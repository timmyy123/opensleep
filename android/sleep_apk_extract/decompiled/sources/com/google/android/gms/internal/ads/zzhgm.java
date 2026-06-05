package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhgm extends zzheu {
    private final zzhgl zza;

    private zzhgm(zzhgl zzhglVar) {
        this.zza = zzhglVar;
    }

    public static zzhgm zzb(zzhgl zzhglVar) {
        return new zzhgm(zzhglVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhgm) && ((zzhgm) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzhgm.class, this.zza);
    }

    public final String toString() {
        String string = this.zza.toString();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 39), "ChaCha20Poly1305 Parameters (variant: ", string, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zza != zzhgl.zzc;
    }

    public final zzhgl zzc() {
        return this.zza;
    }
}
