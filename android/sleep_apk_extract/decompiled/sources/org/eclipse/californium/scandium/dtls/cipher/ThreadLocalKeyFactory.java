package org.eclipse.californium.scandium.dtls.cipher;

import java.security.KeyFactory;
import org.eclipse.californium.elements.util.Asn1DerDecoder;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCryptoMap;

/* JADX INFO: loaded from: classes5.dex */
public class ThreadLocalKeyFactory extends ThreadLocalCrypto<KeyFactory> {
    public static final ThreadLocalCryptoMap<ThreadLocalKeyFactory> KEY_FACTORIES = new ThreadLocalCryptoMap<>(new ThreadLocalCryptoMap.Factory<ThreadLocalKeyFactory>() { // from class: org.eclipse.californium.scandium.dtls.cipher.ThreadLocalKeyFactory.2
        @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCryptoMap.Factory
        public ThreadLocalKeyFactory getInstance(String str) {
            return new ThreadLocalKeyFactory(str);
        }
    });

    public ThreadLocalKeyFactory(final String str) {
        super(new ThreadLocalCrypto.Factory<KeyFactory>() { // from class: org.eclipse.californium.scandium.dtls.cipher.ThreadLocalKeyFactory.1
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            public KeyFactory getInstance() {
                String str2 = str;
                return KeyFactory.getInstance(Asn1DerDecoder.getEdDsaStandardAlgorithmName(str2, str2));
            }
        });
    }
}
