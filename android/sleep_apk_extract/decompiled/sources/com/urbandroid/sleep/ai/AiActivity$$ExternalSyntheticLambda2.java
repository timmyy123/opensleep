package com.urbandroid.sleep.ai;

import com.google.ai.edge.aicore.GenerationConfig;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AiActivity$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AiActivity f$0;

    public /* synthetic */ AiActivity$$ExternalSyntheticLambda2(AiActivity aiActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = aiActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        AiActivity aiActivity = this.f$0;
        switch (i) {
            case 0:
                return AiActivity.onCreate$lambda$1(aiActivity, (GenerationConfig.Builder) obj);
            case 1:
                return AiActivity.addPromptsToView$lambda$0$0(aiActivity, (String) obj);
            default:
                return AiActivity.onCreate$lambda$5$0$0(aiActivity, (String) obj);
        }
    }
}
