package org.eclipse.californium.scandium.dtls.x509;

import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.eclipse.californium.scandium.dtls.CertificateMessage;
import org.eclipse.californium.scandium.dtls.CertificateType;
import org.eclipse.californium.scandium.dtls.CertificateVerificationResult;
import org.eclipse.californium.scandium.dtls.ConnectionId;
import org.eclipse.californium.scandium.dtls.DTLSSession;
import org.eclipse.californium.scandium.dtls.HandshakeResultHandler;
import org.eclipse.californium.scandium.util.ServerNames;

/* JADX INFO: loaded from: classes5.dex */
public interface NewAdvancedCertificateVerifier {
    List<X500Principal> getAcceptedIssuers();

    List<CertificateType> getSupportedCertificateType();

    void setResultHandler(HandshakeResultHandler handshakeResultHandler);

    CertificateVerificationResult verifyCertificate(ConnectionId connectionId, ServerNames serverNames, Boolean bool, boolean z, CertificateMessage certificateMessage, DTLSSession dTLSSession);
}
