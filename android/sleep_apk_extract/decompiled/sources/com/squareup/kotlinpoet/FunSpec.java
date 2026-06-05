package com.squareup.kotlinpoet;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.OriginatingElementsHolder;
import com.squareup.kotlinpoet.TypeSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Element;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u00012\u00020\u00012\u00020\u0001:\u0002feB/\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\fH\u0016¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\u00020\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b(\u0010'J\u001d\u0010)\u001a\u00020\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b)\u0010'J!\u0010*\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0018H\u0002¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u0004\u0018\u00010,*\u00020,H\u0002¢\u0006\u0004\b1\u00102J\u0013\u00103\u001a\u00020,*\u00020,H\u0002¢\u0006\u0004\b3\u00102R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00104R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00105R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00106R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u00107\u001a\u0004\b8\u0010%R\u001a\u00109\u001a\u00020,8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010.R\u0017\u0010<\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b<\u0010:\u001a\u0004\b=\u0010.R\u0017\u0010>\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b>\u0010:\u001a\u0004\b?\u0010.R \u0010B\u001a\b\u0012\u0004\u0012\u00020A0@8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bB\u00106\u001a\u0004\bC\u0010DR\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020I0@8\u0006¢\u0006\f\n\u0004\bJ\u00106\u001a\u0004\bK\u0010DR\u0019\u0010M\u001a\u0004\u0018\u00010L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0017\u0010Q\u001a\u00020L8\u0006¢\u0006\f\n\u0004\bQ\u0010N\u001a\u0004\bR\u0010PR\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000e0@8\u0006¢\u0006\f\n\u0004\bS\u00106\u001a\u0004\bT\u0010DR\u0019\u0010U\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\bU\u00107\u001a\u0004\bV\u0010%R\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020,0@8\u0006¢\u0006\f\n\u0004\bW\u00106\u001a\u0004\bX\u0010DR\u0017\u0010Y\u001a\u00020,8\u0006¢\u0006\f\n\u0004\bY\u0010:\u001a\u0004\bZ\u0010.R\u0014\u0010[\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010\\R\u0011\u0010^\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b^\u00100R\u0011\u0010_\u001a\b\u0012\u0004\u0012\u00020L0@8\u0016X\u0097\u0005R\u0011\u0010a\u001a\b\u0012\u0004\u0012\u00020`0@8\u0016X\u0096\u0005R\u001b\u0010d\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030c\u0012\u0004\u0012\u00020\u00010b8\u0016X\u0096\u0005¨\u0006g"}, d2 = {"Lcom/squareup/kotlinpoet/FunSpec;", "", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder;", "Lcom/squareup/kotlinpoet/FunSpec$Builder;", "builder", "Lcom/squareup/kotlinpoet/TagMap;", "tagMap", "delegateOriginatingElementsHolder", "Lcom/squareup/kotlinpoet/ContextReceivers;", "contextReceivers", "<init>", "(Lcom/squareup/kotlinpoet/FunSpec$Builder;Ljava/util/Map;Lcom/squareup/kotlinpoet/OriginatingElementsHolder;Ljava/util/List;)V", "", "name", "Lcom/squareup/kotlinpoet/ParameterSpec;", "parameter$kotlinpoet", "(Ljava/lang/String;)Lcom/squareup/kotlinpoet/ParameterSpec;", "parameter", "Lcom/squareup/kotlinpoet/CodeWriter;", "codeWriter", "enclosingName", "", "Lcom/squareup/kotlinpoet/KModifier;", "implicitModifiers", "", "includeKdocTags", "", "emit$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeWriter;Ljava/lang/String;Ljava/util/Set;Z)V", "emit", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "shouldOmitBody", "(Ljava/util/Set;)Z", "canNotHaveBody", "canBodyBeOmitted", "emitSignature", "(Lcom/squareup/kotlinpoet/CodeWriter;Ljava/lang/String;)V", "Lcom/squareup/kotlinpoet/CodeBlock;", "kdocWithTags", "()Lcom/squareup/kotlinpoet/CodeBlock;", "emitUnitReturnType", "()Z", "asExpressionBody", "(Lcom/squareup/kotlinpoet/CodeBlock;)Lcom/squareup/kotlinpoet/CodeBlock;", "returnsWithoutLinebreak", "Ljava/util/Map;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder;", "Ljava/util/List;", "Ljava/lang/String;", "getName", "kdoc", "Lcom/squareup/kotlinpoet/CodeBlock;", "getKdoc", "returnKdoc", "getReturnKdoc", "receiverKdoc", "getReceiverKdoc", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotations", "getAnnotations", "()Ljava/util/List;", "modifiers", "Ljava/util/Set;", "getModifiers", "()Ljava/util/Set;", "Lcom/squareup/kotlinpoet/TypeVariableName;", "typeVariables", "getTypeVariables", "Lcom/squareup/kotlinpoet/TypeName;", "receiverType", "Lcom/squareup/kotlinpoet/TypeName;", "getReceiverType", "()Lcom/squareup/kotlinpoet/TypeName;", "returnType", "getReturnType", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "getParameters", "delegateConstructor", "getDelegateConstructor", "delegateConstructorArguments", "getDelegateConstructorArguments", SDKConstants.PARAM_A2U_BODY, "getBody", "isExternalGetter", "Z", "isEmptySetter", "isConstructor", "contextReceiverTypes", "Ljavax/lang/model/element/Element;", "originatingElements", "", "Lkotlin/reflect/KClass;", "tags", "Companion", "Builder", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FunSpec implements OriginatingElementsHolder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CodeBlock RETURN_EXPRESSION_BODY_PREFIX_NBSP;
    private static final CodeBlock RETURN_EXPRESSION_BODY_PREFIX_SPACE;
    private static final CodeBlock THROW_EXPRESSION_BODY_PREFIX_NBSP;
    private static final CodeBlock THROW_EXPRESSION_BODY_PREFIX_SPACE;
    private final List<AnnotationSpec> annotations;
    private final CodeBlock body;
    private final List<? extends TypeName> contextReceivers;
    private final String delegateConstructor;
    private final List<CodeBlock> delegateConstructorArguments;
    private final OriginatingElementsHolder delegateOriginatingElementsHolder;
    private final boolean isEmptySetter;
    private final boolean isExternalGetter;
    private final CodeBlock kdoc;
    private final Set<KModifier> modifiers;
    private final String name;
    private final List<ParameterSpec> parameters;
    private final CodeBlock receiverKdoc;
    private final TypeName receiverType;
    private final CodeBlock returnKdoc;
    private final TypeName returnType;
    private final Map<KClass<?>, ? extends Object> tagMap;
    private final List<TypeVariableName> typeVariables;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u00020\u000b*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u00020\u000b*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00048\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/squareup/kotlinpoet/FunSpec$Companion;", "", "<init>", "()V", "", "name", "Lcom/squareup/kotlinpoet/FunSpec$Builder;", "builder", "(Ljava/lang/String;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "constructorBuilder", "()Lcom/squareup/kotlinpoet/FunSpec$Builder;", "", "isConstructor$kotlinpoet", "(Ljava/lang/String;)Z", "isConstructor", "isAccessor$kotlinpoet", "isAccessor", "CONSTRUCTOR", "Ljava/lang/String;", "GETTER", "SETTER", "Lcom/squareup/kotlinpoet/CodeBlock;", "RETURN_EXPRESSION_BODY_PREFIX_SPACE", "Lcom/squareup/kotlinpoet/CodeBlock;", "RETURN_EXPRESSION_BODY_PREFIX_NBSP", "THROW_EXPRESSION_BODY_PREFIX_SPACE", "THROW_EXPRESSION_BODY_PREFIX_NBSP", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder builder(String name) {
            name.getClass();
            return new Builder(name);
        }

        public final Builder constructorBuilder() {
            return new Builder("constructor()");
        }

        public final boolean isAccessor$kotlinpoet(String str) {
            str.getClass();
            return UtilKt.isOneOf$default(str, "get()", "set()", null, null, null, null, 60, null);
        }

        public final boolean isConstructor$kotlinpoet(String str) {
            str.getClass();
            return Intrinsics.areEqual(str, "constructor()");
        }

        private Companion() {
        }
    }

    static {
        CodeBlock.Companion companion = CodeBlock.INSTANCE;
        RETURN_EXPRESSION_BODY_PREFIX_SPACE = companion.of("return ", new Object[0]);
        RETURN_EXPRESSION_BODY_PREFIX_NBSP = companion.of("return·", new Object[0]);
        THROW_EXPRESSION_BODY_PREFIX_SPACE = companion.of("throw ", new Object[0]);
        THROW_EXPRESSION_BODY_PREFIX_NBSP = companion.of("throw·", new Object[0]);
    }

    private FunSpec(Builder builder, Map<KClass<?>, ? extends Object> map, OriginatingElementsHolder originatingElementsHolder, List<? extends TypeName> list) {
        this.tagMap = map;
        this.delegateOriginatingElementsHolder = originatingElementsHolder;
        this.contextReceivers = list;
        String name = builder.getName();
        this.name = name;
        this.kdoc = builder.getKdoc().build();
        this.returnKdoc = builder.getReturnKdoc();
        this.receiverKdoc = builder.getReceiverKdoc();
        this.annotations = UtilKt.toImmutableList(builder.getAnnotations());
        Set<KModifier> immutableSet = UtilKt.toImmutableSet(builder.getModifiers());
        this.modifiers = immutableSet;
        List<TypeVariableName> immutableList = UtilKt.toImmutableList(builder.getTypeVariables());
        this.typeVariables = immutableList;
        this.receiverType = builder.getReceiverType();
        this.returnType = builder.getReturnType();
        List<ParameterSpec> immutableList2 = UtilKt.toImmutableList(builder.getParameters());
        this.parameters = immutableList2;
        this.delegateConstructor = builder.getDelegateConstructor();
        this.delegateConstructorArguments = UtilKt.toImmutableList(builder.getDelegateConstructorArguments$kotlinpoet());
        CodeBlock codeBlockBuild = builder.getBody().build();
        this.body = codeBlockBuild;
        boolean z = false;
        boolean z2 = Intrinsics.areEqual(name, "get()") && builder.getModifiers().contains(KModifier.EXTERNAL);
        this.isExternalGetter = z2;
        if (Intrinsics.areEqual(name, "set()") && immutableList2.isEmpty()) {
            z = true;
        }
        this.isEmptySetter = z;
        if (!codeBlockBuild.isEmpty() && UtilKt.containsAnyOf(builder.getModifiers(), KModifier.ABSTRACT, KModifier.EXPECT)) {
            Home$$ExternalSyntheticBUOutline0.m("abstract or expect function ", builder.getName(), " cannot have code");
            throw null;
        }
        if (Intrinsics.areEqual(name, "get()")) {
            if (z2 && !codeBlockBuild.isEmpty()) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("external getter cannot have code");
                throw null;
            }
        } else if (Intrinsics.areEqual(name, "set()")) {
            if (immutableList2.size() > 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m$1(name, " can have at most one parameter"));
                throw null;
            }
            if (immutableList2.isEmpty() && !codeBlockBuild.isEmpty()) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("parameterless setter cannot have code");
                throw null;
            }
        }
        if (immutableSet.contains(KModifier.INLINE)) {
            return;
        }
        List<TypeVariableName> list2 = immutableList;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (((TypeVariableName) it.next()).getIsReified()) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("only type parameters of inline functions can be reified!");
                throw null;
            }
        }
    }

    private final CodeBlock asExpressionBody(CodeBlock codeBlock) {
        CodeBlock codeBlockTrim$kotlinpoet = codeBlock.trim$kotlinpoet();
        CodeBlock codeBlockWithoutPrefix$kotlinpoet = codeBlockTrim$kotlinpoet.withoutPrefix$kotlinpoet(RETURN_EXPRESSION_BODY_PREFIX_SPACE);
        if (codeBlockWithoutPrefix$kotlinpoet == null) {
            codeBlockWithoutPrefix$kotlinpoet = codeBlockTrim$kotlinpoet.withoutPrefix$kotlinpoet(RETURN_EXPRESSION_BODY_PREFIX_NBSP);
        }
        if (codeBlockWithoutPrefix$kotlinpoet != null) {
            return codeBlockWithoutPrefix$kotlinpoet;
        }
        if (codeBlockTrim$kotlinpoet.withoutPrefix$kotlinpoet(THROW_EXPRESSION_BODY_PREFIX_SPACE) == null && codeBlockTrim$kotlinpoet.withoutPrefix$kotlinpoet(THROW_EXPRESSION_BODY_PREFIX_NBSP) == null) {
            return null;
        }
        return codeBlockTrim$kotlinpoet;
    }

    private final boolean canBodyBeOmitted(Set<? extends KModifier> implicitModifiers) {
        return isConstructor() || SetsKt.plus((Set) this.modifiers, (Iterable) implicitModifiers).contains(KModifier.EXTERNAL) || this.modifiers.contains(KModifier.ABSTRACT);
    }

    private final boolean canNotHaveBody(Set<? extends KModifier> implicitModifiers) {
        return this.modifiers.contains(KModifier.ABSTRACT) || SetsKt.plus((Set) this.modifiers, (Iterable) implicitModifiers).contains(KModifier.EXPECT);
    }

    private final void emitSignature(CodeWriter codeWriter, String enclosingName) throws Throwable {
        CodeWriter codeWriter2;
        if (isConstructor()) {
            codeWriter.emitCode("constructor", enclosingName);
        } else if (Intrinsics.areEqual(this.name, "get()")) {
            codeWriter.emitCode("get");
        } else if (Intrinsics.areEqual(this.name, "set()")) {
            codeWriter.emitCode("set");
        } else {
            TypeName typeName = this.receiverType;
            if (typeName != null) {
                codeWriter.emitCode("%T.", typeName);
            }
            codeWriter.emitCode("%N", this);
        }
        if (this.isEmptySetter || this.isExternalGetter) {
            codeWriter2 = codeWriter;
        } else {
            codeWriter2 = codeWriter;
            ParameterSpecKt.emit$default(this.parameters, codeWriter2, false, new FunSpec$$ExternalSyntheticLambda1(codeWriter, this, 0), 2, null);
        }
        if (!Intrinsics.areEqual(this.returnType, TypeNames.UNIT) || emitUnitReturnType()) {
            codeWriter2.emitCode(": %T", this.returnType);
        }
        if (this.delegateConstructor != null) {
            CodeWriter.emitCode$default(codeWriter2, CodeBlocks.joinToCode$default(this.delegateConstructorArguments, null, FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(" : "), this.delegateConstructor, '('), ")", 1, null), false, false, false, 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit emitSignature$lambda$8(CodeWriter codeWriter, FunSpec funSpec, ParameterSpec parameterSpec) throws Throwable {
        codeWriter.getClass();
        funSpec.getClass();
        parameterSpec.getClass();
        ParameterSpec.emit$kotlinpoet$default(parameterSpec, codeWriter, !Intrinsics.areEqual(funSpec.name, "set()"), false, 4, null);
        return Unit.INSTANCE;
    }

    private final boolean emitUnitReturnType() {
        return (isConstructor() || Intrinsics.areEqual(this.name, "get()") || Intrinsics.areEqual(this.name, "set()") || asExpressionBody(this.body) == null) ? false : true;
    }

    private final CodeBlock kdocWithTags() {
        boolean z;
        CodeBlock.Builder builder = UtilKt.ensureEndsWithNewLine(getKdoc()).toBuilder();
        boolean zIsNotEmpty = builder.isNotEmpty();
        if (this.receiverKdoc.isNotEmpty()) {
            if (zIsNotEmpty) {
                builder.add("\n", new Object[0]);
                z = true;
            } else {
                z = false;
            }
            builder.add("@receiver %L", UtilKt.ensureEndsWithNewLine(this.receiverKdoc));
        } else {
            z = false;
        }
        int i = 0;
        for (Object obj : this.parameters) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ParameterSpec parameterSpec = (ParameterSpec) obj;
            if (parameterSpec.getKdoc().isNotEmpty()) {
                if (!z && i == 0 && zIsNotEmpty) {
                    builder.add("\n", new Object[0]);
                    z = true;
                }
                builder.add("@param %L %L", parameterSpec.getName(), UtilKt.ensureEndsWithNewLine(parameterSpec.getKdoc()));
            }
            i = i2;
        }
        if (this.returnKdoc.isNotEmpty()) {
            if (!z && zIsNotEmpty) {
                builder.add("\n", new Object[0]);
            }
            builder.add("@return %L", UtilKt.ensureEndsWithNewLine(this.returnKdoc));
        }
        return builder.build();
    }

    private final CodeBlock returnsWithoutLinebreak(CodeBlock codeBlock) {
        CodeBlock codeBlockBuild;
        int i = 0;
        String str = RETURN_EXPRESSION_BODY_PREFIX_SPACE.getFormatParts$kotlinpoet().get(0);
        String str2 = RETURN_EXPRESSION_BODY_PREFIX_NBSP.getFormatParts$kotlinpoet().get(0);
        CodeBlock.Builder builder = null;
        for (String str3 : codeBlock.getFormatParts$kotlinpoet()) {
            int i2 = i + 1;
            if (StringsKt.startsWith$default(str3, str)) {
                if (builder == null) {
                    builder = codeBlock.toBuilder();
                }
                builder.getFormatParts$kotlinpoet().set(i, StringsKt__StringsJVMKt.replaceFirst$default(str3, str, str2, false, 4, null));
            }
            i = i2;
        }
        return (builder == null || (codeBlockBuild = builder.build()) == null) ? codeBlock : codeBlockBuild;
    }

    private final boolean shouldOmitBody(Set<? extends KModifier> implicitModifiers) {
        if (!canNotHaveBody(implicitModifiers)) {
            return canBodyBeOmitted(implicitModifiers) && this.body.isEmpty();
        }
        if (this.body.isEmpty()) {
            return true;
        }
        Utf8$$ExternalSyntheticBUOutline0.m((Object) FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("function "), this.name, " cannot have code"));
        return false;
    }

    public final void emit$kotlinpoet(CodeWriter codeWriter, String enclosingName, Set<? extends KModifier> implicitModifiers, boolean includeKdocTags) {
        codeWriter.getClass();
        implicitModifiers.getClass();
        if (includeKdocTags) {
            codeWriter.emitKdoc(kdocWithTags());
        } else {
            codeWriter.emitKdoc(UtilKt.ensureEndsWithNewLine(getKdoc()));
        }
        codeWriter.emitContextReceivers(getContextReceiverTypes(), "\n");
        codeWriter.emitAnnotations(getAnnotations(), false);
        codeWriter.emitModifiers(this.modifiers, implicitModifiers);
        if (!isConstructor() && !INSTANCE.isAccessor$kotlinpoet(this.name)) {
            codeWriter.emitCode("fun ");
        }
        if (!this.typeVariables.isEmpty()) {
            codeWriter.emitTypeVariables(this.typeVariables);
            CodeWriter.emit$default(codeWriter, " ", false, 2, null);
        }
        emitSignature(codeWriter, enclosingName);
        codeWriter.emitWhereBlock(this.typeVariables);
        if (shouldOmitBody(implicitModifiers)) {
            CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
            return;
        }
        CodeBlock codeBlockAsExpressionBody = asExpressionBody(this.body);
        if (codeBlockAsExpressionBody != null) {
            CodeWriter.emitCode$default(codeWriter, CodeBlock.INSTANCE.of(" = %L", codeBlockAsExpressionBody), false, true, false, 10, null);
            return;
        }
        if (this.isEmptySetter) {
            CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
            return;
        }
        codeWriter.emitCode(" {\n");
        CodeWriter.indent$default(codeWriter, 0, 1, null);
        CodeWriter.emitCode$default(codeWriter, returnsWithoutLinebreak(this.body), false, true, false, 10, null);
        CodeWriter.unindent$default(codeWriter, 0, 1, null);
        CodeWriter.emit$default(codeWriter, "}\n", false, 2, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(FunSpec.class, other.getClass())) {
            return Intrinsics.areEqual(toString(), other.toString());
        }
        return false;
    }

    public List<AnnotationSpec> getAnnotations() {
        return this.annotations;
    }

    public final CodeBlock getBody() {
        return this.body;
    }

    public List<TypeName> getContextReceiverTypes() {
        return this.contextReceivers;
    }

    public final String getDelegateConstructor() {
        return this.delegateConstructor;
    }

    public final List<CodeBlock> getDelegateConstructorArguments() {
        return this.delegateConstructorArguments;
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

    @Override // com.squareup.kotlinpoet.OriginatingElementsHolder
    public List<Element> getOriginatingElements() {
        return this.delegateOriginatingElementsHolder.getOriginatingElements();
    }

    public final List<ParameterSpec> getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final boolean isConstructor() {
        return INSTANCE.isConstructor$kotlinpoet(this.name);
    }

    public final ParameterSpec parameter$kotlinpoet(String name) {
        Object next;
        name.getClass();
        Iterator<T> it = this.parameters.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((ParameterSpec) next).getName(), name)) {
                break;
            }
        }
        return (ParameterSpec) next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            emit$kotlinpoet(codeWriter, "Constructor", TypeSpec.Kind.implicitFunctionModifiers$kotlinpoet$default(TypeSpec.Kind.CLASS, null, 1, null), true);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(codeWriter, null);
            return sb.toString();
        } finally {
        }
    }

    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u00042\b\u0012\u0004\u0012\u00020\u00000\u0005B\u0011\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000f2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R$\u00101\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u00102\u001a\u0004\b7\u00104\"\u0004\b8\u00106R$\u00109\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b9\u0010%\u001a\u0004\b:\u0010'\"\u0004\b;\u0010\tR(\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00110<8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010D\u001a\u00020C8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001a\u0010\u0012\u001a\u00020C8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010E\u001a\u0004\bH\u0010GR \u0010J\u001a\b\u0012\u0004\u0012\u00020\u001e0I8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bJ\u0010>\u001a\u0004\bK\u0010@R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0I8\u0006¢\u0006\f\n\u0004\b\f\u0010>\u001a\u0004\bL\u0010@R\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020M0I8\u0006¢\u0006\f\n\u0004\bN\u0010>\u001a\u0004\bO\u0010@R\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00150I8\u0006¢\u0006\f\n\u0004\bP\u0010>\u001a\u0004\bQ\u0010@R*\u0010U\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030S\u0012\u0004\u0012\u00020T0R8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR \u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0I8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bZ\u0010>\u001a\u0004\b[\u0010@R&\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000f0I8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\\\u0010>\u0012\u0004\b^\u0010_\u001a\u0004\b]\u0010@¨\u0006`"}, d2 = {"Lcom/squareup/kotlinpoet/FunSpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder$Builder;", "Lcom/squareup/kotlinpoet/ContextReceivable$Builder;", "Lcom/squareup/kotlinpoet/Annotatable$Builder;", "Lcom/squareup/kotlinpoet/Documentable$Builder;", "", "name", "<init>", "(Ljava/lang/String;)V", "", "Lcom/squareup/kotlinpoet/KModifier;", "modifiers", "addModifiers", "([Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "Lcom/squareup/kotlinpoet/TypeName;", "returnType", "Lcom/squareup/kotlinpoet/CodeBlock;", "kdoc", "returns", "(Lcom/squareup/kotlinpoet/TypeName;Lcom/squareup/kotlinpoet/CodeBlock;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "Lcom/squareup/kotlinpoet/ParameterSpec;", "parameterSpec", "addParameter", "(Lcom/squareup/kotlinpoet/ParameterSpec;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "type", "(Ljava/lang/String;Lcom/squareup/kotlinpoet/TypeName;[Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "codeBlock", "addCode", "(Lcom/squareup/kotlinpoet/CodeBlock;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotationSpec", "addAnnotation", "(Lcom/squareup/kotlinpoet/AnnotationSpec;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "Lcom/squareup/kotlinpoet/FunSpec;", InAppPurchaseConstants.METHOD_BUILD, "()Lcom/squareup/kotlinpoet/FunSpec;", "Ljava/lang/String;", "getName$kotlinpoet", "()Ljava/lang/String;", "returnKdoc", "Lcom/squareup/kotlinpoet/CodeBlock;", "getReturnKdoc$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock;", "setReturnKdoc$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeBlock;)V", "receiverKdoc", "getReceiverKdoc$kotlinpoet", "setReceiverKdoc$kotlinpoet", "receiverType", "Lcom/squareup/kotlinpoet/TypeName;", "getReceiverType$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeName;", "setReceiverType$kotlinpoet", "(Lcom/squareup/kotlinpoet/TypeName;)V", "getReturnType$kotlinpoet", "setReturnType$kotlinpoet", "delegateConstructor", "getDelegateConstructor$kotlinpoet", "setDelegateConstructor$kotlinpoet", "", "delegateConstructorArguments", "Ljava/util/List;", "getDelegateConstructorArguments$kotlinpoet", "()Ljava/util/List;", "setDelegateConstructorArguments$kotlinpoet", "(Ljava/util/List;)V", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", SDKConstants.PARAM_A2U_BODY, "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getBody$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getKdoc", "", "annotations", "getAnnotations", "getModifiers", "Lcom/squareup/kotlinpoet/TypeVariableName;", "typeVariables", "getTypeVariables", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "getParameters", "", "Lkotlin/reflect/KClass;", "", "tags", "Ljava/util/Map;", "getTags", "()Ljava/util/Map;", "Ljavax/lang/model/element/Element;", "originatingElements", "getOriginatingElements", "contextReceiverTypes", "getContextReceiverTypes", "getContextReceiverTypes$annotations", "()V", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder implements Taggable$Builder<Builder>, OriginatingElementsHolder.Builder<Builder>, ContextReceivable$Builder<Builder>, Annotatable$Builder<Builder>, Documentable$Builder<Builder> {
        private final List<AnnotationSpec> annotations;
        private final CodeBlock.Builder body;
        private final List<TypeName> contextReceiverTypes;
        private String delegateConstructor;
        private List<CodeBlock> delegateConstructorArguments;
        private final CodeBlock.Builder kdoc;
        private final List<KModifier> modifiers;
        private final String name;
        private final List<Element> originatingElements;
        private final List<ParameterSpec> parameters;
        private CodeBlock receiverKdoc;
        private TypeName receiverType;
        private CodeBlock returnKdoc;
        private TypeName returnType;
        private final Map<KClass<?>, Object> tags;
        private final List<TypeVariableName> typeVariables;

        public Builder(String str) {
            str.getClass();
            this.name = str;
            CodeBlock.Companion companion = CodeBlock.INSTANCE;
            this.returnKdoc = companion.getEMPTY$kotlinpoet();
            this.receiverKdoc = companion.getEMPTY$kotlinpoet();
            this.returnType = TypeNames.UNIT;
            this.delegateConstructorArguments = CollectionsKt.emptyList();
            this.body = companion.builder();
            this.kdoc = companion.builder();
            this.annotations = new ArrayList();
            this.modifiers = new ArrayList();
            this.typeVariables = new ArrayList();
            this.parameters = new ArrayList();
            this.tags = new LinkedHashMap();
            this.originatingElements = new ArrayList();
            this.contextReceiverTypes = new ArrayList();
        }

        public static /* synthetic */ Builder returns$default(Builder builder, TypeName typeName, CodeBlock codeBlock, int i, Object obj) {
            if ((i & 2) != 0) {
                codeBlock = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            return builder.returns(typeName, codeBlock);
        }

        @Override // com.squareup.kotlinpoet.Annotatable$Builder
        public Builder addAnnotation(AnnotationSpec annotationSpec) {
            annotationSpec.getClass();
            return (Builder) super.addAnnotation(annotationSpec);
        }

        public final Builder addCode(CodeBlock codeBlock) {
            codeBlock.getClass();
            this.body.add(codeBlock);
            return this;
        }

        public final Builder addModifiers(KModifier... modifiers) {
            modifiers.getClass();
            CollectionsKt__MutableCollectionsKt.addAll(this.modifiers, modifiers);
            return this;
        }

        public final Builder addParameter(String name, TypeName type, KModifier... modifiers) {
            name.getClass();
            type.getClass();
            modifiers.getClass();
            return addParameter(ParameterSpec.INSTANCE.builder(name, type, (KModifier[]) Arrays.copyOf(modifiers, modifiers.length)).build());
        }

        public final FunSpec build() {
            if (!this.typeVariables.isEmpty() && FunSpec.INSTANCE.isAccessor$kotlinpoet(this.name)) {
                Utf8$$ExternalSyntheticBUOutline0.m((Object) FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), this.name, " cannot have type variables"));
                return null;
            }
            if (Intrinsics.areEqual(this.name, "get()") && !this.parameters.isEmpty()) {
                Utf8$$ExternalSyntheticBUOutline0.m((Object) FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), this.name, " cannot have parameters"));
                return null;
            }
            if (Intrinsics.areEqual(this.name, "set()") && this.parameters.size() > 1) {
                Utf8$$ExternalSyntheticBUOutline0.m((Object) FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), this.name, " can have at most one parameter"));
                return null;
            }
            return new FunSpec(this, null, null, null, 14, null);
        }

        @Override // com.squareup.kotlinpoet.Annotatable$Builder
        public List<AnnotationSpec> getAnnotations() {
            return this.annotations;
        }

        /* JADX INFO: renamed from: getBody$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getBody() {
            return this.body;
        }

        @Override // com.squareup.kotlinpoet.ContextReceivable$Builder
        public List<TypeName> getContextReceiverTypes() {
            return this.contextReceiverTypes;
        }

        /* JADX INFO: renamed from: getDelegateConstructor$kotlinpoet, reason: from getter */
        public final String getDelegateConstructor() {
            return this.delegateConstructor;
        }

        public final List<CodeBlock> getDelegateConstructorArguments$kotlinpoet() {
            return this.delegateConstructorArguments;
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

        @Override // com.squareup.kotlinpoet.OriginatingElementsHolder.Builder
        public List<Element> getOriginatingElements() {
            return this.originatingElements;
        }

        public final List<ParameterSpec> getParameters() {
            return this.parameters;
        }

        /* JADX INFO: renamed from: getReceiverKdoc$kotlinpoet, reason: from getter */
        public final CodeBlock getReceiverKdoc() {
            return this.receiverKdoc;
        }

        /* JADX INFO: renamed from: getReceiverType$kotlinpoet, reason: from getter */
        public final TypeName getReceiverType() {
            return this.receiverType;
        }

        /* JADX INFO: renamed from: getReturnKdoc$kotlinpoet, reason: from getter */
        public final CodeBlock getReturnKdoc() {
            return this.returnKdoc;
        }

        /* JADX INFO: renamed from: getReturnType$kotlinpoet, reason: from getter */
        public final TypeName getReturnType() {
            return this.returnType;
        }

        @Override // com.squareup.kotlinpoet.Taggable$Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        public final List<TypeVariableName> getTypeVariables() {
            return this.typeVariables;
        }

        public final Builder returns(TypeName returnType, CodeBlock kdoc) {
            returnType.getClass();
            kdoc.getClass();
            Companion companion = FunSpec.INSTANCE;
            if (companion.isConstructor$kotlinpoet(this.name) || companion.isAccessor$kotlinpoet(this.name)) {
                Utf8$$ExternalSyntheticBUOutline0.m((Object) FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), this.name, " cannot have a return type"));
                return null;
            }
            this.returnType = returnType;
            this.returnKdoc = kdoc;
            return this;
        }

        public final Builder addParameter(ParameterSpec parameterSpec) {
            parameterSpec.getClass();
            this.parameters.add(parameterSpec);
            return this;
        }
    }

    public /* synthetic */ FunSpec(Builder builder, Map map, OriginatingElementsHolder originatingElementsHolder, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : map, (i & 4) != 0 ? OriginatingElements.m944boximpl(OriginatingElementsHolderKt.buildOriginatingElements(builder)) : originatingElementsHolder, (i & 8) != 0 ? ContextReceivableKt.buildContextReceivers(builder) : list);
    }
}
