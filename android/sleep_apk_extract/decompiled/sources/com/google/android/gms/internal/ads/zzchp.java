package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzchp implements Runnable {
    private final zzchb zza;
    private boolean zzb = false;

    public zzchp(zzchb zzchbVar) {
        this.zza = zzchbVar;
    }

    private final void zzc() {
        zzgam zzgamVar = com.google.android.gms.ads.internal.util.zzs.zza;
        zzgamVar.removeCallbacks(this);
        zzgamVar.postDelayed(this, 250L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb) {
            return;
        }
        this.zza.zzF();
        zzc();
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzF();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
