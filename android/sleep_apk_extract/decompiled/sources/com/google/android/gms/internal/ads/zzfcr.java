package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfcr implements zzfci {
    private final int zza;
    private final int zzb;

    public zzfcr(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        int i;
        int i2 = this.zza;
        Bundle bundle = (Bundle) obj;
        if (i2 == -1 || (i = this.zzb) == -1) {
            return;
        }
        bundle.putInt("sessions_without_flags", i2);
        bundle.putInt("crashes_without_flags", i);
        int i3 = com.google.android.gms.ads.internal.client.zzay.$r8$clinit;
        if (com.google.android.gms.ads.internal.client.zzba.zzc().zzc()) {
            bundle.putBoolean("did_reset", true);
        }
    }
}
