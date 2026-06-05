package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;

/* JADX INFO: loaded from: classes5.dex */
public final class PSKServerKeyExchange extends ServerKeyExchange {
    private final PskPublicInformation hint;

    private PSKServerKeyExchange(byte[] bArr, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.hint = PskPublicInformation.fromByteArray(bArr);
    }

    public static HandshakeMessage fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        return new PSKServerKeyExchange(datagramReader.readBytes(datagramReader.read(16)), inetSocketAddress);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.hint.length(), 16);
        datagramWriter.writeBytes(this.hint.getBytes());
        return datagramWriter.toByteArray();
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return this.hint.length() + 2;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        return super.toString() + "\t\tPSK Identity Hint: " + this.hint + StringUtil.lineSeparator();
    }
}
