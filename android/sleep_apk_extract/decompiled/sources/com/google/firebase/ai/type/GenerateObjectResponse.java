package com.google.firebase.ai.type;

import androidx.work.Data$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\r\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/ai/type/GenerateObjectResponse;", "T", "", "response", "Lcom/google/firebase/ai/type/GenerateContentResponse;", "schema", "Lcom/google/firebase/ai/type/JsonSchema;", "<init>", "(Lcom/google/firebase/ai/type/GenerateContentResponse;Lcom/google/firebase/ai/type/JsonSchema;)V", "getResponse", "()Lcom/google/firebase/ai/type/GenerateContentResponse;", "getSchema$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/JsonSchema;", "getObject", "candidateIndex", "", "(I)Ljava/lang/Object;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GenerateObjectResponse<T> {
    private final GenerateContentResponse response;
    private final JsonSchema<T> schema;

    public GenerateObjectResponse(GenerateContentResponse generateContentResponse, JsonSchema<T> jsonSchema) {
        generateContentResponse.getClass();
        jsonSchema.getClass();
        this.response = generateContentResponse;
        this.schema = jsonSchema;
    }

    public static /* synthetic */ Object getObject$default(GenerateObjectResponse generateObjectResponse, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return generateObjectResponse.getObject(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getObject$lambda$1(TextPart textPart) {
        textPart.getClass();
        return textPart.getText();
    }

    public final T getObject(int candidateIndex) {
        Candidate candidate = this.response.getCandidates().get(candidateIndex);
        KSerializer<T> serializer = this.schema.getSerializer();
        List<Part> parts = candidate.getContent().getParts();
        ArrayList arrayList = new ArrayList();
        for (T t : parts) {
            if (!((Part) t).getIsThought()) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof TextPart) {
                arrayList2.add(obj);
            }
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, " ", null, null, new Data$$ExternalSyntheticLambda0(21), 30);
        if (strJoinToString$default.length() == 0) {
            return null;
        }
        return (T) Json.INSTANCE.decodeFromString(serializer, strJoinToString$default);
    }

    public final GenerateContentResponse getResponse() {
        return this.response;
    }

    public final JsonSchema<T> getSchema$com_google_firebase_ai_logic_firebase_ai() {
        return this.schema;
    }
}
