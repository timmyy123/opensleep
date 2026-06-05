package com.urbandroid.sleep.service.google.calendar;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.health.session.idresolver.IdResolver;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/FromToZeroMillisIdResolver;", "Lcom/urbandroid/sleep/service/health/session/idresolver/IdResolver;", "<init>", "()V", "resolveId", "", "record", "Lcom/urbandroid/sleep/domain/SleepRecord;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FromToZeroMillisIdResolver implements IdResolver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/FromToZeroMillisIdResolver$Companion;", "", "<init>", "()V", "", "time", "zeroMillis", "(J)J", "from", "to", "", "resolveId", "(JJ)Ljava/lang/String;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final long zeroMillis(long time) {
            return (time / 1000) * 1000;
        }

        public final String resolveId(long from, long to) {
            long jZeroMillis = zeroMillis(from);
            long jZeroMillis2 = zeroMillis(to);
            StringBuilder sb = new StringBuilder();
            sb.append(jZeroMillis);
            sb.append(jZeroMillis2);
            return sb.toString();
        }

        private Companion() {
        }
    }

    @Override // com.urbandroid.sleep.service.health.session.idresolver.IdResolver
    public String resolveId(SleepRecord record) {
        record.getClass();
        Date to = record.getTo();
        if (to != null) {
            return INSTANCE.resolveId(record.getFrom().getTime(), to.getTime());
        }
        return null;
    }
}
