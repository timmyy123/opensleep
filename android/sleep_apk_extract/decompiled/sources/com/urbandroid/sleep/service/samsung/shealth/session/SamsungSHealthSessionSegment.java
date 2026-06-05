package com.urbandroid.sleep.service.samsung.shealth.session;

import com.urbandroid.sleep.service.health.session.AbstractHealthSessionSegment;
import com.urbandroid.sleep.service.health.session.SleepSegmentType;
import com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthSleepSegmentType;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/service/samsung/shealth/session/SamsungSHealthSessionSegment;", "Lcom/urbandroid/sleep/service/health/session/AbstractHealthSessionSegment;", "Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "segmentType", "Ljava/util/Date;", "from", "to", "<init>", "(Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;Ljava/util/Date;Ljava/util/Date;)V", "", "activity", "Ljava/lang/String;", "getActivity", "()Ljava/lang/String;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SamsungSHealthSessionSegment extends AbstractHealthSessionSegment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String activity;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/service/samsung/shealth/session/SamsungSHealthSessionSegment$Companion;", "", "<init>", "()V", "create", "Lcom/urbandroid/sleep/service/samsung/shealth/session/SamsungSHealthSessionSegment;", "sleepStage", "", "start", "", "end", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SamsungSHealthSessionSegment create(int sleepStage, long start, long end) {
            return new SamsungSHealthSessionSegment(SamsungSHealthSleepSegmentType.find(sleepStage), new Date(start), new Date(end));
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SamsungSHealthSessionSegment(SleepSegmentType sleepSegmentType, Date date, Date date2) {
        super(sleepSegmentType, date, date2);
        date.getClass();
        date2.getClass();
        SleepSegmentType sleepSegmentType2 = getSleepSegmentType();
        this.activity = sleepSegmentType2 != null ? sleepSegmentType2.name() : null;
    }

    public static final SamsungSHealthSessionSegment create(int i, long j, long j2) {
        return INSTANCE.create(i, j, j2);
    }
}
