package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f99kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, null, 62);
    private static final Map<String, String> map;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listListOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f99kotlin;
                sb.append(str);
                sb.append('/');
                sb.append((String) listListOf.get(i));
                int i2 = i + 1;
                linkedHashMap.put(sb.toString(), listListOf.get(i2));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append('/');
                linkedHashMap.put(FileInsert$$ExternalSyntheticOutline0.m(sb2, (String) listListOf.get(i), "Array"), "[" + ((String) listListOf.get(i2)));
                if (i == progressionLastElement) {
                    break;
                } else {
                    i += 2;
                }
            }
        }
        linkedHashMap.put(f99kotlin + "/Unit", "V");
        map$lambda$0$add(linkedHashMap, "Any", "java/lang/Object");
        map$lambda$0$add(linkedHashMap, "Nothing", "java/lang/Void");
        map$lambda$0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            map$lambda$0$add(linkedHashMap, str2, FileInsert$$ExternalSyntheticOutline0.m("java/lang/", str2));
        }
        for (String str3 : CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            map$lambda$0$add(linkedHashMap, FileInsert$$ExternalSyntheticOutline0.m("collections/", str3), FileInsert$$ExternalSyntheticOutline0.m("java/util/", str3));
            map$lambda$0$add(linkedHashMap, FileInsert$$ExternalSyntheticOutline0.m("collections/Mutable", str3), FileInsert$$ExternalSyntheticOutline0.m("java/util/", str3));
        }
        map$lambda$0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i3 = 0; i3 < 23; i3++) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m(i3, "Function");
            StringBuilder sb3 = new StringBuilder();
            String str4 = f99kotlin;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i3);
            map$lambda$0$add(linkedHashMap, strM, sb3.toString());
            map$lambda$0$add(linkedHashMap, FileInsert$$ExternalSyntheticOutline0.m(i3, "reflect/KFunction"), FileInsert$$ExternalSyntheticOutline0.m$1(str4, "/reflect/KFunction"));
        }
        for (String str5 : CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            map$lambda$0$add(linkedHashMap, FileInsert$$ExternalSyntheticOutline0.m$1(str5, ".Companion"), Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(), f99kotlin, "/jvm/internal/", str5, "CompanionObject"));
        }
        map = linkedHashMap;
    }

    private ClassMapperLite() {
    }

    private static final void map$lambda$0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f99kotlin + '/' + str, "L" + str2 + ';');
    }

    public static final String mapClass(String str) {
        str.getClass();
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        return "L" + StringsKt__StringsJVMKt.replace$default(str, '.', '$', false, 4, (Object) null) + ';';
    }
}
