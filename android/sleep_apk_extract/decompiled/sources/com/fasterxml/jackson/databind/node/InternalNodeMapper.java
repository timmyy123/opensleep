package com.fasterxml.jackson.databind.node;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class InternalNodeMapper {
    private static final JsonMapper JSON_MAPPER;
    private static final ObjectReader NODE_READER;
    private static final ObjectWriter PRETTY_WRITER;
    private static final ObjectWriter STD_WRITER;

    public static final class IteratorStack {
        private int _end;
        private Iterator<?>[] _stack;
        private int _top;

        public Iterator<?> popOrNull() {
            int i = this._top;
            if (i == 0) {
                return null;
            }
            Iterator<?>[] itArr = this._stack;
            int i2 = i - 1;
            this._top = i2;
            return itArr[i2];
        }

        public void push(Iterator<?> it) {
            int i = this._top;
            int i2 = this._end;
            Iterator<?>[] itArr = this._stack;
            if (i < i2) {
                this._top = i + 1;
                itArr[i] = it;
                return;
            }
            if (itArr == null) {
                this._end = 10;
                this._stack = new Iterator[10];
            } else {
                int iMin = Math.min(4000, Math.max(20, i2 >> 1)) + i2;
                this._end = iMin;
                this._stack = (Iterator[]) Arrays.copyOf(this._stack, iMin);
            }
            Iterator<?>[] itArr2 = this._stack;
            int i3 = this._top;
            this._top = i3 + 1;
            itArr2[i3] = it;
        }
    }

    static {
        JsonMapper jsonMapper = new JsonMapper();
        JSON_MAPPER = jsonMapper;
        STD_WRITER = jsonMapper.writer();
        PRETTY_WRITER = jsonMapper.writer().withDefaultPrettyPrinter();
        NODE_READER = jsonMapper.readerFor(JsonNode.class);
    }

    private static JsonSerializable _wrapper(BaseJsonNode baseJsonNode) {
        return new WrapperForSerializer(baseJsonNode);
    }

    public static JsonNode bytesToNode(byte[] bArr) {
        return (JsonNode) NODE_READER.readValue(bArr);
    }

    public static String nodeToString(BaseJsonNode baseJsonNode) {
        try {
            return STD_WRITER.writeValueAsString(_wrapper(baseJsonNode));
        } catch (IOException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public static byte[] valueToBytes(Object obj) {
        return JSON_MAPPER.writeValueAsBytes(obj);
    }

    public static class WrapperForSerializer extends JsonSerializable.Base {
        protected SerializerProvider _context;
        protected final BaseJsonNode _root;

        public WrapperForSerializer(BaseJsonNode baseJsonNode) {
            this._root = baseJsonNode;
        }

        public void _serializeNonRecursive(JsonGenerator jsonGenerator, IteratorStack iteratorStack, Iterator<?> it) {
            JsonNode jsonNode;
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) next;
                        jsonGenerator.writeFieldName((String) entry.getKey());
                        jsonNode = (JsonNode) entry.getValue();
                    } else {
                        jsonNode = (JsonNode) next;
                    }
                    if (jsonNode instanceof ObjectNode) {
                        iteratorStack.push(it);
                        it = jsonNode.properties().iterator();
                        jsonGenerator.writeStartObject(jsonNode, jsonNode.size());
                    } else if (jsonNode instanceof ArrayNode) {
                        iteratorStack.push(it);
                        it = jsonNode.elements();
                        jsonGenerator.writeStartArray(jsonNode, jsonNode.size());
                    } else {
                        boolean z = jsonNode instanceof POJONode;
                        SerializerProvider serializerProvider = this._context;
                        if (z) {
                            try {
                                jsonNode.serialize(jsonGenerator, serializerProvider);
                            } catch (IOException | RuntimeException e) {
                                jsonGenerator.writeString(FileInsert$$ExternalSyntheticOutline0.m("[ERROR: (", e.getClass().getName(), ") ", e.getMessage(), "]"));
                            }
                        } else {
                            jsonNode.serialize(jsonGenerator, serializerProvider);
                        }
                    }
                } else {
                    if (jsonGenerator.getOutputContext().inArray()) {
                        jsonGenerator.writeEndArray();
                    } else {
                        jsonGenerator.writeEndObject();
                    }
                    it = iteratorStack.popOrNull();
                    if (it == null) {
                        return;
                    }
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.JsonSerializable
        public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            this._context = serializerProvider;
            _serializeNonRecursive(jsonGenerator, this._root);
        }

        @Override // com.fasterxml.jackson.databind.JsonSerializable
        public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            serialize(jsonGenerator, serializerProvider);
        }

        public void _serializeNonRecursive(JsonGenerator jsonGenerator, JsonNode jsonNode) {
            if (jsonNode instanceof ObjectNode) {
                jsonGenerator.writeStartObject(this, jsonNode.size());
                _serializeNonRecursive(jsonGenerator, new IteratorStack(), jsonNode.properties().iterator());
            } else if (jsonNode instanceof ArrayNode) {
                jsonGenerator.writeStartArray(this, jsonNode.size());
                _serializeNonRecursive(jsonGenerator, new IteratorStack(), jsonNode.elements());
            } else {
                jsonNode.serialize(jsonGenerator, this._context);
            }
        }
    }
}
