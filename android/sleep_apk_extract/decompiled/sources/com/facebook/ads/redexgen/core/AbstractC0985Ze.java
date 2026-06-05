package com.facebook.ads.redexgen.core;

import android.view.View;
import com.facebook.ads.NativeAdLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ze, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0985Ze {
    public static String[] A00 = {"B", "b", "N7Y4O4Xp0bXRpwQYmrnUbbD5XPNn0nfl", "PsTgqcCc8jcMoxm2RXWy1mA6rhf59", "zMLnehec4ICfDGOtTSDp3symXOGZpaRx", "AnvCnC9uV", "JoTWE5M61fQkMjrwCjPz5KG5vu8cqeKb", "O6aKPphMSjoWO4xDWlhiQ7T2kp0fs"};
    public static final int A01 = (int) (XX.A02 * 200.0f);
    public static final int A03 = (int) (XX.A02 * 200.0f);
    public static final int A02 = (int) (XX.A02 * 50.0f);

    public static NF A00(NativeAdLayout nativeAdLayout) {
        if (nativeAdLayout == null) {
            return NF.A04;
        }
        if (A03(nativeAdLayout)) {
            return NF.A05;
        }
        return NF.A03;
    }

    public static AbstractC0984Zd A01(C1421gi c1421gi, VA va, String str, View view) {
        if (view == null) {
            return null;
        }
        int w = view.getWidth();
        int height = view.getHeight();
        if (w >= A01 && height >= A01) {
            return new MC(c1421gi, va, str);
        }
        if (w >= A03) {
            int i = A02;
            String[] strArr = A00;
            if (strArr[6].charAt(28) == strArr[4].charAt(28)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[7] = "MXaU9iKOIfaGo19ccmM4SYJQh1BEv";
            strArr2[3] = "urarsFS1owFx4szCeqq2cq67A77KP";
            if (height >= i) {
                return new MD(c1421gi, va, str);
            }
        }
        return null;
    }

    public static ME A02(C1421gi c1421gi, VA va, String str, C0691Nm c0691Nm, InterfaceC0963Yi interfaceC0963Yi, InterfaceC0962Yh interfaceC0962Yh) {
        return new ME(c1421gi, va, str, c0691Nm, interfaceC0963Yi, interfaceC0962Yh);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A03(NativeAdLayout nativeAdLayout) {
        int width = nativeAdLayout.getWidth();
        int height = nativeAdLayout.getHeight();
        int w = A01;
        if (width >= w) {
            int w2 = A01;
            if (height < w2) {
                int i = A03;
                String[] strArr = A00;
                String str = strArr[1];
                String str2 = strArr[0];
                int h = str.length();
                int w3 = str2.length();
                if (h != w3) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A00;
                strArr2[1] = "e";
                strArr2[0] = "I";
                if (width >= i) {
                    int w4 = A02;
                    if (height < w4) {
                    }
                }
                return true;
            }
        }
        return false;
    }
}
