package kotlinx.io;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0007\u001a\u00020\u0006*\u00060\u0004j\u0002`\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ljava/io/InputStream;", "Lkotlinx/io/RawSource;", "asSource", "(Ljava/io/InputStream;)Lkotlinx/io/RawSource;", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "", "isAndroidGetsocknameError", "(Ljava/lang/AssertionError;)Z", "kotlinx-io-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class JvmCoreKt {
    public static final RawSource asSource(InputStream inputStream) {
        inputStream.getClass();
        return new InputStreamSource(inputStream);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        assertionError.getClass();
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? StringsKt.contains$default(message, "getsockname failed") : false) {
                return true;
            }
        }
        return false;
    }
}
