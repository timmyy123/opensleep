package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public interface LottieLogger {
    void debug(String str);

    void error(String str, Throwable th);

    void warning(String str);

    void warning(String str, Throwable th);
}
