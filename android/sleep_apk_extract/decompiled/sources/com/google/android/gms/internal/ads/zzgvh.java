package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgvh extends zzgyg implements Serializable {
    final zzgta zza;
    final zzgyg zzb;

    public zzgvh(zzgta zzgtaVar, zzgyg zzgygVar) {
        this.zza = zzgtaVar;
        this.zzb = zzgygVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyg, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzgta zzgtaVar = this.zza;
        return this.zzb.compare(zzgtaVar.apply(obj), zzgtaVar.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgvh) {
            zzgvh zzgvhVar = (zzgvh) obj;
            if (this.zza.equals(zzgvhVar.zza) && this.zzb.equals(zzgvhVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        String string = this.zzb.toString();
        int length = string.length();
        String string2 = this.zza.toString();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(length + 12 + string2.length() + 1), string, ".onResultOf(", string2, ")");
    }
}
