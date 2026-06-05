package com.google.android.gms.home.matter.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceDescriptor extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceDescriptor> CREATOR = new zza();
    private final int zza;
    private final int zzb;
    private final int zzc;

    public DeviceDescriptor(int i, int i2, int i3) {
        zzd(i, i2);
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    private static void zzc(int i) {
        boolean z = false;
        if (i >= 0 && i <= 65535) {
            z = true;
        }
        Preconditions.checkArgument(z, "Vendor ID is not in valid range, found 0x%X", Integer.valueOf(i));
    }

    private static void zzd(int i, int i2) {
        zzc(i);
        boolean z = true;
        if (i2 != 0 && i <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "A vendor ID must be specified when a product ID is specified.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceDescriptor)) {
            return false;
        }
        DeviceDescriptor deviceDescriptor = (DeviceDescriptor) obj;
        return this.zza == deviceDescriptor.zza && this.zzb == deviceDescriptor.zzb && this.zzc == deviceDescriptor.zzc;
    }

    @Deprecated
    public int getDeviceType() {
        return this.zzc;
    }

    public int getProductId() {
        return this.zzb;
    }

    public int getVendorId() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public String toString() {
        return String.format(Locale.ROOT, "DeviceDescriptor(VID=0x%04X, PID=0x%04X)", Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVendorId());
        SafeParcelWriter.writeInt(parcel, 2, getProductId());
        SafeParcelWriter.writeInt(parcel, 3, getDeviceType());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
