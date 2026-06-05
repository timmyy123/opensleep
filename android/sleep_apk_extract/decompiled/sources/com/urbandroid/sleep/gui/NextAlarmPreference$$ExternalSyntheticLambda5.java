package com.urbandroid.sleep.gui;

import android.view.View;
import com.urbandroid.sleep.fragment.dashboard.card.UnlockCard;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class NextAlarmPreference$$ExternalSyntheticLambda5 implements View.OnLongClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ NextAlarmPreference$$ExternalSyntheticLambda5(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return NextAlarmPreference.onCreateView$lambda$4((NextAlarmPreference) obj, view);
            case 1:
                return NextAlarmPreference.onCreateView$lambda$5((NextAlarmPreference) obj, view);
            default:
                return UnlockCard.bindView$lambda$0$0((UnlockCard) obj, view);
        }
    }
}
