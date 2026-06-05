package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
    private final byte[] zza;
    private final byte[] zzb;
    private final byte[] zzc;
    private final byte[] zzd;

    public zzae(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.zza = bArr;
        this.zzb = bArr2;
        this.zzc = bArr3;
        this.zzd = bArr4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzae) {
            zzae zzaeVar = (zzae) obj;
            if (Arrays.equals(this.zza, zzaeVar.zza) && Arrays.equals(this.zzb, zzaeVar.zzb) && Arrays.equals(this.zzc, zzaeVar.zzc) && Arrays.equals(this.zzd, zzaeVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(Arrays.hashCode(this.zzd)));
    }

    public final String toString() {
        int iHashCode = Arrays.hashCode(this.zza);
        int iHashCode2 = Arrays.hashCode(this.zzb);
        int iHashCode3 = Arrays.hashCode(this.zzc);
        int iHashCode4 = Arrays.hashCode(this.zzd);
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(iHashCode, iHashCode2, "WifiLanConnectivityInfo:<wifiLanPort hash: ", ">, <wifiLanIp hash: ", ">, <BSSID hash: ");
        sbM.append(iHashCode3);
        sbM.append(">, <actions hash: ");
        sbM.append(iHashCode4);
        sbM.append(">");
        return sbM.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        byte[] bArr = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, bArr == null ? null : (byte[]) bArr.clone(), false);
        byte[] bArr2 = this.zzb;
        SafeParcelWriter.writeByteArray(parcel, 2, bArr2 == null ? null : (byte[]) bArr2.clone(), false);
        byte[] bArr3 = this.zzc;
        SafeParcelWriter.writeByteArray(parcel, 3, bArr3 == null ? null : (byte[]) bArr3.clone(), false);
        byte[] bArr4 = this.zzd;
        SafeParcelWriter.writeByteArray(parcel, 4, bArr4 != null ? (byte[]) bArr4.clone() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
