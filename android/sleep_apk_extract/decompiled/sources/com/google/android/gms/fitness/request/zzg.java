package com.google.android.gms.fitness.request;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;

/* JADX INFO: loaded from: classes3.dex */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzh();
    private final com.google.android.gms.internal.fitness.zzat zza;
    private final DataType zzb;
    private final boolean zzc;

    public zzg(IBinder iBinder, DataType dataType, boolean z) {
        this.zza = com.google.android.gms.internal.fitness.zzas.zzb(iBinder);
        this.zzb = dataType;
        this.zzc = z;
    }

    public final String toString() {
        DataType dataType = this.zzb;
        return FileInsert$$ExternalSyntheticOutline0.m("DailyTotalRequest{", dataType == null ? "null" : dataType.zzc(), "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.internal.fitness.zzat zzatVar = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, zzatVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
