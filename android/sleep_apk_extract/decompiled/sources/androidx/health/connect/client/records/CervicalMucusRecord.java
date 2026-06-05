package androidx.health.connect.client.records;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 &2\u00020\u0001:\u0001&B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\t\u001a\u00020\b8\u0006¢\u0006\u0012\n\u0004\b\t\u0010 \u0012\u0004\b\"\u0010#\u001a\u0004\b!\u0010\u0013R\u001d\u0010\n\u001a\u00020\b8\u0006¢\u0006\u0012\n\u0004\b\n\u0010 \u0012\u0004\b%\u0010#\u001a\u0004\b$\u0010\u0013¨\u0006'"}, d2 = {"Landroidx/health/connect/client/records/CervicalMucusRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "j$/time/Instant", "time", "j$/time/ZoneOffset", "zoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "", "appearance", "sensation", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;II)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getZoneOffset", "()Lj$/time/ZoneOffset;", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "I", "getAppearance", "getAppearance$annotations", "()V", "getSensation", "getSensation$annotations", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CervicalMucusRecord implements InstantaneousRecord {
    public static final Map<Integer, String> APPEARANCE_INT_TO_STRING_MAP;
    public static final Map<String, Integer> APPEARANCE_STRING_TO_INT_MAP;
    public static final Map<Integer, String> SENSATION_INT_TO_STRING_MAP;
    public static final Map<String, Integer> SENSATION_STRING_TO_INT_MAP;
    private final int appearance;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final int sensation;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("clear", 5), TuplesKt.to("creamy", 3), TuplesKt.to("dry", 1), TuplesKt.to("sticky", 2), TuplesKt.to("watery", 4), TuplesKt.to("unusual", 6));
        APPEARANCE_STRING_TO_INT_MAP = mapMapOf;
        APPEARANCE_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf);
        Map<String, Integer> mapMapOf2 = MapsKt.mapOf(TuplesKt.to("light", 1), TuplesKt.to("medium", 2), TuplesKt.to("heavy", 3));
        SENSATION_STRING_TO_INT_MAP = mapMapOf2;
        SENSATION_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf2);
    }

    public CervicalMucusRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, int i, int i2) {
        instant.getClass();
        metadata.getClass();
        this.time = instant;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.appearance = i;
        this.sensation = i2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(CervicalMucusRecord.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        CervicalMucusRecord cervicalMucusRecord = (CervicalMucusRecord) other;
        return Intrinsics.areEqual(getTime(), cervicalMucusRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), cervicalMucusRecord.getZoneOffset()) && this.appearance == cervicalMucusRecord.appearance && this.sensation == cervicalMucusRecord.sensation && Intrinsics.areEqual(getMetadata(), cervicalMucusRecord.getMetadata());
    }

    public final int getAppearance() {
        return this.appearance;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public final int getSensation() {
        return this.sensation;
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
        int iHashCode = getTime().hashCode() * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return getMetadata().hashCode() + ((((((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + this.appearance) * 31) + this.sensation) * 31);
    }

    public String toString() {
        return "CervicalMucusRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", appearance=" + this.appearance + ", sensation=" + this.sensation + ", metadata=" + getMetadata() + ')';
    }
}
