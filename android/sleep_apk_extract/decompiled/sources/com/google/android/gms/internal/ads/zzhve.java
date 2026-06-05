package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhve extends zzhxi {
    private final zzhvd zza;

    private zzhve(zzhvd zzhvdVar) {
        this.zza = zzhvdVar;
    }

    public static zzhve zzb(zzhvd zzhvdVar) {
        return new zzhve(zzhvdVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhve) && ((zzhve) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzhve.class, this.zza);
    }

    public final String toString() {
        String string = this.zza.toString();
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 30), "Ed25519 Parameters (variant: ", string, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zza != zzhvd.zzd;
    }

    public final zzhvd zzc() {
        return this.zza;
    }
}
