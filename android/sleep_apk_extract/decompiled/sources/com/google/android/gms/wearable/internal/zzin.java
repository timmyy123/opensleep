package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes4.dex */
public final class zzin extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzin> CREATOR = new zzio();
    final int zza;
    public final zzgp zzb;

    public zzin(int i, IBinder iBinder) {
        zzgp zzgnVar;
        this.zza = i;
        if (iBinder != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            zzgnVar = iInterfaceQueryLocalInterface instanceof zzgp ? (zzgp) iInterfaceQueryLocalInterface : new zzgn(iBinder);
        } else {
            zzgnVar = null;
        }
        this.zzb = zzgnVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        zzgp zzgpVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzgpVar == null ? null : zzgpVar.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzin(zzgp zzgpVar) {
        this.zza = 1;
        this.zzb = zzgpVar;
    }
}
