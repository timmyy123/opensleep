package io.ktor.client.plugins.contentnegotiation;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/client/plugins/contentnegotiation/JsonContentTypeMatcher;", "Lio/ktor/http/ContentTypeMatcher;", "<init>", "()V", "Lio/ktor/http/ContentType;", "contentType", "", "contains", "(Lio/ktor/http/ContentType;)Z", "ktor-client-content-negotiation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JsonContentTypeMatcher implements ContentTypeMatcher {
    public static final JsonContentTypeMatcher INSTANCE = new JsonContentTypeMatcher();

    private JsonContentTypeMatcher() {
    }

    @Override // io.ktor.http.ContentTypeMatcher
    public boolean contains(ContentType contentType) {
        contentType.getClass();
        if (contentType.match(ContentType.Application.INSTANCE.getJson())) {
            return true;
        }
        String string = contentType.withoutParameters().toString();
        return StringsKt__StringsJVMKt.startsWith(string, "application/", true) && StringsKt__StringsJVMKt.endsWith(string, "+json", true);
    }
}
