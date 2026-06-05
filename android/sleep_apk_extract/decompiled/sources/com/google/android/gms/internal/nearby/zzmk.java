package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class zzmk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmk> CREATOR = new zzml();
    private zzme zza;
    private zzme zzb;
    private zzme zzc;
    private long zzd;
    private final int zze;
    private zzka zzf;

    public zzmk(zzme zzmeVar, zzme zzmeVar2, zzme zzmeVar3, long j, int i, zzka zzkaVar) {
        this.zza = zzmeVar;
        this.zzb = zzmeVar2;
        this.zzc = zzmeVar3;
        this.zzd = j;
        this.zze = i;
        this.zzf = zzkaVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmk) {
            zzmk zzmkVar = (zzmk) obj;
            if (Objects.equal(this.zza, zzmkVar.zza) && Objects.equal(this.zzb, zzmkVar.zzb) && Objects.equal(this.zzc, zzmkVar.zzc) && Objects.equal(Long.valueOf(this.zzd), Long.valueOf(zzmkVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzmkVar.zze)) && Objects.equal(this.zzf, zzmkVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Long.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
