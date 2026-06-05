package org.eclipse.californium.scandium.dtls;

import com.google.android.gms.internal.ads.zzbuy$$ExternalSyntheticBUOutline0;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.SecretKey;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.cipher.AeadBlockCipher;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.util.SecretIvParameterSpec;
import org.eclipse.californium.scandium.util.SecretUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class DtlsAeadConnectionState extends DTLSConnectionState {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) DtlsAeadConnectionState.class);
    private final SecretKey encryptionKey;
    private final SecretIvParameterSpec iv;

    public DtlsAeadConnectionState(CipherSuite cipherSuite, CompressionMethod compressionMethod, SecretKey secretKey, SecretIvParameterSpec secretIvParameterSpec) {
        super(cipherSuite, compressionMethod);
        if (secretKey == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Encryption key must not be null!");
            throw null;
        }
        if (secretIvParameterSpec == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("IV must not be null!");
            throw null;
        }
        this.encryptionKey = SecretUtil.create(secretKey);
        this.iv = SecretUtil.createIv(secretIvParameterSpec);
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSConnectionState
    public byte[] decrypt(Record record, byte[] bArr) throws GeneralSecurityException {
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Ciphertext must not be null");
            return null;
        }
        if (bArr.length < getMacLength() + getRecordIvLength()) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Ciphertext too short!");
            return null;
        }
        int length = (bArr.length - this.cipherSuite.getRecordIvLength()) - this.cipherSuite.getMacLength();
        byte[] bArrGenerateAdditionalData = record.generateAdditionalData(length);
        byte[] iv = this.iv.getIV(bArr, 0, this.cipherSuite.getRecordIvLength());
        Logger logger = LOGGER;
        if (logger.isTraceEnabled()) {
            logger.trace("decrypt: {} bytes", Integer.valueOf(length));
            logger.trace("nonce: {}", StringUtil.byteArray2HexString(iv));
            logger.trace("adata: {}", StringUtil.byteArray2HexString(bArrGenerateAdditionalData));
        }
        if (logger.isDebugEnabled() && "AES/CCM".equals(this.cipherSuite.getTransformation())) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, this.cipherSuite.getRecordIvLength());
            byte[] bArrGenerateExplicitNonce = record.generateExplicitNonce();
            if (!Arrays.equals(bArrGenerateExplicitNonce, bArrCopyOf)) {
                logger.debug("The explicit nonce used by the sender does not match the values provided in the DTLS record" + StringUtil.lineSeparator() + "Used    : " + StringUtil.byteArray2HexString(bArrCopyOf) + StringUtil.lineSeparator() + "Expected: " + StringUtil.byteArray2HexString(bArrGenerateExplicitNonce));
            }
        }
        CipherSuite cipherSuite = this.cipherSuite;
        byte[] bArrDecrypt = AeadBlockCipher.decrypt(cipherSuite, this.encryptionKey, iv, bArrGenerateAdditionalData, bArr, cipherSuite.getRecordIvLength(), bArr.length - this.cipherSuite.getRecordIvLength());
        Bytes.clear(iv);
        return bArrDecrypt;
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        SecretUtil.destroy(this.encryptionKey);
        SecretUtil.destroy(this.iv);
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSConnectionState
    public byte[] encrypt(Record record, byte[] bArr) {
        byte[] bArrGenerateExplicitNonce = record.generateExplicitNonce();
        byte[] iv = this.iv.getIV(bArrGenerateExplicitNonce);
        byte[] bArrGenerateAdditionalData = record.generateAdditionalData(bArr.length);
        Logger logger = LOGGER;
        if (logger.isTraceEnabled()) {
            logger.trace("encrypt: {} bytes", Integer.valueOf(bArr.length));
            logger.trace("nonce: {}", StringUtil.byteArray2HexString(iv));
            logger.trace("adata: {}", StringUtil.byteArray2HexString(bArrGenerateAdditionalData));
        }
        byte[] bArrEncrypt = AeadBlockCipher.encrypt(bArrGenerateExplicitNonce.length, this.cipherSuite, this.encryptionKey, iv, bArrGenerateAdditionalData, bArr);
        Bytes.clear(iv);
        System.arraycopy(bArrGenerateExplicitNonce, 0, bArrEncrypt, 0, bArrGenerateExplicitNonce.length);
        logger.trace("==> {} bytes", Integer.valueOf(bArrEncrypt.length));
        return bArrEncrypt;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return SecretUtil.isDestroyed(this.iv) && SecretUtil.isDestroyed(this.encryptionKey);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DtlsAeadConnectionState:");
        sb.append(StringUtil.lineSeparator());
        sb.append("\tCipher suite: ");
        sb.append(this.cipherSuite);
        sb.append(StringUtil.lineSeparator());
        sb.append("\tCompression method: ");
        sb.append(this.compressionMethod);
        sb.append(StringUtil.lineSeparator());
        sb.append("\tIV: ");
        sb.append(this.iv == null ? "null" : "not null");
        sb.append(StringUtil.lineSeparator());
        sb.append("\tEncryption key: ");
        sb.append(this.encryptionKey == null ? "null" : "not null");
        return sb.toString();
    }
}
