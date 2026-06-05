package androidx.health.connect.client.records;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.Instant;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0001 B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u001d\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\u0012\n\u0004\b\u0006\u0010\u001b\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001f\u0010\u000f¨\u0006!"}, d2 = {"Landroidx/health/connect/client/records/ExerciseSegment;", "", "j$/time/Instant", "startTime", SDKConstants.PARAM_END_TIME, "", "segmentType", "repetitions", "<init>", "(Lj$/time/Instant;Lj$/time/Instant;II)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "sessionType", "isCompatibleWith$connect_client_release", "(I)Z", "isCompatibleWith", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "getEndTime", "I", "getSegmentType", "getSegmentType$annotations", "()V", "getRepetitions", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExerciseSegment {
    private static final Set<Integer> EXERCISE_SEGMENTS;
    private static final Map<Integer, Set<Integer>> SESSION_TO_SEGMENTS_MAPPING;
    private static final Set<Integer> SWIMMING_SEGMENTS;
    private final Instant endTime;
    private final int repetitions;
    private final int segmentType;
    private final Instant startTime;
    private static final Set<Integer> UNIVERSAL_SESSION_TYPES = SetsKt.setOf((Object[]) new Integer[]{10, 36, 0});
    private static final Set<Integer> UNIVERSAL_SEGMENTS = SetsKt.setOf((Object[]) new Integer[]{38, 39, 44, 54, 0});

    static {
        Set<Integer> of = SetsKt.setOf((Object[]) new Integer[]{1, 2, 3, 4, 5, 6, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 23, 25, 26, 28, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 41, 42, 43, 48, 49, 50, 51, 63, 65});
        EXERCISE_SEGMENTS = of;
        Set<Integer> of2 = SetsKt.setOf((Object[]) new Integer[]{55, 56, 58, 57, 59, 61});
        SWIMMING_SEGMENTS = of2;
        Pair pair = TuplesKt.to(8, SetsKt.setOf(7));
        Pair pair2 = TuplesKt.to(9, SetsKt.setOf(8));
        Pair pair3 = TuplesKt.to(13, of);
        Pair pair4 = TuplesKt.to(25, SetsKt.setOf(21));
        Pair pair5 = TuplesKt.to(26, SetsKt.setOf((Object[]) new Integer[]{67, 8, 40, 24}));
        Pair pair6 = TuplesKt.to(34, of);
        Pair pair7 = TuplesKt.to(37, SetsKt.setOf((Object[]) new Integer[]{64, 66}));
        Pair pair8 = TuplesKt.to(48, SetsKt.setOf(40));
        Pair pair9 = TuplesKt.to(54, SetsKt.setOf(45));
        Pair pair10 = TuplesKt.to(56, SetsKt.setOf((Object[]) new Integer[]{46, 64}));
        Pair pair11 = TuplesKt.to(57, SetsKt.setOf(47));
        Pair pair12 = TuplesKt.to(70, of);
        Pair pair13 = TuplesKt.to(68, SetsKt.setOf(52));
        Pair pair14 = TuplesKt.to(69, SetsKt.setOf(53));
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        setCreateSetBuilder.add(60);
        setCreateSetBuilder.addAll(of2);
        Unit unit = Unit.INSTANCE;
        Pair pair15 = TuplesKt.to(73, SetsKt.build(setCreateSetBuilder));
        Set setCreateSetBuilder2 = SetsKt.createSetBuilder();
        setCreateSetBuilder2.add(62);
        setCreateSetBuilder2.addAll(of2);
        SESSION_TO_SEGMENTS_MAPPING = MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, pair15, TuplesKt.to(74, SetsKt.build(setCreateSetBuilder2)), TuplesKt.to(79, SetsKt.setOf(64)), TuplesKt.to(82, SetsKt.setOf(66)), TuplesKt.to(81, of), TuplesKt.to(83, SetsKt.setOf(67)));
    }

    public ExerciseSegment(Instant instant, Instant instant2, int i, int i2) {
        instant.getClass();
        instant2.getClass();
        this.startTime = instant;
        this.endTime = instant2;
        this.segmentType = i;
        this.repetitions = i2;
        if (!instant.isBefore(instant2)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("startTime must be before endTime.");
            throw null;
        }
        if (i2 >= 0) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("repetitions can not be negative.");
        throw null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExerciseSegment)) {
            return false;
        }
        ExerciseSegment exerciseSegment = (ExerciseSegment) other;
        return Intrinsics.areEqual(this.startTime, exerciseSegment.startTime) && Intrinsics.areEqual(this.endTime, exerciseSegment.endTime) && this.segmentType == exerciseSegment.segmentType && this.repetitions == exerciseSegment.repetitions;
    }

    public final Instant getEndTime() {
        return this.endTime;
    }

    public final int getRepetitions() {
        return this.repetitions;
    }

    public final int getSegmentType() {
        return this.segmentType;
    }

    public final Instant getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return Integer.hashCode(this.repetitions) + FileInsert$$ExternalSyntheticOutline0.m(this.segmentType, (this.endTime.hashCode() + (this.startTime.hashCode() * 31)) * 31, 31);
    }

    public final boolean isCompatibleWith$connect_client_release(int sessionType) {
        if (UNIVERSAL_SESSION_TYPES.contains(Integer.valueOf(sessionType)) || UNIVERSAL_SEGMENTS.contains(Integer.valueOf(this.segmentType))) {
            return true;
        }
        Set<Integer> set = SESSION_TO_SEGMENTS_MAPPING.get(Integer.valueOf(sessionType));
        if (set != null) {
            return set.contains(Integer.valueOf(this.segmentType));
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ExerciseSegment(startTime=");
        sb.append(this.startTime);
        sb.append(", endTime=");
        sb.append(this.endTime);
        sb.append(", segmentType=");
        sb.append(this.segmentType);
        sb.append(", repetitions=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.repetitions, ')');
    }
}
