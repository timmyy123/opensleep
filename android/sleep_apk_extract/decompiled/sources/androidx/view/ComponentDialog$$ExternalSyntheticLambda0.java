package androidx.view;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentDialog$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ComponentDialog$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return ComponentDialog.onBackPressedInput_delegate$lambda$0((ComponentDialog) obj);
            case 1:
                return ComponentDialog.onBackPressedDispatcher_delegate$lambda$0((ComponentDialog) obj);
            default:
                return OnBackPressedDispatcher.eventInput_delegate$lambda$0((OnBackPressedDispatcher) obj);
        }
    }
}
