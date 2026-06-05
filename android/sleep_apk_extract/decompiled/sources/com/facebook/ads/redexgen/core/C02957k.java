package com.facebook.ads.redexgen.core;

import android.view.View;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C02957k extends AbstractC1556j0 {
    public static byte[] A03;
    public long A00;
    public View A01;
    public AnonymousClass76 A02;

    static {
        A05();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{20, 23, 38, -15, -16, -3, -3, -12, 1, -18, 1, -12, -11, 1, -12, 2, -9, -18, 3, -8, -4, -12, -5, 0, -7, 1, 6, -9, 8, -7, 10, -7, 5, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 38, 55, 27, 40, 40, 37, 40, -42, 45, 30, 31, 34, 27, -42, 38, 23, 40, 41, 31, 36, 29, -42, 25, 30, 23, 31, 36, 27, 26, -42, 23, 26, 41, -42, -8, 23, 36, 36, 27, 40};
    }

    public C02957k(AnonymousClass76 anonymousClass76, O7 o7) {
        super(anonymousClass76, o7);
        this.A00 = 10000L;
        this.A02 = anonymousClass76;
    }

    private C1559j3 A01(Runnable runnable) {
        return new C1559j3(this, runnable);
    }

    private List<JSONObject> A04(O8 o8) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectA03 = o8.A03();
        if (jSONObjectA03.has(A03(22, 12, 71))) {
            try {
                this.A00 = jSONObjectA03.getJSONObject(r1).optInt(A03(3, 19, 62), 10000);
                JSONArray adsArray = jSONObjectA03.getJSONArray(A03(0, 3, 98));
                if (adsArray.length() > 0) {
                    for (int i = 0; i < adsArray.length(); i++) {
                        arrayList.add((JSONObject) adsArray.get(i));
                    }
                }
            } catch (JSONException unused) {
                String strA03 = A03(36, 38, 101);
                this.A02.A0F().A5g(C0893Vm.A01(AdErrorType.UNKNOWN_ERROR, strA03).A03().getErrorCode(), strA03);
                return arrayList;
            }
        } else {
            arrayList.add(jSONObjectA03);
        }
        return arrayList;
    }

    private void A06(InterfaceC1617k8 interfaceC1617k8, JSONObject jSONObject, C0853Tx c0853Tx) {
        this.A0C = false;
        C1558j2 c1558j2 = new C1558j2(this, interfaceC1617k8, AbstractC0932Xd.A02(jSONObject, A03(34, 2, 114)));
        A0H().postDelayed(c1558j2, c0853Tx.A05());
        interfaceC1617k8.AAt(this.A02, this.A09, this.A08.A08, A01(c1558j2), jSONObject, c0853Tx);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1556j0
    public final void A0P() {
        if (this.A01 != null) {
            this.A02.A0F().A4e();
            this.A07.A0E(this.A01);
        } else {
            this.A02.A0F().A4f();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1556j0
    public final void A0R(N1 n1, C0852Tw c0852Tw, C0850Tu c0850Tu, final O8 o8) {
        this.A02.A0F().A4Y();
        final InterfaceC1617k8 interfaceC1617k8 = (InterfaceC1617k8) n1;
        if (interfaceC1617k8.AKL()) {
            final List<JSONObject> listA04 = A04(o8);
            A06(interfaceC1617k8, listA04.get(0), o8.A01());
            if (listA04.size() > 1) {
                A0H().postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.O9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.A02.A0a(interfaceC1617k8, listA04, o8);
                    }
                }, this.A00);
                return;
            }
            return;
        }
        A06(interfaceC1617k8, o8.A03(), o8.A01());
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1556j0
    public final void A0U(String str) {
        this.A02.A0F().A4d(str != null);
        super.A0U(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1556j0
    public final void A0Y(boolean z) {
        super.A0Y(z);
        this.A01 = null;
    }

    public final /* synthetic */ void A0a(InterfaceC1617k8 interfaceC1617k8, List list, O8 o8) {
        A06(interfaceC1617k8, (JSONObject) list.get(1), o8.A01());
    }
}
