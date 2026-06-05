package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzmi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmi> CREATOR = new zzmj();
    private int zza;
    private int zzb;
    private byte[] zzc;
    private zznr zzd;
    private int zze;
    private zzox[] zzf;
    private int zzg;
    private byte[] zzh;
    private zzox zzi;
    private zzlw zzj;
    private int zzk;
    private int zzl;
    private boolean zzm;

    public zzmi(int i, int i2, byte[] bArr, zznr zznrVar, int i3, zzox[] zzoxVarArr, int i4, byte[] bArr2, zzox zzoxVar, zzlw zzlwVar, int i5, int i6, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = bArr;
        this.zzd = zznrVar;
        this.zze = i3;
        this.zzf = zzoxVarArr;
        this.zzg = i4;
        this.zzh = bArr2;
        this.zzi = zzoxVar;
        this.zzj = zzlwVar;
        this.zzk = i5;
        this.zzl = i6;
        this.zzm = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmi) {
            zzmi zzmiVar = (zzmi) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzmiVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzmiVar.zzb)) && Arrays.equals(this.zzc, zzmiVar.zzc) && Objects.equal(this.zzd, zzmiVar.zzd) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzmiVar.zze)) && Arrays.equals(this.zzf, zzmiVar.zzf) && Objects.equal(Integer.valueOf(this.zzg), Integer.valueOf(zzmiVar.zzg)) && Arrays.equals(this.zzh, zzmiVar.zzh) && Objects.equal(this.zzi, zzmiVar.zzi) && Objects.equal(this.zzj, zzmiVar.zzj) && Objects.equal(Integer.valueOf(this.zzk), Integer.valueOf(zzmiVar.zzk)) && Objects.equal(Integer.valueOf(this.zzl), Integer.valueOf(zzmiVar.zzl)) && Objects.equal(Boolean.valueOf(this.zzm), Boolean.valueOf(zzmiVar.zzm))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, Integer.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(this.zzg), Integer.valueOf(Arrays.hashCode(this.zzh)), this.zzi, this.zzj, Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), Boolean.valueOf(this.zzm));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzk);
        SafeParcelWriter.writeInt(parcel, 12, this.zzl);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzm);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
