package org.eclipse.californium.scandium.dtls;

import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class HandshakeParameter {
    private final CertificateType certificateType;
    private final CipherSuite.KeyExchangeAlgorithm keyExchange;

    public HandshakeParameter(CipherSuite.KeyExchangeAlgorithm keyExchangeAlgorithm, CertificateType certificateType) {
        if (keyExchangeAlgorithm == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("key exchange must not be null!");
            throw null;
        }
        if (certificateType == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("certificate type must not be null!");
            throw null;
        }
        this.keyExchange = keyExchangeAlgorithm;
        this.certificateType = certificateType;
    }

    public CertificateType getCertificateType() {
        return this.certificateType;
    }

    public CipherSuite.KeyExchangeAlgorithm getKeyExchangeAlgorithm() {
        return this.keyExchange;
    }

    public String toString() {
        return "KeyExgAl=" + this.keyExchange + ", cert.type=" + this.certificateType;
    }
}
