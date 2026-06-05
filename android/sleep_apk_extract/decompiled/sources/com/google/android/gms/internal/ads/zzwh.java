package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
final class zzwh implements zzvk {
    private final MediaCodec zza;

    public zzwh(MediaCodec mediaCodec) {
        this.zza = mediaCodec;
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzb(int i, int i2, int i3, long j, int i4) {
        this.zza.queueInputBuffer(i, 0, i3, j, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzc(int i, int i2, zzis zzisVar, long j, int i3) {
        this.zza.queueSecureInputBuffer(i, 0, zzisVar.zzb(), j, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzd(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzg() {
    }
}
