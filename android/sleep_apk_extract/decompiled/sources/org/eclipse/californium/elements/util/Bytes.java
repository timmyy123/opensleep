package org.eclipse.californium.elements.util;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.Arrays;
import java.util.Random;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Bytes {
    public static final byte[] EMPTY = new byte[0];
    private String asString;
    private final byte[] bytes;
    private final int hash;

    public Bytes(byte[] bArr, int i, boolean z) {
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("bytes must not be null");
            throw null;
        }
        if (bArr.length > i) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "bytes length must be between 0 and ", " inclusive"));
            throw null;
        }
        this.bytes = z ? Arrays.copyOf(bArr, bArr.length) : bArr;
        this.hash = Arrays.hashCode(bArr);
    }

    public static void clear(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length + length2];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        System.arraycopy(bArr2, 0, bArr3, length, length2);
        return bArr3;
    }

    public static byte[] createBytes(Random random, int i) {
        byte[] bArr = new byte[i];
        random.nextBytes(bArr);
        return bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Bytes bytes = (Bytes) obj;
        if (this.hash != bytes.hash) {
            return false;
        }
        return Arrays.equals(this.bytes, bytes.bytes);
    }

    public final String getAsString() {
        if (this.asString == null) {
            this.asString = StringUtil.byteArray2Hex(this.bytes);
        }
        return this.asString;
    }

    public final byte[] getBytes() {
        return this.bytes;
    }

    public final int hashCode() {
        return this.hash;
    }

    public final boolean isEmpty() {
        return this.bytes.length == 0;
    }

    public final int length() {
        return this.bytes.length;
    }

    public static byte[] concatenate(Bytes bytes, Bytes bytes2) {
        return concatenate(bytes.getBytes(), bytes2.getBytes());
    }

    public Bytes(byte[] bArr) {
        this(bArr, PHIpAddressSearchManager.END_IP_SCAN, false);
    }
}
