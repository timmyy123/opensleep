package com.google.android.gms.home.matter.commissioning;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class SharedDeviceData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SharedDeviceData> CREATOR = new zzk();
    private final String zza;
    private final long zzb;
    private final String zzc;
    private final String zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;

    public SharedDeviceData(String str, long j, String str2, String str3, int i, int i2, int i3) {
        Preconditions.checkArgument(i >= 0 && i <= 65535, "Vendor ID invalid: %04X", Integer.valueOf(i));
        boolean z = i2 >= 0 && i2 <= 65535;
        Integer numValueOf = Integer.valueOf(i2);
        Preconditions.checkArgument(z, "Product ID invalid: %04X", numValueOf);
        Preconditions.checkArgument(i3 >= 0 && i3 <= 65535, "Device type invalid: %04X", numValueOf);
        Preconditions.checkArgument(j >= 0, "Invalid commissioning window expiration %d", Long.valueOf(j));
        this.zza = (String) Preconditions.checkNotNull(str);
        this.zzb = j;
        this.zzc = str2;
        this.zzd = (String) Preconditions.checkNotNull(str3);
        this.zze = i;
        this.zzf = i2;
        this.zzg = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SharedDeviceData)) {
            return false;
        }
        SharedDeviceData sharedDeviceData = (SharedDeviceData) obj;
        return this.zzb == sharedDeviceData.zzb && this.zze == sharedDeviceData.zze && this.zzf == sharedDeviceData.zzf && this.zzg == sharedDeviceData.zzg && this.zza.equals(sharedDeviceData.zza) && Objects.equal(this.zzc, sharedDeviceData.zzc) && this.zzd.equals(sharedDeviceData.zzd);
    }

    public long getCommissioningWindowExpirationMillis() {
        return this.zzb;
    }

    public String getDeviceName() {
        return this.zzd;
    }

    @Deprecated
    public int getDeviceType() {
        return this.zzg;
    }

    public String getManualPairingCode() {
        return this.zza;
    }

    public int getProductId() {
        return this.zzf;
    }

    public String getRoomName() {
        return this.zzc;
    }

    public int getVendorId() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb), this.zzc, this.zzd, Integer.valueOf(this.zze), Integer.valueOf(this.zzf), Integer.valueOf(this.zzg));
    }

    public String toString() {
        int length = this.zza.length();
        Locale locale = Locale.ROOT;
        String str = String.format(locale, ", vendorId=0x%04X", Integer.valueOf(this.zze));
        String str2 = String.format(locale, ", productId=0x%04X", Integer.valueOf(this.zzf));
        String str3 = String.format(locale, ", deviceType=0x%04X", Integer.valueOf(this.zzg));
        int length2 = String.valueOf(length).length();
        long j = this.zzb;
        int length3 = String.valueOf(j).length();
        String str4 = this.zzc;
        int length4 = String.valueOf(str4).length();
        String str5 = this.zzd;
        int length5 = String.valueOf(str5).length();
        int length6 = str.length();
        int length7 = str2.length();
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length2, 82, length3, 12, length4) + 15 + length5 + 1 + length6 + length7 + str3.length() + 1);
        sb.append("SharedDeviceData{manualPairingCode=<length=");
        sb.append(length);
        sb.append(">, commissioningWindowExpirationMillis=");
        sb.append(j);
        sb.append(", roomName='");
        sb.append(str4);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "', deviceName='", str5, "'", str);
        return Fragment$$ExternalSyntheticOutline1.m(sb, str2, str3, "}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getManualPairingCode(), false);
        SafeParcelWriter.writeLong(parcel, 2, getCommissioningWindowExpirationMillis());
        SafeParcelWriter.writeString(parcel, 3, getRoomName(), false);
        SafeParcelWriter.writeString(parcel, 4, getDeviceName(), false);
        SafeParcelWriter.writeInt(parcel, 5, getVendorId());
        SafeParcelWriter.writeInt(parcel, 6, getProductId());
        SafeParcelWriter.writeInt(parcel, 7, getDeviceType());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
