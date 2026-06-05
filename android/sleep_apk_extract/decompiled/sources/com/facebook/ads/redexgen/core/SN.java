package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class SN {
    public static byte[] A07;
    public static String[] A08 = {"AnF1hfDBxlCdLbiDFLPUuTr8rEIYbsCs", "DcTEZsyKQaFycdRSUI2qHgy2Whp5epDQ", "oumPRRvCFD06iOY6OIziseOiJT3r0Y1F", "T68w1lZpg2aHhxWtuqshCv95QbfqOWN4", "NXTzrqYb1pzocIC4FPaomVlkuxRd4v50", "22ngLnp9x9FhYwfhJQ2wIkSm", "Bx3CPZoq94eNKBlojUhsqxvx", "nU7JTpeEhpBFqPr5yRkbJ9HjbOYUZCS7"};
    public final Handler A00;
    public final SM A01;
    public final C0827Sx A02;
    public final String A03;
    public final String A04;
    public final JSONObject A05;
    public final boolean A06;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 32, 32, 18, 33, 32, -85, -82, -79, -86, -37, -33, -45, -39, -41, -61, -74, -79, -78, -68};
    }

    static {
        A07();
    }

    public SN(C0827Sx c0827Sx, JSONObject jSONObject, String str, String str2, boolean z, SM sm) {
        this.A02 = c0827Sx;
        this.A05 = jSONObject;
        this.A03 = str;
        this.A04 = str2;
        this.A06 = z && A0A(this.A05);
        this.A01 = sm;
        this.A00 = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(boolean z, SL sl) {
        String strA03 = A03(6, 4, 8);
        String strA032 = A03(15, 5, 16);
        String strA033 = A03(10, 5, 53);
        if (z) {
            if (strA033.equals(sl.A02)) {
                this.A02.A0d(new C0825Sv(sl.A03, -1, -1, this.A04, this.A03));
                return;
            } else if (strA032.equals(sl.A02)) {
                this.A02.A0a(new C0823St(sl.A03, this.A04, this.A03));
                return;
            } else {
                if (!strA03.equals(sl.A02)) {
                    return;
                }
                this.A02.A0Z(new C0823St(sl.A03, this.A04, this.A03));
                return;
            }
        }
        boolean zEquals = strA033.equals(sl.A02);
        String[] strArr = A08;
        if (strArr[0].charAt(19) == strArr[7].charAt(19)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[1] = "flwbx6LrQCqeci7k9ke6latQGKdtr0Wf";
        strArr2[4] = "KvRVuDaSTwPscix8AFjTqHYTdR1zRqiC";
        if (zEquals) {
            this.A02.A0c(new C0825Sv(sl.A03, -1, -1, this.A04, this.A03));
        } else if (strA032.equals(sl.A02)) {
            this.A02.A0b(new C0823St(sl.A03, this.A04, this.A03));
        } else {
            if (!strA03.equals(sl.A02)) {
                return;
            }
            this.A02.A0Y(new C0823St(sl.A03, this.A04, this.A03));
        }
    }

    public static boolean A0A(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.has(A03(0, 6, 112));
    }

    public final void A0B() {
        if (!this.A06) {
            this.A01.ACy();
        }
        YG.A06.execute(new C1439h0(this));
    }
}
