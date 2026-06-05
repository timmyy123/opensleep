package com.launchdarkly.logging;

/* JADX INFO: loaded from: classes4.dex */
public interface LDLogAdapter {

    public interface Channel {
        void log(LDLogLevel lDLogLevel, Object obj);

        void log(LDLogLevel lDLogLevel, String str, Object obj);
    }

    Channel newChannel(String str);
}
