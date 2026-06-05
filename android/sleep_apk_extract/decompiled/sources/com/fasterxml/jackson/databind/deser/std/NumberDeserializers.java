package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NumberDeserializers {
    private static final HashSet<String> _classNames = new HashSet<>();

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.NumberDeserializers$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction;

        static {
            int[] iArr = new int[CoercionAction.values().length];
            $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction = iArr;
            try {
                iArr[CoercionAction.Fail.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[CoercionAction.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[CoercionAction.AsEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @JacksonStdImpl
    public static class BigDecimalDeserializer extends StdScalarDeserializer<BigDecimal> {
        public static final BigDecimalDeserializer instance = new BigDecimalDeserializer();

        public BigDecimalDeserializer() {
            super((Class<?>) BigDecimal.class);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
        
            if (r0 != 8) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
        
            if (r0 != null) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00aa, code lost:
        
            return (java.math.BigDecimal) r5.handleUnexpectedToken(getValueType(r5), r4);
         */
        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws StreamConstraintsException {
            String strExtractScalarFromObject;
            int iCurrentTokenId = jsonParser.currentTokenId();
            if (iCurrentTokenId != 1) {
                if (iCurrentTokenId == 3) {
                    return _deserializeFromArray(jsonParser, deserializationContext);
                }
                if (iCurrentTokenId != 6) {
                    if (iCurrentTokenId == 7) {
                        CoercionAction coercionAction_checkIntToFloatCoercion = _checkIntToFloatCoercion(jsonParser, deserializationContext, this._valueClass);
                        if (coercionAction_checkIntToFloatCoercion == CoercionAction.AsNull) {
                            return getNullValue(deserializationContext);
                        }
                        if (coercionAction_checkIntToFloatCoercion == CoercionAction.AsEmpty) {
                            return (BigDecimal) getEmptyValue(deserializationContext);
                        }
                    }
                    return jsonParser.getDecimalValue();
                }
                strExtractScalarFromObject = jsonParser.getText();
                CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject);
                if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
                    return getNullValue(deserializationContext);
                }
                if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
                    return (BigDecimal) getEmptyValue(deserializationContext);
                }
                String strTrim = strExtractScalarFromObject.trim();
                if (_hasTextualNull(strTrim)) {
                    return getNullValue(deserializationContext);
                }
                if (NumberInput.looksLikeValidNumber(strTrim)) {
                    jsonParser.streamReadConstraints().validateFPLength(strTrim.length());
                    try {
                        return NumberInput.parseBigDecimal(strTrim, jsonParser.isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
                    } catch (IllegalArgumentException unused) {
                    }
                }
                return (BigDecimal) deserializationContext.handleWeirdStringValue(this._valueClass, strTrim, "not a valid representation", new Object[0]);
            }
            strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext deserializationContext) {
            return BigDecimal.ZERO;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public final LogicalType logicalType() {
            return LogicalType.Float;
        }
    }

    @JacksonStdImpl
    public static class BigIntegerDeserializer extends StdScalarDeserializer<BigInteger> {
        public static final BigIntegerDeserializer instance = new BigIntegerDeserializer();

        public BigIntegerDeserializer() {
            super((Class<?>) BigInteger.class);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
        
            if (r0 != null) goto L30;
         */
        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BigInteger deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws StreamConstraintsException {
            String strExtractScalarFromObject;
            if (jsonParser.isExpectedNumberIntToken()) {
                return jsonParser.getBigIntegerValue();
            }
            int iCurrentTokenId = jsonParser.currentTokenId();
            if (iCurrentTokenId != 1) {
                if (iCurrentTokenId == 3) {
                    return _deserializeFromArray(jsonParser, deserializationContext);
                }
                if (iCurrentTokenId != 6) {
                    if (iCurrentTokenId == 8) {
                        CoercionAction coercionAction_checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, this._valueClass);
                        if (coercionAction_checkFloatToIntCoercion == CoercionAction.AsNull) {
                            return getNullValue(deserializationContext);
                        }
                        if (coercionAction_checkFloatToIntCoercion == CoercionAction.AsEmpty) {
                            return (BigInteger) getEmptyValue(deserializationContext);
                        }
                        BigDecimal decimalValue = jsonParser.getDecimalValue();
                        jsonParser.streamReadConstraints().validateBigIntegerScale(decimalValue.scale());
                        return decimalValue.toBigInteger();
                    }
                    return (BigInteger) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                strExtractScalarFromObject = jsonParser.getText();
                CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject);
                if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
                    return getNullValue(deserializationContext);
                }
                if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
                    return (BigInteger) getEmptyValue(deserializationContext);
                }
                String strTrim = strExtractScalarFromObject.trim();
                if (_hasTextualNull(strTrim)) {
                    return getNullValue(deserializationContext);
                }
                if (_isIntNumber(strTrim)) {
                    jsonParser.streamReadConstraints().validateIntegerLength(strTrim.length());
                    try {
                        return NumberInput.parseBigInteger(strTrim, jsonParser.isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
                    } catch (IllegalArgumentException unused) {
                    }
                }
                return (BigInteger) deserializationContext.handleWeirdStringValue(this._valueClass, strTrim, "not a valid representation", new Object[0]);
            }
            strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext deserializationContext) {
            return BigInteger.ZERO;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public final LogicalType logicalType() {
            return LogicalType.Integer;
        }
    }

    @JacksonStdImpl
    public static final class BooleanDeserializer extends PrimitiveOrWrapperDeserializer<Boolean> {
        private static final long serialVersionUID = 1;
        static final BooleanDeserializer primitiveInstance = new BooleanDeserializer(Boolean.TYPE, Boolean.FALSE);
        static final BooleanDeserializer wrapperInstance = new BooleanDeserializer(Boolean.class, null);

        public BooleanDeserializer(Class<Boolean> cls, Boolean bool) {
            super(cls, LogicalType.Boolean, bool, Boolean.FALSE);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
            return jsonTokenCurrentToken == JsonToken.VALUE_TRUE ? Boolean.TRUE : jsonTokenCurrentToken == JsonToken.VALUE_FALSE ? Boolean.FALSE : this._primitive ? Boolean.valueOf(_parseBooleanPrimitive(jsonParser, deserializationContext)) : _parseBoolean(jsonParser, deserializationContext, this._valueClass);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public Boolean deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
            return jsonTokenCurrentToken == JsonToken.VALUE_TRUE ? Boolean.TRUE : jsonTokenCurrentToken == JsonToken.VALUE_FALSE ? Boolean.FALSE : this._primitive ? Boolean.valueOf(_parseBooleanPrimitive(jsonParser, deserializationContext)) : _parseBoolean(jsonParser, deserializationContext, this._valueClass);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    @JacksonStdImpl
    public static class ByteDeserializer extends PrimitiveOrWrapperDeserializer<Byte> {
        private static final long serialVersionUID = 1;
        static final ByteDeserializer primitiveInstance = new ByteDeserializer(Byte.TYPE, (byte) 0);
        static final ByteDeserializer wrapperInstance = new ByteDeserializer(Byte.class, null);

        public ByteDeserializer(Class<Byte> cls, Byte b) {
            super(cls, LogicalType.Integer, b, (byte) 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Byte _parseByte(JsonParser jsonParser, DeserializationContext deserializationContext) {
            String text;
            CoercionAction coercionAction_checkFromStringCoercion;
            int iCurrentTokenId = jsonParser.currentTokenId();
            if (iCurrentTokenId == 1) {
                String strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
                if (strExtractScalarFromObject != null) {
                    text = strExtractScalarFromObject;
                    coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, text);
                    if (coercionAction_checkFromStringCoercion != CoercionAction.AsNull) {
                    }
                }
                return (Byte) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
            }
            if (iCurrentTokenId == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            }
            if (iCurrentTokenId == 11) {
                return getNullValue(deserializationContext);
            }
            if (iCurrentTokenId != 6) {
                if (iCurrentTokenId == 7) {
                    return Byte.valueOf(jsonParser.getByteValue());
                }
                if (iCurrentTokenId == 8) {
                    CoercionAction coercionAction_checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, this._valueClass);
                    return coercionAction_checkFloatToIntCoercion == CoercionAction.AsNull ? getNullValue(deserializationContext) : coercionAction_checkFloatToIntCoercion == CoercionAction.AsEmpty ? (Byte) getEmptyValue(deserializationContext) : Byte.valueOf(jsonParser.getByteValue());
                }
                return (Byte) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
            }
            text = jsonParser.getText();
            coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, text);
            if (coercionAction_checkFromStringCoercion != CoercionAction.AsNull) {
                return getNullValue(deserializationContext);
            }
            if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
                return (Byte) getEmptyValue(deserializationContext);
            }
            String strTrim = text.trim();
            if (_checkTextualNull(deserializationContext, strTrim)) {
                return getNullValue(deserializationContext);
            }
            try {
                int i = NumberInput.parseInt(strTrim);
                return _byteOverflow(i) ? (Byte) deserializationContext.handleWeirdStringValue(this._valueClass, strTrim, "overflow, value cannot be represented as 8-bit value", new Object[0]) : Byte.valueOf((byte) i);
            } catch (IllegalArgumentException unused) {
                return (Byte) deserializationContext.handleWeirdStringValue(this._valueClass, strTrim, "not a valid Byte value", new Object[0]);
            }
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Byte deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return jsonParser.isExpectedNumberIntToken() ? Byte.valueOf(jsonParser.getByteValue()) : this._primitive ? Byte.valueOf(_parseBytePrimitive(jsonParser, deserializationContext)) : _parseByte(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    @JacksonStdImpl
    public static class CharacterDeserializer extends PrimitiveOrWrapperDeserializer<Character> {
        private static final long serialVersionUID = 1;
        static final CharacterDeserializer primitiveInstance = new CharacterDeserializer(Character.TYPE, 0);
        static final CharacterDeserializer wrapperInstance = new CharacterDeserializer(Character.class, null);

        public CharacterDeserializer(Class<Character> cls, Character ch) {
            super(cls, LogicalType.Integer, ch, (char) 0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x00b3, code lost:
        
            if (r12 != null) goto L42;
         */
        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Character deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            CharacterDeserializer characterDeserializer;
            DeserializationContext deserializationContext2;
            String strExtractScalarFromObject;
            CharacterDeserializer characterDeserializer2;
            DeserializationContext deserializationContext3;
            int iCurrentTokenId = jsonParser.currentTokenId();
            if (iCurrentTokenId != 1) {
                if (iCurrentTokenId == 3) {
                    return _deserializeFromArray(jsonParser, deserializationContext);
                }
                if (iCurrentTokenId == 11) {
                    if (this._primitive) {
                        _verifyNullForPrimitive(deserializationContext);
                    }
                    return getNullValue(deserializationContext);
                }
                if (iCurrentTokenId == 6) {
                    characterDeserializer = this;
                    deserializationContext2 = deserializationContext;
                    strExtractScalarFromObject = jsonParser.getText();
                    if (strExtractScalarFromObject.length() == 1) {
                        return Character.valueOf(strExtractScalarFromObject.charAt(0));
                    }
                    CoercionAction coercionAction_checkFromStringCoercion = characterDeserializer._checkFromStringCoercion(deserializationContext2, strExtractScalarFromObject);
                    if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
                        return characterDeserializer.getNullValue(deserializationContext2);
                    }
                    if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
                        return (Character) characterDeserializer.getEmptyValue(deserializationContext2);
                    }
                    String strTrim = strExtractScalarFromObject.trim();
                    return characterDeserializer._checkTextualNull(deserializationContext2, strTrim) ? characterDeserializer.getNullValue(deserializationContext2) : (Character) deserializationContext2.handleWeirdStringValue(characterDeserializer.handledType(), strTrim, "Expected either Integer value code or 1-character String", new Object[0]);
                }
                if (iCurrentTokenId != 7) {
                    characterDeserializer = this;
                    deserializationContext2 = deserializationContext;
                    return (Character) deserializationContext2.handleUnexpectedToken(characterDeserializer.getValueType(deserializationContext2), jsonParser);
                }
                CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType(), this._valueClass, CoercionInputShape.Integer);
                int i = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[coercionActionFindCoercionAction.ordinal()];
                if (i == 1) {
                    characterDeserializer2 = this;
                    deserializationContext3 = deserializationContext;
                    characterDeserializer2._checkCoercionFail(deserializationContext3, coercionActionFindCoercionAction, this._valueClass, jsonParser.getNumberValue(), "Integer value (" + jsonParser.getText() + ")");
                } else {
                    if (i != 2) {
                        if (i == 3) {
                            return (Character) getEmptyValue(deserializationContext);
                        }
                        int intValue = jsonParser.getIntValue();
                        return (intValue < 0 || intValue > 65535) ? (Character) deserializationContext.handleWeirdNumberValue(handledType(), Integer.valueOf(intValue), "value outside valid Character range (0x0000 - 0xFFFF)", new Object[0]) : Character.valueOf((char) intValue);
                    }
                    characterDeserializer2 = this;
                    deserializationContext3 = deserializationContext;
                }
                return characterDeserializer2.getNullValue(deserializationContext3);
            }
            characterDeserializer = this;
            deserializationContext2 = deserializationContext;
            strExtractScalarFromObject = deserializationContext2.extractScalarFromObject(jsonParser, characterDeserializer, characterDeserializer._valueClass);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    @JacksonStdImpl
    public static class DoubleDeserializer extends PrimitiveOrWrapperDeserializer<Double> {
        private static final long serialVersionUID = 1;
        static final DoubleDeserializer primitiveInstance = new DoubleDeserializer(Double.TYPE, Double.valueOf(0.0d));
        static final DoubleDeserializer wrapperInstance = new DoubleDeserializer(Double.class, null);

        public DoubleDeserializer(Class<Double> cls, Double d) {
            super(cls, LogicalType.Float, d, Double.valueOf(0.0d));
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0016, code lost:
        
            if (r0 != 8) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        
            if (r0 != null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00c4, code lost:
        
            return (java.lang.Double) r5.handleUnexpectedToken(getValueType(r5), r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Double _parseDouble(JsonParser jsonParser, DeserializationContext deserializationContext) throws StreamConstraintsException {
            String strExtractScalarFromObject;
            int iCurrentTokenId = jsonParser.currentTokenId();
            if (iCurrentTokenId != 1) {
                if (iCurrentTokenId == 3) {
                    return _deserializeFromArray(jsonParser, deserializationContext);
                }
                if (iCurrentTokenId == 11) {
                    return getNullValue(deserializationContext);
                }
                if (iCurrentTokenId != 6) {
                    if (iCurrentTokenId == 7) {
                        CoercionAction coercionAction_checkIntToFloatCoercion = _checkIntToFloatCoercion(jsonParser, deserializationContext, this._valueClass);
                        if (coercionAction_checkIntToFloatCoercion == CoercionAction.AsNull) {
                            return getNullValue(deserializationContext);
                        }
                        if (coercionAction_checkIntToFloatCoercion == CoercionAction.AsEmpty) {
                            return (Double) getEmptyValue(deserializationContext);
                        }
                    }
                    return Double.valueOf(jsonParser.getDoubleValue());
                }
                strExtractScalarFromObject = jsonParser.getText();
                Double d_checkDoubleSpecialValue = _checkDoubleSpecialValue(strExtractScalarFromObject);
                if (d_checkDoubleSpecialValue != null) {
                    return d_checkDoubleSpecialValue;
                }
                CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject);
                if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
                    return getNullValue(deserializationContext);
                }
                if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
                    return (Double) getEmptyValue(deserializationContext);
                }
                String strTrim = strExtractScalarFromObject.trim();
                if (_checkTextualNull(deserializationContext, strTrim)) {
                    return getNullValue(deserializationContext);
                }
                if (NumberInput.looksLikeValidNumber(strTrim)) {
                    jsonParser.streamReadConstraints().validateFPLength(strTrim.length());
                    try {
                        return Double.valueOf(StdDeserializer._parseDouble(strTrim, jsonParser.isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER)));
                    } catch (IllegalArgumentException unused) {
                    }
                }
                return (Double) deserializationContext.handleWeirdStringValue(this._valueClass, strTrim, "not a valid `Double` value", new Object[0]);
            }
            strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return jsonParser.hasToken(JsonToken.VALUE_NUMBER_FLOAT) ? Double.valueOf(jsonParser.getDoubleValue()) : this._primitive ? Double.valueOf(_parseDoublePrimitive(jsonParser, deserializationContext)) : _parseDouble(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public Double deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            return jsonParser.hasToken(JsonToken.VALUE_NUMBER_FLOAT) ? Double.valueOf(jsonParser.getDoubleValue()) : this._primitive ? Double.valueOf(_parseDoublePrimitive(jsonParser, deserializationContext)) : _parseDouble(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    @JacksonStdImpl
    public static class FloatDeserializer extends PrimitiveOrWrapperDeserializer<Float> {
        private static final long serialVersionUID = 1;
        static final FloatDeserializer primitiveInstance = new FloatDeserializer(Float.TYPE, Float.valueOf(0.0f));
        static final FloatDeserializer wrapperInstance = new FloatDeserializer(Float.class, null);

        public FloatDeserializer(Class<Float> cls, Float f) {
            super(cls, LogicalType.Float, f, Float.valueOf(0.0f));
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0016, code lost:
        
            if (r0 != 8) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        
            if (r0 != null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00c4, code lost:
        
            return (java.lang.Float) r5.handleUnexpectedToken(getValueType(r5), r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Float _parseFloat(JsonParser jsonParser, DeserializationContext deserializationContext) throws StreamConstraintsException {
            String strExtractScalarFromObject;
            int iCurrentTokenId = jsonParser.currentTokenId();
            if (iCurrentTokenId != 1) {
                if (iCurrentTokenId == 3) {
                    return _deserializeFromArray(jsonParser, deserializationContext);
                }
                if (iCurrentTokenId == 11) {
                    return getNullValue(deserializationContext);
                }
                if (iCurrentTokenId != 6) {
                    if (iCurrentTokenId == 7) {
                        CoercionAction coercionAction_checkIntToFloatCoercion = _checkIntToFloatCoercion(jsonParser, deserializationContext, this._valueClass);
                        if (coercionAction_checkIntToFloatCoercion == CoercionAction.AsNull) {
                            return getNullValue(deserializationContext);
                        }
                        if (coercionAction_checkIntToFloatCoercion == CoercionAction.AsEmpty) {
                            return (Float) getEmptyValue(deserializationContext);
                        }
                    }
                    return Float.valueOf(jsonParser.getFloatValue());
                }
                strExtractScalarFromObject = jsonParser.getText();
                Float f_checkFloatSpecialValue = _checkFloatSpecialValue(strExtractScalarFromObject);
                if (f_checkFloatSpecialValue != null) {
                    return f_checkFloatSpecialValue;
                }
                CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject);
                if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
                    return getNullValue(deserializationContext);
                }
                if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
                    return (Float) getEmptyValue(deserializationContext);
                }
                String strTrim = strExtractScalarFromObject.trim();
                if (_checkTextualNull(deserializationContext, strTrim)) {
                    return getNullValue(deserializationContext);
                }
                if (NumberInput.looksLikeValidNumber(strTrim)) {
                    jsonParser.streamReadConstraints().validateFPLength(strTrim.length());
                    try {
                        return Float.valueOf(NumberInput.parseFloat(strTrim, jsonParser.isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER)));
                    } catch (IllegalArgumentException unused) {
                    }
                }
                return (Float) deserializationContext.handleWeirdStringValue(this._valueClass, strTrim, "not a valid `Float` value", new Object[0]);
            }
            strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Float deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return jsonParser.hasToken(JsonToken.VALUE_NUMBER_FLOAT) ? Float.valueOf(jsonParser.getFloatValue()) : this._primitive ? Float.valueOf(_parseFloatPrimitive(jsonParser, deserializationContext)) : _parseFloat(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    @JacksonStdImpl
    public static final class IntegerDeserializer extends PrimitiveOrWrapperDeserializer<Integer> {
        private static final long serialVersionUID = 1;
        static final IntegerDeserializer primitiveInstance = new IntegerDeserializer(Integer.TYPE, 0);
        static final IntegerDeserializer wrapperInstance = new IntegerDeserializer(Integer.class, null);

        public IntegerDeserializer(Class<Integer> cls, Integer num) {
            super(cls, LogicalType.Integer, num, 0);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return jsonParser.isExpectedNumberIntToken() ? Integer.valueOf(jsonParser.getIntValue()) : this._primitive ? Integer.valueOf(_parseIntPrimitive(jsonParser, deserializationContext)) : _parseInteger(jsonParser, deserializationContext, Integer.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public Integer deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            return jsonParser.isExpectedNumberIntToken() ? Integer.valueOf(jsonParser.getIntValue()) : this._primitive ? Integer.valueOf(_parseIntPrimitive(jsonParser, deserializationContext)) : _parseInteger(jsonParser, deserializationContext, Integer.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public boolean isCachable() {
            return true;
        }
    }

    @JacksonStdImpl
    public static final class LongDeserializer extends PrimitiveOrWrapperDeserializer<Long> {
        private static final long serialVersionUID = 1;
        static final LongDeserializer primitiveInstance = new LongDeserializer(Long.TYPE, 0L);
        static final LongDeserializer wrapperInstance = new LongDeserializer(Long.class, null);

        public LongDeserializer(Class<Long> cls, Long l) {
            super(cls, LogicalType.Integer, l, 0L);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return jsonParser.isExpectedNumberIntToken() ? Long.valueOf(jsonParser.getLongValue()) : this._primitive ? Long.valueOf(_parseLongPrimitive(jsonParser, deserializationContext)) : _parseLong(jsonParser, deserializationContext, Long.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public boolean isCachable() {
            return true;
        }
    }

    @JacksonStdImpl
    public static class NumberDeserializer extends StdScalarDeserializer<Object> {
        public static final NumberDeserializer instance = new NumberDeserializer();

        public NumberDeserializer() {
            super((Class<?>) Number.class);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
        
            if (r0 != null) goto L32;
         */
        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws StreamConstraintsException {
            String strExtractScalarFromObject;
            int iCurrentTokenId = jsonParser.currentTokenId();
            if (iCurrentTokenId != 1) {
                if (iCurrentTokenId == 3) {
                    return _deserializeFromArray(jsonParser, deserializationContext);
                }
                if (iCurrentTokenId != 6) {
                    if (iCurrentTokenId == 7) {
                        return deserializationContext.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS) ? _coerceIntegral(jsonParser, deserializationContext) : jsonParser.getNumberValue();
                    }
                    if (iCurrentTokenId == 8) {
                        return (!deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) || jsonParser.isNaN()) ? jsonParser.getNumberValue() : jsonParser.getDecimalValue();
                    }
                    return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                strExtractScalarFromObject = jsonParser.getText();
                CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject);
                if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
                    return getNullValue(deserializationContext);
                }
                if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
                    return getEmptyValue(deserializationContext);
                }
                String strTrim = strExtractScalarFromObject.trim();
                if (_hasTextualNull(strTrim)) {
                    return getNullValue(deserializationContext);
                }
                if (_isPosInf(strTrim)) {
                    return Double.valueOf(Double.POSITIVE_INFINITY);
                }
                if (_isNegInf(strTrim)) {
                    return Double.valueOf(Double.NEGATIVE_INFINITY);
                }
                if (_isNaN(strTrim)) {
                    return Double.valueOf(Double.NaN);
                }
                if (!_isIntNumber(strTrim)) {
                    if (NumberInput.looksLikeValidNumber(strTrim)) {
                        jsonParser.streamReadConstraints().validateFPLength(strTrim.length());
                        return deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? NumberInput.parseBigDecimal(strTrim, jsonParser.isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER)) : Double.valueOf(NumberInput.parseDouble(strTrim, jsonParser.isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER)));
                    }
                    return deserializationContext.handleWeirdStringValue(this._valueClass, strTrim, "not a valid number", new Object[0]);
                }
                jsonParser.streamReadConstraints().validateIntegerLength(strTrim.length());
                if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                    return NumberInput.parseBigInteger(strTrim, jsonParser.isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
                }
                long j = NumberInput.parseLong(strTrim);
                return (deserializationContext.isEnabled(DeserializationFeature.USE_LONG_FOR_INTS) || j > 2147483647L || j < -2147483648L) ? Long.valueOf(j) : Integer.valueOf((int) j);
            }
            strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            int iCurrentTokenId = jsonParser.currentTokenId();
            return (iCurrentTokenId == 6 || iCurrentTokenId == 7 || iCurrentTokenId == 8) ? deserialize(jsonParser, deserializationContext) : typeDeserializer.deserializeTypedFromScalar(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public final LogicalType logicalType() {
            return LogicalType.Integer;
        }
    }

    public static abstract class PrimitiveOrWrapperDeserializer<T> extends StdScalarDeserializer<T> {
        private static final long serialVersionUID = 1;
        protected final T _emptyValue;
        protected final LogicalType _logicalType;
        protected final T _nullValue;
        protected final boolean _primitive;

        public PrimitiveOrWrapperDeserializer(Class<T> cls, LogicalType logicalType, T t, T t2) {
            super((Class<?>) cls);
            this._logicalType = logicalType;
            this._nullValue = t;
            this._emptyValue = t2;
            this._primitive = cls.isPrimitive();
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext deserializationContext) {
            return this._emptyValue;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public AccessPattern getNullAccessPattern() {
            return this._primitive ? AccessPattern.DYNAMIC : this._nullValue == null ? AccessPattern.ALWAYS_NULL : AccessPattern.CONSTANT;
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer, com.fasterxml.jackson.databind.deser.NullValueProvider
        public final T getNullValue(DeserializationContext deserializationContext) throws MismatchedInputException {
            if (this._primitive && deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
                deserializationContext.reportInputMismatch(this, "Cannot map `null` into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", ClassUtil.classNameOf(handledType()));
            }
            return this._nullValue;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public final LogicalType logicalType() {
            return this._logicalType;
        }
    }

    @JacksonStdImpl
    public static class ShortDeserializer extends PrimitiveOrWrapperDeserializer<Short> {
        private static final long serialVersionUID = 1;
        static final ShortDeserializer primitiveInstance = new ShortDeserializer(Short.TYPE, 0);
        static final ShortDeserializer wrapperInstance = new ShortDeserializer(Short.class, null);

        public ShortDeserializer(Class<Short> cls, Short sh) {
            super(cls, LogicalType.Integer, sh, (short) 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Short _parseShort(JsonParser jsonParser, DeserializationContext deserializationContext) {
            String text;
            CoercionAction coercionAction_checkFromStringCoercion;
            int iCurrentTokenId = jsonParser.currentTokenId();
            if (iCurrentTokenId == 1) {
                String strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
                if (strExtractScalarFromObject != null) {
                    text = strExtractScalarFromObject;
                    coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, text);
                    if (coercionAction_checkFromStringCoercion != CoercionAction.AsNull) {
                    }
                }
                return (Short) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
            }
            if (iCurrentTokenId == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            }
            if (iCurrentTokenId == 11) {
                return getNullValue(deserializationContext);
            }
            if (iCurrentTokenId != 6) {
                if (iCurrentTokenId == 7) {
                    return Short.valueOf(jsonParser.getShortValue());
                }
                if (iCurrentTokenId == 8) {
                    CoercionAction coercionAction_checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, this._valueClass);
                    return coercionAction_checkFloatToIntCoercion == CoercionAction.AsNull ? getNullValue(deserializationContext) : coercionAction_checkFloatToIntCoercion == CoercionAction.AsEmpty ? (Short) getEmptyValue(deserializationContext) : Short.valueOf(jsonParser.getShortValue());
                }
                return (Short) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
            }
            text = jsonParser.getText();
            coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, text);
            if (coercionAction_checkFromStringCoercion != CoercionAction.AsNull) {
                return getNullValue(deserializationContext);
            }
            if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
                return (Short) getEmptyValue(deserializationContext);
            }
            String strTrim = text.trim();
            if (_checkTextualNull(deserializationContext, strTrim)) {
                return getNullValue(deserializationContext);
            }
            try {
                int i = NumberInput.parseInt(strTrim);
                return _shortOverflow(i) ? (Short) deserializationContext.handleWeirdStringValue(this._valueClass, strTrim, "overflow, value cannot be represented as 16-bit value", new Object[0]) : Short.valueOf((short) i);
            } catch (IllegalArgumentException unused) {
                return (Short) deserializationContext.handleWeirdStringValue(this._valueClass, strTrim, "not a valid Short value", new Object[0]);
            }
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Short deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return jsonParser.isExpectedNumberIntToken() ? Short.valueOf(jsonParser.getShortValue()) : this._primitive ? Short.valueOf(_parseShortPrimitive(jsonParser, deserializationContext)) : _parseShort(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ Object getEmptyValue(DeserializationContext deserializationContext) {
            return super.getEmptyValue(deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ AccessPattern getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    static {
        Class[] clsArr = {Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class};
        for (int i = 0; i < 11; i++) {
            _classNames.add(clsArr[i].getName());
        }
    }

    public static JsonDeserializer<?> find(Class<?> cls, String str) {
        if (!cls.isPrimitive()) {
            if (_classNames.contains(str)) {
                if (cls == Integer.class) {
                    return IntegerDeserializer.wrapperInstance;
                }
                if (cls == Boolean.class) {
                    return BooleanDeserializer.wrapperInstance;
                }
                if (cls == Long.class) {
                    return LongDeserializer.wrapperInstance;
                }
                if (cls == Double.class) {
                    return DoubleDeserializer.wrapperInstance;
                }
                if (cls == Character.class) {
                    return CharacterDeserializer.wrapperInstance;
                }
                if (cls == Byte.class) {
                    return ByteDeserializer.wrapperInstance;
                }
                if (cls == Short.class) {
                    return ShortDeserializer.wrapperInstance;
                }
                if (cls == Float.class) {
                    return FloatDeserializer.wrapperInstance;
                }
                if (cls == Number.class) {
                    return NumberDeserializer.instance;
                }
                if (cls == BigDecimal.class) {
                    return BigDecimalDeserializer.instance;
                }
                if (cls == BigInteger.class) {
                    return BigIntegerDeserializer.instance;
                }
            }
            return null;
        }
        if (cls == Integer.TYPE) {
            return IntegerDeserializer.primitiveInstance;
        }
        if (cls == Boolean.TYPE) {
            return BooleanDeserializer.primitiveInstance;
        }
        if (cls == Long.TYPE) {
            return LongDeserializer.primitiveInstance;
        }
        if (cls == Double.TYPE) {
            return DoubleDeserializer.primitiveInstance;
        }
        if (cls == Character.TYPE) {
            return CharacterDeserializer.primitiveInstance;
        }
        if (cls == Byte.TYPE) {
            return ByteDeserializer.primitiveInstance;
        }
        if (cls == Short.TYPE) {
            return ShortDeserializer.primitiveInstance;
        }
        if (cls == Float.TYPE) {
            return FloatDeserializer.primitiveInstance;
        }
        if (cls == Void.TYPE) {
            return NullifyingDeserializer.instance;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Internal error: can't find deserializer for ".concat(cls.getName()));
        return null;
    }
}
