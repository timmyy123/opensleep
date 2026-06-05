package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    private final String escapeClassName(String str) {
        return str.length() > 1 ? Fragment$$ExternalSyntheticOutline1.m(';', "L", str) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence jvmDescriptor$lambda$0(String str) {
        str.getClass();
        return INSTANCE.escapeClassName(str);
    }

    public final String[] constructors(String... strArr) {
        strArr.getClass();
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final Set<String> inClass(String str, String... strArr) {
        str.getClass();
        strArr.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    public final Set<String> inJavaLang(String str, String... strArr) {
        str.getClass();
        strArr.getClass();
        return inClass(javaLang(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final Set<String> inJavaUtil(String str, String... strArr) {
        str.getClass();
        strArr.getClass();
        return inClass(javaUtil(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final String javaFunction(String str) {
        str.getClass();
        return "java/util/function/" + str;
    }

    public final String javaLang(String str) {
        str.getClass();
        return "java/lang/" + str;
    }

    public final String javaUtil(String str) {
        str.getClass();
        return "java/util/" + str;
    }

    public final String javaUtilConcurrentAtomic(String str) {
        str.getClass();
        return "java/util/concurrent/atomic/" + str;
    }

    public final String jvmDescriptor(String str, List<String> list, String str2) {
        str.getClass();
        list.getClass();
        str2.getClass();
        return str + '(' + CollectionsKt.joinToString$default(list, "", null, null, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return SignatureBuildingComponents.jvmDescriptor$lambda$0((String) obj);
            }
        }, 30) + ')' + escapeClassName(str2);
    }

    public final String signature(String str, String str2) {
        str.getClass();
        str2.getClass();
        return str + '.' + str2;
    }
}
