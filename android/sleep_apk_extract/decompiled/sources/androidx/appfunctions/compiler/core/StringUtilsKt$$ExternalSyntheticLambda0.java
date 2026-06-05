package androidx.appfunctions.compiler.core;

import androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StringUtilsKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ StringUtilsKt$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws ProcessingException {
        switch (this.$r8$classId) {
            case 0:
                return StringUtilsKt.fromCamelCaseToScreamingSnakeCase$lambda$0((MatchResult) obj);
            case 1:
                return AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable.oneOfSerializables_delegate$lambda$0$0((KSClassDeclaration) obj);
            case 2:
                return AnnotatedOneOfAppFunctionSerializable.SealedOneOfSerializable.oneOfSerializables_delegate$lambda$0$0((KSClassDeclaration) obj);
            case 3:
                return Boolean.valueOf(AnnotatedAppFunctionSerializableProxy.serializableReferenceType_delegate$lambda$0$0((KSClassDeclaration) obj));
            case 4:
                if (obj == null) {
                    return AnnotatedParameterizedAppFunctionSerializable.factoryVariableName_delegate$lambda$0$1(null);
                }
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            case 5:
                return AppFunctionInventoryCodeBuilder.toPrimitiveMetadataPropertySpec$lambda$1$0((String) obj);
            case 6:
                return AppFunctionInventoryCodeBuilder.getFunctionMetadataObjectClassName$lambda$0((String) obj);
            case 7:
                if (obj == null) {
                    return AppFunctionSerializableType.findSuperTypesWithSerializableAnnotation$lambda$0(null);
                }
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            case 8:
                return Boolean.valueOf(AppFunctionSerializableType.findSuperTypesWithSerializableAnnotation$lambda$1((KSClassDeclaration) obj));
            case 9:
                if (obj == null) {
                    return Boolean.valueOf(AppFunctionSymbolResolver.resolveAnnotatedAppFunctionEntryPoints$lambda$2$0(null));
                }
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            case 10:
                return AppFunctionSymbolResolver.resolveAnnotatedAppFunctionSerializables$lambda$2((KSClassDeclaration) obj);
            case 11:
                return AppFunctionSymbolResolver.resolveAnnotatedAppFunctionSchemaDefinitions$lambda$0((KSAnnotated) obj);
            case 12:
                return AppFunctionSymbolResolver.resolveAnnotatedAppFunctionSchemaDefinitions$lambda$2((KSClassDeclaration) obj);
            case 13:
                AppFunctionSymbolResolver.resolveUnvalidatedAnnotatedAppFunctions$lambda$0((KSAnnotated) obj);
                return null;
            case 14:
                if (obj == null) {
                    return Boolean.valueOf(AppFunctionSymbolResolver.resolveUnvalidatedAnnotatedAppFunctions$lambda$1(null));
                }
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            case 15:
                return AppFunctionSymbolResolver.resolveAnnotatedAppFunctionEntryPoints$lambda$0((KSAnnotated) obj);
            case 16:
                return AppFunctionSymbolResolver.resolveAnnotatedAppFunctionEntryPoints$lambda$2((KSClassDeclaration) obj);
            case 17:
                return AppFunctionSymbolResolver.resolveLocalAnnotatedAppFunctionSerializableProxy$lambda$0((KSAnnotated) obj);
            case 18:
                return AppFunctionSymbolResolver.resolveLocalAnnotatedAppFunctionSerializableProxy$lambda$2((KSClassDeclaration) obj);
            case 19:
                return AppFunctionSymbolResolver.resolveAnnotatedAppFunctionSerializables$lambda$0((KSAnnotated) obj);
            default:
                return StringUtilsKt.toPascalCase$lambda$1((String) obj);
        }
    }
}
