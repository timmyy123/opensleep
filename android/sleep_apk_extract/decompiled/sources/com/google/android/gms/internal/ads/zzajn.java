package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzajn {
    public static final zzajk zza = zzajl.zza;

    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final zzap zza(byte[] bArr, int i, zzajk zzajkVar, zzaiy zzaiyVar) {
        zzajm zzajmVar;
        ArrayList arrayList = new ArrayList();
        zzet zzetVar = new zzet(bArr, i);
        boolean z = false;
        if (zzetVar.zzd() < 10) {
            zzeg.zzc("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int iZzx = zzetVar.zzx();
            if (iZzx == 4801587) {
                int iZzs = zzetVar.zzs();
                zzetVar.zzk(1);
                int iZzs2 = zzetVar.zzs();
                int iZzG = zzetVar.zzG();
                if (iZzs == 2) {
                    if ((iZzs2 & 64) != 0) {
                        zzeg.zzc("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    }
                    zzajmVar = new zzajm(iZzs, iZzs >= 4 && (iZzs2 & 128) != 0, iZzG);
                } else {
                    if (iZzs == 3) {
                        if ((iZzs2 & 64) != 0) {
                            int iZzB = zzetVar.zzB();
                            zzetVar.zzk(iZzB);
                            iZzG -= iZzB + 4;
                        }
                    } else if (iZzs == 4) {
                        if ((iZzs2 & 64) != 0) {
                            int iZzG2 = zzetVar.zzG();
                            zzetVar.zzk(iZzG2 - 4);
                            iZzG -= iZzG2;
                        }
                        if ((iZzs2 & 16) != 0) {
                            iZzG -= 10;
                        }
                    } else {
                        zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(iZzs).length() + 46), "Skipped ID3 tag with unsupported majorVersion=", iZzs, "Id3Decoder");
                    }
                    if (iZzs >= 4) {
                        zzajmVar = new zzajm(iZzs, iZzs >= 4 && (iZzs2 & 128) != 0, iZzG);
                    }
                }
                if (zzajmVar != null) {
                    return null;
                }
                int iZzg = zzetVar.zzg();
                int i2 = zzajmVar.zza() == 2 ? 6 : 10;
                boolean zZzb = zzajmVar.zzb();
                int iZzc = zzajmVar.zzc();
                if (zZzb) {
                    iZzc = zze(zzetVar, zzajmVar.zzc());
                }
                zzetVar.zzf(iZzg + iZzc);
                if (!zzb(zzetVar, zzajmVar.zza(), i2, false)) {
                    if (zzajmVar.zza() != 4 || !zzb(zzetVar, 4, i2, true)) {
                        int iZza = zzajmVar.zza();
                        zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(iZza).length() + 45), "Failed to validate ID3 tag with majorVersion=", iZza, "Id3Decoder");
                        return null;
                    }
                    z = true;
                }
                while (zzetVar.zzd() >= i2) {
                    zzajo zzajoVarZzc = zzc(zzajmVar.zza(), zzetVar, z, i2, zzajkVar);
                    if (zzajoVarZzc != null) {
                        arrayList.add(zzajoVarZzc);
                    }
                }
                return new zzap(arrayList);
            }
            zzeg.zzc("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x".concat(String.format("%06X", Integer.valueOf(iZzx))));
        }
        zzajmVar = null;
        if (zzajmVar != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006d A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004b, B:25:0x006d, B:29:0x0073, B:41:0x008f, B:42:0x0091, B:45:0x0097, B:48:0x00a1, B:31:0x007d, B:35:0x0084, B:10:0x0025), top: B:54:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008f A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004b, B:25:0x006d, B:29:0x0073, B:41:0x008f, B:42:0x0091, B:45:0x0097, B:48:0x00a1, B:31:0x007d, B:35:0x0084, B:10:0x0025), top: B:54:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean zzb(zzet zzetVar, int i, int i2, boolean z) {
        boolean z2;
        int iZzx;
        long jZzx;
        int iZzt;
        int i3;
        int iZzg = zzetVar.zzg();
        while (true) {
            try {
                z2 = true;
                z2 = true;
                int i4 = 1;
                int i5 = 1;
                if (zzetVar.zzd() < i2) {
                    break;
                }
                if (i >= 3) {
                    iZzx = zzetVar.zzB();
                    jZzx = zzetVar.zzz();
                    iZzt = zzetVar.zzt();
                } else {
                    iZzx = zzetVar.zzx();
                    jZzx = zzetVar.zzx();
                    iZzt = 0;
                }
                if (iZzx != 0 || jZzx != 0 || iZzt != 0) {
                    if (i != 4 || z) {
                        if (i != 4) {
                            if ((iZzt & 64) == 0) {
                                i4 = 0;
                            }
                            int i6 = i4;
                            i5 = iZzt & 1;
                            i3 = i6;
                        } else if (i == 3) {
                            i3 = (iZzt & 32) != 0 ? 1 : 0;
                            if ((iZzt & 128) == 0) {
                                i5 = 0;
                            }
                        } else {
                            i3 = 0;
                            i5 = 0;
                        }
                        if (i5 != 0) {
                            i3 += 4;
                        }
                        if (jZzx < i3 && zzetVar.zzd() >= jZzx) {
                            zzetVar.zzk((int) jZzx);
                        }
                    } else {
                        if ((8421504 & jZzx) != 0) {
                            break;
                        }
                        jZzx = ((jZzx >> 24) << 21) | (((jZzx >> 16) & 255) << 14) | (jZzx & 255) | (((jZzx >> 8) & 255) << 7);
                        if (i != 4) {
                        }
                        if (i5 != 0) {
                        }
                        if (jZzx < i3) {
                            break;
                        }
                        zzetVar.zzk((int) jZzx);
                    }
                }
            } finally {
                zzetVar.zzh(iZzg);
            }
        }
        z2 = false;
        return z2;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02a7 A[Catch: all -> 0x013e, Exception -> 0x0262, OutOfMemoryError -> 0x0267, TRY_LEAVE, TryCatch #7 {all -> 0x013e, blocks: (B:82:0x0110, B:92:0x014c, B:95:0x0153, B:107:0x0185, B:110:0x01b7, B:118:0x01e3, B:132:0x0218, B:134:0x022f, B:158:0x0293, B:160:0x02a7, B:162:0x02ae, B:174:0x02ef, B:170:0x02cf, B:172:0x02e9, B:187:0x032b, B:194:0x036e, B:197:0x0397, B:201:0x03ab, B:205:0x03b8, B:206:0x03be, B:208:0x03c4, B:210:0x03cb, B:212:0x03d0, B:220:0x03f6, B:224:0x0421, B:226:0x042c, B:227:0x0461, B:228:0x046e, B:230:0x0474, B:232:0x047b, B:233:0x047f, B:237:0x0495, B:244:0x04a6, B:246:0x04d0, B:247:0x04df, B:248:0x04ea), top: B:261:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02cf A[Catch: all -> 0x013e, Exception -> 0x02c9, OutOfMemoryError -> 0x02cc, TryCatch #7 {all -> 0x013e, blocks: (B:82:0x0110, B:92:0x014c, B:95:0x0153, B:107:0x0185, B:110:0x01b7, B:118:0x01e3, B:132:0x0218, B:134:0x022f, B:158:0x0293, B:160:0x02a7, B:162:0x02ae, B:174:0x02ef, B:170:0x02cf, B:172:0x02e9, B:187:0x032b, B:194:0x036e, B:197:0x0397, B:201:0x03ab, B:205:0x03b8, B:206:0x03be, B:208:0x03c4, B:210:0x03cb, B:212:0x03d0, B:220:0x03f6, B:224:0x0421, B:226:0x042c, B:227:0x0461, B:228:0x046e, B:230:0x0474, B:232:0x047b, B:233:0x047f, B:237:0x0495, B:244:0x04a6, B:246:0x04d0, B:247:0x04df, B:248:0x04ea), top: B:261:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x050b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzajo zzc(int i, zzet zzetVar, boolean z, int i2, zzajk zzajkVar) {
        int iZzH;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        String str;
        zzajo zzajoVar;
        int i6;
        zzajo zzajfVar;
        zzajo zzajrVar;
        zzajo zzajiVar;
        int iZzi;
        String strConcat;
        int iZzs = zzetVar.zzs();
        int iZzs2 = zzetVar.zzs();
        int iZzs3 = zzetVar.zzs();
        int i7 = 0;
        int iZzs4 = i >= 3 ? zzetVar.zzs() : 0;
        if (i == 4) {
            iZzH = zzetVar.zzH();
            if (!z) {
                iZzH = ((iZzH >> 24) << 21) | (iZzH & PHIpAddressSearchManager.END_IP_SCAN) | (((iZzH >> 8) & PHIpAddressSearchManager.END_IP_SCAN) << 7) | (((iZzH >> 16) & PHIpAddressSearchManager.END_IP_SCAN) << 14);
            }
        } else {
            iZzH = i == 3 ? zzetVar.zzH() : zzetVar.zzx();
        }
        int iZzt = i >= 3 ? zzetVar.zzt() : 0;
        if (iZzs == 0 && iZzs2 == 0 && iZzs3 == 0 && iZzs4 == 0 && iZzH == 0 && iZzt == 0) {
            zzetVar.zzh(zzetVar.zze());
            return null;
        }
        int iZzg = zzetVar.zzg() + iZzH;
        if (iZzg > zzetVar.zze()) {
            zzeg.zzc("Id3Decoder", "Frame size exceeds remaining tag data");
            zzetVar.zzh(zzetVar.zze());
            return null;
        }
        if (zzajkVar != null) {
            zzetVar.zzh(iZzg);
            return null;
        }
        if (i == 3) {
            int i8 = iZzt & 64;
            i3 = (iZzt & 128) != 0 ? 1 : 0;
            i5 = 0;
            z3 = i8 != 0;
            z2 = (iZzt & 32) != 0;
            i4 = i3;
        } else if (i == 4) {
            boolean z4 = (iZzt & 64) != 0;
            int i9 = (iZzt & 8) != 0 ? 1 : 0;
            z3 = (iZzt & 4) != 0;
            i5 = (iZzt & 2) != 0 ? 1 : 0;
            i4 = iZzt & 1;
            int i10 = i9;
            z2 = z4;
            i3 = i10;
        } else {
            i3 = 0;
            i4 = 0;
            z2 = false;
            z3 = false;
            i5 = 0;
        }
        if (i3 != 0 || z3) {
            zzeg.zzc("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
            zzetVar.zzh(iZzg);
            return null;
        }
        if (z2) {
            zzetVar.zzk(1);
            iZzH--;
        }
        if (i4 != 0) {
            zzetVar.zzk(4);
            iZzH -= 4;
        }
        if (i5 != 0) {
            iZzH = zze(zzetVar, iZzH);
        }
        try {
            try {
                if (iZzs == 84 && iZzs2 == 88 && iZzs3 == 88 && (i == 2 || iZzs4 == 88)) {
                    if (iZzH > 0) {
                        int iZzs5 = zzetVar.zzs();
                        int i11 = iZzH - 1;
                        byte[] bArr = new byte[i11];
                        zzetVar.zzm(bArr, 0, i11);
                        int iZzh = zzh(bArr, 0, iZzs5);
                        zzajiVar = new zzajt("TXXX", new String(bArr, 0, iZzh, zzf(iZzs5)), zzd(bArr, iZzs5, iZzh + zzj(iZzs5)));
                        i5 = iZzs;
                        str = "Id3Decoder";
                        zzetVar.zzh(iZzg);
                        zzajoVar = zzajiVar;
                        e = null;
                    }
                    i5 = iZzs;
                    str = "Id3Decoder";
                    zzajiVar = null;
                    zzetVar.zzh(iZzg);
                    zzajoVar = zzajiVar;
                    e = null;
                } else if (iZzs == 84) {
                    String strZzg = zzg(i, 84, iZzs2, iZzs3, iZzs4);
                    if (iZzH <= 0) {
                        i5 = iZzs;
                        str = "Id3Decoder";
                        zzajiVar = null;
                        zzetVar.zzh(iZzg);
                        zzajoVar = zzajiVar;
                        e = null;
                    } else {
                        int iZzs6 = zzetVar.zzs();
                        int i12 = iZzH - 1;
                        byte[] bArr2 = new byte[i12];
                        zzetVar.zzm(bArr2, 0, i12);
                        i5 = iZzs;
                        zzajiVar = new zzajt(strZzg, null, zzd(bArr2, iZzs6, 0));
                        str = "Id3Decoder";
                        zzetVar.zzh(iZzg);
                        zzajoVar = zzajiVar;
                        e = null;
                    }
                } else {
                    if (iZzs == 87) {
                        if (iZzs2 != 88 || iZzs3 != 88 || (i != 2 && iZzs4 != 88)) {
                            i6 = 87;
                        }
                        if (iZzH <= 0) {
                            i5 = iZzs;
                            str = "Id3Decoder";
                            zzajiVar = null;
                            zzetVar.zzh(iZzg);
                            zzajoVar = zzajiVar;
                            e = null;
                        } else {
                            int iZzs7 = zzetVar.zzs();
                            int i13 = iZzH - 1;
                            byte[] bArr3 = new byte[i13];
                            zzetVar.zzm(bArr3, 0, i13);
                            int iZzh2 = zzh(bArr3, 0, iZzs7);
                            String str2 = new String(bArr3, 0, iZzh2, zzf(iZzs7));
                            int iZzj = iZzh2 + zzj(iZzs7);
                            zzajiVar = new zzaju("WXXX", str2, zzl(bArr3, iZzj, zzi(bArr3, iZzj), StandardCharsets.ISO_8859_1));
                            i5 = iZzs;
                            str = "Id3Decoder";
                            zzetVar.zzh(iZzg);
                            zzajoVar = zzajiVar;
                            e = null;
                        }
                    } else {
                        i6 = iZzs;
                    }
                    if (i6 == 87) {
                        String strZzg2 = zzg(i, 87, iZzs2, iZzs3, iZzs4);
                        byte[] bArr4 = new byte[iZzH];
                        zzetVar.zzm(bArr4, 0, iZzH);
                        zzajiVar = new zzaju(strZzg2, null, new String(bArr4, 0, zzi(bArr4, 0), StandardCharsets.ISO_8859_1));
                    } else {
                        if (i6 == 80) {
                            if (iZzs2 == 82 && iZzs3 == 73 && iZzs4 == 86) {
                                byte[] bArr5 = new byte[iZzH];
                                zzetVar.zzm(bArr5, 0, iZzH);
                                int iZzi2 = zzi(bArr5, 0);
                                zzajiVar = new zzajs(new String(bArr5, 0, iZzi2, StandardCharsets.ISO_8859_1), zzk(bArr5, iZzi2 + 1, iZzH));
                            } else {
                                i6 = 80;
                            }
                        }
                        try {
                            if (i6 != 71) {
                                str = "Id3Decoder";
                                try {
                                    if (i == 2) {
                                        if (i6 == 80 && iZzs2 == 73 && iZzs3 == 67) {
                                            int iZzs8 = zzetVar.zzs();
                                            Charset charsetZzf = zzf(iZzs8);
                                            int i14 = iZzH - 1;
                                            byte[] bArr6 = new byte[i14];
                                            zzetVar.zzm(bArr6, 0, i14);
                                            if (i != 2) {
                                                i5 = iZzs;
                                                strConcat = "image/".concat(String.valueOf(zzgss.zza(new String(bArr6, 0, 3, StandardCharsets.ISO_8859_1))));
                                                if ("image/jpg".equals(strConcat)) {
                                                    strConcat = "image/jpeg";
                                                }
                                                iZzi = 2;
                                            } else {
                                                i5 = iZzs;
                                                iZzi = zzi(bArr6, 0);
                                                String strZza = zzgss.zza(new String(bArr6, 0, iZzi, StandardCharsets.ISO_8859_1));
                                                strConcat = strZza.indexOf(47) == -1 ? "image/".concat(strZza) : strZza;
                                            }
                                            int i15 = bArr6[iZzi + 1] & 255;
                                            int i16 = iZzi + 2;
                                            int iZzh3 = zzh(bArr6, i16, iZzs8);
                                            zzajfVar = new zzaje(strConcat, new String(bArr6, i16, iZzh3 - i16, charsetZzf), i15, zzk(bArr6, iZzh3 + zzj(iZzs8), i14));
                                            zzajiVar = zzajfVar;
                                            zzetVar.zzh(iZzg);
                                            zzajoVar = zzajiVar;
                                            e = null;
                                        }
                                        i5 = iZzs;
                                        if (i6 != 67 && iZzs2 == 79 && iZzs3 == 77 && (iZzs4 == 77 || i == 2)) {
                                            if (iZzH >= 4) {
                                                int iZzs9 = zzetVar.zzs();
                                                Charset charsetZzf2 = zzf(iZzs9);
                                                byte[] bArr7 = new byte[3];
                                                zzetVar.zzm(bArr7, 0, 3);
                                                String str3 = new String(bArr7, 0, 3);
                                                int i17 = iZzH - 4;
                                                byte[] bArr8 = new byte[i17];
                                                zzetVar.zzm(bArr8, 0, i17);
                                                int iZzh4 = zzh(bArr8, 0, iZzs9);
                                                String str4 = new String(bArr8, 0, iZzh4, charsetZzf2);
                                                int iZzj2 = iZzh4 + zzj(iZzs9);
                                                zzajiVar = new zzaji(str3, str4, zzl(bArr8, iZzj2, zzh(bArr8, iZzj2, iZzs9), charsetZzf2));
                                            }
                                            zzajiVar = null;
                                        } else {
                                            if (i6 != 67 && iZzs2 == 72 && iZzs3 == 65 && iZzs4 == 80) {
                                                int iZzg2 = zzetVar.zzg();
                                                int iZzi3 = zzi(zzetVar.zzi(), iZzg2);
                                                String str5 = new String(zzetVar.zzi(), iZzg2, iZzi3 - iZzg2, StandardCharsets.ISO_8859_1);
                                                zzetVar.zzh(iZzi3 + 1);
                                                int iZzB = zzetVar.zzB();
                                                int iZzB2 = zzetVar.zzB();
                                                if (iZzB > iZzB2) {
                                                    zzajiVar = null;
                                                } else {
                                                    long jZzz = zzetVar.zzz();
                                                    long j = jZzz == 4294967295L ? -1L : jZzz;
                                                    long jZzz2 = zzetVar.zzz();
                                                    long j2 = jZzz2 == 4294967295L ? -1L : jZzz2;
                                                    ArrayList arrayList = new ArrayList();
                                                    int i18 = iZzg2 + iZzH;
                                                    while (zzetVar.zzg() < i18) {
                                                        zzajo zzajoVarZzc = zzc(i, zzetVar, z, i2, null);
                                                        if (zzajoVarZzc != null) {
                                                            arrayList.add(zzajoVarZzc);
                                                        }
                                                        i7 = 0;
                                                    }
                                                    zzajrVar = new zzajg(str5, iZzB, iZzB2, j, j2, (zzajo[]) arrayList.toArray(new zzajo[i7]));
                                                }
                                            } else if (i6 != 67 && iZzs2 == 84 && iZzs3 == 79 && iZzs4 == 67) {
                                                int iZzg3 = zzetVar.zzg();
                                                int iZzi4 = zzi(zzetVar.zzi(), iZzg3);
                                                String str6 = new String(zzetVar.zzi(), iZzg3, iZzi4 - iZzg3, StandardCharsets.ISO_8859_1);
                                                zzetVar.zzh(iZzi4 + 1);
                                                int iZzs10 = zzetVar.zzs();
                                                boolean z5 = (iZzs10 & 2) != 0;
                                                int i19 = iZzs10 & 1;
                                                int iZzs11 = zzetVar.zzs();
                                                String[] strArr = new String[iZzs11];
                                                int i20 = 0;
                                                while (i20 < iZzs11) {
                                                    int iZzg4 = zzetVar.zzg();
                                                    int i21 = iZzg3;
                                                    int iZzi5 = zzi(zzetVar.zzi(), iZzg4);
                                                    String[] strArr2 = strArr;
                                                    strArr2[i20] = new String(zzetVar.zzi(), iZzg4, iZzi5 - iZzg4, StandardCharsets.ISO_8859_1);
                                                    zzetVar.zzh(iZzi5 + 1);
                                                    i20++;
                                                    iZzg3 = i21;
                                                    iZzs11 = iZzs11;
                                                    str6 = str6;
                                                    strArr = strArr2;
                                                }
                                                int i22 = iZzg3;
                                                String str7 = str6;
                                                String[] strArr3 = strArr;
                                                ArrayList arrayList2 = new ArrayList();
                                                int i23 = i22 + iZzH;
                                                while (zzetVar.zzg() < i23) {
                                                    zzajo zzajoVarZzc2 = zzc(i, zzetVar, z, i2, null);
                                                    if (zzajoVarZzc2 != null) {
                                                        arrayList2.add(zzajoVarZzc2);
                                                    }
                                                }
                                                zzajrVar = new zzajh(str7, z5, 1 == i19, strArr3, (zzajo[]) arrayList2.toArray(new zzajo[0]));
                                            } else if (i6 != 77 && iZzs2 == 76 && iZzs3 == 76 && iZzs4 == 84) {
                                                int iZzt2 = zzetVar.zzt();
                                                int iZzx = zzetVar.zzx();
                                                int iZzx2 = zzetVar.zzx();
                                                int iZzs12 = zzetVar.zzs();
                                                int iZzs13 = zzetVar.zzs();
                                                zzes zzesVar = new zzes();
                                                zzesVar.zza(zzetVar);
                                                int i24 = ((iZzH - 10) * 8) / (iZzs12 + iZzs13);
                                                int[] iArr = new int[i24];
                                                int[] iArr2 = new int[i24];
                                                for (int i25 = 0; i25 < i24; i25++) {
                                                    int iZzj3 = zzesVar.zzj(iZzs12);
                                                    int iZzj4 = zzesVar.zzj(iZzs13);
                                                    iArr[i25] = iZzj3;
                                                    iArr2[i25] = iZzj4;
                                                }
                                                zzajrVar = new zzajr(iZzt2, iZzx, iZzx2, iArr, iArr2);
                                            } else {
                                                String strZzg3 = zzg(i, i6, iZzs2, iZzs3, iZzs4);
                                                byte[] bArr9 = new byte[iZzH];
                                                zzetVar.zzm(bArr9, 0, iZzH);
                                                zzajfVar = new zzajf(strZzg3, bArr9);
                                                zzajiVar = zzajfVar;
                                            }
                                            zzajiVar = zzajrVar;
                                        }
                                        zzetVar.zzh(iZzg);
                                        zzajoVar = zzajiVar;
                                        e = null;
                                    } else {
                                        if (i6 == 65 && iZzs2 == 80 && iZzs3 == 73 && iZzs4 == 67) {
                                            int iZzs82 = zzetVar.zzs();
                                            Charset charsetZzf3 = zzf(iZzs82);
                                            int i142 = iZzH - 1;
                                            byte[] bArr62 = new byte[i142];
                                            zzetVar.zzm(bArr62, 0, i142);
                                            if (i != 2) {
                                            }
                                            int i152 = bArr62[iZzi + 1] & 255;
                                            int i162 = iZzi + 2;
                                            int iZzh32 = zzh(bArr62, i162, iZzs82);
                                            zzajfVar = new zzaje(strConcat, new String(bArr62, i162, iZzh32 - i162, charsetZzf3), i152, zzk(bArr62, iZzh32 + zzj(iZzs82), i142));
                                        } else {
                                            i5 = iZzs;
                                            if (i6 != 67) {
                                                if (i6 != 67) {
                                                    if (i6 != 67) {
                                                        if (i6 != 77) {
                                                        }
                                                        String strZzg32 = zzg(i, i6, iZzs2, iZzs3, iZzs4);
                                                        byte[] bArr92 = new byte[iZzH];
                                                        zzetVar.zzm(bArr92, 0, iZzH);
                                                        zzajfVar = new zzajf(strZzg32, bArr92);
                                                    }
                                                }
                                            }
                                        }
                                        zzajiVar = zzajfVar;
                                        zzetVar.zzh(iZzg);
                                        zzajoVar = zzajiVar;
                                        e = null;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    zzetVar.zzh(iZzg);
                                    zzajoVar = null;
                                } catch (OutOfMemoryError e2) {
                                    e = e2;
                                    zzetVar.zzh(iZzg);
                                    zzajoVar = null;
                                }
                            } else if (iZzs2 != 69 || iZzs3 != 79) {
                                str = "Id3Decoder";
                                i6 = 71;
                                if (i == 2) {
                                }
                            } else if (iZzs4 == 66 || i == 2) {
                                try {
                                    int iZzs14 = zzetVar.zzs();
                                    Charset charsetZzf4 = zzf(iZzs14);
                                    int i26 = iZzH - 1;
                                    byte[] bArr10 = new byte[i26];
                                    zzetVar.zzm(bArr10, 0, i26);
                                    int iZzi6 = zzi(bArr10, 0);
                                    str = "Id3Decoder";
                                    String strZzh = zzas.zzh(new String(bArr10, 0, iZzi6, StandardCharsets.ISO_8859_1));
                                    int i27 = iZzi6 + 1;
                                    int iZzh5 = zzh(bArr10, i27, iZzs14);
                                    String strZzl = zzl(bArr10, i27, iZzh5, charsetZzf4);
                                    int iZzj5 = iZzh5 + zzj(iZzs14);
                                    int iZzh6 = zzh(bArr10, iZzj5, iZzs14);
                                    i5 = iZzs;
                                    zzajiVar = new zzajj(strZzh, strZzl, zzl(bArr10, iZzj5, iZzh6, charsetZzf4), zzk(bArr10, iZzh6 + zzj(iZzs14), i26));
                                    zzetVar.zzh(iZzg);
                                    zzajoVar = zzajiVar;
                                    e = null;
                                } catch (Exception e3) {
                                    e = e3;
                                    str = "Id3Decoder";
                                    i5 = iZzs;
                                    zzetVar.zzh(iZzg);
                                    zzajoVar = null;
                                } catch (OutOfMemoryError e4) {
                                    e = e4;
                                    str = "Id3Decoder";
                                    i5 = iZzs;
                                    zzetVar.zzh(iZzg);
                                    zzajoVar = null;
                                }
                            } else {
                                i6 = 71;
                                str = "Id3Decoder";
                                if (i == 2) {
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                        } catch (OutOfMemoryError e6) {
                            e = e6;
                        }
                    }
                    i5 = iZzs;
                    str = "Id3Decoder";
                    zzetVar.zzh(iZzg);
                    zzajoVar = zzajiVar;
                    e = null;
                }
            } catch (Throwable th) {
                zzetVar.zzh(iZzg);
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            i5 = iZzs;
            str = "Id3Decoder";
            zzetVar.zzh(iZzg);
            zzajoVar = null;
            if (zzajoVar == null) {
            }
            return zzajoVar;
        } catch (OutOfMemoryError e8) {
            e = e8;
            i5 = iZzs;
            str = "Id3Decoder";
            zzetVar.zzh(iZzg);
            zzajoVar = null;
            if (zzajoVar == null) {
            }
            return zzajoVar;
        }
        if (zzajoVar == null) {
            String strZzg4 = zzg(i, i5, iZzs2, iZzs3, iZzs4);
            StringBuilder sb = new StringBuilder(String.valueOf(strZzg4).length() + 39 + String.valueOf(iZzH).length());
            sb.append("Failed to decode frame: id=");
            sb.append(strZzg4);
            sb.append(", frameSize=");
            sb.append(iZzH);
            zzeg.zzd(str, sb.toString(), e);
        }
        return zzajoVar;
    }

    private static zzgwm zzd(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return zzgwm.zzj("");
        }
        int i3 = zzgwm.$r8$clinit;
        zzgwj zzgwjVar = new zzgwj();
        int iZzh = zzh(bArr, i2, i);
        while (i2 < iZzh) {
            zzgwjVar.zzf(new String(bArr, i2, iZzh - i2, zzf(i)));
            i2 = zzj(i) + iZzh;
            iZzh = zzh(bArr, i2, i);
        }
        zzgwm zzgwmVarZzi = zzgwjVar.zzi();
        return zzgwmVarZzi.isEmpty() ? zzgwm.zzj("") : zzgwmVarZzi;
    }

    private static int zze(zzet zzetVar, int i) {
        byte[] bArrZzi = zzetVar.zzi();
        int iZzg = zzetVar.zzg();
        int i2 = iZzg;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iZzg + i) {
                return i;
            }
            if ((bArrZzi[i2] & 255) == 255 && bArrZzi[i3] == 0) {
                System.arraycopy(bArrZzi, i2 + 2, bArrZzi, i3, (i - (i2 - iZzg)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    private static Charset zzf(int i) {
        return i != 1 ? i != 2 ? i != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE : StandardCharsets.UTF_16;
    }

    private static String zzg(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static int zzh(byte[] bArr, int i, int i2) {
        int iZzi = zzi(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iZzi;
        }
        while (true) {
            int length = bArr.length;
            if (iZzi >= length - 1) {
                return length;
            }
            int i3 = iZzi + 1;
            if ((iZzi - i) % 2 == 0 && bArr[i3] == 0) {
                return iZzi;
            }
            iZzi = zzi(bArr, i3);
        }
    }

    private static int zzi(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int zzj(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static byte[] zzk(byte[] bArr, int i, int i2) {
        return i2 <= i ? zzfl.zzb : Arrays.copyOfRange(bArr, i, i2);
    }

    private static String zzl(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }
}
