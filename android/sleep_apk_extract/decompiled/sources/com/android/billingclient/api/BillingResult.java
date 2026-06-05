package com.android.billingclient.api;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.internal.play_billing.zze;

/* JADX INFO: loaded from: classes.dex */
public final class BillingResult {
    private int zza;
    private String zzb;

    public static class Builder {
        private int zza;
        private String zzb = "";

        public /* synthetic */ Builder(zzci zzciVar) {
        }

        public BillingResult build() {
            BillingResult billingResult = new BillingResult();
            billingResult.zza = this.zza;
            billingResult.zzb = this.zzb;
            return billingResult;
        }

        public Builder setDebugMessage(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setResponseCode(int i) {
            this.zza = i;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public String getDebugMessage() {
        return this.zzb;
    }

    public int getResponseCode() {
        return this.zza;
    }

    public String toString() {
        return Fragment$$ExternalSyntheticOutline1.m("Response Code: ", zze.zzi(this.zza), ", Debug Message: ", this.zzb);
    }
}
