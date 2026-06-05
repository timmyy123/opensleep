package oauth.signpost.basic;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oauth.signpost.http.HttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public class HttpURLConnectionRequestAdapter implements HttpRequest {
    protected HttpURLConnection connection;

    public HttpURLConnectionRequestAdapter(HttpURLConnection httpURLConnection) {
        this.connection = httpURLConnection;
    }

    @Override // oauth.signpost.http.HttpRequest
    public Map<String, String> getAllHeaders() {
        Map<String, List<String>> requestProperties = this.connection.getRequestProperties();
        HashMap map = new HashMap(requestProperties.size());
        for (String str : requestProperties.keySet()) {
            List<String> list = requestProperties.get(str);
            if (!list.isEmpty()) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getContentType() {
        return this.connection.getRequestProperty("Content-Type");
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getHeader(String str) {
        return this.connection.getRequestProperty(str);
    }

    @Override // oauth.signpost.http.HttpRequest
    public InputStream getMessagePayload() {
        return null;
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getMethod() {
        return this.connection.getRequestMethod();
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getRequestUrl() {
        return this.connection.getURL().toExternalForm();
    }

    @Override // oauth.signpost.http.HttpRequest
    public void setHeader(String str, String str2) {
        this.connection.setRequestProperty(str, str2);
    }

    @Override // oauth.signpost.http.HttpRequest
    public void setRequestUrl(String str) {
    }

    @Override // oauth.signpost.http.HttpRequest
    public HttpURLConnection unwrap() {
        return this.connection;
    }
}
