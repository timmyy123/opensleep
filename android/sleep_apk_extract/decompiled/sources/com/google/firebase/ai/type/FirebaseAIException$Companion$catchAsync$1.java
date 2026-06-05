package com.google.firebase.ai.type;

import com.google.firebase.ai.type.FirebaseAIException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.ai.type.FirebaseAIException$Companion", f = "Exceptions.kt", l = {63}, m = "catchAsync$com_google_firebase_ai_logic_firebase_ai")
public final class FirebaseAIException$Companion$catchAsync$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FirebaseAIException.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseAIException$Companion$catchAsync$1(FirebaseAIException.Companion companion, Continuation<? super FirebaseAIException$Companion$catchAsync$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.catchAsync$com_google_firebase_ai_logic_firebase_ai(null, this);
    }
}
