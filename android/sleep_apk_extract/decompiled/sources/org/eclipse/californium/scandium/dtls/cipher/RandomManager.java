package org.eclipse.californium.scandium.dtls.cipher;

import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RandomManager {
    private static final long START = System.currentTimeMillis();
    private static final ThreadLocal<SecureRandom> threadLocalSecureRandom = new ThreadLocal<SecureRandom>() { // from class: org.eclipse.californium.scandium.dtls.cipher.RandomManager.1
        @Override // java.lang.ThreadLocal
        public SecureRandom initialValue() {
            return new SecureRandom();
        }
    };
    private static final ThreadLocal<Random> threadLocalRandom = new ThreadLocal<Random>() { // from class: org.eclipse.californium.scandium.dtls.cipher.RandomManager.2
        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random(Thread.currentThread().getId() + RandomManager.START);
        }
    };

    public static Random currentRandom() {
        return threadLocalRandom.get();
    }

    public static SecureRandom currentSecureRandom() {
        return threadLocalSecureRandom.get();
    }
}
