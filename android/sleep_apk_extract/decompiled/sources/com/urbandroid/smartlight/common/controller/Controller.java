package com.urbandroid.smartlight.common.controller;

import com.facebook.internal.ServerProtocol;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Blinder;
import com.urbandroid.smartlight.common.model.BlinderState;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.common.model.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H¦@¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u0013J.\u0010\u0014\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010\u0017J(\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH¦@¢\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00072\u0006\u0010\r\u001a\u00020\u001aH¦@¢\u0006\u0002\u0010 J\u001e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006#"}, d2 = {"Lcom/urbandroid/smartlight/common/controller/Controller;", "", "gateway", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway;", "getGateway", "()Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway;", "getLights", "", "Lcom/urbandroid/smartlight/common/model/Light;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setState", "", "lights", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/urbandroid/smartlight/common/model/State;", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "light", "(Lcom/urbandroid/smartlight/common/model/Light;Lcom/urbandroid/smartlight/common/model/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getState", "(Lcom/urbandroid/smartlight/common/model/Light;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "blink", "repeat", "", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/State;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/urbandroid/smartlight/common/model/Light;Lcom/urbandroid/smartlight/common/model/State;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBlinderState", "Lcom/urbandroid/smartlight/common/model/BlinderState;", "blinder", "Lcom/urbandroid/smartlight/common/model/Blinder;", "(Lcom/urbandroid/smartlight/common/model/Blinder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBlinderState", "blinders", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/BlinderState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/urbandroid/smartlight/common/model/Blinder;Lcom/urbandroid/smartlight/common/model/BlinderState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Controller {
    Object blink(Light light, State state, int i, Continuation<? super Unit> continuation);

    Object blink(List<Light> list, State state, int i, Continuation<? super Unit> continuation);

    Object close(Continuation<? super Unit> continuation);

    Object getBlinderState(Blinder blinder, Continuation<? super BlinderState> continuation);

    AuthenticatedGateway getGateway();

    Object getLights(Continuation<? super List<Light>> continuation);

    Object getState(Light light, Continuation<? super State> continuation);

    Object setBlinderState(Blinder blinder, BlinderState blinderState, Continuation<? super Unit> continuation);

    Object setBlinderState(List<Blinder> list, BlinderState blinderState, Continuation<? super Unit> continuation);

    Object setState(Light light, State state, Continuation<? super Unit> continuation);

    Object setState(List<Light> list, State state, Continuation<? super Unit> continuation);

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object blink(Controller controller, Light light, State state, int i, Continuation<? super Unit> continuation) {
            Object objBlink = controller.blink(CollectionsKt.listOf(light), state, i, continuation);
            return objBlink == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objBlink : Unit.INSTANCE;
        }

        public static /* synthetic */ Object blink$default(Controller controller, List list, State state, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: blink");
                return null;
            }
            if ((i2 & 4) != 0) {
                i = 3;
            }
            return controller.blink((List<Light>) list, state, i, (Continuation<? super Unit>) continuation);
        }

        public static Object setBlinderState(Controller controller, Blinder blinder, BlinderState blinderState, Continuation<? super Unit> continuation) {
            Object blinderState2 = controller.setBlinderState(CollectionsKt.listOf(blinder), blinderState, continuation);
            return blinderState2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? blinderState2 : Unit.INSTANCE;
        }

        public static Object setState(Controller controller, Light light, State state, Continuation<? super Unit> continuation) {
            Object state2 = controller.setState(CollectionsKt.listOf(light), state, continuation);
            return state2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? state2 : Unit.INSTANCE;
        }

        public static /* synthetic */ Object blink$default(Controller controller, Light light, State state, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: blink");
                return null;
            }
            if ((i2 & 4) != 0) {
                i = 3;
            }
            return controller.blink(light, state, i, (Continuation<? super Unit>) continuation);
        }
    }
}
