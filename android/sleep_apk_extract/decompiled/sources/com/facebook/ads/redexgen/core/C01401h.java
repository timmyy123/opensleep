package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C01401h extends AQ {
    public int A00;
    public Uri A01;
    public DatagramSocket A02;
    public InetAddress A03;
    public MulticastSocket A04;
    public boolean A05;
    public final int A06;
    public final DatagramPacket A07;
    public final byte[] A08;

    public C01401h() {
        this(2000);
    }

    public C01401h(int i) {
        this(i, 8000);
    }

    public C01401h(int i, int i2) {
        super(true);
        this.A06 = i2;
        this.A08 = new byte[i];
        this.A07 = new DatagramPacket(this.A08, 0, i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
    public final Uri A9P() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
    public final long AGi(C02415i c02415i) throws C1903p1 {
        this.A01 = c02415i.A06;
        String str = (String) AbstractC02053y.A01(this.A01.getHost());
        int port = this.A01.getPort();
        A0G(c02415i);
        try {
            this.A03 = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.A03, port);
            if (this.A03.isMulticastAddress()) {
                this.A04 = new MulticastSocket(inetSocketAddress);
                this.A04.joinGroup(this.A03);
                this.A02 = this.A04;
            } else {
                this.A02 = new DatagramSocket(inetSocketAddress);
            }
            this.A02.setSoTimeout(this.A06);
            this.A05 = true;
            A0H(c02415i);
            return -1L;
        } catch (IOException e) {
            throw new C1903p1(e, 2001);
        } catch (SecurityException e2) {
            throw new C1903p1(e2, AdError.INTERNAL_ERROR_2006);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1917pF
    public final void close() {
        this.A01 = null;
        if (this.A04 != null) {
            try {
                this.A04.leaveGroup((InetAddress) AbstractC02053y.A01(this.A03));
            } catch (IOException unused) {
            }
            this.A04 = null;
        }
        if (this.A02 != null) {
            this.A02.close();
            this.A02 = null;
        }
        this.A03 = null;
        this.A00 = 0;
        if (this.A05) {
            this.A05 = false;
            A0E();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01612c
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.A00 == 0) {
            try {
                ((DatagramSocket) AbstractC02053y.A01(this.A02)).receive(this.A07);
                this.A00 = this.A07.getLength();
                A0F(this.A00);
            } catch (SocketTimeoutException e) {
                throw new C1903p1(e, AdError.CACHE_ERROR_CODE);
            } catch (IOException e2) {
                throw new C1903p1(e2, 2001);
            }
        }
        int length = this.A07.getLength() - this.A00;
        int packetOffset = this.A00;
        int bytesToRead = Math.min(packetOffset, i2);
        System.arraycopy(this.A08, length, bArr, i, bytesToRead);
        int packetOffset2 = this.A00;
        this.A00 = packetOffset2 - bytesToRead;
        return bytesToRead;
    }
}
