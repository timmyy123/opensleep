package org.eclipse.californium.scandium.dtls.x509;

import java.security.cert.CertPath;
import org.eclipse.californium.scandium.dtls.CertificateMessage;
import org.eclipse.californium.scandium.dtls.DTLSSession;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface AdvancedCertificateVerifier extends CertificateVerifier {
    CertPath verifyCertificate(Boolean bool, boolean z, CertificateMessage certificateMessage, DTLSSession dTLSSession);
}
