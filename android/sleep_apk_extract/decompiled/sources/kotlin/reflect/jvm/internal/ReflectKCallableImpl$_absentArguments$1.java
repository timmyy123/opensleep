package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ReflectKCallableImpl$_absentArguments$1 extends FunctionReferenceImpl implements Function0<Object[]> {
    public ReflectKCallableImpl$_absentArguments$1(Object obj) {
        super(0, obj, ReflectKCallableKt.class, "computeAbsentArguments", "computeAbsentArguments(Lkotlin/reflect/jvm/internal/ReflectKCallable;)[Ljava/lang/Object;", 1);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object[] invoke() {
        return ReflectKCallableKt.computeAbsentArguments((ReflectKCallable) this.receiver);
    }
}
