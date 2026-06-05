package com.google.firebase.ai.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/firebase/ai/type/SessionAlreadyReceivingException;", "Lcom/google/firebase/ai/type/FirebaseAIException;", "<init>", "()V", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SessionAlreadyReceivingException extends FirebaseAIException {
    public SessionAlreadyReceivingException() {
        super("This session is already receiving. Please call stopReceiving() before calling this again.", null, 2, null);
    }
}
