package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;

/* JADX INFO: loaded from: classes3.dex */
final class zzgto extends zzgth {
    private final Object zza;

    public zzgto(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgto) {
            return this.zza.equals(((zzgto) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String string = this.zza.toString();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 13), "Optional.of(", string, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgth
    public final Object zza(Object obj) {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgth
    public final zzgth zzb(zzgta zzgtaVar) {
        Object objApply = zzgtaVar.apply(this.zza);
        zzgtj.zzk(objApply, "the Function passed to Optional.transform() must not return null.");
        return new zzgto(objApply);
    }
}
