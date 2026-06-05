package io.ktor.client.plugins;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.DeprecationKt;
import io.ktor.utils.io.WriterJob;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.io.Source;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a!\u0010\u0007\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0018\u0010\u000b\u001a\u00060\tj\u0002`\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/HttpClient;", "", "defaultTransformers", "(Lio/ktor/client/HttpClient;)V", "", "contentLength", "bytes", "checkContentLength", "(Ljava/lang/Long;J)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class DefaultTransformKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.defaultTransformers");

    /* JADX INFO: renamed from: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", SDKConstants.PARAM_A2U_BODY}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1", f = "DefaultTransform.kt", l = {56}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            OutgoingContent outgoingContentPlatformRequestDefaultTransform;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final PipelineContext pipelineContext = (PipelineContext) this.L$0;
                final Object obj2 = this.L$1;
                HeadersBuilder headers = ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders();
                HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
                if (headers.get(httpHeaders.getAccept()) == null) {
                    ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().append(httpHeaders.getAccept(), "*/*");
                }
                final ContentType contentType = HttpMessagePropertiesKt.contentType((HttpMessageBuilder) pipelineContext.getContext());
                if (obj2 instanceof String) {
                    String str = (String) obj2;
                    if (contentType == null) {
                        contentType = ContentType.Text.INSTANCE.getPlain();
                    }
                    outgoingContentPlatformRequestDefaultTransform = new TextContent(str, contentType, null, 4, null);
                } else {
                    outgoingContentPlatformRequestDefaultTransform = obj2 instanceof byte[] ? new OutgoingContent.ByteArrayContent(contentType, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1
                        final /* synthetic */ Object $body;
                        private final long contentLength;
                        private final ContentType contentType;

                        {
                            this.$body = obj2;
                            this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                            this.contentLength = ((byte[]) obj2).length;
                        }

                        @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                        /* JADX INFO: renamed from: bytes */
                        public byte[] getBytes() {
                            return (byte[]) this.$body;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public Long getContentLength() {
                            return Long.valueOf(this.contentLength);
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public ContentType getContentType() {
                            return this.contentType;
                        }
                    } : obj2 instanceof ByteReadChannel ? new OutgoingContent.ReadChannelContent(pipelineContext, contentType, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2
                        final /* synthetic */ Object $body;
                        private final Long contentLength;
                        private final ContentType contentType;

                        {
                            this.$body = obj2;
                            String str2 = pipelineContext.getContext().getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
                            this.contentLength = str2 != null ? Long.valueOf(Long.parseLong(str2)) : null;
                            this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public Long getContentLength() {
                            return this.contentLength;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public ContentType getContentType() {
                            return this.contentType;
                        }

                        @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                        public ByteReadChannel readFrom() {
                            return (ByteReadChannel) this.$body;
                        }
                    } : obj2 instanceof OutgoingContent ? (OutgoingContent) obj2 : DefaultTransformersJvmKt.platformRequestDefaultTransform(contentType, (HttpRequestBuilder) pipelineContext.getContext(), obj2);
                }
                if ((outgoingContentPlatformRequestDefaultTransform != null ? outgoingContentPlatformRequestDefaultTransform.getContentType() : null) != null) {
                    ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().remove(httpHeaders.getContentType());
                    DefaultTransformKt.LOGGER.trace("Transformed with default transformers request body for " + ((HttpRequestBuilder) pipelineContext.getContext()).getUrl() + " from " + Reflection.getOrCreateKotlinClass(obj2.getClass()));
                    this.L$0 = null;
                    this.label = 1;
                    if (pipelineContext.proceedWith(outgoingContentPlatformRequestDefaultTransform, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<destruct>"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2", f = "DefaultTransform.kt", l = {67, 71, 71, 76, 76, 80, 87, 111, 116}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
        final /* synthetic */ HttpClient $this_defaultTransformers;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpClient httpClient, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$this_defaultTransformers = httpClient;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1$lambda$0(CompletableJob completableJob) {
            completableJob.complete();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_defaultTransformers, continuation);
            anonymousClass2.L$0 = pipelineContext;
            anonymousClass2.L$1 = httpResponseContainer;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x01a8  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01c1  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x027c  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0285  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            PipelineContext pipelineContext;
            TypeInfo expectedType;
            TypeInfo typeInfo;
            PipelineContext pipelineContext2;
            TypeInfo typeInfo2;
            PipelineContext pipelineContext3;
            PipelineContext pipelineContext4;
            TypeInfo typeInfo3;
            PipelineContext pipelineContext5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            HttpResponseContainer httpResponseContainer = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    pipelineContext = (PipelineContext) this.L$0;
                    HttpResponseContainer httpResponseContainer2 = (HttpResponseContainer) this.L$1;
                    expectedType = httpResponseContainer2.getExpectedType();
                    Object response = httpResponseContainer2.getResponse();
                    if (!(response instanceof ByteReadChannel)) {
                        return Unit.INSTANCE;
                    }
                    HttpResponse response2 = ((HttpClientCall) pipelineContext.getContext()).getResponse();
                    KClass<?> type = expectedType.getType();
                    if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Unit.class))) {
                        ByteReadChannelKt.cancel((ByteReadChannel) response);
                        HttpResponseContainer httpResponseContainer3 = new HttpResponseContainer(expectedType, Unit.INSTANCE);
                        this.L$0 = pipelineContext;
                        this.L$1 = expectedType;
                        this.label = 1;
                        obj = pipelineContext.proceedWith(httpResponseContainer3, this);
                        if (obj != coroutine_suspended) {
                            typeInfo2 = expectedType;
                            pipelineContext3 = pipelineContext;
                            httpResponseContainer = (HttpResponseContainer) obj;
                            pipelineContext = pipelineContext3;
                            expectedType = typeInfo2;
                            if (httpResponseContainer != null) {
                                DefaultTransformKt.LOGGER.trace("Transformed with default transformers response body for " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + " to " + expectedType.getType());
                            }
                            return Unit.INSTANCE;
                        }
                    } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        this.L$0 = pipelineContext;
                        this.L$1 = expectedType;
                        this.L$2 = pipelineContext;
                        this.L$3 = expectedType;
                        this.label = 2;
                        obj = ByteReadChannelOperationsKt.readRemaining((ByteReadChannel) response, this);
                        if (obj != coroutine_suspended) {
                            typeInfo3 = expectedType;
                            pipelineContext5 = pipelineContext;
                            HttpResponseContainer httpResponseContainer4 = new HttpResponseContainer(typeInfo3, Boxing.boxInt(Integer.parseInt(DeprecationKt.readText((Source) obj))));
                            this.L$0 = pipelineContext;
                            this.L$1 = expectedType;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 3;
                            obj = pipelineContext5.proceedWith(httpResponseContainer4, this);
                            if (obj != coroutine_suspended) {
                                typeInfo2 = expectedType;
                                pipelineContext3 = pipelineContext;
                                httpResponseContainer = (HttpResponseContainer) obj;
                                pipelineContext = pipelineContext3;
                                expectedType = typeInfo2;
                                if (httpResponseContainer != null) {
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Source.class)) || Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Source.class))) {
                        this.L$0 = pipelineContext;
                        this.L$1 = expectedType;
                        this.L$2 = pipelineContext;
                        this.L$3 = expectedType;
                        this.label = 4;
                        obj = ByteReadChannelOperationsKt.readRemaining((ByteReadChannel) response, this);
                        if (obj != coroutine_suspended) {
                            typeInfo = expectedType;
                            pipelineContext2 = pipelineContext;
                            HttpResponseContainer httpResponseContainer5 = new HttpResponseContainer(typeInfo, obj);
                            this.L$0 = pipelineContext;
                            this.L$1 = expectedType;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 5;
                            obj = pipelineContext2.proceedWith(httpResponseContainer5, this);
                            if (obj != coroutine_suspended) {
                                typeInfo2 = expectedType;
                                pipelineContext3 = pipelineContext;
                                httpResponseContainer = (HttpResponseContainer) obj;
                                pipelineContext = pipelineContext3;
                                expectedType = typeInfo2;
                                if (httpResponseContainer != null) {
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    } else if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(byte[].class))) {
                        this.L$0 = pipelineContext;
                        this.L$1 = expectedType;
                        this.label = 6;
                        obj = ByteReadChannelOperationsKt.toByteArray((ByteReadChannel) response, this);
                        if (obj != coroutine_suspended) {
                            pipelineContext4 = pipelineContext;
                            byte[] bArr = (byte[]) obj;
                            Long lContentLength = HttpMessagePropertiesKt.contentLength(((HttpClientCall) pipelineContext4.getContext()).getResponse());
                            if (!Intrinsics.areEqual(((HttpClientCall) pipelineContext4.getContext()).getRequest().getMethod(), HttpMethod.INSTANCE.getHead())) {
                                DefaultTransformKt.checkContentLength(lContentLength, bArr.length);
                            }
                            HttpResponseContainer httpResponseContainer6 = new HttpResponseContainer(expectedType, bArr);
                            this.L$0 = pipelineContext4;
                            this.L$1 = expectedType;
                            this.label = 7;
                            obj = pipelineContext4.proceedWith(httpResponseContainer6, this);
                            if (obj != coroutine_suspended) {
                                typeInfo2 = expectedType;
                                pipelineContext3 = pipelineContext4;
                                httpResponseContainer = (HttpResponseContainer) obj;
                                pipelineContext = pipelineContext3;
                                expectedType = typeInfo2;
                                if (httpResponseContainer != null) {
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ByteReadChannel.class))) {
                            if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(HttpStatusCode.class))) {
                                ByteReadChannelKt.cancel((ByteReadChannel) response);
                                HttpResponseContainer httpResponseContainer7 = new HttpResponseContainer(expectedType, response2.getStatus());
                                this.L$0 = pipelineContext;
                                this.L$1 = expectedType;
                                this.label = 9;
                                obj = pipelineContext.proceedWith(httpResponseContainer7, this);
                                if (obj != coroutine_suspended) {
                                    typeInfo2 = expectedType;
                                    pipelineContext3 = pipelineContext;
                                    httpResponseContainer = (HttpResponseContainer) obj;
                                    pipelineContext = pipelineContext3;
                                    expectedType = typeInfo2;
                                }
                            }
                            if (httpResponseContainer != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        CompletableJob completableJobJob = JobKt.Job((Job) response2.getCoroutineContext().get(Job.INSTANCE));
                        WriterJob writerJobWriter$default = ByteWriteChannelOperationsKt.writer$default(pipelineContext, this.$this_defaultTransformers.getCoroutineContext(), false, new DefaultTransformKt$defaultTransformers$2$result$channel$1(response, response2, null), 2, null);
                        ByteWriteChannelOperationsKt.invokeOnCompletion(writerJobWriter$default, new DefaultTransformKt$defaultTransformers$2$$ExternalSyntheticLambda0(completableJobJob, 0));
                        HttpResponseContainer httpResponseContainer8 = new HttpResponseContainer(expectedType, writerJobWriter$default.getChannel());
                        this.L$0 = pipelineContext;
                        this.L$1 = expectedType;
                        this.label = 8;
                        obj = pipelineContext.proceedWith(httpResponseContainer8, this);
                        if (obj != coroutine_suspended) {
                            typeInfo2 = expectedType;
                            pipelineContext3 = pipelineContext;
                            httpResponseContainer = (HttpResponseContainer) obj;
                            pipelineContext = pipelineContext3;
                            expectedType = typeInfo2;
                            if (httpResponseContainer != null) {
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    typeInfo2 = (TypeInfo) this.L$1;
                    pipelineContext3 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    httpResponseContainer = (HttpResponseContainer) obj;
                    pipelineContext = pipelineContext3;
                    expectedType = typeInfo2;
                    if (httpResponseContainer != null) {
                    }
                    return Unit.INSTANCE;
                case 2:
                    TypeInfo typeInfo4 = (TypeInfo) this.L$3;
                    PipelineContext pipelineContext6 = (PipelineContext) this.L$2;
                    TypeInfo typeInfo5 = (TypeInfo) this.L$1;
                    PipelineContext pipelineContext7 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    typeInfo3 = typeInfo4;
                    expectedType = typeInfo5;
                    pipelineContext5 = pipelineContext6;
                    pipelineContext = pipelineContext7;
                    HttpResponseContainer httpResponseContainer42 = new HttpResponseContainer(typeInfo3, Boxing.boxInt(Integer.parseInt(DeprecationKt.readText((Source) obj))));
                    this.L$0 = pipelineContext;
                    this.L$1 = expectedType;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 3;
                    obj = pipelineContext5.proceedWith(httpResponseContainer42, this);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 3:
                    typeInfo2 = (TypeInfo) this.L$1;
                    pipelineContext3 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    httpResponseContainer = (HttpResponseContainer) obj;
                    pipelineContext = pipelineContext3;
                    expectedType = typeInfo2;
                    if (httpResponseContainer != null) {
                    }
                    return Unit.INSTANCE;
                case 4:
                    TypeInfo typeInfo6 = (TypeInfo) this.L$3;
                    PipelineContext pipelineContext8 = (PipelineContext) this.L$2;
                    TypeInfo typeInfo7 = (TypeInfo) this.L$1;
                    PipelineContext pipelineContext9 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    typeInfo = typeInfo6;
                    expectedType = typeInfo7;
                    pipelineContext2 = pipelineContext8;
                    pipelineContext = pipelineContext9;
                    HttpResponseContainer httpResponseContainer52 = new HttpResponseContainer(typeInfo, obj);
                    this.L$0 = pipelineContext;
                    this.L$1 = expectedType;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 5;
                    obj = pipelineContext2.proceedWith(httpResponseContainer52, this);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 5:
                    typeInfo2 = (TypeInfo) this.L$1;
                    pipelineContext3 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    httpResponseContainer = (HttpResponseContainer) obj;
                    pipelineContext = pipelineContext3;
                    expectedType = typeInfo2;
                    if (httpResponseContainer != null) {
                    }
                    return Unit.INSTANCE;
                case 6:
                    expectedType = (TypeInfo) this.L$1;
                    pipelineContext4 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    byte[] bArr2 = (byte[]) obj;
                    Long lContentLength2 = HttpMessagePropertiesKt.contentLength(((HttpClientCall) pipelineContext4.getContext()).getResponse());
                    if (!Intrinsics.areEqual(((HttpClientCall) pipelineContext4.getContext()).getRequest().getMethod(), HttpMethod.INSTANCE.getHead())) {
                    }
                    HttpResponseContainer httpResponseContainer62 = new HttpResponseContainer(expectedType, bArr2);
                    this.L$0 = pipelineContext4;
                    this.L$1 = expectedType;
                    this.label = 7;
                    obj = pipelineContext4.proceedWith(httpResponseContainer62, this);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 7:
                    typeInfo2 = (TypeInfo) this.L$1;
                    pipelineContext3 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    httpResponseContainer = (HttpResponseContainer) obj;
                    pipelineContext = pipelineContext3;
                    expectedType = typeInfo2;
                    if (httpResponseContainer != null) {
                    }
                    return Unit.INSTANCE;
                case 8:
                    typeInfo2 = (TypeInfo) this.L$1;
                    pipelineContext3 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    httpResponseContainer = (HttpResponseContainer) obj;
                    pipelineContext = pipelineContext3;
                    expectedType = typeInfo2;
                    if (httpResponseContainer != null) {
                    }
                    return Unit.INSTANCE;
                case 9:
                    typeInfo2 = (TypeInfo) this.L$1;
                    pipelineContext3 = (PipelineContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    httpResponseContainer = (HttpResponseContainer) obj;
                    pipelineContext = pipelineContext3;
                    expectedType = typeInfo2;
                    if (httpResponseContainer != null) {
                    }
                    return Unit.INSTANCE;
                default:
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkContentLength(Long l, long j) {
        if (l == null || l.longValue() == j) {
            return;
        }
        throw new IllegalStateException(("Content-Length mismatch: expected " + l + " bytes, but received " + j + " bytes").toString());
    }

    public static final void defaultTransformers(HttpClient httpClient) {
        httpClient.getClass();
        httpClient.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getRender(), new AnonymousClass1(null));
        httpClient.getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getParse(), new AnonymousClass2(httpClient, null));
        DefaultTransformersJvmKt.platformResponseDefaultTransformers(httpClient);
    }
}
