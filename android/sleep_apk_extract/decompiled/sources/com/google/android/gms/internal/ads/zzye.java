package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzye extends zzagn {
    final /* synthetic */ zzyq zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzye(zzyq zzyqVar, zzahb zzahbVar) {
        super(zzahbVar);
        Objects.requireNonNull(zzyqVar);
        this.zza = zzyqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagn, com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zza.zzQ();
    }
}
