package com.google.android.gms.home.matter.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class ResolveServiceResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveServiceResult> CREATOR = new zzc();
    private final DnsSdServiceInfo zza;

    public ResolveServiceResult(DnsSdServiceInfo dnsSdServiceInfo) {
        dnsSdServiceInfo.getClass();
        this.zza = dnsSdServiceInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResolveServiceResult) {
            return this.zza.equals(((ResolveServiceResult) obj).zza);
        }
        return false;
    }

    public DnsSdServiceInfo getServiceInfo() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.zza);
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strValueOf.length() + 34), "ResolveServiceResult{serviceInfo=", strValueOf, "}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getServiceInfo(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
