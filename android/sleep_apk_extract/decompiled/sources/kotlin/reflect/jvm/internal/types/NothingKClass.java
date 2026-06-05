package kotlin.reflect.jvm.internal.types;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0097\u0001¢\u0006\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00190\u00188\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b#\u0010 R\u0014\u0010%\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b'\u0010&¨\u0006("}, d2 = {"Lkotlin/reflect/jvm/internal/types/NothingKClass;", "Lkotlin/reflect/KClass;", "Ljava/lang/Void;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", SDKConstants.PARAM_VALUE, "isInstance", "getSimpleName", "simpleName", "getQualifiedName", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "constructors", "", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "typeParameters", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes", "isInner", "()Z", "isValue", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NothingKClass implements KClass<Void>, KTypeParameterOwnerImpl, TypeConstructorMarker {
    public static final NothingKClass INSTANCE = new NothingKClass();
    private final /* synthetic */ KClass<Void> $$delegate_0 = Reflection.getOrCreateKotlinClass(Void.class);

    private NothingKClass() {
    }

    public boolean equals(Object other) {
        return this == other;
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<Void>> getConstructors() {
        return this.$$delegate_0.getConstructors();
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return "kotlin.Nothing";
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return "Nothing";
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        return this.$$delegate_0.getSupertypes();
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        return this.$$delegate_0.getTypeParameters();
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        return this.$$delegate_0.isInner();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object value) {
        return this.$$delegate_0.isInstance(value);
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        return this.$$delegate_0.isValue();
    }

    public String toString() {
        return "NothingKClass";
    }
}
