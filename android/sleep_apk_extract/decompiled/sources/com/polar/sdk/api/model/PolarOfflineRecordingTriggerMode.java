package com.polar.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/polar/sdk/api/model/PolarOfflineRecordingTriggerMode;", "", "(Ljava/lang/String;I)V", "TRIGGER_DISABLED", "TRIGGER_SYSTEM_START", "TRIGGER_EXERCISE_START", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PolarOfflineRecordingTriggerMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PolarOfflineRecordingTriggerMode[] $VALUES;
    public static final PolarOfflineRecordingTriggerMode TRIGGER_DISABLED = new PolarOfflineRecordingTriggerMode("TRIGGER_DISABLED", 0);
    public static final PolarOfflineRecordingTriggerMode TRIGGER_SYSTEM_START = new PolarOfflineRecordingTriggerMode("TRIGGER_SYSTEM_START", 1);
    public static final PolarOfflineRecordingTriggerMode TRIGGER_EXERCISE_START = new PolarOfflineRecordingTriggerMode("TRIGGER_EXERCISE_START", 2);

    private static final /* synthetic */ PolarOfflineRecordingTriggerMode[] $values() {
        return new PolarOfflineRecordingTriggerMode[]{TRIGGER_DISABLED, TRIGGER_SYSTEM_START, TRIGGER_EXERCISE_START};
    }

    static {
        PolarOfflineRecordingTriggerMode[] polarOfflineRecordingTriggerModeArr$values = $values();
        $VALUES = polarOfflineRecordingTriggerModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(polarOfflineRecordingTriggerModeArr$values);
    }

    private PolarOfflineRecordingTriggerMode(String str, int i) {
    }

    public static PolarOfflineRecordingTriggerMode valueOf(String str) {
        return (PolarOfflineRecordingTriggerMode) Enum.valueOf(PolarOfflineRecordingTriggerMode.class, str);
    }

    public static PolarOfflineRecordingTriggerMode[] values() {
        return (PolarOfflineRecordingTriggerMode[]) $VALUES.clone();
    }
}
