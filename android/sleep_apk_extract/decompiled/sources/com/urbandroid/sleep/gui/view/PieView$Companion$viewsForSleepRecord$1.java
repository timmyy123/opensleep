package com.urbandroid.sleep.gui.view;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.home.platform.traits.ValidationIssue;
import com.urbandroid.sleep.gui.view.PieView;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.gui.view.PieView$Companion", f = "PieView.kt", l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN, ValidationIssue.UNSUPPORTED_ENTITY_EVENT_FIELD_NUMBER}, m = "viewsForSleepRecord", v = 2)
public final class PieView$Companion$viewsForSleepRecord$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PieView.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PieView$Companion$viewsForSleepRecord$1(PieView.Companion companion, Continuation<? super PieView$Companion$viewsForSleepRecord$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.viewsForSleepRecord(0, null, null, null, null, 0, 0, false, 0, null, this);
    }
}
