package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class zzje extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzje> CREATOR = new zzjf();
    private final zzjm zza;
    private final zzjc zzb;
    private final byte[] zzc;
    private final boolean zzd;
    private final List zze;
    private final List zzf;
    private final List zzg;
    private final zzjo zzh;
    private final zzjg zzi;

    public zzje(zzjm zzjmVar, zzjc zzjcVar, byte[] bArr, boolean z, List list, List list2, List list3, zzjo zzjoVar, zzjg zzjgVar) {
        this.zza = zzjmVar;
        this.zzb = zzjcVar;
        this.zzc = bArr;
        this.zzd = z;
        this.zze = list;
        this.zzf = list2;
        this.zzg = list3;
        this.zzh = zzjoVar;
        this.zzi = zzjgVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzje) {
            zzje zzjeVar = (zzje) obj;
            if (Objects.equal(this.zza, zzjeVar.zza) && Objects.equal(this.zzb, zzjeVar.zzb) && Arrays.equals(this.zzc, zzjeVar.zzc) && this.zzd == zzjeVar.zzd && Objects.equal(this.zze, zzjeVar.zze) && Objects.equal(this.zzf, zzjeVar.zzf) && Objects.equal(this.zzg, zzjeVar.zzg) && Objects.equal(this.zzh, zzjeVar.zzh) && Objects.equal(this.zzi, zzjeVar.zzi)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Boolean.valueOf(this.zzd), this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
    }

    public final String toString() {
        return String.format(Locale.US, "<DataElementCollection: sequenceNumber=%s, castId=%s, deduplicationHint=%s, deduplicationHintEnabled=%s, bleGattConnectivityInfo = %s, wifiLanConnectivityInfoList = %s, bluetoothConnectivityInfoList = %s, connectivityCapability = %s, deviceType = %s>", this.zza, this.zzb, Arrays.toString(this.zzc), Boolean.valueOf(this.zzd), this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzjm zzjmVar = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, zzjmVar, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeTypedList(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
