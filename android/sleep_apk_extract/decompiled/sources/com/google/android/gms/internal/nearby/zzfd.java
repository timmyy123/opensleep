package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfd extends zzb implements zzfe {
    public zzfd() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zzgb zzgbVar = (zzgb) zzc.zza(parcel, zzgb.CREATOR);
            zzc.zzb(parcel);
            zzc(zzgbVar);
            return true;
        }
        if (i == 3) {
            zzgh zzghVar = (zzgh) zzc.zza(parcel, zzgh.CREATOR);
            zzc.zzb(parcel);
            zzd(zzghVar);
            return true;
        }
        if (i == 4) {
            zzgj zzgjVar = (zzgj) zzc.zza(parcel, zzgj.CREATOR);
            zzc.zzb(parcel);
            zze(zzgjVar);
            return true;
        }
        if (i != 5) {
            return false;
        }
        zzfz zzfzVar = (zzfz) zzc.zza(parcel, zzfz.CREATOR);
        zzc.zzb(parcel);
        zzb(zzfzVar);
        return true;
    }
}
