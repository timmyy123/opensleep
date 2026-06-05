package oauth.signpost.commonshttp;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import oauth.signpost.http.HttpRequest;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.methods.HttpUriRequest;

/* JADX INFO: loaded from: classes5.dex */
public class HttpRequestAdapter implements HttpRequest {
    private HttpEntity entity;
    private HttpUriRequest request;

    public HttpRequestAdapter(HttpUriRequest httpUriRequest) {
        this.request = httpUriRequest;
        if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
            this.entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity();
        }
    }

    @Override // oauth.signpost.http.HttpRequest
    public Map<String, String> getAllHeaders() {
        Header[] allHeaders = this.request.getAllHeaders();
        HashMap map = new HashMap();
        for (Header header : allHeaders) {
            map.put(header.getName(), header.getValue());
        }
        return map;
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getContentType() {
        Header contentType;
        HttpEntity httpEntity = this.entity;
        if (httpEntity == null || (contentType = httpEntity.getContentType()) == null) {
            return null;
        }
        return contentType.getValue();
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getHeader(String str) {
        Header firstHeader = this.request.getFirstHeader(str);
        if (firstHeader == null) {
            return null;
        }
        return firstHeader.getValue();
    }

    @Override // oauth.signpost.http.HttpRequest
    public InputStream getMessagePayload() {
        HttpEntity httpEntity = this.entity;
        if (httpEntity == null) {
            return null;
        }
        return httpEntity.getContent();
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getMethod() {
        return this.request.getRequestLine().getMethod();
    }

    @Override // oauth.signpost.http.HttpRequest
    public String getRequestUrl() {
        return this.request.getURI().toString();
    }

    @Override // oauth.signpost.http.HttpRequest
    public void setHeader(String str, String str2) {
        this.request.setHeader(str, str2);
    }

    @Override // oauth.signpost.http.HttpRequest
    public void setRequestUrl(String str) {
        throw new RuntimeException(new UnsupportedOperationException());
    }

    @Override // oauth.signpost.http.HttpRequest
    public Object unwrap() {
        return this.request;
    }
}
