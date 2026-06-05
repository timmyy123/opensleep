package org.eclipse.californium.scandium.dtls.cipher;

import javax.crypto.KeyAgreement;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes5.dex */
public class ThreadLocalKeyAgreement extends ThreadLocalCrypto<KeyAgreement> {
    public ThreadLocalKeyAgreement(final String str) {
        super(new ThreadLocalCrypto.Factory<KeyAgreement>() { // from class: org.eclipse.californium.scandium.dtls.cipher.ThreadLocalKeyAgreement.1
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            public KeyAgreement getInstance() {
                return KeyAgreement.getInstance(str);
            }
        });
    }
}
