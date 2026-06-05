package androidx.health.connect.client.request;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\u0018\u0000 0*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u00010BY\b\u0007\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013BO\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0014J\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048G¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\u00020\u00068G¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8G¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\f\u001a\u00020\u000b8G¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u000e\u001a\u00020\r8G¢\u0006\f\n\u0004\b\u000e\u0010*\u001a\u0004\b+\u0010\u001dR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8G¢\u0006\f\n\u0004\b\u0010\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0011\u001a\u00020\r8G¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b/\u0010\u001d¨\u00061"}, d2 = {"Landroidx/health/connect/client/request/ReadRecordsRequest;", "Landroidx/health/connect/client/records/Record;", "T", "", "Lkotlin/reflect/KClass;", "recordType", "Landroidx/health/connect/client/time/TimeRangeFilter;", "timeRangeFilter", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "dataOriginFilter", "", "ascendingOrder", "", "pageSize", "", "pageToken", "deduplicateStrategy", "<init>", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;ZILjava/lang/String;I)V", "(Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;ZILjava/lang/String;)V", "newPageToken", "withPageToken$connect_client_release", "(Ljava/lang/String;)Landroidx/health/connect/client/request/ReadRecordsRequest;", "withPageToken", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lkotlin/reflect/KClass;", "getRecordType", "()Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/time/TimeRangeFilter;", "getTimeRangeFilter", "()Landroidx/health/connect/client/time/TimeRangeFilter;", "Ljava/util/Set;", "getDataOriginFilter", "()Ljava/util/Set;", "Z", "getAscendingOrder", "()Z", "I", "getPageSize", "Ljava/lang/String;", "getPageToken", "()Ljava/lang/String;", "getDeduplicateStrategy", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReadRecordsRequest<T extends Record> {
    private final boolean ascendingOrder;
    private final Set<DataOrigin> dataOriginFilter;
    private final int deduplicateStrategy;
    private final int pageSize;
    private final String pageToken;
    private final KClass<T> recordType;
    private final TimeRangeFilter timeRangeFilter;

    public ReadRecordsRequest(KClass<T> kClass, TimeRangeFilter timeRangeFilter, Set<DataOrigin> set, boolean z, int i, String str, int i2) {
        kClass.getClass();
        timeRangeFilter.getClass();
        set.getClass();
        this.recordType = kClass;
        this.timeRangeFilter = timeRangeFilter;
        this.dataOriginFilter = set;
        this.ascendingOrder = z;
        this.pageSize = i;
        this.pageToken = str;
        this.deduplicateStrategy = i2;
        if (i > 0) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("pageSize must be positive.");
        throw null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(ReadRecordsRequest.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        ReadRecordsRequest readRecordsRequest = (ReadRecordsRequest) other;
        return Intrinsics.areEqual(this.recordType, readRecordsRequest.recordType) && Intrinsics.areEqual(this.timeRangeFilter, readRecordsRequest.timeRangeFilter) && Intrinsics.areEqual(this.dataOriginFilter, readRecordsRequest.dataOriginFilter) && this.ascendingOrder == readRecordsRequest.ascendingOrder && this.pageSize == readRecordsRequest.pageSize && Intrinsics.areEqual(this.pageToken, readRecordsRequest.pageToken) && this.deduplicateStrategy == readRecordsRequest.deduplicateStrategy;
    }

    public final boolean getAscendingOrder() {
        return this.ascendingOrder;
    }

    public final Set<DataOrigin> getDataOriginFilter() {
        return this.dataOriginFilter;
    }

    public final int getDeduplicateStrategy() {
        return this.deduplicateStrategy;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final String getPageToken() {
        return this.pageToken;
    }

    public final KClass<T> getRecordType() {
        return this.recordType;
    }

    public final TimeRangeFilter getTimeRangeFilter() {
        return this.timeRangeFilter;
    }

    public int hashCode() {
        int iM = (FileInsert$$ExternalSyntheticOutline0.m(this.ascendingOrder, (this.dataOriginFilter.hashCode() + ((this.timeRangeFilter.hashCode() + (this.recordType.hashCode() * 31)) * 31)) * 31, 31) + this.pageSize) * 31;
        String str = this.pageToken;
        return Integer.hashCode(this.deduplicateStrategy) + ((iM + (str != null ? str.hashCode() : 0)) * 31);
    }

    public final ReadRecordsRequest<T> withPageToken$connect_client_release(String newPageToken) {
        return new ReadRecordsRequest<>(this.recordType, this.timeRangeFilter, this.dataOriginFilter, this.ascendingOrder, this.pageSize, newPageToken, this.deduplicateStrategy);
    }

    public /* synthetic */ ReadRecordsRequest(KClass kClass, TimeRangeFilter timeRangeFilter, Set set, boolean z, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, timeRangeFilter, (i2 & 4) != 0 ? SetsKt.emptySet() : set, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? 1000 : i, (i2 & 32) != 0 ? null : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReadRecordsRequest(KClass<T> kClass, TimeRangeFilter timeRangeFilter, Set<DataOrigin> set, boolean z, int i, String str) {
        this(kClass, timeRangeFilter, set, z, i, str, 0);
        kClass.getClass();
        timeRangeFilter.getClass();
        set.getClass();
    }
}
