package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjm> CREATOR = new zzjn();
    private final int zza;

    public zzjm(int i) {
        boolean z = false;
        if (i >= 0 && i <= 15) {
            z = true;
        }
        Preconditions.checkArgument(z, "Sequence number should be 4 bits.");
        this.zza = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzjm) && this.zza == ((zzjm) obj).zza;
    }

    public final int hashCode() {
        return Objects.hash(19, Integer.valueOf(this.zza));
    }

    public final String toString() {
        Locale locale = Locale.US;
        return Fragment$$ExternalSyntheticOutline1.m(this.zza, "DataElement<type: ContextSequenceNumber, value: ", ">");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
