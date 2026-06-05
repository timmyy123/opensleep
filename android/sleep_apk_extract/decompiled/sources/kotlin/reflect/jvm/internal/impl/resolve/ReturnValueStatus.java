package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
public final class ReturnValueStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReturnValueStatus[] $VALUES;
    public static final Companion Companion;
    public static final ReturnValueStatus MustUse = new ReturnValueStatus("MustUse", 0);
    public static final ReturnValueStatus ExplicitlyIgnorable = new ReturnValueStatus("ExplicitlyIgnorable", 1);
    public static final ReturnValueStatus Unspecified = new ReturnValueStatus("Unspecified", 2);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ReturnValueStatus[] $values() {
        return new ReturnValueStatus[]{MustUse, ExplicitlyIgnorable, Unspecified};
    }

    static {
        ReturnValueStatus[] returnValueStatusArr$values = $values();
        $VALUES = returnValueStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(returnValueStatusArr$values);
        Companion = new Companion(null);
    }

    private ReturnValueStatus(String str, int i) {
    }

    public static ReturnValueStatus valueOf(String str) {
        return (ReturnValueStatus) Enum.valueOf(ReturnValueStatus.class, str);
    }

    public static ReturnValueStatus[] values() {
        return (ReturnValueStatus[]) $VALUES.clone();
    }
}
