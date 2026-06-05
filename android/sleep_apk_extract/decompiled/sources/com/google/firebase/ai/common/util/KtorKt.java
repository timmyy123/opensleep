package com.google.firebase.ai.common.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.json.Json;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0080@¢\u0006\u0002\u0010\b\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0080\b\u001a\u001a\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0080@¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0013\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"onEachLine", "", "Lio/ktor/utils/io/ByteReadChannel;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decodeToFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/serialization/json/Json;", "channel", "send", "Lio/ktor/utils/io/ByteChannel;", "bytes", "", "(Lio/ktor/utils/io/ByteChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SSE_SEPARATOR", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KtorKt {
    public static final String SSE_SEPARATOR = "\r\n\r\n";

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.firebase.ai.common.util.KtorKt$decodeToFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 176)
    @DebugMetadata(c = "com.google.firebase.ai.common.util.KtorKt$decodeToFlow$1", f = "ktor.kt", l = {82}, m = "invokeSuspend")
    public static final class AnonymousClass1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteReadChannel $channel;
        final /* synthetic */ Json $this_decodeToFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.google.firebase.ai.common.util.KtorKt$decodeToFlow$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 176)
        @DebugMetadata(c = "com.google.firebase.ai.common.util.KtorKt$decodeToFlow$1$1", f = "ktor.kt", l = {84}, m = "invokeSuspend")
        public static final class C00181 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProducerScope<T> $$this$channelFlow;
            final /* synthetic */ Json $this_decodeToFlow;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00181(ProducerScope<? super T> producerScope, Json json, Continuation<? super C00181> continuation) {
                super(2, continuation);
                this.$$this$channelFlow = producerScope;
                this.$this_decodeToFlow = json;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00181 c00181 = new C00181(this.$$this$channelFlow, this.$this_decodeToFlow, continuation);
                c00181.L$0 = obj;
                return c00181;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(String str, Continuation<? super Unit> continuation) {
                return ((C00181) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.google.firebase.ai.common.util.KtorKt$decodeToFlow$1$1 for r8v3 'this'  kotlin.coroutines.Continuation
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r8.label
                    r2 = 0
                    r3 = 1
                    if (r1 == 0) goto L16
                    if (r1 != r3) goto L10
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L47
                L10:
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    okio.Utf8$$ExternalSyntheticBUOutline0.m$3(r8)
                    return r2
                L16:
                    kotlin.ResultKt.throwOnFailure(r9)
                    java.lang.Object r9 = r8.L$0
                    java.lang.String r9 = (java.lang.String) r9
                    java.lang.String r1 = "data:"
                    java.lang.String r9 = kotlin.text.StringsKt.removePrefix(r9, r1)
                    kotlinx.coroutines.channels.ProducerScope<T> r1 = r8.$$this$channelFlow
                    kotlinx.serialization.json.Json r4 = r8.$this_decodeToFlow
                    kotlinx.serialization.modules.SerializersModule r5 = r4.getSerializersModule()
                    r6 = 6
                    java.lang.String r7 = "T"
                    kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r6, r7)
                    java.lang.String r6 = "kotlinx.serialization.serializer.withModule"
                    kotlin.jvm.internal.MagicApiIntrinsics.voidMagicApiCall(r6)
                    kotlinx.serialization.KSerializer r2 = kotlinx.serialization.SerializersKt.serializer(r5, r2)
                    java.lang.Object r9 = r4.decodeFromString(r2, r9)
                    r8.label = r3
                    java.lang.Object r8 = r1.send(r9, r8)
                    if (r8 != r0) goto L47
                    return r0
                L47:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ai.common.util.KtorKt.AnonymousClass1.C00181.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteReadChannel byteReadChannel, Json json, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$channel = byteReadChannel;
            this.$this_decodeToFlow = json;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.needClassReification();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$channel, this.$this_decodeToFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                ByteReadChannel byteReadChannel = this.$channel;
                Intrinsics.needClassReification();
                C00181 c00181 = new C00181(producerScope, this.$this_decodeToFlow, null);
                this.label = 1;
                if (KtorKt.onEachLine(byteReadChannel, c00181, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.google.firebase.ai.common.util.KtorKt$onEachLine$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.util.KtorKt", f = "ktor.kt", l = {50, 51, 52}, m = "onEachLine")
    public static final class C20561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C20561(Continuation<? super C20561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KtorKt.onEachLine(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.common.util.KtorKt$send$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.util.KtorKt", f = "ktor.kt", l = {96}, m = "send")
    public static final class C20571 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C20571(Continuation<? super C20571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KtorKt.send(null, null, this);
        }
    }

    public static final /* synthetic */ <T> Flow<T> decodeToFlow(Json json, ByteReadChannel byteReadChannel) {
        json.getClass();
        byteReadChannel.getClass();
        Intrinsics.needClassReification();
        return FlowKt.channelFlow(new AnonymousClass1(byteReadChannel, json, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0060, code lost:
    
        if (r11 != null) goto L36;
     */
    /* JADX WARN: Path cross not found for [B:20:0x0060, B:31:0x0087], limit reached: 39 */
    /* JADX WARN: Path cross not found for [B:20:0x0060, B:36:0x0091], limit reached: 39 */
    /* JADX WARN: Path cross not found for [B:31:0x0087, B:20:0x0060], limit reached: 39 */
    /* JADX WARN: Path cross not found for [B:33:0x008d, B:34:0x008e], limit reached: 39 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[PHI: r9 r10 r11
      0x004d: PHI (r9v1 kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) = 
      (r9v3 kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>)
      (r9v10 kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>)
     binds: [B:27:0x0080, B:16:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x004d: PHI (r10v1 io.ktor.utils.io.ByteReadChannel) = (r10v3 io.ktor.utils.io.ByteReadChannel), (r10v9 io.ktor.utils.io.ByteReadChannel) binds: [B:27:0x0080, B:16:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x004d: PHI (r11v2 java.lang.Object) = (r11v6 java.lang.Object), (r11v1 java.lang.Object) binds: [B:27:0x0080, B:16:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0085 -> B:20:0x0060). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x009b -> B:20:0x0060). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object onEachLine(ByteReadChannel byteReadChannel, Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        C20561 c20561;
        ByteReadChannel byteReadChannel2;
        Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function22;
        String str;
        if (continuation instanceof C20561) {
            c20561 = (C20561) continuation;
            int i = c20561.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20561.label = i - Integer.MIN_VALUE;
            } else {
                c20561 = new C20561(continuation);
            }
        }
        Object uTF8Line$default = c20561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20561.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(uTF8Line$default);
        } else {
            if (i2 == 1) {
                function22 = (Function2) c20561.L$1;
                byteReadChannel2 = (ByteReadChannel) c20561.L$0;
                ResultKt.throwOnFailure(uTF8Line$default);
                c20561.L$0 = byteReadChannel2;
                c20561.L$1 = function22;
                c20561.label = 2;
                uTF8Line$default = ByteReadChannelOperationsKt.readUTF8Line$default(byteReadChannel2, 0, c20561, 1, null);
                if (uTF8Line$default != coroutine_suspended) {
                    ByteReadChannel byteReadChannel3 = byteReadChannel2;
                    function2 = function22;
                    byteReadChannel = byteReadChannel3;
                    str = (String) uTF8Line$default;
                    if (str != null) {
                    }
                }
                return coroutine_suspended;
            }
            if (i2 == 2) {
                function22 = (Function2) c20561.L$1;
                byteReadChannel2 = (ByteReadChannel) c20561.L$0;
                ResultKt.throwOnFailure(uTF8Line$default);
                ByteReadChannel byteReadChannel32 = byteReadChannel2;
                function2 = function22;
                byteReadChannel = byteReadChannel32;
                str = (String) uTF8Line$default;
                if (str != null) {
                    if (str.length() == 0) {
                    }
                    if (0 != 0) {
                        c20561.L$0 = byteReadChannel;
                        c20561.L$1 = function2;
                        c20561.label = 3;
                        if (function2.invoke(null, c20561) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i2 != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function23 = (Function2) c20561.L$1;
                ByteReadChannel byteReadChannel4 = (ByteReadChannel) c20561.L$0;
                ResultKt.throwOnFailure(uTF8Line$default);
                function2 = function23;
                byteReadChannel = byteReadChannel4;
            }
        }
        if (byteReadChannel.isClosedForRead()) {
            return Unit.INSTANCE;
        }
        c20561.L$0 = byteReadChannel;
        c20561.L$1 = function2;
        c20561.label = 1;
        if (ByteReadChannel.DefaultImpls.awaitContent$default(byteReadChannel, 0, c20561, 1, null) != coroutine_suspended) {
            Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function24 = function2;
            byteReadChannel2 = byteReadChannel;
            function22 = function24;
            c20561.L$0 = byteReadChannel2;
            c20561.L$1 = function22;
            c20561.label = 2;
            uTF8Line$default = ByteReadChannelOperationsKt.readUTF8Line$default(byteReadChannel2, 0, c20561, 1, null);
            if (uTF8Line$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object send(ByteChannel byteChannel, byte[] bArr, Continuation<? super Unit> continuation) {
        C20571 c20571;
        ByteChannel byteChannel2;
        if (continuation instanceof C20571) {
            c20571 = (C20571) continuation;
            int i = c20571.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20571.label = i - Integer.MIN_VALUE;
            } else {
                c20571 = new C20571(continuation);
            }
        }
        C20571 c205712 = c20571;
        Object obj = c205712.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c205712.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c205712.L$0 = byteChannel;
            c205712.label = 1;
            if (ByteWriteChannelOperationsKt.writeFully$default(byteChannel, bArr, 0, 0, c205712, 6, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            byteChannel2 = byteChannel;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            byteChannel2 = (ByteChannel) c205712.L$0;
            ResultKt.throwOnFailure(obj);
        }
        byteChannel2.close();
        return Unit.INSTANCE;
    }
}
