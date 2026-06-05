package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzaak implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzaak(zzv zzvVar, int i) {
        this.zza = 1 == (zzvVar.zze & 1);
        this.zzb = zznc.zzac(i, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzaak zzaakVar) {
        return zzgvz.zzg().zzd(this.zzb, zzaakVar.zzb).zzd(this.zza, zzaakVar.zza).zze();
    }
}
