package kotlin.reflect.jvm.internal.impl.km;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
public final class ReturnValueStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReturnValueStatus[] $VALUES;
    public static final ReturnValueStatus UNSPECIFIED = new ReturnValueStatus("UNSPECIFIED", 0);
    public static final ReturnValueStatus MUST_USE = new ReturnValueStatus("MUST_USE", 1);
    public static final ReturnValueStatus EXPLICITLY_IGNORABLE = new ReturnValueStatus("EXPLICITLY_IGNORABLE", 2);

    private static final /* synthetic */ ReturnValueStatus[] $values() {
        return new ReturnValueStatus[]{UNSPECIFIED, MUST_USE, EXPLICITLY_IGNORABLE};
    }

    static {
        ReturnValueStatus[] returnValueStatusArr$values = $values();
        $VALUES = returnValueStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(returnValueStatusArr$values);
    }

    private ReturnValueStatus(String str, int i) {
    }

    public static EnumEntries<ReturnValueStatus> getEntries() {
        return $ENTRIES;
    }

    public static ReturnValueStatus valueOf(String str) {
        return (ReturnValueStatus) Enum.valueOf(ReturnValueStatus.class, str);
    }

    public static ReturnValueStatus[] values() {
        return (ReturnValueStatus[]) $VALUES.clone();
    }
}
