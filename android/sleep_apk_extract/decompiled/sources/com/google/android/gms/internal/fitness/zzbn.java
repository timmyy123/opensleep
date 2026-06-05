package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbn extends zza implements IInterface {
    public zzbn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
    }

    public final void zzf(SessionInsertRequest sessionInsertRequest) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, sessionInsertRequest);
        zzk(3, parcelZza);
    }

    public final void zzg(SessionReadRequest sessionReadRequest) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, sessionReadRequest);
        zzk(4, parcelZza);
    }
}
