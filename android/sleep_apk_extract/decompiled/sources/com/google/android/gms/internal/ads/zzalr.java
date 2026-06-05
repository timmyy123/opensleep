package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class zzalr implements zzafy {
    private static final byte[] zza = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzv zzb;
    private zzalq zzC;
    private int zzD;
    private int zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzL;
    private boolean zzM;
    private final zzanj zzc;
    private final int zzd;
    private final List zze;
    private final byte[] zzj;
    private final zzet zzk;
    private int zzs;
    private int zzt;
    private long zzu;
    private int zzv;
    private zzet zzw;
    private long zzx;
    private int zzy;
    private final zzajb zzl = new zzajb();
    private final zzet zzm = new zzet(16);
    private final zzet zzg = new zzet(zzgp.zza);
    private final zzet zzh = new zzet(6);
    private final zzet zzi = new zzet();
    private final ArrayDeque zzn = new ArrayDeque();
    private final ArrayDeque zzo = new ArrayDeque();
    private final SparseArray zzf = new SparseArray();
    private zzgwm zzr = zzgwm.zzi();
    private long zzA = -9223372036854775807L;
    private long zzz = -9223372036854775807L;
    private long zzB = -9223372036854775807L;
    private zzagb zzI = zzagb.zza;
    private zzahk[] zzJ = new zzahk[0];
    private zzahk[] zzK = new zzahk[0];
    private final zzgz zzp = new zzgz(new zzgy() { // from class: com.google.android.gms.internal.ads.zzaln
        @Override // com.google.android.gms.internal.ads.zzgy
        public final /* synthetic */ void zza(long j, zzet zzetVar) {
            this.zza.zzh(j, zzetVar);
        }
    });
    private final zzafn zzq = new zzafn();
    private long zzN = -1;
    private long zzO = -1;

    static {
        zzt zztVar = new zzt();
        zztVar.zzo("application/x-emsg");
        zzb = zztVar.zzO();
    }

    public zzalr(zzanj zzanjVar, int i, zzfi zzfiVar, zzami zzamiVar, List list, zzahk zzahkVar) {
        this.zzc = zzanjVar;
        this.zzd = i;
        this.zze = Collections.unmodifiableList(list);
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzet(bArr);
    }

    private final void zzi() {
        this.zzs = 0;
        this.zzv = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:302:0x0753, code lost:
    
        zzi();
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0756, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0477  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzj(long j) throws zzat {
        zzap zzapVar;
        int i;
        List list;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        byte[] bArr;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z3;
        int iZzB;
        int i17;
        int iZzB2;
        int iZzB3;
        int i18;
        int iZzB4;
        boolean z4;
        long[] jArr;
        while (true) {
            ArrayDeque arrayDeque = this.zzn;
            if (arrayDeque.isEmpty() || ((zzfx) arrayDeque.peek()).zza != j) {
                break;
            }
            zzfx zzfxVar = (zzfx) arrayDeque.pop();
            int i19 = zzfxVar.zzd;
            int i20 = 12;
            int i21 = 8;
            if (i19 == 1836019574) {
                zzq zzqVarZzn = zzn(zzfxVar.zzb);
                zzfx zzfxVarZzd = zzfxVar.zzd(1836475768);
                zzfxVarZzd.getClass();
                SparseArray sparseArray = new SparseArray();
                List list2 = zzfxVarZzd.zzb;
                int size = list2.size();
                int i22 = 0;
                long jZzz = -9223372036854775807L;
                while (i22 < size) {
                    zzfy zzfyVar = (zzfy) list2.get(i22);
                    int i23 = zzfyVar.zzd;
                    if (i23 == 1953654136) {
                        zzet zzetVar = zzfyVar.zza;
                        zzetVar.zzh(i20);
                        Pair pairCreate = Pair.create(Integer.valueOf(zzetVar.zzB()), new zzalk(zzetVar.zzB() - 1, zzetVar.zzB(), zzetVar.zzB(), zzetVar.zzB()));
                        sparseArray.put(((Integer) pairCreate.first).intValue(), (zzalk) pairCreate.second);
                    } else if (i23 == 1835362404) {
                        zzet zzetVar2 = zzfyVar.zza;
                        zzetVar2.zzh(8);
                        jZzz = zzalj.zza(zzetVar2.zzB()) == 0 ? zzetVar2.zzz() : zzetVar2.zzJ();
                    }
                    i22++;
                    i20 = 12;
                }
                zzfx zzfxVarZzd2 = zzfxVar.zzd(1835365473);
                zzap zzapVarZze = zzfxVarZzd2 != null ? zzalj.zze(zzfxVarZzd2) : null;
                zzagr zzagrVar = new zzagr();
                zzfy zzfyVarZzc = zzfxVar.zzc(1969517665);
                if (zzfyVarZzc != null) {
                    zzap zzapVarZzc = zzalj.zzc(zzfyVarZzc);
                    zzagrVar.zza(zzapVarZzc);
                    zzapVar = zzapVarZzc;
                } else {
                    zzapVar = null;
                }
                zzfy zzfyVarZzc2 = zzfxVar.zzc(1836476516);
                zzfyVarZzc2.getClass();
                zzap zzapVar2 = new zzap(-9223372036854775807L, zzalj.zzd(zzfyVarZzc2.zza));
                List listZzb = zzalj.zzb(zzfxVar, zzagrVar, jZzz, zzqVarZzn, (this.zzd & 16) != 0, false, new zzgta(this) { // from class: com.google.android.gms.internal.ads.zzall
                    @Override // com.google.android.gms.internal.ads.zzgta
                    public final /* synthetic */ Object apply(Object obj) {
                        return (zzami) obj;
                    }
                }, false);
                int size2 = listZzb.size();
                SparseArray sparseArray2 = this.zzf;
                if (sparseArray2.size() == 0) {
                    String strZza = zzalu.zza(listZzb);
                    int i24 = 0;
                    while (i24 < size2) {
                        zzaml zzamlVar = (zzaml) listZzb.get(i24);
                        zzami zzamiVar = zzamlVar.zza;
                        zzagb zzagbVar = this.zzI;
                        int i25 = zzamiVar.zzb;
                        zzahk zzahkVarZzu = zzagbVar.zzu(i24, i25);
                        int i26 = size2;
                        SparseArray sparseArray3 = sparseArray2;
                        long j2 = zzamiVar.zze;
                        zzahkVarZzu.zzO(j2);
                        int i27 = i24;
                        zzv zzvVar = zzamiVar.zzg;
                        zzt zztVarZza = zzvVar.zza();
                        zztVarZza.zzn(strZza);
                        zzalt.zzb(i25, zzagrVar, zztVarZza);
                        zzagr zzagrVar2 = zzagrVar;
                        zzalt.zza(i25, zzapVarZze, zztVarZza, zzvVar.zzl, zzapVar, zzapVar2);
                        int i28 = zzamiVar.zza;
                        sparseArray3.put(i28, new zzalq(zzahkVarZzu, zzamlVar, zzp(sparseArray, i28), zztVarZza.zzO()));
                        this.zzA = Math.max(this.zzA, j2);
                        i24 = i27 + 1;
                        sparseArray2 = sparseArray3;
                        size2 = i26;
                        zzagrVar = zzagrVar2;
                    }
                    this.zzI.zzv();
                } else {
                    zzgtj.zzi(sparseArray2.size() == size2);
                    for (int i29 = 0; i29 < size2; i29++) {
                        zzaml zzamlVar2 = (zzaml) listZzb.get(i29);
                        int i30 = zzamlVar2.zza.zza;
                        ((zzalq) sparseArray2.get(i30)).zza(zzamlVar2, zzp(sparseArray, i30));
                    }
                }
            } else {
                int i31 = 16;
                int i32 = 0;
                if (i19 == 1836019558) {
                    SparseArray sparseArray4 = this.zzf;
                    int i33 = this.zzd;
                    byte[] bArr2 = this.zzj;
                    List list3 = zzfxVar.zzc;
                    int size3 = list3.size();
                    int i34 = 0;
                    while (i34 < size3) {
                        zzfx zzfxVar2 = (zzfx) list3.get(i34);
                        if (zzfxVar2.zzd == 1953653094) {
                            zzfy zzfyVarZzc3 = zzfxVar2.zzc(1952868452);
                            zzfyVarZzc3.getClass();
                            zzet zzetVar3 = zzfyVarZzc3.zza;
                            zzetVar3.zzh(i21);
                            int iZzB5 = zzetVar3.zzB();
                            int i35 = zzalj.$r8$clinit;
                            zzalq zzalqVar = (zzalq) sparseArray4.get(zzetVar3.zzB());
                            if (zzalqVar == null) {
                                zzalqVar = null;
                            } else {
                                if ((iZzB5 & 1) != 0) {
                                    long jZzJ = zzetVar3.zzJ();
                                    zzamk zzamkVar = zzalqVar.zzb;
                                    zzamkVar.zzb = jZzJ;
                                    zzamkVar.zzc = jZzJ;
                                }
                                zzalk zzalkVar = zzalqVar.zze;
                                zzalqVar.zzb.zza = new zzalk((iZzB5 & 2) != 0 ? zzetVar3.zzB() - 1 : zzalkVar.zza, (iZzB5 & 8) != 0 ? zzetVar3.zzB() : zzalkVar.zzb, (iZzB5 & 16) != 0 ? zzetVar3.zzB() : zzalkVar.zzc, (iZzB5 & 32) != 0 ? zzetVar3.zzB() : zzalkVar.zzd);
                            }
                            if (zzalqVar == null) {
                                i = i33;
                                list = list3;
                                i2 = size3;
                                i3 = i34;
                                i5 = i31;
                                i6 = i32;
                                i4 = 8;
                                z = true;
                            } else {
                                zzamk zzamkVar2 = zzalqVar.zzb;
                                long j3 = zzamkVar2.zzp;
                                boolean z5 = zzamkVar2.zzq;
                                zzalqVar.zzc();
                                zzalqVar.zzl(true);
                                zzfy zzfyVarZzc4 = zzfxVar2.zzc(1952867444);
                                if (zzfyVarZzc4 == null || (i33 & 2) != 0) {
                                    zzamkVar2.zzp = j3;
                                    zzamkVar2.zzq = z5;
                                } else {
                                    zzet zzetVar4 = zzfyVarZzc4.zza;
                                    zzetVar4.zzh(8);
                                    zzamkVar2.zzp = zzalj.zza(zzetVar4.zzB()) == 1 ? zzetVar4.zzJ() : zzetVar4.zzz();
                                    zzamkVar2.zzq = true;
                                }
                                List list4 = zzfxVar2.zzb;
                                int size4 = list4.size();
                                i = i33;
                                int i36 = i32;
                                int i37 = i36;
                                int i38 = i37;
                                while (true) {
                                    i7 = 1953658222;
                                    if (i36 >= size4) {
                                        break;
                                    }
                                    List list5 = list3;
                                    zzfy zzfyVar2 = (zzfy) list4.get(i36);
                                    int i39 = size3;
                                    if (zzfyVar2.zzd == 1953658222) {
                                        zzet zzetVar5 = zzfyVar2.zza;
                                        zzetVar5.zzh(12);
                                        int iZzH = zzetVar5.zzH();
                                        if (iZzH > 0) {
                                            i38 += iZzH;
                                            i37++;
                                        }
                                    }
                                    i36++;
                                    size3 = i39;
                                    list3 = list5;
                                }
                                list = list3;
                                i2 = size3;
                                int i40 = i32;
                                zzalqVar.zzh = i40;
                                zzalqVar.zzg = i40;
                                zzalqVar.zzf = i40;
                                zzamkVar2.zzd = i37;
                                zzamkVar2.zze = i38;
                                if (zzamkVar2.zzg.length < i37) {
                                    zzamkVar2.zzf = new long[i37];
                                    zzamkVar2.zzg = new int[i37];
                                }
                                if (zzamkVar2.zzh.length < i38) {
                                    int i41 = (i38 * 125) / 100;
                                    zzamkVar2.zzh = new int[i41];
                                    zzamkVar2.zzi = new long[i41];
                                    zzamkVar2.zzj = new boolean[i41];
                                    zzamkVar2.zzl = new boolean[i41];
                                }
                                int i42 = 0;
                                int i43 = 0;
                                int i44 = 0;
                                while (true) {
                                    long j4 = 0;
                                    if (i42 >= size4) {
                                        break;
                                    }
                                    zzfy zzfyVar3 = (zzfy) list4.get(i42);
                                    if (zzfyVar3.zzd == i7) {
                                        int i45 = i43 + 1;
                                        zzet zzetVar6 = zzfyVar3.zza;
                                        zzetVar6.zzh(8);
                                        int iZzB6 = zzetVar6.zzB();
                                        i9 = i42;
                                        zzami zzamiVar2 = zzalqVar.zzd.zza;
                                        int i46 = i43;
                                        zzalk zzalkVar2 = zzamkVar2.zza;
                                        String str = zzfl.zza;
                                        i10 = i34;
                                        zzamkVar2.zzg[i46] = zzetVar6.zzH();
                                        long[] jArr2 = zzamkVar2.zzf;
                                        i11 = size4;
                                        int i47 = i44;
                                        long j5 = zzamkVar2.zzb;
                                        jArr2[i46] = j5;
                                        if ((iZzB6 & 1) != 0) {
                                            jArr2[i46] = j5 + ((long) zzetVar6.zzB());
                                        }
                                        boolean z6 = (iZzB6 & 4) != 0;
                                        int i48 = zzalkVar2.zzd;
                                        int iZzB7 = z6 ? zzetVar6.zzB() : i48;
                                        boolean z7 = z6;
                                        int i49 = iZzB6 & 256;
                                        int i50 = iZzB6 & 512;
                                        int i51 = iZzB6 & 1024;
                                        int i52 = iZzB6 & 2048;
                                        long[] jArr3 = zzamiVar2.zzi;
                                        if (jArr3 != null) {
                                            i12 = i51;
                                            if (jArr3.length == 1 && (jArr = zzamiVar2.zzj) != null) {
                                                long j6 = jArr3[0];
                                                if (j6 == 0) {
                                                    i13 = i48;
                                                    i14 = iZzB7;
                                                } else {
                                                    i13 = i48;
                                                    i14 = iZzB7;
                                                    long j7 = zzamiVar2.zzd;
                                                    RoundingMode roundingMode = RoundingMode.DOWN;
                                                    if (zzfl.zzv(j6, 1000000L, j7, roundingMode) + zzfl.zzv(jArr[0], 1000000L, zzamiVar2.zzc, roundingMode) >= zzamiVar2.zze) {
                                                    }
                                                }
                                                j4 = jArr[0];
                                            }
                                            int[] iArr = zzamkVar2.zzh;
                                            long[] jArr4 = zzamkVar2.zzi;
                                            boolean[] zArr = zzamkVar2.zzj;
                                            int i53 = i13;
                                            boolean z8 = (zzamiVar2.zzb == 2 || (i & 1) == 0) ? false : true;
                                            i15 = i47 + zzamkVar2.zzg[i46];
                                            long j8 = zzamiVar2.zzc;
                                            long j9 = zzamkVar2.zzp;
                                            i16 = i47;
                                            while (i16 < i15) {
                                                if (i49 != 0) {
                                                    z3 = z8;
                                                    iZzB = zzetVar6.zzB();
                                                } else {
                                                    z3 = z8;
                                                    iZzB = zzalkVar2.zzb;
                                                }
                                                zzk(iZzB);
                                                if (i50 != 0) {
                                                    i17 = i16;
                                                    iZzB2 = zzetVar6.zzB();
                                                } else {
                                                    i17 = i16;
                                                    iZzB2 = zzalkVar2.zzc;
                                                }
                                                zzk(iZzB2);
                                                if (i12 != 0) {
                                                    iZzB3 = zzetVar6.zzB();
                                                } else if (i17 != 0) {
                                                    iZzB3 = i53;
                                                } else if (z7) {
                                                    iZzB3 = i14;
                                                    i17 = 0;
                                                } else {
                                                    i17 = 0;
                                                    iZzB3 = i53;
                                                }
                                                if (i52 != 0) {
                                                    i18 = iZzB2;
                                                    iZzB4 = zzetVar6.zzB();
                                                } else {
                                                    i18 = iZzB2;
                                                    iZzB4 = 0;
                                                }
                                                zzalk zzalkVar3 = zzalkVar2;
                                                long jZzv = zzfl.zzv((((long) iZzB4) + j9) - j4, 1000000L, j8, RoundingMode.DOWN);
                                                jArr4[i17] = jZzv;
                                                if (!zzamkVar2.zzq) {
                                                    jArr4[i17] = jZzv + zzalqVar.zzd.zzi;
                                                }
                                                iArr[i17] = i18;
                                                if (((iZzB3 >> 16) & 1) != 0) {
                                                    z4 = false;
                                                } else if (!z3) {
                                                    z4 = true;
                                                } else if (i17 == 0) {
                                                    z4 = true;
                                                    i17 = 0;
                                                }
                                                zArr[i17] = z4;
                                                j9 += (long) iZzB;
                                                i16 = i17 + 1;
                                                z8 = z3;
                                                zzalkVar2 = zzalkVar3;
                                            }
                                            zzamkVar2.zzp = j9;
                                            i44 = i15;
                                            i43 = i45;
                                        } else {
                                            i12 = i51;
                                        }
                                        i13 = i48;
                                        i14 = iZzB7;
                                        int[] iArr2 = zzamkVar2.zzh;
                                        long[] jArr42 = zzamkVar2.zzi;
                                        boolean[] zArr2 = zzamkVar2.zzj;
                                        int i532 = i13;
                                        if (zzamiVar2.zzb == 2) {
                                            i15 = i47 + zzamkVar2.zzg[i46];
                                            long j82 = zzamiVar2.zzc;
                                            long j92 = zzamkVar2.zzp;
                                            i16 = i47;
                                            while (i16 < i15) {
                                            }
                                            zzamkVar2.zzp = j92;
                                            i44 = i15;
                                            i43 = i45;
                                        }
                                    } else {
                                        i9 = i42;
                                        i10 = i34;
                                        i11 = size4;
                                    }
                                    i42 = i9 + 1;
                                    i34 = i10;
                                    size4 = i11;
                                    i7 = 1953658222;
                                }
                                i3 = i34;
                                zzami zzamiVar3 = zzalqVar.zzd.zza;
                                zzalk zzalkVar4 = zzamkVar2.zza;
                                zzalkVar4.getClass();
                                zzamj zzamjVarZza = zzamiVar3.zza(zzalkVar4.zza);
                                zzfy zzfyVarZzc5 = zzfxVar2.zzc(1935763834);
                                if (zzfyVarZzc5 != null) {
                                    zzamjVarZza.getClass();
                                    int i54 = zzamjVarZza.zzd;
                                    zzet zzetVar7 = zzfyVarZzc5.zza;
                                    zzetVar7.zzh(8);
                                    if ((zzetVar7.zzB() & 1) == 1) {
                                        zzetVar7.zzk(8);
                                    }
                                    int iZzs = zzetVar7.zzs();
                                    int iZzH2 = zzetVar7.zzH();
                                    int i55 = zzamkVar2.zze;
                                    if (iZzH2 > i55) {
                                        throw zzat.zzb(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iZzH2).length() + 56 + String.valueOf(i55).length()), iZzH2, "Saiz sample count ", i55, " is greater than fragment sample count"), null);
                                    }
                                    if (iZzs == 0) {
                                        boolean[] zArr3 = zzamkVar2.zzl;
                                        i8 = 0;
                                        for (int i56 = 0; i56 < iZzH2; i56++) {
                                            int iZzs2 = zzetVar7.zzs();
                                            i8 += iZzs2;
                                            zArr3[i56] = iZzs2 > i54;
                                        }
                                        z2 = false;
                                    } else {
                                        boolean z9 = iZzs > i54;
                                        i8 = iZzs * iZzH2;
                                        z2 = false;
                                        Arrays.fill(zzamkVar2.zzl, 0, iZzH2, z9);
                                    }
                                    Arrays.fill(zzamkVar2.zzl, iZzH2, zzamkVar2.zze, z2);
                                    if (i8 > 0) {
                                        zzamkVar2.zza(i8);
                                    }
                                }
                                zzfy zzfyVarZzc6 = zzfxVar2.zzc(1935763823);
                                if (zzfyVarZzc6 != null) {
                                    zzet zzetVar8 = zzfyVarZzc6.zza;
                                    zzetVar8.zzh(8);
                                    int iZzB8 = zzetVar8.zzB();
                                    if ((iZzB8 & 1) == 1) {
                                        zzetVar8.zzk(8);
                                    }
                                    int iZzH3 = zzetVar8.zzH();
                                    if (iZzH3 != 1) {
                                        StringBuilder sb = new StringBuilder(String.valueOf(iZzH3).length() + 29);
                                        sb.append("Unexpected saio entry count: ");
                                        sb.append(iZzH3);
                                        throw zzat.zzb(sb.toString(), null);
                                    }
                                    zzamkVar2.zzc += zzalj.zza(iZzB8) == 0 ? zzetVar8.zzz() : zzetVar8.zzJ();
                                }
                                zzfy zzfyVarZzc7 = zzfxVar2.zzc(1936027235);
                                if (zzfyVarZzc7 != null) {
                                    zzl(zzfyVarZzc7.zza, 0, zzamkVar2);
                                }
                                String str2 = zzamjVarZza != null ? zzamjVarZza.zzb : null;
                                zzet zzetVar9 = null;
                                zzet zzetVar10 = null;
                                for (int i57 = 0; i57 < list4.size(); i57++) {
                                    zzfy zzfyVar4 = (zzfy) list4.get(i57);
                                    zzet zzetVar11 = zzfyVar4.zza;
                                    int i58 = zzfyVar4.zzd;
                                    if (i58 == 1935828848) {
                                        zzetVar11.zzh(12);
                                        if (zzetVar11.zzB() == 1936025959) {
                                            zzetVar9 = zzetVar11;
                                        }
                                    } else if (i58 == 1936158820) {
                                        zzetVar11.zzh(12);
                                        if (zzetVar11.zzB() == 1936025959) {
                                            zzetVar10 = zzetVar11;
                                        }
                                    }
                                }
                                if (zzetVar9 == null || zzetVar10 == null) {
                                    z = true;
                                } else {
                                    zzetVar9.zzh(8);
                                    int iZza = zzalj.zza(zzetVar9.zzB());
                                    zzetVar9.zzk(4);
                                    if (iZza == 1) {
                                        zzetVar9.zzk(4);
                                    }
                                    if (zzetVar9.zzB() != 1) {
                                        throw zzat.zzc("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    zzetVar10.zzh(8);
                                    int iZza2 = zzalj.zza(zzetVar10.zzB());
                                    zzetVar10.zzk(4);
                                    if (iZza2 == 1) {
                                        if (zzetVar10.zzz() == 0) {
                                            throw zzat.zzc("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iZza2 >= 2) {
                                        zzetVar10.zzk(4);
                                    }
                                    if (zzetVar10.zzz() != 1) {
                                        throw zzat.zzc("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    z = true;
                                    zzetVar10.zzk(1);
                                    int iZzs3 = zzetVar10.zzs();
                                    int i59 = (iZzs3 & 240) >> 4;
                                    int i60 = iZzs3 & 15;
                                    if (zzetVar10.zzs() == 1) {
                                        int iZzs4 = zzetVar10.zzs();
                                        int i61 = i31;
                                        byte[] bArr3 = new byte[i61];
                                        zzetVar10.zzm(bArr3, 0, i61);
                                        if (iZzs4 == 0) {
                                            int iZzs5 = zzetVar10.zzs();
                                            byte[] bArr4 = new byte[iZzs5];
                                            zzetVar10.zzm(bArr4, 0, iZzs5);
                                            bArr = bArr4;
                                        } else {
                                            bArr = null;
                                        }
                                        zzamkVar2.zzk = true;
                                        zzamkVar2.zzm = new zzamj(true, str2, iZzs4, bArr3, i59, i60, bArr);
                                    }
                                }
                                int size5 = list4.size();
                                for (int i62 = 0; i62 < size5; i62++) {
                                    zzfy zzfyVar5 = (zzfy) list4.get(i62);
                                    if (zzfyVar5.zzd == 1970628964) {
                                        zzet zzetVar12 = zzfyVar5.zza;
                                        zzetVar12.zzh(8);
                                        zzetVar12.zzm(bArr2, 0, 16);
                                        if (Arrays.equals(bArr2, zza)) {
                                            zzl(zzetVar12, 16, zzamkVar2);
                                        }
                                    }
                                }
                                i6 = 0;
                                i4 = 8;
                                i5 = 16;
                            }
                        } else {
                            i = i33;
                            list = list3;
                            i2 = size3;
                            i3 = i34;
                            i4 = i21;
                            z = z;
                            i5 = i31;
                            i6 = i32;
                        }
                        i34 = i3 + 1;
                        i32 = i6;
                        i21 = i4;
                        i31 = i5;
                        z = z;
                        i33 = i;
                        size3 = i2;
                        list3 = list;
                    }
                    int i63 = i32;
                    zzq zzqVarZzn2 = zzn(zzfxVar.zzb);
                    if (zzqVarZzn2 != null) {
                        int size6 = sparseArray4.size();
                        for (int i64 = i63; i64 < size6; i64++) {
                            ((zzalq) sparseArray4.valueAt(i64)).zzb(zzqVarZzn2);
                        }
                    }
                    if (this.zzz != -9223372036854775807L) {
                        int size7 = sparseArray4.size();
                        for (int i65 = i63; i65 < size7; i65++) {
                            zzalq zzalqVar2 = (zzalq) sparseArray4.valueAt(i65);
                            long j10 = this.zzz;
                            int i66 = zzalqVar2.zzf;
                            while (true) {
                                zzamk zzamkVar3 = zzalqVar2.zzb;
                                if (i66 >= zzamkVar3.zze || zzamkVar3.zzi[i66] > j10) {
                                    break;
                                }
                                if (zzamkVar3.zzj[i66]) {
                                    zzalqVar2.zzi = i66;
                                }
                                i66++;
                            }
                        }
                        this.zzz = -9223372036854775807L;
                    }
                } else if (!arrayDeque.isEmpty()) {
                    ((zzfx) arrayDeque.peek()).zzb(zzfxVar);
                }
            }
        }
    }

    private static int zzk(int i) throws zzat {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 27);
        sb.append("Unexpected negative value: ");
        sb.append(i);
        throw zzat.zzb(sb.toString(), null);
    }

    private static void zzl(zzet zzetVar, int i, zzamk zzamkVar) throws zzat {
        zzetVar.zzh(i + 8);
        int iZzB = zzetVar.zzB();
        int i2 = zzalj.$r8$clinit;
        if ((iZzB & 1) != 0) {
            throw zzat.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iZzB & 2) != 0;
        int iZzH = zzetVar.zzH();
        if (iZzH == 0) {
            Arrays.fill(zzamkVar.zzl, 0, zzamkVar.zze, false);
            return;
        }
        int i3 = zzamkVar.zze;
        if (iZzH != i3) {
            throw zzat.zzb(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iZzH).length() + 58 + String.valueOf(i3).length()), iZzH, "Senc sample count ", i3, " is different from fragment sample count"), null);
        }
        Arrays.fill(zzamkVar.zzl, 0, iZzH, z);
        zzamkVar.zza(zzetVar.zzd());
        zzet zzetVar2 = zzamkVar.zzn;
        zzetVar.zzm(zzetVar2.zzi(), 0, zzetVar2.zze());
        zzetVar2.zzh(0);
        zzamkVar.zzo = false;
    }

    private static Pair zzm(zzet zzetVar, long j) throws zzat {
        long jZzJ;
        long jZzJ2;
        zzet zzetVar2 = zzetVar;
        zzetVar2.zzh(8);
        int iZza = zzalj.zza(zzetVar2.zzB());
        zzetVar2.zzk(4);
        long jZzz = zzetVar2.zzz();
        if (iZza == 0) {
            jZzJ = zzetVar2.zzz();
            jZzJ2 = zzetVar2.zzz();
        } else {
            jZzJ = zzetVar2.zzJ();
            jZzJ2 = zzetVar2.zzJ();
        }
        long j2 = jZzJ2 + j;
        long jZzv = zzfl.zzv(jZzJ, 1000000L, jZzz, RoundingMode.DOWN);
        zzetVar2.zzk(2);
        int iZzt = zzetVar2.zzt();
        int[] iArr = new int[iZzt];
        long[] jArr = new long[iZzt];
        long[] jArr2 = new long[iZzt];
        long[] jArr3 = new long[iZzt];
        long j3 = j2;
        long j4 = jZzv;
        int i = 0;
        while (i < iZzt) {
            int iZzB = zzetVar2.zzB();
            if ((Integer.MIN_VALUE & iZzB) != 0) {
                throw zzat.zzb("Unhandled indirect reference", null);
            }
            long jZzz2 = zzetVar2.zzz();
            iArr[i] = iZzB & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            jZzJ += jZzz2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            long jZzv2 = zzfl.zzv(jZzJ, 1000000L, jZzz, RoundingMode.DOWN);
            jArr4[i] = jZzv2 - jArr5[i];
            zzetVar2.zzk(4);
            j3 += (long) iArr[i];
            i++;
            zzetVar2 = zzetVar;
            iZzt = iZzt;
            j4 = jZzv2;
            jArr2 = jArr4;
            jArr3 = jArr5;
        }
        return Pair.create(Long.valueOf(jZzv), new zzafm(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzq zzn(List list) {
        int i;
        UUID[] uuidArr;
        zzame zzameVar;
        UUID uuid;
        int size = list.size();
        int i2 = 0;
        ArrayList arrayList = null;
        while (i2 < size) {
            zzfy zzfyVar = (zzfy) list.get(i2);
            if (zzfyVar.zzd == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrZzi = zzfyVar.zza.zzi();
                zzet zzetVar = new zzet(bArrZzi);
                if (zzetVar.zze() < 32) {
                    i = i2;
                    zzameVar = null;
                    uuid = zzameVar != null ? null : zzameVar.zza;
                    if (uuid != null) {
                        zzeg.zzc("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                    } else {
                        arrayList.add(new zzp(uuid, null, "video/mp4", bArrZzi));
                    }
                } else {
                    zzetVar.zzh(0);
                    int iZzd = zzetVar.zzd();
                    int iZzB = zzetVar.zzB();
                    if (iZzB != iZzd) {
                        zzeg.zzc("PsshAtomUtil", zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iZzB).length() + 52 + String.valueOf(iZzd).length()), iZzB, "Advertised atom size (", iZzd, ") does not match buffer size: "));
                    } else {
                        int iZzB2 = zzetVar.zzB();
                        if (iZzB2 != 1886614376) {
                            zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(iZzB2).length() + 23), "Atom type is not pssh: ", iZzB2, "PsshAtomUtil");
                        } else {
                            int iZza = zzalj.zza(zzetVar.zzB());
                            if (iZza > 1) {
                                zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(iZza).length() + 26), "Unsupported pssh version: ", iZza, "PsshAtomUtil");
                            } else {
                                UUID uuid2 = new UUID(zzetVar.zzD(), zzetVar.zzD());
                                if (iZza == 1) {
                                    int iZzH = zzetVar.zzH();
                                    uuidArr = new UUID[iZzH];
                                    int i3 = 0;
                                    while (i3 < iZzH) {
                                        UUID[] uuidArr2 = uuidArr;
                                        int i4 = i3;
                                        uuidArr2[i4] = new UUID(zzetVar.zzD(), zzetVar.zzD());
                                        i3 = i4 + 1;
                                        i2 = i2;
                                        uuidArr = uuidArr2;
                                    }
                                } else {
                                    uuidArr = null;
                                }
                                i = i2;
                                int iZzH2 = zzetVar.zzH();
                                int iZzd2 = zzetVar.zzd();
                                if (iZzH2 != iZzd2) {
                                    zzeg.zzc("PsshAtomUtil", zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iZzH2).length() + 49 + String.valueOf(iZzd2).length()), iZzH2, "Atom data size (", iZzd2, ") does not match the bytes left: "));
                                    zzameVar = null;
                                    if (zzameVar != null) {
                                    }
                                    if (uuid != null) {
                                    }
                                } else {
                                    byte[] bArr = new byte[iZzH2];
                                    zzetVar.zzm(bArr, 0, iZzH2);
                                    zzameVar = new zzame(uuid2, iZza, bArr, uuidArr);
                                    if (zzameVar != null) {
                                    }
                                    if (uuid != null) {
                                    }
                                }
                            }
                        }
                    }
                    i = i2;
                    zzameVar = null;
                    if (zzameVar != null) {
                    }
                    if (uuid != null) {
                    }
                }
                i2 = i + 1;
            } else {
                i = i2;
            }
            i2 = i + 1;
        }
        if (arrayList == null) {
            return null;
        }
        return new zzq(arrayList);
    }

    private final void zzo(zzahb zzahbVar, zzagy zzagyVar) {
        this.zzI.zzw(zzahbVar);
        this.zzL = true;
        zzagyVar.zza = this.zzO;
        zzi();
    }

    private static final zzalk zzp(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzalk) sparseArray.valueAt(0);
        }
        zzalk zzalkVar = (zzalk) sparseArray.get(i);
        zzalkVar.getClass();
        return zzalkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) {
        zzahf zzahfVarZza = zzamh.zza(zzafzVar);
        this.zzr = zzahfVarZza != null ? zzgwm.zzj(zzahfVarZza) : zzgwm.zzi();
        return zzahfVarZza == null;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final /* synthetic */ List zzb() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        int i;
        int i2 = this.zzd;
        if ((i2 & 32) == 0) {
            zzagbVar = new zzanm(zzagbVar, this.zzc);
        }
        this.zzI = zzagbVar;
        zzi();
        zzahk[] zzahkVarArr = new zzahk[2];
        this.zzJ = zzahkVarArr;
        int i3 = 100;
        int i4 = 0;
        if ((i2 & 4) != 0) {
            zzahkVarArr[0] = this.zzI.zzu(100, 5);
            i = 1;
            i3 = 101;
        } else {
            i = 0;
        }
        zzahk[] zzahkVarArr2 = (zzahk[]) zzfl.zzb(this.zzJ, i);
        this.zzJ = zzahkVarArr2;
        for (zzahk zzahkVar : zzahkVarArr2) {
            zzahkVar.zzA(zzb);
        }
        List list = this.zze;
        this.zzK = new zzahk[list.size()];
        while (i4 < this.zzK.length) {
            zzahk zzahkVarZzu = this.zzI.zzu(i3, 3);
            zzahkVarZzu.zzA((zzv) list.get(i4));
            this.zzK[i4] = zzahkVarZzu;
            i4++;
            i3++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e5, code lost:
    
        if (r43.zzK.length <= 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e7, code lost:
    
        if (r4 <= 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ef, code lost:
    
        if (com.google.android.gms.internal.ads.zzgp.zzb(r2.zzg, r12, 4) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01f1, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f3, code lost:
    
        r6 = r7 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f4, code lost:
    
        r43.zzH = r6;
        r8.zzc(r11, r4);
        r43.zzE += r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01fe, code lost:
    
        if (r4 <= 0) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0202, code lost:
    
        if (r43.zzG != false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x020b, code lost:
    
        if (com.google.android.gms.internal.ads.zzgp.zzd(r12, 4, r4, r2.zzg) == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x020d, code lost:
    
        r43.zzG = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x021e, code lost:
    
        throw com.google.android.gms.internal.ads.zzat.zzb("Invalid NAL length", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0221, code lost:
    
        if (r43.zzH == false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0223, code lost:
    
        r6 = r43.zzi;
        r6.zza(r4);
        r44.zzc(r6.zzi(), r7 ? 1 : 0, r43.zzF);
        r8.zzc(r6, r43.zzF);
        r4 = r43.zzF;
        r14 = com.google.android.gms.internal.ads.zzgp.zza(r6.zzi(), r6.zze());
        r6.zzh(r7 ? 1 : 0);
        r6.zzf(r14);
        r14 = r2.zzg.zzr;
        r15 = r43.zzp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0251, code lost:
    
        if (r14 != (-1)) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0257, code lost:
    
        if (r15.zzb() == 0) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0259, code lost:
    
        r15.zza(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0262, code lost:
    
        if (r15.zzb() == r14) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0264, code lost:
    
        r15.zza(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0267, code lost:
    
        r7 = r43.zzp;
        r7.zzc(r9, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0274, code lost:
    
        if ((r3.zzg() & 4) == 0) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0276, code lost:
    
        r7.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x027a, code lost:
    
        r4 = r8.zza(r44, r4, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x027e, code lost:
    
        r43.zzE += r4;
        r43.zzF -= r4;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x028c, code lost:
    
        r1 = r3.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0292, code lost:
    
        if (r43.zzG != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0294, code lost:
    
        r1 = r1 | 67108864;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0297, code lost:
    
        r11 = r1;
        r1 = r3.zzj();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x029c, code lost:
    
        if (r1 == null) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x029e, code lost:
    
        r14 = r1.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02a2, code lost:
    
        r14 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02a3, code lost:
    
        r8.zze(r9, r11, r43.zzD, 0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02a9, code lost:
    
        r1 = r43.zzo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02af, code lost:
    
        if (r1.isEmpty() != false) goto L556;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02b1, code lost:
    
        r1 = (com.google.android.gms.internal.ads.zzalo) r1.removeFirst();
        r2 = r43.zzy;
        r15 = r1.zzc;
        r43.zzy = r2 - r15;
        r4 = r1.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02c2, code lost:
    
        if (r1.zzb == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02c4, code lost:
    
        r4 = r4 + r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02c5, code lost:
    
        r12 = r4;
        r1 = r43.zzJ;
        r2 = r1.length;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02ca, code lost:
    
        if (r4 >= r2) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02cc, code lost:
    
        r1[r4].zze(r12, 1, r15, r43.zzy, null);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02df, code lost:
    
        if (r3.zzh() != false) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02e1, code lost:
    
        r43.zzC = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02e4, code lost:
    
        r43.zzs = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02e8, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x07f9, code lost:
    
        throw com.google.android.gms.internal.ads.zzat.zzc("Atom size less than header length (unsupported).");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b2, code lost:
    
        if (r43.zzs != 3) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b4, code lost:
    
        r43.zzD = r3.zzf();
        r2 = r3.zzd.zza.zzg.zzp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c8, code lost:
    
        if (java.util.Objects.equals(r2, "video/avc") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ce, code lost:
    
        if ((r43.zzd & 64) == 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d0, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d2, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00da, code lost:
    
        if (java.util.Objects.equals(r2, "video/hevc") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e0, code lost:
    
        if ((r43.zzd & 128) == 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e3, code lost:
    
        r43.zzG = !r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ea, code lost:
    
        if (r3.zzf >= r3.zzi) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ec, code lost:
    
        r44.zzf(r43.zzD);
        r1 = r3.zzj();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f5, code lost:
    
        if (r1 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f8, code lost:
    
        r2 = r3.zzb;
        r5 = r2.zzn;
        r1 = r1.zzd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fe, code lost:
    
        if (r1 == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0100, code lost:
    
        r5.zzk(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0109, code lost:
    
        if (r2.zzb(r3.zzf) == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010b, code lost:
    
        r5.zzk(r5.zzt() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0118, code lost:
    
        if (r3.zzh() != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011a, code lost:
    
        r43.zzC = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x011c, code lost:
    
        r43.zzs = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x011e, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0125, code lost:
    
        if (r3.zzd.zza.zzh != 1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0127, code lost:
    
        r43.zzD -= 8;
        r44.zzf(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0130, code lost:
    
        r2 = "audio/ac4".equals(r3.zzd.zza.zzg.zzp);
        r5 = r43.zzD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0140, code lost:
    
        if (r2 == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0142, code lost:
    
        r43.zzE = r3.zzi(r5, 7);
        r5 = r43.zzD;
        r8 = r43.zzk;
        com.google.android.gms.internal.ads.zzafb.zzc(r5, r8);
        r3.zza.zzc(r8, 7);
        r5 = r43.zzE + 7;
        r43.zzE = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x015b, code lost:
    
        r5 = r3.zzi(r5, 0);
        r43.zzE = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0161, code lost:
    
        r43.zzD += r5;
        r43.zzs = 4;
        r43.zzF = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x016b, code lost:
    
        r2 = r3.zzd.zza;
        r8 = r3.zza;
        r9 = r3.zzd();
        r5 = r2.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0177, code lost:
    
        if (r5 != 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0179, code lost:
    
        r2 = r43.zzE;
        r5 = r43.zzD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x017d, code lost:
    
        if (r2 >= r5) goto L555;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x017f, code lost:
    
        r43.zzE += r8.zza(r44, r5 - r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x018a, code lost:
    
        r11 = r43.zzh;
        r12 = r11.zzi();
        r12[0] = 0;
        r12[1] = 0;
        r12[r25] = 0;
        r13 = 4 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x019c, code lost:
    
        if (r43.zzE >= r43.zzD) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x019e, code lost:
    
        r4 = r43.zzF;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01a0, code lost:
    
        if (r4 != 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a5, code lost:
    
        if (r43.zzK.length > 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a9, code lost:
    
        if (r43.zzG != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ac, code lost:
    
        r4 = r7 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ae, code lost:
    
        r4 = com.google.android.gms.internal.ads.zzgp.zzc(r2.zzg);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01bb, code lost:
    
        if ((r5 + r4) <= (r43.zzD - r43.zzE)) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01be, code lost:
    
        r44.zzc(r12, r13, r5 + r4);
        r11.zzh(r7 ? 1 : 0);
        r6 = r11.zzB();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ca, code lost:
    
        if (r6 < 0) goto L561;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01cc, code lost:
    
        r43.zzF = r6 - r4;
        r6 = r43.zzg;
        r6.zzh(r7 ? 1 : 0);
        r8.zzc(r6, 4);
        r43.zzE += 4;
        r43.zzD += r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0897  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x08b3  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x08c0  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzafy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws zzat {
        char c;
        int i;
        int i2;
        zzet zzetVar;
        long j;
        long jZzz;
        int i3;
        long j2;
        long jZzv;
        long jZzz2;
        String str;
        String str2;
        long j3;
        int i4;
        while (true) {
            int i5 = this.zzs;
            char c2 = 2;
            int i6 = 8;
            boolean z = false;
            if (i5 == 0) {
                if (this.zzv == 0) {
                    zzet zzetVar2 = this.zzm;
                    if (!zzafzVar.zzb(zzetVar2.zzi(), 0, 8, true)) {
                        long j4 = this.zzN;
                        if (j4 == -1) {
                            this.zzp.zze();
                            return -1;
                        }
                        zzagyVar.zza = j4;
                        this.zzN = -1L;
                        this.zzI.zzw(this.zzq.zzb());
                        this.zzM = true;
                        return 1;
                    }
                    this.zzv = 8;
                    zzetVar2.zzh(0);
                    this.zzu = zzetVar2.zzz();
                    this.zzt = zzetVar2.zzB();
                }
                long j5 = this.zzu;
                if (j5 == 1) {
                    zzet zzetVar3 = this.zzm;
                    zzafzVar.zzc(zzetVar3.zzi(), 8, 8);
                    this.zzv += 8;
                    this.zzu = zzetVar3.zzJ();
                } else if (j5 == 0) {
                    long jZzo = zzafzVar.zzo();
                    if (jZzo == -1) {
                        ArrayDeque arrayDeque = this.zzn;
                        jZzo = !arrayDeque.isEmpty() ? ((zzfx) arrayDeque.peek()).zza : -1L;
                    }
                    if (jZzo != -1) {
                        this.zzu = (jZzo - zzafzVar.zzn()) + ((long) this.zzv);
                    }
                }
                long j6 = this.zzu;
                int i7 = this.zzv;
                long j7 = i7;
                if (j6 < j7) {
                    if (this.zzt != 1718773093 || i7 != 8) {
                        break;
                    }
                    this.zzu = j7;
                    j6 = j7;
                }
                if (this.zzN != -1) {
                    if (this.zzt == 1936286840) {
                        zzet zzetVar4 = this.zzk;
                        zzetVar4.zza((int) j6);
                        System.arraycopy(this.zzm.zzi(), 0, zzetVar4.zzi(), 0, 8);
                        zzafzVar.zzc(zzetVar4.zzi(), 8, (int) (this.zzu - ((long) this.zzv)));
                        this.zzq.zza((zzafm) zzm(new zzfy(1936286840, zzetVar4).zza, zzafzVar.zzm()).second);
                    } else {
                        zzafzVar.zze((int) (j6 - j7), true);
                    }
                    zzi();
                } else {
                    long jZzn = zzafzVar.zzn() - j7;
                    int i8 = this.zzt;
                    if (!(i8 == 1836019558 || i8 == 1835295092) || this.zzL) {
                        if (this.zzt == 1836019558) {
                        }
                        i4 = this.zzt;
                        if (i4 != 1835295092) {
                        }
                    } else if (zzafzVar.zzo() == -1 || this.zzO != -1 || (this.zzd & 512) == 0) {
                        this.zzI.zzw(new zzaha(this.zzA, jZzn));
                        this.zzL = true;
                        if (this.zzt == 1836019558) {
                            SparseArray sparseArray = this.zzf;
                            int size = sparseArray.size();
                            for (int i9 = 0; i9 < size; i9++) {
                                zzamk zzamkVar = ((zzalq) sparseArray.valueAt(i9)).zzb;
                                zzamkVar.zzc = jZzn;
                                zzamkVar.zzb = jZzn;
                            }
                        }
                        i4 = this.zzt;
                        if (i4 != 1835295092) {
                            this.zzC = null;
                            this.zzx = jZzn + this.zzu;
                            this.zzs = 2;
                        } else if (i4 == 1836019574 || i4 == 1953653099 || i4 == 1835297121 || i4 == 1835626086 || i4 == 1937007212 || i4 == 1836019558 || i4 == 1953653094 || i4 == 1836475768 || i4 == 1701082227 || i4 == 1835365473) {
                            long jZzn2 = zzafzVar.zzn();
                            long j8 = this.zzu;
                            long j9 = jZzn2 + j8;
                            if (j8 != this.zzv && i4 == 1835365473) {
                                zzet zzetVar5 = this.zzk;
                                zzetVar5.zza(8);
                                zzafzVar.zzi(zzetVar5.zzi(), 0, 8);
                                zzalj.zzf(zzetVar5);
                                zzafzVar.zzf(zzetVar5.zzg());
                                zzafzVar.zzl();
                            }
                            long j10 = j9 - 8;
                            this.zzn.push(new zzfx(this.zzt, j10));
                            if (this.zzu == this.zzv) {
                                zzj(j10);
                            } else {
                                zzi();
                            }
                        } else if (i4 == 1751411826 || i4 == 1835296868 || i4 == 1836476516 || i4 == 1936286840 || i4 == 1937011556 || i4 == 1937011827 || i4 == 1668576371 || i4 == 1937011555 || i4 == 1937011578 || i4 == 1937013298 || i4 == 1937007471 || i4 == 1668232756 || i4 == 1937011571 || i4 == 1952867444 || i4 == 1952868452 || i4 == 1953196132 || i4 == 1953654136 || i4 == 1953658222 || i4 == 1886614376 || i4 == 1935763834 || i4 == 1935763823 || i4 == 1936027235 || i4 == 1970628964 || i4 == 1935828848 || i4 == 1936158820 || i4 == 1701606260 || i4 == 1835362404 || i4 == 1701671783 || i4 == 1969517665 || i4 == 1801812339 || i4 == 1768715124) {
                            if (this.zzv != 8) {
                                throw zzat.zzc("Leaf atom defines extended atom size (unsupported).");
                            }
                            if (this.zzu > 2147483647L) {
                                throw zzat.zzc("Leaf atom with length > 2147483647 (unsupported).");
                            }
                            zzet zzetVar6 = new zzet((int) this.zzu);
                            System.arraycopy(this.zzm.zzi(), 0, zzetVar6.zzi(), 0, 8);
                            this.zzw = zzetVar6;
                            this.zzs = 1;
                        } else {
                            if (this.zzu > 2147483647L) {
                                throw zzat.zzc("Skipping atom with length > 2147483647 (unsupported).");
                            }
                            this.zzw = null;
                            this.zzs = 1;
                        }
                    } else {
                        this.zzO = jZzn;
                        zzagyVar.zza = zzafzVar.zzo() - 16;
                        this.zzs = 5;
                    }
                }
                if (this.zzs == 5) {
                    return 1;
                }
            } else if (i5 != 1) {
                long j11 = Long.MAX_VALUE;
                if (i5 == 2) {
                    SparseArray sparseArray2 = this.zzf;
                    int size2 = sparseArray2.size();
                    zzalq zzalqVar = null;
                    for (int i10 = 0; i10 < size2; i10++) {
                        zzamk zzamkVar2 = ((zzalq) sparseArray2.valueAt(i10)).zzb;
                        if (zzamkVar2.zzo) {
                            long j12 = zzamkVar2.zzc;
                            if (j12 < j11) {
                                zzalqVar = (zzalq) sparseArray2.valueAt(i10);
                                j11 = j12;
                            }
                        }
                    }
                    if (zzalqVar == null) {
                        this.zzs = 3;
                    } else {
                        int iZzn = (int) (j11 - zzafzVar.zzn());
                        if (iZzn < 0) {
                            throw zzat.zzb("Offset to encryption data was negative.", null);
                        }
                        zzafzVar.zzf(iZzn);
                        zzamk zzamkVar3 = zzalqVar.zzb;
                        zzet zzetVar7 = zzamkVar3.zzn;
                        zzafzVar.zzc(zzetVar7.zzi(), 0, zzetVar7.zze());
                        zzetVar7.zzh(0);
                        zzamkVar3.zzo = false;
                    }
                } else if (i5 == 5) {
                    zzet zzetVar8 = this.zzk;
                    zzetVar8.zza(16);
                    if (zzafzVar.zzb(zzetVar8.zzi(), 0, 16, true)) {
                        zzetVar8.zzh(0);
                        int iZzB = zzetVar8.zzB();
                        int iZzB2 = zzetVar8.zzB();
                        if (iZzB == 16 && iZzB2 == 1835430511) {
                            zzetVar8.zzk(4);
                            long jZzz3 = zzetVar8.zzz();
                            long jZzo2 = zzafzVar.zzo() - jZzz3;
                            if (jZzz3 <= 0 || jZzz3 > 2147483647L || jZzo2 < 0 || jZzo2 < this.zzO) {
                                zzo(new zzaha(this.zzA, this.zzO), zzagyVar);
                            } else {
                                zzagyVar.zza = jZzo2;
                                this.zzs = 6;
                            }
                        } else {
                            zzo(new zzaha(this.zzA, this.zzO), zzagyVar);
                        }
                    } else {
                        zzo(new zzaha(this.zzA, this.zzO), zzagyVar);
                    }
                    int i11 = this.zzs;
                    if (i11 == 6 || i11 == 0) {
                        return 1;
                    }
                } else if (i5 != 6) {
                    zzalq zzalqVar2 = this.zzC;
                    if (zzalqVar2 != null) {
                        c = 2;
                        break;
                    }
                    SparseArray sparseArray3 = this.zzf;
                    int size3 = sparseArray3.size();
                    zzalq zzalqVar3 = null;
                    int i12 = 0;
                    while (i12 < size3) {
                        char c3 = c2;
                        zzalq zzalqVar4 = (zzalq) sparseArray3.valueAt(i12);
                        if ((zzalqVar4.zzk() || zzalqVar4.zzf != zzalqVar4.zzd.zzb) && (!zzalqVar4.zzk() || zzalqVar4.zzh != zzalqVar4.zzb.zzd)) {
                            long jZze = zzalqVar4.zze();
                            if (jZze < j11) {
                                zzalqVar3 = zzalqVar4;
                                j11 = jZze;
                            }
                        }
                        i12++;
                        c2 = c3;
                    }
                    c = c2;
                    if (zzalqVar3 == null) {
                        int iZzn2 = (int) (this.zzx - zzafzVar.zzn());
                        if (iZzn2 < 0) {
                            throw zzat.zzb("Offset to end of mdat was negative.", null);
                        }
                        zzafzVar.zzf(iZzn2);
                        zzi();
                    } else {
                        int iZze = (int) (zzalqVar3.zze() - zzafzVar.zzn());
                        if (iZze < 0) {
                            zzeg.zzc("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            iZze = 0;
                        }
                        zzafzVar.zzf(iZze);
                        this.zzC = zzalqVar3;
                        zzalqVar2 = zzalqVar3;
                    }
                } else {
                    int i13 = 2;
                    int iZzo = (int) (zzafzVar.zzo() - zzafzVar.zzn());
                    zzet zzetVar9 = new zzet(iZzo);
                    zzafzVar.zzc(zzetVar9.zzi(), 0, iZzo);
                    zzetVar9.zzh(0);
                    zzetVar9.zzh(zzetVar9.zzB() == 1 ? 16 : 8);
                    SparseArray sparseArray4 = new SparseArray();
                    SparseArray sparseArray5 = new SparseArray();
                    while (zzetVar9.zzd() >= i6) {
                        int iZzg = zzetVar9.zzg();
                        long jZzz4 = zzetVar9.zzz();
                        int iZzB3 = zzetVar9.zzB();
                        if (jZzz4 == 1) {
                            if (zzetVar9.zzd() < i6) {
                                break;
                            }
                            jZzz4 = zzetVar9.zzD();
                        } else if (jZzz4 == 0) {
                            jZzz4 = ((long) zzetVar9.zze()) - ((long) iZzg);
                        }
                        int i14 = jZzz4 == 1 ? 16 : i6;
                        if (jZzz4 < i14) {
                            break;
                        }
                        long j13 = iZzg;
                        int i15 = i14;
                        if (jZzz4 > ((long) zzetVar9.zze()) - j13) {
                            break;
                        }
                        if (iZzB3 != 1952871009) {
                            zzetVar = zzetVar9;
                            j = jZzz4;
                        } else if (jZzz4 < i15 + 16) {
                            zzetVar9.zzh((int) (j13 + jZzz4));
                        } else {
                            int iZza = zzalj.zza(zzetVar9.zzB());
                            int iZzB4 = zzetVar9.zzB();
                            zzalq zzalqVar5 = (zzalq) this.zzf.get(iZzB4);
                            if (zzalqVar5 == null) {
                                zzetVar9.zzh((int) (j13 + jZzz4));
                            } else {
                                long j14 = zzalqVar5.zzd.zza.zzc;
                                int iZzB5 = zzetVar9.zzB();
                                int i16 = iZzB5 >> 4;
                                int i17 = iZzB5 >> 2;
                                int i18 = iZzB5 & 3;
                                zzet zzetVar10 = zzetVar9;
                                long jZzz5 = zzetVar10.zzz();
                                int i19 = (i16 & 3) + 1;
                                j = jZzz4;
                                int i20 = (i17 & 3) + 1;
                                int i21 = i18 + 1;
                                if (((iZza == 1 ? 16L : 8L) + ((long) i19) + ((long) i20) + ((long) i21)) * jZzz5 > zzetVar10.zzd()) {
                                    zzetVar = zzetVar10;
                                    zzetVar.zzh((int) (j13 + j));
                                    zzetVar9 = zzetVar;
                                    i6 = 8;
                                } else {
                                    zzetVar = zzetVar10;
                                    int i22 = (int) jZzz5;
                                    long[] jArr = new long[i22];
                                    long[] jArr2 = new long[i22];
                                    int i23 = 0;
                                    while (i23 < i22) {
                                        int i24 = i22;
                                        if (iZza == 1) {
                                            jZzz = zzetVar.zzJ();
                                            i3 = iZza;
                                            iZza = 1;
                                        } else {
                                            jZzz = zzetVar.zzz();
                                            i3 = iZza;
                                        }
                                        long jZzJ = iZza == 1 ? zzetVar.zzJ() : zzetVar.zzz();
                                        zzetVar.zzk(i19 + i20 + i21);
                                        jArr[i23] = zzfl.zzv(jZzz, 1000000L, j14, RoundingMode.DOWN);
                                        jArr2[i23] = jZzJ;
                                        i23++;
                                        i22 = i24;
                                        iZza = i3;
                                    }
                                    sparseArray4.put(iZzB4, jArr);
                                    sparseArray5.put(iZzB4, jArr2);
                                }
                            }
                        }
                        zzetVar.zzh((int) (j13 + j));
                        zzetVar9 = zzetVar;
                        i6 = 8;
                    }
                    if (sparseArray4.size() == 0) {
                        zzo(new zzaha(this.zzA, this.zzO), zzagyVar);
                    } else {
                        int iKeyAt = -1;
                        int i25 = -1;
                        int i26 = 0;
                        while (i26 < sparseArray4.size()) {
                            int iKeyAt2 = sparseArray4.keyAt(i26);
                            zzalq zzalqVar6 = (zzalq) this.zzf.get(iKeyAt2);
                            if (zzalqVar6 != null) {
                                int i27 = zzalqVar6.zzd.zza.zzb;
                                if (iKeyAt != -1) {
                                    i2 = iKeyAt;
                                } else if (i27 == i13) {
                                    iKeyAt = iKeyAt2;
                                } else {
                                    i2 = -1;
                                }
                                if (i25 == -1) {
                                    i25 = i27 == 1 ? iKeyAt2 : -1;
                                }
                                iKeyAt = i2;
                            }
                            i26++;
                            i13 = 2;
                        }
                        if (iKeyAt != -1) {
                            i = iKeyAt;
                            zzo(new zzalp(sparseArray4, sparseArray5, this.zzA, this.zzO, i, null), zzagyVar);
                        } else if (i25 != -1) {
                            i = i25;
                            zzo(new zzalp(sparseArray4, sparseArray5, this.zzA, this.zzO, i, null), zzagyVar);
                        } else {
                            iKeyAt = sparseArray4.keyAt(0);
                            i = iKeyAt;
                            zzo(new zzalp(sparseArray4, sparseArray5, this.zzA, this.zzO, i, null), zzagyVar);
                        }
                    }
                    if (this.zzs == 0) {
                        return 1;
                    }
                }
            } else {
                long j15 = this.zzu - ((long) this.zzv);
                zzet zzetVar11 = this.zzw;
                int i28 = (int) j15;
                if (zzetVar11 != null) {
                    zzafzVar.zzc(zzetVar11.zzi(), 8, i28);
                    zzfy zzfyVar = new zzfy(this.zzt, zzetVar11);
                    ArrayDeque arrayDeque2 = this.zzn;
                    if (arrayDeque2.isEmpty()) {
                        int i29 = zzfyVar.zzd;
                        if (i29 == 1936286840) {
                            Pair pairZzm = zzm(zzfyVar.zza, zzafzVar.zzn());
                            zzafn zzafnVar = this.zzq;
                            zzafnVar.zza((zzafm) pairZzm.second);
                            this.zzB = ((Long) pairZzm.first).longValue();
                            if (!this.zzL) {
                                this.zzI.zzw((zzahb) pairZzm.second);
                                this.zzL = true;
                            } else if ((this.zzd & 256) != 0 && !this.zzM && zzafnVar.zzc() > 1) {
                                this.zzN = zzafzVar.zzn();
                            }
                        } else if (i29 == 1701671783) {
                            zzet zzetVar12 = zzfyVar.zza;
                            if (this.zzJ.length != 0) {
                                zzetVar12.zzh(8);
                                int iZza2 = zzalj.zza(zzetVar12.zzB());
                                if (iZza2 == 0) {
                                    String strZzM = zzetVar12.zzM((char) 0);
                                    strZzM.getClass();
                                    String strZzM2 = zzetVar12.zzM((char) 0);
                                    strZzM2.getClass();
                                    long jZzz6 = zzetVar12.zzz();
                                    long jZzz7 = zzetVar12.zzz();
                                    RoundingMode roundingMode = RoundingMode.DOWN;
                                    long jZzv2 = zzfl.zzv(jZzz7, 1000000L, jZzz6, roundingMode);
                                    long j16 = this.zzB;
                                    long j17 = j16 != -9223372036854775807L ? j16 + jZzv2 : -9223372036854775807L;
                                    long jZzv3 = zzfl.zzv(zzetVar12.zzz(), 1000L, jZzz6, roundingMode);
                                    long j18 = j17;
                                    j2 = jZzv2;
                                    jZzv = j18;
                                    jZzz2 = zzetVar12.zzz();
                                    str = strZzM;
                                    str2 = strZzM2;
                                    j3 = jZzv3;
                                } else if (iZza2 != 1) {
                                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(iZza2).length() + 35), "Skipping unsupported emsg version: ", iZza2, "FragmentedMp4Extractor");
                                } else {
                                    long jZzz8 = zzetVar12.zzz();
                                    long jZzJ2 = zzetVar12.zzJ();
                                    RoundingMode roundingMode2 = RoundingMode.DOWN;
                                    jZzv = zzfl.zzv(jZzJ2, 1000000L, jZzz8, roundingMode2);
                                    long jZzv4 = zzfl.zzv(zzetVar12.zzz(), 1000L, jZzz8, roundingMode2);
                                    long jZzz9 = zzetVar12.zzz();
                                    String strZzM3 = zzetVar12.zzM((char) 0);
                                    strZzM3.getClass();
                                    String strZzM4 = zzetVar12.zzM((char) 0);
                                    strZzM4.getClass();
                                    jZzz2 = jZzz9;
                                    str = strZzM3;
                                    str2 = strZzM4;
                                    j3 = jZzv4;
                                    j2 = -9223372036854775807L;
                                }
                                byte[] bArr = new byte[zzetVar12.zzd()];
                                zzetVar12.zzm(bArr, 0, zzetVar12.zzd());
                                zzet zzetVar13 = new zzet(this.zzl.zza(new zzaja(str, str2, j3, jZzz2, bArr)));
                                int iZzd = zzetVar13.zzd();
                                for (zzahk zzahkVar : this.zzJ) {
                                    zzetVar13.zzh(0);
                                    zzahkVar.zzc(zzetVar13, iZzd);
                                }
                                ArrayDeque arrayDeque3 = this.zzo;
                                if (jZzv == -9223372036854775807L) {
                                    arrayDeque3.addLast(new zzalo(j2, true, iZzd));
                                    this.zzy += iZzd;
                                } else if (arrayDeque3.isEmpty()) {
                                    for (zzahk zzahkVar2 : this.zzJ) {
                                        zzahkVar2.zze(jZzv, 1, iZzd, 0, null);
                                    }
                                } else {
                                    arrayDeque3.addLast(new zzalo(jZzv, false, iZzd));
                                    this.zzy += iZzd;
                                }
                            }
                        }
                    } else {
                        ((zzfx) arrayDeque2.peek()).zza(zzfyVar);
                    }
                } else {
                    zzafzVar.zzf(i28);
                }
                zzj(zzafzVar.zzn());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        SparseArray sparseArray = this.zzf;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((zzalq) sparseArray.valueAt(i)).zzc();
        }
        this.zzo.clear();
        this.zzy = 0;
        this.zzp.zzd();
        this.zzz = j2;
        this.zzn.clear();
        this.zzO = -1L;
        zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }

    public final /* synthetic */ void zzh(long j, zzet zzetVar) {
        zzafl.zza(j, zzetVar, this.zzK);
    }
}
