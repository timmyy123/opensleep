package com.urbandroid.sleep.alarmclock.settings;

import android.graphics.drawable.AnimatedVectorDrawable;
import com.urbandroid.sleep.alarmclock.settings.SearchActivity;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SearchActivity$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AnimatedVectorDrawable f$0;

    public /* synthetic */ SearchActivity$$ExternalSyntheticLambda2(AnimatedVectorDrawable animatedVectorDrawable, int i) {
        this.$r8$classId = i;
        this.f$0 = animatedVectorDrawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        AnimatedVectorDrawable animatedVectorDrawable = this.f$0;
        switch (i) {
            case 0:
                SearchActivity.onCreate$lambda$2(animatedVectorDrawable);
                break;
            default:
                SearchActivity.AnonymousClass4.onAnimationStart$lambda$0(animatedVectorDrawable);
                break;
        }
    }
}
