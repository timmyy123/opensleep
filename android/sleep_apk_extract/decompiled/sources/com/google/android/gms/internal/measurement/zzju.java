package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzju extends AbstractSafeParcelable implements Comparable<zzju> {
    public static final Parcelable.Creator<zzju> CREATOR = new zzjv();
    public final int zza;
    public final int zzb;

    public zzju(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean equals(@Nullable Object obj) {
        return (obj instanceof zzju) && compareTo((zzju) obj) == 0;
    }

    public final int hashCode() {
        return (this.zza * 31) + this.zzb;
    }

    public final String toString() {
        int i = this.zza;
        int length = String.valueOf(i).length();
        int i2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 19 + String.valueOf(i2).length() + 1);
        Fragment$$ExternalSyntheticOutline1.m(sb, "GenericDimension(", i, ", ", i2);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzju zzjuVar) {
        int i = this.zza;
        int i2 = zzjuVar.zza;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = this.zzb;
        int i4 = zzjuVar.zzb;
        if (i3 < i4) {
            return -1;
        }
        return i3 > i4 ? 1 : 0;
    }
}
