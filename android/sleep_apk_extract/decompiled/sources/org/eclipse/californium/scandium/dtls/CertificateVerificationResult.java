package org.eclipse.californium.scandium.dtls;

import java.security.PublicKey;
import java.security.cert.CertPath;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class CertificateVerificationResult extends HandshakeResult {
    private final CertPath certificatePath;
    private final HandshakeException exception;
    private final PublicKey publicKey;

    public CertificateVerificationResult(ConnectionId connectionId, HandshakeException handshakeException, Object obj) {
        super(connectionId, obj);
        if (handshakeException == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("exception must not be null!");
            throw null;
        }
        this.certificatePath = null;
        this.publicKey = null;
        this.exception = handshakeException;
    }

    public CertPath getCertificatePath() {
        return this.certificatePath;
    }

    public HandshakeException getException() {
        return this.exception;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public CertificateVerificationResult(ConnectionId connectionId, CertPath certPath, Object obj) {
        super(connectionId, obj);
        this.certificatePath = certPath;
        this.publicKey = null;
        this.exception = null;
    }
}
