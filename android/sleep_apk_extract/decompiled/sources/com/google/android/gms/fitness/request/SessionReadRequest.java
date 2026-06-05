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
import com.google.android.gms.internal.fitness.zzbs;
import com.google.android.gms.internal.fitness.zzbt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class SessionReadRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SessionReadRequest> CREATOR = new zzam();
    private final String zza;
    private final String zzb;
    private final long zzc;
    private final long zzd;
    private final List zze;
    private final List zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final List zzi;
    private final zzbt zzj;
    private final boolean zzk;
    private final boolean zzl;

    /* JADX INFO: loaded from: classes5.dex */
    public static class Builder {
        private String zza;
        private String zzb;
        private long zzc = 0;
        private long zzd = 0;
        private final List zze = new ArrayList();
        private final List zzf = new ArrayList();
        private boolean zzg = false;
        private boolean zzh = false;
        private final List zzi = new ArrayList();
        private boolean zzj = false;
        private boolean zzk = false;
        private boolean zzl = false;

        public SessionReadRequest build() {
            long j = this.zzc;
            boolean z = false;
            Preconditions.checkArgument(j > 0, "Invalid start time: %s", Long.valueOf(j));
            long j2 = this.zzd;
            if (j2 > 0 && j2 > this.zzc) {
                z = true;
            }
            Preconditions.checkArgument(z, "Invalid end time: %s", Long.valueOf(j2));
            if (!this.zzl) {
                this.zzj = true;
            }
            boolean z2 = this.zzk;
            boolean z3 = this.zzj;
            List list = this.zzi;
            boolean z4 = this.zzh;
            boolean z5 = this.zzg;
            List list2 = this.zzf;
            List list3 = this.zze;
            return new SessionReadRequest(this.zza, this.zzb, this.zzc, this.zzd, list3, list2, z5, z4, list, null, z3, z2);
        }

        public Builder enableServerQueries() {
            this.zzh = true;
            return this;
        }

        public Builder includeSleepSessions() {
            this.zzk = true;
            this.zzl = true;
            return this;
        }

        public Builder read(DataType dataType) {
            Preconditions.checkNotNull(dataType, "Attempting to use a null data type");
            List list = this.zze;
            if (!list.contains(dataType)) {
                list.add(dataType);
            }
            return this;
        }

        public Builder setSessionId(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            this.zzc = timeUnit.toMillis(j);
            this.zzd = timeUnit.toMillis(j2);
            return this;
        }
    }

    public SessionReadRequest(String str, String str2, long j, long j2, List list, List list2, boolean z, boolean z2, List list3, IBinder iBinder, boolean z3, boolean z4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = z;
        this.zzh = z2;
        this.zzi = list3;
        this.zzj = iBinder == null ? null : zzbs.zzb(iBinder);
        this.zzk = z3;
        this.zzl = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionReadRequest)) {
            return false;
        }
        SessionReadRequest sessionReadRequest = (SessionReadRequest) obj;
        return Objects.equal(this.zza, sessionReadRequest.zza) && Objects.equal(this.zzb, sessionReadRequest.zzb) && this.zzc == sessionReadRequest.zzc && this.zzd == sessionReadRequest.zzd && Objects.equal(this.zze, sessionReadRequest.zze) && Objects.equal(this.zzf, sessionReadRequest.zzf) && this.zzg == sessionReadRequest.zzg && this.zzi.equals(sessionReadRequest.zzi) && this.zzh == sessionReadRequest.zzh && this.zzk == sessionReadRequest.zzk && this.zzl == sessionReadRequest.zzl;
    }

    public List<DataSource> getDataSources() {
        return this.zzf;
    }

    public List<DataType> getDataTypes() {
        return this.zze;
    }

    public List<String> getExcludedPackages() {
        return this.zzi;
    }

    public String getSessionId() {
        return this.zzb;
    }

    public String getSessionName() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Long.valueOf(this.zzc), Long.valueOf(this.zzd));
    }

    public boolean includeSessionsFromAllApps() {
        return this.zzg;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("sessionName", this.zza).add("sessionId", this.zzb).add("startTimeMillis", Long.valueOf(this.zzc)).add("endTimeMillis", Long.valueOf(this.zzd)).add("dataTypes", this.zze).add("dataSources", this.zzf).add("sessionsFromAllApps", Boolean.valueOf(this.zzg)).add("excludedPackages", this.zzi).add("useServer", Boolean.valueOf(this.zzh)).add("activitySessionsIncluded", Boolean.valueOf(this.zzk)).add("sleepSessionsIncluded", Boolean.valueOf(this.zzl)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getSessionName(), false);
        SafeParcelWriter.writeString(parcel, 2, getSessionId(), false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.writeTypedList(parcel, 5, getDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 6, getDataSources(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, includeSessionsFromAllApps());
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeStringList(parcel, 9, getExcludedPackages(), false);
        zzbt zzbtVar = this.zzj;
        SafeParcelWriter.writeIBinder(parcel, 10, zzbtVar == null ? null : zzbtVar.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzl);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SessionReadRequest(SessionReadRequest sessionReadRequest, zzbt zzbtVar) {
        this(sessionReadRequest.zza, sessionReadRequest.zzb, sessionReadRequest.zzc, sessionReadRequest.zzd, sessionReadRequest.zze, sessionReadRequest.zzf, sessionReadRequest.zzg, sessionReadRequest.zzh, sessionReadRequest.zzi, zzbtVar, sessionReadRequest.zzk, sessionReadRequest.zzl);
    }
}
