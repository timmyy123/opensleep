package com.urbandroid.sleep;

import android.os.AsyncTask;
import com.urbandroid.sleep.domain.SleepRecord;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SleepRecordFilterFilterAsyncTask extends AsyncTask<Void, Void, List<Float>> {
    private final SleepRecord record;
    private static AtomicBoolean calculationInProgress = new AtomicBoolean(false);
    private static List<Float> lastCalculationResult = null;
    private static Object FILTER_LOCK = new Object();

    public SleepRecordFilterFilterAsyncTask(SleepRecord sleepRecord) {
        this.record = sleepRecord;
    }

    @Override // android.os.AsyncTask
    public List<Float> doInBackground(Void... voidArr) {
        if (calculationInProgress.compareAndSet(false, true)) {
            synchronized (FILTER_LOCK) {
                lastCalculationResult = null;
            }
            List<Float> filteredTempHistoryForCharting = this.record.getFilteredTempHistoryForCharting();
            synchronized (FILTER_LOCK) {
                lastCalculationResult = filteredTempHistoryForCharting;
                FILTER_LOCK.notifyAll();
            }
            calculationInProgress.set(false);
        } else {
            synchronized (FILTER_LOCK) {
                while (lastCalculationResult == null) {
                    try {
                        FILTER_LOCK.wait();
                    } catch (InterruptedException unused) {
                        return null;
                    }
                }
            }
        }
        return lastCalculationResult;
    }
}
