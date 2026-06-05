package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class EcdhPskClientKeyExchange extends ECDHClientKeyExchange {
    private final PskPublicInformation identity;

    public EcdhPskClientKeyExchange(PskPublicInformation pskPublicInformation, byte[] bArr, InetSocketAddress inetSocketAddress) {
        super(bArr, inetSocketAddress);
        if (pskPublicInformation != null) {
            this.identity = pskPublicInformation;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("identity cannot be null");
            throw null;
        }
    }

    public static HandshakeMessage fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress != null) {
            return new EcdhPskClientKeyExchange(PskPublicInformation.fromByteArray(datagramReader.readBytes(datagramReader.read(16))), ECDHClientKeyExchange.readEncodedPoint(datagramReader), inetSocketAddress);
        }
        Types$$ExternalSyntheticBUOutline0.m$1("peer address cannot be null");
        return null;
    }

    public PskPublicInformation getIdentity() {
        return this.identity;
    }

    @Override // org.eclipse.californium.scandium.dtls.ECDHClientKeyExchange, org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return this.identity.length() + 2 + super.getMessageLength();
    }

    @Override // org.eclipse.californium.scandium.dtls.ECDHClientKeyExchange, org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        return "\t\t Encoded identity value: " + this.identity + StringUtil.lineSeparator() + super.toString() + StringUtil.lineSeparator();
    }

    @Override // org.eclipse.californium.scandium.dtls.ECDHClientKeyExchange
    public void writeFragment(DatagramWriter datagramWriter) {
        datagramWriter.write(this.identity.length(), 16);
        datagramWriter.writeBytes(this.identity.getBytes());
        super.writeFragment(datagramWriter);
    }
}
