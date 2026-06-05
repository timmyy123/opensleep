package com.google.firebase.ai;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBK\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/google/firebase/ai/OnDeviceConfig;", "", "Lcom/google/firebase/ai/InferenceMode;", "mode", "", "maxOutputTokens", "", "temperature", "topK", "seed", "candidateCount", "<init>", "(Lcom/google/firebase/ai/InferenceMode;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;I)V", "Lcom/google/firebase/ai/InferenceMode;", "getMode", "()Lcom/google/firebase/ai/InferenceMode;", "Ljava/lang/Integer;", "getMaxOutputTokens", "()Ljava/lang/Integer;", "Ljava/lang/Float;", "getTemperature", "()Ljava/lang/Float;", "getTopK", "getSeed", "I", "getCandidateCount", "()I", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OnDeviceConfig {
    public static final OnDeviceConfig IN_CLOUD = new OnDeviceConfig(InferenceMode.ONLY_IN_CLOUD, null, null, null, null, 0, 62, null);
    private final int candidateCount;
    private final Integer maxOutputTokens;
    private final InferenceMode mode;
    private final Integer seed;
    private final Float temperature;
    private final Integer topK;

    public /* synthetic */ OnDeviceConfig(InferenceMode inferenceMode, Integer num, Float f, Integer num2, Integer num3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(inferenceMode, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : f, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : num3, (i2 & 32) != 0 ? 1 : i);
    }

    public final InferenceMode getMode() {
        return this.mode;
    }

    public OnDeviceConfig(InferenceMode inferenceMode, Integer num, Float f, Integer num2, Integer num3, int i) {
        inferenceMode.getClass();
        this.mode = inferenceMode;
        this.maxOutputTokens = num;
        this.temperature = f;
        this.topK = num2;
        this.seed = num3;
        this.candidateCount = i;
    }
}
