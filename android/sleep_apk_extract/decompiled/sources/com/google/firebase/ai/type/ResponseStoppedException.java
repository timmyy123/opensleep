package com.google.firebase.ai.type;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/type/ResponseStoppedException;", "Lcom/google/firebase/ai/type/FirebaseAIException;", "response", "Lcom/google/firebase/ai/type/GenerateContentResponse;", "cause", "", "<init>", "(Lcom/google/firebase/ai/type/GenerateContentResponse;Ljava/lang/Throwable;)V", "getResponse", "()Lcom/google/firebase/ai/type/GenerateContentResponse;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ResponseStoppedException extends FirebaseAIException {
    private final GenerateContentResponse response;

    public ResponseStoppedException(GenerateContentResponse generateContentResponse, Throwable th) {
        generateContentResponse.getClass();
        StringBuilder sb = new StringBuilder("Content generation stopped. Reason: ");
        FinishReason finishReason = ((Candidate) CollectionsKt.first((List) generateContentResponse.getCandidates())).getFinishReason();
        sb.append(finishReason != null ? finishReason.getName() : null);
        super(sb.toString(), th);
        this.response = generateContentResponse;
    }

    public final GenerateContentResponse getResponse() {
        return this.response;
    }

    public /* synthetic */ ResponseStoppedException(GenerateContentResponse generateContentResponse, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(generateContentResponse, (i & 2) != 0 ? null : th);
    }
}
