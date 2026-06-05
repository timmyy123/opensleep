package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ConnectionConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zzf();
    private final String zza;
    private final String zzb;
    private final int zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private volatile String zzg;
    private final boolean zzh;
    private final String zzi;
    private final String zzj;
    private final int zzk;
    private final List zzl;
    private final boolean zzm;
    private final boolean zzn;
    private final zzi zzo;
    private final boolean zzp;
    private final zzg zzq;
    private final int zzr;
    private final int zzs;
    private final boolean zzt;

    public ConnectionConfiguration(String str, String str2, int i, int i2, boolean z, boolean z2, String str3, boolean z3, String str4, String str5, int i3, List list, boolean z4, boolean z5, zzi zziVar, boolean z6, zzg zzgVar, int i4, int i5, boolean z7) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = i2;
        this.zze = z;
        this.zzf = z2;
        this.zzg = str3;
        this.zzh = z3;
        this.zzi = str4;
        this.zzj = str5;
        this.zzk = i3;
        this.zzl = list;
        this.zzm = z4;
        this.zzn = z5;
        this.zzo = zziVar;
        this.zzp = z6;
        this.zzq = zzgVar;
        this.zzr = i4;
        this.zzs = i5;
        this.zzt = z7;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        return Objects.equal(this.zza, connectionConfiguration.zza) && Objects.equal(this.zzb, connectionConfiguration.zzb) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(connectionConfiguration.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(connectionConfiguration.zzd)) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(connectionConfiguration.zze)) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(connectionConfiguration.zzh)) && Objects.equal(Boolean.valueOf(this.zzm), Boolean.valueOf(connectionConfiguration.zzm)) && Objects.equal(Boolean.valueOf(this.zzn), Boolean.valueOf(connectionConfiguration.zzn));
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Boolean.valueOf(this.zze), Boolean.valueOf(this.zzh), Boolean.valueOf(this.zzm), Boolean.valueOf(this.zzn));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConnectionConfiguration[ Name=");
        sb.append(this.zza);
        sb.append(", Address=");
        String str = this.zzb;
        String strConcat = "{invalid address}";
        if (str != null && str.length() == 17) {
            strConcat = "XX:XX:XX:XX:".concat(str.substring(12));
        }
        sb.append(strConcat);
        sb.append(", Type=");
        sb.append(this.zzc);
        sb.append(", Role=");
        sb.append(this.zzd);
        sb.append(", Enabled=");
        sb.append(this.zze);
        sb.append(", IsConnected=");
        sb.append(this.zzf);
        sb.append(", PeerNodeId=");
        sb.append(this.zzg);
        sb.append(", BtlePriority=");
        sb.append(this.zzh);
        sb.append(", NodeId=");
        sb.append(this.zzi);
        sb.append(", PackageName=");
        sb.append(this.zzj);
        sb.append(", ConnectionRetryStrategy=");
        sb.append(this.zzk);
        sb.append(", allowedConfigPackages=");
        sb.append(this.zzl);
        sb.append(", Migrating=");
        sb.append(this.zzm);
        sb.append(", DataItemSyncEnabled=");
        sb.append(this.zzn);
        sb.append(", ConnectionRestrictions=");
        sb.append(this.zzo);
        sb.append(", removeConnectionWhenBondRemovedByUser=");
        sb.append(this.zzp);
        sb.append(", maxSupportedRemoteAndroidSdkVersion=");
        sb.append(this.zzr);
        sb.append(", runtimeType=");
        sb.append(this.zzs);
        sb.append(", skipConnectingIfDeviceNotBonded=");
        sb.append(this.zzt);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, str, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeInt(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzf);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeString(parcel, 10, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzj, false);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeStringList(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzn);
        SafeParcelWriter.writeParcelable(parcel, 16, this.zzo, i, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzp);
        SafeParcelWriter.writeParcelable(parcel, 18, this.zzq, i, false);
        SafeParcelWriter.writeInt(parcel, 19, this.zzr);
        SafeParcelWriter.writeInt(parcel, 20, this.zzs);
        SafeParcelWriter.writeBoolean(parcel, 21, this.zzt);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
