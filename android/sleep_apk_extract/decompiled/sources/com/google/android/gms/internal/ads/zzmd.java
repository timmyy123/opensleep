package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzmd {
    public final zzxk zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final long zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final boolean zzj;
    public final boolean zzk;

    public zzmd(zzxk zzxkVar, long j, long j2, long j3, long j4, long j5, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6 = true;
        zzgtj.zza(!z5 || z3);
        if (z4 && !z3) {
            z6 = false;
        }
        zzgtj.zza(z6);
        this.zza = zzxkVar;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzf = j5;
        this.zzg = false;
        this.zzh = false;
        this.zzi = z3;
        this.zzj = z4;
        this.zzk = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmd.class == obj.getClass()) {
            zzmd zzmdVar = (zzmd) obj;
            if (this.zzb == zzmdVar.zzb && this.zzd == zzmdVar.zzd && this.zze == zzmdVar.zze && this.zzf == zzmdVar.zzf && this.zzi == zzmdVar.zzi && this.zzj == zzmdVar.zzj && this.zzk == zzmdVar.zzk && Objects.equals(this.zza, zzmdVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + 527;
        long j = this.zzf;
        long j2 = this.zze;
        return (((((((((((((iHashCode * 31) + ((int) this.zzb)) * 31) + ((int) this.zzd)) * 31) + ((int) j2)) * 31) + ((int) j)) * 29791) + (this.zzi ? 1 : 0)) * 31) + (this.zzj ? 1 : 0)) * 31) + (this.zzk ? 1 : 0);
    }

    public final zzmd zza(long j, long j2) {
        return (j == this.zzb && j2 == this.zzc) ? this : new zzmd(this.zza, j, j2, this.zzd, this.zze, this.zzf, false, false, this.zzi, this.zzj, this.zzk);
    }

    public final zzmd zzb(long j) {
        return j == this.zzd ? this : new zzmd(this.zza, this.zzb, this.zzc, j, this.zze, this.zzf, false, false, this.zzi, this.zzj, this.zzk);
    }
}
