package com.facebook.ads.redexgen.core;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0530Hf {
    public int A00;
    public int A01;
    public final int A02;
    public final byte[] A03;

    public C0530Hf(byte[] bArr) {
        this.A03 = bArr;
        this.A02 = bArr.length;
    }

    private void A00() {
        AbstractC02053y.A08(this.A01 >= 0 && (this.A01 < this.A02 || (this.A01 == this.A02 && this.A00 == 0)));
    }

    public final int A01() {
        return (this.A01 * 8) + this.A00;
    }

    public final int A02(int i) {
        int bitsRead = this.A01;
        int tempByteOffset = Math.min(i, 8 - this.A00);
        int i2 = bitsRead + 1;
        int tempByteOffset2 = this.A03[bitsRead];
        int tempByteOffset3 = ((tempByteOffset2 & PHIpAddressSearchManager.END_IP_SCAN) >> this.A00) & (PHIpAddressSearchManager.END_IP_SCAN >> (8 - tempByteOffset));
        while (tempByteOffset < i) {
            int returnValue = this.A03[i2];
            tempByteOffset3 |= (returnValue & PHIpAddressSearchManager.END_IP_SCAN) << tempByteOffset;
            tempByteOffset += 8;
            i2++;
        }
        int returnValue2 = (-1) >>> (32 - i);
        int tempByteOffset4 = tempByteOffset3 & returnValue2;
        A03(i);
        return tempByteOffset4;
    }

    public final void A03(int i) {
        int i2 = i / 8;
        int numBytes = this.A01;
        this.A01 = numBytes + i2;
        int numBytes2 = i2 * 8;
        this.A00 += i - numBytes2;
        if (this.A00 > 7) {
            int numBytes3 = this.A01;
            this.A01 = numBytes3 + 1;
            int numBytes4 = this.A00;
            this.A00 = numBytes4 - 8;
        }
        A00();
    }

    public final boolean A04() {
        boolean returnValue = (((this.A03[this.A01] & 255) >> this.A00) & 1) == 1;
        A03(1);
        return returnValue;
    }
}
