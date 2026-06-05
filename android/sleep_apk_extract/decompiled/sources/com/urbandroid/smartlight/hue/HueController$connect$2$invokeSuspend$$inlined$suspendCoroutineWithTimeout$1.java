package com.urbandroid.smartlight.hue;

import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.exception.PHHueException;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.controller.SafeResumeContinuation;
import com.urbandroid.smartlight.hue.HueController;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.urbandroid.smartlight.hue.HueController$connect$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1", f = "HueController.kt", l = {177}, m = "invokeSuspend")
public final class HueController$connect$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ PHAccessPoint $accessPoint$inlined;
    Object L$0;
    int label;
    final /* synthetic */ HueController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HueController$connect$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(Continuation continuation, HueController hueController, PHAccessPoint pHAccessPoint) {
        super(2, continuation);
        this.this$0 = hueController;
        this.$accessPoint$inlined = pHAccessPoint;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HueController$connect$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(continuation, this.this$0, this.$accessPoint$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((HueController$connect$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
        cancellableContinuationImpl.initCancellability();
        final SafeResumeContinuation safeResumeContinuation = new SafeResumeContinuation(cancellableContinuationImpl);
        try {
            final HueController hueController = this.this$0;
            Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.urbandroid.smartlight.hue.HueController$connect$2$success$1$connectListener$1
                public final void invoke(boolean z) {
                    String str = Logger.defaultTag;
                    Logger.logInfo(str, hueController.getTag() + ": " + ((Object) ("connected " + z)), null);
                    HueController hueController2 = hueController;
                    if (z) {
                        Logger.logInfo(Logger.defaultTag, hueController2.getTag() + ": connected established", null);
                    } else {
                        Logger.logInfo(Logger.defaultTag, hueController2.getTag() + ": Bridge not responding, not connected", null);
                    }
                    safeResumeContinuation.resumeWith(Result.m2357constructorimpl(Boolean.valueOf(z)));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
            HueController.ExtendedHueListener extendedHueListener = this.this$0.hueListener;
            extendedHueListener.addListener(function1);
            extendedHueListener.getSdk().connect(this.$accessPoint$inlined);
        } catch (PHHueException e) {
            HueController hueController2 = this.this$0;
            Logger.logWarning(Logger.defaultTag, hueController2.getTag() + ": Already connected?", e);
            Result.Companion companion = Result.INSTANCE;
            safeResumeContinuation.resumeWith(Result.m2357constructorimpl(Boxing.boxBoolean(true)));
        } catch (Exception e2) {
            HueController hueController3 = this.this$0;
            Logger.logSevere(Logger.defaultTag, hueController3.getTag() + ": SmartLight: failed to connect ", e2);
            Result.Companion companion2 = Result.INSTANCE;
            safeResumeContinuation.resumeWith(Result.m2357constructorimpl(Boxing.boxBoolean(false)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(this);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
