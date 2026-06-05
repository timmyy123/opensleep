package kotlinx.serialization.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0001\u001a \u0010\u0000\u001a\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0001¨\u0006\u0007"}, d2 = {"throwSubtypeNotRegistered", "", "subClassName", "", "baseClass", "Lkotlin/reflect/KClass;", "subClass", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractPolymorphicSerializerKt {
    public static final Void throwSubtypeNotRegistered(String str, KClass<?> kClass) {
        String string;
        kClass.getClass();
        String str2 = "in the polymorphic scope of '" + kClass.getSimpleName() + '\'';
        if (str == null) {
            string = Fragment$$ExternalSyntheticOutline1.m('.', "Class discriminator was missing and no default serializers were registered ", str2);
        } else {
            StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Serializer for subclass '", str, "' is not found ", str2, ".\nCheck if class with serial name '");
            FileInsert$$ExternalSyntheticOutline0.m(sbM6m, str, "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '", str, "' has to be '@Serializable', and the base class '");
            sbM6m.append(kClass.getSimpleName());
            sbM6m.append("' has to be sealed and '@Serializable'.");
            string = sbM6m.toString();
        }
        throw new SerializationException(string);
    }

    public static final Void throwSubtypeNotRegistered(KClass<?> kClass, KClass<?> kClass2) {
        kClass.getClass();
        kClass2.getClass();
        String simpleName = kClass.getSimpleName();
        if (simpleName == null) {
            simpleName = String.valueOf(kClass);
        }
        throwSubtypeNotRegistered(simpleName, kClass2);
        throw new KotlinNothingValueException();
    }
}
