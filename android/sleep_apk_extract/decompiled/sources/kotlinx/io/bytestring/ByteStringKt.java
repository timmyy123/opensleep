package kotlinx.io.bytestring;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/io/bytestring/ByteString;", "", "isEmpty", "(Lkotlinx/io/bytestring/ByteString;)Z", "kotlinx-io-bytestring"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ByteStringKt {
    public static final boolean isEmpty(ByteString byteString) {
        byteString.getClass();
        return byteString.getSize() == 0;
    }
}
