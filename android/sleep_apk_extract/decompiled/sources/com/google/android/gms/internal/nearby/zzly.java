package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzly extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzly> CREATOR = new zzlz();
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private int[] zzf;
    private int[] zzg;
    private float zzh;
    private int[] zzi;
    private int[] zzj;
    private int[] zzk;
    private boolean zzl;
    private boolean zzm;

    public zzly(boolean z, boolean z2, boolean z3, int i, int i2, int[] iArr, int[] iArr2, float f, int[] iArr3, int[] iArr4, int[] iArr5, boolean z4, boolean z5) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = i;
        this.zze = i2;
        this.zzf = iArr;
        this.zzg = iArr2;
        this.zzh = f;
        this.zzi = iArr3;
        this.zzj = iArr4;
        this.zzk = iArr5;
        this.zzl = z4;
        this.zzm = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzly) {
            zzly zzlyVar = (zzly) obj;
            if (Objects.equal(Boolean.valueOf(this.zza), Boolean.valueOf(zzlyVar.zza)) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(zzlyVar.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzlyVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzlyVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzlyVar.zze)) && Arrays.equals(this.zzf, zzlyVar.zzf) && Arrays.equals(this.zzg, zzlyVar.zzg) && Objects.equal(Float.valueOf(this.zzh), Float.valueOf(zzlyVar.zzh)) && Arrays.equals(this.zzi, zzlyVar.zzi) && Arrays.equals(this.zzj, zzlyVar.zzj) && Arrays.equals(this.zzk, zzlyVar.zzk) && Objects.equal(Boolean.valueOf(this.zzl), Boolean.valueOf(zzlyVar.zzl)) && Objects.equal(Boolean.valueOf(this.zzm), Boolean.valueOf(zzlyVar.zzm))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(Arrays.hashCode(this.zzg)), Float.valueOf(this.zzh), Integer.valueOf(Arrays.hashCode(this.zzi)), Integer.valueOf(Arrays.hashCode(this.zzj)), Integer.valueOf(Arrays.hashCode(this.zzk)), Boolean.valueOf(this.zzl), Boolean.valueOf(this.zzm));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeIntArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeIntArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzh);
        SafeParcelWriter.writeIntArray(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeIntArray(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeIntArray(parcel, 11, this.zzk, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzl);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzm);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
