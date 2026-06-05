package com.google.firebase.components;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Component$$ExternalSyntheticLambda0 implements ComponentFactory {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Component$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return Component.lambda$intoSet$3(obj, componentContainer);
            default:
                return Component.lambda$of$1(obj, componentContainer);
        }
    }
}
