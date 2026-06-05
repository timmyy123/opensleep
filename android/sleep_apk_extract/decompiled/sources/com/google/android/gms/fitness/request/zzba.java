package com.google.android.gms.fitness.request;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzby;
import com.google.android.gms.internal.fitness.zzbz;

/* JADX INFO: loaded from: classes3.dex */
public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzba> CREATOR = new zzbb();
    private final String zza;
    private final zzbz zzb;

    public zzba(String str, IBinder iBinder) {
        this.zza = str;
        this.zzb = iBinder == null ? null : zzby.zzc(iBinder);
    }

    public final String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m("UnclaimBleDeviceRequest{", this.zza, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, str, false);
        zzbz zzbzVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 3, zzbzVar == null ? null : zzbzVar.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
