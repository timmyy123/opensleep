package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzgqu extends zzgrv {
    private final int zza;
    private final String zzb;
    private final int zzc;

    public /* synthetic */ zzgqu(int i, String str, int i2, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = i2;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgrv) {
            zzgrv zzgrvVar = (zzgrv) obj;
            if (this.zza == zzgrvVar.zza() && ((str = this.zzb) != null ? str.equals(zzgrvVar.zzb()) : zzgrvVar.zzb() == null) && this.zzc == zzgrvVar.zzc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return this.zzc ^ (((str == null ? 0 : str.hashCode()) ^ ((this.zza ^ 1000003) * 1000003)) * 1000003);
    }

    public final String toString() {
        int i = this.zza;
        int length = String.valueOf(i).length();
        String str = this.zzb;
        int length2 = String.valueOf(str).length();
        int i2 = this.zzc;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 46, length2, 9, String.valueOf(i2).length()) + 1);
        zzba$$ExternalSyntheticOutline0.m(sb, "OverlayDisplayState{statusCode=", i, ", sessionToken=", str);
        return zzba$$ExternalSyntheticOutline0.m(sb, ", uiMode=", i2, "}");
    }

    @Override // com.google.android.gms.internal.ads.zzgrv
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgrv
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgrv
    public final int zzc() {
        return this.zzc;
    }
}
