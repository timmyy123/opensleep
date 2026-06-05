package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    private final List zza;
    private final List zzb;
    private final List zzc;

    public zzi(List list, List list2, List list3) {
        this.zza = list;
        this.zzb = list2;
        this.zzc = list3;
    }

    public final String toString() {
        com.google.android.gms.internal.wearable.zzag zzagVarZza = com.google.android.gms.internal.wearable.zzah.zza(this);
        zzagVarZza.zza("allowedDataItemFilters", this.zza);
        zzagVarZza.zza("allowedCapabilities", this.zzb);
        zzagVarZza.zza("allowedPackages", this.zzc);
        return zzagVarZza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        List list = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, list, false);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
