package com.google.android.gms.internal.nearby;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class zziq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zziq> CREATOR = new zzir();
    public static final zziq zza = new zziq(1, "", null);
    final int zzb;
    private final String zzc;
    private final String zzd;

    public zziq(int i, String str, String str2) {
        this.zzb = ((Integer) Preconditions.checkNotNull(Integer.valueOf(i))).intValue();
        this.zzc = str == null ? "" : str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zziq)) {
            return false;
        }
        zziq zziqVar = (zziq) obj;
        return Objects.equal(this.zzc, zziqVar.zzc) && Objects.equal(this.zzd, zziqVar.zzd);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzc, this.zzd);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NearbyDevice{handle=");
        sb.append(this.zzc);
        sb.append(", bluetoothAddress=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.zzd, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zzc;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 3, str, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
