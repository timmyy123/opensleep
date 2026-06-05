package twitter4j.auth;

/* JADX INFO: loaded from: classes5.dex */
public interface OAuthSupport {
    AccessToken getOAuthAccessToken();

    AccessToken getOAuthAccessToken(String str);

    AccessToken getOAuthAccessToken(String str, String str2);

    AccessToken getOAuthAccessToken(RequestToken requestToken);

    AccessToken getOAuthAccessToken(RequestToken requestToken, String str);

    RequestToken getOAuthRequestToken();

    RequestToken getOAuthRequestToken(String str);

    RequestToken getOAuthRequestToken(String str, String str2);

    RequestToken getOAuthRequestToken(String str, String str2, String str3);

    void setOAuthAccessToken(AccessToken accessToken);

    void setOAuthConsumer(String str, String str2);
}
