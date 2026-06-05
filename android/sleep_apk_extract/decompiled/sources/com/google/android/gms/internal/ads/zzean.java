package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzean extends zzear {
    private final long zza;
    private final int zzb;

    public /* synthetic */ zzean(long j, int i, byte[] bArr) {
        this.zza = j;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzear) {
            zzear zzearVar = (zzear) obj;
            if (this.zza == zzearVar.zza() && this.zzb == zzearVar.zzb()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.zza;
        return this.zzb ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }

    public final String toString() {
        long j = this.zza;
        int length = String.valueOf(j).length();
        int i = this.zzb;
        StringBuilder sb = new StringBuilder(length + 34 + String.valueOf(i).length() + 1);
        zzba$$ExternalSyntheticOutline0.m(sb, "OnDeviceStorageKey{id=", j, ", eventType=");
        return FileInsert$$ExternalSyntheticOutline0.m(i, "}", sb);
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final int zzb() {
        return this.zzb;
    }
}
