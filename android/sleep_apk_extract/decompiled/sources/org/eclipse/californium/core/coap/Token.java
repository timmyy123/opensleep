package org.eclipse.californium.core.coap;

import org.eclipse.californium.elements.util.Bytes;

/* JADX INFO: loaded from: classes5.dex */
public class Token extends Bytes {
    public static final Token EMPTY = new Token(Bytes.EMPTY);

    private Token(byte[] bArr, boolean z) {
        super(bArr, 8, z);
    }

    public static Token fromProvider(byte[] bArr) {
        return new Token(bArr, false);
    }

    public String toString() {
        return "Token=" + getAsString();
    }

    public Token(byte[] bArr) {
        this(bArr, true);
    }
}
