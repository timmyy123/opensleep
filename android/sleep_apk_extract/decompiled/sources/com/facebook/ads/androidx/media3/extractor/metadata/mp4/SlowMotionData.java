package com.facebook.ads.androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.SlowMotionData;
import com.facebook.ads.redexgen.core.AbstractC02053y;
import com.facebook.ads.redexgen.core.C1981qI;
import com.facebook.ads.redexgen.core.C3E;
import com.facebook.ads.redexgen.core.C5C;
import com.facebook.ads.redexgen.core.CB;
import com.facebook.ads.redexgen.core.IO;
import com.facebook.ads.redexgen.core.IQ;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class SlowMotionData implements Metadata.Entry {
    public static byte[] A01;
    public static String[] A02 = {"vVy2df4lc7XJo6Qz4oe5hY5QclkC1msO", "bFvn9GGSA", "rJdjwYHSXqwF2zqWmrmsaMbWn2fRncDM", "n0CUwbX8duflj29qDaNo1eMJPSMz1wy0", "EiLK9xVNP", "A5gtacIkI4zY7q4KKlTUB2LfKAwpac0M", "JPTmrF60o3pcMj8GdjYW3ZF0hHRl1hXe", "XraBGFY8gaqj8WwGw2mb8M1qw4f4gRNF"};
    public static final Parcelable.Creator<SlowMotionData> CREATOR;
    public final List<Segment> A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {77, 114, 113, 105, 83, 113, 106, 119, 113, 112, 36, 62, 109, 123, 121, 115, 123, 112, 106, 109, 35};
        if (A02[6].charAt(6) != '6') {
            throw new RuntimeException();
        }
        A02[0] = "JwKkffSlx5R8SL1B7VrP8aoEQpNEGvf5";
        A01 = bArr;
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ byte[] A9a() {
        return C3E.A01(this);
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ C1981qI A9b() {
        return C3E.A00(this);
    }

    public static final class Segment implements Parcelable {
        public static byte[] A03;
        public static String[] A04 = {"ipJNOdoh1eb9OTIeB3FkguNCEb2CSeUt", "LqRrPV4VmAB5juazeQC90lkeOBe3TfbV", "GxIB6PN793OgDEySIBV", "pjbiWXJDETiMhx5orI99E6WkDOkVz5Gn", "J7P3lvdGctxgOfZGGj", "2qOoG3pKeDKf31GDID0", "IGomPZhvHos0bQX2r4wz9X4AzFk3bn9K", "qZQeJZO1qS4yLqIhHjV6vOsyyUqJ"};
        public static final Comparator<Segment> A05;
        public static final Parcelable.Creator<Segment> CREATOR;
        public final int A00;
        public final long A01;
        public final long A02;

        public static String A01(int i, int i2, int i3) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
            for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 99);
            }
            return new String(bArrCopyOfRange);
        }

        public static void A02() {
            A03 = new byte[]{-28, -10, -8, -2, -10, -1, 5, -53, -79, 4, 5, -14, 3, 5, -27, -6, -2, -10, -34, 4, -50, -74, -11, -67, -79, -10, -1, -11, -27, -6, -2, -10, -34, 4, -50, -74, -11, -67, -79, 4, 1, -10, -10, -11, -43, -6, 7, -6, 4, 0, 3, -50, -74, -11};
            if (A04[1].charAt(1) == '9') {
                throw new RuntimeException();
            }
            A04[5] = "usOEkDBV0THirHXXCn";
        }

        static {
            A02();
            A05 = new Comparator() { // from class: com.facebook.ads.redexgen.X.IP
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    SlowMotionData.Segment segment = (SlowMotionData.Segment) obj;
                    SlowMotionData.Segment segment2 = (SlowMotionData.Segment) obj2;
                    return AbstractC1833ns.A01().A07(segment.A02, segment2.A02).A07(segment.A01, segment2.A01).A06(segment.A00, segment2.A00).A05();
                }
            };
            CREATOR = new IQ();
        }

        public Segment(long j, long j2, int i) {
            AbstractC02053y.A07(j < j2);
            this.A02 = j;
            this.A01 = j2;
            this.A00 = i;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (A04[1].charAt(1) == '9') {
                throw new RuntimeException();
            }
            A04[1] = "k7ceU3imh4LqNw1CKaBOtFUoGnjVQs9o";
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Segment segment = (Segment) obj;
            return this.A02 == segment.A02 && this.A01 == segment.A01 && this.A00 == segment.A00;
        }

        public final int hashCode() {
            return CB.A00(Long.valueOf(this.A02), Long.valueOf(this.A01), Integer.valueOf(this.A00));
        }

        public final String toString() {
            return C5C.A0n(A01(0, 54, 46), Long.valueOf(this.A02), Long.valueOf(this.A01), Integer.valueOf(this.A00));
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.A02);
            parcel.writeLong(this.A01);
            parcel.writeInt(this.A00);
        }
    }

    static {
        A01();
        CREATOR = new IO();
    }

    public SlowMotionData(List<Segment> segments) {
        this.A00 = segments;
        AbstractC02053y.A07(!A02(segments));
    }

    public static boolean A02(List<Segment> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j = list.get(0).A01;
        int i = 1;
        while (true) {
            int size = list.size();
            if (A02[6].charAt(6) != '6') {
                throw new RuntimeException();
            }
            A02[3] = "hwBz3ErsuLDi1NRUfjE078y2qAcndrMF";
            if (i >= size) {
                return false;
            }
            if (list.get(i).A02 < j) {
                return true;
            }
            j = list.get(i).A01;
            i++;
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
        return this.A00.equals(((SlowMotionData) obj).A00);
    }

    public final int hashCode() {
        return this.A00.hashCode();
    }

    public final String toString() {
        return A00(0, 21, 2) + this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.A00);
    }
}
