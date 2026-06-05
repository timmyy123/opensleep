package com.google.devtools.ksp.symbol;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b(\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/google/devtools/ksp/symbol/Modifier;", "", "(Ljava/lang/String;I)V", "PUBLIC", "PRIVATE", "INTERNAL", "PROTECTED", "IN", "OUT", "OVERRIDE", "LATEINIT", "ENUM", "SEALED", "ANNOTATION", "DATA", "INNER", "FUN", "VALUE", "SUSPEND", "TAILREC", "OPERATOR", "INFIX", "INLINE", "EXTERNAL", "ABSTRACT", "FINAL", "OPEN", "CONST", "VARARG", "NOINLINE", "CROSSINLINE", "REIFIED", "EXPECT", "ACTUAL", "JAVA_DEFAULT", "JAVA_NATIVE", "JAVA_STATIC", "JAVA_STRICT", "JAVA_SYNCHRONIZED", "JAVA_TRANSIENT", "JAVA_VOLATILE", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Modifier {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Modifier[] $VALUES;
    public static final Modifier PUBLIC = new Modifier("PUBLIC", 0);
    public static final Modifier PRIVATE = new Modifier("PRIVATE", 1);
    public static final Modifier INTERNAL = new Modifier("INTERNAL", 2);
    public static final Modifier PROTECTED = new Modifier("PROTECTED", 3);
    public static final Modifier IN = new Modifier("IN", 4);
    public static final Modifier OUT = new Modifier("OUT", 5);
    public static final Modifier OVERRIDE = new Modifier("OVERRIDE", 6);
    public static final Modifier LATEINIT = new Modifier("LATEINIT", 7);
    public static final Modifier ENUM = new Modifier("ENUM", 8);
    public static final Modifier SEALED = new Modifier("SEALED", 9);
    public static final Modifier ANNOTATION = new Modifier("ANNOTATION", 10);
    public static final Modifier DATA = new Modifier("DATA", 11);
    public static final Modifier INNER = new Modifier("INNER", 12);
    public static final Modifier FUN = new Modifier("FUN", 13);
    public static final Modifier VALUE = new Modifier("VALUE", 14);
    public static final Modifier SUSPEND = new Modifier("SUSPEND", 15);
    public static final Modifier TAILREC = new Modifier("TAILREC", 16);
    public static final Modifier OPERATOR = new Modifier("OPERATOR", 17);
    public static final Modifier INFIX = new Modifier("INFIX", 18);
    public static final Modifier INLINE = new Modifier("INLINE", 19);
    public static final Modifier EXTERNAL = new Modifier("EXTERNAL", 20);
    public static final Modifier ABSTRACT = new Modifier("ABSTRACT", 21);
    public static final Modifier FINAL = new Modifier("FINAL", 22);
    public static final Modifier OPEN = new Modifier("OPEN", 23);
    public static final Modifier CONST = new Modifier("CONST", 24);
    public static final Modifier VARARG = new Modifier("VARARG", 25);
    public static final Modifier NOINLINE = new Modifier("NOINLINE", 26);
    public static final Modifier CROSSINLINE = new Modifier("CROSSINLINE", 27);
    public static final Modifier REIFIED = new Modifier("REIFIED", 28);
    public static final Modifier EXPECT = new Modifier("EXPECT", 29);
    public static final Modifier ACTUAL = new Modifier("ACTUAL", 30);
    public static final Modifier JAVA_DEFAULT = new Modifier("JAVA_DEFAULT", 31);
    public static final Modifier JAVA_NATIVE = new Modifier("JAVA_NATIVE", 32);
    public static final Modifier JAVA_STATIC = new Modifier("JAVA_STATIC", 33);
    public static final Modifier JAVA_STRICT = new Modifier("JAVA_STRICT", 34);
    public static final Modifier JAVA_SYNCHRONIZED = new Modifier("JAVA_SYNCHRONIZED", 35);
    public static final Modifier JAVA_TRANSIENT = new Modifier("JAVA_TRANSIENT", 36);
    public static final Modifier JAVA_VOLATILE = new Modifier("JAVA_VOLATILE", 37);

    private static final /* synthetic */ Modifier[] $values() {
        return new Modifier[]{PUBLIC, PRIVATE, INTERNAL, PROTECTED, IN, OUT, OVERRIDE, LATEINIT, ENUM, SEALED, ANNOTATION, DATA, INNER, FUN, VALUE, SUSPEND, TAILREC, OPERATOR, INFIX, INLINE, EXTERNAL, ABSTRACT, FINAL, OPEN, CONST, VARARG, NOINLINE, CROSSINLINE, REIFIED, EXPECT, ACTUAL, JAVA_DEFAULT, JAVA_NATIVE, JAVA_STATIC, JAVA_STRICT, JAVA_SYNCHRONIZED, JAVA_TRANSIENT, JAVA_VOLATILE};
    }

    static {
        Modifier[] modifierArr$values = $values();
        $VALUES = modifierArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(modifierArr$values);
    }

    private Modifier(String str, int i) {
    }

    public static Modifier valueOf(String str) {
        return (Modifier) Enum.valueOf(Modifier.class, str);
    }

    public static Modifier[] values() {
        return (Modifier[]) $VALUES.clone();
    }
}
