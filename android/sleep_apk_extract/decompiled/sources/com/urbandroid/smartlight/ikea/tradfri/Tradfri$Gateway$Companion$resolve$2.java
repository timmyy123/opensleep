package com.urbandroid.smartlight.ikea.tradfri;

import android.content.Context;
import com.urbandroid.smartlight.ikea.tradfri.Tradfri;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Tradfri$Gateway$Companion$resolve$2", f = "Tradfri.kt", l = {45}, m = "invokeSuspend")
public final class Tradfri$Gateway$Companion$resolve$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Tradfri.Gateway>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $ip;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ String $serviceName;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tradfri$Gateway$Companion$resolve$2(CoroutineScope coroutineScope, Context context, String str, String str2, Continuation<? super Tradfri$Gateway$Companion$resolve$2> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$context = context;
        this.$serviceName = str;
        this.$ip = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Tradfri$Gateway$Companion$resolve$2(this.$scope, this.$context, this.$serviceName, this.$ip, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Tradfri.Gateway>> continuation) {
        return ((Tradfri$Gateway$Companion$resolve$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = this.$scope;
        Context context = this.$context;
        String str = this.$serviceName;
        String str2 = this.$ip;
        this.L$0 = coroutineScope;
        this.L$1 = context;
        this.L$2 = str;
        this.L$3 = str2;
        this.label = 1;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new Tradfri$Gateway$Companion$resolve$2$1$1(coroutineScope, context, str, str2, safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(this);
        }
        return orThrow == coroutine_suspended ? coroutine_suspended : orThrow;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Tradfri.Gateway>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Tradfri.Gateway>>) continuation);
    }
}
