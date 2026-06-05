package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.j3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1559j3 implements N9 {
    public static byte[] A02;
    public static String[] A03 = {"ebJtInVgM8lwtLsL8CqjQvfHZTFWXyTj", "MRT4Iz3aNiJEaKRUIrDApfghDq01n6sB", "qhIcWii6jOsLbVLe4G", "jd0Ec4CahT7YYBjB568owPC0gY4s3zOU", "RPiMcfQYBdHC0SSG6XvNc0NsjlYurq5U", "E74vSWGMqEH8Jt4WlgBEkdQ8nTEO7fKB", "DEVdv4rr1ByH9p4ezSF9ryFdFyWOGnGy", "23RYwIDt1nJrIBpc57"};
    public final /* synthetic */ C02957k A00;
    public final /* synthetic */ Runnable A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{89, 10, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 83, 89, 91, 92, 92, 32, 3, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 7, 16, 66, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 15, 18, 16, 7, 17, 17, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 66, 4, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 16, 7, 6, 28, 29, 49, 18, 29, 29, 22, 1, 63, 28, 20, 20, 26, 29, 20, 58, 30, 3, 1, 22, 0, 0, 26, 28, 29};
    }

    static {
        A01();
    }

    public C1559j3(C02957k c02957k, Runnable runnable) {
        this.A00 = c02957k;
        this.A01 = runnable;
    }

    @Override // com.facebook.ads.redexgen.core.N9
    public final void ADC(InterfaceC1617k8 interfaceC1617k8) {
        this.A00.A02.A0F().A4a();
        this.A00.A07.A0C();
    }

    @Override // com.facebook.ads.redexgen.core.N9
    public final void ADD(InterfaceC1617k8 interfaceC1617k8, View view) {
        this.A00.A02.A0F().A4Z(interfaceC1617k8 == ((AbstractC1556j0) this.A00).A00);
        if (interfaceC1617k8 != ((AbstractC1556j0) this.A00).A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        N1 n1 = ((AbstractC1556j0) this.A00).A01;
        C02957k c02957k = this.A00;
        String[] strArr = A03;
        if (strArr[6].charAt(14) != strArr[5].charAt(14)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[0] = "gfJNIdbF2FrCa8qL8kuytpSS0QUlrsrj";
        strArr2[1] = "KzSpIsxhAVssntgB7OlLodebxm4ynnXJ";
        ((AbstractC1556j0) c02957k).A01 = interfaceC1617k8;
        this.A00.A01 = view;
        if (!this.A00.A0C) {
            this.A00.A07.A0F(interfaceC1617k8);
        } else {
            this.A00.A07.A0E(view);
            this.A00.A0Q(n1);
        }
    }

    @Override // com.facebook.ads.redexgen.core.N9
    public final void ADE(InterfaceC1617k8 interfaceC1617k8) {
        AbstractC0904Vy.A05(A00(31, 25, 61), A00(8, 23, 44), A00(0, 8, 37));
        this.A00.A02.A0F().A4c();
        this.A00.A07.A0D();
        this.A00.A0O();
    }

    @Override // com.facebook.ads.redexgen.core.N9
    public final void AEN(InterfaceC1617k8 interfaceC1617k8, C0893Vm c0893Vm) {
        this.A00.A02.A0F().A4b(interfaceC1617k8 == ((AbstractC1556j0) this.A00).A00, c0893Vm.A03().getErrorCode());
        if (interfaceC1617k8 != ((AbstractC1556j0) this.A00).A00) {
            return;
        }
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A0Q(interfaceC1617k8);
        this.A00.ADp(c0893Vm);
    }
}
