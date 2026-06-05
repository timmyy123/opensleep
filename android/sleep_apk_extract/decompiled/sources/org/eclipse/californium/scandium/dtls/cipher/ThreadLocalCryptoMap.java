package org.eclipse.californium.scandium.dtls.cipher;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes5.dex */
public class ThreadLocalCryptoMap<TL extends ThreadLocalCrypto<?>> {
    private final ConcurrentMap<String, TL> FUNCTIONS = new ConcurrentHashMap();
    private final Factory<TL> factory;

    public interface Factory<T> {
        T getInstance(String str);
    }

    public ThreadLocalCryptoMap(Factory<TL> factory) {
        this.factory = factory;
    }

    public TL get(String str) {
        TL tl = this.FUNCTIONS.get(str);
        if (tl != null) {
            return tl;
        }
        TL factory = this.factory.getInstance(str);
        TL tlPutIfAbsent = this.FUNCTIONS.putIfAbsent(str, factory);
        return tlPutIfAbsent == null ? factory : tlPutIfAbsent;
    }
}
