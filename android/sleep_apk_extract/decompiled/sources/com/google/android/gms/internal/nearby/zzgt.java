package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgt> CREATOR = new zzgu();
    private String zza;
    private PayloadTransferUpdate zzb;
    private final int zzc;
    private zzjk zzd;
    private com.google.android.gms.nearby.connection.zzo zze;

    public zzgt(String str, PayloadTransferUpdate payloadTransferUpdate, int i, zzjk zzjkVar, com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = payloadTransferUpdate;
        this.zzc = i;
        this.zzd = zzjkVar;
        this.zze = zzoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgt) {
            zzgt zzgtVar = (zzgt) obj;
            if (Objects.equal(this.zza, zzgtVar.zza) && Objects.equal(this.zzb, zzgtVar.zzb) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzgtVar.zzc)) && Objects.equal(this.zzd, zzgtVar.zzd) && Objects.equal(this.zze, zzgtVar.zze)) {
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
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final PayloadTransferUpdate zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
