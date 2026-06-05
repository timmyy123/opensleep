package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhib extends zzheu {
    private final zzhia zza;
    private final int zzb;

    private zzhib(zzhia zzhiaVar, int i) {
        this.zza = zzhiaVar;
        this.zzb = i;
    }

    public static zzhib zzb(zzhia zzhiaVar, int i) throws GeneralSecurityException {
        if (i >= 8 && i <= 12) {
            return new zzhib(zzhiaVar, i);
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Salt size must be between 8 and 12 bytes");
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhib)) {
            return false;
        }
        zzhib zzhibVar = (zzhib) obj;
        return zzhibVar.zza == this.zza && zzhibVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzhib.class, this.zza, Integer.valueOf(this.zzb));
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        int i = this.zzb;
        StringBuilder sb = new StringBuilder(length + 48 + String.valueOf(i).length() + 1);
        zzba$$ExternalSyntheticOutline0.m(sb, "X-AES-GCM Parameters (variant: ", string, "salt_size_bytes: ", i);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zza != zzhia.zzb;
    }

    public final zzhia zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }
}
