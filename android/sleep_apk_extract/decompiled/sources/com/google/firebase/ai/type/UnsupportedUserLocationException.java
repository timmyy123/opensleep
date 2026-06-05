package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/ai/type/UnsupportedUserLocationException;", "Lcom/google/firebase/ai/type/FirebaseAIException;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnsupportedUserLocationException extends FirebaseAIException {
    public /* synthetic */ UnsupportedUserLocationException(Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnsupportedUserLocationException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public UnsupportedUserLocationException(Throwable th) {
        super("User location is not supported for the API use.", th);
    }
}
