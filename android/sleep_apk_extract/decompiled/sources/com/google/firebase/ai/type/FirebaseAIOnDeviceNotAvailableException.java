package com.google.firebase.ai.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/ai/type/FirebaseAIOnDeviceNotAvailableException;", "Lcom/google/firebase/ai/type/FirebaseAIException;", "cause", "Lcom/google/firebase/ai/ondevice/interop/FirebaseAIOnDeviceNotAvailableException;", "<init>", "(Lcom/google/firebase/ai/ondevice/interop/FirebaseAIOnDeviceNotAvailableException;)V", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FirebaseAIOnDeviceNotAvailableException extends FirebaseAIException {
    /* JADX WARN: Illegal instructions before constructor call */
    public FirebaseAIOnDeviceNotAvailableException(com.google.firebase.ai.ondevice.interop.FirebaseAIOnDeviceNotAvailableException firebaseAIOnDeviceNotAvailableException) {
        firebaseAIOnDeviceNotAvailableException.getClass();
        String message = firebaseAIOnDeviceNotAvailableException.getMessage();
        super(message == null ? "Device doesn't support local models" : message, firebaseAIOnDeviceNotAvailableException);
    }
}
