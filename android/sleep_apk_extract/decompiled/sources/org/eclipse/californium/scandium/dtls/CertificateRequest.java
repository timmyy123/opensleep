package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.eclipse.californium.elements.util.Asn1DerDecoder;
import org.eclipse.californium.elements.util.CertPathUtil;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class CertificateRequest extends HandshakeMessage {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CertificateRequest.class);
    private final List<X500Principal> certificateAuthorities;
    private int certificateAuthoritiesEncodedLength;
    private final List<ClientCertificateType> certificateTypes;
    private final List<SignatureAndHashAlgorithm> supportedSignatureAlgorithms;

    public enum ClientCertificateType {
        RSA_SIGN(1, true, "RSA"),
        DSS_SIGN(2, true, "DSA"),
        RSA_FIXED_DH(3, false, "DH"),
        DSS_FIXED_DH(4, false, "DH"),
        RSA_EPHEMERAL_DH_RESERVED(5, false, "DH"),
        DSS_EPHEMERAL_DH_RESERVED(6, false, "DH"),
        FORTEZZA_DMS_RESERVED(20, false, "UNKNOWN"),
        ECDSA_SIGN(64, true, "EC", "EdDSA", "OID.1.3.101.112", "OID.1.3.101.113"),
        RSA_FIXED_ECDH(65, false, "DH"),
        ECDSA_FIXED_ECDH(66, false, "DH");

        private final int code;
        private final String[] jcaAlgorithms;
        private final boolean requiresSigningCapability;

        ClientCertificateType(int i, boolean z, String... strArr) {
            this.code = i;
            this.jcaAlgorithms = strArr;
            this.requiresSigningCapability = z;
        }

        public static ClientCertificateType getTypeByCode(int i) {
            for (ClientCertificateType clientCertificateType : values()) {
                if (clientCertificateType.code == i) {
                    return clientCertificateType;
                }
            }
            return null;
        }

        public int getCode() {
            return this.code;
        }

        public boolean isCompatibleWithKeyAlgorithm(String str) {
            String edDsaStandardAlgorithmName = Asn1DerDecoder.getEdDsaStandardAlgorithmName(str, str);
            for (String str2 : this.jcaAlgorithms) {
                if (str2.equalsIgnoreCase(edDsaStandardAlgorithmName)) {
                    return true;
                }
            }
            return false;
        }

        public boolean requiresSigningCapability() {
            return this.requiresSigningCapability;
        }
    }

    public CertificateRequest(List<ClientCertificateType> list, List<SignatureAndHashAlgorithm> list2, List<X500Principal> list3, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        ArrayList arrayList = new ArrayList();
        this.certificateTypes = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.supportedSignatureAlgorithms = arrayList2;
        this.certificateAuthorities = new ArrayList();
        this.certificateAuthoritiesEncodedLength = 0;
        if (list != null) {
            arrayList.addAll(list);
        }
        if (!list2.isEmpty()) {
            arrayList2.addAll(list2);
        }
        if (list3 != null) {
            addCerticiateAuthorities(list3);
        }
    }

    public static HandshakeMessage fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) {
        ArrayList arrayList = new ArrayList();
        DatagramReader datagramReaderCreateRangeReader = datagramReader.createRangeReader(datagramReader.read(8));
        while (datagramReaderCreateRangeReader.bytesAvailable()) {
            arrayList.add(ClientCertificateType.getTypeByCode(datagramReaderCreateRangeReader.read(8)));
        }
        ArrayList arrayList2 = new ArrayList();
        DatagramReader datagramReaderCreateRangeReader2 = datagramReader.createRangeReader(datagramReader.read(16));
        while (datagramReaderCreateRangeReader2.bytesAvailable()) {
            arrayList2.add(new SignatureAndHashAlgorithm(datagramReaderCreateRangeReader2.read(8), datagramReaderCreateRangeReader2.read(8)));
        }
        ArrayList arrayList3 = new ArrayList();
        DatagramReader datagramReaderCreateRangeReader3 = datagramReader.createRangeReader(datagramReader.read(16));
        while (datagramReaderCreateRangeReader3.bytesAvailable()) {
            arrayList3.add(new X500Principal(datagramReaderCreateRangeReader3.readBytes(datagramReaderCreateRangeReader3.read(16))));
        }
        return new CertificateRequest(arrayList, arrayList2, arrayList3, inetSocketAddress);
    }

    public boolean addCerticiateAuthorities(List<X500Principal> list) {
        Iterator<X500Principal> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!addCertificateAuthority(it.next())) {
                LOGGER.debug("could add only {} of {} certificate authorities, max length exceeded", Integer.valueOf(i), Integer.valueOf(list.size()));
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean addCertificateAuthority(X500Principal x500Principal) {
        if (x500Principal == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("authority must not be null");
            return false;
        }
        int length = x500Principal.getEncoded().length + 2;
        if (this.certificateAuthoritiesEncodedLength + length > 65535) {
            return false;
        }
        this.certificateAuthorities.add(x500Principal);
        this.certificateAuthoritiesEncodedLength += length;
        return true;
    }

    public void addCertificateType(ClientCertificateType clientCertificateType) {
        this.certificateTypes.add(clientCertificateType);
    }

    public void addSignatureAlgorithms(List<SignatureAndHashAlgorithm> list) {
        this.supportedSignatureAlgorithms.addAll(list);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(this.certificateTypes.size(), 8);
        Iterator<ClientCertificateType> it = this.certificateTypes.iterator();
        while (it.hasNext()) {
            datagramWriter.write(it.next().getCode(), 8);
        }
        datagramWriter.write(this.supportedSignatureAlgorithms.size() * 2, 16);
        for (SignatureAndHashAlgorithm signatureAndHashAlgorithm : this.supportedSignatureAlgorithms) {
            datagramWriter.write(signatureAndHashAlgorithm.getHash().getCode(), 8);
            datagramWriter.write(signatureAndHashAlgorithm.getSignature().getCode(), 8);
        }
        datagramWriter.write(this.certificateAuthoritiesEncodedLength, 16);
        Iterator<X500Principal> it2 = this.certificateAuthorities.iterator();
        while (it2.hasNext()) {
            byte[] encoded = it2.next().getEncoded();
            datagramWriter.write(encoded.length, 16);
            datagramWriter.writeBytes(encoded);
        }
        return datagramWriter.toByteArray();
    }

    public List<X500Principal> getCertificateAuthorities() {
        return Collections.unmodifiableList(this.certificateAuthorities);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return (this.supportedSignatureAlgorithms.size() * 2) + this.certificateTypes.size() + 3 + 2 + this.certificateAuthoritiesEncodedLength;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        return HandshakeType.CERTIFICATE_REQUEST;
    }

    public SignatureAndHashAlgorithm getSignatureAndHashAlgorithm(List<X509Certificate> list) {
        SignatureAndHashAlgorithm supportedSignatureAlgorithm;
        X509Certificate x509Certificate = list.get(0);
        if (isSupportedKeyType(x509Certificate) && (supportedSignatureAlgorithm = SignatureAndHashAlgorithm.getSupportedSignatureAlgorithm(this.supportedSignatureAlgorithms, x509Certificate.getPublicKey())) != null && SignatureAndHashAlgorithm.isSignedWithSupportedAlgorithms(this.supportedSignatureAlgorithms, list)) {
            return supportedSignatureAlgorithm;
        }
        return null;
    }

    public boolean isSupportedKeyType(X509Certificate x509Certificate) {
        String algorithm = x509Certificate.getPublicKey().getAlgorithm();
        Boolean boolValueOf = null;
        for (ClientCertificateType clientCertificateType : this.certificateTypes) {
            if (clientCertificateType.isCompatibleWithKeyAlgorithm(algorithm)) {
                if (clientCertificateType.requiresSigningCapability()) {
                    if (boolValueOf == null) {
                        boolValueOf = Boolean.valueOf(CertPathUtil.canBeUsedForAuthentication(x509Certificate, true));
                    }
                    if (!boolValueOf.booleanValue()) {
                        LOGGER.error("type: {}, requires missing signing capability!", clientCertificateType);
                    }
                }
                LOGGER.debug("type: {}, is compatible with KeyAlgorithm[{}] and meets signing requirements", clientCertificateType, algorithm);
                return true;
            }
            LOGGER.debug("type: {}, is not compatible with KeyAlgorithm[{}]", clientCertificateType, algorithm);
        }
        LOGGER.debug("certificate [{}] with public key {} is not of any supported type", x509Certificate, algorithm);
        return false;
    }

    public void selectSignatureAlgorithms(List<SignatureAndHashAlgorithm> list) {
        ArrayList arrayList = new ArrayList();
        for (SignatureAndHashAlgorithm signatureAndHashAlgorithm : this.supportedSignatureAlgorithms) {
            if (!list.contains(signatureAndHashAlgorithm)) {
                arrayList.add(signatureAndHashAlgorithm);
            }
        }
        this.supportedSignatureAlgorithms.removeAll(arrayList);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (!this.certificateTypes.isEmpty()) {
            sb.append("\t\tClient certificate type:");
            sb.append(StringUtil.lineSeparator());
            for (ClientCertificateType clientCertificateType : this.certificateTypes) {
                sb.append("\t\t\t");
                sb.append(clientCertificateType);
                sb.append(StringUtil.lineSeparator());
            }
        }
        if (!this.supportedSignatureAlgorithms.isEmpty()) {
            sb.append("\t\tSignature and hash algorithm:");
            sb.append(StringUtil.lineSeparator());
            for (SignatureAndHashAlgorithm signatureAndHashAlgorithm : this.supportedSignatureAlgorithms) {
                sb.append("\t\t\t");
                sb.append(signatureAndHashAlgorithm);
                sb.append(StringUtil.lineSeparator());
            }
        }
        if (!this.certificateAuthorities.isEmpty()) {
            sb.append("\t\tCertificate authorities:");
            sb.append(StringUtil.lineSeparator());
            for (X500Principal x500Principal : this.certificateAuthorities) {
                sb.append("\t\t\t");
                sb.append(x500Principal.getName());
                sb.append(StringUtil.lineSeparator());
            }
        }
        return sb.toString();
    }

    public SignatureAndHashAlgorithm getSignatureAndHashAlgorithm(PublicKey publicKey) {
        if (isSupportedKeyType(publicKey)) {
            return SignatureAndHashAlgorithm.getSupportedSignatureAlgorithm(this.supportedSignatureAlgorithms, publicKey);
        }
        return null;
    }

    public CertificateRequest(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.certificateTypes = new ArrayList();
        this.supportedSignatureAlgorithms = new ArrayList();
        this.certificateAuthorities = new ArrayList();
        this.certificateAuthoritiesEncodedLength = 0;
    }

    public boolean isSupportedKeyType(PublicKey publicKey) {
        String algorithm = publicKey.getAlgorithm();
        Iterator<ClientCertificateType> it = this.certificateTypes.iterator();
        while (it.hasNext()) {
            if (it.next().isCompatibleWithKeyAlgorithm(algorithm)) {
                return true;
            }
        }
        return false;
    }
}
