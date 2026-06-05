package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
final class zzvx extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final /* bridge */ /* synthetic */ Object initialValue() {
        zzwq zzwqVar = new zzwq(zzrn.zza(Thread.currentThread()));
        Thread threadCurrentThread = Thread.currentThread();
        synchronized (zzvy.zze) {
            zzvy.zze.put(threadCurrentThread, zzwqVar);
        }
        return zzwqVar;
    }
}
