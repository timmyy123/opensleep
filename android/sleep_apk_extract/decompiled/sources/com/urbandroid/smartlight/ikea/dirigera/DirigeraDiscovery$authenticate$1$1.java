package com.urbandroid.smartlight.ikea.dirigera;

import android.util.Log;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.discovery.Discovery;
import com.urbandroid.smartlight.common.model.Gateway;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$authenticate$1$1", f = "DirigeraDiscovery.kt", l = {82}, m = "invokeSuspend")
public final class DirigeraDiscovery$authenticate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $codeVerifier;
    final /* synthetic */ Gateway.Dirigera $gateway;
    final /* synthetic */ Discovery.AuthListener<Gateway.Dirigera> $listener;
    int label;
    final /* synthetic */ DirigeraDiscovery this$0;

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$authenticate$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$authenticate$1$1$1", f = "DirigeraDiscovery.kt", l = {85}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $codeVerifier;
        final /* synthetic */ Gateway.Dirigera $gateway;
        final /* synthetic */ Discovery.AuthListener<Gateway.Dirigera> $listener;
        Object L$0;
        int label;
        final /* synthetic */ DirigeraDiscovery this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DirigeraDiscovery dirigeraDiscovery, Gateway.Dirigera dirigera, String str, Discovery.AuthListener<Gateway.Dirigera> authListener, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = dirigeraDiscovery;
            this.$gateway = dirigera;
            this.$codeVerifier = str;
            this.$listener = authListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$gateway, this.$codeVerifier, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DirigeraClient dirigeraClient;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DirigeraClient dirigeraClient2 = new DirigeraClient(this.this$0.getContext(), this.$gateway.getIp());
                    String str = this.$codeVerifier;
                    this.L$0 = dirigeraClient2;
                    this.label = 1;
                    Object objStartAuth = dirigeraClient2.startAuth(str, this);
                    if (objStartAuth == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dirigeraClient = dirigeraClient2;
                    obj = objStartAuth;
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    dirigeraClient = (DirigeraClient) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                String str2 = (String) obj;
                Log.i(Common_smartlightKt.TAG, "Dirigera auth " + str2);
                if (str2 != null) {
                    DirigeraDiscovery dirigeraDiscovery = this.this$0;
                    Discovery.AuthListener<Gateway.Dirigera> authListener = this.$listener;
                    Gateway.Dirigera dirigera = this.$gateway;
                    DirigeraSharedPreferences.getInstance(dirigeraDiscovery.getContext()).setToken(str2);
                    String code = dirigeraClient.getCode();
                    if (code == null) {
                        code = "";
                    }
                    authListener.success(dirigera.toAuthenticated(code, str2));
                }
            } catch (Exception e) {
                Log.e(Common_smartlightKt.TAG, "Auth error ", e);
                this.$listener.failed(this.$gateway);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirigeraDiscovery$authenticate$1$1(DirigeraDiscovery dirigeraDiscovery, Gateway.Dirigera dirigera, String str, Discovery.AuthListener<Gateway.Dirigera> authListener, Continuation<? super DirigeraDiscovery$authenticate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = dirigeraDiscovery;
        this.$gateway = dirigera;
        this.$codeVerifier = str;
        this.$listener = authListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DirigeraDiscovery$authenticate$1$1(this.this$0, this.$gateway, this.$codeVerifier, this.$listener, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DirigeraDiscovery$authenticate$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$gateway, this.$codeVerifier, this.$listener, null);
            this.label = 1;
            if (BuildersKt.withContext(io2, anonymousClass1, this) == coroutine_suspended) {
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
