package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable;
import androidx.appfunctions.compiler.core.AppFunctionSerializableType;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.devtools.ksp.symbol.KSAnnotation;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSFile;
import com.google.devtools.ksp.symbol.Modifier;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 $2\u00020\u0001:\u0003\"#$B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\tH&J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\b\u0010\nR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u0002%&¨\u0006'"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable;", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "<init>", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;)V", "getClassDeclaration", "()Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "isDescribedByKDoc", "", "()Z", "isDescribedByKDoc$delegate", "Lkotlin/Lazy;", "oneOfSerializables", "Lkotlin/sequences/Sequence;", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializable;", "getOneOfSerializables", "()Lkotlin/sequences/Sequence;", "supportsExhaustiveWhen", "validate", "allowSerializableInterfaceTypes", "getSerializableSourceFiles", "", "Lcom/google/devtools/ksp/symbol/KSFile;", "getFactoryCodeBuilder", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType$FactoryCodeBuilder;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "getProperties", "", "Landroidx/appfunctions/compiler/core/AppFunctionPropertyDeclaration;", "sharedDataTypeDescriptionMap", "", "", "SealedOneOfSerializable", "NonSealedOneOfSerializable", "Companion", "Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable$NonSealedOneOfSerializable;", "Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable$SealedOneOfSerializable;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AnnotatedOneOfAppFunctionSerializable implements AppFunctionSerializableType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final KSClassDeclaration classDeclaration;

    /* JADX INFO: renamed from: isDescribedByKDoc$delegate, reason: from kotlin metadata */
    private final Lazy isDescribedByKDoc;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable$Companion;", "", "<init>", "()V", "create", "Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable;", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "findOneOfTypeAnnotation", "Lcom/google/devtools/ksp/symbol/KSAnnotation;", "isOneOfType", "", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final /* synthetic */ KSAnnotation access$findOneOfTypeAnnotation(Companion companion, KSClassDeclaration kSClassDeclaration) {
            companion.findOneOfTypeAnnotation(kSClassDeclaration);
            return null;
        }

        private final KSAnnotation findOneOfTypeAnnotation(KSClassDeclaration classDeclaration) {
            KspUtilsKt.findAnnotation(classDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionOneOfTypeAnnotation.INSTANCE.getCLASS_NAME());
            return null;
        }

        public final AnnotatedOneOfAppFunctionSerializable create(KSClassDeclaration classDeclaration) throws ProcessingException {
            classDeclaration.getClass();
            if (classDeclaration.getModifiers().contains(Modifier.SEALED)) {
                return new SealedOneOfSerializable(classDeclaration);
            }
            KspUtilsKt.findAnnotation(classDeclaration.getAnnotations(), IntrospectionHelper.AppFunctionOneOfTypeAnnotation.INSTANCE.getCLASS_NAME());
            throw new ProcessingException("Cannot be represented as a oneOf Type", classDeclaration, null, 4, null);
        }

        public final boolean isOneOfType(KSClassDeclaration classDeclaration) {
            classDeclaration.getClass();
            if (classDeclaration.getModifiers().contains(Modifier.SEALED)) {
                return true;
            }
            findOneOfTypeAnnotation(classDeclaration);
            return false;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001c"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable$NonSealedOneOfSerializable;", "Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable;", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "<init>", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;)V", "oneOfTypeAnnotation", "Lcom/google/devtools/ksp/symbol/KSAnnotation;", "getOneOfTypeAnnotation", "()Lcom/google/devtools/ksp/symbol/KSAnnotation;", "oneOfTypeAnnotation$delegate", "Lkotlin/Lazy;", "allowedOneOfDeclarations", "Lkotlin/sequences/Sequence;", "getAllowedOneOfDeclarations", "()Lkotlin/sequences/Sequence;", "allowedOneOfDeclarations$delegate", "oneOfSerializables", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializable;", "getOneOfSerializables", "oneOfSerializables$delegate", "validate", "allowSerializableInterfaceTypes", "", "isSubclass", "subclassDecl", "superclassDecl", "supportsExhaustiveWhen", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NonSealedOneOfSerializable extends AnnotatedOneOfAppFunctionSerializable {

        /* JADX INFO: renamed from: allowedOneOfDeclarations$delegate, reason: from kotlin metadata */
        private final Lazy allowedOneOfDeclarations;

        /* JADX INFO: renamed from: oneOfSerializables$delegate, reason: from kotlin metadata */
        private final Lazy oneOfSerializables;

        /* JADX INFO: renamed from: oneOfTypeAnnotation$delegate, reason: from kotlin metadata */
        private final Lazy oneOfTypeAnnotation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NonSealedOneOfSerializable(KSClassDeclaration kSClassDeclaration) {
            super(kSClassDeclaration, null);
            kSClassDeclaration.getClass();
            final int i = 1;
            this.oneOfTypeAnnotation = LazyKt.lazy(new XmlFileResolver$Companion$$ExternalSyntheticLambda0(kSClassDeclaration, i));
            final int i2 = 0;
            this.allowedOneOfDeclarations = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable$NonSealedOneOfSerializable$$ExternalSyntheticLambda2
                public final /* synthetic */ AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable f$0;

                {
                    this.f$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int i3 = i2;
                    AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable nonSealedOneOfSerializable = this.f$0;
                    switch (i3) {
                        case 0:
                            return AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable.allowedOneOfDeclarations_delegate$lambda$0(nonSealedOneOfSerializable);
                        default:
                            return AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable.oneOfSerializables_delegate$lambda$0(nonSealedOneOfSerializable);
                    }
                }
            });
            this.oneOfSerializables = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable$NonSealedOneOfSerializable$$ExternalSyntheticLambda2
                public final /* synthetic */ AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable f$0;

                {
                    this.f$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int i3 = i;
                    AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable nonSealedOneOfSerializable = this.f$0;
                    switch (i3) {
                        case 0:
                            return AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable.allowedOneOfDeclarations_delegate$lambda$0(nonSealedOneOfSerializable);
                        default:
                            return AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable.oneOfSerializables_delegate$lambda$0(nonSealedOneOfSerializable);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Sequence allowedOneOfDeclarations_delegate$lambda$0(NonSealedOneOfSerializable nonSealedOneOfSerializable) {
            nonSealedOneOfSerializable.getOneOfTypeAnnotation();
            return SequencesKt.map(CollectionsKt.asSequence((Iterable) KspUtilsKt.requirePropertyValueOfType(null, IntrospectionHelper.AppFunctionOneOfTypeAnnotation.PROPERTY_MATCH_ONE_OF, Reflection.getOrCreateKotlinClass(List.class))), new AppFunctionMetadataCreatorHelper$$ExternalSyntheticLambda0(nonSealedOneOfSerializable, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KSClassDeclaration allowedOneOfDeclarations_delegate$lambda$0$0(NonSealedOneOfSerializable nonSealedOneOfSerializable, Object obj) throws ProcessingException {
            String str = obj + " provided in matchOneOf property of AppFunctionOneOfType could not be processed as KSType";
            nonSealedOneOfSerializable.getOneOfTypeAnnotation();
            throw new ProcessingException(str, null, null, 4, null);
        }

        private final Sequence<KSClassDeclaration> getAllowedOneOfDeclarations() {
            return (Sequence) this.allowedOneOfDeclarations.getValue();
        }

        private final KSAnnotation getOneOfTypeAnnotation() {
            if (this.oneOfTypeAnnotation.getValue() == null) {
                return null;
            }
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }

        private final boolean isSubclass(KSClassDeclaration subclassDecl, KSClassDeclaration superclassDecl) {
            subclassDecl.asStarProjectedType();
            superclassDecl.asStarProjectedType();
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Sequence oneOfSerializables_delegate$lambda$0(NonSealedOneOfSerializable nonSealedOneOfSerializable) {
            return SequencesKt.map(nonSealedOneOfSerializable.getAllowedOneOfDeclarations(), new StringUtilsKt$$ExternalSyntheticLambda0(1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AnnotatedAppFunctionSerializable oneOfSerializables_delegate$lambda$0$0(KSClassDeclaration kSClassDeclaration) {
            kSClassDeclaration.getClass();
            return new AnnotatedAppFunctionSerializable(kSClassDeclaration);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KSAnnotation oneOfTypeAnnotation_delegate$lambda$0(KSClassDeclaration kSClassDeclaration) throws ProcessingException {
            Companion.access$findOneOfTypeAnnotation(AnnotatedOneOfAppFunctionSerializable.INSTANCE, kSClassDeclaration);
            throw new ProcessingException("@AppFunctionOneOfType annotation not found", kSClassDeclaration, null, 4, null);
        }

        @Override // androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable
        public Sequence<AnnotatedAppFunctionSerializable> getOneOfSerializables() {
            return (Sequence) this.oneOfSerializables.getValue();
        }

        @Override // androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable
        public boolean supportsExhaustiveWhen() {
            return false;
        }

        @Override // androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable, androidx.appfunctions.compiler.core.AppFunctionSerializableType
        public NonSealedOneOfSerializable validate(boolean allowSerializableInterfaceTypes) throws ProcessingException {
            for (KSClassDeclaration kSClassDeclaration : getAllowedOneOfDeclarations()) {
                if (!isSubclass(kSClassDeclaration, getClassDeclaration())) {
                    throw new ProcessingException(FileInsert$$ExternalSyntheticOutline0.m$1(KspUtilsKt.getJvmClassName(kSClassDeclaration), " is not a subclass of ", KspUtilsKt.getJvmClassName(getClassDeclaration())), kSClassDeclaration, null, 4, null);
                }
            }
            AnnotatedOneOfAppFunctionSerializable annotatedOneOfAppFunctionSerializableValidate = super.validate(allowSerializableInterfaceTypes);
            annotatedOneOfAppFunctionSerializableValidate.getClass();
            return (NonSealedOneOfSerializable) annotatedOneOfAppFunctionSerializableValidate;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000e\u0010\t¨\u0006\u0014"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable$SealedOneOfSerializable;", "Landroidx/appfunctions/compiler/core/AnnotatedOneOfAppFunctionSerializable;", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "<init>", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;)V", "sealedSubclasses", "Lkotlin/sequences/Sequence;", "getSealedSubclasses", "()Lkotlin/sequences/Sequence;", "sealedSubclasses$delegate", "Lkotlin/Lazy;", "oneOfSerializables", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializable;", "getOneOfSerializables", "oneOfSerializables$delegate", "validate", "allowSerializableInterfaceTypes", "", "supportsExhaustiveWhen", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SealedOneOfSerializable extends AnnotatedOneOfAppFunctionSerializable {

        /* JADX INFO: renamed from: oneOfSerializables$delegate, reason: from kotlin metadata */
        private final Lazy oneOfSerializables;

        /* JADX INFO: renamed from: sealedSubclasses$delegate, reason: from kotlin metadata */
        private final Lazy sealedSubclasses;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SealedOneOfSerializable(KSClassDeclaration kSClassDeclaration) {
            super(kSClassDeclaration, null);
            kSClassDeclaration.getClass();
            this.sealedSubclasses = LazyKt.lazy(new XmlFileResolver$Companion$$ExternalSyntheticLambda0(kSClassDeclaration, 2));
            this.oneOfSerializables = LazyKt.lazy(new AppFunctionPropertyDeclaration$$ExternalSyntheticLambda1(this, 1));
        }

        private final Sequence<KSClassDeclaration> getSealedSubclasses() {
            return (Sequence) this.sealedSubclasses.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Sequence oneOfSerializables_delegate$lambda$0(SealedOneOfSerializable sealedOneOfSerializable) {
            return SequencesKt.map(sealedOneOfSerializable.getSealedSubclasses(), new StringUtilsKt$$ExternalSyntheticLambda0(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AnnotatedAppFunctionSerializable oneOfSerializables_delegate$lambda$0$0(KSClassDeclaration kSClassDeclaration) {
            kSClassDeclaration.getClass();
            return new AnnotatedAppFunctionSerializable(kSClassDeclaration);
        }

        @Override // androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable
        public Sequence<AnnotatedAppFunctionSerializable> getOneOfSerializables() {
            return (Sequence) this.oneOfSerializables.getValue();
        }

        @Override // androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable
        public boolean supportsExhaustiveWhen() {
            return true;
        }

        @Override // androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable, androidx.appfunctions.compiler.core.AppFunctionSerializableType
        public SealedOneOfSerializable validate(boolean allowSerializableInterfaceTypes) throws ProcessingException {
            if (!getAppFunctionSerializableTypeClassDeclaration().getModifiers().contains(Modifier.SEALED)) {
                throw new ProcessingException(FileInsert$$ExternalSyntheticOutline0.m("Non-sealed classes cannot be used to represent OneOf. ", getAppFunctionSerializableTypeClassDeclaration().getJvmClassName(), " is not sealed."), getAppFunctionSerializableTypeClassDeclaration().getAttributeNode(), null, 4, null);
            }
            for (KSClassDeclaration kSClassDeclaration : getSealedSubclasses()) {
                if (kSClassDeclaration.getModifiers().contains(Modifier.SEALED)) {
                    throw new ProcessingException(FileInsert$$ExternalSyntheticOutline0.m("Nested sealed classes are not allowed. ", KspUtilsKt.getJvmClassName(kSClassDeclaration), " is a sealed class within ", getAppFunctionSerializableTypeClassDeclaration().getJvmClassName(), "."), kSClassDeclaration, null, 4, null);
                }
            }
            AnnotatedOneOfAppFunctionSerializable annotatedOneOfAppFunctionSerializableValidate = super.validate(allowSerializableInterfaceTypes);
            annotatedOneOfAppFunctionSerializableValidate.getClass();
            return (SealedOneOfSerializable) annotatedOneOfAppFunctionSerializableValidate;
        }
    }

    private AnnotatedOneOfAppFunctionSerializable(KSClassDeclaration kSClassDeclaration) {
        this.classDeclaration = kSClassDeclaration;
        this.isDescribedByKDoc = LazyKt.lazy(new AppFunctionPropertyDeclaration$$ExternalSyntheticLambda1(this, 3));
    }

    private static final Iterable getSerializableSourceFiles$lambda$0$0(AnnotatedAppFunctionSerializable annotatedAppFunctionSerializable) {
        annotatedAppFunctionSerializable.getClass();
        return annotatedAppFunctionSerializable.getSerializableSourceFiles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDescribedByKDoc_delegate$lambda$0(AnnotatedOneOfAppFunctionSerializable annotatedOneOfAppFunctionSerializable) {
        KspUtilsKt.findAnnotation(annotatedOneOfAppFunctionSerializable.getClassDeclaration().getAnnotations(), IntrospectionHelper.AppFunctionSerializableAnnotation.INSTANCE.getCLASS_NAME());
        return false;
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public KSClassDeclaration getClassDeclaration() {
        return this.classDeclaration;
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public AppFunctionSerializableType.FactoryCodeBuilder getFactoryCodeBuilder(AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) {
        resolvedAnnotatedSerializableProxies.getClass();
        return new OneOfAppFunctionSerializableFactoryCodeBuilder(this);
    }

    public abstract Sequence<AnnotatedAppFunctionSerializable> getOneOfSerializables();

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public List<AppFunctionPropertyDeclaration> getProperties(Map<String, String> sharedDataTypeDescriptionMap) {
        sharedDataTypeDescriptionMap.getClass();
        return CollectionsKt.emptyList();
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public Set<KSFile> getSerializableSourceFiles() {
        SetsKt.createSetBuilder();
        getClassDeclaration().getContainingFile();
        throw new IllegalStateException("Required value was null.");
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    /* JADX INFO: renamed from: isDescribedByKDoc */
    public boolean getIsDescribedByKDoc() {
        return ((Boolean) this.isDescribedByKDoc.getValue()).booleanValue();
    }

    public abstract boolean supportsExhaustiveWhen();

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public AnnotatedOneOfAppFunctionSerializable validate(boolean allowSerializableInterfaceTypes) {
        Iterator<AnnotatedAppFunctionSerializable> it = getOneOfSerializables().iterator();
        while (it.hasNext()) {
            AppFunctionSerializableType.validate$default(it.next(), false, 1, null);
        }
        return this;
    }

    public /* synthetic */ AnnotatedOneOfAppFunctionSerializable(KSClassDeclaration kSClassDeclaration, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSClassDeclaration);
    }
}
