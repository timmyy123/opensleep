package org.eclipse.californium.scandium;

import java.net.InetSocketAddress;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.eclipse.californium.elements.util.ClockUtil;
import org.eclipse.californium.scandium.dtls.ClientHello;
import org.eclipse.californium.scandium.dtls.CompressionMethod;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.util.SecretUtil;

/* JADX INFO: loaded from: classes5.dex */
public class CookieGenerator {
    public static final long COOKIE_LIFE_TIME = 300000000000L;
    private SecretKey currentSecretKey;
    private long nextKeyGenerationNanos;
    private SecretKey pastSecretKey;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final SecureRandom randomGenerator = new SecureRandom();
    private final byte[] randomBytes = new byte[32];

    private byte[] generateCookie(ClientHello clientHello, SecretKey secretKey) throws InvalidKeyException {
        Mac threadLocalMac = CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256.getThreadLocalMac();
        threadLocalMac.init(secretKey);
        InetSocketAddress peer = clientHello.getPeer();
        threadLocalMac.update(peer.getAddress().getAddress());
        int port = peer.getPort();
        threadLocalMac.update((byte) (port >>> 8));
        threadLocalMac.update((byte) port);
        threadLocalMac.update((byte) clientHello.getClientVersion().getMajor());
        threadLocalMac.update((byte) clientHello.getClientVersion().getMinor());
        threadLocalMac.update(clientHello.getRandom().getBytes());
        threadLocalMac.update(clientHello.getSessionId().getBytes());
        threadLocalMac.update(CipherSuite.listToByteArray(clientHello.getCipherSuites()));
        threadLocalMac.update(CompressionMethod.listToByteArray(clientHello.getCompressionMethods()));
        return threadLocalMac.doFinal();
    }

    private SecretKey getPastSecretKey() {
        this.lock.readLock().lock();
        try {
            return this.pastSecretKey;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    private SecretKey getSecretKey() {
        this.lock.readLock().lock();
        long jNanoRealtime = ClockUtil.nanoRealtime();
        try {
            SecretKey secretKey = this.currentSecretKey;
            if (secretKey != null) {
                if (jNanoRealtime - this.nextKeyGenerationNanos < 0) {
                    return secretKey;
                }
            }
            this.lock.readLock().unlock();
            this.lock.writeLock().lock();
            try {
                SecretKey secretKey2 = this.currentSecretKey;
                if (secretKey2 != null && jNanoRealtime - this.nextKeyGenerationNanos < 0) {
                    return secretKey2;
                }
                this.randomGenerator.nextBytes(this.randomBytes);
                this.nextKeyGenerationNanos = jNanoRealtime + COOKIE_LIFE_TIME;
                this.pastSecretKey = this.currentSecretKey;
                SecretKey secretKeyCreate = SecretUtil.create(this.randomBytes, "MAC");
                this.currentSecretKey = secretKeyCreate;
                return secretKeyCreate;
            } finally {
                this.lock.writeLock().unlock();
            }
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public byte[] generatePastCookie(ClientHello clientHello) {
        SecretKey pastSecretKey = getPastSecretKey();
        if (pastSecretKey != null) {
            return generateCookie(clientHello, pastSecretKey);
        }
        return null;
    }

    public byte[] generateCookie(ClientHello clientHello) {
        return generateCookie(clientHello, getSecretKey());
    }
}
