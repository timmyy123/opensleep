package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.ECDHServerKeyExchange;
import org.eclipse.californium.scandium.dtls.cipher.XECDHECryptography;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class EcdhPskServerKeyExchange extends ECDHServerKeyExchange {
    private final PskPublicInformation hint;

    public EcdhPskServerKeyExchange(PskPublicInformation pskPublicInformation, XECDHECryptography xECDHECryptography, InetSocketAddress inetSocketAddress) {
        super(xECDHECryptography.getSupportedGroup(), xECDHECryptography.getEncodedPoint(), inetSocketAddress);
        if (pskPublicInformation != null) {
            this.hint = pskPublicInformation;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("PSK hint must not be null");
            throw null;
        }
    }

    public static HandshakeMessage fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("peer address cannot be null");
            return null;
        }
        byte[] bytes = datagramReader.readBytes(datagramReader.read(16));
        ECDHServerKeyExchange.EcdhData namedCurve = ECDHServerKeyExchange.readNamedCurve(datagramReader, inetSocketAddress);
        return new EcdhPskServerKeyExchange(bytes, namedCurve.supportedGroup, namedCurve.encodedPoint, inetSocketAddress);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.hint.length(), 16);
        datagramWriter.writeBytes(this.hint.getBytes());
        writeNamedCurve(datagramWriter);
        return datagramWriter.toByteArray();
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return getNamedCurveLength() + this.hint.length() + 2;
    }

    @Override // org.eclipse.californium.scandium.dtls.ECDHServerKeyExchange, org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.hint.isEmpty()) {
            sb.append("\t\tPSK Identity Hint: psk hint not present");
        } else {
            sb.append("\t\tPSK Identity Hint: ");
            sb.append(this.hint);
        }
        sb.append(StringUtil.lineSeparator());
        sb.append(super.toString());
        return sb.toString();
    }

    private EcdhPskServerKeyExchange(byte[] bArr, XECDHECryptography.SupportedGroup supportedGroup, byte[] bArr2, InetSocketAddress inetSocketAddress) {
        super(supportedGroup, bArr2, inetSocketAddress);
        this.hint = PskPublicInformation.fromByteArray(bArr);
    }
}
