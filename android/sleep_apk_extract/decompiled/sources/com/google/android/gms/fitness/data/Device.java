package com.google.android.gms.fitness.data;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class Device extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new zzl();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final int zzd;
    private final int zze;

    public Device(String str, String str2, String str3, int i, int i2) {
        this.zza = (String) Preconditions.checkNotNull(str);
        this.zzb = (String) Preconditions.checkNotNull(str2);
        if (str3 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Device UID is null.");
            throw null;
        }
        this.zzc = str3;
        this.zzd = i;
        this.zze = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        return Objects.equal(this.zza, device.zza) && Objects.equal(this.zzb, device.zzb) && Objects.equal(this.zzc, device.zzc) && this.zzd == device.zzd && this.zze == device.zze;
    }

    public String getManufacturer() {
        return this.zza;
    }

    public String getModel() {
        return this.zzb;
    }

    public int getType() {
        return this.zzd;
    }

    public String getUid() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Integer.valueOf(this.zzd));
    }

    public String toString() {
        String strZza = zza();
        return FileInsert$$ExternalSyntheticOutline0.m(this.zze, "}", Fragment$$ExternalSyntheticOutline1.m(this.zzd, "Device{", strZza, ":", ":"));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getManufacturer(), false);
        SafeParcelWriter.writeString(parcel, 2, getModel(), false);
        SafeParcelWriter.writeString(parcel, 4, getUid(), false);
        SafeParcelWriter.writeInt(parcel, 5, getType());
        SafeParcelWriter.writeInt(parcel, 6, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return Fragment$$ExternalSyntheticOutline1.m(this.zza, ":", this.zzb, ":", this.zzc);
    }
}
