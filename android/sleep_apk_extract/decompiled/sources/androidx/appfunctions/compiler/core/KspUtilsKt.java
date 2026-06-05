package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.devtools.ksp.symbol.KSAnnotation;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSDeclaration;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import com.google.devtools.ksp.symbol.KSName;
import com.google.devtools.ksp.symbol.KSNode;
import com.google.devtools.ksp.symbol.KSPropertyDeclaration;
import com.google.devtools.ksp.symbol.KSType;
import com.google.devtools.ksp.symbol.KSTypeArgument;
import com.google.devtools.ksp.symbol.KSTypeParameter;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.google.devtools.ksp.symbol.KSValueParameter;
import com.google.devtools.ksp.symbol.Variance;
import com.squareup.kotlinpoet.ClassName;
import com.squareup.kotlinpoet.ParameterizedTypeName;
import com.squareup.kotlinpoet.TypeName;
import com.squareup.kotlinpoet.TypeNames;
import com.squareup.kotlinpoet.TypeVariableName;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\u000b\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\t\u001a\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\b\u0012\u0004\u0012\u00020\u00110\u00122\u0006\u0010\u0013\u001a\u00020\t\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0001\u001a/\u0010\u0016\u001a\u0002H\u0017\"\b\b\u0000\u0010\u0017*\u00020\u0018*\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00170\u001b¢\u0006\u0002\u0010\u001c\u001a\n\u0010\u001d\u001a\u00020\u001e*\u00020\u0001\u001a\n\u0010\u001f\u001a\u00020\u0006*\u00020 \u001a\n\u0010!\u001a\u00020\u000e*\u00020\"\u001a\f\u0010#\u001a\u00020\u001e*\u00020\u001eH\u0000\u001a\u001c\u0010\u001d\u001a\u00020\u001e*\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002\u001a\f\u0010\u001d\u001a\u00020\u001e*\u00020'H\u0002\u001a\u001a\u0010(\u001a\u00020\u001e*\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0&H\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u001b¨\u0006)"}, d2 = {"resolveSelfOrUpperBoundType", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "toTypeVariableName", "Lcom/squareup/kotlinpoet/TypeVariableName;", "Lcom/google/devtools/ksp/symbol/KSTypeParameter;", "ensureQualifiedName", "", "Lcom/google/devtools/ksp/symbol/KSDeclaration;", "toClassName", "Lcom/squareup/kotlinpoet/ClassName;", "getJvmQualifiedName", "getJvmClassName", "resolveListParameterizedType", "isOfType", "", "type", "findAnnotation", "Lcom/google/devtools/ksp/symbol/KSAnnotation;", "Lkotlin/sequences/Sequence;", "annotationClass", "ensureQualifiedTypeName", "Lcom/google/devtools/ksp/symbol/KSName;", "requirePropertyValueOfType", "T", "", "propertyName", "expectedType", "Lkotlin/reflect/KClass;", "(Lcom/google/devtools/ksp/symbol/KSAnnotation;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toTypeName", "Lcom/squareup/kotlinpoet/TypeName;", "getQualifiedName", "Lcom/google/devtools/ksp/symbol/KSPropertyDeclaration;", "isEffectivelyOptional", "Lcom/google/devtools/ksp/symbol/KSValueParameter;", "ignoreNullable", "Lcom/google/devtools/ksp/symbol/KSType;", "arguments", "", "Lcom/google/devtools/ksp/symbol/KSTypeArgument;", "withTypeArguments", "appfunctions-compiler"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KspUtilsKt {

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.COVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.CONTRAVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Variance.STAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Variance.INVARIANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String ensureQualifiedName(KSDeclaration kSDeclaration) throws ProcessingException {
        kSDeclaration.getClass();
        kSDeclaration.getQualifiedName();
        throw new ProcessingException("Unable to resolve the qualified name", kSDeclaration, null, 4, null);
    }

    public static final KSName ensureQualifiedTypeName(KSTypeReference kSTypeReference) {
        kSTypeReference.getClass();
        kSTypeReference.resolve();
        throw null;
    }

    public static final KSAnnotation findAnnotation(Sequence<? extends KSAnnotation> sequence, ClassName className) {
        sequence.getClass();
        className.getClass();
        Iterator<? extends KSAnnotation> it = sequence.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
        return null;
    }

    public static final String getJvmClassName(KSDeclaration kSDeclaration) {
        kSDeclaration.getClass();
        return StringsKt__StringsKt.substringAfterLast$default(toClassName(kSDeclaration).reflectionName(), '.', (String) null, 2, (Object) null);
    }

    public static final String getJvmQualifiedName(KSDeclaration kSDeclaration) {
        kSDeclaration.getClass();
        return toClassName(kSDeclaration).reflectionName();
    }

    public static final String getQualifiedName(KSPropertyDeclaration kSPropertyDeclaration) throws ProcessingException {
        kSPropertyDeclaration.getClass();
        kSPropertyDeclaration.getQualifiedName();
        throw new ProcessingException("Unable to resolve the qualified name", kSPropertyDeclaration, null, 4, null);
    }

    public static final TypeName ignoreNullable(TypeName typeName) {
        typeName.getClass();
        return TypeName.copy$default(typeName, false, null, 2, null);
    }

    public static final boolean isEffectivelyOptional(KSValueParameter kSValueParameter) throws ProcessingException {
        kSValueParameter.getClass();
        if (kSValueParameter.getHasDefault()) {
            return true;
        }
        KSNode parent = kSValueParameter.getParent();
        KSFunctionDeclaration kSFunctionDeclaration = parent instanceof KSFunctionDeclaration ? (KSFunctionDeclaration) parent : null;
        if (kSFunctionDeclaration == null) {
            kSValueParameter.getName();
            throw new ProcessingException("Unable to resolve containing function of null", kSValueParameter, null, 4, null);
        }
        int iIndexOf = kSFunctionDeclaration.getParameters().indexOf(kSValueParameter);
        if (iIndexOf == -1) {
            kSValueParameter.getName();
            throw new ProcessingException("Unable to resolve parameter of null", kSValueParameter, null, 4, null);
        }
        KSDeclaration kSDeclarationFindOverridee = kSFunctionDeclaration.findOverridee();
        if (kSDeclarationFindOverridee != null && (kSDeclarationFindOverridee instanceof KSFunctionDeclaration) && CollectionsKt.getOrNull(((KSFunctionDeclaration) kSDeclarationFindOverridee).getParameters(), iIndexOf) != null) {
            Events$$ExternalSyntheticBUOutline0.m();
        }
        return false;
    }

    public static final boolean isOfType(KSTypeReference kSTypeReference, ClassName className) {
        kSTypeReference.getClass();
        className.getClass();
        ensureQualifiedTypeName(kSTypeReference);
        throw null;
    }

    public static final <T> T requirePropertyValueOfType(KSAnnotation kSAnnotation, String str, KClass<T> kClass) throws ProcessingException {
        kSAnnotation.getClass();
        str.getClass();
        kClass.getClass();
        Iterator<T> it = kSAnnotation.getArguments().iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
        throw new ProcessingException("Unable to find property with name: ".concat(str), kSAnnotation, null, 4, null);
    }

    public static final KSTypeReference resolveListParameterizedType(KSTypeReference kSTypeReference) throws ProcessingException {
        kSTypeReference.getClass();
        if (!isOfType(kSTypeReference, TypeNames.LIST)) {
            throw new ProcessingException("Unable to resolve list parameterized type for non list type", kSTypeReference, null, 4, null);
        }
        kSTypeReference.resolve();
        throw null;
    }

    public static final KSTypeReference resolveSelfOrUpperBoundType(KSTypeReference kSTypeReference) {
        kSTypeReference.getClass();
        kSTypeReference.resolve();
        throw null;
    }

    public static final ClassName toClassName(KSDeclaration kSDeclaration) {
        kSDeclaration.getClass();
        kSDeclaration.getPackageName();
        throw null;
    }

    private static final TypeName toTypeName(KSType kSType, List<? extends KSTypeArgument> list) throws ProcessingException {
        if (!(kSType.getDeclaration() instanceof KSClassDeclaration)) {
            throw new ProcessingException("Unable to resolve TypeName", kSType.getDeclaration(), null, 4, null);
        }
        ClassName className = toClassName(kSType.getDeclaration());
        List<? extends KSTypeArgument> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            arrayList.add(toTypeName((KSTypeArgument) null));
        }
        return TypeName.copy$default(withTypeArguments(className, arrayList), kSType.isMarkedNullable(), null, 2, null);
    }

    public static /* synthetic */ TypeName toTypeName$default(KSType kSType, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        return toTypeName(kSType, list);
    }

    public static final TypeVariableName toTypeVariableName(KSTypeParameter kSTypeParameter) {
        kSTypeParameter.getClass();
        TypeVariableName.Companion companion = TypeVariableName.INSTANCE;
        kSTypeParameter.getName();
        throw null;
    }

    private static final TypeName withTypeArguments(ClassName className, List<? extends TypeName> list) {
        return list.isEmpty() ? className : ParameterizedTypeName.INSTANCE.get(className, list);
    }

    public static final String ensureQualifiedName(KClass<?> kClass) {
        kClass.getClass();
        String qualifiedName = kClass.getQualifiedName();
        if (qualifiedName != null) {
            return qualifiedName;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
        return null;
    }

    public static final TypeName toTypeName(KSTypeReference kSTypeReference) {
        kSTypeReference.getClass();
        kSTypeReference.resolve();
        throw null;
    }

    private static final TypeName toTypeName(KSTypeArgument kSTypeArgument) {
        kSTypeArgument.getType();
        return TypeNames.STAR;
    }
}
