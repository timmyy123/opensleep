package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* JADX INFO: loaded from: classes3.dex */
public final class zzif extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzif> CREATOR = new zzig();
    private zzfs zza;
    private String zzb;
    private long zzc;
    private DiscoveryOptions zzd;
    private zzfl zze;
    private zzfi zzf;

    public zzif(IBinder iBinder, IBinder iBinder2, String str, long j, DiscoveryOptions discoveryOptions, IBinder iBinder3) {
        zzfs zzfqVar;
        zzfi zzfiVar;
        zzfl zzfjVar = null;
        if (iBinder == null) {
            zzfqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzfqVar = iInterfaceQueryLocalInterface instanceof zzfs ? (zzfs) iInterfaceQueryLocalInterface : new zzfq(iBinder);
        }
        if (iBinder2 == null) {
            zzfiVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryCallback");
            zzfiVar = iInterfaceQueryLocalInterface2 instanceof zzfi ? (zzfi) iInterfaceQueryLocalInterface2 : new zzfi(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
            zzfjVar = iInterfaceQueryLocalInterface3 instanceof zzfl ? (zzfl) iInterfaceQueryLocalInterface3 : new zzfj(iBinder3);
        }
        this.zza = zzfqVar;
        this.zzf = zzfiVar;
        this.zzb = str;
        this.zzc = j;
        this.zzd = discoveryOptions;
        this.zze = zzfjVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzif) {
            zzif zzifVar = (zzif) obj;
            if (Objects.equal(this.zza, zzifVar.zza) && Objects.equal(this.zzf, zzifVar.zzf) && Objects.equal(this.zzb, zzifVar.zzb) && Objects.equal(Long.valueOf(this.zzc), Long.valueOf(zzifVar.zzc)) && Objects.equal(this.zzd, zzifVar.zzd) && Objects.equal(this.zze, zzifVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzf, this.zzb, Long.valueOf(this.zzc), this.zzd, this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzfs zzfsVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzfsVar == null ? null : zzfsVar.asBinder(), false);
        zzfi zzfiVar = this.zzf;
        SafeParcelWriter.writeIBinder(parcel, 2, zzfiVar == null ? null : zzfiVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i, false);
        zzfl zzflVar = this.zze;
        SafeParcelWriter.writeIBinder(parcel, 6, zzflVar != null ? zzflVar.asBinder() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public /* synthetic */ zzif(zzie zzieVar) {
    }
}
