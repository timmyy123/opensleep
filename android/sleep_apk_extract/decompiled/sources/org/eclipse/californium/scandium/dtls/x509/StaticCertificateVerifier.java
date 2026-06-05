package org.eclipse.californium.scandium.dtls.x509;

import java.security.GeneralSecurityException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.eclipse.californium.elements.util.CertPathUtil;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.CertificateMessage;
import org.eclipse.californium.scandium.dtls.DTLSSession;
import org.eclipse.californium.scandium.dtls.HandshakeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class StaticCertificateVerifier implements AdvancedCertificateVerifier {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) StaticCertificateVerifier.class);
    private final X509Certificate[] rootCertificates;

    public StaticCertificateVerifier(X509Certificate[] x509CertificateArr) {
        if (x509CertificateArr != null) {
            this.rootCertificates = x509CertificateArr;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("root certificates must not be null!");
            throw null;
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.x509.CertificateVerifier
    public X509Certificate[] getAcceptedIssuers() {
        return this.rootCertificates;
    }

    @Override // org.eclipse.californium.scandium.dtls.x509.AdvancedCertificateVerifier
    public CertPath verifyCertificate(Boolean bool, boolean z, CertificateMessage certificateMessage, DTLSSession dTLSSession) throws HandshakeException {
        try {
            CertPath certificateChain = certificateMessage.getCertificateChain();
            if (bool != null && !certificateMessage.isEmpty()) {
                Certificate certificate = certificateChain.getCertificates().get(0);
                if ((certificate instanceof X509Certificate) && !CertPathUtil.canBeUsedForAuthentication((X509Certificate) certificate, bool.booleanValue())) {
                    LOGGER.debug("Certificate validation failed: key usage doesn't match");
                    throw new HandshakeException("Key Usage doesn't match!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.BAD_CERTIFICATE, dTLSSession.getPeer()));
                }
            }
            return CertPathUtil.validateCertificatePathWithIssuer(z, certificateChain, this.rootCertificates);
        } catch (GeneralSecurityException e) {
            Logger logger = LOGGER;
            if (logger.isTraceEnabled()) {
                logger.trace("Certificate validation failed", (Throwable) e);
            } else if (logger.isDebugEnabled()) {
                logger.debug("Certificate validation failed due to {}", e.getMessage());
            }
            throw new HandshakeException("Certificate chain could not be validated", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.BAD_CERTIFICATE, dTLSSession.getPeer()), e);
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.x509.CertificateVerifier
    public void verifyCertificate(CertificateMessage certificateMessage, DTLSSession dTLSSession) throws HandshakeException {
        try {
            CertPathUtil.validateCertificatePathWithIssuer(false, certificateMessage.getCertificateChain(), this.rootCertificates);
        } catch (GeneralSecurityException e) {
            Logger logger = LOGGER;
            if (!logger.isTraceEnabled()) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Certificate validation failed due to {}", e.getMessage());
                }
            } else {
                logger.trace("Certificate validation failed", (Throwable) e);
            }
            throw new HandshakeException("Certificate chain could not be validated", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.BAD_CERTIFICATE, dTLSSession.getPeer()), e);
        }
    }
}
