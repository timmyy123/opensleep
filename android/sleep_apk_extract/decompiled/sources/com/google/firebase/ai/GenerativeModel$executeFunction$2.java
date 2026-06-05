package com.google.firebase.ai;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.ai.GenerativeModel", f = "GenerativeModel.kt", l = {280}, m = "executeFunction$com_google_firebase_ai_logic_firebase_ai")
public final class GenerativeModel$executeFunction$2<I, O> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GenerativeModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenerativeModel$executeFunction$2(GenerativeModel generativeModel, Continuation<? super GenerativeModel$executeFunction$2> continuation) {
        super(continuation);
        this.this$0 = generativeModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeFunction$com_google_firebase_ai_logic_firebase_ai(null, null, null, this);
    }
}
