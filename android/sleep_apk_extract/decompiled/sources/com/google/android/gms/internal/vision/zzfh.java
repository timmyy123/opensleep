package com.google.android.gms.internal.vision;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class zzfh extends zzfd {
    private final zzfg zza = new zzfg();

    @Override // com.google.android.gms.internal.vision.zzfd
    public final void zza(Throwable th) {
        th.printStackTrace();
        List<Throwable> listZza = this.zza.zza(th, false);
        if (listZza == null) {
            return;
        }
        synchronized (listZza) {
            try {
                for (Throwable th2 : listZza) {
                    System.err.print("Suppressed: ");
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
