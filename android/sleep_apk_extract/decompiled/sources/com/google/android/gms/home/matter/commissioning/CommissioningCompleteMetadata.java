package com.google.android.gms.home.matter.commissioning;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.serialization.zzdn;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class CommissioningCompleteMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CommissioningCompleteMetadata> CREATOR = new zzc();
    private final List zza;
    private final String zzb;
    private final String zzc;

    public CommissioningCompleteMetadata(List list, String str, String str2) {
        this.zza = zzdn.zzk(list);
        this.zzb = str;
        this.zzc = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommissioningCompleteMetadata)) {
            return false;
        }
        CommissioningCompleteMetadata commissioningCompleteMetadata = (CommissioningCompleteMetadata) obj;
        return this.zza.equals(commissioningCompleteMetadata.zza) && Objects.equal(this.zzb, commissioningCompleteMetadata.zzb) && Objects.equal(this.zzc, commissioningCompleteMetadata.zzc);
    }

    public String getDeviceNameHint() {
        return this.zzb;
    }

    @Deprecated
    public List<Room> getRooms() {
        return this.zza;
    }

    public String getToken() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getRooms(), false);
        SafeParcelWriter.writeString(parcel, 2, getDeviceNameHint(), false);
        SafeParcelWriter.writeString(parcel, 3, getToken(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
