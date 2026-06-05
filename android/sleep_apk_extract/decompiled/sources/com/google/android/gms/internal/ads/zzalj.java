package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.internal.Utility;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.mp4parser.boxes.sampleentry.AudioSampleEntry;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzalj {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final byte[] zzb;

    static {
        String str = zzfl.zza;
        zzb = "OpusHead".getBytes(StandardCharsets.UTF_8);
    }

    public static int zza(int i) {
        return (i >> 24) & PHIpAddressSearchManager.END_IP_SCAN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e5, code lost:
    
        r26 = -9223372036854775807L;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0c73  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0c75  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0dd9  */
    /* JADX WARN: Removed duplicated region for block: B:617:0x0ddd  */
    /* JADX WARN: Removed duplicated region for block: B:627:0x0e44  */
    /* JADX WARN: Removed duplicated region for block: B:628:0x0e6f  */
    /* JADX WARN: Removed duplicated region for block: B:638:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015d A[PHI: r9 r12 r13
      0x015d: PHI (r9v4 int) = (r9v3 int), (r9v5 int) binds: [B:71:0x013e, B:80:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x015d: PHI (r12v2 int) = (r12v1 int), (r12v4 int) binds: [B:71:0x013e, B:80:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x015d: PHI (r13v5 int) = (r13v4 int), (r13v6 int) binds: [B:71:0x013e, B:80:0x014f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List zzb(zzfx zzfxVar, zzagr zzagrVar, long j, zzq zzqVar, boolean z, boolean z2, zzgta zzgtaVar, boolean z3) {
        int i;
        long jZzz;
        int i2;
        int i3;
        boolean z4;
        long j2;
        long j3;
        long jZzv;
        int iZza;
        int i4;
        int i5;
        int i6;
        ArrayList arrayList;
        int i7;
        long j4;
        long jZzv2;
        int i8;
        String str;
        zzfy zzfyVarZzc;
        zzfx zzfxVar2;
        long[] jArr;
        long[] jArr2;
        zzv zzvVarZzO;
        zzgta zzgtaVar2;
        zzami zzamiVar;
        Pair pairZzn;
        int i9;
        short s;
        int i10;
        int i11;
        long j5;
        zzet zzetVar;
        int i12;
        short s2;
        String str2;
        zzq zzqVar2;
        String str3;
        long j6;
        zzfx zzfxVar3;
        int i13;
        String str4;
        char c;
        String str5;
        String str6;
        int i14;
        String str7;
        zzalf zzalfVar;
        int i15;
        int i16;
        int i17;
        boolean z5;
        int i18;
        String str8;
        String str9;
        int i19;
        int i20;
        zzalf zzalfVar2;
        zzgm zzgmVar;
        int i21;
        String str10;
        boolean z6;
        String str11;
        boolean z7;
        int i22;
        String str12;
        boolean z8;
        boolean z9;
        boolean z10;
        int i23;
        zzq zzqVarZzb;
        zzgwm zzgwmVarZzj;
        int i24;
        long j7;
        boolean z11;
        zzami zzamiVar2;
        ArrayList arrayList2;
        zzfx zzfxVar4 = zzfxVar;
        ArrayList arrayList3 = new ArrayList();
        int i25 = 0;
        while (true) {
            List list = zzfxVar4.zzc;
            if (i25 >= list.size()) {
                return arrayList3;
            }
            zzfx zzfxVar5 = (zzfx) list.get(i25);
            if (zzfxVar5.zzd != 1953653099) {
                arrayList2 = arrayList3;
                i = i25;
            } else {
                zzfy zzfyVarZzc2 = zzfxVar4.zzc(1836476516);
                zzfyVarZzc2.getClass();
                zzfx zzfxVarZzd = zzfxVar5.zzd(1835297121);
                zzfxVarZzd.getClass();
                zzfy zzfyVarZzc3 = zzfxVarZzd.zzc(1751411826);
                zzfyVarZzc3.getClass();
                int iZzj = zzj(zzfyVarZzc3.zza);
                int i26 = 1;
                int i27 = iZzj == 1936684398 ? 1 : iZzj == 1986618469 ? 2 : (iZzj == 1952807028 || iZzj == 1935832172 || iZzj == 1937072756 || iZzj == 1668047728 || iZzj == 1937072752) ? 3 : iZzj == 1835365473 ? 5 : -1;
                if (i27 == -1) {
                    zzgtaVar2 = zzgtaVar;
                    arrayList = arrayList3;
                    i = i25;
                } else {
                    zzfy zzfyVarZzc4 = zzfxVar5.zzc(1953196132);
                    zzfyVarZzc4.getClass();
                    zzet zzetVar2 = zzfyVarZzc4.zza;
                    zzetVar2.zzh(8);
                    int iZza2 = zza(zzetVar2.zzB());
                    char c2 = 0;
                    zzetVar2.zzk(iZza2 == 0 ? 8 : 16);
                    int iZzB = zzetVar2.zzB();
                    zzetVar2.zzk(4);
                    int iZzg = zzetVar2.zzg();
                    int i28 = 0;
                    while (true) {
                        int i29 = iZza2 == 0 ? 4 : 8;
                        i = i25;
                        if (i28 >= i29) {
                            zzetVar2.zzk(i29);
                            break;
                        }
                        if (zzetVar2.zzi()[iZzg + i28] != -1) {
                            jZzz = iZza2 == 0 ? zzetVar2.zzz() : zzetVar2.zzJ();
                            if (jZzz == 0) {
                                break;
                            }
                        } else {
                            i28++;
                            i25 = i;
                        }
                    }
                    zzetVar2.zzk(10);
                    int iZzt = zzetVar2.zzt();
                    zzetVar2.zzk(4);
                    int iZzB2 = zzetVar2.zzB();
                    int iZzB3 = zzetVar2.zzB();
                    zzetVar2.zzk(4);
                    int iZzB4 = zzetVar2.zzB();
                    int iZzB5 = zzetVar2.zzB();
                    if (iZzB2 == 0) {
                        if (iZzB3 == 65536) {
                            if (iZzB4 != -65536) {
                                if (iZzB4 == 65536) {
                                    z11 = iZzB5 != 0;
                                    iZzB4 = 65536;
                                }
                                iZzB3 = 65536;
                            } else {
                                z11 = iZzB5 != 0;
                            }
                            if (true != z11) {
                                i2 = 90;
                                i3 = i2;
                                zzetVar2.zzk(16);
                                short sZzv = zzetVar2.zzv();
                                zzetVar2.zzk(2);
                                short sZzv2 = zzetVar2.zzv();
                                if (j != -9223372036854775807L) {
                                }
                                long j8 = zzd(zzfyVarZzc2.zza).zzc;
                                if (j2 != -9223372036854775807L) {
                                }
                                zzfx zzfxVarZzd2 = zzfxVarZzd.zzd(1835626086);
                                zzfxVarZzd2.getClass();
                                zzfx zzfxVarZzd3 = zzfxVarZzd2.zzd(1937007212);
                                zzfxVarZzd3.getClass();
                                zzfy zzfyVarZzc5 = zzfxVarZzd.zzc(1835296868);
                                zzfyVarZzc5.getClass();
                                zzet zzetVar3 = zzfyVarZzc5.zza;
                                zzetVar3.zzh(8);
                                iZza = zza(zzetVar3.zzB());
                                zzetVar3.zzk(iZza != 0 ? 8 : 16);
                                long jZzz2 = zzetVar3.zzz();
                                int iZzg2 = zzetVar3.zzg();
                                i4 = 0;
                                while (true) {
                                    if (iZza != 0) {
                                    }
                                    if (i4 < i5) {
                                    }
                                    i4++;
                                    i3 = i3;
                                    i26 = i6;
                                    arrayList3 = arrayList3;
                                }
                                int iZzt2 = zzetVar3.zzt();
                                char[] cArr = new char[3];
                                cArr[0] = (char) (((iZzt2 >> 10) & 31) + 96);
                                cArr[i6] = (char) (((iZzt2 >> 5) & 31) + 96);
                                char c3 = 2;
                                cArr[2] = (char) ((iZzt2 & 31) + 96);
                                while (i8 < 3) {
                                }
                                str = new String(cArr);
                                zzfyVarZzc = zzfxVarZzd3.zzc(1937011556);
                                String str13 = "BoxParsers";
                                if (zzfyVarZzc != null) {
                                }
                            }
                            iZzB3 = 65536;
                        }
                        iZzB2 = 0;
                        if (iZzB2 == 0) {
                        }
                    } else if (iZzB2 == 0) {
                        if (iZzB3 == -65536) {
                            if (iZzB4 != 65536) {
                                if (iZzB4 == -65536) {
                                    z4 = iZzB5 != 0;
                                    iZzB4 = -65536;
                                }
                                iZzB3 = -65536;
                            } else {
                                z4 = iZzB5 != 0;
                            }
                            if (true != z4) {
                                i2 = 270;
                                i3 = i2;
                                zzetVar2.zzk(16);
                                short sZzv3 = zzetVar2.zzv();
                                zzetVar2.zzk(2);
                                short sZzv22 = zzetVar2.zzv();
                                if (j != -9223372036854775807L) {
                                }
                                long j82 = zzd(zzfyVarZzc2.zza).zzc;
                                if (j2 != -9223372036854775807L) {
                                }
                                zzfx zzfxVarZzd22 = zzfxVarZzd.zzd(1835626086);
                                zzfxVarZzd22.getClass();
                                zzfx zzfxVarZzd32 = zzfxVarZzd22.zzd(1937007212);
                                zzfxVarZzd32.getClass();
                                zzfy zzfyVarZzc52 = zzfxVarZzd.zzc(1835296868);
                                zzfyVarZzc52.getClass();
                                zzet zzetVar32 = zzfyVarZzc52.zza;
                                zzetVar32.zzh(8);
                                iZza = zza(zzetVar32.zzB());
                                zzetVar32.zzk(iZza != 0 ? 8 : 16);
                                long jZzz22 = zzetVar32.zzz();
                                int iZzg22 = zzetVar32.zzg();
                                i4 = 0;
                                while (true) {
                                    if (iZza != 0) {
                                    }
                                    if (i4 < i5) {
                                    }
                                    i4++;
                                    i3 = i3;
                                    i26 = i6;
                                    arrayList3 = arrayList3;
                                }
                                int iZzt22 = zzetVar32.zzt();
                                char[] cArr2 = new char[3];
                                cArr2[0] = (char) (((iZzt22 >> 10) & 31) + 96);
                                cArr2[i6] = (char) (((iZzt22 >> 5) & 31) + 96);
                                char c32 = 2;
                                cArr2[2] = (char) ((iZzt22 & 31) + 96);
                                while (i8 < 3) {
                                }
                                str = new String(cArr2);
                                zzfyVarZzc = zzfxVarZzd32.zzc(1937011556);
                                String str132 = "BoxParsers";
                                if (zzfyVarZzc != null) {
                                }
                            }
                            iZzB3 = -65536;
                        }
                        iZzB2 = 0;
                        if (iZzB2 != -65536) {
                            i2 = 180;
                            i3 = i2;
                            zzetVar2.zzk(16);
                            short sZzv32 = zzetVar2.zzv();
                            zzetVar2.zzk(2);
                            short sZzv222 = zzetVar2.zzv();
                            if (j != -9223372036854775807L) {
                            }
                            long j822 = zzd(zzfyVarZzc2.zza).zzc;
                            if (j2 != -9223372036854775807L) {
                            }
                            zzfx zzfxVarZzd222 = zzfxVarZzd.zzd(1835626086);
                            zzfxVarZzd222.getClass();
                            zzfx zzfxVarZzd322 = zzfxVarZzd222.zzd(1937007212);
                            zzfxVarZzd322.getClass();
                            zzfy zzfyVarZzc522 = zzfxVarZzd.zzc(1835296868);
                            zzfyVarZzc522.getClass();
                            zzet zzetVar322 = zzfyVarZzc522.zza;
                            zzetVar322.zzh(8);
                            iZza = zza(zzetVar322.zzB());
                            zzetVar322.zzk(iZza != 0 ? 8 : 16);
                            long jZzz222 = zzetVar322.zzz();
                            int iZzg222 = zzetVar322.zzg();
                            i4 = 0;
                            while (true) {
                                if (iZza != 0) {
                                }
                                if (i4 < i5) {
                                }
                                i4++;
                                i3 = i3;
                                i26 = i6;
                                arrayList3 = arrayList3;
                            }
                            int iZzt222 = zzetVar322.zzt();
                            char[] cArr22 = new char[3];
                            cArr22[0] = (char) (((iZzt222 >> 10) & 31) + 96);
                            cArr22[i6] = (char) (((iZzt222 >> 5) & 31) + 96);
                            char c322 = 2;
                            cArr22[2] = (char) ((iZzt222 & 31) + 96);
                            while (i8 < 3) {
                            }
                            str = new String(cArr22);
                            zzfyVarZzc = zzfxVarZzd322.zzc(1937011556);
                            String str1322 = "BoxParsers";
                            if (zzfyVarZzc != null) {
                            }
                        } else {
                            i2 = 180;
                            i3 = i2;
                            zzetVar2.zzk(16);
                            short sZzv322 = zzetVar2.zzv();
                            zzetVar2.zzk(2);
                            short sZzv2222 = zzetVar2.zzv();
                            if (j != -9223372036854775807L) {
                            }
                            long j8222 = zzd(zzfyVarZzc2.zza).zzc;
                            if (j2 != -9223372036854775807L) {
                            }
                            zzfx zzfxVarZzd2222 = zzfxVarZzd.zzd(1835626086);
                            zzfxVarZzd2222.getClass();
                            zzfx zzfxVarZzd3222 = zzfxVarZzd2222.zzd(1937007212);
                            zzfxVarZzd3222.getClass();
                            zzfy zzfyVarZzc5222 = zzfxVarZzd.zzc(1835296868);
                            zzfyVarZzc5222.getClass();
                            zzet zzetVar3222 = zzfyVarZzc5222.zza;
                            zzetVar3222.zzh(8);
                            iZza = zza(zzetVar3222.zzB());
                            zzetVar3222.zzk(iZza != 0 ? 8 : 16);
                            long jZzz2222 = zzetVar3222.zzz();
                            int iZzg2222 = zzetVar3222.zzg();
                            i4 = 0;
                            while (true) {
                                if (iZza != 0) {
                                }
                                if (i4 < i5) {
                                }
                                i4++;
                                i3 = i3;
                                i26 = i6;
                                arrayList3 = arrayList3;
                            }
                            int iZzt2222 = zzetVar3222.zzt();
                            char[] cArr222 = new char[3];
                            cArr222[0] = (char) (((iZzt2222 >> 10) & 31) + 96);
                            cArr222[i6] = (char) (((iZzt2222 >> 5) & 31) + 96);
                            char c3222 = 2;
                            cArr222[2] = (char) ((iZzt2222 & 31) + 96);
                            while (i8 < 3) {
                            }
                            str = new String(cArr222);
                            zzfyVarZzc = zzfxVarZzd3222.zzc(1937011556);
                            String str13222 = "BoxParsers";
                            if (zzfyVarZzc != null) {
                            }
                        }
                    } else if ((iZzB2 != -65536 || iZzB2 == 65536) && iZzB3 == 0 && iZzB4 == 0 && iZzB5 == -65536) {
                        i2 = 180;
                        i3 = i2;
                        zzetVar2.zzk(16);
                        short sZzv3222 = zzetVar2.zzv();
                        zzetVar2.zzk(2);
                        short sZzv22222 = zzetVar2.zzv();
                        j2 = j != -9223372036854775807L ? jZzz : j;
                        long j82222 = zzd(zzfyVarZzc2.zza).zzc;
                        if (j2 != -9223372036854775807L) {
                            j3 = j82222;
                            jZzv = -9223372036854775807L;
                        } else {
                            j3 = j82222;
                            jZzv = zzfl.zzv(j2, 1000000L, j3, RoundingMode.DOWN);
                        }
                        zzfx zzfxVarZzd22222 = zzfxVarZzd.zzd(1835626086);
                        zzfxVarZzd22222.getClass();
                        zzfx zzfxVarZzd32222 = zzfxVarZzd22222.zzd(1937007212);
                        zzfxVarZzd32222.getClass();
                        zzfy zzfyVarZzc52222 = zzfxVarZzd.zzc(1835296868);
                        zzfyVarZzc52222.getClass();
                        zzet zzetVar32222 = zzfyVarZzc52222.zza;
                        zzetVar32222.zzh(8);
                        iZza = zza(zzetVar32222.zzB());
                        zzetVar32222.zzk(iZza != 0 ? 8 : 16);
                        long jZzz22222 = zzetVar32222.zzz();
                        int iZzg22222 = zzetVar32222.zzg();
                        i4 = 0;
                        while (true) {
                            i5 = iZza != 0 ? 4 : 8;
                            if (i4 < i5) {
                                i6 = i26;
                                arrayList = arrayList3;
                                i7 = i3;
                                j4 = jZzz22222;
                                zzetVar32222.zzk(i5);
                                jZzv2 = -9223372036854775807L;
                                break;
                            }
                            i6 = i26;
                            if (zzetVar32222.zzi()[iZzg22222 + i4] != -1) {
                                long jZzz3 = iZza == 0 ? zzetVar32222.zzz() : zzetVar32222.zzJ();
                                if (jZzz3 == 0) {
                                    arrayList = arrayList3;
                                    i7 = i3;
                                    jZzv2 = -9223372036854775807L;
                                } else {
                                    jZzv2 = zzfl.zzv(jZzz3, 1000000L, jZzz22222, RoundingMode.DOWN);
                                    arrayList = arrayList3;
                                    i7 = i3;
                                }
                                j4 = jZzz22222;
                            } else {
                                i4++;
                                i3 = i3;
                                i26 = i6;
                                arrayList3 = arrayList3;
                            }
                        }
                        int iZzt22222 = zzetVar32222.zzt();
                        char[] cArr2222 = new char[3];
                        cArr2222[0] = (char) (((iZzt22222 >> 10) & 31) + 96);
                        cArr2222[i6] = (char) (((iZzt22222 >> 5) & 31) + 96);
                        char c32222 = 2;
                        cArr2222[2] = (char) ((iZzt22222 & 31) + 96);
                        for (i8 = 0; i8 < 3; i8++) {
                            char c4 = cArr2222[i8];
                            if (c4 < 'a' || c4 > 'z') {
                                str = null;
                                break;
                            }
                        }
                        str = new String(cArr2222);
                        zzfyVarZzc = zzfxVarZzd32222.zzc(1937011556);
                        String str132222 = "BoxParsers";
                        if (zzfyVarZzc != null) {
                            zzeg.zzc("BoxParsers", "Ignoring track where sample table (stbl) box is missing a sample description (stsd).");
                            zzgtaVar2 = zzgtaVar;
                        } else {
                            String strZzc = zzalc.zzc(j4, jZzv2, str);
                            zzet zzetVar4 = zzfyVarZzc.zza;
                            zzetVar4.zzh(12);
                            int iZzB6 = zzetVar4.zzB();
                            long j9 = jZzv2;
                            zzalf zzalfVar3 = new zzalf(iZzB6);
                            int i30 = 0;
                            while (i30 < iZzB6) {
                                int i31 = i27;
                                int iZzg3 = zzetVar4.zzg();
                                int i32 = iZzt;
                                int iZzB7 = zzetVar4.zzB();
                                String str14 = str132222;
                                zzagc.zza(iZzB7 > 0 ? i6 : c2, "childAtomSize must be positive");
                                String str15 = "childAtomSize must be positive";
                                int iZzB8 = zzetVar4.zzB();
                                int i33 = iZzg3;
                                if (iZzB8 == 1635148593 || iZzB8 == 1635148595 || iZzB8 == 1701733238 || iZzB8 == 1831958048 || iZzB8 == 1836070006 || iZzB8 == 1752589105 || iZzB8 == 1751479857 || iZzB8 == 1987470129 || iZzB8 == 1987471665 || iZzB8 == 1932670515 || iZzB8 == 1211250227 || iZzB8 == 1748121139 || iZzB8 == 1987063864 || iZzB8 == 1987063865 || iZzB8 == 1635135537 || iZzB8 == 1685479798 || iZzB8 == 1685479729 || iZzB8 == 1685481573 || iZzB8 == 1685481521 || iZzB8 == 1634760241 || iZzB8 == 1684108849) {
                                    i9 = iZzB6;
                                    s = sZzv3222;
                                    i10 = i31;
                                    i11 = i32;
                                    j5 = j9;
                                    String str16 = str14;
                                    int i34 = 8;
                                    int i35 = iZzB8;
                                    zzetVar = zzetVar4;
                                    zzetVar.zzh(i33 + 16);
                                    zzetVar.zzk(16);
                                    int iZzt3 = zzetVar.zzt();
                                    i12 = i30;
                                    int iZzt4 = zzetVar.zzt();
                                    s2 = sZzv22222;
                                    zzetVar.zzk(50);
                                    int iZzg4 = zzetVar.zzg();
                                    str2 = str;
                                    if (i35 == 1701733238) {
                                        Pair pairZzr = zzr(zzetVar, i33, iZzB7);
                                        if (pairZzr != null) {
                                            int iIntValue = ((Integer) pairZzr.first).intValue();
                                            if (zzqVar == null) {
                                                i23 = iIntValue;
                                                zzqVarZzb = null;
                                            } else {
                                                i23 = iIntValue;
                                                zzqVarZzb = zzqVar.zzb(((zzamj) pairZzr.second).zzb);
                                            }
                                            zzalfVar3.zza[i12] = (zzamj) pairZzr.second;
                                        } else {
                                            i23 = 1701733238;
                                            zzqVarZzb = zzqVar;
                                        }
                                        zzetVar.zzh(iZzg4);
                                        i35 = i23;
                                        zzqVar2 = zzqVarZzb;
                                    } else {
                                        zzqVar2 = zzqVar;
                                    }
                                    if (i35 == 1831958048) {
                                        str3 = "video/mpeg";
                                    } else if (i35 == 1211250227) {
                                        i35 = 1211250227;
                                        str3 = "video/3gpp";
                                    } else {
                                        str3 = null;
                                    }
                                    zzq zzqVar3 = zzqVar2;
                                    i33 = i33;
                                    int i36 = iZzB;
                                    String str17 = strZzc;
                                    j6 = j4;
                                    int i37 = iZzg4;
                                    int i38 = 8;
                                    float fZzH = 1.0f;
                                    int i39 = -1;
                                    int i40 = -1;
                                    int iZzc = -1;
                                    List listZzj = null;
                                    zzgm zzgmVar2 = null;
                                    int i41 = -1;
                                    int i42 = -1;
                                    boolean z12 = false;
                                    int i43 = -1;
                                    int i44 = -1;
                                    int i45 = -1;
                                    String str18 = null;
                                    byte[] bArrCopyOfRange = null;
                                    ByteBuffer byteBufferZzm = null;
                                    zzaky zzakyVarZzq = null;
                                    zzala zzalaVar = null;
                                    zzfu zzfuVarZza = null;
                                    zzfxVar3 = zzfxVar5;
                                    int i46 = 8;
                                    while (i37 - i33 < iZzB7) {
                                        zzetVar.zzh(i37);
                                        int iZzg5 = zzetVar.zzg();
                                        int iZzB9 = zzetVar.zzB();
                                        if (iZzB9 == 0) {
                                            i15 = i37;
                                            if (zzetVar.zzg() - i33 == iZzB7) {
                                                break;
                                            }
                                            i16 = 0;
                                        } else {
                                            i15 = i37;
                                            i16 = iZzB9;
                                        }
                                        if (i16 > 0) {
                                            i17 = iZzB7;
                                            z5 = true;
                                        } else {
                                            i17 = iZzB7;
                                            z5 = false;
                                        }
                                        zzagc.zza(z5, str15);
                                        int iZzB10 = zzetVar.zzB();
                                        if (iZzB10 == 1635148611) {
                                            int i47 = iZzg5 + 8;
                                            zzagc.zza(str3 == null, null);
                                            zzetVar.zzh(i47);
                                            zzafd zzafdVarZza = zzafd.zza(zzetVar);
                                            List list2 = zzafdVarZza.zza;
                                            zzalfVar3.zzc = zzafdVarZza.zzb;
                                            if (z12) {
                                                z10 = true;
                                            } else {
                                                fZzH = zzafdVarZza.zzk;
                                                z10 = false;
                                            }
                                            String str19 = zzafdVarZza.zzl;
                                            int i48 = zzafdVarZza.zzj;
                                            int i49 = zzafdVarZza.zzg;
                                            int i50 = zzafdVarZza.zzh;
                                            int i51 = zzafdVarZza.zzi;
                                            str18 = str19;
                                            i43 = i48;
                                            i18 = i35;
                                            str9 = str15;
                                            zzalfVar2 = zzalfVar3;
                                            i40 = i49;
                                            zzgmVar = zzgmVar2;
                                            i20 = zzafdVarZza.zze;
                                            str8 = "video/avc";
                                            i46 = zzafdVarZza.zzf;
                                            z12 = z10;
                                            i39 = i50;
                                            iZzc = i51;
                                            listZzj = list2;
                                        } else {
                                            i18 = i35;
                                            if (iZzB10 == 1752589123) {
                                                int i52 = iZzg5 + 8;
                                                zzagc.zza(str3 == null, null);
                                                zzetVar.zzh(i52);
                                                zzags zzagsVarZza = zzags.zza(zzetVar);
                                                List list3 = zzagsVarZza.zza;
                                                zzalfVar3.zzc = zzagsVarZza.zzb;
                                                if (z12) {
                                                    z9 = true;
                                                } else {
                                                    fZzH = zzagsVarZza.zzl;
                                                    z9 = false;
                                                }
                                                int i53 = zzagsVarZza.zzm;
                                                int i54 = zzagsVarZza.zzc;
                                                String str20 = zzagsVarZza.zzn;
                                                int i55 = zzagsVarZza.zzk;
                                                if (i55 == -1) {
                                                    i55 = i41;
                                                }
                                                int i56 = zzagsVarZza.zzd;
                                                int i57 = zzagsVarZza.zze;
                                                int i58 = zzagsVarZza.zzh;
                                                int i59 = zzagsVarZza.zzi;
                                                int i60 = zzagsVarZza.zzj;
                                                int i61 = zzagsVarZza.zzf;
                                                int i62 = zzagsVarZza.zzg;
                                                zzgmVar = zzagsVarZza.zzo;
                                                str8 = "video/hevc";
                                                str9 = str15;
                                                zzalfVar2 = zzalfVar3;
                                                str18 = str20;
                                                i45 = i56;
                                                i44 = i57;
                                                i39 = i59;
                                                listZzj = list3;
                                                i20 = i61;
                                                i43 = i53;
                                                i42 = i54;
                                                i41 = i55;
                                                i40 = i58;
                                                iZzc = i60;
                                                i46 = i62;
                                                z12 = z9;
                                                str10 = str16;
                                            } else {
                                                if (iZzB10 == 1818785347) {
                                                    int i63 = iZzg5 + 8;
                                                    zzagc.zza("video/hevc".equals(str3), "lhvC must follow hvcC atom");
                                                    if (zzgmVar2 != null) {
                                                        z8 = zzgmVar2.zza.size() >= 2;
                                                    } else {
                                                        z8 = false;
                                                        zzgmVar2 = null;
                                                    }
                                                    zzagc.zza(z8, "must have at least two layers");
                                                    zzetVar.zzh(i63);
                                                    zzgmVar2.getClass();
                                                    zzags zzagsVarZzb = zzags.zzb(zzetVar, zzgmVar2);
                                                    zzagc.zza(zzalfVar3.zzc == zzagsVarZzb.zzb, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                                                    int i64 = zzagsVarZzb.zzh;
                                                    if (i64 != -1) {
                                                        zzagc.zza(i40 == i64, "colorSpace must be the same for both views");
                                                    }
                                                    int i65 = zzagsVarZzb.zzi;
                                                    if (i65 != -1) {
                                                        zzagc.zza(i39 == i65, "colorRange must be the same for both views");
                                                    }
                                                    int i66 = zzagsVarZzb.zzj;
                                                    if (i66 != -1) {
                                                        zzagc.zza(iZzc == i66, "colorTransfer must be the same for both views");
                                                    }
                                                    zzagc.zza(i38 == zzagsVarZzb.zzf, "bitdepthLuma must be the same for both views");
                                                    zzagc.zza(i46 == zzagsVarZzb.zzg, "bitdepthChroma must be the same for both views");
                                                    if (listZzj != null) {
                                                        int i67 = zzgwm.$r8$clinit;
                                                        zzgwj zzgwjVar = new zzgwj();
                                                        zzgwjVar.zzh(listZzj);
                                                        zzgwjVar.zzh(zzagsVarZzb.zza);
                                                        listZzj = zzgwjVar.zzi();
                                                    } else {
                                                        zzagc.zza(false, "initializationData must be already set from hvcC atom");
                                                    }
                                                    str18 = zzagsVarZzb.zzn;
                                                    i20 = i38;
                                                    str8 = "video/mv-hevc";
                                                    str9 = str15;
                                                } else if (iZzB10 == 1987470147) {
                                                    int i68 = iZzg5 + 8;
                                                    zzagc.zza(str3 == null, null);
                                                    zzetVar.zzh(i68);
                                                    zzahn zzahnVarZza = zzahn.zza(zzetVar);
                                                    List list4 = zzahnVarZza.zza;
                                                    zzalfVar3.zzc = zzahnVarZza.zzb;
                                                    String str21 = zzahnVarZza.zzc;
                                                    i46 = zzahnVarZza.zzd;
                                                    i20 = i46;
                                                    listZzj = list4;
                                                    str18 = str21;
                                                    str8 = "video/vvc";
                                                    str9 = str15;
                                                    zzalfVar2 = zzalfVar3;
                                                    zzgmVar = zzgmVar2;
                                                    str10 = str16;
                                                    i43 = 16;
                                                } else if (iZzB10 == 1986361461) {
                                                    zzetVar.zzh(iZzg5 + 8);
                                                    int iZzg6 = zzetVar.zzg();
                                                    zzalb zzalbVar = null;
                                                    while (iZzg6 - iZzg5 < i16) {
                                                        zzetVar.zzh(iZzg6);
                                                        int iZzB11 = zzetVar.zzB();
                                                        if (iZzB11 > 0) {
                                                            str11 = str3;
                                                            z7 = true;
                                                        } else {
                                                            str11 = str3;
                                                            z7 = false;
                                                        }
                                                        zzagc.zza(z7, str15);
                                                        int i69 = iZzg6;
                                                        if (zzetVar.zzB() == 1702454643) {
                                                            zzetVar.zzh(i69 + 8);
                                                            int iZzg7 = zzetVar.zzg();
                                                            while (true) {
                                                                if (iZzg7 - i69 >= iZzB11) {
                                                                    i22 = iZzB11;
                                                                    str12 = str15;
                                                                    zzalbVar = null;
                                                                    break;
                                                                }
                                                                zzetVar.zzh(iZzg7);
                                                                int iZzB12 = zzetVar.zzB();
                                                                zzagc.zza(iZzB12 > 0, str15);
                                                                int i70 = iZzg7;
                                                                if (zzetVar.zzB() == 1937011305) {
                                                                    zzetVar.zzk(4);
                                                                    int iZzs = zzetVar.zzs();
                                                                    i22 = iZzB11;
                                                                    str12 = str15;
                                                                    zzalbVar = new zzalb(new zzale(1 == (iZzs & 1), (iZzs & 2) == 2, (iZzs & 8) == i34));
                                                                } else {
                                                                    iZzg7 = i70 + iZzB12;
                                                                    i34 = 8;
                                                                }
                                                            }
                                                        } else {
                                                            i22 = iZzB11;
                                                            str12 = str15;
                                                        }
                                                        iZzg6 = i69 + i22;
                                                        str3 = str11;
                                                        str15 = str12;
                                                        i34 = 8;
                                                    }
                                                    str8 = str3;
                                                    str9 = str15;
                                                    zzali zzaliVar = zzalbVar == null ? null : new zzali(zzalbVar);
                                                    if (zzaliVar != null) {
                                                        if (zzgmVar2 == null) {
                                                            zzgmVar2 = null;
                                                        } else if (zzgmVar2.zza.size() >= 2) {
                                                            zzagc.zza(zzaliVar.zza(), "both eye views must be marked as available");
                                                            zzagc.zza(!zzaliVar.zzb().zza().zzc(), "for MV-HEVC, eye_views_reversed must be set to false");
                                                        }
                                                        if (i41 == -1) {
                                                            i20 = i38;
                                                            zzalfVar2 = zzalfVar3;
                                                            zzgmVar = zzgmVar2;
                                                            if (true != zzaliVar.zzb().zza().zzc()) {
                                                                str10 = str16;
                                                                i41 = 4;
                                                            } else {
                                                                i41 = 5;
                                                                str10 = str16;
                                                            }
                                                        } else {
                                                            i20 = i38;
                                                            zzalfVar2 = zzalfVar3;
                                                            zzgmVar = zzgmVar2;
                                                            str10 = str16;
                                                        }
                                                    }
                                                    i19 = i39;
                                                    i20 = i38;
                                                    zzalfVar2 = zzalfVar3;
                                                    zzgmVar = zzgmVar2;
                                                    i21 = i46;
                                                    str10 = str16;
                                                    i46 = i21;
                                                    i39 = i19;
                                                } else {
                                                    str8 = str3;
                                                    str9 = str15;
                                                    if (iZzB10 == 1685480259 || iZzB10 == 1685485123 || iZzB10 == 1685485379) {
                                                        i19 = i39;
                                                        i20 = i38;
                                                        zzalfVar2 = zzalfVar3;
                                                        zzgmVar = zzgmVar2;
                                                        i21 = i46;
                                                        str10 = str16;
                                                        zzfuVarZza = zzfu.zza(zzetVar);
                                                    } else if (iZzB10 == 1987076931) {
                                                        int i71 = iZzg5 + 12;
                                                        zzagc.zza(str8 == null, null);
                                                        zzetVar.zzh(i71);
                                                        byte bZzs = (byte) zzetVar.zzs();
                                                        byte bZzs2 = (byte) zzetVar.zzs();
                                                        int iZzs2 = zzetVar.zzs();
                                                        int i72 = iZzs2 >> 4;
                                                        int i73 = iZzs2 >> 1;
                                                        String str22 = i18 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                                        if (str22.equals("video/x-vnd.on2.vp9")) {
                                                            listZzj = zzdq.zza(bZzs, bZzs2, (byte) i72, (byte) (i73 & 7));
                                                        }
                                                        int i74 = iZzs2 & 1;
                                                        int iZzs3 = zzetVar.zzs();
                                                        int iZzs4 = zzetVar.zzs();
                                                        int iZzb = zzi.zzb(iZzs3);
                                                        int i75 = 1 != i74 ? 2 : 1;
                                                        i46 = i72;
                                                        i20 = i46;
                                                        i18 = i18;
                                                        zzalfVar2 = zzalfVar3;
                                                        str8 = str22;
                                                        zzgmVar = zzgmVar2;
                                                        iZzc = zzi.zzc(iZzs4);
                                                        i39 = i75;
                                                        i40 = iZzb;
                                                    } else if (iZzB10 == 1635135811) {
                                                        int i76 = i16 - 8;
                                                        byte[] bArr = new byte[i76];
                                                        zzetVar.zzm(bArr, 0, i76);
                                                        zzafc zzafcVarZza = zzafc.zza(bArr);
                                                        List list5 = zzafcVarZza.zza;
                                                        int i77 = zzafcVarZza.zzb;
                                                        int i78 = zzafcVarZza.zzc;
                                                        int i79 = zzafcVarZza.zzd;
                                                        iZzc = zzafcVarZza.zze;
                                                        listZzj = list5;
                                                        i46 = i77;
                                                        i20 = i46;
                                                        i39 = i79;
                                                        str8 = "video/av01";
                                                        i18 = i18;
                                                        zzalfVar2 = zzalfVar3;
                                                        zzgmVar = zzgmVar2;
                                                        str10 = str16;
                                                        i40 = i78;
                                                    } else if (iZzB10 == 1668050025) {
                                                        if (byteBufferZzm == null) {
                                                            byteBufferZzm = zzm();
                                                        }
                                                        ByteBuffer byteBuffer = byteBufferZzm;
                                                        byteBuffer.position(21);
                                                        byteBuffer.putShort(zzetVar.zzv());
                                                        byteBuffer.putShort(zzetVar.zzv());
                                                        byteBufferZzm = byteBuffer;
                                                        i20 = i38;
                                                        i18 = i18;
                                                    } else if (iZzB10 == 1835295606) {
                                                        if (byteBufferZzm == null) {
                                                            byteBufferZzm = zzm();
                                                        }
                                                        ByteBuffer byteBuffer2 = byteBufferZzm;
                                                        short sZzv4 = zzetVar.zzv();
                                                        short sZzv5 = zzetVar.zzv();
                                                        short sZzv6 = zzetVar.zzv();
                                                        i18 = i18;
                                                        short sZzv7 = zzetVar.zzv();
                                                        zzgmVar = zzgmVar2;
                                                        short sZzv8 = zzetVar.zzv();
                                                        zzalfVar2 = zzalfVar3;
                                                        short sZzv9 = zzetVar.zzv();
                                                        int i80 = i46;
                                                        short sZzv10 = zzetVar.zzv();
                                                        i20 = i38;
                                                        short sZzv11 = zzetVar.zzv();
                                                        long jZzz4 = zzetVar.zzz();
                                                        long jZzz5 = zzetVar.zzz();
                                                        byteBuffer2.position(1);
                                                        byteBuffer2.putShort(sZzv8);
                                                        byteBuffer2.putShort(sZzv9);
                                                        byteBuffer2.putShort(sZzv4);
                                                        byteBuffer2.putShort(sZzv5);
                                                        byteBuffer2.putShort(sZzv6);
                                                        byteBuffer2.putShort(sZzv7);
                                                        byteBuffer2.putShort(sZzv10);
                                                        byteBuffer2.putShort(sZzv11);
                                                        byteBuffer2.putShort((short) (jZzz4 / 10000));
                                                        byteBuffer2.putShort((short) (jZzz5 / 10000));
                                                        byteBufferZzm = byteBuffer2;
                                                        str10 = str16;
                                                        i46 = i80;
                                                        i39 = i39;
                                                    } else {
                                                        i19 = i39;
                                                        i20 = i38;
                                                        i18 = i18;
                                                        zzalfVar2 = zzalfVar3;
                                                        zzgmVar = zzgmVar2;
                                                        i21 = i46;
                                                        if (iZzB10 == 1681012275) {
                                                            zzagc.zza(str8 == null, null);
                                                            str8 = "video/3gpp";
                                                            str10 = str16;
                                                            i46 = i21;
                                                            i39 = i19;
                                                        } else {
                                                            if (iZzB10 == 1702061171) {
                                                                zzagc.zza(str8 == null, null);
                                                                zzala zzalaVarZzp = zzp(zzetVar, iZzg5);
                                                                String strZza = zzalaVarZzp.zza();
                                                                byte[] bArrZzb = zzalaVarZzp.zzb();
                                                                if (bArrZzb != null) {
                                                                    zzalaVar = zzalaVarZzp;
                                                                    str8 = strZza;
                                                                    listZzj = zzgwm.zzj(bArrZzb);
                                                                } else {
                                                                    zzalaVar = zzalaVarZzp;
                                                                    str8 = strZza;
                                                                }
                                                            } else if (iZzB10 == 1651798644) {
                                                                zzakyVarZzq = zzq(zzetVar, iZzg5);
                                                            } else if (iZzB10 == 1885434736) {
                                                                zzetVar.zzh(iZzg5 + 8);
                                                                fZzH = zzetVar.zzH() / zzetVar.zzH();
                                                                str10 = str16;
                                                                i46 = i21;
                                                                i39 = i19;
                                                                z12 = true;
                                                            } else if (iZzB10 == 1937126244) {
                                                                int i81 = iZzg5 + 8;
                                                                while (true) {
                                                                    if (i81 - iZzg5 >= i16) {
                                                                        bArrCopyOfRange = null;
                                                                        break;
                                                                    }
                                                                    zzetVar.zzh(i81);
                                                                    int iZzB13 = zzetVar.zzB() + i81;
                                                                    if (zzetVar.zzB() == 1886547818) {
                                                                        bArrCopyOfRange = Arrays.copyOfRange(zzetVar.zzi(), i81, iZzB13);
                                                                        break;
                                                                    }
                                                                    i81 = iZzB13;
                                                                }
                                                            } else if (iZzB10 == 1936995172) {
                                                                int iZzs5 = zzetVar.zzs();
                                                                zzetVar.zzk(3);
                                                                if (iZzs5 == 0) {
                                                                    int iZzs6 = zzetVar.zzs();
                                                                    if (iZzs6 == 0) {
                                                                        str10 = str16;
                                                                        i46 = i21;
                                                                        i39 = i19;
                                                                        i41 = 0;
                                                                    } else if (iZzs6 == 1) {
                                                                        str10 = str16;
                                                                        i46 = i21;
                                                                        i39 = i19;
                                                                        i41 = 1;
                                                                    } else if (iZzs6 == 2) {
                                                                        str10 = str16;
                                                                        i46 = i21;
                                                                        i39 = i19;
                                                                        i41 = 2;
                                                                    } else if (iZzs6 == 3) {
                                                                        i41 = 3;
                                                                        str10 = str16;
                                                                        i46 = i21;
                                                                        i39 = i19;
                                                                    }
                                                                }
                                                                str10 = str16;
                                                            } else if (iZzB10 == 1634760259) {
                                                                int i82 = i16 - 12;
                                                                byte[] bArr2 = new byte[i82];
                                                                zzetVar.zzh(iZzg5 + 12);
                                                                zzetVar.zzm(bArr2, 0, i82);
                                                                String strZzd = zzdq.zzd(bArr2);
                                                                zzgwm zzgwmVarZzj2 = zzgwm.zzj(bArr2);
                                                                zzi zziVarZzl = zzl(new zzet(bArr2));
                                                                str18 = strZzd;
                                                                listZzj = zzgwmVarZzj2;
                                                                i20 = zziVarZzl.zzf;
                                                                i46 = zziVarZzl.zzg;
                                                                i40 = zziVarZzl.zzb;
                                                                i39 = zziVarZzl.zzc;
                                                                str8 = "video/apv";
                                                                iZzc = zziVarZzl.zzd;
                                                            } else if (iZzB10 != 1668246642 || i40 != -1) {
                                                                str10 = str16;
                                                            } else if (iZzc == -1) {
                                                                int iZzB14 = zzetVar.zzB();
                                                                if (iZzB14 == 1852009592 || iZzB14 == 1852009571) {
                                                                    str10 = str16;
                                                                    int iZzt5 = zzetVar.zzt();
                                                                    int iZzt6 = zzetVar.zzt();
                                                                    zzetVar.zzk(2);
                                                                    if (i16 != 19) {
                                                                        z6 = false;
                                                                        int iZzb2 = zzi.zzb(iZzt5);
                                                                        int i83 = true != z6 ? 2 : 1;
                                                                        i40 = iZzb2;
                                                                        i39 = i83;
                                                                        iZzc = zzi.zzc(iZzt6);
                                                                        i46 = i21;
                                                                    } else if ((zzetVar.zzs() & 128) != 0) {
                                                                        i16 = 19;
                                                                        z6 = true;
                                                                        int iZzb22 = zzi.zzb(iZzt5);
                                                                        int i832 = true != z6 ? 2 : 1;
                                                                        i40 = iZzb22;
                                                                        i39 = i832;
                                                                        iZzc = zzi.zzc(iZzt6);
                                                                        i46 = i21;
                                                                    } else {
                                                                        i16 = 19;
                                                                        z6 = false;
                                                                        int iZzb222 = zzi.zzb(iZzt5);
                                                                        int i8322 = true != z6 ? 2 : 1;
                                                                        i40 = iZzb222;
                                                                        i39 = i8322;
                                                                        iZzc = zzi.zzc(iZzt6);
                                                                        i46 = i21;
                                                                    }
                                                                } else {
                                                                    str10 = str16;
                                                                    zzeg.zzc(str10, "Unsupported color type: ".concat(zzfz.zze(iZzB14)));
                                                                    i40 = -1;
                                                                    iZzc = -1;
                                                                    i46 = i21;
                                                                    i39 = i19;
                                                                }
                                                            } else {
                                                                str10 = str16;
                                                                i40 = -1;
                                                            }
                                                            str10 = str16;
                                                            i46 = i21;
                                                            i39 = i19;
                                                        }
                                                    }
                                                    i46 = i21;
                                                    i39 = i19;
                                                }
                                                zzalfVar2 = zzalfVar3;
                                                zzgmVar = zzgmVar2;
                                                str10 = str16;
                                            }
                                            i37 = i15 + i16;
                                            str16 = str10;
                                            iZzB7 = i17;
                                            i35 = i18;
                                            str3 = str8;
                                            zzgmVar2 = zzgmVar;
                                            zzalfVar3 = zzalfVar2;
                                            str15 = str9;
                                            i38 = i20;
                                            i34 = 8;
                                        }
                                        str10 = str16;
                                        i37 = i15 + i16;
                                        str16 = str10;
                                        iZzB7 = i17;
                                        i35 = i18;
                                        str3 = str8;
                                        zzgmVar2 = zzgmVar;
                                        zzalfVar3 = zzalfVar2;
                                        str15 = str9;
                                        i38 = i20;
                                        i34 = 8;
                                    }
                                    int i84 = i39;
                                    String str23 = str3;
                                    int i85 = i38;
                                    i13 = iZzB7;
                                    zzalf zzalfVar4 = zzalfVar3;
                                    int i86 = i46;
                                    str4 = str16;
                                    c = 2;
                                    if (zzfuVarZza != null) {
                                        str5 = zzfuVarZza.zza;
                                        str6 = "video/dolby-vision";
                                    } else {
                                        str5 = str18;
                                        str6 = str23;
                                    }
                                    if (str6 == null) {
                                        i14 = i7;
                                        str7 = str17;
                                        iZzB = i36;
                                        zzalfVar = zzalfVar4;
                                    } else {
                                        zzt zztVar = new zzt();
                                        iZzB = i36;
                                        zztVar.zzb(iZzB);
                                        zztVar.zzo(str6);
                                        zztVar.zzk(str5);
                                        zztVar.zzv(iZzt3);
                                        zztVar.zzw(iZzt4);
                                        zztVar.zzx(i45);
                                        zztVar.zzy(i44);
                                        zztVar.zzB(fZzH);
                                        i14 = i7;
                                        zztVar.zzA(i14);
                                        zztVar.zzC(bArrCopyOfRange);
                                        zztVar.zzD(i41);
                                        zztVar.zzr(listZzj);
                                        zztVar.zzq(i43);
                                        zztVar.zzF(i42);
                                        zztVar.zzs(zzqVar3);
                                        str7 = str17;
                                        zztVar.zze(str7);
                                        zzh zzhVar = new zzh();
                                        zzhVar.zza(i40);
                                        zzhVar.zzb(i84);
                                        zzhVar.zzc(iZzc);
                                        zzhVar.zzd(byteBufferZzm != null ? byteBufferZzm.array() : null);
                                        zzhVar.zze(i85);
                                        zzhVar.zzf(i86);
                                        zztVar.zzE(zzhVar.zzg());
                                        if (zzakyVarZzq != null) {
                                            zztVar.zzi(zzhah.zzb(zzakyVarZzq.zza()));
                                            zztVar.zzj(zzhah.zzb(zzakyVarZzq.zzb()));
                                        } else if (zzalaVar != null) {
                                            zztVar.zzi(zzhah.zzb(zzalaVar.zzc()));
                                            zztVar.zzj(zzhah.zzb(zzalaVar.zzd()));
                                        }
                                        zzalfVar = zzalfVar4;
                                        zzalfVar.zzb = zztVar.zzO();
                                    }
                                } else if (iZzB8 == 1836069985 || iZzB8 == 1701733217 || iZzB8 == 1633889587 || iZzB8 == 1700998451 || iZzB8 == 1633889588 || iZzB8 == 1835823201 || iZzB8 == 1685353315 || iZzB8 == 1685353317 || iZzB8 == 1685353320 || iZzB8 == 1685353324 || iZzB8 == 1685353336 || iZzB8 == 1935764850 || iZzB8 == 1935767394 || iZzB8 == 1819304813 || iZzB8 == 1936684916 || iZzB8 == 1953984371 || iZzB8 == 778924082 || iZzB8 == 778924083 || iZzB8 == 1835557169 || iZzB8 == 1835560241 || iZzB8 == 1634492771 || iZzB8 == 1634492791 || iZzB8 == 1970037111 || iZzB8 == 1332770163 || iZzB8 == 1716281667 || iZzB8 == 1767992678 || iZzB8 == 1768973165 || iZzB8 == 1718641517) {
                                    i9 = iZzB6;
                                    s = sZzv3222;
                                    i10 = i31;
                                    i11 = i32;
                                    j5 = j9;
                                    zzo(zzetVar4, iZzB8, i33, iZzB7, iZzB, strZzc, z2, zzqVar, zzalfVar3, i30);
                                    zzetVar = zzetVar4;
                                    str2 = str;
                                    i33 = i33;
                                    i13 = iZzB7;
                                    str7 = strZzc;
                                    zzalfVar = zzalfVar3;
                                    i12 = i30;
                                    j6 = j4;
                                    zzfxVar3 = zzfxVar5;
                                    s2 = sZzv22222;
                                    i14 = i7;
                                    str4 = str14;
                                    c = 2;
                                } else {
                                    if (iZzB8 == 1414810956 || iZzB8 == 1954034535 || iZzB8 == 2004251764 || iZzB8 == 1937010800 || iZzB8 == 1664495672 || iZzB8 == 1836070003) {
                                        zzetVar4.zzh(i33 + 16);
                                        String str24 = "application/ttml+xml";
                                        if (iZzB8 != 1414810956) {
                                            if (iZzB8 == 1954034535) {
                                                int i87 = iZzB7 - 16;
                                                byte[] bArr3 = new byte[i87];
                                                zzetVar4.zzm(bArr3, 0, i87);
                                                zzgwmVarZzj = zzgwm.zzj(bArr3);
                                                str24 = "application/x-quicktime-tx3g";
                                            } else {
                                                if (iZzB8 == 2004251764) {
                                                    str24 = "application/x-mp4-vtt";
                                                } else if (iZzB8 == 1937010800) {
                                                    i24 = iZzB7;
                                                    j7 = 0;
                                                    zzgwmVarZzj = null;
                                                    if (str24 == null) {
                                                        zzet zzetVar5 = zzetVar4;
                                                        zzt zztVar2 = new zzt();
                                                        zztVar2.zzb(iZzB);
                                                        zztVar2.zzo(str24);
                                                        zztVar2.zze(strZzc);
                                                        zztVar2.zzt(j7);
                                                        zztVar2.zzr(zzgwmVarZzj);
                                                        zzalfVar3.zzb = zztVar2.zzO();
                                                        str7 = strZzc;
                                                        i9 = iZzB6;
                                                        zzalfVar = zzalfVar3;
                                                        i12 = i30;
                                                        j6 = j4;
                                                        s = sZzv3222;
                                                        zzfxVar3 = zzfxVar5;
                                                        i10 = i31;
                                                        c = c32222;
                                                        i11 = i32;
                                                        j5 = j9;
                                                        str4 = str14;
                                                        i13 = i24;
                                                        zzetVar = zzetVar5;
                                                    } else {
                                                        zzetVar = zzetVar4;
                                                        str7 = strZzc;
                                                        i9 = iZzB6;
                                                        zzalfVar = zzalfVar3;
                                                        i12 = i30;
                                                        j6 = j4;
                                                        s = sZzv3222;
                                                        zzfxVar3 = zzfxVar5;
                                                        i10 = i31;
                                                        c = c32222;
                                                        i11 = i32;
                                                        j5 = j9;
                                                        str4 = str14;
                                                        i13 = i24;
                                                    }
                                                    str2 = str;
                                                    s2 = sZzv22222;
                                                    i14 = i7;
                                                } else {
                                                    int i88 = i6;
                                                    if (iZzB8 == 1664495672) {
                                                        zzalfVar3.zzd = i88;
                                                        str24 = "application/x-mp4-cea-608";
                                                    } else {
                                                        int iZzg8 = zzetVar4.zzg();
                                                        zzetVar4.zzk(4);
                                                        if (zzetVar4.zzB() == 1702061171) {
                                                            zzala zzalaVarZzp2 = zzp(zzetVar4, iZzg8);
                                                            if (zzalaVarZzp2.zzb() != null && zzalaVarZzp2.zzb().length == 64) {
                                                                String strZzk = zzk(zzalaVarZzp2.zzb(), sZzv3222, sZzv22222);
                                                                String str25 = zzfl.zza;
                                                                zzgwmVarZzj = zzgwm.zzj(strZzk.getBytes(StandardCharsets.UTF_8));
                                                                str24 = "application/vobsub";
                                                            }
                                                        } else {
                                                            zzgwmVarZzj = null;
                                                            str24 = null;
                                                        }
                                                    }
                                                }
                                                i24 = iZzB7;
                                                j7 = Long.MAX_VALUE;
                                                zzgwmVarZzj = null;
                                                if (str24 == null) {
                                                }
                                                str2 = str;
                                                s2 = sZzv22222;
                                                i14 = i7;
                                            }
                                            i24 = iZzB7;
                                            j7 = Long.MAX_VALUE;
                                            if (str24 == null) {
                                            }
                                            str2 = str;
                                            s2 = sZzv22222;
                                            i14 = i7;
                                        } else {
                                            i24 = iZzB7;
                                            j7 = Long.MAX_VALUE;
                                            zzgwmVarZzj = null;
                                            if (str24 == null) {
                                            }
                                            str2 = str;
                                            s2 = sZzv22222;
                                            i14 = i7;
                                        }
                                    } else if (iZzB8 == 1835365492) {
                                        zzetVar4.zzh(i33 + 16);
                                        char c5 = c2;
                                        zzetVar4.zzM(c5);
                                        String strZzM = zzetVar4.zzM(c5);
                                        if (strZzM != null) {
                                            zzt zztVar3 = new zzt();
                                            zztVar3.zzb(iZzB);
                                            zztVar3.zzo(strZzM);
                                            zzalfVar3.zzb = zztVar3.zzO();
                                        }
                                    } else if (iZzB8 == 1667329389) {
                                        zzt zztVar4 = new zzt();
                                        zztVar4.zzb(iZzB);
                                        zztVar4.zzo("application/x-camera-motion");
                                        zzalfVar3.zzb = zztVar4.zzO();
                                    }
                                    zzetVar = zzetVar4;
                                    i13 = iZzB7;
                                    str7 = strZzc;
                                    i9 = iZzB6;
                                    zzalfVar = zzalfVar3;
                                    i12 = i30;
                                    j6 = j4;
                                    s = sZzv3222;
                                    zzfxVar3 = zzfxVar5;
                                    i10 = i31;
                                    c = c32222;
                                    i11 = i32;
                                    j5 = j9;
                                    str4 = str14;
                                    str2 = str;
                                    s2 = sZzv22222;
                                    i14 = i7;
                                }
                                zzetVar.zzh(i33 + i13);
                                i30 = i12 + 1;
                                zzet zzetVar6 = zzetVar;
                                str132222 = str4;
                                zzetVar4 = zzetVar6;
                                i7 = i14;
                                c32222 = c;
                                iZzB6 = i9;
                                sZzv22222 = s2;
                                str = str2;
                                zzfxVar5 = zzfxVar3;
                                j4 = j6;
                                sZzv3222 = s;
                                iZzt = i11;
                                j9 = j5;
                                i6 = 1;
                                c2 = 0;
                                zzalfVar3 = zzalfVar;
                                strZzc = str7;
                                i27 = i10;
                            }
                            int i89 = i27;
                            int i90 = iZzt;
                            zzalf zzalfVar5 = zzalfVar3;
                            long j10 = j4;
                            zzfx zzfxVar6 = zzfxVar5;
                            long j11 = j9;
                            String str26 = str;
                            if (z) {
                                zzfxVar2 = zzfxVar6;
                            } else {
                                zzfxVar2 = zzfxVar6;
                                zzfx zzfxVarZzd4 = zzfxVar2.zzd(1701082227);
                                if (zzfxVarZzd4 != null && (pairZzn = zzn(zzfxVarZzd4)) != null) {
                                    long[] jArr3 = (long[]) pairZzn.first;
                                    jArr2 = (long[]) pairZzn.second;
                                    jArr = jArr3;
                                }
                                zzvVarZzO = zzalfVar5.zzb;
                                if (zzvVarZzO != null) {
                                    zzgtaVar2 = zzgtaVar;
                                    zzamiVar = null;
                                } else {
                                    if (i90 != 0) {
                                        zzfw zzfwVar = new zzfw(i90);
                                        zzt zztVarZza = zzvVarZzO.zza();
                                        zzap zzapVar = zzvVarZzO.zzl;
                                        zztVarZza.zzl(zzapVar != null ? zzapVar.zzg(zzfwVar) : new zzap(-9223372036854775807L, zzfwVar));
                                        zzvVarZzO = zztVarZza.zzO();
                                    }
                                    zzami zzamiVar3 = new zzami(iZzB, i89, zzalc.zza(j10, j11, str26), j3, jZzv, zzalc.zzb(j10, j11, str26), zzvVarZzO, zzalfVar5.zzd, zzalfVar5.zza, zzalfVar5.zzc, jArr, jArr2);
                                    zzgtaVar2 = zzgtaVar;
                                    zzamiVar = zzamiVar3;
                                }
                                zzamiVar2 = (zzami) zzgtaVar2.apply(zzamiVar);
                                if (zzamiVar2 != null) {
                                    zzfx zzfxVarZzd5 = zzfxVar2.zzd(1835297121);
                                    zzfxVarZzd5.getClass();
                                    zzfx zzfxVarZzd6 = zzfxVarZzd5.zzd(1835626086);
                                    zzfxVarZzd6.getClass();
                                    zzfx zzfxVarZzd7 = zzfxVarZzd6.zzd(1937007212);
                                    zzfxVarZzd7.getClass();
                                    zzaml zzamlVarZzg = zzg(zzamiVar2, zzfxVarZzd7, zzagrVar, false);
                                    arrayList2 = arrayList;
                                    arrayList2.add(zzamlVarZzg);
                                } else {
                                    arrayList2 = arrayList;
                                }
                            }
                            jArr = null;
                            jArr2 = null;
                            zzvVarZzO = zzalfVar5.zzb;
                            if (zzvVarZzO != null) {
                            }
                            zzamiVar2 = (zzami) zzgtaVar2.apply(zzamiVar);
                            if (zzamiVar2 != null) {
                            }
                        }
                    } else {
                        i3 = 0;
                        zzetVar2.zzk(16);
                        short sZzv32222 = zzetVar2.zzv();
                        zzetVar2.zzk(2);
                        short sZzv222222 = zzetVar2.zzv();
                        if (j != -9223372036854775807L) {
                        }
                        long j822222 = zzd(zzfyVarZzc2.zza).zzc;
                        if (j2 != -9223372036854775807L) {
                        }
                        zzfx zzfxVarZzd222222 = zzfxVarZzd.zzd(1835626086);
                        zzfxVarZzd222222.getClass();
                        zzfx zzfxVarZzd322222 = zzfxVarZzd222222.zzd(1937007212);
                        zzfxVarZzd322222.getClass();
                        zzfy zzfyVarZzc522222 = zzfxVarZzd.zzc(1835296868);
                        zzfyVarZzc522222.getClass();
                        zzet zzetVar322222 = zzfyVarZzc522222.zza;
                        zzetVar322222.zzh(8);
                        iZza = zza(zzetVar322222.zzB());
                        zzetVar322222.zzk(iZza != 0 ? 8 : 16);
                        long jZzz222222 = zzetVar322222.zzz();
                        int iZzg222222 = zzetVar322222.zzg();
                        i4 = 0;
                        while (true) {
                            if (iZza != 0) {
                            }
                            if (i4 < i5) {
                            }
                            i4++;
                            i3 = i3;
                            i26 = i6;
                            arrayList3 = arrayList3;
                        }
                        int iZzt222222 = zzetVar322222.zzt();
                        char[] cArr22222 = new char[3];
                        cArr22222[0] = (char) (((iZzt222222 >> 10) & 31) + 96);
                        cArr22222[i6] = (char) (((iZzt222222 >> 5) & 31) + 96);
                        char c322222 = 2;
                        cArr22222[2] = (char) ((iZzt222222 & 31) + 96);
                        while (i8 < 3) {
                        }
                        str = new String(cArr22222);
                        zzfyVarZzc = zzfxVarZzd322222.zzc(1937011556);
                        String str1322222 = "BoxParsers";
                        if (zzfyVarZzc != null) {
                        }
                    }
                    i25 = i + 1;
                    zzfxVar4 = zzfxVar;
                    arrayList3 = arrayList2;
                }
                zzfxVar2 = zzfxVar5;
                zzamiVar = null;
                zzamiVar2 = (zzami) zzgtaVar2.apply(zzamiVar);
                if (zzamiVar2 != null) {
                }
            }
            i25 = i + 1;
            zzfxVar4 = zzfxVar;
            arrayList3 = arrayList2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzap zzc(zzfy zzfyVar) {
        int iZzF;
        zzet zzetVar = zzfyVar.zza;
        zzetVar.zzh(8);
        zzap zzapVar = new zzap(-9223372036854775807L, new zzao[0]);
        while (zzetVar.zzd() >= 8) {
            int iZzg = zzetVar.zzg();
            int iZzB = zzetVar.zzB() + iZzg;
            int iZzB2 = zzetVar.zzB();
            zzap zzapVar2 = null;
            if (iZzB2 == 1835365473) {
                zzetVar.zzh(iZzg);
                zzetVar.zzk(8);
                zzf(zzetVar);
                while (true) {
                    if (zzetVar.zzg() >= iZzB) {
                        break;
                    }
                    int iZzg2 = zzetVar.zzg();
                    int iZzB3 = zzetVar.zzB() + iZzg2;
                    if (zzetVar.zzB() == 1768715124) {
                        zzetVar.zzh(iZzg2);
                        zzetVar.zzk(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzetVar.zzg() < iZzB3) {
                            zzao zzaoVarZzc = zzalt.zzc(zzetVar);
                            if (zzaoVarZzc != null) {
                                arrayList.add(zzaoVarZzc);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzapVar2 = new zzap(arrayList);
                        }
                    } else {
                        zzetVar.zzh(iZzB3);
                    }
                }
                zzapVar = zzapVar.zzf(zzapVar2);
            } else if (iZzB2 == 1936553057) {
                zzetVar.zzh(iZzg);
                zzetVar.zzk(12);
                while (true) {
                    if (zzetVar.zzg() >= iZzB) {
                        break;
                    }
                    int iZzg3 = zzetVar.zzg();
                    int iZzB4 = zzetVar.zzB();
                    if (zzetVar.zzB() != 1935766900) {
                        zzetVar.zzh(iZzg3 + iZzB4);
                    } else if (iZzB4 >= 16) {
                        zzetVar.zzk(4);
                        int i = -1;
                        int i2 = 0;
                        for (int i3 = 0; i3 < 2; i3++) {
                            int iZzs = zzetVar.zzs();
                            int iZzs2 = zzetVar.zzs();
                            if (iZzs == 0) {
                                i = iZzs2;
                            } else if (iZzs == 1) {
                                i2 = iZzs2;
                            }
                        }
                        if (i == 12) {
                            iZzF = 240;
                        } else if (i == 13) {
                            iZzF = 120;
                        } else if (i == 21 && zzetVar.zzd() >= 8 && zzetVar.zzg() + 8 <= iZzB) {
                            iZzF = (zzetVar.zzB() < 12 || zzetVar.zzB() != 1936877170) ? -2147483647 : zzetVar.zzF();
                        }
                        if (iZzF != -2147483647) {
                            zzapVar2 = new zzap(-9223372036854775807L, new zzajx(iZzF, i2));
                        }
                    }
                }
                zzapVar = zzapVar.zzf(zzapVar2);
            } else if (iZzB2 == -1451722374) {
                zzapVar = zzapVar.zzf(zzi(zzetVar));
            } else if (iZzB2 == 1667788908) {
                zzapVar = zzapVar.zzf(zzh(zzetVar));
            }
            zzetVar.zzh(iZzB);
        }
        return zzapVar;
    }

    public static zzgb zzd(zzet zzetVar) {
        long jZzD;
        long jZzD2;
        zzetVar.zzh(8);
        if (zza(zzetVar.zzB()) == 0) {
            jZzD = zzetVar.zzz();
            jZzD2 = zzetVar.zzz();
        } else {
            jZzD = zzetVar.zzD();
            jZzD2 = zzetVar.zzD();
        }
        return new zzgb(jZzD, jZzD2, zzetVar.zzz());
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
    
        r8 = r12.zzB();
        r10 = r12.zzB();
        r9 = r9 - 16;
        r11 = new byte[r9];
        r12.zzm(r11, 0, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0098, code lost:
    
        r9 = new com.google.android.gms.internal.ads.zzfv(r6, r11, r10, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009e, code lost:
    
        com.android.billingclient.api.zzba$$ExternalSyntheticOutline0.m(r6, "Failed to parse metadata entry with key: ", "MetadataUtil");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a5, code lost:
    
        r9 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzap zze(zzfx zzfxVar) {
        zzfv zzfvVar;
        zzfy zzfyVarZzc = zzfxVar.zzc(1751411826);
        zzfy zzfyVarZzc2 = zzfxVar.zzc(1801812339);
        zzfy zzfyVarZzc3 = zzfxVar.zzc(1768715124);
        if (zzfyVarZzc != null && zzfyVarZzc2 != null && zzfyVarZzc3 != null && zzj(zzfyVarZzc.zza) == 1835299937) {
            zzet zzetVar = zzfyVarZzc2.zza;
            zzetVar.zzh(12);
            int iZzB = zzetVar.zzB();
            String[] strArr = new String[iZzB];
            for (int i = 0; i < iZzB; i++) {
                int iZzB2 = zzetVar.zzB();
                zzetVar.zzk(4);
                strArr[i] = zzetVar.zzK(iZzB2 - 8, StandardCharsets.UTF_8);
            }
            zzet zzetVar2 = zzfyVarZzc3.zza;
            zzetVar2.zzh(8);
            ArrayList arrayList = new ArrayList();
            while (zzetVar2.zzd() > 8) {
                int iZzB3 = zzetVar2.zzB() + zzetVar2.zzg();
                int iZzB4 = zzetVar2.zzB() - 1;
                if (iZzB4 < 0 || iZzB4 >= iZzB) {
                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(iZzB4).length() + 41), "Skipped metadata with unknown key index: ", iZzB4, "BoxParsers");
                } else {
                    String str = strArr[iZzB4];
                    while (true) {
                        int iZzg = zzetVar2.zzg();
                        if (iZzg >= iZzB3) {
                            break;
                        }
                        int iZzB5 = zzetVar2.zzB();
                        if (zzetVar2.zzB() == 1684108385) {
                            break;
                        }
                        zzetVar2.zzh(iZzg + iZzB5);
                    }
                    if (zzfvVar != null) {
                        arrayList.add(zzfvVar);
                    }
                }
                zzetVar2.zzh(iZzB3);
            }
            if (!arrayList.isEmpty()) {
                return new zzap(arrayList);
            }
        }
        return null;
    }

    public static void zzf(zzet zzetVar) {
        int iZzg = zzetVar.zzg();
        zzetVar.zzk(4);
        if (zzetVar.zzB() != 1751411826) {
            iZzg += 4;
        }
        zzetVar.zzh(iZzg);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e5  */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r23v31 */
    /* JADX WARN: Type inference failed for: r23v32 */
    /* JADX WARN: Type inference failed for: r23v33 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARN: Type inference failed for: r23v9 */
    /* JADX WARN: Type inference failed for: r29v2, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r29v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r38v0 */
    /* JADX WARN: Type inference failed for: r38v1 */
    /* JADX WARN: Type inference failed for: r45v14, types: [int[]] */
    /* JADX WARN: Type inference failed for: r45v15 */
    /* JADX WARN: Type inference failed for: r45v16 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r4v75 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzaml zzg(zzami zzamiVar, zzfx zzfxVar, zzagr zzagrVar, boolean z) throws zzat {
        zzald zzalhVar;
        boolean z2;
        int iZzH;
        int iZzH2;
        int i;
        int iZzH3;
        int i2;
        int i3;
        zzv zzvVar;
        long[] jArr;
        ?? CopyOf;
        int i4;
        long[] jArr2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        long[] jArr3;
        long j;
        long[] jArr4;
        int i12;
        long[] jArr5;
        int[] iArr;
        long j2;
        long j3;
        int i13;
        int i14;
        ?? r23;
        ?? r15;
        long j4;
        long[] jArr6;
        long j5;
        int i15;
        boolean z3;
        int[] iArr2;
        int i16;
        int i17;
        boolean z4;
        int length;
        zzami zzamiVarZzb = zzamiVar;
        zzfy zzfyVarZzc = zzfxVar.zzc(1937011578);
        if (zzfyVarZzc != null) {
            zzalhVar = new zzalg(zzfyVarZzc, zzamiVarZzb.zzg);
        } else {
            zzfy zzfyVarZzc2 = zzfxVar.zzc(1937013298);
            if (zzfyVarZzc2 == null) {
                throw zzat.zzb("Track has no sample table size information", null);
            }
            zzalhVar = new zzalh(zzfyVarZzc2);
        }
        int iZza = zzalhVar.zza();
        if (iZza == 0) {
            return new zzaml(zzamiVarZzb, new long[0], new int[0], 0, new long[0], new int[0], new int[0], false, 0L, 0);
        }
        if (zzamiVarZzb.zzb == 2) {
            long j6 = zzamiVarZzb.zzf;
            if (j6 > 0) {
                zzt zztVarZza = zzamiVarZzb.zzg.zza();
                zztVarZza.zzz(iZza / (j6 / 1000000.0f));
                zzamiVarZzb = zzamiVarZzb.zzb(zztVarZza.zzO());
            }
        }
        zzfy zzfyVarZzc3 = zzfxVar.zzc(1937007471);
        if (zzfyVarZzc3 == null) {
            zzfyVarZzc3 = zzfxVar.zzc(1668232756);
            zzfyVarZzc3.getClass();
            z2 = true;
        } else {
            z2 = false;
        }
        zzfy zzfyVarZzc4 = zzfxVar.zzc(1937011555);
        zzfyVarZzc4.getClass();
        zzet zzetVar = zzfyVarZzc4.zza;
        zzfy zzfyVarZzc5 = zzfxVar.zzc(1937011827);
        zzfyVarZzc5.getClass();
        zzet zzetVar2 = zzfyVarZzc5.zza;
        zzfy zzfyVarZzc6 = zzfxVar.zzc(1937011571);
        zzet zzetVar3 = zzfyVarZzc6 != null ? zzfyVarZzc6.zza : null;
        zzfy zzfyVarZzc7 = zzfxVar.zzc(1668576371);
        zzet zzetVar4 = zzfyVarZzc7 != null ? zzfyVarZzc7.zza : null;
        zzakz zzakzVar = new zzakz(zzetVar, zzfyVarZzc3.zza, z2);
        zzetVar2.zzh(12);
        int iZzH4 = zzetVar2.zzH() - 1;
        int iZzH5 = zzetVar2.zzH();
        int iZzH6 = zzetVar2.zzH();
        if (zzetVar4 != null) {
            zzetVar4.zzh(12);
            iZzH = zzetVar4.zzH();
        } else {
            iZzH = 0;
        }
        if (zzetVar3 != null) {
            zzetVar3.zzh(12);
            iZzH2 = zzetVar3.zzH();
            if (iZzH2 > 0) {
                iZzH3 = zzetVar3.zzH() - 1;
                i = 0;
            } else {
                i = 0;
                iZzH3 = -1;
                zzetVar3 = null;
            }
        } else {
            iZzH2 = 0;
            i = 0;
            iZzH3 = -1;
        }
        int iZzb = zzalhVar.zzb();
        zzv zzvVar2 = zzamiVarZzb.zzg;
        if (iZzb != -1) {
            String str = zzvVar2.zzp;
            i2 = 1;
            if (("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && iZzH4 == 0) {
                if (iZzH == 0 && iZzH2 == 0) {
                    iZzH4 = i;
                    i3 = 1;
                } else {
                    i3 = i;
                    iZzH4 = i3;
                }
            }
            ArrayList arrayList = new ArrayList();
            ?? r31 = zzetVar3 != null ? i2 : i;
            if (i3 == 0) {
                int i18 = zzakzVar.zza;
                long[] jArr7 = new long[i18];
                int[] iArr3 = new int[i18];
                while (zzakzVar.zza()) {
                    int i19 = zzakzVar.zzb;
                    jArr7[i19] = zzakzVar.zzd;
                    iArr3[i19] = zzakzVar.zzc;
                }
                long j7 = iZzH6;
                int i20 = Utility.DEFAULT_STREAM_BUFFER_SIZE / iZzb;
                int i21 = i;
                int i22 = i21;
                while (i21 < i18) {
                    int i23 = iArr3[i21];
                    String str2 = zzfl.zza;
                    i22 += ((i23 + i20) - 1) / i20;
                    i21++;
                }
                long[] jArr8 = new long[i22];
                int[] iArr4 = new int[i22];
                jArr4 = new long[i22];
                int[] iArr5 = new int[i22];
                int i24 = i;
                int i25 = i24;
                int i26 = i25;
                int i27 = i26;
                int i28 = i27;
                while (i24 < i18) {
                    int i29 = iArr3[i24];
                    long j8 = jArr7[i24];
                    int i30 = i28;
                    int i31 = i18;
                    int iMax = i27;
                    int i32 = i30;
                    int i33 = i24;
                    int i34 = i29;
                    while (i34 > 0) {
                        int iMin = Math.min(i20, i34);
                        jArr8[i32] = j8;
                        int i35 = i34;
                        int i36 = iZzb * iMin;
                        iArr4[i32] = i36;
                        int i37 = i26 + i36;
                        iMax = Math.max(iMax, i36);
                        long j9 = j7;
                        jArr4[i32] = j9 * ((long) i25);
                        iArr5[i32] = i2;
                        j8 += (long) iArr4[i32];
                        i25 += iMin;
                        i34 = i35 - iMin;
                        i32++;
                        i26 = i37;
                        j7 = j9;
                    }
                    long j10 = j7;
                    i24 = i33 + 1;
                    int i38 = i32;
                    i27 = iMax;
                    i18 = i31;
                    i28 = i38;
                    j7 = j10;
                }
                j3 = i26;
                j2 = j7 * ((long) i25);
                zzvVar = zzvVar2;
                jArr5 = jArr8;
                i12 = i22;
                iArr = iArr4;
                i13 = i27;
                r15 = iArr5;
            } else {
                long[] jArr9 = new long[iZza];
                int[] iArr6 = new int[iZza];
                zzet zzetVar5 = zzetVar4;
                long[] jArrCopyOf = new long[iZza];
                int i39 = iZzH2;
                int i40 = iZzH3;
                zzald zzaldVar = zzalhVar;
                int iZzH7 = i40;
                zzvVar = zzvVar2;
                int i41 = iZzH;
                int i42 = iZzH4;
                long j11 = 0;
                long j12 = 0;
                long j13 = 0;
                int i43 = i;
                int i44 = i43;
                int i45 = i44;
                int iZzH8 = i45;
                int iZzB = iZzH6;
                int iZzB2 = iZzH8;
                ?? r4 = new int[iZza];
                while (true) {
                    if (i43 >= iZza) {
                        jArr = jArr9;
                        CopyOf = r4;
                        break;
                    }
                    long j14 = j11;
                    ?? r232 = i2;
                    while (true) {
                        if (i45 != 0) {
                            i14 = i45;
                            r23 = r232;
                            break;
                        }
                        boolean zZza = zzakzVar.zza();
                        if (!zZza) {
                            i14 = i;
                            r23 = zZza;
                            break;
                        }
                        j14 = zzakzVar.zzd;
                        i45 = zzakzVar.zzc;
                        iZza = iZza;
                        r232 = zZza;
                    }
                    int i46 = iZza;
                    if (r23 == 0) {
                        zzeg.zzc("BoxParsers", "Unexpected end of chunk data");
                        long[] jArrCopyOf2 = Arrays.copyOf(jArr9, i43);
                        int[] iArrCopyOf = Arrays.copyOf(iArr6, i43);
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i43);
                        jArr = jArrCopyOf2;
                        iArr6 = iArrCopyOf;
                        CopyOf = Arrays.copyOf((int[]) r4, i43);
                        iZza = i43;
                        break;
                    }
                    if (zzetVar5 != null) {
                        while (true) {
                            if (iZzH8 != 0) {
                                break;
                            }
                            if (i41 <= 0) {
                                iZzH8 = i;
                                break;
                            }
                            i41--;
                            iZzH8 = zzetVar5.zzH();
                            iZzB2 = zzetVar5.zzB();
                        }
                        iZzH8--;
                    }
                    int iZzc = zzaldVar.zzc();
                    ?? r38 = r4;
                    long[] jArr10 = jArr9;
                    long j15 = iZzc;
                    j13 += j15;
                    if (iZzc > i44) {
                        i44 = iZzc;
                    }
                    jArr10[i43] = j14;
                    iArr6[i43] = iZzc;
                    int i47 = i14;
                    jArrCopyOf[i43] = j12 + ((long) iZzB2);
                    r38[i43] = r31;
                    if (i43 == iZzH7) {
                        r38[i43] = i2;
                        arrayList.add(Integer.valueOf(i43));
                    }
                    if (zzetVar3 != null && i43 == iZzH7) {
                        int i48 = i39 - 1;
                        if (i48 > 0) {
                            i39 = i48;
                            iZzH7 = zzetVar3.zzH() - 1;
                        } else {
                            i39 = i48;
                        }
                    }
                    j12 += (long) iZzB;
                    iZzH5--;
                    if (iZzH5 == 0) {
                        if (i42 > 0) {
                            i42--;
                            iZzH5 = zzetVar2.zzH();
                            iZzB = zzetVar2.zzB();
                        } else {
                            iZzH5 = i;
                        }
                    }
                    long j16 = j14 + j15;
                    i45 = i47 - 1;
                    i43++;
                    jArr9 = jArr10;
                    r4 = r38;
                    iZza = i46;
                    j11 = j16;
                }
                long j17 = j12 + ((long) iZzB2);
                if (zzetVar5 != null) {
                    while (i41 > 0) {
                        if (zzetVar5.zzH() != 0) {
                            i4 = i;
                            break;
                        }
                        zzetVar5.zzB();
                        i41--;
                    }
                    i4 = i2;
                    if (i39 != 0) {
                        if (iZzH5 != 0) {
                            jArr2 = jArrCopyOf;
                            i5 = i4;
                            i6 = iZza;
                            i7 = iZzH5;
                            i11 = i;
                        } else if (i45 != 0) {
                            jArr2 = jArrCopyOf;
                            i5 = i4;
                            i6 = iZza;
                            i11 = i;
                            i7 = i11;
                        } else if (i42 != 0) {
                            jArr2 = jArrCopyOf;
                            i5 = i4;
                            i6 = iZza;
                            i11 = i;
                            i7 = i11;
                            i8 = i7;
                            i9 = i42;
                            i10 = iZzH8;
                        } else if (iZzH8 != 0) {
                            jArr2 = jArrCopyOf;
                            i5 = i4;
                            i6 = iZza;
                            i11 = i;
                            i7 = i11;
                            i8 = i7;
                            i9 = i8;
                            i10 = iZzH8;
                        } else if (i4 == 0) {
                            jArr2 = jArrCopyOf;
                            i6 = iZza;
                            i5 = i;
                            i11 = i5;
                            i7 = i11;
                            i8 = i7;
                            i9 = i8;
                            i10 = i9;
                        } else {
                            jArr2 = jArrCopyOf;
                            i6 = iZza;
                            j = j17;
                            jArr3 = jArr;
                            jArr4 = jArr2;
                            i12 = i6;
                            jArr5 = jArr3;
                            iArr = iArr6;
                            j2 = j;
                            j3 = j13;
                            i13 = i44;
                            r15 = CopyOf;
                        }
                        i8 = i45;
                        i9 = i42;
                        i10 = iZzH8;
                    } else {
                        jArr2 = jArrCopyOf;
                        i5 = i4;
                        i6 = iZza;
                        i7 = iZzH5;
                        i8 = i45;
                        i9 = i42;
                        i10 = iZzH8;
                        i11 = i39;
                    }
                    int i49 = zzamiVarZzb.zza;
                    int length2 = String.valueOf(i9).length() + String.valueOf(i8).length() + String.valueOf(i7).length() + String.valueOf(i11).length() + String.valueOf(i49).length() + 66 + 35 + 26 + 33 + 36;
                    int length3 = String.valueOf(i10).length();
                    j = j17;
                    String str3 = i2 == i5 ? ", ctts invalid" : "";
                    StringBuilder sb = new StringBuilder(str3.length() + length2 + length3);
                    jArr3 = jArr;
                    Fragment$$ExternalSyntheticOutline1.m(sb, "Inconsistent stbl box for track ", i49, ": remainingSynchronizationSamples ", i11);
                    Fragment$$ExternalSyntheticOutline1.m(sb, ", remainingSamplesAtTimestampDelta ", i7, ", remainingSamplesInChunk ", i8);
                    Fragment$$ExternalSyntheticOutline1.m(sb, ", remainingTimestampDeltaChanges ", i9, ", remainingSamplesAtTimestampOffset ", i10);
                    sb.append(str3);
                    zzeg.zzc("BoxParsers", sb.toString());
                    jArr4 = jArr2;
                    i12 = i6;
                    jArr5 = jArr3;
                    iArr = iArr6;
                    j2 = j;
                    j3 = j13;
                    i13 = i44;
                    r15 = CopyOf;
                } else {
                    i4 = i2;
                    if (i39 != 0) {
                    }
                    int i492 = zzamiVarZzb.zza;
                    int length22 = String.valueOf(i9).length() + String.valueOf(i8).length() + String.valueOf(i7).length() + String.valueOf(i11).length() + String.valueOf(i492).length() + 66 + 35 + 26 + 33 + 36;
                    int length32 = String.valueOf(i10).length();
                    j = j17;
                    if (i2 == i5) {
                    }
                    StringBuilder sb2 = new StringBuilder(str3.length() + length22 + length32);
                    jArr3 = jArr;
                    Fragment$$ExternalSyntheticOutline1.m(sb2, "Inconsistent stbl box for track ", i492, ": remainingSynchronizationSamples ", i11);
                    Fragment$$ExternalSyntheticOutline1.m(sb2, ", remainingSamplesAtTimestampDelta ", i7, ", remainingSamplesInChunk ", i8);
                    Fragment$$ExternalSyntheticOutline1.m(sb2, ", remainingTimestampDeltaChanges ", i9, ", remainingSamplesAtTimestampOffset ", i10);
                    sb2.append(str3);
                    zzeg.zzc("BoxParsers", sb2.toString());
                    jArr4 = jArr2;
                    i12 = i6;
                    jArr5 = jArr3;
                    iArr = iArr6;
                    j2 = j;
                    j3 = j13;
                    i13 = i44;
                    r15 = CopyOf;
                }
            }
            j4 = zzamiVarZzb.zzf;
            if (j4 > 0) {
                long jZzv = zzfl.zzv(j3 * 8, 1000000L, j4, RoundingMode.HALF_DOWN);
                if (jZzv > 0 && jZzv < 2147483647L) {
                    zzt zztVarZza2 = zzvVar.zza();
                    zztVarZza2.zzi((int) jZzv);
                    zzamiVarZzb = zzamiVarZzb.zzb(zztVarZza2.zzO());
                }
            }
            long j18 = zzamiVarZzb.zzc;
            RoundingMode roundingMode = RoundingMode.DOWN;
            long jZzv2 = zzfl.zzv(j2, 1000000L, j18, roundingMode);
            int[] iArrZzf = zzhah.zzf(arrayList);
            jArr6 = zzamiVarZzb.zzi;
            if (jArr6 != null) {
                zzfl.zzw(jArr4, 1000000L, j18);
                return new zzaml(zzamiVarZzb, jArr5, iArr, i13, jArr4, r15, iArrZzf, r31, jZzv2, i12);
            }
            ?? r29 = r15;
            int length4 = jArr6.length;
            if (length4 == 1) {
                if (zzamiVarZzb.zzb != 1 || (length = jArr4.length) < 2) {
                    j5 = j18;
                } else {
                    long[] jArr11 = zzamiVarZzb.zzj;
                    jArr11.getClass();
                    long j19 = jArr11[i];
                    long j20 = jArr6[i];
                    long j21 = zzamiVarZzb.zzd;
                    long jZzv3 = zzfl.zzv(j20, j18, j21, roundingMode) + j19;
                    int i50 = length - 1;
                    int i51 = i;
                    int iMax2 = Math.max(i51, Math.min(4, i50));
                    int iMax3 = Math.max(i51, Math.min(length - 4, i50));
                    if (jArr4[i51] > j19 || j19 >= jArr4[iMax2] || jArr4[iMax3] >= jZzv3 || jZzv3 > 2 + j2) {
                        j5 = j18;
                    } else {
                        long jMax = Math.max(0L, j2 - jZzv3);
                        long j22 = j19 - jArr4[0];
                        long j23 = zzamiVarZzb.zzg.zzI;
                        long jZzv4 = zzfl.zzv(j22, j23, j18, roundingMode);
                        long jZzv5 = zzfl.zzv(jMax, j23, j18, roundingMode);
                        j5 = j18;
                        if (jZzv4 != 0) {
                            if (jZzv4 <= 2147483647L && jZzv5 <= 2147483647L) {
                                zzagrVar.zza = (int) jZzv4;
                                zzagrVar.zzb = (int) jZzv5;
                                zzfl.zzw(jArr4, 1000000L, j5);
                                return new zzaml(zzamiVarZzb, jArr5, iArr, i13, jArr4, r29, iArrZzf, r31, zzfl.zzv(jArr6[0], 1000000L, j21, roundingMode), i12);
                            }
                        } else if (jZzv5 != 0) {
                            jZzv4 = 0;
                            if (jZzv4 <= 2147483647L) {
                                zzagrVar.zza = (int) jZzv4;
                                zzagrVar.zzb = (int) jZzv5;
                                zzfl.zzw(jArr4, 1000000L, j5);
                                return new zzaml(zzamiVarZzb, jArr5, iArr, i13, jArr4, r29, iArrZzf, r31, zzfl.zzv(jArr6[0], 1000000L, j21, roundingMode), i12);
                            }
                        }
                    }
                }
                i15 = 1;
                length4 = 1;
            } else {
                j5 = j18;
                i15 = 1;
            }
            if (length4 == i15 && jArr6[0] == 0) {
                long[] jArr12 = zzamiVarZzb.zzj;
                jArr12.getClass();
                long j24 = jArr12[0];
                int i52 = 0;
                while (i52 < jArr4.length) {
                    long j25 = j5;
                    jArr4[i52] = zzfl.zzv(jArr4[i52] - j24, 1000000L, j25, RoundingMode.DOWN);
                    i52++;
                    j5 = j25;
                }
                return new zzaml(zzamiVarZzb, jArr5, iArr, i13, jArr4, r29, iArrZzf, r31, zzfl.zzv(j2 - j24, 1000000L, j5, RoundingMode.DOWN), i12);
            }
            long j26 = j5;
            long[] jArr13 = jArr5;
            int[] iArr7 = iArr;
            int i53 = i12;
            boolean z5 = zzamiVarZzb.zzb == 1;
            long[] jArr14 = zzamiVarZzb.zzj;
            int[] iArr8 = new int[length4];
            int[] iArr9 = new int[length4];
            jArr14.getClass();
            int i54 = 0;
            int i55 = 0;
            boolean z6 = false;
            int i56 = 0;
            while (i54 < jArr6.length) {
                int[] iArr10 = iArr9;
                long j27 = jArr14[i54];
                if (j27 != -1) {
                    iArr2 = iArr8;
                    i16 = i54;
                    long j28 = j26;
                    j26 = j28;
                    long jZzv6 = zzfl.zzv(jArr6[i54], j28, zzamiVarZzb.zzd, RoundingMode.DOWN) + j27;
                    boolean z7 = z6;
                    iArr2[i16] = zzfl.zzo(jArr4, j27, true, true);
                    int iZzq = zzfl.zzq(jArr4, jZzv6, z5, false);
                    z3 = z5;
                    int i57 = iZzq - 1;
                    int i58 = 0;
                    for (int i59 = iZzq; i59 < jArr4.length; i59++) {
                        if (jArr4[i59] >= jZzv6) {
                            i58++;
                            if (i58 > zzamiVarZzb.zzg.zzr) {
                                break;
                            }
                        } else {
                            i57 = i59;
                        }
                    }
                    iArr10[i16] = i57 + 1;
                    int i60 = iArr2[i16];
                    while (true) {
                        i17 = iArr2[i16];
                        if (i17 <= 0 || (r29[i17] & 1) != 0) {
                            break;
                        }
                        iArr2[i16] = i17 - 1;
                    }
                    if (i17 == 0) {
                        z4 = false;
                        if ((r29[0] & 1) == 0) {
                            iArr2[i16] = i60;
                            while (true) {
                                i17 = iArr2[i16];
                                if (i17 >= iArr10[i16] || (r29[i17] & 1) != 0) {
                                    break;
                                }
                                iArr2[i16] = i17 + 1;
                            }
                        }
                    } else {
                        z4 = false;
                    }
                    int i61 = iArr10[i16];
                    int i62 = (i61 - i17) + i55;
                    boolean z8 = i56 != i17 ? true : z4;
                    i56 = i61;
                    z6 = z7 | z8;
                    i55 = i62;
                } else {
                    z3 = z5;
                    iArr2 = iArr8;
                    i16 = i54;
                }
                i54 = i16 + 1;
                iArr9 = iArr10;
                iArr8 = iArr2;
                z5 = z3;
            }
            int[] iArr11 = iArr9;
            int[] iArr12 = iArr8;
            boolean z9 = z6 | (i55 != i53);
            long[] jArr15 = z9 ? new long[i55] : jArr13;
            int[] iArr13 = z9 ? new int[i55] : iArr7;
            if (true == z9) {
                i13 = 0;
            }
            ?? r5 = z9 ? new int[i55] : r29;
            if (z9) {
                arrayList = new ArrayList();
            }
            long[] jArr16 = new long[i55];
            int i63 = 0;
            boolean z10 = false;
            int i64 = 0;
            int i65 = i13;
            long j29 = 0;
            ?? r52 = r5;
            while (i63 < jArr6.length) {
                long j30 = jArr14[i63];
                int i66 = iArr12[i63];
                long[] jArr17 = jArr6;
                int i67 = iArr11[i63];
                long[] jArr18 = jArr16;
                if (z9) {
                    int i68 = i67 - i66;
                    System.arraycopy(jArr13, i66, jArr15, i64, i68);
                    System.arraycopy(iArr7, i66, iArr13, i64, i68);
                    System.arraycopy(r29, i66, r52, i64, i68);
                }
                while (i66 < i67) {
                    int[] iArr14 = iArr13;
                    ?? r45 = r52;
                    long j31 = zzamiVarZzb.zzd;
                    RoundingMode roundingMode2 = RoundingMode.DOWN;
                    long jZzv7 = zzfl.zzv(j29, 1000000L, j31, roundingMode2);
                    long jZzv8 = zzfl.zzv(jArr4[i66] - j30, 1000000L, j26, roundingMode2);
                    z10 = (!(jZzv8 >= 0)) | z10;
                    jArr18[i64] = jZzv7 + jZzv8;
                    if (z9 && iArr14[i64] > i65) {
                        i65 = iArr7[i66];
                    }
                    if (z9 && r31 == 0 && (r45[i64] & 1) != 0) {
                        arrayList.add(Integer.valueOf(i64));
                    }
                    i64++;
                    i66++;
                    r52 = r45;
                    iArr13 = iArr14;
                }
                j29 += jArr17[i63];
                i63++;
                r52 = r52;
                iArr13 = iArr13;
                jArr6 = jArr17;
                jArr16 = jArr18;
            }
            ?? r452 = r52;
            long[] jArr19 = jArr16;
            int[] iArr15 = iArr13;
            long jZzv9 = zzfl.zzv(j29, 1000000L, zzamiVarZzb.zzd, RoundingMode.DOWN);
            if (z10) {
                zzt zztVarZza3 = zzamiVarZzb.zzg.zza();
                zztVarZza3.zzu(true);
                zzamiVarZzb = zzamiVarZzb.zzb(zztVarZza3.zzO());
            }
            return new zzaml(zzamiVarZzb, jArr15, iArr15, i65, jArr19, r452, zzhah.zzf(arrayList), r31, jZzv9, jArr15.length);
        }
        i2 = 1;
        i3 = i;
        ArrayList arrayList2 = new ArrayList();
        if (zzetVar3 != null) {
        }
        if (i3 == 0) {
        }
        j4 = zzamiVarZzb.zzf;
        if (j4 > 0) {
        }
        long j182 = zzamiVarZzb.zzc;
        RoundingMode roundingMode3 = RoundingMode.DOWN;
        long jZzv22 = zzfl.zzv(j2, 1000000L, j182, roundingMode3);
        int[] iArrZzf2 = zzhah.zzf(arrayList2);
        jArr6 = zzamiVarZzb.zzi;
        if (jArr6 != null) {
        }
    }

    public static zzap zzh(zzet zzetVar) {
        try {
            zzetVar.zzk(5);
            int iZzB = zzetVar.zzB();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < iZzB; i++) {
                long jZzD = zzetVar.zzD() / 10000;
                if (jZzD < 0) {
                    jZzD = -9223372036854775807L;
                }
                arrayList.add(zzaiv.zzb(jZzD, -9223372036854775807L, zzetVar.zzK(zzetVar.zzs(), StandardCharsets.UTF_8)));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new zzap(arrayList);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    private static zzap zzi(zzet zzetVar) {
        short sZzv = zzetVar.zzv();
        zzetVar.zzk(2);
        String strZzK = zzetVar.zzK(sZzv, StandardCharsets.UTF_8);
        int iMax = Math.max(strZzK.lastIndexOf(43), strZzK.lastIndexOf(45));
        try {
            return new zzap(-9223372036854775807L, new zzga(Float.parseFloat(strZzK.substring(0, iMax)), Float.parseFloat(strZzK.substring(iMax, strZzK.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static int zzj(zzet zzetVar) {
        zzetVar.zzh(16);
        return zzetVar.zzB();
    }

    private static String zzk(byte[] bArr, int i, int i2) {
        zzgtj.zzi(bArr.length == 64);
        ArrayList arrayList = new ArrayList(16);
        for (int i3 = 0; i3 < bArr.length - 3; i3 += 4) {
            int iZze = zzhah.zze(bArr[i3], bArr[i3 + 1], bArr[i3 + 2], bArr[i3 + 3]);
            String str = zzfl.zza;
            int i4 = ((iZze >> 8) & PHIpAddressSearchManager.END_IP_SCAN) - 128;
            int i5 = (iZze >> 16) & PHIpAddressSearchManager.END_IP_SCAN;
            int iMax = Math.max(0, Math.min(((i4 * 14075) / 10000) + i5, PHIpAddressSearchManager.END_IP_SCAN)) << 16;
            int i6 = (iZze & PHIpAddressSearchManager.END_IP_SCAN) - 128;
            arrayList.add(String.format("%06x", Integer.valueOf(Math.max(0, Math.min(((i6 * 17790) / 10000) + i5, PHIpAddressSearchManager.END_IP_SCAN)) | iMax | (Math.max(0, Math.min((i5 - ((i6 * 3455) / 10000)) - ((i4 * 7169) / 10000), PHIpAddressSearchManager.END_IP_SCAN)) << 8))));
        }
        String strZzd = zzgtd.zzd(arrayList, ", ");
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(String.valueOf(i).length() + 7, 10, String.valueOf(i2)), 1, strZzd));
        sb.append("size: ");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return Fragment$$ExternalSyntheticOutline1.m(sb, "\npalette: ", strZzd, "\n");
    }

    private static zzi zzl(zzet zzetVar) {
        zzh zzhVar = new zzh();
        byte[] bArrZzi = zzetVar.zzi();
        zzes zzesVar = new zzes(bArrZzi, bArrZzi.length);
        zzesVar.zzf(zzetVar.zzg() * 8);
        zzesVar.zzo(1);
        int iZzj = zzesVar.zzj(8);
        for (int i = 0; i < iZzj; i++) {
            zzesVar.zzo(1);
            int iZzj2 = zzesVar.zzj(8);
            for (int i2 = 0; i2 < iZzj2; i2++) {
                zzesVar.zzh(6);
                boolean zZzi = zzesVar.zzi();
                zzesVar.zzg();
                zzesVar.zzo(11);
                zzesVar.zzh(4);
                int iZzj3 = zzesVar.zzj(4) + 8;
                zzhVar.zze(iZzj3);
                zzhVar.zzf(iZzj3);
                zzesVar.zzo(1);
                if (zZzi) {
                    int iZzj4 = zzesVar.zzj(8);
                    int iZzj5 = zzesVar.zzj(8);
                    zzesVar.zzo(1);
                    boolean zZzi2 = zzesVar.zzi();
                    zzhVar.zza(zzi.zzb(iZzj4));
                    zzhVar.zzb(true != zZzi2 ? 2 : 1);
                    zzhVar.zzc(zzi.zzc(iZzj5));
                }
            }
        }
        return zzhVar.zzg();
    }

    private static ByteBuffer zzm() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static Pair zzn(zzfx zzfxVar) {
        zzfy zzfyVarZzc = zzfxVar.zzc(1701606260);
        if (zzfyVarZzc == null) {
            return null;
        }
        zzet zzetVar = zzfyVarZzc.zza;
        zzetVar.zzh(8);
        int iZza = zza(zzetVar.zzB());
        int iZzH = zzetVar.zzH();
        long[] jArr = new long[iZzH];
        long[] jArr2 = new long[iZzH];
        for (int i = 0; i < iZzH; i++) {
            jArr[i] = iZza == 1 ? zzetVar.zzJ() : zzetVar.zzz();
            jArr2[i] = iZza == 1 ? zzetVar.zzD() : zzetVar.zzB();
            if (zzetVar.zzv() != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Unsupported media rate.");
                return null;
            }
            zzetVar.zzk(2);
        }
        return Pair.create(jArr, jArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zzo(zzet zzetVar, int i, int i2, int i3, int i4, String str, boolean z, zzq zzqVar, zzalf zzalfVar, int i5) throws zzat {
        int iZzt;
        int i6;
        int iZzB;
        int iZzH;
        int iRound;
        int iZzC;
        String str2;
        int i7;
        int i8;
        String str3;
        int i9;
        int i10;
        int iZzB2;
        String str4;
        int i11;
        boolean z2;
        int i12 = i;
        int i13 = i3;
        zzq zzqVarZzb = zzqVar;
        zzetVar.zzh(i2 + 16);
        if (z) {
            iZzt = zzetVar.zzt();
            zzetVar.zzk(6);
        } else {
            zzetVar.zzk(8);
            iZzt = 0;
        }
        if (iZzt == 0 || iZzt == 1) {
            i6 = 2;
            int iZzt2 = zzetVar.zzt();
            zzetVar.zzk(6);
            int iZzF = zzetVar.zzF();
            zzetVar.zzh(zzetVar.zzg() - 4);
            iZzB = zzetVar.zzB();
            if (iZzt == 1) {
                zzetVar.zzk(16);
            }
            iZzH = iZzt2;
            iRound = iZzF;
            iZzC = -1;
        } else {
            if (iZzt != 2) {
                return;
            }
            zzetVar.zzk(16);
            iRound = (int) Math.round(Double.longBitsToDouble(zzetVar.zzD()));
            iZzH = zzetVar.zzH();
            zzetVar.zzk(4);
            i6 = 2;
            int iZzH2 = zzetVar.zzH();
            int iZzH3 = zzetVar.zzH();
            int i14 = iZzH3 & 1;
            int i15 = iZzH3 & 2;
            if (i14 == 0) {
                iZzC = zzfl.zzB(iZzH2, i15 != 0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            } else {
                iZzC = i15 == 0 ? zzfl.zzC(iZzH2) : -1;
            }
            if (iZzC == 0) {
                iZzC = -1;
            }
            zzetVar.zzk(8);
            iZzB = 0;
        }
        if (i12 == 1767992678) {
            iRound = -1;
            iZzH = -1;
        } else {
            if (i12 == 1935764850) {
                iRound = 8000;
            } else if (i12 == 1935767394) {
                iRound = 16000;
                i12 = 1935767394;
            }
            iZzH = 1;
        }
        int iZzg = zzetVar.zzg();
        int iIntValue = 1701733217;
        if (i12 == 1701733217) {
            Pair pairZzr = zzr(zzetVar, i2, i13);
            if (pairZzr != null) {
                iIntValue = ((Integer) pairZzr.first).intValue();
                zzqVarZzb = zzqVarZzb == null ? null : zzqVarZzb.zzb(((zzamj) pairZzr.second).zzb);
                zzalfVar.zza[i5] = (zzamj) pairZzr.second;
            }
            i12 = iIntValue;
            zzetVar.zzh(iZzg);
        }
        String str5 = "audio/mhm1";
        if (i12 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i12 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i12 == 1633889588) {
            str2 = "audio/ac4";
        } else if (i12 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i12 == 1685353320 || i12 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i12 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i12 == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (i12 == 1935764850) {
            str2 = "audio/3gpp";
        } else if (i12 == 1935767394) {
            str2 = "audio/amr-wb";
        } else if (i12 != 1936684916) {
            if (i12 == 1953984371) {
                iZzC = ClientDefaults.MAX_MSG_SIZE;
            } else if (i12 == 1819304813) {
                if (iZzC == -1) {
                    iZzC = i6;
                }
            } else if (i12 == 778924082 || i12 == 778924083) {
                str2 = "audio/mpeg";
            } else if (i12 == 1835557169) {
                str2 = "audio/mha1";
            } else if (i12 == 1835560241) {
                str2 = "audio/mhm1";
            } else if (i12 == 1634492771) {
                str2 = "audio/alac";
            } else if (i12 == 1634492791) {
                str2 = "audio/g711-alaw";
            } else if (i12 == 1970037111) {
                str2 = "audio/g711-mlaw";
            } else if (i12 == 1332770163) {
                str2 = "audio/opus";
            } else if (i12 == 1716281667) {
                str2 = "audio/flac";
            } else if (i12 == 1835823201) {
                str2 = "audio/true-hd";
            } else if (i12 == 1767992678) {
                str2 = "audio/iamf";
                i12 = 1767992678;
            } else {
                str2 = null;
            }
            str2 = "audio/raw";
        }
        int i16 = iZzC;
        List listZzj = null;
        String strM = null;
        zzala zzalaVarZzp = null;
        zzaky zzakyVarZzq = null;
        while (iZzg - i2 < i13) {
            zzetVar.zzh(iZzg);
            int iZzB3 = zzetVar.zzB();
            String str6 = strM;
            String str7 = "childAtomSize must be positive";
            zzagc.zza(iZzB3 > 0, "childAtomSize must be positive");
            int iZzB4 = zzetVar.zzB();
            int i17 = iRound;
            if (iZzB4 == 1835557187) {
                zzetVar.zzh(iZzg + 8);
                zzetVar.zzk(1);
                int iZzs = zzetVar.zzs();
                zzetVar.zzk(1);
                String str8 = Objects.equals(str2, str5) ? String.format("mhm1.%02X", Integer.valueOf(iZzs)) : String.format("mha1.%02X", Integer.valueOf(iZzs));
                int iZzt3 = zzetVar.zzt();
                byte[] bArr = new byte[iZzt3];
                str6 = str8;
                zzetVar.zzm(bArr, 0, iZzt3);
                if (listZzj == null) {
                    listZzj = zzgwm.zzj(bArr);
                    iZzB2 = i16;
                    i7 = iZzB3;
                    i8 = iZzB;
                    str3 = str5;
                    iRound = i17;
                    strM = str6;
                    iZzg += i7;
                    i16 = iZzB2;
                    str5 = str3;
                    iZzB = i8;
                    i6 = 2;
                    i13 = i3;
                } else {
                    listZzj = zzgwm.zzk(bArr, (byte[]) listZzj.get(0));
                    iZzB2 = i16;
                    i7 = iZzB3;
                    i8 = iZzB;
                    str3 = str5;
                    strM = str6;
                    iRound = i17;
                }
            } else {
                if (iZzB4 == 1835557200) {
                    zzetVar.zzh(iZzg + 8);
                    int iZzs2 = zzetVar.zzs();
                    if (iZzs2 > 0) {
                        byte[] bArr2 = new byte[iZzs2];
                        zzetVar.zzm(bArr2, 0, iZzs2);
                        if (listZzj == null) {
                            listZzj = zzgwm.zzj(bArr2);
                            iZzB2 = i16;
                            i7 = iZzB3;
                            i8 = iZzB;
                            str3 = str5;
                            strM = str6;
                            iRound = i17;
                        } else {
                            listZzj = zzgwm.zzk((byte[]) listZzj.get(0), bArr2);
                            iZzB2 = i16;
                            i7 = iZzB3;
                            i8 = iZzB;
                            str3 = str5;
                            strM = str6;
                            iRound = i17;
                        }
                    }
                    i7 = iZzB3;
                    i8 = iZzB;
                    str3 = str5;
                    iRound = i17;
                    iZzB2 = i16;
                    strM = str6;
                } else {
                    if (iZzB4 == 1702061171) {
                        i7 = iZzB3;
                        i8 = iZzB;
                        str3 = str5;
                        iRound = i17;
                        i9 = iZzg;
                        i10 = -1;
                    } else if (z && iZzB4 == 2002876005) {
                        int iZzg2 = zzetVar.zzg();
                        zzagc.zza(iZzg2 >= iZzg, null);
                        int i18 = iZzg2;
                        while (true) {
                            if (i18 - iZzg >= iZzB3) {
                                i7 = iZzB3;
                                i8 = iZzB;
                                str3 = str5;
                                iRound = i17;
                                i9 = -1;
                                i10 = -1;
                                break;
                            }
                            zzetVar.zzh(i18);
                            int iZzB5 = zzetVar.zzB();
                            if (iZzB5 > 0) {
                                i11 = i18;
                                z2 = true;
                            } else {
                                i11 = i18;
                                z2 = false;
                            }
                            zzagc.zza(z2, str7);
                            String str9 = str7;
                            if (zzetVar.zzB() == 1702061171) {
                                i7 = iZzB3;
                                i8 = iZzB;
                                iRound = i17;
                                i9 = i11;
                                i10 = -1;
                                str3 = str5;
                                break;
                            }
                            i18 = i11 + iZzB5;
                            str7 = str9;
                        }
                    } else if (iZzB4 == 1651798644) {
                        zzakyVarZzq = zzq(zzetVar, iZzg);
                        iZzB2 = i16;
                        i7 = iZzB3;
                        i8 = iZzB;
                        str3 = str5;
                        strM = str6;
                        iRound = i17;
                    } else {
                        if (iZzB4 == 1684103987) {
                            zzetVar.zzh(iZzg + 8);
                            zzalfVar.zzb = zzaey.zza(zzetVar, Integer.toString(i4), str, zzqVarZzb);
                        } else if (iZzB4 == 1684366131) {
                            zzetVar.zzh(iZzg + 8);
                            zzalfVar.zzb = zzaey.zzb(zzetVar, Integer.toString(i4), str, zzqVarZzb);
                        } else if (iZzB4 == 1684103988) {
                            zzetVar.zzh(iZzg + 8);
                            zzalfVar.zzb = zzafb.zza(zzetVar, Integer.toString(i4), str, zzqVarZzb);
                        } else if (iZzB4 != 1684892784) {
                            if (iZzB4 == 1684305011 || iZzB4 == 1969517683) {
                                i7 = iZzB3;
                                i8 = iZzB;
                                str3 = str5;
                                zzt zztVar = new zzt();
                                zztVar.zzb(i4);
                                zztVar.zzo(str2);
                                zztVar.zzG(iZzH);
                                iRound = i17;
                                zztVar.zzH(iRound);
                                zztVar.zzs(zzqVarZzb);
                                zztVar.zze(str);
                                zzalfVar.zzb = zztVar.zzO();
                            } else {
                                if (iZzB4 == 1682927731) {
                                    int i19 = iZzB3 - 8;
                                    byte[] bArr3 = zzb;
                                    int length = bArr3.length;
                                    i7 = iZzB3;
                                    byte[] bArrCopyOf = Arrays.copyOf(bArr3, length + i19);
                                    zzetVar.zzh(iZzg + 8);
                                    zzetVar.zzm(bArrCopyOf, length, i19);
                                    listZzj = zzgv.zza(bArrCopyOf);
                                } else {
                                    i7 = iZzB3;
                                    if (iZzB4 == 1684425825) {
                                        byte[] bArr4 = new byte[i7 - 8];
                                        bArr4[0] = 102;
                                        bArr4[1] = 76;
                                        bArr4[i6] = 97;
                                        bArr4[3] = 67;
                                        zzetVar.zzh(iZzg + 12);
                                        zzetVar.zzm(bArr4, 4, i7 - 12);
                                        listZzj = zzgwm.zzj(bArr4);
                                    } else if (iZzB4 == 1634492771) {
                                        int i20 = i7 - 12;
                                        byte[] bArr5 = new byte[i20];
                                        zzetVar.zzh(iZzg + 12);
                                        zzetVar.zzm(bArr5, 0, i20);
                                        int i21 = zzdq.$r8$clinit;
                                        zzet zzetVar2 = new zzet(bArr5);
                                        zzetVar2.zzh(5);
                                        int iZzs3 = zzetVar2.zzs();
                                        zzetVar2.zzh(9);
                                        int iZzs4 = zzetVar2.zzs();
                                        zzetVar2.zzh(20);
                                        int[] iArr = {zzetVar2.zzH(), iZzs4, iZzs3};
                                        int i22 = iArr[0];
                                        int i23 = iArr[1];
                                        int iZzB6 = zzfl.zzB(iZzs3, ByteOrder.LITTLE_ENDIAN);
                                        if (iZzB6 == 0) {
                                            iZzB6 = -1;
                                        }
                                        iRound = i22;
                                        i8 = iZzB;
                                        str3 = str5;
                                        iZzH = i23;
                                        listZzj = zzgwm.zzj(bArr5);
                                        iZzB2 = iZzB6;
                                        strM = str6;
                                    } else {
                                        if (iZzB4 == 1767990114) {
                                            zzetVar.zzh(iZzg + 9);
                                            int iZza = zzhah.zza(zzetVar.zzP());
                                            byte[] bArr6 = new byte[iZza];
                                            zzetVar.zzm(bArr6, 0, iZza);
                                            int i24 = zzdq.$r8$clinit;
                                            zzet zzetVar3 = new zzet(bArr6);
                                            String str10 = null;
                                            String str11 = null;
                                            while (zzetVar3.zzd() > 0 && (str11 == null || str10 == null)) {
                                                int iZzs5 = zzetVar3.zzs();
                                                int i25 = iZzs5 >> 3;
                                                int i26 = iZzs5 & 2;
                                                int i27 = iZzs5 & 1;
                                                int iZza2 = zzhah.zza(zzetVar3.zzP());
                                                byte[] bArr7 = bArr6;
                                                if (i25 > 4 && i25 < 24 && i26 != 0) {
                                                    zzetVar3.zzQ();
                                                    zzetVar3.zzQ();
                                                }
                                                if (i27 != 0) {
                                                    zzetVar3.zzk(zzhah.zza(zzetVar3.zzP()));
                                                }
                                                int iZzg3 = zzetVar3.zzg() + iZza2;
                                                int i28 = iZzB;
                                                if (i25 == 31) {
                                                    zzetVar3.zzk(4);
                                                    Object[] objArr = {Integer.valueOf(zzetVar3.zzs()), Integer.valueOf(zzetVar3.zzs())};
                                                    String str12 = zzfl.zza;
                                                    str11 = String.format(Locale.US, "iamf.%03X.%03X", objArr);
                                                } else {
                                                    if (i25 == 0) {
                                                        zzetVar3.zzQ();
                                                        String strZzK = zzetVar3.zzK(4, StandardCharsets.UTF_8);
                                                        if (strZzK.equals(AudioSampleEntry.TYPE3)) {
                                                            zzetVar3.zzQ();
                                                            zzetVar3.zzk(i6);
                                                            zzes zzesVar = new zzes();
                                                            zzesVar.zza(zzetVar3);
                                                            str4 = str5;
                                                            int iZzj = zzesVar.zzj(5);
                                                            if (iZzj == 31) {
                                                                iZzj = zzesVar.zzj(6) + 32;
                                                            }
                                                            StringBuilder sb = new StringBuilder(strZzK.length() + 4 + String.valueOf(iZzj).length());
                                                            sb.append(strZzK);
                                                            sb.append(".40.");
                                                            sb.append(iZzj);
                                                            strZzK = sb.toString();
                                                        } else {
                                                            str4 = str5;
                                                        }
                                                        str10 = strZzK;
                                                    }
                                                    zzetVar3.zzh(iZzg3);
                                                    str5 = str4;
                                                    iZzB = i28;
                                                    bArr6 = bArr7;
                                                    i6 = 2;
                                                }
                                                str4 = str5;
                                                zzetVar3.zzh(iZzg3);
                                                str5 = str4;
                                                iZzB = i28;
                                                bArr6 = bArr7;
                                                i6 = 2;
                                            }
                                            byte[] bArr8 = bArr6;
                                            i8 = iZzB;
                                            str3 = str5;
                                            strM = (str11 == null || str10 == null) ? null : Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(str11.length() + 1 + str10.length()), str11, ".", str10);
                                            listZzj = zzgwm.zzj(bArr8);
                                            iZzB2 = i16;
                                        } else {
                                            i8 = iZzB;
                                            str3 = str5;
                                            if (iZzB4 == 1885564227) {
                                                zzetVar.zzh(iZzg + 12);
                                                ByteOrder byteOrder = (zzetVar.zzs() & 1) != 0 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
                                                int iZzs6 = zzetVar.zzs();
                                                iZzB2 = i12 == 1768973165 ? zzfl.zzB(iZzs6, byteOrder) : (i12 == 1718641517 && byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) ? zzfl.zzC(iZzs6) : i16;
                                                if (iZzB2 == 0) {
                                                    iZzB2 = -1;
                                                }
                                                if (iZzB2 != -1) {
                                                    str2 = "audio/raw";
                                                }
                                                strM = str6;
                                            } else {
                                                iRound = i17;
                                            }
                                        }
                                        iRound = i17;
                                    }
                                }
                                iZzB2 = i16;
                                i8 = iZzB;
                                str3 = str5;
                                strM = str6;
                                iRound = i17;
                            }
                            iZzB2 = i16;
                            strM = str6;
                        } else {
                            if (iZzB <= 0) {
                                StringBuilder sb2 = new StringBuilder(String.valueOf(iZzB).length() + 49);
                                sb2.append("Invalid sample rate for Dolby TrueHD MLP stream: ");
                                sb2.append(iZzB);
                                throw zzat.zzb(sb2.toString(), null);
                            }
                            iZzB2 = i16;
                            i7 = iZzB3;
                            iRound = iZzB;
                            i8 = iRound;
                            str3 = str5;
                            iZzH = i6;
                            strM = str6;
                        }
                        i7 = iZzB3;
                        i8 = iZzB;
                        str3 = str5;
                        iRound = i17;
                        iZzB2 = i16;
                        strM = str6;
                    }
                    if (i9 != i10) {
                        zzalaVarZzp = zzp(zzetVar, i9);
                        String strZza = zzalaVarZzp.zza();
                        byte[] bArrZzb = zzalaVarZzp.zzb();
                        if (bArrZzb != null) {
                            if ("audio/vorbis".equals(strZza)) {
                                int i29 = zzahm.$r8$clinit;
                                zzet zzetVar4 = new zzet(bArrZzb);
                                int i30 = 1;
                                zzetVar4.zzk(1);
                                int i31 = 0;
                                while (zzetVar4.zzd() > 0 && zzetVar4.zzn() == 255) {
                                    zzetVar4.zzk(i30);
                                    i31 += PHIpAddressSearchManager.END_IP_SCAN;
                                    i30 = 1;
                                }
                                int iZzs7 = zzetVar4.zzs() + i31;
                                int i32 = 0;
                                while (zzetVar4.zzd() > 0 && zzetVar4.zzn() == 255) {
                                    zzetVar4.zzk(1);
                                    i32 += PHIpAddressSearchManager.END_IP_SCAN;
                                }
                                int iZzs8 = zzetVar4.zzs() + i32;
                                byte[] bArr9 = new byte[iZzs7];
                                int iZzg4 = zzetVar4.zzg();
                                System.arraycopy(bArrZzb, iZzg4, bArr9, 0, iZzs7);
                                int i33 = iZzg4 + iZzs7 + iZzs8;
                                int length2 = bArrZzb.length - i33;
                                byte[] bArr10 = new byte[length2];
                                System.arraycopy(bArrZzb, i33, bArr10, 0, length2);
                                listZzj = zzgwm.zzk(bArr9, bArr10);
                            } else {
                                if ("audio/mp4a-latm".equals(strZza)) {
                                    zzaev zzaevVarZza = zzaew.zza(bArrZzb);
                                    iRound = zzaevVarZza.zza;
                                    iZzH = zzaevVarZza.zzb;
                                    strM = zzaevVarZza.zzc;
                                } else {
                                    strM = str6;
                                }
                                listZzj = zzgwm.zzj(bArrZzb);
                                str2 = strZza;
                                iZzB2 = i16;
                            }
                        }
                        str2 = strZza;
                        strM = str6;
                        iZzB2 = i16;
                    }
                    iZzB2 = i16;
                    strM = str6;
                }
                iZzg += i7;
                i16 = iZzB2;
                str5 = str3;
                iZzB = i8;
                i6 = 2;
                i13 = i3;
            }
            iZzg += i7;
            i16 = iZzB2;
            str5 = str3;
            iZzB = i8;
            i6 = 2;
            i13 = i3;
        }
        String str13 = strM;
        if (zzalfVar.zzb != null || str2 == null) {
            return;
        }
        zzt zztVar2 = new zzt();
        zztVar2.zzb(i4);
        zztVar2.zzo(str2);
        zztVar2.zzk(str13);
        zztVar2.zzG(iZzH);
        zztVar2.zzH(iRound);
        zztVar2.zzI(i16);
        zztVar2.zzr(listZzj);
        zztVar2.zzs(zzqVarZzb);
        zztVar2.zze(str);
        if (zzalaVarZzp != null) {
            zztVar2.zzi(zzhah.zzb(zzalaVarZzp.zzc()));
            zztVar2.zzj(zzhah.zzb(zzalaVarZzp.zzd()));
        } else if (zzakyVarZzq != null) {
            zztVar2.zzi(zzhah.zzb(zzakyVarZzq.zza()));
            zztVar2.zzj(zzhah.zzb(zzakyVarZzq.zzb()));
        }
        zzalfVar.zzb = zztVar2.zzO();
    }

    private static zzala zzp(zzet zzetVar, int i) {
        zzetVar.zzh(i + 12);
        zzetVar.zzk(1);
        zzs(zzetVar);
        zzetVar.zzk(2);
        int iZzs = zzetVar.zzs();
        if ((iZzs & 128) != 0) {
            zzetVar.zzk(2);
        }
        if ((iZzs & 64) != 0) {
            zzetVar.zzk(zzetVar.zzs());
        }
        if ((iZzs & 32) != 0) {
            zzetVar.zzk(2);
        }
        zzetVar.zzk(1);
        zzs(zzetVar);
        String strZze = zzas.zze(zzetVar.zzs());
        if ("audio/mpeg".equals(strZze) || "audio/vnd.dts".equals(strZze) || "audio/vnd.dts.hd".equals(strZze)) {
            return new zzala(strZze, null, -1L, -1L);
        }
        zzetVar.zzk(4);
        long jZzz = zzetVar.zzz();
        long jZzz2 = zzetVar.zzz();
        zzetVar.zzk(1);
        int iZzs2 = zzs(zzetVar);
        long j = jZzz2;
        byte[] bArr = new byte[iZzs2];
        zzetVar.zzm(bArr, 0, iZzs2);
        if (j <= 0) {
            j = -1;
        }
        return new zzala(strZze, bArr, j, jZzz > 0 ? jZzz : -1L);
    }

    private static zzaky zzq(zzet zzetVar, int i) {
        zzetVar.zzh(i + 8);
        zzetVar.zzk(4);
        return new zzaky(zzetVar.zzz(), zzetVar.zzz());
    }

    private static Pair zzr(zzet zzetVar, int i, int i2) throws zzat {
        Integer num;
        zzamj zzamjVar;
        Pair pairCreate;
        int i3;
        int i4;
        Integer num2;
        boolean z;
        int iZzg = zzetVar.zzg();
        while (iZzg - i < i2) {
            zzetVar.zzh(iZzg);
            int iZzB = zzetVar.zzB();
            zzagc.zza(iZzB > 0, "childAtomSize must be positive");
            if (zzetVar.zzB() == 1936289382) {
                int i5 = iZzg + 8;
                int i6 = 0;
                int i7 = -1;
                Integer numValueOf = null;
                String strZzK = null;
                while (i5 - iZzg < iZzB) {
                    zzetVar.zzh(i5);
                    int iZzB2 = zzetVar.zzB();
                    int iZzB3 = zzetVar.zzB();
                    if (iZzB3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzetVar.zzB());
                    } else if (iZzB3 == 1935894637) {
                        zzetVar.zzk(4);
                        strZzK = zzetVar.zzK(4, StandardCharsets.UTF_8);
                    } else if (iZzB3 == 1935894633) {
                        i7 = i5;
                        i6 = iZzB2;
                    }
                    i5 += iZzB2;
                }
                byte[] bArr = null;
                if ("cenc".equals(strZzK) || "cbc1".equals(strZzK) || "cens".equals(strZzK) || "cbcs".equals(strZzK)) {
                    zzagc.zza(numValueOf != null, "frma atom is mandatory");
                    zzagc.zza(i7 != -1, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            num = numValueOf;
                            zzamjVar = null;
                            break;
                        }
                        zzetVar.zzh(i8);
                        int iZzB4 = zzetVar.zzB();
                        if (zzetVar.zzB() == 1952804451) {
                            int iZza = zza(zzetVar.zzB());
                            zzetVar.zzk(1);
                            if (iZza == 0) {
                                zzetVar.zzk(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int iZzs = zzetVar.zzs();
                                i3 = iZzs & 15;
                                i4 = (iZzs & 240) >> 4;
                            }
                            if (zzetVar.zzs() == 1) {
                                num2 = numValueOf;
                                z = true;
                            } else {
                                num2 = numValueOf;
                                z = false;
                            }
                            int iZzs2 = zzetVar.zzs();
                            byte[] bArr2 = new byte[16];
                            zzetVar.zzm(bArr2, 0, 16);
                            if (z && iZzs2 == 0) {
                                int iZzs3 = zzetVar.zzs();
                                byte[] bArr3 = new byte[iZzs3];
                                zzetVar.zzm(bArr3, 0, iZzs3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzamjVar = new zzamj(z, strZzK, iZzs2, bArr2, i4, i3, bArr);
                        } else {
                            i8 += iZzB4;
                        }
                    }
                    zzagc.zza(zzamjVar != null, "tenc atom is mandatory");
                    String str = zzfl.zza;
                    pairCreate = Pair.create(num, zzamjVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzg += iZzB;
        }
        return null;
    }

    private static int zzs(zzet zzetVar) {
        int iZzs = zzetVar.zzs();
        int i = iZzs & 127;
        while ((iZzs & 128) == 128) {
            iZzs = zzetVar.zzs();
            i = (i << 7) | (iZzs & 127);
        }
        return i;
    }
}
