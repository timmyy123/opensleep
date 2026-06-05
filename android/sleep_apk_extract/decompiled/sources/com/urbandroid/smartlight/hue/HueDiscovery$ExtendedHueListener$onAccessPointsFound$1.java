package com.urbandroid.smartlight.hue;

import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.urbandroid.smartlight.common.discovery.Discovery;
import com.urbandroid.smartlight.common.mapper.MappersKt;
import com.urbandroid.smartlight.hue.HueDiscovery;
import java.util.Iterator;
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
@DebugMetadata(c = "com.urbandroid.smartlight.hue.HueDiscovery$ExtendedHueListener$onAccessPointsFound$1", f = "HueDiscovery.kt", l = {}, m = "invokeSuspend")
public final class HueDiscovery$ExtendedHueListener$onAccessPointsFound$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PHAccessPoint> $accessPoint;
    int label;
    final /* synthetic */ HueDiscovery.ExtendedHueListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HueDiscovery$ExtendedHueListener$onAccessPointsFound$1(List<? extends PHAccessPoint> list, HueDiscovery.ExtendedHueListener extendedHueListener, Continuation<? super HueDiscovery$ExtendedHueListener$onAccessPointsFound$1> continuation) {
        super(2, continuation);
        this.$accessPoint = list;
        this.this$0 = extendedHueListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HueDiscovery$ExtendedHueListener$onAccessPointsFound$1(this.$accessPoint, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HueDiscovery$ExtendedHueListener$onAccessPointsFound$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        List<PHAccessPoint> list = this.$accessPoint;
        HueDiscovery.ExtendedHueListener extendedHueListener = this.this$0;
        for (PHAccessPoint pHAccessPoint : list) {
            Iterator it = extendedHueListener.listeners.iterator();
            while (it.hasNext()) {
                ((Discovery.Listener) it.next()).found(MappersKt.toGateway(pHAccessPoint));
            }
        }
        return Unit.INSTANCE;
    }
}
