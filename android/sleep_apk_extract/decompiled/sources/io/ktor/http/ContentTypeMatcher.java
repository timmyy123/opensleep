package io.ktor.http;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/ContentTypeMatcher;", "", "Lio/ktor/http/ContentType;", "contentType", "", "contains", "(Lio/ktor/http/ContentType;)Z", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ContentTypeMatcher {
    boolean contains(ContentType contentType);
}
