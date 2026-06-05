package io.ktor.util.reflect;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/util/reflect/TypeInfo;", "", "Lkotlin/reflect/KClass;", "type", "Lkotlin/reflect/KType;", "kotlinType", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KType;)V", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/reflect/KClass;", "getType", "()Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getKotlinType", "()Lkotlin/reflect/KType;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TypeInfo {
    private final KType kotlinType;
    private final KClass<?> type;

    public TypeInfo(KClass<?> kClass, KType kType) {
        kClass.getClass();
        this.type = kClass;
        this.kotlinType = kType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TypeInfo)) {
            return false;
        }
        KType kType = this.kotlinType;
        if (kType == null) {
            TypeInfo typeInfo = (TypeInfo) other;
            if (typeInfo.kotlinType == null) {
                return Intrinsics.areEqual(this.type, typeInfo.type);
            }
        }
        return Intrinsics.areEqual(kType, ((TypeInfo) other).kotlinType);
    }

    public final KType getKotlinType() {
        return this.kotlinType;
    }

    public final KClass<?> getType() {
        return this.type;
    }

    public int hashCode() {
        KType kType = this.kotlinType;
        return kType != null ? kType.hashCode() : this.type.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TypeInfo(");
        Object obj = this.kotlinType;
        if (obj == null) {
            obj = this.type;
        }
        sb.append(obj);
        sb.append(')');
        return sb.toString();
    }
}
