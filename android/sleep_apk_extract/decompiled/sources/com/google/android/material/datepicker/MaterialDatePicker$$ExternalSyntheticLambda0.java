package com.google.android.material.datepicker;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MaterialDatePicker$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MaterialDatePicker f$0;

    public /* synthetic */ MaterialDatePicker$$ExternalSyntheticLambda0(MaterialDatePicker materialDatePicker, int i) {
        this.$r8$classId = i;
        this.f$0 = materialDatePicker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        MaterialDatePicker materialDatePicker = this.f$0;
        switch (i) {
            case 0:
                materialDatePicker.onPositiveButtonClick(view);
                break;
            case 1:
                materialDatePicker.onNegativeButtonClick(view);
                break;
            default:
                materialDatePicker.lambda$initHeaderToggle$0(view);
                break;
        }
    }
}
