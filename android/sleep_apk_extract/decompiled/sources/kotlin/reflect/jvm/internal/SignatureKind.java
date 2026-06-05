package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/SignatureKind;", "", "<init>", "(Ljava/lang/String;I)V", "FUNCTION", "PROPERTY", "FIELD_IN_JAVA_CLASS", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SignatureKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SignatureKind[] $VALUES;
    public static final SignatureKind FUNCTION = new SignatureKind("FUNCTION", 0);
    public static final SignatureKind PROPERTY = new SignatureKind("PROPERTY", 1);
    public static final SignatureKind FIELD_IN_JAVA_CLASS = new SignatureKind("FIELD_IN_JAVA_CLASS", 2);

    private static final /* synthetic */ SignatureKind[] $values() {
        return new SignatureKind[]{FUNCTION, PROPERTY, FIELD_IN_JAVA_CLASS};
    }

    static {
        SignatureKind[] signatureKindArr$values = $values();
        $VALUES = signatureKindArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(signatureKindArr$values);
    }

    private SignatureKind(String str, int i) {
    }

    public static SignatureKind valueOf(String str) {
        return (SignatureKind) Enum.valueOf(SignatureKind.class, str);
    }

    public static SignatureKind[] values() {
        return (SignatureKind[]) $VALUES.clone();
    }
}
