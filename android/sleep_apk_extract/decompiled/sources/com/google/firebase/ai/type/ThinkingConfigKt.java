package com.google.firebase.ai.type;

import com.google.firebase.ai.type.ThinkingConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lcom/google/firebase/ai/type/ThinkingConfig$Builder;", "", "init", "Lcom/google/firebase/ai/type/ThinkingConfig;", "thinkingConfig", "(Lkotlin/jvm/functions/Function1;)Lcom/google/firebase/ai/type/ThinkingConfig;", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ThinkingConfigKt {
    public static final ThinkingConfig thinkingConfig(Function1<? super ThinkingConfig.Builder, Unit> function1) {
        function1.getClass();
        ThinkingConfig.Builder builder = new ThinkingConfig.Builder();
        function1.invoke(builder);
        return builder.build();
    }
}
