package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdOfflineRecTriggerMode;", "", "Lkotlin/UByte;", SDKConstants.PARAM_VALUE, "<init>", "(Ljava/lang/String;IB)V", "B", "getValue-w2LRezQ", "()B", "Companion", "TRIGGER_DISABLE", "TRIGGER_SYSTEM_START", "TRIGGER_EXERCISE_START", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PmdOfflineRecTriggerMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PmdOfflineRecTriggerMode[] $VALUES;
    private final byte value;
    public static final PmdOfflineRecTriggerMode TRIGGER_DISABLE = new PmdOfflineRecTriggerMode("TRIGGER_DISABLE", 0, (byte) 0);
    public static final PmdOfflineRecTriggerMode TRIGGER_SYSTEM_START = new PmdOfflineRecTriggerMode("TRIGGER_SYSTEM_START", 1, (byte) 1);
    public static final PmdOfflineRecTriggerMode TRIGGER_EXERCISE_START = new PmdOfflineRecTriggerMode("TRIGGER_EXERCISE_START", 2, (byte) 2);

    private static final /* synthetic */ PmdOfflineRecTriggerMode[] $values() {
        return new PmdOfflineRecTriggerMode[]{TRIGGER_DISABLE, TRIGGER_SYSTEM_START, TRIGGER_EXERCISE_START};
    }

    static {
        PmdOfflineRecTriggerMode[] pmdOfflineRecTriggerModeArr$values = $values();
        $VALUES = pmdOfflineRecTriggerModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pmdOfflineRecTriggerModeArr$values);
        INSTANCE = new Companion(null);
    }

    private PmdOfflineRecTriggerMode(String str, int i, byte b) {
        this.value = b;
    }

    public static PmdOfflineRecTriggerMode valueOf(String str) {
        return (PmdOfflineRecTriggerMode) Enum.valueOf(PmdOfflineRecTriggerMode.class, str);
    }

    public static PmdOfflineRecTriggerMode[] values() {
        return (PmdOfflineRecTriggerMode[]) $VALUES.clone();
    }
}
