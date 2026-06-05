package com.spotify.protocol.client;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionDetails {
    private final String mAuthId;
    private final String[] mAuthMethods;
    private final String mCategory;
    private final Map<String, String> mExtras;
    private final String mId;
    private final int mImageHeight;
    private final int mImageWidth;
    private final String mModel;
    private final String mName;
    private final List<String> mRequiredFeatures;
    private final int mThumbnailImageHeight;
    private final int mThumbnailImageWidth;
    private final String mVersion;

    public static class Builder {
        private String mAuthId;
        private String[] mAuthMethods;
        private String mCategory;
        private Map<String, String> mExtras;
        private final String mId;
        private int mImageSize;
        private String mModel;
        private String mName;
        private List<String> mRequiredFeatures;
        private int mThumbnailSize;
        private String mVersion;

        public Builder(String str) {
            this.mId = str;
        }

        public ConnectionDetails build() {
            String str = this.mId;
            String str2 = this.mName;
            String str3 = this.mModel;
            String str4 = this.mCategory;
            String str5 = this.mVersion;
            int i = this.mImageSize;
            int i2 = this.mThumbnailSize;
            return new ConnectionDetails(str, str2, str3, str4, str5, i, i, i2, i2, this.mAuthMethods, this.mAuthId, this.mExtras, this.mRequiredFeatures);
        }

        public Builder setAuthId(String str) {
            this.mAuthId = str;
            return this;
        }

        public Builder setAuthMethods(String[] strArr) {
            this.mAuthMethods = strArr;
            return this;
        }

        public Builder setCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public Builder setExtras(Map<String, String> map) {
            this.mExtras = map;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setRequiredFeatures(List<String> list) {
            this.mRequiredFeatures = list;
            return this;
        }

        public Builder setVersion(String str) {
            this.mVersion = str;
            return this;
        }
    }

    private ConnectionDetails(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, String[] strArr, String str6, Map<String, String> map, List<String> list) {
        this.mId = str;
        this.mName = str2;
        this.mModel = str3;
        this.mCategory = str4;
        this.mVersion = str5;
        this.mImageWidth = i;
        this.mImageHeight = i2;
        this.mThumbnailImageWidth = i3;
        this.mThumbnailImageHeight = i4;
        this.mAuthMethods = strArr;
        this.mAuthId = str6;
        this.mExtras = map;
        this.mRequiredFeatures = list;
    }

    public String getAuthId() {
        return this.mAuthId;
    }

    public String[] getAuthMethods() {
        return this.mAuthMethods;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public Map<String, String> getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.mId;
    }

    public int getImageHeight() {
        return this.mImageHeight;
    }

    public int getImageWidth() {
        return this.mImageWidth;
    }

    public String getModel() {
        return this.mModel;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getRequiredFeatures() {
        return this.mRequiredFeatures;
    }

    public int getThumbnailImageHeight() {
        return this.mThumbnailImageHeight;
    }

    public String getVersion() {
        return this.mVersion;
    }
}
