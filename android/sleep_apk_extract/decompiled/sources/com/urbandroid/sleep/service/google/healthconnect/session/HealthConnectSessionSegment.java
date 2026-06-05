package com.urbandroid.sleep.service.google.healthconnect.session;

import androidx.health.connect.client.records.SleepSessionRecord;
import com.urbandroid.sleep.service.google.healthconnect.HealthConnectSleepSegmentTypeKt;
import com.urbandroid.sleep.service.health.session.AbstractHealthSessionSegment;
import com.urbandroid.sleep.service.health.session.SleepSegmentType;
import j$.util.DesugarDate;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/service/google/healthconnect/session/HealthConnectSessionSegment;", "Lcom/urbandroid/sleep/service/health/session/AbstractHealthSessionSegment;", "Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "segmentType", "Ljava/util/Date;", "start", "end", "<init>", "(Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;Ljava/util/Date;Ljava/util/Date;)V", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthConnectSessionSegment extends AbstractHealthSessionSegment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/service/google/healthconnect/session/HealthConnectSessionSegment$Companion;", "", "<init>", "()V", "fromHealthConnectSleepStage", "Lcom/urbandroid/sleep/service/google/healthconnect/session/HealthConnectSessionSegment;", "stage", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HealthConnectSessionSegment fromHealthConnectSleepStage(SleepSessionRecord.Stage stage) {
            stage.getClass();
            SleepSegmentType sleepSegmentType = HealthConnectSleepSegmentTypeKt.toSleepSegmentType(stage.getStage());
            Date dateFrom = DesugarDate.from(stage.getStartTime());
            dateFrom.getClass();
            Date dateFrom2 = DesugarDate.from(stage.getEndTime());
            dateFrom2.getClass();
            return new HealthConnectSessionSegment(sleepSegmentType, dateFrom, dateFrom2);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthConnectSessionSegment(SleepSegmentType sleepSegmentType, Date date, Date date2) {
        super(sleepSegmentType, date, date2);
        date.getClass();
        date2.getClass();
    }
}
