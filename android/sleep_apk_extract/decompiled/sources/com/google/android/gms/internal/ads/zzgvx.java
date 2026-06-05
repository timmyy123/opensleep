package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
final class zzgvx extends zzgvz {
    public zzgvx() {
        super(null);
    }

    public static final zzgvz zzf(int i) {
        return i < 0 ? zzgvz.zzb : i > 0 ? zzgvz.zzc : zzgvz.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgvz
    public final zzgvz zza(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzgvz
    public final zzgvz zzb(int i, int i2) {
        return zzf(Integer.compare(i, i2));
    }

    @Override // com.google.android.gms.internal.ads.zzgvz
    public final zzgvz zzc(boolean z, boolean z2) {
        return zzf(Boolean.compare(z2, z));
    }

    @Override // com.google.android.gms.internal.ads.zzgvz
    public final zzgvz zzd(boolean z, boolean z2) {
        return zzf(Boolean.compare(z, z2));
    }

    @Override // com.google.android.gms.internal.ads.zzgvz
    public final int zze() {
        return 0;
    }
}
