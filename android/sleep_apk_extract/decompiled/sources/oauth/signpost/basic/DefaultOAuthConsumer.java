package oauth.signpost.basic;

import java.net.HttpURLConnection;
import oauth.signpost.AbstractOAuthConsumer;
import oauth.signpost.http.HttpRequest;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultOAuthConsumer extends AbstractOAuthConsumer {
    private static final long serialVersionUID = 1;

    public DefaultOAuthConsumer(String str, String str2) {
        super(str, str2);
    }

    @Override // oauth.signpost.AbstractOAuthConsumer
    public HttpRequest wrap(Object obj) {
        if (obj instanceof HttpURLConnection) {
            return new HttpURLConnectionRequestAdapter((HttpURLConnection) obj);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("The default consumer expects requests of type java.net.HttpURLConnection");
        return null;
    }
}
