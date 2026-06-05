package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0918Wn {
    public static byte[] A05;
    public static final Object A06;
    public static final Map<String, String> A07;
    public static final AtomicBoolean A08;
    public final SharedPreferences A00;
    public final T8 A01;
    public final C0844To A02;
    public final String A03;
    public final String A04;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{-100, -19, -14, -4, -25, -89, -45, -35, -32, -45, -29, 35, 47, 45, -18, 33, 46, 36, 50, 47, 41, 36, -18, 54, 37, 46, 36, 41, 46, 39, -21, -5, -23, -8, -15, 10, 26, 19, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 10, -18, -20, -11, -20, -7, -16, -22};
    }

    static {
        A04();
        A07 = new HashMap();
        A06 = new Object();
        A08 = new AtomicBoolean();
    }

    public C0918Wn(T8 t8, String str) {
        this.A01 = t8;
        this.A03 = str;
        this.A02 = new C0844To(this.A01, str);
        this.A00 = WN.A00(this.A01);
        this.A04 = A01(1, 4, 93) + str + A01(0, 1, 18) + this.A02.A06();
    }

    private final String A00() {
        return this.A00.getString(this.A04, null);
    }

    public static String A02(T8 t8, String str) {
        try {
            PackageManager packageManager = t8.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return C0929Xa.A03(packageManager.getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e) {
            if (A08.compareAndSet(false, true)) {
                t8.A08().ABC(A01(40, 7, 56), AbstractC0833Td.A1P, new C0834Te(e));
            }
            return null;
        }
    }

    public static String A03(String str) {
        String str2;
        synchronized (A06) {
            str2 = A07.get(str);
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A05() throws JSONException {
        String strA01 = null;
        if (Build.VERSION.SDK_INT < 31) {
            String strA012 = A01(5, 1, 5);
            String checksumApiFingerprint = Build.VERSION.CODENAME;
            if (strA012.equals(checksumApiFingerprint)) {
                if (C0871Up.A2o(this.A01)) {
                    String strA013 = A01(11, 19, 113);
                    String checksumApiFingerprint2 = this.A02.A0B();
                    if (strA013.equals(checksumApiFingerprint2)) {
                        T8 t8 = this.A01;
                        String checksumApiFingerprint3 = this.A03;
                        strA01 = C0929Xa.A01(t8, checksumApiFingerprint3);
                    }
                }
            }
        }
        if (strA01 == null) {
            T8 t82 = this.A01;
            String checksumApiFingerprint4 = this.A03;
            strA01 = A02(t82, checksumApiFingerprint4);
        } else if (C0871Up.A1k(this.A01)) {
            T8 t83 = this.A01;
            String checksumApiFingerprint5 = this.A03;
            String strA02 = A02(t83, checksumApiFingerprint5);
            String checksumApiFingerprint6 = A01(6, 5, 33);
            C0834Te c0834Te = new C0834Te(checksumApiFingerprint6);
            c0834Te.A05(1);
            c0834Te.A06(1);
            c0834Te.A0A(false);
            JSONObject checksumsJson = new JSONObject();
            String checksumApiFingerprint7 = A01(30, 5, 57);
            checksumsJson.put(checksumApiFingerprint7, strA01);
            String checksumApiFingerprint8 = A01(35, 5, 88);
            checksumsJson.put(checksumApiFingerprint8, strA02);
            c0834Te.A07(checksumsJson);
            InterfaceC0832Tc interfaceC0832TcA08 = this.A01.A08();
            String legacyMd5 = A01(40, 7, 56);
            interfaceC0832TcA08.ABD(legacyMd5, AbstractC0833Td.A1I, c0834Te);
        }
        synchronized (A06) {
            Map<String, String> map = A07;
            String checksumApiFingerprint9 = this.A03;
            map.put(checksumApiFingerprint9, strA01);
        }
        SharedPreferences.Editor editorEdit = this.A00.edit();
        String checksumApiFingerprint10 = this.A04;
        editorEdit.putString(checksumApiFingerprint10, strA01).apply();
    }

    public final void A06() {
        String strA00 = A00();
        synchronized (A06) {
            Map<String, String> map = A07;
            String storedFingerprint = this.A03;
            map.put(storedFingerprint, strA00);
        }
    }
}
