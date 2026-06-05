package com.urbandroid.sleep.alarmclock.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity", f = "ServicesSettingsActivity.kt", l = {613}, m = "onActivityResult$showConsentScreenIfNeeded", v = 2)
public final class ServicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ServicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1(Continuation<? super ServicesSettingsActivity$onActivityResult$showConsentScreenIfNeeded$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ServicesSettingsActivity.onActivityResult$showConsentScreenIfNeeded(null, this);
    }
}
