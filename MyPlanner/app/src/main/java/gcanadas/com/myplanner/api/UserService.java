package gcanadas.com.myplanner.api;

import java.util.List;

import gcanadas.com.myplanner.models.Device;
import gcanadas.com.myplanner.models.User;
import gcanadas.com.myplanner.models.UserDevice;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by gerard on 5/1/17.
 */

public interface UserService {

    @GET("userdevices/{username}")
    Call<UserDevice> listUserDevices(@Path("username") String username);

    @POST("userdevices")
    Call<ResponseBody> insertUserDevice(@Body UserDevice userDevice);

}
