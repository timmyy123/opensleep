package io.ktor.util;

import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt;
import kotlin.Metadata;
import kotlinx.io.Buffer;
import kotlinx.io.SourcesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "bytes", "", "hex", "([B)Ljava/lang/String;", "", "size", "generateNonce", "(I)[B", "", "digits", "[C", "NONCE_SIZE_IN_BYTES", "I", "ktor-utils"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "io/ktor/util/CryptoKt")
abstract /* synthetic */ class CryptoKt__CryptoKt {
    private static final char[] digits = CharsetKt.toCharArray("0123456789abcdef");

    public static final byte[] generateNonce(int i) {
        Buffer buffer = new Buffer();
        while (BytePacketBuilderKt.getSize(buffer) < i) {
            StringsKt.writeText$default(buffer, CryptoKt.generateNonce(), 0, 0, null, 14, null);
        }
        return SourcesKt.readByteArray(buffer, i);
    }

    public static final String hex(byte[] bArr) {
        bArr.getClass();
        char[] cArr = new char[bArr.length * 2];
        char[] cArr2 = digits;
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr[i] = cArr2[(b & 255) >> 4];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return kotlin.text.StringsKt.concatToString(cArr);
    }
}
