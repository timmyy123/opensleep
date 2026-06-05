package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;

/* JADX INFO: loaded from: classes3.dex */
final class zzuk implements zzun {
    @Override // com.google.android.gms.internal.ads.zzun
    public final zzug zza(zzui zzuiVar, zzv zzvVar) {
        if (zzvVar.zzt == null) {
            return null;
        }
        return new zzuo(new zzuf(new zzup(1), AdError.MEDIAVIEW_MISSING_ERROR_CODE));
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final int zzb(zzv zzvVar) {
        return zzvVar.zzt != null ? 1 : 0;
    }
}
