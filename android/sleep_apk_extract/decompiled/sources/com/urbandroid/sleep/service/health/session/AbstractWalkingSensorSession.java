package com.urbandroid.sleep.service.health.session;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.service.health.HealthDataSourceProvider;
import com.urbandroid.sleep.service.health.session.idresolver.FromToIdResolver;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/AbstractWalkingSensorSession;", "Lcom/urbandroid/sleep/service/health/session/AbstractHealthSession;", "Lcom/urbandroid/sleep/service/health/session/WalkingSensorSession;", "from", "", "to", "steps", "", "provider", "Lcom/urbandroid/sleep/service/health/HealthDataSourceProvider;", "<init>", "(JJILcom/urbandroid/sleep/service/health/HealthDataSourceProvider;)V", "getSteps", "()I", "toSleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "isSportActivity", "", "()Z", "isWalkingActivity", "isSleepActivity", "format", "Ljava/text/SimpleDateFormat;", "toWalkingEventInterval", "Lcom/urbandroid/sleep/domain/interval/EventInterval;", InAppPurchaseConstants.METHOD_TO_STRING, "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AbstractWalkingSensorSession extends AbstractHealthSession implements WalkingSensorSession {
    private final SimpleDateFormat format;
    private final int steps;

    public AbstractWalkingSensorSession(long j, long j2, int i, HealthDataSourceProvider healthDataSourceProvider) {
        super(FileInsert$$ExternalSyntheticOutline0.m("WalkingSensor", FromToIdResolver.resolveId(j, j2)), healthDataSourceProvider, new Date(j), new Date(j2), null, 16, null);
        this.steps = i;
        this.format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Override // com.urbandroid.sleep.service.health.session.WalkingSensorSession
    public int getSteps() {
        return this.steps;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSleepActivity() {
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSportActivity() {
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isWalkingActivity() {
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public SleepRecord toSleepRecord() {
        throw new UnsupportedOperationException();
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthSession
    public String toString() {
        String simpleName = getClass().getSimpleName();
        int steps = getSteps();
        String str = this.format.format(getFrom());
        String str2 = this.format.format(getTo());
        StringBuilder sb = new StringBuilder();
        sb.append(simpleName);
        sb.append("{steps=");
        sb.append(steps);
        sb.append(",from=");
        sb.append(str);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ",to=", str2, "}");
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthInterval, com.urbandroid.sleep.service.health.session.HealthInterval
    public EventInterval toWalkingEventInterval() {
        return new EventInterval(new Event(getFromInMillis(), EventLabel.WALKING_START), new Event(getToInMillis(), EventLabel.WALKING_END));
    }
}
