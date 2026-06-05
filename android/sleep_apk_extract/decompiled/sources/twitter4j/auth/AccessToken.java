package twitter4j.auth;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;
import twitter4j.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
public class AccessToken extends OAuthToken implements Serializable {
    private static final long serialVersionUID = 2470022129505774772L;
    private String screenName;
    private long userId;

    public AccessToken(String str) {
        super(str);
        this.userId = -1L;
        this.screenName = getParameter("screen_name");
        String parameter = getParameter("user_id");
        if (parameter != null) {
            this.userId = Long.parseLong(parameter);
        }
    }

    @Override // twitter4j.auth.OAuthToken
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        if (this.userId != accessToken.userId) {
            return false;
        }
        String str = this.screenName;
        String str2 = accessToken.screenName;
        return str == null ? str2 == null : str.equals(str2);
    }

    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ String getParameter(String str) {
        return super.getParameter(str);
    }

    public String getScreenName() {
        return this.screenName;
    }

    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ String getToken() {
        return super.getToken();
    }

    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ String getTokenSecret() {
        return super.getTokenSecret();
    }

    public long getUserId() {
        return this.userId;
    }

    @Override // twitter4j.auth.OAuthToken
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.screenName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        long j = this.userId;
        return iHashCode2 + ((int) (j ^ (j >>> 32)));
    }

    @Override // twitter4j.auth.OAuthToken
    public String toString() {
        StringBuilder sb = new StringBuilder("AccessToken{screenName='");
        sb.append(this.screenName);
        sb.append("', userId=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.userId, '}');
    }

    public AccessToken(HttpResponse httpResponse) {
        this(httpResponse.asString());
    }

    public AccessToken(String str, String str2) {
        super(str, str2);
        this.userId = -1L;
        int iIndexOf = str.indexOf("-");
        if (iIndexOf != -1) {
            try {
                this.userId = Long.parseLong(str.substring(0, iIndexOf));
            } catch (NumberFormatException unused) {
            }
        }
    }
}
