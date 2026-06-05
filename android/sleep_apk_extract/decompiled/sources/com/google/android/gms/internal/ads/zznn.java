package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zznn {
    public final long zza;
    public final zzbf zzb;
    public final int zzc;
    public final zzxk zzd;
    public final long zze;
    public final zzbf zzf;
    public final int zzg;
    public final zzxk zzh;
    public final long zzi;
    public final long zzj;

    public zznn(long j, zzbf zzbfVar, int i, zzxk zzxkVar, long j2, zzbf zzbfVar2, int i2, zzxk zzxkVar2, long j3, long j4) {
        this.zza = j;
        this.zzb = zzbfVar;
        this.zzc = i;
        this.zzd = zzxkVar;
        this.zze = j2;
        this.zzf = zzbfVar2;
        this.zzg = i2;
        this.zzh = zzxkVar2;
        this.zzi = j3;
        this.zzj = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznn.class == obj.getClass()) {
            zznn zznnVar = (zznn) obj;
            if (this.zza == zznnVar.zza && this.zzc == zznnVar.zzc && this.zze == zznnVar.zze && this.zzg == zznnVar.zzg && this.zzi == zznnVar.zzi && this.zzj == zznnVar.zzj && Objects.equals(this.zzb, zznnVar.zzb) && Objects.equals(this.zzd, zznnVar.zzd) && Objects.equals(this.zzf, zznnVar.zzf) && Objects.equals(this.zzh, zznnVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj));
    }
}
