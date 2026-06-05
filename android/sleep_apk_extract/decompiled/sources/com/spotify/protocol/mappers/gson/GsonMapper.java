package com.spotify.protocol.mappers.gson;

import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.spotify.protocol.mappers.JsonArray;
import com.spotify.protocol.mappers.JsonMapper;
import com.spotify.protocol.mappers.JsonMappingException;
import com.spotify.protocol.mappers.JsonObject;
import com.spotify.protocol.types.ImageUri;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class GsonMapper implements JsonMapper {
    private final Gson mGson;

    public static class ByteArrayToBase64TypeAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
        private ByteArrayToBase64TypeAdapter() {
        }

        @Override // com.google.gson.JsonDeserializer
        public byte[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            return Base64.decode(jsonElement.getAsJsonPrimitive().getAsString(), 2);
        }

        @Override // com.google.gson.JsonSerializer
        public JsonElement serialize(byte[] bArr, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(Base64.encodeToString(bArr, 2));
        }
    }

    public static class GsonJsonArray implements JsonArray {
        private final Gson mGson;
        private final com.google.gson.JsonArray mJsonArray;

        public GsonJsonArray(Gson gson, JsonElement jsonElement) {
            this.mGson = gson;
            this.mJsonArray = jsonElement.getAsJsonArray();
        }

        @Override // com.spotify.protocol.mappers.JsonArray
        public int getIntAt(int i) {
            try {
                return this.mJsonArray.get(i).getAsInt();
            } catch (RuntimeException unused) {
                return 0;
            }
        }

        @Override // com.spotify.protocol.mappers.JsonArray
        @Nullable
        public JsonObject getObjectAt(int i) {
            try {
                return new GsonJsonObject(this.mGson, this.mJsonArray.get(i));
            } catch (RuntimeException unused) {
                return null;
            }
        }

        @Override // com.spotify.protocol.mappers.JsonArray
        @Nullable
        public String getStringAt(int i) {
            try {
                return this.mJsonArray.get(i).getAsString();
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    public static class GsonJsonObject implements JsonObject {
        private final Gson mGson;
        private final JsonElement mJsonElement;

        public GsonJsonObject(Gson gson, JsonElement jsonElement) {
            this.mGson = gson;
            this.mJsonElement = jsonElement;
        }

        @Override // com.spotify.protocol.mappers.JsonObject
        public <T> T getAs(Class<T> cls) throws JsonMappingException {
            try {
                return (T) this.mGson.fromJson(this.mJsonElement, cls);
            } catch (RuntimeException e) {
                throw new JsonMappingException(e);
            }
        }

        @Override // com.spotify.protocol.mappers.JsonObject
        public String toJson() {
            return this.mGson.toJson(this.mJsonElement);
        }
    }

    private GsonMapper(Gson gson) {
        this.mGson = gson;
    }

    public static GsonMapper create() {
        return new GsonMapper(new GsonBuilder().registerTypeAdapter(ImageUri.class, new ImageUriGson()).registerTypeAdapter(byte[].class, new ByteArrayToBase64TypeAdapter()).create());
    }

    @Override // com.spotify.protocol.mappers.JsonMapper
    public String toJson(Object obj) {
        return this.mGson.toJson(obj);
    }

    @Override // com.spotify.protocol.mappers.JsonMapper
    public JsonArray toJsonArray(String str) throws JsonMappingException {
        try {
            return new GsonJsonArray(this.mGson, (JsonElement) this.mGson.fromJson(str, JsonElement.class));
        } catch (RuntimeException e) {
            throw new JsonMappingException(e);
        }
    }

    public static class ImageUriGson implements JsonDeserializer<ImageUri>, JsonSerializer<ImageUri> {
        private ImageUriGson() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.JsonDeserializer
        public ImageUri deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            return new ImageUri(jsonElement.getAsString());
        }

        @Override // com.google.gson.JsonSerializer
        public JsonElement serialize(ImageUri imageUri, Type type, JsonSerializationContext jsonSerializationContext) {
            return jsonSerializationContext.serialize(imageUri.raw);
        }
    }
}
