package com.google.android.gms.internal.ads;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzags {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;
    public final float zzl;
    public final int zzm;
    public final String zzn;
    public final zzgm zzo;

    private zzags(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f, int i13, String str, zzgm zzgmVar) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
        this.zzg = i8;
        this.zzh = i9;
        this.zzi = i10;
        this.zzj = i11;
        this.zzk = i12;
        this.zzl = f;
        this.zzm = i13;
        this.zzn = str;
        this.zzo = zzgmVar;
    }

    public static zzags zza(zzet zzetVar) {
        return zzc(zzetVar, false, null);
    }

    public static zzags zzb(zzet zzetVar, zzgm zzgmVar) {
        return zzc(zzetVar, true, zzgmVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0133 A[PHI: r34
      0x0133: PHI (r34v2 int) = (r34v0 int), (r34v0 int), (r34v0 int), (r34v0 int), (r34v3 int) binds: [B:41:0x013c, B:42:0x013e, B:96:0x023e, B:97:0x0240, B:38:0x0131] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzags zzc(zzet zzetVar, boolean z, zzgm zzgmVar) throws zzat {
        boolean z2;
        boolean z3;
        int i;
        int i2;
        zzgi zzgiVar;
        int i3;
        int iMax;
        int i4;
        int iMax2;
        int i5;
        int i6;
        int i7;
        int i8 = 4;
        boolean z4 = true;
        if (z) {
            try {
                zzetVar.zzk(4);
            } catch (ArrayIndexOutOfBoundsException e) {
                e = e;
                z3 = true;
                throw zzat.zzb("Error parsing".concat(z3 != z ? "HEVC config" : "L-HEVC config"), e);
            }
        } else {
            try {
                zzetVar.zzk(21);
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                z2 = z4;
                z3 = z2;
                throw zzat.zzb("Error parsing".concat(z3 != z ? "HEVC config" : "L-HEVC config"), e);
            }
        }
        int iZzs = zzetVar.zzs() & 3;
        int iZzs2 = zzetVar.zzs();
        int iZzg = zzetVar.zzg();
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < iZzs2; i11++) {
            zzetVar.zzk(1);
            int iZzt = zzetVar.zzt();
            for (int i12 = 0; i12 < iZzt; i12++) {
                int iZzt2 = zzetVar.zzt();
                i10 += iZzt2 + 4;
                zzetVar.zzk(iZzt2);
            }
        }
        zzetVar.zzh(iZzg);
        byte[] bArr = new byte[i10];
        zzgm zzgmVar2 = zzgmVar;
        int i13 = 0;
        float f = 1.0f;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i20 = -1;
        int i21 = -1;
        int i22 = -1;
        int i23 = -1;
        int i24 = -1;
        int i25 = -1;
        String strZzc = null;
        int i26 = 0;
        while (i26 < iZzs2) {
            int iZzs3 = zzetVar.zzs() & 63;
            int iZzt3 = zzetVar.zzt();
            z2 = z4;
            int i27 = i9;
            zzgm zzgmVarZzf = zzgmVar2;
            while (i27 < iZzt3) {
                try {
                    int iZzt4 = zzetVar.zzt();
                    int i28 = i27;
                    System.arraycopy(zzgp.zza, i9, bArr, i13, i8);
                    int i29 = i13 + 4;
                    System.arraycopy(zzetVar.zzi(), zzetVar.zzg(), bArr, i29, iZzt4);
                    int i30 = 32;
                    if (iZzs3 == 32) {
                        if (i28 == 0) {
                            zzgmVarZzf = zzgp.zzf(bArr, i29, i29 + iZzt4);
                            i2 = i29;
                            i = iZzs;
                            i6 = 0;
                            i5 = 0;
                        }
                        i13 = i2 + iZzt4;
                        zzetVar.zzk(iZzt4);
                        i27 = i6 + 1;
                        i9 = i5;
                        iZzs = i;
                        i8 = 4;
                    } else {
                        i30 = iZzs3;
                    }
                    i = iZzs;
                    if (i30 != 33) {
                        i2 = i29;
                        int i31 = 8;
                        if (i30 == 39 && i28 == 0) {
                            int i32 = i13 + 6;
                            int i33 = (i2 + iZzt4) - 1;
                            while (true) {
                                byte b = bArr[i33];
                                if (b == 0) {
                                    if (i33 <= i32) {
                                        break;
                                    }
                                    i33--;
                                } else {
                                    if (b == 0 || i33 <= i32) {
                                        break;
                                    }
                                    zzgw zzgwVar = new zzgw(bArr, i32, i33 + 1);
                                    while (true) {
                                        if (!zzgwVar.zzd(16)) {
                                            break;
                                        }
                                        int i34 = i31;
                                        int iZzf = zzgwVar.zzf(i34);
                                        int i35 = 0;
                                        while (iZzf == 255) {
                                            i35 += PHIpAddressSearchManager.END_IP_SCAN;
                                            iZzf = zzgwVar.zzf(i34);
                                        }
                                        int i36 = i35 + iZzf;
                                        int iZzf2 = zzgwVar.zzf(i34);
                                        int i37 = 0;
                                        while (iZzf2 == 255) {
                                            i37 += PHIpAddressSearchManager.END_IP_SCAN;
                                            iZzf2 = zzgwVar.zzf(8);
                                        }
                                        i31 = 8;
                                        int i38 = i37 + iZzf2;
                                        if (i38 == 0 || !zzgwVar.zzd(i38)) {
                                            break;
                                        }
                                        if (i36 == 176) {
                                            int iZzg2 = zzgwVar.zzg();
                                            boolean zZze = zzgwVar.zze();
                                            int iZzg3 = zZze ? zzgwVar.zzg() : 0;
                                            int iZzg4 = zzgwVar.zzg();
                                            int iZzg5 = -1;
                                            int iZzg6 = -1;
                                            int i39 = -1;
                                            int iZzf3 = -1;
                                            int i40 = -1;
                                            int iZzf4 = -1;
                                            int i41 = 0;
                                            while (i41 <= iZzg4) {
                                                iZzg5 = zzgwVar.zzg();
                                                iZzg6 = zzgwVar.zzg();
                                                boolean z5 = zZze;
                                                int iZzf5 = zzgwVar.zzf(6);
                                                if (iZzf5 != 63) {
                                                    if (iZzf5 == 0) {
                                                        i3 = iZzf5;
                                                        iMax = Math.max(0, iZzg2 - 30);
                                                    } else {
                                                        i3 = iZzf5;
                                                        iMax = Math.max(0, (i3 + iZzg2) - 31);
                                                    }
                                                    iZzf3 = zzgwVar.zzf(iMax);
                                                    if (z5) {
                                                        int iZzf6 = zzgwVar.zzf(6);
                                                        if (iZzf6 != 63) {
                                                            if (iZzf6 == 0) {
                                                                i4 = iZzf6;
                                                                iMax2 = Math.max(0, iZzg3 - 30);
                                                            } else {
                                                                i4 = iZzf6;
                                                                iMax2 = Math.max(0, (i4 + iZzg3) - 31);
                                                            }
                                                            iZzf4 = zzgwVar.zzf(iMax2);
                                                            i40 = i4;
                                                        }
                                                    }
                                                    if (zzgwVar.zze()) {
                                                        zzgwVar.zzb(10);
                                                    }
                                                    i41++;
                                                    zZze = z5;
                                                    i39 = i3;
                                                }
                                            }
                                            zzgiVar = new zzgi(iZzg2, iZzg3, iZzg4 + 1, iZzg5, iZzg6, i39, iZzf3, i40, iZzf4);
                                        } else {
                                            zzgwVar.zzb(i38 * 8);
                                        }
                                    }
                                }
                            }
                            zzgiVar = null;
                            if (zzgiVar != null && zzgmVarZzf != null) {
                                i5 = 0;
                                if (zzgiVar.zza == ((zzgc) zzgmVarZzf.zza.get(0)).zzb) {
                                    i6 = i28;
                                    i24 = 4;
                                } else {
                                    i24 = 5;
                                }
                            }
                        } else {
                            i5 = 0;
                        }
                        i13 = i2 + iZzt4;
                        zzetVar.zzk(iZzt4);
                        i27 = i6 + 1;
                        i9 = i5;
                        iZzs = i;
                        i8 = 4;
                    } else if (i28 == 0) {
                        zzgj zzgjVarZzg = zzgp.zzg(bArr, i29, i29 + iZzt4, zzgmVarZzf);
                        int i42 = zzgjVarZzg.zza + 1;
                        int i43 = zzgjVarZzg.zze;
                        int i44 = zzgjVarZzg.zzf;
                        int i45 = zzgjVarZzg.zzg;
                        i2 = i29;
                        int i46 = zzgjVarZzg.zzh;
                        int i47 = zzgjVarZzg.zzc + 8;
                        int i48 = zzgjVarZzg.zzd + 8;
                        int i49 = zzgjVarZzg.zzk;
                        int i50 = zzgjVarZzg.zzl;
                        int i51 = zzgjVarZzg.zzm;
                        float f2 = zzgjVarZzg.zzi;
                        int i52 = zzgjVarZzg.zzj;
                        zzge zzgeVar = zzgjVarZzg.zzb;
                        if (zzgeVar != null) {
                            i7 = i52;
                            strZzc = zzdq.zzc(zzgeVar.zza, zzgeVar.zzb, zzgeVar.zzc, zzgeVar.zzd, zzgeVar.zze, zzgeVar.zzf);
                        } else {
                            i7 = i52;
                        }
                        i23 = i51;
                        f = f2;
                        i25 = i7;
                        i6 = i28;
                        i20 = i48;
                        i21 = i49;
                        i22 = i50;
                        i17 = i45;
                        i18 = i46;
                        i19 = i47;
                        i5 = 0;
                        i15 = i43;
                        i16 = i44;
                        i14 = i42;
                        i13 = i2 + iZzt4;
                        zzetVar.zzk(iZzt4);
                        i27 = i6 + 1;
                        i9 = i5;
                        iZzs = i;
                        i8 = 4;
                    } else {
                        i2 = i29;
                        i5 = 0;
                    }
                    i6 = i28;
                    i13 = i2 + iZzt4;
                    zzetVar.zzk(iZzt4);
                    i27 = i6 + 1;
                    i9 = i5;
                    iZzs = i;
                    i8 = 4;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    e = e3;
                    z3 = z2;
                    throw zzat.zzb("Error parsing".concat(z3 != z ? "HEVC config" : "L-HEVC config"), e);
                }
            }
            i26++;
            zzgmVar2 = zzgmVarZzf;
            z4 = z2;
            iZzs = iZzs;
            i8 = 4;
        }
        z2 = z4;
        return new zzags(i10 == 0 ? Collections.EMPTY_LIST : Collections.singletonList(bArr), iZzs + 1, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, f, i25, strZzc, zzgmVar2);
    }
}
