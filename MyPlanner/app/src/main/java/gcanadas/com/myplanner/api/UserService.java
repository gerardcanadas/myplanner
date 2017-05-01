package gcanadas.com.myplanner.api;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import gcanadas.com.myplanner.models.User;
import gcanadas.com.myplanner.models.UserDevice;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by gerard on 5/1/17.
 */

public interface UserService {

    @GET("users/{user}/repos")
    Call<UserDevice> listUserDevices(@Path("username") String username);
}
