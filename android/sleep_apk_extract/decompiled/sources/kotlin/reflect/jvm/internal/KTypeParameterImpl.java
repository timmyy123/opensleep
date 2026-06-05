package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeParameterBase;
import kotlin.reflect.KType;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.types.DescriptorKType;
import kotlin.reflect.jvm.internal.types.KTypeSubstitutor;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B3\b\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012B)\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u0013R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\r\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/jvm/internal/KTypeParameterBase;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeParameterMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "container", "", "name", "Lkotlin/reflect/KVariance;", "variance", "", "isReified", "<init>", "(Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "Lkotlin/reflect/jvm/internal/types/KTypeSubstitutor;", "typeSubstitutor", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;Lkotlin/reflect/jvm/internal/types/KTypeSubstitutor;)V", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "Z", "()Z", "_descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "", "Lkotlin/reflect/KType;", "upperBounds", "Ljava/util/List;", "getUpperBounds", "()Ljava/util/List;", "setUpperBounds", "(Ljava/util/List;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KTypeParameterImpl extends KTypeParameterBase implements TypeConstructorMarker, TypeParameterMarker {
    private final TypeParameterDescriptor _descriptor;
    private final boolean isReified;
    private final String name;
    public volatile List<? extends KType> upperBounds;
    private final KVariance variance;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, TypeParameterDescriptor typeParameterDescriptor, KTypeSubstitutor kTypeSubstitutor) {
        kTypeParameterOwnerImpl.getClass();
        typeParameterDescriptor.getClass();
        kTypeSubstitutor.getClass();
        String strAsString = typeParameterDescriptor.getName().asString();
        strAsString.getClass();
        Variance variance = typeParameterDescriptor.getVariance();
        variance.getClass();
        this(typeParameterDescriptor, kTypeParameterOwnerImpl, strAsString, KTypeParameterImplKt.toKVariance(variance), typeParameterDescriptor.isReified());
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        upperBounds.getClass();
        List<KotlinType> list = upperBounds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (KotlinType kotlinType : list) {
            kotlinType.getClass();
            KType type = KTypeSubstitutor.substitute$default(kTypeSubstitutor, new DescriptorKType(kotlinType, null, 2, 0 == true ? 1 : 0), null, 2, null).getType();
            if (type == null) {
                FakeOverridesKt.starProjectionInTopLevelTypeIsNotPossible(kTypeParameterOwnerImpl);
                Utf8$$ExternalSyntheticBUOutline0.m();
                throw null;
            }
            arrayList.add(type);
        }
        setUpperBounds(arrayList);
    }

    public final TypeParameterDescriptor getDescriptor() {
        TypeParameterDescriptor typeParameterDescriptor = this._descriptor;
        if (typeParameterDescriptor != null) {
            return typeParameterDescriptor;
        }
        Utf8$$ExternalSyntheticBUOutline0.m("Descriptor-less type parameter: ", this);
        return null;
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.KTypeParameter
    public List<KType> getUpperBounds() {
        List list = this.upperBounds;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("upperBounds");
        return null;
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance getVariance() {
        return this.variance;
    }

    public void setUpperBounds(List<? extends KType> list) {
        list.getClass();
        this.upperBounds = list;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, String str, KVariance kVariance, boolean z) {
        this((TypeParameterDescriptor) null, kTypeParameterOwnerImpl, str, kVariance, z);
        kTypeParameterOwnerImpl.getClass();
        str.getClass();
        kVariance.getClass();
    }

    public /* synthetic */ KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, TypeParameterDescriptor typeParameterDescriptor, KTypeSubstitutor kTypeSubstitutor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kTypeParameterOwnerImpl, typeParameterDescriptor, (i & 4) != 0 ? KTypeSubstitutor.INSTANCE.getEMPTY() : kTypeSubstitutor);
    }

    private KTypeParameterImpl(TypeParameterDescriptor typeParameterDescriptor, KTypeParameterOwnerImpl kTypeParameterOwnerImpl, String str, KVariance kVariance, boolean z) {
        super(kTypeParameterOwnerImpl);
        this.name = str;
        this.variance = kVariance;
        this.isReified = z;
        this._descriptor = typeParameterDescriptor;
    }
}
