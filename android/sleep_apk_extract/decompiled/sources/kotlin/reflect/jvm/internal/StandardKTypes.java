package kotlin.reflect.jvm.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.types.SimpleKType;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/StandardKTypes;", "", "<init>", "()V", "ANY", "Lkotlin/reflect/KType;", "getANY", "()Lkotlin/reflect/KType;", "NULLABLE_ANY", "getNULLABLE_ANY", "CLONEABLE", "getCLONEABLE", "SERIALIZABLE", "getSERIALIZABLE", "UNIT_RETURN_TYPE", "getUNIT_RETURN_TYPE", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StandardKTypes {
    public static final StandardKTypes INSTANCE = new StandardKTypes();
    private static final KType ANY = Reflection.typeOf(Object.class);
    private static final KType NULLABLE_ANY = Reflection.nullableTypeOf(Object.class);
    private static final KType CLONEABLE = Reflection.typeOf(Cloneable.class);
    private static final KType SERIALIZABLE = Reflection.typeOf(Serializable.class);
    private static final KType UNIT_RETURN_TYPE = new SimpleKType(Reflection.getOrCreateKotlinClass(Unit.class), CollectionsKt.emptyList(), false, CollectionsKt.emptyList(), null, false, false, false, null, new Function0() { // from class: kotlin.reflect.jvm.internal.StandardKTypes$$Lambda$0
        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return StandardKTypes.UNIT_RETURN_TYPE$lambda$0();
        }
    });

    private StandardKTypes() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type UNIT_RETURN_TYPE$lambda$0() {
        Class cls = Void.TYPE;
        cls.getClass();
        return cls;
    }

    public final KType getANY() {
        return ANY;
    }

    public final KType getCLONEABLE() {
        return CLONEABLE;
    }

    public final KType getNULLABLE_ANY() {
        return NULLABLE_ANY;
    }

    public final KType getSERIALIZABLE() {
        return SERIALIZABLE;
    }

    public final KType getUNIT_RETURN_TYPE() {
        return UNIT_RETURN_TYPE;
    }
}
