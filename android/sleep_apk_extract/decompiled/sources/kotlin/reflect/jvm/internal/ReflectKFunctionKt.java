package kotlin.reflect.jvm.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.KCallables;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"extractContinuationArgument", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/jvm/internal/ReflectKFunction;", "DefaultConstructorMarkerDescriptor", "", "patchJvmDescriptorByExtraBoxing", "Lkotlin/reflect/jvm/internal/DescriptorPatchingResult;", "function", "jvmDescriptor", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ReflectKFunctionKt {
    public static final Type extractContinuationArgument(ReflectKFunction reflectKFunction) {
        Type[] lowerBounds;
        reflectKFunction.getClass();
        if (reflectKFunction.isSuspend()) {
            Object objLastOrNull = CollectionsKt.lastOrNull((List<? extends Object>) reflectKFunction.getCaller().getParameterTypes());
            ParameterizedType parameterizedType = objLastOrNull instanceof ParameterizedType ? (ParameterizedType) objLastOrNull : null;
            if (Intrinsics.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                actualTypeArguments.getClass();
                Object objSingle = ArraysKt.single(actualTypeArguments);
                WildcardType wildcardType = objSingle instanceof WildcardType ? (WildcardType) objSingle : null;
                if (wildcardType != null && (lowerBounds = wildcardType.getLowerBounds()) != null) {
                    return (Type) ArraysKt.first(lowerBounds);
                }
            }
        }
        return null;
    }

    public static final DescriptorPatchingResult patchJvmDescriptorByExtraBoxing(ReflectKFunction reflectKFunction, String str) {
        reflectKFunction.getClass();
        str.getClass();
        FunctionJvmDescriptor jvmDescriptor = UtilKt.parseJvmDescriptor(str);
        boolean zAreEqual = Intrinsics.areEqual(CollectionsKt.lastOrNull((List) jvmDescriptor.getParameters()), "Lkotlin/jvm/internal/DefaultConstructorMarker;");
        int size = KCallables.getValueParameters(reflectKFunction).size() + (zAreEqual ? 1 : 0);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(CollectionsKt.take(jvmDescriptor.getParameters(), jvmDescriptor.getParameters().size() - size));
        for (Pair pair : CollectionsKt.zip(KCallables.getValueParameters(reflectKFunction), CollectionsKt.takeLast(jvmDescriptor.getParameters(), size))) {
            KParameter kParameter = (KParameter) pair.component1();
            String str2 = (String) pair.component2();
            if (UtilKt.isAlwaysBoxedByCompiler(kParameter)) {
                linkedHashSet.add(Integer.valueOf(arrayList.size()));
                KClassifier classifier = kParameter.getType().getClassifier();
                classifier.getClass();
                arrayList.add(UtilKt.toJvmDescriptor((KClass) classifier));
            } else {
                arrayList.add(str2);
            }
        }
        if (zAreEqual) {
            arrayList.add("Lkotlin/jvm/internal/DefaultConstructorMarker;");
        }
        if (linkedHashSet.isEmpty()) {
            return new DescriptorPatchingResult(str, SetsKt.emptySet());
        }
        return new DescriptorPatchingResult(CollectionsKt.joinToString$default(arrayList, "", "(", ")", null, 56) + jvmDescriptor.getReturnType(), linkedHashSet);
    }
}
