package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzaao extends zzaaq implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;

    public zzaao(int i, zzbg zzbgVar, int i2, zzaam zzaamVar, int i3, String str, String str2) {
        int iZzj;
        super(i, zzbgVar, i2);
        int i4 = 0;
        this.zzf = zznc.zzac(i3, false);
        int i5 = this.zzd.zze;
        int i6 = zzaamVar.zzC;
        this.zzg = 1 == (i5 & 1);
        this.zzh = (i5 & 2) != 0;
        zzgwm zzgwmVarZzj = str2 != null ? zzgwm.zzj(str2) : zzaamVar.zzy.isEmpty() ? zzgwm.zzj("") : zzaamVar.zzy;
        int i7 = 0;
        while (true) {
            if (i7 >= zzgwmVarZzj.size()) {
                iZzj = 0;
                i7 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj = zzaay.zzj(this.zzd, (String) zzgwmVarZzj.get(i7), false);
                if (iZzj > 0) {
                    break;
                } else {
                    i7++;
                }
            }
        }
        this.zzi = i7;
        this.zzj = iZzj;
        int iZzm = zzaay.zzm(this.zzd.zzf, str2 != null ? 1088 : 0);
        this.zzk = iZzm;
        zzv zzvVar = this.zzd;
        this.zzn = (1088 & zzvVar.zzf) != 0;
        int iZzn = zzaay.zzn(zzvVar, zzaamVar.zzz);
        this.zzl = iZzn;
        int iZzj2 = zzaay.zzj(this.zzd, str, zzaay.zzi(str) == null);
        this.zzm = iZzj2;
        boolean z = iZzj > 0 || (zzaamVar.zzy.isEmpty() && iZzm > 0) || ((zzaamVar.zzy.isEmpty() && iZzn != Integer.MAX_VALUE) || this.zzg || (this.zzh && iZzj2 > 0));
        if (zznc.zzac(i3, zzaamVar.zzV) && z) {
            i4 = 1;
        }
        this.zze = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final int zza() {
        return this.zze;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzaao zzaaoVar) {
        zzgvz zzgvzVarZza = zzgvz.zzg().zzd(this.zzf, zzaaoVar.zzf).zza(Integer.valueOf(this.zzi), Integer.valueOf(zzaaoVar.zzi), zzgyg.zzb().zza());
        int i = this.zzj;
        zzgvz zzgvzVarZzb = zzgvzVarZza.zzb(i, zzaaoVar.zzj);
        int i2 = this.zzk;
        zzgvz zzgvzVarZzb2 = zzgvzVarZzb.zzb(i2, zzaaoVar.zzk).zza(Integer.valueOf(this.zzl), Integer.valueOf(zzaaoVar.zzl), zzgyg.zzb().zza()).zzd(this.zzg, zzaaoVar.zzg).zza(Boolean.valueOf(this.zzh), Boolean.valueOf(zzaaoVar.zzh), i == 0 ? zzgyg.zzb() : zzgyg.zzb().zza()).zzb(this.zzm, zzaaoVar.zzm);
        if (i2 == 0) {
            zzgvzVarZzb2 = zzgvzVarZzb2.zzc(this.zzn, zzaaoVar.zzn);
        }
        return zzgvzVarZzb2.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* bridge */ /* synthetic */ boolean zzc(zzaaq zzaaqVar) {
        return false;
    }
}
