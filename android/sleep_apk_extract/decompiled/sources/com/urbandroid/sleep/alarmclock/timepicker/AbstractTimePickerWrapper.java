package com.urbandroid.sleep.alarmclock.timepicker;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractTimePickerWrapper implements ITimePickerWrapper {
    private Context context;

    public AbstractTimePickerWrapper(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }
}
