package androidx.health.connect.client.records;

import androidx.health.connect.client.units.BloodGlucose;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u0000 .2\u00020\u0001:\u0001.BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\u0012\n\u0004\b\u000b\u0010&\u0012\u0004\b(\u0010)\u001a\u0004\b'\u0010\u0016R\u001d\u0010\f\u001a\u00020\n8\u0006¢\u0006\u0012\n\u0004\b\f\u0010&\u0012\u0004\b+\u0010)\u001a\u0004\b*\u0010\u0016R\u001d\u0010\r\u001a\u00020\n8\u0006¢\u0006\u0012\n\u0004\b\r\u0010&\u0012\u0004\b-\u0010)\u001a\u0004\b,\u0010\u0016¨\u0006/"}, d2 = {"Landroidx/health/connect/client/records/BloodGlucoseRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "j$/time/Instant", "time", "j$/time/ZoneOffset", "zoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "Landroidx/health/connect/client/units/BloodGlucose;", "level", "", "specimenSource", "mealType", "relationToMeal", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Landroidx/health/connect/client/units/BloodGlucose;III)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getZoneOffset", "()Lj$/time/ZoneOffset;", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "Landroidx/health/connect/client/units/BloodGlucose;", "getLevel", "()Landroidx/health/connect/client/units/BloodGlucose;", "I", "getSpecimenSource", "getSpecimenSource$annotations", "()V", "getMealType", "getMealType$annotations", "getRelationToMeal", "getRelationToMeal$annotations", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BloodGlucoseRecord implements InstantaneousRecord {
    private static final BloodGlucose MAX_BLOOD_GLUCOSE_LEVEL = BloodGlucose.INSTANCE.millimolesPerLiter(50.0d);
    public static final Map<Integer, String> RELATION_TO_MEAL_INT_TO_STRING_MAP;
    public static final Map<String, Integer> RELATION_TO_MEAL_STRING_TO_INT_MAP;
    public static final Map<Integer, String> SPECIMEN_SOURCE_INT_TO_STRING_MAP;
    public static final Map<String, Integer> SPECIMEN_SOURCE_STRING_TO_INT_MAP;
    private final BloodGlucose level;
    private final int mealType;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final int relationToMeal;
    private final int specimenSource;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("general", 1), TuplesKt.to("after_meal", 4), TuplesKt.to("fasting", 2), TuplesKt.to("before_meal", 3));
        RELATION_TO_MEAL_STRING_TO_INT_MAP = mapMapOf;
        RELATION_TO_MEAL_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf);
        Map<String, Integer> mapMapOf2 = MapsKt.mapOf(TuplesKt.to("interstitial_fluid", 1), TuplesKt.to("capillary_blood", 2), TuplesKt.to("plasma", 3), TuplesKt.to("tears", 5), TuplesKt.to("whole_blood", 6), TuplesKt.to("serum", 4));
        SPECIMEN_SOURCE_STRING_TO_INT_MAP = mapMapOf2;
        SPECIMEN_SOURCE_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf2);
    }

    public BloodGlucoseRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, BloodGlucose bloodGlucose, int i, int i2, int i3) {
        instant.getClass();
        metadata.getClass();
        bloodGlucose.getClass();
        this.time = instant;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.level = bloodGlucose;
        this.specimenSource = i;
        this.mealType = i2;
        this.relationToMeal = i3;
        UtilsKt.requireNotLess(bloodGlucose, bloodGlucose.zero$connect_client_release(), "level");
        UtilsKt.requireNotMore(bloodGlucose, MAX_BLOOD_GLUCOSE_LEVEL, "level");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(BloodGlucoseRecord.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        BloodGlucoseRecord bloodGlucoseRecord = (BloodGlucoseRecord) other;
        return Intrinsics.areEqual(getTime(), bloodGlucoseRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), bloodGlucoseRecord.getZoneOffset()) && Intrinsics.areEqual(this.level, bloodGlucoseRecord.level) && this.specimenSource == bloodGlucoseRecord.specimenSource && this.mealType == bloodGlucoseRecord.mealType && this.relationToMeal == bloodGlucoseRecord.relationToMeal && Intrinsics.areEqual(getMetadata(), bloodGlucoseRecord.getMetadata());
    }

    public final BloodGlucose getLevel() {
        return this.level;
    }

    public final int getMealType() {
        return this.mealType;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public final int getRelationToMeal() {
        return this.relationToMeal;
    }

    public final int getSpecimenSource() {
        return this.specimenSource;
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
        return getMetadata().hashCode() + ((((((((this.level.hashCode() + ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31)) * 31) + this.specimenSource) * 31) + this.mealType) * 31) + this.relationToMeal) * 31);
    }

    public String toString() {
        return "BloodGlucoseRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", level=" + this.level + ", specimenSource=" + this.specimenSource + ", mealType=" + this.mealType + ", relationToMeal=" + this.relationToMeal + ", metadata=" + getMetadata() + ')';
    }
}
