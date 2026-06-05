package org.eclipse.californium.scandium.dtls;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import javax.crypto.SecretKey;
import javax.security.auth.Destroyable;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.util.SecretIvParameterSpec;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DTLSConnectionState implements Destroyable {
    public static final DTLSConnectionState NULL = new DTLSConnectionState(CipherSuite.TLS_NULL_WITH_NULL_NULL, CompressionMethod.NULL) { // from class: org.eclipse.californium.scandium.dtls.DTLSConnectionState.1
        @Override // org.eclipse.californium.scandium.dtls.DTLSConnectionState
        public byte[] decrypt(Record record, byte[] bArr) {
            return bArr;
        }

        @Override // javax.security.auth.Destroyable
        public void destroy() {
        }

        @Override // org.eclipse.californium.scandium.dtls.DTLSConnectionState
        public byte[] encrypt(Record record, byte[] bArr) {
            return bArr;
        }

        @Override // javax.security.auth.Destroyable
        public boolean isDestroyed() {
            return false;
        }

        public final String toString() {
            return "DtlsNullConnectionState:" + StringUtil.lineSeparator() + "\tCipher suite: " + this.cipherSuite + StringUtil.lineSeparator() + "\tCompression method: " + this.compressionMethod;
        }
    };
    protected final CipherSuite cipherSuite;
    protected final CompressionMethod compressionMethod;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.dtls.DTLSConnectionState$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$CipherType;

        static {
            int[] iArr = new int[CipherSuite.CipherType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$CipherType = iArr;
            try {
                iArr[CipherSuite.CipherType.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$CipherType[CipherSuite.CipherType.BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$CipherType[CipherSuite.CipherType.AEAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public DTLSConnectionState(CipherSuite cipherSuite, CompressionMethod compressionMethod) {
        if (cipherSuite == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Cipher suite must not be null");
            throw null;
        }
        if (compressionMethod == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Compression method must not be null");
            throw null;
        }
        this.cipherSuite = cipherSuite;
        this.compressionMethod = compressionMethod;
    }

    public static DTLSConnectionState create(CipherSuite cipherSuite, CompressionMethod compressionMethod, SecretKey secretKey, SecretIvParameterSpec secretIvParameterSpec, SecretKey secretKey2) {
        int i = AnonymousClass2.$SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$CipherType[cipherSuite.getCipherType().ordinal()];
        if (i == 1) {
            return NULL;
        }
        if (i == 2) {
            return new DtlsBlockConnectionState(cipherSuite, compressionMethod, secretKey, secretKey2);
        }
        if (i == 3) {
            return new DtlsAeadConnectionState(cipherSuite, compressionMethod, secretKey, secretIvParameterSpec);
        }
        Gson$$ExternalSyntheticBUOutline0.m("cipher type ", cipherSuite.getCipherType(), " not supported!");
        return null;
    }

    public abstract byte[] decrypt(Record record, byte[] bArr);

    public abstract byte[] encrypt(Record record, byte[] bArr);

    public CipherSuite getCipherSuite() {
        return this.cipherSuite;
    }

    public CompressionMethod getCompressionMethod() {
        return this.compressionMethod;
    }

    public int getMacLength() {
        return this.cipherSuite.getMacLength();
    }

    public int getRecordIvLength() {
        return this.cipherSuite.getRecordIvLength();
    }

    public boolean hasValidCipherSuite() {
        return !CipherSuite.TLS_NULL_WITH_NULL_NULL.equals(this.cipherSuite);
    }
}
