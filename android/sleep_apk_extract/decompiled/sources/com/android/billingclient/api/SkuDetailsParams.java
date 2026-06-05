package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SkuDetailsParams {
    private String zza;
    private List zzb;

    public static class Builder {
        private String zza;
        private List zzb;

        public /* synthetic */ Builder(zzdd zzddVar) {
        }

        public SkuDetailsParams build() {
            String str = this.zza;
            if (str == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("SKU type must be set");
                return null;
            }
            if (this.zzb == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("SKU list must be set");
                return null;
            }
            SkuDetailsParams skuDetailsParams = new SkuDetailsParams();
            skuDetailsParams.zza = str;
            skuDetailsParams.zzb = this.zzb;
            return skuDetailsParams;
        }

        public Builder setSkusList(List<String> list) {
            this.zzb = new ArrayList(list);
            return this;
        }

        public Builder setType(String str) {
            this.zza = str;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public String getSkuType() {
        return this.zza;
    }

    public List<String> getSkusList() {
        return this.zzb;
    }
}
