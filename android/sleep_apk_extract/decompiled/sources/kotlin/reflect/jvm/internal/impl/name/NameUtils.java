package kotlin.reflect.jvm.internal.impl.name;

import kotlin.text.Regex;

/* JADX INFO: loaded from: classes5.dex */
public final class NameUtils {
    public static final NameUtils INSTANCE = new NameUtils();
    private static final Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS = new Regex("[^\\p{L}\\p{Digit}]");
    private static final String CONTEXT_RECEIVER_PREFIX = "$context_receiver";

    private NameUtils() {
    }

    public static final Name contextReceiverName(int i) {
        Name nameIdentifier = Name.identifier(CONTEXT_RECEIVER_PREFIX + '_' + i);
        nameIdentifier.getClass();
        return nameIdentifier;
    }

    public static final String sanitizeAsJavaIdentifier(String str) {
        str.getClass();
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace(str, "_");
    }
}
