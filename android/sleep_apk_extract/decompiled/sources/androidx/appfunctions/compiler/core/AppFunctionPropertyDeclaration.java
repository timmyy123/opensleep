package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.devtools.ksp.symbol.KSAnnotation;
import com.google.devtools.ksp.symbol.KSPropertyDeclaration;
import com.google.devtools.ksp.symbol.KSTypeReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eB5\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0004\b\r\u0010\u0014J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003JK\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0014\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020+HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001aR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u001b\u0010\u001e\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001e\u0010\u001a¨\u0006-"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionPropertyDeclaration;", "", "name", "", "type", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "description", "isRequired", "", "propertyAnnotations", "Lkotlin/sequences/Sequence;", "Lcom/google/devtools/ksp/symbol/KSAnnotation;", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "<init>", "(Ljava/lang/String;Lcom/google/devtools/ksp/symbol/KSTypeReference;Ljava/lang/String;ZLkotlin/sequences/Sequence;Ljava/lang/String;)V", "property", "Lcom/google/devtools/ksp/symbol/KSPropertyDeclaration;", "isDescribedByKDoc", "sharedDataTypeDescriptionMap", "", "(Lcom/google/devtools/ksp/symbol/KSPropertyDeclaration;ZZLjava/util/Map;)V", "getName", "()Ljava/lang/String;", "getType", "()Lcom/google/devtools/ksp/symbol/KSTypeReference;", "getDescription", "()Z", "getPropertyAnnotations", "()Lkotlin/sequences/Sequence;", "getQualifiedName", "isGenericType", "isGenericType$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppFunctionPropertyDeclaration {
    private final String description;

    /* JADX INFO: renamed from: isGenericType$delegate, reason: from kotlin metadata */
    private final Lazy isGenericType;
    private final boolean isRequired;
    private final String name;
    private final Sequence<KSAnnotation> propertyAnnotations;
    private final String qualifiedName;
    private final KSTypeReference type;

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionPropertyDeclaration(String str, KSTypeReference kSTypeReference, String str2, boolean z, Sequence<? extends KSAnnotation> sequence, String str3) {
        str.getClass();
        kSTypeReference.getClass();
        str2.getClass();
        sequence.getClass();
        str3.getClass();
        this.name = str;
        this.description = str2;
        this.isRequired = z;
        this.propertyAnnotations = sequence;
        this.qualifiedName = str3;
        this.isGenericType = LazyKt.lazy(new AppFunctionPropertyDeclaration$$ExternalSyntheticLambda1(this, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppFunctionPropertyDeclaration copy$default(AppFunctionPropertyDeclaration appFunctionPropertyDeclaration, String str, KSTypeReference kSTypeReference, String str2, boolean z, Sequence sequence, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionPropertyDeclaration.name;
        }
        if ((i & 2) != 0) {
            appFunctionPropertyDeclaration.getClass();
            kSTypeReference = null;
        }
        if ((i & 4) != 0) {
            str2 = appFunctionPropertyDeclaration.description;
        }
        if ((i & 8) != 0) {
            z = appFunctionPropertyDeclaration.isRequired;
        }
        if ((i & 16) != 0) {
            sequence = appFunctionPropertyDeclaration.propertyAnnotations;
        }
        if ((i & 32) != 0) {
            str3 = appFunctionPropertyDeclaration.qualifiedName;
        }
        Sequence sequence2 = sequence;
        String str4 = str3;
        return appFunctionPropertyDeclaration.copy(str, kSTypeReference, str2, z, sequence2, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isGenericType_delegate$lambda$0(AppFunctionPropertyDeclaration appFunctionPropertyDeclaration) {
        appFunctionPropertyDeclaration.getClass();
        throw null;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final KSTypeReference component2() {
        return null;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsRequired() {
        return this.isRequired;
    }

    public final Sequence<KSAnnotation> component5() {
        return this.propertyAnnotations;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    public final AppFunctionPropertyDeclaration copy(String name, KSTypeReference type, String description, boolean isRequired, Sequence<? extends KSAnnotation> propertyAnnotations, String qualifiedName) {
        name.getClass();
        type.getClass();
        description.getClass();
        propertyAnnotations.getClass();
        qualifiedName.getClass();
        return new AppFunctionPropertyDeclaration(name, type, description, isRequired, propertyAnnotations, qualifiedName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionPropertyDeclaration)) {
            return false;
        }
        AppFunctionPropertyDeclaration appFunctionPropertyDeclaration = (AppFunctionPropertyDeclaration) other;
        return Intrinsics.areEqual(this.name, appFunctionPropertyDeclaration.name) && Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.description, appFunctionPropertyDeclaration.description) && this.isRequired == appFunctionPropertyDeclaration.isRequired && Intrinsics.areEqual(this.propertyAnnotations, appFunctionPropertyDeclaration.propertyAnnotations) && Intrinsics.areEqual(this.qualifiedName, appFunctionPropertyDeclaration.qualifiedName);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final Sequence<KSAnnotation> getPropertyAnnotations() {
        return this.propertyAnnotations;
    }

    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    public final KSTypeReference getType() {
        return null;
    }

    public int hashCode() {
        this.name.hashCode();
        throw null;
    }

    public final boolean isGenericType() {
        return ((Boolean) this.isGenericType.getValue()).booleanValue();
    }

    public final boolean isRequired() {
        return this.isRequired;
    }

    public String toString() {
        String str = this.name;
        String str2 = this.description;
        boolean z = this.isRequired;
        Sequence<KSAnnotation> sequence = this.propertyAnnotations;
        String str3 = this.qualifiedName;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("AppFunctionPropertyDeclaration(name=", str, ", type=null, description=", str2, ", isRequired=");
        sbM6m.append(z);
        sbM6m.append(", propertyAnnotations=");
        sbM6m.append(sequence);
        sbM6m.append(", qualifiedName=");
        return FileInsert$$ExternalSyntheticOutline0.m(sbM6m, str3, ")");
    }

    public /* synthetic */ AppFunctionPropertyDeclaration(String str, KSTypeReference kSTypeReference, String str2, boolean z, Sequence sequence, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, kSTypeReference, str2, z, (i & 16) != 0 ? SequencesKt.emptySequence() : sequence, str3);
    }

    public AppFunctionPropertyDeclaration(KSPropertyDeclaration kSPropertyDeclaration, boolean z, boolean z2, Map<String, String> map) {
        kSPropertyDeclaration.getClass();
        map.getClass();
        kSPropertyDeclaration.getSimpleName();
        throw new IllegalStateException("Required value was null.");
    }
}
