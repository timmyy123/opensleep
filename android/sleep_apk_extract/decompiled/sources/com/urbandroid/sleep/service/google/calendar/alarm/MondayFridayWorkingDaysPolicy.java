package com.urbandroid.sleep.service.google.calendar.alarm;

import java.util.Calendar;

/* JADX INFO: loaded from: classes5.dex */
public class MondayFridayWorkingDaysPolicy implements WorkingDaysPolicy {
    @Override // com.urbandroid.sleep.service.google.calendar.alarm.WorkingDaysPolicy
    public boolean isWorkingDay(Calendar calendar) {
        int i = calendar.get(7);
        return (i == 7 || i == 1) ? false : true;
    }
}
