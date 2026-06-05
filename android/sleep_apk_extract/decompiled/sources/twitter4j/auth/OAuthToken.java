package twitter4j.auth;

import java.io.Serializable;
import javax.crypto.spec.SecretKeySpec;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import twitter4j.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
abstract class OAuthToken implements Serializable {
    private static final long serialVersionUID = -7841506492508140600L;
    private String[] responseStr;
    private transient SecretKeySpec secretKeySpec;
    private final String token;
    private final String tokenSecret;

    public OAuthToken(String str) {
        this.responseStr = null;
        this.responseStr = str.split("&");
        this.tokenSecret = getParameter(OAuth.OAUTH_TOKEN_SECRET);
        this.token = getParameter(OAuth.OAUTH_TOKEN);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OAuthToken)) {
            return false;
        }
        OAuthToken oAuthToken = (OAuthToken) obj;
        return this.token.equals(oAuthToken.token) && this.tokenSecret.equals(oAuthToken.tokenSecret);
    }

    public String getParameter(String str) {
        for (String str2 : this.responseStr) {
            if (str2.startsWith(str + '=')) {
                return str2.split("=")[1].trim();
            }
        }
        return null;
    }

    public SecretKeySpec getSecretKeySpec() {
        return this.secretKeySpec;
    }

    public String getToken() {
        return this.token;
    }

    public String getTokenSecret() {
        return this.tokenSecret;
    }

    public int hashCode() {
        return this.tokenSecret.hashCode() + (this.token.hashCode() * 31);
    }

    public void setSecretKeySpec(SecretKeySpec secretKeySpec) {
        this.secretKeySpec = secretKeySpec;
    }

    public String toString() {
        return "OAuthToken{token='" + this.token + "', tokenSecret='" + this.tokenSecret + "', secretKeySpec=" + this.secretKeySpec + '}';
    }

    public OAuthToken(HttpResponse httpResponse) {
        this(httpResponse.asString());
    }

    public OAuthToken(String str, String str2) {
        this.responseStr = null;
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Token can't be null");
            throw null;
        }
        if (str2 != null) {
            this.token = str;
            this.tokenSecret = str2;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2("TokenSecret can't be null");
            throw null;
        }
    }
}
