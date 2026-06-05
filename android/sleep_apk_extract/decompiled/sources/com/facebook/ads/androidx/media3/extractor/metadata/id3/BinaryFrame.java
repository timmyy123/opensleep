package com.facebook.ads.androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.core.C5C;
import com.facebook.ads.redexgen.core.I9;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class BinaryFrame extends Id3Frame {
    public static String[] A01 = {"mO2v2I8nIlxBj", "qTeiOagQgmfIePZq", "", "yu", "e92", "94hbfjGXx", "JfA8eazzapC4ELerSklcK4", "O"};
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new I9();
    public final byte[] A00;

    public BinaryFrame(Parcel parcel) {
        super((String) C5C.A0f(parcel.readString()));
        this.A00 = (byte[]) C5C.A0f(parcel.createByteArray());
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.A00 = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            Class<?> cls = getClass();
            if (A01[2].length() != 0) {
                throw new RuntimeException();
            }
            A01[2] = "";
            if (cls == obj.getClass()) {
                BinaryFrame binaryFrame = (BinaryFrame) obj;
                return super.A00.equals(((Id3Frame) binaryFrame).A00) && Arrays.equals(this.A00, binaryFrame.A00);
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = super.A00.hashCode();
        return (((17 * 31) + result) * 31) + Arrays.hashCode(this.A00);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.A00);
        parcel.writeByteArray(this.A00);
    }
}
