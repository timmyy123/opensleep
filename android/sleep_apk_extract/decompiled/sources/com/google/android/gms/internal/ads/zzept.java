package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzept implements zzely {
    private final Context zza;
    private final zzdvr zzb;

    public zzept(Context context, zzdvr zzdvrVar) {
        this.zza = context;
        this.zzb = zzdvrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) {
        try {
            zzbxb zzbxbVar = (zzbxb) zzelvVar.zzb;
            zzbxbVar.zzo(zzfkfVar.zzZ);
            zzfky zzfkyVar = zzfkqVar.zza.zza;
            int i = zzfkyVar.zzp.zza;
            String str = zzfkfVar.zzU;
            if (i == 3) {
                zzbxbVar.zzp(str, zzfkfVar.zzv.toString(), zzfkyVar.zzd, ObjectWrapper.wrap(this.zza), new zzeps(this, zzelvVar, null), (zzbvi) zzelvVar.zzc);
            } else {
                zzbxbVar.zzl(str, zzfkfVar.zzv.toString(), zzfkyVar.zzd, ObjectWrapper.wrap(this.zza), new zzeps(this, zzelvVar, null), (zzbvi) zzelvVar.zzc);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) {
        zzenq zzenqVar = new zzenq(zzfkfVar, (zzbxb) zzelvVar.zzb, AdFormat.REWARDED);
        zzdvn zzdvnVarZzf = this.zzb.zzf(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdvo(zzenqVar));
        zzenqVar.zzc(zzdvnVarZzf.zzd());
        ((zzenh) zzelvVar.zzc).zzc(zzdvnVarZzf.zzn());
        return zzdvnVarZzf.zzh();
    }
}
