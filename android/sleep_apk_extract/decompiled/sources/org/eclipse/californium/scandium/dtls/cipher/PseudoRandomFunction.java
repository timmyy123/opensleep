package org.eclipse.californium.scandium.dtls.cipher;

import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StandardCharsets;
import org.eclipse.californium.scandium.util.SecretUtil;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PseudoRandomFunction {

    public enum Label {
        MASTER_SECRET_LABEL("master secret", 48),
        KEY_EXPANSION_LABEL("key expansion", 128),
        CLIENT_FINISHED_LABEL("client finished", 12),
        SERVER_FINISHED_LABEL("server finished", 12);

        private final byte[] bytesValue;
        private final int length;
        private final String value;

        Label(String str, int i) {
            this.value = str;
            this.bytesValue = str.getBytes(StandardCharsets.UTF_8);
            this.length = i;
        }

        public byte[] getBytes() {
            return this.bytesValue;
        }

        public int length() {
            return this.length;
        }
    }

    public static final byte[] doExpansion(Mac mac, byte[] bArr, byte[] bArr2, int i) {
        int macLength = mac.getMacLength();
        byte[] bArr3 = new byte[bArr.length + macLength + bArr2.length];
        byte[] bArr4 = new byte[i];
        try {
            System.arraycopy(bArr, 0, bArr3, macLength, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length + macLength, bArr2.length);
            mac.update(bArr);
            mac.update(bArr2);
            int i2 = 0;
            while (true) {
                mac.doFinal(bArr3, 0);
                mac.update(bArr3);
                int i3 = i2 + macLength;
                if (i3 > i) {
                    mac.doFinal(bArr3, 0);
                    System.arraycopy(bArr3, 0, bArr4, i2, i - i2);
                    return bArr4;
                }
                mac.doFinal(bArr4, i2);
                if (i3 == i) {
                    return bArr4;
                }
                mac.update(bArr3, 0, macLength);
                i2 = i3;
            }
        } catch (ShortBufferException e) {
            e.printStackTrace();
            return bArr4;
        }
    }

    public static byte[] doPRF(Mac mac, SecretKey secretKey, byte[] bArr, byte[] bArr2, int i) {
        try {
            mac.init(secretKey);
            byte[] bArrDoExpansion = doExpansion(mac, bArr, bArr2, i);
            mac.reset();
            return bArrDoExpansion;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException("Cannot run Pseudo Random Function with invalid key", e);
        }
    }

    public static SecretKey generateMasterSecret(Mac mac, SecretKey secretKey, byte[] bArr) {
        byte[] bArrDoPRF = doPRF(mac, secretKey, Label.MASTER_SECRET_LABEL, bArr);
        SecretKey secretKeyCreate = SecretUtil.create(bArrDoPRF, "MAC");
        Bytes.clear(bArrDoPRF);
        return secretKeyCreate;
    }

    public static SecretKey generatePremasterSecretFromPSK(SecretKey secretKey, SecretKey secretKey2) {
        byte[] encoded = secretKey2.getEncoded();
        int length = encoded.length;
        byte[] encoded2 = secretKey != null ? secretKey.getEncoded() : new byte[length];
        DatagramWriter datagramWriter = new DatagramWriter(true);
        datagramWriter.write(encoded2.length, 16);
        datagramWriter.writeBytes(encoded2);
        datagramWriter.write(length, 16);
        datagramWriter.writeBytes(encoded);
        byte[] byteArray = datagramWriter.toByteArray();
        datagramWriter.close();
        SecretKey secretKeyCreate = SecretUtil.create(byteArray, "MAC");
        Bytes.clear(encoded);
        Bytes.clear(encoded2);
        Bytes.clear(byteArray);
        return secretKeyCreate;
    }

    public static final byte[] doPRF(Mac mac, SecretKey secretKey, Label label, byte[] bArr) {
        return doPRF(mac, secretKey, label.getBytes(), bArr, label.length());
    }

    public static final byte[] doPRF(Mac mac, SecretKey secretKey, Label label, byte[] bArr, int i) {
        return doPRF(mac, secretKey, label.getBytes(), bArr, i);
    }
}
