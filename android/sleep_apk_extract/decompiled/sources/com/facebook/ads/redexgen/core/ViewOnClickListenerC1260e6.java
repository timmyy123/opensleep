package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.e6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1260e6 implements View.OnClickListener {
    public static byte[] A01;
    public static String[] A02 = {"ZORd5xFqixOFhmYOfXnO345CHw6Ta02w", "OZ", "OQ0N", "rqVhPmdjJ9FZprpIbtM3CV9Bkmueh049", "Mzz9MqA4zj", "ReAjeiyasZdcxecBPaADU26VXrhM6RJh", "r52dfcnslGQHpCZhGZGmnjgdJQXYjMBM", "zjyNvy4fEAQ51zWLeD1ZjnseIufNB9Ms"};
    public final /* synthetic */ C4U A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[7].charAt(1) == '2') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[5] = "Q8w71E1pXjwyeJwXodLveN5DPJuDbHqJ";
            strArr[6] = "vKRTSYGBBmrLOEBfFNTayte5spFfdrra";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 55);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{107, 102, 98, 103, 102, 113};
    }

    static {
        A01();
    }

    public ViewOnClickListenerC1260e6(C4U c4u) {
        this.A00 = c4u;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A02(A00(0, 6, 52));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
