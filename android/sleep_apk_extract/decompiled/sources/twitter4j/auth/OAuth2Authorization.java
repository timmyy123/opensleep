package twitter4j.auth;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import twitter4j.BASE64Encoder;
import twitter4j.HttpClient;
import twitter4j.HttpClientFactory;
import twitter4j.HttpParameter;
import twitter4j.HttpRequest;
import twitter4j.HttpResponse;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
public class OAuth2Authorization implements Authorization, Serializable, OAuth2Support {
    private static final long serialVersionUID = -2895232598422218647L;
    private final Configuration conf;
    private String consumerKey;
    private String consumerSecret;
    private final HttpClient http;
    private OAuth2Token token;

    public OAuth2Authorization(Configuration configuration) {
        this.conf = configuration;
        setOAuthConsumer(configuration.getOAuthConsumerKey(), configuration.getOAuthConsumerSecret());
        this.http = HttpClientFactory.getInstance(configuration.getHttpClientConfiguration());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OAuth2Authorization)) {
            return false;
        }
        OAuth2Authorization oAuth2Authorization = (OAuth2Authorization) obj;
        String str = this.consumerKey;
        String str2 = oAuth2Authorization.consumerKey;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.consumerSecret;
        String str4 = oAuth2Authorization.consumerSecret;
        if (str3 == null ? str4 != null : !str3.equals(str4)) {
            return false;
        }
        OAuth2Token oAuth2Token = this.token;
        OAuth2Token oAuth2Token2 = oAuth2Authorization.token;
        if (oAuth2Token != null) {
            if (oAuth2Token.equals(oAuth2Token2)) {
                return true;
            }
        } else if (oAuth2Token2 == null) {
            return true;
        }
        return false;
    }

    @Override // twitter4j.auth.Authorization
    public String getAuthorizationHeader(HttpRequest httpRequest) {
        String str;
        OAuth2Token oAuth2Token = this.token;
        if (oAuth2Token != null) {
            return oAuth2Token.generateAuthorizationHeader();
        }
        try {
            str = URLEncoder.encode(this.consumerKey, OAuth.ENCODING) + ":" + URLEncoder.encode(this.consumerSecret, OAuth.ENCODING);
        } catch (UnsupportedEncodingException unused) {
            str = "";
        }
        return "Basic " + BASE64Encoder.encode(str.getBytes());
    }

    @Override // twitter4j.auth.OAuth2Support
    public OAuth2Token getOAuth2Token() throws TwitterException {
        if (this.token != null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("OAuth 2 Bearer Token is already available.");
            return null;
        }
        HttpParameter[] httpParameterArr = new HttpParameter[this.conf.getOAuth2Scope() == null ? 1 : 2];
        httpParameterArr[0] = new HttpParameter("grant_type", "client_credentials");
        if (this.conf.getOAuth2Scope() != null) {
            httpParameterArr[1] = new HttpParameter("scope", this.conf.getOAuth2Scope());
        }
        HttpResponse httpResponsePost = this.http.post(this.conf.getOAuth2TokenURL(), httpParameterArr, this, null);
        if (httpResponsePost.getStatusCode() != 200) {
            throw new TwitterException("Obtaining OAuth 2 Bearer Token failed.", httpResponsePost);
        }
        OAuth2Token oAuth2Token = new OAuth2Token(httpResponsePost);
        this.token = oAuth2Token;
        return oAuth2Token;
    }

    public int hashCode() {
        String str = this.consumerKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.consumerSecret;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        OAuth2Token oAuth2Token = this.token;
        return iHashCode2 + (oAuth2Token != null ? oAuth2Token.hashCode() : 0);
    }

    @Override // twitter4j.auth.OAuth2Support
    public void invalidateOAuth2Token() {
        OAuth2Token oAuth2Token = this.token;
        if (oAuth2Token == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("OAuth 2 Bearer Token is not available.");
            return;
        }
        HttpParameter[] httpParameterArr = {new HttpParameter("access_token", oAuth2Token.getAccessToken())};
        OAuth2Token oAuth2Token2 = this.token;
        try {
            this.token = null;
            HttpResponse httpResponsePost = this.http.post(this.conf.getOAuth2InvalidateTokenURL(), httpParameterArr, this, null);
            if (httpResponsePost.getStatusCode() == 200) {
            } else {
                throw new TwitterException("Invalidating OAuth 2 Bearer Token failed.", httpResponsePost);
            }
        } catch (Throwable th) {
            this.token = oAuth2Token2;
            throw th;
        }
    }

    @Override // twitter4j.auth.Authorization
    public boolean isEnabled() {
        return this.token != null;
    }

    @Override // twitter4j.auth.OAuth2Support
    public void setOAuth2Token(OAuth2Token oAuth2Token) {
        this.token = oAuth2Token;
    }

    public void setOAuthConsumer(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.consumerKey = str;
        if (str2 == null) {
            str2 = "";
        }
        this.consumerSecret = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OAuth2Authorization{consumerKey='");
        sb.append(this.consumerKey);
        sb.append("', consumerSecret='******************************************', token=");
        OAuth2Token oAuth2Token = this.token;
        return FileInsert$$ExternalSyntheticOutline0.m(sb, oAuth2Token == null ? "null" : oAuth2Token.toString(), '}');
    }
}
