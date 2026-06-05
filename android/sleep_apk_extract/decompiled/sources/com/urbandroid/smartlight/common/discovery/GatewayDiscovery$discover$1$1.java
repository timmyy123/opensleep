package com.urbandroid.smartlight.common.discovery;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.model.Gateway;
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
@DebugMetadata(c = "com.urbandroid.smartlight.common.discovery.GatewayDiscovery$discover$1$1", f = "GatewayDiscovery.kt", l = {}, m = "invokeSuspend")
public final class GatewayDiscovery$discover$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Discovery<Gateway> $it;
    final /* synthetic */ GatewayDiscovery$discover$listenerWrapper$1 $listenerWrapper;
    int label;
    final /* synthetic */ GatewayDiscovery this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayDiscovery$discover$1$1(GatewayDiscovery gatewayDiscovery, Discovery<Gateway> discovery, GatewayDiscovery$discover$listenerWrapper$1 gatewayDiscovery$discover$listenerWrapper$1, Continuation<? super GatewayDiscovery$discover$1$1> continuation) {
        super(2, continuation);
        this.this$0 = gatewayDiscovery;
        this.$it = discovery;
        this.$listenerWrapper = gatewayDiscovery$discover$listenerWrapper$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GatewayDiscovery$discover$1$1(this.this$0, this.$it, this.$listenerWrapper, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GatewayDiscovery$discover$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        GatewayDiscovery gatewayDiscovery = this.this$0;
        String str = "launching discovery " + this.$it;
        Logger.logInfo(Logger.defaultTag, gatewayDiscovery.getTag() + ": " + ((Object) str), null);
        this.$it.discover(this.$listenerWrapper);
        return Unit.INSTANCE;
    }
}
