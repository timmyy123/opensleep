package io.github.zeroone3010.yahueapi.v2;

import j$.time.ZonedDateTime;

/* JADX INFO: loaded from: classes5.dex */
final class TimeUtil {
    private static final String UTC_SUFFIX = "+00:00[UTC]";

    private TimeUtil() {
    }

    public static ZonedDateTime stringTimestampToZonedDateTime(String str) {
        return ZonedDateTime.parse(str + UTC_SUFFIX);
    }
}
