package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzre {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final boolean zzd = false;
    public final int zze;
    public final zzd zzf;
    public final int zzg;
    public final int zzh;

    public /* synthetic */ zzre(zzrd zzrdVar, byte[] bArr) {
        this.zza = zzrdVar.zzi();
        this.zzb = zzrdVar.zzj();
        this.zzc = zzrdVar.zzk();
        this.zze = zzrdVar.zzl();
        this.zzf = zzrdVar.zzm();
        this.zzg = zzrdVar.zzn();
        this.zzh = zzrdVar.zzo();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzre.class == obj.getClass()) {
            zzre zzreVar = (zzre) obj;
            if (this.zza == zzreVar.zza && this.zzb == zzreVar.zzb && this.zzc == zzreVar.zzc && this.zze == zzreVar.zze && this.zzg == zzreVar.zzg && this.zzh == zzreVar.zzh && this.zzf.equals(zzreVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer numValueOf = Integer.valueOf(this.zza);
        Integer numValueOf2 = Integer.valueOf(this.zzb);
        Integer numValueOf3 = Integer.valueOf(this.zzc);
        Boolean bool = Boolean.FALSE;
        return Objects.hash(numValueOf, numValueOf2, numValueOf3, bool, bool, Integer.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), Integer.valueOf(this.zzh), bool, bool);
    }
}
