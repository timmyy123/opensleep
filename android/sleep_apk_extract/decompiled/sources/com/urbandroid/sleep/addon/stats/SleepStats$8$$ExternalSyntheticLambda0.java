package com.urbandroid.sleep.addon.stats;

import android.graphics.drawable.AnimatedVectorDrawable;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.StatRepoBinderKt;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SleepStats$8$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SleepStats$8$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((SleepStats.AnonymousClass8) obj).lambda$onPostExecute$0();
                break;
            default:
                StatRepoBinderKt.AnonymousClass3.onAnimationEnd$lambda$0((AnimatedVectorDrawable) obj);
                break;
        }
    }
}
