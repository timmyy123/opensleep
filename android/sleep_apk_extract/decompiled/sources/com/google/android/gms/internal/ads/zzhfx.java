package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhfx extends zzheu {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzhfw zzd;

    public /* synthetic */ zzhfx(int i, int i2, int i3, zzhfw zzhfwVar, byte[] bArr) {
        this.zza = i;
        this.zzd = zzhfwVar;
    }

    public static zzhfv zzb() {
        return new zzhfv(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhfx)) {
            return false;
        }
        zzhfx zzhfxVar = (zzhfx) obj;
        return zzhfxVar.zza == this.zza && zzhfxVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzhfx.class, Integer.valueOf(this.zza), 12, 16, this.zzd);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int length = strValueOf.length();
        int length2 = String.valueOf(12).length();
        int length3 = String.valueOf(16).length();
        int i = this.zza;
        StringBuilder sb = new StringBuilder(FileInsert$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(length, 30, length2, 10, length3), 15, String.valueOf(i).length(), 10));
        zzba$$ExternalSyntheticOutline0.m(sb, "AesGcm Parameters (variant: ", strValueOf, ", 12-byte IV, 16-byte tag, and ", i);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzd != zzhfw.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzhfw zzd() {
        return this.zzd;
    }
}
