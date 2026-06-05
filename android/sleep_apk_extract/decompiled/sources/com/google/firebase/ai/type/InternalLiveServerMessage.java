package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bq\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&\u0082\u0001\u0005\u0005\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/type/InternalLiveServerMessage;", "", "toPublic", "Lcom/google/firebase/ai/type/LiveServerMessage;", "Companion", "Lcom/google/firebase/ai/type/LiveServerContent$InternalWrapper;", "Lcom/google/firebase/ai/type/LiveServerGoAway$InternalWrapper;", "Lcom/google/firebase/ai/type/LiveServerSetupComplete$Internal;", "Lcom/google/firebase/ai/type/LiveServerToolCall$InternalWrapper;", "Lcom/google/firebase/ai/type/LiveServerToolCallCancellation$InternalWrapper;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable(with = LiveServerMessageSerializer.class)
public interface InternalLiveServerMessage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/InternalLiveServerMessage$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/InternalLiveServerMessage;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<InternalLiveServerMessage> serializer() {
            return LiveServerMessageSerializer.INSTANCE;
        }
    }

    LiveServerMessage toPublic();
}
