package com.android.installreferrer.api;

import android.content.Context;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public abstract class InstallReferrerClient {

    public static final class Builder {
        private final Context mContext;

        private Builder(Context context) {
            this.mContext = context;
        }

        public InstallReferrerClient build() {
            Context context = this.mContext;
            if (context != null) {
                return new InstallReferrerClientImpl(context);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Please provide a valid Context.");
            return null;
        }
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    public abstract void endConnection();

    public abstract ReferrerDetails getInstallReferrer();

    public abstract void startConnection(InstallReferrerStateListener installReferrerStateListener);
}
