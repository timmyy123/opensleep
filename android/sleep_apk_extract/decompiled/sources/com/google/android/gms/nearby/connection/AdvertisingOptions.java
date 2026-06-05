package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class AdvertisingOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdvertisingOptions> CREATOR = new zzb();
    private int zzA;
    private byte[] zzB;
    private boolean zzC;
    private int zzD;

    @Deprecated
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private Strategy zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private byte[] zzf;
    private boolean zzg;
    private ParcelUuid zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private int zzp;
    private byte[] zzq;
    private long zzr;
    private zzac[] zzs;
    private boolean zzt;

    @Deprecated
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private int[] zzx;
    private int[] zzy;
    private boolean zzz;

    public static final class Builder {
        private final AdvertisingOptions zza = new AdvertisingOptions(null);

        public AdvertisingOptions build() {
            int[] iArr = this.zza.zzx;
            if (iArr != null && iArr.length > 0) {
                this.zza.zze = false;
                this.zza.zzd = false;
                this.zza.zzj = false;
                this.zza.zzk = false;
                this.zza.zzi = false;
                this.zza.zzm = false;
                for (int i : iArr) {
                    if (i == 2) {
                        this.zza.zzd = true;
                    } else if (i == 9) {
                        this.zza.zzm = true;
                    } else if (i != 11) {
                        if (i == 4) {
                            this.zza.zze = true;
                        } else if (i == 5) {
                            this.zza.zzi = true;
                        } else if (i == 6) {
                            this.zza.zzk = true;
                        } else if (i != 7) {
                            Log.d("NearbyConnections", "Illegal advertising medium " + i);
                        } else {
                            this.zza.zzj = true;
                        }
                    }
                }
            }
            if (this.zza.zzy != null && this.zza.zzy.length > 0) {
                this.zza.zzv = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.zza.zzy.length) {
                        break;
                    }
                    if (this.zza.zzy[i2] == 9) {
                        this.zza.zzv = true;
                        break;
                    }
                    i2++;
                }
            }
            int i3 = this.zza.zzA;
            AdvertisingOptions advertisingOptions = this.zza;
            if (i3 == 0) {
                advertisingOptions.zzA = true == advertisingOptions.zzg ? 1 : 3;
            } else {
                advertisingOptions.zzg = advertisingOptions.zzA != 3;
            }
            int i4 = this.zza.zzD;
            AdvertisingOptions advertisingOptions2 = this.zza;
            if (i4 != 0) {
                advertisingOptions2.zzu = advertisingOptions2.zzD == 1;
            } else if (!advertisingOptions2.zzu) {
                this.zza.zzD = 2;
            }
            return this.zza;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zza.zza = strategy;
            return this;
        }
    }

    public AdvertisingOptions(Strategy strategy, boolean z, boolean z2, boolean z3, boolean z4, byte[] bArr, boolean z5, ParcelUuid parcelUuid, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i, int i2, byte[] bArr2, long j, zzac[] zzacVarArr, boolean z12, boolean z13, boolean z14, boolean z15, int[] iArr, int[] iArr2, boolean z16, int i3, byte[] bArr3, boolean z17, int i4, boolean z18, boolean z19, boolean z20, boolean z21) {
        this.zza = strategy;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = bArr;
        this.zzg = z5;
        this.zzh = parcelUuid;
        this.zzi = z6;
        this.zzj = z7;
        this.zzk = z8;
        this.zzl = z9;
        this.zzm = z10;
        this.zzn = z11;
        this.zzo = i;
        this.zzp = i2;
        this.zzq = bArr2;
        this.zzr = j;
        this.zzs = zzacVarArr;
        this.zzt = z12;
        this.zzu = z13;
        this.zzv = z14;
        this.zzw = z15;
        this.zzx = iArr;
        this.zzy = iArr2;
        this.zzz = z16;
        this.zzA = i3;
        this.zzB = bArr3;
        this.zzC = z17;
        this.zzD = i4;
        this.zzE = z18;
        this.zzF = z19;
        this.zzG = z20;
        this.zzH = z21;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdvertisingOptions) {
            AdvertisingOptions advertisingOptions = (AdvertisingOptions) obj;
            if (Objects.equal(this.zza, advertisingOptions.zza) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(advertisingOptions.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(advertisingOptions.zzc)) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(advertisingOptions.zzd)) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(advertisingOptions.zze)) && Arrays.equals(this.zzf, advertisingOptions.zzf) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(advertisingOptions.zzg)) && Objects.equal(this.zzh, advertisingOptions.zzh) && Objects.equal(Boolean.valueOf(this.zzi), Boolean.valueOf(advertisingOptions.zzi)) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(advertisingOptions.zzj)) && Objects.equal(Boolean.valueOf(this.zzk), Boolean.valueOf(advertisingOptions.zzk)) && Objects.equal(Boolean.valueOf(this.zzl), Boolean.valueOf(advertisingOptions.zzl)) && Objects.equal(Boolean.valueOf(this.zzm), Boolean.valueOf(advertisingOptions.zzm)) && Objects.equal(Boolean.valueOf(this.zzn), Boolean.valueOf(advertisingOptions.zzn)) && Objects.equal(Integer.valueOf(this.zzo), Integer.valueOf(advertisingOptions.zzo)) && Objects.equal(Integer.valueOf(this.zzp), Integer.valueOf(advertisingOptions.zzp)) && Arrays.equals(this.zzq, advertisingOptions.zzq) && Objects.equal(Long.valueOf(this.zzr), Long.valueOf(advertisingOptions.zzr)) && Arrays.equals(this.zzs, advertisingOptions.zzs) && Objects.equal(Boolean.valueOf(this.zzt), Boolean.valueOf(advertisingOptions.zzt)) && Objects.equal(Boolean.valueOf(this.zzu), Boolean.valueOf(advertisingOptions.zzu)) && Objects.equal(Boolean.valueOf(this.zzv), Boolean.valueOf(advertisingOptions.zzv)) && Objects.equal(Boolean.valueOf(this.zzw), Boolean.valueOf(advertisingOptions.zzw)) && Arrays.equals(this.zzx, advertisingOptions.zzx) && Arrays.equals(this.zzy, advertisingOptions.zzy) && Objects.equal(Boolean.valueOf(this.zzz), Boolean.valueOf(advertisingOptions.zzz)) && Objects.equal(Integer.valueOf(this.zzA), Integer.valueOf(advertisingOptions.zzA)) && Arrays.equals(this.zzB, advertisingOptions.zzB) && Objects.equal(Boolean.valueOf(this.zzC), Boolean.valueOf(advertisingOptions.zzC)) && Objects.equal(Integer.valueOf(this.zzD), Integer.valueOf(advertisingOptions.zzD)) && Objects.equal(Boolean.valueOf(this.zzE), Boolean.valueOf(advertisingOptions.zzE)) && Objects.equal(Boolean.valueOf(this.zzF), Boolean.valueOf(advertisingOptions.zzF)) && Objects.equal(Boolean.valueOf(this.zzG), Boolean.valueOf(advertisingOptions.zzG)) && Objects.equal(Boolean.valueOf(this.zzH), Boolean.valueOf(advertisingOptions.zzH))) {
                return true;
            }
        }
        return false;
    }

    public int getConnectionType() {
        return this.zzD;
    }

    @Deprecated
    public boolean getDisruptiveUpgrade() {
        return this.zzu;
    }

    public boolean getLowPower() {
        return this.zzg;
    }

    public Strategy getStrategy() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Boolean.valueOf(this.zzg), this.zzh, Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzl), Boolean.valueOf(this.zzm), Boolean.valueOf(this.zzn), Integer.valueOf(this.zzo), Integer.valueOf(this.zzp), Integer.valueOf(Arrays.hashCode(this.zzq)), Long.valueOf(this.zzr), Integer.valueOf(Arrays.hashCode(this.zzs)), Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw), Integer.valueOf(Arrays.hashCode(this.zzx)), Integer.valueOf(Arrays.hashCode(this.zzy)), Boolean.valueOf(this.zzz), Integer.valueOf(this.zzA), Integer.valueOf(Arrays.hashCode(this.zzB)), Boolean.valueOf(this.zzC), Integer.valueOf(this.zzD), Boolean.valueOf(this.zzE), Boolean.valueOf(this.zzF), Boolean.valueOf(this.zzG), Boolean.valueOf(this.zzH));
    }

    public String toString() {
        Locale locale = Locale.US;
        Strategy strategy = this.zza;
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        boolean z3 = this.zzd;
        boolean z4 = this.zze;
        byte[] bArr = this.zzf;
        String strZzb = bArr == null ? null : com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr);
        boolean z5 = this.zzg;
        ParcelUuid parcelUuid = this.zzh;
        boolean z6 = this.zzi;
        boolean z7 = this.zzj;
        boolean z8 = this.zzk;
        boolean z9 = this.zzl;
        boolean z10 = this.zzm;
        boolean z11 = this.zzn;
        int i = this.zzo;
        int i2 = this.zzp;
        byte[] bArr2 = this.zzq;
        String strZzb2 = bArr2 == null ? "null" : com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr2);
        long j = this.zzr;
        String string = Arrays.toString(this.zzs);
        boolean z12 = this.zzt;
        boolean z13 = this.zzu;
        boolean z14 = this.zzw;
        byte[] bArr3 = this.zzB;
        String strZzb3 = bArr3 == null ? null : com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr3);
        boolean z15 = this.zzC;
        int i3 = this.zzD;
        boolean z16 = this.zzH;
        StringBuilder sb = new StringBuilder("AdvertisingOptions{strategy: ");
        sb.append(strategy);
        sb.append(", autoUpgradeBandwidth: ");
        sb.append(z);
        sb.append(", enforceTopologyConstraints: ");
        sb.append(z2);
        sb.append(", enableBluetooth: ");
        sb.append(z3);
        sb.append(", enableBle: ");
        sb.append(z4);
        sb.append(", nearbyNotificationsBeaconData: ");
        sb.append(strZzb);
        sb.append(", lowPower: ");
        sb.append(z5);
        sb.append(", fastAdvertisementServiceUuid: ");
        sb.append(parcelUuid);
        sb.append(", enableWifiLan: ");
        sb.append(z6);
        sb.append(", enableNfc: ");
        sb.append(z7);
        sb.append(", enableWifiAware: ");
        sb.append(z8);
        sb.append(", enableBluetoothListening: ");
        sb.append(z9);
        sb.append(", enableWebRtcListening: ");
        sb.append(z10);
        sb.append(", enableUwbRanging: ");
        sb.append(z11);
        sb.append(", uwbChannel: ");
        Fragment$$ExternalSyntheticOutline1.m(sb, i, ", uwbPreambleIndex: ", i2, ", remoteUwbAddress: ");
        sb.append(strZzb2);
        sb.append(", flowId: ");
        sb.append(j);
        sb.append(", uwbSenderInfo: ");
        sb.append(string);
        sb.append(", enableOutOfBandConnection: ");
        sb.append(z12);
        zza$$ExternalSyntheticOutline0.m(sb, ", disruptiveUpgrade: ", z13, ", useStableIdentifiers: ", z14);
        sb.append(", deviceInfo: ");
        sb.append(strZzb3);
        sb.append(",allowGattConnections: ");
        sb.append(z15);
        sb.append(", connectionType: ");
        sb.append(i3);
        sb.append(", enableBleL2capListening: ");
        sb.append(z16);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStrategy(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 7, getLowPower());
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzl);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzn);
        SafeParcelWriter.writeInt(parcel, 15, this.zzo);
        SafeParcelWriter.writeInt(parcel, 16, this.zzp);
        SafeParcelWriter.writeByteArray(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeLong(parcel, 18, this.zzr);
        SafeParcelWriter.writeTypedArray(parcel, 19, this.zzs, i, false);
        SafeParcelWriter.writeBoolean(parcel, 20, this.zzt);
        SafeParcelWriter.writeBoolean(parcel, 21, getDisruptiveUpgrade());
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzv);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzw);
        SafeParcelWriter.writeIntArray(parcel, 24, this.zzx, false);
        SafeParcelWriter.writeIntArray(parcel, 25, this.zzy, false);
        SafeParcelWriter.writeBoolean(parcel, 26, this.zzz);
        SafeParcelWriter.writeInt(parcel, 27, this.zzA);
        SafeParcelWriter.writeByteArray(parcel, 28, this.zzB, false);
        SafeParcelWriter.writeBoolean(parcel, 29, this.zzC);
        SafeParcelWriter.writeInt(parcel, 30, getConnectionType());
        SafeParcelWriter.writeBoolean(parcel, 31, this.zzE);
        SafeParcelWriter.writeBoolean(parcel, 32, this.zzF);
        SafeParcelWriter.writeBoolean(parcel, 33, this.zzG);
        SafeParcelWriter.writeBoolean(parcel, 34, this.zzH);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public /* synthetic */ AdvertisingOptions(zza zzaVar) {
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzg = false;
        this.zzi = true;
        this.zzj = true;
        this.zzk = true;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = 0;
        this.zzp = 0;
        this.zzr = 0L;
        this.zzt = false;
        this.zzu = true;
        this.zzv = false;
        this.zzw = true;
        this.zzz = true;
        this.zzA = 0;
        this.zzC = true;
        this.zzD = 0;
        this.zzE = false;
        this.zzF = true;
        this.zzG = true;
        this.zzH = true;
    }
}
