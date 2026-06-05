package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.KotlinGenericDeclaration;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004J\f\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0080\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectKProperty;", "V", "Lkotlin/reflect/jvm/internal/ReflectKCallable;", "Lkotlin/reflect/KProperty;", "Lkotlin/jvm/internal/KotlinGenericDeclaration;", "signature", "", "getSignature", "()Ljava/lang/String;", "javaField", "Ljava/lang/reflect/Field;", "getJavaField", "()Ljava/lang/reflect/Field;", "findJavaDeclaration", "Ljava/lang/reflect/GenericDeclaration;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ReflectKProperty<V> extends KotlinGenericDeclaration, KProperty<V>, ReflectKCallable<V> {
    Field getJavaField();

    String getSignature();
}
