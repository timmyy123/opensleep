package com.fasterxml.jackson.databind;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.DatatypeFeature;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.MissingInjectableValueExcepion;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeserializationContext extends DatabindContext implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient ArrayBuilders _arrayBuilders;
    protected transient ContextAttributes _attributes;
    protected final DeserializerCache _cache;
    protected final DeserializationConfig _config;
    protected LinkedNode<JavaType> _currentType;
    protected transient DateFormat _dateFormat;
    protected final DeserializerFactory _factory;
    protected final int _featureFlags;
    protected final InjectableValues _injectableValues;
    protected transient ObjectBuffer _objectBuffer;
    protected transient JsonParser _parser;
    protected final JacksonFeatureSet<StreamReadCapability> _readCapabilities;
    protected final Class<?> _view;

    public DeserializationContext(DeserializationContext deserializationContext, DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
        this._cache = deserializationContext._cache;
        this._factory = deserializationContext._factory;
        this._readCapabilities = jsonParser == null ? null : jsonParser.getReadCapabilities();
        this._config = deserializationConfig;
        this._featureFlags = deserializationConfig.getDeserializationFeatures();
        this._view = deserializationConfig.getActiveView();
        this._parser = jsonParser;
        this._injectableValues = injectableValues;
        this._attributes = deserializationConfig.getAttributes();
    }

    private Object _readValue(JsonParser jsonParser, JsonDeserializer<Object> jsonDeserializer) {
        return jsonParser.hasToken(JsonToken.VALUE_NULL) ? jsonDeserializer.getNullValue(this) : jsonDeserializer.deserialize(jsonParser, this);
    }

    public DateFormat _getDateFormat() {
        DateFormat dateFormat = this._dateFormat;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this._config.getDateFormat().clone();
        this._dateFormat = dateFormat2;
        return dateFormat2;
    }

    public String _shapeForToken(JsonToken jsonToken) {
        return JsonToken.valueDescFor(jsonToken);
    }

    public TokenBuffer bufferAsCopyOfValue(JsonParser jsonParser) {
        TokenBuffer tokenBufferBufferForInputBuffering = bufferForInputBuffering(jsonParser);
        tokenBufferBufferForInputBuffering.copyCurrentStructure(jsonParser);
        return tokenBufferBufferForInputBuffering;
    }

    public final TokenBuffer bufferForInputBuffering() {
        return bufferForInputBuffering(getParser());
    }

    public final boolean canOverrideAccessModifiers() {
        return this._config.canOverrideAccessModifiers();
    }

    public Calendar constructCalendar(Date date) {
        Calendar calendar = Calendar.getInstance(getTimeZone());
        calendar.setTime(date);
        return calendar;
    }

    public JavaType constructSpecializedType(JavaType javaType, Class<?> cls) {
        return javaType.hasRawClass(cls) ? javaType : getConfig().getTypeFactory().constructSpecializedType(javaType, cls, false);
    }

    public final JavaType constructType(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return this._config.constructType(cls);
    }

    public abstract JsonDeserializer<Object> deserializerInstance(Annotated annotated, Object obj);

    public String extractScalarFromObject(JsonParser jsonParser, JsonDeserializer<?> jsonDeserializer, Class<?> cls) {
        return null;
    }

    public Class<?> findClass(String str) {
        return getTypeFactory().findClass(str);
    }

    public CoercionAction findCoercionAction(LogicalType logicalType, Class<?> cls, CoercionInputShape coercionInputShape) {
        return this._config.findCoercionAction(logicalType, cls, coercionInputShape);
    }

    public CoercionAction findCoercionFromBlankString(LogicalType logicalType, Class<?> cls, CoercionAction coercionAction) {
        return this._config.findCoercionFromBlankString(logicalType, cls, coercionAction);
    }

    public final JsonDeserializer<Object> findContextualValueDeserializer(JavaType javaType, BeanProperty beanProperty) {
        JsonDeserializer<Object> jsonDeserializerFindValueDeserializer = this._cache.findValueDeserializer(this, this._factory, javaType);
        return jsonDeserializerFindValueDeserializer != null ? handleSecondaryContextualization(jsonDeserializerFindValueDeserializer, beanProperty, javaType) : jsonDeserializerFindValueDeserializer;
    }

    public final Object findInjectableValue(Object obj, BeanProperty beanProperty, Object obj2, Boolean bool, Boolean bool2) {
        InjectableValues injectableValuesEmpty = this._injectableValues;
        if (injectableValuesEmpty == null) {
            injectableValuesEmpty = InjectableValues.empty();
        }
        return injectableValuesEmpty.findInjectableValue(this, obj, beanProperty, obj2, bool, bool2);
    }

    public final KeyDeserializer findKeyDeserializer(JavaType javaType, BeanProperty beanProperty) throws InvalidDefinitionException {
        try {
            return this._cache.findKeyDeserializer(this, this._factory, javaType);
        } catch (IllegalArgumentException e) {
            this.reportBadDefinition(javaType, ClassUtil.exceptionMessage(e));
            return null;
        }
    }

    public final JsonDeserializer<Object> findNonContextualValueDeserializer(JavaType javaType) {
        return this._cache.findValueDeserializer(this, this._factory, javaType);
    }

    public abstract ReadableObjectId findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator, ObjectIdResolver objectIdResolver);

    public final JsonDeserializer<Object> findRootValueDeserializer(JavaType javaType) {
        JsonDeserializer<Object> jsonDeserializerFindValueDeserializer = this._cache.findValueDeserializer(this, this._factory, javaType);
        if (jsonDeserializerFindValueDeserializer == null) {
            return null;
        }
        JsonDeserializer<?> jsonDeserializerHandleSecondaryContextualization = handleSecondaryContextualization(jsonDeserializerFindValueDeserializer, null, javaType);
        TypeDeserializer typeDeserializerFindTypeDeserializer = this._factory.findTypeDeserializer(this._config, javaType);
        return typeDeserializerFindTypeDeserializer != null ? new TypeWrappedDeserializer(typeDeserializerFindTypeDeserializer.forProperty(null), jsonDeserializerHandleSecondaryContextualization) : jsonDeserializerHandleSecondaryContextualization;
    }

    public final Class<?> getActiveView() {
        return this._view;
    }

    public final AnnotationIntrospector getAnnotationIntrospector() {
        return this._config.getAnnotationIntrospector();
    }

    public final ArrayBuilders getArrayBuilders() {
        if (this._arrayBuilders == null) {
            this._arrayBuilders = new ArrayBuilders();
        }
        return this._arrayBuilders;
    }

    public final Base64Variant getBase64Variant() {
        return this._config.getBase64Variant();
    }

    public final DatatypeFeatures getDatatypeFeatures() {
        return this._config.getDatatypeFeatures();
    }

    public final JsonFormat.Value getDefaultPropertyFormat(Class<?> cls) {
        return this._config.getDefaultPropertyFormat(cls);
    }

    public final int getDeserializationFeatures() {
        return this._featureFlags;
    }

    public Locale getLocale() {
        return this._config.getLocale();
    }

    public final JsonNodeFactory getNodeFactory() {
        return this._config.getNodeFactory();
    }

    public final JsonParser getParser() {
        return this._parser;
    }

    public TimeZone getTimeZone() {
        return this._config.getTimeZone();
    }

    @Override // com.fasterxml.jackson.databind.DatabindContext
    public final TypeFactory getTypeFactory() {
        return this._config.getTypeFactory();
    }

    public void handleBadMerge(JsonDeserializer<?> jsonDeserializer) throws InvalidDefinitionException {
        if (isEnabled(MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE)) {
            return;
        }
        JavaType javaTypeConstructType = constructType(jsonDeserializer.handledType());
        throw InvalidDefinitionException.from(getParser(), FileInsert$$ExternalSyntheticOutline0.m("Invalid configuration: values of type ", ClassUtil.getTypeDescription(javaTypeConstructType), " cannot be merged"), javaTypeConstructType);
    }

    public Object handleInstantiationProblem(Class<?> cls, Object obj, Throwable th) throws IOException {
        LinkedNode<Object> problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers != null) {
            problemHandlers.value().getClass();
            throw new ClassCastException();
        }
        ClassUtil.throwIfIOE(th);
        if (!isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) {
            ClassUtil.throwIfRTE(th);
        }
        throw instantiationException(cls, th);
    }

    public Object handleMissingInstantiator(Class<?> cls, ValueInstantiator valueInstantiator, JsonParser jsonParser, String str, Object... objArr) {
        if (jsonParser == null) {
            getParser();
        }
        String str_format = _format(str, objArr);
        LinkedNode<Object> problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            return valueInstantiator == null ? reportBadDefinition(cls, Fragment$$ExternalSyntheticOutline1.m("Cannot construct instance of ", ClassUtil.nameOf(cls), ": ", str_format)) : !valueInstantiator.canInstantiate() ? reportBadDefinition(cls, Fragment$$ExternalSyntheticOutline1.m("Cannot construct instance of ", ClassUtil.nameOf(cls), " (no Creators, like default constructor, exist): ", str_format)) : reportInputMismatch(cls, Fragment$$ExternalSyntheticOutline1.m("Cannot construct instance of ", ClassUtil.nameOf(cls), " (although at least one Creator exists): ", str_format), new Object[0]);
        }
        problemHandlers.value().getClass();
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public JavaType handleMissingTypeId(JavaType javaType, TypeIdResolver typeIdResolver, String str) throws JsonMappingException {
        LinkedNode<Object> problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            throw missingTypeIdException(javaType, str);
        }
        problemHandlers.value().getClass();
        throw new ClassCastException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsonDeserializer<?> handlePrimaryContextualization(JsonDeserializer<?> jsonDeserializer, BeanProperty beanProperty, JavaType javaType) {
        if (!(jsonDeserializer instanceof ContextualDeserializer)) {
            return jsonDeserializer;
        }
        this._currentType = new LinkedNode<>(javaType, this._currentType);
        try {
            return ((ContextualDeserializer) jsonDeserializer).createContextual(this, beanProperty);
        } finally {
            this._currentType = this._currentType.next();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsonDeserializer<?> handleSecondaryContextualization(JsonDeserializer<?> jsonDeserializer, BeanProperty beanProperty, JavaType javaType) {
        if (!(jsonDeserializer instanceof ContextualDeserializer)) {
            return jsonDeserializer;
        }
        this._currentType = new LinkedNode<>(javaType, this._currentType);
        try {
            return ((ContextualDeserializer) jsonDeserializer).createContextual(this, beanProperty);
        } finally {
            this._currentType = this._currentType.next();
        }
    }

    public Object handleUnexpectedToken(JavaType javaType, JsonToken jsonToken, JsonParser jsonParser, String str, Object... objArr) throws MismatchedInputException {
        String str_format = _format(str, objArr);
        LinkedNode<Object> problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers != null) {
            problemHandlers.value().getClass();
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        if (str_format == null) {
            String typeDescription = ClassUtil.getTypeDescription(javaType);
            if (jsonToken == null) {
                str_format = FileInsert$$ExternalSyntheticOutline0.m("Unexpected end-of-input when trying read value of type ", typeDescription);
            } else {
                StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Cannot deserialize value of type ", typeDescription, " from ", _shapeForToken(jsonToken), " (token `JsonToken.");
                sbM6m.append(jsonToken);
                sbM6m.append("`)");
                str_format = sbM6m.toString();
            }
        }
        if (jsonToken != null && jsonToken.isScalarValue()) {
            jsonParser.getText();
        }
        reportInputMismatch(javaType, str_format, new Object[0]);
        return null;
    }

    public boolean handleUnknownProperty(JsonParser jsonParser, JsonDeserializer<?> jsonDeserializer, Object obj, String str) throws UnrecognizedPropertyException {
        LinkedNode<Object> problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers != null) {
            problemHandlers.value().getClass();
            Events$$ExternalSyntheticBUOutline0.m();
            return false;
        }
        if (isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
            throw UnrecognizedPropertyException.from(this._parser, obj, str, jsonDeserializer == null ? null : jsonDeserializer.getKnownPropertyNames());
        }
        jsonParser.skipChildren();
        return true;
    }

    public JavaType handleUnknownTypeId(JavaType javaType, String str, TypeIdResolver typeIdResolver, String str2) throws JsonMappingException {
        LinkedNode<Object> problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            if (isEnabled(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
                throw invalidTypeIdException(javaType, str, str2);
            }
            return null;
        }
        problemHandlers.value().getClass();
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public Object handleWeirdKey(Class<?> cls, String str, String str2, Object... objArr) throws JsonMappingException {
        String str_format = _format(str2, objArr);
        LinkedNode<Object> problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            throw weirdKeyException(cls, str, str_format);
        }
        problemHandlers.value().getClass();
        throw new ClassCastException();
    }

    public Object handleWeirdNativeValue(JavaType javaType, Object obj, JsonParser jsonParser) throws JsonMappingException {
        LinkedNode<Object> problemHandlers = this._config.getProblemHandlers();
        Class<?> rawClass = javaType.getRawClass();
        if (problemHandlers == null) {
            throw weirdNativeValueException(obj, rawClass);
        }
        problemHandlers.value().getClass();
        throw new ClassCastException();
    }

    public Object handleWeirdNumberValue(Class<?> cls, Number number, String str, Object... objArr) throws JsonMappingException {
        String str_format = _format(str, objArr);
        LinkedNode<Object> problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            throw weirdNumberException(number, cls, str_format);
        }
        problemHandlers.value().getClass();
        throw new ClassCastException();
    }

    public Object handleWeirdStringValue(Class<?> cls, String str, String str2, Object... objArr) throws JsonMappingException {
        String str_format = _format(str2, objArr);
        LinkedNode<Object> problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            throw weirdStringException(str, cls, str_format);
        }
        problemHandlers.value().getClass();
        throw new ClassCastException();
    }

    public final boolean hasSomeOfFeatures(int i) {
        return (this._featureFlags & i) != 0;
    }

    public JsonMappingException instantiationException(Class<?> cls, Throwable th) {
        String strExceptionMessage;
        if (th == null) {
            strExceptionMessage = "N/A";
        } else {
            strExceptionMessage = ClassUtil.exceptionMessage(th);
            if (strExceptionMessage == null) {
                strExceptionMessage = ClassUtil.nameOf(th.getClass());
            }
        }
        return ValueInstantiationException.from(this._parser, Fragment$$ExternalSyntheticOutline1.m("Cannot construct instance of ", ClassUtil.nameOf(cls), ", problem: ", strExceptionMessage), constructType(cls), th);
    }

    @Override // com.fasterxml.jackson.databind.DatabindContext
    public JsonMappingException invalidTypeIdException(JavaType javaType, String str, String str2) {
        return InvalidTypeIdException.from(this._parser, _colonConcat(Fragment$$ExternalSyntheticOutline1.m("Could not resolve type id '", str, "' as a subtype of ", ClassUtil.getTypeDescription(javaType)), str2), javaType, str);
    }

    public final boolean isEnabled(DeserializationFeature deserializationFeature) {
        return (this._featureFlags & deserializationFeature.getMask()) != 0;
    }

    public abstract KeyDeserializer keyDeserializerInstance(Annotated annotated, Object obj);

    public final ObjectBuffer leaseObjectBuffer() {
        ObjectBuffer objectBuffer = this._objectBuffer;
        if (objectBuffer == null) {
            return new ObjectBuffer();
        }
        this._objectBuffer = null;
        return objectBuffer;
    }

    public JsonMappingException missingInjectableValueException(String str, Object obj, BeanProperty beanProperty, Object obj2) {
        return MissingInjectableValueExcepion.from(this._parser, str, obj, beanProperty, obj2);
    }

    public JsonMappingException missingTypeIdException(JavaType javaType, String str) {
        return InvalidTypeIdException.from(this._parser, _colonConcat(String.format("Could not resolve subtype of %s", javaType), str), javaType, null);
    }

    public Date parseDate(String str) {
        try {
            return _getDateFormat().parse(str);
        } catch (ParseException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m("Failed to parse Date value '", str, "': ", ClassUtil.exceptionMessage(e)));
            return null;
        }
    }

    public <T> T readValue(JsonParser jsonParser, JavaType javaType) {
        JsonDeserializer<Object> jsonDeserializerFindRootValueDeserializer = findRootValueDeserializer(javaType);
        if (jsonDeserializerFindRootValueDeserializer != null) {
            return (T) _readValue(jsonParser, jsonDeserializerFindRootValueDeserializer);
        }
        return (T) reportBadDefinition(javaType, "Could not find JsonDeserializer for type " + ClassUtil.getTypeDescription(javaType));
    }

    public <T> T reportBadCoercion(JsonDeserializer<?> jsonDeserializer, Class<?> cls, Object obj, String str, Object... objArr) throws InvalidFormatException {
        throw InvalidFormatException.from(getParser(), _format(str, objArr), obj, cls);
    }

    @Override // com.fasterxml.jackson.databind.DatabindContext
    public <T> T reportBadDefinition(JavaType javaType, String str) throws InvalidDefinitionException {
        throw InvalidDefinitionException.from(this._parser, str, javaType);
    }

    public <T> T reportBadPropertyDefinition(BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition, String str, Object... objArr) throws InvalidDefinitionException {
        String str_format = _format(str, objArr);
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Invalid definition for property ", ClassUtil.nameOf(beanPropertyDefinition), " (of type ", ClassUtil.nameOf(beanDescription.getBeanClass()), "): ");
        sbM6m.append(str_format);
        throw InvalidDefinitionException.from(this._parser, sbM6m.toString(), beanDescription, beanPropertyDefinition);
    }

    public <T> T reportBadTypeDefinition(BeanDescription beanDescription, String str, Object... objArr) throws InvalidDefinitionException {
        throw InvalidDefinitionException.from(this._parser, Fragment$$ExternalSyntheticOutline1.m("Invalid type definition for type ", ClassUtil.nameOf(beanDescription.getBeanClass()), ": ", _format(str, objArr)), beanDescription, (BeanPropertyDefinition) null);
    }

    public <T> T reportInputMismatch(BeanProperty beanProperty, String str, Object... objArr) throws MismatchedInputException {
        AnnotatedMember member;
        MismatchedInputException mismatchedInputExceptionFrom = MismatchedInputException.from(getParser(), beanProperty == null ? null : beanProperty.getType(), _format(str, objArr));
        if (beanProperty == null || (member = beanProperty.getMember()) == null) {
            throw mismatchedInputExceptionFrom;
        }
        mismatchedInputExceptionFrom.prependPath(member.getDeclaringClass(), beanProperty.getName());
        throw mismatchedInputExceptionFrom;
    }

    public <T> T reportPropertyInputMismatch(Class<?> cls, String str, String str2, Object... objArr) throws MismatchedInputException {
        MismatchedInputException mismatchedInputExceptionFrom = MismatchedInputException.from(getParser(), cls, _format(str2, objArr));
        if (str == null) {
            throw mismatchedInputExceptionFrom;
        }
        mismatchedInputExceptionFrom.prependPath(cls, str);
        throw mismatchedInputExceptionFrom;
    }

    public <T> T reportTrailingTokens(Class<?> cls, JsonParser jsonParser, JsonToken jsonToken) {
        throw MismatchedInputException.from(jsonParser, cls, "Trailing token (of type " + jsonToken + ") found after value (bound as " + ClassUtil.nameOf(cls) + "): not allowed as per `DeserializationFeature.FAIL_ON_TRAILING_TOKENS`");
    }

    public <T> T reportUnresolvedObjectId(ObjectIdReader objectIdReader, Object obj) {
        return (T) reportInputMismatch(objectIdReader.idProperty, String.format("No Object Id found for an instance of %s, to assign to property '%s'", ClassUtil.classNameOf(obj), objectIdReader.propertyName), new Object[0]);
    }

    public void reportWrongTokenException(JsonDeserializer<?> jsonDeserializer, JsonToken jsonToken, String str, Object... objArr) throws JsonMappingException {
        throw wrongTokenException(getParser(), jsonDeserializer.handledType(), jsonToken, _format(str, objArr));
    }

    public final void returnObjectBuffer(ObjectBuffer objectBuffer) {
        if (this._objectBuffer == null || objectBuffer.initialCapacity() >= this._objectBuffer.initialCapacity()) {
            this._objectBuffer = objectBuffer;
        }
    }

    public JsonMappingException weirdKeyException(Class<?> cls, String str, String str2) {
        JsonParser jsonParser = this._parser;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Cannot deserialize Map key of type ", ClassUtil.nameOf(cls), " from String ", _quotedString(str), ": ");
        sbM6m.append(str2);
        return InvalidFormatException.from(jsonParser, sbM6m.toString(), str, cls);
    }

    public JsonMappingException weirdNativeValueException(Object obj, Class<?> cls) {
        return InvalidFormatException.from(this._parser, FileInsert$$ExternalSyntheticOutline0.m("Cannot deserialize value of type ", ClassUtil.nameOf(cls), " from native value (`JsonToken.VALUE_EMBEDDED_OBJECT`) of type ", ClassUtil.classNameOf(obj), ": incompatible types"), obj, cls);
    }

    public JsonMappingException weirdNumberException(Number number, Class<?> cls, String str) {
        JsonParser jsonParser = this._parser;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Cannot deserialize value of type ", ClassUtil.nameOf(cls), " from number ", String.valueOf(number), ": ");
        sbM6m.append(str);
        return InvalidFormatException.from(jsonParser, sbM6m.toString(), number, cls);
    }

    public JsonMappingException weirdStringException(String str, Class<?> cls, String str2) {
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Cannot deserialize value of type ", ClassUtil.nameOf(cls), " from String ", _quotedString(str), ": ");
        sbM6m.append(str2);
        return InvalidFormatException.from(this._parser, sbM6m.toString(), str, cls);
    }

    public JsonMappingException wrongTokenException(JsonParser jsonParser, JavaType javaType, JsonToken jsonToken, String str) {
        return MismatchedInputException.from(jsonParser, javaType, _colonConcat("Unexpected token (" + jsonParser.currentToken() + "), expected " + jsonToken, str));
    }

    @Override // com.fasterxml.jackson.databind.DatabindContext
    public DeserializationConfig getConfig() {
        return this._config;
    }

    public TokenBuffer bufferForInputBuffering(JsonParser jsonParser) {
        return new TokenBuffer(jsonParser, this);
    }

    public final boolean isEnabled(DatatypeFeature datatypeFeature) {
        return this._config.isEnabled(datatypeFeature);
    }

    public final boolean isEnabled(MapperFeature mapperFeature) {
        return this._config.isEnabled(mapperFeature);
    }

    public final boolean isEnabled(StreamReadCapability streamReadCapability) {
        return this._readCapabilities.isEnabled(streamReadCapability);
    }

    public void reportWrongTokenException(JavaType javaType, JsonToken jsonToken, String str, Object... objArr) throws JsonMappingException {
        throw wrongTokenException(getParser(), javaType, jsonToken, _format(str, objArr));
    }

    public <T> T reportPropertyInputMismatch(JavaType javaType, String str, String str2, Object... objArr) {
        return (T) reportPropertyInputMismatch(javaType.getRawClass(), str, str2, objArr);
    }

    public void reportWrongTokenException(Class<?> cls, JsonToken jsonToken, String str, Object... objArr) throws JsonMappingException {
        throw wrongTokenException(getParser(), cls, jsonToken, _format(str, objArr));
    }

    public <T> T readValue(JsonParser jsonParser, Class<T> cls) {
        return (T) readValue(jsonParser, getTypeFactory().constructType(cls));
    }

    public JsonMappingException wrongTokenException(JsonParser jsonParser, Class<?> cls, JsonToken jsonToken, String str) {
        return MismatchedInputException.from(jsonParser, cls, _colonConcat("Unexpected token (" + jsonParser.currentToken() + "), expected " + jsonToken, str));
    }

    public <T> T reportInputMismatch(Class<?> cls, String str, Object... objArr) throws MismatchedInputException {
        throw MismatchedInputException.from(getParser(), cls, _format(str, objArr));
    }

    public <T> T reportInputMismatch(JavaType javaType, String str, Object... objArr) throws MismatchedInputException {
        throw MismatchedInputException.from(getParser(), javaType, _format(str, objArr));
    }

    public <T> T reportInputMismatch(JsonDeserializer<?> jsonDeserializer, String str, Object... objArr) throws MismatchedInputException {
        throw MismatchedInputException.from(getParser(), jsonDeserializer.handledType(), _format(str, objArr));
    }

    public DeserializationContext(DeserializationContext deserializationContext, DeserializerFactory deserializerFactory) {
        this._cache = deserializationContext._cache;
        this._factory = deserializerFactory;
        this._config = deserializationContext._config;
        this._featureFlags = deserializationContext._featureFlags;
        this._readCapabilities = deserializationContext._readCapabilities;
        this._view = deserializationContext._view;
        this._parser = deserializationContext._parser;
        this._injectableValues = deserializationContext._injectableValues;
        this._attributes = deserializationContext._attributes;
    }

    public DeserializationContext(DeserializerFactory deserializerFactory, DeserializerCache deserializerCache) {
        Objects.requireNonNull(deserializerFactory);
        this._factory = deserializerFactory;
        this._cache = deserializerCache == null ? new DeserializerCache() : deserializerCache;
        this._featureFlags = 0;
        this._readCapabilities = null;
        this._config = null;
        this._injectableValues = null;
        this._view = null;
        this._attributes = null;
    }

    public DeserializationContext(DeserializationContext deserializationContext, DeserializationConfig deserializationConfig) {
        this._cache = deserializationContext._cache;
        this._factory = deserializationContext._factory;
        this._readCapabilities = null;
        this._config = deserializationConfig;
        this._featureFlags = deserializationConfig.getDeserializationFeatures();
        this._view = null;
        this._parser = null;
        this._injectableValues = null;
        this._attributes = null;
    }

    public Object handleUnexpectedToken(Class<?> cls, JsonToken jsonToken, JsonParser jsonParser, String str, Object... objArr) {
        return handleUnexpectedToken(constructType(cls), jsonToken, jsonParser, str, objArr);
    }

    public Object handleUnexpectedToken(JavaType javaType, JsonParser jsonParser) {
        return handleUnexpectedToken(javaType, jsonParser.currentToken(), jsonParser, (String) null, new Object[0]);
    }

    public Object handleUnexpectedToken(Class<?> cls, JsonParser jsonParser) {
        return handleUnexpectedToken(constructType(cls), jsonParser.currentToken(), jsonParser, (String) null, new Object[0]);
    }
}
