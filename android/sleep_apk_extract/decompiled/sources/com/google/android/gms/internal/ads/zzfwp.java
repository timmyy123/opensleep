package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzfwp implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (zzfws.zzc != null) {
            zzfws.zzc.post(zzfws.zzk);
            zzfws.zzc.postDelayed(zzfws.zzl, 200L);
        }
    }
}
