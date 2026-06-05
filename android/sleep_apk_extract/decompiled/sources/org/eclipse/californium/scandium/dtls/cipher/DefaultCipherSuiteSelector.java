package org.eclipse.californium.scandium.dtls.cipher;

import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.scandium.dtls.CertificateType;
import org.eclipse.californium.scandium.dtls.SignatureAndHashAlgorithm;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.dtls.cipher.XECDHECryptography;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultCipherSuiteSelector implements CipherSuiteSelector {
    protected static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) DefaultCipherSuiteSelector.class);

    @Override // org.eclipse.californium.scandium.dtls.cipher.CipherSuiteSelector
    public boolean select(CipherSuiteParameters cipherSuiteParameters) {
        boolean z = false;
        for (CipherSuite cipherSuite : cipherSuiteParameters.getCipherSuites()) {
            if (!cipherSuite.requiresServerCertificateMessage()) {
                if (select(cipherSuite, cipherSuiteParameters)) {
                    return true;
                }
            } else if (z) {
                continue;
            } else {
                if (select(cipherSuite, cipherSuiteParameters)) {
                    return true;
                }
                z = true;
            }
        }
        return false;
    }

    public boolean selectForCertificate(CipherSuiteParameters cipherSuiteParameters, CipherSuite cipherSuite) {
        SignatureAndHashAlgorithm supportedSignatureAlgorithm;
        if (cipherSuiteParameters.getServerCertTypes().isEmpty()) {
            return false;
        }
        boolean z = cipherSuiteParameters.isClientAuthenticationRequired() || cipherSuiteParameters.isClientAuthenticationWanted();
        if ((z && cipherSuiteParameters.getClientCertTypes().isEmpty()) || cipherSuiteParameters.getSignatures().isEmpty()) {
            return false;
        }
        if (cipherSuite.getCertificateKeyAlgorithm() != CipherSuite.CertificateKeyAlgorithm.EC) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Only ECDSA certificate based cipher suites are supported!");
            return false;
        }
        XECDHECryptography.SupportedGroup supportedGroupFromPublicKey = XECDHECryptography.SupportedGroup.fromPublicKey(cipherSuiteParameters.getPublicKey());
        if (supportedGroupFromPublicKey == null || !cipherSuiteParameters.getSupportedGroups().contains(supportedGroupFromPublicKey) || (supportedSignatureAlgorithm = SignatureAndHashAlgorithm.getSupportedSignatureAlgorithm(cipherSuiteParameters.getSignatures(), cipherSuiteParameters.getPublicKey())) == null) {
            return false;
        }
        CertificateType certificateType = cipherSuiteParameters.getServerCertTypes().get(0);
        if (CertificateType.X_509.equals(certificateType)) {
            if (cipherSuiteParameters.getCertificateChain() == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Certificate type x509 requires a certificate chain!");
                return false;
            }
            boolean zIsSignedWithSupportedAlgorithms = SignatureAndHashAlgorithm.isSignedWithSupportedAlgorithms(cipherSuiteParameters.getSignatures(), cipherSuiteParameters.getCertificateChain());
            if (zIsSignedWithSupportedAlgorithms) {
                zIsSignedWithSupportedAlgorithms = XECDHECryptography.SupportedGroup.isSupported(cipherSuiteParameters.getSupportedGroups(), cipherSuiteParameters.getCertificateChain());
            }
            if (!zIsSignedWithSupportedAlgorithms) {
                List<CertificateType> serverCertTypes = cipherSuiteParameters.getServerCertTypes();
                CertificateType certificateType2 = CertificateType.RAW_PUBLIC_KEY;
                if (!serverCertTypes.contains(certificateType2)) {
                    return false;
                }
                certificateType = certificateType2;
            }
        }
        cipherSuiteParameters.select(cipherSuite);
        cipherSuiteParameters.selectServerCertificateType(certificateType);
        cipherSuiteParameters.selectSignatureAndHashAlgorithm(supportedSignatureAlgorithm);
        cipherSuiteParameters.selectClientCertificateType(z ? cipherSuiteParameters.getClientCertTypes().get(0) : null);
        return true;
    }

    public boolean select(CipherSuite cipherSuite, CipherSuiteParameters cipherSuiteParameters) {
        if (cipherSuite.isEccBased() && (cipherSuiteParameters.getSupportedGroups().isEmpty() || cipherSuiteParameters.getFormat() == null)) {
            return false;
        }
        if (cipherSuite.requiresServerCertificateMessage()) {
            return selectForCertificate(cipherSuiteParameters, cipherSuite);
        }
        cipherSuiteParameters.select(cipherSuite);
        return true;
    }
}
