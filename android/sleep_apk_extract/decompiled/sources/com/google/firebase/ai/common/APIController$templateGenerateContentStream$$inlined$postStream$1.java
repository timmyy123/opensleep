package com.google.firebase.ai.common;

import com.google.firebase.ai.common.util.KtorKt;
import com.google.firebase.ai.type.GenerateContentResponse;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.json.Json;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "R", "Lcom/google/firebase/ai/type/Response;", "Lkotlinx/coroutines/channels/ProducerScope;", "com/google/firebase/ai/common/APIController$postStream$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$postStream$1", f = "APIController.kt", l = {}, m = "invokeSuspend")
public final class APIController$templateGenerateContentStream$$inlined$postStream$1 extends SuspendLambda implements Function2<ProducerScope<? super GenerateContentResponse.Internal>, Continuation<? super Unit>, Object> {
    final /* synthetic */ TemplateGenerateContentRequest $request$inlined;
    final /* synthetic */ HttpClient $this_postStream;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ APIController this$0;
    final /* synthetic */ APIController this$0$inline_fun;

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$postStream$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/google/firebase/ai/common/APIController$postStream$2$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$postStream$1$1", f = "APIController.kt", l = {343, 346}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProducerScope<GenerateContentResponse.Internal> $$this$channelFlow;
        final /* synthetic */ TemplateGenerateContentRequest $request$inlined;
        final /* synthetic */ HttpClient $this_postStream;
        final /* synthetic */ String $url;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ APIController this$0;
        final /* synthetic */ APIController this$0$inline_fun;

        /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$postStream$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "it", "Lio/ktor/client/statement/HttpResponse;", "com/google/firebase/ai/common/APIController$postStream$2$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.google.firebase.ai.common.APIController$postStream$2$1$2", f = "APIController.kt", l = {347, 349, 352}, m = "invokeSuspend")
        public static final class C00151 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProducerScope<GenerateContentResponse.Internal> $$this$channelFlow;
            /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$postStream$1$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "com/google/firebase/ai/common/util/KtorKt$decodeToFlow$1", "com/google/firebase/ai/common/APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.google.firebase.ai.common.util.KtorKt$decodeToFlow$1", f = "ktor.kt", l = {82}, m = "invokeSuspend")
            public static final class C00161 extends SuspendLambda implements Function2<ProducerScope<? super GenerateContentResponse.Internal>, Continuation<? super Unit>, Object> {
                final /* synthetic */ ByteReadChannel $channel;
                final /* synthetic */ Json $this_decodeToFlow;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$postStream$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "", "com/google/firebase/ai/common/util/KtorKt$decodeToFlow$1$1", "com/google/firebase/ai/common/APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "com.google.firebase.ai.common.util.KtorKt$decodeToFlow$1$1", f = "ktor.kt", l = {84}, m = "invokeSuspend")
                public static final class C00171 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ProducerScope<GenerateContentResponse.Internal> $$this$channelFlow;
                    final /* synthetic */ Json $this_decodeToFlow;
                    /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C00171(ProducerScope producerScope, Json json, Continuation continuation) {
                        super(2, continuation);
                        this.$this_decodeToFlow = json;
                        this.$$this$channelFlow = producerScope;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00171 c00171 = new C00171(this.$$this$channelFlow, this.$this_decodeToFlow, continuation);
                        c00171.L$0 = obj;
                        return c00171;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(String str, Continuation<? super Unit> continuation) {
                        return ((C00171) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$postStream$1$1$1$1$1 for r5v3 'this'  kotlin.coroutines.Continuation
                        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                        */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                        /*
                            r5 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r5.label
                            r2 = 1
                            if (r1 == 0) goto L16
                            if (r1 != r2) goto Lf
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L3d
                        Lf:
                            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                            okio.Utf8$$ExternalSyntheticBUOutline0.m$3(r5)
                            r5 = 0
                            return r5
                        L16:
                            kotlin.ResultKt.throwOnFailure(r6)
                            java.lang.Object r6 = r5.L$0
                            java.lang.String r6 = (java.lang.String) r6
                            java.lang.String r1 = "data:"
                            java.lang.String r6 = kotlin.text.StringsKt.removePrefix(r6, r1)
                            kotlinx.coroutines.channels.ProducerScope<com.google.firebase.ai.type.GenerateContentResponse$Internal> r1 = r5.$$this$channelFlow
                            kotlinx.serialization.json.Json r3 = r5.$this_decodeToFlow
                            r3.getSerializersModule()
                            com.google.firebase.ai.type.GenerateContentResponse$Internal$Companion r4 = com.google.firebase.ai.type.GenerateContentResponse.Internal.INSTANCE
                            kotlinx.serialization.KSerializer r4 = r4.serializer()
                            java.lang.Object r6 = r3.decodeFromString(r4, r6)
                            r5.label = r2
                            java.lang.Object r5 = r1.send(r6, r5)
                            if (r5 != r0) goto L3d
                            return r0
                        L3d:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$postStream$1.AnonymousClass1.C00151.C00161.C00171.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00161(ByteReadChannel byteReadChannel, Json json, Continuation continuation) {
                    super(2, continuation);
                    this.$channel = byteReadChannel;
                    this.$this_decodeToFlow = json;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00161 c00161 = new C00161(this.$channel, this.$this_decodeToFlow, continuation);
                    c00161.L$0 = obj;
                    return c00161;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ProducerScope<? super GenerateContentResponse.Internal> producerScope, Continuation<? super Unit> continuation) {
                    return ((C00161) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ProducerScope producerScope = (ProducerScope) this.L$0;
                        ByteReadChannel byteReadChannel = this.$channel;
                        C00171 c00171 = new C00171(producerScope, this.$this_decodeToFlow, null);
                        this.label = 1;
                        if (KtorKt.onEachLine(byteReadChannel, c00171, this) == coroutine_suspended) {
                            return coroutine_suspended;
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00151(ProducerScope producerScope, Continuation continuation) {
                super(2, continuation);
                this.$$this$channelFlow = producerScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00151 c00151 = new C00151(this.$$this$channelFlow, continuation);
                c00151.L$0 = obj;
                return c00151;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
                return ((C00151) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
            
                if (r7.collect(r1, r6) != r0) goto L21;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) throws Throwable {
                HttpResponse httpResponse;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    httpResponse = (HttpResponse) this.L$0;
                    this.L$0 = httpResponse;
                    this.label = 1;
                    if (APIControllerKt.validateResponse(httpResponse, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    httpResponse = (HttpResponse) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Flow flowChannelFlow = FlowKt.channelFlow(new C00161((ByteReadChannel) obj, APIControllerKt.getJSON(), null));
                    final ProducerScope<GenerateContentResponse.Internal> producerScope = this.$$this$channelFlow;
                    FlowCollector flowCollector = new FlowCollector() { // from class: com.google.firebase.ai.common.APIController$templateGenerateContentStream$.inlined.postStream.1.1.1.2
                        public final Object emit(GenerateContentResponse.Internal internal, Continuation<? super Unit> continuation) {
                            Object objSend = producerScope.send(internal, continuation);
                            return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                        }

                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((GenerateContentResponse.Internal) obj2, (Continuation<? super Unit>) continuation);
                        }
                    };
                    this.label = 3;
                }
                this.L$0 = null;
                this.label = 2;
                obj = HttpResponseKt.bodyAsChannel(httpResponse, this);
                if (obj != coroutine_suspended) {
                    Flow flowChannelFlow2 = FlowKt.channelFlow(new C00161((ByteReadChannel) obj, APIControllerKt.getJSON(), null));
                    final ProducerScope producerScope2 = this.$$this$channelFlow;
                    FlowCollector flowCollector2 = new FlowCollector() { // from class: com.google.firebase.ai.common.APIController$templateGenerateContentStream$.inlined.postStream.1.1.1.2
                        public final Object emit(GenerateContentResponse.Internal internal, Continuation<? super Unit> continuation) {
                            Object objSend = producerScope2.send(internal, continuation);
                            return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                        }

                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((GenerateContentResponse.Internal) obj2, (Continuation<? super Unit>) continuation);
                        }
                    };
                    this.label = 3;
                }
                return coroutine_suspended;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HttpClient httpClient, String str, APIController aPIController, ProducerScope producerScope, Continuation continuation, APIController aPIController2, TemplateGenerateContentRequest templateGenerateContentRequest) {
            super(2, continuation);
            this.$this_postStream = httpClient;
            this.$url = str;
            this.this$0$inline_fun = aPIController;
            this.this$0 = aPIController2;
            this.$request$inlined = templateGenerateContentRequest;
            this.$$this$channelFlow = producerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_postStream, this.$url, this.this$0$inline_fun, this.$$this$channelFlow, continuation, this.this$0, this.$request$inlined);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0073, code lost:
        
            if (r8.execute(r1, r7) == r0) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            HttpClient httpClient;
            HttpRequestBuilder httpRequestBuilder;
            HttpRequestBuilder httpRequestBuilder2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                httpClient = this.$this_postStream;
                String str = this.$url;
                APIController aPIController = this.this$0$inline_fun;
                HttpRequestBuilder httpRequestBuilder3 = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder3, str);
                this.L$0 = httpClient;
                this.L$1 = httpRequestBuilder3;
                this.L$2 = httpRequestBuilder3;
                this.label = 1;
                if (aPIController.applyHeaderProvider(httpRequestBuilder3, this) != coroutine_suspended) {
                    httpRequestBuilder = httpRequestBuilder3;
                    httpRequestBuilder2 = httpRequestBuilder;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            httpRequestBuilder = (HttpRequestBuilder) this.L$2;
            httpRequestBuilder2 = (HttpRequestBuilder) this.L$1;
            httpClient = (HttpClient) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.this$0.applyCommonConfiguration(httpRequestBuilder, this.$request$inlined);
            httpRequestBuilder2.setMethod(HttpMethod.INSTANCE.getPost());
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder2, httpClient);
            C00151 c00151 = new C00151(this.$$this$channelFlow, null);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APIController$templateGenerateContentStream$$inlined$postStream$1(HttpClient httpClient, String str, APIController aPIController, Continuation continuation, APIController aPIController2, TemplateGenerateContentRequest templateGenerateContentRequest) {
        super(2, continuation);
        this.$this_postStream = httpClient;
        this.$url = str;
        this.this$0$inline_fun = aPIController;
        this.this$0 = aPIController2;
        this.$request$inlined = templateGenerateContentRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        APIController$templateGenerateContentStream$$inlined$postStream$1 aPIController$templateGenerateContentStream$$inlined$postStream$1 = new APIController$templateGenerateContentStream$$inlined$postStream$1(this.$this_postStream, this.$url, this.this$0$inline_fun, continuation, this.this$0, this.$request$inlined);
        aPIController$templateGenerateContentStream$$inlined$postStream$1.L$0 = obj;
        return aPIController$templateGenerateContentStream$$inlined$postStream$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super GenerateContentResponse.Internal> producerScope, Continuation<? super Unit> continuation) {
        return ((APIController$templateGenerateContentStream$$inlined$postStream$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        ProducerScope producerScope = (ProducerScope) this.L$0;
        BuildersKt__Builders_commonKt.launch$default(producerScope, new CoroutineName("postStream"), null, new AnonymousClass1(this.$this_postStream, this.$url, this.this$0$inline_fun, producerScope, null, this.this$0, this.$request$inlined), 2, null);
        return Unit.INSTANCE;
    }
}
