package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.List;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.cipher.RandomManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class CertificateVerify extends HandshakeMessage {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CertificateVerify.class);
    private final SignatureAndHashAlgorithm signatureAndHashAlgorithm;
    private final byte[] signatureBytes;

    public CertificateVerify(SignatureAndHashAlgorithm signatureAndHashAlgorithm, PrivateKey privateKey, List<HandshakeMessage> list, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.signatureAndHashAlgorithm = signatureAndHashAlgorithm;
        this.signatureBytes = sign(signatureAndHashAlgorithm, privateKey, list);
    }

    public static HandshakeMessage fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        return new CertificateVerify(new SignatureAndHashAlgorithm(datagramReader.read(8), datagramReader.read(8)), datagramReader.readBytes(datagramReader.read(16)), inetSocketAddress);
    }

    private static byte[] sign(SignatureAndHashAlgorithm signatureAndHashAlgorithm, PrivateKey privateKey, List<HandshakeMessage> list) {
        byte[] bArr = Bytes.EMPTY;
        try {
            Signature signatureCurrentWithCause = signatureAndHashAlgorithm.getThreadLocalSignature().currentWithCause();
            signatureCurrentWithCause.initSign(privateKey, RandomManager.currentSecureRandom());
            int i = 0;
            for (HandshakeMessage handshakeMessage : list) {
                signatureCurrentWithCause.update(handshakeMessage.toByteArray());
                LOGGER.trace("  [{}] - {}", Integer.valueOf(i), handshakeMessage.getMessageType());
                i++;
            }
            return signatureCurrentWithCause.sign();
        } catch (Exception e) {
            LOGGER.error("Could not create signature.", (Throwable) e);
            return bArr;
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.signatureAndHashAlgorithm.getHash().getCode(), 8);
        datagramWriter.write(this.signatureAndHashAlgorithm.getSignature().getCode(), 8);
        datagramWriter.write(this.signatureBytes.length, 16);
        datagramWriter.writeBytes(this.signatureBytes);
        return datagramWriter.toByteArray();
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return this.signatureBytes.length + 4;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        return HandshakeType.CERTIFICATE_VERIFY;
    }

    public void verifySignature(PublicKey publicKey, List<HandshakeMessage> list) throws HandshakeException {
        try {
            Signature signatureCurrentWithCause = this.signatureAndHashAlgorithm.getThreadLocalSignature().currentWithCause();
            signatureCurrentWithCause.initVerify(publicKey);
            int i = 0;
            for (HandshakeMessage handshakeMessage : list) {
                signatureCurrentWithCause.update(handshakeMessage.toByteArray());
                LOGGER.trace("  [{}] - {}", Integer.valueOf(i), handshakeMessage.getMessageType());
                i++;
            }
            if (signatureCurrentWithCause.verify(this.signatureBytes)) {
                return;
            }
        } catch (GeneralSecurityException e) {
            LOGGER.error("Could not verify the client's signature.", (Throwable) e);
        }
        throw new HandshakeException("The client's CertificateVerify message could not be verified.", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, getPeer()));
    }

    private CertificateVerify(SignatureAndHashAlgorithm signatureAndHashAlgorithm, byte[] bArr, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.signatureAndHashAlgorithm = signatureAndHashAlgorithm;
        this.signatureBytes = bArr;
    }
}
