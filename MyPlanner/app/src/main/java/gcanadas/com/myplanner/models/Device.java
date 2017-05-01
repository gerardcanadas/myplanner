package gcanadas.com.myplanner.models;

/**
 * Created by gerard on 5/1/17.
 */

public class Device {

    private int Id;
    private String DeviceId;
    private boolean Active;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}
