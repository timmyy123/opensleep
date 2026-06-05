package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzdsq implements zzhbt {
    final /* synthetic */ zzcfw zza;

    public zzdsq(zzdtc zzdtcVar, zzcfw zzcfwVar) {
        this.zza = zzcfwVar;
        Objects.requireNonNull(zzdtcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to load media data due to video view load failure.");
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcku zzckuVar = (zzcku) obj;
        final zzcfw zzcfwVar = this.zza;
        if (zzckuVar == null) {
            zzcfwVar.zzd(new zzeph(1, "Missing webview from video view future."));
        } else {
            zzckuVar.zzab("/video", new zzcim(new zzcil() { // from class: com.google.android.gms.internal.ads.zzdsp
                @Override // com.google.android.gms.internal.ads.zzcil
                public final /* synthetic */ void zza(String str) {
                    zzcfwVar.zzc(zzba$$ExternalSyntheticOutline0.m("mediaUrl", str));
                }
            }));
            zzckuVar.zzI();
        }
    }
}
