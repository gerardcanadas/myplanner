package gcanadas.com.myplanner.api;

import android.content.Context;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.StringEntity;
import gcanadas.com.myplanner.models.UserDevice;

import static gcanadas.com.myplanner.api.RestServiceProvider.*;

/**
 * Created by gerard on 5/1/17.
 */

public class UserService {
    public void insertUserDevice(UserDevice udev) throws JSONException {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(udev);
            StringEntity httpEntity = new StringEntity(json, ContentType.APPLICATION_JSON);

            Looper.prepare();
            Looper looper = Looper.myLooper();
            if (looper == null) Log.w("ASYNC HTTP", "MyLooper is null");

            post(null, "userdevices", httpEntity, new JsonHttpResponseHandler() {
//          post("userdevice", pars, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    if (statusCode == 200) //OK
                        System.out.println("Insert UserDevice OK");
                }
                @Override
                public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
