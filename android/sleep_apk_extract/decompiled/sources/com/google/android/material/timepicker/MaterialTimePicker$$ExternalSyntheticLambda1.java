package com.google.android.material.timepicker;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MaterialTimePicker$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MaterialTimePicker$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((MaterialTimePicker) obj).lambda$onCreateView$1(view);
                break;
            case 1:
                ((MaterialTimePicker) obj).lambda$onCreateView$2(view);
                break;
            default:
                ((TimePickerTextInputPresenter) obj).lambda$new$0(view);
                break;
        }
    }
}
