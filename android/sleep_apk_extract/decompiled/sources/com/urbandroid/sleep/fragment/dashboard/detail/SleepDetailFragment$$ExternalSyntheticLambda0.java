package com.urbandroid.sleep.fragment.dashboard.detail;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SleepDetailFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SleepDetailFragment f$0;
    public final /* synthetic */ FragmentActivity f$1;

    public /* synthetic */ SleepDetailFragment$$ExternalSyntheticLambda0(SleepDetailFragment sleepDetailFragment, FragmentActivity fragmentActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = sleepDetailFragment;
        this.f$1 = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        FragmentActivity fragmentActivity = this.f$1;
        SleepDetailFragment sleepDetailFragment = this.f$0;
        switch (i) {
            case 0:
                SleepDetailFragment.initFab$lambda$0$0$0(sleepDetailFragment, fragmentActivity, view);
                break;
            case 1:
                SleepDetailFragment$reload$1$1.invokeSuspend$lambda$0(sleepDetailFragment, fragmentActivity, view);
                break;
            case 2:
                SleepDetailFragment$reload$1$1.invokeSuspend$lambda$1(sleepDetailFragment, fragmentActivity, view);
                break;
            default:
                SleepDetailFragment$reload$1$1.invokeSuspend$lambda$2(sleepDetailFragment, fragmentActivity, view);
                break;
        }
    }
}
