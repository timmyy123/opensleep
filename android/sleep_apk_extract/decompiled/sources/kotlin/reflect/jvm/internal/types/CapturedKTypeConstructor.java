package kotlin.reflect.jvm.internal.types;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/types/CapturedKTypeConstructor;", "Lkotlin/reflect/jvm/internal/impl/types/model/CapturedTypeConstructorMarker;", "projection", "Lkotlin/reflect/KTypeProjection;", "<init>", "(Lkotlin/reflect/KTypeProjection;)V", "getProjection", "()Lkotlin/reflect/KTypeProjection;", "supertypes", "", "Lkotlin/reflect/KType;", "getSupertypes", "()Ljava/util/List;", "setSupertypes", "(Ljava/util/List;)V", InAppPurchaseConstants.METHOD_TO_STRING, "", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CapturedKTypeConstructor implements CapturedTypeConstructorMarker {
    private final KTypeProjection projection;
    public List<? extends KType> supertypes;

    public CapturedKTypeConstructor(KTypeProjection kTypeProjection) {
        kTypeProjection.getClass();
        this.projection = kTypeProjection;
    }

    public final KTypeProjection getProjection() {
        return this.projection;
    }

    public final List<KType> getSupertypes() {
        List list = this.supertypes;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("supertypes");
        return null;
    }

    public final void setSupertypes(List<? extends KType> list) {
        list.getClass();
        this.supertypes = list;
    }

    public String toString() {
        return "CapturedType(" + this.projection + ')';
    }
}
