package twitter4j.auth;

/* JADX INFO: loaded from: classes5.dex */
public interface OAuth2Support {
    OAuth2Token getOAuth2Token();

    void invalidateOAuth2Token();

    void setOAuth2Token(OAuth2Token oAuth2Token);
}
