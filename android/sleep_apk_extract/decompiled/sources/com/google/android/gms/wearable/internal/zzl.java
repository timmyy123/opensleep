package com.google.android.gms.wearable.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes4.dex */
public final class zzl extends AbstractSafeParcelable implements com.google.android.gms.wearable.zzb {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final byte zzh;
    private final byte zzi;
    private final byte zzj;
    private final byte zzk;
    private final String zzl;

    public zzl(int i, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4, String str7) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
        this.zzh = b;
        this.zzi = b2;
        this.zzj = b3;
        this.zzk = b4;
        this.zzl = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzl.class != obj.getClass()) {
            return false;
        }
        zzl zzlVar = (zzl) obj;
        if (this.zza != zzlVar.zza || this.zzh != zzlVar.zzh || this.zzi != zzlVar.zzi || this.zzj != zzlVar.zzj || this.zzk != zzlVar.zzk || !this.zzb.equals(zzlVar.zzb)) {
            return false;
        }
        String str = this.zzc;
        String str2 = zzlVar.zzc;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        if (!this.zzd.equals(zzlVar.zzd) || !this.zze.equals(zzlVar.zze) || !this.zzf.equals(zzlVar.zzf)) {
            return false;
        }
        String str3 = this.zzg;
        String str4 = zzlVar.zzg;
        if (str3 == null ? str4 != null : !str3.equals(str4)) {
            return false;
        }
        String str5 = this.zzl;
        String str6 = zzlVar.zzl;
        return str5 != null ? str5.equals(str6) : str6 == null;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() + ((this.zza + 31) * 31);
        String str = this.zzc;
        int iM = FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(iHashCode, 31, str != null ? str.hashCode() : 0, 31), 31, this.zzd), 31, this.zze), 31, this.zzf);
        String str2 = this.zzg;
        int iHashCode2 = (((((((((iM + (str2 != null ? str2.hashCode() : 0)) * 31) + this.zzh) * 31) + this.zzi) * 31) + this.zzj) * 31) + this.zzk) * 31;
        String str3 = this.zzl;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        int i = this.zza;
        int length = String.valueOf(i).length();
        String str = this.zzb;
        int length2 = String.valueOf(str).length();
        String str2 = this.zzc;
        int length3 = String.valueOf(str2).length();
        byte b = this.zzh;
        int length4 = String.valueOf((int) b).length();
        byte b2 = this.zzi;
        int length5 = String.valueOf((int) b2).length();
        byte b3 = this.zzj;
        int length6 = String.valueOf((int) b3).length();
        byte b4 = this.zzk;
        int length7 = String.valueOf((int) b4).length();
        String str3 = this.zzl;
        StringBuilder sb = new StringBuilder(length + 41 + length2 + 13 + length3 + 11 + length4 + 13 + length5 + 13 + length6 + 16 + length7 + 15 + String.valueOf(str3).length() + 2);
        zzba$$ExternalSyntheticOutline0.m(sb, "AncsNotificationParcelable{, id=", i, ", appId='", str);
        zzba$$ExternalSyntheticOutline0.m(sb, "', dateTime='", str2, "', eventId=", b);
        Fragment$$ExternalSyntheticOutline1.m(sb, ", eventFlags=", b2, ", categoryId=", b3);
        zzba$$ExternalSyntheticOutline0.m(sb, ", categoryCount=", b4, ", packageName='", str3);
        sb.append("'}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        String str = this.zzb;
        SafeParcelWriter.writeString(parcel, 3, str, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        String str2 = this.zzg;
        if (str2 != null) {
            str = str2;
        }
        SafeParcelWriter.writeString(parcel, 8, str, false);
        SafeParcelWriter.writeByte(parcel, 9, this.zzh);
        SafeParcelWriter.writeByte(parcel, 10, this.zzi);
        SafeParcelWriter.writeByte(parcel, 11, this.zzj);
        SafeParcelWriter.writeByte(parcel, 12, this.zzk);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
