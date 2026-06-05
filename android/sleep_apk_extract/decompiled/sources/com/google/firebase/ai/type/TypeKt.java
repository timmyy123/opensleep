package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"toInternal", "Lkotlinx/serialization/json/JsonObject;", "Lorg/json/JSONObject;", "toPublic", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TypeKt {
    public static final JsonObject toInternal(JSONObject jSONObject) {
        jSONObject.getClass();
        Json.Companion companion = Json.INSTANCE;
        String string = jSONObject.toString();
        string.getClass();
        companion.getSerializersModule();
        return (JsonObject) companion.decodeFromString(JsonObject.INSTANCE.serializer(), string);
    }

    public static final JSONObject toPublic(JsonObject jsonObject) {
        jsonObject.getClass();
        return new JSONObject(jsonObject.toString());
    }
}
