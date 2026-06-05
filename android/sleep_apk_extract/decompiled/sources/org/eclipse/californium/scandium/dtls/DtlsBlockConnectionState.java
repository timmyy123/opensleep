package org.eclipse.californium.scandium.dtls;

import com.google.android.gms.internal.ads.zzbuy$$ExternalSyntheticBUOutline0;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.cipher.CbcBlockCipher;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.util.SecretUtil;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class DtlsBlockConnectionState extends DTLSConnectionState {
    private final SecretKey encryptionKey;
    private final SecretKey macKey;

    public DtlsBlockConnectionState(CipherSuite cipherSuite, CompressionMethod compressionMethod, SecretKey secretKey, SecretKey secretKey2) {
        super(cipherSuite, compressionMethod);
        if (secretKey == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Encryption key must not be null!");
            throw null;
        }
        if (secretKey2 == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("MAC key must not be null!");
            throw null;
        }
        this.encryptionKey = SecretUtil.create(secretKey);
        this.macKey = SecretUtil.create(secretKey2);
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSConnectionState
    public byte[] decrypt(Record record, byte[] bArr) throws GeneralSecurityException {
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Ciphertext must not be null");
            return null;
        }
        if (bArr.length % getRecordIvLength() != 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Ciphertext doesn't fit block size!");
            return null;
        }
        if (bArr.length >= getMacLength() + getRecordIvLength() + 1) {
            return CbcBlockCipher.decrypt(this.cipherSuite, this.encryptionKey, this.macKey, record.generateAdditionalData(0), bArr);
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Ciphertext too short!");
        return null;
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        SecretUtil.destroy(this.encryptionKey);
        SecretUtil.destroy(this.macKey);
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSConnectionState
    public byte[] encrypt(Record record, byte[] bArr) {
        return CbcBlockCipher.encrypt(this.cipherSuite, this.encryptionKey, this.macKey, record.generateAdditionalData(bArr.length), bArr);
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return SecretUtil.isDestroyed(this.macKey) && SecretUtil.isDestroyed(this.encryptionKey);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DtlsBlockConnectionState:");
        sb.append(StringUtil.lineSeparator());
        sb.append("\tCipher suite: ");
        sb.append(this.cipherSuite);
        sb.append(StringUtil.lineSeparator());
        sb.append("\tCompression method: ");
        sb.append(this.compressionMethod);
        sb.append(StringUtil.lineSeparator());
        sb.append("\tMAC key: ");
        sb.append(this.macKey == null ? "null" : "not null");
        sb.append(StringUtil.lineSeparator());
        sb.append("\tEncryption key: ");
        sb.append(this.encryptionKey == null ? "null" : "not null");
        return sb.toString();
    }
}
