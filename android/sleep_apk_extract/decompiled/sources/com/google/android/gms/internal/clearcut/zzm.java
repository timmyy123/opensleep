package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzm extends zzb implements zzl {
    public zzm() {
        super("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
    }

    @Override // com.google.android.gms.internal.clearcut.zzb
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zza((Status) zzc.zza(parcel, Status.CREATOR));
                return true;
            case 2:
                zzb((Status) zzc.zza(parcel, Status.CREATOR));
                return true;
            case 3:
                zza((Status) zzc.zza(parcel, Status.CREATOR), parcel.readLong());
                return true;
            case 4:
                zzc((Status) zzc.zza(parcel, Status.CREATOR));
                return true;
            case 5:
                zzb((Status) zzc.zza(parcel, Status.CREATOR), parcel.readLong());
                return true;
            case 6:
                zza((Status) zzc.zza(parcel, Status.CREATOR), (com.google.android.gms.clearcut.zze[]) parcel.createTypedArray(com.google.android.gms.clearcut.zze.CREATOR));
                return true;
            case 7:
                zza((DataHolder) zzc.zza(parcel, DataHolder.CREATOR));
                return true;
            case 8:
                zza((Status) zzc.zza(parcel, Status.CREATOR), (com.google.android.gms.clearcut.zzc) zzc.zza(parcel, com.google.android.gms.clearcut.zzc.CREATOR));
                return true;
            case 9:
                zzb((Status) zzc.zza(parcel, Status.CREATOR), (com.google.android.gms.clearcut.zzc) zzc.zza(parcel, com.google.android.gms.clearcut.zzc.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
