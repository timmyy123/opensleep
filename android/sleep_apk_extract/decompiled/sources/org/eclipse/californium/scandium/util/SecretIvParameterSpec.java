package org.eclipse.californium.scandium.util;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.security.auth.Destroyable;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.Bytes;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class SecretIvParameterSpec implements AlgorithmParameterSpec, Destroyable {
    private boolean destroyed;
    private final byte[] iv;

    public SecretIvParameterSpec(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("IV missing");
            throw null;
        }
        if (bArr.length == 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("IV is empty");
            throw null;
        }
        if (i2 < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$1("len is negative");
            throw null;
        }
        if (bArr.length - i >= i2) {
            this.iv = Arrays.copyOfRange(bArr, i, i2 + i);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid offset/length combination");
            throw null;
        }
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        Bytes.clear(this.iv);
        this.destroyed = true;
    }

    public byte[] getIV(byte[] bArr, int i, int i2) {
        if (this.destroyed) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("secret destroyed!");
            return null;
        }
        if (bArr == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("explicit nonce missing");
            return null;
        }
        if (bArr.length == 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("IV key");
            return null;
        }
        if (i2 < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$1("len is negative");
            return null;
        }
        if (bArr.length - i < i2) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid offset/length combination");
            return null;
        }
        byte[] bArr2 = this.iv;
        byte[] bArrCopyOf = Arrays.copyOf(bArr2, bArr2.length + i2);
        System.arraycopy(bArr, i, bArrCopyOf, this.iv.length, i2);
        return bArrCopyOf;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.destroyed;
    }

    public byte[] getIV(byte[] bArr) {
        return getIV(bArr, 0, bArr.length);
    }

    public byte[] getIV() {
        if (!this.destroyed) {
            byte[] bArr = this.iv;
            return Arrays.copyOf(bArr, bArr.length);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("secret destroyed!");
        return null;
    }
}
