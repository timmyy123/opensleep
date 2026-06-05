package com.google.android.gms.internal.serialization;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.home.permissions.HomeAccountResult;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcq extends zzb implements zzcr {
    public zzcq() {
        super("com.google.android.gms.home.permissions.internal.IHomeAccountCallback");
    }

    @Override // com.google.android.gms.internal.serialization.zzb
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        HomeAccountResult homeAccountResult = (HomeAccountResult) zzc.zza(parcel, HomeAccountResult.CREATOR);
        zzc.zze(parcel);
        zza(status, homeAccountResult);
        return true;
    }
}
