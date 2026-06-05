package kotlin.reflect.jvm.internal.impl.load.java.structure;

/* JADX INFO: loaded from: classes5.dex */
public interface JavaField extends JavaMember {
    boolean getHasConstantNotNullInitializer();

    JavaType getType();

    boolean isEnumEntry();
}
