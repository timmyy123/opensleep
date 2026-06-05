package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzwh implements Runnable {
    static final /* synthetic */ zzwh zza = new zzwh();

    private /* synthetic */ zzwh() {
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        throw new IllegalStateException("Span was closed by an invalid call to SpanEndSignal.run()");
    }
}
