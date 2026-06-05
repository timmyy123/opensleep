package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionOptions> CREATOR = new zzn();
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private byte[] zzi;
    private boolean zzj;
    private boolean zzk;

    @Deprecated
    private boolean zzl;
    private int zzm;
    private int zzn;
    private int[] zzo;
    private int[] zzp;
    private byte[] zzq;
    private Strategy zzr;
    private int zzs;
    private long zzt;

    @Deprecated
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;

    public ConnectionOptions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, byte[] bArr, boolean z9, boolean z10, boolean z11, int i, int i2, int[] iArr, int[] iArr2, byte[] bArr2, Strategy strategy, int i3, long j, boolean z12, boolean z13, boolean z14) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = z4;
        this.zze = z5;
        this.zzf = z6;
        this.zzg = z7;
        this.zzh = z8;
        this.zzi = bArr;
        this.zzj = z9;
        this.zzk = z10;
        this.zzl = z11;
        this.zzm = i;
        this.zzn = i2;
        this.zzo = iArr;
        this.zzp = iArr2;
        this.zzq = bArr2;
        this.zzr = strategy;
        this.zzs = i3;
        this.zzt = j;
        this.zzu = z12;
        this.zzv = z13;
        this.zzw = z14;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConnectionOptions) {
            ConnectionOptions connectionOptions = (ConnectionOptions) obj;
            if (Objects.equal(Boolean.valueOf(this.zza), Boolean.valueOf(connectionOptions.zza)) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(connectionOptions.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(connectionOptions.zzc)) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(connectionOptions.zzd)) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(connectionOptions.zze)) && Objects.equal(Boolean.valueOf(this.zzf), Boolean.valueOf(connectionOptions.zzf)) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(connectionOptions.zzg)) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(connectionOptions.zzh)) && Arrays.equals(this.zzi, connectionOptions.zzi) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(connectionOptions.zzj)) && Objects.equal(Boolean.valueOf(this.zzk), Boolean.valueOf(connectionOptions.zzk)) && Objects.equal(Boolean.valueOf(this.zzl), Boolean.valueOf(connectionOptions.zzl)) && Objects.equal(Integer.valueOf(this.zzm), Integer.valueOf(connectionOptions.zzm)) && Objects.equal(Integer.valueOf(this.zzn), Integer.valueOf(connectionOptions.zzn)) && Arrays.equals(this.zzo, connectionOptions.zzo) && Arrays.equals(this.zzp, connectionOptions.zzp) && Arrays.equals(this.zzq, connectionOptions.zzq) && Objects.equal(this.zzr, connectionOptions.zzr) && Objects.equal(Integer.valueOf(this.zzs), Integer.valueOf(connectionOptions.zzs)) && Objects.equal(Long.valueOf(this.zzt), Long.valueOf(connectionOptions.zzt)) && Objects.equal(Boolean.valueOf(this.zzu), Boolean.valueOf(connectionOptions.zzu)) && Objects.equal(Boolean.valueOf(this.zzv), Boolean.valueOf(connectionOptions.zzv)) && Objects.equal(Boolean.valueOf(this.zzw), Boolean.valueOf(connectionOptions.zzw))) {
                return true;
            }
        }
        return false;
    }

    public int getConnectionType() {
        return this.zzs;
    }

    @Deprecated
    public boolean getDisruptiveUpgrade() {
        return this.zzl;
    }

    public boolean getLowPower() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), Boolean.valueOf(this.zzf), Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Integer.valueOf(Arrays.hashCode(this.zzi)), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzl), Integer.valueOf(this.zzm), Integer.valueOf(this.zzn), Integer.valueOf(Arrays.hashCode(this.zzo)), Integer.valueOf(Arrays.hashCode(this.zzp)), Integer.valueOf(Arrays.hashCode(this.zzq)), this.zzr, Integer.valueOf(this.zzs), Long.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
    }

    public String toString() {
        Locale locale = Locale.US;
        boolean z = this.zza;
        boolean z2 = this.zzb;
        boolean z3 = this.zzc;
        boolean z4 = this.zzd;
        boolean z5 = this.zze;
        boolean z6 = this.zzf;
        boolean z7 = this.zzg;
        boolean z8 = this.zzh;
        byte[] bArr = this.zzi;
        String strZzb = bArr == null ? null : com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr);
        boolean z9 = this.zzj;
        boolean z10 = this.zzk;
        boolean z11 = this.zzl;
        byte[] bArr2 = this.zzq;
        return "ConnectionOptions{lowPower: " + z + ", enableBluetooth: " + z2 + ", enableBle: " + z3 + ", enableWifiLan: " + z4 + ", enableNfc: " + z5 + ", enableWifiAware: " + z6 + ", enableWifiHotspot: " + z7 + ", enableWifiDirect: " + z8 + ", remoteBluetoothMacAddress: " + strZzb + ", enableWebRtc: " + z9 + ", enforceTopologyConstraints: " + z10 + ", disruptiveUpgrade: " + z11 + ",deviceInfo: " + (bArr2 != null ? com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr2) : null) + ",strategy: " + this.zzr + ",connectionType: " + this.zzs + "flowId: " + this.zzt + ", }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getLowPower());
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeByteArray(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 12, getDisruptiveUpgrade());
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeInt(parcel, 14, this.zzn);
        SafeParcelWriter.writeIntArray(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeIntArray(parcel, 16, this.zzp, false);
        SafeParcelWriter.writeByteArray(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeParcelable(parcel, 18, this.zzr, i, false);
        SafeParcelWriter.writeInt(parcel, 19, getConnectionType());
        SafeParcelWriter.writeLong(parcel, 20, this.zzt);
        SafeParcelWriter.writeBoolean(parcel, 21, this.zzu);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzv);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzw);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
