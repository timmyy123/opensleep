package com.google.android.gms.home.matter.commissioning;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.home.matter.common.DeviceDescriptor;
import com.google.android.gms.home.matter.common.NetworkLocation;

/* JADX INFO: loaded from: classes3.dex */
public class ShareDeviceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ShareDeviceRequest> CREATOR = new zzj();
    private final CommissioningWindow zza;
    private final DeviceDescriptor zzb;
    private final String zzc;
    private final String zzd;
    private final NetworkLocation zze;

    public ShareDeviceRequest(CommissioningWindow commissioningWindow, DeviceDescriptor deviceDescriptor, String str, String str2, NetworkLocation networkLocation) {
        this.zza = (CommissioningWindow) Preconditions.checkNotNull(commissioningWindow);
        this.zzb = (DeviceDescriptor) Preconditions.checkNotNull(deviceDescriptor);
        this.zzc = (String) Preconditions.checkNotNull(str);
        this.zzd = str2;
        this.zze = networkLocation;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareDeviceRequest)) {
            return false;
        }
        ShareDeviceRequest shareDeviceRequest = (ShareDeviceRequest) obj;
        return Objects.equal(this.zza, shareDeviceRequest.zza) && Objects.equal(this.zzb, shareDeviceRequest.zzb) && Objects.equal(this.zzc, shareDeviceRequest.zzc) && Objects.equal(this.zzd, shareDeviceRequest.zzd) && Objects.equal(this.zze, shareDeviceRequest.zze);
    }

    public CommissioningWindow getCommissioningWindow() {
        return this.zza;
    }

    public DeviceDescriptor getDeviceDescriptor() {
        return this.zzb;
    }

    public String getDeviceName() {
        return this.zzc;
    }

    public NetworkLocation getNetworkLocation() {
        return this.zze;
    }

    public String getRoomName() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getCommissioningWindow(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getDeviceDescriptor(), i, false);
        SafeParcelWriter.writeString(parcel, 3, getDeviceName(), false);
        SafeParcelWriter.writeString(parcel, 4, getRoomName(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getNetworkLocation(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
