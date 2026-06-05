package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class DiscoveryOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DiscoveryOptions> CREATOR = new zzv();
    private Strategy zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private ParcelUuid zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private int zzl;
    private byte[] zzm;
    private long zzn;
    private int[] zzo;
    private boolean zzp;

    @Deprecated
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;

    public static final class Builder {
        private final DiscoveryOptions zza = new DiscoveryOptions(null);

        public DiscoveryOptions build() {
            int[] iArr = this.zza.zzo;
            if (iArr != null && iArr.length > 0) {
                this.zza.zzd = false;
                this.zza.zzc = false;
                this.zza.zzh = false;
                this.zza.zzi = false;
                this.zza.zzg = false;
                for (int i : iArr) {
                    if (i == 2) {
                        this.zza.zzc = true;
                    } else if (i != 11) {
                        if (i == 4) {
                            this.zza.zzd = true;
                        } else if (i == 5) {
                            this.zza.zzg = true;
                        } else if (i == 6) {
                            this.zza.zzi = true;
                        } else if (i != 7) {
                            Log.d("NearbyConnections", "Illegal discovery medium " + i);
                        } else {
                            this.zza.zzh = true;
                        }
                    }
                }
            }
            return this.zza;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zza.zza = strategy;
            return this;
        }
    }

    public DiscoveryOptions(Strategy strategy, boolean z, boolean z2, boolean z3, boolean z4, ParcelUuid parcelUuid, boolean z5, boolean z6, boolean z7, boolean z8, int i, int i2, byte[] bArr, long j, int[] iArr, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.zza = strategy;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = parcelUuid;
        this.zzg = z5;
        this.zzh = z6;
        this.zzi = z7;
        this.zzj = z8;
        this.zzk = i;
        this.zzl = i2;
        this.zzm = bArr;
        this.zzn = j;
        this.zzo = iArr;
        this.zzp = z9;
        this.zzq = z10;
        this.zzr = z11;
        this.zzs = z12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscoveryOptions) {
            DiscoveryOptions discoveryOptions = (DiscoveryOptions) obj;
            if (Objects.equal(this.zza, discoveryOptions.zza) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(discoveryOptions.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(discoveryOptions.zzc)) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(discoveryOptions.zzd)) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(discoveryOptions.zze)) && Objects.equal(this.zzf, discoveryOptions.zzf) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(discoveryOptions.zzg)) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(discoveryOptions.zzh)) && Objects.equal(Boolean.valueOf(this.zzi), Boolean.valueOf(discoveryOptions.zzi)) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(discoveryOptions.zzj)) && Objects.equal(Integer.valueOf(this.zzk), Integer.valueOf(discoveryOptions.zzk)) && Objects.equal(Integer.valueOf(this.zzl), Integer.valueOf(discoveryOptions.zzl)) && Arrays.equals(this.zzm, discoveryOptions.zzm) && Objects.equal(Long.valueOf(this.zzn), Long.valueOf(discoveryOptions.zzn)) && Arrays.equals(this.zzo, discoveryOptions.zzo) && Objects.equal(Boolean.valueOf(this.zzp), Boolean.valueOf(discoveryOptions.zzp)) && Objects.equal(Boolean.valueOf(this.zzq), Boolean.valueOf(discoveryOptions.zzq)) && Objects.equal(Boolean.valueOf(this.zzr), Boolean.valueOf(discoveryOptions.zzr)) && Objects.equal(Boolean.valueOf(this.zzs), Boolean.valueOf(discoveryOptions.zzs))) {
                return true;
            }
        }
        return false;
    }

    public boolean getLowPower() {
        return this.zze;
    }

    public Strategy getStrategy() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf, Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(Arrays.hashCode(this.zzm)), Long.valueOf(this.zzn), Integer.valueOf(Arrays.hashCode(this.zzo)), Boolean.valueOf(this.zzp), Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs));
    }

    public String toString() {
        Locale locale = Locale.US;
        Strategy strategy = this.zza;
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        boolean z3 = this.zzd;
        boolean z4 = this.zze;
        ParcelUuid parcelUuid = this.zzf;
        boolean z5 = this.zzg;
        boolean z6 = this.zzh;
        boolean z7 = this.zzi;
        boolean z8 = this.zzj;
        int i = this.zzk;
        int i2 = this.zzl;
        byte[] bArr = this.zzm;
        String strZzb = bArr == null ? "null" : com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr);
        long j = this.zzn;
        boolean z9 = this.zzp;
        StringBuilder sb = new StringBuilder("DiscoveryOptions{strategy: ");
        sb.append(strategy);
        sb.append(", forwardUnrecognizedBluetoothDevices: ");
        sb.append(z);
        sb.append(", enableBluetooth: ");
        sb.append(z2);
        sb.append(", enableBle: ");
        sb.append(z3);
        sb.append(", lowPower: ");
        sb.append(z4);
        sb.append(", fastAdvertisementServiceUuid: ");
        sb.append(parcelUuid);
        sb.append(", enableWifiLan: ");
        sb.append(z5);
        sb.append(", enableNfc: ");
        sb.append(z6);
        sb.append(", enableWifiAware: ");
        sb.append(z7);
        sb.append(", enableUwbRanging: ");
        sb.append(z8);
        sb.append(", uwbChannel: ");
        Fragment$$ExternalSyntheticOutline1.m(sb, i, ", uwbPreambleIndex: ", i2, ", uwbAddress: ");
        sb.append(strZzb);
        sb.append(", flowId: ");
        sb.append(j);
        sb.append(", allowGattConnections: ");
        sb.append(z9);
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
        SafeParcelWriter.writeBoolean(parcel, 5, getLowPower());
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeInt(parcel, 13, this.zzl);
        SafeParcelWriter.writeByteArray(parcel, 14, this.zzm, false);
        SafeParcelWriter.writeLong(parcel, 15, this.zzn);
        SafeParcelWriter.writeIntArray(parcel, 16, this.zzo, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzp);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzq);
        SafeParcelWriter.writeBoolean(parcel, 19, this.zzr);
        SafeParcelWriter.writeBoolean(parcel, 20, this.zzs);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final boolean zzK() {
        return this.zzh;
    }

    public /* synthetic */ DiscoveryOptions(zzu zzuVar) {
        this.zzb = false;
        this.zzc = true;
        this.zzd = true;
        this.zze = false;
        this.zzg = true;
        this.zzh = true;
        this.zzi = true;
        this.zzj = false;
        this.zzk = 0;
        this.zzl = 0;
        this.zzn = 0L;
        this.zzp = true;
        this.zzq = false;
        this.zzr = true;
        this.zzs = true;
    }
}
