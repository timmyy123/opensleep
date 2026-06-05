package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class BleDevice extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BleDevice> CREATOR = new zzd();
    private final String zza;
    private final String zzb;
    private final List zzc;
    private final List zzd;

    public BleDevice(String str, String str2, List list, List list2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = Collections.unmodifiableList(list);
        this.zzd = Collections.unmodifiableList(list2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BleDevice)) {
            return false;
        }
        BleDevice bleDevice = (BleDevice) obj;
        return this.zzb.equals(bleDevice.zzb) && this.zza.equals(bleDevice.zza) && new HashSet(this.zzc).equals(new HashSet(bleDevice.zzc)) && new HashSet(this.zzd).equals(new HashSet(bleDevice.zzd));
    }

    public String getAddress() {
        return this.zza;
    }

    public List<DataType> getDataTypes() {
        return this.zzd;
    }

    public String getName() {
        return this.zzb;
    }

    public List<String> getSupportedProfiles() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zza, this.zzc, this.zzd);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.zzb).add(IntegrityManager.INTEGRITY_TYPE_ADDRESS, this.zza).add("dataTypes", this.zzd).add("supportedProfiles", this.zzc).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAddress(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeStringList(parcel, 3, getSupportedProfiles(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getDataTypes(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
