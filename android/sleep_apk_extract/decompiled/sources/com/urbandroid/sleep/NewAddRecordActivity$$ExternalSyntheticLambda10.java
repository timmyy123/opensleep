package com.urbandroid.sleep;

import android.view.View;
import com.google.android.material.timepicker.MaterialTimePicker;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class NewAddRecordActivity$$ExternalSyntheticLambda10 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ NewAddRecordActivity f$0;
    public final /* synthetic */ MaterialTimePicker f$1;

    public /* synthetic */ NewAddRecordActivity$$ExternalSyntheticLambda10(NewAddRecordActivity newAddRecordActivity, MaterialTimePicker materialTimePicker, int i) {
        this.$r8$classId = i;
        this.f$0 = newAddRecordActivity;
        this.f$1 = materialTimePicker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        MaterialTimePicker materialTimePicker = this.f$1;
        NewAddRecordActivity newAddRecordActivity = this.f$0;
        switch (i) {
            case 0:
                newAddRecordActivity.lambda$onCreate$2(materialTimePicker, view);
                break;
            default:
                newAddRecordActivity.lambda$onCreate$4(materialTimePicker, view);
                break;
        }
    }
}
