package com.squareup.kotlinpoet;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.squareup.kotlinpoet.TypeName;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%Bi\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0011\u0010\u0012J6\u0010\u001a\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0016JT\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u001b\u001a\u00020\t2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005*\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0002J\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0010¢\u0006\u0002\b J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0019¨\u0006&"}, d2 = {"Lcom/squareup/kotlinpoet/TypeVariableName;", "Lcom/squareup/kotlinpoet/TypeName;", "name", "", "bounds", "", "variance", "Lcom/squareup/kotlinpoet/KModifier;", "isReified", "", "nullable", "annotations", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "tags", "", "Lkotlin/reflect/KClass;", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/squareup/kotlinpoet/KModifier;ZZLjava/util/List;Ljava/util/Map;)V", "getName", "()Ljava/lang/String;", "getBounds", "()Ljava/util/List;", "getVariance", "()Lcom/squareup/kotlinpoet/KModifier;", "()Z", "copy", "reified", "withoutImplicitBound", "emit", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "equals", "other", "hashCode", "", "Companion", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TypeVariableName extends TypeName {
    private final List<TypeName> bounds;
    private final boolean isReified;
    private final String name;
    private final KModifier variance;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<TypeName> NULLABLE_ANY_LIST = CollectionsKt.listOf(CodeWriterKt.getNULLABLE_ANY());
    private static final ClassName JAVA_OBJECT = new ClassName("java.lang", "Object");

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/squareup/kotlinpoet/TypeVariableName$Companion;", "", "<init>", "()V", "Ljava/lang/reflect/TypeVariable;", "type", "", "Ljava/lang/reflect/Type;", "Lcom/squareup/kotlinpoet/TypeVariableName;", "map", "get$kotlinpoet", "(Ljava/lang/reflect/TypeVariable;Ljava/util/Map;)Lcom/squareup/kotlinpoet/TypeVariableName;", "get", "Lcom/squareup/kotlinpoet/ClassName;", "JAVA_OBJECT", "Lcom/squareup/kotlinpoet/ClassName;", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TypeVariableName get$kotlinpoet(TypeVariable<?> type, Map<Type, TypeVariableName> map) {
            type.getClass();
            map.getClass();
            TypeVariableName typeVariableName = map.get(type);
            if (typeVariableName != null) {
                return typeVariableName;
            }
            ArrayList arrayList = new ArrayList();
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            String name = type.getName();
            name.getClass();
            listUnmodifiableList.getClass();
            TypeVariableName typeVariableName2 = new TypeVariableName(name, listUnmodifiableList, null, false, false, null, null, 124, null);
            map.put(type, typeVariableName2);
            Iterator it = ArrayIteratorKt.iterator(type.getBounds());
            while (it.hasNext()) {
                Type type2 = (Type) it.next();
                TypeName.Companion companion = TypeName.INSTANCE;
                type2.getClass();
                arrayList.add(companion.get$kotlinpoet(type2, map));
            }
            arrayList.remove(TypeNames.ANY);
            arrayList.remove(TypeVariableName.JAVA_OBJECT);
            if (arrayList.isEmpty()) {
                arrayList.add(CodeWriterKt.getNULLABLE_ANY());
            }
            return typeVariableName2;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TypeVariableName(String str, List list, KModifier kModifier, boolean z, boolean z2, List list2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? null : kModifier, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? CollectionsKt.emptyList() : list2, (i & 64) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<TypeName> withoutImplicitBound(List<? extends TypeName> list) {
        if (list.size() == 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Intrinsics.areEqual((TypeName) obj, CodeWriterKt.getNULLABLE_ANY())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final TypeVariableName copy(boolean nullable, List<AnnotationSpec> annotations, List<? extends TypeName> bounds, boolean reified, Map<KClass<?>, ? extends Object> tags) {
        annotations.getClass();
        bounds.getClass();
        tags.getClass();
        return new TypeVariableName(this.name, withoutImplicitBound(bounds), this.variance, reified, nullable, annotations, tags);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public CodeWriter emit$kotlinpoet(CodeWriter out) {
        out.getClass();
        return CodeWriter.emit$default(out, this.name, false, 2, null);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(TypeVariableName.class, other != null ? other.getClass() : null) || !super.equals(other)) {
            return false;
        }
        other.getClass();
        TypeVariableName typeVariableName = (TypeVariableName) other;
        return Intrinsics.areEqual(this.name, typeVariableName.name) && Intrinsics.areEqual(this.bounds, typeVariableName.bounds) && this.variance == typeVariableName.variance && this.isReified == typeVariableName.isReified;
    }

    public final List<TypeName> getBounds() {
        return this.bounds;
    }

    public final String getName() {
        return this.name;
    }

    public final KModifier getVariance() {
        return this.variance;
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public int hashCode() {
        int iM = FileInsert$$ExternalSyntheticOutline0.m((List) this.bounds, FileInsert$$ExternalSyntheticOutline0.m(super.hashCode() * 31, 31, this.name), 31);
        KModifier kModifier = this.variance;
        return Boolean.hashCode(this.isReified) + ((iM + (kModifier != null ? kModifier.hashCode() : 0)) * 31);
    }

    /* JADX INFO: renamed from: isReified, reason: from getter */
    public final boolean getIsReified() {
        return this.isReified;
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public TypeVariableName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        annotations.getClass();
        tags.getClass();
        return copy(nullable, annotations, this.bounds, this.isReified, tags);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public /* bridge */ /* synthetic */ TypeName copy(boolean z, List list, Map map) {
        return copy(z, (List<AnnotationSpec>) list, (Map<KClass<?>, ? extends Object>) map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeVariableName(String str, List<? extends TypeName> list, KModifier kModifier, boolean z, boolean z2, List<AnnotationSpec> list2, Map<KClass<?>, ? extends Object> map) {
        super(z2, list2, TagMap.INSTANCE.m952invokeBEeaP9Q(map), null);
        this.name = str;
        this.bounds = list;
        this.variance = kModifier;
        this.isReified = z;
    }
}
