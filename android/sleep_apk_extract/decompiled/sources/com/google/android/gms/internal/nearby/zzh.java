package com.google.android.gms.internal.nearby;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzh extends zzj {
    private final String zzb;
    private final int zzc;

    public /* synthetic */ zzh(String str, boolean z, boolean z2, zzd zzdVar, zze zzeVar, int i, zzg zzgVar) {
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzj) {
            zzj zzjVar = (zzj) obj;
            if (this.zzb.equals(zzjVar.zzc())) {
                zzjVar.zzd();
                zzjVar.zze();
                zzjVar.zza();
                zzjVar.zzb();
                int i = this.zzc;
                int iZzf = zzjVar.zzf();
                if (i == 0) {
                    throw null;
                }
                if (iZzf == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() ^ 1000003;
        if (this.zzc != 0) {
            return (((((iHashCode * 1000003) ^ 1237) * 1000003) ^ 1237) * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m("FileComplianceOptions{fileOwner=", this.zzb, ", hasDifferentDmaOwner=false, skipChecks=false, dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=", this.zzc != 1 ? "null" : "READ_AND_WRITE", "}");
    }

    @Override // com.google.android.gms.internal.nearby.zzj
    public final zzd zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.nearby.zzj
    public final zze zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.nearby.zzj
    public final String zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzj
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzj
    public final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.internal.nearby.zzj
    public final int zzf() {
        return this.zzc;
    }
}
