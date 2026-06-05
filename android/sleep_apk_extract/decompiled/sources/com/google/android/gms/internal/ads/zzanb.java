package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class zzanb extends zzamz {
    private zzana zza;
    private int zzb;
    private boolean zzc;
    private zzhd zzd;
    private zzhb zze;

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(boolean z) {
        super.zza(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final long zzb(zzet zzetVar) {
        if ((zzetVar.zzi()[0] & 1) == 1) {
            return -1L;
        }
        zzana zzanaVar = this.zza;
        zzanaVar.getClass();
        byte b = zzetVar.zzi()[0];
        zzhd zzhdVar = zzanaVar.zza;
        zzhc[] zzhcVarArr = zzanaVar.zzd;
        int i = zzhcVarArr[(b >> 1) & (PHIpAddressSearchManager.END_IP_SCAN >>> (8 - zzhe.zza(zzhcVarArr.length + (-1))))].zza ? zzhdVar.zzf : zzhdVar.zze;
        int i2 = this.zzc ? (this.zzb + i) / 4 : 0;
        if (zzetVar.zzj() < zzetVar.zze() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzetVar.zzi(), zzetVar.zze() + 4);
            zzetVar.zzb(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzetVar.zzf(zzetVar.zze() + 4);
        }
        long j = i2;
        byte[] bArrZzi = zzetVar.zzi();
        bArrZzi[zzetVar.zze() - 4] = (byte) (j & 255);
        bArrZzi[zzetVar.zze() - 3] = (byte) ((j >>> 8) & 255);
        bArrZzi[zzetVar.zze() - 2] = (byte) ((j >>> 16) & 255);
        bArrZzi[zzetVar.zze() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final boolean zzc(zzet zzetVar, long j, zzamx zzamxVar) throws zzat {
        zzana zzanaVar;
        int i;
        int iZzb;
        int i2;
        int i3;
        long jFloor;
        if (this.zza != null) {
            zzamxVar.zza.getClass();
            return false;
        }
        zzhd zzhdVar = this.zzd;
        int i4 = 1;
        if (zzhdVar == null) {
            zzhe.zzc(1, zzetVar, false);
            int iZzI = zzetVar.zzI();
            int iZzs = zzetVar.zzs();
            int iZzI2 = zzetVar.zzI();
            int iZzC = zzetVar.zzC();
            int i5 = iZzC <= 0 ? -1 : iZzC;
            int iZzC2 = zzetVar.zzC();
            int i6 = iZzC2 <= 0 ? -1 : iZzC2;
            int iZzC3 = zzetVar.zzC();
            int i7 = iZzC3 <= 0 ? -1 : iZzC3;
            int iZzs2 = zzetVar.zzs();
            this.zzd = new zzhd(iZzI, iZzs, iZzI2, i5, i6, i7, (int) Math.pow(2.0d, iZzs2 & 15), (int) Math.pow(2.0d, (iZzs2 & 240) >> 4), 1 == (zzetVar.zzs() & 1), Arrays.copyOf(zzetVar.zzi(), zzetVar.zze()));
        } else {
            int i8 = 4;
            zzhb zzhbVar = this.zze;
            if (zzhbVar == null) {
                this.zze = zzhe.zzb(zzetVar, true, true);
            } else {
                byte[] bArr = new byte[zzetVar.zze()];
                System.arraycopy(zzetVar.zzi(), 0, bArr, 0, zzetVar.zze());
                int i9 = zzhdVar.zza;
                int i10 = 5;
                zzhe.zzc(5, zzetVar, false);
                int iZzs3 = zzetVar.zzs() + 1;
                zzha zzhaVar = new zzha(zzetVar.zzi());
                zzhaVar.zzc(zzetVar.zzg() * 8);
                int i11 = 0;
                while (true) {
                    int i12 = 2;
                    int i13 = 16;
                    if (i11 >= iZzs3) {
                        int i14 = i4;
                        int i15 = 6;
                        int iZzb2 = zzhaVar.zzb(6) + i14;
                        for (int i16 = 0; i16 < iZzb2; i16++) {
                            if (zzhaVar.zzb(16) != 0) {
                                throw zzat.zzb("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int iZzb3 = zzhaVar.zzb(6) + i14;
                        int i17 = 0;
                        while (true) {
                            int i18 = 3;
                            if (i17 < iZzb3) {
                                int iZzb4 = zzhaVar.zzb(i13);
                                if (iZzb4 == 0) {
                                    int i19 = 8;
                                    zzhaVar.zzc(8);
                                    zzhaVar.zzc(16);
                                    zzhaVar.zzc(16);
                                    zzhaVar.zzc(6);
                                    zzhaVar.zzc(8);
                                    int iZzb5 = zzhaVar.zzb(4) + 1;
                                    int i20 = 0;
                                    while (i20 < iZzb5) {
                                        zzhaVar.zzc(i19);
                                        i20++;
                                        i19 = 8;
                                    }
                                } else {
                                    if (iZzb4 != 1) {
                                        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(iZzb4, 41));
                                        sb.append("floor type greater than 1 not decodable: ");
                                        sb.append(iZzb4);
                                        throw zzat.zzb(sb.toString(), null);
                                    }
                                    int iZzb6 = zzhaVar.zzb(5);
                                    int[] iArr = new int[iZzb6];
                                    int i21 = -1;
                                    for (int i22 = 0; i22 < iZzb6; i22++) {
                                        int iZzb7 = zzhaVar.zzb(4);
                                        iArr[i22] = iZzb7;
                                        if (iZzb7 > i21) {
                                            i21 = iZzb7;
                                        }
                                    }
                                    int i23 = i21 + 1;
                                    int[] iArr2 = new int[i23];
                                    int i24 = 0;
                                    while (i24 < i23) {
                                        iArr2[i24] = zzhaVar.zzb(i18) + 1;
                                        int iZzb8 = zzhaVar.zzb(2);
                                        if (iZzb8 > 0) {
                                            i2 = 8;
                                            zzhaVar.zzc(8);
                                        } else {
                                            i2 = 8;
                                        }
                                        int i25 = i23;
                                        int i26 = 0;
                                        for (int i27 = 1; i26 < (i27 << iZzb8); i27 = 1) {
                                            zzhaVar.zzc(i2);
                                            i26++;
                                            i2 = 8;
                                        }
                                        i24++;
                                        i23 = i25;
                                        i18 = 3;
                                    }
                                    zzhaVar.zzc(2);
                                    int iZzb9 = zzhaVar.zzb(4);
                                    int i28 = 0;
                                    int i29 = 0;
                                    for (int i30 = 0; i30 < iZzb6; i30++) {
                                        i28 += iArr2[iArr[i30]];
                                        while (i29 < i28) {
                                            zzhaVar.zzc(iZzb9);
                                            i29++;
                                        }
                                    }
                                }
                                i17++;
                                i15 = 6;
                                i13 = 16;
                            } else {
                                int i31 = 1;
                                int iZzb10 = zzhaVar.zzb(i15) + 1;
                                int i32 = 0;
                                while (i32 < iZzb10) {
                                    if (zzhaVar.zzb(16) > 2) {
                                        throw zzat.zzb("residueType greater than 2 is not decodable", null);
                                    }
                                    zzhaVar.zzc(24);
                                    zzhaVar.zzc(24);
                                    zzhaVar.zzc(24);
                                    int iZzb11 = zzhaVar.zzb(i15) + i31;
                                    int i33 = 8;
                                    zzhaVar.zzc(8);
                                    int[] iArr3 = new int[iZzb11];
                                    for (int i34 = 0; i34 < iZzb11; i34++) {
                                        iArr3[i34] = ((zzhaVar.zza() ? zzhaVar.zzb(5) : 0) * 8) + zzhaVar.zzb(3);
                                    }
                                    int i35 = 0;
                                    while (i35 < iZzb11) {
                                        int i36 = 0;
                                        while (i36 < i33) {
                                            if ((iArr3[i35] & (1 << i36)) != 0) {
                                                zzhaVar.zzc(i33);
                                            }
                                            i36++;
                                            i33 = 8;
                                        }
                                        i35++;
                                        i33 = 8;
                                    }
                                    i32++;
                                    i15 = 6;
                                    i31 = 1;
                                }
                                int iZzb12 = zzhaVar.zzb(i15) + 1;
                                for (int i37 = 0; i37 < iZzb12; i37++) {
                                    int iZzb13 = zzhaVar.zzb(16);
                                    if (iZzb13 != 0) {
                                        StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(iZzb13, 41));
                                        sb2.append("mapping type other than 0 not supported: ");
                                        sb2.append(iZzb13);
                                        zzeg.zze("VorbisUtil", sb2.toString());
                                    } else {
                                        if (zzhaVar.zza()) {
                                            i = 1;
                                            iZzb = zzhaVar.zzb(4) + 1;
                                        } else {
                                            i = 1;
                                            iZzb = 1;
                                        }
                                        if (zzhaVar.zza()) {
                                            int iZzb14 = zzhaVar.zzb(8) + i;
                                            for (int i38 = 0; i38 < iZzb14; i38++) {
                                                int i39 = i9 - 1;
                                                zzhaVar.zzc(zzhe.zza(i39));
                                                zzhaVar.zzc(zzhe.zza(i39));
                                            }
                                        }
                                        if (zzhaVar.zzb(2) != 0) {
                                            throw zzat.zzb("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i40 = 0; i40 < i9; i40++) {
                                                zzhaVar.zzc(4);
                                            }
                                        }
                                        for (int i41 = 0; i41 < iZzb; i41++) {
                                            zzhaVar.zzc(8);
                                            zzhaVar.zzc(8);
                                            zzhaVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb15 = zzhaVar.zzb(6);
                                int i42 = iZzb15 + 1;
                                zzhc[] zzhcVarArr = new zzhc[i42];
                                for (int i43 = 0; i43 < i42; i43++) {
                                    zzhcVarArr[i43] = new zzhc(zzhaVar.zza(), zzhaVar.zzb(16), zzhaVar.zzb(16), zzhaVar.zzb(8));
                                }
                                if (!zzhaVar.zza()) {
                                    throw zzat.zzb("framing bit after modes not set as expected", null);
                                }
                                zzanaVar = new zzana(zzhdVar, zzhbVar, bArr, zzhcVarArr, zzhe.zza(iZzb15));
                            }
                        }
                    } else {
                        if (zzhaVar.zzb(24) != 5653314) {
                            int iZzd = zzhaVar.zzd();
                            StringBuilder sb3 = new StringBuilder(String.valueOf(iZzd).length() + 55);
                            sb3.append("expected code book to start with [0x56, 0x43, 0x42] at ");
                            sb3.append(iZzd);
                            throw zzat.zzb(sb3.toString(), null);
                        }
                        int iZzb16 = zzhaVar.zzb(16);
                        int iZzb17 = zzhaVar.zzb(24);
                        if (zzhaVar.zza()) {
                            zzhaVar.zzc(i10);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzhaVar.zzb(zzhe.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZza = zzhaVar.zza();
                            for (int i44 = 0; i44 < iZzb17; i44++) {
                                if (!zZza) {
                                    zzhaVar.zzc(i10);
                                } else if (zzhaVar.zza()) {
                                    zzhaVar.zzc(i10);
                                }
                            }
                        }
                        int i45 = i8;
                        int iZzb19 = zzhaVar.zzb(i45);
                        if (iZzb19 > 2) {
                            StringBuilder sb4 = new StringBuilder(String.valueOf(iZzb19).length() + 42);
                            sb4.append("lookup type greater than 2 not decodable: ");
                            sb4.append(iZzb19);
                            throw zzat.zzb(sb4.toString(), null);
                        }
                        if (iZzb19 != i4) {
                            if (iZzb19 != 2) {
                                i3 = i4;
                            }
                            i11++;
                            i4 = i3;
                            i8 = 4;
                            i10 = 5;
                        } else {
                            i12 = iZzb19;
                        }
                        zzhaVar.zzc(32);
                        zzhaVar.zzc(32);
                        int iZzb20 = zzhaVar.zzb(i45) + i4;
                        zzhaVar.zzc(i4);
                        if (i12 != i4) {
                            i3 = i4;
                            jFloor = ((long) iZzb16) * ((long) iZzb17);
                        } else if (iZzb16 != 0) {
                            i3 = i4;
                            jFloor = (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16)));
                        } else {
                            i3 = i4;
                            jFloor = 0;
                        }
                        zzhaVar.zzc((int) (jFloor * ((long) iZzb20)));
                        i11++;
                        i4 = i3;
                        i8 = 4;
                        i10 = 5;
                    }
                }
            }
        }
        zzanaVar = null;
        this.zza = zzanaVar;
        if (zzanaVar == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        zzhd zzhdVar2 = zzanaVar.zza;
        arrayList.add(zzhdVar2.zzg);
        arrayList.add(zzanaVar.zzc);
        zzap zzapVarZzb = zzahm.zzb(zzgwm.zzr(zzanaVar.zzb.zza));
        zzt zztVar = new zzt();
        zztVar.zzn("audio/ogg");
        zztVar.zzo("audio/vorbis");
        zztVar.zzi(zzhdVar2.zzd);
        zztVar.zzj(zzhdVar2.zzc);
        zztVar.zzG(zzhdVar2.zza);
        zztVar.zzH(zzhdVar2.zzb);
        zztVar.zzr(arrayList);
        zztVar.zzl(zzapVarZzb);
        zzamxVar.zza = zztVar.zzO();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzj(long j) {
        super.zzj(j);
        this.zzc = j != 0;
        zzhd zzhdVar = this.zzd;
        this.zzb = zzhdVar != null ? zzhdVar.zze : 0;
    }
}
