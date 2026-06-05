package com.urbandroid.sleep.sensor.respiration.v2;

import com.urbandroid.util.StringBufferPersister;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/sensor/respiration/v2/BreathLogger;", "androidSleepDataLogger", "()Lcom/urbandroid/sleep/sensor/respiration/v2/BreathLogger;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class BreathLoggerKt {
    public static final BreathLogger androidSleepDataLogger() {
        final StringBufferPersister stringBufferPersister = new StringBufferPersister("breath_details", 10000, true);
        return new BreathLogger() { // from class: com.urbandroid.sleep.sensor.respiration.v2.BreathLoggerKt.androidSleepDataLogger.1
            @Override // com.urbandroid.sleep.sensor.respiration.v2.BreathLogger
            public void log(String s) {
                s.getClass();
                stringBufferPersister.update(s);
                stringBufferPersister.flush();
            }
        };
    }
}
