package gcanadas.com.myplanner.api;

import retrofit2.ProtoConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by gerard on 5/1/17.
 */

public class RestServiceProvider {

    public UserService userService;

    private static RestServiceProvider instance = null;

    protected RestServiceProvider() {
        // Exists only to defeat instantiation.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:5000/api/")
                .addConverterFactory(ProtoConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
    }

    public static RestServiceProvider getInstance() {
        if(instance == null) instance = new RestServiceProvider();
        return instance;
    }

}
