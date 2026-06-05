package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcez extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzcfd zza;

    public zzcez(zzcfd zzcfdVar) {
        Objects.requireNonNull(zzcfdVar);
        this.zza = zzcfdVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        zzcfd zzcfdVar = this.zza;
        zzbit zzbitVar = new zzbit(zzcfdVar.zzz(), zzcfdVar.zzA().afmaVersion);
        synchronized (zzcfdVar.zzy()) {
            try {
                com.google.android.gms.ads.internal.zzt.zzm();
                zzbiw.zza(zzcfdVar.zzB(), zzbitVar);
            } catch (IllegalArgumentException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot config CSI reporter.", e);
            }
        }
    }
}
