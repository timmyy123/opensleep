package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfu extends zzb implements zzfv {
    public zzfu() {
        super("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 2) {
            return false;
        }
        zzgv zzgvVar = (zzgv) zzc.zza(parcel, zzgv.CREATOR);
        zzc.zzb(parcel);
        zzb(zzgvVar);
        return true;
    }
}
