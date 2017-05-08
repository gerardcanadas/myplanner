package gcanadas.com.myplanner.services;

import android.content.Context;

/**
 * Created by gerard on 5/6/17.
 */

public class GlobalService {
    private static GlobalService instance;
    public static GlobalService getInstance() {
        if (instance == null)
            instance = new GlobalService();
        return instance;
    }

    private GlobalService() {

    }

    public Context getApplicationContext() {
        return ApplicationContext;
    }

    public void setApplicationContext(Context applicationContext) {
        ApplicationContext = applicationContext;
    }

    public Context ApplicationContext;
}
