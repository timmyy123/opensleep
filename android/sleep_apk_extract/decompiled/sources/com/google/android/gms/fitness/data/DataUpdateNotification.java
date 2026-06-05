package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes3.dex */
public class DataUpdateNotification extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataUpdateNotification> CREATOR = new zzk();
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final DataSource zzd;
    private final DataType zze;

    public DataUpdateNotification(long j, long j2, int i, DataSource dataSource, DataType dataType) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = i;
        this.zzd = dataSource;
        this.zze = dataType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataUpdateNotification)) {
            return false;
        }
        DataUpdateNotification dataUpdateNotification = (DataUpdateNotification) obj;
        return this.zza == dataUpdateNotification.zza && this.zzb == dataUpdateNotification.zzb && this.zzc == dataUpdateNotification.zzc && Objects.equal(this.zzd, dataUpdateNotification.zzd) && Objects.equal(this.zze, dataUpdateNotification.zze);
    }

    public DataSource getDataSource() {
        return this.zzd;
    }

    public DataType getDataType() {
        return this.zze;
    }

    public int getOperationType() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("updateStartTimeNanos", Long.valueOf(this.zza)).add("updateEndTimeNanos", Long.valueOf(this.zzb)).add("operationType", Integer.valueOf(this.zzc)).add("dataSource", this.zzd).add("dataType", this.zze).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        long j = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, j);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, getOperationType());
        SafeParcelWriter.writeParcelable(parcel, 4, getDataSource(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, getDataType(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
