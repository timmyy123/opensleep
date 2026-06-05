package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class zzccb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzccb> CREATOR = new zzccc();
    public final String zza;
    public final int zzb;

    public zzccb(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public static zzccb zza(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzccb(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzccb)) {
            return false;
        }
        zzccb zzccbVar = (zzccb) obj;
        return Objects.equal(this.zza, zzccbVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzccbVar.zzb));
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, str, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
