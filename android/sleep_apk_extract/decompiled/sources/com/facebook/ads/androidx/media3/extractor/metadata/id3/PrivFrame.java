package com.facebook.ads.androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.core.C5C;
import com.facebook.ads.redexgen.core.II;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class PrivFrame extends Id3Frame {
    public static byte[] A02;
    public static String[] A03 = {"EWOInCaIHCzogpd", "fs9ugozw1c5kvUCIqsvCcWemveC1sf1J", "NT8OM95pl0Jx8yQ64hFxmReoXGuhAEeW", "iJI9GReRfI7hh21r5IzNiPRGAwsaTEq4", "tJNEz0EhemzaODezwv68GjVKxVwF2XHD", "CfB", "doDcIJ4JyUsYbIdMITVPy357", "yuRfgYSExXdGEzX5nOmQsyIvKxDppAIu"};
    public static final Parcelable.Creator<PrivFrame> CREATOR;
    public final String A00;
    public final byte[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] ^ i3;
            String[] strArr = A03;
            if (strArr[4].charAt(8) == strArr[1].charAt(8)) {
                throw new RuntimeException();
            }
            A03[0] = "DmEtIuuy4dqW5fO";
            bArrCopyOfRange[i4] = (byte) (i5 ^ 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{89, 67, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 20, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 6, 17, 94, 88, 90, 65, 94};
    }

    static {
        A01();
        CREATOR = new II();
    }

    public PrivFrame(Parcel parcel) {
        super(A00(8, 4, 119));
        this.A00 = (String) C5C.A0f(parcel.readString());
        this.A01 = (byte[]) C5C.A0f(parcel.createByteArray());
    }

    public PrivFrame(String str, byte[] bArr) {
        super(A00(8, 4, 119));
        this.A00 = str;
        this.A01 = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        return C5C.A1E(this.A00, privFrame.A00) && Arrays.equals(this.A01, privFrame.A01);
    }

    public final int hashCode() {
        int i = 17 * 31;
        int result = this.A00 != null ? this.A00.hashCode() : 0;
        return ((i + result) * 31) + Arrays.hashCode(this.A01);
    }

    @Override // com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(0, 8, 28) + this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A00);
        parcel.writeByteArray(this.A01);
    }
}
