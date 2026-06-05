package com.facebook.ads.redexgen.core;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class A0 extends AbstractC1866oQ {
    public static final int A00 = Float.floatToIntBits(Float.NaN);

    public static void A00(int i, ByteBuffer byteBuffer) {
        float pcm32BitFloat = (float) (((double) i) * 4.656612875245797E-10d);
        int floatBits = Float.floatToIntBits(pcm32BitFloat);
        if (floatBits == A00) {
            floatBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatBits);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1866oQ
    public final C01893i A09(C01893i c01893i) throws C01903j {
        int i = c01893i.A02;
        if (C5C.A14(i)) {
            if (i != 4) {
                return new C01893i(c01893i.A03, c01893i.A01, 4);
            }
            return C01893i.A05;
        }
        throw new C01903j(c01893i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01913k
    public final void AHH(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferA00;
        int i = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int limit = iLimit - i;
        int position = this.A05.A02;
        switch (position) {
            case 536870912:
                int position2 = limit / 3;
                byteBufferA00 = A00(position2 * 4);
                while (i < iLimit) {
                    int position3 = byteBuffer.get(i);
                    int limit2 = (position3 & PHIpAddressSearchManager.END_IP_SCAN) << 8;
                    int position4 = i + 1;
                    int limit3 = limit2 | ((byteBuffer.get(position4) & PHIpAddressSearchManager.END_IP_SCAN) << 16);
                    int position5 = i + 2;
                    A00(limit3 | ((byteBuffer.get(position5) & PHIpAddressSearchManager.END_IP_SCAN) << 24), byteBufferA00);
                    i += 3;
                }
                break;
            case 805306368:
                byteBufferA00 = A00(limit);
                while (i < iLimit) {
                    int position6 = byteBuffer.get(i);
                    int limit4 = position6 & PHIpAddressSearchManager.END_IP_SCAN;
                    int position7 = i + 1;
                    int limit5 = limit4 | ((byteBuffer.get(position7) & PHIpAddressSearchManager.END_IP_SCAN) << 8);
                    int position8 = i + 2;
                    int limit6 = limit5 | ((byteBuffer.get(position8) & PHIpAddressSearchManager.END_IP_SCAN) << 16);
                    int position9 = i + 3;
                    A00(limit6 | ((byteBuffer.get(position9) & PHIpAddressSearchManager.END_IP_SCAN) << 24), byteBufferA00);
                    i += 4;
                }
                break;
            default:
                throw new IllegalStateException();
        }
        int position10 = byteBuffer.limit();
        byteBuffer.position(position10);
        byteBufferA00.flip();
    }
}
