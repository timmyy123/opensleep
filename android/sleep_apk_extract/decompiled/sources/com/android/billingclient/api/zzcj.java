package com.android.billingclient.api;

import com.android.billingclient.api.BillingResult;

/* JADX INFO: loaded from: classes.dex */
abstract class zzcj {
    static final BillingResult zzA;
    static final BillingResult zzB;
    static final BillingResult zzC;
    static final BillingResult zzD;
    static final BillingResult zzE;
    static final BillingResult zzF;
    static final BillingResult zzG;
    static final BillingResult zza = zzba$$ExternalSyntheticOutline0.m255m(3, "Google Play In-app Billing API version is less than 3");
    static final BillingResult zzb = zzba$$ExternalSyntheticOutline0.m255m(3, "Google Play In-app Billing API version is less than 9");
    static final BillingResult zzc = zzba$$ExternalSyntheticOutline0.m255m(3, "Billing service unavailable on device.");
    static final BillingResult zzd = zzba$$ExternalSyntheticOutline0.m255m(2, "Billing service unavailable on device.");
    static final BillingResult zze = zzba$$ExternalSyntheticOutline0.m255m(5, "Client is already in the process of connecting to billing service.");
    static final BillingResult zzf = zzba$$ExternalSyntheticOutline0.m255m(5, "The list of SKUs can't be empty.");
    static final BillingResult zzg = zzba$$ExternalSyntheticOutline0.m255m(5, "SKU type can't be empty.");
    static final BillingResult zzh = zzba$$ExternalSyntheticOutline0.m255m(5, "Product type can't be empty.");
    static final BillingResult zzi = zzba$$ExternalSyntheticOutline0.m255m(-2, "Client does not support extra params.");
    static final BillingResult zzj = zzba$$ExternalSyntheticOutline0.m255m(5, "Invalid purchase token.");
    static final BillingResult zzk = zzba$$ExternalSyntheticOutline0.m255m(6, "An internal error occurred.");
    static final BillingResult zzl;
    static final BillingResult zzm;
    static final BillingResult zzn;
    static final BillingResult zzo;
    static final BillingResult zzp;
    static final BillingResult zzq;
    static final BillingResult zzr;
    static final BillingResult zzs;
    static final BillingResult zzt;
    static final BillingResult zzu;
    static final BillingResult zzv;
    static final BillingResult zzw;
    static final BillingResult zzx;
    static final BillingResult zzy;
    static final BillingResult zzz;

    static {
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(5);
        builderNewBuilder.setDebugMessage("SKU can't be null.");
        builderNewBuilder.build();
        BillingResult.Builder builderNewBuilder2 = BillingResult.newBuilder();
        builderNewBuilder2.setResponseCode(0);
        zzl = builderNewBuilder2.build();
        zzm = zzba$$ExternalSyntheticOutline0.m255m(-1, "Service connection is disconnected.");
        zzn = zzba$$ExternalSyntheticOutline0.m255m(2, "Timeout communicating with service.");
        zzo = zzba$$ExternalSyntheticOutline0.m255m(-2, "Client does not support subscriptions.");
        zzp = zzba$$ExternalSyntheticOutline0.m255m(-2, "Client does not support subscriptions update.");
        zzq = zzba$$ExternalSyntheticOutline0.m255m(-2, "Client does not support get purchase history.");
        zzr = zzba$$ExternalSyntheticOutline0.m255m(-2, "Client does not support price change confirmation.");
        zzs = zzba$$ExternalSyntheticOutline0.m255m(-2, "Play Store version installed does not support cross selling products.");
        zzt = zzba$$ExternalSyntheticOutline0.m255m(-2, "Client does not support multi-item purchases.");
        zzu = zzba$$ExternalSyntheticOutline0.m255m(-2, "Client does not support offer_id_token.");
        zzv = zzba$$ExternalSyntheticOutline0.m255m(-2, "Client does not support ProductDetails.");
        zzw = zzba$$ExternalSyntheticOutline0.m255m(-2, "Client does not support in-app messages.");
        BillingResult.Builder builderNewBuilder3 = BillingResult.newBuilder();
        builderNewBuilder3.setResponseCode(-2);
        builderNewBuilder3.setDebugMessage("Client does not support user choice billing.");
        builderNewBuilder3.build();
        BillingResult.Builder builderNewBuilder4 = BillingResult.newBuilder();
        builderNewBuilder4.setResponseCode(-2);
        builderNewBuilder4.setDebugMessage("Play Store version installed does not support external offer.");
        zzx = builderNewBuilder4.build();
        zzy = zzba$$ExternalSyntheticOutline0.m255m(-2, "Play Store version installed does not support multi-item purchases with season pass in one cart.");
        zzz = zzba$$ExternalSyntheticOutline0.m255m(5, "Unknown feature");
        zzA = zzba$$ExternalSyntheticOutline0.m255m(-2, "Play Store version installed does not support get billing config.");
        zzB = zzba$$ExternalSyntheticOutline0.m255m(-2, "Query product details with serialized docid is not supported.");
        zzC = zzba$$ExternalSyntheticOutline0.m255m(4, "Item is unavailable for purchase.");
        zzD = zzba$$ExternalSyntheticOutline0.m255m(-2, "Query product details with developer specified account is not supported.");
        zzE = zzba$$ExternalSyntheticOutline0.m255m(-2, "Play Store version installed does not support alternative billing only.");
        zzF = zzba$$ExternalSyntheticOutline0.m255m(5, "To use this API you must specify a PurchasesUpdateListener when initializing a BillingClient.");
        zzG = zzba$$ExternalSyntheticOutline0.m255m(6, "An error occurred while retrieving billing override.");
    }

    public static BillingResult zza(int i, String str) {
        return zzba$$ExternalSyntheticOutline0.m255m(i, str);
    }
}
