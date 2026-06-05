package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzby;
import com.google.android.gms.internal.fitness.zzbz;

/* JADX INFO: loaded from: classes3.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new zzai();
    private final DataSource zza;
    private final DataType zzb;
    private final com.google.android.gms.fitness.data.zzt zzc;
    private final long zzd;
    private final long zze;
    private final PendingIntent zzf;
    private final long zzg;
    private final int zzh;
    private final long zzi;
    private final zzbz zzj;

    public zzah(DataSource dataSource, DataType dataType, IBinder iBinder, long j, long j2, PendingIntent pendingIntent, long j3, int i, long j4, IBinder iBinder2) {
        this.zza = dataSource;
        this.zzb = dataType;
        this.zzc = iBinder == null ? null : com.google.android.gms.fitness.data.zzs.zzb(iBinder);
        this.zzd = j;
        this.zzg = j3;
        this.zze = j2;
        this.zzf = pendingIntent;
        this.zzh = i;
        this.zzi = j4;
        this.zzj = iBinder2 != null ? zzby.zzc(iBinder2) : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzahVar = (zzah) obj;
        return Objects.equal(this.zza, zzahVar.zza) && Objects.equal(this.zzb, zzahVar.zzb) && Objects.equal(this.zzc, zzahVar.zzc) && this.zzd == zzahVar.zzd && this.zzg == zzahVar.zzg && this.zze == zzahVar.zze && this.zzh == zzahVar.zzh;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Long.valueOf(this.zzd), Long.valueOf(this.zzg), Long.valueOf(this.zze), Integer.valueOf(this.zzh));
    }

    public final String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", this.zzb, this.zza, Long.valueOf(this.zzd), Long.valueOf(this.zzg), Long.valueOf(this.zze));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        com.google.android.gms.fitness.data.zzt zztVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, zztVar == null ? null : zztVar.asBinder(), false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzd);
        SafeParcelWriter.writeLong(parcel, 7, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzf, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzg);
        SafeParcelWriter.writeInt(parcel, 10, this.zzh);
        SafeParcelWriter.writeLong(parcel, 12, this.zzi);
        zzbz zzbzVar = this.zzj;
        SafeParcelWriter.writeIBinder(parcel, 13, zzbzVar != null ? zzbzVar.asBinder() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
