package com.google.android.gms.internal.ads;

import android.app.AppOpsManager$OnOpActiveChangedListener;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbca implements AppOpsManager$OnOpActiveChangedListener {
    final /* synthetic */ zzbcb zza;

    public zzbca(zzbcb zzbcbVar) {
        Objects.requireNonNull(zzbcbVar);
        this.zza = zzbcbVar;
    }

    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        zzbcb zzbcbVar = this.zza;
        if (z) {
            zzbcbVar.zze(System.currentTimeMillis());
            zzbcbVar.zzh(true);
            return;
        }
        long jZzf = zzbcbVar.zzf();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jZzf > 0 && jCurrentTimeMillis >= zzbcbVar.zzf()) {
            zzbcbVar.zzg(jCurrentTimeMillis - zzbcbVar.zzf());
        }
        zzbcbVar.zzh(false);
    }
}
