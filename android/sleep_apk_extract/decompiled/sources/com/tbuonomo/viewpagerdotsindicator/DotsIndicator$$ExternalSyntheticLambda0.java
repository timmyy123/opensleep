package com.tbuonomo.viewpagerdotsindicator;

import android.view.View;
import com.urbandroid.sleep.gui.drawer.DrawerRecyclerViewAdapter;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class DotsIndicator$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ DotsIndicator$$ExternalSyntheticLambda0(Object obj, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        int i2 = this.f$1;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                DotsIndicator.addDot$lambda$0((DotsIndicator) obj, i2, view);
                break;
            default:
                ((DrawerRecyclerViewAdapter) obj).lambda$onBindViewHolder$0(i2, view);
                break;
        }
    }
}
