package com.urbandroid.util;

import j$.util.DesugarTimeZone;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TimeZoneUtils {
    public static TimeZone resolve(long j, TimeUnit timeUnit) {
        long millis = timeUnit.toMillis(j) % 46800000;
        long j2 = millis / 3600000;
        TimeZone timeZone = TimeZone.getDefault();
        if (timeZone.getRawOffset() == millis) {
            return timeZone;
        }
        StringBuilder sb = new StringBuilder("GMT");
        sb.append(j2 < 0 ? "-" : MqttTopic.SINGLE_LEVEL_WILDCARD);
        sb.append(Math.abs(j2));
        return DesugarTimeZone.getTimeZone(sb.toString());
    }

    public static TimeZone resolveFix(long j, TimeUnit timeUnit) {
        return resolve(j, timeUnit);
    }
}
