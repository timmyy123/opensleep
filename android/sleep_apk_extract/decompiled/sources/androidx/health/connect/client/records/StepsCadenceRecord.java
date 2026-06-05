package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()BA\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b \u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b!\u0010\u001fR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Landroidx/health/connect/client/records/StepsCadenceRecord;", "Landroidx/health/connect/client/records/SeriesRecord;", "Landroidx/health/connect/client/records/StepsCadenceRecord$Sample;", "j$/time/Instant", "startTime", "j$/time/ZoneOffset", "startZoneOffset", SDKConstants.PARAM_END_TIME, "endZoneOffset", "", "samples", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Lj$/time/Instant;Lj$/time/ZoneOffset;Ljava/util/List;Landroidx/health/connect/client/records/metadata/Metadata;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getStartZoneOffset", "()Lj$/time/ZoneOffset;", "getEndTime", "getEndZoneOffset", "Ljava/util/List;", "getSamples", "()Ljava/util/List;", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "Companion", "Sample", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StepsCadenceRecord implements SeriesRecord<Sample> {
    public static final AggregateMetric<Double> RATE_AVG;
    public static final AggregateMetric<Double> RATE_MAX;
    public static final AggregateMetric<Double> RATE_MIN;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final List<Sample> samples;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/health/connect/client/records/StepsCadenceRecord$Sample;", "", "j$/time/Instant", "time", "", "rate", "<init>", "(Lj$/time/Instant;D)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getTime", "()Lj$/time/Instant;", "D", "getRate", "()D", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Sample {
        private final double rate;
        private final Instant time;

        public Sample(Instant instant, double d) {
            instant.getClass();
            this.time = instant;
            this.rate = d;
            UtilsKt.requireNonNegative(d, "rate");
            UtilsKt.requireNotMore(Double.valueOf(d), Double.valueOf(10000.0d), "rate");
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Sample)) {
                return false;
            }
            Sample sample = (Sample) other;
            return Intrinsics.areEqual(this.time, sample.time) && this.rate == sample.rate;
        }

        public final double getRate() {
            return this.rate;
        }

        public final Instant getTime() {
            return this.time;
        }

        public int hashCode() {
            return Double.hashCode(this.rate) + (this.time.hashCode() * 31);
        }

        public String toString() {
            return "Sample(time=" + this.time + ", rate=" + this.rate + ')';
        }
    }

    static {
        AggregateMetric.Companion companion = AggregateMetric.INSTANCE;
        RATE_AVG = companion.doubleMetric$connect_client_release("StepsCadenceSeries", AggregateMetric.AggregationType.AVERAGE, "rate");
        RATE_MIN = companion.doubleMetric$connect_client_release("StepsCadenceSeries", AggregateMetric.AggregationType.MINIMUM, "rate");
        RATE_MAX = companion.doubleMetric$connect_client_release("StepsCadenceSeries", AggregateMetric.AggregationType.MAXIMUM, "rate");
    }

    public StepsCadenceRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, List<Sample> list, androidx.health.connect.client.records.metadata.Metadata metadata) {
        instant.getClass();
        instant2.getClass();
        list.getClass();
        metadata.getClass();
        this.startTime = instant;
        this.startZoneOffset = zoneOffset;
        this.endTime = instant2;
        this.endZoneOffset = zoneOffset2;
        this.samples = list;
        this.metadata = metadata;
        if (getStartTime().isAfter(getEndTime())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("startTime must not be after endTime.");
            throw null;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StepsCadenceRecord)) {
            return false;
        }
        StepsCadenceRecord stepsCadenceRecord = (StepsCadenceRecord) other;
        return Intrinsics.areEqual(getStartTime(), stepsCadenceRecord.getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), stepsCadenceRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), stepsCadenceRecord.getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), stepsCadenceRecord.getEndZoneOffset()) && Intrinsics.areEqual(getSamples(), stepsCadenceRecord.getSamples()) && Intrinsics.areEqual(getMetadata(), stepsCadenceRecord.getMetadata());
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getEndTime() {
        return this.endTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getEndZoneOffset() {
        return this.endZoneOffset;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // androidx.health.connect.client.records.SeriesRecord
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getStartTime() {
        return this.startTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getStartZoneOffset() {
        return this.startZoneOffset;
    }

    public int hashCode() {
        int iHashCode = getStartTime().hashCode() * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode2 = (getEndTime().hashCode() + ((iHashCode + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31)) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        int iHashCode3 = endZoneOffset != null ? endZoneOffset.hashCode() : 0;
        return getMetadata().hashCode() + ((getSamples().hashCode() + ((iHashCode2 + iHashCode3) * 31)) * 31);
    }

    public String toString() {
        return "StepsCadenceRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", samples=" + getSamples() + ", metadata=" + getMetadata() + ')';
    }
}
