package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhuu extends zzhxi {
    private final zzhus zza;
    private final zzhuq zzb;
    private final zzhur zzc;
    private final zzhut zzd;

    public /* synthetic */ zzhuu(zzhus zzhusVar, zzhuq zzhuqVar, zzhur zzhurVar, zzhut zzhutVar, byte[] bArr) {
        this.zza = zzhusVar;
        this.zzb = zzhuqVar;
        this.zzc = zzhurVar;
        this.zzd = zzhutVar;
    }

    public static zzhup zzb() {
        return new zzhup(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhuu)) {
            return false;
        }
        zzhuu zzhuuVar = (zzhuu) obj;
        return zzhuuVar.zza == this.zza && zzhuuVar.zzb == this.zzb && zzhuuVar.zzc == this.zzc && zzhuuVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzhuu.class, this.zza, this.zzb, this.zzc, this.zzd);
    }

    public final String toString() {
        String string = this.zzd.toString();
        int length = string.length();
        String string2 = this.zzc.toString();
        int length2 = string2.length();
        String string3 = this.zza.toString();
        int length3 = string3.length();
        String string4 = this.zzb.toString();
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 39, length2, 12, length3, 9, string4.length()) + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "ECDSA Parameters (variant: ", string, ", hashType: ", string2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", encoding: ", string3, ", curve: ", string4);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzd != zzhut.zzd;
    }

    public final zzhus zzc() {
        return this.zza;
    }

    public final zzhuq zzd() {
        return this.zzb;
    }

    public final zzhur zze() {
        return this.zzc;
    }

    public final zzhut zzf() {
        return this.zzd;
    }
}
