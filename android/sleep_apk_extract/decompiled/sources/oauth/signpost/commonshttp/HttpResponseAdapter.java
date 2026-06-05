package oauth.signpost.commonshttp;

import java.io.InputStream;
import oauth.signpost.http.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
public class HttpResponseAdapter implements HttpResponse {
    private org.apache.http.HttpResponse response;

    public HttpResponseAdapter(org.apache.http.HttpResponse httpResponse) {
        this.response = httpResponse;
    }

    @Override // oauth.signpost.http.HttpResponse
    public InputStream getContent() {
        return this.response.getEntity().getContent();
    }

    @Override // oauth.signpost.http.HttpResponse
    public String getReasonPhrase() {
        return this.response.getStatusLine().getReasonPhrase();
    }

    @Override // oauth.signpost.http.HttpResponse
    public int getStatusCode() {
        return this.response.getStatusLine().getStatusCode();
    }

    @Override // oauth.signpost.http.HttpResponse
    public Object unwrap() {
        return this.response;
    }
}
