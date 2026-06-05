package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzemh implements zzely {
    private final Context zza;
    private final zzcuz zzb;
    private final Executor zzc;

    public zzemh(Context context, zzcuz zzcuzVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcuzVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        zzflw zzflwVar = (zzflw) zzelvVar.zzb;
        zzfky zzfkyVar = zzfkqVar.zza.zza;
        String string = zzfkfVar.zzv.toString();
        zzflwVar.zzy(this.zza, zzfkyVar.zzd, string, (zzbvi) zzelvVar.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) {
        zzcuw zzcuwVarZzf = this.zzb.zzf(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdmd(new zzemg(this, zzelvVar, zzfkfVar), null), new zzcux(zzfkfVar.zzaa));
        zzcuwVarZzf.zza().zzq(new zzcsz((zzflw) zzelvVar.zzb), this.zzc);
        ((zzenh) zzelvVar.zzc).zzc(zzcuwVarZzf.zzf());
        return zzcuwVarZzf.zzh();
    }
}
