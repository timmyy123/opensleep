package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.SystemPropertiesKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.types.AbstractKType;
import kotlin.reflect.jvm.internal.types.DescriptorKType;
import kotlin.reflect.jvm.internal.types.ReflectTypeSystemContext;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/KType;", "other", "", "isSubtypeOf", "(Lkotlin/reflect/KType;Lkotlin/reflect/KType;)Z", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class KTypes {
    public static final boolean isSubtypeOf(KType kType, KType kType2) {
        kType.getClass();
        kType2.getClass();
        if (SystemPropertiesKt.getUseK1Implementation()) {
            return TypeUtilsKt.isSubtypeOf(((DescriptorKType) kType).getType(), ((DescriptorKType) kType2).getType());
        }
        return AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, new TypeCheckerState(false, false, false, false, ReflectTypeSystemContext.INSTANCE, AbstractTypePreparator.Default.INSTANCE, AbstractTypeRefiner.Default.INSTANCE), (AbstractKType) kType, (AbstractKType) kType2, false, 8, null);
    }
}
