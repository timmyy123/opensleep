package io.ktor.client.plugins.websocket;

import com.squareup.kotlinpoet.FunSpec$$ExternalSyntheticLambda1;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLProtocol;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a(\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a2\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/client/HttpClient;", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "block", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "webSocketSession", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class BuildersKt {

    /* JADX INFO: renamed from: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2", f = "builders.kt", l = {243, 246, 52, 265, 265}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<DefaultClientWebSocketSession> $sessionDeferred;
        final /* synthetic */ HttpStatement $statement;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpStatement httpStatement, CompletableDeferred<DefaultClientWebSocketSession> completableDeferred, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$statement = httpStatement;
            this.$sessionDeferred = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$statement, this.$sessionDeferred, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(1:74)|(1:(1:(1:(1:(1:(2:9|10)(3:11|12|64))(4:18|19|68|69))(5:21|72|22|54|55))(4:26|77|27|(3:50|(3:53|54|55)|63)(2:58|59)))(3:31|32|33))(4:34|35|36|(2:38|63)(1:39))|40|70|41|75|42|45|(2:48|(0)(0))|63|(2:(0)|(0))) */
        /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|74|(1:(1:(1:(1:(1:(2:9|10)(3:11|12|64))(4:18|19|68|69))(5:21|72|22|54|55))(4:26|77|27|(3:50|(3:53|54|55)|63)(2:58|59)))(3:31|32|33))(4:34|35|36|(2:38|63)(1:39))|40|70|41|75|42|45|(2:48|(0)(0))|63|(2:(0)|(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00e7, code lost:
        
            if (r2.cleanup(r0, r14) != r1) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00f2, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00ff, code lost:
        
            if (r2.cleanup(r15, r14) != r1) goto L64;
         */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00b6 A[Catch: all -> 0x005c, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x005c, blocks: (B:27:0x0057, B:50:0x00b6, B:58:0x00ea, B:59:0x00f1), top: B:77:0x0057 }] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00ea A[Catch: all -> 0x005c, TRY_ENTER, TryCatch #5 {all -> 0x005c, blocks: (B:27:0x0057, B:50:0x00b6, B:58:0x00ea, B:59:0x00f1), top: B:77:0x0057 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            HttpStatement httpStatement;
            CompletableDeferred<DefaultClientWebSocketSession> completableDeferred;
            HttpResponse httpResponse;
            HttpResponse httpResponse2;
            HttpStatement httpStatement2;
            CompletableDeferred<DefaultClientWebSocketSession> completableDeferred2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                } catch (CancellationException e) {
                    throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
                }
            } catch (Throwable th) {
                this.$sessionDeferred.completeExceptionally(th);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HttpStatement httpStatement3 = this.$statement;
                CompletableDeferred<DefaultClientWebSocketSession> completableDeferred3 = this.$sessionDeferred;
                this.L$0 = httpStatement3;
                this.L$1 = completableDeferred3;
                this.label = 1;
                Object objFetchStreamingResponse = httpStatement3.fetchStreamingResponse(this);
                if (objFetchStreamingResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpStatement = httpStatement3;
                obj = objFetchStreamingResponse;
                completableDeferred = completableDeferred3;
            } else if (i == 1) {
                CompletableDeferred<DefaultClientWebSocketSession> completableDeferred4 = (CompletableDeferred) this.L$1;
                HttpStatement httpStatement4 = (HttpStatement) this.L$0;
                ResultKt.throwOnFailure(obj);
                completableDeferred = completableDeferred4;
                httpStatement = httpStatement4;
            } else {
                if (i == 2) {
                    httpResponse2 = (HttpResponse) this.L$2;
                    completableDeferred2 = (CompletableDeferred) this.L$1;
                    httpStatement2 = (HttpStatement) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        httpResponse = httpResponse2;
                        httpStatement = httpStatement2;
                        this.L$0 = th;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 5;
                    }
                    if (obj != null) {
                        throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                    }
                    DefaultClientWebSocketSession defaultClientWebSocketSession = (DefaultClientWebSocketSession) obj;
                    final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                    completableDeferred2.complete(defaultClientWebSocketSession);
                    defaultClientWebSocketSession.getOutgoing().invokeOnClose(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$1$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th3) {
                            CompletableDeferred<Unit> completableDeferred5 = completableDeferredCompletableDeferred$default;
                            if (th3 != null) {
                                completableDeferred5.completeExceptionally(th3);
                            } else {
                                completableDeferred5.complete(Unit.INSTANCE);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th3) {
                            invoke2(th3);
                            return Unit.INSTANCE;
                        }
                    });
                    this.L$0 = httpStatement2;
                    this.L$1 = httpResponse2;
                    this.L$2 = null;
                    this.label = 3;
                    if (completableDeferredCompletableDeferred$default.await(this) != coroutine_suspended) {
                        httpStatement = httpStatement2;
                        this.L$0 = Unit.INSTANCE;
                        this.L$1 = null;
                        this.label = 4;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    if (i == 4) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i != 5) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    th = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th;
                }
                httpResponse2 = (HttpResponse) this.L$1;
                httpStatement = (HttpStatement) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = Unit.INSTANCE;
                    this.L$1 = null;
                    this.label = 4;
                } catch (Throwable th3) {
                    HttpResponse httpResponse3 = httpResponse2;
                    th = th3;
                    httpResponse = httpResponse3;
                    this.L$0 = th;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                }
            }
            httpResponse = (HttpResponse) obj;
            HttpClientCall call = httpResponse.getCall();
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class);
            KType kTypeTypeOf = Reflection.typeOf(DefaultClientWebSocketSession.class);
            TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kTypeTypeOf);
            this.L$0 = httpStatement;
            this.L$1 = completableDeferred;
            this.L$2 = httpResponse;
            this.label = 2;
            Object objBodyNullable = call.bodyNullable(typeInfo, this);
            if (objBodyNullable != coroutine_suspended) {
                httpResponse2 = httpResponse;
                obj = objBodyNullable;
                httpStatement2 = httpStatement;
                completableDeferred2 = completableDeferred;
                if (obj != null) {
                }
            }
            return coroutine_suspended;
        }
    }

    public static final Object webSocketSession(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        HttpClientPluginKt.plugin(httpClient, WebSockets.INSTANCE);
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.url(new CombinedContext$$ExternalSyntheticLambda1(2));
        function1.invoke(httpRequestBuilder);
        BuildersKt__Builders_commonKt.launch$default(httpClient, null, null, new AnonymousClass2(new HttpStatement(httpRequestBuilder, httpClient), completableDeferredCompletableDeferred$default, null), 3, null);
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$2$lambda$1(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
        uRLBuilder.getClass();
        uRLBuilder2.getClass();
        uRLBuilder.setProtocol(URLProtocol.INSTANCE.getWS());
        uRLBuilder.setPort(uRLBuilder.getProtocol().getDefaultPort());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$6(String str, Function1 function1, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), str);
        function1.invoke(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    public static final Object webSocketSession(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return webSocketSession(httpClient, new FunSpec$$ExternalSyntheticLambda1(str, function1, 18), continuation);
    }
}
