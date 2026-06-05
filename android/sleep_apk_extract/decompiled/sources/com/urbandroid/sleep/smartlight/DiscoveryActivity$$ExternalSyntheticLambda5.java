package com.urbandroid.sleep.smartlight;

import android.preference.Preference;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.urbandroid.sleep.alarmclock.settings.BedtimeNoAlarmSettingsActivity;
import com.urbandroid.sleep.alarmclock.timepicker.IcsTimePickerWrapper;
import com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker;
import com.urbandroid.sleep.alarmclock.timepicker.TimePickerActivity;
import com.urbandroid.smartlight.common.model.Gateway;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class DiscoveryActivity$$ExternalSyntheticLambda5 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ DiscoveryActivity$$ExternalSyntheticLambda5(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$3;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (i) {
            case 0:
                DiscoveryActivity.inputSecurityCode$lambda$3((TextView) obj4, (AlertDialog) obj3, (DiscoveryActivity) obj2, (Gateway.Tradfri) obj, view);
                break;
            case 1:
                BedtimeNoAlarmSettingsActivity.refresh$lambda$2$0$0((BedtimeNoAlarmSettingsActivity) obj4, (String) obj3, (MaterialTimePicker) obj2, (Preference) obj, view);
                break;
            default:
                RoundTimePicker.createTimePickerDialog$lambda$8((IcsTimePickerWrapper) obj4, (TimePickerActivity) obj3, (RoundTimePicker) obj2, (NumberPicker) obj, view);
                break;
        }
    }
}
