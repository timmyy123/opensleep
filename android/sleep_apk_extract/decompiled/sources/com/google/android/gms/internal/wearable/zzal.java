package com.google.android.gms.internal.wearable;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;

/* JADX INFO: loaded from: classes4.dex */
final class zzal implements zzak {
    private final zzan zza = new zzan();
    private volatile zzak zzb;
    private Object zzc;

    public zzal(zzak zzakVar) {
        this.zzb = zzakVar;
    }

    public final String toString() {
        Object objM = this.zzb;
        if (objM == null) {
            String strValueOf = String.valueOf(this.zzc);
            objM = Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strValueOf.length() + 25), "<supplier that returned ", strValueOf, ">");
        }
        String string = objM.toString();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 19), "Suppliers.memoize(", string, ")");
    }
}
