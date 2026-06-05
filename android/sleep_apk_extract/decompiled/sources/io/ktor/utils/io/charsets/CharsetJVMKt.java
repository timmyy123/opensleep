package io.ktor.utils.io.charsets;

import io.ktor.utils.io.core.ByteReadPacketKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.io.ByteStringsKt;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import kotlinx.io.bytestring.ByteStringJvmExtKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a!\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\t\u001a\u00020\b*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n\u001a1\u0010\u0013\u001a\u00020\u0012*\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0015\u001a\u00020\u0012*\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0014\u001a7\u0010\u0018\u001a\u00020\u000f*\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a1\u0010 \u001a\u00020\u000f*\u00060\u001aj\u0002`\u001b2\u0006\u0010\u000e\u001a\u00020\u001c2\n\u0010\u0017\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u001f\u001a\u00020\u000f¢\u0006\u0004\b \u0010!\"\u0019\u0010\u0003\u001a\u00020\u0002*\u00060\u0004j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u001d\u0010&\u001a\u00060\u0004j\u0002`\u0005*\u00060\u001aj\u0002`\u001b8F¢\u0006\u0006\u001a\u0004\b$\u0010%*\n\u0010'\"\u00020\u00042\u00020\u0004*\n\u0010(\"\u00020\u000b2\u00020\u000b*\n\u0010)\"\u00020\u001a2\u00020\u001a*\n\u0010*\"\u00020\u00002\u00020\u0000¨\u0006+"}, d2 = {"Lkotlin/text/Charsets;", "Lio/ktor/utils/io/charsets/Charsets;", "", "name", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "forName", "(Lkotlin/text/Charsets;Ljava/lang/String;)Ljava/nio/charset/Charset;", "", "isSupported", "(Lkotlin/text/Charsets;Ljava/lang/String;)Z", "Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "", "input", "", "fromIndex", "toIndex", "", "encodeToByteArray", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;II)[B", "encodeToByteArraySlow", "Lkotlinx/io/Sink;", "dst", "encodeImpl", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;IILkotlinx/io/Sink;)I", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "Lkotlinx/io/Source;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "max", "decode", "(Ljava/nio/charset/CharsetDecoder;Lkotlinx/io/Source;Ljava/lang/Appendable;I)I", "getName", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "getCharset", "(Ljava/nio/charset/CharsetDecoder;)Ljava/nio/charset/Charset;", "charset", "Charset", "CharsetEncoder", "CharsetDecoder", "Charsets", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class CharsetJVMKt {
    public static final int decode(CharsetDecoder charsetDecoder, Source source, Appendable appendable, int i) throws IOException {
        charsetDecoder.getClass();
        source.getClass();
        appendable.getClass();
        if (Intrinsics.areEqual(getCharset(charsetDecoder), Charsets.UTF_8)) {
            String string = Utf8Kt.readString(source);
            appendable.append(string);
            return string.length();
        }
        long remaining = ByteReadPacketKt.getRemaining(source);
        appendable.append(ByteStringJvmExtKt.decodeToString(ByteStringsKt.readByteString(source), getCharset(charsetDecoder)));
        return (int) remaining;
    }

    public static final int encodeImpl(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, Sink sink) {
        charsetEncoder.getClass();
        charSequence.getClass();
        sink.getClass();
        byte[] bArrEncodeToByteArray = encodeToByteArray(charsetEncoder, charSequence, i, i2);
        Sink.write$default(sink, bArrEncodeToByteArray, 0, 0, 6, null);
        return bArrEncodeToByteArray.length;
    }

    public static final byte[] encodeToByteArray(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        charsetEncoder.getClass();
        charSequence.getClass();
        if (!(charSequence instanceof String)) {
            return encodeToByteArraySlow(charsetEncoder, charSequence, i, i2);
        }
        if (i == 0) {
            String str = (String) charSequence;
            if (i2 == str.length()) {
                byte[] bytes = str.getBytes(charsetEncoder.charset());
                bytes.getClass();
                return bytes;
            }
        }
        byte[] bytes2 = ((String) charSequence).substring(i, i2).getBytes(charsetEncoder.charset());
        bytes2.getClass();
        return bytes2;
    }

    private static final byte[] encodeToByteArraySlow(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) throws CharacterCodingException {
        ByteBuffer byteBufferEncode = charsetEncoder.encode(CharBuffer.wrap(charSequence, i, i2));
        byte[] bArr = null;
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            byte[] bArrArray = byteBufferEncode.array();
            if (bArrArray.length == byteBufferEncode.remaining()) {
                bArr = bArrArray;
            }
        }
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr2);
        return bArr2;
    }

    public static final Charset forName(Charsets charsets, String str) {
        charsets.getClass();
        str.getClass();
        Charset charsetForName = Charset.forName(str);
        charsetForName.getClass();
        return charsetForName;
    }

    public static final Charset getCharset(CharsetDecoder charsetDecoder) {
        charsetDecoder.getClass();
        Charset charset = charsetDecoder.charset();
        charset.getClass();
        return charset;
    }

    public static final String getName(Charset charset) {
        charset.getClass();
        String strName = charset.name();
        strName.getClass();
        return strName;
    }

    public static final boolean isSupported(Charsets charsets, String str) {
        charsets.getClass();
        str.getClass();
        return Charset.isSupported(str);
    }
}
