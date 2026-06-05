package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzec {
    public final Object zza;
    private zzr zzb = new zzr();
    private boolean zzc;
    private boolean zzd;

    public zzec(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzec.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzec) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(int i, zzea zzeaVar) {
        if (this.zzd) {
            return;
        }
        if (i != -1) {
            this.zzb.zza(i);
        }
        this.zzc = true;
        zzeaVar.zza(this.zza);
    }

    public final void zzb(zzeb zzebVar) {
        if (this.zzd || !this.zzc) {
            return;
        }
        zzs zzsVarZzb = this.zzb.zzb();
        this.zzb = new zzr();
        this.zzc = false;
        zzebVar.zza(this.zza, zzsVarZzb);
    }

    public final /* synthetic */ void zzc(zzeb zzebVar) {
        this.zzd = true;
        if (zzebVar == null || !this.zzc) {
            return;
        }
        this.zzc = false;
        zzebVar.zza(this.zza, this.zzb.zzb());
    }
}
