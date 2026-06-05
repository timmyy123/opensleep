package com.facebook.ads.androidx.media3.extractor.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.redexgen.core.C01722p;
import com.facebook.ads.redexgen.core.C0550Hz;
import com.facebook.ads.redexgen.core.C1981qI;
import com.facebook.ads.redexgen.core.C5C;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class EventMessage implements Metadata.Entry {
    public static byte[] A06;
    public static final C1981qI A07;
    public static final C1981qI A08;
    public static final Parcelable.Creator<EventMessage> CREATOR;
    public int A00;
    public final long A01;
    public final long A02;
    public final String A03;
    public final String A04;
    public final byte[] A05;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{35, 47, 107, 122, 125, 110, 123, 102, 96, 97, 66, 124, 50, 6, 10, 67, 78, 23, 7, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 93, 74, 71, 94, 78, 22, 119, 127, 97, 117, 8, 18, 65, 81, 90, 87, 95, 87, 15, 56, 41, 41, 53, 48, 58, 56, 45, 48, 54, 55, 118, 48, 61, 106, 101, 116, 116, 104, 109, 103, 101, 112, 109, 107, 106, 43, 124, 41, 119, 103, 112, 97, 55, 49, 35, 63, 63, 59, 56, 113, 100, 100, 42, 36, 38, 46, 47, 34, 42, 101, 36, 57, 44, 100, 46, 38, 56, 44, 100, 2, 15, 120, 99, 127, 127, 123, 120, 49, 36, 36, 111, 110, 125, 110, 103, 100, 123, 110, 121, 37, 106, 123, 123, 103, 110, 37, 104, 100, 102, 36, 120, 127, 121, 110, 106, 102, 98, 101, 108, 36, 110, 102, 120, 108, 38, 98, 111, 56, 75, 76, 80, 4, 77, 93, 74, 91, 4, 77, 93, 74, 91, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 10, 4, 92, 87, 80};
    }

    static {
        A01();
        A07 = new C01722p().A11(A00(39, 15, 32)).A14();
        A08 = new C01722p().A11(A00(54, 20, 125)).A14();
        CREATOR = new C0550Hz();
    }

    public EventMessage(Parcel parcel) {
        this.A03 = (String) C5C.A0f(parcel.readString());
        this.A04 = (String) C5C.A0f(parcel.readString());
        this.A01 = parcel.readLong();
        this.A02 = parcel.readLong();
        this.A05 = (byte[]) C5C.A0f(parcel.createByteArray());
    }

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.A03 = str;
        this.A04 = str2;
        this.A01 = j;
        this.A02 = j2;
        this.A05 = bArr;
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final byte[] A9a() {
        if (A9b() != null) {
            return this.A05;
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0009  */
    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C1981qI A9b() {
        byte b;
        String str = this.A03;
        switch (str.hashCode()) {
            case -1468477611:
                b = !str.equals(A00(148, 24, 71)) ? (byte) -1 : (byte) 2;
                break;
            case -795945609:
                if (str.equals(A00(74, 28, 50))) {
                    b = 0;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals(A00(102, 46, 114))) {
                    b = 1;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
                return A07;
            case 2:
                return A08;
            default:
                return null;
        }
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
        EventMessage eventMessage = (EventMessage) obj;
        if (this.A01 == eventMessage.A01 && this.A02 == eventMessage.A02 && C5C.A1E(this.A03, eventMessage.A03) && C5C.A1E(this.A04, eventMessage.A04) && Arrays.equals(this.A05, eventMessage.A05)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int i = 17 * 31;
            int result = this.A03 != null ? this.A03.hashCode() : 0;
            int iHashCode = (((i + result) * 31) + (this.A04 != null ? this.A04.hashCode() : 0)) * 31;
            int result2 = (int) (this.A01 ^ (this.A01 >>> 32));
            int result3 = (((iHashCode + result2) * 31) + ((int) (this.A02 ^ (this.A02 >>> 32)))) * 31;
            int result4 = Arrays.hashCode(this.A05);
            this.A00 = result3 + result4;
        }
        return this.A00;
    }

    public final String toString() {
        return A00(26, 13, 75) + this.A03 + A00(13, 5, 83) + this.A02 + A00(0, 13, 118) + this.A01 + A00(18, 8, 82) + this.A04;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A03);
        parcel.writeString(this.A04);
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A02);
        parcel.writeByteArray(this.A05);
    }
}
