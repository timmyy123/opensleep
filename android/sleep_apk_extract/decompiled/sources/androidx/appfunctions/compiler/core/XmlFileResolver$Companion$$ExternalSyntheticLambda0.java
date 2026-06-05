package androidx.appfunctions.compiler.core;

import androidx.appfunctions.compiler.core.AnnotatedOneOfAppFunctionSerializable;
import androidx.appfunctions.compiler.core.XmlFileResolver;
import com.google.devtools.ksp.symbol.KSClassDeclaration;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class XmlFileResolver$Companion$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ XmlFileResolver$Companion$$ExternalSyntheticLambda0() {
        this.$r8$classId = 0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws ProcessingException {
        switch (this.$r8$classId) {
            case 0:
                return XmlFileResolver.Companion.RESOLVER_delegate$lambda$0();
            case 1:
                AnnotatedOneOfAppFunctionSerializable.NonSealedOneOfSerializable.oneOfTypeAnnotation_delegate$lambda$0(null);
                return null;
            default:
                return null.getSealedSubclasses();
        }
    }

    public /* synthetic */ XmlFileResolver$Companion$$ExternalSyntheticLambda0(KSClassDeclaration kSClassDeclaration, int i) {
        this.$r8$classId = i;
    }
}
