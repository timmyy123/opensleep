package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzby;
import com.google.android.gms.internal.fitness.zzbz;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzak();
    private final com.google.android.gms.fitness.data.zzt zza;
    private final PendingIntent zzb;
    private final zzbz zzc;

    public zzaj(IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2) {
        this.zza = iBinder == null ? null : com.google.android.gms.fitness.data.zzs.zzb(iBinder);
        this.zzb = pendingIntent;
        this.zzc = iBinder2 != null ? zzby.zzc(iBinder2) : null;
    }

    public final String toString() {
        return String.format("SensorUnregistrationRequest{%s}", this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.fitness.data.zzt zztVar = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, zztVar == null ? null : zztVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzbz zzbzVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, zzbzVar != null ? zzbzVar.asBinder() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
