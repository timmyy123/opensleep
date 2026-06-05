package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfo extends zzb implements zzfp {
    public zzfo() {
        super("com.google.android.gms.nearby.internal.connection.IPayloadListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zzgr zzgrVar = (zzgr) zzc.zza(parcel, zzgr.CREATOR);
            zzc.zzb(parcel);
            zzb(zzgrVar);
            return true;
        }
        if (i != 3) {
            return false;
        }
        zzgt zzgtVar = (zzgt) zzc.zza(parcel, zzgt.CREATOR);
        zzc.zzb(parcel);
        zzc(zzgtVar);
        return true;
    }
}
