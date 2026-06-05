package com.google.firebase.ai;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseKt;
import com.google.firebase.ai.type.GenerativeBackend;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/firebase/Firebase;", "Lcom/google/firebase/FirebaseApp;", "app", "Lcom/google/firebase/ai/type/GenerativeBackend;", "backend", "Lcom/google/firebase/ai/FirebaseAI;", "ai", "(Lcom/google/firebase/Firebase;Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/ai/type/GenerativeBackend;)Lcom/google/firebase/ai/FirebaseAI;", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class FirebaseAIKt {
    public static final FirebaseAI ai(Firebase firebase, FirebaseApp firebaseApp, GenerativeBackend generativeBackend) {
        firebase.getClass();
        firebaseApp.getClass();
        generativeBackend.getClass();
        return FirebaseAI.INSTANCE.getInstance(firebaseApp, generativeBackend);
    }

    public static /* synthetic */ FirebaseAI ai$default(Firebase firebase, FirebaseApp firebaseApp, GenerativeBackend generativeBackend, int i, Object obj) {
        if ((i & 1) != 0) {
            firebaseApp = FirebaseKt.getApp(Firebase.INSTANCE);
        }
        if ((i & 2) != 0) {
            generativeBackend = GenerativeBackend.INSTANCE.googleAI();
        }
        return ai(firebase, firebaseApp, generativeBackend);
    }
}
