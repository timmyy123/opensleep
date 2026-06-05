package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzxk {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    private zzxk(Object obj, int i, int i2, long j, int i3) {
        this.zza = obj;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzxk)) {
            return false;
        }
        zzxk zzxkVar = (zzxk) obj;
        return this.zza.equals(zzxkVar.zza) && this.zzb == zzxkVar.zzb && this.zzc == zzxkVar.zzc && this.zzd == zzxkVar.zzd && this.zze == zzxkVar.zze;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzxk zza(Object obj) {
        return this.zza.equals(obj) ? this : new zzxk(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }

    public zzxk(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    public zzxk(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public zzxk(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }
}
