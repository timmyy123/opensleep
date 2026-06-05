package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzfh;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public class Goal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Goal> CREATOR = new zzq();
    private final long zza;
    private final long zzb;
    private final List zzc;
    private final Recurrence zzd;
    private final int zze;
    private final MetricObjective zzf;
    private final DurationObjective zzg;
    private final FrequencyObjective zzh;

    public static class DurationObjective extends AbstractSafeParcelable {
        public static final Parcelable.Creator<DurationObjective> CREATOR = new zzn();
        private final long zza;

        public DurationObjective(long j) {
            this.zza = j;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof DurationObjective) && this.zza == ((DurationObjective) obj).zza;
        }

        public int hashCode() {
            return (int) this.zza;
        }

        public String toString() {
            return Objects.toStringHelper(this).add("duration", Long.valueOf(this.zza)).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeLong(parcel, 1, this.zza);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    public static class FrequencyObjective extends AbstractSafeParcelable {
        public static final Parcelable.Creator<FrequencyObjective> CREATOR = new zzp();
        private final int zza;

        public FrequencyObjective(int i) {
            this.zza = i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof FrequencyObjective) && this.zza == ((FrequencyObjective) obj).zza;
        }

        public int getFrequency() {
            return this.zza;
        }

        public int hashCode() {
            return this.zza;
        }

        public String toString() {
            return Objects.toStringHelper(this).add("frequency", Integer.valueOf(this.zza)).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, getFrequency());
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    public static class MetricObjective extends AbstractSafeParcelable {
        public static final Parcelable.Creator<MetricObjective> CREATOR = new zzw();
        private final String zza;
        private final double zzb;
        private final double zzc;

        public MetricObjective(String str, double d, double d2) {
            this.zza = str;
            this.zzb = d;
            this.zzc = d2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MetricObjective)) {
                return false;
            }
            MetricObjective metricObjective = (MetricObjective) obj;
            return Objects.equal(this.zza, metricObjective.zza) && this.zzb == metricObjective.zzb && this.zzc == metricObjective.zzc;
        }

        public String getDataTypeName() {
            return this.zza;
        }

        public double getValue() {
            return this.zzb;
        }

        public int hashCode() {
            return this.zza.hashCode();
        }

        public String toString() {
            return Objects.toStringHelper(this).add("dataTypeName", this.zza).add(SDKConstants.PARAM_VALUE, Double.valueOf(this.zzb)).add("initialValue", Double.valueOf(this.zzc)).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getDataTypeName(), false);
            SafeParcelWriter.writeDouble(parcel, 2, getValue());
            SafeParcelWriter.writeDouble(parcel, 3, this.zzc);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    public static class Recurrence extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Recurrence> CREATOR = new zzaa();
        private final int zza;
        private final int zzb;

        public Recurrence(int i, int i2) {
            this.zza = i;
            boolean z = false;
            if (i2 > 0 && i2 <= 3) {
                z = true;
            }
            Preconditions.checkState(z);
            this.zzb = i2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Recurrence)) {
                return false;
            }
            Recurrence recurrence = (Recurrence) obj;
            return this.zza == recurrence.zza && this.zzb == recurrence.zzb;
        }

        public int getCount() {
            return this.zza;
        }

        public int getUnit() {
            return this.zzb;
        }

        public int hashCode() {
            return this.zzb;
        }

        public String toString() {
            String str;
            Objects.ToStringHelper toStringHelperAdd = Objects.toStringHelper(this).add("count", Integer.valueOf(this.zza));
            int i = this.zzb;
            if (i == 1) {
                str = "day";
            } else if (i == 2) {
                str = "week";
            } else {
                if (i != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("invalid unit value");
                    return null;
                }
                str = "month";
            }
            return toStringHelperAdd.add("unit", str).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, getCount());
            SafeParcelWriter.writeInt(parcel, 2, getUnit());
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    public Goal(long j, long j2, List list, Recurrence recurrence, int i, MetricObjective metricObjective, DurationObjective durationObjective, FrequencyObjective frequencyObjective) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = list;
        this.zzd = recurrence;
        this.zze = i;
        this.zzf = metricObjective;
        this.zzg = durationObjective;
        this.zzh = frequencyObjective;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Goal)) {
            return false;
        }
        Goal goal = (Goal) obj;
        return this.zza == goal.zza && this.zzb == goal.zzb && Objects.equal(this.zzc, goal.zzc) && Objects.equal(this.zzd, goal.zzd) && this.zze == goal.zze && Objects.equal(this.zzf, goal.zzf) && Objects.equal(this.zzg, goal.zzg) && Objects.equal(this.zzh, goal.zzh);
    }

    public String getActivityName() {
        List list = this.zzc;
        if (list.isEmpty() || list.size() > 1) {
            return null;
        }
        return zzfh.zzb(((Integer) list.get(0)).intValue());
    }

    public int getObjectiveType() {
        return this.zze;
    }

    public Recurrence getRecurrence() {
        return this.zzd;
    }

    public int hashCode() {
        return this.zze;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("activity", getActivityName()).add("recurrence", this.zzd).add("metricObjective", this.zzf).add("durationObjective", this.zzg).add("frequencyObjective", this.zzh).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        long j = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, j);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeList(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getRecurrence(), i, false);
        SafeParcelWriter.writeInt(parcel, 5, getObjectiveType());
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
