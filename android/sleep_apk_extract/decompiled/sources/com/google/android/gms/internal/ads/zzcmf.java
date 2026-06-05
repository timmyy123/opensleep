package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcmf {
    private final zzcme zza;
    private final zzcmg zzb;

    public zzcmf(zzcmg zzcmgVar, zzcme zzcmeVar) {
        this.zza = zzcmeVar;
        this.zzb = zzcmgVar;
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        zzcmg zzcmgVar = this.zzb;
        zzbap zzbapVarZzS = ((zzcmn) zzcmgVar).zzS();
        if (zzbapVarZzS == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzbak zzbakVarZzb = zzbapVarZzS.zzb();
        if (zzbakVarZzb == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signals object is empty, ignoring.");
            return "";
        }
        if (zzcmgVar.getContext() != null) {
            return zzbakVarZzb.zzf(zzcmgVar.getContext(), str, ((zzcmp) zzcmgVar).zzE(), zzcmgVar.zzj());
        }
        com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
        return "";
    }

    @JavascriptInterface
    public String getViewSignals() {
        zzcmg zzcmgVar = this.zzb;
        zzbap zzbapVarZzS = ((zzcmn) zzcmgVar).zzS();
        if (zzbapVarZzS == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzbak zzbakVarZzb = zzbapVarZzS.zzb();
        if (zzbakVarZzb == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signals object is empty, ignoring.");
            return "";
        }
        if (zzcmgVar.getContext() != null) {
            return zzbakVarZzb.zzj(zzcmgVar.getContext(), ((zzcmp) zzcmgVar).zzE(), zzcmgVar.zzj());
        }
        com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
        return "";
    }

    @JavascriptInterface
    public String getViewSignalsJson() {
        zzcmg zzcmgVar = this.zzb;
        zzbiq.zza(zzcmgVar.getContext());
        String viewSignals = getViewSignals();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpj)).booleanValue()) {
            return viewSignals;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ms", viewSignals);
            zzcms zzcmsVarZzP = ((zzcku) zzcmgVar).zzP();
            zzdbn zzdbnVarZzK = zzcmsVarZzP != null ? zzcmsVarZzP.zzK() : null;
            if (zzdbnVarZzK != null) {
                long jZza = zzdbnVarZzK.zza();
                if (jZza > 0) {
                    jSONObject.put("plcmtid", jZza);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Error constructing JSON.", e);
            return "";
        }
    }

    @JavascriptInterface
    public void notify(final String str) {
        if (!TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmc
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zza(str);
                }
            });
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("URL is empty, ignoring message");
        }
    }

    public final /* synthetic */ void zza(String str) {
        this.zza.zza(Uri.parse(str));
    }
}
