package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ab, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1044ab implements View.OnClickListener {
    public static byte[] A01;
    public static String[] A02 = {"sP3gpwd6Zoi5atkrMGPTc5EXN8BQ3Rhb", "CuI3HGsHCqf5OUDiTkLeplOhcTm9T7NI", "qUh1oDSzqsBPPR1tLa2Ioa4F3OHVyWz", "9USBf0H8rgb5C7JYpIITcKF8xtKeHlI", "rVv7rCrqZ3PnTP4EIzYeJpV", "KXSca88saLVPZ5uec2yV3IdyBKC0ygXP", "JOf8s03jk9aSXntkdxYTuuj", "1B5kCc4TTNYrg"};
    public final /* synthetic */ M8 A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[5].charAt(30) == 'J') {
                throw new RuntimeException();
            }
            A02[6] = "NOG9o";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 53);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{-68, -67, -54, -48, -49, -107, -67, -57, -68, -55, -58, -106, -93, -108, -106, -104, -87, -98, -85, -98, -87, -82, 20, 33, 23, 37, 34, 28, 23, -31, 28, 33, 39, 24, 33, 39, -31, 20, 22, 39, 28, 34, 33, -31, 9, -4, -8, 10};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
        } catch (Throwable th) {
            WU.A00(th, this);
        }
        if (!TextUtils.isEmpty(this.A00.A06) && !A00(0, 11, 38).equals(this.A00.A06)) {
            Intent intent = new Intent(A00(22, 26, 126), XB.A00(this.A00.A06));
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            this.A00.A08.A0F().A9y();
            try {
                C0925Wu.A0D(this.A00.A08, intent);
                if (this.A00.A05 != null) {
                    this.A00.A05.AF0();
                    return;
                }
                return;
            } catch (C0923Ws e) {
                Throwable cause = e.getCause();
                C0923Ws cause2 = e;
                if (cause != null) {
                    cause2 = e.getCause();
                }
                this.A00.A08.A08().ABC(A00(11, 11, 0), AbstractC0833Td.A00, new C0834Te(cause2));
                return;
            }
            WU.A00(th, this);
        }
    }

    static {
        A01();
    }

    public ViewOnClickListenerC1044ab(M8 m8) {
        this.A00 = m8;
    }
}
