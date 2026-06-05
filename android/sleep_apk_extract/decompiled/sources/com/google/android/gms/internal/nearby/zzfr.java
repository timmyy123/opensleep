package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfr extends zzb implements zzfs {
    public zzfr() {
        super("com.google.android.gms.nearby.internal.connection.IResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 2) {
            return false;
        }
        int i3 = parcel.readInt();
        zzc.zzb(parcel);
        zzb(i3);
        return true;
    }
}
