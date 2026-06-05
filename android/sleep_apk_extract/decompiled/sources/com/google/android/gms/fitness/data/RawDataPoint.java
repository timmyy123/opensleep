package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class RawDataPoint extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzy();
    private final long zza;
    private final long zzb;
    private final Value[] zzc;
    private final int zzd;
    private final int zze;
    private final long zzf;

    public RawDataPoint(DataPoint dataPoint, List list) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        this.zza = dataPoint.getTimestamp(timeUnit);
        this.zzb = dataPoint.getStartTime(timeUnit);
        this.zzc = dataPoint.zzb();
        this.zzd = com.google.android.gms.internal.fitness.zzd.zza(dataPoint.getDataSource(), list);
        this.zze = com.google.android.gms.internal.fitness.zzd.zza(dataPoint.zzc(), list);
        this.zzf = dataPoint.zzd();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawDataPoint)) {
            return false;
        }
        RawDataPoint rawDataPoint = (RawDataPoint) obj;
        return this.zza == rawDataPoint.zza && this.zzb == rawDataPoint.zzb && Arrays.equals(this.zzc, rawDataPoint.zzc) && this.zzd == rawDataPoint.zzd && this.zze == rawDataPoint.zze && this.zzf == rawDataPoint.zzf;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb));
    }

    public final String toString() {
        Locale locale = Locale.US;
        String string = Arrays.toString(this.zzc);
        long j = this.zzb;
        long j2 = this.zza;
        int i = this.zzd;
        int i2 = this.zze;
        StringBuilder sb = new StringBuilder("RawDataPoint{");
        sb.append(string);
        sb.append("@[");
        sb.append(j);
        zzba$$ExternalSyntheticOutline0.m(sb, ", ", j2, "](");
        sb.append(i);
        sb.append(",");
        sb.append(i2);
        sb.append(")}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeLong(parcel, 6, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final long zza() {
        return this.zza;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final Value[] zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final int zze() {
        return this.zze;
    }

    public final long zzf() {
        return this.zzf;
    }

    public RawDataPoint(long j, long j2, Value[] valueArr, int i, int i2, long j3) {
        this.zza = j;
        this.zzb = j2;
        this.zzd = i;
        this.zze = i2;
        this.zzf = j3;
        this.zzc = valueArr;
    }
}
