package oni.pepper.scoutoverview.requestmanagement;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

public class HttpRequestServiceImpl implements HttpRequestService {

    private static final String TAG = HttpRequestServiceImpl.class.getName();

    @Override
    public StringRequest sendGetRequest(String url) {

        // Request a string response from the provided URL.
        return new StringRequest(Request.Method.GET, url,
                response -> {
                    // Display the first 500 characters of the response string.
                    Log.i(TAG, response.substring(0, 500));
                }, error -> Log.e(TAG, "Fehler"));
    }

    @Override
    public JsonObjectRequest sendGetRequestJson(String url) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, response.toString());
                    }
                }, error -> {
                    Log.e(TAG, "Fehler");
                });
        return jsonObjectRequest;
    }


}
