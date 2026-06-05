package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzpi;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzh();
    private final byte[] zza;
    private final byte[] zzb;
    private final byte[] zzc;
    private final byte[] zzd;
    private final byte[] zze;

    public zzg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.zza = bArr;
        this.zzb = bArr2;
        this.zzc = bArr3;
        this.zzd = bArr4;
        this.zze = bArr5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzg) {
            zzg zzgVar = (zzg) obj;
            if (Arrays.equals(this.zza, zzgVar.zza) && Arrays.equals(this.zzb, zzgVar.zzb) && Arrays.equals(this.zzc, zzgVar.zzc) && Arrays.equals(this.zzd, zzgVar.zzd) && Arrays.equals(this.zze, zzgVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(Arrays.hashCode(this.zzb)), Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(Arrays.hashCode(this.zzd)), Integer.valueOf(Arrays.hashCode(this.zze)));
    }

    public final String toString() {
        String string;
        byte[] bArr = this.zza;
        if (bArr != null && bArr.length == 6) {
            StringBuilder sb = new StringBuilder(18);
            int i = 0;
            for (int i2 = 0; i2 < 6; i2++) {
                byte b = bArr[i2];
                if (sb.length() > 0) {
                    sb.append(':');
                }
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            string = sb.toString();
            while (true) {
                int length = string.length();
                if (i >= length) {
                    break;
                }
                if (zzpi.zza(string.charAt(i))) {
                    char[] charArray = string.toCharArray();
                    while (i < length) {
                        char c = charArray[i];
                        if (zzpi.zza(c)) {
                            charArray[i] = (char) (c ^ ' ');
                        }
                        i++;
                    }
                    string = String.valueOf(charArray);
                } else {
                    i++;
                }
            }
        } else {
            string = null;
        }
        byte[] bArr2 = this.zzb;
        Integer numValueOf = bArr2 == null ? null : Integer.valueOf(Arrays.hashCode(bArr2));
        byte[] bArr3 = this.zzc;
        Integer numValueOf2 = bArr3 == null ? null : Integer.valueOf(Arrays.hashCode(bArr3));
        byte[] bArr4 = this.zzd;
        Integer numValueOf3 = bArr4 == null ? null : Integer.valueOf(Arrays.hashCode(bArr4));
        byte[] bArr5 = this.zze;
        return "BleConnectivityInfo:<bleMacAddress hash: " + string + ", bleGattCharacteristic hash: " + numValueOf + ", actions hash: " + numValueOf2 + ", psm hash: " + numValueOf3 + ", deviceToken hash : " + (bArr5 != null ? Integer.valueOf(Arrays.hashCode(bArr5)) : null) + ">";
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
        SafeParcelWriter.writeByteArray(parcel, 4, bArr4 == null ? null : (byte[]) bArr4.clone(), false);
        byte[] bArr5 = this.zze;
        SafeParcelWriter.writeByteArray(parcel, 5, bArr5 != null ? (byte[]) bArr5.clone() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
