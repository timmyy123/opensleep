package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbl extends zzb implements zzbm {
    public zzbl() {
        super("com.google.android.gms.home.interaction.internal.ISendCommandsLargeCallback");
    }

    public static zzbm zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.home.interaction.internal.ISendCommandsLargeCallback");
        return iInterfaceQueryLocalInterface instanceof zzbm ? (zzbm) iInterfaceQueryLocalInterface : new zzbk(iBinder);
    }

    @Override // com.google.android.gms.internal.serialization.zzb
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        DataHolder dataHolder = (DataHolder) zzc.zza(parcel, DataHolder.CREATOR);
        zzc.zze(parcel);
        zze(status, dataHolder);
        return true;
    }
}
