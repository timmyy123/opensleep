package kotlin.reflect.jvm.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.jvm.KClassesJvm;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt;
import kotlin.reflect.jvm.internal.types.AbstractKType;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006*\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010\t\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J\u001c\u0010\r\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J\u0018\u0010\u000e\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u00020\u00102\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014J\u0012\u0010\u0015\u001a\u00020\u00102\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017J\u0012\u0010\u0018\u001a\u00020\u00102\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0017J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 J\u001e\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001d\u001a\u00020#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%H\u0002J\u0018\u0010&\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\u0006\u0010\u001d\u001a\u00020#H\u0002JB\u0010'\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%2\u0006\u0010(\u001a\u00020\"2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 H\u0002J.\u0010-\u001a\u00020\n*\u00060\u0005j\u0002`\u00062\f\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u0010H\u0002¨\u00062"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "<init>", "()V", "appendReceiverType", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/KParameter;", "appendReceivers", "", "callable", "Lkotlin/reflect/KCallable;", "appendContexts", "appendName", "name", "", "renderCallable", "renderProperty", "property", "Lkotlin/reflect/KProperty;", "renderFunction", "function", "Lkotlin/reflect/KFunction;", "renderLambda", "lambda", "renderParameter", "parameter", "renderType", "type", "Lkotlin/reflect/KType;", "renderRawArgumentPrefix", "", "getTypeClassFqName", "Lkotlin/reflect/jvm/internal/impl/name/FqNameUnsafe;", "Lkotlin/reflect/jvm/internal/types/AbstractKType;", "klass", "Lkotlin/reflect/KClass;", "renderFunctionType", "renderSimpleType", "classFqName", "allArguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "renderTypeArgumentsAndNullability", "typeArguments", "renderFlexibleType", "lowerRendered", "upperRendered", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReflectionObjectRenderer {
    public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KParameter.Kind.values().length];
            try {
                iArr[KParameter.Kind.INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KParameter.Kind.CONTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KParameter.Kind.VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ReflectionObjectRenderer() {
    }

    private final void appendContexts(StringBuilder sb, KCallable<?> kCallable) throws IOException {
        List<KParameter> contextParameters = KCallables.getContextParameters(kCallable);
        if (contextParameters.isEmpty()) {
            return;
        }
        CollectionsKt___CollectionsKt.joinTo(contextParameters, sb, (124 & 2) != 0 ? ", " : null, (124 & 4) != 0 ? "" : "context(", (124 & 8) == 0 ? ") " : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ReflectionObjectRenderer.appendContexts$lambda$0((KParameter) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence appendContexts$lambda$0(KParameter kParameter) {
        kParameter.getClass();
        StringBuilder sb = new StringBuilder();
        String name = kParameter.getName();
        if (name == null) {
            name = "_";
        }
        sb.append(name);
        sb.append(": ");
        sb.append(kParameter.getType());
        return sb.toString();
    }

    private final void appendName(StringBuilder sb, String str) {
        Name nameIdentifier = Name.identifier(str);
        nameIdentifier.getClass();
        sb.append(RenderingUtilsKt.render$default(nameIdentifier, false, 1, null));
    }

    private final StringBuilder appendReceiverType(StringBuilder sb, KParameter kParameter) {
        sb.append(renderType$default(this, kParameter.getType(), false, 2, null));
        sb.append(".");
        return sb;
    }

    private final void appendReceivers(StringBuilder sb, KCallable<?> kCallable) {
        kCallable.getClass();
        List<KParameter> allParameters = ((ReflectKCallable) kCallable).getAllParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allParameters) {
            KParameter kParameter = (KParameter) obj;
            if (kParameter.getKind() == KParameter.Kind.INSTANCE || kParameter.getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                arrayList.add(obj);
            }
        }
        KParameter kParameter2 = (KParameter) CollectionsKt.getOrNull(arrayList, 0);
        if (kParameter2 != null) {
            INSTANCE.appendReceiverType(sb, kParameter2);
        }
        KParameter kParameter3 = (KParameter) CollectionsKt.getOrNull(arrayList, 1);
        if (kParameter3 != null) {
            ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
            sb.append("(");
            reflectionObjectRenderer.appendReceiverType(sb, kParameter3).append(")");
        }
    }

    private final FqNameUnsafe getTypeClassFqName(AbstractKType type, KClass<?> klass) {
        if (type.getIsNothingType()) {
            return StandardNames.FqNames.nothing;
        }
        KClass<?> mutableCollectionClass = type.getMutableCollectionClass();
        if (mutableCollectionClass != null) {
            klass = mutableCollectionClass;
        }
        String qualifiedName = klass.getQualifiedName();
        if (qualifiedName != null) {
            return new FqNameUnsafe(qualifiedName);
        }
        return null;
    }

    private final String renderCallable(KCallable<?> callable) {
        if (callable instanceof KProperty) {
            return renderProperty((KProperty) callable);
        }
        if (callable instanceof KFunction) {
            return renderFunction((KFunction) callable);
        }
        Utf8$$ExternalSyntheticBUOutline0.m("Illegal callable: ", callable);
        return null;
    }

    private final String renderFlexibleType(final String lowerRendered, String upperRendered) {
        if (Intrinsics.areEqual(lowerRendered, StringsKt.replace$default(upperRendered, "?", ""))) {
            return StringsKt.replace$default(upperRendered, "?", "!");
        }
        if (StringsKt__StringsJVMKt.endsWith$default(upperRendered, "?", false, 2, null)) {
            if (Intrinsics.areEqual(lowerRendered + '?', upperRendered)) {
                return lowerRendered + '!';
            }
        }
        if (Intrinsics.areEqual("(" + lowerRendered + ")?", upperRendered)) {
            return FileInsert$$ExternalSyntheticOutline0.m("(", lowerRendered, ")!");
        }
        String strRenderFlexibleMutabilityOrArrayElementVarianceType$default = RenderingUtilsKt.renderFlexibleMutabilityOrArrayElementVarianceType$default(lowerRendered, upperRendered, new Function0(lowerRendered) { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$5
            private final String arg$0;

            {
                this.arg$0 = lowerRendered;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ReflectionObjectRenderer.renderFlexibleType$lambda$0(this.arg$0);
            }
        }, new Function0(lowerRendered) { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$6
            private final String arg$0;

            {
                this.arg$0 = lowerRendered;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ReflectionObjectRenderer.renderFlexibleType$lambda$1(this.arg$0);
            }
        }, null, 16, null);
        if (strRenderFlexibleMutabilityOrArrayElementVarianceType$default != null) {
            return strRenderFlexibleMutabilityOrArrayElementVarianceType$default;
        }
        return "(" + lowerRendered + ".." + upperRendered + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderFlexibleType$lambda$0(String str) {
        String str2 = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.asString() + '.';
        if (!StringsKt.startsWith$default(str, str2)) {
            str2 = null;
        }
        return str2 == null ? "" : str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderFlexibleType$lambda$1(String str) {
        String str2 = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.asString() + '.';
        if (!StringsKt.startsWith$default(str, str2)) {
            str2 = null;
        }
        return str2 == null ? "" : str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderFunction$lambda$0$0(KParameter kParameter) {
        kParameter.getClass();
        return renderType$default(INSTANCE, kParameter.getType(), false, 2, null);
    }

    private final void renderFunctionType(StringBuilder sb, AbstractKType abstractKType) throws IOException {
        if (abstractKType.getIsMarkedNullable()) {
            sb.append("(");
        }
        if (abstractKType.getIsSuspendFunctionType()) {
            sb.append("suspend ");
        }
        CollectionsKt___CollectionsKt.joinTo(CollectionsKt.dropLast(abstractKType.getArguments(), 1), sb, (124 & 2) != 0 ? ", " : null, (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ") -> " : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        sb.append(CollectionsKt.last((List) abstractKType.getArguments()));
        if (abstractKType.getIsMarkedNullable()) {
            sb.append(")?");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderLambda$lambda$0$1(KParameter kParameter) {
        kParameter.getClass();
        return renderType$default(INSTANCE, kParameter.getType(), false, 2, null);
    }

    private final void renderSimpleType(StringBuilder sb, KClass<?> kClass, FqNameUnsafe fqNameUnsafe, List<KTypeProjection> list, boolean z, boolean z2) throws IOException {
        ReflectionObjectRenderer reflectionObjectRenderer;
        StringBuilder sb2;
        boolean z3;
        if (kClass.getTypeParameters().size() >= list.size() || JvmClassMappingKt.getJavaClass(kClass).getDeclaringClass() == null) {
            reflectionObjectRenderer = this;
            sb2 = sb;
            z3 = z2;
            sb2.append(RenderingUtilsKt.render(fqNameUnsafe));
        } else {
            Class<?> declaringClass = JvmClassMappingKt.getJavaClass(kClass).getDeclaringClass();
            declaringClass.getClass();
            reflectionObjectRenderer = this;
            sb2 = sb;
            z3 = z2;
            reflectionObjectRenderer.renderSimpleType(sb2, JvmClassMappingKt.getKotlinClass(declaringClass), fqNameUnsafe.parent(), CollectionsKt.drop(list, kClass.getTypeParameters().size()), false, z3);
            sb2.append(".");
            sb2.append(RenderingUtilsKt.render$default(fqNameUnsafe.shortName(), false, 1, null));
        }
        reflectionObjectRenderer.renderTypeArgumentsAndNullability(sb2, CollectionsKt.take(list, kClass.getTypeParameters().size()), z, z3);
    }

    public static /* synthetic */ String renderType$default(ReflectionObjectRenderer reflectionObjectRenderer, KType kType, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return reflectionObjectRenderer.renderType(kType, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderType$lambda$0$1(Name name) {
        name.getClass();
        return RenderingUtilsKt.render$default(name, false, 1, null);
    }

    private final void renderTypeArgumentsAndNullability(StringBuilder sb, List<KTypeProjection> list, boolean z, final boolean z2) throws IOException {
        StringBuilder sb2;
        if (list.isEmpty()) {
            sb2 = sb;
        } else {
            sb2 = sb;
            CollectionsKt___CollectionsKt.joinTo(list, sb2, (124 & 2) != 0 ? ", " : null, (124 & 4) != 0 ? "" : "<", (124 & 8) == 0 ? ">" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new Function1(z2) { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$4
                private final boolean arg$0;

                {
                    this.arg$0 = z2;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return ReflectionObjectRenderer.renderTypeArgumentsAndNullability$lambda$0(this.arg$0, (KTypeProjection) obj);
                }
            });
        }
        if (z) {
            sb2.append("?");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderTypeArgumentsAndNullability$lambda$0(boolean z, KTypeProjection kTypeProjection) {
        kTypeProjection.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "(raw) " : "");
        sb.append(kTypeProjection);
        return sb.toString();
    }

    public final String renderFunction(KFunction<?> function) throws IOException {
        function.getClass();
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendContexts(sb, function);
        sb.append("fun ");
        reflectionObjectRenderer.appendReceivers(sb, function);
        reflectionObjectRenderer.appendName(sb, function.getName());
        CollectionsKt___CollectionsKt.joinTo(KCallables.getValueParameters(function), sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ReflectionObjectRenderer.renderFunction$lambda$0$0((KParameter) obj);
            }
        });
        sb.append(": ");
        sb.append(renderType$default(reflectionObjectRenderer, function.getReturnType(), false, 2, null));
        return sb.toString();
    }

    public final String renderLambda(KFunction<?> lambda) throws IOException {
        lambda.getClass();
        StringBuilder sb = new StringBuilder();
        KParameter extensionReceiverParameter = KCallables.getExtensionReceiverParameter(lambda);
        if (extensionReceiverParameter != null) {
            sb.append(renderType$default(INSTANCE, extensionReceiverParameter.getType(), false, 2, null));
            sb.append(".");
        }
        CollectionsKt___CollectionsKt.joinTo(KCallables.getValueParameters(lambda), sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ReflectionObjectRenderer.renderLambda$lambda$0$1((KParameter) obj);
            }
        });
        sb.append(" -> ");
        sb.append(renderType$default(INSTANCE, lambda.getReturnType(), false, 2, null));
        return sb.toString();
    }

    public final String renderParameter(KParameter parameter) {
        parameter.getClass();
        StringBuilder sb = new StringBuilder();
        int i = WhenMappings.$EnumSwitchMapping$0[parameter.getKind().ordinal()];
        if (i == 1) {
            sb.append("instance parameter");
        } else if (i == 2) {
            sb.append("context parameter " + parameter.getName());
        } else if (i == 3) {
            sb.append("extension receiver parameter");
        } else {
            if (i != 4) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            sb.append("parameter #" + parameter.getIndex() + ' ' + parameter.getName());
        }
        sb.append(" of ");
        sb.append(INSTANCE.renderCallable(((ReflectKParameter) parameter).getCallable()));
        return sb.toString();
    }

    public final String renderProperty(KProperty<?> property) throws IOException {
        property.getClass();
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.appendContexts(sb, property);
        sb.append(property instanceof KMutableProperty ? "var " : "val ");
        reflectionObjectRenderer.appendReceivers(sb, property);
        reflectionObjectRenderer.appendName(sb, property.getName());
        sb.append(": ");
        sb.append(renderType$default(reflectionObjectRenderer, property.getReturnType(), false, 2, null));
        return sb.toString();
    }

    public final String renderType(KType type, boolean renderRawArgumentPrefix) throws IOException {
        type.getClass();
        AbstractKType abstractKType = (AbstractKType) type;
        if (abstractKType.getIsRawType()) {
            AbstractKType abstractKTypeLowerBoundIfFlexible = abstractKType.getLowerBound();
            abstractKTypeLowerBoundIfFlexible.getClass();
            return renderType(abstractKTypeLowerBoundIfFlexible, true);
        }
        AbstractKType abstractKTypeLowerBoundIfFlexible2 = abstractKType.getLowerBound();
        AbstractKType abstractKTypeUpperBoundIfFlexible = abstractKType.getUpperBound();
        if (abstractKTypeLowerBoundIfFlexible2 != null && abstractKTypeUpperBoundIfFlexible != null) {
            return renderFlexibleType(renderType$default(this, abstractKTypeLowerBoundIfFlexible2, false, 2, null), renderType$default(this, abstractKTypeUpperBoundIfFlexible, false, 2, null));
        }
        StringBuilder sb = new StringBuilder();
        KType abbreviation = abstractKType.getAbbreviation();
        if (abbreviation != null) {
            sb.append(abbreviation);
            sb.append(" /* = ");
        }
        KClassifier classifier = type.getClassifier();
        if (classifier instanceof KTypeParameter) {
            INSTANCE.appendName(sb, ((KTypeParameter) classifier).getName());
            if (type.getIsMarkedNullable()) {
                sb.append("?");
            } else if (abstractKType.getIsDefinitelyNotNullType()) {
                sb.append(" & Any");
            }
        } else if (classifier instanceof KClass) {
            ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
            KClass<?> kClass = (KClass) classifier;
            FqNameUnsafe typeClassFqName = reflectionObjectRenderer.getTypeClassFqName(abstractKType, kClass);
            if (typeClassFqName == null) {
                typeClassFqName = new FqNameUnsafe(KClassesJvm.getJvmName(kClass));
            }
            FqNameUnsafe fqNameUnsafe = typeClassFqName;
            if (!FunctionTypesKt.isNumberedFunctionClassFqName(fqNameUnsafe) || type.getArguments().contains(KTypeProjection.INSTANCE.getSTAR())) {
                reflectionObjectRenderer.renderSimpleType(sb, kClass, fqNameUnsafe, type.getArguments(), type.getIsMarkedNullable(), renderRawArgumentPrefix);
            } else {
                reflectionObjectRenderer.renderFunctionType(sb, abstractKType);
            }
        } else if (classifier instanceof KTypeAliasImpl) {
            CollectionsKt___CollectionsKt.joinTo(((KTypeAliasImpl) classifier).getFqName().pathSegments(), sb, (124 & 2) != 0 ? ", " : ".", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$$Lambda$3
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return ReflectionObjectRenderer.renderType$lambda$0$1((Name) obj);
                }
            });
            INSTANCE.renderTypeArgumentsAndNullability(sb, type.getArguments(), type.getIsMarkedNullable(), renderRawArgumentPrefix);
        } else {
            sb.append("???");
        }
        if (abstractKType.getAbbreviation() != null) {
            sb.append(" */");
        }
        return sb.toString();
    }
}
