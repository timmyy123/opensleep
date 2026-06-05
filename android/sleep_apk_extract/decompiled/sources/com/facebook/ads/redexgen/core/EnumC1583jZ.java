package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/MetaExoPlayerUpgradeConfig$LONG_ID;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL_RENDERER_POSITION_OFFSET_US", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum EnumC1583jZ {
    A04;

    public static byte[] A00;
    public static String[] A01 = {"kbxTv3n6hOrYmARNELIVFN1o35aFfxf9", "DC", "fWmFvctsjomcGnzUliPpX0WJqK3ttEhT", "gzuy7MWN7RDST0VBtMES1RH9HPGoue", "foiaC1fQ94YGSPY2K40utxG5DrDjHMZK", "wvizdHnr", "2cDtQFqEW53Cr0fRDBLwjWIuLIMxwFH2", "gA310x3TNgH1UJZXUpTymdFhi18Mjiej"};
    public static final /* synthetic */ InterfaceC0351Ac A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[7].charAt(30) == strArr[4].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "bPc16As4eDCXVeAhkQE8g5lePspI9WaB";
            strArr2[4] = "g5SuAOrPD4zJLvmEwHOKGazhXjfOTdbt";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 57);
            i4++;
        }
    }

    public static void A01() {
        A00 = new byte[]{-47, -42, -47, -36, -47, -55, -44, -25, -38, -51, -42, -52, -51, -38, -51, -38, -25, -40, -41, -37, -47, -36, -47, -41, -42, -25, -41, -50, -50, -37, -51, -36, -25, -35, -37};
    }

    static {
        A01();
        A02 = AbstractC1998qd.A01(A03);
    }
}
