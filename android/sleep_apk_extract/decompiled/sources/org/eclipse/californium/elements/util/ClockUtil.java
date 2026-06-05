package org.eclipse.californium.elements.util;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ClockUtil {
    private static volatile Realtime handler = new Realtime() { // from class: org.eclipse.californium.elements.util.ClockUtil.1
        @Override // org.eclipse.californium.elements.util.ClockUtil.Realtime
        public long nanoRealtime() {
            return System.nanoTime();
        }
    };

    public interface Realtime {
        long nanoRealtime();
    }

    public static long nanoRealtime() {
        return handler.nanoRealtime();
    }
}
