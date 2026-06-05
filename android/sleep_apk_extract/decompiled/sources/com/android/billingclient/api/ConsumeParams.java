package com.android.billingclient.api;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public final class ConsumeParams {
    private String zza;

    public static final class Builder {
        private String zza;

        public /* synthetic */ Builder(zzck zzckVar) {
        }

        public ConsumeParams build() {
            String str = this.zza;
            zzck zzckVar = null;
            if (str == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Purchase token must be set");
                return null;
            }
            ConsumeParams consumeParams = new ConsumeParams(zzckVar);
            consumeParams.zza = str;
            return consumeParams;
        }

        public Builder setPurchaseToken(String str) {
            this.zza = str;
            return this;
        }
    }

    public /* synthetic */ ConsumeParams(zzck zzckVar) {
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public String getPurchaseToken() {
        return this.zza;
    }
}
