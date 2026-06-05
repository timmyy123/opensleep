package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzby;
import com.google.android.gms.internal.fitness.zzbz;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class StartBleScanRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new zzav();
    private final List zza;
    private final zzz zzb;
    private final int zzc;
    private final zzbz zzd;

    public StartBleScanRequest(List list, IBinder iBinder, int i, IBinder iBinder2) {
        zzz zzxVar;
        this.zza = list;
        if (iBinder == null) {
            zzxVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            zzxVar = iInterfaceQueryLocalInterface instanceof zzz ? (zzz) iInterfaceQueryLocalInterface : new zzx(iBinder);
        }
        this.zzb = zzxVar;
        this.zzc = i;
        this.zzd = iBinder2 != null ? zzby.zzc(iBinder2) : null;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zza);
    }

    public int getTimeoutSecs() {
        return this.zzc;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataTypes", this.zza).add("timeoutSecs", Integer.valueOf(this.zzc)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataTypes(), false);
        zzz zzzVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzzVar == null ? null : zzzVar.asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 3, getTimeoutSecs());
        zzbz zzbzVar = this.zzd;
        SafeParcelWriter.writeIBinder(parcel, 4, zzbzVar != null ? zzbzVar.asBinder() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
