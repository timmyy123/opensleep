package com.google.firebase.ai;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class FirebaseAIRegistrar$$ExternalSyntheticLambda0 implements ComponentFactory {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FirebaseAIRegistrar$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.$r8$classId) {
            case 0:
                return FirebaseAIRegistrar.getComponents$lambda$0(componentContainer);
            case 1:
                return ExecutorsRegistrar.lambda$getComponents$4(componentContainer);
            case 2:
                return ExecutorsRegistrar.lambda$getComponents$5(componentContainer);
            case 3:
                return ExecutorsRegistrar.lambda$getComponents$6(componentContainer);
            case 4:
                return ExecutorsRegistrar.lambda$getComponents$7(componentContainer);
            case 5:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
            default:
                return DefaultUserAgentPublisher.lambda$component$0(componentContainer);
        }
    }
}
