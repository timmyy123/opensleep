package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes4.dex */
public final class zzj extends AbstractSafeParcelable implements com.google.android.gms.wearable.zza {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    private final byte zza;
    private final byte zzb;
    private final String zzc;

    public zzj(byte b, byte b2, String str) {
        this.zza = b;
        this.zzb = b2;
        this.zzc = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzj.class != obj.getClass()) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        return this.zza == zzjVar.zza && this.zzb == zzjVar.zzb && this.zzc.equals(zzjVar.zzc);
    }

    public final int hashCode() {
        byte b = this.zza;
        String str = this.zzc;
        return str.hashCode() + ((((b + 31) * 31) + this.zzb) * 31);
    }

    public final String toString() {
        byte b = this.zza;
        int length = String.valueOf((int) b).length();
        byte b2 = this.zzb;
        int length2 = String.valueOf((int) b2).length();
        String str = this.zzc;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 53, length2, 10, String.valueOf(str).length()) + 2);
        Fragment$$ExternalSyntheticOutline1.m(sb, "AmsEntityUpdateParcelable{, mEntityId=", b, ", mAttributeId=", b2);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", mValue='", str, "'}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, this.zza);
        SafeParcelWriter.writeByte(parcel, 3, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
