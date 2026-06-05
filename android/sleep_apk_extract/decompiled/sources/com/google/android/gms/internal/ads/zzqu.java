package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzqu extends Exception {
    public final int zza;
    public final boolean zzb;

    public zzqu(int i, boolean z) {
        super(zzba$$ExternalSyntheticOutline0.m(i, "AudioOutput write failed: ", new StringBuilder(String.valueOf(i).length() + 26)));
        this.zzb = z;
        this.zza = i;
    }
}
