package org.eclipse.californium.scandium.dtls.x509;

import java.security.cert.X509Certificate;
import org.eclipse.californium.scandium.dtls.CertificateMessage;
import org.eclipse.californium.scandium.dtls.DTLSSession;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface CertificateVerifier {
    X509Certificate[] getAcceptedIssuers();

    void verifyCertificate(CertificateMessage certificateMessage, DTLSSession dTLSSession);
}
