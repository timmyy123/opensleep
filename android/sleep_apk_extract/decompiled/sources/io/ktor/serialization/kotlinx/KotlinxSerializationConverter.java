package io.ktor.serialization.kotlinx;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.JsonConvertException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.io.Source;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.StringFormat;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015JA\u0010\u0019\u001a\u00020\u00182\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxSerializationConverter;", "Lio/ktor/serialization/ContentConverter;", "Lkotlinx/serialization/SerialFormat;", "format", "<init>", "(Lkotlinx/serialization/SerialFormat;)V", "Lio/ktor/http/ContentType;", "contentType", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "", SDKConstants.PARAM_VALUE, "Lio/ktor/http/content/OutgoingContent;", "serialize", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "content", "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/serialization/KSerializer;", "serializer", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "serializeContent", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/SerialFormat;Ljava/lang/Object;Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;)Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "Lkotlinx/serialization/SerialFormat;", "", "Lio/ktor/serialization/kotlinx/KotlinxSerializationExtension;", "extensions", "Ljava/util/List;", "ktor-serialization-kotlinx"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KotlinxSerializationConverter implements ContentConverter {
    private final List<KotlinxSerializationExtension> extensions;
    private final SerialFormat format;

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", l = {61, 65}, m = "deserialize")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationConverter.this.deserialize(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", l = {46}, m = "serialize")
    public static final class C22551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C22551(Continuation<? super C22551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationConverter.this.serialize(null, null, null, null, this);
        }
    }

    public KotlinxSerializationConverter(SerialFormat serialFormat) {
        serialFormat.getClass();
        this.format = serialFormat;
        this.extensions = ExtensionsKt.extensions(serialFormat);
        if (serialFormat instanceof StringFormat) {
            return;
        }
        Home$$ExternalSyntheticBUOutline0.m("Only binary and string formats are supported, ", serialFormat, " is not supported.");
        throw null;
    }

    private final OutgoingContent.ByteArrayContent serializeContent(KSerializer<?> serializer, SerialFormat format, Object value, ContentType contentType, Charset charset) {
        if (format instanceof StringFormat) {
            serializer.getClass();
            return new TextContent(((StringFormat) format).encodeToString(serializer, value), ContentTypesKt.withCharsetIfNeeded(contentType, charset), null, 4, null);
        }
        Utf8$$ExternalSyntheticBUOutline0.m("Unsupported format ", format);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8 A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:30:0x00b2, B:32:0x00b8, B:34:0x00c4, B:35:0x00e0), top: B:39:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c4 A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:30:0x00b2, B:32:0x00b8, B:34:0x00c4, B:35:0x00e0), top: B:39:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deserialize(final Charset charset, final TypeInfo typeInfo, final ByteReadChannel byteReadChannel, Continuation<Object> continuation) throws JsonConvertException {
        AnonymousClass1 anonymousClass1;
        KotlinxSerializationConverter kotlinxSerializationConverter;
        KSerializer<?> kSerializer;
        SerialFormat serialFormat;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objFirstOrNull = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            final Flow flowAsFlow = FlowKt.asFlow(this.extensions);
            Flow<Object> flow = new Flow<Object>() { // from class: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1

                /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1$2, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ Charset $charset$inlined;
                    final /* synthetic */ ByteReadChannel $content$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ TypeInfo $typeInfo$inlined;

                    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$$inlined$map$1$2", f = "KotlinxSerializationConverter.kt", l = {51, 50}, m = "emit")
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$charset$inlined = charset;
                        this.$typeInfo$inlined = typeInfo;
                        this.$content$inlined = byteReadChannel;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                    
                        if (r8.emit(r10, r0) == r1) goto L22;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        FlowCollector flowCollector;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                        }
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i2 = anonymousClass1.label;
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector2 = this.$this_unsafeFlow;
                            Charset charset = this.$charset$inlined;
                            TypeInfo typeInfo = this.$typeInfo$inlined;
                            ByteReadChannel byteReadChannel = this.$content$inlined;
                            anonymousClass1.L$0 = flowCollector2;
                            anonymousClass1.label = 1;
                            Object objDeserialize = ((KotlinxSerializationExtension) obj).deserialize(charset, typeInfo, byteReadChannel, anonymousClass1);
                            if (objDeserialize != coroutine_suspended) {
                                obj2 = objDeserialize;
                                flowCollector = flowCollector2;
                            }
                            return coroutine_suspended;
                        }
                        if (i2 != 1) {
                            if (i2 == 2) {
                                ResultKt.throwOnFailure(obj2);
                                return Unit.INSTANCE;
                            }
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        flowCollector = flowCollector3;
                        anonymousClass1.L$0 = null;
                        anonymousClass1.label = 2;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Object> flowCollector, Continuation continuation2) {
                    Object objCollect = flowAsFlow.collect(new AnonymousClass2(flowCollector, charset, typeInfo, byteReadChannel), continuation2);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
            KotlinxSerializationConverter$deserialize$fromExtension$2 kotlinxSerializationConverter$deserialize$fromExtension$2 = new KotlinxSerializationConverter$deserialize$fromExtension$2(byteReadChannel, null);
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = charset;
            anonymousClass1.L$2 = typeInfo;
            anonymousClass1.L$3 = byteReadChannel;
            anonymousClass1.label = 1;
            objFirstOrNull = FlowKt.firstOrNull(flow, kotlinxSerializationConverter$deserialize$fromExtension$2, anonymousClass1);
            if (objFirstOrNull != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            kSerializer = (KSerializer) anonymousClass1.L$2;
            charset = (Charset) anonymousClass1.L$1;
            kotlinxSerializationConverter = (KotlinxSerializationConverter) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objFirstOrNull);
            Source source = (Source) objFirstOrNull;
            try {
                serialFormat = kotlinxSerializationConverter.format;
                if (!(serialFormat instanceof StringFormat)) {
                    return ((StringFormat) serialFormat).decodeFromString(kSerializer, StringsKt.readText$default(source, charset, 0, 2, null));
                }
                ByteReadPacketKt.discard$default(source, 0L, 1, null);
                throw new IllegalStateException(("Unsupported format " + kotlinxSerializationConverter.format).toString());
            } catch (Throwable th) {
                throw new JsonConvertException("Illegal input: " + th.getMessage(), th);
            }
        }
        byteReadChannel = (ByteReadChannel) anonymousClass1.L$3;
        typeInfo = (TypeInfo) anonymousClass1.L$2;
        charset = (Charset) anonymousClass1.L$1;
        this = (KotlinxSerializationConverter) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objFirstOrNull);
        if (!this.extensions.isEmpty() && (objFirstOrNull != null || byteReadChannel.isClosedForRead())) {
            return objFirstOrNull;
        }
        KSerializer<?> kSerializerSerializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(this.format.getSerializersModule(), typeInfo);
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = charset;
        anonymousClass1.L$2 = kSerializerSerializerForTypeInfo;
        anonymousClass1.L$3 = null;
        anonymousClass1.label = 2;
        objFirstOrNull = ByteReadChannelOperationsKt.readRemaining(byteReadChannel, anonymousClass1);
        if (objFirstOrNull != coroutine_suspended) {
            kotlinxSerializationConverter = this;
            kSerializer = kSerializerSerializerForTypeInfo;
            Source source2 = (Source) objFirstOrNull;
            serialFormat = kotlinxSerializationConverter.format;
            if (!(serialFormat instanceof StringFormat)) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object serialize(final ContentType contentType, final Charset charset, final TypeInfo typeInfo, Object obj, Continuation<? super OutgoingContent> continuation) {
        C22551 c22551;
        final Object obj2;
        TypeInfo typeInfo2;
        KSerializer<?> kSerializerGuessSerializer;
        if (continuation instanceof C22551) {
            c22551 = (C22551) continuation;
            int i = c22551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22551.label = i - Integer.MIN_VALUE;
            } else {
                c22551 = new C22551(continuation);
            }
        }
        Object objFirstOrNull = c22551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22551.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            final Flow flowAsFlow = FlowKt.asFlow(this.extensions);
            obj2 = obj;
            Flow<OutgoingContent> flow = new Flow<OutgoingContent>() { // from class: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1

                /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ Charset $charset$inlined;
                    final /* synthetic */ ContentType $contentType$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ TypeInfo $typeInfo$inlined;
                    final /* synthetic */ Object $value$inlined;

                    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2", f = "KotlinxSerializationConverter.kt", l = {51, 50}, m = "emit")
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$contentType$inlined = contentType;
                        this.$charset$inlined = charset;
                        this.$typeInfo$inlined = typeInfo;
                        this.$value$inlined = obj;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
                    
                        if (r10.emit(r12, r6) == r0) goto L23;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        FlowCollector flowCollector;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i = anonymousClass1.label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                        }
                        AnonymousClass1 anonymousClass12 = anonymousClass1;
                        Object obj2 = anonymousClass12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i2 = anonymousClass12.label;
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector2 = this.$this_unsafeFlow;
                            ContentType contentType = this.$contentType$inlined;
                            Charset charset = this.$charset$inlined;
                            TypeInfo typeInfo = this.$typeInfo$inlined;
                            Object obj3 = this.$value$inlined;
                            anonymousClass12.L$0 = flowCollector2;
                            anonymousClass12.label = 1;
                            Object objSerialize = ((KotlinxSerializationExtension) obj).serialize(contentType, charset, typeInfo, obj3, anonymousClass12);
                            if (objSerialize != coroutine_suspended) {
                                obj2 = objSerialize;
                                flowCollector = flowCollector2;
                            }
                            return coroutine_suspended;
                        }
                        if (i2 != 1) {
                            if (i2 == 2) {
                                ResultKt.throwOnFailure(obj2);
                                return Unit.INSTANCE;
                            }
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        FlowCollector flowCollector3 = (FlowCollector) anonymousClass12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        flowCollector = flowCollector3;
                        anonymousClass12.L$0 = null;
                        anonymousClass12.label = 2;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super OutgoingContent> flowCollector, Continuation continuation2) {
                    Object objCollect = flowAsFlow.collect(new AnonymousClass2(flowCollector, contentType, charset, typeInfo, obj2), continuation2);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
            KotlinxSerializationConverter$serialize$fromExtension$2 kotlinxSerializationConverter$serialize$fromExtension$2 = new KotlinxSerializationConverter$serialize$fromExtension$2(null);
            c22551.L$0 = this;
            c22551.L$1 = contentType;
            c22551.L$2 = charset;
            c22551.L$3 = typeInfo;
            c22551.L$4 = obj2;
            c22551.label = 1;
            objFirstOrNull = FlowKt.firstOrNull(flow, kotlinxSerializationConverter$serialize$fromExtension$2, c22551);
            if (objFirstOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            typeInfo2 = typeInfo;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Object obj3 = c22551.L$4;
            TypeInfo typeInfo3 = (TypeInfo) c22551.L$3;
            charset = (Charset) c22551.L$2;
            ContentType contentType2 = (ContentType) c22551.L$1;
            KotlinxSerializationConverter kotlinxSerializationConverter = (KotlinxSerializationConverter) c22551.L$0;
            ResultKt.throwOnFailure(objFirstOrNull);
            obj2 = obj3;
            typeInfo2 = typeInfo3;
            this = kotlinxSerializationConverter;
            contentType = contentType2;
        }
        OutgoingContent outgoingContent = (OutgoingContent) objFirstOrNull;
        if (outgoingContent != null) {
            return outgoingContent;
        }
        try {
            kSerializerGuessSerializer = SerializerLookupKt.serializerForTypeInfo(this.format.getSerializersModule(), typeInfo2);
        } catch (SerializationException unused) {
            kSerializerGuessSerializer = SerializerLookupKt.guessSerializer(obj2, this.format.getSerializersModule());
        }
        return this.serializeContent(kSerializerGuessSerializer, this.format, obj2, contentType, charset);
    }
}
