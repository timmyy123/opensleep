package com.squareup.kotlinpoet;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0005H\u0007¢\u0006\u0004\b\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Ljava/lang/Class;", "Lcom/squareup/kotlinpoet/ClassName;", "get", "(Ljava/lang/Class;)Lcom/squareup/kotlinpoet/ClassName;", "asClassName", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/squareup/kotlinpoet/ClassName;", "kotlinpoet"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ClassNames {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ClassName get(KClass<?> kClass) {
        List list;
        kClass.getClass();
        String qualifiedName = kClass.getQualifiedName();
        if (qualifiedName == null) {
            Home$$ExternalSyntheticBUOutline0.m(kClass, " cannot be represented as a ClassName");
            return null;
        }
        switch (qualifiedName.hashCode()) {
            case -2090462596:
                if (qualifiedName.equals("kotlin.Double.Companion")) {
                    list = CollectionsKt.listOf((Object[]) new String[]{"kotlin", "Double", "Companion"});
                } else {
                    ArrayDeque arrayDeque = new ArrayDeque();
                    Class<?> javaClass = JvmClassMappingKt.getJavaClass(kClass);
                    while (javaClass != null) {
                        javaClass = javaClass.getEnclosingClass();
                        int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) qualifiedName, '.', 0, false, 6, (Object) null);
                        if (iLastIndexOf$default != -1) {
                            arrayDeque.addFirst(qualifiedName.substring(iLastIndexOf$default + 1));
                            qualifiedName = qualifiedName.substring(0, iLastIndexOf$default);
                        } else {
                            if (javaClass != null) {
                                Utf8$$ExternalSyntheticBUOutline0.m$1(kClass);
                                return null;
                            }
                            arrayDeque.addFirst(qualifiedName);
                            qualifiedName = "";
                        }
                    }
                    arrayDeque.addFirst(qualifiedName);
                    list = CollectionsKt.toList(arrayDeque);
                }
                return new ClassName(list, false, null, null, 14, null);
            case -1788631364:
                if (qualifiedName.equals("kotlin.String.Companion")) {
                    list = CollectionsKt.listOf((Object[]) new String[]{"kotlin", "String", "Companion"});
                }
                return new ClassName(list, false, null, null, 14, null);
            case -1610597024:
                if (qualifiedName.equals("kotlin.Int.Companion")) {
                    list = CollectionsKt.listOf((Object[]) new String[]{"kotlin", "Int", "Companion"});
                }
                return new ClassName(list, false, null, null, 14, null);
            case -1324369241:
                if (qualifiedName.equals("kotlin.Long.Companion")) {
                    list = CollectionsKt.listOf((Object[]) new String[]{"kotlin", "Long", "Companion"});
                }
                return new ClassName(list, false, null, null, 14, null);
            case -348798259:
                if (qualifiedName.equals("kotlin.Float.Companion")) {
                    list = CollectionsKt.listOf((Object[]) new String[]{"kotlin", "Float", "Companion"});
                }
                return new ClassName(list, false, null, null, 14, null);
            case 870618675:
                if (qualifiedName.equals("kotlin.Byte.Companion")) {
                    list = CollectionsKt.listOf((Object[]) new String[]{"kotlin", "Byte", "Companion"});
                }
                return new ClassName(list, false, null, null, 14, null);
            case 1014808321:
                if (qualifiedName.equals("kotlin.Char.Companion")) {
                    list = CollectionsKt.listOf((Object[]) new String[]{"kotlin", "Char", "Companion"});
                }
                return new ClassName(list, false, null, null, 14, null);
            case 1219749612:
                if (qualifiedName.equals("kotlin.Enum.Companion")) {
                    list = CollectionsKt.listOf((Object[]) new String[]{"kotlin", "Enum", "Companion"});
                }
                return new ClassName(list, false, null, null, 14, null);
            case 1485360345:
                if (qualifiedName.equals("kotlin.Boolean.Companion")) {
                    list = CollectionsKt.listOf((Object[]) new String[]{"kotlin", "Boolean", "Companion"});
                }
                return new ClassName(list, false, null, null, 14, null);
            case 1991179501:
                if (qualifiedName.equals("kotlin.Short.Companion")) {
                    list = CollectionsKt.listOf((Object[]) new String[]{"kotlin", "Short", "Companion"});
                }
                return new ClassName(list, false, null, null, 14, null);
        }
    }

    public static final ClassName get(Class<?> cls) {
        cls.getClass();
        if (!cls.isPrimitive()) {
            if (!Intrinsics.areEqual(Void.TYPE, cls)) {
                if (!cls.isArray()) {
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        arrayList.add(cls.getSimpleName());
                        Class<?> enclosingClass = cls.getEnclosingClass();
                        if (enclosingClass == null) {
                            break;
                        }
                        cls = enclosingClass;
                    }
                    int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) cls.getName(), '.', 0, false, 6, (Object) null);
                    if (iLastIndexOf$default != -1) {
                        arrayList.add(cls.getName().substring(0, iLastIndexOf$default));
                    }
                    CollectionsKt.reverse(arrayList);
                    return new ClassName(arrayList, false, null, null, 14, null);
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2("array types cannot be represented as a ClassName");
                return null;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("'void' type cannot be represented as a ClassName");
            return null;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("primitive types cannot be represented as a ClassName");
        return null;
    }
}
