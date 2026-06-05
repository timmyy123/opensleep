package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzka extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzka> CREATOR = new zzkb();
    private int zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private float zzh;
    private float zzi;
    private long zzj;
    private long zzk;
    private int zzl;
    private byte[] zzm;
    private byte[] zzn;

    public zzka(int i, int i2, int i3, int i4, int i5, long j, long j2, float f, float f2, long j3, long j4, int i6, byte[] bArr, byte[] bArr2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = j;
        this.zzg = j2;
        this.zzh = f;
        this.zzi = f2;
        this.zzj = j3;
        this.zzk = j4;
        this.zzl = i6;
        this.zzm = bArr;
        this.zzn = bArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzka) {
            zzka zzkaVar = (zzka) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzkaVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzkaVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzkaVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzkaVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzkaVar.zze)) && Objects.equal(Long.valueOf(this.zzf), Long.valueOf(zzkaVar.zzf)) && Objects.equal(Long.valueOf(this.zzg), Long.valueOf(zzkaVar.zzg)) && Objects.equal(Float.valueOf(this.zzh), Float.valueOf(zzkaVar.zzh)) && Objects.equal(Float.valueOf(this.zzi), Float.valueOf(zzkaVar.zzi)) && Objects.equal(Long.valueOf(this.zzj), Long.valueOf(zzkaVar.zzj)) && Objects.equal(Long.valueOf(this.zzk), Long.valueOf(zzkaVar.zzk)) && Objects.equal(Integer.valueOf(this.zzl), Integer.valueOf(zzkaVar.zzl)) && Arrays.equals(this.zzm, zzkaVar.zzm) && Arrays.equals(this.zzn, zzkaVar.zzn)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Long.valueOf(this.zzf), Long.valueOf(this.zzg), Float.valueOf(this.zzh), Float.valueOf(this.zzi), Long.valueOf(this.zzj), Long.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(Arrays.hashCode(this.zzm)), Integer.valueOf(Arrays.hashCode(this.zzn)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeLong(parcel, 6, this.zzf);
        SafeParcelWriter.writeLong(parcel, 7, this.zzg);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzh);
        SafeParcelWriter.writeFloat(parcel, 9, this.zzi);
        SafeParcelWriter.writeLong(parcel, 10, this.zzj);
        SafeParcelWriter.writeLong(parcel, 11, this.zzk);
        SafeParcelWriter.writeInt(parcel, 12, this.zzl);
        SafeParcelWriter.writeByteArray(parcel, 13, this.zzm, false);
        SafeParcelWriter.writeByteArray(parcel, 14, this.zzn, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
