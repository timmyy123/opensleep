package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzabh {
    private zzabg zza;
    private zzabq zzb;

    public void zzb() {
        this.zza = null;
        this.zzb = null;
    }

    public abstract boolean zzd();

    public abstract void zze(zzd zzdVar);

    public abstract zznb zzg();

    public abstract void zzq(Object obj);

    public abstract zzabi zzr(zznc[] zzncVarArr, zzzn zzznVar, zzxk zzxkVar, zzbf zzbfVar);

    public final void zzs(zzabg zzabgVar, zzabq zzabqVar) {
        zzgtj.zzi(this.zza == null);
        this.zza = zzabgVar;
        this.zzb = zzabqVar;
    }

    public final void zzt() {
        zzabg zzabgVar = this.zza;
        if (zzabgVar != null) {
            zzabgVar.zzq();
        }
    }

    public final zzabq zzu() {
        zzabq zzabqVar = this.zzb;
        zzabqVar.getClass();
        return zzabqVar;
    }
}
