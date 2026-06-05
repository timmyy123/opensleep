package twitter4j.auth;

import java.io.Serializable;
import twitter4j.HttpResponse;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

/* JADX INFO: loaded from: classes5.dex */
public final class RequestToken extends OAuthToken implements Serializable {
    private static final long serialVersionUID = -8806439091674811734L;
    private final Configuration conf;

    /* JADX INFO: renamed from: oauth, reason: collision with root package name */
    private OAuthSupport f138oauth;

    public RequestToken(HttpResponse httpResponse, OAuthSupport oAuthSupport) {
        super(httpResponse);
        this.conf = ConfigurationContext.getInstance();
        this.f138oauth = oAuthSupport;
    }

    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getAuthenticationURL() {
        return this.conf.getOAuthAuthenticationURL() + "?oauth_token=" + getToken();
    }

    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ String getParameter(String str) {
        return super.getParameter(str);
    }

    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ String getToken() {
        return super.getToken();
    }

    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ String getTokenSecret() {
        return super.getTokenSecret();
    }

    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public RequestToken(String str, String str2) {
        super(str, str2);
        this.conf = ConfigurationContext.getInstance();
    }
}
