package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzyn implements zzzc {
    final /* synthetic */ zzyq zza;
    private final int zzb;

    public zzyn(zzyq zzyqVar, int i) {
        Objects.requireNonNull(zzyqVar);
        this.zza = zzyqVar;
        this.zzb = i;
    }

    public final /* synthetic */ int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean zzb() {
        return this.zza.zzp(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zzc() throws IOException {
        this.zza.zzq(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zzd(zzlw zzlwVar, zziv zzivVar, int i) {
        return this.zza.zzs(this.zzb, zzlwVar, zzivVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zze(long j) {
        return this.zza.zzt(this.zzb, j);
    }
}
