package com.urbandroid.sleep.addon.stats;

import android.os.AsyncTask;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.urbandroid.sleep.addon.stats.ChartFragment;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ChartFragment$3$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AsyncTask f$0;
    public final /* synthetic */ KeyEvent.Callback f$1;

    public /* synthetic */ ChartFragment$3$$ExternalSyntheticLambda0(AsyncTask asyncTask, KeyEvent.Callback callback, int i) {
        this.$r8$classId = i;
        this.f$0 = asyncTask;
        this.f$1 = callback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        KeyEvent.Callback callback = this.f$1;
        AsyncTask asyncTask = this.f$0;
        switch (i) {
            case 0:
                ((ChartFragment.AnonymousClass3) asyncTask).lambda$createViews$0((ViewGroup) callback);
                break;
            default:
                ((ChartFragment.AnonymousClass5) asyncTask).lambda$createViews$1((FragmentActivity) callback);
                break;
        }
    }
}
