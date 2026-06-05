package com.google.firebase.ai.common;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H¦@¢\u0006\u0002\u0010\tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/common/HeaderProvider;", "", "timeout", "Lkotlin/time/Duration;", "getTimeout-UwyO8pc", "()J", "generateHeaders", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HeaderProvider {
    Object generateHeaders(Continuation<? super Map<String, String>> continuation);

    /* JADX INFO: renamed from: getTimeout-UwyO8pc */
    long mo395getTimeoutUwyO8pc();
}
