package org.eclipse.californium.scandium.dtls.cipher;

import javax.crypto.Mac;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes5.dex */
public class ThreadLocalMac extends ThreadLocalCrypto<Mac> {
    public ThreadLocalMac(final String str) {
        super(new ThreadLocalCrypto.Factory<Mac>() { // from class: org.eclipse.californium.scandium.dtls.cipher.ThreadLocalMac.1
            @Override // org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.Factory
            public Mac getInstance() {
                return Mac.getInstance(str);
            }
        });
    }
}
