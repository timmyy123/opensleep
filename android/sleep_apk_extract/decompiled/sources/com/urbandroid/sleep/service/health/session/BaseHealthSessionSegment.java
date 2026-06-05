package com.urbandroid.sleep.service.health.session;

import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/BaseHealthSessionSegment;", "Lcom/urbandroid/sleep/service/health/session/AbstractHealthSessionSegment;", "Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "segmentType", "Ljava/util/Date;", "from", "to", "<init>", "(Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;Ljava/util/Date;Ljava/util/Date;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BaseHealthSessionSegment extends AbstractHealthSessionSegment {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseHealthSessionSegment(SleepSegmentType sleepSegmentType, Date date, Date date2) {
        super(sleepSegmentType, date, date2);
        date.getClass();
        date2.getClass();
    }
}
