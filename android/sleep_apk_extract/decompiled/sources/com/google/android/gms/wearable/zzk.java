package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();
    private final Uri zza;
    private final int zzb;

    public zzk(Uri uri, int i) {
        this.zza = uri;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzk)) {
            return false;
        }
        zzk zzkVar = (zzk) obj;
        return Objects.equals(this.zza, zzkVar.zza) && this.zzb == zzkVar.zzb;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Integer.valueOf(this.zzb));
    }

    public final String toString() {
        com.google.android.gms.internal.wearable.zzag zzagVarZza = com.google.android.gms.internal.wearable.zzah.zza(this);
        zzagVarZza.zza(ShareConstants.MEDIA_URI, this.zza);
        zzagVarZza.zzb("filterType", this.zzb);
        return zzagVarZza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Uri uri = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, uri, i, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
