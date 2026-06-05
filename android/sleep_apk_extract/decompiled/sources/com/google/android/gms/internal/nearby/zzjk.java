package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjk> CREATOR = new zzjl();
    private static final String[] zza = {"UNKNOWN", "PHONE", "TABLET", "DISPLAY", "LAPTOP", "TV", "WATCH", "CHROMEOS", "FOLDABLE", "AUTOMOTIVE", "SPEAKER"};
    private final long zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private final long zzf;
    private final String zzg;
    private final byte[] zzh;
    private final byte[] zzi;
    private final List zzj;
    private final int zzk;
    private final byte[] zzl;
    private final zzje zzm;
    private final int zzn;
    private final int zzo;
    private final String zzp;

    public zzjk(long j, String str, int i, String str2, long j2, String str3, byte[] bArr, byte[] bArr2, List list, int i2, byte[] bArr3, zzje zzjeVar, int i3, int i4, String str4) {
        this.zzb = j;
        this.zzc = str;
        this.zzd = i;
        this.zze = str2;
        this.zzf = j2;
        this.zzg = str3;
        this.zzh = bArr;
        this.zzi = bArr2;
        this.zzj = list;
        this.zzk = i2;
        this.zzl = bArr3;
        this.zzm = zzjeVar;
        this.zzn = i3;
        this.zzo = i4;
        this.zzp = str4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzjk) {
            zzjk zzjkVar = (zzjk) obj;
            if (Objects.equal(Long.valueOf(this.zzb), Long.valueOf(zzjkVar.zzb)) && Objects.equal(this.zzc, zzjkVar.zzc) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzjkVar.zzd)) && Objects.equal(this.zze, zzjkVar.zze) && Objects.equal(this.zzg, zzjkVar.zzg) && Arrays.equals(this.zzh, zzjkVar.zzh) && Arrays.equals(this.zzi, zzjkVar.zzi) && Objects.equal(this.zzj, zzjkVar.zzj) && Objects.equal(Integer.valueOf(this.zzk), Integer.valueOf(zzjkVar.zzk)) && Arrays.equals(this.zzl, zzjkVar.zzl) && Objects.equal(this.zzm, zzjkVar.zzm) && Objects.equal(Integer.valueOf(this.zzn), Integer.valueOf(zzjkVar.zzn)) && Objects.equal(Integer.valueOf(this.zzo), Integer.valueOf(zzjkVar.zzo)) && Objects.equal(this.zzp, zzjkVar.zzp)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), this.zze, this.zzg, Integer.valueOf(Arrays.hashCode(this.zzh)), Integer.valueOf(Arrays.hashCode(this.zzi)), this.zzj, Integer.valueOf(this.zzk), Integer.valueOf(Arrays.hashCode(this.zzl)), this.zzm, Integer.valueOf(this.zzn), Integer.valueOf(this.zzo), this.zzp);
    }

    public final String toString() {
        char c;
        Long lValueOf = Long.valueOf(this.zzb);
        String str = this.zzc;
        switch (this.zzd) {
            case 1:
                c = 1;
                break;
            case 2:
                c = 2;
                break;
            case 3:
                c = 3;
                break;
            case 4:
                c = 4;
                break;
            case 5:
                c = 5;
                break;
            case 6:
                c = 6;
                break;
            case 7:
                c = 7;
                break;
            case 8:
                c = '\b';
                break;
            case 9:
                c = '\t';
                break;
            case 10:
                c = '\n';
                break;
            default:
                c = 0;
                break;
        }
        String str2 = zza[c];
        String str3 = this.zze;
        Long lValueOf2 = Long.valueOf(this.zzf);
        String str4 = this.zzg;
        byte[] bArr = this.zzh;
        String string = bArr == null ? null : Arrays.toString(bArr);
        byte[] bArr2 = this.zzi;
        Integer numValueOf = bArr2 == null ? null : Integer.valueOf(Arrays.hashCode(bArr2));
        List list = this.zzj;
        Integer numValueOf2 = Integer.valueOf(this.zzk);
        byte[] bArr3 = this.zzl;
        return String.format("PresenceDevice:<deviceId: %s, deviceName: %s, deviceType: %s, deviceImageUrl: %s, discoveryTimestampMillis: %s, endpointId: %s, endpointInfo: %s, bluetoothMacAddress hash: %s, actions: %s, identityType: %s, connectivityBytes hash: %s, dataElements: %s, discoveryMedium: %s, instance type %s>, Dusi: %s", lValueOf, str, str2, str3, lValueOf2, str4, string, numValueOf, list, numValueOf2, bArr3 != null ? Arrays.toString(bArr3) : null, this.zzm, Integer.valueOf(this.zzn), com.google.android.gms.nearby.connection.zzr.zza(this.zzo), this.zzp);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        long j = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, j);
        SafeParcelWriter.writeString(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeString(parcel, 4, this.zze, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzf);
        SafeParcelWriter.writeString(parcel, 6, this.zzg, false);
        byte[] bArr = this.zzh;
        SafeParcelWriter.writeByteArray(parcel, 7, bArr == null ? null : (byte[]) bArr.clone(), false);
        byte[] bArr2 = this.zzi;
        SafeParcelWriter.writeByteArray(parcel, 8, bArr2 != null ? (byte[]) bArr2.clone() : null, false);
        List list = this.zzj;
        SafeParcelWriter.writeTypedList(parcel, 9, list == null ? zzpt.zzk() : zzpt.zzj(list), false);
        SafeParcelWriter.writeInt(parcel, 10, this.zzk);
        SafeParcelWriter.writeByteArray(parcel, 11, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzm, i, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzn);
        SafeParcelWriter.writeInt(parcel, 14, this.zzo);
        SafeParcelWriter.writeString(parcel, 15, this.zzp, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
