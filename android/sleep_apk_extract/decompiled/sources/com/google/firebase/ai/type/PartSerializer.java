package com.google.firebase.ai.type;

import android.util.Log;
import com.google.firebase.ai.type.CodeExecutionResultPart;
import com.google.firebase.ai.type.ExecutableCodePart;
import com.google.firebase.ai.type.FileDataPart;
import com.google.firebase.ai.type.FunctionCallPart;
import com.google.firebase.ai.type.FunctionResponsePart;
import com.google.firebase.ai.type.InlineDataPart;
import com.google.firebase.ai.type.TextPart;
import com.google.firebase.ai.type.UnknownPart;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.JsonContentPolymorphicSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/google/firebase/ai/type/PartSerializer;", "Lkotlinx/serialization/json/JsonContentPolymorphicSerializer;", "Lcom/google/firebase/ai/type/InternalPart;", "<init>", "()V", "TAG", "", "selectDeserializer", "Lkotlinx/serialization/DeserializationStrategy;", "element", "Lkotlinx/serialization/json/JsonElement;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PartSerializer extends JsonContentPolymorphicSerializer<InternalPart> {
    public static final PartSerializer INSTANCE = new PartSerializer();
    private static final String TAG = "javaClass";

    private PartSerializer() {
        super(Reflection.getOrCreateKotlinClass(InternalPart.class));
    }

    @Override // kotlinx.serialization.json.JsonContentPolymorphicSerializer
    public DeserializationStrategy<InternalPart> selectDeserializer(JsonElement element) {
        element.getClass();
        JsonObject jsonObject = JsonElementKt.getJsonObject(element);
        if (jsonObject.containsKey((Object) "text")) {
            return TextPart.Internal.INSTANCE.serializer();
        }
        if (jsonObject.containsKey((Object) "executableCode")) {
            return ExecutableCodePart.Internal.INSTANCE.serializer();
        }
        if (jsonObject.containsKey((Object) "codeExecutionResult")) {
            return CodeExecutionResultPart.Internal.INSTANCE.serializer();
        }
        if (jsonObject.containsKey((Object) "functionCall")) {
            return FunctionCallPart.Internal.INSTANCE.serializer();
        }
        if (jsonObject.containsKey((Object) "functionResponse")) {
            return FunctionResponsePart.Internal.INSTANCE.serializer();
        }
        if (jsonObject.containsKey((Object) "inlineData")) {
            return InlineDataPart.Internal.INSTANCE.serializer();
        }
        if (jsonObject.containsKey((Object) "fileData")) {
            return FileDataPart.Internal.INSTANCE.serializer();
        }
        Log.w(TAG, "Unknown part type received, ignoring.");
        return UnknownPart.Internal.INSTANCE.serializer();
    }
}
