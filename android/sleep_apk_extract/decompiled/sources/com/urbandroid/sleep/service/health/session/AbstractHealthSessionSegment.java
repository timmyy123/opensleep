package com.urbandroid.sleep.service.health.session;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.sleep.service.health.HeathSyncKt;
import java.util.Date;
import kotlin.Metadata;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0082\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/AbstractHealthSessionSegment;", "Lcom/urbandroid/sleep/service/health/session/AbstractHealthInterval;", "Lcom/urbandroid/sleep/service/health/session/HealthSessionSegment;", "sleepSegmentType", "Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "from", "Ljava/util/Date;", "to", "<init>", "(Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;Ljava/util/Date;Ljava/util/Date;)V", "getSleepSegmentType", "()Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", InAppPurchaseConstants.METHOD_TO_STRING, "", "equals", "", "other", "", "hashCode", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AbstractHealthSessionSegment extends AbstractHealthInterval implements HealthSessionSegment {
    private final SleepSegmentType sleepSegmentType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractHealthSessionSegment(SleepSegmentType sleepSegmentType, Date date, Date date2) {
        super(date, date2);
        date.getClass();
        date2.getClass();
        this.sleepSegmentType = sleepSegmentType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbstractHealthSessionSegment)) {
            return false;
        }
        AbstractHealthSessionSegment abstractHealthSessionSegment = (AbstractHealthSessionSegment) other;
        return getSleepSegmentType() == abstractHealthSessionSegment.getSleepSegmentType() && getSleepSegmentType() != null && getFrom().getTime() == abstractHealthSessionSegment.getFrom().getTime() && getTo().getTime() == abstractHealthSessionSegment.getTo().getTime();
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSessionSegment
    public SleepSegmentType getSleepSegmentType() {
        return this.sleepSegmentType;
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthInterval
    public int hashCode() {
        SleepSegmentType sleepSegmentType = getSleepSegmentType();
        int iHashCode = sleepSegmentType != null ? sleepSegmentType.hashCode() : 0;
        return getTo().hashCode() + ((getFrom().hashCode() + (iHashCode * 31)) * 31);
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSessionSegment
    /* JADX INFO: renamed from: short, reason: not valid java name */
    public /* bridge */ String mo2047short() {
        return super.mo2047short();
    }

    public String toString() {
        return Fragment$$ExternalSyntheticOutline1.m(mo2047short(), " ", HeathSyncKt.getPrettyTime(getFrom().getTime()), MqttTopic.TOPIC_LEVEL_SEPARATOR, HeathSyncKt.getPrettyTime(getTo().getTime()));
    }
}
