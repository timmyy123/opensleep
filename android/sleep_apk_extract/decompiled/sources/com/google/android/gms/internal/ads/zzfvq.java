package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfvq implements zzfvj {
    private static zzfvq zza;
    private float zzb = 0.0f;
    private zzfve zzc;
    private zzfvi zzd;

    public zzfvq(zzfvf zzfvfVar, zzfvb zzfvbVar) {
    }

    public static zzfvq zza() {
        if (zza == null) {
            zza = new zzfvq(new zzfvf(), new zzfvb());
        }
        return zza;
    }

    public final void zzb(Context context) {
        this.zzc = new zzfve(new Handler(), context, new zzfva(), this);
    }

    public final void zzc() {
        zzfvh.zza().zzg(this);
        zzfvh.zza().zze();
        zzfws.zzb().zzc();
        this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzfvj
    public final void zzd(boolean z) {
        if (z) {
            zzfws.zzb().zzc();
        } else {
            zzfws.zzb().zze();
        }
    }

    public final void zze() {
        zzfws.zzb().zzd();
        zzfvh.zza().zzf();
        this.zzc.zzb();
    }

    public final void zzf(float f) {
        this.zzb = f;
        if (this.zzd == null) {
            this.zzd = zzfvi.zza();
        }
        Iterator it = this.zzd.zzf().iterator();
        while (it.hasNext()) {
            ((zzfuo) it.next()).zzg().zzo(f);
        }
    }

    public final float zzg() {
        return this.zzb;
    }
}
