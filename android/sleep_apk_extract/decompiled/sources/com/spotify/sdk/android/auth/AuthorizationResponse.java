package com.spotify.sdk.android.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessToken;
import com.facebook.internal.ServerProtocol;

/* JADX INFO: loaded from: classes4.dex */
public class AuthorizationResponse implements Parcelable {
    public static final Parcelable.Creator<AuthorizationResponse> CREATOR = new Parcelable.Creator<AuthorizationResponse>() { // from class: com.spotify.sdk.android.auth.AuthorizationResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthorizationResponse createFromParcel(Parcel parcel) {
            return new AuthorizationResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthorizationResponse[] newArray(int i) {
            return new AuthorizationResponse[i];
        }
    };
    private final String mAccessToken;
    private final String mCode;
    private final String mError;
    private final int mExpiresIn;
    private final String mState;
    private final Type mType;

    public static class Builder {
        private String mAccessToken;
        private String mCode;
        private String mError;
        private int mExpiresIn;
        private String mState;
        private Type mType;

        public AuthorizationResponse build() {
            return new AuthorizationResponse(this.mType, this.mCode, this.mAccessToken, this.mState, this.mError, this.mExpiresIn);
        }

        public Builder setAccessToken(String str) {
            this.mAccessToken = str;
            return this;
        }

        public Builder setCode(String str) {
            this.mCode = str;
            return this;
        }

        public Builder setError(String str) {
            this.mError = str;
            return this;
        }

        public Builder setExpiresIn(int i) {
            this.mExpiresIn = i;
            return this;
        }

        public Builder setState(String str) {
            this.mState = str;
            return this;
        }

        public Builder setType(Type type) {
            this.mType = type;
            return this;
        }
    }

    public enum Type {
        CODE("code"),
        TOKEN("token"),
        ERROR("error"),
        EMPTY("empty"),
        UNKNOWN("unknown");

        private final String mType;

        Type(String str) {
            this.mType = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mType;
        }
    }

    public AuthorizationResponse(Parcel parcel) {
        this.mExpiresIn = parcel.readInt();
        this.mError = parcel.readString();
        this.mState = parcel.readString();
        this.mAccessToken = parcel.readString();
        this.mCode = parcel.readString();
        this.mType = Type.values()[parcel.readInt()];
    }

    public static AuthorizationResponse fromUri(Uri uri) {
        Builder builder = new Builder();
        if (uri == null) {
            builder.setType(Type.EMPTY);
            return builder.build();
        }
        String queryParameter = uri.getQueryParameter("error");
        if (queryParameter != null) {
            String queryParameter2 = uri.getQueryParameter(ServerProtocol.DIALOG_PARAM_STATE);
            builder.setError(queryParameter);
            builder.setState(queryParameter2);
            builder.setType(Type.ERROR);
            return builder.build();
        }
        String queryParameter3 = uri.getQueryParameter("code");
        if (queryParameter3 != null) {
            String queryParameter4 = uri.getQueryParameter(ServerProtocol.DIALOG_PARAM_STATE);
            builder.setCode(queryParameter3);
            builder.setState(queryParameter4);
            builder.setType(Type.CODE);
            return builder.build();
        }
        String encodedFragment = uri.getEncodedFragment();
        if (encodedFragment == null || encodedFragment.length() <= 0) {
            builder.setType(Type.UNKNOWN);
            return builder.build();
        }
        String strDecode = null;
        String strDecode2 = null;
        String strDecode3 = null;
        for (String str : encodedFragment.split("&")) {
            String[] strArrSplit = str.split("=");
            if (strArrSplit.length == 2) {
                if (strArrSplit[0].startsWith("access_token")) {
                    strDecode = Uri.decode(strArrSplit[1]);
                }
                if (strArrSplit[0].startsWith(ServerProtocol.DIALOG_PARAM_STATE)) {
                    strDecode2 = Uri.decode(strArrSplit[1]);
                }
                if (strArrSplit[0].startsWith(AccessToken.EXPIRES_IN_KEY)) {
                    strDecode3 = Uri.decode(strArrSplit[1]);
                }
            }
        }
        builder.setAccessToken(strDecode);
        builder.setState(strDecode2);
        if (strDecode3 != null) {
            try {
                builder.setExpiresIn(Integer.parseInt(strDecode3));
            } catch (NumberFormatException unused) {
            }
        }
        builder.setType(Type.TOKEN);
        return builder.build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public String getError() {
        return this.mError;
    }

    public Type getType() {
        return this.mType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mExpiresIn);
        parcel.writeString(this.mError);
        parcel.writeString(this.mState);
        parcel.writeString(this.mAccessToken);
        parcel.writeString(this.mCode);
        parcel.writeInt(this.mType.ordinal());
    }

    private AuthorizationResponse(Type type, String str, String str2, String str3, String str4, int i) {
        this.mType = type == null ? Type.UNKNOWN : type;
        this.mCode = str;
        this.mAccessToken = str2;
        this.mState = str3;
        this.mError = str4;
        this.mExpiresIn = i;
    }
}
