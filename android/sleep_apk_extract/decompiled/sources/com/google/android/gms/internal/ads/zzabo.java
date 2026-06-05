package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzabo {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzabp zzabpVar) {
        zzb(zzabpVar);
        this.zza.add(new zzabn(handler, zzabpVar));
    }

    public final void zzb(zzabp zzabpVar) {
        CopyOnWriteArrayList<zzabn> copyOnWriteArrayList = this.zza;
        for (zzabn zzabnVar : copyOnWriteArrayList) {
            if (zzabnVar.zzc() == zzabpVar) {
                zzabnVar.zza();
                copyOnWriteArrayList.remove(zzabnVar);
            }
        }
    }

    public final void zzc(final int i, final long j, final long j2) {
        for (final zzabn zzabnVar : this.zza) {
            if (!zzabnVar.zzd()) {
                zzabnVar.zzb().post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabm
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzabnVar.zzc().zzX(i, j, j2);
                    }
                });
            }
        }
    }
}
