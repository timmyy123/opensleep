package com.google.android.gms.wearable.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelClient;

/* JADX INFO: loaded from: classes4.dex */
public final class zzcb extends AbstractSafeParcelable implements Channel, ChannelClient.Channel {
    public static final Parcelable.Creator<zzcb> CREATOR = new zzcc();
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzcb(String str, String str2, String str3) {
        str.getClass();
        this.zza = str;
        str2.getClass();
        this.zzb = str2;
        str3.getClass();
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcb)) {
            return false;
        }
        zzcb zzcbVar = (zzcb) obj;
        return this.zza.equals(zzcbVar.zza) && Objects.equal(zzcbVar.zzb, this.zzb) && Objects.equal(zzcbVar.zzc, this.zzc);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        int i = 0;
        for (char c : str.toCharArray()) {
            i += c;
        }
        String strTrim = str.trim();
        int length = strTrim.length();
        if (length > 25) {
            String strSubstring = strTrim.substring(0, 10);
            String strSubstring2 = strTrim.substring(length - 10, length);
            StringBuilder sb = new StringBuilder(strSubstring.length() + 3 + strSubstring2.length() + 2 + String.valueOf(i).length());
            FileInsert$$ExternalSyntheticOutline0.m(sb, strSubstring, "...", strSubstring2, "::");
            sb.append(i);
            strTrim = sb.toString();
        }
        String str2 = this.zzb;
        String str3 = this.zzc;
        StringBuilder sb2 = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(String.valueOf(str2).length() + strTrim.length() + 23 + 7, 1, String.valueOf(str3)));
        sb2.append("Channel{token=");
        sb2.append(strTrim);
        sb2.append(", nodeId=");
        sb2.append(str2);
        return Fragment$$ExternalSyntheticOutline1.m(sb2, ", path=", str3, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, str, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
