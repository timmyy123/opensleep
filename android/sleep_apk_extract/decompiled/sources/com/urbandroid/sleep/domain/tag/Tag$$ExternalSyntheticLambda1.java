package com.urbandroid.sleep.domain.tag;

import android.view.View;
import android.widget.EditText;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Tag$$ExternalSyntheticLambda1 implements View.OnLongClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Tag$$ExternalSyntheticLambda1(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                return Tag.lambda$handleTag$1((EditText) obj2, (String) obj, view);
            default:
                return ((DashboardCard) obj2).lambda$getViewHolder$1((DashboardCard) obj, view);
        }
    }
}
