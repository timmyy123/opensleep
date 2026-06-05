package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzsd extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzv zzc;

    public zzsd(int i, zzv zzvVar, boolean z) {
        super(zzba$$ExternalSyntheticOutline0.m(i, "AudioTrack write failed: ", new StringBuilder(String.valueOf(i).length() + 25)));
        this.zzb = z;
        this.zza = i;
        this.zzc = zzvVar;
    }
}
