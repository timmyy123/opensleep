package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
final class zzhd extends zzhh {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzhg createFromParcel(Parcel parcel) {
        zzhg zzhgVarCreateFromParcel = super.createFromParcel(parcel);
        if (zzhgVarCreateFromParcel.zzb != null) {
            zzhgVarCreateFromParcel.zza = zzhg.zzd(zzhgVarCreateFromParcel.zzb);
        }
        return zzhgVarCreateFromParcel;
    }
}
