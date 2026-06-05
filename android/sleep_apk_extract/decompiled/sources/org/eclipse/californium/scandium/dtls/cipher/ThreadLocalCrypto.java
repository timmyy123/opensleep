package org.eclipse.californium.scandium.dtls.cipher;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ThreadLocalCrypto<CryptoFunction> {
    private final GeneralSecurityException exception;
    private final Factory<CryptoFunction> factory;
    private final ThreadLocal<CryptoFunction> threadLocalFunction;

    public interface Factory<CryptoFunction> {
        CryptoFunction getInstance();
    }

    public ThreadLocalCrypto(Factory<CryptoFunction> factory) {
        ThreadLocal<CryptoFunction> threadLocal;
        GeneralSecurityException e = null;
        try {
            CryptoFunction factory2 = factory.getInstance();
            if (factory2 != null) {
                try {
                    threadLocal = new ThreadLocal<>();
                    try {
                        threadLocal.set(factory2);
                    } catch (GeneralSecurityException e2) {
                        e = e2;
                    }
                } catch (GeneralSecurityException e3) {
                    e = e3;
                    threadLocal = null;
                }
            } else {
                GeneralSecurityException generalSecurityException = new GeneralSecurityException(factory.getClass().getSimpleName().concat(" not supported!"));
                factory = null;
                threadLocal = null;
                e = generalSecurityException;
            }
        } catch (GeneralSecurityException e4) {
            threadLocal = null;
            e = e4;
            factory = null;
        }
        this.threadLocalFunction = threadLocal;
        this.factory = factory;
        this.exception = e;
    }

    public CryptoFunction current() {
        if (!isSupported()) {
            return null;
        }
        CryptoFunction factory = this.threadLocalFunction.get();
        if (factory != null) {
            return factory;
        }
        try {
            factory = this.factory.getInstance();
            this.threadLocalFunction.set(factory);
            return factory;
        } catch (GeneralSecurityException unused) {
            return factory;
        }
    }

    public CryptoFunction currentWithCause() throws GeneralSecurityException {
        GeneralSecurityException generalSecurityException = this.exception;
        if (generalSecurityException == null) {
            return current();
        }
        throw generalSecurityException;
    }

    public final boolean isSupported() {
        return this.exception == null;
    }
}
