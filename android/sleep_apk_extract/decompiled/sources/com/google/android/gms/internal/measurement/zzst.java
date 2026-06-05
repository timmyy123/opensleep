package com.google.android.gms.internal.measurement;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class zzst implements zzrt {
    private zzst() {
    }

    public static zzst zzb() {
        return new zzst();
    }

    public static final InputStream zzc(zzrs zzrsVar) {
        return (InputStream) zzrsVar.zzc(zzrsVar.zza().zzd(zzrsVar.zzb())).get(0);
    }

    @Override // com.google.android.gms.internal.measurement.zzrt
    public final /* bridge */ /* synthetic */ Object zza(zzrs zzrsVar) {
        return zzc(zzrsVar);
    }
}
