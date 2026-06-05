package com.google.android.gms.nearby.connection;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    final byte[] zza;
    private final String zzb;
    private final byte[] zzc;
    private final byte[] zzd;
    private final int zze;

    public zzo(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        this.zzb = str;
        this.zzc = bArr;
        this.zzd = bArr2;
        this.zza = bArr3;
        this.zze = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzo) {
            zzo zzoVar = (zzo) obj;
            if (Objects.equal(this.zzb, zzoVar.zzb) && Arrays.equals(this.zzc, zzoVar.zzc) && Arrays.equals(this.zzd, zzoVar.zzd) && Arrays.equals(this.zza, zzoVar.zza) && this.zze == zzoVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(Arrays.hashCode(this.zzd)), Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(this.zze));
    }

    public final String toString() {
        String str = this.zzb;
        byte[] bArr = this.zzc;
        String string = bArr == null ? null : Arrays.toString(bArr);
        byte[] bArr2 = this.zza;
        return Fragment$$ExternalSyntheticOutline1.m(FileInsert$$ExternalSyntheticOutline0.m6m("ConnectionsDevice:<endpointId: ", str, ", endpointInfo: ", string, ", connectivityBytes: "), bArr2 != null ? Arrays.toString(bArr2) : null, ", instanceType : ", zzr.zza(this.zze), ">");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        byte[] bArr = this.zzc;
        SafeParcelWriter.writeByteArray(parcel, 2, bArr == null ? null : (byte[]) bArr.clone(), false);
        byte[] bArr2 = this.zzd;
        SafeParcelWriter.writeByteArray(parcel, 3, bArr2 != null ? (byte[]) bArr2.clone() : null, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
