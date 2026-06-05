package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgh> CREATOR = new zzgi();
    private String zza;
    private int zzb;
    private byte[] zzc;
    private final int zzd;
    private zzjk zze;
    private com.google.android.gms.nearby.connection.zzo zzf;

    public zzgh(String str, int i, byte[] bArr, int i2, zzjk zzjkVar, com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = i;
        this.zzc = bArr;
        this.zzd = i2;
        this.zze = zzjkVar;
        this.zzf = zzoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgh) {
            zzgh zzghVar = (zzgh) obj;
            if (Objects.equal(this.zza, zzghVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzghVar.zzb)) && Arrays.equals(this.zzc, zzghVar.zzc) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzghVar.zzd)) && Objects.equal(this.zze, zzghVar.zze) && Objects.equal(this.zzf, zzghVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
