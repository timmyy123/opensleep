package com.urbandroid.sleep;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Sleep$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Sleep f$0;

    public /* synthetic */ Sleep$$ExternalSyntheticLambda2(Sleep sleep, int i) {
        this.$r8$classId = i;
        this.f$0 = sleep;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Sleep sleep = this.f$0;
        switch (i) {
            case 0:
                sleep.lambda$onCreateOptionsMenu$7(view);
                break;
            case 1:
                sleep.lambda$onCreateOptionsMenu$8(view);
                break;
            case 2:
                sleep.lambda$onCreate$1(view);
                break;
            default:
                sleep.lambda$onCreate$2(view);
                break;
        }
    }
}
