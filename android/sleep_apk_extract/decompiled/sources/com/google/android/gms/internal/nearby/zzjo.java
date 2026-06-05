package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjo extends AbstractSafeParcelable {
    private final boolean zzb;
    private final boolean zzc;
    public static final zzjo zza = new zzjo(false, false);
    public static final Parcelable.Creator<zzjo> CREATOR = new zzjp();

    public zzjo(boolean z, boolean z2) {
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjo)) {
            return false;
        }
        zzjo zzjoVar = (zzjo) obj;
        return this.zzb == zzjoVar.zzb && this.zzc == zzjoVar.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        return "UwbConnectivityCapability<S-STS: " + this.zzb + ", P-STS: " + this.zzc + ">";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean z = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, z);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
