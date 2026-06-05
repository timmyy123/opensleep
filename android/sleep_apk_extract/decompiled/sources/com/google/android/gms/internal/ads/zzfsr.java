package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzfsr implements zzbfk {
    final /* synthetic */ zzfss zza;

    public zzfsr(zzfss zzfssVar) {
        Objects.requireNonNull(zzfssVar);
        this.zza = zzfssVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zza(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzz)).booleanValue()) {
            this.zza.zzl(z);
        }
    }
}
