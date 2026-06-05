package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzqs {
    public static final zzqs zza = new zzqr().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    public /* synthetic */ zzqs(zzqr zzqrVar, byte[] bArr) {
        this.zzb = zzqrVar.zze();
        this.zzc = zzqrVar.zzf();
        this.zzd = zzqrVar.zzg();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzqs.class == obj.getClass()) {
            zzqs zzqsVar = (zzqs) obj;
            if (this.zzb == zzqsVar.zzb && this.zzc == zzqsVar.zzc && this.zzd == zzqsVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return (z2 ? 1 : 0) + (z2 ? 1 : 0) + ((z ? 1 : 0) << 2) + (this.zzd ? 1 : 0);
    }
}
