package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/google/firebase/ai/type/PromptBlockedException;", "Lcom/google/firebase/ai/type/FirebaseAIException;", "response", "Lcom/google/firebase/ai/type/GenerateContentResponse;", "cause", "", "message", "", "<init>", "(Lcom/google/firebase/ai/type/GenerateContentResponse;Ljava/lang/Throwable;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getResponse", "()Lcom/google/firebase/ai/type/GenerateContentResponse;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PromptBlockedException extends FirebaseAIException {
    private final GenerateContentResponse response;

    public PromptBlockedException(GenerateContentResponse generateContentResponse, Throwable th, String str) {
        PromptFeedback promptFeedback;
        BlockReason blockReason;
        String name;
        StringBuilder sb = new StringBuilder("Prompt was blocked: ");
        if (generateContentResponse != null && (promptFeedback = generateContentResponse.getPromptFeedback()) != null && (blockReason = promptFeedback.getBlockReason()) != null && (name = blockReason.getName()) != null) {
            str = name;
        }
        sb.append(str);
        super(sb.toString(), th);
        this.response = generateContentResponse;
    }

    public final GenerateContentResponse getResponse() {
        return this.response;
    }

    public /* synthetic */ PromptBlockedException(GenerateContentResponse generateContentResponse, Throwable th, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(generateContentResponse, (i & 2) != 0 ? null : th, (i & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PromptBlockedException(String str, Throwable th) {
        this(null, th, str);
        str.getClass();
    }

    public /* synthetic */ PromptBlockedException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }
}
