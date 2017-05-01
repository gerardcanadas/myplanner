package gcanadas.com.myplanner.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gerard on 5/1/17.
 */

public class User {
    @SerializedName("id")
    private int Id;

    @SerializedName("username")
    private String Username;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
