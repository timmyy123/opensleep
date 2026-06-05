package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbxy implements View.OnClickListener {
    final /* synthetic */ zzbya zza;

    public zzbxy(zzbya zzbyaVar) {
        Objects.requireNonNull(zzbyaVar);
        this.zza = zzbyaVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zzb(true);
    }
}
