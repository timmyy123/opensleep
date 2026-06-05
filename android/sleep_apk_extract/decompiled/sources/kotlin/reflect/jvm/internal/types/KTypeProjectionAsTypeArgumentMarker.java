package kotlin.reflect.jvm.internal.types;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/reflect/jvm/internal/types/KTypeProjectionAsTypeArgumentMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeArgumentMarker;", SDKConstants.PARAM_VALUE, "Lkotlin/reflect/KTypeProjection;", "<init>", "(Lkotlin/reflect/KTypeProjection;)V", "getValue", "()Lkotlin/reflect/KTypeProjection;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KTypeProjectionAsTypeArgumentMarker implements TypeArgumentMarker {
    private final KTypeProjection value;

    public KTypeProjectionAsTypeArgumentMarker(KTypeProjection kTypeProjection) {
        kTypeProjection.getClass();
        this.value = kTypeProjection;
    }

    public final KTypeProjection getValue() {
        return this.value;
    }
}
