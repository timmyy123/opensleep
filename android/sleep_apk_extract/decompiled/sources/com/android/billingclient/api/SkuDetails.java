package com.android.billingclient.api;

import android.text.TextUtils;
import com.facebook.appevents.internal.Constants;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SkuDetails {
    private final String zza;
    private final JSONObject zzb;

    public SkuDetails(String str) {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString("productId"))) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("SKU cannot be empty.");
            throw null;
        }
        if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("SkuType cannot be empty.");
            throw null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.zza, ((SkuDetails) obj).zza);
        }
        return false;
    }

    public String getIntroductoryPrice() {
        return this.zzb.optString("introductoryPrice");
    }

    public long getIntroductoryPriceAmountMicros() {
        return this.zzb.optLong(Constants.GP_IAP_INTRODUCTORY_PRICE_AMOUNT_MICROS);
    }

    public String getOriginalJson() {
        return this.zza;
    }

    public String getPrice() {
        return this.zzb.optString("price");
    }

    public long getPriceAmountMicros() {
        return this.zzb.optLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V2V4);
    }

    public String getPriceCurrencyCode() {
        return this.zzb.optString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V2V4);
    }

    public String getSku() {
        return this.zzb.optString("productId");
    }

    public String getType() {
        return this.zzb.optString("type");
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.zza));
    }

    public int zza() {
        return this.zzb.optInt("offer_type");
    }

    public String zzb() {
        return this.zzb.optString("offer_id");
    }

    public String zzc() {
        String strOptString = this.zzb.optString("offerIdToken");
        return strOptString.isEmpty() ? this.zzb.optString("offer_id_token") : strOptString;
    }

    public final String zzd() {
        return this.zzb.optString("packageName");
    }

    public String zze() {
        return this.zzb.optString("serializedDocid");
    }

    public final String zzf() {
        return this.zzb.optString("skuDetailsToken");
    }
}
