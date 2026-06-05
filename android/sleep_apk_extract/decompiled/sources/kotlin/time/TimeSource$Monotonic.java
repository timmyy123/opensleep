package kotlin.time;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"kotlin/time/TimeSource$Monotonic", "Lkotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "markNow", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "ValueTimeMark", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TimeSource$Monotonic implements TimeSource$WithComparableMarks {
    public static final TimeSource$Monotonic INSTANCE = new TimeSource$Monotonic();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0006\u0088\u0001\u0004\u0092\u0001\u00060\u0002j\u0002`\u0003¨\u0006\n"}, d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "", "", "Lkotlin/time/ValueTimeMarkReading;", "reading", "constructor-impl", "(J)J", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "elapsedNow", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ValueTimeMark implements Comparable {
        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m2566constructorimpl(long j) {
            return j;
        }

        /* JADX INFO: renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
        public static long m2567elapsedNowUwyO8pc(long j) {
            return MonotonicTimeSource.INSTANCE.m2563elapsedFrom6eNON_k(j);
        }
    }

    private TimeSource$Monotonic() {
    }

    /* JADX INFO: renamed from: markNow-z9LOYto, reason: not valid java name */
    public long m2565markNowz9LOYto() {
        return MonotonicTimeSource.INSTANCE.m2564markNowz9LOYto();
    }

    public String toString() {
        return MonotonicTimeSource.INSTANCE.toString();
    }
}
