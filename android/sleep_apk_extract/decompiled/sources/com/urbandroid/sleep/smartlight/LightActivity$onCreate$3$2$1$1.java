package com.urbandroid.sleep.smartlight;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.widget.ListView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.controller.Controller;
import com.urbandroid.smartlight.common.model.Color;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.common.model.State;
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
@DebugMetadata(c = "com.urbandroid.sleep.smartlight.LightActivity$onCreate$3$2$1$1", f = "LightActivity.kt", l = {117}, m = "invokeSuspend", v = 2)
public final class LightActivity$onCreate$3$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Controller $controller;
    final /* synthetic */ Light $light;
    final /* synthetic */ ListView $this_apply;
    int label;
    final /* synthetic */ LightActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightActivity$onCreate$3$2$1$1(LightActivity lightActivity, ListView listView, Controller controller, Light light, Continuation<? super LightActivity$onCreate$3$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = lightActivity;
        this.$this_apply = listView;
        this.$controller = controller;
        this.$light = light;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LightActivity$onCreate$3$2$1$1(this.this$0, this.$this_apply, this.$controller, this.$light, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LightActivity$onCreate$3$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LightActivity lightActivity = this.this$0;
            String strM = FileInsert$$ExternalSyntheticOutline0.m(this.$this_apply.getId(), "Blinking ");
            Logger.logInfo(Logger.defaultTag, lightActivity.getTag() + ": " + strM, null);
            Controller controller = this.$controller;
            Light light = this.$light;
            State state = new State(new Color.Hsb(500, 10000, 100, 200), 100, State.Switch.ON, false, 8, null);
            this.label = 1;
            if (Controller.DefaultImpls.blink$default(controller, light, state, 0, this, 4, (Object) null) == coroutine_suspended) {
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
