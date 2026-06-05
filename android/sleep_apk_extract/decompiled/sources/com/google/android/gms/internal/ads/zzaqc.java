package com.google.android.gms.internal.ads;

import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaqc implements zzapt {
    private final zzaqw zza;
    private String zzb;
    private zzahk zzc;
    private zzaqb zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzaqk zzg = new zzaqk(32, 128);
    private final zzaqk zzh = new zzaqk(33, 128);
    private final zzaqk zzi = new zzaqk(34, 128);
    private final zzaqk zzj = new zzaqk(39, 128);
    private final zzaqk zzk = new zzaqk(40, 128);
    private long zzm = -9223372036854775807L;
    private final zzet zzn = new zzet();

    public zzaqc(zzaqw zzaqwVar, String str) {
        this.zza = zzaqwVar;
    }

    private final void zzf(long j, int i, int i2, long j2) {
        this.zzd.zzb(j, i, i2, j2, this.zze);
        if (!this.zze) {
            this.zzg.zzc(i2);
            this.zzh.zzc(i2);
            this.zzi.zzc(i2);
        }
        this.zzj.zzc(i2);
        this.zzk.zzc(i2);
    }

    private final void zzg(byte[] bArr, int i, int i2) {
        this.zzd.zzc(bArr, i, i2);
        if (!this.zze) {
            this.zzg.zzd(bArr, i, i2);
            this.zzh.zzd(bArr, i, i2);
            this.zzi.zzd(bArr, i, i2);
        }
        this.zzj.zzd(bArr, i, i2);
        this.zzk.zzd(bArr, i, i2);
    }

    private final void zzh(long j, int i, int i2, long j2) {
        this.zzd.zzd(j, i, this.zze);
        if (!this.zze) {
            zzaqk zzaqkVar = this.zzg;
            zzaqkVar.zze(i2);
            zzaqk zzaqkVar2 = this.zzh;
            zzaqkVar2.zze(i2);
            zzaqk zzaqkVar3 = this.zzi;
            zzaqkVar3.zze(i2);
            if (zzaqkVar.zzb() && zzaqkVar2.zzb() && zzaqkVar3.zzb()) {
                String str = this.zzb;
                int i3 = zzaqkVar.zzb;
                byte[] bArr = new byte[zzaqkVar2.zzb + i3 + zzaqkVar3.zzb];
                System.arraycopy(zzaqkVar.zza, 0, bArr, 0, i3);
                System.arraycopy(zzaqkVar2.zza, 0, bArr, zzaqkVar.zzb, zzaqkVar2.zzb);
                System.arraycopy(zzaqkVar3.zza, 0, bArr, zzaqkVar.zzb + zzaqkVar2.zzb, zzaqkVar3.zzb);
                String strZzc = null;
                zzgj zzgjVarZzg = zzgp.zzg(zzaqkVar2.zza, 3, zzaqkVar2.zzb, null);
                zzge zzgeVar = zzgjVarZzg.zzb;
                if (zzgeVar != null) {
                    int i4 = zzgeVar.zzf;
                    int[] iArr = zzgeVar.zze;
                    int i5 = zzgeVar.zzd;
                    strZzc = zzdq.zzc(zzgeVar.zza, zzgeVar.zzb, zzgeVar.zzc, i5, iArr, i4);
                }
                zzt zztVar = new zzt();
                zztVar.zza(str);
                zztVar.zzn("video/mp2t");
                zztVar.zzo("video/hevc");
                zztVar.zzk(strZzc);
                zztVar.zzv(zzgjVarZzg.zze);
                zztVar.zzw(zzgjVarZzg.zzf);
                zztVar.zzx(zzgjVarZzg.zzg);
                zztVar.zzy(zzgjVarZzg.zzh);
                zzh zzhVar = new zzh();
                zzhVar.zza(zzgjVarZzg.zzk);
                zzhVar.zzb(zzgjVarZzg.zzl);
                zzhVar.zzc(zzgjVarZzg.zzm);
                zzhVar.zze(zzgjVarZzg.zzc + 8);
                zzhVar.zzf(zzgjVarZzg.zzd + 8);
                zztVar.zzE(zzhVar.zzg());
                zztVar.zzB(zzgjVarZzg.zzi);
                zztVar.zzq(zzgjVarZzg.zzj);
                zztVar.zzF(zzgjVarZzg.zza + 1);
                zztVar.zzr(Collections.singletonList(bArr));
                zzv zzvVarZzO = zztVar.zzO();
                this.zzc.zzA(zzvVarZzO);
                int i6 = zzvVarZzO.zzr;
                zzgtj.zzi(i6 != -1);
                this.zza.zzb(i6);
                this.zze = true;
            }
        }
        zzaqk zzaqkVar4 = this.zzj;
        if (zzaqkVar4.zze(i2)) {
            int iZza = zzgp.zza(zzaqkVar4.zza, zzaqkVar4.zzb);
            zzet zzetVar = this.zzn;
            zzetVar.zzb(zzaqkVar4.zza, iZza);
            zzetVar.zzk(5);
            this.zza.zzc(j2, zzetVar);
        }
        zzaqk zzaqkVar5 = this.zzk;
        if (zzaqkVar5.zze(i2)) {
            int iZza2 = zzgp.zza(zzaqkVar5.zza, zzaqkVar5.zzb);
            zzet zzetVar2 = this.zzn;
            zzetVar2.zzb(zzaqkVar5.zza, iZza2);
            zzetVar2.zzk(5);
            this.zza.zzc(j2, zzetVar2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzl = 0L;
        this.zzm = -9223372036854775807L;
        zzgp.zzj(this.zzf);
        this.zzg.zza();
        this.zzh.zza();
        this.zzi.zza();
        this.zzj.zza();
        this.zzk.zza();
        this.zza.zze();
        zzaqb zzaqbVar = this.zzd;
        if (zzaqbVar != null) {
            zzaqbVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzb = zzarhVar.zzc();
        zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 2);
        this.zzc = zzahkVarZzu;
        this.zzd = new zzaqb(zzahkVarZzu);
        this.zza.zza(zzagbVar, zzarhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) {
        this.zzc.getClass();
        String str = zzfl.zza;
        while (zzetVar.zzd() > 0) {
            int iZzg = zzetVar.zzg();
            int iZze = zzetVar.zze();
            byte[] bArrZzi = zzetVar.zzi();
            this.zzl += (long) zzetVar.zzd();
            this.zzc.zzc(zzetVar, zzetVar.zzd());
            while (iZzg < iZze) {
                int iZzi = zzgp.zzi(bArrZzi, iZzg, iZze, this.zzf);
                if (iZzi == iZze) {
                    zzg(bArrZzi, iZzg, iZze);
                    return;
                }
                int i = bArrZzi[iZzi + 3] & 126;
                int i2 = 3;
                if (iZzi > 0) {
                    int i3 = iZzi - 1;
                    if (bArrZzi[i3] == 0) {
                        i2 = 4;
                        iZzi = i3;
                    }
                }
                int i4 = iZzi - iZzg;
                if (i4 > 0) {
                    zzg(bArrZzi, iZzg, iZzi);
                }
                int i5 = iZze - iZzi;
                long j = this.zzl - ((long) i5);
                zzh(j, i5, i4 < 0 ? -i4 : 0, this.zzm);
                zzf(j, i5, i >> 1, this.zzm);
                iZzg = iZzi + i2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
        this.zzc.getClass();
        String str = zzfl.zza;
        if (z) {
            this.zza.zzd();
            zzh(this.zzl, 0, 0, this.zzm);
            zzf(this.zzl, 0, 48, this.zzm);
        }
    }
}
