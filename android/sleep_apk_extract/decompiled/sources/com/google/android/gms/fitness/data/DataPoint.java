package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class DataPoint extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DataPoint> CREATOR = new zzf();
    private final DataSource zza;
    private long zzb;
    private long zzc;
    private final Value[] zzd;
    private DataSource zze;
    private final long zzf;

    private DataPoint(DataSource dataSource) {
        this.zza = (DataSource) Preconditions.checkNotNull(dataSource, "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.zzd = new Value[fields.size()];
        Iterator<Field> it = fields.iterator();
        int i = 0;
        while (it.hasNext()) {
            this.zzd[i] = new Value(it.next().getFormat(), false, 0.0f, null, null, null, null, null);
            i++;
        }
        this.zzf = 0L;
    }

    public static Builder builder(DataSource dataSource) {
        Preconditions.checkNotNull(dataSource, "DataSource should be specified");
        return new Builder(dataSource, null);
    }

    @Deprecated
    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    private static DataSource zzh(List list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return (DataSource) list.get(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataPoint)) {
            return false;
        }
        DataPoint dataPoint = (DataPoint) obj;
        return Objects.equal(this.zza, dataPoint.zza) && this.zzb == dataPoint.zzb && this.zzc == dataPoint.zzc && Arrays.equals(this.zzd, dataPoint.zzd) && Objects.equal(getOriginalDataSource(), dataPoint.getOriginalDataSource());
    }

    public DataSource getDataSource() {
        return this.zza;
    }

    public DataType getDataType() {
        return this.zza.getDataType();
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzb, TimeUnit.NANOSECONDS);
    }

    public DataSource getOriginalDataSource() {
        DataSource dataSource = this.zze;
        return dataSource != null ? dataSource : this.zza;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzc, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzb, TimeUnit.NANOSECONDS);
    }

    public Value getValue(Field field) {
        return this.zzd[getDataType().indexOf(field)];
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    @Deprecated
    public DataPoint setTimeInterval(long j, long j2, TimeUnit timeUnit) {
        this.zzc = timeUnit.toNanos(j);
        this.zzb = timeUnit.toNanos(j2);
        return this;
    }

    @Deprecated
    public DataPoint setTimestamp(long j, TimeUnit timeUnit) {
        this.zzb = timeUnit.toNanos(j);
        return this;
    }

    public String toString() {
        String string = Arrays.toString(this.zzd);
        long j = this.zzc;
        long j2 = this.zzb;
        long j3 = this.zzf;
        String strZzb = this.zza.zzb();
        DataSource dataSource = this.zze;
        String strZzb2 = dataSource != null ? dataSource.zzb() : "N/A";
        StringBuilder sb = new StringBuilder("DataPoint{");
        sb.append(string);
        sb.append("@[");
        sb.append(j);
        zzba$$ExternalSyntheticOutline0.m(sb, ", ", j2, ",raw=");
        sb.append(j3);
        sb.append("](");
        sb.append(strZzb);
        return Fragment$$ExternalSyntheticOutline1.m(sb, " ", strZzb2, ")}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzb);
        SafeParcelWriter.writeLong(parcel, 4, this.zzc);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zze, i, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final Value zza(int i) {
        DataType dataType = getDataType();
        boolean z = false;
        if (i >= 0 && i < dataType.getFields().size()) {
            z = true;
        }
        Preconditions.checkArgument(z, "fieldIndex %s is out of range for %s", Integer.valueOf(i), dataType);
        return this.zzd[i];
    }

    public final Value[] zzb() {
        return this.zzd;
    }

    public final DataSource zzc() {
        return this.zze;
    }

    public final long zzd() {
        return this.zzf;
    }

    public final void zze() {
        Preconditions.checkArgument(getDataType().getName().equals(getDataSource().getDataType().getName()), "Conflicting data types found %s vs %s", getDataType(), getDataType());
        Preconditions.checkArgument(this.zzb > 0, "Data point does not have the timestamp set: %s", this);
        long j = this.zzc;
        long j2 = this.zzb;
        Preconditions.checkArgument(j <= j2, "Data point with start time greater than end time found: %s", this);
    }

    public static class Builder {
        private final DataPoint zza;
        private boolean zzb = false;

        public /* synthetic */ Builder(DataSource dataSource, byte[] bArr) {
            this.zza = DataPoint.create(dataSource);
        }

        public DataPoint build() {
            Preconditions.checkState(!this.zzb, "DataPoint#build should not be called multiple times.");
            this.zzb = true;
            return this.zza;
        }

        public Builder setField(Field field, float f) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.getValue(field).setFloat(f);
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.setTimeInterval(j, j2, timeUnit);
            return this;
        }

        public Builder setField(Field field, int i) {
            Preconditions.checkState(!this.zzb, "Builder should not be mutated after calling #build.");
            this.zza.getValue(field).setInt(i);
            return this;
        }
    }

    public DataPoint(DataSource dataSource, long j, long j2, Value[] valueArr, DataSource dataSource2, long j3) {
        this.zza = dataSource;
        this.zze = dataSource2;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = valueArr;
        this.zzf = j3;
    }

    public DataPoint(List list, RawDataPoint rawDataPoint) {
        this((DataSource) Preconditions.checkNotNull(zzh(list, rawDataPoint.zzd())), rawDataPoint.zza(), rawDataPoint.zzb(), rawDataPoint.zzc(), zzh(list, rawDataPoint.zze()), rawDataPoint.zzf());
    }
}
