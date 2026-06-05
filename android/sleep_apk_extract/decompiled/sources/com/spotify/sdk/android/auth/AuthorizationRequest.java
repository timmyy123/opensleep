package com.spotify.sdk.android.auth;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.facebook.internal.ServerProtocol;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class AuthorizationRequest implements Parcelable {
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new Parcelable.Creator<AuthorizationRequest>() { // from class: com.spotify.sdk.android.auth.AuthorizationRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthorizationRequest createFromParcel(Parcel parcel) {
            return new AuthorizationRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthorizationRequest[] newArray(int i) {
            return new AuthorizationRequest[i];
        }
    };
    private final String mCampaign;
    private final String mClientId;
    private final Map<String, String> mCustomParams;
    private final String mRedirectUri;
    private final String mResponseType;
    private final String[] mScopes;
    private final boolean mShowDialog;
    private final String mState;

    public static class Builder {
        private String mCampaign;
        private final String mClientId;
        private final Map<String, String> mCustomParams = new HashMap();
        private final String mRedirectUri;
        private final AuthorizationResponse.Type mResponseType;
        private String[] mScopes;
        private boolean mShowDialog;
        private String mState;

        public Builder(String str, AuthorizationResponse.Type type, String str2) {
            if (str == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Client ID can't be null");
                throw null;
            }
            if (type == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Response type can't be null");
                throw null;
            }
            if (str2 == null || str2.length() == 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Redirect URI can't be null or empty");
                throw null;
            }
            this.mClientId = str;
            this.mResponseType = type;
            this.mRedirectUri = str2;
        }

        public AuthorizationRequest build() {
            return new AuthorizationRequest(this.mClientId, this.mResponseType, this.mRedirectUri, this.mState, this.mScopes, this.mShowDialog, this.mCustomParams, this.mCampaign);
        }

        public Builder setScopes(String[] strArr) {
            this.mScopes = strArr;
            return this;
        }
    }

    public AuthorizationRequest(Parcel parcel) {
        this.mClientId = parcel.readString();
        this.mResponseType = parcel.readString();
        this.mRedirectUri = parcel.readString();
        this.mState = parcel.readString();
        this.mScopes = parcel.createStringArray();
        this.mShowDialog = parcel.readByte() == 1;
        this.mCustomParams = new HashMap();
        this.mCampaign = parcel.readString();
        Bundle bundle = parcel.readBundle(getClass().getClassLoader());
        for (String str : bundle.keySet()) {
            this.mCustomParams.put(str, bundle.getString(str));
        }
    }

    private String scopesToString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.mScopes) {
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCampaign() {
        return TextUtils.isEmpty(this.mCampaign) ? "android-sdk" : this.mCampaign;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getMedium() {
        return "android-sdk";
    }

    public String getRedirectUri() {
        return this.mRedirectUri;
    }

    public String getResponseType() {
        return this.mResponseType;
    }

    public String[] getScopes() {
        return this.mScopes;
    }

    public String getSource() {
        return "spotify-sdk";
    }

    public String getState() {
        return this.mState;
    }

    public Uri toUri() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(TournamentShareDialogURIBuilder.scheme).authority("accounts.spotify.com").appendPath("authorize").appendQueryParameter("client_id", this.mClientId).appendQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, this.mResponseType).appendQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.mRedirectUri).appendQueryParameter("show_dialog", String.valueOf(this.mShowDialog)).appendQueryParameter("utm_source", getSource()).appendQueryParameter("utm_medium", getMedium()).appendQueryParameter("utm_campaign", getCampaign());
        String[] strArr = this.mScopes;
        if (strArr != null && strArr.length > 0) {
            builder.appendQueryParameter("scope", scopesToString());
        }
        String str = this.mState;
        if (str != null) {
            builder.appendQueryParameter(ServerProtocol.DIALOG_PARAM_STATE, str);
        }
        if (this.mCustomParams.size() > 0) {
            for (Map.Entry<String, String> entry : this.mCustomParams.entrySet()) {
                builder.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mClientId);
        parcel.writeString(this.mResponseType);
        parcel.writeString(this.mRedirectUri);
        parcel.writeString(this.mState);
        parcel.writeStringArray(this.mScopes);
        parcel.writeByte(this.mShowDialog ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mCampaign);
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : this.mCustomParams.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        parcel.writeBundle(bundle);
    }

    private AuthorizationRequest(String str, AuthorizationResponse.Type type, String str2, String str3, String[] strArr, boolean z, Map<String, String> map, String str4) {
        this.mClientId = str;
        this.mResponseType = type.toString();
        this.mRedirectUri = str2;
        this.mState = str3;
        this.mScopes = strArr;
        this.mShowDialog = z;
        this.mCustomParams = map;
        this.mCampaign = str4;
    }
}
