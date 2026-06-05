package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.cipher.PseudoRandomFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class Finished extends HandshakeMessage {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) Finished.class);
    private final byte[] verifyData;

    public Finished(Mac mac, SecretKey secretKey, boolean z, byte[] bArr, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.verifyData = generateVerifyData(mac, secretKey, z, bArr);
    }

    public static HandshakeMessage fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        return new Finished(datagramReader, inetSocketAddress);
    }

    private byte[] generateVerifyData(Mac mac, SecretKey secretKey, boolean z, byte[] bArr) {
        return z ? PseudoRandomFunction.doPRF(mac, secretKey, PseudoRandomFunction.Label.CLIENT_FINISHED_LABEL, bArr) : PseudoRandomFunction.doPRF(mac, secretKey, PseudoRandomFunction.Label.SERVER_FINISHED_LABEL, bArr);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        return this.verifyData;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return this.verifyData.length;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        return HandshakeType.FINISHED;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        return super.toString() + "\t\tVerify Data: " + StringUtil.byteArray2HexString(this.verifyData) + StringUtil.lineSeparator();
    }

    public void verifyData(Mac mac, SecretKey secretKey, boolean z, byte[] bArr) throws HandshakeException {
        byte[] bArrGenerateVerifyData = generateVerifyData(mac, secretKey, z, bArr);
        if (MessageDigest.isEqual(bArrGenerateVerifyData, this.verifyData)) {
            return;
        }
        StringBuilder sb = new StringBuilder("Verification of peer's [");
        sb.append(getPeer());
        sb.append("] FINISHED message failed");
        Logger logger = LOG;
        if (logger.isTraceEnabled()) {
            sb.append(StringUtil.lineSeparator());
            sb.append("Expected: ");
            sb.append(StringUtil.byteArray2HexString(bArrGenerateVerifyData));
            sb.append(StringUtil.lineSeparator());
            sb.append("Received: ");
            sb.append(StringUtil.byteArray2HexString(this.verifyData));
        }
        logger.debug(sb.toString());
        throw new HandshakeException("Verification of FINISHED message failed", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, getPeer()));
    }

    private Finished(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.verifyData = datagramReader.readBytesLeft();
    }
}
