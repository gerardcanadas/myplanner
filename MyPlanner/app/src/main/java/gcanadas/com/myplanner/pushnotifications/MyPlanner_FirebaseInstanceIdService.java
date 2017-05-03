package gcanadas.com.myplanner.pushnotifications;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import gcanadas.com.myplanner.api.UserService;
import gcanadas.com.myplanner.models.Device;
import gcanadas.com.myplanner.models.User;
import gcanadas.com.myplanner.models.UserDevice;

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
        try {
            if (username != "") {
                User user = new User();
                user.setUsername(username);
                List<Device> devicesList = new ArrayList<>();
                Device currentDevice = new Device();
                currentDevice.setDeviceId(refreshedToken);
                devicesList.add(currentDevice);
                UserDevice udev = new UserDevice();
                udev.setUser(user);
                udev.setDevices(devicesList);
                UserRepositoryTask userRepositoryTask = new UserRepositoryTask();
                userRepositoryTask.execute(udev);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    class UserRepositoryTask extends AsyncTask<UserDevice, Void, Boolean> {

        @Override
        protected Boolean doInBackground(UserDevice... params) {
            UserService userService = new UserService();
            try {
                userService.insertUserDevice(params[0]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
