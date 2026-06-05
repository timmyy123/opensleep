package androidx.appfunctions.compiler.core;

import androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppFunctionMetadataCreatorHelper$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AppFunctionMetadataCreatorHelper$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                AppFunctionMetadataCreatorHelper appFunctionMetadataCreatorHelper = (AppFunctionMetadataCreatorHelper) obj2;
                if (obj == null) {
                    return AppFunctionMetadataCreatorHelper.addSerializableTypeMetadataToSharedDataTypeMap$lambda$0$0(appFunctionMetadataCreatorHelper, null);
                }
                Events$$ExternalSyntheticBUOutline0.m();
                return null;
            default:
                return AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable.allowedOneOfDeclarations_delegate$lambda$0$0((AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable) obj2, obj);
        }
    }
}
