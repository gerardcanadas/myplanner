package gcanadas.com.myplanner.api;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.HttpEntity;

/**
 * Created by gerard on 5/1/17.
 */

public class RestServiceProvider {

    public UserService userService;

    private static RestServiceProvider instance = null;

    protected RestServiceProvider() {
        // Exists only to defeat instantiation.
    }

    public static RestServiceProvider getInstance() {
        if(instance == null) instance = new RestServiceProvider();
        return instance;
    }

    private static final String BASE_URL = "http://192.168.204.106:8081/api/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(Context context, String url, HttpEntity httpEntity, AsyncHttpResponseHandler responseHandler) {
        client.post(context, getAbsoluteUrl(url), httpEntity, "application/json", responseHandler);
    }

    public static void getByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(url, params, responseHandler);
    }

    public static void postByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(url, params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

}
