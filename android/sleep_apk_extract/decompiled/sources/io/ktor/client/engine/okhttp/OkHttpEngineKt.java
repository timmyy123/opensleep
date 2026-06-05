package io.ktor.client.engine.okhttp;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.engine.okhttp.OkHttpEngineKt;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLParserKt$$ExternalSyntheticLambda0;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import io.ktor.http.Url$$ExternalSyntheticLambda1;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperations_jvmKt;
import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.JobKt;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import okio.BufferedSource;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0013\u001a\u00020\u0012*\u00020\u00112\u0006\u0010\r\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0018\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lokio/BufferedSource;", "Lkotlin/coroutines/CoroutineContext;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lio/ktor/client/request/HttpRequestData;", "requestData", "Lio/ktor/utils/io/ByteReadChannel;", "toChannel", "(Lokio/BufferedSource;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/request/HttpRequestData;)Lio/ktor/utils/io/ByteReadChannel;", "", "cause", "request", "mapExceptions", "(Ljava/lang/Throwable;Lio/ktor/client/request/HttpRequestData;)Ljava/lang/Throwable;", "callContext", "Lokhttp3/Request;", "convertToOkHttpRequest", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/CoroutineContext;)Lokhttp3/Request;", "Lio/ktor/http/content/OutgoingContent;", "Lokhttp3/RequestBody;", "convertToOkHttpBody", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/CoroutineContext;)Lokhttp3/RequestBody;", "Lokhttp3/OkHttpClient$Builder;", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "timeoutAttributes", "setupTimeoutAttributes", "(Lokhttp3/OkHttpClient$Builder;Lio/ktor/client/plugins/HttpTimeoutConfig;)Lokhttp3/OkHttpClient$Builder;", "ktor-client-okhttp"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class OkHttpEngineKt {

    /* JADX INFO: renamed from: io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1", f = "OkHttpEngine.kt", l = {170, 179}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $context;
        final /* synthetic */ HttpRequestData $requestData;
        final /* synthetic */ BufferedSource $this_toChannel;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_toChannel = bufferedSource;
            this.$context = coroutineContext;
            this.$requestData = httpRequestData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2$lambda$1(Ref$IntRef ref$IntRef, BufferedSource bufferedSource, HttpRequestData httpRequestData, CoroutineContext coroutineContext, ByteBuffer byteBuffer) throws Throwable {
            Object objM2357constructorimpl;
            try {
                ref$IntRef.element = bufferedSource.read(byteBuffer);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM2357constructorimpl = Result.m2357constructorimpl(JobKt.getJob(coroutineContext).getCancellationException());
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM2357constructorimpl = Result.m2357constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m2362isFailureimpl(objM2357constructorimpl)) {
                    objM2357constructorimpl = null;
                }
                CancellationException cancellationException = (CancellationException) objM2357constructorimpl;
                if (cancellationException != null) {
                    th = cancellationException;
                }
                throw OkHttpEngineKt.mapExceptions(th, httpRequestData);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_toChannel, this.$context, this.$requestData, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00bc, code lost:
        
            if (r11.flush(r16) != r6) goto L8;
         */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00bc -> B:8:0x002c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            Closeable closeable;
            WriterScope writerScope;
            final CoroutineContext coroutineContext;
            final HttpRequestData httpRequestData;
            final Ref$IntRef ref$IntRef;
            final BufferedSource bufferedSource;
            Closeable closeable2;
            CoroutineContext coroutineContext2;
            HttpRequestData httpRequestData2;
            BufferedSource bufferedSource2;
            Ref$IntRef ref$IntRef2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            Throwable th2 = null;
            try {
            } catch (Throwable th3) {
                th = th3;
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WriterScope writerScope2 = (WriterScope) this.L$0;
                BufferedSource bufferedSource3 = this.$this_toChannel;
                CoroutineContext coroutineContext3 = this.$context;
                writerScope = writerScope2;
                coroutineContext = coroutineContext3;
                httpRequestData = this.$requestData;
                ref$IntRef = new Ref$IntRef();
                bufferedSource = bufferedSource3;
                closeable2 = bufferedSource;
                if (!bufferedSource.isOpen()) {
                }
                Unit unit = Unit.INSTANCE;
                if (closeable2 != null) {
                }
                if (th2 != null) {
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ref$IntRef2 = (Ref$IntRef) this.L$5;
                    bufferedSource2 = (BufferedSource) this.L$4;
                    httpRequestData2 = (HttpRequestData) this.L$3;
                    coroutineContext2 = (CoroutineContext) this.L$2;
                    closeable = (Closeable) this.L$1;
                    writerScope = (WriterScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ref$IntRef = ref$IntRef2;
                    bufferedSource = bufferedSource2;
                    httpRequestData = httpRequestData2;
                    coroutineContext = coroutineContext2;
                    closeable2 = closeable;
                    try {
                        if (!bufferedSource.isOpen() && JobKt.isActive(coroutineContext) && ref$IntRef.element >= 0) {
                            ByteWriteChannel channel = writerScope.getChannel();
                            Function1 function1 = new Function1() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return OkHttpEngineKt.AnonymousClass1.invokeSuspend$lambda$2$lambda$1(ref$IntRef, bufferedSource, httpRequestData, coroutineContext, (ByteBuffer) obj2);
                                }
                            };
                            this.L$0 = writerScope;
                            this.L$1 = closeable2;
                            this.L$2 = coroutineContext;
                            this.L$3 = httpRequestData;
                            this.L$4 = bufferedSource;
                            this.L$5 = ref$IntRef;
                            this.label = 1;
                            if (ByteWriteChannelOperations_jvmKt.write$default(channel, 0, function1, this, 1, null) != coroutine_suspended) {
                                coroutineContext2 = coroutineContext;
                                httpRequestData2 = httpRequestData;
                                ref$IntRef2 = ref$IntRef;
                                bufferedSource2 = bufferedSource;
                                closeable = closeable2;
                                ByteWriteChannel channel2 = writerScope.getChannel();
                                this.L$0 = writerScope;
                                this.L$1 = closeable;
                                this.L$2 = coroutineContext2;
                                this.L$3 = httpRequestData2;
                                this.L$4 = bufferedSource2;
                                this.L$5 = ref$IntRef2;
                                this.label = 2;
                            }
                            return coroutine_suspended;
                        }
                        Unit unit2 = Unit.INSTANCE;
                        if (closeable2 != null) {
                            try {
                                closeable2.close();
                            } catch (Throwable th4) {
                                th2 = th4;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        closeable = closeable2;
                        if (closeable != null) {
                            try {
                                closeable.close();
                            } catch (Throwable th6) {
                                ExceptionsKt.addSuppressed(th, th6);
                            }
                        }
                        th2 = th;
                    }
                    if (th2 != null) {
                        return Unit.INSTANCE;
                    }
                    throw th2;
                }
                ref$IntRef2 = (Ref$IntRef) this.L$5;
                bufferedSource2 = (BufferedSource) this.L$4;
                httpRequestData2 = (HttpRequestData) this.L$3;
                coroutineContext2 = (CoroutineContext) this.L$2;
                closeable = (Closeable) this.L$1;
                writerScope = (WriterScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                ByteWriteChannel channel22 = writerScope.getChannel();
                this.L$0 = writerScope;
                this.L$1 = closeable;
                this.L$2 = coroutineContext2;
                this.L$3 = httpRequestData2;
                this.L$4 = bufferedSource2;
                this.L$5 = ref$IntRef2;
                this.label = 2;
            }
        }
    }

    public static final RequestBody convertToOkHttpBody(OutgoingContent outgoingContent, CoroutineContext coroutineContext) {
        outgoingContent.getClass();
        coroutineContext.getClass();
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            byte[] bArrBytes = ((OutgoingContent.ByteArrayContent) outgoingContent).getBytes();
            return RequestBody.INSTANCE.create(bArrBytes, MediaType.INSTANCE.parse(String.valueOf(outgoingContent.getContentType())), 0, bArrBytes.length);
        }
        if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new StreamRequestBody(outgoingContent.getContentLength(), new Url$$ExternalSyntheticLambda0((OutgoingContent.ReadChannelContent) outgoingContent, 20));
        }
        if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            return new StreamRequestBody(outgoingContent.getContentLength(), new Url$$ExternalSyntheticLambda1(coroutineContext, (OutgoingContent.WriteChannelContent) outgoingContent, 9));
        }
        if (outgoingContent instanceof OutgoingContent.NoContent) {
            return RequestBody.INSTANCE.create(new byte[0], null, 0, 0);
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel convertToOkHttpBody$lambda$3(OutgoingContent outgoingContent) {
        return ((OutgoingContent.ReadChannelContent) outgoingContent).readFrom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel convertToOkHttpBody$lambda$4(CoroutineContext coroutineContext, OutgoingContent outgoingContent) {
        return ByteWriteChannelOperationsKt.writer$default(GlobalScope.INSTANCE, coroutineContext, false, new OkHttpEngineKt$convertToOkHttpBody$3$1(outgoingContent, null), 2, null).getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request convertToOkHttpRequest(HttpRequestData httpRequestData, CoroutineContext coroutineContext) {
        Request.Builder builder = new Request.Builder();
        builder.url(httpRequestData.getUrl().getUrlString());
        UtilsKt.mergeHeaders(httpRequestData.getHeaders(), httpRequestData.getBody(), new URLParserKt$$ExternalSyntheticLambda0(builder, 3));
        builder.method(httpRequestData.getMethod().getValue(), HttpMethod.permitsRequestBody(httpRequestData.getMethod().getValue()) ? convertToOkHttpBody(httpRequestData.getBody(), coroutineContext) : null);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convertToOkHttpRequest$lambda$1$lambda$0(Request.Builder builder, String str, String str2) {
        str.getClass();
        str2.getClass();
        if (Intrinsics.areEqual(str, HttpHeaders.INSTANCE.getContentLength())) {
            return Unit.INSTANCE;
        }
        builder.addHeader(str, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapExceptions(Throwable th, HttpRequestData httpRequestData) {
        return th instanceof SocketTimeoutException ? HttpTimeoutKt.SocketTimeoutException(httpRequestData, th) : th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient.Builder setupTimeoutAttributes(OkHttpClient.Builder builder, HttpTimeoutConfig httpTimeoutConfig) {
        Long connectTimeoutMillis = httpTimeoutConfig.get_connectTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (connectTimeoutMillis != null) {
            builder.connectTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(connectTimeoutMillis.longValue()), timeUnit);
        }
        Long socketTimeoutMillis = httpTimeoutConfig.get_socketTimeoutMillis();
        if (socketTimeoutMillis != null) {
            long jLongValue = socketTimeoutMillis.longValue();
            builder.readTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(jLongValue), timeUnit);
            builder.writeTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(jLongValue), timeUnit);
        }
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel toChannel(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData) {
        return ByteWriteChannelOperationsKt.writer$default(GlobalScope.INSTANCE, coroutineContext, false, new AnonymousClass1(bufferedSource, coroutineContext, httpRequestData, null), 2, null).getChannel();
    }
}
