package com.google.android.gms.home.internal;

import android.content.IntentSender;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.home.matter.commissioning.CommissioningRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class zze extends com.google.android.gms.internal.serialization.zza implements IInterface {
    public zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.home.internal.IChipService");
    }

    public final IntentSender zze(CommissioningRequest commissioningRequest) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.serialization.zzc.zzb(parcelZza, commissioningRequest);
        Parcel parcelZzb = zzb(2, parcelZza);
        IntentSender intentSender = (IntentSender) com.google.android.gms.internal.serialization.zzc.zza(parcelZzb, IntentSender.CREATOR);
        parcelZzb.recycle();
        return intentSender;
    }
}
