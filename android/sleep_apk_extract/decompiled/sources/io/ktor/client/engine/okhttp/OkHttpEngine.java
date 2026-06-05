package io.ktor.client.engine.okhttp;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4;
import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.sse.SSECapability;
import io.ktor.client.plugins.websocket.WebSocketCapability;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.HttpResponseData;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.util.CacheKt;
import io.ktor.util.CoroutinesUtilsKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import java.net.Proxy;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.WebSocket;
import okio.BufferedSource;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0004\u0018\u0000 72\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u0016\u0010\u0015J0\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010 \u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010(R$\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0)8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u00100\u001a\u0004\b2\u00103R\"\u00105\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u000e048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpEngine;", "Lio/ktor/client/engine/HttpClientEngineBase;", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "config", "<init>", "(Lio/ktor/client/engine/okhttp/OkHttpConfig;)V", "Lio/ktor/client/request/HttpRequestData;", "data", "Lio/ktor/client/request/HttpResponseData;", "execute", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "close", "()V", "Lokhttp3/OkHttpClient;", "engine", "Lokhttp3/Request;", "engineRequest", "Lkotlin/coroutines/CoroutineContext;", "callContext", "executeWebSocketRequest", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeServerSendEventsRequest", "requestData", "executeHttpRequest", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/Response;", "response", "Lio/ktor/util/date/GMTDate;", "requestTime", "", SDKConstants.PARAM_A2U_BODY, "buildResponseData", "(Lokhttp3/Response;Lio/ktor/util/date/GMTDate;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/client/request/HttpResponseData;", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "timeoutExtension", "createOkHttpClient", "(Lio/ktor/client/plugins/HttpTimeoutConfig;)Lokhttp3/OkHttpClient;", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "getConfig", "()Lio/ktor/client/engine/okhttp/OkHttpConfig;", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "supportedCapabilities", "Ljava/util/Set;", "getSupportedCapabilities", "()Ljava/util/Set;", "requestsJob", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "", "clientCache", "Ljava/util/Map;", "Companion", "ktor-client-okhttp"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OkHttpEngine extends HttpClientEngineBase {
    private static final Companion Companion = new Companion(null);
    private static final Lazy<OkHttpClient> okHttpClientPrototype$delegate = LazyKt.lazy(new HttpClientConfig$$ExternalSyntheticLambda4(11));
    private final Map<HttpTimeoutConfig, OkHttpClient> clientCache;
    private final OkHttpConfig config;
    private final CoroutineContext coroutineContext;
    private final CoroutineContext requestsJob;
    private final Set<HttpClientEngineCapability<?>> supportedCapabilities;

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine$1", f = "OkHttpEngine.kt", l = {49}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OkHttpEngine.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.util.Iterator] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext.Element element = OkHttpEngine.this.requestsJob.get(Job.INSTANCE);
                    element.getClass();
                    this.label = 1;
                    if (((Job) element).join(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                while (it.hasNext()) {
                    OkHttpClient okHttpClient = (OkHttpClient) ((Map.Entry) it.next()).getValue();
                    okHttpClient.getConnectionPool().evictAll();
                    okHttpClient.getDispatcher().executorService().shutdown();
                }
                return Unit.INSTANCE;
            } finally {
                it = OkHttpEngine.this.clientCache.entrySet().iterator();
                while (it.hasNext()) {
                    OkHttpClient okHttpClient2 = (OkHttpClient) ((Map.Entry) it.next()).getValue();
                    okHttpClient2.getConnectionPool().evictAll();
                    okHttpClient2.getDispatcher().executorService().shutdown();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpEngine$Companion;", "", "<init>", "()V", "Lokhttp3/OkHttpClient;", "okHttpClientPrototype$delegate", "Lkotlin/Lazy;", "getOkHttpClientPrototype", "()Lokhttp3/OkHttpClient;", "okHttpClientPrototype", "ktor-client-okhttp"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OkHttpClient getOkHttpClientPrototype() {
            return (OkHttpClient) OkHttpEngine.okHttpClientPrototype$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$execute$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {60, 67, 68, 69}, m = "execute")
    public static final class C22461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C22461(Continuation<? super C22461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.execute(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {118}, m = "executeHttpRequest")
    public static final class C22471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C22471(Continuation<? super C22471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.executeHttpRequest(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$executeServerSendEventsRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {107}, m = "executeServerSendEventsRequest")
    public static final class C22481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C22481(Continuation<? super C22481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.executeServerSendEventsRequest(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {91}, m = "executeWebSocketRequest")
    public static final class C22491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C22491(Continuation<? super C22491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.executeWebSocketRequest(null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine(OkHttpConfig okHttpConfig) {
        super("ktor-okhttp");
        okHttpConfig.getClass();
        this.config = okHttpConfig;
        this.supportedCapabilities = SetsKt.setOf((Object[]) new HttpClientEngineCapability[]{HttpTimeoutCapability.INSTANCE, WebSocketCapability.INSTANCE, SSECapability.INSTANCE});
        this.clientCache = CacheKt.createLRUCache(new OkHttpEngine$clientCache$1(this), new URLUtilsKt$$ExternalSyntheticLambda0(14), getConfig().getClientCacheSize());
        CoroutineContext.Element element = super.getCoroutineContext().get(Job.INSTANCE);
        element.getClass();
        CoroutineContext coroutineContextSilentSupervisor = CoroutinesUtilsKt.SilentSupervisor((Job) element);
        this.requestsJob = coroutineContextSilentSupervisor;
        this.coroutineContext = super.getCoroutineContext().plus(coroutineContextSilentSupervisor);
        BuildersKt.launch(GlobalScope.INSTANCE, super.getCoroutineContext(), CoroutineStart.ATOMIC, new AnonymousClass1(null));
    }

    private final HttpResponseData buildResponseData(Response response, GMTDate requestTime, Object body, CoroutineContext callContext) {
        return new HttpResponseData(new HttpStatusCode(response.getCode(), response.getMessage()), requestTime, OkUtilsKt.fromOkHttp(response.getHeaders()), OkUtilsKt.fromOkHttp(response.getProtocol()), body, callContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clientCache$lambda$0(OkHttpClient okHttpClient) {
        okHttpClient.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient createOkHttpClient(HttpTimeoutConfig timeoutExtension) {
        OkHttpClient preconfigured = getConfig().getPreconfigured();
        if (preconfigured == null) {
            preconfigured = Companion.getOkHttpClientPrototype();
        }
        OkHttpClient.Builder builderNewBuilder = preconfigured.newBuilder();
        builderNewBuilder.dispatcher(new Dispatcher());
        getConfig().getConfig$ktor_client_okhttp().invoke(builderNewBuilder);
        Proxy proxy = getConfig().getProxy();
        if (proxy != null) {
            builderNewBuilder.proxy(proxy);
        }
        if (timeoutExtension != null) {
            OkHttpEngineKt.setupTimeoutAttributes(builderNewBuilder, timeoutExtension);
        }
        return builderNewBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeHttpRequest(OkHttpClient okHttpClient, Request request, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation) {
        C22471 c22471;
        GMTDate gMTDateGMTDate$default;
        Object objExecute;
        ByteReadChannel empty;
        BufferedSource bufferedSourceSource;
        if (continuation instanceof C22471) {
            c22471 = (C22471) continuation;
            int i = c22471.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22471.label = i - Integer.MIN_VALUE;
            } else {
                c22471 = new C22471(continuation);
            }
        }
        Object obj = c22471.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22471.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            gMTDateGMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
            c22471.L$0 = this;
            c22471.L$1 = coroutineContext;
            c22471.L$2 = httpRequestData;
            c22471.L$3 = gMTDateGMTDate$default;
            c22471.label = 1;
            objExecute = OkUtilsKt.execute(okHttpClient, request, httpRequestData, coroutineContext, c22471);
            if (objExecute == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            GMTDate gMTDate = (GMTDate) c22471.L$3;
            httpRequestData = (HttpRequestData) c22471.L$2;
            coroutineContext = (CoroutineContext) c22471.L$1;
            OkHttpEngine okHttpEngine = (OkHttpEngine) c22471.L$0;
            ResultKt.throwOnFailure(obj);
            gMTDateGMTDate$default = gMTDate;
            this = okHttpEngine;
            objExecute = obj;
        }
        Response response = (Response) objExecute;
        ResponseBody responseBodyBody = response.getBody();
        CoroutineContext.Element element = coroutineContext.get(Job.INSTANCE);
        element.getClass();
        ((Job) element).invokeOnCompletion(new CodecsKt$$ExternalSyntheticLambda2(responseBodyBody, 21));
        if (responseBodyBody == null || (bufferedSourceSource = responseBodyBody.getSource()) == null || (empty = OkHttpEngineKt.toChannel(bufferedSourceSource, coroutineContext, httpRequestData)) == null) {
            empty = ByteReadChannel.INSTANCE.getEmpty();
        }
        return this.buildResponseData(response, gMTDateGMTDate$default, empty, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit executeHttpRequest$lambda$2(ResponseBody responseBody, Throwable th) {
        if (responseBody != null) {
            responseBody.close();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeServerSendEventsRequest(OkHttpClient okHttpClient, Request request, CoroutineContext coroutineContext, Continuation<? super HttpResponseData> continuation) {
        C22481 c22481;
        OkHttpSSESession okHttpSSESession;
        GMTDate gMTDate;
        if (continuation instanceof C22481) {
            c22481 = (C22481) continuation;
            int i = c22481.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22481.label = i - Integer.MIN_VALUE;
            } else {
                c22481 = new C22481(continuation);
            }
        }
        Object obj = c22481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22481.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            GMTDate gMTDateGMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
            okHttpSSESession = new OkHttpSSESession(okHttpClient, request, coroutineContext);
            CompletableDeferred<Response> originResponse$ktor_client_okhttp = okHttpSSESession.getOriginResponse$ktor_client_okhttp();
            c22481.L$0 = this;
            c22481.L$1 = coroutineContext;
            c22481.L$2 = gMTDateGMTDate$default;
            c22481.L$3 = okHttpSSESession;
            c22481.label = 1;
            Object objAwait = originResponse$ktor_client_okhttp.await(c22481);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objAwait;
            gMTDate = gMTDateGMTDate$default;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            OkHttpSSESession okHttpSSESession2 = (OkHttpSSESession) c22481.L$3;
            gMTDate = (GMTDate) c22481.L$2;
            coroutineContext = (CoroutineContext) c22481.L$1;
            OkHttpEngine okHttpEngine = (OkHttpEngine) c22481.L$0;
            ResultKt.throwOnFailure(obj);
            okHttpSSESession = okHttpSSESession2;
            this = okHttpEngine;
        }
        return this.buildResponseData((Response) obj, gMTDate, okHttpSSESession, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeWebSocketRequest(OkHttpClient okHttpClient, Request request, CoroutineContext coroutineContext, Continuation<? super HttpResponseData> continuation) {
        C22491 c22491;
        OkHttpWebsocketSession okHttpWebsocketSession;
        GMTDate gMTDate;
        if (continuation instanceof C22491) {
            c22491 = (C22491) continuation;
            int i = c22491.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22491.label = i - Integer.MIN_VALUE;
            } else {
                c22491 = new C22491(continuation);
            }
        }
        Object obj = c22491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22491.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            GMTDate gMTDateGMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
            WebSocket.Factory webSocketFactory = getConfig().getWebSocketFactory();
            if (webSocketFactory == null) {
                webSocketFactory = okHttpClient;
            }
            okHttpWebsocketSession = new OkHttpWebsocketSession(okHttpClient, webSocketFactory, request, coroutineContext);
            okHttpWebsocketSession.start();
            CompletableDeferred<Response> originResponse$ktor_client_okhttp = okHttpWebsocketSession.getOriginResponse$ktor_client_okhttp();
            c22491.L$0 = this;
            c22491.L$1 = coroutineContext;
            c22491.L$2 = gMTDateGMTDate$default;
            c22491.L$3 = okHttpWebsocketSession;
            c22491.label = 1;
            Object objAwait = originResponse$ktor_client_okhttp.await(c22491);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objAwait;
            gMTDate = gMTDateGMTDate$default;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            OkHttpWebsocketSession okHttpWebsocketSession2 = (OkHttpWebsocketSession) c22491.L$3;
            gMTDate = (GMTDate) c22491.L$2;
            coroutineContext = (CoroutineContext) c22491.L$1;
            OkHttpEngine okHttpEngine = (OkHttpEngine) c22491.L$0;
            ResultKt.throwOnFailure(obj);
            okHttpWebsocketSession = okHttpWebsocketSession2;
            this = okHttpEngine;
        }
        return this.buildResponseData((Response) obj, gMTDate, okHttpWebsocketSession, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient okHttpClientPrototype_delegate$lambda$5() {
        return new OkHttpClient.Builder().build();
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        CoroutineContext.Element element = this.requestsJob.get(Job.INSTANCE);
        element.getClass();
        ((CompletableJob) element).complete();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // io.ktor.client.engine.HttpClientEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execute(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation) {
        C22461 c22461;
        if (continuation instanceof C22461) {
            c22461 = (C22461) continuation;
            int i = c22461.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22461.label = i - Integer.MIN_VALUE;
            } else {
                c22461 = new C22461(continuation);
            }
        }
        C22461 c224612 = c22461;
        Object objCallContext = c224612.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c224612.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCallContext);
            c224612.L$0 = this;
            c224612.L$1 = httpRequestData;
            c224612.label = 1;
            objCallContext = UtilsKt.callContext(c224612);
            if (objCallContext != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objCallContext);
                return objCallContext;
            }
            if (i2 == 3) {
                ResultKt.throwOnFailure(objCallContext);
                return objCallContext;
            }
            if (i2 == 4) {
                ResultKt.throwOnFailure(objCallContext);
                return objCallContext;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        httpRequestData = (HttpRequestData) c224612.L$1;
        this = (OkHttpEngine) c224612.L$0;
        ResultKt.throwOnFailure(objCallContext);
        OkHttpEngine okHttpEngine = this;
        HttpRequestData httpRequestData2 = httpRequestData;
        CoroutineContext coroutineContext = (CoroutineContext) objCallContext;
        Request requestConvertToOkHttpRequest = OkHttpEngineKt.convertToOkHttpRequest(httpRequestData2, coroutineContext);
        OkHttpClient okHttpClient = okHttpEngine.clientCache.get(httpRequestData2.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE));
        if (okHttpClient == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("OkHttpClient can't be constructed because HttpTimeout plugin is not installed");
            return null;
        }
        if (HttpRequestKt.isUpgradeRequest(httpRequestData2)) {
            c224612.L$0 = null;
            c224612.L$1 = null;
            c224612.label = 2;
            Object objExecuteWebSocketRequest = okHttpEngine.executeWebSocketRequest(okHttpClient, requestConvertToOkHttpRequest, coroutineContext, c224612);
            if (objExecuteWebSocketRequest != coroutine_suspended) {
                return objExecuteWebSocketRequest;
            }
        } else if (HttpRequestKt.isSseRequest(httpRequestData2)) {
            c224612.L$0 = null;
            c224612.L$1 = null;
            c224612.label = 3;
            Object objExecuteServerSendEventsRequest = okHttpEngine.executeServerSendEventsRequest(okHttpClient, requestConvertToOkHttpRequest, coroutineContext, c224612);
            if (objExecuteServerSendEventsRequest != coroutine_suspended) {
                return objExecuteServerSendEventsRequest;
            }
        } else {
            c224612.L$0 = null;
            c224612.L$1 = null;
            c224612.label = 4;
            Object objExecuteHttpRequest = okHttpEngine.executeHttpRequest(okHttpClient, requestConvertToOkHttpRequest, coroutineContext, httpRequestData2, c224612);
            if (objExecuteHttpRequest != coroutine_suspended) {
                return objExecuteHttpRequest;
            }
        }
        return coroutine_suspended;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return this.supportedCapabilities;
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public OkHttpConfig getConfig() {
        return this.config;
    }
}
