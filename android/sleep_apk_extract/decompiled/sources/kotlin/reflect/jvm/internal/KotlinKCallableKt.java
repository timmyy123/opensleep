package kotlin.reflect.jvm.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.reflect.KClass;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aL\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001H\u0000\"\u001c\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u000f"}, d2 = {"isLocalDelegatedProperty", "", "Lkotlin/reflect/jvm/internal/KotlinKCallable;", "(Lkotlin/reflect/jvm/internal/KotlinKCallable;)Z", "computeParameters", "", "Lkotlin/reflect/KParameter;", "contextParameters", "Lkotlin/reflect/jvm/internal/impl/km/KmValueParameter;", "receiverParameterType", "Lkotlin/reflect/jvm/internal/impl/km/KmType;", "valueParameters", "typeParameterTable", "Lkotlin/reflect/jvm/internal/TypeParameterTable;", "includeReceivers", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class KotlinKCallableKt {
    public static final List<KParameter> computeParameters(KotlinKCallable<?> kotlinKCallable, List<KmValueParameter> list, KmType kmType, List<KmValueParameter> list2, TypeParameterTable typeParameterTable, boolean z) {
        kotlinKCallable.getClass();
        list.getClass();
        list2.getClass();
        typeParameterTable.getClass();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (z) {
            ClassBasedDeclarationContainer container = kotlinKCallable.getContainer();
            if (container instanceof KClassImpl) {
                if (ReflectKCallableKt.isConstructor(kotlinKCallable)) {
                    if (((KClassImpl) container).isInner()) {
                        Class<?> declaringClass = JvmClassMappingKt.getJavaClass((KClass) container).getDeclaringClass();
                        declaringClass.getClass();
                        listCreateListBuilder.add(new InstanceParameter(kotlinKCallable, JvmClassMappingKt.getKotlinClass(declaringClass)));
                    }
                } else if (!isLocalDelegatedProperty(kotlinKCallable)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$4("Only top-level callables are supported for now: ", kotlinKCallable);
                    return null;
                }
            }
            Iterator<KmValueParameter> it = list.iterator();
            while (it.hasNext()) {
                listCreateListBuilder.add(new KotlinKParameter(kotlinKCallable, it.next(), listCreateListBuilder.size(), KParameter.Kind.CONTEXT, typeParameterTable));
            }
            if (kmType != null) {
                String strAsString = SpecialNames.THIS.asString();
                strAsString.getClass();
                KmValueParameter kmValueParameter = new KmValueParameter(strAsString);
                kmValueParameter.setType(kmType);
                listCreateListBuilder.add(new KotlinKParameter(kotlinKCallable, kmValueParameter, listCreateListBuilder.size(), KParameter.Kind.EXTENSION_RECEIVER, typeParameterTable));
            }
        }
        Iterator<KmValueParameter> it2 = list2.iterator();
        while (it2.hasNext()) {
            listCreateListBuilder.add(new KotlinKParameter(kotlinKCallable, it2.next(), listCreateListBuilder.size(), KParameter.Kind.VALUE, typeParameterTable));
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final boolean isLocalDelegatedProperty(KotlinKCallable<?> kotlinKCallable) {
        return (kotlinKCallable instanceof KotlinKProperty) && ReflectKPropertyKt.isLocalDelegated((ReflectKProperty) kotlinKCallable);
    }
}
