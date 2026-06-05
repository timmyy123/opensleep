package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public class MapValue extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MapValue> CREATOR = new zzv();
    private final int zza;
    private final float zzb;

    public MapValue(int i, float f) {
        this.zza = i;
        this.zzb = f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapValue)) {
            return false;
        }
        MapValue mapValue = (MapValue) obj;
        int i = this.zza;
        if (i != mapValue.zza) {
            return false;
        }
        if (i != 2) {
            if (this.zzb != mapValue.zzb) {
                return false;
            }
        } else if (zza() != mapValue.zza()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (int) this.zzb;
    }

    public final String toString() {
        return this.zza != 2 ? "unknown" : Float.toString(zza());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeFloat(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final float zza() {
        Preconditions.checkState(this.zza == 2, "Value is not in float format");
        return this.zzb;
    }
}
