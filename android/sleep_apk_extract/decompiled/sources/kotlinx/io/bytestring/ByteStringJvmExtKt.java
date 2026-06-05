package kotlinx.io.bytestring;

import java.nio.charset.Charset;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/io/bytestring/ByteString;", "Ljava/nio/charset/Charset;", "charset", "", "decodeToString", "(Lkotlinx/io/bytestring/ByteString;Ljava/nio/charset/Charset;)Ljava/lang/String;", "kotlinx-io-bytestring"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ByteStringJvmExtKt {
    public static final String decodeToString(ByteString byteString, Charset charset) {
        byteString.getClass();
        charset.getClass();
        return new String(byteString.getData(), charset);
    }
}
