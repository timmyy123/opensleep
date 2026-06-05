package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcoh implements zzimu {
    private final zzcnl zza;

    private zzcoh(zzcnl zzcnlVar) {
        this.zza = zzcnlVar;
    }

    public static zzcoh zza(zzcnl zzcnlVar) {
        return new zzcoh(zzcnlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        String strZze = this.zza.zze();
        zzinc.zzb(strZze);
        return strZze;
    }
}
