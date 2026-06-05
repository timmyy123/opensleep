package com.google.android.gms.internal.nearby;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjc> CREATOR = new zzjd();
    private final String zza;

    public zzjc(String str) {
        Preconditions.checkArgument(str.length() <= 32, "Cast id should be at most 32 characters.");
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzjc) {
            return Objects.equals(this.zza, ((zzjc) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(17, this.zza);
    }

    public final String toString() {
        Locale locale = Locale.US;
        return FileInsert$$ExternalSyntheticOutline0.m("DataElement<type: CastId, Id: ", this.zza, ">");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
