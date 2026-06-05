package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.EditText;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Executor;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0744Pp implements YT {
    public static byte[] A04;
    public C1417ge A00;
    public C0852Tw A01;
    public InterfaceC1372fv A02;
    public final Executor A03;

    static {
        A06();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A04 = new byte[]{98, 103, 103, 97, 100, 105, 97, 99, 102, 98, 99, 96, 103, 97, 98, 92, 87, 89, 94, 93, 91, 90, 92, 94, 86, 86, 91, 90, 93, 90, 95, 80, 90, 80, 92, 90, 80, 93, 89, 80, 80, 94, 80, 89, 88, 21, 80, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 15, 91, 80, 8, 88, 15, 91, 94, 93, 92, 94, 93, 95, 8, 95, 10, 95, 89, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 94, 89, 94, 15, 92, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, 91, 90, 10, 91, 94, 124, 115, 126, 120, 113, 109, 65, 89, 0, 79, 84, 72, 69, 82, 83, 0, 76, 79, 71, 73, 78, 0, 65, 83, 0, 89, 79, 85, 0, 84, 79, 0, 68, 69, 66, 85, 71, 31, 0, 104, 79, 87, 0, 68, 79, 0, 89, 79, 85, 0, 82, 69, 80, 82, 79, 68, 85, 67, 69, 0, 84, 72, 69, 0, 73, 83, 83, 85, 69, 31, 53, 3, 8, 2, 70, 52, 3, 22, 9, 20, 18, 62, 1, 8, 29, 73, 33, 8, 25, 25, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 7, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 86, 27, 25, 25, 31, 9, 9, 37, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 21, 17, 31, 20, 25, 27, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 31, 29, 21, 8, 3, 37, 19, 30, 47, 32, 37, 41, 34, 56, 19, 56, 37, 33, 41, 99, 108, 105, 101, 110, 116, 95, 116, 111, 107, 101, 110, 89, 85, 84, 92, 83, 93, 101, 83, 94, 1, 0, 22, 6, 23, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 21, 17, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 47, 39, 54, 35, 38, 35, 54, 35, 57, 61, 39, 55, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 61, 58, 50, 59, 116, 114, 100, 115, 94, 104, 101, 100, 111, 117, 104, 103, 104, 100, 115};
    }

    public C0744Pp(Executor executor, C0852Tw c0852Tw, C1421gi c1421gi) {
        this.A00 = c1421gi.A02();
        this.A02 = C1390gD.A01(this.A00);
        this.A03 = executor;
        this.A01 = c0852Tw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A02(String str) {
        C1386g9 c1386g9 = new C1386g9();
        C1386g9 c1386g92 = new C1386g9();
        C1386g9 c1386g93 = new C1386g9();
        c1386g9.put(A03(257, 15, 52), SZ.A00().A03());
        c1386g9.put(A03(220, 9, 15), A03(15, 15, 91));
        c1386g9.put(A03(186, 11, 79), A03(0, 15, 101));
        c1386g9.put(A03(174, 12, 79), A03(30, 48, 92));
        c1386g9.put(A03(197, 11, 121), (System.currentTimeMillis() / 1000) + A03(0, 0, 108));
        String strA09 = this.A01.A09();
        if (strA09 != null) {
            c1386g93.put(A03(208, 12, 53), strA09);
        }
        c1386g92.put(A03(229, 11, 80), str);
        c1386g92.put(A03(248, 9, 97), AbstractC0932Xd.A01(c1386g93));
        c1386g9.A04(A03(240, 8, 119), AbstractC0932Xd.A01(c1386g92));
        return c1386g9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(C0852Tw c0852Tw) {
        this.A01 = c0852Tw;
    }

    @Override // com.facebook.ads.redexgen.core.YT
    public final void AFv() {
        Activity activityA00 = ActivityUtils.A00();
        if (activityA00 == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activityA00);
        builder.setTitle(A03(160, 14, 92));
        EditText editText = new EditText(activityA00);
        editText.setSingleLine(false);
        editText.setImeOptions(1073741824);
        editText.setHint(A03(84, 65, 21));
        editText.setMaxLines(2);
        editText.setMinLines(2);
        builder.setView(editText);
        builder.setNegativeButton(A03(78, 6, 40), new YQ(this));
        builder.setPositiveButton(A03(149, 11, 83), new YR(this, editText));
        builder.create().show();
    }
}
