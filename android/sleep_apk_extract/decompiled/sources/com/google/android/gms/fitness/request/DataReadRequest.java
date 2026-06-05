package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DataReadRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataReadRequest> CREATOR = new zzl();
    private final List zza;
    private final List zzb;
    private final long zzc;
    private final long zzd;
    private final List zze;
    private final List zzf;
    private final int zzg;
    private final long zzh;
    private final DataSource zzi;
    private final int zzj;
    private final boolean zzk;
    private final boolean zzl;
    private final com.google.android.gms.internal.fitness.zzaw zzm;
    private final List zzn;
    private final List zzo;

    public static class Builder {
        private DataSource zze;
        private long zzf;
        private long zzg;
        private final List zza = new ArrayList();
        private final List zzb = new ArrayList();
        private final List zzc = new ArrayList();
        private final List zzd = new ArrayList();
        private final List zzh = new ArrayList();
        private final List zzi = new ArrayList();
        private int zzj = 0;
        private long zzk = 0;
        private int zzl = 0;
        private boolean zzm = false;

        public Builder bucketByTime(int i, TimeUnit timeUnit) {
            int i2 = this.zzj;
            Preconditions.checkArgument(i2 == 0, "Bucketing strategy already set to %s", Integer.valueOf(i2));
            Preconditions.checkArgument(i > 0, "Must specify a valid minimum duration: %d", Integer.valueOf(i));
            this.zzj = 1;
            this.zzk = timeUnit.toMillis(i);
            return this;
        }

        public DataReadRequest build() {
            List list = this.zzb;
            Preconditions.checkState((list.isEmpty() && this.zza.isEmpty() && this.zzd.isEmpty() && this.zzc.isEmpty()) ? false : true, "Must add at least one data source (aggregated or detailed)");
            long j = this.zzf;
            Preconditions.checkState(j > 0, "Invalid start time: %s", Long.valueOf(j));
            long j2 = this.zzg;
            Preconditions.checkState(j2 > 0 && j2 > this.zzf, "Invalid end time: %s", Long.valueOf(j2));
            List list2 = this.zzd;
            boolean z = list2.isEmpty() && this.zzc.isEmpty();
            if (this.zzj == 0) {
                Preconditions.checkState(z, "Must specify a valid bucketing strategy while requesting aggregation");
            }
            if (!z) {
                Preconditions.checkState(this.zzj != 0, "Must specify a valid bucketing strategy while requesting aggregation");
            }
            List list3 = this.zzi;
            List list4 = this.zzh;
            boolean z2 = this.zzm;
            int i = this.zzl;
            DataSource dataSource = this.zze;
            long j3 = this.zzk;
            int i2 = this.zzj;
            List list5 = this.zzc;
            return new DataReadRequest(this.zza, list, this.zzf, this.zzg, list5, list2, i2, j3, dataSource, i, false, z2, (com.google.android.gms.internal.fitness.zzaw) null, list4, list3);
        }

        public Builder enableServerQueries() {
            this.zzm = true;
            return this;
        }

        public Builder read(DataType dataType) {
            Preconditions.checkNotNull(dataType, "Attempting to use a null data type");
            Preconditions.checkState(!this.zzc.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            List list = this.zza;
            if (!list.contains(dataType)) {
                list.add(dataType);
            }
            return this;
        }

        public Builder setTimeRange(long j, long j2, TimeUnit timeUnit) {
            this.zzf = timeUnit.toMillis(j);
            this.zzg = timeUnit.toMillis(j2);
            return this;
        }
    }

    public DataReadRequest(List list, List list2, long j, long j2, List list3, List list4, int i, long j3, DataSource dataSource, int i2, boolean z, boolean z2, IBinder iBinder, List list5, List list6) {
        this.zza = list;
        this.zzb = list2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = list3;
        this.zzf = list4;
        this.zzg = i;
        this.zzh = j3;
        this.zzi = dataSource;
        this.zzj = i2;
        this.zzk = z;
        this.zzl = z2;
        this.zzm = iBinder == null ? null : com.google.android.gms.internal.fitness.zzav.zzc(iBinder);
        List list7 = list5 == null ? Collections.EMPTY_LIST : list5;
        this.zzn = list7;
        List list8 = list6 == null ? Collections.EMPTY_LIST : list6;
        this.zzo = list8;
        Preconditions.checkArgument(list7.size() == list8.size(), "Unequal number of interval start and end times.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DataReadRequest) {
            DataReadRequest dataReadRequest = (DataReadRequest) obj;
            if (this.zza.equals(dataReadRequest.zza) && this.zzb.equals(dataReadRequest.zzb) && this.zzc == dataReadRequest.zzc && this.zzd == dataReadRequest.zzd && this.zzg == dataReadRequest.zzg && this.zzf.equals(dataReadRequest.zzf) && this.zze.equals(dataReadRequest.zze) && Objects.equal(this.zzi, dataReadRequest.zzi) && this.zzh == dataReadRequest.zzh && this.zzl == dataReadRequest.zzl && this.zzj == dataReadRequest.zzj && this.zzk == dataReadRequest.zzk && Objects.equal(this.zzm, dataReadRequest.zzm)) {
                return true;
            }
        }
        return false;
    }

    public DataSource getActivityDataSource() {
        return this.zzi;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.zzf;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.zze;
    }

    public int getBucketType() {
        return this.zzg;
    }

    public List<DataSource> getDataSources() {
        return this.zzb;
    }

    public List<DataType> getDataTypes() {
        return this.zza;
    }

    public int getLimit() {
        return this.zzj;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzg), Long.valueOf(this.zzc), Long.valueOf(this.zzd));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataReadRequest{");
        List list = this.zza;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                sb.append(((DataType) it.next()).zzc());
                sb.append(" ");
            }
        }
        List list2 = this.zzb;
        if (!list2.isEmpty()) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                sb.append(((DataSource) it2.next()).zzb());
                sb.append(" ");
            }
        }
        int i = this.zzg;
        if (i != 0) {
            sb.append("bucket by ");
            sb.append(Bucket.zzc(i));
            long j = this.zzh;
            if (j > 0) {
                zzba$$ExternalSyntheticOutline0.m(sb, " >", j, "ms");
            }
            sb.append(": ");
        }
        List list3 = this.zze;
        if (!list3.isEmpty()) {
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                sb.append(((DataType) it3.next()).zzc());
                sb.append(" ");
            }
        }
        List list4 = this.zzf;
        if (!list4.isEmpty()) {
            Iterator it4 = list4.iterator();
            while (it4.hasNext()) {
                sb.append(((DataSource) it4.next()).zzb());
                sb.append(" ");
            }
        }
        long j2 = this.zzc;
        Locale locale = Locale.US;
        Long lValueOf = Long.valueOf(j2);
        Long lValueOf2 = Long.valueOf(this.zzd);
        sb.append(String.format(locale, "(%tF %tT - %tF %tT)", lValueOf, lValueOf, lValueOf2, lValueOf2));
        DataSource dataSource = this.zzi;
        if (dataSource != null) {
            sb.append("activities: ");
            sb.append(dataSource.zzb());
        }
        if (this.zzl) {
            sb.append(" +server");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, getDataSources(), false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.writeTypedList(parcel, 5, getAggregatedDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 6, getAggregatedDataSources(), false);
        SafeParcelWriter.writeInt(parcel, 7, getBucketType());
        SafeParcelWriter.writeLong(parcel, 8, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 9, getActivityDataSource(), i, false);
        SafeParcelWriter.writeInt(parcel, 10, getLimit());
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzl);
        com.google.android.gms.internal.fitness.zzaw zzawVar = this.zzm;
        SafeParcelWriter.writeIBinder(parcel, 14, zzawVar == null ? null : zzawVar.asBinder(), false);
        SafeParcelWriter.writeLongList(parcel, 18, this.zzn, false);
        SafeParcelWriter.writeLongList(parcel, 19, this.zzo, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public DataReadRequest(DataReadRequest dataReadRequest, com.google.android.gms.internal.fitness.zzaw zzawVar) {
        this(dataReadRequest.zza, dataReadRequest.zzb, dataReadRequest.zzc, dataReadRequest.zzd, dataReadRequest.zze, dataReadRequest.zzf, dataReadRequest.zzg, dataReadRequest.zzh, dataReadRequest.zzi, dataReadRequest.zzj, dataReadRequest.zzk, dataReadRequest.zzl, zzawVar, dataReadRequest.zzn, dataReadRequest.zzo);
    }

    public DataReadRequest(List list, List list2, long j, long j2, List list3, List list4, int i, long j3, DataSource dataSource, int i2, boolean z, boolean z2, com.google.android.gms.internal.fitness.zzaw zzawVar, List list5, List list6) {
        this(list, list2, j, j2, list3, list4, i, j3, dataSource, i2, z, z2, zzawVar == null ? null : zzawVar.asBinder(), list5, list6);
    }
}
