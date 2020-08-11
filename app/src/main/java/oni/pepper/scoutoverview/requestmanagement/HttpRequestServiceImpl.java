package oni.pepper.scoutoverview.requestmanagement;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

public class HttpRequestServiceImpl implements HttpRequestService {

    private static final String TAG = HttpRequestServiceImpl.class.getName();

    @Override
    public StringRequest sendGetRequest(String url) {

        // Request a string response from the provided URL.
        return new StringRequest(Request.Method.GET, url,
                response -> {
                    // Display the first 500 characters of the response string.
                    Log.e(TAG, response.substring(0, 500));
                }, error -> Log.e(TAG, "Fehler"));
    }
}
