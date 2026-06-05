package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final TypeUsage howThisTypeIsUsed;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public ErasureTypeAttributes(TypeUsage typeUsage, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        typeUsage.getClass();
        this.howThisTypeIsUsed = typeUsage;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }

    public abstract SimpleType getDefaultType();

    public abstract TypeUsage getHowThisTypeIsUsed();

    public abstract Set<TypeParameterDescriptor> getVisitedTypeParameters();

    public abstract int hashCode();

    public abstract ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor typeParameterDescriptor);
}
