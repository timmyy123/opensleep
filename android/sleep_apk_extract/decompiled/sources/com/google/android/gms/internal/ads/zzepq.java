package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzepq implements zzely {
    private final Context zza;
    private final Executor zzb;
    private final zzdvr zzc;

    public zzepq(Context context, Executor executor, zzdvr zzdvrVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdvrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) {
        try {
            zzfky zzfkyVar = zzfkqVar.zza.zza;
            if (zzfkyVar.zzp.zza == 3) {
                ((zzflw) zzelvVar.zzb).zzx(this.zza, zzfkyVar.zzd, zzfkfVar.zzv.toString(), (zzbvi) zzelvVar.zzc);
            } else {
                ((zzflw) zzelvVar.zzb).zzv(this.zza, zzfkyVar.zzd, zzfkfVar.zzv.toString(), (zzbvi) zzelvVar.zzc);
            }
        } catch (Exception e) {
            String str = zzelvVar.zza;
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Fail to load ad from adapter ".concat(String.valueOf(str)), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) {
        zzdvn zzdvnVarZzf = this.zzc.zzf(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdvo(new zzepp(this, zzelvVar, zzfkfVar)));
        zzdvnVarZzf.zza().zzq(new zzcsz((zzflw) zzelvVar.zzb), this.zzb);
        ((zzenh) zzelvVar.zzc).zzc(zzdvnVarZzf.zzm());
        return zzdvnVarZzf.zzh();
    }
}
