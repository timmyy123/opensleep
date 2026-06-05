package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.security.Signature;
import java.util.Arrays;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.cipher.XECDHECryptography;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ECDHServerKeyExchange extends ServerKeyExchange {
    private final byte[] encodedPoint;
    private final XECDHECryptography.SupportedGroup supportedGroup;

    public static class EcdhData {
        public final byte[] encodedPoint;
        public final XECDHECryptography.SupportedGroup supportedGroup;

        public EcdhData(XECDHECryptography.SupportedGroup supportedGroup, byte[] bArr) {
            this.supportedGroup = supportedGroup;
            this.encodedPoint = bArr;
        }
    }

    public ECDHServerKeyExchange(XECDHECryptography.SupportedGroup supportedGroup, byte[] bArr, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        if (supportedGroup == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("supported group cannot be null!");
            throw null;
        }
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("encoded point cannot be null!");
            throw null;
        }
        this.supportedGroup = supportedGroup;
        this.encodedPoint = bArr;
    }

    public static EcdhData readNamedCurve(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        int i = datagramReader.read(8);
        if (i != 3) {
            throw new HandshakeException(String.format("Curve type [%s] received in ServerKeyExchange message from peer [%s] is unsupported", Integer.valueOf(i), inetSocketAddress), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, inetSocketAddress));
        }
        int i2 = datagramReader.read(16);
        XECDHECryptography.SupportedGroup supportedGroupFromId = XECDHECryptography.SupportedGroup.fromId(i2);
        if (supportedGroupFromId == null || !supportedGroupFromId.isUsable()) {
            throw new HandshakeException(String.format("Server used unsupported elliptic curve (%d) for ECDH", Integer.valueOf(i2)), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, inetSocketAddress));
        }
        return new EcdhData(supportedGroupFromId, datagramReader.readBytes(datagramReader.read(8)));
    }

    public byte[] getEncodedPoint() {
        byte[] bArr = this.encodedPoint;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public int getNamedCurveLength() {
        return this.encodedPoint.length + 4;
    }

    public XECDHECryptography.SupportedGroup getSupportedGroup() {
        return this.supportedGroup;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        return super.toString() + "\t\tDiffie-Hellman public key: " + this.supportedGroup.name() + "-" + StringUtil.byteArray2HexString(this.encodedPoint, (char) 0, 10) + StringUtil.lineSeparator();
    }

    public void updateSignatureForNamedCurve(Signature signature) {
        int id = getSupportedGroup().getId();
        signature.update((byte) 3);
        signature.update((byte) (id >> 8));
        signature.update((byte) id);
        signature.update((byte) this.encodedPoint.length);
        signature.update(this.encodedPoint);
    }

    public void writeNamedCurve(DatagramWriter datagramWriter) {
        datagramWriter.write(3, 8);
        datagramWriter.write(this.supportedGroup.getId(), 16);
        datagramWriter.write(this.encodedPoint.length, 8);
        datagramWriter.writeBytes(this.encodedPoint);
    }
}
