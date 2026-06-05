package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaeo {
    private final Handler zza;
    private final zzaep zzb;

    public zzaeo(Handler handler, zzaep zzaepVar) {
        if (zzaepVar != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzaepVar;
    }

    public final void zza(final zzjb zzjbVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaen
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzl(zzjbVar);
                }
            });
        }
    }

    public final void zzb(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaed
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzm(str, j, j2);
                }
            });
        }
    }

    public final void zzc(final zzv zzvVar, final zzjc zzjcVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaee
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzn(zzvVar, zzjcVar);
                }
            });
        }
    }

    public final void zzd(final int i, final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaef
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzo(i, j);
                }
            });
        }
    }

    public final void zze(final long j, final int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaeg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzp(j, i);
                }
            });
        }
    }

    public final void zzf(final zzbv zzbvVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaeh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzq(zzbvVar);
                }
            });
        }
    }

    public final void zzg(final Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaei
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzr(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final void zzh(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaej
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzs(str);
                }
            });
        }
    }

    public final void zzi(final zzjb zzjbVar) {
        zzjbVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaek
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzt(zzjbVar);
                }
            });
        }
    }

    public final void zzj(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzael
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(exc);
                }
            });
        }
    }

    public final void zzk(final zziz zzizVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaem
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzv(zzizVar);
                }
            });
        }
    }

    public final /* synthetic */ void zzl(zzjb zzjbVar) {
        String str = zzfl.zza;
        this.zzb.zzb(zzjbVar);
    }

    public final /* synthetic */ void zzm(String str, long j, long j2) {
        String str2 = zzfl.zza;
        this.zzb.zzc(str, j, j2);
    }

    public final /* synthetic */ void zzn(zzv zzvVar, zzjc zzjcVar) {
        String str = zzfl.zza;
        this.zzb.zzd(zzvVar, zzjcVar);
    }

    public final /* synthetic */ void zzo(int i, long j) {
        String str = zzfl.zza;
        this.zzb.zze(i, j);
    }

    public final /* synthetic */ void zzp(long j, int i) {
        String str = zzfl.zza;
        this.zzb.zzj(j, i);
    }

    public final /* synthetic */ void zzq(zzbv zzbvVar) {
        String str = zzfl.zza;
        this.zzb.zzf(zzbvVar);
    }

    public final /* synthetic */ void zzr(Object obj, long j) {
        String str = zzfl.zza;
        this.zzb.zzg(obj, j);
    }

    public final /* synthetic */ void zzs(String str) {
        String str2 = zzfl.zza;
        this.zzb.zzh(str);
    }

    public final /* synthetic */ void zzt(zzjb zzjbVar) {
        zzjbVar.zza();
        String str = zzfl.zza;
        this.zzb.zzi(zzjbVar);
    }

    public final /* synthetic */ void zzu(Exception exc) {
        String str = zzfl.zza;
        this.zzb.zzk(exc);
    }

    public final /* synthetic */ void zzv(zziz zzizVar) {
        String str = zzfl.zza;
        this.zzb.zzz(zzizVar);
    }
}
