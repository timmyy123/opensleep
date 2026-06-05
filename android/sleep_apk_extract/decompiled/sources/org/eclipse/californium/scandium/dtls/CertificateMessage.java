package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.eclipse.californium.elements.util.Asn1DerDecoder;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.CertPathUtil;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCertificateFactory;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalKeyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class CertificateMessage extends HandshakeMessage {
    private final CertPath certPath;
    private final List<byte[]> encodedChain;
    private final int length;
    private final PublicKey publicKey;
    private final byte[] rawPublicKeyBytes;
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CertificateMessage.class);
    private static final ThreadLocalCertificateFactory CERTIFICATE_FACTORY = new ThreadLocalCertificateFactory("X.509");

    public CertificateMessage(byte[] bArr, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        PublicKey publicKeyGeneratePublic = null;
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Raw public key byte array must not be null");
            throw null;
        }
        this.certPath = null;
        this.encodedChain = null;
        this.rawPublicKeyBytes = Arrays.copyOf(bArr, bArr.length);
        this.length = bArr.length + 3;
        if (bArr.length > 0) {
            try {
                String subjectPublicKeyAlgorithm = Asn1DerDecoder.readSubjectPublicKeyAlgorithm(bArr);
                if (subjectPublicKeyAlgorithm != null) {
                    ThreadLocalKeyFactory threadLocalKeyFactory = (ThreadLocalKeyFactory) ThreadLocalKeyFactory.KEY_FACTORIES.get(subjectPublicKeyAlgorithm);
                    if (threadLocalKeyFactory != null && threadLocalKeyFactory.current() != null) {
                        publicKeyGeneratePublic = threadLocalKeyFactory.current().generatePublic(new X509EncodedKeySpec(bArr));
                    }
                } else {
                    LOGGER.info("Could not reconstruct the peer's public key [{}]", StringUtil.byteArray2Hex(bArr));
                }
            } catch (IllegalArgumentException e) {
                LOGGER.warn("Could not reconstruct the peer's public key", (Throwable) e);
            } catch (GeneralSecurityException e2) {
                LOGGER.warn("Could not reconstruct the peer's public key", (Throwable) e2);
            }
        }
        this.publicKey = publicKeyGeneratePublic;
    }

    public static CertificateMessage fromReader(DatagramReader datagramReader, CertificateType certificateType, InetSocketAddress inetSocketAddress) {
        if (CertificateType.RAW_PUBLIC_KEY == certificateType) {
            LOGGER.debug("Parsing RawPublicKey CERTIFICATE message");
            return new CertificateMessage(datagramReader.readBytes(datagramReader.read(24)), inetSocketAddress);
        }
        if (CertificateType.X_509 == certificateType) {
            return readX509CertificateMessage(datagramReader, inetSocketAddress);
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Certificate type ", certificateType, " not supported!");
        return null;
    }

    private static CertificateMessage readX509CertificateMessage(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) throws HandshakeException {
        LOGGER.debug("Parsing X.509 CERTIFICATE message");
        DatagramReader datagramReaderCreateRangeReader = datagramReader.createRangeReader(datagramReader.read(24));
        try {
            CertificateFactory certificateFactoryCurrentWithCause = CERTIFICATE_FACTORY.currentWithCause();
            ArrayList arrayList = new ArrayList();
            while (datagramReaderCreateRangeReader.bytesAvailable()) {
                arrayList.add(certificateFactoryCurrentWithCause.generateCertificate(datagramReaderCreateRangeReader.createRangeInputStream(datagramReaderCreateRangeReader.read(24))));
            }
            return new CertificateMessage(certificateFactoryCurrentWithCause.generateCertPath(arrayList), inetSocketAddress);
        } catch (GeneralSecurityException e) {
            throw new HandshakeException("Cannot parse X.509 certificate chain provided by peer", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.BAD_CERTIFICATE, inetSocketAddress), e);
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        byte[] bArr = this.rawPublicKeyBytes;
        if (bArr == null) {
            datagramWriter.write(getMessageLength() - 3, 24);
            for (byte[] bArr2 : this.encodedChain) {
                datagramWriter.write(bArr2.length, 24);
                datagramWriter.writeBytes(bArr2);
            }
        } else {
            datagramWriter.write(bArr.length, 24);
            datagramWriter.writeBytes(this.rawPublicKeyBytes);
        }
        return datagramWriter.toByteArray();
    }

    public CertPath getCertificateChain() {
        return this.certPath;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return this.length;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        return HandshakeType.CERTIFICATE;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public boolean isEmpty() {
        List<byte[]> list = this.encodedChain;
        return list != null && list.isEmpty();
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        byte[] bArr = this.rawPublicKeyBytes;
        if (bArr == null && this.certPath != null) {
            sb.append("\t\tCertificate chain length: ");
            sb.append(getMessageLength() - 3);
            sb.append(StringUtil.lineSeparator());
            int i = 0;
            for (Certificate certificate : this.certPath.getCertificates()) {
                sb.append("\t\t\tCertificate Length: ");
                sb.append(this.encodedChain.get(i).length);
                sb.append(StringUtil.lineSeparator());
                sb.append("\t\t\tCertificate: ");
                sb.append(certificate);
                sb.append(StringUtil.lineSeparator());
                i++;
            }
        } else if (bArr != null && this.certPath == null) {
            sb.append("\t\tRaw Public Key: ");
            sb.append(getPublicKey().toString());
            sb.append(StringUtil.lineSeparator());
        }
        return sb.toString();
    }

    public CertificateMessage(List<X509Certificate> list, List<X500Principal> list2, InetSocketAddress inetSocketAddress) {
        this(CertPathUtil.generateValidatableCertPath(list, list2), inetSocketAddress);
        Logger logger = LOGGER;
        if (logger.isDebugEnabled()) {
            int size = this.certPath.getCertificates().size();
            if (size < list.size()) {
                logger.debug("created CERTIFICATE message with truncated certificate chain [length: {}, full-length: {}]", Integer.valueOf(size), Integer.valueOf(list.size()));
            } else {
                logger.debug("created CERTIFICATE message with certificate chain [length: {}]", Integer.valueOf(size));
            }
        }
    }

    private CertificateMessage(CertPath certPath, InetSocketAddress inetSocketAddress) {
        int length;
        super(inetSocketAddress);
        PublicKey publicKey = null;
        if (certPath != null) {
            this.rawPublicKeyBytes = null;
            this.certPath = certPath;
            List<? extends Certificate> certificates = certPath.getCertificates();
            int size = certificates.size();
            ArrayList arrayList = new ArrayList(size);
            if (size > 0) {
                try {
                    Iterator<? extends Certificate> it = certificates.iterator();
                    length = 0;
                    while (it.hasNext()) {
                        byte[] encoded = it.next().getEncoded();
                        arrayList.add(encoded);
                        length += encoded.length + 3;
                    }
                } catch (CertificateEncodingException e) {
                    LOGGER.warn("Could not encode certificate chain", (Throwable) e);
                    arrayList = null;
                    length = 0;
                }
            } else {
                length = 0;
            }
            if (arrayList != null && size != 0) {
                publicKey = certificates.get(0).getPublicKey();
            }
            this.publicKey = publicKey;
            this.encodedChain = arrayList;
            this.length = length + 3;
            return;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Certificate chain must not be null");
        throw null;
    }

    public CertificateMessage(PublicKey publicKey, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.certPath = null;
        this.encodedChain = null;
        byte[] encoded = publicKey == null ? Bytes.EMPTY : publicKey.getEncoded();
        this.rawPublicKeyBytes = encoded;
        this.length = encoded.length + 3;
        this.publicKey = publicKey;
    }

    public CertificateMessage(List<X509Certificate> list, InetSocketAddress inetSocketAddress) {
        this(list, null, inetSocketAddress);
    }
}
