package com.spotify.android.appremote.api;

import com.spotify.protocol.client.RequiredFeatures;
import com.spotify.protocol.mappers.JsonMapper;
import com.spotify.protocol.mappers.gson.GsonMapper;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ConnectionParams {
    private final AuthMethod mAuthMethod;
    private final String mClientId;
    private final JsonMapper mJsonMapper;
    private final String mRedirectUri;
    private final List<String> mRequiredFeatures;
    private final boolean mShowAuthView;

    public enum AuthMethod {
        APP_ID,
        NONE
    }

    public static class Builder {
        private AuthMethod mAuthMethod;
        private final String mClientId;
        private JsonMapper mJsonMapper;
        private String mRedirectUri;
        private List<String> mRequiredFeatures;
        private boolean mShowAuthView;

        public Builder(String str) {
            this.mClientId = str;
        }

        public ConnectionParams build() {
            return new ConnectionParams(this.mClientId, this.mAuthMethod, this.mRedirectUri, this.mShowAuthView, this.mRequiredFeatures, this.mJsonMapper);
        }

        public Builder setRedirectUri(String str) {
            this.mRedirectUri = str;
            return this;
        }

        public Builder showAuthView(boolean z) {
            this.mShowAuthView = z;
            return this;
        }
    }

    private ConnectionParams(String str, AuthMethod authMethod, String str2, boolean z, List<String> list, JsonMapper jsonMapper) {
        this.mClientId = str;
        this.mAuthMethod = authMethod == null ? AuthMethod.APP_ID : authMethod;
        this.mShowAuthView = z;
        this.mRedirectUri = str2;
        this.mRequiredFeatures = list == null ? RequiredFeatures.FEATURES : list;
        this.mJsonMapper = jsonMapper == null ? GsonMapper.create() : jsonMapper;
    }

    public AuthMethod getAuthMethod() {
        return this.mAuthMethod;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public JsonMapper getJsonMapper() {
        return this.mJsonMapper;
    }

    public String getRedirectUri() {
        return this.mRedirectUri;
    }

    public List<String> getRequiredFeatures() {
        return this.mRequiredFeatures;
    }

    public boolean shouldShowAuthView() {
        return this.mShowAuthView;
    }
}
