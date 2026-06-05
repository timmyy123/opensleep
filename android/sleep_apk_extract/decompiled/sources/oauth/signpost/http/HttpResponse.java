package oauth.signpost.http;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpResponse {
    InputStream getContent();

    String getReasonPhrase();

    int getStatusCode();

    Object unwrap();
}
