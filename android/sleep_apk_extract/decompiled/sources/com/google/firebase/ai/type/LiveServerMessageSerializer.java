package com.google.firebase.ai.type;

import com.google.firebase.ai.type.LiveServerContent;
import com.google.firebase.ai.type.LiveServerGoAway;
import com.google.firebase.ai.type.LiveServerSetupComplete;
import com.google.firebase.ai.type.LiveServerToolCall;
import com.google.firebase.ai.type.LiveServerToolCallCancellation;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.JsonContentPolymorphicSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\t"}, d2 = {"Lcom/google/firebase/ai/type/LiveServerMessageSerializer;", "Lkotlinx/serialization/json/JsonContentPolymorphicSerializer;", "Lcom/google/firebase/ai/type/InternalLiveServerMessage;", "<init>", "()V", "selectDeserializer", "Lkotlinx/serialization/DeserializationStrategy;", "element", "Lkotlinx/serialization/json/JsonElement;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveServerMessageSerializer extends JsonContentPolymorphicSerializer<InternalLiveServerMessage> {
    public static final LiveServerMessageSerializer INSTANCE = new LiveServerMessageSerializer();

    private LiveServerMessageSerializer() {
        super(Reflection.getOrCreateKotlinClass(InternalLiveServerMessage.class));
    }

    @Override // kotlinx.serialization.json.JsonContentPolymorphicSerializer
    public DeserializationStrategy<InternalLiveServerMessage> selectDeserializer(JsonElement element) {
        element.getClass();
        JsonObject jsonObject = JsonElementKt.getJsonObject(element);
        if (jsonObject.containsKey((Object) "serverContent")) {
            return LiveServerContent.InternalWrapper.INSTANCE.serializer();
        }
        if (jsonObject.containsKey((Object) "setupComplete")) {
            return LiveServerSetupComplete.Internal.INSTANCE.serializer();
        }
        if (jsonObject.containsKey((Object) "toolCall")) {
            return LiveServerToolCall.InternalWrapper.INSTANCE.serializer();
        }
        if (jsonObject.containsKey((Object) "toolCallCancellation")) {
            return LiveServerToolCallCancellation.InternalWrapper.INSTANCE.serializer();
        }
        if (jsonObject.containsKey((Object) "goAway")) {
            return LiveServerGoAway.InternalWrapper.INSTANCE.serializer();
        }
        throw new SerializationException("Unknown LiveServerMessage response type. Keys found: " + jsonObject.keySet(), null, 2, null);
    }
}
