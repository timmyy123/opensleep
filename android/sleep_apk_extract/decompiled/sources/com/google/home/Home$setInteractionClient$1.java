package com.google.home;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.Home", f = "Home.kt", l = {130}, m = "setInteractionClient$java_com_google_android_gmscore_integ_client_home_home")
public final class Home$setInteractionClient$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Home this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Home$setInteractionClient$1(Home home, Continuation<? super Home$setInteractionClient$1> continuation) {
        super(continuation);
        this.this$0 = home;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setInteractionClient$java_com_google_android_gmscore_integ_client_home_home(null, this);
    }
}
