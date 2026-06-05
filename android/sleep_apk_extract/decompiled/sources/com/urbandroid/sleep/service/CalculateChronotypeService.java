package com.urbandroid.sleep.service;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.FixedJobIntentService;
import androidx.core.app.JobIntentService;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;

/* JADX INFO: loaded from: classes4.dex */
public class CalculateChronotypeService extends FixedJobIntentService {
    public static int CALCULATE_CHRONOTYPE_INTERVAL = 604800000;
    public static int CALCULATE_CHRONOTYPE_WHEN_MIN_RECORDS = 30;

    public static void calculateChronotype(Context context) {
        Settings settings = new Settings(context);
        if (settings.getRecordsCount() <= CALCULATE_CHRONOTYPE_WHEN_MIN_RECORDS || !settings.isTimeToCalculateChronotype()) {
            return;
        }
        JobIntentService.enqueueWork(context, (Class<?>) CalculateChronotypeService.class, 1002, new Intent());
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(Intent intent) {
        GlobalInitializator.initializeIfRequired(this);
        StatRepo.calculateChronotype(getApplicationContext());
    }
}
