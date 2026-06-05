package com.launchdarkly.logging;

import com.launchdarkly.logging.LDLogAdapter;

/* JADX INFO: loaded from: classes4.dex */
public final class LDLogger {
    final LDLogAdapter adapter;
    private final LDLogAdapter.Channel channel;
    private final String name;

    public LDLogger(String str, LDLogAdapter lDLogAdapter, LDLogAdapter.Channel channel) {
        this.name = str;
        this.adapter = lDLogAdapter;
        this.channel = channel;
    }

    public static LDLogger none() {
        return withAdapter(Logs.none(), "");
    }

    public static LDLogger withAdapter(LDLogAdapter lDLogAdapter, String str) {
        return new LDLogger(str, lDLogAdapter, lDLogAdapter.newChannel(str));
    }

    public void debug(Object obj) {
        this.channel.log(LDLogLevel.DEBUG, obj);
    }

    public void info(String str, Object obj) {
        this.channel.log(LDLogLevel.INFO, str, obj);
    }

    public void warn(String str, Object obj) {
        this.channel.log(LDLogLevel.WARN, str, obj);
    }

    public void debug(String str, Object obj) {
        this.channel.log(LDLogLevel.DEBUG, str, obj);
    }
}
