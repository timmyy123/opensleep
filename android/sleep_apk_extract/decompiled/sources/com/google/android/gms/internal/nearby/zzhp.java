package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhp> CREATOR = new zzhq();
    private zzfs zza;
    private String zzb;
    private final int zzc;
    private zzjk zzd;
    private com.google.android.gms.nearby.connection.zzo zze;

    public zzhp(IBinder iBinder, String str, int i, zzjk zzjkVar, com.google.android.gms.nearby.connection.zzo zzoVar) {
        zzfs zzfqVar;
        if (iBinder == null) {
            zzfqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzfqVar = iInterfaceQueryLocalInterface instanceof zzfs ? (zzfs) iInterfaceQueryLocalInterface : new zzfq(iBinder);
        }
        this.zza = zzfqVar;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzjkVar;
        this.zze = zzoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhp) {
            zzhp zzhpVar = (zzhp) obj;
            if (Objects.equal(this.zza, zzhpVar.zza) && Objects.equal(this.zzb, zzhpVar.zzb) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzhpVar.zzc)) && Objects.equal(this.zzd, zzhpVar.zzd) && Objects.equal(this.zze, zzhpVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzfs zzfsVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzfsVar == null ? null : zzfsVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
