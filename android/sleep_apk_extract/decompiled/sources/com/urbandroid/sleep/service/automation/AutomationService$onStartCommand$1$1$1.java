package com.urbandroid.sleep.service.automation;

import com.urbandroid.common.logging.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.automation.AutomationService$onStartCommand$1$1$1", f = "AutomationService.kt", l = {}, m = "invokeSuspend", v = 2)
public final class AutomationService$onStartCommand$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $current;
    final /* synthetic */ AutomationEvent $event;
    final /* synthetic */ AutomationTrigger $trigger;
    int label;
    final /* synthetic */ AutomationService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutomationService$onStartCommand$1$1$1(AutomationService automationService, AutomationTrigger automationTrigger, AutomationEvent automationEvent, int i, Continuation<? super AutomationService$onStartCommand$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = automationService;
        this.$trigger = automationTrigger;
        this.$event = automationEvent;
        this.$current = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutomationService$onStartCommand$1$1$1(this.this$0, this.$trigger, this.$event, this.$current, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AutomationService$onStartCommand$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        AutomationService automationService = this.this$0;
        String str = this.$trigger.getName() + " " + this.$event.getEventName() + " " + this.$current + " finished";
        Logger.logInfo(Logger.defaultTag, automationService.getTag() + ": " + str, null);
        return Unit.INSTANCE;
    }
}
