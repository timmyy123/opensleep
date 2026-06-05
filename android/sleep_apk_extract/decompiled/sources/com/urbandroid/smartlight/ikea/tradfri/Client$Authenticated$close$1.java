package com.urbandroid.smartlight.ikea.tradfri;

import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.ikea.tradfri.Client;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.SendChannel;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated$close$1", f = "Client.kt", l = {348}, m = "invokeSuspend")
public final class Client$Authenticated$close$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Client.Authenticated this$0;

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated$close$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated$close$1$1", f = "Client.kt", l = {351}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ Client.Authenticated this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Client.Authenticated authenticated, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = authenticated;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long secondsInMillis;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0 && i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            do {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.this$0.getLastSendTimestamp();
                long secondsInMillis2 = Utils.getSecondsInMillis(1);
                Client.Authenticated authenticated = this.this$0;
                if (jCurrentTimeMillis > secondsInMillis2) {
                    Logger.logInfo(Logger.defaultTag, authenticated.getTag() + ": closed", null);
                    CoroutineScopeKt.cancel$default(this.this$0.stateScope, null, 1, null);
                    SendChannel.close$default(this.this$0.applyStateChannel, null, 1, null);
                    this.this$0.getStateExecutor().shutdown();
                    this.this$0.getExecutor().shutdown();
                    return Unit.INSTANCE;
                }
                String str = "close " + (System.currentTimeMillis() - this.this$0.getLastSendTimestamp());
                Logger.logInfo(Logger.defaultTag, authenticated.getTag() + ": " + ((Object) str), null);
                secondsInMillis = Utils.getSecondsInMillis(1);
                this.label = 1;
            } while (DelayKt.delay(secondsInMillis, this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Client$Authenticated$close$1(Client.Authenticated authenticated, Continuation<? super Client$Authenticated$close$1> continuation) {
        super(2, continuation);
        this.this$0 = authenticated;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Client$Authenticated$close$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Client$Authenticated$close$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long secondsInMillis = Utils.getSecondsInMillis(30);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
                this.label = 1;
                Object objWithTimeout = TimeoutKt.withTimeout(secondsInMillis, anonymousClass1, this);
                this = objWithTimeout;
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this = this;
            }
        } catch (Exception e) {
            Client.Authenticated authenticated = this.this$0;
            Logger.logWarning(Logger.defaultTag, authenticated.getTag() + ": close failure", e);
        }
        return Unit.INSTANCE;
    }
}
