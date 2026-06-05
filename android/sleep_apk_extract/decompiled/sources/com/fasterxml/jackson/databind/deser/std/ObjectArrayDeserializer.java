package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class ObjectArrayDeserializer extends ContainerDeserializerBase<Object> implements ContextualDeserializer {
    private static final long serialVersionUID = 1;
    protected final Class<?> _elementClass;
    protected JsonDeserializer<Object> _elementDeserializer;
    protected final TypeDeserializer _elementTypeDeserializer;
    protected final Object[] _emptyValue;
    protected final boolean _untyped;

    public static class ArrayReferring extends ReadableObjectId.Referring {
        private final ObjectArrayReferringAccumulator _parent;

        public ArrayReferring(UnresolvedForwardReference unresolvedForwardReference, Class<?> cls, ObjectArrayReferringAccumulator objectArrayReferringAccumulator) {
            super(unresolvedForwardReference, cls);
            this._parent = objectArrayReferringAccumulator;
            objectArrayReferringAccumulator._accumulator.add(this);
        }
    }

    public static class ObjectArrayReferringAccumulator {
        private final List<Object> _accumulator = new ArrayList();
        private Object[] _array;
        private final Class<?> _elementType;
        private final boolean _untyped;

        public ObjectArrayReferringAccumulator(boolean z, Class<?> cls) {
            this._untyped = z;
            this._elementType = cls;
        }

        public void add(Object obj) {
            this._accumulator.add(obj);
        }

        public Object[] buildArray() {
            if (this._untyped) {
                this._array = new Object[this._accumulator.size()];
            } else {
                this._array = (Object[]) Array.newInstance(this._elementType, this._accumulator.size());
            }
            for (int i = 0; i < this._accumulator.size(); i++) {
                if (!(this._accumulator.get(i) instanceof ArrayReferring)) {
                    this._array[i] = this._accumulator.get(i);
                }
            }
            return this._array;
        }
    }

    public ObjectArrayDeserializer(JavaType javaType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer) {
        super(javaType, (NullValueProvider) null, (Boolean) null);
        ArrayType arrayType = (ArrayType) javaType;
        Class<?> rawClass = arrayType.getContentType().getRawClass();
        this._elementClass = rawClass;
        this._untyped = rawClass == Object.class;
        this._elementDeserializer = jsonDeserializer;
        this._elementTypeDeserializer = typeDeserializer;
        this._emptyValue = arrayType.getEmptyArray();
    }

    public Object[] _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, ObjectBuffer objectBuffer, int i, Object[] objArr) throws JsonMappingException {
        Object obj_deserializeNoNullChecks;
        while (true) {
            try {
                JsonToken jsonTokenNextToken = jsonParser.nextToken();
                if (jsonTokenNextToken == JsonToken.END_ARRAY) {
                    break;
                }
                if (jsonTokenNextToken != JsonToken.VALUE_NULL) {
                    obj_deserializeNoNullChecks = _deserializeNoNullChecks(jsonParser, deserializationContext);
                } else if (!this._skipNullValues) {
                    obj_deserializeNoNullChecks = null;
                }
                if (obj_deserializeNoNullChecks != null || (obj_deserializeNoNullChecks = this._nullProvider.getNullValue(deserializationContext)) != null || !this._skipNullValues) {
                    if (i >= objArr.length) {
                        objArr = objectBuffer.appendCompletedChunk(objArr);
                        i = 0;
                    }
                    int i2 = i + 1;
                    try {
                        objArr[i] = obj_deserializeNoNullChecks;
                        i = i2;
                    } catch (Exception e) {
                        e = e;
                        i = i2;
                        throw JsonMappingException.wrapWithPath(e, objArr, objectBuffer.bufferedSize() + i);
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        Object[] objArrCompleteAndClearBuffer = this._untyped ? objectBuffer.completeAndClearBuffer(objArr, i) : objectBuffer.completeAndClearBuffer(objArr, i, this._elementClass);
        deserializationContext.returnObjectBuffer(objectBuffer);
        return objArrCompleteAndClearBuffer;
    }

    public Object _deserializeNoNullChecks(JsonParser jsonParser, DeserializationContext deserializationContext) {
        TypeDeserializer typeDeserializer = this._elementTypeDeserializer;
        JsonDeserializer<Object> jsonDeserializer = this._elementDeserializer;
        return typeDeserializer == null ? jsonDeserializer.deserialize(jsonParser, deserializationContext) : jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
    }

    public Object[] _deserializeWithObjectId(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
        Object obj_deserializeNoNullChecks;
        ObjectArrayReferringAccumulator objectArrayReferringAccumulator = new ObjectArrayReferringAccumulator(this._untyped, this._elementClass);
        int i = 0;
        while (true) {
            try {
                JsonToken jsonTokenNextToken = jsonParser.nextToken();
                if (jsonTokenNextToken == JsonToken.END_ARRAY) {
                    return objectArrayReferringAccumulator.buildArray();
                }
                try {
                } catch (UnresolvedForwardReference e) {
                    e.getRoid().appendReferring(new ArrayReferring(e, this._elementClass, objectArrayReferringAccumulator));
                }
                if (jsonTokenNextToken != JsonToken.VALUE_NULL) {
                    obj_deserializeNoNullChecks = _deserializeNoNullChecks(jsonParser, deserializationContext);
                } else if (!this._skipNullValues) {
                    obj_deserializeNoNullChecks = null;
                }
                if (obj_deserializeNoNullChecks != null || (obj_deserializeNoNullChecks = this._nullProvider.getNullValue(deserializationContext)) != null || !this._skipNullValues) {
                    objectArrayReferringAccumulator.add(obj_deserializeNoNullChecks);
                    i++;
                }
            } catch (Exception e2) {
                if (deserializationContext != null && !deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) {
                    ClassUtil.throwIfRTE(e2);
                }
                throw JsonMappingException.wrapWithPath(e2, objectArrayReferringAccumulator.buildArray(), i);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Class, java.lang.Class<?>] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public Object[] _wrapSingleWithObjectId(JsonParser jsonParser, DeserializationContext deserializationContext) {
        UnresolvedForwardReference unresolvedForwardReference;
        ?? r2;
        Object nullValue;
        ObjectArrayDeserializer objectArrayDeserializer;
        DeserializationContext deserializationContext2;
        JsonParser jsonParser2;
        boolean z = this._untyped;
        ?? r22 = this._elementClass;
        ObjectArrayReferringAccumulator objectArrayReferringAccumulator = new ObjectArrayReferringAccumulator(z, r22);
        try {
            try {
            } catch (UnresolvedForwardReference e) {
                e = e;
            }
        } catch (UnresolvedForwardReference e2) {
            e = e2;
            r22 = this;
        }
        if (jsonParser.hasToken(JsonToken.VALUE_NULL)) {
            try {
                if (this._skipNullValues) {
                    return this._emptyValue;
                }
                nullValue = null;
                objectArrayDeserializer = this;
                deserializationContext2 = deserializationContext;
            } catch (UnresolvedForwardReference e3) {
                unresolvedForwardReference = e3;
                r2 = this;
                unresolvedForwardReference.getRoid().appendReferring(new ArrayReferring(unresolvedForwardReference, r2._elementClass, objectArrayReferringAccumulator));
            }
            return objectArrayReferringAccumulator.buildArray();
        }
        if (jsonParser.hasToken(JsonToken.VALUE_STRING)) {
            String text = jsonParser.getText();
            if (text.isEmpty()) {
                CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyString);
                if (coercionActionFindCoercionAction != CoercionAction.Fail) {
                    try {
                        return (Object[]) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionAction, handledType(), "empty String (\"\")");
                    } catch (UnresolvedForwardReference e4) {
                        e = e4;
                        r22 = this;
                    }
                }
                objectArrayDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                nullValue = objectArrayDeserializer._deserializeNoNullChecks(jsonParser2, deserializationContext2);
            } else {
                objectArrayDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                if (StdDeserializer._isBlank(text)) {
                    LogicalType logicalType = objectArrayDeserializer.logicalType();
                    Class<?> clsHandledType = objectArrayDeserializer.handledType();
                    CoercionAction coercionAction = CoercionAction.Fail;
                    CoercionAction coercionActionFindCoercionFromBlankString = deserializationContext2.findCoercionFromBlankString(logicalType, clsHandledType, coercionAction);
                    if (coercionActionFindCoercionFromBlankString != coercionAction) {
                        return (Object[]) objectArrayDeserializer._deserializeFromEmptyString(jsonParser2, deserializationContext2, coercionActionFindCoercionFromBlankString, objectArrayDeserializer.handledType(), "blank String (all whitespace)");
                    }
                }
                nullValue = objectArrayDeserializer._deserializeNoNullChecks(jsonParser2, deserializationContext2);
            }
            unresolvedForwardReference = e;
            r2 = r22;
            unresolvedForwardReference.getRoid().appendReferring(new ArrayReferring(unresolvedForwardReference, r2._elementClass, objectArrayReferringAccumulator));
        } else {
            objectArrayDeserializer = this;
            jsonParser2 = jsonParser;
            deserializationContext2 = deserializationContext;
            nullValue = objectArrayDeserializer._deserializeNoNullChecks(jsonParser2, deserializationContext2);
        }
        return objectArrayReferringAccumulator.buildArray();
        if (nullValue == null && (nullValue = objectArrayDeserializer._nullProvider.getNullValue(deserializationContext2)) == null && objectArrayDeserializer._skipNullValues) {
            return objectArrayDeserializer._emptyValue;
        }
        objectArrayReferringAccumulator.add(nullValue);
        return objectArrayReferringAccumulator.buildArray();
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer<?> jsonDeserializer = this._elementDeserializer;
        Boolean boolFindFormatFeature = findFormatFeature(deserializationContext, beanProperty, this._containerType.getRawClass(), JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        JsonDeserializer<?> jsonDeserializerFindConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, beanProperty, jsonDeserializer);
        JavaType contentType = this._containerType.getContentType();
        JsonDeserializer<?> jsonDeserializerFindContextualValueDeserializer = jsonDeserializerFindConvertingContentDeserializer == null ? deserializationContext.findContextualValueDeserializer(contentType, beanProperty) : deserializationContext.handleSecondaryContextualization(jsonDeserializerFindConvertingContentDeserializer, beanProperty, contentType);
        TypeDeserializer typeDeserializerForProperty = this._elementTypeDeserializer;
        if (typeDeserializerForProperty != null) {
            typeDeserializerForProperty = typeDeserializerForProperty.forProperty(beanProperty);
        }
        return withResolved(typeDeserializerForProperty, jsonDeserializerFindContextualValueDeserializer, findContentNullProvider(deserializationContext, beanProperty, jsonDeserializerFindContextualValueDeserializer), boolFindFormatFeature);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        Object obj_deserializeNoNullChecks;
        Object[] objArr = (Object[]) obj;
        if (!jsonParser.isExpectedStartArrayToken()) {
            Object[] objArr2 = (Object[]) handleNonArray(jsonParser, deserializationContext);
            if (objArr2 == null) {
                return objArr;
            }
            int length = objArr.length;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr2.length + length);
            System.arraycopy(objArr2, 0, objArrCopyOf, length, objArr2.length);
            return objArrCopyOf;
        }
        ObjectBuffer objectBufferLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        int length2 = objArr.length;
        Object[] objArrResetAndStart = objectBufferLeaseObjectBuffer.resetAndStart(objArr, length2);
        while (true) {
            try {
                JsonToken jsonTokenNextToken = jsonParser.nextToken();
                if (jsonTokenNextToken == JsonToken.END_ARRAY) {
                    break;
                }
                if (jsonTokenNextToken != JsonToken.VALUE_NULL) {
                    obj_deserializeNoNullChecks = _deserializeNoNullChecks(jsonParser, deserializationContext);
                } else if (!this._skipNullValues) {
                    obj_deserializeNoNullChecks = null;
                }
                if (obj_deserializeNoNullChecks != null || (obj_deserializeNoNullChecks = this._nullProvider.getNullValue(deserializationContext)) != null || !this._skipNullValues) {
                    if (length2 >= objArrResetAndStart.length) {
                        objArrResetAndStart = objectBufferLeaseObjectBuffer.appendCompletedChunk(objArrResetAndStart);
                        length2 = 0;
                    }
                    int i = length2 + 1;
                    try {
                        objArrResetAndStart[length2] = obj_deserializeNoNullChecks;
                        length2 = i;
                    } catch (Exception e) {
                        e = e;
                        length2 = i;
                        throw JsonMappingException.wrapWithPath(e, objArrResetAndStart, objectBufferLeaseObjectBuffer.bufferedSize() + length2);
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        Object[] objArrCompleteAndClearBuffer = this._untyped ? objectBufferLeaseObjectBuffer.completeAndClearBuffer(objArrResetAndStart, length2) : objectBufferLeaseObjectBuffer.completeAndClearBuffer(objArrResetAndStart, length2, this._elementClass);
        deserializationContext.returnObjectBuffer(objectBufferLeaseObjectBuffer);
        return objArrCompleteAndClearBuffer;
    }

    public Byte[] deserializeFromBase64(JsonParser jsonParser, DeserializationContext deserializationContext) {
        byte[] binaryValue = jsonParser.getBinaryValue(deserializationContext.getBase64Variant());
        Byte[] bArr = new Byte[binaryValue.length];
        int length = binaryValue.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = Byte.valueOf(binaryValue[i]);
        }
        return bArr;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return (Object[]) typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public JsonDeserializer<Object> getContentDeserializer() {
        return this._elementDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, com.fasterxml.jackson.databind.JsonDeserializer
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, com.fasterxml.jackson.databind.JsonDeserializer
    public Object getEmptyValue(DeserializationContext deserializationContext) {
        return this._emptyValue;
    }

    public Object handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) {
        ObjectArrayDeserializer objectArrayDeserializer;
        JsonParser jsonParser2;
        DeserializationContext deserializationContext2;
        Object obj_deserializeNoNullChecks;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return jsonParser.hasToken(JsonToken.VALUE_STRING) ? this._elementClass == Byte.class ? deserializeFromBase64(jsonParser, deserializationContext) : _deserializeFromString(jsonParser, deserializationContext) : deserializationContext.handleUnexpectedToken(this._containerType, jsonParser);
        }
        if (this._elementDeserializer.getObjectIdReader() != null) {
            return _wrapSingleWithObjectId(jsonParser, deserializationContext);
        }
        if (jsonParser.hasToken(JsonToken.VALUE_NULL)) {
            if (this._skipNullValues) {
                return this._emptyValue;
            }
            obj_deserializeNoNullChecks = null;
            objectArrayDeserializer = this;
            deserializationContext2 = deserializationContext;
        } else if (jsonParser.hasToken(JsonToken.VALUE_STRING)) {
            String text = jsonParser.getText();
            if (text.isEmpty()) {
                CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyString);
                if (coercionActionFindCoercionAction != CoercionAction.Fail) {
                    return (Object[]) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionAction, handledType(), "empty String (\"\")");
                }
                objectArrayDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                obj_deserializeNoNullChecks = objectArrayDeserializer._deserializeNoNullChecks(jsonParser2, deserializationContext2);
            } else {
                objectArrayDeserializer = this;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                if (StdDeserializer._isBlank(text)) {
                    LogicalType logicalType = objectArrayDeserializer.logicalType();
                    Class<?> clsHandledType = objectArrayDeserializer.handledType();
                    CoercionAction coercionAction = CoercionAction.Fail;
                    CoercionAction coercionActionFindCoercionFromBlankString = deserializationContext2.findCoercionFromBlankString(logicalType, clsHandledType, coercionAction);
                    if (coercionActionFindCoercionFromBlankString != coercionAction) {
                        return (Object[]) objectArrayDeserializer._deserializeFromEmptyString(jsonParser2, deserializationContext2, coercionActionFindCoercionFromBlankString, objectArrayDeserializer.handledType(), "blank String (all whitespace)");
                    }
                }
                obj_deserializeNoNullChecks = objectArrayDeserializer._deserializeNoNullChecks(jsonParser2, deserializationContext2);
            }
        } else {
            objectArrayDeserializer = this;
            jsonParser2 = jsonParser;
            deserializationContext2 = deserializationContext;
            obj_deserializeNoNullChecks = objectArrayDeserializer._deserializeNoNullChecks(jsonParser2, deserializationContext2);
        }
        if (obj_deserializeNoNullChecks == null && (obj_deserializeNoNullChecks = objectArrayDeserializer._nullProvider.getNullValue(deserializationContext2)) == null && objectArrayDeserializer._skipNullValues) {
            return objectArrayDeserializer._emptyValue;
        }
        Object[] objArr = objectArrayDeserializer._untyped ? new Object[1] : (Object[]) Array.newInstance(objectArrayDeserializer._elementClass, 1);
        objArr[0] = obj_deserializeNoNullChecks;
        return objArr;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return this._elementDeserializer == null && this._elementTypeDeserializer == null;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Array;
    }

    public ObjectArrayDeserializer withResolved(TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer, NullValueProvider nullValueProvider, Boolean bool) {
        return (Objects.equals(bool, this._unwrapSingle) && nullValueProvider == this._nullProvider && jsonDeserializer == this._elementDeserializer && typeDeserializer == this._elementTypeDeserializer) ? this : new ObjectArrayDeserializer(this, jsonDeserializer, typeDeserializer, nullValueProvider, bool);
    }

    public ObjectArrayDeserializer(ObjectArrayDeserializer objectArrayDeserializer, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, NullValueProvider nullValueProvider, Boolean bool) {
        super(objectArrayDeserializer, nullValueProvider, bool);
        this._elementClass = objectArrayDeserializer._elementClass;
        this._untyped = objectArrayDeserializer._untyped;
        this._emptyValue = objectArrayDeserializer._emptyValue;
        this._elementDeserializer = jsonDeserializer;
        this._elementTypeDeserializer = typeDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext);
        }
        if (this._elementDeserializer.getObjectIdReader() != null) {
            return _deserializeWithObjectId(jsonParser, deserializationContext);
        }
        ObjectBuffer objectBufferLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        return _deserialize(jsonParser, deserializationContext, objectBufferLeaseObjectBuffer, 0, objectBufferLeaseObjectBuffer.resetAndStart());
    }
}
