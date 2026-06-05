package com.google.android.gms.home.matter.commissioning;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.home.matter.common.DeviceDescriptor;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class CommissioningResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CommissioningResult> CREATOR = new zzf();
    private final DeviceDescriptor zza;
    private final Room zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;

    public CommissioningResult(DeviceDescriptor deviceDescriptor, Room room, String str, String str2, List list) {
        this.zza = (DeviceDescriptor) Preconditions.checkNotNull(deviceDescriptor);
        this.zzb = room;
        this.zzc = (String) Preconditions.checkNotNull(str);
        this.zzd = str2;
        this.zze = list;
    }

    public static CommissioningResult fromIntentSenderResult(int i, Intent intent) {
        if (i == -1) {
            CommissioningResult commissioningResult = intent != null ? (CommissioningResult) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.android.gms.home.matter.commissioning.EXTRA_COMMISSIONING_RESULT", CREATOR) : null;
            if (commissioningResult != null) {
                return commissioningResult;
            }
            throw new ApiException(new Status(8, "IntentSender result did not contain the expected data. This should only be called in response to an IntentSender result for the CommissioningClient.commissionDevice() API."));
        }
        Status status = intent != null ? (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.android.gms.home.matter.commissioning.EXTRA_COMMISSIONING_ERROR_STATUS", Status.CREATOR) : null;
        if (status == null) {
            status = Status.RESULT_INTERNAL_ERROR;
        }
        throw new ApiException(status);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommissioningResult)) {
            return false;
        }
        CommissioningResult commissioningResult = (CommissioningResult) obj;
        return this.zza.equals(commissioningResult.zza) && Objects.equals(this.zzb, commissioningResult.zzb) && this.zzc.equals(commissioningResult.zzc) && Objects.equals(this.zzd, commissioningResult.zzd) && Objects.equals(this.zze, commissioningResult.zze);
    }

    public DeviceDescriptor getCommissionedDeviceDescriptor() {
        return this.zza;
    }

    public List<String> getDeviceIds() {
        return this.zze;
    }

    public String getDeviceName() {
        return this.zzc;
    }

    public Room getRoom() {
        return this.zzb;
    }

    public String getToken() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hash(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getCommissionedDeviceDescriptor(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getRoom(), i, false);
        SafeParcelWriter.writeString(parcel, 4, getDeviceName(), false);
        SafeParcelWriter.writeString(parcel, 5, getToken(), false);
        SafeParcelWriter.writeStringList(parcel, 6, getDeviceIds(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
