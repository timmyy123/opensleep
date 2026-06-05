package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcnt implements zzimu {
    private final zzcnl zza;

    private zzcnt(zzcnl zzcnlVar) {
        this.zza = zzcnlVar;
    }

    public static zzcnt zzc(zzcnl zzcnlVar) {
        return new zzcnt(zzcnlVar);
    }

    public static WeakReference zzd(zzcnl zzcnlVar) {
        WeakReference weakReferenceZzc = zzcnlVar.zzc();
        zzinc.zzb(weakReferenceZzc);
        return weakReferenceZzc;
    }

    public final WeakReference zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
