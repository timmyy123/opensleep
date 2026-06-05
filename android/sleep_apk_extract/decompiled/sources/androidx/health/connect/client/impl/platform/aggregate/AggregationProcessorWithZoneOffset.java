package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.records.InstantaneousRecord;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.SeriesRecord;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\f\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessorWithZoneOffset;", "Landroidx/health/connect/client/records/Record;", "T", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "delegate", "j$/time/Instant", "bucketStartTime", "<init>", "(Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;Lj$/time/Instant;)V", "record", "", "processRecord", "(Landroidx/health/connect/client/records/Record;)V", "Landroidx/health/connect/client/aggregate/AggregationResult;", "getProcessedAggregationResult", "()Landroidx/health/connect/client/aggregate/AggregationResult;", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "Lj$/time/Instant;", "getBucketStartTime", "()Lj$/time/Instant;", "j$/time/ZoneOffset", "zoneOffset", "Lj$/time/ZoneOffset;", "getZoneOffset", "()Lj$/time/ZoneOffset;", "setZoneOffset", "(Lj$/time/ZoneOffset;)V", "minTime", "getMinTime", "setMinTime", "(Lj$/time/Instant;)V", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AggregationProcessorWithZoneOffset<T extends Record> implements AggregationProcessor<T> {
    private final Instant bucketStartTime;
    private final AggregationProcessor<T> delegate;
    private Instant minTime;
    private ZoneOffset zoneOffset;

    public AggregationProcessorWithZoneOffset(AggregationProcessor<T> aggregationProcessor, Instant instant) {
        aggregationProcessor.getClass();
        instant.getClass();
        this.delegate = aggregationProcessor;
        this.bucketStartTime = instant;
    }

    public final Instant getBucketStartTime() {
        return this.bucketStartTime;
    }

    public final Instant getMinTime() {
        return this.minTime;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public AggregationResult getProcessedAggregationResult() {
        return this.delegate.getProcessedAggregationResult();
    }

    public final ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public void processRecord(T record) {
        Instant startTime;
        ZoneOffset startZoneOffset;
        record.getClass();
        boolean z = record instanceof InstantaneousRecord;
        if (z) {
            startTime = ((InstantaneousRecord) record).getTime();
        } else if (record instanceof SeriesRecord) {
            List samples = ((SeriesRecord) record).getSamples();
            ArrayList arrayList = new ArrayList();
            for (Object obj : samples) {
                if (AggregatorUtils.INSTANCE.getTime$connect_client_release(obj).compareTo(this.bucketStartTime) >= 0) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            if (!it.hasNext()) {
                Types$$ExternalSyntheticBUOutline0.m();
                return;
            }
            Instant time$connect_client_release = AggregatorUtils.INSTANCE.getTime$connect_client_release(it.next());
            while (it.hasNext()) {
                Instant time$connect_client_release2 = AggregatorUtils.INSTANCE.getTime$connect_client_release(it.next());
                if (time$connect_client_release.compareTo(time$connect_client_release2) > 0) {
                    time$connect_client_release = time$connect_client_release2;
                }
            }
            startTime = time$connect_client_release;
        } else {
            if (!(record instanceof IntervalRecord)) {
                Utf8$$ExternalSyntheticBUOutline0.m("Unsupported record ", record);
                return;
            }
            startTime = ((IntervalRecord) record).getStartTime();
        }
        if (z) {
            startZoneOffset = ((InstantaneousRecord) record).getZoneOffset();
        } else {
            if (!(record instanceof IntervalRecord)) {
                Utf8$$ExternalSyntheticBUOutline0.m("Unsupported record ", record);
                return;
            }
            startZoneOffset = ((IntervalRecord) record).getStartZoneOffset();
        }
        Instant instant = this.minTime;
        if (instant == null || startTime.compareTo(instant) < 0) {
            this.minTime = startTime;
            this.zoneOffset = startZoneOffset;
        }
        this.delegate.processRecord(record);
    }
}
