package com.squareup.kotlinpoet;

import com.squareup.kotlinpoet.TypeName;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\u0001)B]\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\u0011\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0010¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "Lcom/squareup/kotlinpoet/TypeName;", "enclosingType", "Lcom/squareup/kotlinpoet/ClassName;", "rawType", "", "typeArguments", "", "nullable", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotations", "", "Lkotlin/reflect/KClass;", "", "tags", "<init>", "(Lcom/squareup/kotlinpoet/TypeName;Lcom/squareup/kotlinpoet/ClassName;Ljava/util/List;ZLjava/util/List;Ljava/util/Map;)V", "copy", "(ZLjava/util/List;Ljava/util/Map;)Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeWriter;)Lcom/squareup/kotlinpoet/CodeWriter;", "emit", "", "name", "nestedClass", "(Ljava/lang/String;Ljava/util/List;)Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/squareup/kotlinpoet/TypeName;", "Lcom/squareup/kotlinpoet/ClassName;", "getRawType", "()Lcom/squareup/kotlinpoet/ClassName;", "Ljava/util/List;", "getTypeArguments", "()Ljava/util/List;", "Companion", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ParameterizedTypeName extends TypeName {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TypeName enclosingType;
    private final ClassName rawType;
    private final List<TypeName> typeArguments;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\b*\u00020\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\b*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0007¢\u0006\u0004\b\t\u0010\rJ+\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/squareup/kotlinpoet/ParameterizedTypeName$Companion;", "", "<init>", "()V", "Lcom/squareup/kotlinpoet/ClassName;", "", "Lcom/squareup/kotlinpoet/TypeName;", "typeArguments", "Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "get", "(Lcom/squareup/kotlinpoet/ClassName;[Lcom/squareup/kotlinpoet/TypeName;)Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "parameterizedBy", "", "(Lcom/squareup/kotlinpoet/ClassName;Ljava/util/List;)Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "Ljava/lang/reflect/ParameterizedType;", "type", "", "Ljava/lang/reflect/Type;", "Lcom/squareup/kotlinpoet/TypeVariableName;", "map", "get$kotlinpoet", "(Ljava/lang/reflect/ParameterizedType;Ljava/util/Map;)Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ParameterizedTypeName get(ClassName className, TypeName... typeNameArr) {
            className.getClass();
            typeNameArr.getClass();
            return new ParameterizedTypeName(null, className, ArraysKt.toList(typeNameArr), false, null, null, 56, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ParameterizedTypeName get$kotlinpoet(ParameterizedType type, Map<Type, TypeVariableName> map) {
            ParameterizedType parameterizedType;
            type.getClass();
            map.getClass();
            Type rawType = type.getRawType();
            rawType.getClass();
            ClassName className = ClassNames.get((Class<?>) rawType);
            if (type.getOwnerType() instanceof ParameterizedType) {
                Type rawType2 = type.getRawType();
                rawType2.getClass();
                if (Modifier.isStatic(((Class) rawType2).getModifiers())) {
                    parameterizedType = null;
                } else {
                    Type ownerType = type.getOwnerType();
                    ownerType.getClass();
                    parameterizedType = (ParameterizedType) ownerType;
                }
            }
            Type[] actualTypeArguments = type.getActualTypeArguments();
            actualTypeArguments.getClass();
            ArrayList arrayList = new ArrayList(actualTypeArguments.length);
            for (Type type2 : actualTypeArguments) {
                TypeName.Companion companion = TypeName.INSTANCE;
                type2.getClass();
                arrayList.add(companion.get$kotlinpoet(type2, map));
            }
            if (parameterizedType != null) {
                return get$kotlinpoet(parameterizedType, map).nestedClass(className.getSimpleName(), arrayList);
            }
            return new ParameterizedTypeName(null, className, arrayList, false, null, null, 56, null);
        }

        private Companion() {
        }

        public final ParameterizedTypeName get(ClassName className, List<? extends TypeName> list) {
            className.getClass();
            list.getClass();
            return new ParameterizedTypeName(null, className, list, false, null, null, 56, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParameterizedTypeName(TypeName typeName, ClassName className, List<? extends TypeName> list, boolean z, List<AnnotationSpec> list2, Map<KClass<?>, ? extends Object> map) {
        super(z, list2, TagMap.INSTANCE.m952invokeBEeaP9Q(map), null);
        className.getClass();
        list.getClass();
        list2.getClass();
        map.getClass();
        this.enclosingType = typeName;
        this.rawType = className;
        List<? extends TypeName> list3 = list;
        this.typeArguments = UtilKt.toImmutableList(list3);
        if (list3.isEmpty() && typeName == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$4("no type arguments: ", className);
            throw null;
        }
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public ParameterizedTypeName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags) {
        annotations.getClass();
        tags.getClass();
        return new ParameterizedTypeName(this.enclosingType, this.rawType, this.typeArguments, nullable, annotations, tags);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public CodeWriter emit$kotlinpoet(CodeWriter out) throws IOException {
        out.getClass();
        TypeName typeName = this.enclosingType;
        if (typeName != null) {
            typeName.emitAnnotations$kotlinpoet(out);
            this.enclosingType.emit$kotlinpoet(out);
            CodeWriter.emit$default(out, "." + this.rawType.getSimpleName(), false, 2, null);
        } else {
            this.rawType.emitAnnotations$kotlinpoet(out);
            this.rawType.emit$kotlinpoet(out);
        }
        if (!this.typeArguments.isEmpty()) {
            CodeWriter.emit$default(out, "<", false, 2, null);
            int i = 0;
            for (Object obj : this.typeArguments) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TypeName typeName2 = (TypeName) obj;
                if (i > 0) {
                    CodeWriter.emit$default(out, ", ", false, 2, null);
                }
                typeName2.emitAnnotations$kotlinpoet(out);
                typeName2.emit$kotlinpoet(out);
                typeName2.emitNullable$kotlinpoet(out);
                i = i2;
            }
            CodeWriter.emit$default(out, ">", false, 2, null);
        }
        return out;
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(ParameterizedTypeName.class, other != null ? other.getClass() : null) || !super.equals(other)) {
            return false;
        }
        other.getClass();
        ParameterizedTypeName parameterizedTypeName = (ParameterizedTypeName) other;
        return Intrinsics.areEqual(this.enclosingType, parameterizedTypeName.enclosingType) && Intrinsics.areEqual(this.rawType, parameterizedTypeName.rawType) && Intrinsics.areEqual(this.typeArguments, parameterizedTypeName.typeArguments);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        TypeName typeName = this.enclosingType;
        return this.typeArguments.hashCode() + ((this.rawType.hashCode() + ((iHashCode + (typeName != null ? typeName.hashCode() : 0)) * 31)) * 31);
    }

    public final ParameterizedTypeName nestedClass(String name, List<? extends TypeName> typeArguments) {
        name.getClass();
        typeArguments.getClass();
        return new ParameterizedTypeName(this, this.rawType.nestedClass(name), typeArguments, false, null, null, 56, null);
    }

    @Override // com.squareup.kotlinpoet.TypeName
    public /* bridge */ /* synthetic */ TypeName copy(boolean z, List list, Map map) {
        return copy(z, (List<AnnotationSpec>) list, (Map<KClass<?>, ? extends Object>) map);
    }

    public /* synthetic */ ParameterizedTypeName(TypeName typeName, ClassName className, List list, boolean z, List list2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeName, className, list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? CollectionsKt.emptyList() : list2, (i & 32) != 0 ? MapsKt.emptyMap() : map);
    }
}
