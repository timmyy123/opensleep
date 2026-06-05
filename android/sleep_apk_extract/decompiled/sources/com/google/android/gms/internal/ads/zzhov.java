package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhov extends zzhoy {
    private final int zza;
    private final int zzb;
    private final zzhou zzc;
    private final zzhot zzd;

    public /* synthetic */ zzhov(int i, int i2, zzhou zzhouVar, zzhot zzhotVar, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzhouVar;
        this.zzd = zzhotVar;
    }

    public static zzhos zzb() {
        return new zzhos(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhov)) {
            return false;
        }
        zzhov zzhovVar = (zzhov) obj;
        return zzhovVar.zza == this.zza && zzhovVar.zze() == zze() && zzhovVar.zzc == this.zzc && zzhovVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzhov.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        zzhot zzhotVar = this.zzd;
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(zzhotVar);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        int i = this.zzb;
        int length3 = String.valueOf(i).length();
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 38, length2, 2, length3, 16, String.valueOf(i2).length()) + 10);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "HMAC Parameters (variant: ", strValueOf, ", hashType: ", strValueOf2);
        Fragment$$ExternalSyntheticOutline1.m(sb, ", ", i, "-byte tags, and ", i2);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzc != zzhou.zzd;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        zzhou zzhouVar = this.zzc;
        if (zzhouVar == zzhou.zzd) {
            return this.zzb;
        }
        if (zzhouVar == zzhou.zza || zzhouVar == zzhou.zzb || zzhouVar == zzhou.zzc) {
            return this.zzb + 5;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown variant");
        return 0;
    }

    public final zzhou zzf() {
        return this.zzc;
    }

    public final zzhot zzg() {
        return this.zzd;
    }
}
