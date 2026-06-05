package com.launchdarkly.logging;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Logs {
    public static LDLogAdapter none() {
        return NullLogging.INSTANCE;
    }
}
