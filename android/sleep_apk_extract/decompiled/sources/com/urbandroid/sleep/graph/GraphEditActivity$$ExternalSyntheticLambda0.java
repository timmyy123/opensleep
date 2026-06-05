package com.urbandroid.sleep.graph;

import android.view.KeyEvent;
import android.widget.HorizontalScrollView;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GraphEditActivity$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ KeyEvent.Callback f$0;

    public /* synthetic */ GraphEditActivity$$ExternalSyntheticLambda0(KeyEvent.Callback callback, int i) {
        this.$r8$classId = i;
        this.f$0 = callback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        KeyEvent.Callback callback = this.f$0;
        switch (i) {
            case 0:
                ((GraphEditActivity) callback).removeSelectHint();
                break;
            case 1:
                GraphDetailsActivity.lambda$buildFromIntent$1((HorizontalScrollView) callback);
                break;
            default:
                GraphDetailsActivity.lambda$buildFromIntent$2((HorizontalScrollView) callback);
                break;
        }
    }
}
