package com.google.android.gms.home.matter.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.serialization.zzdf;

/* JADX INFO: loaded from: classes3.dex */
public final class TxtRecord extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TxtRecord> CREATOR = new zzd();
    private final String zza;
    private final String zzb;

    public TxtRecord(String str, String str2) {
        zzdf.zza(!str.isEmpty(), "Key cannot be empty.");
        zzdf.zzc(str2, "Value cannot be null.");
        this.zza = str;
        this.zzb = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TxtRecord)) {
            return false;
        }
        TxtRecord txtRecord = (TxtRecord) obj;
        return this.zza.equals(txtRecord.zza) && this.zzb.equals(txtRecord.zzb);
    }

    public String getKey() {
        return this.zza;
    }

    public String getValue() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public String toString() {
        boolean zIsEmpty = this.zzb.isEmpty();
        String str = this.zza;
        if (zIsEmpty) {
            return str;
        }
        String str2 = this.zzb;
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length()), str, "=", str2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getKey(), false);
        SafeParcelWriter.writeString(parcel, 2, getValue(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
