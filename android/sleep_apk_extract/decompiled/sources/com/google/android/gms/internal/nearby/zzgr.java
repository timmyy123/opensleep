package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgr> CREATOR = new zzgs();
    private String zza;
    private zzhk zzb;
    private boolean zzc;
    private final int zzd;
    private zzjk zze;
    private com.google.android.gms.nearby.connection.zzo zzf;

    public zzgr(String str, zzhk zzhkVar, boolean z, int i, zzjk zzjkVar, com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = zzhkVar;
        this.zzc = z;
        this.zzd = i;
        this.zze = zzjkVar;
        this.zzf = zzoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgr) {
            zzgr zzgrVar = (zzgr) obj;
            if (Objects.equal(this.zza, zzgrVar.zza) && Objects.equal(this.zzb, zzgrVar.zzb) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzgrVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzgrVar.zzd)) && Objects.equal(this.zze, zzgrVar.zze) && Objects.equal(this.zzf, zzgrVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Boolean.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzhk zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
