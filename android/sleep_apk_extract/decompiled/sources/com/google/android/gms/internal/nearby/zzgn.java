package com.google.android.gms.internal.nearby;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgn> CREATOR = new zzgo();
    private String zza;
    private String zzb;
    private String zzc;
    private BluetoothDevice zzd;
    private byte[] zze;
    private final int zzf;
    private com.google.android.gms.nearby.connection.zzo zzg;

    public zzgn(String str, String str2, String str3, BluetoothDevice bluetoothDevice, byte[] bArr, int i, com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bluetoothDevice;
        this.zze = bArr;
        this.zzf = i;
        this.zzg = zzoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgn) {
            zzgn zzgnVar = (zzgn) obj;
            if (Objects.equal(this.zza, zzgnVar.zza) && Objects.equal(this.zzb, zzgnVar.zzb) && Objects.equal(this.zzc, zzgnVar.zzc) && Objects.equal(this.zzd, zzgnVar.zzd) && Arrays.equals(this.zze, zzgnVar.zze) && Objects.equal(Integer.valueOf(this.zzf), Integer.valueOf(zzgnVar.zzf)) && Objects.equal(this.zzg, zzgnVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Integer.valueOf(Arrays.hashCode(this.zze)), Integer.valueOf(this.zzf), this.zzg);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final BluetoothDevice zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final byte[] zze() {
        return this.zze;
    }
}
