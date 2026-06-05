package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class zzapp implements zzapt {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final String zze;
    private final int zzf;
    private final String zzg;
    private String zzh;
    private zzahk zzi;
    private zzahk zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzr;
    private boolean zzs;
    private int zzu;
    private zzahk zzw;
    private long zzx;
    private final zzes zzc = new zzes(new byte[7], 7);
    private final zzet zzd = new zzet(Arrays.copyOf(zza, 10));
    private int zzp = -1;
    private int zzq = -1;
    private long zzt = -9223372036854775807L;
    private long zzv = -9223372036854775807L;

    public zzapp(boolean z, String str, int i, String str2) {
        this.zzb = z;
        this.zze = str;
        this.zzf = i;
        this.zzg = str2;
        zzi();
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzo = false;
        zzi();
    }

    private final boolean zzh(zzet zzetVar, byte[] bArr, int i) {
        int iMin = Math.min(zzetVar.zzd(), i - this.zzl);
        zzetVar.zzm(bArr, this.zzl, iMin);
        int i2 = this.zzl + iMin;
        this.zzl = i2;
        return i2 == i;
    }

    private final void zzi() {
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = 256;
    }

    private final void zzj(zzahk zzahkVar, long j, int i, int i2) {
        this.zzk = 4;
        this.zzl = i;
        this.zzw = zzahkVar;
        this.zzx = j;
        this.zzu = i2;
    }

    private final void zzk() {
        this.zzk = 3;
        this.zzl = 0;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | 65280);
    }

    private static final boolean zzm(zzet zzetVar, byte[] bArr, int i) {
        if (zzetVar.zzd() < i) {
            return false;
        }
        zzetVar.zzm(bArr, 0, i);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzv = -9223372036854775807L;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzh = zzarhVar.zzc();
        zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 1);
        this.zzi = zzahkVarZzu;
        this.zzw = zzahkVarZzu;
        if (!this.zzb) {
            this.zzj = new zzafv();
            return;
        }
        zzarhVar.zza();
        zzahk zzahkVarZzu2 = zzagbVar.zzu(zzarhVar.zzb(), 5);
        this.zzj = zzahkVarZzu2;
        zzt zztVar = new zzt();
        zztVar.zza(zzarhVar.zzc());
        zztVar.zzn(this.zzg);
        zztVar.zzo("application/id3");
        zzahkVarZzu2.zzA(zztVar.zzO());
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        this.zzv = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x025b, code lost:
    
        r18.zzk = 1;
        r18.zzl = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0261, code lost:
    
        zzk();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0264, code lost:
    
        r19.zzh(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0247, code lost:
    
        r18.zzr = (r14 & 8) >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0250, code lost:
    
        if (1 == ((r14 & 1) ^ 1)) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0252, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0254, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0255, code lost:
    
        r18.zzn = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0259, code lost:
    
        if (r18.zzo != false) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0247 A[EDGE_INSN: B:143:0x0247->B:94:0x0247 BREAK  A[LOOP:1: B:48:0x01a0->B:169:0x01a0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ff  */
    @Override // com.google.android.gms.internal.ads.zzapt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(zzet zzetVar) {
        char c;
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        this.zzi.getClass();
        String str = zzfl.zza;
        while (zzetVar.zzd() > 0) {
            int i6 = this.zzk;
            char c2 = 7;
            int i7 = 3;
            int i8 = 2;
            if (i6 == 0) {
                byte[] bArrZzi = zzetVar.zzi();
                int iZzg = zzetVar.zzg();
                int iZze = zzetVar.zze();
                while (true) {
                    if (iZzg >= iZze) {
                        zzetVar.zzh(iZzg);
                        break;
                    }
                    int i9 = iZzg + 1;
                    byte b = bArrZzi[iZzg];
                    int i10 = b & 255;
                    int i11 = i7;
                    if (this.zzm != 512 || !zzl((byte) -1, (byte) i10)) {
                        c = c2;
                    } else {
                        if (this.zzo) {
                            break;
                        }
                        int i12 = iZzg - 1;
                        zzetVar.zzh(iZzg);
                        zzes zzesVar = this.zzc;
                        if (zzm(zzetVar, zzesVar.zza, 1)) {
                            zzesVar.zzf(4);
                            int iZzj = zzesVar.zzj(1);
                            int i13 = this.zzp;
                            if (i13 == -1 || iZzj == i13) {
                                if (this.zzq == -1) {
                                    if (!zzm(zzetVar, zzesVar.zza, 4)) {
                                        zzesVar.zzf(14);
                                        int iZzj2 = zzesVar.zzj(13);
                                        c = 7;
                                        if (iZzj2 >= 7) {
                                            byte[] bArrZzi2 = zzetVar.zzi();
                                            int iZze2 = zzetVar.zze();
                                            int i14 = i12 + iZzj2;
                                            if (i14 < iZze2) {
                                                byte b2 = bArrZzi2[i14];
                                                if (b2 != -1) {
                                                    if (b2 == 73 && ((i4 = i14 + 1) == iZze2 || (bArrZzi2[i4] == 68 && ((i5 = i14 + 2) == iZze2 || bArrZzi2[i5] == 51)))) {
                                                        break;
                                                    }
                                                } else {
                                                    int i15 = i14 + 1;
                                                    if (i15 == iZze2) {
                                                        break;
                                                    }
                                                    byte b3 = bArrZzi2[i15];
                                                    if (zzl((byte) -1, b3) && ((b3 & 8) >> 3) == iZzj) {
                                                        break;
                                                    }
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    if (!zzm(zzetVar, zzesVar.zza, 1)) {
                                        break;
                                    }
                                    zzesVar.zzf(i8);
                                    if (zzesVar.zzj(4) == this.zzq) {
                                        zzetVar.zzh(iZzg + 1);
                                        if (!zzm(zzetVar, zzesVar.zza, 4)) {
                                        }
                                    }
                                    c = 7;
                                }
                            }
                        } else {
                            c = 7;
                        }
                    }
                    int i16 = this.zzm;
                    int i17 = i16 | i10;
                    if (i17 == 329) {
                        i = i11;
                        i2 = 2;
                        z = false;
                        i3 = 768;
                    } else if (i17 == 511) {
                        i = i11;
                        i2 = 2;
                        z = false;
                        i3 = 512;
                    } else if (i17 == 836) {
                        i = i11;
                        i2 = 2;
                        z = false;
                        i3 = 1024;
                    } else {
                        if (i17 == 1075) {
                            this.zzk = 2;
                            this.zzl = i11;
                            this.zzu = 0;
                            this.zzd.zzh(0);
                            zzetVar.zzh(i9);
                            break;
                        }
                        if (i16 != 256) {
                            this.zzm = 256;
                            c2 = c;
                            i7 = i11;
                            i8 = 2;
                        } else {
                            i = i11;
                            i2 = 2;
                            z = false;
                            iZzg = i9;
                            i7 = i;
                            c2 = c;
                            i8 = i2;
                        }
                    }
                    this.zzm = i3;
                    iZzg = i9;
                    i7 = i;
                    c2 = c;
                    i8 = i2;
                }
            } else if (i6 != 1) {
                if (i6 == 2) {
                    zzet zzetVar2 = this.zzd;
                    if (zzh(zzetVar, zzetVar2.zzi(), 10)) {
                        this.zzj.zzc(zzetVar2, 10);
                        zzetVar2.zzh(6);
                        zzj(this.zzj, 0L, 10, zzetVar2.zzG() + 10);
                    }
                } else if (i6 != 3) {
                    int iMin = Math.min(zzetVar.zzd(), this.zzu - this.zzl);
                    this.zzw.zzc(zzetVar, iMin);
                    int i18 = this.zzl + iMin;
                    this.zzl = i18;
                    if (i18 == this.zzu) {
                        zzgtj.zzi(this.zzv != -9223372036854775807L);
                        this.zzw.zze(this.zzv, 1, this.zzu, 0, null);
                        this.zzv += this.zzx;
                        zzi();
                    }
                } else {
                    int i19 = true != this.zzn ? 5 : 7;
                    zzes zzesVar2 = this.zzc;
                    if (zzh(zzetVar, zzesVar2.zza, i19)) {
                        zzesVar2.zzf(0);
                        if (this.zzs) {
                            zzesVar2.zzh(10);
                        } else {
                            int iZzj3 = zzesVar2.zzj(2) + 1;
                            if (iZzj3 != 2) {
                                StringBuilder sb = new StringBuilder(String.valueOf(iZzj3).length() + 50);
                                sb.append("Detected audio object type: ");
                                sb.append(iZzj3);
                                sb.append(", but assuming AAC LC.");
                                zzeg.zzc("AdtsReader", sb.toString());
                            }
                            zzesVar2.zzh(5);
                            int iZzj4 = zzesVar2.zzj(3);
                            int i20 = this.zzq;
                            byte[] bArr = {(byte) (((i20 >> 1) & 7) | 16), (byte) (((iZzj4 << 3) & 120) | ((i20 << 7) & 128))};
                            zzaev zzaevVarZza = zzaew.zza(bArr);
                            zzt zztVar = new zzt();
                            zztVar.zza(this.zzh);
                            zztVar.zzn(this.zzg);
                            zztVar.zzo("audio/mp4a-latm");
                            zztVar.zzk(zzaevVarZza.zzc);
                            zztVar.zzG(zzaevVarZza.zzb);
                            zztVar.zzH(zzaevVarZza.zza);
                            zztVar.zzr(Collections.singletonList(bArr));
                            zztVar.zze(this.zze);
                            zztVar.zzg(this.zzf);
                            zzv zzvVarZzO = zztVar.zzO();
                            this.zzt = 1024000000 / ((long) zzvVarZzO.zzI);
                            this.zzi.zzA(zzvVarZzO);
                            this.zzs = true;
                        }
                        zzesVar2.zzh(4);
                        int iZzj5 = zzesVar2.zzj(13);
                        int i21 = iZzj5 - 7;
                        if (this.zzn) {
                            i21 = iZzj5 - 9;
                        }
                        zzj(this.zzi, this.zzt, 0, i21);
                    }
                }
            } else if (zzetVar.zzd() != 0) {
                zzes zzesVar3 = this.zzc;
                zzesVar3.zza[0] = zzetVar.zzi()[zzetVar.zzg()];
                zzesVar3.zzf(2);
                int iZzj6 = zzesVar3.zzj(4);
                int i22 = this.zzq;
                if (i22 == -1 || iZzj6 == i22) {
                    if (!this.zzo) {
                        this.zzo = true;
                        this.zzp = this.zzr;
                        this.zzq = iZzj6;
                    }
                    zzk();
                } else {
                    zzg();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
    }
}
