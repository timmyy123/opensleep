package com.google.android.material.chip;

import android.widget.CompoundButton;
import com.urbandroid.sleep.gui.AlarmTimePreference;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Chip$$ExternalSyntheticLambda0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Chip$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((Chip) obj).lambda$new$0(compoundButton, z);
                break;
            default:
                AlarmTimePreference.checkedListener$lambda$0((AlarmTimePreference) obj, compoundButton, z);
                break;
        }
    }
}
