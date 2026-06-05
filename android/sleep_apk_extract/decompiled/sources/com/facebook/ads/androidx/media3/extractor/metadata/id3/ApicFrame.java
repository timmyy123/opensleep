package com.facebook.ads.androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.core.C5C;
import com.facebook.ads.redexgen.core.I8;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ApicFrame extends Id3Frame {
    public static byte[] A04;
    public static String[] A05 = {"5o877G0Xn4g", "fiOGvUvan2p0zeHSdd1zDEfnnu", "vTZ", "Cn8", "Biz8k47ZZA2czV", "Z3kr8YtjBqxV00IQ2eamuz9uGN", "STDT2GTKdPFkuTZOytQGPqPU77", "1166HsxlVHC8oY9ZvqmOAOxF"};
    public static final Parcelable.Creator<ApicFrame> CREATOR;
    public final int A00;
    public final String A01;
    public final String A02;
    public final byte[] A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{23, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 79, 80, 94, 78, 93, 84, 91, 95, 84, 90, 89, 40, -45, -71, 6, 2, 6, -2, -19, 18, 9, -2, -42, -41, -26, -33, -39};
    }

    static {
        A01();
        CREATOR = new I8();
    }

    public ApicFrame(Parcel parcel) {
        super(A00(25, 4, 24));
        this.A02 = (String) C5C.A0f(parcel.readString());
        this.A01 = parcel.readString();
        this.A00 = parcel.readInt();
        this.A03 = (byte[]) C5C.A0f(parcel.createByteArray());
    }

    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super(A00(25, 4, 24));
        this.A02 = str;
        this.A01 = str2;
        this.A00 = i;
        this.A03 = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            Class<?> cls = getClass();
            Class<?> cls2 = obj.getClass();
            String[] strArr = A05;
            if (strArr[6].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A05[0] = "Vat9FRYSvb0";
            if (cls == cls2) {
                ApicFrame apicFrame = (ApicFrame) obj;
                if (this.A00 == apicFrame.A00 && C5C.A1E(this.A02, apicFrame.A02) && C5C.A1E(this.A01, apicFrame.A01)) {
                    byte[] bArr = this.A03;
                    String[] strArr2 = A05;
                    if (strArr2[2].length() != strArr2[3].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr3 = A05;
                    strArr3[6] = "N5mzCkpeHXkGaEeNVH6XxC0l1A";
                    strArr3[5] = "UQhaCuUYGvgNkUfwyKrX3KpkmF";
                    if (Arrays.equals(bArr, apicFrame.A03)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A00;
        int result2 = ((17 * 31) + result) * 31;
        int result3 = this.A02 != null ? this.A02.hashCode() : 0;
        return ((((result2 + result3) * 31) + (this.A01 != null ? this.A01.hashCode() : 0)) * 31) + Arrays.hashCode(this.A03);
    }

    @Override // com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(14, 11, 27) + this.A02 + A00(0, 14, 109) + this.A01;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A02);
        parcel.writeString(this.A01);
        parcel.writeInt(this.A00);
        parcel.writeByteArray(this.A03);
    }
}
