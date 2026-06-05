package com.urbandroid.sleep.alarmclock;

import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.AppFunctionException;
import androidx.core.app.FixedJobIntentService;
import androidx.core.app.JobIntentService;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class FrequentGeoService extends FixedJobIntentService {
    public static void start(Context context) {
        JobIntentService.enqueueWork(context, (Class<?>) FrequentGeoService.class, AppFunctionException.ERROR_FUNCTION_NOT_FOUND, new Intent());
    }

    public void calculate() {
        GlobalInitializator.initializeIfRequired(this);
        Settings settings = SharedApplicationContext.getSettings();
        DbSleepRecordRepository.GeoResult frequentGeos = SharedApplicationContext.getInstance().getSleepRecordRepository().getFrequentGeos(settings.getGeoTimeFrom());
        Logger.logInfo(frequentGeos.toString());
        settings.setMaxGeoFreq(frequentGeos.getHomeFreq());
        settings.setGeos(frequentGeos.getGeos());
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(Intent intent) {
        calculate();
    }
}
