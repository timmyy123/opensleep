package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeex implements zzimu {
    private final zzind zza;

    private zzeex(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzeex zza(zzind zzindVar) {
        return new zzeex(zzindVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.ads.zzinj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ Object zzb() {
        String strValueOf;
        zzfky zzfkyVarZza = ((zzdci) this.zza).zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzil)).booleanValue()) {
            String str = zzfkyVarZza.zzd.zzx;
            if (!TextUtils.isEmpty(str)) {
                try {
                    strValueOf = new JSONObject(str).getString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
                } catch (JSONException unused) {
                }
                if (TextUtils.isEmpty(strValueOf)) {
                    com.google.android.gms.ads.internal.client.zzc zzcVar = zzfkyVarZza.zzd.zzs;
                    if (zzcVar != null) {
                        try {
                            strValueOf = new JSONObject(zzcVar.zza).getString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
                        } catch (JSONException unused2) {
                        }
                        if (TextUtils.isEmpty(strValueOf)) {
                            strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zzh().nextInt() & Integer.MAX_VALUE);
                        }
                    }
                }
            }
        }
        zzinc.zzb(strValueOf);
        return strValueOf;
    }
}
