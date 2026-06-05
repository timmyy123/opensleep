package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfz {
    protected volatile int zzrs = -1;

    public static final void zza(zzfz zzfzVar, byte[] bArr, int i, int i2) {
        try {
            zzfs zzfsVarZzh = zzfs.zzh(bArr, 0, i2);
            zzfzVar.zza(zzfsVarZzh);
            zzfsVarZzh.zzem();
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m("Serializing to a byte array threw an IOException (should never happen).", (Throwable) e);
        }
    }

    public String toString() {
        return zzga.zza(this);
    }

    public abstract void zza(zzfs zzfsVar);

    public final int zzas() {
        int iZzen = zzen();
        this.zzrs = iZzen;
        return iZzen;
    }

    public abstract int zzen();

    public zzfz zzep() {
        return (zzfz) super.clone();
    }
}
