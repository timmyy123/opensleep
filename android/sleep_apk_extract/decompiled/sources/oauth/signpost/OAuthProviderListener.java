package oauth.signpost;

import oauth.signpost.http.HttpRequest;
import oauth.signpost.http.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
public interface OAuthProviderListener {
    boolean onResponseReceived(HttpRequest httpRequest, HttpResponse httpResponse);

    void prepareRequest(HttpRequest httpRequest);

    void prepareSubmission(HttpRequest httpRequest);
}
