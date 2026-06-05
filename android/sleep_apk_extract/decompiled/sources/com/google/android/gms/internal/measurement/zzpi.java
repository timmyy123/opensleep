package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
final class zzpi implements zzph {
    private volatile zzon zza;
    private zzpg zzb;

    public /* synthetic */ zzpi(zzon zzonVar, byte[] bArr) {
        this.zza = zzonVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzph
    public final zzpg zza(zzlk zzlkVar, String str) {
        Preconditions.checkArgument(true);
        zzon zzonVar = this.zza;
        zzon zzonVar2 = zzpg.zza;
        if (zzonVar != zzonVar2) {
            this.zzb = zzpg.zzd().zzc(zzlkVar, zzonVar, "").zza(zzlkVar, "");
            this.zza = zzonVar2;
        }
        return this.zzb;
    }
}
