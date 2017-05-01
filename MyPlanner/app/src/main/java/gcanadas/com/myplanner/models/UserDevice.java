package gcanadas.com.myplanner.models;

import java.util.List;

public class UserDevice {

    private User User;
    private List<Device> Devices;

    public gcanadas.com.myplanner.models.User getUser() {
        return User;
    }

    public void setUser(gcanadas.com.myplanner.models.User user) {
        User = user;
    }

    public List<Device> getDevices() {
        return Devices;
    }

    public void setDevices(List<Device> devices) {
        Devices = devices;
    }
}
