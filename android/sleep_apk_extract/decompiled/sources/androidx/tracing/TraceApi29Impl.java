package androidx.tracing;

/* JADX INFO: loaded from: classes.dex */
abstract class TraceApi29Impl {
    public static void beginAsyncSection(String str, int i) {
        android.os.Trace.beginAsyncSection(str, i);
    }

    public static void endAsyncSection(String str, int i) {
        android.os.Trace.endAsyncSection(str, i);
    }

    public static boolean isEnabled() {
        return android.os.Trace.isEnabled();
    }
}
