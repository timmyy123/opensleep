package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public abstract class JvmBuiltInsCustomizerKt {
    private static final Name GET_FIRST_LIST_NAME;
    private static final Name GET_LAST_LIST_NAME;

    static {
        Name nameIdentifier = Name.identifier("getFirst");
        nameIdentifier.getClass();
        GET_FIRST_LIST_NAME = nameIdentifier;
        Name nameIdentifier2 = Name.identifier("getLast");
        nameIdentifier2.getClass();
        GET_LAST_LIST_NAME = nameIdentifier2;
    }
}
