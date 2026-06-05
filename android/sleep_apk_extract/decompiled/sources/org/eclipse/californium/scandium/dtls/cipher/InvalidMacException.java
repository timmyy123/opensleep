package org.eclipse.californium.scandium.dtls.cipher;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import org.eclipse.californium.elements.util.Bytes;

/* JADX INFO: loaded from: classes5.dex */
public class InvalidMacException extends GeneralSecurityException {
    private static final long serialVersionUID = 1;
    private final byte[] actual;
    private final byte[] expected;

    public InvalidMacException(byte[] bArr, byte[] bArr2) {
        super("MAC validation failed");
        this.expected = Arrays.copyOf(bArr, bArr.length);
        this.actual = Arrays.copyOf(bArr2, bArr2.length);
    }

    public InvalidMacException(String str) {
        super(str);
        byte[] bArr = Bytes.EMPTY;
        this.expected = bArr;
        this.actual = bArr;
    }

    public InvalidMacException() {
        this("MAC validation failed");
    }
}
