package io.ktor.client.statement;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.plugins.DoubleReceivePluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.utils.io.ByteReadChannelKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J:\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\r\u001a\u00020\nH\u0086@¢\u0006\u0004\b\r\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0011\u0010\u000fJ\u0014\u0010\u0013\u001a\u00020\u0012*\u00020\nH\u0081@¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R \u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lio/ktor/client/statement/HttpStatement;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/HttpClient;", "client", "<init>", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/HttpClient;)V", "T", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/coroutines/Continuation;", "block", "execute", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchStreamingResponse", "fetchResponse", "", "cleanup", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "getClient$annotations", "()V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpStatement {
    private final HttpRequestBuilder builder;
    private final HttpClient client;

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$cleanup$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {168}, m = "cleanup")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.cleanup(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$execute$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {49, 52, 54, 54}, m = "execute")
    public static final class C22521<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C22521(Continuation<? super C22521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.execute(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$fetchResponse$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {147, 148, 149}, m = "fetchResponse")
    public static final class C22531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C22531(Continuation<? super C22531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.fetchResponse(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$fetchStreamingResponse$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {136}, m = "fetchStreamingResponse")
    public static final class C22541 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C22541(Continuation<? super C22541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.fetchStreamingResponse(this);
        }
    }

    public HttpStatement(HttpRequestBuilder httpRequestBuilder, HttpClient httpClient) {
        httpRequestBuilder.getClass();
        httpClient.getClass();
        this.builder = httpRequestBuilder;
        this.client = httpClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cleanup(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineContext.Element element = httpResponse.getCoroutineContext().get(Job.INSTANCE);
            element.getClass();
            CompletableJob completableJob = (CompletableJob) element;
            completableJob.complete();
            try {
                ByteReadChannelKt.cancel(httpResponse.getRawContent());
            } catch (Throwable unused) {
            }
            anonymousClass1.L$0 = completableJob;
            anonymousClass1.label = 1;
            if (completableJob.join(anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:57|(1:(1:(1:(1:(2:14|15)(3:16|17|58))(3:19|20|21))(5:22|53|23|40|(2:42|48)(1:43)))(2:28|29))(4:31|32|(1:34)|48)|35|55|36|(3:39|40|(0)(0))|48) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0093, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0094, code lost:
    
        r8 = r10;
        r10 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a4 A[Catch: CancellationException -> 0x00a5, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x00a5, blocks: (B:17:0x0039, B:49:0x00a4, B:20:0x0040, B:40:0x0085, B:46:0x0097, B:29:0x005e, B:35:0x0072, B:32:0x0065), top: B:57:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object execute(Function2<? super HttpResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        C22521 c22521;
        HttpResponse httpResponse;
        HttpStatement httpStatement;
        HttpResponse httpResponse2;
        if (continuation instanceof C22521) {
            c22521 = (C22521) continuation;
            int i = c22521.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22521.label = i - Integer.MIN_VALUE;
            } else {
                c22521 = new C22521(continuation);
            }
        }
        Object objFetchStreamingResponse = c22521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22521.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objFetchStreamingResponse);
                c22521.L$0 = this;
                c22521.L$1 = function2;
                c22521.label = 1;
                objFetchStreamingResponse = fetchStreamingResponse(c22521);
                if (objFetchStreamingResponse == coroutine_suspended) {
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        Object obj = c22521.L$0;
                        ResultKt.throwOnFailure(objFetchStreamingResponse);
                        return obj;
                    }
                    if (i2 != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Throwable th = (Throwable) c22521.L$0;
                    ResultKt.throwOnFailure(objFetchStreamingResponse);
                    throw th;
                }
                httpResponse2 = (HttpResponse) c22521.L$1;
                httpStatement = (HttpStatement) c22521.L$0;
                try {
                    ResultKt.throwOnFailure(objFetchStreamingResponse);
                    c22521.L$0 = objFetchStreamingResponse;
                    c22521.L$1 = null;
                    c22521.label = 3;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    httpResponse = httpResponse2;
                    Throwable th4 = th3;
                    c22521.L$0 = th4;
                    c22521.L$1 = null;
                    c22521.label = 4;
                    if (httpStatement.cleanup(httpResponse, c22521) != coroutine_suspended) {
                        throw th4;
                    }
                }
                return httpStatement.cleanup(httpResponse2, c22521) != coroutine_suspended ? coroutine_suspended : objFetchStreamingResponse;
            }
            function2 = (Function2) c22521.L$1;
            this = (HttpStatement) c22521.L$0;
            ResultKt.throwOnFailure(objFetchStreamingResponse);
            httpResponse = (HttpResponse) objFetchStreamingResponse;
            c22521.L$0 = this;
            c22521.L$1 = httpResponse;
            c22521.label = 2;
            Object objInvoke = function2.invoke(httpResponse, c22521);
            if (objInvoke != coroutine_suspended) {
                httpStatement = this;
                httpResponse2 = httpResponse;
                objFetchStreamingResponse = objInvoke;
                c22521.L$0 = objFetchStreamingResponse;
                c22521.L$1 = null;
                c22521.label = 3;
                if (httpStatement.cleanup(httpResponse2, c22521) != coroutine_suspended) {
                }
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchResponse(Continuation<? super HttpResponse> continuation) throws Throwable {
        C22531 c22531;
        HttpStatement httpStatement;
        HttpClientCall httpClientCall;
        if (continuation instanceof C22531) {
            c22531 = (C22531) continuation;
            int i = c22531.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22531.label = i - Integer.MIN_VALUE;
            } else {
                c22531 = new C22531(continuation);
            }
        }
        Object objExecute$ktor_client_core = c22531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22531.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
                HttpRequestBuilder httpRequestBuilderTakeFromWithExecutionContext = new HttpRequestBuilder().takeFromWithExecutionContext(this.builder);
                HttpClient httpClient = this.client;
                c22531.L$0 = this;
                c22531.label = 1;
                objExecute$ktor_client_core = httpClient.execute$ktor_client_core(httpRequestBuilderTakeFromWithExecutionContext, c22531);
                if (objExecute$ktor_client_core == coroutine_suspended) {
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    HttpResponse httpResponse = (HttpResponse) c22531.L$0;
                    ResultKt.throwOnFailure(objExecute$ktor_client_core);
                    return httpResponse;
                }
                httpClientCall = (HttpClientCall) c22531.L$1;
                httpStatement = (HttpStatement) c22531.L$0;
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
                HttpResponse response = ((HttpClientCall) objExecute$ktor_client_core).getResponse();
                HttpResponse response2 = httpClientCall.getResponse();
                c22531.L$0 = response;
                c22531.L$1 = null;
                c22531.label = 3;
                return httpStatement.cleanup(response2, c22531) != coroutine_suspended ? coroutine_suspended : response;
            }
            this = (HttpStatement) c22531.L$0;
            ResultKt.throwOnFailure(objExecute$ktor_client_core);
            HttpClientCall httpClientCall2 = (HttpClientCall) objExecute$ktor_client_core;
            c22531.L$0 = this;
            c22531.L$1 = httpClientCall2;
            c22531.label = 2;
            Object objSave = SavedCallKt.save(httpClientCall2, c22531);
            if (objSave != coroutine_suspended) {
                httpStatement = this;
                httpClientCall = httpClientCall2;
                objExecute$ktor_client_core = objSave;
                HttpResponse response3 = ((HttpClientCall) objExecute$ktor_client_core).getResponse();
                HttpResponse response22 = httpClientCall.getResponse();
                c22531.L$0 = response3;
                c22531.L$1 = null;
                c22531.label = 3;
                if (httpStatement.cleanup(response22, c22531) != coroutine_suspended) {
                }
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchStreamingResponse(Continuation<? super HttpResponse> continuation) throws Throwable {
        C22541 c22541;
        if (continuation instanceof C22541) {
            c22541 = (C22541) continuation;
            int i = c22541.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22541.label = i - Integer.MIN_VALUE;
            } else {
                c22541 = new C22541(continuation);
            }
        }
        Object objExecute$ktor_client_core = c22541.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22541.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
                HttpRequestBuilder httpRequestBuilderTakeFromWithExecutionContext = new HttpRequestBuilder().takeFromWithExecutionContext(this.builder);
                DoubleReceivePluginKt.skipSavingBody(httpRequestBuilderTakeFromWithExecutionContext);
                HttpClient httpClient = this.client;
                c22541.label = 1;
                objExecute$ktor_client_core = httpClient.execute$ktor_client_core(httpRequestBuilderTakeFromWithExecutionContext, c22541);
                if (objExecute$ktor_client_core == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
            }
            return ((HttpClientCall) objExecute$ktor_client_core).getResponse();
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    public String toString() {
        return "HttpStatement[" + this.builder.getUrl() + ']';
    }

    public final Object execute(Continuation<? super HttpResponse> continuation) {
        return fetchResponse(continuation);
    }
}
