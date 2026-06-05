package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class zzapy implements zzapt {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzarl zzb;
    private zzapx zzg;
    private long zzh;
    private String zzi;
    private zzahk zzj;
    private boolean zzk;
    private final boolean[] zzd = new boolean[4];
    private final zzapw zze = new zzapw(128);
    private long zzl = -9223372036854775807L;
    private final zzaqk zzf = new zzaqk(178, 128);
    private final zzet zzc = new zzet();

    public zzapy(zzarl zzarlVar, String str) {
        this.zzb = zzarlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        zzgp.zzj(this.zzd);
        this.zze.zza();
        zzapx zzapxVar = this.zzg;
        if (zzapxVar != null) {
            zzapxVar.zza();
        }
        this.zzf.zza();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzi = zzarhVar.zzc();
        zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 2);
        this.zzj = zzahkVarZzu;
        this.zzg = new zzapx(zzahkVarZzu);
        this.zzb.zza(zzagbVar, zzarhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        this.zzl = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0185  */
    @Override // com.google.android.gms.internal.ads.zzapt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(zzet zzetVar) {
        int i;
        int i2;
        int i3;
        this.zzg.getClass();
        this.zzj.getClass();
        int iZzg = zzetVar.zzg();
        int iZze = zzetVar.zze();
        byte[] bArrZzi = zzetVar.zzi();
        this.zzh += (long) zzetVar.zzd();
        this.zzj.zzc(zzetVar, zzetVar.zzd());
        while (true) {
            int iZzi = zzgp.zzi(bArrZzi, iZzg, iZze, this.zzd);
            if (iZzi == iZze) {
                break;
            }
            int i4 = iZzi + 3;
            int i5 = zzetVar.zzi()[i4] & 255;
            int i6 = iZzi - iZzg;
            if (this.zzk) {
                i = iZze;
            } else {
                if (i6 > 0) {
                    this.zze.zzc(bArrZzi, iZzg, iZzi);
                }
                int i7 = i6 < 0 ? -i6 : 0;
                zzapw zzapwVar = this.zze;
                if (zzapwVar.zzb(i5, i7)) {
                    zzahk zzahkVar = this.zzj;
                    int i8 = zzapwVar.zzb;
                    String str = this.zzi;
                    str.getClass();
                    byte[] bArrCopyOf = Arrays.copyOf(zzapwVar.zzc, zzapwVar.zza);
                    zzes zzesVar = new zzes(bArrCopyOf, bArrCopyOf.length);
                    zzesVar.zzo(i8);
                    zzesVar.zzo(4);
                    zzesVar.zzg();
                    zzesVar.zzh(8);
                    if (zzesVar.zzi()) {
                        zzesVar.zzh(4);
                        zzesVar.zzh(3);
                    }
                    int iZzj = zzesVar.zzj(4);
                    float f = 1.0f;
                    i = iZze;
                    if (iZzj == 15) {
                        int iZzj2 = zzesVar.zzj(8);
                        int iZzj3 = zzesVar.zzj(8);
                        if (iZzj3 == 0) {
                            zzeg.zzc("H263Reader", "Invalid aspect ratio");
                        } else {
                            f = iZzj2 / iZzj3;
                        }
                    } else if (iZzj < 7) {
                        f = zza[iZzj];
                    } else {
                        zzeg.zzc("H263Reader", "Invalid aspect ratio");
                    }
                    float f2 = f;
                    if (zzesVar.zzi()) {
                        zzesVar.zzh(2);
                        zzesVar.zzh(1);
                        if (zzesVar.zzi()) {
                            zzesVar.zzh(15);
                            zzesVar.zzg();
                            zzesVar.zzh(15);
                            zzesVar.zzg();
                            zzesVar.zzh(15);
                            zzesVar.zzg();
                            zzesVar.zzh(3);
                            zzesVar.zzh(11);
                            zzesVar.zzg();
                            zzesVar.zzh(15);
                            zzesVar.zzg();
                            i3 = 2;
                        } else {
                            i3 = 2;
                        }
                        if (zzesVar.zzj(i3) != 0) {
                            zzeg.zzc("H263Reader", "Unhandled video object layer shape");
                        }
                        zzesVar.zzg();
                        int iZzj4 = zzesVar.zzj(16);
                        zzesVar.zzg();
                        if (zzesVar.zzi()) {
                            if (iZzj4 == 0) {
                                zzeg.zzc("H263Reader", "Invalid vop_increment_time_resolution");
                            } else {
                                int i9 = iZzj4 - 1;
                                int i10 = 0;
                                while (i9 > 0) {
                                    i9 >>= 1;
                                    i10++;
                                }
                                zzesVar.zzh(i10);
                            }
                        }
                        zzesVar.zzg();
                        int iZzj5 = zzesVar.zzj(13);
                        zzesVar.zzg();
                        int iZzj6 = zzesVar.zzj(13);
                        zzesVar.zzg();
                        zzesVar.zzg();
                        zzt zztVar = new zzt();
                        zztVar.zza(str);
                        zztVar.zzn("video/mp2t");
                        zztVar.zzo("video/mp4v-es");
                        zztVar.zzv(iZzj5);
                        zztVar.zzw(iZzj6);
                        zztVar.zzB(f2);
                        zztVar.zzr(Collections.singletonList(bArrCopyOf));
                        zzahkVar.zzA(zztVar.zzO());
                        this.zzk = true;
                    }
                }
            }
            this.zzg.zzc(bArrZzi, iZzg, iZzi);
            zzaqk zzaqkVar = this.zzf;
            if (i6 > 0) {
                zzaqkVar.zzd(bArrZzi, iZzg, iZzi);
                i2 = 0;
            } else {
                i2 = -i6;
            }
            if (zzaqkVar.zze(i2)) {
                int iZza = zzgp.zza(zzaqkVar.zza, zzaqkVar.zzb);
                zzet zzetVar2 = this.zzc;
                String str2 = zzfl.zza;
                zzetVar2.zzb(zzaqkVar.zza, iZza);
                this.zzb.zzb(this.zzl, zzetVar2);
            }
            if (i5 == 178) {
                if (zzetVar.zzi()[iZzi + 2] == 1) {
                    zzaqkVar.zzc(178);
                }
                i5 = 178;
            }
            int i11 = i - iZzi;
            this.zzg.zzd(this.zzh - ((long) i11), i11, this.zzk);
            this.zzg.zzb(i5, this.zzl);
            iZzg = i4;
            iZze = i;
        }
        if (!this.zzk) {
            this.zze.zzc(bArrZzi, iZzg, iZze);
        }
        this.zzg.zzc(bArrZzi, iZzg, iZze);
        this.zzf.zzd(bArrZzi, iZzg, iZze);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
        zzapx zzapxVar = this.zzg;
        zzapxVar.getClass();
        if (z) {
            zzapxVar.zzd(this.zzh, 0, this.zzk);
            this.zzg.zza();
        }
    }
}
