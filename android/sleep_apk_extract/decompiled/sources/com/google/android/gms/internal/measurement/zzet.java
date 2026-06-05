package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzet extends zzeo {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzey zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzet(zzey zzeyVar, Activity activity) {
        super(zzeyVar.zza, true);
        this.zza = activity;
        Objects.requireNonNull(zzeyVar);
        this.zzb = zzeyVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeo
    public final void zza() {
        ((zzcp) Preconditions.checkNotNull(this.zzb.zza.zzS())).onActivityResumedByScionActivityInfo(zzdd.zza(this.zza), this.zzj);
    }
}
