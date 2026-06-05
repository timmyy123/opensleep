package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfcc implements zzfck {
    private final boolean zza;

    public zzfcc(zzfia zzfiaVar) {
        this.zza = zzfiaVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return zzhbw.zza(new zzfcb(this.zza, null));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 36;
    }
}
