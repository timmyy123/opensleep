package org.eclipse.californium.scandium.dtls.cipher;

import javax.crypto.Cipher;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes5.dex */
public class ThreadLocalCipher extends ThreadLocalCrypto<Cipher> {
    public ThreadLocalCipher(final String str) {
        super(new ThreadLocalCrypto.Factory<Cipher>() { // from class: org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCipher.1
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            public Cipher getInstance() {
                return Cipher.getInstance(str);
            }
        });
    }
}
