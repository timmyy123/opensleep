package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzhly extends zzheh {
    private final String zza;
    private final zzhtm zzb;

    public /* synthetic */ zzhly(String str, zzhtm zzhtmVar, byte[] bArr) {
        this.zza = str;
        this.zzb = zzhtmVar;
    }

    public final String toString() {
        String str = this.zza;
        int iOrdinal = this.zzb.ordinal();
        return FileInsert$$ExternalSyntheticOutline0.m("(typeUrl=", str, ", outputPrefixType=", iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK", ")");
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzb != zzhtm.RAW;
    }
}
