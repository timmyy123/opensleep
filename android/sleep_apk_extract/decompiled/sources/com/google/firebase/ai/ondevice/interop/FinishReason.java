package com.google.firebase.ai.ondevice.interop;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/ondevice/interop/FinishReason;", "", "", "name", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Companion", "com.google.firebase-firebase-ai-ondevice-interop"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FinishReason {
    private final String name;
    public static final FinishReason STOP = new FinishReason("STOP");
    public static final FinishReason MAX_TOKENS = new FinishReason("MAX_TOKENS");
    public static final FinishReason OTHER = new FinishReason("OTHER");

    private FinishReason(String str) {
        this.name = str;
    }
}
