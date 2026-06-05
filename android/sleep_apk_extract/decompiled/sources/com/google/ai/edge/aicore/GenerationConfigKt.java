package com.google.ai.edge.aicore;

import com.google.ai.edge.aicore.GenerationConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lcom/google/ai/edge/aicore/GenerationConfig$Builder;", "", "init", "Lcom/google/ai/edge/aicore/GenerationConfig;", "generationConfig", "(Lkotlin/jvm/functions/Function1;)Lcom/google/ai/edge/aicore/GenerationConfig;", "java.com.google.android.apps.aicore.client_client"}, k = 2, mv = {2, 1, 0}, xi = 48)
public abstract class GenerationConfigKt {
    public static final GenerationConfig generationConfig(Function1<? super GenerationConfig.Builder, Unit> function1) {
        function1.getClass();
        GenerationConfig.Builder builder = GenerationConfig.INSTANCE.builder();
        function1.invoke(builder);
        return builder.build();
    }
}
