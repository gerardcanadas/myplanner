package gcanadas.com.myplanner.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gerard on 5/1/17.
 */

public class Device {

    @SerializedName("id")
    private int Id;
    @SerializedName("deviceId")
    private String DeviceId;
    @SerializedName("active")
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
