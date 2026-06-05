package com.urbandroid.sleep.service.health.session;

import com.urbandroid.sleep.domain.EventLabel;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "", "startLabel", "Lcom/urbandroid/sleep/domain/EventLabel;", "endLabel", "<init>", "(Ljava/lang/String;ILcom/urbandroid/sleep/domain/EventLabel;Lcom/urbandroid/sleep/domain/EventLabel;)V", "getStartLabel", "()Lcom/urbandroid/sleep/domain/EventLabel;", "getEndLabel", "LIGHT", "DEEP", "REM", "AWAKE", "AWAKE_PAUSED", "AWAKE_WALKING", "code", "", "getCode", "()C", "normalize", "isAwake", "", "()Z", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepSegmentType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SleepSegmentType[] $VALUES;
    private final char code = StringsKt.first(name());
    private final EventLabel endLabel;
    private final EventLabel startLabel;
    public static final SleepSegmentType LIGHT = new SleepSegmentType("LIGHT", 0, EventLabel.LIGHT_START, EventLabel.LIGHT_END);
    public static final SleepSegmentType DEEP = new SleepSegmentType("DEEP", 1, EventLabel.DEEP_START, EventLabel.DEEP_END);
    public static final SleepSegmentType REM = new SleepSegmentType("REM", 2, EventLabel.REM_START, EventLabel.REM_END);
    public static final SleepSegmentType AWAKE = new SleepSegmentType("AWAKE", 3, EventLabel.AWAKE_START, EventLabel.AWAKE_END);
    public static final SleepSegmentType AWAKE_PAUSED = new SleepSegmentType("AWAKE_PAUSED", 4, EventLabel.TRACKING_PAUSED, EventLabel.TRACKING_RESUMED);
    public static final SleepSegmentType AWAKE_WALKING = new SleepSegmentType("AWAKE_WALKING", 5, EventLabel.WALKING_START, EventLabel.WALKING_END);

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SleepSegmentType.values().length];
            try {
                iArr[SleepSegmentType.AWAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SleepSegmentType.AWAKE_WALKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ SleepSegmentType[] $values() {
        return new SleepSegmentType[]{LIGHT, DEEP, REM, AWAKE, AWAKE_PAUSED, AWAKE_WALKING};
    }

    static {
        SleepSegmentType[] sleepSegmentTypeArr$values = $values();
        $VALUES = sleepSegmentTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sleepSegmentTypeArr$values);
        INSTANCE = new Companion(null);
    }

    private SleepSegmentType(String str, int i, EventLabel eventLabel, EventLabel eventLabel2) {
        this.startLabel = eventLabel;
        this.endLabel = eventLabel2;
    }

    public static SleepSegmentType valueOf(String str) {
        return (SleepSegmentType) Enum.valueOf(SleepSegmentType.class, str);
    }

    public static SleepSegmentType[] values() {
        return (SleepSegmentType[]) $VALUES.clone();
    }

    public final char getCode() {
        return this.code;
    }

    public final EventLabel getEndLabel() {
        return this.endLabel;
    }

    public final EventLabel getStartLabel() {
        return this.startLabel;
    }

    public final boolean isAwake() {
        return SetsKt.setOf((Object[]) new SleepSegmentType[]{AWAKE_PAUSED, AWAKE, AWAKE_WALKING}).contains(this);
    }

    public final SleepSegmentType normalize() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        return (i == 1 || i == 2) ? AWAKE_PAUSED : this;
    }
}
