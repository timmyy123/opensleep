package com.urbandroid.smartlight.ikea.tradfri;

import android.content.Context;
import com.urbandroid.smartlight.ikea.tradfri.Tradfri;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Tradfri$Gateway$Companion$resolve$2$1$1", f = "Tradfri.kt", l = {47}, m = "invokeSuspend")
public final class Tradfri$Gateway$Companion$resolve$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Continuation<Result<Tradfri.Gateway>> $continuation;
    final /* synthetic */ String $ip;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ String $serviceName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Tradfri$Gateway$Companion$resolve$2$1$1(CoroutineScope coroutineScope, Context context, String str, String str2, Continuation<? super Result<Tradfri.Gateway>> continuation, Continuation<? super Tradfri$Gateway$Companion$resolve$2$1$1> continuation2) {
        super(2, continuation2);
        this.$scope = coroutineScope;
        this.$context = context;
        this.$serviceName = str;
        this.$ip = str2;
        this.$continuation = continuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Tradfri$Gateway$Companion$resolve$2$1$1(this.$scope, this.$context, this.$serviceName, this.$ip, this.$continuation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Tradfri$Gateway$Companion$resolve$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Tradfri tradfri = Tradfri.INSTANCE;
            CoroutineScope coroutineScope = this.$scope;
            Context context = this.$context;
            final Continuation<Result<Tradfri.Gateway>> continuation = this.$continuation;
            Tradfri.DiscoveryCallback discoveryCallback = new Tradfri.DiscoveryCallback() { // from class: com.urbandroid.smartlight.ikea.tradfri.Tradfri$Gateway$Companion$resolve$2$1$1.1
                private boolean alreadyResumed;

                @Override // com.urbandroid.smartlight.ikea.tradfri.Tradfri.DiscoveryCallback
                public void failed(String msg) {
                    msg.getClass();
                    if (this.alreadyResumed) {
                        return;
                    }
                    this.alreadyResumed = true;
                    Continuation<Result<Tradfri.Gateway>> continuation2 = continuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m2357constructorimpl(Result.m2356boximpl(Result.m2357constructorimpl(ResultKt.createFailure(new TradDiscoveryException(msg))))));
                }

                @Override // com.urbandroid.smartlight.ikea.tradfri.Tradfri.DiscoveryCallback
                public void finished() {
                    Tradfri.DiscoveryCallback.DefaultImpls.finished(this);
                }

                @Override // com.urbandroid.smartlight.ikea.tradfri.Tradfri.DiscoveryCallback
                public Object found(Tradfri.Gateway gateway, Continuation<? super Unit> continuation2) {
                    if (this.alreadyResumed) {
                        return Unit.INSTANCE;
                    }
                    this.alreadyResumed = true;
                    continuation.resumeWith(Result.m2357constructorimpl(Result.m2356boximpl(Result.m2357constructorimpl(gateway))));
                    return Unit.INSTANCE;
                }

                @Override // com.urbandroid.smartlight.ikea.tradfri.Tradfri.DiscoveryCallback
                public void started() {
                    Tradfri.DiscoveryCallback.DefaultImpls.started(this);
                }
            };
            String str = this.$serviceName;
            String str2 = this.$ip;
            this.label = 1;
            if (tradfri.discover(coroutineScope, context, discoveryCallback, str, str2, this) == coroutine_suspended) {
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
