package com.facebook.ads.androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.redexgen.core.AbstractC2040rd;
import com.facebook.ads.redexgen.core.C1981qI;
import com.facebook.ads.redexgen.core.C5C;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class Metadata implements Parcelable {
    public static byte[] A02;
    public static String[] A03 = {"mhtWLLrhhof2c3oNGAikQ02zY04FWWhb", "D7PA5y5JB7lzm0w5G", "zJXPfo0gMr3Jucw9cJGyuGk1ctIsyJh8", "Rs3TDnOYdqPS5YfXoagNS3YNrnFCycs6", "xjaJofD0dPUcmVvb8BJkqUvajzMbPe01", "BOBSub5c7lfBtbfZCMGuub2gKHyTzLoC", "LM9W6", "jYsNszMUFrPRtUIi9AiskAAH1nkqNQHo"};
    public static final Parcelable.Creator<Metadata> CREATOR;
    public final long A00;
    public final Entry[] A01;

    public interface Entry extends Parcelable {
        byte[] A9a();

        C1981qI A9b();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[0].charAt(19) != strArr[4].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[2] = "jJYb5XESnreQmnafz5VJdwPxqQSxn5xg";
            strArr2[7] = "kTpneR3tTrjWo9SwHImypXlm89YhFqkJ";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 102);
            i4++;
        }
    }

    public static void A01() {
        String[] strArr = A03;
        if (strArr[6].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[0] = "FHzPVNHLMxLnXBjwMdKkWWwrPs5hsjYz";
        strArr2[4] = "XDjvnqVH9aBEFffbIwnkls2Q80ahFTsl";
        A02 = new byte[]{56, 52, 100, 102, 113, 103, 113, 122, 96, 117, 96, 125, 123, 122, 64, 125, 121, 113, 65, 103, 41, 92, 87, 77, 75, 80, 92, 74, 4};
    }

    static {
        A01();
        CREATOR = new Parcelable.Creator<Metadata>() { // from class: com.facebook.ads.redexgen.X.3D
            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final Metadata createFromParcel(Parcel parcel) {
                return new Metadata(parcel);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
            public final Metadata[] newArray(int i) {
                return new Metadata[i];
            }
        };
    }

    public Metadata(long j, Entry... entryArr) {
        this.A00 = j;
        this.A01 = entryArr;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Metadata(Parcel parcel) {
        this.A01 = new Entry[parcel.readInt()];
        for (int i = 0; i < i; i++) {
            this.A01[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
        }
        this.A00 = parcel.readLong();
    }

    public Metadata(List<? extends Entry> entries) {
        this((Entry[]) entries.toArray(new Entry[0]));
    }

    public Metadata(Entry... entryArr) {
        this(-9223372036854775807L, entryArr);
    }

    public final int A02() {
        return this.A01.length;
    }

    public final Entry A03(int i) {
        return this.A01[i];
    }

    public final Metadata A04(Metadata metadata) {
        if (metadata == null) {
            return this;
        }
        return A05(metadata.A01);
    }

    public final Metadata A05(Entry... entryArr) {
        if (entryArr.length == 0) {
            return this;
        }
        return new Metadata(this.A00, (Entry[]) C5C.A1K(this.A01, entryArr));
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
        Metadata metadata = (Metadata) obj;
        return Arrays.equals(this.A01, metadata.A01) && this.A00 == metadata.A00;
    }

    public final int hashCode() {
        int result = Arrays.hashCode(this.A01);
        int i = result * 31;
        int result2 = AbstractC2040rd.A00(this.A00);
        return i + result2;
    }

    public final String toString() {
        return A00(21, 8, 95) + Arrays.toString(this.A01) + (this.A00 == -9223372036854775807L ? A00(0, 0, 66) : A00(0, 21, 114) + this.A00);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.A01.length);
        for (Entry entry : this.A01) {
            String[] strArr = A03;
            if (strArr[6].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[0] = "Y2eKphX3uEoYAY6qefSk2brdpzOum5mA";
            strArr2[4] = "2ZL0aXTB42gyCwKS7w8k2h86pmsl1x45";
            parcel.writeParcelable(entry, 0);
        }
        parcel.writeLong(this.A00);
    }
}
