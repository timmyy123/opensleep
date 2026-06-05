package com.google.android.gms.home.matter.commissioning;

import android.accounts.Account;
import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class CommissioningRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CommissioningRequest> CREATOR = new zzd();
    private final Account zza;
    private final String zzb;
    private final DeviceInfo zzc;
    private final String zzd;
    private final String zze;
    private final ComponentName zzf;
    private final boolean zzg;
    private final Long zzh;
    private final boolean zzi;

    public interface Builder {
        CommissioningRequest build();

        Builder setDeviceNameHint(String str);

        Builder setShareDeviceFlow(boolean z);
    }

    public CommissioningRequest(Account account, String str, DeviceInfo deviceInfo, String str2, String str3, ComponentName componentName, boolean z, Long l, boolean z2) {
        this.zza = account;
        this.zzb = str;
        this.zzc = deviceInfo;
        this.zzd = str2;
        this.zze = str3;
        this.zzf = componentName;
        this.zzg = z;
        this.zzh = l;
        this.zzi = z2;
    }

    public static Builder builder() {
        zza zzaVar = new zza();
        zzaVar.setStoreToGoogleFabric(false);
        zzaVar.setShareDeviceFlow(false);
        return zzaVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommissioningRequest)) {
            return false;
        }
        CommissioningRequest commissioningRequest = (CommissioningRequest) obj;
        return Objects.equal(this.zza, commissioningRequest.zza) && Objects.equal(this.zzb, commissioningRequest.zzb) && Objects.equal(this.zzc, commissioningRequest.zzc) && Objects.equal(this.zzd, commissioningRequest.zzd) && Objects.equal(this.zze, commissioningRequest.zze) && Objects.equal(this.zzf, commissioningRequest.zzf) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(commissioningRequest.zzg)) && Objects.equal(this.zzh, commissioningRequest.zzh) && Objects.equal(Boolean.valueOf(this.zzi), Boolean.valueOf(commissioningRequest.zzi));
    }

    public ComponentName getCommissioningService() {
        return this.zzf;
    }

    public DeviceInfo getDeviceInfo() {
        return this.zzc;
    }

    public String getDeviceNameHint() {
        return this.zze;
    }

    public String getOnboardingPayload() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, Boolean.valueOf(this.zzg), this.zzh, Boolean.valueOf(this.zzi));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Account account = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, account, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getDeviceInfo(), i, false);
        SafeParcelWriter.writeString(parcel, 4, getOnboardingPayload(), false);
        SafeParcelWriter.writeString(parcel, 5, getDeviceNameHint(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getCommissioningService(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeLongObject(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
