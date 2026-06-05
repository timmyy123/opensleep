package com.google.android.gms.internal.measurement;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zznv extends zzqo {
    private final zznd zza;
    private final zzqr zzb;

    public zznv(zznd zzndVar, zzqr zzqrVar) {
        this.zza = zzndVar;
        this.zzb = zzqrVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzqo) {
            zzqo zzqoVar = (zzqo) obj;
            zznd zzndVar = this.zza;
            if (zzndVar != null ? zzndVar == zzqoVar.zza() : zzqoVar.zza() == null) {
                if (this.zzb.equals(zzqoVar.zzb())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        zznd zzndVar = this.zza;
        return this.zzb.hashCode() ^ (((zzndVar == null ? 0 : zzndVar.hashCode()) ^ 1000003) * 1000003);
    }

    public final String toString() {
        zzqr zzqrVar = this.zzb;
        String strValueOf = String.valueOf(this.zza);
        String string = zzqrVar.toString();
        StringBuilder sb = new StringBuilder(strValueOf.length() + 52 + string.length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "SnapshotBlobAndResult{snapshotBlob=", strValueOf, ", snapshotResult=", string);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzqo
    public final zznd zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzqo
    public final zzqr zzb() {
        return this.zzb;
    }
}
