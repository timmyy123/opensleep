package com.google.android.gms.internal.ads;

import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhzn {
    private final byte[] zza;
    private final byte[] zzb;

    private zzhzn(byte[] bArr, byte[] bArr2) {
        this.zza = bArr;
        this.zzb = bArr2;
    }

    public static zzhzn zzc() {
        byte[] bArrZza = zzhnp.zza(32);
        if (bArrZza.length == 32) {
            return new zzhzn(zzhlc.zza(zzhlc.zzb(bArrZza)), bArrZza);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Given secret seed length is not 32");
        return null;
    }

    public final byte[] zza() {
        return Arrays.copyOf(this.zza, 32);
    }

    public final byte[] zzb() {
        byte[] bArr = this.zzb;
        return Arrays.copyOf(bArr, bArr.length);
    }
}
