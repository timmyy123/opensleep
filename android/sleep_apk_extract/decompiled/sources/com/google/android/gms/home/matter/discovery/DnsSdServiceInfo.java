package com.google.android.gms.home.matter.discovery;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.home.matter.common.NetworkLocation;
import com.google.android.gms.internal.serialization.zzdn;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class DnsSdServiceInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DnsSdServiceInfo> CREATOR = new zza();
    private final List zza;
    private final List zzb;
    private final String zzc;
    private final String zzd;

    public DnsSdServiceInfo(List list, List list2, String str, String str2) {
        this.zza = zzdn.zzk(list);
        this.zzb = zzdn.zzk(list2);
        str.getClass();
        this.zzc = str;
        str2.getClass();
        this.zzd = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DnsSdServiceInfo)) {
            return false;
        }
        DnsSdServiceInfo dnsSdServiceInfo = (DnsSdServiceInfo) obj;
        return this.zza.equals(dnsSdServiceInfo.zza) && this.zzb.equals(dnsSdServiceInfo.zzb) && this.zzc.equals(dnsSdServiceInfo.zzc) && this.zzd.equals(dnsSdServiceInfo.zzd);
    }

    public String getInstanceName() {
        return this.zzc;
    }

    public List<NetworkLocation> getNetworkLocations() {
        return this.zzb;
    }

    public String getServiceType() {
        return this.zzd;
    }

    public List<TxtRecord> getTxtRecords() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public String toString() {
        List list = this.zza;
        String strValueOf = String.valueOf(this.zzb);
        String strValueOf2 = String.valueOf(list);
        String str = this.zzc;
        int length = String.valueOf(str).length();
        String str2 = this.zzd;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 47, String.valueOf(str2).length(), 20, strValueOf.length(), 13, strValueOf2.length()) + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "DnsSdServiceInfo{instanceName='", str, "', serviceType='", str2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "', networkLocations=", strValueOf, ", txtRecords=", strValueOf2);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getTxtRecords(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, getNetworkLocations(), false);
        SafeParcelWriter.writeString(parcel, 3, getInstanceName(), false);
        SafeParcelWriter.writeString(parcel, 4, getServiceType(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
