package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgl> CREATOR = new zzgm();
    private String zza;
    private int zzb;
    private com.google.android.gms.nearby.connection.zzaa zzc;
    private final int zzd;
    private com.google.android.gms.nearby.connection.zzo zze;

    public zzgl(String str, int i, com.google.android.gms.nearby.connection.zzaa zzaaVar, int i2, com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = i;
        this.zzc = zzaaVar;
        this.zzd = i2;
        this.zze = zzoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgl) {
            zzgl zzglVar = (zzgl) obj;
            if (Objects.equal(this.zza, zzglVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzglVar.zzb)) && Objects.equal(this.zzc, zzglVar.zzc) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzglVar.zzd)) && Objects.equal(this.zze, zzglVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final com.google.android.gms.nearby.connection.zzaa zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }
}
