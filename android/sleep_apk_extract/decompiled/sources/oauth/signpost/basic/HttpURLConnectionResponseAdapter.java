package oauth.signpost.basic;

import java.io.InputStream;
import java.net.HttpURLConnection;
import oauth.signpost.http.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
public class HttpURLConnectionResponseAdapter implements HttpResponse {
    private HttpURLConnection connection;

    public HttpURLConnectionResponseAdapter(HttpURLConnection httpURLConnection) {
        this.connection = httpURLConnection;
    }

    @Override // oauth.signpost.http.HttpResponse
    public InputStream getContent() {
        return this.connection.getInputStream();
    }

    @Override // oauth.signpost.http.HttpResponse
    public String getReasonPhrase() {
        return this.connection.getResponseMessage();
    }

    @Override // oauth.signpost.http.HttpResponse
    public int getStatusCode() {
        return this.connection.getResponseCode();
    }

    @Override // oauth.signpost.http.HttpResponse
    public Object unwrap() {
        return this.connection;
    }
}
