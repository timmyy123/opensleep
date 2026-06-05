package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzfg implements zzdz {
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzfg(Handler handler) {
        this.zzb = handler;
    }

    public static /* synthetic */ void zzo(zzff zzffVar) {
        List list = zza;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(zzffVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static zzff zzp() {
        zzff zzffVar;
        List list = zza;
        synchronized (list) {
            try {
                zzffVar = list.isEmpty() ? new zzff(null) : (zzff) list.remove(list.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzffVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final Looper zza() {
        return this.zzb.getLooper();
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzb(int i) {
        return this.zzb.hasMessages(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final zzdy zzc(int i) {
        Handler handler = this.zzb;
        zzff zzffVarZzp = zzp();
        zzffVarZzp.zzb(handler.obtainMessage(i), this);
        return zzffVarZzp;
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final zzdy zzd(int i, Object obj) {
        Handler handler = this.zzb;
        zzff zzffVarZzp = zzp();
        zzffVarZzp.zzb(handler.obtainMessage(i, obj), this);
        return zzffVarZzp;
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final zzdy zze(int i, int i2, int i3) {
        Handler handler = this.zzb;
        zzff zzffVarZzp = zzp();
        zzffVarZzp.zzb(handler.obtainMessage(i, i2, i3), this);
        return zzffVarZzp;
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final zzdy zzf(int i, int i2, int i3, Object obj) {
        Handler handler = this.zzb;
        zzff zzffVarZzp = zzp();
        zzffVarZzp.zzb(handler.obtainMessage(31, 0, 0, obj), this);
        return zzffVarZzp;
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzg(zzdy zzdyVar) {
        return ((zzff) zzdyVar).zzc(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzh(int i) {
        return this.zzb.sendEmptyMessage(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzi(int i, int i2) {
        return this.zzb.sendEmptyMessageDelayed(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzj(int i, long j) {
        return this.zzb.sendEmptyMessageAtTime(2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final void zzk(int i) {
        this.zzb.removeMessages(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final void zzl(Object obj) {
        this.zzb.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzm(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzdz
    public final boolean zzn(Runnable runnable, long j) {
        return this.zzb.postDelayed(runnable, 1000L);
    }
}
