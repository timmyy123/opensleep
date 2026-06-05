package com.squareup.kotlinpoet;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.squareup.kotlinpoet.CodeBlock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 <2\u00020\u00012\u00020\u00012\u00020\u0001:\u0002=<B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0017\u0010\u001e\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u001cR\u001a\u0010\"\u001a\u00020!8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R \u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00103\u001a\u0002028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0019\u00107\u001a\u0004\u0018\u00010!8\u0006¢\u0006\f\n\u0004\b7\u0010#\u001a\u0004\b8\u0010%R\u001b\u0010;\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030:\u0012\u0004\u0012\u00020\u0001098\u0016X\u0096\u0005¨\u0006>"}, d2 = {"Lcom/squareup/kotlinpoet/ParameterSpec;", "", "Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "builder", "Lcom/squareup/kotlinpoet/TagMap;", "tagMap", "<init>", "(Lcom/squareup/kotlinpoet/ParameterSpec$Builder;Ljava/util/Map;)V", "Lcom/squareup/kotlinpoet/CodeWriter;", "codeWriter", "", "includeType", "inlineAnnotations", "", "emit$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeWriter;ZZ)V", "emit", "emitDefaultValue$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeWriter;)V", "emitDefaultValue", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/util/Map;", "name", "Ljava/lang/String;", "getName", "Lcom/squareup/kotlinpoet/CodeBlock;", "kdoc", "Lcom/squareup/kotlinpoet/CodeBlock;", "getKdoc", "()Lcom/squareup/kotlinpoet/CodeBlock;", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotations", "Ljava/util/List;", "getAnnotations", "()Ljava/util/List;", "", "Lcom/squareup/kotlinpoet/KModifier;", "modifiers", "Ljava/util/Set;", "getModifiers", "()Ljava/util/Set;", "Lcom/squareup/kotlinpoet/TypeName;", "type", "Lcom/squareup/kotlinpoet/TypeName;", "getType", "()Lcom/squareup/kotlinpoet/TypeName;", "defaultValue", "getDefaultValue", "", "Lkotlin/reflect/KClass;", "tags", "Companion", "Builder", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ParameterSpec {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnnotationSpec> annotations;
    private final CodeBlock defaultValue;
    private final CodeBlock kdoc;
    private final Set<KModifier> modifiers;
    private final String name;
    private final Map<KClass<?>, ? extends Object> tagMap;
    private final TypeName type;

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0019\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0#8\u0006¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010(\u001a\u00020'8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R*\u0010/\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030-\u0012\u0004\u0012\u00020.0,8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R \u00103\u001a\b\u0012\u0004\u0012\u00020\u000f0#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u0010&¨\u00065"}, d2 = {"Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "Lcom/squareup/kotlinpoet/Annotatable$Builder;", "Lcom/squareup/kotlinpoet/Documentable$Builder;", "", "name", "Lcom/squareup/kotlinpoet/TypeName;", "type", "<init>", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;)V", "", "Lcom/squareup/kotlinpoet/KModifier;", "modifiers", "addModifiers", "([Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotationSpec", "addAnnotation", "(Lcom/squareup/kotlinpoet/AnnotationSpec;)Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "Lcom/squareup/kotlinpoet/ParameterSpec;", InAppPurchaseConstants.METHOD_BUILD, "()Lcom/squareup/kotlinpoet/ParameterSpec;", "Ljava/lang/String;", "getName$kotlinpoet", "()Ljava/lang/String;", "Lcom/squareup/kotlinpoet/TypeName;", "getType$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeName;", "Lcom/squareup/kotlinpoet/CodeBlock;", "defaultValue", "Lcom/squareup/kotlinpoet/CodeBlock;", "getDefaultValue$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock;", "setDefaultValue$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeBlock;)V", "", "Ljava/util/List;", "getModifiers", "()Ljava/util/List;", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "kdoc", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getKdoc", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "", "Lkotlin/reflect/KClass;", "", "tags", "Ljava/util/Map;", "getTags", "()Ljava/util/Map;", "annotations", "getAnnotations", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder implements Taggable$Builder<Builder>, Annotatable$Builder<Builder>, Documentable$Builder<Builder> {
        private final List<AnnotationSpec> annotations;
        private CodeBlock defaultValue;
        private final CodeBlock.Builder kdoc;
        private final List<KModifier> modifiers;
        private final String name;
        private final Map<KClass<?>, Object> tags;
        private final TypeName type;

        public Builder(String str, TypeName typeName) {
            str.getClass();
            typeName.getClass();
            this.name = str;
            this.type = typeName;
            this.modifiers = new ArrayList();
            this.kdoc = CodeBlock.INSTANCE.builder();
            this.tags = new LinkedHashMap();
            this.annotations = new ArrayList();
        }

        @Override // com.squareup.kotlinpoet.Annotatable$Builder
        public Builder addAnnotation(AnnotationSpec annotationSpec) {
            annotationSpec.getClass();
            return (Builder) super.addAnnotation(annotationSpec);
        }

        public final Builder addModifiers(KModifier... modifiers) {
            modifiers.getClass();
            CollectionsKt__MutableCollectionsKt.addAll(this.modifiers, modifiers);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ParameterSpec build() {
            return new ParameterSpec(this, null, 2, 0 == true ? 1 : 0);
        }

        @Override // com.squareup.kotlinpoet.Annotatable$Builder
        public List<AnnotationSpec> getAnnotations() {
            return this.annotations;
        }

        /* JADX INFO: renamed from: getDefaultValue$kotlinpoet, reason: from getter */
        public final CodeBlock getDefaultValue() {
            return this.defaultValue;
        }

        @Override // com.squareup.kotlinpoet.Documentable$Builder
        public CodeBlock.Builder getKdoc() {
            return this.kdoc;
        }

        public final List<KModifier> getModifiers() {
            return this.modifiers;
        }

        /* JADX INFO: renamed from: getName$kotlinpoet, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Override // com.squareup.kotlinpoet.Taggable$Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        /* JADX INFO: renamed from: getType$kotlinpoet, reason: from getter */
        public final TypeName getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/squareup/kotlinpoet/ParameterSpec$Companion;", "", "<init>", "()V", "", "name", "Lcom/squareup/kotlinpoet/TypeName;", "type", "", "Lcom/squareup/kotlinpoet/KModifier;", "modifiers", "Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "builder", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "Lkotlin/reflect/KClass;", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/ParameterSpec$Builder;", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder builder(String name, TypeName type, KModifier... modifiers) {
            name.getClass();
            type.getClass();
            modifiers.getClass();
            return new Builder(name, type).addModifiers((KModifier[]) Arrays.copyOf(modifiers, modifiers.length));
        }

        private Companion() {
        }

        public final Builder builder(String name, KClass<?> type, KModifier... modifiers) {
            name.getClass();
            type.getClass();
            modifiers.getClass();
            return builder(name, TypeNames.get(type), (KModifier[]) Arrays.copyOf(modifiers, modifiers.length));
        }
    }

    private ParameterSpec(Builder builder, Map<KClass<?>, ? extends Object> map) {
        this.tagMap = map;
        this.name = builder.getName();
        this.kdoc = builder.getKdoc().build();
        this.annotations = UtilKt.toImmutableList(builder.getAnnotations());
        List<KModifier> modifiers = builder.getModifiers();
        LinkedHashSet linkedHashSet = new LinkedHashSet(modifiers);
        linkedHashSet.removeAll(ParameterSpecKt.ALLOWED_PARAMETER_MODIFIERS);
        if (linkedHashSet.isEmpty()) {
            this.modifiers = UtilKt.toImmutableSet(modifiers);
            this.type = builder.getType();
            this.defaultValue = builder.getDefaultValue();
        } else {
            StringBuilder sb = new StringBuilder("Modifiers ");
            sb.append(linkedHashSet);
            Home$$ExternalSyntheticBUOutline0.m(sb, " are not allowed on Kotlin parameters. Allowed modifiers: ", ParameterSpecKt.ALLOWED_PARAMETER_MODIFIERS);
            throw null;
        }
    }

    public static /* synthetic */ void emit$kotlinpoet$default(ParameterSpec parameterSpec, CodeWriter codeWriter, boolean z, boolean z2, int i, Object obj) throws Throwable {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        parameterSpec.emit$kotlinpoet(codeWriter, z, z2);
    }

    public final void emit$kotlinpoet(CodeWriter codeWriter, boolean includeType, boolean inlineAnnotations) throws Throwable {
        codeWriter.getClass();
        codeWriter.emitAnnotations(getAnnotations(), inlineAnnotations);
        CodeWriter.emitModifiers$default(codeWriter, this.modifiers, null, 2, null);
        if (this.name.length() > 0) {
            codeWriter.emitCode("%N", this);
        }
        if (this.name.length() > 0 && includeType) {
            codeWriter.emitCode(": ");
        }
        if (includeType) {
            codeWriter.emitCode("%T", this.type);
        }
        emitDefaultValue$kotlinpoet(codeWriter);
    }

    public final void emitDefaultValue$kotlinpoet(CodeWriter codeWriter) throws Throwable {
        codeWriter.getClass();
        CodeBlock codeBlock = this.defaultValue;
        if (codeBlock != null) {
            codeWriter.emitCode(codeBlock.hasStatements$kotlinpoet() ? " = %L" : " = «%L»", this.defaultValue);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(ParameterSpec.class, other.getClass())) {
            return Intrinsics.areEqual(toString(), other.toString());
        }
        return false;
    }

    public List<AnnotationSpec> getAnnotations() {
        return this.annotations;
    }

    public CodeBlock getKdoc() {
        return this.kdoc;
    }

    public final Set<KModifier> getModifiers() {
        return this.modifiers;
    }

    public final String getName() {
        return this.name;
    }

    public final TypeName getType() {
        return this.type;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            emit$kotlinpoet$default(this, codeWriter, false, false, 6, null);
            try {
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(codeWriter, null);
                return sb.toString();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(codeWriter, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            codeWriter = codeWriter;
        }
    }

    public /* synthetic */ ParameterSpec(Builder builder, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : map);
    }
}
