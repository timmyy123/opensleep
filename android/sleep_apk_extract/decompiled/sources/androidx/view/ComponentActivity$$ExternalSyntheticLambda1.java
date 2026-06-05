package androidx.view;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda1(ComponentActivity componentActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = componentActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        ComponentActivity componentActivity = this.f$0;
        switch (i) {
            case 0:
                return ComponentActivity.fullyDrawnReporter_delegate$lambda$0(componentActivity);
            case 1:
                return ComponentActivity.fullyDrawnReporter_delegate$lambda$0$0(componentActivity);
            case 2:
                return ComponentActivity.onBackPressedInput_delegate$lambda$0(componentActivity);
            case 3:
                return ComponentActivity.defaultViewModelProviderFactory_delegate$lambda$0(componentActivity);
            default:
                return ComponentActivity.onBackPressedDispatcher_delegate$lambda$0(componentActivity);
        }
    }
}
