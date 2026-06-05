package com.google.android.gms.internal.aicore;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.common.base.MoreObjects;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    private final String zza;
    private final String zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final int zzf;

    public zzd(String str, String str2, int i, int i2, int i3, int i4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzd)) {
            return false;
        }
        zzd zzdVar = (zzd) obj;
        return this.zzc == zzdVar.zzc && this.zzd == zzdVar.zzd && Objects.equals(this.zza, zzdVar.zza) && this.zze == zzdVar.zze && this.zzf == zzdVar.zzf;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(this.zzf));
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", this.zza).add("modelName", this.zzb).add("type", this.zzc).add("variant", this.zzd).add("id", this.zze).add("version", this.zzf).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
