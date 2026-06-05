package com.google.devtools.ksp;

import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSDeclaration;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import com.google.devtools.ksp.symbol.KSPropertyDeclaration;
import com.google.devtools.ksp.symbol.KSType;
import com.google.devtools.ksp.symbol.KSTypeAlias;
import com.google.devtools.ksp.symbol.KSTypeParameter;
import com.google.devtools.ksp.symbol.KSTypeReference;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0004\u001a\u0011\u0010\t\u001a\u00020\u0000*\u00020\b¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\u0000¢\u0006\u0004\b\f\u0010\u0004\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "Lkotlin/sequences/Sequence;", "Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "getDeclaredFunctions", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;)Lkotlin/sequences/Sequence;", "Lcom/google/devtools/ksp/symbol/KSPropertyDeclaration;", "getDeclaredProperties", "getConstructors", "Lcom/google/devtools/ksp/symbol/KSTypeAlias;", "findActualType", "(Lcom/google/devtools/ksp/symbol/KSTypeAlias;)Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "Lcom/google/devtools/ksp/symbol/KSType;", "getAllSuperTypes", "", "isConstructor", "(Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;)Z", "api"}, k = 2, mv = {1, 9, 0}, xi = 48)
public abstract class UtilsKt {
    public static final KSClassDeclaration findActualType(KSTypeAlias kSTypeAlias) {
        kSTypeAlias.getClass();
        kSTypeAlias.getType();
        throw null;
    }

    public static final Sequence<KSType> getAllSuperTypes(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        return SequencesKt.distinct(SequencesKt.plus(SequencesKt.map(kSClassDeclaration.getSuperTypes(), new Function1<KSTypeReference, KSType>() { // from class: com.google.devtools.ksp.UtilsKt.getAllSuperTypes.1
            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ KSType invoke(KSTypeReference kSTypeReference) {
                if (kSTypeReference == null) {
                    invoke2((KSTypeReference) null);
                    return null;
                }
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final KSType invoke2(KSTypeReference kSTypeReference) {
                kSTypeReference.getClass();
                kSTypeReference.resolve();
                return null;
            }
        }), SequencesKt.flatMap(SequencesKt.mapNotNull(kSClassDeclaration.getSuperTypes(), new Function1<KSTypeReference, KSDeclaration>() { // from class: com.google.devtools.ksp.UtilsKt.getAllSuperTypes.2
            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ KSDeclaration invoke(KSTypeReference kSTypeReference) {
                if (kSTypeReference == null) {
                    return invoke2((KSTypeReference) null);
                }
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final KSDeclaration invoke2(KSTypeReference kSTypeReference) {
                kSTypeReference.getClass();
                kSTypeReference.resolve();
                throw null;
            }
        }), new Function1<KSDeclaration, Sequence<? extends KSType>>() { // from class: com.google.devtools.ksp.UtilsKt.getAllSuperTypes.3
            @Override // kotlin.jvm.functions.Function1
            public final Sequence<KSType> invoke(KSDeclaration kSDeclaration) {
                kSDeclaration.getClass();
                if (kSDeclaration instanceof KSClassDeclaration) {
                    return UtilsKt.getAllSuperTypes((KSClassDeclaration) kSDeclaration);
                }
                if (kSDeclaration instanceof KSTypeAlias) {
                    return UtilsKt.getAllSuperTypes(UtilsKt.findActualType((KSTypeAlias) kSDeclaration));
                }
                if (kSDeclaration instanceof KSTypeParameter) {
                    return SequencesKt.flatMap(UtilsKt.getAllSuperTypes$getTypesUpperBound((KSTypeParameter) kSDeclaration), new Function1<KSClassDeclaration, Sequence<? extends KSType>>() { // from class: com.google.devtools.ksp.UtilsKt.getAllSuperTypes.3.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Sequence<KSType> invoke(KSClassDeclaration kSClassDeclaration2) {
                            kSClassDeclaration2.getClass();
                            return UtilsKt.getAllSuperTypes(kSClassDeclaration2);
                        }
                    });
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("unhandled super type kind, please file a bug at https://github.com/google/ksp/issues/new");
                return null;
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence<KSClassDeclaration> getAllSuperTypes$getTypesUpperBound(KSTypeParameter kSTypeParameter) {
        return SequencesKt.flatMap(kSTypeParameter.getBounds(), new Function1<KSTypeReference, Sequence<? extends KSClassDeclaration>>() { // from class: com.google.devtools.ksp.UtilsKt$getAllSuperTypes$getTypesUpperBound$1
            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Sequence<? extends KSClassDeclaration> invoke(KSTypeReference kSTypeReference) {
                if (kSTypeReference == null) {
                    return invoke2((KSTypeReference) null);
                }
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Sequence<KSClassDeclaration> invoke2(KSTypeReference kSTypeReference) {
                kSTypeReference.getClass();
                kSTypeReference.resolve();
                throw null;
            }
        });
    }

    public static final Sequence<KSFunctionDeclaration> getConstructors(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        return SequencesKt.filter(getDeclaredFunctions(kSClassDeclaration), new Function1<KSFunctionDeclaration, Boolean>() { // from class: com.google.devtools.ksp.UtilsKt.getConstructors.1
            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Boolean invoke(KSFunctionDeclaration kSFunctionDeclaration) {
                if (kSFunctionDeclaration == null) {
                    return invoke2((KSFunctionDeclaration) null);
                }
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(KSFunctionDeclaration kSFunctionDeclaration) {
                kSFunctionDeclaration.getClass();
                return Boolean.valueOf(UtilsKt.isConstructor(kSFunctionDeclaration));
            }
        });
    }

    public static final Sequence<KSFunctionDeclaration> getDeclaredFunctions(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        Sequence<KSFunctionDeclaration> sequenceFilter = SequencesKt.filter(kSClassDeclaration.getDeclarations(), new Function1<Object, Boolean>() { // from class: com.google.devtools.ksp.UtilsKt$getDeclaredFunctions$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return false;
            }
        });
        sequenceFilter.getClass();
        return sequenceFilter;
    }

    public static final Sequence<KSPropertyDeclaration> getDeclaredProperties(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        Sequence<KSPropertyDeclaration> sequenceFilter = SequencesKt.filter(kSClassDeclaration.getDeclarations(), new Function1<Object, Boolean>() { // from class: com.google.devtools.ksp.UtilsKt$getDeclaredProperties$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return false;
            }
        });
        sequenceFilter.getClass();
        return sequenceFilter;
    }

    public static final boolean isConstructor(KSFunctionDeclaration kSFunctionDeclaration) {
        kSFunctionDeclaration.getClass();
        kSFunctionDeclaration.getSimpleName();
        throw null;
    }
}
