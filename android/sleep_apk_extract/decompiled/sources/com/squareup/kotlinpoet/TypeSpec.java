package com.squareup.kotlinpoet;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.OriginatingElementsHolder;
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
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 t2\u00020\u00012\u00020\u00022\u00020\u00012\u00020\u00012\u00020\u00012\u00020\u00012\u00020\u0001:\u0003uvtB/\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ;\u0010\u0018\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"0!H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010(\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\"2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010-R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010.R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0019\u00105\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010 R\u001a\u00108\u001a\u00020*8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010,R \u0010=\u001a\b\u0012\u0004\u0012\u00020<0;8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b=\u0010/\u001a\u0004\b>\u0010?R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020D0;8\u0006¢\u0006\f\n\u0004\bE\u0010/\u001a\u0004\bF\u0010?R\u0019\u0010H\u001a\u0004\u0018\u00010G8\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010M\u001a\u00020L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020*0;8\u0006¢\u0006\f\n\u0004\bQ\u0010/\u001a\u0004\bR\u0010?R\u0017\u0010S\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bS\u0010UR\u0017\u0010V\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\bV\u0010T\u001a\u0004\bV\u0010UR\u0017\u0010W\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\bW\u0010T\u001a\u0004\bW\u0010UR\u0017\u0010X\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\bX\u0010T\u001a\u0004\bX\u0010UR\u0017\u0010Y\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\bY\u0010T\u001a\u0004\bY\u0010UR%\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020L\u0012\u0006\u0012\u0004\u0018\u00010*0!8\u0006¢\u0006\f\n\u0004\bZ\u0010-\u001a\u0004\b[\u0010$R#\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00000!8\u0006¢\u0006\f\n\u0004\b\\\u0010-\u001a\u0004\b]\u0010$R \u0010^\u001a\b\u0012\u0004\u0012\u00020\"0;8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b^\u0010/\u001a\u0004\b_\u0010?R\u0017\u0010`\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b`\u00109\u001a\u0004\ba\u0010,R\u0017\u0010b\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010\u001eR \u0010e\u001a\b\u0012\u0004\u0012\u00020G0;8\u0016X\u0096\u0004¢\u0006\f\n\u0004\be\u0010/\u001a\u0004\bf\u0010?R \u0010g\u001a\b\u0012\u0004\u0012\u00020\u00000;8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bg\u0010/\u001a\u0004\bh\u0010?R\"\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\bi\u0010A\u001a\u0004\bj\u0010CR\u0014\u0010l\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010UR\u0014\u0010n\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u0010UR\u0011\u0010o\u001a\b\u0012\u0004\u0012\u00020L0;8\u0016X\u0097\u0005R\u0011\u0010q\u001a\b\u0012\u0004\u0012\u00020p0;8\u0016X\u0096\u0005R\u001b\u0010s\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030r\u0012\u0004\u0012\u00020\u00010!8\u0016X\u0096\u0005¨\u0006w"}, d2 = {"Lcom/squareup/kotlinpoet/TypeSpec;", "", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder;", "Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "builder", "Lcom/squareup/kotlinpoet/TagMap;", "tagMap", "delegateOriginatingElements", "Lcom/squareup/kotlinpoet/ContextReceivers;", "contextReceivers", "<init>", "(Lcom/squareup/kotlinpoet/TypeSpec$Builder;Ljava/util/Map;Lcom/squareup/kotlinpoet/OriginatingElementsHolder;Ljava/util/List;)V", "Lcom/squareup/kotlinpoet/CodeWriter;", "codeWriter", "", "enumName", "", "Lcom/squareup/kotlinpoet/KModifier;", "implicitModifiers", "", "isNestedExternal", "", "emit$kotlinpoet", "(Lcom/squareup/kotlinpoet/CodeWriter;Ljava/lang/String;Ljava/util/Set;Z)V", "emit", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "Lcom/squareup/kotlinpoet/PropertySpec;", "constructorProperties", "()Ljava/util/Map;", "property", "Lcom/squareup/kotlinpoet/ParameterSpec;", "parameter", "isPropertyInitializerConstructorParameter", "(Lcom/squareup/kotlinpoet/PropertySpec;Lcom/squareup/kotlinpoet/ParameterSpec;)Z", "Lcom/squareup/kotlinpoet/CodeBlock;", "kdocWithConstructorDocs", "()Lcom/squareup/kotlinpoet/CodeBlock;", "Ljava/util/Map;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder;", "Ljava/util/List;", "Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "kind", "Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "getKind", "()Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "name", "Ljava/lang/String;", "getName", "kdoc", "Lcom/squareup/kotlinpoet/CodeBlock;", "getKdoc", "", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotations", "getAnnotations", "()Ljava/util/List;", "modifiers", "Ljava/util/Set;", "getModifiers", "()Ljava/util/Set;", "Lcom/squareup/kotlinpoet/TypeVariableName;", "typeVariables", "getTypeVariables", "Lcom/squareup/kotlinpoet/FunSpec;", "primaryConstructor", "Lcom/squareup/kotlinpoet/FunSpec;", "getPrimaryConstructor", "()Lcom/squareup/kotlinpoet/FunSpec;", "Lcom/squareup/kotlinpoet/TypeName;", "superclass", "Lcom/squareup/kotlinpoet/TypeName;", "getSuperclass", "()Lcom/squareup/kotlinpoet/TypeName;", "superclassConstructorParameters", "getSuperclassConstructorParameters", "isEnum", "Z", "()Z", "isAnnotation", "isCompanion", "isAnonymousClass", "isFunctionalInterface", "superinterfaces", "getSuperinterfaces", "enumConstants", "getEnumConstants", "propertySpecs", "getPropertySpecs", "initializerBlock", "getInitializerBlock", "initializerIndex", "I", "getInitializerIndex", "funSpecs", "getFunSpecs", "typeSpecs", "getTypeSpecs", "nestedTypesSimpleNames", "getNestedTypesSimpleNames$kotlinpoet", "getHasInitializer", "hasInitializer", "getHasNoBody", "hasNoBody", "contextReceiverTypes", "Ljavax/lang/model/element/Element;", "originatingElements", "Lkotlin/reflect/KClass;", "tags", "Companion", "Kind", "Builder", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TypeSpec implements OriginatingElementsHolder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnnotationSpec> annotations;
    private final List<? extends TypeName> contextReceivers;
    private final OriginatingElementsHolder delegateOriginatingElements;
    private final Map<String, TypeSpec> enumConstants;
    private final List<FunSpec> funSpecs;
    private final CodeBlock initializerBlock;
    private final int initializerIndex;
    private final boolean isAnnotation;
    private final boolean isAnonymousClass;
    private final boolean isCompanion;
    private final boolean isEnum;
    private final boolean isFunctionalInterface;
    private final CodeBlock kdoc;
    private final Kind kind;
    private final Set<KModifier> modifiers;
    private final String name;
    private final Set<String> nestedTypesSimpleNames;
    private final FunSpec primaryConstructor;
    private final List<PropertySpec> propertySpecs;
    private final TypeName superclass;
    private final List<CodeBlock> superclassConstructorParameters;
    private final Map<TypeName, CodeBlock> superinterfaces;
    private final Map<KClass<?>, ? extends Object> tagMap;
    private final List<TypeSpec> typeSpecs;
    private final List<TypeVariableName> typeVariables;

    @Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u00042\b\u0012\u0004\u0012\u00020\u00000\u00052\b\u0012\u0004\u0012\u00020\u00000\u00062\b\u0012\u0004\u0012\u00020\u00000\u0006B/\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\"\u0010\u0014J\u0017\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020#¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b.\u0010/R\"\u0010\b\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u00105\u001a\u0004\b6\u00107R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0016\u001a\u00020\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010C\u001a\u00020B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR*\u0010P\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030O\u0012\u0004\u0012\u00020\u00060N8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020B8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bT\u0010D\u001a\u0004\bU\u0010FR \u0010X\u001a\b\u0012\u0004\u0012\u00020W0V8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R \u0010\\\u001a\b\u0012\u0004\u0012\u00020'0V8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\\\u0010Y\u001a\u0004\b]\u0010[R&\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00150V8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b^\u0010Y\u0012\u0004\b`\u0010/\u001a\u0004\b_\u0010[R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0a8\u0006¢\u0006\f\n\u0004\b\r\u0010b\u001a\u0004\bc\u0010dR%\u0010e\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00190N8\u0006¢\u0006\f\n\u0004\be\u0010Q\u001a\u0004\bf\u0010SR#\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#0N8\u0006¢\u0006\f\n\u0004\bg\u0010Q\u001a\u0004\bh\u0010SR\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020i0V8\u0006¢\u0006\f\n\u0004\bj\u0010Y\u001a\u0004\bk\u0010[R\u001d\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00190V8\u0006¢\u0006\f\n\u0004\bl\u0010Y\u001a\u0004\bm\u0010[R\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020\u001d0V8\u0006¢\u0006\f\n\u0004\bn\u0010Y\u001a\u0004\bo\u0010[R\u001d\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00120V8\u0006¢\u0006\f\n\u0004\bp\u0010Y\u001a\u0004\bq\u0010[R\u001d\u0010r\u001a\b\u0012\u0004\u0012\u00020#0V8\u0006¢\u0006\f\n\u0004\br\u0010Y\u001a\u0004\bs\u0010[R\u0014\u0010w\u001a\u00020t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0014\u0010y\u001a\u00020t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bx\u0010vR\u0014\u0010{\u001a\u00020t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bz\u0010vR\u0014\u0010}\u001a\u00020t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b|\u0010vR\u0014\u0010\u007f\u001a\u00020t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b~\u0010vR\u0016\u0010\u0081\u0001\u001a\u00020t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010vR\u0016\u0010\u0083\u0001\u001a\u00020t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010vR\u0016\u0010\u0085\u0001\u001a\u00020t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010v¨\u0006\u0086\u0001"}, d2 = {"Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "Lcom/squareup/kotlinpoet/Taggable$Builder;", "Lcom/squareup/kotlinpoet/OriginatingElementsHolder$Builder;", "Lcom/squareup/kotlinpoet/ContextReceivable$Builder;", "Lcom/squareup/kotlinpoet/Annotatable$Builder;", "Lcom/squareup/kotlinpoet/Documentable$Builder;", "", "Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "kind", "", "name", "", "Lcom/squareup/kotlinpoet/KModifier;", "modifiers", "<init>", "(Lcom/squareup/kotlinpoet/TypeSpec$Kind;Ljava/lang/String;[Lcom/squareup/kotlinpoet/KModifier;)V", "addModifiers", "([Lcom/squareup/kotlinpoet/KModifier;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "Lcom/squareup/kotlinpoet/FunSpec;", "primaryConstructor", "(Lcom/squareup/kotlinpoet/FunSpec;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "Lcom/squareup/kotlinpoet/TypeName;", "superclass", "(Lcom/squareup/kotlinpoet/TypeName;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "superinterface", "Lcom/squareup/kotlinpoet/CodeBlock;", "delegate", "addSuperinterface", "(Lcom/squareup/kotlinpoet/TypeName;Lcom/squareup/kotlinpoet/CodeBlock;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "Lcom/squareup/kotlinpoet/PropertySpec;", "propertySpec", "addProperty", "(Lcom/squareup/kotlinpoet/PropertySpec;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "funSpec", "addFunction", "Lcom/squareup/kotlinpoet/TypeSpec;", "typeSpec", "addType", "(Lcom/squareup/kotlinpoet/TypeSpec;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "annotationSpec", "addAnnotation", "(Lcom/squareup/kotlinpoet/AnnotationSpec;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", InAppPurchaseConstants.METHOD_BUILD, "()Lcom/squareup/kotlinpoet/TypeSpec;", "", "checkCanHaveSuperclass", "()V", "Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "getKind$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "setKind$kotlinpoet", "(Lcom/squareup/kotlinpoet/TypeSpec$Kind;)V", "Ljava/lang/String;", "getName$kotlinpoet", "()Ljava/lang/String;", "Lcom/squareup/kotlinpoet/FunSpec;", "getPrimaryConstructor$kotlinpoet", "()Lcom/squareup/kotlinpoet/FunSpec;", "setPrimaryConstructor$kotlinpoet", "(Lcom/squareup/kotlinpoet/FunSpec;)V", "Lcom/squareup/kotlinpoet/TypeName;", "getSuperclass$kotlinpoet", "()Lcom/squareup/kotlinpoet/TypeName;", "setSuperclass$kotlinpoet", "(Lcom/squareup/kotlinpoet/TypeName;)V", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "initializerBlock", "Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "getInitializerBlock$kotlinpoet", "()Lcom/squareup/kotlinpoet/CodeBlock$Builder;", "", "initializerIndex", "I", "getInitializerIndex", "()I", "setInitializerIndex", "(I)V", "", "Lkotlin/reflect/KClass;", "tags", "Ljava/util/Map;", "getTags", "()Ljava/util/Map;", "kdoc", "getKdoc", "", "Ljavax/lang/model/element/Element;", "originatingElements", "Ljava/util/List;", "getOriginatingElements", "()Ljava/util/List;", "annotations", "getAnnotations", "contextReceiverTypes", "getContextReceiverTypes", "getContextReceiverTypes$annotations", "", "Ljava/util/Set;", "getModifiers", "()Ljava/util/Set;", "superinterfaces", "getSuperinterfaces", "enumConstants", "getEnumConstants", "Lcom/squareup/kotlinpoet/TypeVariableName;", "typeVariables", "getTypeVariables", "superclassConstructorParameters", "getSuperclassConstructorParameters", "propertySpecs", "getPropertySpecs", "funSpecs", "getFunSpecs", "typeSpecs", "getTypeSpecs", "", "isAnonymousClass$kotlinpoet", "()Z", "isAnonymousClass", "isExternal$kotlinpoet", "isExternal", "isEnum$kotlinpoet", "isEnum", "isAnnotation$kotlinpoet", "isAnnotation", "isCompanion$kotlinpoet", "isCompanion", "isInlineOrValClass$kotlinpoet", "isInlineOrValClass", "isSimpleClass$kotlinpoet", "isSimpleClass", "isFunInterface$kotlinpoet", "isFunInterface", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder implements Taggable$Builder<Builder>, OriginatingElementsHolder.Builder<Builder>, ContextReceivable$Builder<Builder>, Annotatable$Builder<Builder>, Documentable$Builder<Builder> {
        private final List<AnnotationSpec> annotations;
        private final List<TypeName> contextReceiverTypes;
        private final Map<String, TypeSpec> enumConstants;
        private final List<FunSpec> funSpecs;
        private final CodeBlock.Builder initializerBlock;
        private int initializerIndex;
        private final CodeBlock.Builder kdoc;
        private Kind kind;
        private final Set<KModifier> modifiers;
        private final String name;
        private final List<Element> originatingElements;
        private FunSpec primaryConstructor;
        private final List<PropertySpec> propertySpecs;
        private TypeName superclass;
        private final List<CodeBlock> superclassConstructorParameters;
        private final Map<TypeName, CodeBlock> superinterfaces;
        private final Map<KClass<?>, Object> tags;
        private final List<TypeSpec> typeSpecs;
        private final List<TypeVariableName> typeVariables;

        public Builder(Kind kind, String str, KModifier... kModifierArr) {
            kind.getClass();
            kModifierArr.getClass();
            this.kind = kind;
            this.name = str;
            this.superclass = TypeNames.ANY;
            CodeBlock.Companion companion = CodeBlock.INSTANCE;
            this.initializerBlock = companion.builder();
            this.initializerIndex = -1;
            this.tags = new LinkedHashMap();
            this.kdoc = companion.builder();
            this.originatingElements = new ArrayList();
            this.annotations = new ArrayList();
            this.contextReceiverTypes = new ArrayList();
            this.modifiers = SetsKt.mutableSetOf(Arrays.copyOf(kModifierArr, kModifierArr.length));
            this.superinterfaces = new LinkedHashMap();
            this.enumConstants = new LinkedHashMap();
            this.typeVariables = new ArrayList();
            this.superclassConstructorParameters = new ArrayList();
            this.propertySpecs = new ArrayList();
            this.funSpecs = new ArrayList();
            this.typeSpecs = new ArrayList();
        }

        public static /* synthetic */ Builder addSuperinterface$default(Builder builder, TypeName typeName, CodeBlock codeBlock, int i, Object obj) {
            if ((i & 2) != 0) {
                codeBlock = CodeBlock.INSTANCE.getEMPTY$kotlinpoet();
            }
            return builder.addSuperinterface(typeName, codeBlock);
        }

        private final void checkCanHaveSuperclass() {
            if (!isSimpleClass$kotlinpoet() && this.kind != Kind.OBJECT) {
                Utf8$$ExternalSyntheticBUOutline0.m$1("only classes can have super classes, not ", this.kind);
            } else if (isInlineOrValClass$kotlinpoet()) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("value/inline classes cannot have super classes");
            }
        }

        @Override // com.squareup.kotlinpoet.Annotatable$Builder
        public Builder addAnnotation(AnnotationSpec annotationSpec) {
            annotationSpec.getClass();
            return (Builder) super.addAnnotation(annotationSpec);
        }

        public Builder addFunction(FunSpec funSpec) {
            funSpec.getClass();
            this.funSpecs.add(funSpec);
            return this;
        }

        public final Builder addModifiers(KModifier... modifiers) {
            modifiers.getClass();
            if (isAnonymousClass$kotlinpoet()) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("forbidden on anonymous types.");
                return null;
            }
            CollectionsKt__MutableCollectionsKt.addAll(this.modifiers, modifiers);
            return this;
        }

        public Builder addProperty(PropertySpec propertySpec) {
            propertySpec.getClass();
            if (this.modifiers.contains(KModifier.EXPECT)) {
                if (propertySpec.getInitializer() != null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("properties in expect classes can't have initializers");
                    return null;
                }
                if (propertySpec.getGetter() != null || propertySpec.getSetter() != null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("properties in expect classes can't have getters and setters");
                    return null;
                }
            }
            if (isEnum$kotlinpoet() && (Intrinsics.areEqual(propertySpec.getName(), "name") || Intrinsics.areEqual(propertySpec.getName(), "ordinal"))) {
                Home$$ExternalSyntheticBUOutline0.m((Object) propertySpec.getName(), (Object) " is a final supertype member and can't be redeclared or overridden");
                return null;
            }
            this.propertySpecs.add(propertySpec);
            return this;
        }

        public final Builder addSuperinterface(TypeName superinterface, CodeBlock delegate) {
            superinterface.getClass();
            delegate.getClass();
            if (delegate.isEmpty()) {
                this.superinterfaces.put(superinterface, null);
                return this;
            }
            if (!isSimpleClass$kotlinpoet() && this.kind != Kind.OBJECT) {
                StringBuilder sb = new StringBuilder("delegation only allowed for classes and objects (found ");
                sb.append(this.kind);
                sb.append(" '");
                Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m(sb, this.name, "')"));
                return null;
            }
            if (superinterface.getIsNullable()) {
                Utf8$$ExternalSyntheticBUOutline0.m(39, TypeName.copy$default(superinterface, false, null, 2, null), "expected non-nullable type but was '");
                return null;
            }
            if (this.superinterfaces.get(superinterface) == null) {
                this.superinterfaces.put(superinterface, delegate);
                return this;
            }
            StringBuilder sb2 = new StringBuilder("'");
            sb2.append(this.name);
            sb2.append("' can not delegate to ");
            sb2.append(superinterface);
            sb2.append(" by ");
            sb2.append(delegate);
            Home$$ExternalSyntheticBUOutline0.m$1(sb2, " with existing declaration by ", this.superinterfaces.get(superinterface));
            return null;
        }

        public Builder addType(TypeSpec typeSpec) {
            typeSpec.getClass();
            this.typeSpecs.add(typeSpec);
            return this;
        }

        public final TypeSpec build() {
            Object next;
            List<ParameterSpec> parameters;
            ParameterSpec parameterSpec;
            FunSpec funSpec;
            if (!this.enumConstants.isEmpty() && !isEnum$kotlinpoet()) {
                Utf8$$ExternalSyntheticBUOutline0.m((Object) FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(), this.name, " is not an enum and cannot have enum constants"));
                return null;
            }
            if (!this.superclassConstructorParameters.isEmpty()) {
                checkCanHaveSuperclass();
                if (isExternal$kotlinpoet()) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("delegated constructor call in external class is not allowed");
                    return null;
                }
            }
            if (isExternal$kotlinpoet()) {
                List<FunSpec> list = this.funSpecs;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (((FunSpec) it.next()).getDelegateConstructor() != null) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("delegated constructor call in external class is not allowed");
                            return null;
                        }
                    }
                }
            }
            if (isAnonymousClass$kotlinpoet() && !this.typeVariables.isEmpty()) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("typevariables are forbidden on anonymous types");
                return null;
            }
            int i = 0;
            boolean z = this.modifiers.contains(KModifier.ABSTRACT) || this.modifiers.contains(KModifier.SEALED) || this.kind == Kind.INTERFACE || isEnum$kotlinpoet();
            for (FunSpec funSpec2 : this.funSpecs) {
                if (!z && funSpec2.getModifiers().contains(KModifier.ABSTRACT)) {
                    Home$$ExternalSyntheticBUOutline0.m("non-abstract type ", this.name, " cannot declare abstract function ", funSpec2.getName());
                    return null;
                }
                if (this.kind == Kind.INTERFACE) {
                    UtilKt.requireNoneOf(funSpec2.getModifiers(), KModifier.INTERNAL, KModifier.PROTECTED);
                    UtilKt.requireNoneOrOneOf(funSpec2.getModifiers(), KModifier.ABSTRACT, KModifier.PRIVATE);
                } else {
                    if (isAnnotation$kotlinpoet()) {
                        Home$$ExternalSyntheticBUOutline0.m$1("annotation class ", this.name, " cannot declare member function ", funSpec2.getName());
                        return null;
                    }
                    if (this.modifiers.contains(KModifier.EXPECT) && !funSpec2.getBody().isEmpty()) {
                        Utf8$$ExternalSyntheticBUOutline0.m$2("functions in expect classes can't have bodies");
                        return null;
                    }
                }
            }
            for (PropertySpec propertySpec : this.propertySpecs) {
                if (!z && propertySpec.getModifiers().contains(KModifier.ABSTRACT)) {
                    Home$$ExternalSyntheticBUOutline0.m("non-abstract type ", this.name, " cannot declare abstract property ", propertySpec.getName());
                    return null;
                }
                if (!propertySpec.getContextReceiverTypes().isEmpty() && !SetsKt.plus((Set) this.kind.implicitPropertyModifiers$kotlinpoet(this.modifiers), (Iterable) propertySpec.getModifiers()).contains(KModifier.ABSTRACT)) {
                    if (propertySpec.getGetter() == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$2("non-abstract properties with context receivers require a get()");
                        return null;
                    }
                    if (propertySpec.getMutable() && propertySpec.getSetter() == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$2("non-abstract mutable properties with context receivers require a set()");
                        return null;
                    }
                }
            }
            if (isAnnotation$kotlinpoet() && (funSpec = this.primaryConstructor) != null) {
                UtilKt.requireNoneOf(funSpec.getModifiers(), KModifier.INTERNAL, KModifier.PROTECTED, KModifier.PRIVATE, KModifier.ABSTRACT);
            }
            if (this.primaryConstructor == null) {
                List<FunSpec> list2 = this.funSpecs;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it2 = list2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (((FunSpec) it2.next()).isConstructor()) {
                            if (!this.superclassConstructorParameters.isEmpty()) {
                                Utf8$$ExternalSyntheticBUOutline0.m$2("types without a primary constructor cannot specify secondary constructors and superclass constructor parameters");
                                return null;
                            }
                        }
                    }
                }
            }
            if (isInlineOrValClass$kotlinpoet()) {
                FunSpec funSpec3 = this.primaryConstructor;
                if (funSpec3 != null && funSpec3.getParameters().size() != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("value/inline classes must have 1 parameter in constructor");
                    return null;
                }
                if (this.propertySpecs.size() <= 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("value/inline classes must have at least 1 property");
                    return null;
                }
                FunSpec funSpec4 = this.primaryConstructor;
                String name = (funSpec4 == null || (parameters = funSpec4.getParameters()) == null || (parameterSpec = (ParameterSpec) CollectionsKt.firstOrNull((List) parameters)) == null) ? null : parameterSpec.getName();
                if (name != null) {
                    Iterator<T> it3 = this.propertySpecs.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it3.next();
                        if (Intrinsics.areEqual(((PropertySpec) next).getName(), name)) {
                            break;
                        }
                    }
                    PropertySpec propertySpec2 = (PropertySpec) next;
                    if (propertySpec2 == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$2("value/inline classes must have a single read-only (val) property parameter.");
                        return null;
                    }
                    if (propertySpec2.getMutable()) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("value/inline classes must have a single read-only (val) property parameter.");
                        return null;
                    }
                }
                if (!Intrinsics.areEqual(this.superclass, TypeNames.get((KClass<?>) Reflection.getOrCreateKotlinClass(Object.class)))) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("value/inline classes cannot have super classes");
                    return null;
                }
            }
            if (isFunInterface$kotlinpoet()) {
                List<FunSpec> list3 = this.funSpecs;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list3) {
                    if (((FunSpec) obj).getModifiers().contains(KModifier.ABSTRACT)) {
                        arrayList.add(obj);
                    }
                }
                if (arrayList.size() != 1) {
                    StringBuilder sb = new StringBuilder("Functional interfaces must have exactly one abstract function. Contained ");
                    sb.append(arrayList.size());
                    sb.append(": ");
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        arrayList2.add(((FunSpec) it4.next()).getName());
                    }
                    sb.append(arrayList2);
                    throw new IllegalStateException(sb.toString().toString());
                }
            }
            List<TypeSpec> list4 = this.typeSpecs;
            if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                Iterator<T> it5 = list4.iterator();
                while (it5.hasNext()) {
                    if (((TypeSpec) it5.next()).getIsCompanion() && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (i != 0) {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Multiple companion objects are present but only one is allowed.");
                    return null;
                }
                if (!isSimpleClass$kotlinpoet() && this.kind != Kind.INTERFACE && !isEnum$kotlinpoet() && !isAnnotation$kotlinpoet()) {
                    Home$$ExternalSyntheticBUOutline0.m(this.kind, " types can't have a companion object");
                    return null;
                }
            }
            return new TypeSpec(this, null, null, null, 14, null);
        }

        @Override // com.squareup.kotlinpoet.Annotatable$Builder
        public List<AnnotationSpec> getAnnotations() {
            return this.annotations;
        }

        @Override // com.squareup.kotlinpoet.ContextReceivable$Builder
        public List<TypeName> getContextReceiverTypes() {
            return this.contextReceiverTypes;
        }

        public final Map<String, TypeSpec> getEnumConstants() {
            return this.enumConstants;
        }

        public final List<FunSpec> getFunSpecs() {
            return this.funSpecs;
        }

        /* JADX INFO: renamed from: getInitializerBlock$kotlinpoet, reason: from getter */
        public final CodeBlock.Builder getInitializerBlock() {
            return this.initializerBlock;
        }

        public final int getInitializerIndex() {
            return this.initializerIndex;
        }

        @Override // com.squareup.kotlinpoet.Documentable$Builder
        public CodeBlock.Builder getKdoc() {
            return this.kdoc;
        }

        /* JADX INFO: renamed from: getKind$kotlinpoet, reason: from getter */
        public final Kind getKind() {
            return this.kind;
        }

        public final Set<KModifier> getModifiers() {
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

        /* JADX INFO: renamed from: getPrimaryConstructor$kotlinpoet, reason: from getter */
        public final FunSpec getPrimaryConstructor() {
            return this.primaryConstructor;
        }

        public final List<PropertySpec> getPropertySpecs() {
            return this.propertySpecs;
        }

        /* JADX INFO: renamed from: getSuperclass$kotlinpoet, reason: from getter */
        public final TypeName getSuperclass() {
            return this.superclass;
        }

        public final List<CodeBlock> getSuperclassConstructorParameters() {
            return this.superclassConstructorParameters;
        }

        public final Map<TypeName, CodeBlock> getSuperinterfaces() {
            return this.superinterfaces;
        }

        @Override // com.squareup.kotlinpoet.Taggable$Builder
        public Map<KClass<?>, Object> getTags() {
            return this.tags;
        }

        public final List<TypeSpec> getTypeSpecs() {
            return this.typeSpecs;
        }

        public final List<TypeVariableName> getTypeVariables() {
            return this.typeVariables;
        }

        public final boolean isAnnotation$kotlinpoet() {
            return this.kind == Kind.CLASS && this.modifiers.contains(KModifier.ANNOTATION);
        }

        public final boolean isAnonymousClass$kotlinpoet() {
            return this.name == null && this.kind == Kind.CLASS;
        }

        public final boolean isCompanion$kotlinpoet() {
            return this.kind == Kind.OBJECT && this.modifiers.contains(KModifier.COMPANION);
        }

        public final boolean isEnum$kotlinpoet() {
            return this.kind == Kind.CLASS && this.modifiers.contains(KModifier.ENUM);
        }

        public final boolean isExternal$kotlinpoet() {
            return this.modifiers.contains(KModifier.EXTERNAL);
        }

        public final boolean isFunInterface$kotlinpoet() {
            return this.kind == Kind.INTERFACE && this.modifiers.contains(KModifier.FUN);
        }

        public final boolean isInlineOrValClass$kotlinpoet() {
            if (this.kind == Kind.CLASS) {
                return this.modifiers.contains(KModifier.INLINE) || this.modifiers.contains(KModifier.VALUE);
            }
            return false;
        }

        public final boolean isSimpleClass$kotlinpoet() {
            return (this.kind != Kind.CLASS || isEnum$kotlinpoet() || isAnnotation$kotlinpoet()) ? false : true;
        }

        public final Builder primaryConstructor(FunSpec primaryConstructor) {
            if (this.kind != Kind.CLASS) {
                throw new IllegalStateException((this.kind + " can't have a primary constructor").toString());
            }
            if (primaryConstructor != null) {
                if (!primaryConstructor.isConstructor()) {
                    Utf8$$ExternalSyntheticBUOutline0.m$4("expected a constructor but was ", primaryConstructor.getName());
                    return null;
                }
                if (isInlineOrValClass$kotlinpoet() && primaryConstructor.getParameters().size() != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("value/inline classes must have 1 parameter in constructor");
                    return null;
                }
                if (primaryConstructor.getDelegateConstructor() != null || !primaryConstructor.getDelegateConstructorArguments().isEmpty()) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("primary constructor can't delegate to other constructors");
                    return null;
                }
            }
            this.primaryConstructor = primaryConstructor;
            return this;
        }

        public final Builder superclass(TypeName superclass) {
            superclass.getClass();
            checkCanHaveSuperclass();
            if (this.superclass == TypeNames.ANY) {
                this.superclass = superclass;
                return this;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$1("superclass already set to ", this.superclass);
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/squareup/kotlinpoet/TypeSpec$Companion;", "", "<init>", "()V", "", "name", "Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "classBuilder", "(Ljava/lang/String;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "Lcom/squareup/kotlinpoet/ClassName;", "className", "(Lcom/squareup/kotlinpoet/ClassName;)Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "objectBuilder", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder classBuilder(String name) {
            name.getClass();
            return new Builder(Kind.CLASS, name, new KModifier[0]);
        }

        public final Builder objectBuilder(String name) {
            name.getClass();
            return new Builder(Kind.OBJECT, name, new KModifier[0]);
        }

        private Companion() {
        }

        public final Builder classBuilder(ClassName className) {
            className.getClass();
            return classBuilder(className.getSimpleName());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B;\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\rJ%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0011\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018j\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/squareup/kotlinpoet/TypeSpec$Kind;", "", "", "declarationKeyword", "", "Lcom/squareup/kotlinpoet/KModifier;", "defaultImplicitPropertyModifiers", "defaultImplicitFunctionModifiers", "defaultImplicitTypeModifiers", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;)V", "modifiers", "implicitPropertyModifiers$kotlinpoet", "(Ljava/util/Set;)Ljava/util/Set;", "implicitPropertyModifiers", "implicitFunctionModifiers$kotlinpoet", "implicitFunctionModifiers", "implicitTypeModifiers$kotlinpoet", "implicitTypeModifiers", "Ljava/lang/String;", "getDeclarationKeyword$kotlinpoet", "()Ljava/lang/String;", "Ljava/util/Set;", "getDefaultImplicitPropertyModifiers$kotlinpoet", "()Ljava/util/Set;", "getDefaultImplicitFunctionModifiers$kotlinpoet", "getDefaultImplicitTypeModifiers$kotlinpoet", "CLASS", "OBJECT", "INTERFACE", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Kind {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind CLASS;
        public static final Kind INTERFACE;
        public static final Kind OBJECT;
        private final String declarationKeyword;
        private final Set<KModifier> defaultImplicitFunctionModifiers;
        private final Set<KModifier> defaultImplicitPropertyModifiers;
        private final Set<KModifier> defaultImplicitTypeModifiers;

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{CLASS, OBJECT, INTERFACE};
        }

        static {
            KModifier kModifier = KModifier.PUBLIC;
            CLASS = new Kind("CLASS", 0, "class", SetsKt.setOf(kModifier), SetsKt.setOf(kModifier), SetsKt.emptySet());
            OBJECT = new Kind("OBJECT", 1, "object", SetsKt.setOf(kModifier), SetsKt.setOf(kModifier), SetsKt.emptySet());
            KModifier kModifier2 = KModifier.ABSTRACT;
            INTERFACE = new Kind("INTERFACE", 2, "interface", SetsKt.setOf((Object[]) new KModifier[]{kModifier, kModifier2}), SetsKt.setOf((Object[]) new KModifier[]{kModifier, kModifier2}), SetsKt.emptySet());
            Kind[] kindArr$values = $values();
            $VALUES = kindArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(kindArr$values);
        }

        private Kind(String str, int i, String str2, Set set, Set set2, Set set3) {
            this.declarationKeyword = str2;
            this.defaultImplicitPropertyModifiers = set;
            this.defaultImplicitFunctionModifiers = set2;
            this.defaultImplicitTypeModifiers = set3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Set implicitFunctionModifiers$kotlinpoet$default(Kind kind, Set set, int i, Object obj) {
            if (obj != null) {
                Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: implicitFunctionModifiers");
                return null;
            }
            if ((i & 1) != 0) {
                set = SetsKt.emptySet();
            }
            return kind.implicitFunctionModifiers$kotlinpoet(set);
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        /* JADX INFO: renamed from: getDeclarationKeyword$kotlinpoet, reason: from getter */
        public final String getDeclarationKeyword() {
            return this.declarationKeyword;
        }

        public final Set<KModifier> implicitFunctionModifiers$kotlinpoet(Set<? extends KModifier> modifiers) {
            Set of;
            modifiers.getClass();
            Set<KModifier> set = this.defaultImplicitFunctionModifiers;
            KModifier kModifier = KModifier.EXPECT;
            if (modifiers.contains(kModifier)) {
                of = SetsKt.setOf(kModifier);
            } else {
                KModifier kModifier2 = KModifier.EXTERNAL;
                of = modifiers.contains(kModifier2) ? SetsKt.setOf(kModifier2) : SetsKt.emptySet();
            }
            return SetsKt.plus((Set) set, (Iterable) of);
        }

        public final Set<KModifier> implicitPropertyModifiers$kotlinpoet(Set<? extends KModifier> modifiers) {
            Set of;
            modifiers.getClass();
            Set<KModifier> set = this.defaultImplicitPropertyModifiers;
            if (modifiers.contains(KModifier.ANNOTATION)) {
                of = SetsKt.emptySet();
            } else {
                KModifier kModifier = KModifier.EXPECT;
                if (modifiers.contains(kModifier)) {
                    of = SetsKt.setOf(kModifier);
                } else {
                    KModifier kModifier2 = KModifier.EXTERNAL;
                    of = modifiers.contains(kModifier2) ? SetsKt.setOf(kModifier2) : SetsKt.emptySet();
                }
            }
            return SetsKt.plus((Set) set, (Iterable) of);
        }

        public final Set<KModifier> implicitTypeModifiers$kotlinpoet(Set<? extends KModifier> modifiers) {
            Set of;
            modifiers.getClass();
            Set<KModifier> set = this.defaultImplicitTypeModifiers;
            KModifier kModifier = KModifier.EXPECT;
            if (modifiers.contains(kModifier)) {
                of = SetsKt.setOf(kModifier);
            } else {
                KModifier kModifier2 = KModifier.EXTERNAL;
                of = modifiers.contains(kModifier2) ? SetsKt.setOf(kModifier2) : SetsKt.emptySet();
            }
            return SetsKt.plus((Set) set, (Iterable) of);
        }
    }

    private TypeSpec(Builder builder, Map<KClass<?>, ? extends Object> map, OriginatingElementsHolder originatingElementsHolder, List<? extends TypeName> list) {
        this.tagMap = map;
        this.delegateOriginatingElements = originatingElementsHolder;
        this.contextReceivers = list;
        this.kind = builder.getKind();
        this.name = builder.getName();
        this.kdoc = builder.getKdoc().build();
        this.annotations = UtilKt.toImmutableList(builder.getAnnotations());
        this.modifiers = UtilKt.toImmutableSet(builder.getModifiers());
        this.typeVariables = UtilKt.toImmutableList(builder.getTypeVariables());
        this.primaryConstructor = builder.getPrimaryConstructor();
        this.superclass = builder.getSuperclass();
        this.superclassConstructorParameters = UtilKt.toImmutableList(builder.getSuperclassConstructorParameters());
        this.isEnum = builder.isEnum$kotlinpoet();
        this.isAnnotation = builder.isAnnotation$kotlinpoet();
        this.isCompanion = builder.isCompanion$kotlinpoet();
        this.isAnonymousClass = builder.isAnonymousClass$kotlinpoet();
        this.isFunctionalInterface = builder.isFunInterface$kotlinpoet();
        this.superinterfaces = UtilKt.toImmutableMap(builder.getSuperinterfaces());
        this.enumConstants = UtilKt.toImmutableMap(builder.getEnumConstants());
        this.propertySpecs = UtilKt.toImmutableList(builder.getPropertySpecs());
        this.initializerBlock = builder.getInitializerBlock().build();
        this.initializerIndex = builder.getInitializerIndex();
        this.funSpecs = UtilKt.toImmutableList(builder.getFunSpecs());
        this.typeSpecs = UtilKt.toImmutableList(builder.getTypeSpecs());
        List<TypeSpec> typeSpecs = getTypeSpecs();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeSpecs, 10));
        Iterator<T> it = typeSpecs.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeSpec) it.next()).name);
        }
        this.nestedTypesSimpleNames = UtilKt.toImmutableSet(arrayList);
    }

    private final Map<String, PropertySpec> constructorProperties() {
        ParameterSpec parameterSpecParameter$kotlinpoet;
        if (this.primaryConstructor == null) {
            return MapsKt.emptyMap();
        }
        IntRange intRangeUntil = getHasInitializer() ? RangesKt.until(0, this.initializerIndex) : CollectionsKt.getIndices(getPropertySpecs());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int first = intRangeUntil.getFirst();
        int last = intRangeUntil.getLast();
        if (first <= last) {
            while (true) {
                PropertySpec propertySpec = getPropertySpecs().get(first);
                if (propertySpec.getGetter() == null && propertySpec.getSetter() == null && (parameterSpecParameter$kotlinpoet = this.primaryConstructor.parameter$kotlinpoet(propertySpec.getName())) != null && Intrinsics.areEqual(parameterSpecParameter$kotlinpoet.getType(), propertySpec.getType()) && isPropertyInitializerConstructorParameter(propertySpec, parameterSpecParameter$kotlinpoet)) {
                    linkedHashMap.put(propertySpec.getName(), propertySpec.fromPrimaryConstructorParameter$kotlinpoet(parameterSpecParameter$kotlinpoet));
                }
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void emit$kotlinpoet$default(TypeSpec typeSpec, CodeWriter codeWriter, String str, Set set, boolean z, int i, Object obj) throws Throwable {
        if ((i & 4) != 0) {
            set = SetsKt.emptySet();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        typeSpec.emit$kotlinpoet(codeWriter, str, set, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit emit$lambda$3$lambda$2(Ref$BooleanRef ref$BooleanRef, Map map, CodeWriter codeWriter, ParameterSpec parameterSpec) throws Throwable {
        ref$BooleanRef.getClass();
        map.getClass();
        codeWriter.getClass();
        parameterSpec.getClass();
        ref$BooleanRef.element = true;
        PropertySpec propertySpec = (PropertySpec) map.get(parameterSpec.getName());
        if (propertySpec != null) {
            PropertySpec.emit$kotlinpoet$default(propertySpec, codeWriter, SetsKt.setOf(KModifier.PUBLIC), false, false, true, false, 8, null);
            parameterSpec.emitDefaultValue$kotlinpoet(codeWriter);
        } else {
            ParameterSpec.emit$kotlinpoet$default(parameterSpec, codeWriter, false, false, 2, null);
        }
        return Unit.INSTANCE;
    }

    private static final void emit$possiblyEmitInitializer(Ref$BooleanRef ref$BooleanRef, boolean z, Ref$BooleanRef ref$BooleanRef2, CodeWriter codeWriter, TypeSpec typeSpec) throws Throwable {
        if (ref$BooleanRef.element) {
            return;
        }
        ref$BooleanRef.element = true;
        if (z) {
            if (!ref$BooleanRef2.element) {
                CodeWriter.emit$default(codeWriter, "\n", false, 2, null);
            }
            CodeWriter.emitCode$default(codeWriter, typeSpec.initializerBlock, false, false, false, 14, null);
            ref$BooleanRef2.element = false;
        }
    }

    private final boolean getHasInitializer() {
        return this.initializerIndex != -1 && this.initializerBlock.isNotEmpty();
    }

    private final boolean getHasNoBody() {
        CodeBlock body;
        if (!getPropertySpecs().isEmpty()) {
            Map<String, PropertySpec> mapConstructorProperties = constructorProperties();
            Iterator<PropertySpec> it = getPropertySpecs().iterator();
            while (it.hasNext()) {
                if (!mapConstructorProperties.containsKey(it.next().getName())) {
                    return false;
                }
            }
        }
        if (this.enumConstants.isEmpty() && this.initializerBlock.isEmpty()) {
            FunSpec funSpec = this.primaryConstructor;
            if (((funSpec == null || (body = funSpec.getBody()) == null) ? true : body.isEmpty()) && getFunSpecs().isEmpty() && getTypeSpecs().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private final boolean isPropertyInitializerConstructorParameter(PropertySpec property, ParameterSpec parameter) {
        return Intrinsics.areEqual(CodeBlock.INSTANCE.of("%N", parameter).toString(), UtilKt.escapeIfNecessary(String.valueOf(property.getInitializer()), false));
    }

    private final CodeBlock kdocWithConstructorDocs() {
        CodeBlock codeBlockEnsureEndsWithNewLine = UtilKt.ensureEndsWithNewLine(getKdoc());
        CodeBlock.Builder builder = CodeBlock.INSTANCE.builder();
        FunSpec funSpec = this.primaryConstructor;
        if (funSpec != null) {
            if (funSpec.getKdoc().isNotEmpty()) {
                builder.add("@constructor %L", UtilKt.ensureEndsWithNewLine(this.primaryConstructor.getKdoc()));
            }
            for (ParameterSpec parameterSpec : this.primaryConstructor.getParameters()) {
                if (parameterSpec.getKdoc().isNotEmpty()) {
                    builder.add("@param %L %L", parameterSpec.getName(), UtilKt.ensureEndsWithNewLine(parameterSpec.getKdoc()));
                }
            }
        }
        List listListOf = CollectionsKt.listOf((Object[]) new CodeBlock[]{codeBlockEnsureEndsWithNewLine, builder.build()});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((CodeBlock) obj).isNotEmpty()) {
                arrayList.add(obj);
            }
        }
        return CodeBlocks.joinToCode$default(arrayList, "\n", null, null, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02bd A[Catch: all -> 0x0079, TryCatch #1 {all -> 0x0079, blocks: (B:10:0x003e, B:12:0x005b, B:16:0x0080, B:20:0x008a, B:131:0x0363, B:132:0x037b, B:134:0x0381, B:136:0x0397, B:140:0x03ab, B:143:0x03ba, B:145:0x03be, B:147:0x03c2, B:148:0x03c8, B:150:0x03d4, B:152:0x03e0, B:154:0x03ec, B:156:0x03f4, B:157:0x03fc, B:158:0x0410, B:160:0x0416, B:162:0x0422, B:163:0x0425, B:166:0x0433, B:168:0x0437, B:169:0x043d, B:173:0x0461, B:175:0x0469, B:177:0x0471, B:179:0x047b, B:180:0x04a3, B:181:0x04ab, B:183:0x04b1, B:185:0x04bd, B:187:0x04c1, B:188:0x04c7, B:189:0x04dc, B:190:0x04e4, B:192:0x04ea, B:194:0x04f6, B:196:0x04fa, B:197:0x0500, B:198:0x0516, B:199:0x051e, B:201:0x0524, B:203:0x052e, B:204:0x0534, B:205:0x054c, B:207:0x055e, B:209:0x0562, B:22:0x0090, B:24:0x009a, B:28:0x00ae, B:30:0x00b8, B:33:0x00e0, B:35:0x00ea, B:36:0x00fd, B:38:0x0103, B:40:0x011b, B:42:0x012a, B:43:0x014a, B:45:0x0150, B:48:0x0159, B:39:0x0117, B:31:0x00cb, B:32:0x00dc, B:49:0x015e, B:51:0x0177, B:53:0x0188, B:55:0x0198, B:56:0x01a1, B:58:0x01af, B:60:0x01c8, B:65:0x01d6, B:68:0x01e4, B:69:0x01ef, B:72:0x01fb, B:74:0x0202, B:77:0x020d, B:78:0x0213, B:79:0x0224, B:80:0x0235, B:82:0x023b, B:84:0x024a, B:85:0x024e, B:86:0x025d, B:89:0x0265, B:91:0x026f, B:93:0x0279, B:96:0x0283, B:97:0x0287, B:99:0x028d, B:101:0x0299, B:107:0x02c7, B:103:0x02a6, B:105:0x02b0, B:106:0x02bd, B:108:0x02cb, B:109:0x02e0, B:111:0x02e6, B:113:0x02fa, B:115:0x0311, B:114:0x0305, B:116:0x0316, B:118:0x0323, B:123:0x032f, B:124:0x0348, B:126:0x0353, B:130:0x0360, B:52:0x0182), top: B:216:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0381 A[Catch: all -> 0x0079, TryCatch #1 {all -> 0x0079, blocks: (B:10:0x003e, B:12:0x005b, B:16:0x0080, B:20:0x008a, B:131:0x0363, B:132:0x037b, B:134:0x0381, B:136:0x0397, B:140:0x03ab, B:143:0x03ba, B:145:0x03be, B:147:0x03c2, B:148:0x03c8, B:150:0x03d4, B:152:0x03e0, B:154:0x03ec, B:156:0x03f4, B:157:0x03fc, B:158:0x0410, B:160:0x0416, B:162:0x0422, B:163:0x0425, B:166:0x0433, B:168:0x0437, B:169:0x043d, B:173:0x0461, B:175:0x0469, B:177:0x0471, B:179:0x047b, B:180:0x04a3, B:181:0x04ab, B:183:0x04b1, B:185:0x04bd, B:187:0x04c1, B:188:0x04c7, B:189:0x04dc, B:190:0x04e4, B:192:0x04ea, B:194:0x04f6, B:196:0x04fa, B:197:0x0500, B:198:0x0516, B:199:0x051e, B:201:0x0524, B:203:0x052e, B:204:0x0534, B:205:0x054c, B:207:0x055e, B:209:0x0562, B:22:0x0090, B:24:0x009a, B:28:0x00ae, B:30:0x00b8, B:33:0x00e0, B:35:0x00ea, B:36:0x00fd, B:38:0x0103, B:40:0x011b, B:42:0x012a, B:43:0x014a, B:45:0x0150, B:48:0x0159, B:39:0x0117, B:31:0x00cb, B:32:0x00dc, B:49:0x015e, B:51:0x0177, B:53:0x0188, B:55:0x0198, B:56:0x01a1, B:58:0x01af, B:60:0x01c8, B:65:0x01d6, B:68:0x01e4, B:69:0x01ef, B:72:0x01fb, B:74:0x0202, B:77:0x020d, B:78:0x0213, B:79:0x0224, B:80:0x0235, B:82:0x023b, B:84:0x024a, B:85:0x024e, B:86:0x025d, B:89:0x0265, B:91:0x026f, B:93:0x0279, B:96:0x0283, B:97:0x0287, B:99:0x028d, B:101:0x0299, B:107:0x02c7, B:103:0x02a6, B:105:0x02b0, B:106:0x02bd, B:108:0x02cb, B:109:0x02e0, B:111:0x02e6, B:113:0x02fa, B:115:0x0311, B:114:0x0305, B:116:0x0316, B:118:0x0323, B:123:0x032f, B:124:0x0348, B:126:0x0353, B:130:0x0360, B:52:0x0182), top: B:216:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03be A[Catch: all -> 0x0079, TryCatch #1 {all -> 0x0079, blocks: (B:10:0x003e, B:12:0x005b, B:16:0x0080, B:20:0x008a, B:131:0x0363, B:132:0x037b, B:134:0x0381, B:136:0x0397, B:140:0x03ab, B:143:0x03ba, B:145:0x03be, B:147:0x03c2, B:148:0x03c8, B:150:0x03d4, B:152:0x03e0, B:154:0x03ec, B:156:0x03f4, B:157:0x03fc, B:158:0x0410, B:160:0x0416, B:162:0x0422, B:163:0x0425, B:166:0x0433, B:168:0x0437, B:169:0x043d, B:173:0x0461, B:175:0x0469, B:177:0x0471, B:179:0x047b, B:180:0x04a3, B:181:0x04ab, B:183:0x04b1, B:185:0x04bd, B:187:0x04c1, B:188:0x04c7, B:189:0x04dc, B:190:0x04e4, B:192:0x04ea, B:194:0x04f6, B:196:0x04fa, B:197:0x0500, B:198:0x0516, B:199:0x051e, B:201:0x0524, B:203:0x052e, B:204:0x0534, B:205:0x054c, B:207:0x055e, B:209:0x0562, B:22:0x0090, B:24:0x009a, B:28:0x00ae, B:30:0x00b8, B:33:0x00e0, B:35:0x00ea, B:36:0x00fd, B:38:0x0103, B:40:0x011b, B:42:0x012a, B:43:0x014a, B:45:0x0150, B:48:0x0159, B:39:0x0117, B:31:0x00cb, B:32:0x00dc, B:49:0x015e, B:51:0x0177, B:53:0x0188, B:55:0x0198, B:56:0x01a1, B:58:0x01af, B:60:0x01c8, B:65:0x01d6, B:68:0x01e4, B:69:0x01ef, B:72:0x01fb, B:74:0x0202, B:77:0x020d, B:78:0x0213, B:79:0x0224, B:80:0x0235, B:82:0x023b, B:84:0x024a, B:85:0x024e, B:86:0x025d, B:89:0x0265, B:91:0x026f, B:93:0x0279, B:96:0x0283, B:97:0x0287, B:99:0x028d, B:101:0x0299, B:107:0x02c7, B:103:0x02a6, B:105:0x02b0, B:106:0x02bd, B:108:0x02cb, B:109:0x02e0, B:111:0x02e6, B:113:0x02fa, B:115:0x0311, B:114:0x0305, B:116:0x0316, B:118:0x0323, B:123:0x032f, B:124:0x0348, B:126:0x0353, B:130:0x0360, B:52:0x0182), top: B:216:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0416 A[Catch: all -> 0x0079, TryCatch #1 {all -> 0x0079, blocks: (B:10:0x003e, B:12:0x005b, B:16:0x0080, B:20:0x008a, B:131:0x0363, B:132:0x037b, B:134:0x0381, B:136:0x0397, B:140:0x03ab, B:143:0x03ba, B:145:0x03be, B:147:0x03c2, B:148:0x03c8, B:150:0x03d4, B:152:0x03e0, B:154:0x03ec, B:156:0x03f4, B:157:0x03fc, B:158:0x0410, B:160:0x0416, B:162:0x0422, B:163:0x0425, B:166:0x0433, B:168:0x0437, B:169:0x043d, B:173:0x0461, B:175:0x0469, B:177:0x0471, B:179:0x047b, B:180:0x04a3, B:181:0x04ab, B:183:0x04b1, B:185:0x04bd, B:187:0x04c1, B:188:0x04c7, B:189:0x04dc, B:190:0x04e4, B:192:0x04ea, B:194:0x04f6, B:196:0x04fa, B:197:0x0500, B:198:0x0516, B:199:0x051e, B:201:0x0524, B:203:0x052e, B:204:0x0534, B:205:0x054c, B:207:0x055e, B:209:0x0562, B:22:0x0090, B:24:0x009a, B:28:0x00ae, B:30:0x00b8, B:33:0x00e0, B:35:0x00ea, B:36:0x00fd, B:38:0x0103, B:40:0x011b, B:42:0x012a, B:43:0x014a, B:45:0x0150, B:48:0x0159, B:39:0x0117, B:31:0x00cb, B:32:0x00dc, B:49:0x015e, B:51:0x0177, B:53:0x0188, B:55:0x0198, B:56:0x01a1, B:58:0x01af, B:60:0x01c8, B:65:0x01d6, B:68:0x01e4, B:69:0x01ef, B:72:0x01fb, B:74:0x0202, B:77:0x020d, B:78:0x0213, B:79:0x0224, B:80:0x0235, B:82:0x023b, B:84:0x024a, B:85:0x024e, B:86:0x025d, B:89:0x0265, B:91:0x026f, B:93:0x0279, B:96:0x0283, B:97:0x0287, B:99:0x028d, B:101:0x0299, B:107:0x02c7, B:103:0x02a6, B:105:0x02b0, B:106:0x02bd, B:108:0x02cb, B:109:0x02e0, B:111:0x02e6, B:113:0x02fa, B:115:0x0311, B:114:0x0305, B:116:0x0316, B:118:0x0323, B:123:0x032f, B:124:0x0348, B:126:0x0353, B:130:0x0360, B:52:0x0182), top: B:216:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04b1 A[Catch: all -> 0x0079, TryCatch #1 {all -> 0x0079, blocks: (B:10:0x003e, B:12:0x005b, B:16:0x0080, B:20:0x008a, B:131:0x0363, B:132:0x037b, B:134:0x0381, B:136:0x0397, B:140:0x03ab, B:143:0x03ba, B:145:0x03be, B:147:0x03c2, B:148:0x03c8, B:150:0x03d4, B:152:0x03e0, B:154:0x03ec, B:156:0x03f4, B:157:0x03fc, B:158:0x0410, B:160:0x0416, B:162:0x0422, B:163:0x0425, B:166:0x0433, B:168:0x0437, B:169:0x043d, B:173:0x0461, B:175:0x0469, B:177:0x0471, B:179:0x047b, B:180:0x04a3, B:181:0x04ab, B:183:0x04b1, B:185:0x04bd, B:187:0x04c1, B:188:0x04c7, B:189:0x04dc, B:190:0x04e4, B:192:0x04ea, B:194:0x04f6, B:196:0x04fa, B:197:0x0500, B:198:0x0516, B:199:0x051e, B:201:0x0524, B:203:0x052e, B:204:0x0534, B:205:0x054c, B:207:0x055e, B:209:0x0562, B:22:0x0090, B:24:0x009a, B:28:0x00ae, B:30:0x00b8, B:33:0x00e0, B:35:0x00ea, B:36:0x00fd, B:38:0x0103, B:40:0x011b, B:42:0x012a, B:43:0x014a, B:45:0x0150, B:48:0x0159, B:39:0x0117, B:31:0x00cb, B:32:0x00dc, B:49:0x015e, B:51:0x0177, B:53:0x0188, B:55:0x0198, B:56:0x01a1, B:58:0x01af, B:60:0x01c8, B:65:0x01d6, B:68:0x01e4, B:69:0x01ef, B:72:0x01fb, B:74:0x0202, B:77:0x020d, B:78:0x0213, B:79:0x0224, B:80:0x0235, B:82:0x023b, B:84:0x024a, B:85:0x024e, B:86:0x025d, B:89:0x0265, B:91:0x026f, B:93:0x0279, B:96:0x0283, B:97:0x0287, B:99:0x028d, B:101:0x0299, B:107:0x02c7, B:103:0x02a6, B:105:0x02b0, B:106:0x02bd, B:108:0x02cb, B:109:0x02e0, B:111:0x02e6, B:113:0x02fa, B:115:0x0311, B:114:0x0305, B:116:0x0316, B:118:0x0323, B:123:0x032f, B:124:0x0348, B:126:0x0353, B:130:0x0360, B:52:0x0182), top: B:216:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04ea A[Catch: all -> 0x0079, TryCatch #1 {all -> 0x0079, blocks: (B:10:0x003e, B:12:0x005b, B:16:0x0080, B:20:0x008a, B:131:0x0363, B:132:0x037b, B:134:0x0381, B:136:0x0397, B:140:0x03ab, B:143:0x03ba, B:145:0x03be, B:147:0x03c2, B:148:0x03c8, B:150:0x03d4, B:152:0x03e0, B:154:0x03ec, B:156:0x03f4, B:157:0x03fc, B:158:0x0410, B:160:0x0416, B:162:0x0422, B:163:0x0425, B:166:0x0433, B:168:0x0437, B:169:0x043d, B:173:0x0461, B:175:0x0469, B:177:0x0471, B:179:0x047b, B:180:0x04a3, B:181:0x04ab, B:183:0x04b1, B:185:0x04bd, B:187:0x04c1, B:188:0x04c7, B:189:0x04dc, B:190:0x04e4, B:192:0x04ea, B:194:0x04f6, B:196:0x04fa, B:197:0x0500, B:198:0x0516, B:199:0x051e, B:201:0x0524, B:203:0x052e, B:204:0x0534, B:205:0x054c, B:207:0x055e, B:209:0x0562, B:22:0x0090, B:24:0x009a, B:28:0x00ae, B:30:0x00b8, B:33:0x00e0, B:35:0x00ea, B:36:0x00fd, B:38:0x0103, B:40:0x011b, B:42:0x012a, B:43:0x014a, B:45:0x0150, B:48:0x0159, B:39:0x0117, B:31:0x00cb, B:32:0x00dc, B:49:0x015e, B:51:0x0177, B:53:0x0188, B:55:0x0198, B:56:0x01a1, B:58:0x01af, B:60:0x01c8, B:65:0x01d6, B:68:0x01e4, B:69:0x01ef, B:72:0x01fb, B:74:0x0202, B:77:0x020d, B:78:0x0213, B:79:0x0224, B:80:0x0235, B:82:0x023b, B:84:0x024a, B:85:0x024e, B:86:0x025d, B:89:0x0265, B:91:0x026f, B:93:0x0279, B:96:0x0283, B:97:0x0287, B:99:0x028d, B:101:0x0299, B:107:0x02c7, B:103:0x02a6, B:105:0x02b0, B:106:0x02bd, B:108:0x02cb, B:109:0x02e0, B:111:0x02e6, B:113:0x02fa, B:115:0x0311, B:114:0x0305, B:116:0x0316, B:118:0x0323, B:123:0x032f, B:124:0x0348, B:126:0x0353, B:130:0x0360, B:52:0x0182), top: B:216:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0524 A[Catch: all -> 0x0079, TryCatch #1 {all -> 0x0079, blocks: (B:10:0x003e, B:12:0x005b, B:16:0x0080, B:20:0x008a, B:131:0x0363, B:132:0x037b, B:134:0x0381, B:136:0x0397, B:140:0x03ab, B:143:0x03ba, B:145:0x03be, B:147:0x03c2, B:148:0x03c8, B:150:0x03d4, B:152:0x03e0, B:154:0x03ec, B:156:0x03f4, B:157:0x03fc, B:158:0x0410, B:160:0x0416, B:162:0x0422, B:163:0x0425, B:166:0x0433, B:168:0x0437, B:169:0x043d, B:173:0x0461, B:175:0x0469, B:177:0x0471, B:179:0x047b, B:180:0x04a3, B:181:0x04ab, B:183:0x04b1, B:185:0x04bd, B:187:0x04c1, B:188:0x04c7, B:189:0x04dc, B:190:0x04e4, B:192:0x04ea, B:194:0x04f6, B:196:0x04fa, B:197:0x0500, B:198:0x0516, B:199:0x051e, B:201:0x0524, B:203:0x052e, B:204:0x0534, B:205:0x054c, B:207:0x055e, B:209:0x0562, B:22:0x0090, B:24:0x009a, B:28:0x00ae, B:30:0x00b8, B:33:0x00e0, B:35:0x00ea, B:36:0x00fd, B:38:0x0103, B:40:0x011b, B:42:0x012a, B:43:0x014a, B:45:0x0150, B:48:0x0159, B:39:0x0117, B:31:0x00cb, B:32:0x00dc, B:49:0x015e, B:51:0x0177, B:53:0x0188, B:55:0x0198, B:56:0x01a1, B:58:0x01af, B:60:0x01c8, B:65:0x01d6, B:68:0x01e4, B:69:0x01ef, B:72:0x01fb, B:74:0x0202, B:77:0x020d, B:78:0x0213, B:79:0x0224, B:80:0x0235, B:82:0x023b, B:84:0x024a, B:85:0x024e, B:86:0x025d, B:89:0x0265, B:91:0x026f, B:93:0x0279, B:96:0x0283, B:97:0x0287, B:99:0x028d, B:101:0x0299, B:107:0x02c7, B:103:0x02a6, B:105:0x02b0, B:106:0x02bd, B:108:0x02cb, B:109:0x02e0, B:111:0x02e6, B:113:0x02fa, B:115:0x0311, B:114:0x0305, B:116:0x0316, B:118:0x0323, B:123:0x032f, B:124:0x0348, B:126:0x0353, B:130:0x0360, B:52:0x0182), top: B:216:0x003c }] */
    /* JADX WARN: Type inference failed for: r6v36, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v40, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void emit$kotlinpoet(CodeWriter codeWriter, String enumName, Set<? extends KModifier> implicitModifiers, boolean isNestedExternal) throws Throwable {
        boolean z;
        Object obj;
        int i;
        CodeBlock codeBlockOf;
        int i2;
        ?? EmptyList;
        String str;
        FunSpec funSpec;
        CodeWriter codeWriter2;
        Map<String, PropertySpec> map;
        String str2;
        int i3;
        CodeWriter codeWriter3 = codeWriter;
        codeWriter3.getClass();
        implicitModifiers.getClass();
        Set<KModifier> set = this.modifiers;
        KModifier kModifier = KModifier.EXTERNAL;
        boolean z2 = set.contains(kModifier) || isNestedExternal;
        int statementLine = codeWriter3.getStatementLine();
        codeWriter3.setStatementLine(-1);
        Map<String, PropertySpec> mapConstructorProperties = constructorProperties();
        CodeBlock codeBlockJoinToCode$default = CodeBlocks.joinToCode$default(this.superclassConstructorParameters, null, null, null, 7, null);
        String str3 = "\n";
        try {
            if (enumName != null) {
                codeWriter3.emitKdoc(kdocWithConstructorDocs());
                codeWriter3.emitAnnotations(getAnnotations(), false);
                codeWriter3.emitCode("%N", enumName);
                if (codeBlockJoinToCode$default.isNotEmpty()) {
                    CodeWriter.emit$default(codeWriter3, "(", false, 2, null);
                    i3 = 2;
                    z = z2;
                    obj = null;
                    CodeWriter.emitCode$default(codeWriter3, codeBlockJoinToCode$default, false, false, false, 14, null);
                    CodeWriter.emit$default(codeWriter3, ")", false, 2, null);
                } else {
                    i3 = 2;
                    z = z2;
                    obj = null;
                }
                if (getHasNoBody()) {
                    codeWriter3.setStatementLine(statementLine);
                    return;
                }
                CodeWriter.emit$default(codeWriter3, " {\n", false, i3, obj);
            } else {
                z = z2;
                obj = null;
                if (!this.isAnonymousClass) {
                    codeWriter3.emitKdoc(kdocWithConstructorDocs());
                    codeWriter3.emitContextReceivers(getContextReceiverTypes(), "\n");
                    codeWriter3.emitAnnotations(getAnnotations(), false);
                    codeWriter3.emitModifiers(this.modifiers, isNestedExternal ? SetsKt.setOf((Object[]) new KModifier[]{KModifier.PUBLIC, kModifier}) : SetsKt.setOf(KModifier.PUBLIC));
                    CodeWriter.emit$default(codeWriter3, this.kind.getDeclarationKeyword(), false, 2, null);
                    if (this.name != null) {
                        codeWriter3.emitCode(" %N", this);
                    }
                    codeWriter3.emitTypeVariables(this.typeVariables);
                    Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                    FunSpec funSpec2 = this.primaryConstructor;
                    if (funSpec2 != null) {
                        codeWriter3.pushType(this);
                        boolean zIsEmpty = funSpec2.getAnnotations().isEmpty();
                        boolean z3 = (funSpec2.getAnnotations().isEmpty() && funSpec2.getModifiers().isEmpty()) ? false : true;
                        if (!funSpec2.getAnnotations().isEmpty()) {
                            CodeWriter.emit$default(codeWriter3, " ", false, 2, null);
                            codeWriter3.emitAnnotations(funSpec2.getAnnotations(), true);
                        }
                        if (funSpec2.getModifiers().isEmpty()) {
                            i2 = 2;
                        } else {
                            if (zIsEmpty) {
                                i2 = 2;
                                CodeWriter.emit$default(codeWriter3, " ", false, 2, null);
                            } else {
                                i2 = 2;
                            }
                            CodeWriter.emitModifiers$default(codeWriter3, funSpec2.getModifiers(), null, i2, null);
                        }
                        if (z3) {
                            CodeWriter.emit$default(codeWriter3, "constructor", false, i2, null);
                        }
                        ParameterSpecKt.emit(funSpec2.getParameters(), codeWriter3, true, new TypeSpec$$ExternalSyntheticLambda0(ref$BooleanRef, mapConstructorProperties, codeWriter3, 0));
                        codeWriter3.popType();
                    }
                    List listListOf = CollectionsKt.listOf(this.superclass);
                    ArrayList<TypeName> arrayList = new ArrayList();
                    for (Object obj2 : listListOf) {
                        if (!Intrinsics.areEqual((TypeName) obj2, TypeNames.ANY)) {
                            arrayList.add(obj2);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                    for (TypeName typeName : arrayList) {
                        if (this.primaryConstructor == null) {
                            List<FunSpec> funSpecs = getFunSpecs();
                            if (!(funSpecs instanceof Collection) || !funSpecs.isEmpty()) {
                                Iterator it = funSpecs.iterator();
                                while (it.hasNext()) {
                                    if (((FunSpec) it.next()).isConstructor()) {
                                        codeBlockOf = CodeBlock.INSTANCE.of("%T", typeName);
                                        break;
                                    }
                                }
                            }
                            codeBlockOf = (!z || this.modifiers.contains(KModifier.EXPECT)) ? CodeBlock.INSTANCE.of("%T", typeName) : CodeBlock.INSTANCE.of("%T(%L)", typeName, codeBlockJoinToCode$default);
                        } else if (z) {
                        }
                        arrayList2.add(codeBlockOf);
                    }
                    Set<Map.Entry<TypeName, CodeBlock>> setEntrySet = this.superinterfaces.entrySet();
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
                    Iterator it2 = setEntrySet.iterator();
                    while (it2.hasNext()) {
                        Map.Entry entry = (Map.Entry) it2.next();
                        TypeName typeName2 = (TypeName) entry.getKey();
                        CodeBlock codeBlock = (CodeBlock) entry.getValue();
                        arrayList3.add(codeBlock == null ? CodeBlock.INSTANCE.of("%T", typeName2) : CodeBlock.INSTANCE.of("%T by %L", typeName2, codeBlock));
                    }
                    List listPlus = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
                    if (!listPlus.isEmpty()) {
                        CodeWriter.emitCode$default(codeWriter3, CodeBlocks.joinToCode$default(listPlus, ref$BooleanRef.element ? ",\n    " : ",♢", " : ", null, 4, null), false, false, false, 14, null);
                    }
                    codeWriter3.emitWhereBlock(this.typeVariables);
                    if (getHasNoBody()) {
                        CodeWriter.emit$default(codeWriter3, "\n", false, 2, null);
                        codeWriter3.setStatementLine(statementLine);
                        return;
                    }
                    i = 0;
                    obj = null;
                    CodeWriter.emit$default(codeWriter3, " {\n", false, 2, null);
                    codeWriter3.pushType(this);
                    CodeWriter.indent$default(codeWriter3, i, 1, obj);
                    Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                    ref$BooleanRef2.element = true;
                    for (Map.Entry<String, TypeSpec> entry2 : this.enumConstants.entrySet()) {
                        String key = entry2.getKey();
                        TypeSpec value = entry2.getValue();
                        if (!ref$BooleanRef2.element) {
                            CodeWriter.emit$default(codeWriter3, "\n", false, 2, null);
                        }
                        codeWriter2 = codeWriter3;
                        try {
                            emit$kotlinpoet$default(value, codeWriter2, key, null, false, 12, null);
                            codeWriter3 = codeWriter2;
                            CodeWriter.emit$default(codeWriter3, ",", false, 2, null);
                            ref$BooleanRef2.element = false;
                        } catch (Throwable th) {
                            th = th;
                            codeWriter3 = codeWriter2;
                            codeWriter3.setStatementLine(statementLine);
                            throw th;
                        }
                    }
                    if (this.isEnum) {
                        if (!ref$BooleanRef2.element) {
                            CodeWriter.emit$default(codeWriter3, "\n", false, 2, null);
                        }
                        if (!getPropertySpecs().isEmpty() || !getFunSpecs().isEmpty() || !getTypeSpecs().isEmpty() || this.initializerBlock.isNotEmpty()) {
                            CodeWriter.emit$default(codeWriter3, ";\n", false, 2, null);
                        }
                    }
                    boolean hasInitializer = getHasInitializer();
                    Ref$BooleanRef ref$BooleanRef3 = new Ref$BooleanRef();
                    int i4 = 0;
                    for (PropertySpec propertySpec : getPropertySpecs()) {
                        int i5 = i4 + 1;
                        if (i4 == this.initializerIndex) {
                            emit$possiblyEmitInitializer(ref$BooleanRef3, hasInitializer, ref$BooleanRef2, codeWriter3, this);
                        }
                        if (mapConstructorProperties.containsKey(propertySpec.getName())) {
                            map = mapConstructorProperties;
                            str2 = str3;
                        } else {
                            if (!ref$BooleanRef2.element) {
                                CodeWriter.emit$default(codeWriter3, str3, false, 2, null);
                            }
                            codeWriter2 = codeWriter3;
                            map = mapConstructorProperties;
                            str2 = str3;
                            PropertySpec.emit$kotlinpoet$default(propertySpec, codeWriter2, this.kind.implicitPropertyModifiers$kotlinpoet(this.modifiers), false, false, false, false, 60, null);
                            codeWriter3 = codeWriter2;
                            ref$BooleanRef2.element = false;
                        }
                        str3 = str2;
                        i4 = i5;
                        mapConstructorProperties = map;
                    }
                    str = str3;
                    emit$possiblyEmitInitializer(ref$BooleanRef3, hasInitializer, ref$BooleanRef2, codeWriter3, this);
                    funSpec = this.primaryConstructor;
                    if (funSpec != null && funSpec.getBody().isNotEmpty()) {
                        CodeWriter.emit$default(codeWriter3, "init {\n", false, 2, null);
                        CodeWriter.indent$default(codeWriter3, 0, 1, null);
                        CodeWriter.emitCode$default(codeWriter3, this.primaryConstructor.getBody(), false, false, false, 14, null);
                        CodeWriter.unindent$default(codeWriter3, 0, 1, null);
                        CodeWriter.emit$default(codeWriter3, "}\n", false, 2, null);
                    }
                    for (FunSpec funSpec3 : getFunSpecs()) {
                        if (funSpec3.isConstructor()) {
                            if (!ref$BooleanRef2.element) {
                                CodeWriter.emit$default(codeWriter3, str, false, 2, null);
                            }
                            funSpec3.emit$kotlinpoet(codeWriter3, this.name, this.kind.implicitFunctionModifiers$kotlinpoet(SetsKt.plus((Set) this.modifiers, (Iterable) implicitModifiers)), false);
                            ref$BooleanRef2.element = false;
                        }
                    }
                    for (FunSpec funSpec4 : getFunSpecs()) {
                        if (!funSpec4.isConstructor()) {
                            if (!ref$BooleanRef2.element) {
                                CodeWriter.emit$default(codeWriter3, str, false, 2, null);
                            }
                            funSpec4.emit$kotlinpoet(codeWriter3, this.name, this.kind.implicitFunctionModifiers$kotlinpoet(SetsKt.plus((Set) this.modifiers, (Iterable) implicitModifiers)), true);
                            ref$BooleanRef2.element = false;
                        }
                    }
                    for (TypeSpec typeSpec : getTypeSpecs()) {
                        if (!ref$BooleanRef2.element) {
                            CodeWriter.emit$default(codeWriter3, str, false, 2, null);
                        }
                        boolean z4 = z;
                        typeSpec.emit$kotlinpoet(codeWriter3, null, this.kind.implicitTypeModifiers$kotlinpoet(SetsKt.plus((Set) this.modifiers, (Iterable) implicitModifiers)), z4);
                        ref$BooleanRef2.element = false;
                        z = z4;
                    }
                    CodeWriter.unindent$default(codeWriter3, 0, 1, null);
                    codeWriter3.popType();
                    CodeWriter.emit$default(codeWriter3, "}", false, 2, null);
                    if (enumName == null && !this.isAnonymousClass) {
                        CodeWriter.emit$default(codeWriter3, str, false, 2, null);
                    }
                    codeWriter3.setStatementLine(statementLine);
                }
                codeWriter3.emitCode("object");
                List listListOf2 = !Intrinsics.areEqual(this.superclass, TypeNames.ANY) ? (z || this.modifiers.contains(KModifier.EXPECT)) ? CollectionsKt.listOf(CodeBlock.INSTANCE.of(" %T", this.superclass)) : CollectionsKt.listOf(CodeBlock.INSTANCE.of(" %T(%L)", this.superclass, codeBlockJoinToCode$default)) : CollectionsKt.emptyList();
                if (this.superinterfaces.isEmpty()) {
                    EmptyList = CollectionsKt.emptyList();
                } else {
                    Set<TypeName> setKeySet = this.superinterfaces.keySet();
                    EmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
                    Iterator it3 = setKeySet.iterator();
                    while (it3.hasNext()) {
                        EmptyList.add(CodeBlock.INSTANCE.of(" %T", (TypeName) it3.next()));
                    }
                }
                List listPlus2 = CollectionsKt.plus((Collection) listListOf2, (Iterable) EmptyList);
                if (!listPlus2.isEmpty()) {
                    codeWriter3.emitCode(" :");
                    CodeWriter.emitCode$default(codeWriter3, CodeBlocks.joinToCode$default(listPlus2, ",", null, null, 6, null), false, false, false, 14, null);
                }
                if (getHasNoBody()) {
                    CodeWriter.emit$default(codeWriter3, " {\n}", false, 2, null);
                    codeWriter3.setStatementLine(statementLine);
                    return;
                }
                CodeWriter.emit$default(codeWriter3, " {\n", false, 2, null);
            }
            i = 0;
            codeWriter3.pushType(this);
            CodeWriter.indent$default(codeWriter3, i, 1, obj);
            Ref$BooleanRef ref$BooleanRef22 = new Ref$BooleanRef();
            ref$BooleanRef22.element = true;
            while (r8.hasNext()) {
            }
            if (this.isEnum) {
            }
            boolean hasInitializer2 = getHasInitializer();
            Ref$BooleanRef ref$BooleanRef32 = new Ref$BooleanRef();
            int i42 = 0;
            while (r20.hasNext()) {
            }
            str = str3;
            emit$possiblyEmitInitializer(ref$BooleanRef32, hasInitializer2, ref$BooleanRef22, codeWriter3, this);
            funSpec = this.primaryConstructor;
            if (funSpec != null) {
                CodeWriter.emit$default(codeWriter3, "init {\n", false, 2, null);
                CodeWriter.indent$default(codeWriter3, 0, 1, null);
                CodeWriter.emitCode$default(codeWriter3, this.primaryConstructor.getBody(), false, false, false, 14, null);
                CodeWriter.unindent$default(codeWriter3, 0, 1, null);
                CodeWriter.emit$default(codeWriter3, "}\n", false, 2, null);
            }
            while (r2.hasNext()) {
            }
            while (r2.hasNext()) {
            }
            while (r2.hasNext()) {
            }
            CodeWriter.unindent$default(codeWriter3, 0, 1, null);
            codeWriter3.popType();
            CodeWriter.emit$default(codeWriter3, "}", false, 2, null);
            if (enumName == null) {
                CodeWriter.emit$default(codeWriter3, str, false, 2, null);
            }
            codeWriter3.setStatementLine(statementLine);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(TypeSpec.class, other.getClass())) {
            return Intrinsics.areEqual(toString(), other.toString());
        }
        return false;
    }

    public List<AnnotationSpec> getAnnotations() {
        return this.annotations;
    }

    public List<TypeName> getContextReceiverTypes() {
        return this.contextReceivers;
    }

    public final Map<String, TypeSpec> getEnumConstants() {
        return this.enumConstants;
    }

    public List<FunSpec> getFunSpecs() {
        return this.funSpecs;
    }

    public CodeBlock getKdoc() {
        return this.kdoc;
    }

    public final String getName() {
        return this.name;
    }

    public final Set<String> getNestedTypesSimpleNames$kotlinpoet() {
        return this.nestedTypesSimpleNames;
    }

    @Override // com.squareup.kotlinpoet.OriginatingElementsHolder
    public List<Element> getOriginatingElements() {
        return this.delegateOriginatingElements.getOriginatingElements();
    }

    public List<PropertySpec> getPropertySpecs() {
        return this.propertySpecs;
    }

    public List<TypeSpec> getTypeSpecs() {
        return this.typeSpecs;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    /* JADX INFO: renamed from: isCompanion, reason: from getter */
    public final boolean getIsCompanion() {
        return this.isCompanion;
    }

    /* JADX INFO: renamed from: isEnum, reason: from getter */
    public final boolean getIsEnum() {
        return this.isEnum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CodeWriter codeWriter = new CodeWriter(sb, null, null, null, null, Integer.MAX_VALUE, 30, null);
        try {
            emit$kotlinpoet$default(this, codeWriter, null, null, false, 12, null);
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

    public /* synthetic */ TypeSpec(Builder builder, Map map, OriginatingElementsHolder originatingElementsHolder, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        map = (i & 2) != 0 ? TaggableKt.buildTagMap(builder) : map;
        if ((i & 4) != 0) {
            List<Element> originatingElements = builder.getOriginatingElements();
            List<TypeSpec> typeSpecs = builder.getTypeSpecs();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = typeSpecs.iterator();
            while (it.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((TypeSpec) it.next()).getOriginatingElements());
            }
            originatingElementsHolder = OriginatingElements.m944boximpl(OriginatingElementsHolderKt.buildOriginatingElements((List<? extends Element>) CollectionsKt.plus((Collection) originatingElements, (Iterable) arrayList)));
        }
        this(builder, map, originatingElementsHolder, (i & 8) != 0 ? ContextReceivableKt.buildContextReceivers(builder) : list);
    }
}
