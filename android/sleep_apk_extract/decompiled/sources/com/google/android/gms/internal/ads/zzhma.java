package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhma extends zzheh {
    private final zzhnn zza;

    public zzhma(zzhnn zzhnnVar) {
        this.zza = zzhnnVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhma)) {
            return false;
        }
        zzhnn zzhnnVar = ((zzhma) obj).zza;
        zzhnn zzhnnVar2 = this.zza;
        return zzhnnVar2.zzc().zzc().equals(zzhnnVar.zzc().zzc()) && zzhnnVar2.zzc().zza().equals(zzhnnVar.zzc().zza()) && zzhnnVar2.zzc().zzb().equals(zzhnnVar.zzc().zzb());
    }

    public final int hashCode() {
        zzhnn zzhnnVar = this.zza;
        return Objects.hash(zzhnnVar.zzc(), zzhnnVar.zzf());
    }

    public final String toString() {
        zzhnn zzhnnVar = this.zza;
        String strZza = zzhnnVar.zzc().zza();
        int iOrdinal = zzhnnVar.zzc().zzc().ordinal();
        return FileInsert$$ExternalSyntheticOutline0.m("(typeUrl=", strZza, ", outputPrefixType=", iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK", ")");
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zza.zzc().zzc() != zzhtm.RAW;
    }

    public final zzhnn zzb() {
        return this.zza;
    }
}
