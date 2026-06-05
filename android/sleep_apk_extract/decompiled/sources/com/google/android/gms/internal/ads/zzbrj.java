package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbrj extends zzbrg {
    final /* synthetic */ zzcfw zza;

    public zzbrj(zzbrk zzbrkVar, zzcfw zzcfwVar) {
        this.zza = zzcfwVar;
        Objects.requireNonNull(zzbrkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrh
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzc(parcelFileDescriptor);
    }
}
