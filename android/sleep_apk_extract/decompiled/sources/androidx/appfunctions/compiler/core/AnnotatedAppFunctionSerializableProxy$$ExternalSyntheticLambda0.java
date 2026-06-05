package androidx.appfunctions.compiler.core;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AnnotatedAppFunctionSerializableProxy$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AnnotatedAppFunctionSerializableProxy f$0;

    public /* synthetic */ AnnotatedAppFunctionSerializableProxy$$ExternalSyntheticLambda0(AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy, int i) {
        this.$r8$classId = i;
        this.f$0 = annotatedAppFunctionSerializableProxy;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        AnnotatedAppFunctionSerializableProxy annotatedAppFunctionSerializableProxy = this.f$0;
        switch (i) {
            case 0:
                if (obj != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                }
                break;
            default:
                if (obj != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                }
                break;
        }
        return null;
    }
}
