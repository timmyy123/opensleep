package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KClassifier;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeAliasImpl;", "Lkotlin/reflect/KClassifier;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "<init>", "(Lorg/jetbrains/kotlin/name/FqName;)V", "getFqName", "()Lorg/jetbrains/kotlin/name/FqName;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KTypeAliasImpl implements KClassifier, TypeConstructorMarker {
    private final FqName fqName;

    public KTypeAliasImpl(FqName fqName) {
        fqName.getClass();
        this.fqName = fqName;
    }

    public final FqName getFqName() {
        return this.fqName;
    }
}
