package com.google.api.client.util;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BackOffUtils {
    public static boolean next(Sleeper sleeper, BackOff backOff) {
        long jNextBackOffMillis = backOff.nextBackOffMillis();
        if (jNextBackOffMillis == -1) {
            return false;
        }
        sleeper.sleep(jNextBackOffMillis);
        return true;
    }
}
