package io.ktor.http;

import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "ch", "", "isDelimiter", "(C)Z", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class HttpHeadersKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDelimiter(char c) {
        return StringsKt__StringsKt.contains$default("\"(),/:;<=>?@[\\]{}", c, false, 2, (Object) null);
    }
}
