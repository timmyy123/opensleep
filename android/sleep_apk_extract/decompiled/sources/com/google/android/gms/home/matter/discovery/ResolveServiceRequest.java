package com.google.android.gms.home.matter.discovery;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class ResolveServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveServiceRequest> CREATOR = new zzb();
    private final String zza;
    private final String zzb;

    public ResolveServiceRequest(String str, String str2) {
        str.getClass();
        this.zza = str;
        str2.getClass();
        this.zzb = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveServiceRequest)) {
            return false;
        }
        ResolveServiceRequest resolveServiceRequest = (ResolveServiceRequest) obj;
        return this.zzb.equals(resolveServiceRequest.zzb) && this.zza.equals(resolveServiceRequest.zza);
    }

    public String getInstanceName() {
        return this.zza;
    }

    public String getServiceType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zza);
    }

    public String toString() {
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 52 + String.valueOf(str2).length() + 2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "ResolveServiceRequest{instanceName='", str, "', serviceType='", str2);
        sb.append("'}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getInstanceName(), false);
        SafeParcelWriter.writeString(parcel, 2, getServiceType(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
