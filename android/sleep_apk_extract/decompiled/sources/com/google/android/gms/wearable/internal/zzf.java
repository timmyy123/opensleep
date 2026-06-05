package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes4.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();
    public final zzgp zza;
    public final IntentFilter[] zzb;
    public final String zzc;
    public final String zzd;

    public zzf(IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        zzgp zzgnVar;
        if (iBinder != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            zzgnVar = iInterfaceQueryLocalInterface instanceof zzgp ? (zzgp) iInterfaceQueryLocalInterface : new zzgn(iBinder);
        } else {
            zzgnVar = null;
        }
        this.zza = zzgnVar;
        this.zzb = intentFilterArr;
        this.zzc = str;
        this.zzd = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzgp zzgpVar = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, zzgpVar == null ? null : zzgpVar.asBinder(), false);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzf(zzko zzkoVar) {
        this.zza = zzkoVar;
        this.zzb = zzkoVar.zzv();
        this.zzc = zzkoVar.zzw();
        this.zzd = null;
    }
}
