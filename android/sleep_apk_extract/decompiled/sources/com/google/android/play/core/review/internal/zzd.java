package com.google.android.play.core.review.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes4.dex */
public final class zzd extends zza implements zzf {
    public zzd(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.core.review.internal.zzf
    public final void zzc(String str, Bundle bundle, zzh zzhVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        int i = zzc.zza;
        parcelZza.writeInt(1);
        bundle.writeToParcel(parcelZza, 0);
        parcelZza.writeStrongBinder(zzhVar);
        zzb(2, parcelZza);
    }
}
