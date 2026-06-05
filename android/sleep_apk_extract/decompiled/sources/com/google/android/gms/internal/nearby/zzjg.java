package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjg> CREATOR = new zzjh();
    private final int zza;

    public zzjg(int i) {
        this.zza = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzjg) && this.zza == ((zzjg) obj).zza;
    }

    public final int hashCode() {
        return Objects.hash(22, Integer.valueOf(this.zza));
    }

    public final String toString() {
        Locale locale = Locale.US;
        return Fragment$$ExternalSyntheticOutline1.m(this.zza, "DataElement<type: DeviceType, value: ", ">");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
