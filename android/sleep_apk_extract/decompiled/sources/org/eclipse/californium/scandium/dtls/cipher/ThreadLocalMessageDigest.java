package org.eclipse.californium.scandium.dtls.cipher;

import java.security.MessageDigest;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes5.dex */
public class ThreadLocalMessageDigest extends ThreadLocalCrypto<MessageDigest> {
    public ThreadLocalMessageDigest(final String str) {
        super(new ThreadLocalCrypto.Factory<MessageDigest>() { // from class: org.eclipse.californium.scandium.dtls.cipher.ThreadLocalMessageDigest.1
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            public MessageDigest getInstance() {
                return MessageDigest.getInstance(str);
            }
        });
    }
}
