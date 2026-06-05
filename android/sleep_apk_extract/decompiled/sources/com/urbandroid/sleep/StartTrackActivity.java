package com.urbandroid.sleep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.gui.KeyguardUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/StartTrackActivity;", "Landroid/app/Activity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StartTrackActivity extends Activity {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(SleepLockManager sleepLockManager, StartTrackActivity startTrackActivity) {
        Logger.logInfo("AutoTracking: StartTrackActivity finish StartTrackActivity");
        sleepLockManager.releaseScreenOnLock();
        startTrackActivity.finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        SleepLockManager sleepLockManager = new SleepLockManager(this);
        sleepLockManager.turnScreenOn(500);
        KeyguardUtil.disable(this);
        Intent intent = getIntent();
        Logger.logInfo("AutoTracking: StartTrackActivity Workaround for noise recording and sonar in Android 11");
        Intent intent2 = new Intent(intent);
        intent2.setClass(this, SleepService.class);
        intent2.setPackage(getPackageName());
        ContextExtKt.startForegroundServiceWithLog(this, intent2);
        new Handler().postDelayed(new StartTrackActivity$$ExternalSyntheticLambda0(sleepLockManager, this, 0), 1L);
    }
}
