package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/TypeNullability;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_NULL", "NULLABLE", "FLEXIBLE", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TypeNullability {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TypeNullability[] $VALUES;
    public static final TypeNullability NOT_NULL = new TypeNullability("NOT_NULL", 0);
    public static final TypeNullability NULLABLE = new TypeNullability("NULLABLE", 1);
    public static final TypeNullability FLEXIBLE = new TypeNullability("FLEXIBLE", 2);

    private static final /* synthetic */ TypeNullability[] $values() {
        return new TypeNullability[]{NOT_NULL, NULLABLE, FLEXIBLE};
    }

    static {
        TypeNullability[] typeNullabilityArr$values = $values();
        $VALUES = typeNullabilityArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(typeNullabilityArr$values);
    }

    private TypeNullability(String str, int i) {
    }

    public static TypeNullability valueOf(String str) {
        return (TypeNullability) Enum.valueOf(TypeNullability.class, str);
    }

    public static TypeNullability[] values() {
        return (TypeNullability[]) $VALUES.clone();
    }
}
