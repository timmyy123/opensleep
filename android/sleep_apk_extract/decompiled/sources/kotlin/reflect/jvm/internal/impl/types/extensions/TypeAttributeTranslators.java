package kotlin.reflect.jvm.internal.impl.types.extensions;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;

/* JADX INFO: loaded from: classes5.dex */
public final class TypeAttributeTranslators {
    private final List<TypeAttributeTranslator> translators;

    /* JADX WARN: Multi-variable type inference failed */
    public TypeAttributeTranslators(List<? extends TypeAttributeTranslator> list) {
        list.getClass();
        this.translators = list;
    }

    public final List<TypeAttributeTranslator> getTranslators() {
        return this.translators;
    }
}
