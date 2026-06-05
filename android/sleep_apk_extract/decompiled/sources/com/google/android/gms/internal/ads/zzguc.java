package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
final class zzguc implements Serializable, zzgub {
    final zzgub zza;
    volatile transient boolean zzb;
    transient Object zzc;
    private final transient zzgui zzd = new zzgui();

    public zzguc(zzgub zzgubVar) {
        this.zza = zzgubVar;
    }

    public final String toString() {
        Object objM;
        if (this.zzb) {
            String strValueOf = String.valueOf(this.zzc);
            objM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strValueOf.length() + 25), "<supplier that returned ", strValueOf, ">");
        } else {
            objM = this.zza;
        }
        String string = objM.toString();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 19), "Suppliers.memoize(", string, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgub
    public final Object zza() {
        if (!this.zzb) {
            synchronized (this.zzd) {
                try {
                    if (!this.zzb) {
                        Object objZza = this.zza.zza();
                        this.zzc = objZza;
                        this.zzb = true;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.zzc;
    }
}
