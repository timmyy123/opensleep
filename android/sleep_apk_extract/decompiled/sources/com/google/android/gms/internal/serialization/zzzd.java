package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
final class zzzd implements zzyt<zzzd> {
    final zzzl zza;
    final int zzb;
    final zzace zzc;
    final boolean zzd;
    final boolean zze;

    public zzzd(zzzl zzzlVar, int i, zzace zzaceVar, boolean z, boolean z2) {
        this.zza = zzzlVar;
        this.zzb = i;
        this.zzc = zzaceVar;
        this.zzd = z;
        this.zze = z2;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zzb - ((zzzd) obj).zzb;
    }

    @Override // com.google.android.gms.internal.serialization.zzyt
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.serialization.zzyt
    public final zzace zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.serialization.zzyt
    public final zzacf zzc() {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.serialization.zzyt
    public final boolean zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.serialization.zzyt
    public final boolean zze() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.serialization.zzyt
    public final zzaap zzf(zzaap zzaapVar, zzaaq zzaaqVar) {
        return ((zzyy) zzaapVar).mergeFrom((zzzg) zzaaqVar);
    }
}
