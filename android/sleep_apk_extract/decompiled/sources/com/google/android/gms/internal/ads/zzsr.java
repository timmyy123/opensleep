package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzsr implements zzte {
    final /* synthetic */ zzsy zza;

    public /* synthetic */ zzsr(zzsy zzsyVar, byte[] bArr) {
        Objects.requireNonNull(zzsyVar);
        this.zza = zzsyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zza(long j) {
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 41);
        sb.append("Ignoring impossibly large audio latency: ");
        sb.append(j);
        zzeg.zzc("AudioTrackAudioOutput", sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzte
    public final void zzb(final long j) {
        zzsy zzsyVar = this.zza;
        if (zzsyVar.zzu().zzb()) {
            zzef zzefVarZzu = zzsyVar.zzu();
            zzefVarZzu.zze(-1, new zzea() { // from class: com.google.android.gms.internal.ads.zzsq
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj) {
                    ((zzqt) obj).zza(j);
                }
            });
            zzefVarZzu.zzf();
        }
    }
}
