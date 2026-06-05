package com.urbandroid.sleep.fragment.preview;

import android.app.Activity;
import android.view.ViewGroup;
import com.urbandroid.sleep.alarmclock.UnlockFlow;
import java.io.Serializable;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PremiumPreviewPage$$ExternalSyntheticLambda0 implements UnlockFlow.UnlockFlowListener, Serializable {
    public final /* synthetic */ ViewGroup f$0;
    public final /* synthetic */ Ref$ObjectRef f$1;
    public final /* synthetic */ Activity f$2;
    public final /* synthetic */ PremiumPreviewPage f$3;

    public /* synthetic */ PremiumPreviewPage$$ExternalSyntheticLambda0(ViewGroup viewGroup, Ref$ObjectRef ref$ObjectRef, Activity activity, PremiumPreviewPage premiumPreviewPage) {
        this.f$0 = viewGroup;
        this.f$1 = ref$ObjectRef;
        this.f$2 = activity;
        this.f$3 = premiumPreviewPage;
    }

    @Override // com.urbandroid.sleep.alarmclock.UnlockFlow.UnlockFlowListener
    public final void onBackButton() {
        PremiumPreviewPage.adjustLayout$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
