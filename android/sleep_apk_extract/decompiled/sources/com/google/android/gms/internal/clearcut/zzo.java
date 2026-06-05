package com.google.android.gms.internal.clearcut;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzo extends zza implements zzn {
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    }

    @Override // com.google.android.gms.internal.clearcut.zzn
    public final void zza(zzl zzlVar, com.google.android.gms.clearcut.zze zzeVar) {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzlVar);
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzeVar);
        transactOneway(1, parcelObtainAndWriteInterfaceToken);
    }
}
