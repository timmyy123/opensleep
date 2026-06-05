package oauth.signpost.commonshttp;

import oauth.signpost.AbstractOAuthConsumer;
import oauth.signpost.http.HttpRequest;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.apache.http.client.methods.HttpUriRequest;

/* JADX INFO: loaded from: classes5.dex */
public class CommonsHttpOAuthConsumer extends AbstractOAuthConsumer {
    private static final long serialVersionUID = 1;

    public CommonsHttpOAuthConsumer(String str, String str2) {
        super(str, str2);
    }

    @Override // oauth.signpost.AbstractOAuthConsumer
    public HttpRequest wrap(Object obj) {
        if (obj instanceof org.apache.http.HttpRequest) {
            return new HttpRequestAdapter((HttpUriRequest) obj);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("This consumer expects requests of type ", org.apache.http.HttpRequest.class.getCanonicalName());
        return null;
    }
}
