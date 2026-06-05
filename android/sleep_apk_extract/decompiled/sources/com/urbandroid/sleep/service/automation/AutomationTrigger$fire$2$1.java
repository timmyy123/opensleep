package com.urbandroid.sleep.service.automation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.automation.AutomationTrigger$fire$2$1", f = "AutomationTrigger.kt", l = {28}, m = "invokeSuspend", v = 2)
public final class AutomationTrigger$fire$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ AutomationEvent $event;
    final /* synthetic */ long $timeoutInMs;
    int label;
    final /* synthetic */ AutomationTrigger this$0;

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.AutomationTrigger$fire$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.automation.AutomationTrigger$fire$2$1$1", f = "AutomationTrigger.kt", l = {29}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ AutomationEvent $event;
        final /* synthetic */ long $timeoutInMs;
        int label;
        final /* synthetic */ AutomationTrigger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AutomationTrigger automationTrigger, AutomationEvent automationEvent, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = automationTrigger;
            this.$event = automationEvent;
            this.$timeoutInMs = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$event, this.$timeoutInMs, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            AutomationTrigger automationTrigger = this.this$0;
            AutomationEvent automationEvent = this.$event;
            long j = this.$timeoutInMs;
            this.label = 1;
            Object objDoSend = automationTrigger.doSend(automationEvent, j, this);
            return objDoSend == coroutine_suspended ? coroutine_suspended : objDoSend;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutomationTrigger$fire$2$1(AutomationTrigger automationTrigger, AutomationEvent automationEvent, long j, Continuation<? super AutomationTrigger$fire$2$1> continuation) {
        super(2, continuation);
        this.this$0 = automationTrigger;
        this.$event = automationEvent;
        this.$timeoutInMs = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutomationTrigger$fire$2$1(this.this$0, this.$event, this.$timeoutInMs, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((AutomationTrigger$fire$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineDispatcher io2 = Dispatchers.getIO();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$event, this.$timeoutInMs, null);
        this.label = 1;
        Object objWithContext = BuildersKt.withContext(io2, anonymousClass1, this);
        return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
    }
}
