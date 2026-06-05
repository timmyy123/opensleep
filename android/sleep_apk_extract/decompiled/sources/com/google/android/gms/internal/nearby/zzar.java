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
public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new zzas();
    private zzfs zza;
    private zzfb zzb;
    private String zzc;
    private byte[] zzd;
    private zzfp zze;
    private final int zzf;
    private zzjk zzg;
    private com.google.android.gms.nearby.connection.zzo zzh;

    public zzar(IBinder iBinder, IBinder iBinder2, String str, byte[] bArr, IBinder iBinder3, int i, zzjk zzjkVar, com.google.android.gms.nearby.connection.zzo zzoVar) {
        zzfs zzfqVar;
        zzfb zzezVar;
        zzfp zzfnVar = null;
        if (iBinder == null) {
            zzfqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzfqVar = iInterfaceQueryLocalInterface instanceof zzfs ? (zzfs) iInterfaceQueryLocalInterface : new zzfq(iBinder);
        }
        if (iBinder2 == null) {
            zzezVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
            zzezVar = iInterfaceQueryLocalInterface2 instanceof zzfb ? (zzfb) iInterfaceQueryLocalInterface2 : new zzez(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IPayloadListener");
            zzfnVar = iInterfaceQueryLocalInterface3 instanceof zzfp ? (zzfp) iInterfaceQueryLocalInterface3 : new zzfn(iBinder3);
        }
        this.zza = zzfqVar;
        this.zzb = zzezVar;
        this.zzc = str;
        this.zzd = bArr;
        this.zze = zzfnVar;
        this.zzf = i;
        this.zzg = zzjkVar;
        this.zzh = zzoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzar) {
            zzar zzarVar = (zzar) obj;
            if (Objects.equal(this.zza, zzarVar.zza) && Objects.equal(this.zzb, zzarVar.zzb) && Objects.equal(this.zzc, zzarVar.zzc) && Arrays.equals(this.zzd, zzarVar.zzd) && Objects.equal(this.zze, zzarVar.zze) && Objects.equal(Integer.valueOf(this.zzf), Integer.valueOf(zzarVar.zzf)) && Objects.equal(this.zzg, zzarVar.zzg) && Objects.equal(this.zzh, zzarVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Integer.valueOf(Arrays.hashCode(this.zzd)), this.zze, Integer.valueOf(this.zzf), this.zzg, this.zzh);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzfs zzfsVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzfsVar == null ? null : zzfsVar.asBinder(), false);
        zzfb zzfbVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzfbVar == null ? null : zzfbVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        zzfp zzfpVar = this.zze;
        SafeParcelWriter.writeIBinder(parcel, 5, zzfpVar != null ? zzfpVar.asBinder() : null, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
