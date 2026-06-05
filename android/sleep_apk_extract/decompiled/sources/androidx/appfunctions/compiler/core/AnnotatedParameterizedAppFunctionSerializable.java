package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSTypeArgument;
import com.google.devtools.ksp.symbol.KSTypeReference;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u001a\u001a\u00020\u000b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00052\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0018\u0010\u0011¨\u0006\u001e"}, d2 = {"Landroidx/appfunctions/compiler/core/AnnotatedParameterizedAppFunctionSerializable;", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializable;", "appFunctionSerializableClass", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "arguments", "", "Lcom/google/devtools/ksp/symbol/KSTypeArgument;", "<init>", "(Lcom/google/devtools/ksp/symbol/KSClassDeclaration;Ljava/util/List;)V", "typeParameterMap", "", "", "Lcom/google/devtools/ksp/symbol/KSTypeReference;", "getTypeParameterMap", "()Ljava/util/Map;", "jvmQualifiedName", "getJvmQualifiedName", "()Ljava/lang/String;", "jvmQualifiedName$delegate", "Lkotlin/Lazy;", "unparameterizedJvmQualifiedName", "getUnparameterizedJvmQualifiedName", "unparameterizedJvmQualifiedName$delegate", "factoryVariableName", "getFactoryVariableName", "factoryVariableName$delegate", "getDescription", "sharedDataTypeDescriptionMap", "getProperties", "Landroidx/appfunctions/compiler/core/AppFunctionPropertyDeclaration;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnotatedParameterizedAppFunctionSerializable extends AnnotatedAppFunctionSerializable {
    private final KSClassDeclaration appFunctionSerializableClass;
    private final List<KSTypeArgument> arguments;

    /* JADX INFO: renamed from: factoryVariableName$delegate, reason: from kotlin metadata */
    private final Lazy factoryVariableName;

    /* JADX INFO: renamed from: jvmQualifiedName$delegate, reason: from kotlin metadata */
    private final Lazy jvmQualifiedName;
    private final Map<String, KSTypeReference> typeParameterMap;

    /* JADX INFO: renamed from: unparameterizedJvmQualifiedName$delegate, reason: from kotlin metadata */
    private final Lazy unparameterizedJvmQualifiedName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnnotatedParameterizedAppFunctionSerializable(KSClassDeclaration kSClassDeclaration, List<? extends KSTypeArgument> list) {
        super(kSClassDeclaration);
        kSClassDeclaration.getClass();
        list.getClass();
        this.appFunctionSerializableClass = kSClassDeclaration;
        this.arguments = list;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator<T> it = kSClassDeclaration.getTypeParameters().iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
        this.typeParameterMap = MapsKt.build(mapCreateMapBuilder);
        final int i = 0;
        this.jvmQualifiedName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedParameterizedAppFunctionSerializable$$ExternalSyntheticLambda1
            public final /* synthetic */ AnnotatedParameterizedAppFunctionSerializable f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                AnnotatedParameterizedAppFunctionSerializable annotatedParameterizedAppFunctionSerializable = this.f$0;
                switch (i2) {
                    case 0:
                        return AnnotatedParameterizedAppFunctionSerializable.jvmQualifiedName_delegate$lambda$0(annotatedParameterizedAppFunctionSerializable);
                    case 1:
                        return super/*androidx.appfunctions.compiler.core.AppFunctionSerializableType*/.getJvmQualifiedName();
                    default:
                        return AnnotatedParameterizedAppFunctionSerializable.factoryVariableName_delegate$lambda$0(annotatedParameterizedAppFunctionSerializable);
                }
            }
        });
        final int i2 = 1;
        this.unparameterizedJvmQualifiedName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedParameterizedAppFunctionSerializable$$ExternalSyntheticLambda1
            public final /* synthetic */ AnnotatedParameterizedAppFunctionSerializable f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i2;
                AnnotatedParameterizedAppFunctionSerializable annotatedParameterizedAppFunctionSerializable = this.f$0;
                switch (i22) {
                    case 0:
                        return AnnotatedParameterizedAppFunctionSerializable.jvmQualifiedName_delegate$lambda$0(annotatedParameterizedAppFunctionSerializable);
                    case 1:
                        return super/*androidx.appfunctions.compiler.core.AppFunctionSerializableType*/.getJvmQualifiedName();
                    default:
                        return AnnotatedParameterizedAppFunctionSerializable.factoryVariableName_delegate$lambda$0(annotatedParameterizedAppFunctionSerializable);
                }
            }
        });
        final int i3 = 2;
        this.factoryVariableName = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.compiler.core.AnnotatedParameterizedAppFunctionSerializable$$ExternalSyntheticLambda1
            public final /* synthetic */ AnnotatedParameterizedAppFunctionSerializable f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i3;
                AnnotatedParameterizedAppFunctionSerializable annotatedParameterizedAppFunctionSerializable = this.f$0;
                switch (i22) {
                    case 0:
                        return AnnotatedParameterizedAppFunctionSerializable.jvmQualifiedName_delegate$lambda$0(annotatedParameterizedAppFunctionSerializable);
                    case 1:
                        return super/*androidx.appfunctions.compiler.core.AppFunctionSerializableType*/.getJvmQualifiedName();
                    default:
                        return AnnotatedParameterizedAppFunctionSerializable.factoryVariableName_delegate$lambda$0(annotatedParameterizedAppFunctionSerializable);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String factoryVariableName_delegate$lambda$0(AnnotatedParameterizedAppFunctionSerializable annotatedParameterizedAppFunctionSerializable) {
        String strReplace$default = StringsKt.replace$default(annotatedParameterizedAppFunctionSerializable.getAppFunctionSerializableTypeClassDeclaration().getJvmClassName(), "$", "");
        if (strReplace$default.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String strValueOf = String.valueOf(strReplace$default.charAt(0));
            strValueOf.getClass();
            String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            sb.append((Object) lowerCase);
            sb.append(strReplace$default.substring(1));
            strReplace$default = sb.toString();
        }
        return FileInsert$$ExternalSyntheticOutline0.m$1(strReplace$default, CollectionsKt.joinToString$default(annotatedParameterizedAppFunctionSerializable.typeParameterMap.values(), null, null, null, new StringUtilsKt$$ExternalSyntheticLambda0(4), 31), "Factory");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence factoryVariableName_delegate$lambda$0$1(KSTypeReference kSTypeReference) {
        kSTypeReference.getClass();
        return StringUtilsKt.toPascalCase(StringsKt.replace$default(new Regex("[_<>]").replace(KspUtilsKt.toTypeName(kSTypeReference).toString(), "_"), "?", "_Nullable"));
    }

    private final String getUnparameterizedJvmQualifiedName() {
        return (String) this.unparameterizedJvmQualifiedName.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String jvmQualifiedName_delegate$lambda$0(AnnotatedParameterizedAppFunctionSerializable annotatedParameterizedAppFunctionSerializable) {
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(annotatedParameterizedAppFunctionSerializable.getUnparameterizedJvmQualifiedName());
        Iterator<T> it = annotatedParameterizedAppFunctionSerializable.typeParameterMap.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            Map.Entry entry = (Map.Entry) it.next();
            if (i == 0) {
                sbM.append("<");
            }
            if (entry.getValue() != null) {
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            sbM.append(KspUtilsKt.toTypeName((KSTypeReference) null));
            if (i != annotatedParameterizedAppFunctionSerializable.typeParameterMap.size() - 1) {
                sbM.append(",");
            } else {
                sbM.append(">");
            }
            i = i2;
        }
        return sbM.toString();
    }

    @Override // androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializable, androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public String getDescription(Map<String, String> sharedDataTypeDescriptionMap) {
        sharedDataTypeDescriptionMap.getClass();
        String docString = getDocString();
        if (docString.length() != 0) {
            return docString;
        }
        String str = sharedDataTypeDescriptionMap.get(getUnparameterizedJvmQualifiedName());
        return str == null ? "" : str;
    }

    @Override // androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializable, androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public String getFactoryVariableName() {
        return (String) this.factoryVariableName.getValue();
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public String getJvmQualifiedName() {
        return (String) this.jvmQualifiedName.getValue();
    }

    @Override // androidx.appfunctions.compiler.core.AppFunctionSerializableType
    public List<AppFunctionPropertyDeclaration> getProperties(Map<String, String> sharedDataTypeDescriptionMap) {
        sharedDataTypeDescriptionMap.getClass();
        List<AppFunctionPropertyDeclaration> properties = super.getProperties(sharedDataTypeDescriptionMap);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(properties, 10));
        Iterator<T> it = properties.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        ((AppFunctionPropertyDeclaration) it.next()).getType();
        throw null;
    }

    public final Map<String, KSTypeReference> getTypeParameterMap() {
        return this.typeParameterMap;
    }
}
