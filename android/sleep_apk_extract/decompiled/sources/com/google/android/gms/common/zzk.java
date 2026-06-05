package com.google.android.gms.common;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class zzk extends zzj {
    private final byte[] zza;

    public zzk(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    @Override // com.google.android.gms.common.zzj
    public final byte[] zzc() {
        return this.zza;
    }
}
