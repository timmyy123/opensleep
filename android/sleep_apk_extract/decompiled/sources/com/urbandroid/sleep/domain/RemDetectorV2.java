package com.urbandroid.sleep.domain;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.internal.AnalyticsEvents;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import java.util.Date;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/urbandroid/sleep/domain/RemDetectorV2;", "Lcom/urbandroid/sleep/domain/RemDetector;", "clock", "Lkotlin/Function0;", "", "deepWindow", "minDeepLength", "maxAwakeLength", "maxLucidCuesCount", "", "<init>", "(Lkotlin/jvm/functions/Function0;JJJI)V", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "Lcom/urbandroid/sleep/domain/RemDetectorV2$Status;", "lucidCuesFiredCount", "lucidCueIntervalStart", "sleepStart", "deepIntervals", "Lcom/urbandroid/sleep/domain/Intervals;", "lightIntervals", "awakeIntervals", "handleDeepSleep", "", "handleLightSleep", "lastDetailedStatusLog", "evaluateRemAndSendCues", "now", "handleAwake", "getStatusInfo", "", "Status", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RemDetectorV2 implements RemDetector {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Intervals awakeIntervals;
    private final Function0<Long> clock;
    private final Intervals deepIntervals;
    private final long deepWindow;
    private long lastDetailedStatusLog;
    private final Intervals lightIntervals;
    private long lucidCueIntervalStart;
    private int lucidCuesFiredCount;
    private final long maxAwakeLength;
    private final int maxLucidCuesCount;
    private final long minDeepLength;
    private final long sleepStart;
    private Status status;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/domain/RemDetectorV2$Companion;", "", "<init>", "()V", "newInstanceLowSensitivity", "Lcom/urbandroid/sleep/domain/RemDetectorV2;", "clock", "Lkotlin/Function0;", "", "newInstanceMediumSensitivity", "newInstanceHighSensitivity", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RemDetectorV2 newInstanceHighSensitivity(Function0<Long> clock) {
            clock.getClass();
            return new RemDetectorV2(clock, RemDetectorsKt.minutes(20), RemDetectorsKt.minutes(5), RemDetectorsKt.minutes(7), 3);
        }

        public final RemDetectorV2 newInstanceLowSensitivity(Function0<Long> clock) {
            clock.getClass();
            return new RemDetectorV2(clock, RemDetectorsKt.minutes(15), RemDetectorsKt.minutes(13), 0L, 2);
        }

        public final RemDetectorV2 newInstanceMediumSensitivity(Function0<Long> clock) {
            clock.getClass();
            return new RemDetectorV2(clock, RemDetectorsKt.minutes(20), RemDetectorsKt.minutes(9), 0L, 2);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/domain/RemDetectorV2$Status;", "", "<init>", "(Ljava/lang/String;I)V", "DEEP", "LIGHT", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Status DEEP = new Status("DEEP", 0);
        public static final Status LIGHT = new Status("LIGHT", 1);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{DEEP, LIGHT};
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
        }

        private Status(String str, int i) {
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    public RemDetectorV2(Function0<Long> function0, long j, long j2, long j3, int i) {
        function0.getClass();
        this.clock = function0;
        this.deepWindow = j;
        this.minDeepLength = j2;
        this.maxAwakeLength = j3;
        this.maxLucidCuesCount = i;
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("RemDetectorV2:"), FrequencyGuards.maxCountPerInterval(60, 20), 0, 4, null));
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("RemDetectorV2: created: deepWindow", ", minDeepLength=", j);
        sbM.append(j2);
        zzba$$ExternalSyntheticOutline0.m(sbM, ", maxAwakeLength=", j3, ", maxLucidCuesCount=");
        zza$$ExternalSyntheticOutline0.m(sbM, i);
        this.status = Status.LIGHT;
        this.deepIntervals = new Intervals();
        Intervals intervals = new Intervals();
        this.lightIntervals = intervals;
        this.awakeIntervals = new Intervals();
        long jLongValue = function0.invoke().longValue();
        intervals.add(jLongValue, jLongValue);
        this.lucidCueIntervalStart = jLongValue;
        this.sleepStart = jLongValue;
    }

    private final void evaluateRemAndSendCues(long now) {
        if (now - this.lastDetailedStatusLog > RemDetectorsKt.minutes(60)) {
            zza$$ExternalSyntheticOutline0.m(">>> ", getStatusInfo());
            this.lastDetailedStatusLog = now;
        }
        if (now - this.sleepStart >= RemDetectorsKt.minutes(55) && this.lucidCuesFiredCount < this.maxLucidCuesCount) {
            if (now - this.lucidCueIntervalStart < RemDetectorsKt.minutes(10)) {
                return;
            }
            if ((this.awakeIntervals.isEmpty() || now - this.awakeIntervals.last().getTo() >= RemDetectorsKt.minutes(5)) && this.awakeIntervals.intersectionLength(this.lightIntervals.last()) <= this.maxAwakeLength) {
                long from = this.lightIntervals.last().getFrom();
                if (this.deepIntervals.intersectionLength(from - this.deepWindow, from) < this.minDeepLength) {
                    return;
                }
                Logger.logInfo("RemDetectorV2: fire lucid cue " + this.lucidCuesFiredCount + " " + new Date(this.lucidCueIntervalStart));
                RemDetectorsKt.fireLucidCue(now);
                this.lucidCuesFiredCount = this.lucidCuesFiredCount + 1;
                this.lucidCueIntervalStart = now;
            }
        }
    }

    public String getStatusInfo() {
        return "RemDetectorV2(status=" + this.status + ", lucidCuesFiredCount=" + this.lucidCuesFiredCount + ", lucidCueIntervalStart=" + this.lucidCueIntervalStart + ", deep=" + this.deepIntervals + ", light=" + this.lightIntervals + ", awake=" + this.awakeIntervals + ")";
    }

    @Override // com.urbandroid.sleep.domain.RemDetector
    public void handleAwake() {
        try {
            long jLongValue = this.clock.invoke().longValue();
            long jMinutes = RemDetectorsKt.minutes(3);
            if (this.awakeIntervals.isEmpty()) {
                Logger.logInfo("RemDetectorV2: AWAKE");
                this.awakeIntervals.add(jLongValue - jMinutes, jLongValue);
            } else if (jLongValue - this.awakeIntervals.last().getTo() <= jMinutes) {
                this.awakeIntervals.extendLast(jLongValue);
            } else {
                Logger.logInfo("RemDetectorV2: AWAKE");
                this.awakeIntervals.add(jLongValue - jMinutes, jLongValue);
            }
        } catch (RuntimeException e) {
            Logger.logSevere("RemDetectorV2: handleAwake", e);
        }
    }

    @Override // com.urbandroid.sleep.domain.RemDetector
    public void handleDeepSleep() {
        try {
            long jLongValue = this.clock.invoke().longValue();
            Status status = this.status;
            Status status2 = Status.DEEP;
            if (status == status2) {
                this.deepIntervals.extendLast(jLongValue);
                return;
            }
            Logger.logInfo("RemDetectorV2: DEEP");
            this.status = status2;
            this.deepIntervals.add(jLongValue - RemDetectorsKt.minutes(5), jLongValue);
        } catch (RuntimeException e) {
            Logger.logSevere("RemDetectorV2: handleDeepSleep", e);
        }
    }

    @Override // com.urbandroid.sleep.domain.RemDetector
    public void handleLightSleep() {
        try {
            long jLongValue = this.clock.invoke().longValue();
            Status status = this.status;
            Status status2 = Status.LIGHT;
            if (status == status2) {
                this.lightIntervals.extendLast(jLongValue);
                evaluateRemAndSendCues(jLongValue);
                return;
            }
            Logger.logInfo("RemDetectorV2: LIGHT");
            this.status = status2;
            long jSeconds = jLongValue - RemDetectorsKt.seconds(10);
            this.lightIntervals.add(jSeconds, jLongValue);
            this.lucidCuesFiredCount = 0;
            this.lucidCueIntervalStart = jSeconds;
        } catch (RuntimeException e) {
            Logger.logSevere("RemDetectorV2: handleLightSleep", e);
        }
    }
}
