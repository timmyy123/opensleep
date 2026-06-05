package kotlin.reflect.jvm.internal.impl.km;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
public final class KmVersionRequirementLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ KmVersionRequirementLevel[] $VALUES;
    public static final KmVersionRequirementLevel WARNING = new KmVersionRequirementLevel("WARNING", 0);
    public static final KmVersionRequirementLevel ERROR = new KmVersionRequirementLevel("ERROR", 1);
    public static final KmVersionRequirementLevel HIDDEN = new KmVersionRequirementLevel("HIDDEN", 2);

    private static final /* synthetic */ KmVersionRequirementLevel[] $values() {
        return new KmVersionRequirementLevel[]{WARNING, ERROR, HIDDEN};
    }

    static {
        KmVersionRequirementLevel[] kmVersionRequirementLevelArr$values = $values();
        $VALUES = kmVersionRequirementLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(kmVersionRequirementLevelArr$values);
    }

    private KmVersionRequirementLevel(String str, int i) {
    }

    public static KmVersionRequirementLevel valueOf(String str) {
        return (KmVersionRequirementLevel) Enum.valueOf(KmVersionRequirementLevel.class, str);
    }

    public static KmVersionRequirementLevel[] values() {
        return (KmVersionRequirementLevel[]) $VALUES.clone();
    }
}
