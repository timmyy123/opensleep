package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgb> CREATOR = new zzgc();
    private String zza;
    private String zzb;
    private String zzc;
    private boolean zzd;
    private byte[] zze;
    private byte[] zzf;
    private byte[] zzg;
    private boolean zzh;
    private final int zzi;
    private zzjk zzj;
    private com.google.android.gms.nearby.connection.zzo zzk;
    private final int zzl;

    public zzgb(String str, String str2, String str3, boolean z, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z2, int i, zzjk zzjkVar, com.google.android.gms.nearby.connection.zzo zzoVar, int i2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z;
        this.zze = bArr;
        this.zzf = bArr2;
        this.zzg = bArr3;
        this.zzh = z2;
        this.zzi = i;
        this.zzj = zzjkVar;
        this.zzk = zzoVar;
        this.zzl = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgb) {
            zzgb zzgbVar = (zzgb) obj;
            if (Objects.equal(this.zza, zzgbVar.zza) && Objects.equal(this.zzb, zzgbVar.zzb) && Objects.equal(this.zzc, zzgbVar.zzc) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzgbVar.zzd)) && Arrays.equals(this.zze, zzgbVar.zze) && Arrays.equals(this.zzf, zzgbVar.zzf) && Arrays.equals(this.zzg, zzgbVar.zzg) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(zzgbVar.zzh)) && Objects.equal(Integer.valueOf(this.zzi), Integer.valueOf(zzgbVar.zzi)) && Objects.equal(this.zzj, zzgbVar.zzj) && Objects.equal(this.zzk, zzgbVar.zzk) && Objects.equal(Integer.valueOf(this.zzl), Integer.valueOf(zzgbVar.zzl))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Boolean.valueOf(this.zzd), Integer.valueOf(Arrays.hashCode(this.zze)), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(Arrays.hashCode(this.zzg)), Boolean.valueOf(this.zzh), Integer.valueOf(this.zzi), this.zzj, this.zzk, Integer.valueOf(this.zzl));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 12, this.zzl);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzl;
    }

    public final String zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzd;
    }

    public final byte[] zzg() {
        return this.zzf;
    }

    public final byte[] zzh() {
        return this.zzg;
    }
}
