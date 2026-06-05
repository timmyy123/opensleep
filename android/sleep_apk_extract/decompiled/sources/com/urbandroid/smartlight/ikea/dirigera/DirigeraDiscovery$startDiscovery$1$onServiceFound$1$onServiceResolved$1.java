package com.urbandroid.smartlight.ikea.dirigera;

import android.net.nsd.NsdServiceInfo;
import com.urbandroid.smartlight.common.discovery.DiscoveryCallback;
import com.urbandroid.smartlight.common.model.Gateway;
import com.urbandroid.smartlight.ikea.tradfri.TradfriKt;
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
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$startDiscovery$1$onServiceFound$1$onServiceResolved$1", f = "DirigeraDiscovery.kt", l = {244}, m = "invokeSuspend")
public final class DirigeraDiscovery$startDiscovery$1$onServiceFound$1$onServiceResolved$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $codeVerifier;
    final /* synthetic */ String $hostIp;
    final /* synthetic */ DiscoveryCallback $listener;
    final /* synthetic */ NsdServiceInfo $serviceInfo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirigeraDiscovery$startDiscovery$1$onServiceFound$1$onServiceResolved$1(DiscoveryCallback discoveryCallback, NsdServiceInfo nsdServiceInfo, String str, String str2, Continuation<? super DirigeraDiscovery$startDiscovery$1$onServiceFound$1$onServiceResolved$1> continuation) {
        super(2, continuation);
        this.$listener = discoveryCallback;
        this.$serviceInfo = nsdServiceInfo;
        this.$hostIp = str;
        this.$codeVerifier = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DirigeraDiscovery$startDiscovery$1$onServiceFound$1$onServiceResolved$1(this.$listener, this.$serviceInfo, this.$hostIp, this.$codeVerifier, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DirigeraDiscovery$startDiscovery$1$onServiceFound$1$onServiceResolved$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DiscoveryCallback discoveryCallback = this.$listener;
            String hostname = this.$serviceInfo.getHostname();
            if (hostname == null) {
                hostname = this.$serviceInfo.getServiceName();
            }
            hostname.getClass();
            Gateway.Dirigera dirigera = new Gateway.Dirigera(hostname, this.$hostIp, TradfriKt.DIRIGERA_PORT, this.$codeVerifier);
            this.label = 1;
            if (discoveryCallback.found(dirigera, this) == coroutine_suspended) {
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
