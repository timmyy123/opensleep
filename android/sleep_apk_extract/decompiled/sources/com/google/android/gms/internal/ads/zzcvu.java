package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcvu implements zzimu {
    private final zzcvs zza;

    private zzcvu(zzcvs zzcvsVar) {
        this.zza = zzcvsVar;
    }

    public static zzcvu zzc(zzcvs zzcvsVar) {
        return new zzcvu(zzcvsVar);
    }

    public static View zzd(zzcvs zzcvsVar) {
        View viewZzb = zzcvsVar.zzb();
        zzinc.zzb(viewZzb);
        return viewZzb;
    }

    public final View zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
