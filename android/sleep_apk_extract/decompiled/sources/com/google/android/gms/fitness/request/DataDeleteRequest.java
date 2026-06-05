package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.zzby;
import com.google.android.gms.internal.fitness.zzbz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DataDeleteRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new zzi();
    private final long zza;
    private final long zzb;
    private final List zzc;
    private final List zzd;
    private final List zze;
    private final boolean zzf;
    private final boolean zzg;
    private final zzbz zzh;
    private final boolean zzi;
    private final boolean zzj;

    public static class Builder {
        private long zza;
        private long zzb;
        private final List zzc = new ArrayList();
        private final List zzd = new ArrayList();
        private final List zze = new ArrayList();
        private boolean zzf = false;
        private boolean zzg = false;

        public Builder addDataType(DataType dataType) {
            Preconditions.checkArgument(!this.zzf, "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
            Preconditions.checkArgument(dataType != null, "Must specify a valid data type");
            List list = this.zzd;
            if (!list.contains(dataType)) {
                list.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            Preconditions.checkArgument(!this.zzg, "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
            Preconditions.checkArgument(session != null, "Must specify a valid session");
            Preconditions.checkArgument(session.getEndTime(TimeUnit.MILLISECONDS) > 0, "Cannot delete an ongoing session. Please stop the session prior to deleting it");
            this.zze.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            long j = this.zza;
            Preconditions.checkState(j > 0 && this.zzb > j, "Must specify a valid time interval");
            Preconditions.checkState((this.zzf || !this.zzc.isEmpty() || !this.zzd.isEmpty()) || (this.zzg || !this.zze.isEmpty()), "No data or session marked for deletion");
            List<Session> list = this.zze;
            if (!list.isEmpty()) {
                for (Session session : list) {
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    Preconditions.checkState(session.getStartTime(timeUnit) >= this.zza && session.getEndTime(timeUnit) <= this.zzb, "Session %s is outside the time interval [%d, %d]", session, Long.valueOf(this.zza), Long.valueOf(this.zzb));
                }
            }
            boolean z = this.zzg;
            boolean z2 = this.zzf;
            List list2 = this.zzd;
            return new DataDeleteRequest(this.zza, this.zzb, this.zzc, list2, list, z2, z, false, false, (zzbz) null);
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkArgument(j > 0, "Invalid start time: %d", Long.valueOf(j));
            Preconditions.checkArgument(j2 > j, "Invalid end time: %d", Long.valueOf(j2));
            this.zza = timeUnit.toMillis(j);
            this.zzb = timeUnit.toMillis(j2);
            return this;
        }
    }

    public DataDeleteRequest(long j, long j2, List list, List list2, List list3, boolean z, boolean z2, boolean z3, boolean z4, IBinder iBinder) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = Collections.unmodifiableList(list);
        this.zzd = Collections.unmodifiableList(list2);
        this.zze = list3;
        this.zzf = z;
        this.zzg = z2;
        this.zzi = z3;
        this.zzj = z4;
        this.zzh = iBinder == null ? null : zzby.zzc(iBinder);
    }

    public boolean deleteAllData() {
        return this.zzf;
    }

    public boolean deleteAllSessions() {
        return this.zzg;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataDeleteRequest)) {
            return false;
        }
        DataDeleteRequest dataDeleteRequest = (DataDeleteRequest) obj;
        return this.zza == dataDeleteRequest.zza && this.zzb == dataDeleteRequest.zzb && Objects.equal(this.zzc, dataDeleteRequest.zzc) && Objects.equal(this.zzd, dataDeleteRequest.zzd) && Objects.equal(this.zze, dataDeleteRequest.zze) && this.zzf == dataDeleteRequest.zzf && this.zzg == dataDeleteRequest.zzg && this.zzi == dataDeleteRequest.zzi && this.zzj == dataDeleteRequest.zzj;
    }

    public List<DataSource> getDataSources() {
        return this.zzc;
    }

    public List<DataType> getDataTypes() {
        return this.zzd;
    }

    public List<Session> getSessions() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb));
    }

    public String toString() {
        Objects.ToStringHelper toStringHelperAdd = Objects.toStringHelper(this).add("startTimeMillis", Long.valueOf(this.zza)).add("endTimeMillis", Long.valueOf(this.zzb)).add("dataSources", this.zzc).add("dateTypes", this.zzd).add("sessions", this.zze).add("deleteAllData", Boolean.valueOf(this.zzf)).add("deleteAllSessions", Boolean.valueOf(this.zzg));
        if (this.zzi) {
            toStringHelperAdd.add("deleteByTimeRange", Boolean.TRUE);
        }
        return toStringHelperAdd.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        long j = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, j);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeTypedList(parcel, 3, getDataSources(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getSessions(), false);
        SafeParcelWriter.writeBoolean(parcel, 6, deleteAllData());
        SafeParcelWriter.writeBoolean(parcel, 7, deleteAllSessions());
        zzbz zzbzVar = this.zzh;
        SafeParcelWriter.writeIBinder(parcel, 8, zzbzVar == null ? null : zzbzVar.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public DataDeleteRequest(long j, long j2, List list, List list2, List list3, boolean z, boolean z2, boolean z3, boolean z4, zzbz zzbzVar) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = Collections.unmodifiableList(list);
        this.zzd = Collections.unmodifiableList(list2);
        this.zze = list3;
        this.zzf = z;
        this.zzg = z2;
        this.zzi = z3;
        this.zzj = z4;
        this.zzh = zzbzVar;
    }

    public DataDeleteRequest(DataDeleteRequest dataDeleteRequest, zzbz zzbzVar) {
        this(dataDeleteRequest.zza, dataDeleteRequest.zzb, dataDeleteRequest.zzc, dataDeleteRequest.zzd, dataDeleteRequest.zze, dataDeleteRequest.zzf, dataDeleteRequest.zzg, dataDeleteRequest.zzi, dataDeleteRequest.zzj, zzbzVar);
    }
}
