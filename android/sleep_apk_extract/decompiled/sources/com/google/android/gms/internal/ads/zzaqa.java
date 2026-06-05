package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaqa implements zzapt {
    private final zzaqw zza;
    private long zzf;
    private String zzh;
    private zzahk zzi;
    private zzapz zzj;
    private boolean zzk;
    private boolean zzm;
    private final String zzb = "video/mp2t";
    private final boolean[] zzg = new boolean[3];
    private final zzaqk zzc = new zzaqk(7, 128);
    private final zzaqk zzd = new zzaqk(8, 128);
    private final zzaqk zze = new zzaqk(6, 128);
    private long zzl = -9223372036854775807L;
    private final zzet zzn = new zzet();

    public zzaqa(zzaqw zzaqwVar, boolean z, boolean z2, String str) {
        this.zza = zzaqwVar;
    }

    private final void zzf(long j, int i, long j2) {
        if (!this.zzk) {
            this.zzc.zzc(i);
            this.zzd.zzc(i);
        }
        this.zze.zzc(i);
        this.zzj.zzd(j, i, j2, this.zzm);
    }

    private final void zzg(byte[] bArr, int i, int i2) {
        if (!this.zzk) {
            this.zzc.zzd(bArr, i, i2);
            this.zzd.zzd(bArr, i, i2);
        }
        this.zze.zzd(bArr, i, i2);
    }

    private final void zzh(long j, int i, int i2, long j2) {
        if (!this.zzk) {
            zzaqk zzaqkVar = this.zzc;
            zzaqkVar.zze(i2);
            zzaqk zzaqkVar2 = this.zzd;
            zzaqkVar2.zze(i2);
            if (this.zzk) {
                if (zzaqkVar.zzb()) {
                    zzgo zzgoVarZze = zzgp.zze(zzaqkVar.zza, 4, zzaqkVar.zzb);
                    this.zza.zzb(zzgoVarZze.zzm);
                    this.zzj.zza(zzgoVarZze);
                    zzaqkVar.zza();
                } else if (zzaqkVar2.zzb()) {
                    this.zzj.zzb(zzgp.zzh(zzaqkVar2.zza, 4, zzaqkVar2.zzb));
                    zzaqkVar2.zza();
                }
            } else if (zzaqkVar.zzb() && zzaqkVar2.zzb()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(zzaqkVar.zza, zzaqkVar.zzb));
                arrayList.add(Arrays.copyOf(zzaqkVar2.zza, zzaqkVar2.zzb));
                zzgo zzgoVarZze2 = zzgp.zze(zzaqkVar.zza, 4, zzaqkVar.zzb);
                zzgn zzgnVarZzh = zzgp.zzh(zzaqkVar2.zza, 4, zzaqkVar2.zzb);
                String strZzb = zzdq.zzb(zzgoVarZze2.zza, zzgoVarZze2.zzb, zzgoVarZze2.zzc);
                zzahk zzahkVar = this.zzi;
                zzt zztVar = new zzt();
                zztVar.zza(this.zzh);
                zztVar.zzn(this.zzb);
                zztVar.zzo("video/avc");
                zztVar.zzk(strZzb);
                zztVar.zzv(zzgoVarZze2.zze);
                zztVar.zzw(zzgoVarZze2.zzf);
                zzh zzhVar = new zzh();
                zzhVar.zza(zzgoVarZze2.zzj);
                zzhVar.zzb(zzgoVarZze2.zzk);
                zzhVar.zzc(zzgoVarZze2.zzl);
                zzhVar.zze(zzgoVarZze2.zzh + 8);
                zzhVar.zzf(zzgoVarZze2.zzi + 8);
                zztVar.zzE(zzhVar.zzg());
                zztVar.zzB(zzgoVarZze2.zzg);
                zztVar.zzr(arrayList);
                int i3 = zzgoVarZze2.zzm;
                zztVar.zzq(i3);
                zzahkVar.zzA(zztVar.zzO());
                this.zzk = true;
                this.zza.zzb(i3);
                this.zzj.zza(zzgoVarZze2);
                this.zzj.zzb(zzgnVarZzh);
                zzaqkVar.zza();
                zzaqkVar2.zza();
            }
        }
        zzaqk zzaqkVar3 = this.zze;
        if (zzaqkVar3.zze(i2)) {
            int iZza = zzgp.zza(zzaqkVar3.zza, zzaqkVar3.zzb);
            zzet zzetVar = this.zzn;
            zzetVar.zzb(zzaqkVar3.zza, iZza);
            zzetVar.zzh(4);
            this.zza.zzc(j2, zzetVar);
        }
        if (this.zzj.zze(j, i, this.zzk)) {
            this.zzm = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzf = 0L;
        this.zzm = false;
        this.zzl = -9223372036854775807L;
        zzgp.zzj(this.zzg);
        this.zzc.zza();
        this.zzd.zza();
        this.zze.zza();
        this.zza.zze();
        zzapz zzapzVar = this.zzj;
        if (zzapzVar != null) {
            zzapzVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzh = zzarhVar.zzc();
        zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 2);
        this.zzi = zzahkVarZzu;
        this.zzj = new zzapz(zzahkVarZzu, false, false);
        this.zza.zza(zzagbVar, zzarhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        this.zzl = j;
        int i2 = i & 2;
        this.zzm = (i2 != 0) | this.zzm;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    @Override // com.google.android.gms.internal.ads.zzapt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(zzet zzetVar) {
        int i;
        int i2;
        this.zzi.getClass();
        String str = zzfl.zza;
        int iZzg = zzetVar.zzg();
        int iZze = zzetVar.zze();
        byte[] bArrZzi = zzetVar.zzi();
        this.zzf += (long) zzetVar.zzd();
        this.zzi.zzc(zzetVar, zzetVar.zzd());
        while (true) {
            int iZzi = zzgp.zzi(bArrZzi, iZzg, iZze, this.zzg);
            if (iZzi == iZze) {
                zzg(bArrZzi, iZzg, iZze);
                return;
            }
            int i3 = bArrZzi[iZzi + 3] & 31;
            if (iZzi > 0) {
                int i4 = iZzi - 1;
                if (bArrZzi[i4] == 0) {
                    i2 = 4;
                    i = i4;
                } else {
                    i = iZzi;
                    i2 = 3;
                }
            }
            int i5 = i - iZzg;
            if (i5 > 0) {
                zzg(bArrZzi, iZzg, i);
            }
            int i6 = iZze - i;
            long j = this.zzf - ((long) i6);
            zzh(j, i6, i5 < 0 ? -i5 : 0, this.zzl);
            zzf(j, i3, this.zzl);
            iZzg = i + i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
        this.zzi.getClass();
        String str = zzfl.zza;
        if (z) {
            this.zza.zzd();
            zzh(this.zzf, 0, 0, this.zzl);
            zzf(this.zzf, 9, this.zzl);
            zzh(this.zzf, 0, 0, this.zzl);
        }
    }
}
