package org.eclipse.californium.scandium.dtls.cipher;

import java.security.Provider;
import java.security.Signature;
import org.eclipse.californium.elements.util.Asn1DerDecoder;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCryptoMap;

/* JADX INFO: loaded from: classes5.dex */
public class ThreadLocalSignature extends ThreadLocalCrypto<Signature> {
    public static final ThreadLocalCryptoMap<ThreadLocalSignature> SIGNATURES = new ThreadLocalCryptoMap<>(new ThreadLocalCryptoMap.Factory<ThreadLocalSignature>() { // from class: org.eclipse.californium.scandium.dtls.cipher.ThreadLocalSignature.2
        @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCryptoMap.Factory
        public ThreadLocalSignature getInstance(String str) {
            return new ThreadLocalSignature(str);
        }
    });

    public ThreadLocalSignature(final String str) {
        super(new ThreadLocalCrypto.Factory<Signature>() { // from class: org.eclipse.californium.scandium.dtls.cipher.ThreadLocalSignature.1
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            public Signature getInstance() {
                Provider edDsaProvider;
                String edDsaStandardAlgorithmName = Asn1DerDecoder.getEdDsaStandardAlgorithmName(str, null);
                return (edDsaStandardAlgorithmName == null || (edDsaProvider = Asn1DerDecoder.getEdDsaProvider()) == null) ? Signature.getInstance(str) : Signature.getInstance(edDsaStandardAlgorithmName, edDsaProvider);
            }
        });
    }
}
