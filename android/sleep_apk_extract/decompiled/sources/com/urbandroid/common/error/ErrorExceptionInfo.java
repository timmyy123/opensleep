package com.urbandroid.common.error;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorExceptionInfo {
    private final Map<Thread, StackTraceElement[]> allTraces;
    private final String exceptionThreadName;
    private final Throwable throwable;

    public ErrorExceptionInfo(String str, Throwable th, Map<Thread, StackTraceElement[]> map) {
        this.exceptionThreadName = str;
        this.throwable = th;
        this.allTraces = map;
    }

    public Map<Thread, StackTraceElement[]> getAllTraces() {
        return new LinkedHashMap(this.allTraces);
    }

    public String getExceptionThreadName() {
        return this.exceptionThreadName;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
