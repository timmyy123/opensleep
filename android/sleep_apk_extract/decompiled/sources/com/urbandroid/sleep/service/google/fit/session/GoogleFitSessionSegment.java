package com.urbandroid.sleep.service.google.fit.session;

import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Value;
import com.urbandroid.sleep.service.google.fit.GoogleFitSleepSegmentType;
import com.urbandroid.sleep.service.google.fit.GoogleFitSleepSegmentTypeKt;
import com.urbandroid.sleep.service.health.session.AbstractHealthSessionSegment;
import com.urbandroid.sleep.service.health.session.SleepSegmentType;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/service/google/fit/session/GoogleFitSessionSegment;", "Lcom/urbandroid/sleep/service/health/session/AbstractHealthSessionSegment;", "Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "segmentType", "Ljava/util/Date;", "start", "end", "<init>", "(Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;Ljava/util/Date;Ljava/util/Date;)V", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleFitSessionSegment extends AbstractHealthSessionSegment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/service/google/fit/session/GoogleFitSessionSegment$Companion;", "", "<init>", "()V", "create", "Lcom/urbandroid/sleep/service/google/fit/session/GoogleFitSessionSegment;", "dataPoint", "Lcom/google/android/gms/fitness/data/DataPoint;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GoogleFitSessionSegment create(DataPoint dataPoint) {
            dataPoint.getClass();
            Value value = dataPoint.getValue(Field.FIELD_SLEEP_SEGMENT_TYPE);
            value.getClass();
            String strAsActivity = value.asActivity();
            strAsActivity.getClass();
            SleepSegmentType sleepSegmentTypeFindByName = GoogleFitSleepSegmentType.findByName(strAsActivity);
            if (sleepSegmentTypeFindByName == null) {
                sleepSegmentTypeFindByName = GoogleFitSleepSegmentTypeKt.toSleepSegmentType(value.asInt());
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return new GoogleFitSessionSegment(sleepSegmentTypeFindByName, new Date(dataPoint.getStartTime(timeUnit)), new Date(dataPoint.getEndTime(timeUnit)));
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitSessionSegment(SleepSegmentType sleepSegmentType, Date date, Date date2) {
        super(sleepSegmentType, date, date2);
        date.getClass();
        date2.getClass();
    }

    public static final GoogleFitSessionSegment create(DataPoint dataPoint) {
        return INSTANCE.create(dataPoint);
    }
}
