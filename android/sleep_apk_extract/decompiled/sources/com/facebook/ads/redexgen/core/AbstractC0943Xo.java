package com.facebook.ads.redexgen.core;

import android.os.Parcel;
import java.io.Serializable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0943Xo {
    public static String[] A00 = {"tfO9EFprOidg15dbWOFNM3pJ9DH12nbd", "iQi3WSSmt7paFVU78YsoSc5vRnrGV8FY", "eVwJkLn66NX0DyzCMNkg9H8sjiBrfui3", "LdqoMHLm0q63TozEkFqOQv3OaH4JH8Wu", "cJBmiPiaGEEsJOt", "9KYT0ysg0qk30iHsbz0zWhVwZhq8iyG9", "m7p", "Jc"};

    public static Serializable A00(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        String[] strArr = A00;
        if (strArr[5].charAt(1) == strArr[2].charAt(1)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A00;
        strArr2[0] = "ayJKSMoIzNcUU8Q19fzYI1UxLR6MMgkq";
        strArr2[3] = "KX8CQKcPRjr3ALAXmnNmxPsf5ZezVoBn";
        parcelObtain.setDataPosition(0);
        Serializable serializable = parcelObtain.readSerializable();
        parcelObtain.recycle();
        return serializable;
    }

    public static byte[] A01(Serializable serializable) {
        if (serializable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeSerializable(serializable);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
