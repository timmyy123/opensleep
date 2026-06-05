package io.ktor.utils.io.core;

import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.charsets.EncodingKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\n\u001a\u00020\u0000*\u00020\u00072\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a;\u0010\u0012\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", "", "toByteArray", "(Ljava/lang/String;Ljava/nio/charset/Charset;)[B", "Lkotlinx/io/Source;", "", "max", "readText", "(Lkotlinx/io/Source;Ljava/nio/charset/Charset;I)Ljava/lang/String;", "Lkotlinx/io/Sink;", "", "text", "fromIndex", "toIndex", "", "writeText", "(Lkotlinx/io/Sink;Ljava/lang/CharSequence;IILjava/nio/charset/Charset;)V", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class StringsKt {
    public static final String readText(Source source, Charset charset, int i) {
        source.getClass();
        charset.getClass();
        return Intrinsics.areEqual(charset, Charsets.UTF_8) ? i == Integer.MAX_VALUE ? Utf8Kt.readString(source) : Utf8Kt.readString(source, Math.min(source.getBuffer().getSizeMut(), i)) : EncodingKt.decode(charset.newDecoder(), source, i);
    }

    public static /* synthetic */ String readText$default(Source source, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(source, charset, i);
    }

    public static final byte[] toByteArray(String str, Charset charset) {
        str.getClass();
        charset.getClass();
        return Intrinsics.areEqual(charset, Charsets.UTF_8) ? StringsKt__StringsJVMKt.encodeToByteArray$default(str, 0, 0, true, 3, null) : CharsetJVMKt.encodeToByteArray(charset.newEncoder(), str, 0, str.length());
    }

    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return toByteArray(str, charset);
    }

    public static final void writeText(Sink sink, CharSequence charSequence, int i, int i2, Charset charset) {
        sink.getClass();
        charSequence.getClass();
        charset.getClass();
        if (charset == Charsets.UTF_8) {
            Utf8Kt.writeString(sink, charSequence.toString(), i, i2);
        } else {
            EncodingKt.encodeToImpl(charset.newEncoder(), sink, charSequence, i, i2);
        }
    }

    public static /* synthetic */ void writeText$default(Sink sink, CharSequence charSequence, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(sink, charSequence, i, i2, charset);
    }
}
