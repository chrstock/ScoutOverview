package oni.pepper.scoutoverview.requestmanagement;

import com.android.volley.toolbox.StringRequest;

/**
 * API for sending HTTP requets to urls
 */
public interface HttpRequestService {

    /**
     * Sends Https request to passed url
     *
     * @param url - URL, which will send http request
     *
     * @return answer of HttpRequest
     */
    StringRequest sendGetRequest(String url);
}
