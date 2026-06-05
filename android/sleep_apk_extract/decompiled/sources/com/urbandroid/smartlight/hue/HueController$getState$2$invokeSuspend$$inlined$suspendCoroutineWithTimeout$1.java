package com.urbandroid.smartlight.hue;

import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.mapper.MappersKt;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.common.model.State;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$getState$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1", f = "HueController.kt", l = {177}, m = "invokeSuspend")
public final class HueController$getState$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super State>, Object> {
    final /* synthetic */ Light $light$inlined;
    Object L$0;
    int label;
    final /* synthetic */ HueController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HueController$getState$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(Continuation continuation, HueController hueController, Light light) {
        super(2, continuation);
        this.this$0 = hueController;
        this.$light$inlined = light;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HueController$getState$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(continuation, this.this$0, this.$light$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super State> continuation) {
        return ((HueController$getState$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        this.label = 1;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
        cancellableContinuationImpl.initCancellability();
        PHBridge selectedBridge = this.this$0.sdk.getSelectedBridge();
        PHLight hueLight = MappersKt.toHueLight(this.$light$inlined);
        final HueController hueController = this.this$0;
        selectedBridge.updateLight(hueLight, new PHLightListener() { // from class: com.urbandroid.smartlight.hue.HueController$getState$2$1$1
            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onError(int p0, String p1) {
                HueController hueController2 = hueController;
                String str = "getState ERROR " + p0 + ' ' + p1;
                Logger.logInfo(Logger.defaultTag, hueController2.getTag() + ": " + ((Object) str), null);
                cancellableContinuationImpl.resumeWith(Result.m2357constructorimpl(null));
            }

            @Override // com.philips.lighting.hue.listener.PHLightListener
            public void onReceivingLightDetails(PHLight light) {
                String str = Logger.defaultTag;
                Logger.logInfo(str, hueController.getTag() + ": " + ((Object) ("getState Light " + light)), null);
                if (light != null) {
                    HueController hueController2 = hueController;
                    Continuation<State> continuation = cancellableContinuationImpl;
                    if (light.getLastKnownLightState() == null) {
                        Logger.logInfo(Logger.defaultTag, hueController2.getTag() + ": lastKnownState NULL", null);
                        continuation.resumeWith(Result.m2357constructorimpl(null));
                        return;
                    }
                    String strValueOf = String.valueOf(light.getLastKnownLightState());
                    Logger.logInfo(Logger.defaultTag, hueController2.getTag() + ": " + ((Object) strValueOf), null);
                    PHLightState lastKnownLightState = light.getLastKnownLightState();
                    continuation.resumeWith(Result.m2357constructorimpl(lastKnownLightState != null ? MappersKt.toState(lastKnownLightState) : null));
                }
            }

            @Override // com.philips.lighting.hue.listener.PHLightListener
            public void onReceivingLights(List<PHBridgeResource> p0) {
            }

            @Override // com.philips.lighting.hue.listener.PHLightListener
            public void onSearchComplete() {
            }

            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onStateUpdate(Map<String, String> p0, List<PHHueError> p1) {
            }

            @Override // com.philips.lighting.hue.listener.PHBridgeAPIListener
            public void onSuccess() {
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(this);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
