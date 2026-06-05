package com.urbandroid.common;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LoggingService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Logger.logInfo(BaseActivity.traceIntent(BaseActivity.traceMethod(getClass(), "onBind"), intent).toString());
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger.logDebug(BaseActivity.traceMethod(getClass(), "onDestroy").toString());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Logger.logInfo(BaseActivity.traceIntent(BaseActivity.traceMethod(getClass(), "onStartCommand"), intent).toString());
        return super.onStartCommand(intent, i, i2);
    }
}
