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
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public final class StringCollectionDeserializer extends ContainerDeserializerBase<Collection<String>> implements ContextualDeserializer {
    private static final long serialVersionUID = 1;
    private final JsonDeserializer<Object> _delegateDeserializer;
    private final JsonDeserializer<String> _valueDeserializer;
    private final ValueInstantiator _valueInstantiator;

    public StringCollectionDeserializer(JavaType javaType, JsonDeserializer<?> jsonDeserializer, ValueInstantiator valueInstantiator) {
        this(javaType, valueInstantiator, null, jsonDeserializer, jsonDeserializer, null);
    }

    private static Collection<String> castToCollection(Object obj) {
        if (obj != null) {
            if (obj.getClass() == ArrayList.class) {
                return (ArrayList) obj;
            }
            if (obj.getClass() == HashSet.class) {
                return (HashSet) obj;
            }
        }
        return (Collection) obj;
    }

    private Collection<String> deserializeUsingCustom(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection, JsonDeserializer<String> jsonDeserializer) throws JsonMappingException {
        String strDeserialize;
        while (true) {
            try {
                if (jsonParser.nextTextValue() == null) {
                    JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
                    if (jsonTokenCurrentToken == JsonToken.END_ARRAY) {
                        return collection;
                    }
                    if (jsonTokenCurrentToken != JsonToken.VALUE_NULL) {
                        strDeserialize = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                    } else if (!this._skipNullValues) {
                        strDeserialize = null;
                    }
                } else {
                    strDeserialize = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                }
                if (strDeserialize != null || (strDeserialize = (String) this._nullProvider.getNullValue(deserializationContext)) != null || !this._skipNullValues) {
                    collection.add(strDeserialize);
                }
            } catch (Exception e) {
                throw JsonMappingException.wrapWithPath(e, collection, collection.size());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab A[Catch: Exception -> 0x00b3, TRY_ENTER, TryCatch #0 {Exception -> 0x00b3, blocks: (B:37:0x00ab, B:41:0x00b6), top: B:53:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6 A[Catch: Exception -> 0x00b3, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b3, blocks: (B:37:0x00ab, B:41:0x00b6), top: B:53:0x00a9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Collection<String> handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws JsonMappingException {
        StringCollectionDeserializer stringCollectionDeserializer;
        JsonDeserializer<String> jsonDeserializer;
        JsonParser jsonParser2;
        DeserializationContext deserializationContext2;
        String str_parseString;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return jsonParser.hasToken(JsonToken.VALUE_STRING) ? _deserializeFromString(jsonParser, deserializationContext) : castToCollection(deserializationContext.handleUnexpectedToken(this._containerType, jsonParser));
        }
        JsonDeserializer<String> jsonDeserializer2 = this._valueDeserializer;
        if (jsonParser.currentToken() == JsonToken.VALUE_NULL) {
            if (!this._skipNullValues) {
                str_parseString = null;
                stringCollectionDeserializer = this;
                deserializationContext2 = deserializationContext;
            }
            return collection;
        }
        if (jsonParser.hasToken(JsonToken.VALUE_STRING)) {
            String text = jsonParser.getText();
            if (text.isEmpty()) {
                CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyString);
                if (coercionActionFindCoercionAction != CoercionAction.Fail) {
                    return castToCollection(_deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionAction, handledType(), "empty String (\"\")"));
                }
                stringCollectionDeserializer = this;
                jsonDeserializer = jsonDeserializer2;
                jsonParser2 = jsonParser;
                deserializationContext2 = deserializationContext;
                try {
                    str_parseString = jsonDeserializer == null ? stringCollectionDeserializer._parseString(jsonParser2, deserializationContext2, stringCollectionDeserializer._nullProvider) : jsonDeserializer.deserialize(jsonParser2, deserializationContext2);
                } catch (Exception e) {
                    throw JsonMappingException.wrapWithPath(e, collection, collection.size());
                }
            } else {
                deserializationContext2 = deserializationContext;
                if (StdDeserializer._isBlank(text)) {
                    LogicalType logicalType = logicalType();
                    Class<?> clsHandledType = handledType();
                    CoercionAction coercionAction = CoercionAction.Fail;
                    CoercionAction coercionActionFindCoercionFromBlankString = deserializationContext2.findCoercionFromBlankString(logicalType, clsHandledType, coercionAction);
                    if (coercionActionFindCoercionFromBlankString != coercionAction) {
                        return castToCollection(_deserializeFromEmptyString(jsonParser, deserializationContext2, coercionActionFindCoercionFromBlankString, handledType(), "blank String (all whitespace)"));
                    }
                }
                jsonDeserializer = jsonDeserializer2;
                stringCollectionDeserializer = this;
                jsonParser2 = jsonParser;
                str_parseString = jsonDeserializer == null ? stringCollectionDeserializer._parseString(jsonParser2, deserializationContext2, stringCollectionDeserializer._nullProvider) : jsonDeserializer.deserialize(jsonParser2, deserializationContext2);
            }
        } else {
            stringCollectionDeserializer = this;
            jsonDeserializer = jsonDeserializer2;
            jsonParser2 = jsonParser;
            deserializationContext2 = deserializationContext;
            str_parseString = jsonDeserializer == null ? stringCollectionDeserializer._parseString(jsonParser2, deserializationContext2, stringCollectionDeserializer._nullProvider) : jsonDeserializer.deserialize(jsonParser2, deserializationContext2);
        }
        return collection;
        if (str_parseString != null || (str_parseString = (String) stringCollectionDeserializer._nullProvider.getNullValue(deserializationContext2)) != null || !stringCollectionDeserializer._skipNullValues) {
            collection.add(str_parseString);
            return collection;
        }
        return collection;
    }

    private StringCollectionDeserializer withResolved(JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, NullValueProvider nullValueProvider, Boolean bool) {
        return (Objects.equals(this._unwrapSingle, bool) && this._nullProvider == nullValueProvider && this._valueDeserializer == jsonDeserializer2 && this._delegateDeserializer == jsonDeserializer) ? this : new StringCollectionDeserializer(this._containerType, this._valueInstantiator, jsonDeserializer, jsonDeserializer2, nullValueProvider, bool);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer<?> jsonDeserializerFindDeserializer;
        JsonDeserializer<?> jsonDeserializerHandleSecondaryContextualization;
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        if (valueInstantiator != null) {
            AnnotatedWithParams arrayDelegateCreator = valueInstantiator.getArrayDelegateCreator();
            ValueInstantiator valueInstantiator2 = this._valueInstantiator;
            jsonDeserializerFindDeserializer = arrayDelegateCreator != null ? findDeserializer(deserializationContext, valueInstantiator2.getArrayDelegateType(deserializationContext.getConfig()), beanProperty) : valueInstantiator2.getDelegateCreator() != null ? findDeserializer(deserializationContext, this._valueInstantiator.getDelegateType(deserializationContext.getConfig()), beanProperty) : null;
        }
        JsonDeserializer<String> jsonDeserializer = this._valueDeserializer;
        JavaType contentType = this._containerType.getContentType();
        if (jsonDeserializer == null) {
            jsonDeserializerHandleSecondaryContextualization = findConvertingContentDeserializer(deserializationContext, beanProperty, jsonDeserializer);
            if (jsonDeserializerHandleSecondaryContextualization == null) {
                jsonDeserializerHandleSecondaryContextualization = deserializationContext.findContextualValueDeserializer(contentType, beanProperty);
            }
        } else {
            jsonDeserializerHandleSecondaryContextualization = deserializationContext.handleSecondaryContextualization(jsonDeserializer, beanProperty, contentType);
        }
        return withResolved(jsonDeserializerFindDeserializer, isDefaultDeserializer(jsonDeserializerHandleSecondaryContextualization) ? null : jsonDeserializerHandleSecondaryContextualization, findContentNullProvider(deserializationContext, beanProperty, jsonDeserializerHandleSecondaryContextualization), findFormatFeature(deserializationContext, beanProperty, Collection.class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY));
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws JsonMappingException {
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext, collection);
        }
        JsonDeserializer<String> jsonDeserializer = this._valueDeserializer;
        if (jsonDeserializer != null) {
            return deserializeUsingCustom(jsonParser, deserializationContext, collection, jsonDeserializer);
        }
        while (true) {
            try {
                String strNextTextValue = jsonParser.nextTextValue();
                if (strNextTextValue != null) {
                    collection.add(strNextTextValue);
                } else {
                    JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
                    if (jsonTokenCurrentToken == JsonToken.END_ARRAY) {
                        return collection;
                    }
                    if (jsonTokenCurrentToken != JsonToken.VALUE_NULL) {
                        strNextTextValue = _parseString(jsonParser, deserializationContext, this._nullProvider);
                    } else if (this._skipNullValues) {
                    }
                    if (strNextTextValue != null || (strNextTextValue = (String) this._nullProvider.getNullValue(deserializationContext)) != null || !this._skipNullValues) {
                        collection.add(strNextTextValue);
                    }
                }
            } catch (Exception e) {
                throw JsonMappingException.wrapWithPath(e, collection, collection.size());
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return this._valueDeserializer == null && this._delegateDeserializer == null;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private StringCollectionDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, NullValueProvider nullValueProvider, Boolean bool) {
        super(javaType, nullValueProvider, bool);
        this._valueDeserializer = jsonDeserializer2;
        this._valueInstantiator = valueInstantiator;
        this._delegateDeserializer = jsonDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        if (jsonDeserializer != null) {
            return castToCollection(valueInstantiator.createUsingDelegate(deserializationContext, jsonDeserializer.deserialize(jsonParser, deserializationContext)));
        }
        return deserialize(jsonParser, deserializationContext, castToCollection(valueInstantiator.createUsingDefault(deserializationContext)));
    }
}
