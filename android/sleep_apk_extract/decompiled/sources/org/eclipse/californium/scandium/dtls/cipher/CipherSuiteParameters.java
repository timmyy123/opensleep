package org.eclipse.californium.scandium.dtls.cipher;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.List;
import org.eclipse.californium.scandium.dtls.CertificateType;
import org.eclipse.californium.scandium.dtls.SignatureAndHashAlgorithm;
import org.eclipse.californium.scandium.dtls.SupportedPointFormatsExtension;
import org.eclipse.californium.scandium.dtls.cipher.XECDHECryptography;

/* JADX INFO: loaded from: classes5.dex */
public class CipherSuiteParameters {
    private List<X509Certificate> certificateChain;
    private List<CipherSuite> cipherSuites;
    private boolean clientAuthenticationRequired;
    private boolean clientAuthenticationWanted;
    private List<CertificateType> clientCertTypes;
    private SupportedPointFormatsExtension.ECPointFormat format;
    private PublicKey publicKey;
    private SignatureAndHashAlgorithm selectedSignature;
    private List<CertificateType> serverCertTypes;
    private List<SignatureAndHashAlgorithm> signatures;
    private List<XECDHECryptography.SupportedGroup> supportedGroups;

    public CipherSuiteParameters(PublicKey publicKey, List<X509Certificate> list, boolean z, boolean z2, List<CipherSuite> list2, List<CertificateType> list3, List<CertificateType> list4, List<XECDHECryptography.SupportedGroup> list5, List<SignatureAndHashAlgorithm> list6, SupportedPointFormatsExtension.ECPointFormat eCPointFormat) {
        this.publicKey = publicKey;
        this.certificateChain = list;
        this.clientAuthenticationRequired = z;
        this.clientAuthenticationWanted = !z && z2;
        this.cipherSuites = list2;
        this.serverCertTypes = list3;
        this.clientCertTypes = list4;
        this.supportedGroups = list5;
        this.signatures = list6;
        this.format = eCPointFormat;
    }

    public List<X509Certificate> getCertificateChain() {
        return this.certificateChain;
    }

    public List<CipherSuite> getCipherSuites() {
        return this.cipherSuites;
    }

    public List<CertificateType> getClientCertTypes() {
        return this.clientCertTypes;
    }

    public SupportedPointFormatsExtension.ECPointFormat getFormat() {
        return this.format;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public CipherSuite getSelectedCipherSuite() {
        return this.cipherSuites.get(0);
    }

    public CertificateType getSelectedClientCertificateType() {
        if (this.clientCertTypes.isEmpty()) {
            return null;
        }
        return this.clientCertTypes.get(0);
    }

    public CertificateType getSelectedServerCertificateType() {
        if (this.serverCertTypes.isEmpty()) {
            return null;
        }
        return this.serverCertTypes.get(0);
    }

    public SignatureAndHashAlgorithm getSelectedSignature() {
        return this.selectedSignature;
    }

    public XECDHECryptography.SupportedGroup getSelectedSupportedGroup() {
        if (this.supportedGroups.isEmpty()) {
            return null;
        }
        return this.supportedGroups.get(0);
    }

    public List<CertificateType> getServerCertTypes() {
        return this.serverCertTypes;
    }

    public List<SignatureAndHashAlgorithm> getSignatures() {
        return this.signatures;
    }

    public List<XECDHECryptography.SupportedGroup> getSupportedGroups() {
        return this.supportedGroups;
    }

    public boolean isClientAuthenticationRequired() {
        return this.clientAuthenticationRequired;
    }

    public boolean isClientAuthenticationWanted() {
        return this.clientAuthenticationWanted;
    }

    public void select(CipherSuite cipherSuite) {
        this.cipherSuites.clear();
        this.cipherSuites.add(cipherSuite);
    }

    public void selectClientCertificateType(CertificateType certificateType) {
        this.clientCertTypes.clear();
        if (certificateType != null) {
            this.clientCertTypes.add(certificateType);
        }
    }

    public void selectServerCertificateType(CertificateType certificateType) {
        this.serverCertTypes.clear();
        if (certificateType != null) {
            this.serverCertTypes.add(certificateType);
        }
    }

    public void selectSignatureAndHashAlgorithm(SignatureAndHashAlgorithm signatureAndHashAlgorithm) {
        this.selectedSignature = signatureAndHashAlgorithm;
    }
}
