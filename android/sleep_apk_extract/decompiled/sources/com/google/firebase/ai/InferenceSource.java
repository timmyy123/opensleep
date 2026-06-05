package com.google.firebase.ai;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/InferenceSource;", "", SDKConstants.PARAM_VALUE, "", "<init>", "(Ljava/lang/String;)V", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InferenceSource {
    private final String value;
    public static final InferenceSource ON_DEVICE = new InferenceSource("source on device");
    public static final InferenceSource IN_CLOUD = new InferenceSource("source in cloud");

    private InferenceSource(String str) {
        this.value = str;
    }
}
