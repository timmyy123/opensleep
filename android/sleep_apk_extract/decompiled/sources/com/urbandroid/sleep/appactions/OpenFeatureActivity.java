package com.urbandroid.sleep.appactions;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.alarmclock.AlarmActivity;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.graph.GraphDetailsActivity;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/appactions/OpenFeatureActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OpenFeatureActivity extends BaseActivity implements FeatureLogger {
    private final String tag = "OpenFeatureActivity";

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        String encodedPath;
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        Uri data2 = getIntent().getData();
        String strM = FileInsert$$ExternalSyntheticOutline0.m("path: ", data2 != null ? data2.getEncodedPath() : null);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        Uri data3 = getIntent().getData();
        String strSubstringAfterLast$default = (data3 == null || (encodedPath = data3.getEncodedPath()) == null) ? null : StringsKt__StringsKt.substringAfterLast$default(encodedPath, MqttTopic.TOPIC_LEVEL_SEPARATOR, (String) null, 2, (Object) null);
        String strM2 = FileInsert$$ExternalSyntheticOutline0.m("feature: ", strSubstringAfterLast$default);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM2, null);
        if (strSubstringAfterLast$default != null) {
            switch (strSubstringAfterLast$default.hashCode()) {
                case -1415196606:
                    if (strSubstringAfterLast$default.equals("alarms")) {
                        startActivity(new Intent(this, (Class<?>) AlarmActivity.class));
                    }
                    break;
                case -1047860588:
                    if (strSubstringAfterLast$default.equals("dashboard")) {
                        startActivity(new Intent(this, (Class<?>) AlarmClock.class));
                    }
                    break;
                case -818893886:
                    if (strSubstringAfterLast$default.equals("start-tracking")) {
                        Logger.logDebug(Logger.defaultTag, getTag() + ": Trying to start-tracking", null);
                        new SleepStarter().startSleep(getApplicationContext());
                    }
                    break;
                case 850726112:
                    if (strSubstringAfterLast$default.equals("last-sleep")) {
                        SleepRecord lastSleepRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().getLastSleepRecord();
                        Intent intent = new Intent(this, (Class<?>) GraphDetailsActivity.class);
                        intent.putExtra("SleepRecord", (Parcelable) lastSleepRecord);
                        startActivity(intent);
                    }
                    break;
                case 1818721314:
                    if (strSubstringAfterLast$default.equals("stop-tracking")) {
                        ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK"), null, 2, null);
                    }
                    break;
            }
        }
        finish();
    }
}
