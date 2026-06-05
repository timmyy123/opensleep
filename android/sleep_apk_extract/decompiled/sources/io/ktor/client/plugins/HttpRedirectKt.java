package io.ktor.client.plugins;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLProtocolKt;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.http.UrlKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0018\u0010\n\u001a\u00060\bj\u0002`\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/ktor/http/HttpStatusCode;", "", "isRedirect", "(Lio/ktor/http/HttpStatusCode;)Z", "", "Lio/ktor/http/HttpMethod;", "ALLOWED_FOR_REDIRECT", "Ljava/util/Set;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "HttpResponseRedirectEvent", "Lio/ktor/events/EventDefinition;", "getHttpResponseRedirectEvent", "()Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/HttpRedirectConfig;", "HttpRedirect", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRedirect", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRedirect$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class HttpRedirectKt {
    private static final Set<HttpMethod> ALLOWED_FOR_REDIRECT;
    private static final ClientPlugin<HttpRedirectConfig> HttpRedirect;
    private static final EventDefinition<HttpResponse> HttpResponseRedirectEvent;
    private static final Logger LOGGER;

    static {
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        ALLOWED_FOR_REDIRECT = SetsKt.setOf((Object[]) new HttpMethod[]{companion.getGet(), companion.getHead()});
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRedirect");
        HttpResponseRedirectEvent = new EventDefinition<>();
        HttpRedirect = CreatePluginUtilsKt.createClientPlugin("HttpRedirect", HttpRedirectKt$HttpRedirect$1.INSTANCE, new URLUtilsKt$$ExternalSyntheticLambda0(19));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpRedirect$lambda$2(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        clientPluginBuilder.on(Send.INSTANCE, new HttpRedirectKt$HttpRedirect$2$1(((HttpRedirectConfig) clientPluginBuilder.getPluginConfig()).getCheckHttpMethod(), ((HttpRedirectConfig) clientPluginBuilder.getPluginConfig()).getAllowHttpsDowngrade(), clientPluginBuilder, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0185 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [io.ktor.client.plugins.api.Send$Sender, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r14v3, types: [T, io.ktor.client.request.HttpRequestBuilder] */
    /* JADX WARN: Type inference failed for: r19v0, types: [T, io.ktor.client.call.HttpClientCall, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v12, types: [T] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [T] */
    /* JADX WARN: Type inference failed for: r6v1, types: [io.ktor.client.request.HttpRequestBuilder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0186 -> B:35:0x018d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object HttpRedirect$lambda$2$handleCall(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, HttpClientCall httpClientCall, boolean z, HttpClient httpClient, Continuation<? super HttpClientCall> continuation) {
        HttpRedirectKt$HttpRedirect$2$handleCall$1 httpRedirectKt$HttpRedirect$2$handleCall$1;
        String authority;
        Ref$ObjectRef ref$ObjectRef;
        URLProtocol uRLProtocol;
        ?? r0;
        Ref$ObjectRef ref$ObjectRef2;
        HttpRedirectKt$HttpRedirect$2$handleCall$1 httpRedirectKt$HttpRedirect$2$handleCall$12;
        boolean z2;
        HttpClient httpClient2;
        ?? r6;
        String str;
        ?? httpRequestBuilder2;
        Object objProceed;
        if (continuation instanceof HttpRedirectKt$HttpRedirect$2$handleCall$1) {
            httpRedirectKt$HttpRedirect$2$handleCall$1 = (HttpRedirectKt$HttpRedirect$2$handleCall$1) continuation;
            int i = httpRedirectKt$HttpRedirect$2$handleCall$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                httpRedirectKt$HttpRedirect$2$handleCall$1.label = i - Integer.MIN_VALUE;
            } else {
                httpRedirectKt$HttpRedirect$2$handleCall$1 = new HttpRedirectKt$HttpRedirect$2$handleCall$1(continuation);
            }
        }
        Object obj = httpRedirectKt$HttpRedirect$2$handleCall$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = httpRedirectKt$HttpRedirect$2$handleCall$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!isRedirect(httpClientCall.getResponse().getStatus())) {
                return httpClientCall;
            }
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = httpClientCall;
            Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            ?? r62 = httpRequestBuilder;
            ref$ObjectRef4.element = r62;
            URLProtocol protocol2 = httpClientCall.getRequest().getUrl().getProtocol();
            authority = UrlKt.getAuthority(httpClientCall.getRequest().getUrl());
            ref$ObjectRef = ref$ObjectRef4;
            uRLProtocol = protocol2;
            r0 = sender;
            ref$ObjectRef2 = ref$ObjectRef3;
            httpRedirectKt$HttpRedirect$2$handleCall$12 = httpRedirectKt$HttpRedirect$2$handleCall$1;
            z2 = z;
            httpClient2 = httpClient;
            r6 = r62;
            httpClient2.getMonitor().raise(HttpResponseRedirectEvent, ((HttpClientCall) ref$ObjectRef2.element).getResponse());
            Headers headers = ((HttpClientCall) ref$ObjectRef2.element).getResponse().getHeaders();
            HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
            str = headers.get(httpHeaders.getLocation());
            Logger logger = LOGGER;
            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Received redirect response to ", str, " for request ");
            sbM5m.append(r6.getUrl());
            logger.trace(sbM5m.toString());
            httpRequestBuilder2 = new HttpRequestBuilder();
            httpRequestBuilder2.takeFromWithExecutionContext((HttpRequestBuilder) ref$ObjectRef.element);
            httpRequestBuilder2.getUrl().getParameters().clear();
            if (str != null) {
            }
            if (z2) {
            }
            if (!Intrinsics.areEqual(authority, URLBuilderKt.getAuthority(httpRequestBuilder2.getUrl()))) {
            }
            ref$ObjectRef.element = httpRequestBuilder2;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$0 = r0;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$1 = r6;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$2 = httpClient2;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$3 = ref$ObjectRef2;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$4 = ref$ObjectRef;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$5 = uRLProtocol;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$6 = authority;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$7 = ref$ObjectRef2;
            httpRedirectKt$HttpRedirect$2$handleCall$12.Z$0 = z2;
            httpRedirectKt$HttpRedirect$2$handleCall$12.label = 1;
            objProceed = r0.proceed(httpRequestBuilder2, httpRedirectKt$HttpRedirect$2$handleCall$12);
            if (objProceed != coroutine_suspended) {
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            boolean z3 = httpRedirectKt$HttpRedirect$2$handleCall$1.Z$0;
            Ref$ObjectRef ref$ObjectRef5 = (Ref$ObjectRef) httpRedirectKt$HttpRedirect$2$handleCall$1.L$7;
            String str2 = (String) httpRedirectKt$HttpRedirect$2$handleCall$1.L$6;
            URLProtocol uRLProtocol2 = (URLProtocol) httpRedirectKt$HttpRedirect$2$handleCall$1.L$5;
            Ref$ObjectRef ref$ObjectRef6 = (Ref$ObjectRef) httpRedirectKt$HttpRedirect$2$handleCall$1.L$4;
            Ref$ObjectRef ref$ObjectRef7 = (Ref$ObjectRef) httpRedirectKt$HttpRedirect$2$handleCall$1.L$3;
            HttpClient httpClient3 = (HttpClient) httpRedirectKt$HttpRedirect$2$handleCall$1.L$2;
            HttpRequestBuilder httpRequestBuilder3 = (HttpRequestBuilder) httpRedirectKt$HttpRedirect$2$handleCall$1.L$1;
            Send.Sender sender2 = (Send.Sender) httpRedirectKt$HttpRedirect$2$handleCall$1.L$0;
            ResultKt.throwOnFailure(obj);
            HttpRedirectKt$HttpRedirect$2$handleCall$1 httpRedirectKt$HttpRedirect$2$handleCall$13 = httpRedirectKt$HttpRedirect$2$handleCall$1;
            boolean z4 = z3;
            ?? r02 = sender2;
            Ref$ObjectRef ref$ObjectRef8 = ref$ObjectRef6;
            authority = str2;
            HttpRedirectKt$HttpRedirect$2$handleCall$1 httpRedirectKt$HttpRedirect$2$handleCall$14 = httpRedirectKt$HttpRedirect$2$handleCall$13;
            uRLProtocol = uRLProtocol2;
            ref$ObjectRef2 = ref$ObjectRef7;
            ?? r1 = obj;
            ?? r11 = httpRequestBuilder3;
            ref$ObjectRef5.element = r1;
            if (isRedirect(((HttpClientCall) ref$ObjectRef2.element).getResponse().getStatus())) {
                return ref$ObjectRef2.element;
            }
            z2 = z4;
            httpRedirectKt$HttpRedirect$2$handleCall$12 = httpRedirectKt$HttpRedirect$2$handleCall$14;
            httpClient2 = httpClient3;
            r6 = r11;
            ref$ObjectRef = ref$ObjectRef8;
            r0 = r02;
            httpClient2.getMonitor().raise(HttpResponseRedirectEvent, ((HttpClientCall) ref$ObjectRef2.element).getResponse());
            Headers headers2 = ((HttpClientCall) ref$ObjectRef2.element).getResponse().getHeaders();
            HttpHeaders httpHeaders2 = HttpHeaders.INSTANCE;
            str = headers2.get(httpHeaders2.getLocation());
            Logger logger2 = LOGGER;
            StringBuilder sbM5m2 = FileInsert$$ExternalSyntheticOutline0.m5m("Received redirect response to ", str, " for request ");
            sbM5m2.append(r6.getUrl());
            logger2.trace(sbM5m2.toString());
            httpRequestBuilder2 = new HttpRequestBuilder();
            httpRequestBuilder2.takeFromWithExecutionContext((HttpRequestBuilder) ref$ObjectRef.element);
            httpRequestBuilder2.getUrl().getParameters().clear();
            if (str != null) {
                URLParserKt.takeFrom(httpRequestBuilder2.getUrl(), str);
            }
            if (z2 && URLProtocolKt.isSecure(uRLProtocol) && !URLProtocolKt.isSecure(httpRequestBuilder2.getUrl().getProtocol())) {
                logger2.trace("Can not redirect " + r6.getUrl() + " because of security downgrade");
                return ref$ObjectRef2.element;
            }
            if (!Intrinsics.areEqual(authority, URLBuilderKt.getAuthority(httpRequestBuilder2.getUrl()))) {
                httpRequestBuilder2.getHeaders().remove(httpHeaders2.getAuthorization());
                logger2.trace("Removing Authorization header from redirect for " + r6.getUrl());
            }
            ref$ObjectRef.element = httpRequestBuilder2;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$0 = r0;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$1 = r6;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$2 = httpClient2;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$3 = ref$ObjectRef2;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$4 = ref$ObjectRef;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$5 = uRLProtocol;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$6 = authority;
            httpRedirectKt$HttpRedirect$2$handleCall$12.L$7 = ref$ObjectRef2;
            httpRedirectKt$HttpRedirect$2$handleCall$12.Z$0 = z2;
            httpRedirectKt$HttpRedirect$2$handleCall$12.label = 1;
            objProceed = r0.proceed(httpRequestBuilder2, httpRedirectKt$HttpRedirect$2$handleCall$12);
            if (objProceed != coroutine_suspended) {
                return coroutine_suspended;
            }
            ref$ObjectRef8 = ref$ObjectRef;
            httpClient3 = httpClient2;
            z4 = z2;
            r1 = objProceed;
            r11 = r6;
            httpRedirectKt$HttpRedirect$2$handleCall$14 = httpRedirectKt$HttpRedirect$2$handleCall$12;
            ref$ObjectRef5 = ref$ObjectRef2;
            r02 = r0;
            ref$ObjectRef5.element = r1;
            if (isRedirect(((HttpClientCall) ref$ObjectRef2.element).getResponse().getStatus())) {
            }
        }
    }

    public static final ClientPlugin<HttpRedirectConfig> getHttpRedirect() {
        return HttpRedirect;
    }

    private static final boolean isRedirect(HttpStatusCode httpStatusCode) {
        int value = httpStatusCode.getValue();
        HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
        return value == companion.getMovedPermanently().getValue() || value == companion.getFound().getValue() || value == companion.getTemporaryRedirect().getValue() || value == companion.getPermanentRedirect().getValue() || value == companion.getSeeOther().getValue();
    }
}
