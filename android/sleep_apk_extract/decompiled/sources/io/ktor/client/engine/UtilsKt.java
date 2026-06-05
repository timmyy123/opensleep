package io.ktor.client.engine;

import io.ktor.client.utils.HeadersKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLParserKt$$ExternalSyntheticLambda0;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.PlatformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\u001a9\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0010\u0010\u000b\u001a\u00020\nH\u0087@¢\u0006\u0004\b\u000b\u0010\f\u001a\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\" \u0010\u0010\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\"\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/http/Headers;", "requestHeaders", "Lio/ktor/http/content/OutgoingContent;", "content", "Lkotlin/Function2;", "", "", "block", "mergeHeaders", "(Lio/ktor/http/Headers;Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/CoroutineContext;", "callContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "needUserAgent", "()Z", "KTOR_DEFAULT_USER_AGENT", "Ljava/lang/String;", "getKTOR_DEFAULT_USER_AGENT", "()Ljava/lang/String;", "getKTOR_DEFAULT_USER_AGENT$annotations", "()V", "", "DATE_HEADERS", "Ljava/util/Set;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class UtilsKt {
    private static final Set<String> DATE_HEADERS;
    private static final String KTOR_DEFAULT_USER_AGENT = "ktor-client";

    static {
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        DATE_HEADERS = SetsKt.setOf((Object[]) new String[]{httpHeaders.getDate(), httpHeaders.getExpires(), httpHeaders.getLastModified(), httpHeaders.getIfModifiedSince(), httpHeaders.getIfUnmodifiedSince()});
    }

    public static final Object callContext(Continuation<? super CoroutineContext> continuation) {
        CoroutineContext.Element element = continuation.getContext().get(KtorCallContextElement.INSTANCE);
        element.getClass();
        return ((KtorCallContextElement) element).getCallContext();
    }

    public static final void mergeHeaders(Headers headers, OutgoingContent outgoingContent, Function2<? super String, ? super String, Unit> function2) {
        String string;
        String string2;
        headers.getClass();
        outgoingContent.getClass();
        function2.getClass();
        HeadersKt.buildHeaders(new UtilsKt$$ExternalSyntheticLambda0(headers, outgoingContent, 0)).forEach(new URLParserKt$$ExternalSyntheticLambda0(function2, 2));
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        if (headers.get(httpHeaders.getUserAgent()) == null && outgoingContent.getHeaders().get(httpHeaders.getUserAgent()) == null && needUserAgent()) {
            function2.invoke(httpHeaders.getUserAgent(), KTOR_DEFAULT_USER_AGENT);
        }
        ContentType contentType = outgoingContent.getContentType();
        if ((contentType == null || (string = contentType.toString()) == null) && (string = outgoingContent.getHeaders().get(httpHeaders.getContentType())) == null) {
            string = headers.get(httpHeaders.getContentType());
        }
        Long contentLength = outgoingContent.getContentLength();
        if ((contentLength == null || (string2 = contentLength.toString()) == null) && (string2 = outgoingContent.getHeaders().get(httpHeaders.getContentLength())) == null) {
            string2 = headers.get(httpHeaders.getContentLength());
        }
        if (string != null) {
            function2.invoke(httpHeaders.getContentType(), string);
        }
        if (string2 != null) {
            function2.invoke(httpHeaders.getContentLength(), string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mergeHeaders$lambda$0(Headers headers, OutgoingContent outgoingContent, HeadersBuilder headersBuilder) {
        headersBuilder.getClass();
        headersBuilder.appendAll(headers);
        headersBuilder.appendAll(outgoingContent.getHeaders());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mergeHeaders$lambda$2(Function2 function2, String str, List list) {
        str.getClass();
        list.getClass();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        if (Intrinsics.areEqual(httpHeaders.getContentLength(), str)) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(httpHeaders.getContentType(), str)) {
            return Unit.INSTANCE;
        }
        if (DATE_HEADERS.contains(str)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                function2.invoke(str, (String) it.next());
            }
        } else {
            function2.invoke(str, CollectionsKt.joinToString$default(list, Intrinsics.areEqual(httpHeaders.getCookie(), str) ? "; " : ",", null, null, null, 62));
        }
        return Unit.INSTANCE;
    }

    private static final boolean needUserAgent() {
        return !PlatformUtils.INSTANCE.getIS_BROWSER();
    }
}
