package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzena extends zzbwo {
    final /* synthetic */ zzenb zza;
    private final zzelv zzb;

    public /* synthetic */ zzena(zzenb zzenbVar, zzelv zzelvVar, byte[] bArr) {
        Objects.requireNonNull(zzenbVar);
        this.zza = zzenbVar;
        this.zzb = zzelvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwp
    public final void zze(IObjectWrapper iObjectWrapper) {
        this.zza.zzd((View) ObjectWrapper.unwrap(iObjectWrapper));
        ((zzenh) this.zzb.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbwp
    public final void zzf(String str) {
        ((zzenh) this.zzb.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbwp
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) {
        ((zzenh) this.zzb.zzc).zzx(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwp
    public final void zzh(zzbvl zzbvlVar) {
        this.zza.zze(zzbvlVar);
        ((zzenh) this.zzb.zzc).zzj();
    }
}
