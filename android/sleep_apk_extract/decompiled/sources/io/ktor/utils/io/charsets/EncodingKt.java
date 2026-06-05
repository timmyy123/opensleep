package io.ktor.utils.io.charsets;

import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\b\u001a\u00020\u0007*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\u000e\u001a\u00020\r*\u00060\nj\u0002`\u000b2\u0006\u0010\u0003\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000f\u001a7\u0010\u0013\u001a\u00020\u0012*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "", "input", "", "fromIndex", "toIndex", "Lkotlinx/io/Source;", "encode", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;II)Lkotlinx/io/Source;", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "max", "", "decode", "(Ljava/nio/charset/CharsetDecoder;Lkotlinx/io/Source;I)Ljava/lang/String;", "Lkotlinx/io/Sink;", ShareConstants.DESTINATION, "", "encodeToImpl", "(Ljava/nio/charset/CharsetEncoder;Lkotlinx/io/Sink;Ljava/lang/CharSequence;II)V", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class EncodingKt {
    public static final String decode(CharsetDecoder charsetDecoder, Source source, int i) throws IOException {
        charsetDecoder.getClass();
        source.getClass();
        StringBuilder sb = new StringBuilder((int) Math.min(i, source.getBufferField().getSizeMut()));
        CharsetJVMKt.decode(charsetDecoder, source, sb, i);
        return sb.toString();
    }

    public static /* synthetic */ String decode$default(CharsetDecoder charsetDecoder, Source source, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return decode(charsetDecoder, source, i);
    }

    public static final Source encode(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        charsetEncoder.getClass();
        charSequence.getClass();
        Buffer buffer = new Buffer();
        encodeToImpl(charsetEncoder, buffer, charSequence, i, i2);
        return buffer;
    }

    public static /* synthetic */ Source encode$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encode(charsetEncoder, charSequence, i, i2);
    }

    public static final void encodeToImpl(CharsetEncoder charsetEncoder, Sink sink, CharSequence charSequence, int i, int i2) {
        charsetEncoder.getClass();
        sink.getClass();
        charSequence.getClass();
        if (i >= i2) {
            return;
        }
        do {
            int iEncodeImpl = CharsetJVMKt.encodeImpl(charsetEncoder, charSequence, i, i2, sink);
            if (iEncodeImpl < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Check failed.");
                return;
            }
            i += iEncodeImpl;
        } while (i < i2);
    }
}
