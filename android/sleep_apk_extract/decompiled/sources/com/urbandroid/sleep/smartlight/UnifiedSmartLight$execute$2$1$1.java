package com.urbandroid.sleep.smartlight;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.controller.Controller;
import com.urbandroid.smartlight.common.model.Light;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.smartlight.UnifiedSmartLight$execute$2$1$1", f = "UnifiedSmartLight.kt", l = {56}, m = "invokeSuspend", v = 2)
public final class UnifiedSmartLight$execute$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Controller, List<Light>, Continuation<? super Unit>, Object> $block;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ UnifiedSmartLight this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UnifiedSmartLight$execute$2$1$1(UnifiedSmartLight unifiedSmartLight, Function3<? super Controller, ? super List<Light>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super UnifiedSmartLight$execute$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = unifiedSmartLight;
        this.$block = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnifiedSmartLight$execute$2$1$1(this.this$0, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnifiedSmartLight$execute$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<Light> list = CollectionsKt.toList(this.this$0.configuration.getSelectedLights());
            UnifiedSmartLight unifiedSmartLight = this.this$0;
            String str = Logger.defaultTag;
            Logger.logInfo(str, unifiedSmartLight.getTag() + ": " + ("selected lights: " + list), null);
            Controller controller = this.this$0.getController();
            if (controller == null) {
                return null;
            }
            Function3<Controller, List<Light>, Continuation<? super Unit>, Object> function3 = this.$block;
            this.L$0 = SpillingKt.nullOutSpilledVariable(list);
            this.L$1 = SpillingKt.nullOutSpilledVariable(controller);
            this.I$0 = 0;
            this.label = 1;
            if (function3.invoke(controller, list, this) == coroutine_suspended) {
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
