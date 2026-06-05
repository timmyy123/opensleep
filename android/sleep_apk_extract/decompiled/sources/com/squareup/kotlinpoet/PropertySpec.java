package com.squareup.kotlinpoet;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.OriginatingElementsHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Element;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u00012\u00020\u00012\u00020\u0001:\u0002^]B/\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJM\u0010\u0019\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J#\u0010+\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020%2\b\b\u0002\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010-R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010.R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010/R\u0017\u00100\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u0010(\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b(\u00104\u001a\u0004\b5\u0010'R\u0017\u0010*\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b*\u00106\u001a\u0004\b7\u00108R\u001a\u0010:\u001a\u0002098\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R \u0010@\u001a\b\u0012\u0004\u0012\u00020?0>8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b@\u0010/\u001a\u0004\bA\u0010BR\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020G0>8\u0006¢\u0006\f\n\u0004\bH\u0010/\u001a\u0004\bI\u0010BR\u0019\u0010J\u001a\u0004\u0018\u0001098\u0006¢\u0006\f\n\u0004\bJ\u0010;\u001a\u0004\bK\u0010=R\u0017\u0010L\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\bL\u00101\u001a\u0004\bM\u00103R\u0019\u0010O\u001a\u0004\u0018\u00010N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0019\u0010S\u001a\u0004\u0018\u00010N8\u0006¢\u0006\f\n\u0004\bS\u0010P\u001a\u0004\bT\u0010RR\u0019\u0010U\u001a\u0004\u0018\u00010)8\u0006¢\u0006\f\n\u0004\bU\u00106\u001a\u0004\bV\u00108R\u0011\u0010W\u001a\b\u0012\u0004\u0012\u00020)0>8\u0016X\u0097\u0005R\u0011\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0>8\u0016X\u0096\u0005R\u001b\u0010\\\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030[\u0012\u0004\u0012\u00020\u00010Z8\u0016X\u0096\u0005¨\u0006_"}, d2 = {"Lcom/squareup/kotlinpoet/PropertySpec;", "", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder;", "Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "builder", "Lcom/squareup/kotlinpoet/TagMap;", "tagMap", "delegateOriginatingElementsHolder", "Lcom/squareup/kotlinpoet/ContextReceivers;", "contextReceivers", "<init>", "(Lcom/squareup/kotlinpoet/PropertySpec$Builder;Ljava/util/Map;Lcom/squareup/kotlinpoet/OriginatingElementsHolder;Ljava/util/List;)V", "Lcom/squareup/kotlinpoet/CodeWriter;", "codeWriter", "", "Lcom/squareup/kotlinpoet/KModifier;", "implicitModifiers", "", "withInitializer", "emitKdoc", "inline", "inlineAnnotations", "", "emit$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeWriter;Ljava/util/Set;ZZZZ)V", "emit", "Lcom/squareup/kotlinpoet/ParameterSpec;", "parameter", "fromPrimaryConstructorParameter$kotlinpoet", "(Lcom/squareup/kotlinpoet/ParameterSpec;)Lcom/squareup/kotlinpoet/PropertySpec;", "fromPrimaryConstructorParameter", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "name", "Lcom/squareup/kotlinpoet/TypeName;", "type", "toBuilder", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "Ljava/util/Map;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder;", "Ljava/util/List;", "mutable", "Z", "getMutable", "()Z", "Ljava/lang/String;", "getName", "Lcom/squareup/kotlinpoet/TypeName;", "getType", "()Lcom/squareup/kotlinpoet/TypeName;", "Lcom/squareup/kotlinpoet/CodeBlock;", "kdoc", "Lcom/squareup/kotlinpoet/CodeBlock;", "getKdoc", "()Lcom/squareup/kotlinpoet/CodeBlock;", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotations", "getAnnotations", "()Ljava/util/List;", "modifiers", "Ljava/util/Set;", "getModifiers", "()Ljava/util/Set;", "Lcom/squareup/kotlinpoet/TypeVariableName;", "typeVariables", "getTypeVariables", "initializer", "getInitializer", "delegated", "getDelegated", "Lcom/squareup/kotlinpoet/FunSpec;", "getter", "Lcom/squareup/kotlinpoet/FunSpec;", "getGetter", "()Lcom/squareup/kotlinpoet/FunSpec;", "setter", "getSetter", "receiverType", "getReceiverType", "contextReceiverTypes", "Ljavax/lang/model/element/Element;", "originatingElements", "", "Lkotlin/reflect/KClass;", "tags", "Companion", "Builder", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PropertySpec implements OriginatingElementsHolder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnnotationSpec> annotations;
    private final List<? extends TypeName> contextReceivers;
    private final OriginatingElementsHolder delegateOriginatingElementsHolder;
    private final boolean delegated;
    private final FunSpec getter;
    private final CodeBlock initializer;
    private final CodeBlock kdoc;
    private final Set<KModifier> modifiers;
    private final boolean mutable;
    private final String name;
    private final TypeName receiverType;
    private final FunSpec setter;
    private final Map<KClass<?>, ? extends Object> tagMap;
    private final TypeName type;
    private final List<TypeVariableName> typeVariables;

    @Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u00042\b\u0012\u0004\u0012\u00020\u00000\u0005B\u0019\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\u00020\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u0014J\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R$\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u00020(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u0010*\u001a\u0004\b8\u0010,\"\u0004\b9\u0010.R$\u0010;\u001a\u0004\u0018\u00010:8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010A\u001a\u0004\u0018\u00010:8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bA\u0010<\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R$\u0010D\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bD\u0010%\u001a\u0004\bE\u0010'\"\u0004\bF\u0010GR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0H8\u0006¢\u0006\f\n\u0004\b\u000e\u0010I\u001a\u0004\bJ\u0010KR\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020L0H8\u0006¢\u0006\f\n\u0004\bM\u0010I\u001a\u0004\bN\u0010KR*\u0010R\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030P\u0012\u0004\u0012\u00020Q0O8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001a\u0010W\u001a\u00020V8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR \u0010\\\u001a\b\u0012\u0004\u0012\u00020[0H8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\\\u0010I\u001a\u0004\b]\u0010KR \u0010^\u001a\b\u0012\u0004\u0012\u00020\u00150H8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b^\u0010I\u001a\u0004\b_\u0010KR&\u0010`\u001a\b\u0012\u0004\u0012\u00020\b0H8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b`\u0010I\u0012\u0004\bb\u0010c\u001a\u0004\ba\u0010K¨\u0006d"}, d2 = {"Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder$Builder;", "Lcom/squareup/kotlinpoet/ContextReceivable$Builder;", "Lcom/squareup/kotlinpoet/Annotatable$Builder;", "Lcom/squareup/kotlinpoet/Documentable$Builder;", "", "name", "Lcom/squareup/kotlinpoet/TypeName;", "type", "<init>", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;)V", "", "Lcom/squareup/kotlinpoet/KModifier;", "modifiers", "addModifiers", "([Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "Lcom/squareup/kotlinpoet/CodeBlock;", "codeBlock", "initializer", "(Lcom/squareup/kotlinpoet/CodeBlock;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotationSpec", "addAnnotation", "(Lcom/squareup/kotlinpoet/AnnotationSpec;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "", "annotationSpecs", "addAnnotations", "(Ljava/lang/Iterable;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "block", "addKdoc", "Lcom/squareup/kotlinpoet/PropertySpec;", InAppPurchaseConstants.METHOD_BUILD, "()Lcom/squareup/kotlinpoet/PropertySpec;", "Ljava/lang/String;", "getName$kotlinpoet", "()Ljava/lang/String;", "Lcom/squareup/kotlinpoet/TypeName;", "getType$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeName;", "", "isPrimaryConstructorParameter", "Z", "isPrimaryConstructorParameter$kotlinpoet", "()Z", "setPrimaryConstructorParameter$kotlinpoet", "(Z)V", "mutable", "getMutable$kotlinpoet", "setMutable$kotlinpoet", "Lcom/squareup/kotlinpoet/CodeBlock;", "getInitializer$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock;", "setInitializer$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeBlock;)V", "delegated", "getDelegated$kotlinpoet", "setDelegated$kotlinpoet", "Lcom/squareup/kotlinpoet/FunSpec;", "getter", "Lcom/squareup/kotlinpoet/FunSpec;", "getGetter$kotlinpoet", "()Lcom/squareup/kotlinpoet/FunSpec;", "setGetter$kotlinpoet", "(Lcom/squareup/kotlinpoet/FunSpec;)V", "setter", "getSetter$kotlinpoet", "setSetter$kotlinpoet", "receiverType", "getReceiverType$kotlinpoet", "setReceiverType$kotlinpoet", "(Lcom/squareup/kotlinpoet/TypeName;)V", "", "Ljava/util/List;", "getModifiers", "()Ljava/util/List;", "Lcom/squareup/kotlinpoet/TypeVariableName;", "typeVariables", "getTypeVariables", "", "Lkotlin/reflect/KClass;", "", "tags", "Ljava/util/Map;", "getTags", "()Ljava/util/Map;", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "kdoc", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getKdoc", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "Ljavax/lang/model/element/Element;", "originatingElements", "getOriginatingElements", "annotations", "getAnnotations", "contextReceiverTypes", "getContextReceiverTypes", "getContextReceiverTypes$annotations", "()V", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder implements Taggable$Builder<Builder>, OriginatingElementsHolder.Builder<Builder>, ContextReceivable$Builder<Builder>, Annotatable$Builder<Builder>, Documentable$Builder<Builder> {
        private final List<AnnotationSpec> annotations;
        private final List<TypeName> contextReceiverTypes;
        private boolean delegated;
        private FunSpec getter;
        private CodeBlock initializer;
        private boolean isPrimaryConstructorParameter;
        private final CodeBlock.Builder kdoc;
        private final List<KModifier> modifiers;
        private boolean mutable;
        private final String name;
        private final List<Element> originatingElements;
        private TypeName receiverType;
        private FunSpec setter;
        private final Map<KClass<?>, Object> tags;
        private final TypeName type;
        private final List<TypeVariableName> typeVariables;

        public Builder(String str, TypeName typeName) {
            str.getClass();
            typeName.getClass();
            this.name = str;
            this.type = typeName;
            this.modifiers = new ArrayList();
            this.typeVariables = new ArrayList();
            this.tags = new LinkedHashMap();
            this.kdoc = CodeBlock.INSTANCE.builder();
            this.originatingElements = new ArrayList();
            this.annotations = new ArrayList();
            this.contextReceiverTypes = new ArrayList();
        }

        @Override // com.squareup.kotlinpoet.Annotatable$Builder
        public Builder addAnnotation(AnnotationSpec annotationSpec) {
            annotationSpec.getClass();
            return (Builder) super.addAnnotation(annotationSpec);
        }

        @Override // com.squareup.kotlinpoet.Annotatable$Builder
        public Builder addAnnotations(Iterable<AnnotationSpec> annotationSpecs) {
            annotationSpecs.getClass();
            return (Builder) super.addAnnotations(annotationSpecs);
        }

        @Override // com.squareup.kotlinpoet.Documentable$Builder
        public Builder addKdoc(CodeBlock block) {
            block.getClass();
            return (Builder) super.addKdoc(block);
        }

        public final Builder addModifiers(KModifier... modifiers) {
            modifiers.getClass();
            CollectionsKt__MutableCollectionsKt.addAll(this.modifiers, modifiers);
            return this;
        }

        public final PropertySpec build() {
            if (this.modifiers.contains(KModifier.INLINE)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("KotlinPoet doesn't allow setting the inline modifier on properties. You should mark either the getter, the setter, or both inline.");
                return null;
            }
            for (KModifier kModifier : this.modifiers) {
                if (!this.isPrimaryConstructorParameter) {
                    kModifier.checkTarget$kotlinpoet(KModifier.Target.PROPERTY);
                }
            }
            return new PropertySpec(this, null, null, null, 14, null);
        }

        @Override // com.squareup.kotlinpoet.Annotatable$Builder
        public List<AnnotationSpec> getAnnotations() {
            return this.annotations;
        }

        @Override // com.squareup.kotlinpoet.ContextReceivable$Builder
        public List<TypeName> getContextReceiverTypes() {
            return this.contextReceiverTypes;
        }

        /* JADX INFO: renamed from: getDelegated$kotlinpoet, reason: from getter */
        public final boolean getDelegated() {
            return this.delegated;
        }

        /* JADX INFO: renamed from: getGetter$kotlinpoet, reason: from getter */
        public final FunSpec getGetter() {
            return this.getter;
        }

        /* JADX INFO: renamed from: getInitializer$kotlinpoet, reason: from getter */
        public final CodeBlock getInitializer() {
            return this.initializer;
        }

        @Override // com.squareup.kotlinpoet.Documentable$Builder
        public CodeBlock.Builder getKdoc() {
            return this.kdoc;
        }

        public final List<KModifier> getModifiers() {
            return this.modifiers;
        }

        /* JADX INFO: renamed from: getMutable$kotlinpoet, reason: from getter */
        public final boolean getMutable() {
            return this.mutable;
        }

        /* JADX INFO: renamed from: getName$kotlinpoet, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Override // com.squareup.kotlinpoet.OriginatingElementsHolder.Builder
        public List<Element> getOriginatingElements() {
            return this.originatingElements;
        }

        /* JADX INFO: renamed from: getReceiverType$kotlinpoet, reason: from getter */
        public final TypeName getReceiverType() {
            return this.receiverType;
        }

        /* JADX INFO: renamed from: getSetter$kotlinpoet, reason: from getter */
        public final FunSpec getSetter() {
            return this.setter;
        }

        @Override // com.squareup.kotlinpoet.Taggable$Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        /* JADX INFO: renamed from: getType$kotlinpoet, reason: from getter */
        public final TypeName getType() {
            return this.type;
        }

        public final List<TypeVariableName> getTypeVariables() {
            return this.typeVariables;
        }

        public final Builder initializer(CodeBlock codeBlock) {
            this.initializer = codeBlock;
            this.delegated = false;
            return this;
        }

        public final void setDelegated$kotlinpoet(boolean z) {
            this.delegated = z;
        }

        public final void setGetter$kotlinpoet(FunSpec funSpec) {
            this.getter = funSpec;
        }

        public final void setInitializer$kotlinpoet(CodeBlock codeBlock) {
            this.initializer = codeBlock;
        }

        public final void setMutable$kotlinpoet(boolean z) {
            this.mutable = z;
        }

        public final void setPrimaryConstructorParameter$kotlinpoet(boolean z) {
            this.isPrimaryConstructorParameter = z;
        }

        public final void setReceiverType$kotlinpoet(TypeName typeName) {
            this.receiverType = typeName;
        }

        public final void setSetter$kotlinpoet(FunSpec funSpec) {
            this.setter = funSpec;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/squareup/kotlinpoet/PropertySpec$Companion;", "", "<init>", "()V", "", "name", "Lcom/squareup/kotlinpoet/TypeName;", "type", "", "Lcom/squareup/kotlinpoet/KModifier;", "modifiers", "Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "builder", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
    }

    private PropertySpec(Builder builder, Map<KClass<?>, ? extends Object> map, OriginatingElementsHolder originatingElementsHolder, List<? extends TypeName> list) {
        FunSpec funSpec;
        this.tagMap = map;
        this.delegateOriginatingElementsHolder = originatingElementsHolder;
        this.contextReceivers = list;
        this.mutable = builder.getMutable();
        this.name = builder.getName();
        this.type = builder.getType();
        this.kdoc = builder.getKdoc().build();
        this.annotations = UtilKt.toImmutableList(builder.getAnnotations());
        this.modifiers = UtilKt.toImmutableSet(builder.getModifiers());
        List<TypeVariableName> immutableList = UtilKt.toImmutableList(builder.getTypeVariables());
        this.typeVariables = immutableList;
        this.initializer = builder.getInitializer();
        this.delegated = builder.getDelegated();
        this.getter = builder.getGetter();
        this.setter = builder.getSetter();
        this.receiverType = builder.getReceiverType();
        List<TypeVariableName> list2 = immutableList;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((TypeVariableName) it.next()).getIsReified()) {
                    FunSpec funSpec2 = this.getter;
                    if ((funSpec2 == null && this.setter == null) || ((funSpec2 != null && !funSpec2.getModifiers().contains(KModifier.INLINE)) || ((funSpec = this.setter) != null && !funSpec.getModifiers().contains(KModifier.INLINE)))) {
                        Utf8$$ExternalSyntheticBUOutline0.m$2("only type parameters of properties with inline getters and/or setters can be reified!");
                        throw null;
                    }
                }
            }
        }
        if (this.mutable || this.setter == null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("only a mutable property can have a setter");
        throw null;
    }

    public static /* synthetic */ void emit$kotlinpoet$default(PropertySpec propertySpec, CodeWriter codeWriter, Set set, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) throws Throwable {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        if ((i & 16) != 0) {
            z3 = false;
        }
        if ((i & 32) != 0) {
            z4 = z3;
        }
        propertySpec.emit$kotlinpoet(codeWriter, set, z, z2, z3, z4);
    }

    public static /* synthetic */ Builder toBuilder$default(PropertySpec propertySpec, String str, TypeName typeName, int i, Object obj) {
        if ((i & 1) != 0) {
            str = propertySpec.name;
        }
        if ((i & 2) != 0) {
            typeName = propertySpec.type;
        }
        return propertySpec.toBuilder(str, typeName);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void emit$kotlinpoet(CodeWriter codeWriter, Set<? extends KModifier> implicitModifiers, boolean withInitializer, boolean emitKdoc, boolean inline, boolean inlineAnnotations) throws Throwable {
        boolean z;
        Set<KModifier> modifiers;
        Set<KModifier> modifiers2;
        codeWriter.getClass();
        implicitModifiers.getClass();
        FunSpec funSpec = this.getter;
        if ((funSpec == null || (modifiers2 = funSpec.getModifiers()) == null) ? false : modifiers2.contains(KModifier.INLINE)) {
            if (this.mutable) {
                FunSpec funSpec2 = this.setter;
                if ((funSpec2 == null || (modifiers = funSpec2.getModifiers()) == null) ? false : modifiers.contains(KModifier.INLINE)) {
                }
            }
            z = true;
        } else {
            z = false;
        }
        Set<KModifier> setPlus = this.modifiers;
        if (z) {
            setPlus = SetsKt.plus(setPlus, KModifier.INLINE);
        }
        if (emitKdoc) {
            codeWriter.emitKdoc(UtilKt.ensureEndsWithNewLine(getKdoc()));
        }
        codeWriter.emitContextReceivers(getContextReceiverTypes(), "\n");
        codeWriter.emitAnnotations(getAnnotations(), inlineAnnotations);
        codeWriter.emitModifiers(setPlus, implicitModifiers);
        codeWriter.emitCode(this.mutable ? "var " : "val ");
        if (!this.typeVariables.isEmpty()) {
            codeWriter.emitTypeVariables(this.typeVariables);
            CodeWriter.emit$default(codeWriter, "♢", false, 2, null);
        }
        TypeName typeName = this.receiverType;
        if (typeName != null) {
            codeWriter.emitCode("%T.", typeName);
        }
        codeWriter.emitCode("%N:♢%T", this, this.type);
        if (withInitializer && this.initializer != null) {
            if (this.delegated) {
                CodeWriter.emit$default(codeWriter, "♢by♢", false, 2, null);
            } else {
                codeWriter.emitCode("♢=♢");
            }
            CodeWriter.emitCode$default(codeWriter, CodeBlock.INSTANCE.of(this.initializer.hasStatements$kotlinpoet() ? "%L" : "«%L»", UtilKt.trimTrailingNewLine$default(this.initializer, null, 1, null)), this.modifiers.contains(KModifier.CONST), false, false, 12, null);
        }
        codeWriter.emitWhereBlock(this.typeVariables);
        if (!inline) {
            CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(KModifier.class);
        for (KModifier kModifier : implicitModifiers) {
            if (!KModifierKt.getVISIBILITY_MODIFIERS().contains(kModifier)) {
                enumSetNoneOf.add(kModifier);
            }
        }
        if (z) {
            enumSetNoneOf.add(KModifier.INLINE);
        }
        if (this.getter != null) {
            codeWriter.emitCode("⇥");
            FunSpec funSpec3 = this.getter;
            enumSetNoneOf.getClass();
            funSpec3.emit$kotlinpoet(codeWriter, null, enumSetNoneOf, false);
            codeWriter.emitCode("⇤");
        }
        if (this.setter != null) {
            codeWriter.emitCode("⇥");
            FunSpec funSpec4 = this.setter;
            enumSetNoneOf.getClass();
            funSpec4.emit$kotlinpoet(codeWriter, null, enumSetNoneOf, false);
            codeWriter.emitCode("⇤");
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(PropertySpec.class, other.getClass())) {
            return Intrinsics.areEqual(toString(), other.toString());
        }
        return false;
    }

    public final PropertySpec fromPrimaryConstructorParameter$kotlinpoet(ParameterSpec parameter) {
        parameter.getClass();
        Builder builderAddAnnotations = toBuilder$default(this, null, null, 3, null).addAnnotations((Iterable<AnnotationSpec>) parameter.getAnnotations());
        builderAddAnnotations.setPrimaryConstructorParameter$kotlinpoet(true);
        CollectionsKt__MutableCollectionsKt.addAll(builderAddAnnotations.getModifiers(), parameter.getModifiers());
        if (builderAddAnnotations.getKdoc().isEmpty()) {
            builderAddAnnotations.addKdoc(parameter.getKdoc());
        }
        return builderAddAnnotations.build();
    }

    public List<AnnotationSpec> getAnnotations() {
        return this.annotations;
    }

    public List<TypeName> getContextReceiverTypes() {
        return this.contextReceivers;
    }

    public final FunSpec getGetter() {
        return this.getter;
    }

    public final CodeBlock getInitializer() {
        return this.initializer;
    }

    public CodeBlock getKdoc() {
        return this.kdoc;
    }

    public final Set<KModifier> getModifiers() {
        return this.modifiers;
    }

    public final boolean getMutable() {
        return this.mutable;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.squareup.kotlinpoet.OriginatingElementsHolder
    public List<Element> getOriginatingElements() {
        return this.delegateOriginatingElementsHolder.getOriginatingElements();
    }

    public final FunSpec getSetter() {
        return this.setter;
    }

    public final TypeName getType() {
        return this.type;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final Builder toBuilder(String name, TypeName type) {
        name.getClass();
        type.getClass();
        Builder builder = new Builder(name, type);
        builder.setMutable$kotlinpoet(this.mutable);
        builder.getKdoc().add(getKdoc());
        CollectionsKt__MutableCollectionsKt.addAll(builder.getAnnotations(), getAnnotations());
        CollectionsKt__MutableCollectionsKt.addAll(builder.getModifiers(), this.modifiers);
        CollectionsKt__MutableCollectionsKt.addAll(builder.getTypeVariables(), this.typeVariables);
        builder.setInitializer$kotlinpoet(this.initializer);
        builder.setDelegated$kotlinpoet(this.delegated);
        builder.setSetter$kotlinpoet(this.setter);
        builder.setGetter$kotlinpoet(this.getter);
        builder.setReceiverType$kotlinpoet(this.receiverType);
        builder.getTags().putAll(this.tagMap);
        CollectionsKt__MutableCollectionsKt.addAll(builder.getOriginatingElements(), getOriginatingElements());
        CollectionsKt__MutableCollectionsKt.addAll(builder.getContextReceiverTypes(), getContextReceiverTypes());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            try {
                emit$kotlinpoet$default(this, codeWriter, SetsKt.emptySet(), false, false, false, false, 60, null);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(codeWriter, null);
                return sb.toString();
            } catch (Throwable th) {
                th = th;
                codeWriter = codeWriter;
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
        }
    }

    public /* synthetic */ PropertySpec(Builder builder, Map map, OriginatingElementsHolder originatingElementsHolder, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : map, (i & 4) != 0 ? OriginatingElements.m944boximpl(OriginatingElementsHolderKt.buildOriginatingElements(builder)) : originatingElementsHolder, (i & 8) != 0 ? ContextReceivableKt.buildContextReceivers(builder) : list);
    }
}
