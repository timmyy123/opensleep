package org.eclipse.californium.scandium.dtls.cipher;

import java.security.cert.CertificateFactory;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes5.dex */
public class ThreadLocalCertificateFactory extends ThreadLocalCrypto<CertificateFactory> {
    public ThreadLocalCertificateFactory(final String str) {
        super(new ThreadLocalCrypto.Factory<CertificateFactory>() { // from class: org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCertificateFactory.1
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            public CertificateFactory getInstance() {
                return CertificateFactory.getInstance(str);
            }
        });
    }
}
