package org.eclipse.californium.scandium.dtls.cipher;

import java.security.KeyPairGenerator;
import org.eclipse.californium.elements.util.Asn1DerDecoder;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes5.dex */
public class ThreadLocalKeyPairGenerator extends ThreadLocalCrypto<KeyPairGenerator> {
    public ThreadLocalKeyPairGenerator(final String str) {
        super(new ThreadLocalCrypto.Factory<KeyPairGenerator>() { // from class: org.eclipse.californium.scandium.dtls.cipher.ThreadLocalKeyPairGenerator.1
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            public KeyPairGenerator getInstance() {
                String str2 = str;
                return KeyPairGenerator.getInstance(Asn1DerDecoder.getEdDsaStandardAlgorithmName(str2, str2));
            }
        });
    }
}
