package com.urbandroid.sleep.graph;

import android.view.View;
import com.urbandroid.sleep.graph.GraphDetailsActivity;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GraphEditActivity$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ GraphEditActivity$$ExternalSyntheticLambda3(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((GraphEditActivity) obj).lambda$showUndoToast$4(view);
                break;
            case 1:
                ((GraphEditActivity) obj).lambda$showAddSleep$0(view);
                break;
            case 2:
                ((GraphEditActivity) obj).lambda$showAddSleep$1(view);
                break;
            default:
                ((GraphDetailsActivity.AnonymousClass7) obj).lambda$onPostExecute$1(view);
                break;
        }
    }
}
