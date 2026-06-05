package androidx.appfunctions.compiler.core;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.AppFunctionTypeReference;
import com.google.devtools.ksp.UtilsKt;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import com.google.devtools.ksp.symbol.KSNode;
import com.google.devtools.ksp.symbol.KSPropertyDeclaration;
import com.google.devtools.ksp.symbol.KSTypeReference;
import com.google.devtools.ksp.symbol.KSValueParameter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tJ$\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\r\u001a\u00020\tH\u0002J$\u0010\u000e\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionSerializableValidateHelper;", "", "annotatedSerializable", "Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;", "<init>", "(Landroidx/appfunctions/compiler/core/AppFunctionSerializableType;)V", "validatePrimaryConstructor", "", "checkHasGetter", "", "parameter", "Lcom/google/devtools/ksp/symbol/KSValueParameter;", "validateParameters", "allowSerializableInterfaceTypes", "validateSuperTypes", "parametersToValidate", "", "", "Landroidx/appfunctions/compiler/core/AppFunctionPropertyDeclaration;", "superTypesWithSerializableAnnotation", "", "Lcom/google/devtools/ksp/symbol/KSClassDeclaration;", "superTypesWithCapabilityAnnotation", "validateSerializableParameter", "propertyDeclaration", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionSerializableValidateHelper {
    private final AppFunctionSerializableType annotatedSerializable;

    public AppFunctionSerializableValidateHelper(AppFunctionSerializableType appFunctionSerializableType) {
        appFunctionSerializableType.getClass();
        this.annotatedSerializable = appFunctionSerializableType;
    }

    private final boolean checkHasGetter(KSValueParameter parameter) {
        parameter.getName();
        return false;
    }

    private final void validateSerializableParameter(AppFunctionPropertyDeclaration propertyDeclaration, boolean allowSerializableInterfaceTypes) throws ProcessingException {
        if (propertyDeclaration.isGenericType()) {
            return;
        }
        AppFunctionTypeReference.Companion companion = AppFunctionTypeReference.INSTANCE;
        propertyDeclaration.getType();
        if (!companion.isSupportedType(null, allowSerializableInterfaceTypes)) {
            String supported_types_string = companion.getSUPPORTED_TYPES_STRING();
            propertyDeclaration.getType();
            String str = "AppFunctionSerializable properties must be one of the following types:\n" + supported_types_string + ", an @AppFunctionSerializable or a list of @AppFunctionSerializable\nbut found " + KspUtilsKt.toTypeName((KSTypeReference) null);
            propertyDeclaration.getType();
            throw new ProcessingException(str, null, null, 4, null);
        }
        if (propertyDeclaration.isRequired()) {
            return;
        }
        propertyDeclaration.getType();
        if (companion.isAllowToBeOptional(null)) {
            return;
        }
        propertyDeclaration.getType();
        String str2 = "Type " + KspUtilsKt.toTypeName((KSTypeReference) null) + " cannot be optional";
        propertyDeclaration.getType();
        throw new ProcessingException(str2, null, null, 4, null);
    }

    private final void validateSuperTypes(Map<String, AppFunctionPropertyDeclaration> parametersToValidate, boolean allowSerializableInterfaceTypes) throws ProcessingException {
        Set<KSClassDeclaration> setFindSuperTypesWithSerializableAnnotation = this.annotatedSerializable.findSuperTypesWithSerializableAnnotation();
        Set<KSClassDeclaration> setFindSuperTypesWithCapabilityAnnotation = this.annotatedSerializable.findSuperTypesWithCapabilityAnnotation();
        validateSuperTypes(setFindSuperTypesWithSerializableAnnotation, setFindSuperTypesWithCapabilityAnnotation);
        Iterator<KSClassDeclaration> it = setFindSuperTypesWithSerializableAnnotation.iterator();
        while (it.hasNext()) {
            for (AppFunctionPropertyDeclaration appFunctionPropertyDeclaration : AppFunctionSerializableType.getProperties$default(new AnnotatedAppFunctionSerializable(it.next()).validate(allowSerializableInterfaceTypes), null, 1, null)) {
                AppFunctionPropertyDeclaration appFunctionPropertyDeclarationRemove = parametersToValidate.remove(appFunctionPropertyDeclaration.getName());
                if (appFunctionPropertyDeclarationRemove == null) {
                    appFunctionPropertyDeclaration.getType();
                    throw new ProcessingException("All parameters in @AppFunctionSerializable supertypes must be present in subtype", null, null, 4, null);
                }
                validateSerializableParameter(appFunctionPropertyDeclarationRemove, allowSerializableInterfaceTypes);
            }
        }
        Iterator<KSClassDeclaration> it2 = setFindSuperTypesWithCapabilityAnnotation.iterator();
        while (it2.hasNext()) {
            Iterator<KSPropertyDeclaration> it3 = UtilsKt.getDeclaredProperties(it2.next()).iterator();
            if (it3.hasNext()) {
                throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it3);
            }
        }
    }

    public final void validateParameters(boolean allowSerializableInterfaceTypes) {
        List properties$default = AppFunctionSerializableType.getProperties$default(this.annotatedSerializable, null, 1, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) properties$default, 10, 16));
        for (Object obj : properties$default) {
            String name = ((AppFunctionPropertyDeclaration) obj).getName();
            if (name == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                return;
            }
            linkedHashMap.put(name, obj);
        }
        Map<String, AppFunctionPropertyDeclaration> mutableMap = MapsKt.toMutableMap(linkedHashMap);
        if (!(this.annotatedSerializable instanceof AnnotatedAppFunctionSerializableInterface)) {
            validateSuperTypes(mutableMap, allowSerializableInterfaceTypes);
        }
        if (mutableMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, AppFunctionPropertyDeclaration>> it = mutableMap.entrySet().iterator();
        while (it.hasNext()) {
            validateSerializableParameter(it.next().getValue(), allowSerializableInterfaceTypes);
        }
    }

    public final void validatePrimaryConstructor() {
        this.annotatedSerializable.getAppFunctionSerializableTypeClassDeclaration().getPrimaryConstructor();
        throw new ProcessingException("A valid AppFunctionSerializable must have a primary constructor.", this.annotatedSerializable.getAppFunctionSerializableTypeClassDeclaration().getAttributeNode(), null, 4, null);
    }

    private final void validateSuperTypes(Set<? extends KSClassDeclaration> superTypesWithSerializableAnnotation, Set<? extends KSClassDeclaration> superTypesWithCapabilityAnnotation) throws ProcessingException {
        Set setIntersect = CollectionsKt___CollectionsKt.intersect(superTypesWithSerializableAnnotation, superTypesWithCapabilityAnnotation);
        if (!setIntersect.isEmpty()) {
            throw new ProcessingException("A class cannot be annotated with both @AppFunctionSerializable and @AppFunctionSchemaCapability.", (KSNode) CollectionsKt.first(setIntersect), null, 4, null);
        }
    }
}
