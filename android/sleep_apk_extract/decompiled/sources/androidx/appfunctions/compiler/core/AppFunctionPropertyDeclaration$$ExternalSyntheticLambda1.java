package androidx.appfunctions.compiler.core;

import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppFunctionPropertyDeclaration$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AppFunctionPropertyDeclaration$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return Boolean.valueOf(AppFunctionPropertyDeclaration.isGenericType_delegate$lambda$0((AppFunctionPropertyDeclaration) obj));
            case 1:
                return AnnotatedOneOfAppFunctionSerializable.SealedOneOfSerializable.oneOfSerializables_delegate$lambda$0((AnnotatedOneOfAppFunctionSerializable.SealedOneOfSerializable) obj);
            case 2:
                return AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies.proxyTargetToSerializableProxy_delegate$lambda$0((AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies) obj);
            default:
                return Boolean.valueOf(AnnotatedOneOfAppFunctionSerializable.isDescribedByKDoc_delegate$lambda$0((AnnotatedOneOfAppFunctionSerializable) obj));
        }
    }
}
