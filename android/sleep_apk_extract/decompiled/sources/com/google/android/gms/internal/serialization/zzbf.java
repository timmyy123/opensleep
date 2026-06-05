package com.google.android.gms.internal.serialization;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbf extends zzb implements zzbg {
    public zzbf() {
        super("com.google.android.gms.home.interaction.internal.IRegisterSubscriberCallback");
    }

    public static zzbg zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.home.interaction.internal.IRegisterSubscriberCallback");
        return iInterfaceQueryLocalInterface instanceof zzbg ? (zzbg) iInterfaceQueryLocalInterface : new zzbe(iBinder);
    }

    @Override // com.google.android.gms.internal.serialization.zzb
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        zzc.zze(parcel);
        zze(status);
        return true;
    }
}
