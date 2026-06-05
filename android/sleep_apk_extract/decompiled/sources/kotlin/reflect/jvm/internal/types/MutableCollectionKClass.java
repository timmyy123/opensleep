package kotlin.reflect.jvm.internal.types;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u00042\u00020\u0005B]\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u001e\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u0012\u001e\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0097\u0001¢\u0006\u0004\b\u001b\u0010\u0014R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010\u0019R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R \u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u0014\u0010(\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0019R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000*0)8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b0\u0010/¨\u00061"}, d2 = {"Lkotlin/reflect/jvm/internal/types/MutableCollectionKClass;", "", "T", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "klass", "", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "Lkotlin/Function1;", "", "Lkotlin/reflect/KTypeParameter;", "createTypeParameters", "Lkotlin/reflect/KType;", "createSupertypes", "<init>", "(Lkotlin/reflect/KClass;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", SDKConstants.PARAM_VALUE, "isInstance", "Lkotlin/reflect/KClass;", "getKlass", "()Lkotlin/reflect/KClass;", "Ljava/lang/String;", "getQualifiedName", "typeParameters", "Ljava/util/List;", "getTypeParameters", "()Ljava/util/List;", "supertypes", "getSupertypes", "getSimpleName", "simpleName", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "constructors", "isInner", "()Z", "isValue", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MutableCollectionKClass<T> implements KClass<T>, KTypeParameterOwnerImpl, TypeConstructorMarker {
    private final KClass<T> klass;
    private final String qualifiedName;
    private final List<KType> supertypes;
    private final List<KTypeParameter> typeParameters;

    public MutableCollectionKClass(KClass<T> kClass, String str, Function1<? super MutableCollectionKClass<T>, ? extends List<? extends KTypeParameter>> function1, Function1<? super MutableCollectionKClass<T>, ? extends List<? extends KType>> function12) {
        kClass.getClass();
        str.getClass();
        function1.getClass();
        function12.getClass();
        this.klass = kClass;
        this.qualifiedName = str;
        this.typeParameters = (List) function1.invoke(this);
        this.supertypes = (List) function12.invoke(this);
    }

    public boolean equals(Object other) {
        return (other instanceof MutableCollectionKClass) && Intrinsics.areEqual(this.klass, ((MutableCollectionKClass) other).klass);
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<T>> getConstructors() {
        return this.klass.getConstructors();
    }

    public final KClass<T> getKlass() {
        return this.klass;
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return this.qualifiedName;
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return StringsKt__StringsKt.substringAfterLast$default(getQualifiedName(), ".", (String) null, 2, (Object) null);
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        return this.supertypes;
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return this.klass.hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        return this.klass.isInner();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object value) {
        return this.klass.isInstance(value);
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        return this.klass.isValue();
    }

    public String toString() {
        return "MutableCollectionKClass(" + this.klass + ')';
    }
}
