package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbo extends zzb implements zzbp {
    public zzbo() {
        super("com.google.android.gms.home.interaction.internal.ITraitCallback");
    }

    public static zzbp zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.home.interaction.internal.ITraitCallback");
        return iInterfaceQueryLocalInterface instanceof zzbp ? (zzbp) iInterfaceQueryLocalInterface : new zzbn(iBinder);
    }

    @Override // com.google.android.gms.internal.serialization.zzb
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zzai zzaiVar = (zzai) zzc.zza(parcel, zzai.CREATOR);
        zzc.zze(parcel);
        zze(zzaiVar);
        return true;
    }
}
