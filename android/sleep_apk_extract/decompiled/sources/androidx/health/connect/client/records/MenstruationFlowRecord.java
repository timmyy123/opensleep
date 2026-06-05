package androidx.health.connect.client.records;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 #2\u00020\u0001:\u0001#B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\t\u001a\u00020\b8\u0006¢\u0006\u0012\n\u0004\b\t\u0010\u001f\u0012\u0004\b!\u0010\"\u001a\u0004\b \u0010\u0012¨\u0006$"}, d2 = {"Landroidx/health/connect/client/records/MenstruationFlowRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "j$/time/Instant", "time", "j$/time/ZoneOffset", "zoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "", "flow", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getZoneOffset", "()Lj$/time/ZoneOffset;", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "I", "getFlow", "getFlow$annotations", "()V", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MenstruationFlowRecord implements InstantaneousRecord {
    public static final Map<Integer, String> FLOW_TYPE_INT_TO_STRING_MAP;
    public static final Map<String, Integer> FLOW_TYPE_STRING_TO_INT_MAP;
    private final int flow;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("light", 1), TuplesKt.to("medium", 2), TuplesKt.to("heavy", 3));
        FLOW_TYPE_STRING_TO_INT_MAP = mapMapOf;
        Set<Map.Entry<String, Integer>> setEntrySet = mapMapOf.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Integer.valueOf(((Number) entry.getValue()).intValue()), (String) entry.getKey());
        }
        FLOW_TYPE_INT_TO_STRING_MAP = linkedHashMap;
    }

    public MenstruationFlowRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int i) {
        instant.getClass();
        metadata.getClass();
        this.time = instant;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.flow = i;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MenstruationFlowRecord)) {
            return false;
        }
        MenstruationFlowRecord menstruationFlowRecord = (MenstruationFlowRecord) other;
        return this.flow == menstruationFlowRecord.flow && Intrinsics.areEqual(getTime(), menstruationFlowRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), menstruationFlowRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), menstruationFlowRecord.getMetadata());
    }

    public final int getFlow() {
        return this.flow;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public int hashCode() {
        int iHashCode = (getTime().hashCode() + (this.flow * 31)) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return getMetadata().hashCode() + ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "MenstruationFlowRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", flow=" + this.flow + ", metadata=" + getMetadata() + ')';
    }
}
