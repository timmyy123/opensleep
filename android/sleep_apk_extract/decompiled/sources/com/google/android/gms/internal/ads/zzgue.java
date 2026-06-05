package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;

/* JADX INFO: loaded from: classes3.dex */
final class zzgue implements zzgub {
    private static final zzgub zzb = zzgud.zza;
    private final zzgui zza = new zzgui();
    private volatile zzgub zzc;
    private Object zzd;

    public zzgue(zzgub zzgubVar) {
        this.zzc = zzgubVar;
    }

    public final String toString() {
        Object objM = this.zzc;
        if (objM == zzb) {
            String strValueOf = String.valueOf(this.zzd);
            objM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strValueOf.length() + 25), "<supplier that returned ", strValueOf, ">");
        }
        String strValueOf2 = String.valueOf(objM);
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strValueOf2.length() + 19), "Suppliers.memoize(", strValueOf2, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgub
    public final Object zza() {
        zzgub zzgubVar = this.zzc;
        zzgub zzgubVar2 = zzb;
        if (zzgubVar != zzgubVar2) {
            synchronized (this.zza) {
                try {
                    if (this.zzc != zzgubVar2) {
                        Object objZza = this.zzc.zza();
                        this.zzd = objZza;
                        this.zzc = zzgubVar2;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.zzd;
    }
}
