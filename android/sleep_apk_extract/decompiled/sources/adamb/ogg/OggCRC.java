package adamb.ogg;

import adamb.util.Util;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes.dex */
public class OggCRC {
    private int[] crc_lookup = new int[256];
    private int crc_reg;

    public OggCRC() {
        int i = 0;
        while (true) {
            int[] iArr = this.crc_lookup;
            if (i >= iArr.length) {
                reset();
                return;
            } else {
                iArr[i] = crc_entry(i);
                i++;
            }
        }
    }

    private int crc_entry(int i) {
        int i2 = i << 24;
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = Integer.MIN_VALUE & i2;
            i2 <<= 1;
            if (i4 != 0) {
                i2 ^= 79764919;
            }
        }
        return i2;
    }

    public int getValue() {
        int i = this.crc_reg;
        return Util.asIntLE(new byte[]{(byte) i, (byte) (i >>> 8), (byte) (i >>> 16), (byte) (i >>> 24)}, 0, 4);
    }

    public void reset() {
        this.crc_reg = 0;
    }

    public void update(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.crc_reg;
            this.crc_reg = this.crc_lookup[((i4 >>> 24) & PHIpAddressSearchManager.END_IP_SCAN) ^ (bArr[i3 + i] & 255)] ^ (i4 << 8);
        }
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }
}
