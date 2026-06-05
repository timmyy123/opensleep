package com.urbandroid.sleep.graph;

import android.widget.ScrollView;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GraphDetailsActivity$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ScrollView f$0;

    public /* synthetic */ GraphDetailsActivity$$ExternalSyntheticLambda5(ScrollView scrollView, int i) {
        this.$r8$classId = i;
        this.f$0 = scrollView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        ScrollView scrollView = this.f$0;
        switch (i) {
            case 0:
                GraphDetailsActivity.lambda$buildFromIntent$3(scrollView);
                break;
            case 1:
                GraphDetailsActivity.lambda$buildFromIntent$4(scrollView);
                break;
            default:
                GraphDetailsActivity.lambda$setEditMode$7(scrollView);
                break;
        }
    }
}
