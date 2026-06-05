package twitter4j;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import twitter4j.auth.Authorization;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HttpClientBase implements HttpClient, Serializable {
    private static final Logger logger = Logger.getLogger(HttpClientBase.class);
    private static final long serialVersionUID = -8016974810651763053L;
    protected final HttpClientConfiguration CONF;
    private final Map<String, String> requestHeaders;

    public HttpClientBase(HttpClientConfiguration httpClientConfiguration) {
        this.CONF = httpClientConfiguration;
        HashMap map = new HashMap();
        this.requestHeaders = map;
        map.put("X-Twitter-Client-Version", Version.getVersion());
        map.put("X-Twitter-Client-URL", "http://twitter4j.org/en/twitter4j-" + Version.getVersion() + ".xml");
        map.put("X-Twitter-Client", "Twitter4J");
        map.put("User-Agent", "twitter4j http://twitter4j.org/ /" + Version.getVersion());
        if (httpClientConfiguration.isGZIPEnabled()) {
            map.put("Accept-Encoding", "gzip");
        }
    }

    public void addDefaultRequestHeader(String str, String str2) {
        this.requestHeaders.put(str, str2);
    }

    @Override // twitter4j.HttpClient
    public HttpResponse delete(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) {
        return request(new HttpRequest(RequestMethod.DELETE, str, httpParameterArr, authorization, this.requestHeaders), httpResponseListener);
    }

    @Override // twitter4j.HttpClient
    public HttpResponse get(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) {
        return request(new HttpRequest(RequestMethod.GET, str, httpParameterArr, authorization, this.requestHeaders), httpResponseListener);
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public abstract HttpResponse handleRequest(HttpRequest httpRequest);

    public HttpResponse head(String str) {
        return request(new HttpRequest(RequestMethod.HEAD, str, null, null, this.requestHeaders));
    }

    public boolean isProxyConfigured() {
        return (this.CONF.getHttpProxyHost() == null || this.CONF.getHttpProxyHost().equals("")) ? false : true;
    }

    @Override // twitter4j.HttpClient
    public HttpResponse post(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) {
        return request(new HttpRequest(RequestMethod.POST, str, httpParameterArr, authorization, this.requestHeaders), httpResponseListener);
    }

    public HttpResponse put(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) {
        return request(new HttpRequest(RequestMethod.PUT, str, httpParameterArr, authorization, this.requestHeaders), httpResponseListener);
    }

    public final HttpResponse request(HttpRequest httpRequest, HttpResponseListener httpResponseListener) throws TwitterException {
        try {
            HttpResponse httpResponseHandleRequest = handleRequest(httpRequest);
            if (httpResponseListener == null) {
                return httpResponseHandleRequest;
            }
            httpResponseListener.httpResponseReceived(new HttpResponseEvent(httpRequest, httpResponseHandleRequest, null));
            return httpResponseHandleRequest;
        } catch (TwitterException e) {
            if (httpResponseListener != null) {
                httpResponseListener.httpResponseReceived(new HttpResponseEvent(httpRequest, null, e));
            }
            throw e;
        }
    }

    public void write(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        logger.debug(str);
    }

    public HttpResponse delete(String str) {
        return request(new HttpRequest(RequestMethod.DELETE, str, null, null, this.requestHeaders));
    }

    public HttpResponse post(String str) {
        return request(new HttpRequest(RequestMethod.POST, str, null, null, this.requestHeaders));
    }

    public HttpResponse put(String str) {
        return request(new HttpRequest(RequestMethod.PUT, str, null, null, this.requestHeaders));
    }

    public final HttpResponse request(HttpRequest httpRequest) {
        return handleRequest(httpRequest);
    }
}
