package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhhg extends zzheu {
    private final zzhhf zza;
    private final String zzb;
    private final zzhhe zzc;
    private final zzheu zzd;

    public /* synthetic */ zzhhg(zzhhf zzhhfVar, String str, zzhhe zzhheVar, zzheu zzheuVar, byte[] bArr) {
        this.zza = zzhhfVar;
        this.zzb = str;
        this.zzc = zzhheVar;
        this.zzd = zzheuVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhhg)) {
            return false;
        }
        zzhhg zzhhgVar = (zzhhg) obj;
        return zzhhgVar.zzc.equals(this.zzc) && zzhhgVar.zzd.equals(this.zzd) && zzhhgVar.zzb.equals(this.zzb) && zzhhgVar.zza.equals(this.zza);
    }

    public final int hashCode() {
        return Objects.hash(zzhhg.class, this.zzb, this.zzc, this.zzd, this.zza);
    }

    public final String toString() {
        zzhhf zzhhfVar = this.zza;
        zzheu zzheuVar = this.zzd;
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(zzheuVar);
        String strValueOf3 = String.valueOf(zzhhfVar);
        String str = this.zzb;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(String.valueOf(str).length(), 64, strValueOf.length(), 27, strValueOf2.length(), 11, strValueOf3.length()) + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "LegacyKmsEnvelopeAead Parameters (kekUri: ", str, ", dekParsingStrategy: ", strValueOf);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", dekParametersForNewKeys: ", strValueOf2, ", variant: ", strValueOf3);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zza != zzhhf.zzb;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final zzhhf zzc() {
        return this.zza;
    }

    public final zzheu zzd() {
        return this.zzd;
    }
}
