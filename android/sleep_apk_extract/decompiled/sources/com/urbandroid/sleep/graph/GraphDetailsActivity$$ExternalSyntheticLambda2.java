package com.urbandroid.sleep.graph;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GraphDetailsActivity$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ GraphDetailsActivity f$0;

    public /* synthetic */ GraphDetailsActivity$$ExternalSyntheticLambda2(GraphDetailsActivity graphDetailsActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = graphDetailsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        GraphDetailsActivity graphDetailsActivity = this.f$0;
        switch (i) {
            case 0:
                graphDetailsActivity.lambda$buildFromIntent$0(view);
                break;
            case 1:
                graphDetailsActivity.lambda$displayRdi$10(view);
                break;
            case 2:
                graphDetailsActivity.lambda$displayRdi$11(view);
                break;
            case 3:
                graphDetailsActivity.lambda$displayRdi$12(view);
                break;
            case 4:
                graphDetailsActivity.lambda$updateTitle$13(view);
                break;
            case 5:
                graphDetailsActivity.lambda$setEditMode$5(view);
                break;
            default:
                graphDetailsActivity.lambda$setEditMode$6(view);
                break;
        }
    }
}
