package kotlin.reflect.jvm.internal.impl.km;

import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class KmAnnotation {
    private final Map<String, KmAnnotationArgument> arguments;
    private final String className;

    /* JADX WARN: Multi-variable type inference failed */
    public KmAnnotation(String str, Map<String, ? extends KmAnnotationArgument> map) {
        str.getClass();
        map.getClass();
        this.className = str;
        this.arguments = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$0(Pair pair) {
        pair.getClass();
        return ((String) pair.component1()) + " = " + ((KmAnnotationArgument) pair.component2());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KmAnnotation)) {
            return false;
        }
        KmAnnotation kmAnnotation = (KmAnnotation) obj;
        return Intrinsics.areEqual(this.className, kmAnnotation.className) && Intrinsics.areEqual(this.arguments, kmAnnotation.arguments);
    }

    public final Map<String, KmAnnotationArgument> getArguments() {
        return this.arguments;
    }

    public final String getClassName() {
        return this.className;
    }

    public int hashCode() {
        return this.arguments.hashCode() + (this.className.hashCode() * 31);
    }

    public String toString() {
        return "@" + this.className + '(' + CollectionsKt.joinToString$default(MapsKt.toList(this.arguments), null, null, null, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.km.KmAnnotation$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return KmAnnotation.toString$lambda$0((Pair) obj);
            }
        }, 31) + ')';
    }
}
