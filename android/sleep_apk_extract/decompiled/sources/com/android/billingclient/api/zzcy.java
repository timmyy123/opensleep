package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zze;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
abstract class zzcy {
    public static zzcx zza(Bundle bundle, String str, String str2) {
        BillingResult billingResult = zzcj.zzk;
        if (bundle == null) {
            zze.zzl("BillingClient", str2 + " got null owned items list");
            return new zzcx(billingResult, 54);
        }
        int iZzb = zze.zzb(bundle, "BillingClient");
        BillingResult billingResultM255m = zzba$$ExternalSyntheticOutline0.m255m(iZzb, zze.zzh(bundle, "BillingClient"));
        if (iZzb != 0) {
            zze.zzl("BillingClient", str2 + " failed. Response code: " + iZzb);
            return new zzcx(billingResultM255m, 23);
        }
        if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            zze.zzl("BillingClient", "Bundle returned from " + str2 + " doesn't contain required fields.");
            return new zzcx(billingResult, 55);
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        if (stringArrayList == null) {
            zze.zzl("BillingClient", "Bundle returned from " + str2 + " contains null SKUs list.");
            return new zzcx(billingResult, 56);
        }
        if (stringArrayList2 == null) {
            zze.zzl("BillingClient", "Bundle returned from " + str2 + " contains null purchases list.");
            return new zzcx(billingResult, 57);
        }
        if (stringArrayList3 != null) {
            return new zzcx(zzcj.zzl, 1);
        }
        zze.zzl("BillingClient", "Bundle returned from " + str2 + " contains null signatures list.");
        return new zzcx(billingResult, 58);
    }
}
