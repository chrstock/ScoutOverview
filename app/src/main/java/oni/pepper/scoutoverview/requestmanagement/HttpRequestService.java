package oni.pepper.scoutoverview.requestmanagement;

import android.content.Context;

/**
 * API for sending HTTP requets to urls
 */
public interface HttpRequestService {

    /**
     * Sends Https request to passed url
     *
     * @param url - URL, which will send http request
     * @param context - which is bound to http request
     *
     * @return answer of HttpRequest
     */
    String sendGetRequest(String url, Context context);
}
