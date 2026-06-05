package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgrp extends zzgqn {
    final /* synthetic */ zzgrr zza;
    private final zzgrw zzb;

    public zzgrp(zzgrr zzgrrVar, zzgrw zzgrwVar) {
        Objects.requireNonNull(zzgrrVar);
        this.zza = zzgrrVar;
        this.zzb = zzgrwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgqo
    public final void zzb(Bundle bundle) {
        int i = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        int i2 = bundle.getInt("uiMode", 0);
        zzgru zzgruVarZzd = zzgrv.zzd();
        zzgruVarZzd.zza(i);
        if (string != null) {
            zzgruVarZzd.zzb(string);
        }
        zzgruVarZzd.zzc(i2);
        this.zzb.zza(zzgruVarZzd.zzd());
        if (i == 8157) {
            this.zza.zzd();
        }
    }
}
