package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdlu extends zzdip {
    private boolean zzb;

    public zzdlu(Set set) {
        super(set);
    }

    public final void zza() {
        zzs(zzdlt.zza);
    }

    public final void zzb() {
        zzs(zzdlp.zza);
    }

    public final synchronized void zzc() {
        zzs(zzdlq.zza);
        this.zzb = true;
    }

    public final synchronized void zzd() {
        try {
            if (!this.zzb) {
                zzs(zzdls.zza);
                this.zzb = true;
            }
            zzs(zzdlr.zza);
        } catch (Throwable th) {
            throw th;
        }
    }
}
