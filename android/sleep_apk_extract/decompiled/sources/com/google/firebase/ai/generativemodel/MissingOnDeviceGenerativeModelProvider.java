package com.google.firebase.ai.generativemodel;

import com.google.firebase.ai.ondevice.interop.FirebaseAIOnDeviceNotAvailableException;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.FirebaseAIException;
import com.google.firebase.ai.type.GenerateContentResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0096@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/generativemodel/MissingOnDeviceGenerativeModelProvider;", "Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;", "<init>", "()V", "", "Lcom/google/firebase/ai/type/Content;", "prompt", "Lcom/google/firebase/ai/type/GenerateContentResponse;", "generateContent", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MissingOnDeviceGenerativeModelProvider implements GenerativeModelProvider {
    @Override // com.google.firebase.ai.generativemodel.GenerativeModelProvider
    public Object generateContent(List<Content> list, Continuation<? super GenerateContentResponse> continuation) {
        throw FirebaseAIException.INSTANCE.from$com_google_firebase_ai_logic_firebase_ai(new FirebaseAIOnDeviceNotAvailableException("On-device model is not available", null, 2, null));
    }
}
