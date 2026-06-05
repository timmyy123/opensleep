package twitter4j.auth;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import oauth.signpost.OAuth;
import twitter4j.HttpResponse;
import twitter4j.JSONException;
import twitter4j.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class OAuth2Token implements Serializable {
    private static final long serialVersionUID = -8985359441959903216L;
    private String accessToken;
    private String tokenType;

    public OAuth2Token(HttpResponse httpResponse) {
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        this.tokenType = getRawString("token_type", jSONObjectAsJSONObject);
        try {
            this.accessToken = URLDecoder.decode(getRawString("access_token", jSONObjectAsJSONObject), OAuth.ENCODING);
        } catch (UnsupportedEncodingException unused) {
        }
    }

    private static String getRawString(String str, JSONObject jSONObject) {
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OAuth2Token)) {
            return false;
        }
        OAuth2Token oAuth2Token = (OAuth2Token) obj;
        String str = this.tokenType;
        String str2 = oAuth2Token.tokenType;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.accessToken;
        String str4 = oAuth2Token.accessToken;
        if (str3 != null) {
            if (str3.equals(str4)) {
                return true;
            }
        } else if (str4 == null) {
            return true;
        }
        return false;
    }

    public String generateAuthorizationHeader() {
        String strEncode;
        try {
            strEncode = URLEncoder.encode(this.accessToken, OAuth.ENCODING);
        } catch (UnsupportedEncodingException unused) {
            strEncode = "";
        }
        return FileInsert$$ExternalSyntheticOutline0.m("Bearer ", strEncode);
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public int hashCode() {
        String str = this.tokenType;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.accessToken;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OAuth2Token{tokenType='");
        sb.append(this.tokenType);
        sb.append("', accessToken='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.accessToken, "'}");
    }

    public OAuth2Token(String str, String str2) {
        this.tokenType = str;
        this.accessToken = str2;
    }
}
