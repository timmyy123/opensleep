package com.urbandroid.sleep.service.health.session;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.service.health.DataSourceProvider;
import com.urbandroid.sleep.service.health.HeathSyncKt;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u00012\u00020\u0002B5\b\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b\"\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\n\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b&\u0010\u0019R \u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R*\u0010.\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00158\u0016@TX\u0096\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b.\u0010\u0017\"\u0004\b0\u00101R*\u00102\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00158\u0016@TX\u0096\u000e¢\u0006\u0012\n\u0004\b2\u0010/\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u00101R\"\u00104\u001a\u00020\u00158\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u00101¨\u00066"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/AbstractHealthSession;", "Lcom/urbandroid/sleep/service/health/session/AbstractHealthInterval;", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "", "id", "Lcom/urbandroid/sleep/service/health/DataSourceProvider;", "provider", "Ljava/util/Date;", "from", "to", "timeZoneId", "<init>", "(Ljava/lang/String;Lcom/urbandroid/sleep/service/health/DataSourceProvider;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V", "", "markAsBroken", "()V", "markAsDuplicate", "Lcom/urbandroid/sleep/domain/interval/Interval;", "cutInterval", "toCutSession", "(Lcom/urbandroid/sleep/domain/interval/Interval;)Lcom/urbandroid/sleep/service/health/session/HealthSession;", "", "hasSegments", "()Z", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getId", "Lcom/urbandroid/sleep/service/health/DataSourceProvider;", "getProvider", "()Lcom/urbandroid/sleep/service/health/DataSourceProvider;", "getTimeZoneId", "", "Lcom/urbandroid/sleep/service/health/session/HealthSessionSegment;", "segments", "Ljava/util/List;", "getSegments", "()Ljava/util/List;", SDKConstants.PARAM_VALUE, "isBroken", "Z", "setBroken", "(Z)V", "isDuplicate", "setDuplicate", "isFinished", "setFinished", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AbstractHealthSession extends AbstractHealthInterval implements HealthSession {
    private final String id;
    private boolean isBroken;
    private boolean isDuplicate;
    private boolean isFinished;
    private final DataSourceProvider provider;
    private final List<HealthSessionSegment> segments;
    private final String timeZoneId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractHealthSession(String str, DataSourceProvider dataSourceProvider, Date date, Date date2, String str2) {
        super(date, date2);
        str.getClass();
        date.getClass();
        date2.getClass();
        str2.getClass();
        this.id = str;
        this.provider = dataSourceProvider;
        this.timeZoneId = str2;
        this.segments = new ArrayList();
        this.isFinished = true;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HealthSession) {
            return Intrinsics.areEqual(getId(), ((HealthSession) other).getId());
        }
        return false;
    }

    public String getId() {
        return this.id;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public DataSourceProvider getProvider() {
        return this.provider;
    }

    public List<HealthSessionSegment> getSegments() {
        return this.segments;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public String getTimeZoneId() {
        return this.timeZoneId;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean hasSegments() {
        return !getSegments().isEmpty();
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthInterval
    public int hashCode() {
        return getId().hashCode() + (super.hashCode() * 31);
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    /* JADX INFO: renamed from: isBroken, reason: from getter */
    public boolean getIsBroken() {
        return this.isBroken;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    /* JADX INFO: renamed from: isDuplicate, reason: from getter */
    public boolean getIsDuplicate() {
        return this.isDuplicate;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    /* JADX INFO: renamed from: isFinished, reason: from getter */
    public boolean getIsFinished() {
        return this.isFinished;
    }

    public void markAsBroken() {
        setBroken(true);
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public void markAsDuplicate() {
        setDuplicate(true);
    }

    public void setBroken(boolean z) {
        this.isBroken = z;
    }

    public void setDuplicate(boolean z) {
        this.isDuplicate = z;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public HealthSession toCutSession(Interval cutInterval) {
        cutInterval.getClass();
        String id = getId();
        long jMax = Math.max(getFromInMillis(), cutInterval.getFrom());
        long jMin = Math.min(getToInMillis(), cutInterval.getTo());
        String activity = getActivity();
        activity.getClass();
        return new BaseHealthSession(id, jMax, jMin, activity);
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        DataSourceProvider provider = getProvider();
        String id = getId();
        String activity = getActivity();
        String prettyMillis = HeathSyncKt.getPrettyMillis(getFrom().getTime());
        String prettyMillis2 = HeathSyncKt.getPrettyMillis(getTo().getTime());
        String strPretty = HeathSyncKt.pretty(CollectionsKt.sortedWith(getSegments(), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1()));
        StringBuilder sb = new StringBuilder();
        sb.append(simpleName);
        sb.append("{provider=");
        sb.append(provider);
        sb.append(", id=");
        sb.append(id);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", activity=", activity, ", from=", prettyMillis);
        FileInsert$$ExternalSyntheticOutline0.m(sb, ", to=", prettyMillis2, ", segments=", strPretty);
        sb.append("}");
        return sb.toString().concat("\n");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbstractHealthSession(String str, DataSourceProvider dataSourceProvider, Date date, Date date2) {
        this(str, dataSourceProvider, date, date2, null, 16, null);
        str.getClass();
        date.getClass();
        date2.getClass();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AbstractHealthSession(String str, DataSourceProvider dataSourceProvider, Date date, Date date2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 16) != 0) {
            str2 = TimeZone.getDefault().getID();
            str2.getClass();
        }
        this(str, dataSourceProvider, date, date2, str2);
    }
}
