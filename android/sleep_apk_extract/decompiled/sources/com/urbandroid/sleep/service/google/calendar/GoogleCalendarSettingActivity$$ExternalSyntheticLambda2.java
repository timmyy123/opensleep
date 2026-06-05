package com.urbandroid.sleep.service.google.calendar;

import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.gui.SeekBarPreference;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class GoogleCalendarSettingActivity$$ExternalSyntheticLambda2 implements SeekBarPreference.IFormatter {
    @Override // com.urbandroid.sleep.gui.SeekBarPreference.IFormatter
    public final String format(int i) {
        return DateUtil.formatDuration(i);
    }
}
