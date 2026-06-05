package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
public final class zzyg extends Exception {
    public zzyg(Throwable th, zzyv zzyvVar, StackTraceElement[] stackTraceElementArr) {
        super(zzyvVar.toString(), th);
        setStackTrace(stackTraceElementArr);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }
}
