package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzacb implements Runnable {
    private final zzaca zza;

    public zzacb(zzaca zzacaVar) {
        this.zza = zzacaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzo();
    }
}
