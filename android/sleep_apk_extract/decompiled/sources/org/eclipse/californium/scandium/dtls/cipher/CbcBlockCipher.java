package org.eclipse.californium.scandium.dtls.cipher;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.DatagramWriter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CbcBlockCipher {
    private static final byte[] FILLUP = Bytes.createBytes(new SecureRandom(), 256);

    public static boolean checkPadding(int i, byte[] bArr, int i2) {
        if (bArr.length < i2 + 257) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("data must contain 257 bytes from offset on!");
            return false;
        }
        byte b = (byte) i;
        byte b2 = 0;
        for (int i3 = 0; i3 <= i; i3++) {
            b2 = (byte) (b2 | (bArr[i2 + i3] ^ b));
        }
        byte b3 = 0;
        for (int i4 = i + 1; i4 < 256; i4++) {
            b3 = (byte) (b3 | (bArr[i2 + i4] ^ b));
        }
        int length = bArr.length - 1;
        bArr[length] = (byte) (bArr[length] ^ b3);
        return b2 == 0;
    }

    public static byte[] decrypt(CipherSuite cipherSuite, SecretKey secretKey, SecretKey secretKey2, byte[] bArr, byte[] bArr2) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidMacException, InvalidAlgorithmParameterException, ShortBufferException {
        byte[] bArr3 = new byte[Math.max(cipherSuite.getMacMessageBlockLength(), 256) + bArr2.length];
        int recordIvLength = cipherSuite.getRecordIvLength();
        Cipher threadLocalCipher = cipherSuite.getThreadLocalCipher();
        int i = 0;
        threadLocalCipher.init(2, secretKey, new IvParameterSpec(bArr2, 0, recordIvLength));
        int iDoFinal = threadLocalCipher.doFinal(bArr2, recordIvLength, bArr2.length - recordIvLength, bArr3);
        System.arraycopy(FILLUP, 0, bArr3, iDoFinal, cipherSuite.getMacMessageBlockLength());
        int macLength = cipherSuite.getMacLength();
        int i2 = bArr3[iDoFinal - 1] & 255;
        int i3 = (iDoFinal - macLength) - 1;
        int i4 = i3 - i2;
        if (i4 < 0) {
            i4 = i3;
            i2 = 0;
        }
        if (checkPadding(i2, bArr3, i4 + macLength)) {
            i = i2;
            i3 = i4;
        }
        int length = bArr.length;
        bArr[length - 2] = (byte) ((i3 >> 8) & PHIpAddressSearchManager.END_IP_SCAN);
        bArr[length - 1] = (byte) (i3 & PHIpAddressSearchManager.END_IP_SCAN);
        MessageDigest threadLocalMacMessageDigest = cipherSuite.getThreadLocalMacMessageDigest();
        threadLocalMacMessageDigest.reset();
        byte[] blockCipherMac = getBlockCipherMac(cipherSuite.getThreadLocalMac(), secretKey2, bArr, bArr3, i3);
        int macMessageLengthBytes = cipherSuite.getMacMessageLengthBytes();
        int macMessageBlockLength = cipherSuite.getMacMessageBlockLength();
        int length2 = bArr.length + i3 + macMessageLengthBytes;
        threadLocalMacMessageDigest.update(bArr3, i3, ((((i + length2) / macMessageBlockLength) - (length2 / macMessageBlockLength)) * macMessageBlockLength) + 1);
        threadLocalMacMessageDigest.reset();
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr3, i3, macLength + i3);
        boolean zIsEqual = MessageDigest.isEqual(bArrCopyOfRange, blockCipherMac);
        Bytes.clear(blockCipherMac);
        Bytes.clear(bArrCopyOfRange);
        byte[] bArrCopyOf = zIsEqual ? Arrays.copyOf(bArr3, i3) : null;
        Bytes.clear(bArr3);
        if (zIsEqual) {
            return bArrCopyOf;
        }
        throw new InvalidMacException();
    }

    public static byte[] encrypt(CipherSuite cipherSuite, SecretKey secretKey, SecretKey secretKey2, byte[] bArr, byte[] bArr2) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, ShortBufferException {
        DatagramWriter datagramWriter = new DatagramWriter(true);
        datagramWriter.writeBytes(bArr2);
        byte[] blockCipherMac = getBlockCipherMac(cipherSuite.getThreadLocalMac(), secretKey2, bArr, bArr2, bArr2.length);
        datagramWriter.writeBytes(blockCipherMac);
        Bytes.clear(blockCipherMac);
        int macLength = cipherSuite.getMacLength() + bArr2.length + 1;
        int recordIvLength = cipherSuite.getRecordIvLength();
        int i = macLength % recordIvLength;
        int i2 = i > 0 ? recordIvLength - i : 0;
        byte[] bArr3 = new byte[i2 + 1];
        Arrays.fill(bArr3, (byte) i2);
        datagramWriter.writeBytes(bArr3);
        Bytes.clear(bArr3);
        Cipher threadLocalCipher = cipherSuite.getThreadLocalCipher();
        threadLocalCipher.init(1, secretKey);
        byte[] iv = threadLocalCipher.getIV();
        byte[] byteArray = datagramWriter.toByteArray();
        datagramWriter.close();
        byte[] bArrCopyOf = Arrays.copyOf(iv, iv.length + byteArray.length);
        threadLocalCipher.doFinal(byteArray, 0, byteArray.length, bArrCopyOf, iv.length);
        return bArrCopyOf;
    }

    public static byte[] getBlockCipherMac(Mac mac, SecretKey secretKey, byte[] bArr, byte[] bArr2, int i) throws InvalidKeyException {
        mac.init(secretKey);
        mac.update(bArr);
        mac.update(bArr2, 0, i);
        byte[] bArrDoFinal = mac.doFinal();
        mac.reset();
        return bArrDoFinal;
    }
}
