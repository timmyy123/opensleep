package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzaw extends zzb implements zzax {
    public zzaw() {
        super("com.google.android.gms.home.interaction.internal.IEventCallback");
    }

    public static zzax zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.home.interaction.internal.IEventCallback");
        return iInterfaceQueryLocalInterface instanceof zzax ? (zzax) iInterfaceQueryLocalInterface : new zzav(iBinder);
    }

    @Override // com.google.android.gms.internal.serialization.zzb
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zzh zzhVar = (zzh) zzc.zza(parcel, zzh.CREATOR);
        zzc.zze(parcel);
        zze(zzhVar);
        return true;
    }
}
