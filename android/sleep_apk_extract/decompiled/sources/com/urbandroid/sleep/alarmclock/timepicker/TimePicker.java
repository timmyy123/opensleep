package com.urbandroid.sleep.alarmclock.timepicker;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/timepicker/TimePicker;", "", "setState", "", "hour", "", "minute", "is24", "", "getHour", "getMinute", "isShown", "dismiss", "show", "activity", "Landroidx/fragment/app/FragmentActivity;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface TimePicker {
    void dismiss();

    int getHour();

    int getMinute();

    boolean isShown();

    void setState(int hour, int minute, boolean is24);

    void show(FragmentActivity activity);
}
