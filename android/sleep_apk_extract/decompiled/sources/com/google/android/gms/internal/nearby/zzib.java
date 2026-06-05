package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzib extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzib> CREATOR = new zzic();
    private zzfv zza;
    private zzey zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private AdvertisingOptions zzf;
    private zzfe zzg;
    private byte[] zzh;

    public zzib(IBinder iBinder, IBinder iBinder2, String str, String str2, long j, AdvertisingOptions advertisingOptions, IBinder iBinder3, byte[] bArr) {
        zzfv zzftVar;
        zzey zzewVar;
        zzfe zzfcVar = null;
        if (iBinder == null) {
            zzftVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
            zzftVar = iInterfaceQueryLocalInterface instanceof zzfv ? (zzfv) iInterfaceQueryLocalInterface : new zzft(iBinder);
        }
        if (iBinder2 == null) {
            zzewVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
            zzewVar = iInterfaceQueryLocalInterface2 instanceof zzey ? (zzey) iInterfaceQueryLocalInterface2 : new zzew(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzfcVar = iInterfaceQueryLocalInterface3 instanceof zzfe ? (zzfe) iInterfaceQueryLocalInterface3 : new zzfc(iBinder3);
        }
        this.zza = zzftVar;
        this.zzb = zzewVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = j;
        this.zzf = advertisingOptions;
        this.zzg = zzfcVar;
        this.zzh = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzib) {
            zzib zzibVar = (zzib) obj;
            if (Objects.equal(this.zza, zzibVar.zza) && Objects.equal(this.zzb, zzibVar.zzb) && Objects.equal(this.zzc, zzibVar.zzc) && Objects.equal(this.zzd, zzibVar.zzd) && Objects.equal(Long.valueOf(this.zze), Long.valueOf(zzibVar.zze)) && Objects.equal(this.zzf, zzibVar.zzf) && Objects.equal(this.zzg, zzibVar.zzg) && Arrays.equals(this.zzh, zzibVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Long.valueOf(this.zze), this.zzf, this.zzg, Integer.valueOf(Arrays.hashCode(this.zzh)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzfv zzfvVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzfvVar == null ? null : zzfvVar.asBinder(), false);
        zzey zzeyVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzeyVar == null ? null : zzeyVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        zzfe zzfeVar = this.zzg;
        SafeParcelWriter.writeIBinder(parcel, 7, zzfeVar != null ? zzfeVar.asBinder() : null, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public /* synthetic */ zzib(zzia zziaVar) {
    }
}
