package com.google.android.gms.internal.clearcut;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzbv extends zzbu<Object> {
    @Override // com.google.android.gms.internal.clearcut.zzbu
    public final void zza(zzfr zzfrVar, Map.Entry<?, ?> entry) {
        if (entry.getKey() != null) {
            throw new ClassCastException();
        }
        int[] iArr = zzbw.zzgq;
        throw null;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbu
    public final zzby<Object> zzb(Object obj) {
        zzby<Object> zzbyVarZza = zza(obj);
        if (!zzbyVarZza.isImmutable()) {
            return zzbyVarZza;
        }
        zzby<Object> zzbyVar = (zzby) zzbyVarZza.clone();
        zza(obj, zzbyVar);
        return zzbyVar;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbu
    public final void zzc(Object obj) {
        zza(obj).zzv();
    }

    @Override // com.google.android.gms.internal.clearcut.zzbu
    public final boolean zze(zzdo zzdoVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbu
    public final zzby<Object> zza(Object obj) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // com.google.android.gms.internal.clearcut.zzbu
    public final int zza(Map.Entry<?, ?> entry) {
        throw Fragment$$ExternalSyntheticOutline1.m(entry);
    }

    public final void zza(Object obj, zzby<Object> zzbyVar) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }
}
