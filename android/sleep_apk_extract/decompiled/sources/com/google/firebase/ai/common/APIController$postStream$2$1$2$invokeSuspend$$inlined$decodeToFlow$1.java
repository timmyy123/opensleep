package com.google.firebase.ai.common;

import com.google.firebase.ai.common.util.KtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.serialization.json.Json;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "com/google/firebase/ai/common/util/KtorKt$decodeToFlow$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.ai.common.util.KtorKt$decodeToFlow$1", f = "ktor.kt", l = {82}, m = "invokeSuspend")
public final class APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteReadChannel $channel;
    final /* synthetic */ Json $this_decodeToFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "it", "", "com/google/firebase/ai/common/util/KtorKt$decodeToFlow$1$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.util.KtorKt$decodeToFlow$1$1", f = "ktor.kt", l = {84}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProducerScope<R> $$this$channelFlow;
        final /* synthetic */ Json $this_decodeToFlow;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ProducerScope producerScope, Json json, Continuation continuation) {
            super(2, continuation);
            this.$this_decodeToFlow = json;
            this.$$this$channelFlow = producerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$channelFlow, this.$this_decodeToFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.google.firebase.ai.common.APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1$1 for r8v3 'this'  kotlin.coroutines.Continuation
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
                kotlinx.coroutines.channels.ProducerScope<R> r1 = r8.$$this$channelFlow
                kotlinx.serialization.json.Json r4 = r8.$this_decodeToFlow
                kotlinx.serialization.modules.SerializersModule r5 = r4.getSerializersModule()
                r6 = 6
                java.lang.String r7 = "R"
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ai.common.APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1(ByteReadChannel byteReadChannel, Json json, Continuation continuation) {
        super(2, continuation);
        this.$channel = byteReadChannel;
        this.$this_decodeToFlow = json;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1 aPIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1 = new APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1(this.$channel, this.$this_decodeToFlow, continuation);
        aPIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1.L$0 = obj;
        return aPIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
        return ((APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(producerScope, this.$this_decodeToFlow, null);
            this.label = 1;
            if (KtorKt.onEachLine(byteReadChannel, anonymousClass1, this) == coroutine_suspended) {
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
