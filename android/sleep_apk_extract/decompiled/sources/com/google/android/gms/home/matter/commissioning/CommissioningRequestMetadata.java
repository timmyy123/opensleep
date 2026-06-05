package com.google.android.gms.home.matter.commissioning;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.home.matter.common.DeviceDescriptor;
import com.google.android.gms.home.matter.common.NetworkLocation;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class CommissioningRequestMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CommissioningRequestMetadata> CREATOR = new zze();
    private final NetworkLocation zza;
    private final long zzb;
    private final DeviceDescriptor zzc;

    public CommissioningRequestMetadata(NetworkLocation networkLocation, long j, DeviceDescriptor deviceDescriptor) {
        this.zza = (NetworkLocation) Preconditions.checkNotNull(networkLocation);
        zzb(j);
        this.zzb = j;
        this.zzc = (DeviceDescriptor) Preconditions.checkNotNull(deviceDescriptor);
    }

    private static long zzb(long j) {
        boolean z = false;
        if (j >= 1 && j <= 99999998) {
            z = true;
        }
        Preconditions.checkArgument(z, "Invalid passcode %d", Long.valueOf(j));
        return j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommissioningRequestMetadata)) {
            return false;
        }
        CommissioningRequestMetadata commissioningRequestMetadata = (CommissioningRequestMetadata) obj;
        return this.zza.equals(commissioningRequestMetadata.zza) && this.zzb == commissioningRequestMetadata.zzb && this.zzc.equals(commissioningRequestMetadata.zzc);
    }

    public DeviceDescriptor getDeviceDescriptor() {
        return this.zzc;
    }

    public NetworkLocation getNetworkLocation() {
        return this.zza;
    }

    public long getPasscode() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hash(this.zza, Long.valueOf(this.zzb), this.zzc);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getNetworkLocation(), i, false);
        SafeParcelWriter.writeLong(parcel, 2, getPasscode());
        SafeParcelWriter.writeParcelable(parcel, 3, getDeviceDescriptor(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
