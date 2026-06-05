package org.eclipse.californium.scandium.dtls.cipher;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AeadBlockCipher {
    public static final byte[] decrypt(CipherSuite cipherSuite, SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return "AES/CCM".equals(cipherSuite.getTransformation()) ? CCMBlockCipher.decrypt(secretKey, bArr, bArr2, bArr3, i, i2, cipherSuite.getMacLength()) : jreDecrypt(cipherSuite, secretKey, bArr, bArr2, bArr3, i, i2);
    }

    public static final byte[] encrypt(int i, CipherSuite cipherSuite, SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return "AES/CCM".equals(cipherSuite.getTransformation()) ? CCMBlockCipher.encrypt(i, secretKey, bArr, bArr2, bArr3, cipherSuite.getMacLength()) : jreEncrypt(i, cipherSuite, secretKey, bArr, bArr2, bArr3);
    }

    public static final boolean isSupported(String str, int i) {
        try {
            Cipher cipherCurrent = "AES/CCM".equals(str) ? CCMBlockCipher.CIPHER.current() : Cipher.getInstance(str);
            if (cipherCurrent != null) {
                if (i * 8 <= Cipher.getMaxAllowedKeyLength(cipherCurrent.getAlgorithm())) {
                    return true;
                }
            }
        } catch (GeneralSecurityException unused) {
        }
        return false;
    }

    private static final byte[] jreDecrypt(CipherSuite cipherSuite, SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher threadLocalCipher = cipherSuite.getThreadLocalCipher();
        threadLocalCipher.init(2, secretKey, new GCMParameterSpec(cipherSuite.getMacLength() * 8, bArr));
        threadLocalCipher.updateAAD(bArr2);
        return threadLocalCipher.doFinal(bArr3, i, i2);
    }

    private static final byte[] jreEncrypt(int i, CipherSuite cipherSuite, SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException {
        Cipher threadLocalCipher = cipherSuite.getThreadLocalCipher();
        threadLocalCipher.init(1, secretKey, new GCMParameterSpec(cipherSuite.getMacLength() * 8, bArr));
        threadLocalCipher.updateAAD(bArr2);
        byte[] bArr4 = new byte[threadLocalCipher.getOutputSize(bArr3.length) + i];
        threadLocalCipher.doFinal(bArr3, 0, bArr3.length, bArr4, i);
        return bArr4;
    }
}
