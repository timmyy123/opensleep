package com.urbandroid.sleep.alarmclock.timepicker;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public class IcsTimePickerWrapper extends AbstractTimePickerWrapper {
    private android.widget.TimePicker timePicker;

    public IcsTimePickerWrapper(Context context, android.widget.TimePicker timePicker) {
        super(context);
        this.timePicker = timePicker;
    }

    public void confirm() {
        if (this.timePicker == null || new Settings(getContext()).isNewTimepicker()) {
            return;
        }
        Logger.logInfo("TimePicker: confirm()");
        this.timePicker.clearFocus();
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.ITimePickerWrapper
    public int getHour() {
        android.widget.TimePicker timePicker = this.timePicker;
        if (timePicker != null) {
            return timePicker.getCurrentHour().intValue();
        }
        return 0;
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.ITimePickerWrapper
    public int getMinute() {
        android.widget.TimePicker timePicker = this.timePicker;
        if (timePicker != null) {
            return timePicker.getCurrentMinute().intValue();
        }
        return 0;
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.ITimePickerWrapper
    public void setState(int i, int i2, boolean z) {
        android.widget.TimePicker timePicker = this.timePicker;
        if (timePicker != null) {
            timePicker.setIs24HourView(Boolean.valueOf(z));
            this.timePicker.setCurrentHour(Integer.valueOf(i));
            this.timePicker.setCurrentMinute(Integer.valueOf(i2));
        }
    }
}
