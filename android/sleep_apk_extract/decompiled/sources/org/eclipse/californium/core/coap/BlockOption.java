package org.eclipse.californium.core.coap;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.Bytes;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockOption {
    private final boolean m;
    private final int num;
    private final int szx;

    public BlockOption(byte[] bArr) {
        bArr.getClass();
        if (bArr.length > 3) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(bArr.length, " must be at most 3 bytes inclusive", new StringBuilder("Block option's length ")));
            throw null;
        }
        if (bArr.length == 0) {
            this.szx = 0;
            this.m = false;
            this.num = 0;
            return;
        }
        byte b = bArr[bArr.length - 1];
        this.szx = b & 7;
        this.m = ((b >> 3) & 1) == 1;
        int i = (b & 255) >> 4;
        for (int i2 = 1; i2 < bArr.length; i2++) {
            i += (bArr[(bArr.length - i2) - 1] & 255) << ((i2 * 8) - 4);
        }
        this.num = i;
    }

    public static int size2Szx(int i) {
        if (i >= 1024) {
            return 6;
        }
        if (i <= 16) {
            return 0;
        }
        return Integer.numberOfTrailingZeros(Integer.highestOneBit(i)) - 4;
    }

    public static int szx2Size(int i) {
        if (i <= 0) {
            return 16;
        }
        if (i >= 6) {
            return 1024;
        }
        return 1 << (i + 4);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BlockOption)) {
            return false;
        }
        BlockOption blockOption = (BlockOption) obj;
        return this.szx == blockOption.szx && this.num == blockOption.num && this.m == blockOption.m;
    }

    public int getNum() {
        return this.num;
    }

    public int getOffset() {
        return szx2Size(this.szx) * this.num;
    }

    public int getSize() {
        return 1 << (this.szx + 4);
    }

    public int getSzx() {
        return this.szx;
    }

    public byte[] getValue() {
        int i = this.szx;
        boolean z = this.m;
        int i2 = (z ? 8 : 0) | i;
        int i3 = this.num;
        return (i3 == 0 && !z && i == 0) ? Bytes.EMPTY : i3 < 16 ? new byte[]{(byte) ((i3 << 4) | i2)} : i3 < 4096 ? new byte[]{(byte) (i3 >> 4), (byte) ((i3 << 4) | i2)} : new byte[]{(byte) (i3 >> 12), (byte) (i3 >> 4), (byte) ((i3 << 4) | i2)};
    }

    public int hashCode() {
        return (((this.szx * 31) + (this.m ? 1 : 0)) * 31) + this.num;
    }

    public boolean isM() {
        return this.m;
    }

    public String toString() {
        return String.format("(szx=%d/%d, m=%b, num=%d)", Integer.valueOf(this.szx), Integer.valueOf(szx2Size(this.szx)), Boolean.valueOf(this.m), Integer.valueOf(this.num));
    }

    public BlockOption(BlockOption blockOption) {
        if (blockOption != null) {
            this.szx = blockOption.getSzx();
            this.m = blockOption.isM();
            this.num = blockOption.getNum();
            return;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("origin must not be null");
        throw null;
    }

    public BlockOption(int i, boolean z, int i2) {
        if (i < 0 || 7 < i) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "Block option's szx ", " must be between 0 and 7 inclusive"));
            throw null;
        }
        if (i2 >= 0 && 1048575 >= i2) {
            this.szx = i;
            this.m = z;
            this.num = i2;
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i2, "Block option's num ", " must be between 0 and 524288 inclusive"));
        throw null;
    }
}
