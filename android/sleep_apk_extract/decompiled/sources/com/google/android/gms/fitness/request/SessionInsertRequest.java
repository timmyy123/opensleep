package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.zzby;
import com.google.android.gms.internal.fitness.zzbz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class SessionInsertRequest extends AbstractSafeParcelable {
    private final Session zzb;
    private final List zzc;
    private final List zzd;
    private final zzbz zze;
    private static final TimeUnit zza = TimeUnit.MILLISECONDS;
    public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new zzal();

    public static class Builder {
        private Session zza;
        private final List zzb = new ArrayList();
        private final List zzc = new ArrayList();
        private final List zzd = new ArrayList();

        private final void zza(DataPoint dataPoint) {
            Session session = this.zza;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long startTime = session.getStartTime(timeUnit);
            long endTime = this.zza.getEndTime(timeUnit);
            long startTime2 = dataPoint.getStartTime(timeUnit);
            long endTime2 = dataPoint.getEndTime(timeUnit);
            if (startTime2 == 0 || endTime2 == 0) {
                return;
            }
            if (endTime2 > endTime) {
                TimeUnit timeUnit2 = SessionInsertRequest.zza;
                endTime2 = timeUnit.convert(timeUnit2.convert(endTime2, timeUnit), timeUnit2);
            }
            boolean z = false;
            if (startTime2 >= startTime && endTime2 <= endTime) {
                z = true;
            }
            Preconditions.checkState(z, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
            if (endTime2 != dataPoint.getEndTime(timeUnit)) {
                Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", Long.valueOf(dataPoint.getEndTime(timeUnit)), Long.valueOf(endTime2), SessionInsertRequest.zza));
                dataPoint.setTimeInterval(startTime2, endTime2, timeUnit);
            }
        }

        private final void zzb(DataPoint dataPoint) {
            Session session = this.zza;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long startTime = session.getStartTime(timeUnit);
            long endTime = this.zza.getEndTime(timeUnit);
            long timestamp = dataPoint.getTimestamp(timeUnit);
            if (timestamp != 0) {
                if (timestamp < startTime || timestamp > endTime) {
                    TimeUnit timeUnit2 = SessionInsertRequest.zza;
                    timestamp = timeUnit.convert(timeUnit2.convert(timestamp, timeUnit), timeUnit2);
                }
                boolean z = false;
                if (timestamp >= startTime && timestamp <= endTime) {
                    z = true;
                }
                Preconditions.checkState(z, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (dataPoint.getTimestamp(timeUnit) != timestamp) {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", Long.valueOf(dataPoint.getTimestamp(timeUnit)), Long.valueOf(timestamp), SessionInsertRequest.zza));
                    dataPoint.setTimestamp(timestamp, timeUnit);
                }
            }
        }

        public Builder addDataSet(DataSet dataSet) {
            Preconditions.checkArgument(dataSet != null, "Must specify a valid data set.");
            DataSource dataSource = dataSet.getDataSource();
            List list = this.zzd;
            Preconditions.checkState(!list.contains(dataSource), "Data set for this data source %s is already added.", dataSource);
            Preconditions.checkArgument(true ^ dataSet.getDataPoints().isEmpty(), "No data points specified in the input data set.");
            list.add(dataSource);
            this.zzb.add(dataSet);
            return this;
        }

        public SessionInsertRequest build() {
            Preconditions.checkState(this.zza != null, "Must specify a valid session.");
            Preconditions.checkState(this.zza.getEndTime(TimeUnit.MILLISECONDS) != 0, "Must specify a valid end time, cannot insert a continuing session.");
            List list = this.zzb;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                for (DataPoint dataPoint : ((DataSet) it.next()).getDataPoints()) {
                    zzb(dataPoint);
                    zza(dataPoint);
                }
            }
            List<DataPoint> list2 = this.zzc;
            for (DataPoint dataPoint2 : list2) {
                zzb(dataPoint2);
                zza(dataPoint2);
            }
            return new SessionInsertRequest(this.zza, list, list2, (zzbz) null);
        }

        public Builder setSession(Session session) {
            this.zza = session;
            return this;
        }
    }

    public SessionInsertRequest(Session session, List list, List list2, IBinder iBinder) {
        this.zzb = session;
        this.zzc = Collections.unmodifiableList(list);
        this.zzd = Collections.unmodifiableList(list2);
        this.zze = iBinder == null ? null : zzby.zzc(iBinder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SessionInsertRequest) {
            SessionInsertRequest sessionInsertRequest = (SessionInsertRequest) obj;
            if (Objects.equal(this.zzb, sessionInsertRequest.zzb) && Objects.equal(this.zzc, sessionInsertRequest.zzc) && Objects.equal(this.zzd, sessionInsertRequest.zzd)) {
                return true;
            }
        }
        return false;
    }

    public List<DataPoint> getAggregateDataPoints() {
        return this.zzd;
    }

    public List<DataSet> getDataSets() {
        return this.zzc;
    }

    public Session getSession() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc, this.zzd);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("session", this.zzb).add("dataSets", this.zzc).add("aggregateDataPoints", this.zzd).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getSession(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, getDataSets(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, getAggregateDataPoints(), false);
        zzbz zzbzVar = this.zze;
        SafeParcelWriter.writeIBinder(parcel, 4, zzbzVar == null ? null : zzbzVar.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public SessionInsertRequest(Session session, List list, List list2, zzbz zzbzVar) {
        this.zzb = session;
        this.zzc = Collections.unmodifiableList(list);
        this.zzd = Collections.unmodifiableList(list2);
        this.zze = zzbzVar;
    }

    public SessionInsertRequest(SessionInsertRequest sessionInsertRequest, zzbz zzbzVar) {
        this(sessionInsertRequest.zzb, sessionInsertRequest.zzc, sessionInsertRequest.zzd, zzbzVar);
    }
}
