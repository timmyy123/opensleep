package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhx> CREATOR = new zzhy();
    private zzfs zza;
    private String[] zzb;
    private zzhk zzc;
    private boolean zzd;
    private final int zze;
    private zzjk zzf;
    private com.google.android.gms.nearby.connection.zzo zzg;

    public zzhx(IBinder iBinder, String[] strArr, zzhk zzhkVar, boolean z, int i, zzjk zzjkVar, com.google.android.gms.nearby.connection.zzo zzoVar) {
        zzfs zzfqVar;
        if (iBinder == null) {
            zzfqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzfqVar = iInterfaceQueryLocalInterface instanceof zzfs ? (zzfs) iInterfaceQueryLocalInterface : new zzfq(iBinder);
        }
        this.zza = zzfqVar;
        this.zzb = strArr;
        this.zzc = zzhkVar;
        this.zzd = z;
        this.zze = i;
        this.zzf = zzjkVar;
        this.zzg = zzoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhx) {
            zzhx zzhxVar = (zzhx) obj;
            if (Objects.equal(this.zza, zzhxVar.zza) && Arrays.equals(this.zzb, zzhxVar.zzb) && Objects.equal(this.zzc, zzhxVar.zzc) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzhxVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzhxVar.zze)) && Objects.equal(this.zzf, zzhxVar.zzf) && Objects.equal(this.zzg, zzhxVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(Arrays.hashCode(this.zzb)), this.zzc, Boolean.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf, this.zzg);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzfs zzfsVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzfsVar == null ? null : zzfsVar.asBinder(), false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
