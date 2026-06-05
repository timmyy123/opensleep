package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: loaded from: classes3.dex */
public final class zzru {
    private final Handler zza;
    private final zzrv zzb;

    public zzru(Handler handler, zzrv zzrvVar) {
        this.zza = zzrvVar == null ? null : handler;
        this.zzb = zzrvVar;
    }

    public final /* synthetic */ void zzA(int i) {
        String str = zzfl.zza;
        this.zzb.zzx(i);
    }

    public final /* synthetic */ void zzB(zziz zzizVar) {
        String str = zzfl.zza;
        this.zzb.zzy(zzizVar);
    }

    public final void zza(final zzjb zzjbVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrt
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzo(zzjbVar);
                }
            });
        }
    }

    public final void zzb(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzp(str, j, j2);
                }
            });
        }
    }

    public final void zzc(final zzv zzvVar, final zzjc zzjcVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzq(zzvVar, zzjcVar);
                }
            });
        }
    }

    public final void zzd(final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzr(j);
                }
            });
        }
    }

    public final void zze(final int i, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzs(i, j, j2);
                }
            });
        }
    }

    public final void zzf(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrn
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzt(str);
                }
            });
        }
    }

    public final void zzg(final zzjb zzjbVar) {
        zzjbVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzro
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(zzjbVar);
                }
            });
        }
    }

    public final void zzh(final boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzv(z);
                }
            });
        }
    }

    public final void zzi(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzw(exc);
                }
            });
        }
    }

    public final void zzj(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrr
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzx(exc);
                }
            });
        }
    }

    public final void zzk(final zzry zzryVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrs
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzy(zzryVar);
                }
            });
        }
    }

    public final void zzl(final zzry zzryVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzz(zzryVar);
                }
            });
        }
    }

    public final void zzm(final int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzri
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzA(i);
                }
            });
        }
    }

    public final void zzn(final zziz zzizVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrj
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzB(zzizVar);
                }
            });
        }
    }

    public final /* synthetic */ void zzo(zzjb zzjbVar) {
        String str = zzfl.zza;
        this.zzb.zzl(zzjbVar);
    }

    public final /* synthetic */ void zzp(String str, long j, long j2) {
        String str2 = zzfl.zza;
        this.zzb.zzm(str, j, j2);
    }

    public final /* synthetic */ void zzq(zzv zzvVar, zzjc zzjcVar) {
        String str = zzfl.zza;
        this.zzb.zzn(zzvVar, zzjcVar);
    }

    public final /* synthetic */ void zzr(long j) {
        String str = zzfl.zza;
        this.zzb.zzo(j);
    }

    public final /* synthetic */ void zzs(int i, long j, long j2) {
        String str = zzfl.zza;
        this.zzb.zzp(i, j, j2);
    }

    public final /* synthetic */ void zzt(String str) {
        String str2 = zzfl.zza;
        this.zzb.zzq(str);
    }

    public final /* synthetic */ void zzu(zzjb zzjbVar) {
        zzjbVar.zza();
        String str = zzfl.zza;
        this.zzb.zzr(zzjbVar);
    }

    public final /* synthetic */ void zzv(boolean z) {
        String str = zzfl.zza;
        this.zzb.zzs(z);
    }

    public final /* synthetic */ void zzw(Exception exc) {
        String str = zzfl.zza;
        this.zzb.zzt(exc);
    }

    public final /* synthetic */ void zzx(Exception exc) {
        String str = zzfl.zza;
        this.zzb.zzu(exc);
    }

    public final /* synthetic */ void zzy(zzry zzryVar) {
        String str = zzfl.zza;
        this.zzb.zzv(zzryVar);
    }

    public final /* synthetic */ void zzz(zzry zzryVar) {
        String str = zzfl.zza;
        this.zzb.zzw(zzryVar);
    }
}
