package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcuq implements zzbeq {
    private zzcku zza;
    private final Executor zzb;
    private final zzcuc zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcuf zzg = new zzcuf();

    public zzcuq(Executor executor, zzcuc zzcucVar, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcucVar;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            final JSONObject jSONObjectZzb = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcup
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzf(jSONObjectZzb);
                    }
                });
            }
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed to call video active view js", e);
        }
    }

    public final void zza(zzcku zzckuVar) {
        this.zza = zzckuVar;
    }

    public final void zzb() {
        this.zze = false;
    }

    public final void zzd() {
        this.zze = true;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbeq
    public final void zzdj(zzbep zzbepVar) {
        boolean z = this.zzf ? false : zzbepVar.zzj;
        zzcuf zzcufVar = this.zzg;
        zzcufVar.zza = z;
        zzcufVar.zzd = this.zzd.elapsedRealtime();
        zzcufVar.zzf = zzbepVar;
        if (this.zze) {
            zzg();
        }
    }

    public final void zze(boolean z) {
        this.zzf = z;
    }

    public final /* synthetic */ void zzf(JSONObject jSONObject) {
        String string = jSONObject.toString();
        String strM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 31), "Calling AFMA_updateActiveView(", string, ")");
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzd(strM);
        this.zza.zzb("AFMA_updateActiveView", jSONObject);
    }
}
