package com.urbandroid.smartlight.hue;

import com.urbandroid.smartlight.common.discovery.Discovery;
import com.urbandroid.smartlight.common.model.Gateway;
import com.urbandroid.smartlight.hue.HueDiscovery;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.smartlight.hue.HueDiscovery$ExtendedHueListener$onBridgeConnected$2", f = "HueDiscovery.kt", l = {}, m = "invokeSuspend")
public final class HueDiscovery$ExtendedHueListener$onBridgeConnected$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $username;
    int label;
    final /* synthetic */ HueDiscovery.ExtendedHueListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HueDiscovery$ExtendedHueListener$onBridgeConnected$2(HueDiscovery.ExtendedHueListener extendedHueListener, String str, Continuation<? super HueDiscovery$ExtendedHueListener$onBridgeConnected$2> continuation) {
        super(2, continuation);
        this.this$0 = extendedHueListener;
        this.$username = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HueDiscovery$ExtendedHueListener$onBridgeConnected$2(this.this$0, this.$username, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HueDiscovery$ExtendedHueListener$onBridgeConnected$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        List<Discovery.AuthListener> list = this.this$0.authListeners;
        HueDiscovery.ExtendedHueListener extendedHueListener = this.this$0;
        String str = this.$username;
        for (Discovery.AuthListener authListener : list) {
            Gateway.Hue gateway = extendedHueListener.getGateway();
            if (gateway != null) {
                authListener.success(gateway.toAuthenticated(str));
            }
        }
        this.this$0.authListeners.clear();
        return Unit.INSTANCE;
    }
}
