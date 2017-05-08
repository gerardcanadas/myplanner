package gcanadas.com.myplanner.services;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import gcanadas.com.myplanner.activities.MainActivity;

/**
 * Created by gerard on 5/6/17.
 */

public class UserStorageService {
    private static UserStorageService instance;
    public static UserStorageService getInstance() {
        if (instance == null)
            instance = new UserStorageService();
        return instance;
    }

    private static SharedPreferences userPreferences;
    private static Gson gson;

    private UserStorageService() {
        userPreferences = PreferenceManager.getDefaultSharedPreferences(GlobalService.getInstance().getApplicationContext());
        gson = new Gson();
    }

    public static <T> Boolean Set(String key, T item) {
        String serializedItem = gson.toJson(item);
        userPreferences.edit().putString(key, serializedItem).apply();
        return true;
    }

    public static <T> T Get(String key) {
        T result = null;
        Type listType = new TypeToken<T>(){}.getType();
        String serializedItem = userPreferences.getString(key, null);
        if (serializedItem != null) {
            result = gson.fromJson(serializedItem, listType);
        }
        return result;
    }
}
