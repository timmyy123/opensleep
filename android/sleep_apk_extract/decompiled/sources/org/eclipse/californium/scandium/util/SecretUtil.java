package org.eclipse.californium.scandium.util;

import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SecretUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) SecretUtil.class);

    public static SecretKey create(SecretKey secretKey) {
        if (secretKey == null) {
            return null;
        }
        byte[] encoded = secretKey.getEncoded();
        DestroyableSecretKeySpec destroyableSecretKeySpec = new DestroyableSecretKeySpec(encoded, secretKey.getAlgorithm());
        Bytes.clear(encoded);
        return destroyableSecretKeySpec;
    }

    public static SecretIvParameterSpec createIv(SecretIvParameterSpec secretIvParameterSpec) {
        if (secretIvParameterSpec == null) {
            return null;
        }
        byte[] iv = secretIvParameterSpec.getIV();
        SecretIvParameterSpec secretIvParameterSpec2 = new SecretIvParameterSpec(iv, 0, iv.length);
        Bytes.clear(iv);
        return secretIvParameterSpec2;
    }

    public static void destroy(Destroyable destroyable) {
        if (destroyable != null) {
            try {
                destroyable.destroy();
            } catch (DestroyFailedException e) {
                LOGGER.warn("Destroy on {} failed!", destroyable.getClass(), e);
            }
        }
    }

    public static boolean isDestroyed(Destroyable destroyable) {
        return destroyable == null || destroyable.isDestroyed();
    }

    public static boolean isDestroyed(SecretKey secretKey) {
        if (secretKey != null) {
            return secretKey.isDestroyed();
        }
        return true;
    }

    public static SecretIvParameterSpec createIv(byte[] bArr, int i, int i2) {
        return new SecretIvParameterSpec(bArr, i, i2);
    }

    public static void destroy(SecretKey secretKey) {
        if (secretKey != null) {
            destroy((Destroyable) secretKey);
        }
    }

    public static SecretKey create(byte[] bArr, int i, int i2, String str) {
        return new DestroyableSecretKeySpec(bArr, i, i2, str);
    }

    public static SecretKey create(byte[] bArr, String str) {
        return new DestroyableSecretKeySpec(bArr, str);
    }

    public static class DestroyableSecretKeySpec implements KeySpec, SecretKey, Destroyable {
        private static final long serialVersionUID = 6578238307397289933L;
        private final String algorithm;
        private volatile boolean destroyed;
        private final int hashCode;
        private final byte[] key;

        private DestroyableSecretKeySpec(byte[] bArr, int i, int i2, String str) {
            if (bArr == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("Key missing");
                throw null;
            }
            if (str == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("Algorithm missing");
                throw null;
            }
            if (bArr.length == 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Empty key");
                throw null;
            }
            if (bArr.length - i < i2) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid offset/length combination");
                throw null;
            }
            if (i2 < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$1("len is negative");
                throw null;
            }
            this.key = Arrays.copyOfRange(bArr, i, i2 + i);
            this.algorithm = str;
            this.hashCode = calcHashCode();
        }

        private int calcHashCode() {
            return this.hashCode;
        }

        @Override // javax.security.auth.Destroyable
        public void destroy() {
            Bytes.clear(this.key);
            this.destroyed = true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SecretKey)) {
                return false;
            }
            SecretKey secretKey = (SecretKey) obj;
            if (!this.algorithm.equalsIgnoreCase(secretKey.getAlgorithm())) {
                return false;
            }
            if (this.destroyed) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("secret destroyed!");
                return false;
            }
            byte[] encoded = secretKey.getEncoded();
            boolean zIsEqual = MessageDigest.isEqual(this.key, encoded);
            Bytes.clear(encoded);
            return zIsEqual;
        }

        @Override // java.security.Key
        public String getAlgorithm() {
            return this.algorithm;
        }

        @Override // java.security.Key
        public byte[] getEncoded() {
            if (!this.destroyed) {
                return (byte[]) this.key.clone();
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("secret destroyed!");
            return null;
        }

        @Override // java.security.Key
        public String getFormat() {
            return "RAW";
        }

        public int hashCode() {
            return this.hashCode;
        }

        @Override // javax.security.auth.Destroyable
        public boolean isDestroyed() {
            return this.destroyed;
        }

        private DestroyableSecretKeySpec(byte[] bArr, String str) {
            this(bArr, 0, bArr == null ? 0 : bArr.length, str);
        }
    }
}
