package androidx.appfunctions.compiler.core;

import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSDeclaration;
import com.google.devtools.ksp.symbol.KSFunctionDeclaration;
import com.google.devtools.ksp.symbol.KSNode;
import com.google.devtools.ksp.symbol.KSTypeParameter;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.google.devtools.ksp.symbol.Modifier;
import com.squareup.kotlinpoet.ClassName;
import com.squareup.kotlinpoet.ParameterizedTypeName;
import com.squareup.kotlinpoet.TypeName;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0017\u0010\u0013R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b&\u0010'R!\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u001b\u00109\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u000b\u001a\u0004\b:\u0010\t¨\u0006<"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionSerializableTypeClassDeclaration;", "", "classDeclaration", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "<init>", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;)V", "jvmQualifiedName", "", "getJvmQualifiedName", "()Ljava/lang/String;", "jvmQualifiedName$delegate", "Lkotlin/Lazy;", "jvmClassName", "getJvmClassName", "jvmClassName$delegate", "superTypes", "Lkotlin/sequences/Sequence;", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "getSuperTypes", "()Lkotlin/sequences/Sequence;", "superTypes$delegate", "declarations", "Lcom/google/devtools/ksp/symbol/KSDeclaration;", "getDeclarations", "declarations$delegate", "modifiers", "", "Lcom/google/devtools/ksp/symbol/Modifier;", "getModifiers", "()Ljava/util/Set;", "modifiers$delegate", "primaryConstructor", "Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "getPrimaryConstructor", "()Lcom/google/devtools/ksp/symbol/KSFunctionDeclaration;", "primaryConstructor$delegate", "attributeNode", "Lcom/google/devtools/ksp/symbol/KSNode;", "getAttributeNode", "()Lcom/google/devtools/ksp/symbol/KSNode;", "attributeNode$delegate", "typeParameters", "", "Lcom/google/devtools/ksp/symbol/KSTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "typeParameters$delegate", "originalClassName", "Lcom/squareup/kotlinpoet/ClassName;", "getOriginalClassName", "()Lcom/squareup/kotlinpoet/ClassName;", "originalClassName$delegate", "typeName", "Lcom/squareup/kotlinpoet/TypeName;", "getTypeName", "()Lcom/squareup/kotlinpoet/TypeName;", "typeName$delegate", "docString", "getDocString", "docString$delegate", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionSerializableTypeClassDeclaration {

    /* JADX INFO: renamed from: attributeNode$delegate, reason: from kotlin metadata */
    private final Lazy attributeNode;
    private final KSClassDeclaration classDeclaration;

    /* JADX INFO: renamed from: declarations$delegate, reason: from kotlin metadata */
    private final Lazy declarations;

    /* JADX INFO: renamed from: docString$delegate, reason: from kotlin metadata */
    private final Lazy docString;

    /* JADX INFO: renamed from: jvmClassName$delegate, reason: from kotlin metadata */
    private final Lazy jvmClassName;

    /* JADX INFO: renamed from: jvmQualifiedName$delegate, reason: from kotlin metadata */
    private final Lazy jvmQualifiedName;

    /* JADX INFO: renamed from: modifiers$delegate, reason: from kotlin metadata */
    private final Lazy modifiers;

    /* JADX INFO: renamed from: originalClassName$delegate, reason: from kotlin metadata */
    private final Lazy originalClassName;

    /* JADX INFO: renamed from: primaryConstructor$delegate, reason: from kotlin metadata */
    private final Lazy primaryConstructor;

    /* JADX INFO: renamed from: superTypes$delegate, reason: from kotlin metadata */
    private final Lazy superTypes;

    /* JADX INFO: renamed from: typeName$delegate, reason: from kotlin metadata */
    private final Lazy typeName;

    /* JADX INFO: renamed from: typeParameters$delegate, reason: from kotlin metadata */
    private final Lazy typeParameters;

    public AppFunctionSerializableTypeClassDeclaration(KSClassDeclaration kSClassDeclaration) {
        kSClassDeclaration.getClass();
        this.classDeclaration = kSClassDeclaration;
        final int i = 0;
        this.jvmQualifiedName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionSerializableTypeClassDeclaration$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionSerializableTypeClassDeclaration f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration = this.f$0;
                switch (i2) {
                    case 0:
                        return AppFunctionSerializableTypeClassDeclaration.jvmQualifiedName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 1:
                        return AppFunctionSerializableTypeClassDeclaration.typeName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 2:
                        return AppFunctionSerializableTypeClassDeclaration.docString_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 3:
                        return AppFunctionSerializableTypeClassDeclaration.jvmClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 4:
                        return AppFunctionSerializableTypeClassDeclaration.superTypes_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 5:
                        return AppFunctionSerializableTypeClassDeclaration.declarations_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 6:
                        return AppFunctionSerializableTypeClassDeclaration.modifiers_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 7:
                        AppFunctionSerializableTypeClassDeclaration.primaryConstructor_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                        return null;
                    case 8:
                        return appFunctionSerializableTypeClassDeclaration.classDeclaration;
                    case 9:
                        return AppFunctionSerializableTypeClassDeclaration.typeParameters_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    default:
                        return AppFunctionSerializableTypeClassDeclaration.originalClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                }
            }
        });
        final int i2 = 3;
        this.jvmClassName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionSerializableTypeClassDeclaration$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionSerializableTypeClassDeclaration f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i2;
                AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration = this.f$0;
                switch (i22) {
                    case 0:
                        return AppFunctionSerializableTypeClassDeclaration.jvmQualifiedName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 1:
                        return AppFunctionSerializableTypeClassDeclaration.typeName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 2:
                        return AppFunctionSerializableTypeClassDeclaration.docString_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 3:
                        return AppFunctionSerializableTypeClassDeclaration.jvmClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 4:
                        return AppFunctionSerializableTypeClassDeclaration.superTypes_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 5:
                        return AppFunctionSerializableTypeClassDeclaration.declarations_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 6:
                        return AppFunctionSerializableTypeClassDeclaration.modifiers_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 7:
                        AppFunctionSerializableTypeClassDeclaration.primaryConstructor_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                        return null;
                    case 8:
                        return appFunctionSerializableTypeClassDeclaration.classDeclaration;
                    case 9:
                        return AppFunctionSerializableTypeClassDeclaration.typeParameters_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    default:
                        return AppFunctionSerializableTypeClassDeclaration.originalClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                }
            }
        });
        final int i3 = 4;
        this.superTypes = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionSerializableTypeClassDeclaration$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionSerializableTypeClassDeclaration f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i3;
                AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration = this.f$0;
                switch (i22) {
                    case 0:
                        return AppFunctionSerializableTypeClassDeclaration.jvmQualifiedName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 1:
                        return AppFunctionSerializableTypeClassDeclaration.typeName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 2:
                        return AppFunctionSerializableTypeClassDeclaration.docString_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 3:
                        return AppFunctionSerializableTypeClassDeclaration.jvmClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 4:
                        return AppFunctionSerializableTypeClassDeclaration.superTypes_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 5:
                        return AppFunctionSerializableTypeClassDeclaration.declarations_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 6:
                        return AppFunctionSerializableTypeClassDeclaration.modifiers_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 7:
                        AppFunctionSerializableTypeClassDeclaration.primaryConstructor_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                        return null;
                    case 8:
                        return appFunctionSerializableTypeClassDeclaration.classDeclaration;
                    case 9:
                        return AppFunctionSerializableTypeClassDeclaration.typeParameters_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    default:
                        return AppFunctionSerializableTypeClassDeclaration.originalClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                }
            }
        });
        final int i4 = 5;
        this.declarations = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionSerializableTypeClassDeclaration$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionSerializableTypeClassDeclaration f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i4;
                AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration = this.f$0;
                switch (i22) {
                    case 0:
                        return AppFunctionSerializableTypeClassDeclaration.jvmQualifiedName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 1:
                        return AppFunctionSerializableTypeClassDeclaration.typeName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 2:
                        return AppFunctionSerializableTypeClassDeclaration.docString_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 3:
                        return AppFunctionSerializableTypeClassDeclaration.jvmClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 4:
                        return AppFunctionSerializableTypeClassDeclaration.superTypes_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 5:
                        return AppFunctionSerializableTypeClassDeclaration.declarations_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 6:
                        return AppFunctionSerializableTypeClassDeclaration.modifiers_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 7:
                        AppFunctionSerializableTypeClassDeclaration.primaryConstructor_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                        return null;
                    case 8:
                        return appFunctionSerializableTypeClassDeclaration.classDeclaration;
                    case 9:
                        return AppFunctionSerializableTypeClassDeclaration.typeParameters_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    default:
                        return AppFunctionSerializableTypeClassDeclaration.originalClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                }
            }
        });
        final int i5 = 6;
        this.modifiers = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionSerializableTypeClassDeclaration$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionSerializableTypeClassDeclaration f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i5;
                AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration = this.f$0;
                switch (i22) {
                    case 0:
                        return AppFunctionSerializableTypeClassDeclaration.jvmQualifiedName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 1:
                        return AppFunctionSerializableTypeClassDeclaration.typeName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 2:
                        return AppFunctionSerializableTypeClassDeclaration.docString_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 3:
                        return AppFunctionSerializableTypeClassDeclaration.jvmClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 4:
                        return AppFunctionSerializableTypeClassDeclaration.superTypes_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 5:
                        return AppFunctionSerializableTypeClassDeclaration.declarations_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 6:
                        return AppFunctionSerializableTypeClassDeclaration.modifiers_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 7:
                        AppFunctionSerializableTypeClassDeclaration.primaryConstructor_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                        return null;
                    case 8:
                        return appFunctionSerializableTypeClassDeclaration.classDeclaration;
                    case 9:
                        return AppFunctionSerializableTypeClassDeclaration.typeParameters_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    default:
                        return AppFunctionSerializableTypeClassDeclaration.originalClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                }
            }
        });
        final int i6 = 7;
        this.primaryConstructor = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionSerializableTypeClassDeclaration$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionSerializableTypeClassDeclaration f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i6;
                AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration = this.f$0;
                switch (i22) {
                    case 0:
                        return AppFunctionSerializableTypeClassDeclaration.jvmQualifiedName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 1:
                        return AppFunctionSerializableTypeClassDeclaration.typeName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 2:
                        return AppFunctionSerializableTypeClassDeclaration.docString_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 3:
                        return AppFunctionSerializableTypeClassDeclaration.jvmClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 4:
                        return AppFunctionSerializableTypeClassDeclaration.superTypes_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 5:
                        return AppFunctionSerializableTypeClassDeclaration.declarations_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 6:
                        return AppFunctionSerializableTypeClassDeclaration.modifiers_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 7:
                        AppFunctionSerializableTypeClassDeclaration.primaryConstructor_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                        return null;
                    case 8:
                        return appFunctionSerializableTypeClassDeclaration.classDeclaration;
                    case 9:
                        return AppFunctionSerializableTypeClassDeclaration.typeParameters_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    default:
                        return AppFunctionSerializableTypeClassDeclaration.originalClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                }
            }
        });
        final int i7 = 8;
        this.attributeNode = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionSerializableTypeClassDeclaration$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionSerializableTypeClassDeclaration f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i7;
                AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration = this.f$0;
                switch (i22) {
                    case 0:
                        return AppFunctionSerializableTypeClassDeclaration.jvmQualifiedName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 1:
                        return AppFunctionSerializableTypeClassDeclaration.typeName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 2:
                        return AppFunctionSerializableTypeClassDeclaration.docString_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 3:
                        return AppFunctionSerializableTypeClassDeclaration.jvmClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 4:
                        return AppFunctionSerializableTypeClassDeclaration.superTypes_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 5:
                        return AppFunctionSerializableTypeClassDeclaration.declarations_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 6:
                        return AppFunctionSerializableTypeClassDeclaration.modifiers_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 7:
                        AppFunctionSerializableTypeClassDeclaration.primaryConstructor_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                        return null;
                    case 8:
                        return appFunctionSerializableTypeClassDeclaration.classDeclaration;
                    case 9:
                        return AppFunctionSerializableTypeClassDeclaration.typeParameters_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    default:
                        return AppFunctionSerializableTypeClassDeclaration.originalClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                }
            }
        });
        final int i8 = 9;
        this.typeParameters = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionSerializableTypeClassDeclaration$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionSerializableTypeClassDeclaration f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i8;
                AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration = this.f$0;
                switch (i22) {
                    case 0:
                        return AppFunctionSerializableTypeClassDeclaration.jvmQualifiedName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 1:
                        return AppFunctionSerializableTypeClassDeclaration.typeName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 2:
                        return AppFunctionSerializableTypeClassDeclaration.docString_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 3:
                        return AppFunctionSerializableTypeClassDeclaration.jvmClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 4:
                        return AppFunctionSerializableTypeClassDeclaration.superTypes_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 5:
                        return AppFunctionSerializableTypeClassDeclaration.declarations_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 6:
                        return AppFunctionSerializableTypeClassDeclaration.modifiers_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 7:
                        AppFunctionSerializableTypeClassDeclaration.primaryConstructor_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                        return null;
                    case 8:
                        return appFunctionSerializableTypeClassDeclaration.classDeclaration;
                    case 9:
                        return AppFunctionSerializableTypeClassDeclaration.typeParameters_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    default:
                        return AppFunctionSerializableTypeClassDeclaration.originalClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                }
            }
        });
        final int i9 = 10;
        this.originalClassName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionSerializableTypeClassDeclaration$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionSerializableTypeClassDeclaration f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i9;
                AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration = this.f$0;
                switch (i22) {
                    case 0:
                        return AppFunctionSerializableTypeClassDeclaration.jvmQualifiedName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 1:
                        return AppFunctionSerializableTypeClassDeclaration.typeName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 2:
                        return AppFunctionSerializableTypeClassDeclaration.docString_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 3:
                        return AppFunctionSerializableTypeClassDeclaration.jvmClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 4:
                        return AppFunctionSerializableTypeClassDeclaration.superTypes_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 5:
                        return AppFunctionSerializableTypeClassDeclaration.declarations_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 6:
                        return AppFunctionSerializableTypeClassDeclaration.modifiers_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 7:
                        AppFunctionSerializableTypeClassDeclaration.primaryConstructor_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                        return null;
                    case 8:
                        return appFunctionSerializableTypeClassDeclaration.classDeclaration;
                    case 9:
                        return AppFunctionSerializableTypeClassDeclaration.typeParameters_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    default:
                        return AppFunctionSerializableTypeClassDeclaration.originalClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                }
            }
        });
        final int i10 = 1;
        this.typeName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionSerializableTypeClassDeclaration$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionSerializableTypeClassDeclaration f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i10;
                AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration = this.f$0;
                switch (i22) {
                    case 0:
                        return AppFunctionSerializableTypeClassDeclaration.jvmQualifiedName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 1:
                        return AppFunctionSerializableTypeClassDeclaration.typeName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 2:
                        return AppFunctionSerializableTypeClassDeclaration.docString_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 3:
                        return AppFunctionSerializableTypeClassDeclaration.jvmClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 4:
                        return AppFunctionSerializableTypeClassDeclaration.superTypes_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 5:
                        return AppFunctionSerializableTypeClassDeclaration.declarations_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 6:
                        return AppFunctionSerializableTypeClassDeclaration.modifiers_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 7:
                        AppFunctionSerializableTypeClassDeclaration.primaryConstructor_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                        return null;
                    case 8:
                        return appFunctionSerializableTypeClassDeclaration.classDeclaration;
                    case 9:
                        return AppFunctionSerializableTypeClassDeclaration.typeParameters_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    default:
                        return AppFunctionSerializableTypeClassDeclaration.originalClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                }
            }
        });
        final int i11 = 2;
        this.docString = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AppFunctionSerializableTypeClassDeclaration$$ExternalSyntheticLambda0
            public final /* synthetic */ AppFunctionSerializableTypeClassDeclaration f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i11;
                AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration = this.f$0;
                switch (i22) {
                    case 0:
                        return AppFunctionSerializableTypeClassDeclaration.jvmQualifiedName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 1:
                        return AppFunctionSerializableTypeClassDeclaration.typeName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 2:
                        return AppFunctionSerializableTypeClassDeclaration.docString_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 3:
                        return AppFunctionSerializableTypeClassDeclaration.jvmClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 4:
                        return AppFunctionSerializableTypeClassDeclaration.superTypes_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 5:
                        return AppFunctionSerializableTypeClassDeclaration.declarations_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 6:
                        return AppFunctionSerializableTypeClassDeclaration.modifiers_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    case 7:
                        AppFunctionSerializableTypeClassDeclaration.primaryConstructor_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                        return null;
                    case 8:
                        return appFunctionSerializableTypeClassDeclaration.classDeclaration;
                    case 9:
                        return AppFunctionSerializableTypeClassDeclaration.typeParameters_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                    default:
                        return AppFunctionSerializableTypeClassDeclaration.originalClassName_delegate$lambda$0(appFunctionSerializableTypeClassDeclaration);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence declarations_delegate$lambda$0(AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration) {
        return appFunctionSerializableTypeClassDeclaration.classDeclaration.getDeclarations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String docString_delegate$lambda$0(AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration) {
        String docString = appFunctionSerializableTypeClassDeclaration.classDeclaration.getDocString();
        return docString == null ? "" : docString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String jvmClassName_delegate$lambda$0(AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration) {
        return KspUtilsKt.getJvmClassName(appFunctionSerializableTypeClassDeclaration.classDeclaration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String jvmQualifiedName_delegate$lambda$0(AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration) {
        return KspUtilsKt.getJvmQualifiedName(appFunctionSerializableTypeClassDeclaration.classDeclaration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set modifiers_delegate$lambda$0(AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration) {
        return appFunctionSerializableTypeClassDeclaration.classDeclaration.getModifiers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClassName originalClassName_delegate$lambda$0(AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration) {
        return KspUtilsKt.toClassName(appFunctionSerializableTypeClassDeclaration.classDeclaration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSFunctionDeclaration primaryConstructor_delegate$lambda$0(AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration) {
        appFunctionSerializableTypeClassDeclaration.classDeclaration.getPrimaryConstructor();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence superTypes_delegate$lambda$0(AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration) {
        return appFunctionSerializableTypeClassDeclaration.classDeclaration.getSuperTypes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeName typeName_delegate$lambda$0(AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration) {
        if (appFunctionSerializableTypeClassDeclaration.getTypeParameters().isEmpty()) {
            return appFunctionSerializableTypeClassDeclaration.getOriginalClassName();
        }
        ParameterizedTypeName.Companion companion = ParameterizedTypeName.INSTANCE;
        ClassName originalClassName = appFunctionSerializableTypeClassDeclaration.getOriginalClassName();
        List<KSTypeParameter> typeParameters = appFunctionSerializableTypeClassDeclaration.getTypeParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            arrayList.add(KspUtilsKt.toTypeVariableName(null));
        }
        return companion.get(originalClassName, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List typeParameters_delegate$lambda$0(AppFunctionSerializableTypeClassDeclaration appFunctionSerializableTypeClassDeclaration) {
        return appFunctionSerializableTypeClassDeclaration.classDeclaration.getTypeParameters();
    }

    public final KSNode getAttributeNode() {
        return (KSNode) this.attributeNode.getValue();
    }

    public final Sequence<KSDeclaration> getDeclarations() {
        return (Sequence) this.declarations.getValue();
    }

    public final String getDocString() {
        return (String) this.docString.getValue();
    }

    public final String getJvmClassName() {
        return (String) this.jvmClassName.getValue();
    }

    public final String getJvmQualifiedName() {
        return (String) this.jvmQualifiedName.getValue();
    }

    public final Set<Modifier> getModifiers() {
        return (Set) this.modifiers.getValue();
    }

    public final ClassName getOriginalClassName() {
        return (ClassName) this.originalClassName.getValue();
    }

    public final KSFunctionDeclaration getPrimaryConstructor() {
        if (this.primaryConstructor.getValue() == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public final Sequence<KSTypeReference> getSuperTypes() {
        return (Sequence) this.superTypes.getValue();
    }

    public final TypeName getTypeName() {
        return (TypeName) this.typeName.getValue();
    }

    public final List<KSTypeParameter> getTypeParameters() {
        return (List) this.typeParameters.getValue();
    }
}
