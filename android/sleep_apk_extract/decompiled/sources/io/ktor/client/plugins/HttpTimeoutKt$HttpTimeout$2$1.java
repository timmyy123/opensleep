package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLProtocolKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeoutKt$HttpTimeout$2$1", f = "HttpTimeout.kt", l = {144, 175}, m = "invokeSuspend")
public final class HttpTimeoutKt$HttpTimeout$2$1 extends SuspendLambda implements Function3<Send.Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ Long $connectTimeoutMillis;
    final /* synthetic */ Long $requestTimeoutMillis;
    final /* synthetic */ Long $socketTimeoutMillis;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTimeoutKt$HttpTimeout$2$1(Long l, Long l2, Long l3, Continuation<? super HttpTimeoutKt$HttpTimeout$2$1> continuation) {
        super(3, continuation);
        this.$requestTimeoutMillis = l;
        this.$connectTimeoutMillis = l2;
        this.$socketTimeoutMillis = l3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$lambda$0(Job job, Throwable th) {
        Job.cancel$default(job, null, 1, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpTimeoutKt$HttpTimeout$2$1 httpTimeoutKt$HttpTimeout$2$1 = new HttpTimeoutKt$HttpTimeout$2$1(this.$requestTimeoutMillis, this.$connectTimeoutMillis, this.$socketTimeoutMillis, continuation);
        httpTimeoutKt$HttpTimeout$2$1.L$0 = sender;
        httpTimeoutKt$HttpTimeout$2$1.L$1 = httpRequestBuilder;
        return httpTimeoutKt$HttpTimeout$2$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        Send.Sender sender = (Send.Sender) this.L$0;
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$1;
        if (URLProtocolKt.isWebsocket(httpRequestBuilder.getUrl().getProtocol()) || (httpRequestBuilder.getBody() instanceof ClientUpgradeContent)) {
            this.L$0 = null;
            this.label = 1;
            Object objProceed = sender.proceed(httpRequestBuilder, this);
            if (objProceed != coroutine_suspended) {
                return objProceed;
            }
        } else {
            httpRequestBuilder.getBody();
            HttpTimeoutCapability httpTimeoutCapability = HttpTimeoutCapability.INSTANCE;
            HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) httpRequestBuilder.getCapabilityOrNull(httpTimeoutCapability);
            if (httpTimeoutConfig == null && HttpTimeoutKt.HttpTimeout$lambda$1$hasNotNullTimeouts(this.$requestTimeoutMillis, this.$connectTimeoutMillis, this.$socketTimeoutMillis)) {
                HttpTimeoutConfig httpTimeoutConfig2 = new HttpTimeoutConfig(null, null, null, 7, null);
                httpRequestBuilder.setCapability(httpTimeoutCapability, httpTimeoutConfig2);
                httpTimeoutConfig = httpTimeoutConfig2;
            }
            if (httpTimeoutConfig != null) {
                Long l = this.$connectTimeoutMillis;
                Long l2 = this.$socketTimeoutMillis;
                Long l3 = this.$requestTimeoutMillis;
                Long l4 = httpTimeoutConfig.get_connectTimeoutMillis();
                if (l4 != null) {
                    l = l4;
                }
                httpTimeoutConfig.setConnectTimeoutMillis(l);
                Long l5 = httpTimeoutConfig.get_socketTimeoutMillis();
                if (l5 != null) {
                    l2 = l5;
                }
                httpTimeoutConfig.setSocketTimeoutMillis(l2);
                Long l6 = httpTimeoutConfig.get_requestTimeoutMillis();
                if (l6 != null) {
                    l3 = l6;
                }
                httpTimeoutConfig.setRequestTimeoutMillis(l3);
                Long l7 = httpTimeoutConfig.get_requestTimeoutMillis();
                if (l7 != null && l7.longValue() != Long.MAX_VALUE) {
                    httpRequestBuilder.getExecutionContext().invokeOnCompletion(new HttpRequestLifecycleKt$$ExternalSyntheticLambda1(BuildersKt__Builders_commonKt.launch$default(sender, null, null, new HttpTimeoutKt$HttpTimeout$2$1$1$killer$1(l7, httpRequestBuilder, httpRequestBuilder.getExecutionContext(), null), 3, null), i2));
                }
            }
            this.L$0 = null;
            this.label = 2;
            Object objProceed2 = sender.proceed(httpRequestBuilder, this);
            if (objProceed2 != coroutine_suspended) {
                return objProceed2;
            }
        }
        return coroutine_suspended;
    }
}
