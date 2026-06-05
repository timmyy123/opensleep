package com.google.firebase.ai.generativemodel;

import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.GenerateContentResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;", "", "", "Lcom/google/firebase/ai/type/Content;", "prompt", "Lcom/google/firebase/ai/type/GenerateContentResponse;", "generateContent", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface GenerativeModelProvider {
    Object generateContent(List<Content> list, Continuation<? super GenerateContentResponse> continuation);
}
