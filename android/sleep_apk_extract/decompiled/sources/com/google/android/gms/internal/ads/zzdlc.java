package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdlc {
    private final List zza;
    private final zzfsc zzb;
    private final com.google.android.gms.ads.internal.util.client.zzv zzc;
    private boolean zzd;

    public zzdlc(zzfkf zzfkfVar, zzfsc zzfscVar) {
        this.zza = zzfkfVar.zzp;
        this.zzb = zzfscVar;
        this.zzc = zzfkfVar.zzax;
    }

    public final void zza() {
        if (this.zzd) {
            return;
        }
        this.zzb.zza(this.zza, this.zzc);
        this.zzd = true;
    }
}
