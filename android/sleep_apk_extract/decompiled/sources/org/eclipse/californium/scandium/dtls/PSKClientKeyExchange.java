package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;

/* JADX INFO: loaded from: classes5.dex */
public final class PSKClientKeyExchange extends ClientKeyExchange {
    private final PskPublicInformation identity;

    private PSKClientKeyExchange(byte[] bArr, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.identity = PskPublicInformation.fromByteArray(bArr);
    }

    public static HandshakeMessage fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        return new PSKClientKeyExchange(datagramReader.readBytes(datagramReader.read(16)), inetSocketAddress);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.identity.length(), 16);
        datagramWriter.writeBytes(this.identity.getBytes());
        return datagramWriter.toByteArray();
    }

    public PskPublicInformation getIdentity() {
        return this.identity;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return this.identity.length() + 2;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        return super.toString() + "\t\tPSK Identity: " + this.identity + StringUtil.lineSeparator();
    }

    public PSKClientKeyExchange(PskPublicInformation pskPublicInformation, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.identity = pskPublicInformation;
    }
}
