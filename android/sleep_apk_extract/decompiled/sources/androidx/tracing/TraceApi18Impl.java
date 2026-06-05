package androidx.tracing;

/* JADX INFO: loaded from: classes.dex */
abstract class TraceApi18Impl {
    public static void beginSection(String str) {
        android.os.Trace.beginSection(str);
    }

    public static void endSection() {
        android.os.Trace.endSection();
    }
}
