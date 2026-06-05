package com.urbandroid.common.wifi;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.wifi.WifiEnabler;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {2, 3, 0})
@DebugMetadata(c = "com.urbandroid.common.wifi.Wifi_enablerKt$enableWifi$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1", f = "wifi-enabler.kt", l = {177}, m = "invokeSuspend", v = 2)
public final class Wifi_enablerKt$enableWifi$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WifiContext>, Object> {
    final /* synthetic */ String $applicantId$inlined;
    final /* synthetic */ int $timeoutInSecond$inlined;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Wifi_enablerKt$enableWifi$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(Continuation continuation, String str, int i) {
        super(2, continuation);
        this.$applicantId$inlined = str;
        this.$timeoutInSecond$inlined = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Wifi_enablerKt$enableWifi$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(continuation, this.$applicantId$inlined, this.$timeoutInSecond$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WifiContext> continuation) {
        return ((Wifi_enablerKt$enableWifi$2$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        this.I$0 = 0;
        this.label = 1;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
        cancellableContinuationImpl.initCancellability();
        WifiEnabler wifiEnabler = WifiEnabler.getInstance();
        String str = this.$applicantId$inlined;
        final int i2 = this.$timeoutInSecond$inlined;
        wifiEnabler.enable(str, i2, new WifiEnabler.OnConnectListener() { // from class: com.urbandroid.common.wifi.Wifi_enablerKt$enableWifi$2$1$1
            @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
            public void connected(WifiContext wifiContext) {
                wifiContext.getClass();
                cancellableContinuationImpl.resumeWith(Result.m2357constructorimpl(wifiContext));
            }

            @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
            public void failed() {
                Logger.logWarning("unable to enable wifi - failure", null);
                cancellableContinuationImpl.resumeWith(Result.m2357constructorimpl(null));
            }

            @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
            public void timeouted() {
                Logger.logWarning("unable to enable wifi - timeout " + i2 + " sec", null);
                cancellableContinuationImpl.resumeWith(Result.m2357constructorimpl(null));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(this);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
