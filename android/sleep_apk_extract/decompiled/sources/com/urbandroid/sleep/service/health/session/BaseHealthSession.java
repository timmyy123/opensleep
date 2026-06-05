package com.urbandroid.sleep.service.health.session;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.health.HealthDataSourceProvider;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/BaseHealthSession;", "Lcom/urbandroid/sleep/service/health/session/AbstractHealthSession;", "", "id", "", "from", "to", "activity", "<init>", "(Ljava/lang/String;JJLjava/lang/String;)V", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V", "Lcom/urbandroid/sleep/domain/SleepRecord;", "toSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "Ljava/lang/String;", "getActivity", "()Ljava/lang/String;", "", "isWalkingActivity", "()Z", "isSportActivity", "isSleepActivity", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BaseHealthSession extends AbstractHealthSession {
    private final String activity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseHealthSession(String str, Date date, Date date2, String str2) {
        super(str, HealthDataSourceProvider.SLEEP, date, date2, null, 16, null);
        str.getClass();
        date.getClass();
        date2.getClass();
        str2.getClass();
        this.activity = str2;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public String getActivity() {
        return this.activity;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSleepActivity() {
        throw new UnsupportedOperationException();
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSportActivity() {
        throw new UnsupportedOperationException();
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isWalkingActivity() {
        throw new UnsupportedOperationException();
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public SleepRecord toSleepRecord() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseHealthSession(String str, long j, long j2, String str2) {
        this(str, new Date(j), new Date(j2), str2);
        str.getClass();
        str2.getClass();
    }
}
