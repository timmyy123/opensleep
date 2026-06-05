package com.google.android.gms.internal.aicore;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzdx extends zzea {
    private final int zzc;

    public zzdx(byte[] bArr, int i, int i2) {
        super(bArr);
        zzeb.zzi(0, i2, bArr.length);
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.aicore.zzea, com.google.android.gms.internal.aicore.zzeb
    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return ((zzea) this).zza[i];
        }
        if (i < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(zzba$$ExternalSyntheticOutline0.m(i, "Index < 0: ", new StringBuilder(String.valueOf(i).length() + 11)));
            return (byte) 0;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$1(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(i).length() + 18 + String.valueOf(i2).length()), i, "Index > length: ", i2, ", "));
        return (byte) 0;
    }

    @Override // com.google.android.gms.internal.aicore.zzea, com.google.android.gms.internal.aicore.zzeb
    public final byte zzb(int i) {
        return ((zzea) this).zza[i];
    }

    @Override // com.google.android.gms.internal.aicore.zzea, com.google.android.gms.internal.aicore.zzeb
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.aicore.zzea
    public final int zzd() {
        return 0;
    }
}
