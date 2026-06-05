package oauth.signpost.http;

import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpRequest {
    Map<String, String> getAllHeaders();

    String getContentType();

    String getHeader(String str);

    InputStream getMessagePayload();

    String getMethod();

    String getRequestUrl();

    void setHeader(String str, String str2);

    void setRequestUrl(String str);

    Object unwrap();
}
