package com.google.api.client.extensions.java6.auth.oauth2;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class FilePersistedCredential extends GenericJson {

    @Key("access_token")
    private String accessToken;

    @Key("expiration_time_millis")
    private Long expirationTimeMillis;

    @Key("refresh_token")
    private String refreshToken;

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public FilePersistedCredential clone() {
        return (FilePersistedCredential) super.clone();
    }

    public void load(Credential credential) {
        throw null;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public FilePersistedCredential set(String str, Object obj) {
        return (FilePersistedCredential) super.set(str, obj);
    }

    public void store(Credential credential) {
        throw null;
    }

    public StoredCredential toStoredCredential() {
        return new StoredCredential().setAccessToken(this.accessToken).setRefreshToken(this.refreshToken).setExpirationTimeMilliseconds(this.expirationTimeMillis);
    }
}
