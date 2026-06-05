package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzpb implements zzpo {
    final /* synthetic */ zzpg zza;

    public zzpb(zzpg zzpgVar) {
        Objects.requireNonNull(zzpgVar);
        this.zza = zzpgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzpo
    public final void zza(String str, String str2, Bundle bundle) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zzpg zzpgVar = this.zza;
        if (!zIsEmpty) {
            zzpgVar.zzaX().zzj(new zzpa(this, str, str2, bundle));
        } else if (zzpgVar.zzay() != null) {
            zzpgVar.zzay().zzaW().zzb().zzb("AppId not known when logging event", str2);
        }
    }
}
