package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Iu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public abstract class AbstractC0570Iu {
    public static byte[] A01;

    @MetaExoPlayerCustomization("Adding TYPE_xml")
    public static final int A02;
    public final int A00;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A01 = new byte[]{-26, -37, -38, -114};
    }

    static {
        A04();
        A02 = C5C.A0D(A03(0, 4, 3));
    }

    public AbstractC0570Iu(int i) {
        this.A00 = i;
    }

    public static int A00(int i) {
        return 16777215 & i;
    }

    public static int A01(int i) {
        return (i >> 24) & PHIpAddressSearchManager.END_IP_SCAN;
    }

    public static String A02(int i) {
        return A03(0, 0, 9) + ((char) ((i >> 24) & PHIpAddressSearchManager.END_IP_SCAN)) + ((char) ((i >> 16) & PHIpAddressSearchManager.END_IP_SCAN)) + ((char) ((i >> 8) & PHIpAddressSearchManager.END_IP_SCAN)) + ((char) (i & PHIpAddressSearchManager.END_IP_SCAN));
    }

    public String toString() {
        return A02(this.A00);
    }
}
