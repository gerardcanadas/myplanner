package pushnotifications;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.util.ArrayList;
import java.util.List;

import gcanadas.com.myplanner.api.RestServiceProvider;
import gcanadas.com.myplanner.models.Device;
import gcanadas.com.myplanner.models.User;
import gcanadas.com.myplanner.models.UserDevice;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static android.content.ContentValues.TAG;

/**
 * Created by gerard on 5/1/17.
 */

public class MyPlanner_FirebaseInstanceIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String username = prefs.getString("username", "");
        sendRegistrationToServer(refreshedToken, username);
    }

    public void sendRegistrationToServer(String refreshedToken, String username) {
        User user = new User();
        user.setUsername(username);
        List<Device> devicesList = new ArrayList<>();
        Device currentDevice = new Device();
        currentDevice.setDeviceId(refreshedToken);
        devicesList.add(currentDevice);
        UserDevice udev = new UserDevice();
        udev.setUser(user);
        udev.setDevices(devicesList);
        RestServiceProvider.getInstance().userService.insertUserDevice(udev);
    }
}
