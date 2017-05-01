package gcanadas.com.myplanner.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by gerard on 5/1/17.
 */

public class RestServiceProvider {

    public UserService userService;

    private static RestServiceProvider instance = null;

    protected RestServiceProvider() {
        // Exists only to defeat instantiation.
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:5000/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        userService = retrofit.create(UserService.class);
    }

    public static RestServiceProvider getInstance() {
        if(instance == null) instance = new RestServiceProvider();
        return instance;
    }

}
