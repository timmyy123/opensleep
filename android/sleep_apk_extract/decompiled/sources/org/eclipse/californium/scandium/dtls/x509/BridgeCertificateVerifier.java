package org.eclipse.californium.scandium.dtls.x509;

import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.CertPathUtil;
import org.eclipse.californium.elements.util.SslContextUtil;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.CertificateMessage;
import org.eclipse.californium.scandium.dtls.CertificateType;
import org.eclipse.californium.scandium.dtls.CertificateVerificationResult;
import org.eclipse.californium.scandium.dtls.ConnectionId;
import org.eclipse.californium.scandium.dtls.DTLSSession;
import org.eclipse.californium.scandium.dtls.HandshakeException;
import org.eclipse.californium.scandium.dtls.HandshakeResultHandler;
import org.eclipse.californium.scandium.dtls.rpkstore.TrustedRpkStore;
import org.eclipse.californium.scandium.util.ServerNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class BridgeCertificateVerifier implements NewAdvancedCertificateVerifier {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final List<CertificateType> supportedCertificateTypes;
    private final CertificateVerifier x509verifier;

    public static class Builder {
        protected List<CertificateType> supportedCertificateTypes;
        protected CertificateVerifier x509verifier;

        public NewAdvancedCertificateVerifier build() {
            init();
            return new BridgeCertificateVerifier(this.x509verifier, null, this.supportedCertificateTypes);
        }

        public void init() {
            ArrayList arrayList = new ArrayList();
            if (this.x509verifier != null) {
                arrayList.add(CertificateType.X_509);
            }
            this.supportedCertificateTypes = Collections.unmodifiableList(arrayList);
        }

        public Builder setCertificateVerifier(CertificateVerifier certificateVerifier) {
            this.x509verifier = certificateVerifier;
            return this;
        }

        public Builder setTrustedCertificates(Certificate[] certificateArr) {
            if (certificateArr == null) {
                this.x509verifier = null;
                return this;
            }
            if (certificateArr.length == 0) {
                this.x509verifier = new StaticCertificateVerifier(new X509Certificate[0]);
                return this;
            }
            X509Certificate[] x509CertificateArrAsX509Certificates = SslContextUtil.asX509Certificates(certificateArr);
            SslContextUtil.ensureUniqueCertificates(x509CertificateArrAsX509Certificates);
            this.x509verifier = new StaticCertificateVerifier(x509CertificateArrAsX509Certificates);
            return this;
        }
    }

    public BridgeCertificateVerifier(CertificateVerifier certificateVerifier, TrustedRpkStore trustedRpkStore, List<CertificateType> list) {
        if (certificateVerifier == null && trustedRpkStore == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("no verifier provided!");
            throw null;
        }
        if (list == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("list of supported certificate types must not be null!");
            throw null;
        }
        this.x509verifier = certificateVerifier;
        this.supportedCertificateTypes = list;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // org.eclipse.californium.scandium.dtls.x509.NewAdvancedCertificateVerifier
    public List<X500Principal> getAcceptedIssuers() {
        X509Certificate[] acceptedIssuers = this.x509verifier.getAcceptedIssuers();
        return acceptedIssuers != null ? CertPathUtil.toSubjects(Arrays.asList(acceptedIssuers)) : CertPathUtil.toSubjects(null);
    }

    @Override // org.eclipse.californium.scandium.dtls.x509.NewAdvancedCertificateVerifier
    public List<CertificateType> getSupportedCertificateType() {
        return this.supportedCertificateTypes;
    }

    @Override // org.eclipse.californium.scandium.dtls.x509.NewAdvancedCertificateVerifier
    public void setResultHandler(HandshakeResultHandler handshakeResultHandler) {
    }

    @Override // org.eclipse.californium.scandium.dtls.x509.NewAdvancedCertificateVerifier
    public CertificateVerificationResult verifyCertificate(ConnectionId connectionId, ServerNames serverNames, Boolean bool, boolean z, CertificateMessage certificateMessage, DTLSSession dTLSSession) {
        try {
            CertPath certificateChain = certificateMessage.getCertificateChain();
            if (certificateChain == null) {
                throw new HandshakeException("RPK verification not enabled!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, dTLSSession.getPeer()));
            }
            CertificateVerifier certificateVerifier = this.x509verifier;
            if (certificateVerifier == null) {
                throw new HandshakeException("x509 verification not enabled!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, dTLSSession.getPeer()));
            }
            if (certificateVerifier instanceof AdvancedCertificateVerifier) {
                certificateChain = ((AdvancedCertificateVerifier) certificateVerifier).verifyCertificate(bool, z, certificateMessage, dTLSSession);
            } else {
                if (bool != null && !certificateMessage.isEmpty()) {
                    Certificate certificate = certificateChain.getCertificates().get(0);
                    if ((certificate instanceof X509Certificate) && !CertPathUtil.canBeUsedForAuthentication((X509Certificate) certificate, bool.booleanValue())) {
                        throw new HandshakeException("Key Usage doesn't match!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.BAD_CERTIFICATE, dTLSSession.getPeer()));
                    }
                }
                this.x509verifier.verifyCertificate(certificateMessage, dTLSSession);
            }
            return new CertificateVerificationResult(connectionId, certificateChain, (Object) null);
        } catch (HandshakeException e) {
            this.LOGGER.debug("Certificate validation failed!", (Throwable) e);
            return new CertificateVerificationResult(connectionId, e, (Object) null);
        }
    }
}
