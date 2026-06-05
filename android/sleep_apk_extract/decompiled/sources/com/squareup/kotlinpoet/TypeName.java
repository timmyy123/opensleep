package com.squareup.kotlinpoet;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.squareup.kotlinpoet.ParameterizedTypeName;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleTypeVisitor8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 32\u00020\u00012\u00020\u0001:\u00013B'\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\f\u0010\rJC\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00010\u000eH&¢\u0006\u0004\b\f\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH ¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010#\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b$\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b\u0003\u0010'R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b,\u0010-R\u001b\u00101\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u001aR\u0011\u00102\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b2\u0010'R\u001b\u0010\u0010\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00010\u000e8\u0016X\u0096\u0005\u0082\u0001\u000545678¨\u00069"}, d2 = {"Lcom/squareup/kotlinpoet/TypeName;", "", "", "isNullable", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotations", "Lcom/squareup/kotlinpoet/TagMap;", "tagMap", "<init>", "(ZLjava/util/List;Ljava/util/Map;)V", "nullable", "copy", "(ZLjava/util/List;)Lcom/squareup/kotlinpoet/TypeName;", "", "Lkotlin/reflect/KClass;", "tags", "(ZLjava/util/List;Ljava/util/Map;)Lcom/squareup/kotlinpoet/TypeName;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/squareup/kotlinpoet/CodeWriter;", "out", "emit$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeWriter;)Lcom/squareup/kotlinpoet/CodeWriter;", "emit", "", "emitAnnotations$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeWriter;)V", "emitAnnotations", "emitNullable$kotlinpoet", "emitNullable", "Z", "()Z", "Ljava/util/Map;", "getTagMap-GFPekZs$kotlinpoet", "()Ljava/util/Map;", "Ljava/util/List;", "getAnnotations", "()Ljava/util/List;", "cachedString$delegate", "Lkotlin/Lazy;", "getCachedString", "cachedString", "isAnnotated", "Companion", "Lcom/squareup/kotlinpoet/ClassName;", "Lcom/squareup/kotlinpoet/Dynamic;", "Lcom/squareup/kotlinpoet/ParameterizedTypeName;", "Lcom/squareup/kotlinpoet/TypeVariableName;", "Lcom/squareup/kotlinpoet/WildcardTypeName;", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class TypeName {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnnotationSpec> annotations;

    /* JADX INFO: renamed from: cachedString$delegate, reason: from kotlin metadata */
    private final Lazy cachedString;
    private final boolean isNullable;
    private final Map<KClass<?>, ? extends Object> tagMap;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0000¢\u0006\u0002\b\fJ)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\u0010H\u0000¢\u0006\u0002\b\f¨\u0006\u0011"}, d2 = {"Lcom/squareup/kotlinpoet/TypeName$Companion;", "", "<init>", "()V", "get", "Lcom/squareup/kotlinpoet/TypeName;", "mirror", "Ljavax/lang/model/type/TypeMirror;", "typeVariables", "", "Ljavax/lang/model/element/TypeParameterElement;", "Lcom/squareup/kotlinpoet/TypeVariableName;", "get$kotlinpoet", "type", "Ljava/lang/reflect/Type;", "map", "", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TypeName get$kotlinpoet(Type type, Map<Type, TypeVariableName> map) {
            type.getClass();
            map.getClass();
            if (!(type instanceof Class)) {
                if (type instanceof ParameterizedType) {
                    return ParameterizedTypeName.Companion.get$kotlinpoet((ParameterizedType) type, map);
                }
                if (type instanceof WildcardType) {
                    return WildcardTypeName.Companion.get$kotlinpoet((WildcardType) type, map);
                }
                if (type instanceof TypeVariable) {
                    return TypeVariableName.Companion.get$kotlinpoet((TypeVariable) type, map);
                }
                if (!(type instanceof GenericArrayType)) {
                    Gson$$ExternalSyntheticBUOutline0.m("unexpected type: ", type);
                    return null;
                }
                ParameterizedTypeName.Companion companion = ParameterizedTypeName.Companion;
                ClassName className = TypeNames.ARRAY;
                Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
                genericComponentType.getClass();
                return companion.get(className, get$kotlinpoet(genericComponentType, map));
            }
            if (type == Void.TYPE) {
                return TypeNames.UNIT;
            }
            if (type == Boolean.TYPE) {
                return TypeNames.BOOLEAN;
            }
            if (type == Byte.TYPE) {
                return TypeNames.BYTE;
            }
            if (type == Short.TYPE) {
                return TypeNames.SHORT;
            }
            if (type == Integer.TYPE) {
                return TypeNames.INT;
            }
            if (type == Long.TYPE) {
                return TypeNames.LONG;
            }
            if (type == Character.TYPE) {
                return TypeNames.CHAR;
            }
            if (type == Float.TYPE) {
                return TypeNames.FLOAT;
            }
            if (type == Double.TYPE) {
                return TypeNames.DOUBLE;
            }
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return ClassNames.get((Class<?>) cls);
            }
            ParameterizedTypeName.Companion companion2 = ParameterizedTypeName.Companion;
            ClassName className2 = TypeNames.ARRAY;
            Class<?> componentType = cls.getComponentType();
            componentType.getClass();
            return companion2.get(className2, get$kotlinpoet(componentType, map));
        }

        private Companion() {
        }

        public final TypeName get$kotlinpoet(TypeMirror mirror, final Map<TypeParameterElement, TypeVariableName> typeVariables) {
            mirror.getClass();
            typeVariables.getClass();
            Object objAccept = mirror.accept(new SimpleTypeVisitor8<TypeName, Void>() { // from class: com.squareup.kotlinpoet.TypeName$Companion$get$1
            }, (Object) null);
            objAccept.getClass();
            return (TypeName) objAccept;
        }
    }

    private TypeName(boolean z, List<AnnotationSpec> list, Map<KClass<?>, ? extends Object> map) {
        list.getClass();
        map.getClass();
        this.isNullable = z;
        this.tagMap = map;
        this.annotations = UtilKt.toImmutableList(list);
        this.cachedString = LazyKt.lazy(new Url$$ExternalSyntheticLambda0(this, 11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String cachedString_delegate$lambda$1(TypeName typeName) {
        typeName.getClass();
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            typeName.emitAnnotations$kotlinpoet(codeWriter);
            typeName.emit$kotlinpoet(codeWriter);
            if (typeName.isNullable) {
                CodeWriter.emit$default(codeWriter, "?", false, 2, null);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(codeWriter, null);
            return sb.toString();
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TypeName copy$default(TypeName typeName, boolean z, List list, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: copy");
            return null;
        }
        if ((i & 1) != 0) {
            z = typeName.isNullable;
        }
        if ((i & 2) != 0) {
            list = CollectionsKt.toList(typeName.getAnnotations());
        }
        return typeName.copy(z, list);
    }

    private final String getCachedString() {
        return (String) this.cachedString.getValue();
    }

    public final TypeName copy(boolean nullable, List<AnnotationSpec> annotations) {
        annotations.getClass();
        return copy(nullable, annotations, getTags());
    }

    public abstract TypeName copy(boolean nullable, List<AnnotationSpec> annotations, Map<KClass<?>, ? extends Object> tags);

    public abstract CodeWriter emit$kotlinpoet(CodeWriter out);

    public final void emitAnnotations$kotlinpoet(CodeWriter out) throws IOException {
        out.getClass();
        Iterator<AnnotationSpec> it = getAnnotations().iterator();
        while (it.hasNext()) {
            CodeWriter codeWriter = out;
            AnnotationSpec.emit$kotlinpoet$default(it.next(), codeWriter, true, false, 4, null);
            CodeWriter.emit$default(codeWriter, " ", false, 2, null);
            out = codeWriter;
        }
    }

    public final void emitNullable$kotlinpoet(CodeWriter out) throws IOException {
        out.getClass();
        if (this.isNullable) {
            CodeWriter.emit$default(out, "?", false, 2, null);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        TypeName typeName = (TypeName) other;
        return this.isNullable == typeName.isNullable && Intrinsics.areEqual(getAnnotations(), typeName.getAnnotations());
    }

    public List<AnnotationSpec> getAnnotations() {
        return this.annotations;
    }

    public Map<KClass<?>, Object> getTags() {
        return this.tagMap;
    }

    public int hashCode() {
        return getAnnotations().hashCode() + (Boolean.hashCode(this.isNullable) * 31);
    }

    public final boolean isAnnotated() {
        return !getAnnotations().isEmpty();
    }

    /* JADX INFO: renamed from: isNullable, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    public String toString() {
        return getCachedString();
    }

    public /* synthetic */ TypeName(boolean z, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, list, map);
    }
}
