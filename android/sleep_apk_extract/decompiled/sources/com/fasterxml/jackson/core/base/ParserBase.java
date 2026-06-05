package com.fasterxml.jackson.core.base;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public abstract class ParserBase extends ParserMinimalBase {
    protected static final JacksonFeatureSet<StreamReadCapability> JSON_READ_CAPABILITIES = JsonParser.DEFAULT_READ_CAPABILITIES;
    protected byte[] _binaryValue;
    protected ByteArrayBuilder _byteArrayBuilder;
    protected boolean _closed;
    protected long _currInputProcessed;
    protected int _currInputRow;
    protected int _currInputRowStart;
    protected int _expLength;
    protected int _fractLength;
    protected int _inputEnd;
    protected int _inputPtr;
    protected int _intLength;
    protected final IOContext _ioContext;
    protected boolean _nameCopied;
    protected char[] _nameCopyBuffer;
    protected JsonToken _nextToken;
    protected int _numTypesValid;
    protected BigDecimal _numberBigDecimal;
    protected BigInteger _numberBigInt;
    protected double _numberDouble;
    protected float _numberFloat;
    protected int _numberInt;
    protected boolean _numberIsNaN;
    protected long _numberLong;
    protected boolean _numberNegative;
    protected String _numberString;
    protected JsonReadContext _parsingContext;
    protected final TextBuffer _textBuffer;
    protected int _tokenInputCol;
    protected int _tokenInputRow;
    protected long _tokenInputTotal;

    public ParserBase(IOContext iOContext, int i) {
        super(i, iOContext.streamReadConstraints());
        this._currInputRow = 1;
        this._tokenInputRow = 1;
        this._numTypesValid = 0;
        this._ioContext = iOContext;
        this._textBuffer = iOContext.constructReadConstrainedTextBuffer();
        this._parsingContext = JsonReadContext.createRootContext(JsonParser.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? DupDetector.rootDetector(this) : null);
    }

    private void _parseSlowFloat(int i) {
        if (i == 16) {
            this._numberBigDecimal = this._textBuffer.contentsAsDecimal(isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
            this._numTypesValid = 16;
            return;
        }
        if (i == 8) {
            this._numberDouble = this._textBuffer.contentsAsDouble(isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER));
            this._numTypesValid = 8;
        } else if (i == 32) {
            this._numberFloat = this._textBuffer.contentsAsFloat(isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER));
            this._numTypesValid = 32;
        } else {
            this._numberDouble = 0.0d;
            this._numberString = this._textBuffer.contentsAsString();
            this._numTypesValid = 8;
        }
    }

    private void _parseSlowInt(int i) throws InputCoercionException {
        String strContentsAsString = this._textBuffer.contentsAsString();
        if (i == 1 || i == 2) {
            _reportTooLongIntegral(i, strContentsAsString);
        }
        if (i == 8 || i == 32) {
            this._numberString = strContentsAsString;
            this._numTypesValid = 8;
        } else {
            this._numberBigInt = null;
            this._numberString = strContentsAsString;
            this._numTypesValid = 4;
        }
    }

    public static int[] growArrayBy(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length + i;
        if (length >= 0) {
            return Arrays.copyOf(iArr, length);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Unable to grow array to longer than `Integer.MAX_VALUE`");
        return null;
    }

    public void _checkStdFeatureChanges(int i, int i2) {
        int mask = JsonParser.Feature.STRICT_DUPLICATE_DETECTION.getMask();
        if ((i2 & mask) == 0 || (i & mask) == 0) {
            return;
        }
        DupDetector dupDetector = this._parsingContext.getDupDetector();
        JsonReadContext jsonReadContext = this._parsingContext;
        if (dupDetector == null) {
            this._parsingContext = jsonReadContext.withDupDetector(DupDetector.rootDetector(this));
        } else {
            this._parsingContext = jsonReadContext.withDupDetector(null);
        }
    }

    public abstract void _closeInput();

    public ContentReference _contentReference() {
        return JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION.enabledIn(this._features) ? this._ioContext.contentReference() : _contentReferenceRedacted();
    }

    public ContentReference _contentReferenceRedacted() {
        return ContentReference.redacted();
    }

    public BigInteger _convertBigDecimalToBigInteger(BigDecimal bigDecimal) throws StreamConstraintsException {
        this._streamReadConstraints.validateBigIntegerScale(bigDecimal.scale());
        return bigDecimal.toBigInteger();
    }

    public final int _decodeBase64Escape(Base64Variant base64Variant, char c, int i) {
        if (c != '\\') {
            throw reportInvalidBase64Char(base64Variant, c, i);
        }
        char c_decodeEscaped = _decodeEscaped();
        if (c_decodeEscaped <= ' ' && i == 0) {
            return -1;
        }
        int iDecodeBase64Char = base64Variant.decodeBase64Char(c_decodeEscaped);
        if (iDecodeBase64Char >= 0 || (iDecodeBase64Char == -2 && i >= 2)) {
            return iDecodeBase64Char;
        }
        throw reportInvalidBase64Char(base64Variant, c_decodeEscaped, i);
    }

    public abstract char _decodeEscaped();

    public final int _eofAsNextChar() {
        _handleEOF();
        return -1;
    }

    public BigDecimal _getBigDecimal() throws JsonParseException {
        BigDecimal bigDecimal = this._numberBigDecimal;
        if (bigDecimal != null) {
            return bigDecimal;
        }
        String str = this._numberString;
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("cannot get BigDecimal from current parser state");
            return null;
        }
        try {
            this._numberBigDecimal = NumberInput.parseBigDecimal(str, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
        } catch (NumberFormatException e) {
            _wrapError("Malformed numeric value (" + _longNumberDesc(this._numberString) + ")", e);
        }
        this._numberString = null;
        return this._numberBigDecimal;
    }

    public BigInteger _getBigInteger() throws JsonParseException {
        BigInteger bigInteger = this._numberBigInt;
        if (bigInteger != null) {
            return bigInteger;
        }
        String str = this._numberString;
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("cannot get BigInteger from current parser state");
            return null;
        }
        try {
            this._numberBigInt = NumberInput.parseBigInteger(str, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
        } catch (NumberFormatException e) {
            _wrapError("Malformed numeric value (" + _longNumberDesc(this._numberString) + ")", e);
        }
        this._numberString = null;
        return this._numberBigInt;
    }

    public ByteArrayBuilder _getByteArrayBuilder() {
        ByteArrayBuilder byteArrayBuilder = this._byteArrayBuilder;
        if (byteArrayBuilder == null) {
            this._byteArrayBuilder = new ByteArrayBuilder();
        } else {
            byteArrayBuilder.reset();
        }
        return this._byteArrayBuilder;
    }

    public double _getNumberDouble() throws JsonParseException {
        String str = this._numberString;
        if (str != null) {
            try {
                this._numberDouble = NumberInput.parseDouble(str, isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER));
            } catch (NumberFormatException e) {
                _wrapError("Malformed numeric value (" + _longNumberDesc(this._numberString) + ")", e);
            }
            this._numberString = null;
        }
        return this._numberDouble;
    }

    public float _getNumberFloat() throws JsonParseException {
        String str = this._numberString;
        if (str != null) {
            try {
                this._numberFloat = NumberInput.parseFloat(str, isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER));
            } catch (NumberFormatException e) {
                _wrapError("Malformed numeric value (" + _longNumberDesc(this._numberString) + ")", e);
            }
            this._numberString = null;
        }
        return this._numberFloat;
    }

    public int[] _growNameDecodeBuffer(int[] iArr, int i) {
        this._streamReadConstraints.validateNameLength(iArr.length << 2);
        return growArrayBy(iArr, i);
    }

    public void _handleBase64MissingPadding(Base64Variant base64Variant) {
        _reportError(base64Variant.missingPaddingMessage());
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase
    public void _handleEOF() {
        if (this._parsingContext.inRoot()) {
            return;
        }
        _reportInvalidEOF(String.format(": expected close marker for %s (start marker at %s)", this._parsingContext.inArray() ? "Array" : "Object", this._parsingContext.startLocation(_contentReference())), null);
    }

    public char _handleUnrecognizedCharacterEscape(char c) throws JsonParseException {
        if (isEnabled(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER) || (c == '\'' && isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
            return c;
        }
        throw _constructReadException("Unrecognized character escape " + ParserMinimalBase._getCharDesc(c), _currentLocationMinusOne());
    }

    public int _parseIntValue() throws JsonParseException, InputCoercionException {
        if (this._closed) {
            _reportError("Internal error: _parseNumericValue called when parser instance closed");
        }
        if (this._currToken != JsonToken.VALUE_NUMBER_INT || this._intLength > 9) {
            _parseNumericValue(1);
            if ((this._numTypesValid & 1) == 0) {
                convertNumberToInt();
            }
            return this._numberInt;
        }
        int iContentsAsInt = this._textBuffer.contentsAsInt(this._numberNegative);
        this._numberInt = iContentsAsInt;
        this._numTypesValid = 1;
        return iContentsAsInt;
    }

    public void _parseNumericValue(int i) throws JsonParseException, InputCoercionException {
        if (this._closed || this._currToken != JsonToken.VALUE_NUMBER_INT) {
            JsonToken jsonToken = this._currToken;
            if (jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
                _parseSlowFloat(i);
                return;
            } else {
                _reportError("Current token (%s) not numeric, can not use numeric value accessors", jsonToken);
                return;
            }
        }
        int i2 = this._intLength;
        if (i2 <= 9) {
            this._numberInt = this._textBuffer.contentsAsInt(this._numberNegative);
            this._numTypesValid = 1;
            return;
        }
        if (i2 > 18) {
            if (i2 == 19) {
                char[] textBuffer = this._textBuffer.getTextBuffer();
                int textOffset = this._textBuffer.getTextOffset();
                boolean z = this._numberNegative;
                if (z) {
                    textOffset++;
                }
                if (NumberInput.inLongRange(textBuffer, textOffset, i2, z)) {
                    this._numberLong = NumberInput.parseLong19(textBuffer, textOffset, this._numberNegative);
                    this._numTypesValid = 2;
                    return;
                }
            }
            _parseSlowInt(i);
            return;
        }
        long jContentsAsLong = this._textBuffer.contentsAsLong(this._numberNegative);
        if (i2 == 10) {
            if (this._numberNegative) {
                if (jContentsAsLong >= -2147483648L) {
                    this._numberInt = (int) jContentsAsLong;
                    this._numTypesValid = 1;
                    return;
                }
            } else if (jContentsAsLong <= 2147483647L) {
                this._numberInt = (int) jContentsAsLong;
                this._numTypesValid = 1;
                return;
            }
        }
        this._numberLong = jContentsAsLong;
        this._numTypesValid = 2;
    }

    public void _releaseBuffers() {
        this._textBuffer.releaseBuffers();
        char[] cArr = this._nameCopyBuffer;
        if (cArr != null) {
            this._nameCopyBuffer = null;
            this._ioContext.releaseNameCopyBuffer(cArr);
        }
    }

    public void _reportExtraEndMarker(int i) throws JsonParseException {
        throw _constructReadException("Unexpected close marker '" + ((char) i) + "': no open " + (i == 125 ? "Object" : "Array") + " to close", _currentLocationMinusOne());
    }

    public void _reportMismatchedEndMarker(int i, char c) {
        JsonReadContext parsingContext = getParsingContext();
        if (!parsingContext.inRoot()) {
            throw _constructReadException(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", Character.valueOf((char) i), Character.valueOf(c), parsingContext.typeDesc(), parsingContext.startLocation(_contentReference())), _currentLocationMinusOne());
        }
        _reportExtraEndMarker(i);
    }

    public void _reportTooLongIntegral(int i, String str) throws InputCoercionException {
        if (i == 1) {
            reportOverflowInt(str);
        } else {
            reportOverflowLong(str);
        }
    }

    public void _throwUnquotedSpace(int i, String str) {
        if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i > 32) {
            throw _constructReadException("Illegal unquoted character (" + ParserMinimalBase._getCharDesc((char) i) + "): has to be escaped using backslash to be included in " + str, _currentLocationMinusOne());
        }
    }

    public String _validJsonTokenList() {
        return _validJsonValueList();
    }

    public String _validJsonValueList() {
        return isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS) ? "(JSON String, Number (or 'NaN'/'+INF'/'-INF'), Array, Object or token 'null', 'true' or 'false')" : "(JSON String, Number, Array, Object or token 'null', 'true' or 'false')";
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void assignCurrentValue(Object obj) {
        this._parsingContext.setCurrentValue(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this._closed) {
            return;
        }
        this._inputPtr = Math.max(this._inputPtr, this._inputEnd);
        this._closed = true;
        if (JsonParser.Feature.CLEAR_CURRENT_TOKEN_ON_CLOSE.enabledIn(this._features)) {
            this._currToken = null;
        }
        try {
            _closeInput();
        } finally {
            _releaseBuffers();
            this._ioContext.close();
        }
    }

    public void convertNumberToBigDecimal() {
        int i = this._numTypesValid;
        if ((i & 8) != 0) {
            String text = this._numberString;
            if (text == null) {
                text = getText();
            }
            this._numberBigDecimal = NumberInput.parseBigDecimal(text, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
        } else if ((i & 4) != 0) {
            this._numberBigDecimal = new BigDecimal(_getBigInteger());
        } else if ((i & 2) != 0) {
            this._numberBigDecimal = BigDecimal.valueOf(this._numberLong);
        } else if ((i & 1) != 0) {
            this._numberBigDecimal = BigDecimal.valueOf(this._numberInt);
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 16;
    }

    public void convertNumberToBigInteger() {
        int i = this._numTypesValid;
        if ((i & 16) != 0) {
            this._numberBigInt = _convertBigDecimalToBigInteger(_getBigDecimal());
        } else if ((i & 2) != 0) {
            this._numberBigInt = BigInteger.valueOf(this._numberLong);
        } else if ((i & 1) != 0) {
            this._numberBigInt = BigInteger.valueOf(this._numberInt);
        } else if ((i & 8) == 0) {
            _throwInternal();
        } else if (this._numberString != null) {
            this._numberBigInt = _convertBigDecimalToBigInteger(_getBigDecimal());
        } else {
            this._numberBigInt = _convertBigDecimalToBigInteger(BigDecimal.valueOf(_getNumberDouble()));
        }
        this._numTypesValid |= 4;
    }

    public void convertNumberToDouble() {
        int i = this._numTypesValid;
        if ((i & 16) != 0) {
            if (this._numberString != null) {
                this._numberDouble = _getNumberDouble();
            } else {
                this._numberDouble = _getBigDecimal().doubleValue();
            }
        } else if ((i & 4) != 0) {
            if (this._numberString != null) {
                this._numberDouble = _getNumberDouble();
            } else {
                this._numberDouble = _getBigInteger().doubleValue();
            }
        } else if ((i & 2) != 0) {
            this._numberDouble = this._numberLong;
        } else if ((i & 1) != 0) {
            this._numberDouble = this._numberInt;
        } else if ((i & 32) == 0) {
            _throwInternal();
        } else if (this._numberString != null) {
            this._numberDouble = _getNumberDouble();
        } else {
            this._numberDouble = _getNumberFloat();
        }
        this._numTypesValid |= 8;
    }

    public void convertNumberToFloat() {
        int i = this._numTypesValid;
        if ((i & 16) != 0) {
            if (this._numberString != null) {
                this._numberFloat = _getNumberFloat();
            } else {
                this._numberFloat = _getBigDecimal().floatValue();
            }
        } else if ((i & 4) != 0) {
            if (this._numberString != null) {
                this._numberFloat = _getNumberFloat();
            } else {
                this._numberFloat = _getBigInteger().floatValue();
            }
        } else if ((i & 2) != 0) {
            this._numberFloat = this._numberLong;
        } else if ((i & 1) != 0) {
            this._numberFloat = this._numberInt;
        } else if ((i & 8) == 0) {
            _throwInternal();
        } else if (this._numberString != null) {
            this._numberFloat = _getNumberFloat();
        } else {
            this._numberFloat = (float) _getNumberDouble();
        }
        this._numTypesValid |= 32;
    }

    public void convertNumberToInt() {
        int i = this._numTypesValid;
        if ((i & 2) != 0) {
            long j = this._numberLong;
            int i2 = (int) j;
            if (i2 != j) {
                reportOverflowInt(getText(), currentToken());
            }
            this._numberInt = i2;
        } else if ((i & 4) != 0) {
            BigInteger bigInteger_getBigInteger = _getBigInteger();
            if (ParserMinimalBase.BI_MIN_INT.compareTo(bigInteger_getBigInteger) > 0 || ParserMinimalBase.BI_MAX_INT.compareTo(bigInteger_getBigInteger) < 0) {
                reportOverflowInt();
            }
            this._numberInt = bigInteger_getBigInteger.intValue();
        } else if ((i & 8) != 0) {
            double d_getNumberDouble = _getNumberDouble();
            if (d_getNumberDouble < -2.147483648E9d || d_getNumberDouble > 2.147483647E9d) {
                reportOverflowInt();
            }
            this._numberInt = (int) d_getNumberDouble;
        } else if ((i & 16) != 0) {
            BigDecimal bigDecimal_getBigDecimal = _getBigDecimal();
            if (ParserMinimalBase.BD_MIN_INT.compareTo(bigDecimal_getBigDecimal) > 0 || ParserMinimalBase.BD_MAX_INT.compareTo(bigDecimal_getBigDecimal) < 0) {
                reportOverflowInt();
            }
            this._numberInt = bigDecimal_getBigDecimal.intValue();
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 1;
    }

    public void convertNumberToLong() throws JsonParseException {
        int i = this._numTypesValid;
        if ((i & 1) != 0) {
            this._numberLong = this._numberInt;
        } else if ((i & 4) != 0) {
            BigInteger bigInteger_getBigInteger = _getBigInteger();
            if (ParserMinimalBase.BI_MIN_LONG.compareTo(bigInteger_getBigInteger) > 0 || ParserMinimalBase.BI_MAX_LONG.compareTo(bigInteger_getBigInteger) < 0) {
                reportOverflowLong();
            }
            this._numberLong = bigInteger_getBigInteger.longValue();
        } else if ((i & 8) != 0) {
            double d_getNumberDouble = _getNumberDouble();
            if (d_getNumberDouble < -9.223372036854776E18d || d_getNumberDouble > 9.223372036854776E18d) {
                reportOverflowLong();
            }
            this._numberLong = (long) d_getNumberDouble;
        } else if ((i & 16) != 0) {
            BigDecimal bigDecimal_getBigDecimal = _getBigDecimal();
            if (ParserMinimalBase.BD_MIN_LONG.compareTo(bigDecimal_getBigDecimal) > 0 || ParserMinimalBase.BD_MAX_LONG.compareTo(bigDecimal_getBigDecimal) < 0) {
                reportOverflowLong();
            }
            this._numberLong = bigDecimal_getBigDecimal.longValue();
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 2;
    }

    public void createChildArrayContext(int i, int i2) {
        JsonReadContext jsonReadContextCreateChildArrayContext = this._parsingContext.createChildArrayContext(i, i2);
        this._parsingContext = jsonReadContextCreateChildArrayContext;
        this._streamReadConstraints.validateNestingDepth(jsonReadContextCreateChildArrayContext.getNestingDepth());
    }

    public void createChildObjectContext(int i, int i2) {
        JsonReadContext jsonReadContextCreateChildObjectContext = this._parsingContext.createChildObjectContext(i, i2);
        this._parsingContext = jsonReadContextCreateChildObjectContext;
        this._streamReadConstraints.validateNestingDepth(jsonReadContextCreateChildObjectContext.getNestingDepth());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger getBigIntegerValue() throws JsonParseException, InputCoercionException {
        int i = this._numTypesValid;
        if ((i & 4) == 0) {
            if (i == 0) {
                _parseNumericValue(4);
            }
            if ((this._numTypesValid & 4) == 0) {
                convertNumberToBigInteger();
                return this._numberBigInt;
            }
        }
        return _getBigInteger();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public String getCurrentName() {
        JsonReadContext parent;
        JsonToken jsonToken = this._currToken;
        return ((jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) && (parent = this._parsingContext.getParent()) != null) ? parent.getCurrentName() : this._parsingContext.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal getDecimalValue() throws JsonParseException, InputCoercionException {
        int i = this._numTypesValid;
        if ((i & 16) == 0) {
            if (i == 0) {
                _parseNumericValue(16);
            }
            if ((this._numTypesValid & 16) == 0) {
                convertNumberToBigDecimal();
                return this._numberBigDecimal;
            }
        }
        return _getBigDecimal();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double getDoubleValue() throws JsonParseException, InputCoercionException {
        int i = this._numTypesValid;
        if ((i & 8) == 0) {
            if (i == 0) {
                _parseNumericValue(8);
            }
            if ((this._numTypesValid & 8) == 0) {
                convertNumberToDouble();
                return this._numberDouble;
            }
        }
        return _getNumberDouble();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float getFloatValue() throws JsonParseException, InputCoercionException {
        int i = this._numTypesValid;
        if ((i & 32) == 0) {
            if (i == 0) {
                _parseNumericValue(32);
            }
            if ((this._numTypesValid & 32) == 0) {
                convertNumberToFloat();
                return this._numberFloat;
            }
        }
        return _getNumberFloat();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getIntValue() {
        int i = this._numTypesValid;
        if ((i & 1) == 0) {
            if (i == 0) {
                return _parseIntValue();
            }
            if ((i & 1) == 0) {
                convertNumberToInt();
            }
        }
        return this._numberInt;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getLongValue() throws JsonParseException, InputCoercionException {
        int i = this._numTypesValid;
        if ((i & 2) == 0) {
            if (i == 0) {
                _parseNumericValue(2);
            }
            if ((this._numTypesValid & 2) == 0) {
                convertNumberToLong();
            }
        }
        return this._numberLong;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType getNumberType() throws JsonParseException, InputCoercionException {
        if (this._numTypesValid == 0) {
            _parseNumericValue(0);
        }
        JsonToken jsonToken = this._currToken;
        JsonToken jsonToken2 = JsonToken.VALUE_NUMBER_INT;
        int i = this._numTypesValid;
        return jsonToken == jsonToken2 ? (i & 1) != 0 ? JsonParser.NumberType.INT : (i & 2) != 0 ? JsonParser.NumberType.LONG : JsonParser.NumberType.BIG_INTEGER : (i & 16) != 0 ? JsonParser.NumberType.BIG_DECIMAL : (i & 32) != 0 ? JsonParser.NumberType.FLOAT : JsonParser.NumberType.DOUBLE;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number getNumberValue() throws JsonParseException, InputCoercionException {
        if (this._numTypesValid == 0) {
            _parseNumericValue(0);
        }
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            int i = this._numTypesValid;
            if ((i & 1) != 0) {
                return Integer.valueOf(this._numberInt);
            }
            if ((i & 2) != 0) {
                return Long.valueOf(this._numberLong);
            }
            if ((i & 4) != 0) {
                return _getBigInteger();
            }
            _throwInternal();
        }
        int i2 = this._numTypesValid;
        if ((i2 & 16) != 0) {
            return _getBigDecimal();
        }
        if ((i2 & 32) != 0) {
            return Float.valueOf(_getNumberFloat());
        }
        if ((i2 & 8) == 0) {
            _throwInternal();
        }
        return Double.valueOf(_getNumberDouble());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getNumberValueDeferred() throws JsonParseException, InputCoercionException {
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            if (this._numTypesValid == 0) {
                _parseNumericValue(0);
            }
            int i = this._numTypesValid;
            if ((i & 1) != 0) {
                return Integer.valueOf(this._numberInt);
            }
            if ((i & 2) != 0) {
                return Long.valueOf(this._numberLong);
            }
            if ((i & 4) != 0) {
                BigInteger bigInteger = this._numberBigInt;
                if (bigInteger != null) {
                    return bigInteger;
                }
                String str = this._numberString;
                return str != null ? str : _getBigInteger();
            }
            _throwInternal();
        }
        if (this._currToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return getNumberValue();
        }
        int i2 = this._numTypesValid;
        return (i2 & 16) != 0 ? _getBigDecimal() : (i2 & 8) != 0 ? Double.valueOf(_getNumberDouble()) : (i2 & 32) != 0 ? Float.valueOf(_getNumberFloat()) : this._textBuffer.contentsAsString();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return true;
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this._nameCopied;
        }
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean isNaN() {
        return this._currToken == JsonToken.VALUE_NUMBER_FLOAT && this._numberIsNaN;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser overrideStdFeatures(int i, int i2) {
        int i3 = this._features;
        int i4 = (i & i2) | ((~i2) & i3);
        int i5 = i3 ^ i4;
        if (i5 != 0) {
            this._features = i4;
            _checkStdFeatureChanges(i4, i5);
        }
        return this;
    }

    public IllegalArgumentException reportInvalidBase64Char(Base64Variant base64Variant, int i, int i2, String str) {
        String strM$1;
        if (i <= 32) {
            strM$1 = String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", Integer.toHexString(i), Integer.valueOf(i2 + 1));
        } else if (base64Variant.usesPaddingChar(i)) {
            strM$1 = "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(i) || Character.isISOControl(i)) {
            strM$1 = "Illegal character (code 0x" + Integer.toHexString(i) + ") in base64 content";
        } else {
            strM$1 = "Illegal character '" + ((char) i) + "' (code 0x" + Integer.toHexString(i) + ") in base64 content";
        }
        if (str != null) {
            strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(strM$1, ": ", str);
        }
        return new IllegalArgumentException(strM$1);
    }

    public final JsonToken resetAsNaN(String str, double d) {
        this._textBuffer.resetWithString(str);
        this._numberDouble = d;
        this._numTypesValid = 8;
        this._numberIsNaN = true;
        this._numberString = null;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final JsonToken resetFloat(boolean z, int i, int i2, int i3) throws StreamConstraintsException {
        this._streamReadConstraints.validateFPLength(i + i2 + i3);
        this._numberNegative = z;
        this._numberIsNaN = false;
        this._intLength = i;
        this._fractLength = i2;
        this._expLength = i3;
        this._numTypesValid = 0;
        this._numberString = null;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final JsonToken resetInt(boolean z, int i) throws StreamConstraintsException {
        this._streamReadConstraints.validateIntegerLength(i);
        this._numberNegative = z;
        this._numberIsNaN = false;
        this._intLength = i;
        this._fractLength = 0;
        this._expLength = 0;
        this._numTypesValid = 0;
        this._numberString = null;
        return JsonToken.VALUE_NUMBER_INT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public JsonParser setFeatureMask(int i) {
        int i2 = this._features ^ i;
        if (i2 != 0) {
            this._features = i;
            _checkStdFeatureChanges(i, i2);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonReadContext getParsingContext() {
        return this._parsingContext;
    }

    public final int _decodeBase64Escape(Base64Variant base64Variant, int i, int i2) {
        if (i == 92) {
            char c_decodeEscaped = _decodeEscaped();
            if (c_decodeEscaped <= ' ' && i2 == 0) {
                return -1;
            }
            int iDecodeBase64Char = base64Variant.decodeBase64Char((int) c_decodeEscaped);
            if (iDecodeBase64Char >= 0 || iDecodeBase64Char == -2) {
                return iDecodeBase64Char;
            }
            throw reportInvalidBase64Char(base64Variant, c_decodeEscaped, i2);
        }
        throw reportInvalidBase64Char(base64Variant, i, i2);
    }

    public IllegalArgumentException reportInvalidBase64Char(Base64Variant base64Variant, int i, int i2) {
        return reportInvalidBase64Char(base64Variant, i, i2, null);
    }
}
