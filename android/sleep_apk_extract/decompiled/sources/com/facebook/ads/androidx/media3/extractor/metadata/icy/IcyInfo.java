package com.facebook.ads.androidx.media3.extractor.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.redexgen.core.AbstractC02053y;
import com.facebook.ads.redexgen.core.C1981qI;
import com.facebook.ads.redexgen.core.C3E;
import com.facebook.ads.redexgen.core.I6;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class IcyInfo implements Metadata.Entry {
    public static byte[] A03;
    public static String[] A04 = {"nnP96OK6t36Mr", "fp9gNvfCMNXuQgLWlYB5lEjFUO4QWdNh", "hZObmpkmCubUhQPk0sNPC7HLyRXYLs4E", "Wb5maXdS5cbTZNKyQcb5C4QnLONrxe0h", "nHFX7Df", "5CI6e8SpgqKAx4NAP8Yv6TwtqqCApbcl", "OJNC", "2nin"};
    public static final Parcelable.Creator<IcyInfo> CREATOR;
    public final String A00;
    public final String A01;
    public final byte[] A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A04;
            if (strArr[7].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[3] = "qKUW1KH6CuSTGDfvrO6Qdp683VdyVHth";
            strArr2[1] = "LPZYmu17yBTH9DPNueNU7kcuuOoRtJJh";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 30);
            i4++;
        }
    }

    public static void A01() {
        A03 = new byte[]{-128, 122, -112, 113, 87, -85, -96, -85, -93, -100, 116, 89, 92, -86, 89, 99, 87, -84, -87, -93, 116, 89, 92, -86, 89, 99, 87, -87, -104, -82, -124, -100, -85, -104, -101, -104, -85, -104, 101, -93, -100, -91, -98, -85, -97, 116, 89, 92, -86, 89};
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ byte[] A9a() {
        return C3E.A01(this);
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ C1981qI A9b() {
        return C3E.A00(this);
    }

    static {
        A01();
        CREATOR = new I6();
    }

    public IcyInfo(Parcel parcel) {
        this.A02 = (byte[]) AbstractC02053y.A01(parcel.createByteArray());
        this.A00 = parcel.readString();
        this.A01 = parcel.readString();
    }

    public IcyInfo(byte[] bArr, String str, String str2) {
        this.A02 = bArr;
        this.A00 = str;
        this.A01 = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.A02, ((IcyInfo) obj).A02);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.A02);
    }

    public final String toString() {
        return String.format(A00(0, 50, 25), this.A00, this.A01, Integer.valueOf(this.A02.length));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.A02);
        parcel.writeString(this.A00);
        parcel.writeString(this.A01);
    }
}
