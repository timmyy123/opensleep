package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfk extends zzb implements zzfl {
    public zzfk() {
        super("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zzgn zzgnVar = (zzgn) zzc.zza(parcel, zzgn.CREATOR);
            zzc.zzb(parcel);
            zzc(zzgnVar);
            return true;
        }
        if (i == 3) {
            zzgp zzgpVar = (zzgp) zzc.zza(parcel, zzgp.CREATOR);
            zzc.zzb(parcel);
            zzd(zzgpVar);
            return true;
        }
        if (i == 4) {
            zzc.zzb(parcel);
            return true;
        }
        if (i != 5) {
            return false;
        }
        zzgl zzglVar = (zzgl) zzc.zza(parcel, zzgl.CREATOR);
        zzc.zzb(parcel);
        zzb(zzglVar);
        return true;
    }
}
