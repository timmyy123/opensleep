package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1792nD extends AbstractC0470Ew {
    public static String[] A01 = {"LN1kZ6lR3vZBqqrviA4uTSOzBGS9o2bO", "mUQPITaRnEXTrG2Wr7xIAnPzPHhU6DS3", "avW0I4bwWNzzQZleeOInYpLZY9PTle7", "LGUT8ZIo3joumZn9NybI7JCchk0DSCTG", "S4WFRdtC0lcE2afHWARgiwpUU5tNPmtd", "SbOYlLigHNVPkFHrMvYK7wwtNeL", "2fmBOvz22OTh8nUuYBKjoVDFU", "lR30iWlIbuozJgbVtB9O9DOed4NJenPq"};
    public C0462Eo A00;

    public abstract Pair<C03037s[], InterfaceC1793nE[]> A0d(C0462Eo c0462Eo, int[][][] iArr, int[] iArr2, C1829no c1829no, Timeline timeline) throws AD;

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /* JADX WARN: Incorrect condition in loop: B:7:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A0Y(InterfaceC03007p[] interfaceC03007pArr, C1944pg c1944pg, int[] iArr, boolean z) throws AD {
        int length = interfaceC03007pArr.length;
        int formatSupportLevel = 0;
        int i = 1;
        for (int i2 = 0; i2 < bestRendererIndex; i2++) {
            InterfaceC03007p interfaceC03007p = interfaceC03007pArr[i2];
            int iMax = 0;
            for (int bestFormatSupportLevel = 0; bestFormatSupportLevel < bestRendererIndex; bestFormatSupportLevel++) {
                int bestRendererIndex = interfaceC03007p.AKM(c1944pg.A08(bestFormatSupportLevel));
                iMax = Math.max(iMax, AbstractC02937i.A03(bestRendererIndex));
            }
            int bestRendererIndex2 = iArr[i2];
            int bestRendererIndex3 = bestRendererIndex2 == 0 ? 1 : 0;
            if (iMax > formatSupportLevel || (iMax == formatSupportLevel && z && i == 0 && bestRendererIndex3 != 0)) {
                length = i2;
                formatSupportLevel = iMax;
                i = bestRendererIndex3;
            }
        }
        return length;
    }

    public static int[] A0Z(InterfaceC03007p interfaceC03007p, C1944pg c1944pg) throws AD {
        int[] iArr = new int[c1944pg.A01];
        for (int i = 0; i < c1944pg.A01; i++) {
            iArr[i] = interfaceC03007p.AKM(c1944pg.A08(i));
        }
        return iArr;
    }

    public static int[] A0a(InterfaceC03007p[] interfaceC03007pArr) throws AD {
        int[] iArr = new int[interfaceC03007pArr.length];
        for (int i = 0; i < iArr.length; i++) {
            int iAKO = interfaceC03007pArr[i].AKO();
            String[] strArr = A01;
            String str = strArr[4];
            String str2 = strArr[1];
            int i2 = str.charAt(23);
            if (i2 == str2.charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "1ViYEGUZxGRCVXLKV1NACncyCaxKGcLE";
            strArr2[1] = "WZkUCc71MckdncxFpAml539B1oxWjr0A";
            iArr[i] = iAKO;
        }
        return iArr;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0470Ew
    public final C0471Ex A0b(InterfaceC03007p[] interfaceC03007pArr, C1811nW c1811nW, C1829no c1829no, Timeline timeline) throws AD {
        int[] rendererTrackGroupCounts;
        int[] iArr = new int[interfaceC03007pArr.length + 1];
        C1944pg[][] c1944pgArr = new C1944pg[interfaceC03007pArr.length + 1][];
        int[][][] iArr2 = new int[interfaceC03007pArr.length + 1][][];
        for (int i = 0; i < c1944pgArr.length; i++) {
            c1944pgArr[i] = new C1944pg[c1811nW.A01];
            iArr2[i] = new int[c1811nW.A01][];
        }
        int[] iArrA0a = A0a(interfaceC03007pArr);
        for (int i2 = 0; i2 < c1811nW.A01; i2++) {
            C1944pg c1944pgA05 = c1811nW.A05(i2);
            int groupIndex = A0Y(interfaceC03007pArr, c1944pgA05, iArr, c1944pgA05.A02 == 5);
            if (groupIndex == interfaceC03007pArr.length) {
                rendererTrackGroupCounts = new int[c1944pgA05.A01];
            } else {
                rendererTrackGroupCounts = A0Z(interfaceC03007pArr[groupIndex], c1944pgA05);
            }
            int i3 = iArr[groupIndex];
            c1944pgArr[groupIndex][i3] = c1944pgA05;
            iArr2[groupIndex][i3] = rendererTrackGroupCounts;
            iArr[groupIndex] = iArr[groupIndex] + 1;
        }
        C1811nW[] c1811nWArr = new C1811nW[interfaceC03007pArr.length];
        String[] strArr = new String[interfaceC03007pArr.length];
        int[] iArr3 = new int[interfaceC03007pArr.length];
        int i4 = 0;
        while (true) {
            int length = interfaceC03007pArr.length;
            String[] strArr2 = A01;
            if (strArr2[4].charAt(23) == strArr2[1].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr3 = A01;
            strArr3[4] = "hppY0P6sht5kF7is4RCKyMBKsFUVAoRB";
            strArr3[1] = "XeHPWbHBeoBDFVDQc4DbmKa9NYqMdrJh";
            if (i4 < length) {
                int i5 = iArr[i4];
                c1811nWArr[i4] = new C1811nW((C1944pg[]) C5C.A1I(c1944pgArr[i4], i5));
                iArr2[i4] = (int[][]) C5C.A1I(iArr2[i4], i5);
                strArr[i4] = interfaceC03007pArr[i4].getName();
                iArr3[i4] = interfaceC03007pArr[i4].A9N();
                i4++;
            } else {
                C0462Eo c0462Eo = new C0462Eo(strArr, iArr3, c1811nWArr, iArrA0a, iArr2, new C1811nW((C1944pg[]) C5C.A1I(c1944pgArr[interfaceC03007pArr.length], iArr[interfaceC03007pArr.length])));
                Pair<C03037s[], InterfaceC1793nE[]> pairA0d = A0d(c0462Eo, iArr2, iArrA0a, c1829no, timeline);
                return new C0471Ex((C03037s[]) pairA0d.first, (InterfaceC1793nE[]) pairA0d.second, AbstractC0467Et.A00(c0462Eo, (InterfaceC0464Eq[]) pairA0d.second), c0462Eo);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0470Ew
    public final void A0c(Object obj) {
        this.A00 = (C0462Eo) obj;
    }
}
