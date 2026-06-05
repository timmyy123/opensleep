package twitter4j.auth;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;
import twitter4j.BASE64Encoder;
import twitter4j.HttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public class BasicAuthorization implements Authorization, Serializable {
    private static final long serialVersionUID = 7420629998989177351L;
    private final String basic = encodeBasicAuthenticationString();
    private final String password;
    private final String userId;

    public BasicAuthorization(String str, String str2) {
        this.userId = str;
        this.password = str2;
    }

    private String encodeBasicAuthenticationString() {
        if (this.userId == null || this.password == null) {
            return null;
        }
        return "Basic " + BASE64Encoder.encode((this.userId + ":" + this.password).getBytes());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BasicAuthorization) {
            return this.basic.equals(((BasicAuthorization) obj).basic);
        }
        return false;
    }

    @Override // twitter4j.auth.Authorization
    public String getAuthorizationHeader(HttpRequest httpRequest) {
        return this.basic;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.basic.hashCode();
    }

    @Override // twitter4j.auth.Authorization
    public boolean isEnabled() {
        return true;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("BasicAuthorization{userId='"), this.userId, "', password='**********''}");
    }
}
