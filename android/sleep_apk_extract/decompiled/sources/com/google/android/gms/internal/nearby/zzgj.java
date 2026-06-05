package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgj> CREATOR = new zzgk();
    private String zza;
    private final int zzb;
    private zzjk zzc;
    private com.google.android.gms.nearby.connection.zzo zzd;

    public zzgj(String str, int i, zzjk zzjkVar, com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = i;
        this.zzc = zzjkVar;
        this.zzd = zzoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgj) {
            zzgj zzgjVar = (zzgj) obj;
            if (Objects.equal(this.zza, zzgjVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzgjVar.zzb)) && Objects.equal(this.zzc, zzgjVar.zzc) && Objects.equal(this.zzd, zzgjVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }
}
