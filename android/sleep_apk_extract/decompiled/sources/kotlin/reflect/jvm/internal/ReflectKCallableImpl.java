package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.ReflectProperties;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R2\u0010\t\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007 \b*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectKCallableImpl;", "R", "Lkotlin/reflect/jvm/internal/ReflectKCallable;", "<init>", "()V", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_absentArguments", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ReflectKCallableImpl<R> implements ReflectKCallable<R> {
    private final ReflectProperties.LazySoftVal<Object[]> _absentArguments;

    public ReflectKCallableImpl() {
        ReflectProperties.LazySoftVal<Object[]> lazySoftValLazySoft = ReflectProperties.lazySoft(new ReflectKCallableImpl$_absentArguments$1(this));
        lazySoftValLazySoft.getClass();
        this._absentArguments = lazySoftValLazySoft;
    }

    @Override // kotlin.reflect.KCallable
    public /* bridge */ R call(Object... objArr) {
        return default$call(objArr);
    }

    public R default$call(Object... objArr) throws IllegalCallableAccessException {
        objArr.getClass();
        try {
            return (R) getCaller().call(objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }
}
