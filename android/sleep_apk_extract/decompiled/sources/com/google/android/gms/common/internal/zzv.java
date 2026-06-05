package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzv extends com.google.android.gms.internal.common.zza implements zzx {
    public zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzx
    public final IObjectWrapper zzd() {
        return zzba$$ExternalSyntheticOutline0.m(zzB(1, zza()));
    }

    @Override // com.google.android.gms.common.internal.zzx
    public final int zze() {
        Parcel parcelZzB = zzB(2, zza());
        int i = parcelZzB.readInt();
        parcelZzB.recycle();
        return i;
    }
}
