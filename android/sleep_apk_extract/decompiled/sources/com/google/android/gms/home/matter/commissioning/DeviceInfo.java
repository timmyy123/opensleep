package com.google.android.gms.home.matter.commissioning;

import android.bluetooth.BluetoothAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.home.matter.common.Discriminator;
import com.google.android.gms.home.matter.common.NetworkLocation;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new zzh();
    private final int zza;
    private final int zzb;
    private final Discriminator zzc;
    private final String zzd;
    private final NetworkLocation zze;
    private final String zzf;

    public DeviceInfo(int i, int i2, Discriminator discriminator, String str, NetworkLocation networkLocation, String str2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = discriminator;
        this.zzd = str;
        this.zze = networkLocation;
        this.zzf = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return this.zza == deviceInfo.zza && this.zzb == deviceInfo.zzb && Objects.equal(this.zzc, deviceInfo.zzc) && Objects.equal(this.zzd, deviceInfo.zzd) && Objects.equal(this.zze, deviceInfo.zze) && Objects.equal(this.zzf, deviceInfo.zzf);
    }

    public Discriminator getDiscriminator() {
        return this.zzc;
    }

    public int getProductId() {
        return this.zzb;
    }

    public int getVendorId() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVendorId());
        SafeParcelWriter.writeInt(parcel, 2, getProductId());
        SafeParcelWriter.writeParcelable(parcel, 3, getDiscriminator(), i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final void zza() {
        String str = this.zzd;
        boolean z = true;
        if (str != null && !BluetoothAdapter.checkBluetoothAddress(str)) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid Bluetooth address %s", String.valueOf(str));
    }
}
