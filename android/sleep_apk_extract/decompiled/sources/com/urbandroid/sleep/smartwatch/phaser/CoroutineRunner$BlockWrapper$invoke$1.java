package com.urbandroid.sleep.smartwatch.phaser;

import com.urbandroid.sleep.smartwatch.phaser.CoroutineRunner;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.CoroutineRunner$BlockWrapper", f = "CoroutineRunner.kt", l = {80}, m = "invoke", v = 2)
public final class CoroutineRunner$BlockWrapper$invoke$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutineRunner.BlockWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineRunner$BlockWrapper$invoke$1(CoroutineRunner.BlockWrapper blockWrapper, Continuation<? super CoroutineRunner$BlockWrapper$invoke$1> continuation) {
        super(continuation);
        this.this$0 = blockWrapper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
