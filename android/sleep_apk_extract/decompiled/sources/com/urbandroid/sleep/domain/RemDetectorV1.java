package com.urbandroid.sleep.domain;

import com.facebook.internal.AnalyticsEvents;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/domain/RemDetectorV1;", "Lcom/urbandroid/sleep/domain/RemDetector;", "Lkotlin/Function0;", "", "clock", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "", "reset", "()V", "handleDeepSleep", "handleLightSleep", "handleAwake", "Lkotlin/jvm/functions/Function0;", "Lcom/urbandroid/sleep/domain/RemDetectorV1$Status;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "Lcom/urbandroid/sleep/domain/RemDetectorV1$Status;", "deepStart", "J", "lightStart", "Status", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RemDetectorV1 implements RemDetector {
    private final Function0<Long> clock;
    private long deepStart;
    private long lightStart;
    private Status status;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/domain/RemDetectorV1$Status;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "DEEP", "LIGHT", "REM", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Status INIT = new Status("INIT", 0);
        public static final Status DEEP = new Status("DEEP", 1);
        public static final Status LIGHT = new Status("LIGHT", 2);
        public static final Status REM = new Status("REM", 3);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{INIT, DEEP, LIGHT, REM};
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

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.DEEP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.LIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Status.REM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RemDetectorV1(Function0<Long> function0) {
        function0.getClass();
        this.clock = function0;
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("RemDetectorV1:"), FrequencyGuards.maxCountPerInterval(60, 20), 0, 4, null));
        this.status = Status.INIT;
    }

    private final void reset() {
        Status status = this.status;
        Status status2 = Status.INIT;
        if (status != status2) {
            Logger.logInfo("RemDetectorV1: reset: " + status + " -> INIT");
            this.status = status2;
        }
    }

    @Override // com.urbandroid.sleep.domain.RemDetector
    public void handleAwake() {
        Logger.logInfo("RemDetectorV1: awake");
        reset();
    }

    @Override // com.urbandroid.sleep.domain.RemDetector
    public void handleDeepSleep() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.status.ordinal()];
        if (i != 1) {
            if (i != 2) {
                reset();
            }
        } else {
            Logger.logInfo("RemDetectorV1: rem status: INIT -> DEEP");
            this.deepStart = this.clock.invoke().longValue() - RemDetectorsKt.minutes(5);
            this.status = Status.DEEP;
        }
    }

    @Override // com.urbandroid.sleep.domain.RemDetector
    public void handleLightSleep() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.status.ordinal()];
        if (i == 2) {
            if (this.clock.invoke().longValue() - this.deepStart <= RemDetectorsKt.minutes(15)) {
                reset();
                return;
            }
            Logger.logInfo("RemDetectorV1: rem status: DEEP -> LIGHT");
            this.lightStart = this.clock.invoke().longValue();
            this.status = Status.LIGHT;
            return;
        }
        if (i == 3) {
            if (this.clock.invoke().longValue() - this.lightStart > RemDetectorsKt.minutes(10)) {
                Logger.logInfo("RemDetectorV1: rem status: LIGHT -> REM, Lucid trigger 1");
                this.status = Status.REM;
                RemDetectorsKt.fireLucidCue(this.clock.invoke().longValue());
                return;
            }
            return;
        }
        if (i != 4) {
            reset();
        } else if (this.clock.invoke().longValue() - this.lightStart > RemDetectorsKt.minutes(20)) {
            Logger.logInfo("RemDetectorV1: Lucid trigger 2");
            RemDetectorsKt.fireLucidCue(this.clock.invoke().longValue());
            reset();
        }
    }
}
