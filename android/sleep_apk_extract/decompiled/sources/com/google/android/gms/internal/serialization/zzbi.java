package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbi extends zzb implements zzbj {
    public zzbi() {
        super("com.google.android.gms.home.interaction.internal.ISendCommandsCallback");
    }

    public static zzbj zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.home.interaction.internal.ISendCommandsCallback");
        return iInterfaceQueryLocalInterface instanceof zzbj ? (zzbj) iInterfaceQueryLocalInterface : new zzbh(iBinder);
    }

    @Override // com.google.android.gms.internal.serialization.zzb
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        zzad zzadVar = (zzad) zzc.zza(parcel, zzad.CREATOR);
        zzc.zze(parcel);
        zze(status, zzadVar);
        return true;
    }
}
