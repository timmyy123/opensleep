package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.ECDHServerKeyExchange;
import org.eclipse.californium.scandium.dtls.cipher.RandomManager;
import org.eclipse.californium.scandium.dtls.cipher.XECDHECryptography;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class EcdhEcdsaServerKeyExchange extends ECDHServerKeyExchange {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) EcdhEcdsaServerKeyExchange.class);
    private final SignatureAndHashAlgorithm signatureAndHashAlgorithm;
    private final byte[] signatureEncoded;

    public EcdhEcdsaServerKeyExchange(SignatureAndHashAlgorithm signatureAndHashAlgorithm, XECDHECryptography xECDHECryptography, PrivateKey privateKey, Random random, Random random2, InetSocketAddress inetSocketAddress) throws GeneralSecurityException {
        super(xECDHECryptography.getSupportedGroup(), xECDHECryptography.getEncodedPoint(), inetSocketAddress);
        if (signatureAndHashAlgorithm == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("signature and hash algorithm cannot be null");
            throw null;
        }
        this.signatureAndHashAlgorithm = signatureAndHashAlgorithm;
        Signature signatureCurrentWithCause = signatureAndHashAlgorithm.getThreadLocalSignature().currentWithCause();
        signatureCurrentWithCause.initSign(privateKey, RandomManager.currentSecureRandom());
        updateSignature(signatureCurrentWithCause, random, random2);
        this.signatureEncoded = signatureCurrentWithCause.sign();
    }

    public static HandshakeMessage fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        SignatureAndHashAlgorithm signatureAndHashAlgorithm;
        byte[] bytes;
        ECDHServerKeyExchange.EcdhData namedCurve = ECDHServerKeyExchange.readNamedCurve(datagramReader, inetSocketAddress);
        if (datagramReader.bytesAvailable()) {
            SignatureAndHashAlgorithm signatureAndHashAlgorithm2 = new SignatureAndHashAlgorithm(datagramReader.read(8), datagramReader.read(8));
            bytes = datagramReader.readBytes(datagramReader.read(16));
            signatureAndHashAlgorithm = signatureAndHashAlgorithm2;
        } else {
            signatureAndHashAlgorithm = null;
            bytes = null;
        }
        return new EcdhEcdsaServerKeyExchange(signatureAndHashAlgorithm, namedCurve.supportedGroup, namedCurve.encodedPoint, bytes, inetSocketAddress);
    }

    private void updateSignature(Signature signature, Random random, Random random2) throws SignatureException {
        signature.update(random.getBytes());
        signature.update(random2.getBytes());
        updateSignatureForNamedCurve(signature);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        writeNamedCurve(datagramWriter);
        if (this.signatureEncoded != null) {
            datagramWriter.write(this.signatureAndHashAlgorithm.getHash().getCode(), 8);
            datagramWriter.write(this.signatureAndHashAlgorithm.getSignature().getCode(), 8);
            datagramWriter.write(this.signatureEncoded.length, 16);
            datagramWriter.writeBytes(this.signatureEncoded);
        }
        return datagramWriter.toByteArray();
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        byte[] bArr = this.signatureEncoded;
        return getNamedCurveLength() + (bArr == null ? 0 : bArr.length + 4);
    }

    @Override // org.eclipse.californium.scandium.dtls.ECDHServerKeyExchange, org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (this.signatureEncoded != null) {
            sb.append("\t\tSignature: ");
        }
        sb.append(this.signatureAndHashAlgorithm.toString());
        sb.append("-");
        sb.append(StringUtil.byteArray2HexString(this.signatureEncoded, (char) 0, 10));
        sb.append(StringUtil.lineSeparator());
        return sb.toString();
    }

    public void verifySignature(PublicKey publicKey, Random random, Random random2) throws HandshakeException {
        boolean zVerify;
        if (this.signatureEncoded == null) {
            throw new HandshakeException("The server's ECDHE key exchange message has no signature.", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, getPeer()));
        }
        try {
            Signature signatureCurrentWithCause = this.signatureAndHashAlgorithm.getThreadLocalSignature().currentWithCause();
            signatureCurrentWithCause.initVerify(publicKey);
            updateSignature(signatureCurrentWithCause, random, random2);
            zVerify = signatureCurrentWithCause.verify(this.signatureEncoded);
        } catch (GeneralSecurityException e) {
            LOGGER.error("Could not verify the server's signature.", (Throwable) e);
            zVerify = false;
        }
        if (!zVerify) {
            throw new HandshakeException("The server's ECDHE key exchange message's signature could not be verified.", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.HANDSHAKE_FAILURE, getPeer()));
        }
    }

    private EcdhEcdsaServerKeyExchange(SignatureAndHashAlgorithm signatureAndHashAlgorithm, XECDHECryptography.SupportedGroup supportedGroup, byte[] bArr, byte[] bArr2, InetSocketAddress inetSocketAddress) {
        super(supportedGroup, bArr, inetSocketAddress);
        if (signatureAndHashAlgorithm == null && bArr2 != null) {
            Types$$ExternalSyntheticBUOutline0.m$1("signature and hash algorithm cannot be null");
            throw null;
        }
        if (signatureAndHashAlgorithm != null && bArr2 == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("signature cannot be null");
            throw null;
        }
        this.signatureAndHashAlgorithm = signatureAndHashAlgorithm;
        this.signatureEncoded = bArr2;
    }
}
