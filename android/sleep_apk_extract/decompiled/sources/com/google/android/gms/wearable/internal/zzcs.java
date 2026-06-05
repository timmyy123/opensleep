package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class zzcs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcs> CREATOR = new zzct();
    public final int zza;
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final boolean zze;
    public final List zzf;
    public final String zzg;
    public final Long zzh;

    public zzcs(int i, boolean z, boolean z2, boolean z3, boolean z4, List list, String str, Long l) {
        this.zza = i;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = list;
        this.zzg = str;
        this.zzh = l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcs)) {
            return false;
        }
        zzcs zzcsVar = (zzcs) obj;
        if (this.zza == zzcsVar.zza && this.zzb == zzcsVar.zzb && this.zzc == zzcsVar.zzc && this.zzd == zzcsVar.zzd && this.zze == zzcsVar.zze) {
            List list = zzcsVar.zzf;
            List list2 = this.zzf;
            if (list2 == null || list == null ? list2 == list : !(!list2.containsAll(list) || list2.size() != list.size())) {
                if (Objects.equal(this.zzg, zzcsVar.zzg) && Objects.equal(this.zzh, zzcsVar.zzh)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf, this.zzg, this.zzh);
    }

    public final String toString() {
        int i = this.zza;
        String strValueOf = String.valueOf(this.zzf);
        int length = String.valueOf(i).length();
        boolean z = this.zzb;
        int length2 = String.valueOf(z).length();
        boolean z2 = this.zzc;
        int length3 = String.valueOf(z2).length();
        boolean z3 = this.zzd;
        int length4 = String.valueOf(z3).length();
        boolean z4 = this.zze;
        int length5 = String.valueOf(z4).length();
        int length6 = strValueOf.length();
        String str = this.zzg;
        int length7 = String.valueOf(str).length();
        Long l = this.zzh;
        StringBuilder sb = new StringBuilder(length + 46 + length2 + 21 + length3 + 23 + length4 + 22 + length5 + 25 + length6 + 10 + length7 + 27 + String.valueOf(l).length() + 1);
        sb.append("ConsentResponse {statusCode =");
        sb.append(i);
        sb.append(", hasTosConsent =");
        sb.append(z);
        zza$$ExternalSyntheticOutline0.m(sb, ", hasLoggingConsent =", z2, ", hasCloudSyncConsent =", z3);
        sb.append(", hasLocationConsent =");
        sb.append(z4);
        sb.append(", accountConsentRecords =");
        sb.append(strValueOf);
        sb.append(", nodeId =");
        sb.append(str);
        sb.append(", lastUpdateRequestedTime =");
        sb.append(l);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeLongObject(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
