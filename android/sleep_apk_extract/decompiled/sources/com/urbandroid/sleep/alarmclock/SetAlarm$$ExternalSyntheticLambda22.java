package com.urbandroid.sleep.alarmclock;

import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.squareup.kotlinpoet.TypeSpec$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SetAlarm$$ExternalSyntheticLambda22 implements MaterialPickerOnPositiveButtonClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SetAlarm$$ExternalSyntheticLambda22(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
    public final void onPositiveButtonClick(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                ((SetAlarm) obj2).lambda$showDatePicker$20((Long) obj);
                break;
            default:
                ((TypeSpec$$ExternalSyntheticLambda0) obj2).invoke(obj);
                break;
        }
    }
}
