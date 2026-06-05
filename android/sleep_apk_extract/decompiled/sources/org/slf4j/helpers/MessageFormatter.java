package org.slf4j.helpers;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MessageFormatter {
    public static Throwable getThrowableCandidate(Object[] objArr) {
        return NormalizedParameters.getThrowableCandidate(objArr);
    }

    public static Object[] trimmedCopy(Object[] objArr) {
        return NormalizedParameters.trimmedCopy(objArr);
    }
}
