package com.launchdarkly.eventsource;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
abstract class Helpers {
    static final Charset UTF8 = Charset.forName(OAuth.ENCODING);

    public static long millisFromTimeUnit(long j, TimeUnit timeUnit) {
        return timeUnitOrDefault(timeUnit).toMillis(j);
    }

    public static TimeUnit timeUnitOrDefault(TimeUnit timeUnit) {
        return timeUnit == null ? TimeUnit.MILLISECONDS : timeUnit;
    }

    public static String utf8ByteArrayOutputStreamToString(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return byteArrayOutputStream.toString(UTF8.name());
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
