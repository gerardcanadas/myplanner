package gcanadas.com.myplanner.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserDevice {

    @SerializedName("user")
    private User User;
    @SerializedName("devices")
    private List<Device> Devices;

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public List<Device> getDevices() {
        return Devices;
    }

    public void setDevices(List<Device> devices) {
        Devices = devices;
    }
}
