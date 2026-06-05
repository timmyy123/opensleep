package com.facebook.ads.redexgen.core;

import android.os.SystemClock;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1865oP implements AnonymousClass93 {
    public static byte[] A01;
    public static String[] A02 = {"JE7C4PJjP7BCbZqkJpMMyURXZ5h", "iMYF6XNZz1LBnq9Lsd18aPb3vu2", "XxqNLC6c7RSVqgSJXO5oI", "nEpRStmmyFjBR5hyZRShRQxXaXf0Mj7x", "WMevU6o4a2paeBy7iKLxLT9X", "1yBfwy19", "IbfL1f4elDnhfhlOaFmHA7", "3K7V2NpliX3hv5M7KS"};
    public final /* synthetic */ C1862oM A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {64, 76, 70, 103, 100, 99, 119, 110, 118, 67, 119, 102, 107, 109, 81, 107, 108, 105, 24, 54, 63, 62, 35, 56, 63, 54, 113, 56, 60, 33, 62, 34, 34, 56, 51, 61, 40, 113, 61, 48, 35, 54, 52, 113, 48, 36, 53, 56, 62, 113, 61, 48, 37, 52, 63, 50, 40, 107, 113, 98, 65, 68, 67, 88, 94, 68, 66, 17, 80, 68, 85, 88, 94, 17, 69, 88, 92, 84, 66, 69, 80, 92, 65, 17, 25, 87, 67, 80, 92, 84, 17, 65, 94, 66, 88, 69, 88, 94, 95, 17, 92, 88, 66, 92, 80, 69, 82, 89, 24, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 17, 102, 69, 64, 71, 92, 90, 64, 70, 21, 84, 64, 81, 92, 90, 21, 65, 92, 88, 80, 70, 65, 84, 88, 69, 21, 29, 70, 76, 70, 65, 80, 88, 21, 86, 89, 90, 86, 94, 21, 88, 92, 70, 88, 84, 65, 86, 93, 28, 15, 21};
        if (A02[4].length() != 24) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[2] = "crOuuTwIIsvqp0CyO4zKH";
        strArr[6] = "QvBSziwTMADuiMqU3qgYIx";
        A01 = bArr;
    }

    static {
        A01();
    }

    public C1865oP(C1862oM c1862oM) {
        this.A00 = c1862oM;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass93
    public final void AEM(long j) {
        AbstractC02134g.A07(A00(2, 16, 116), A00(18, 41, 39) + j);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass93
    public final void AFN(long j) {
        if (this.A00.A0I != null) {
            C1862oM c1862oM = this.A00;
            String[] strArr = A02;
            if (strArr[1].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[2] = "XUD65QsQyQCwJDnhFrO8y";
            strArr2[6] = "L1DcP3KlVDNfGhVI0cZDzs";
            c1862oM.A0I.AFN(j);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass93
    public final void AFP(long j, long j2, long j3, long j4) {
        StringBuilder sbAppend = new StringBuilder().append(A00(59, 52, 71)).append(j);
        String strA00 = A00(0, 2, 26);
        String string = sbAppend.append(strA00).append(j2).append(strA00).append(j3).append(strA00).append(j4).append(strA00).append(this.A00.A06()).append(strA00).append(this.A00.A07()).toString();
        if (!C1862oM.A0v) {
            String message = A00(2, 16, 116);
            AbstractC02134g.A07(message, string);
            return;
        }
        throw new C9I(string);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass93
    public final void AG9(long j, long j2, long j3, long j4) {
        StringBuilder sbAppend = new StringBuilder().append(A00(111, 50, 67)).append(j);
        String strA00 = A00(0, 2, 26);
        String string = sbAppend.append(strA00).append(j2).append(strA00).append(j3).append(strA00).append(j4).append(strA00).append(this.A00.A06()).append(strA00).append(this.A00.A07()).toString();
        if (!C1862oM.A0v) {
            String message = A00(2, 16, 116);
            AbstractC02134g.A07(message, string);
            return;
        }
        throw new C9I(string);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass93
    public final void AGI(int i, long j) {
        if (this.A00.A0I != null) {
            this.A00.A0I.AGJ(i, j, SystemClock.elapsedRealtime() - this.A00.A07);
        }
    }
}
