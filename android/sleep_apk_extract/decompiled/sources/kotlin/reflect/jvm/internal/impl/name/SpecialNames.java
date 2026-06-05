package kotlin.reflect.jvm.internal.impl.name;

import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public final class SpecialNames {
    public static final Name ANONYMOUS;
    public static final FqName ANONYMOUS_FQ_NAME;
    public static final Name ARRAY;
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT;
    public static final Name DESTRUCT;
    public static final Name ENUM_GET_ENTRIES;
    public static final Name IMPLICIT_SET_PARAMETER;
    public static final Name INIT;
    public static final SpecialNames INSTANCE = new SpecialNames();
    public static final Name ITERATOR;
    public static final Name LOCAL;
    public static final Name NO_NAME_PROVIDED;
    public static final Name RECEIVER;
    public static final Name ROOT_PACKAGE;
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME;
    public static final Name THIS;
    public static final Name UNARY;
    public static final Name UNDERSCORE_FOR_UNUSED_VAR;
    public static final Name WHEN_SUBJECT;

    static {
        Name nameSpecial = Name.special("<no name provided>");
        nameSpecial.getClass();
        NO_NAME_PROVIDED = nameSpecial;
        Name nameSpecial2 = Name.special("<root package>");
        nameSpecial2.getClass();
        ROOT_PACKAGE = nameSpecial2;
        Name nameIdentifier = Name.identifier("Companion");
        nameIdentifier.getClass();
        DEFAULT_NAME_FOR_COMPANION_OBJECT = nameIdentifier;
        Name nameIdentifier2 = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        nameIdentifier2.getClass();
        SAFE_IDENTIFIER_FOR_NO_NAME = nameIdentifier2;
        Name nameSpecial3 = Name.special("<anonymous>");
        nameSpecial3.getClass();
        ANONYMOUS = nameSpecial3;
        FqName.Companion companion = FqName.Companion;
        Name nameSpecial4 = Name.special("<anonymous>");
        nameSpecial4.getClass();
        ANONYMOUS_FQ_NAME = companion.topLevel(nameSpecial4);
        Name nameSpecial5 = Name.special("<unary>");
        nameSpecial5.getClass();
        UNARY = nameSpecial5;
        Name nameSpecial6 = Name.special("<this>");
        nameSpecial6.getClass();
        THIS = nameSpecial6;
        Name nameSpecial7 = Name.special("<init>");
        nameSpecial7.getClass();
        INIT = nameSpecial7;
        Name nameSpecial8 = Name.special("<when-subject>");
        nameSpecial8.getClass();
        WHEN_SUBJECT = nameSpecial8;
        Name nameSpecial9 = Name.special("<iterator>");
        nameSpecial9.getClass();
        ITERATOR = nameSpecial9;
        Name nameSpecial10 = Name.special("<destruct>");
        nameSpecial10.getClass();
        DESTRUCT = nameSpecial10;
        Name nameSpecial11 = Name.special("<local>");
        nameSpecial11.getClass();
        LOCAL = nameSpecial11;
        Name nameSpecial12 = Name.special("<unused var>");
        nameSpecial12.getClass();
        UNDERSCORE_FOR_UNUSED_VAR = nameSpecial12;
        Name nameSpecial13 = Name.special("<set-?>");
        nameSpecial13.getClass();
        IMPLICIT_SET_PARAMETER = nameSpecial13;
        Name nameSpecial14 = Name.special("<array>");
        nameSpecial14.getClass();
        ARRAY = nameSpecial14;
        Name nameSpecial15 = Name.special("<receiver>");
        nameSpecial15.getClass();
        RECEIVER = nameSpecial15;
        Name nameSpecial16 = Name.special("<get-entries>");
        nameSpecial16.getClass();
        ENUM_GET_ENTRIES = nameSpecial16;
    }

    private SpecialNames() {
    }

    public static final Name safeIdentifier(Name name) {
        return (name == null || name.isSpecial()) ? SAFE_IDENTIFIER_FOR_NO_NAME : name;
    }

    public final boolean isSafeIdentifier(Name name) {
        name.getClass();
        String strAsString = name.asString();
        strAsString.getClass();
        return strAsString.length() > 0 && !name.isSpecial();
    }
}
