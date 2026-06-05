package oauth.signpost.basic;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import oauth.signpost.http.HttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public class UrlStringRequestAdapter implements HttpRequest {
    private String url;

    public UrlStringRequestAdapter(String str) {
        this.url = str;
    }

    @Override // oauth.signpost.http.HttpRequest
    public Map<String, String> getAllHeaders() {
        return Collections.EMPTY_MAP;
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getContentType() {
        return null;
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getHeader(String str) {
        return null;
    }

    @Override // oauth.signpost.http.HttpRequest
    public InputStream getMessagePayload() {
        return null;
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getMethod() {
        return "GET";
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getRequestUrl() {
        return this.url;
    }

    @Override // oauth.signpost.http.HttpRequest
    public void setHeader(String str, String str2) {
    }

    @Override // oauth.signpost.http.HttpRequest
    public void setRequestUrl(String str) {
        this.url = str;
    }

    @Override // oauth.signpost.http.HttpRequest
    public Object unwrap() {
        return this.url;
    }
}
