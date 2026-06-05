package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzftf implements zzbfk {
    final /* synthetic */ zzfth zza;

    public zzftf(zzfth zzfthVar) {
        Objects.requireNonNull(zzfthVar);
        this.zza = zzfthVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zza(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzz)).booleanValue()) {
            this.zza.zzj(z);
        }
    }
}
