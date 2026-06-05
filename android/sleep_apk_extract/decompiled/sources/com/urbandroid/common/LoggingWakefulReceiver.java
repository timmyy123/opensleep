package com.urbandroid.common;

import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.WakefulForegroundBroadcastReceiver;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LoggingWakefulReceiver extends WakefulForegroundBroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        GlobalInitializator.initializeIfRequired(context);
        Logger.logInfo(BaseActivity.traceIntent(BaseActivity.traceMethod(getClass(), "onReceive"), intent).toString());
    }
}
