package twitter4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes5.dex */
public class HttpResponseImpl extends HttpResponse {
    private HttpURLConnection con;

    public HttpResponseImpl(HttpURLConnection httpURLConnection, HttpClientConfiguration httpClientConfiguration) throws IOException {
        super(httpClientConfiguration);
        this.con = httpURLConnection;
        try {
            this.statusCode = httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (!"Received authentication challenge is null".equals(e.getMessage())) {
                throw e;
            }
            this.statusCode = httpURLConnection.getResponseCode();
        }
        InputStream errorStream = httpURLConnection.getErrorStream();
        this.is = errorStream;
        if (errorStream == null) {
            this.is = httpURLConnection.getInputStream();
        }
        if (this.is == null || !"gzip".equals(httpURLConnection.getContentEncoding())) {
            return;
        }
        this.is = new StreamingGZIPInputStream(this.is);
    }

    @Override // twitter4j.HttpResponse
    public void disconnect() {
        this.con.disconnect();
    }

    @Override // twitter4j.HttpResponse
    public String getResponseHeader(String str) {
        return this.con.getHeaderField(str);
    }
}
