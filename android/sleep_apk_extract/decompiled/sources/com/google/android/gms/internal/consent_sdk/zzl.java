package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzl {
    private final zzam zza;
    private final Context zzb;

    public zzl(Application application, zzam zzamVar) {
        this.zza = zzamVar;
        this.zzb = application.getApplicationContext();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:70:0x007f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(Map map) {
        String str;
        String str2;
        int iIntValue;
        zzam zzamVar = this.zza;
        if (zzamVar.zzd()) {
            zzamVar.zzb(this.zzb);
            Integer num = (Integer) map.get("IABTCF_gdprApplies");
            HashMap map2 = new HashMap();
            for (String str3 : map.keySet()) {
                if (!str3.equals("IABTCF_gdprApplies")) {
                    switch (str3.hashCode()) {
                        case -1926457382:
                            if (str3.equals("UMP_CoMoAdPersonalizationPurposeConsentStatus")) {
                                str = "google_analytics_default_allow_ad_personalization_signals";
                                str2 = "AD_PERSONALIZATION";
                                iIntValue = ((Integer) map.get(str3)).intValue();
                                if (iIntValue == -1) {
                                    if (iIntValue == 1) {
                                        map2.put(str2, "GRANTED");
                                    } else if (iIntValue == 2) {
                                        map2.put(str2, "DENIED");
                                    } else if (iIntValue != 4) {
                                        if (iIntValue != 5) {
                                            Log.w("UserMessagingPlatform", "Invalid CoMo consent status: " + iIntValue);
                                        } else {
                                            Object objZza = zzamVar.zza(str);
                                            if (objZza == null) {
                                                Log.w("UserMessagingPlatform", "No default metadata");
                                            } else if (objZza instanceof Boolean) {
                                                map2.put(str2, true != ((Boolean) objZza).booleanValue() ? "DENIED" : "GRANTED");
                                            } else if ((objZza instanceof String) && objZza.equals("eu_consent_policy") && ((str2.equals("AD_PERSONALIZATION") || str2.equals("AD_USER_DATA")) && num != null)) {
                                                map2.put(str2, num.intValue() == 1 ? "DENIED" : "GRANTED");
                                            } else {
                                                Log.w("UserMessagingPlatform", "Failed to get the default eu_consent_policy value.");
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        case -142866440:
                            if (!str3.equals("UMP_CoMoAnalyticsStoragePurposeConsentStatus")) {
                                break;
                            } else {
                                str = "google_analytics_default_allow_analytics_storage";
                                str2 = "ANALYTICS_STORAGE";
                                iIntValue = ((Integer) map.get(str3)).intValue();
                                if (iIntValue == -1) {
                                }
                            }
                            break;
                        case 1068702385:
                            if (!str3.equals("UMP_CoMoAdStoragePurposeConsentStatus")) {
                                break;
                            } else {
                                str = "google_analytics_default_allow_ad_storage";
                                str2 = "AD_STORAGE";
                                iIntValue = ((Integer) map.get(str3)).intValue();
                                if (iIntValue == -1) {
                                }
                            }
                            break;
                        case 1479307131:
                            if (!str3.equals("UMP_CoMoAdUserDataPurposeConsentStatus")) {
                                break;
                            } else {
                                str = "google_analytics_default_allow_ad_user_data";
                                str2 = "AD_USER_DATA";
                                iIntValue = ((Integer) map.get(str3)).intValue();
                                if (iIntValue == -1) {
                                }
                            }
                            break;
                    }
                }
            }
            zzamVar.zzc(map2);
        }
    }
}
