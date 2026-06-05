package com.urbandroid.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LoggingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        GlobalInitializator.initializeIfRequired(context);
    }
}
