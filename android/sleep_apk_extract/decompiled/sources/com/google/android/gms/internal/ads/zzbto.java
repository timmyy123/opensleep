package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbto extends zzcgd {
    private final Object zza = new Object();
    private final zzbtt zzb;
    private boolean zzc;

    public zzbto(zzbtt zzbttVar) {
        this.zzb = zzbttVar;
    }

    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("release: Trying to acquire lock");
        synchronized (this.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("release: Lock acquired");
                if (this.zzc) {
                    com.google.android.gms.ads.internal.util.zze.zza("release: Lock already released");
                    return;
                }
                this.zzc = true;
                zze(new zzbtl(this), new zzcfz());
                zze(new zzbtm(this), new zzbtn(this));
                com.google.android.gms.ads.internal.util.zze.zza("release: Lock released");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ zzbtt zzb() {
        return this.zzb;
    }
}
