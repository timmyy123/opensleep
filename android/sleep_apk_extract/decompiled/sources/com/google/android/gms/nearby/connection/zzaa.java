package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes4.dex */
public final class zzaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaa> CREATOR = new zzab();
    private int zza;
    private int zzb;
    private int zzc;
    private boolean zzd;

    public zzaa(int i, int i2, int i3, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzaa) {
            zzaa zzaaVar = (zzaa) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzaaVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzaaVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzaaVar.zzc)) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzaaVar.zzd))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Boolean.valueOf(this.zzd));
    }

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        int i3 = this.zzc;
        boolean z = this.zzd;
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, i2, "UwbRangingData{rawDistance=", ", rawAngleOfArrivalAzimuth=", ", rawAngleOfArrivalPolar=");
        sbM.append(i3);
        sbM.append(", isValidAngleOfArrivalData=");
        sbM.append(z);
        sbM.append("}");
        return sbM.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
