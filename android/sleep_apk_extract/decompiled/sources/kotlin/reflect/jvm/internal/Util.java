package kotlin.reflect.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
abstract class Util {
    public static Object getEnumConstantByName(Class<? extends Enum<?>> cls, String str) {
        return Enum.valueOf(cls, str);
    }
}
