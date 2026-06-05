package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public class FilteringParserDelegate extends JsonParserDelegate {
    protected boolean _allowMultipleMatches;
    protected JsonToken _currToken;
    protected TokenFilterContext _exposedContext;
    protected TokenFilterContext _headContext;
    protected TokenFilter.Inclusion _inclusion;
    protected TokenFilter _itemFilter;
    protected JsonToken _lastClearedToken;
    protected int _matchCount;
    protected TokenFilter rootFilter;

    public FilteringParserDelegate(JsonParser jsonParser, TokenFilter tokenFilter, TokenFilter.Inclusion inclusion, boolean z) {
        super(jsonParser);
        _checkAsyncParser(jsonParser);
        initializeFilters(tokenFilter, inclusion, z);
    }

    private static void _checkAsyncParser(JsonParser jsonParser) {
        if (jsonParser.canParseAsync()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(jsonParser.getClass().getSimpleName().concat(" is an asynchronous parser (canParseAsync() == true), which requires explicit permission to be used: to allow use, call constructor with `allowNonBlockingParser` passed as `true`"));
        }
    }

    private JsonToken _nextBuffered(TokenFilterContext tokenFilterContext) throws JsonParseException {
        this._exposedContext = tokenFilterContext;
        JsonToken jsonTokenNextTokenToRead = tokenFilterContext.nextTokenToRead();
        if (jsonTokenNextTokenToRead != null) {
            return jsonTokenNextTokenToRead;
        }
        while (tokenFilterContext != this._headContext) {
            tokenFilterContext = this._exposedContext.findChildOf(tokenFilterContext);
            this._exposedContext = tokenFilterContext;
            if (tokenFilterContext == null) {
                throw _constructError("Unexpected problem: chain of filtered context broken");
            }
            JsonToken jsonTokenNextTokenToRead2 = tokenFilterContext.nextTokenToRead();
            if (jsonTokenNextTokenToRead2 != null) {
                return jsonTokenNextTokenToRead2;
            }
        }
        throw _constructError("Internal error: failed to locate expected buffered tokens");
    }

    private final boolean _verifyAllowedMatches() {
        int i = this._matchCount;
        if (i != 0 && !this._allowMultipleMatches) {
            return false;
        }
        this._matchCount = i + 1;
        return true;
    }

    private void initializeFilters(TokenFilter tokenFilter, TokenFilter.Inclusion inclusion, boolean z) {
        this.rootFilter = tokenFilter;
        this._itemFilter = tokenFilter;
        this._headContext = TokenFilterContext.createRootContext(tokenFilter);
        this._inclusion = inclusion;
        this._allowMultipleMatches = z;
    }

    public JsonStreamContext _filterContext() {
        TokenFilterContext tokenFilterContext = this._exposedContext;
        return tokenFilterContext != null ? tokenFilterContext : this._headContext;
    }

    public final JsonToken _nextToken2() {
        TokenFilter tokenFilterCheckValue;
        JsonToken jsonToken_nextTokenWithBuffering;
        JsonToken jsonToken_nextTokenWithBuffering2;
        JsonToken jsonToken_nextTokenWithBuffering3;
        while (true) {
            JsonToken jsonTokenNextToken = this.delegate.nextToken();
            if (jsonTokenNextToken == null) {
                this._currToken = jsonTokenNextToken;
                return jsonTokenNextToken;
            }
            int iId = jsonTokenNextToken.id();
            if (iId == 1) {
                TokenFilter tokenFilter = this._itemFilter;
                TokenFilter tokenFilter2 = TokenFilter.INCLUDE_ALL;
                if (tokenFilter == tokenFilter2) {
                    this._headContext = this._headContext.createChildObjectContext(tokenFilter, true);
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
                if (tokenFilter == null) {
                    this.delegate.skipChildren();
                } else {
                    TokenFilter tokenFilterCheckValue2 = this._headContext.checkValue(tokenFilter);
                    if (tokenFilterCheckValue2 == null) {
                        this.delegate.skipChildren();
                    } else {
                        if (tokenFilterCheckValue2 != tokenFilter2) {
                            tokenFilterCheckValue2 = tokenFilterCheckValue2.filterStartObject();
                        }
                        this._itemFilter = tokenFilterCheckValue2;
                        if (tokenFilterCheckValue2 == tokenFilter2) {
                            this._headContext = this._headContext.createChildObjectContext(tokenFilterCheckValue2, true);
                            this._currToken = jsonTokenNextToken;
                            return jsonTokenNextToken;
                        }
                        if (tokenFilterCheckValue2 != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                            this._headContext = this._headContext.createChildObjectContext(tokenFilterCheckValue2, true);
                            this._currToken = jsonTokenNextToken;
                            return jsonTokenNextToken;
                        }
                        TokenFilterContext tokenFilterContextCreateChildObjectContext = this._headContext.createChildObjectContext(tokenFilterCheckValue2, false);
                        this._headContext = tokenFilterContextCreateChildObjectContext;
                        if (this._inclusion == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH && (jsonToken_nextTokenWithBuffering3 = _nextTokenWithBuffering(tokenFilterContextCreateChildObjectContext)) != null) {
                            this._currToken = jsonToken_nextTokenWithBuffering3;
                            return jsonToken_nextTokenWithBuffering3;
                        }
                    }
                }
            } else if (iId == 2) {
                boolean zIsStartHandled = this._headContext.isStartHandled();
                TokenFilter filter = this._headContext.getFilter();
                if (filter != null && filter != TokenFilter.INCLUDE_ALL) {
                    filter.filterFinishObject();
                    if (!zIsStartHandled && filter.includeEmptyObject(this._headContext.hasCurrentName())) {
                        TokenFilterContext tokenFilterContext = this._headContext;
                        tokenFilterContext._needToHandleName = false;
                        return _nextBuffered(tokenFilterContext);
                    }
                }
                TokenFilterContext parent = this._headContext.getParent();
                this._headContext = parent;
                this._itemFilter = parent.getFilter();
                if (zIsStartHandled) {
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
            } else if (iId == 3) {
                TokenFilter tokenFilter3 = this._itemFilter;
                TokenFilter tokenFilter4 = TokenFilter.INCLUDE_ALL;
                if (tokenFilter3 == tokenFilter4) {
                    this._headContext = this._headContext.createChildArrayContext(tokenFilter3, true);
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
                if (tokenFilter3 == null) {
                    this.delegate.skipChildren();
                } else {
                    TokenFilter tokenFilterCheckValue3 = this._headContext.checkValue(tokenFilter3);
                    if (tokenFilterCheckValue3 == null) {
                        this.delegate.skipChildren();
                    } else {
                        if (tokenFilterCheckValue3 != tokenFilter4) {
                            tokenFilterCheckValue3 = tokenFilterCheckValue3.filterStartArray();
                        }
                        this._itemFilter = tokenFilterCheckValue3;
                        if (tokenFilterCheckValue3 == tokenFilter4) {
                            this._headContext = this._headContext.createChildArrayContext(tokenFilterCheckValue3, true);
                            this._currToken = jsonTokenNextToken;
                            return jsonTokenNextToken;
                        }
                        if (tokenFilterCheckValue3 != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                            this._headContext = this._headContext.createChildArrayContext(tokenFilterCheckValue3, true);
                            this._currToken = jsonTokenNextToken;
                            return jsonTokenNextToken;
                        }
                        TokenFilterContext tokenFilterContextCreateChildArrayContext = this._headContext.createChildArrayContext(tokenFilterCheckValue3, false);
                        this._headContext = tokenFilterContextCreateChildArrayContext;
                        if (this._inclusion == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH && (jsonToken_nextTokenWithBuffering2 = _nextTokenWithBuffering(tokenFilterContextCreateChildArrayContext)) != null) {
                            this._currToken = jsonToken_nextTokenWithBuffering2;
                            return jsonToken_nextTokenWithBuffering2;
                        }
                    }
                }
            } else if (iId == 4) {
                boolean zIsStartHandled2 = this._headContext.isStartHandled();
                TokenFilter filter2 = this._headContext.getFilter();
                if (filter2 != null && filter2 != TokenFilter.INCLUDE_ALL) {
                    filter2.filterFinishArray();
                    if (!zIsStartHandled2 && filter2.includeEmptyArray(this._headContext.hasCurrentIndex())) {
                        TokenFilterContext tokenFilterContext2 = this._headContext;
                        tokenFilterContext2._needToHandleName = false;
                        return _nextBuffered(tokenFilterContext2);
                    }
                }
                TokenFilterContext parent2 = this._headContext.getParent();
                this._headContext = parent2;
                this._itemFilter = parent2.getFilter();
                if (zIsStartHandled2) {
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
            } else if (iId != 5) {
                TokenFilter tokenFilter5 = this._itemFilter;
                TokenFilter tokenFilter6 = TokenFilter.INCLUDE_ALL;
                if (tokenFilter5 == tokenFilter6) {
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
                if (tokenFilter5 != null && ((tokenFilterCheckValue = this._headContext.checkValue(tokenFilter5)) == tokenFilter6 || (tokenFilterCheckValue != null && tokenFilterCheckValue.includeValue(this.delegate)))) {
                    if (_verifyAllowedMatches()) {
                        this._currToken = jsonTokenNextToken;
                        return jsonTokenNextToken;
                    }
                }
            } else {
                String strCurrentName = this.delegate.currentName();
                TokenFilter fieldName = this._headContext.setFieldName(strCurrentName);
                TokenFilter tokenFilter7 = TokenFilter.INCLUDE_ALL;
                if (fieldName == tokenFilter7) {
                    this._itemFilter = fieldName;
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
                if (fieldName == null) {
                    this.delegate.nextToken();
                    this.delegate.skipChildren();
                } else {
                    TokenFilter tokenFilterIncludeProperty = fieldName.includeProperty(strCurrentName);
                    if (tokenFilterIncludeProperty == null) {
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                    } else {
                        this._itemFilter = tokenFilterIncludeProperty;
                        if (tokenFilterIncludeProperty == tokenFilter7) {
                            if (!_verifyAllowedMatches()) {
                                this.delegate.nextToken();
                                this.delegate.skipChildren();
                            } else if (this._inclusion == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH) {
                                this._currToken = jsonTokenNextToken;
                                return jsonTokenNextToken;
                            }
                        } else if (this._inclusion != TokenFilter.Inclusion.ONLY_INCLUDE_ALL && (jsonToken_nextTokenWithBuffering = _nextTokenWithBuffering(this._headContext)) != null) {
                            this._currToken = jsonToken_nextTokenWithBuffering;
                            return jsonToken_nextTokenWithBuffering;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0172, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JsonToken _nextTokenWithBuffering(TokenFilterContext tokenFilterContext) {
        TokenFilter tokenFilterCheckValue;
        boolean z;
        while (true) {
            JsonToken jsonTokenNextToken = this.delegate.nextToken();
            if (jsonTokenNextToken == null) {
                return jsonTokenNextToken;
            }
            int iId = jsonTokenNextToken.id();
            if (iId == 1) {
                TokenFilter tokenFilter = this._itemFilter;
                TokenFilter tokenFilter2 = TokenFilter.INCLUDE_ALL;
                if (tokenFilter == tokenFilter2) {
                    this._headContext = this._headContext.createChildObjectContext(tokenFilter, true);
                    return jsonTokenNextToken;
                }
                if (tokenFilter == null) {
                    this.delegate.skipChildren();
                } else {
                    TokenFilter tokenFilterCheckValue2 = this._headContext.checkValue(tokenFilter);
                    if (tokenFilterCheckValue2 == null) {
                        this.delegate.skipChildren();
                    } else {
                        if (tokenFilterCheckValue2 != tokenFilter2) {
                            tokenFilterCheckValue2 = tokenFilterCheckValue2.filterStartObject();
                        }
                        this._itemFilter = tokenFilterCheckValue2;
                        if (tokenFilterCheckValue2 == tokenFilter2) {
                            this._headContext = this._headContext.createChildObjectContext(tokenFilterCheckValue2, true);
                            return _nextBuffered(tokenFilterContext);
                        }
                        if (tokenFilterCheckValue2 != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                            this._headContext = this._headContext.createChildArrayContext(tokenFilterCheckValue2, true);
                            return _nextBuffered(tokenFilterContext);
                        }
                        this._headContext = this._headContext.createChildObjectContext(tokenFilterCheckValue2, false);
                    }
                }
            } else if (iId == 2) {
                TokenFilter filter = this._headContext.getFilter();
                TokenFilterContext tokenFilterContext2 = this._headContext;
                boolean z2 = tokenFilterContext2 == tokenFilterContext;
                z = z2 && tokenFilterContext2.isStartHandled();
                if (filter != null && filter != TokenFilter.INCLUDE_ALL) {
                    filter.filterFinishObject();
                    if (!z && filter.includeEmptyObject(this._headContext.hasCurrentName())) {
                        this._headContext._needToHandleName = false;
                        return _nextBuffered(tokenFilterContext);
                    }
                }
                TokenFilterContext parent = this._headContext.getParent();
                this._headContext = parent;
                this._itemFilter = parent.getFilter();
                if (z) {
                    break;
                }
                if (z2) {
                    return null;
                }
            } else if (iId == 3) {
                TokenFilter tokenFilterCheckValue3 = this._headContext.checkValue(this._itemFilter);
                if (tokenFilterCheckValue3 == null) {
                    this.delegate.skipChildren();
                } else {
                    TokenFilter tokenFilter3 = TokenFilter.INCLUDE_ALL;
                    if (tokenFilterCheckValue3 != tokenFilter3) {
                        tokenFilterCheckValue3 = tokenFilterCheckValue3.filterStartArray();
                    }
                    this._itemFilter = tokenFilterCheckValue3;
                    if (tokenFilterCheckValue3 == tokenFilter3) {
                        this._headContext = this._headContext.createChildArrayContext(tokenFilterCheckValue3, true);
                        return _nextBuffered(tokenFilterContext);
                    }
                    if (tokenFilterCheckValue3 != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                        this._headContext = this._headContext.createChildArrayContext(tokenFilterCheckValue3, true);
                        return _nextBuffered(tokenFilterContext);
                    }
                    this._headContext = this._headContext.createChildArrayContext(tokenFilterCheckValue3, false);
                }
            } else if (iId == 4) {
                TokenFilter filter2 = this._headContext.getFilter();
                TokenFilterContext tokenFilterContext3 = this._headContext;
                boolean z3 = tokenFilterContext3 == tokenFilterContext;
                z = z3 && tokenFilterContext3.isStartHandled();
                if (filter2 != null && filter2 != TokenFilter.INCLUDE_ALL) {
                    filter2.filterFinishArray();
                    if (!z && filter2.includeEmptyArray(this._headContext.hasCurrentIndex())) {
                        this._headContext._needToHandleName = false;
                        return _nextBuffered(tokenFilterContext);
                    }
                }
                TokenFilterContext parent2 = this._headContext.getParent();
                this._headContext = parent2;
                this._itemFilter = parent2.getFilter();
                if (z) {
                    break;
                }
                if (z3) {
                    return null;
                }
            } else if (iId != 5) {
                TokenFilter tokenFilter4 = this._itemFilter;
                TokenFilter tokenFilter5 = TokenFilter.INCLUDE_ALL;
                if (tokenFilter4 == tokenFilter5) {
                    return _nextBuffered(tokenFilterContext);
                }
                if (tokenFilter4 != null && ((tokenFilterCheckValue = this._headContext.checkValue(tokenFilter4)) == tokenFilter5 || (tokenFilterCheckValue != null && tokenFilterCheckValue.includeValue(this.delegate)))) {
                    if (_verifyAllowedMatches()) {
                        return _nextBuffered(tokenFilterContext);
                    }
                }
            } else {
                String strCurrentName = this.delegate.currentName();
                TokenFilter fieldName = this._headContext.setFieldName(strCurrentName);
                TokenFilter tokenFilter6 = TokenFilter.INCLUDE_ALL;
                if (fieldName == tokenFilter6) {
                    this._itemFilter = fieldName;
                    return _nextBuffered(tokenFilterContext);
                }
                if (fieldName == null) {
                    this.delegate.nextToken();
                    this.delegate.skipChildren();
                } else {
                    TokenFilter tokenFilterIncludeProperty = fieldName.includeProperty(strCurrentName);
                    if (tokenFilterIncludeProperty == null) {
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                    } else {
                        this._itemFilter = tokenFilterIncludeProperty;
                        if (tokenFilterIncludeProperty != tokenFilter6) {
                            continue;
                        } else {
                            if (_verifyAllowedMatches()) {
                                return _nextBuffered(tokenFilterContext);
                            }
                            this._itemFilter = this._headContext.setFieldName(strCurrentName);
                        }
                    }
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public void clearCurrentToken() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != null) {
            this._lastClearedToken = jsonToken;
            this._currToken = null;
        }
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentLocation() {
        return this.delegate.currentLocation();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public String currentName() {
        JsonStreamContext jsonStreamContext_filterContext = _filterContext();
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return jsonStreamContext_filterContext.getCurrentName();
        }
        JsonStreamContext parent = jsonStreamContext_filterContext.getParent();
        if (parent == null) {
            return null;
        }
        return parent.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonToken currentToken() {
        return this._currToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public final int currentTokenId() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.id();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentTokenLocation() {
        return this.delegate.currentTokenLocation();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public BigInteger getBigIntegerValue() {
        return this.delegate.getBigIntegerValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) {
        return this.delegate.getBinaryValue(base64Variant);
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean getBooleanValue() {
        return this.delegate.getBooleanValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public byte getByteValue() {
        return this.delegate.getByteValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public String getCurrentName() {
        JsonStreamContext jsonStreamContext_filterContext = _filterContext();
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return jsonStreamContext_filterContext.getCurrentName();
        }
        JsonStreamContext parent = jsonStreamContext_filterContext.getParent();
        if (parent == null) {
            return null;
        }
        return parent.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public JsonToken getCurrentToken() {
        return this._currToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public BigDecimal getDecimalValue() {
        return this.delegate.getDecimalValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public double getDoubleValue() {
        return this.delegate.getDoubleValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() {
        return this.delegate.getEmbeddedObject();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public float getFloatValue() {
        return this.delegate.getFloatValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getIntValue() {
        return this.delegate.getIntValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public long getLongValue() {
        return this.delegate.getLongValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType getNumberType() {
        return this.delegate.getNumberType();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public Number getNumberValue() {
        return this.delegate.getNumberValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonStreamContext getParsingContext() {
        return _filterContext();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public short getShortValue() {
        return this.delegate.getShortValue();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public String getText() {
        return this._currToken == JsonToken.FIELD_NAME ? currentName() : this.delegate.getText();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() {
        return this._currToken == JsonToken.FIELD_NAME ? currentName().toCharArray() : this.delegate.getTextCharacters();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() {
        return this._currToken == JsonToken.FIELD_NAME ? currentName().length() : this.delegate.getTextLength();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getTextOffset() {
        if (this._currToken == JsonToken.FIELD_NAME) {
            return 0;
        }
        return this.delegate.getTextOffset();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt() {
        return this.delegate.getValueAsInt();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong() {
        return this.delegate.getValueAsLong();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() {
        return this._currToken == JsonToken.FIELD_NAME ? currentName() : this.delegate.getValueAsString();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean hasCurrentToken() {
        return this._currToken != null;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        if (this._currToken == JsonToken.FIELD_NAME) {
            return false;
        }
        return this.delegate.hasTextCharacters();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public final boolean hasToken(JsonToken jsonToken) {
        return this._currToken == jsonToken;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean hasTokenId(int i) {
        JsonToken jsonToken = this._currToken;
        return jsonToken == null ? i == 0 : jsonToken.id() == i;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean isExpectedStartArrayToken() {
        return this._currToken == JsonToken.START_ARRAY;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public boolean isExpectedStartObjectToken() {
        return this._currToken == JsonToken.START_OBJECT;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x019e  */
    @Override // com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonToken nextToken() throws JsonParseException {
        TokenFilter tokenFilterCheckValue;
        JsonToken jsonToken_nextTokenWithBuffering;
        TokenFilter tokenFilterCheckValue2;
        JsonToken jsonToken_nextTokenWithBuffering2;
        TokenFilter tokenFilterIncludeProperty;
        JsonToken jsonToken_nextTokenWithBuffering3;
        TokenFilter tokenFilterCheckValue3;
        JsonToken jsonToken;
        if (!this._allowMultipleMatches && (jsonToken = this._currToken) != null && this._exposedContext == null && jsonToken.isScalarValue() && !this._headContext.isStartHandled() && this._inclusion == TokenFilter.Inclusion.ONLY_INCLUDE_ALL && this._itemFilter == TokenFilter.INCLUDE_ALL) {
            this._currToken = null;
            return null;
        }
        TokenFilterContext tokenFilterContextFindChildOf = this._exposedContext;
        if (tokenFilterContextFindChildOf != null) {
            do {
                JsonToken jsonTokenNextTokenToRead = tokenFilterContextFindChildOf.nextTokenToRead();
                if (jsonTokenNextTokenToRead != null) {
                    this._currToken = jsonTokenNextTokenToRead;
                    return jsonTokenNextTokenToRead;
                }
                TokenFilterContext tokenFilterContext = this._headContext;
                if (tokenFilterContextFindChildOf == tokenFilterContext) {
                    this._exposedContext = null;
                    boolean zInArray = tokenFilterContextFindChildOf.inArray();
                    JsonParser jsonParser = this.delegate;
                    if (zInArray) {
                        JsonToken currentToken = jsonParser.getCurrentToken();
                        this._currToken = currentToken;
                        if (currentToken == JsonToken.END_ARRAY) {
                            TokenFilterContext parent = this._headContext.getParent();
                            this._headContext = parent;
                            this._itemFilter = parent.getFilter();
                        }
                        return currentToken;
                    }
                    JsonToken jsonTokenCurrentToken = jsonParser.currentToken();
                    if (jsonTokenCurrentToken == JsonToken.END_OBJECT) {
                        TokenFilterContext parent2 = this._headContext.getParent();
                        this._headContext = parent2;
                        this._itemFilter = parent2.getFilter();
                    }
                    if (jsonTokenCurrentToken != JsonToken.FIELD_NAME) {
                        this._currToken = jsonTokenCurrentToken;
                        return jsonTokenCurrentToken;
                    }
                } else {
                    tokenFilterContextFindChildOf = tokenFilterContext.findChildOf(tokenFilterContextFindChildOf);
                    this._exposedContext = tokenFilterContextFindChildOf;
                }
            } while (tokenFilterContextFindChildOf != null);
            throw _constructError("Unexpected problem: chain of filtered context broken");
        }
        JsonToken jsonTokenNextToken = this.delegate.nextToken();
        if (jsonTokenNextToken == null) {
            this._currToken = jsonTokenNextToken;
            return jsonTokenNextToken;
        }
        int iId = jsonTokenNextToken.id();
        if (iId == -1) {
            throw _constructError("`JsonToken.NOT_AVAILABLE` received: ensure all input is fed to the Parser before use");
        }
        if (iId == 1) {
            TokenFilter tokenFilter = this._itemFilter;
            TokenFilter tokenFilter2 = TokenFilter.INCLUDE_ALL;
            if (tokenFilter == tokenFilter2) {
                this._headContext = this._headContext.createChildObjectContext(tokenFilter, true);
                this._currToken = jsonTokenNextToken;
                return jsonTokenNextToken;
            }
            if (tokenFilter == null || (tokenFilterCheckValue = this._headContext.checkValue(tokenFilter)) == null) {
                this.delegate.skipChildren();
            } else {
                if (tokenFilterCheckValue != tokenFilter2) {
                    tokenFilterCheckValue = tokenFilterCheckValue.filterStartObject();
                }
                this._itemFilter = tokenFilterCheckValue;
                if (tokenFilterCheckValue == tokenFilter2) {
                    this._headContext = this._headContext.createChildObjectContext(tokenFilterCheckValue, true);
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
                if (tokenFilterCheckValue != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                    this._headContext = this._headContext.createChildObjectContext(tokenFilterCheckValue, true);
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
                TokenFilterContext tokenFilterContextCreateChildObjectContext = this._headContext.createChildObjectContext(tokenFilterCheckValue, false);
                this._headContext = tokenFilterContextCreateChildObjectContext;
                if (this._inclusion == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH && (jsonToken_nextTokenWithBuffering = _nextTokenWithBuffering(tokenFilterContextCreateChildObjectContext)) != null) {
                    this._currToken = jsonToken_nextTokenWithBuffering;
                    return jsonToken_nextTokenWithBuffering;
                }
            }
        } else if (iId == 2) {
            boolean zIsStartHandled = this._headContext.isStartHandled();
            TokenFilter filter = this._headContext.getFilter();
            if (filter != null && filter != TokenFilter.INCLUDE_ALL) {
                if (jsonTokenNextToken.id() == 4) {
                    filter.filterFinishArray();
                } else {
                    filter.filterFinishObject();
                }
            }
            TokenFilterContext parent3 = this._headContext.getParent();
            this._headContext = parent3;
            this._itemFilter = parent3.getFilter();
            if (zIsStartHandled) {
                this._currToken = jsonTokenNextToken;
                return jsonTokenNextToken;
            }
        } else if (iId == 3) {
            TokenFilter tokenFilter3 = this._itemFilter;
            TokenFilter tokenFilter4 = TokenFilter.INCLUDE_ALL;
            if (tokenFilter3 == tokenFilter4) {
                this._headContext = this._headContext.createChildArrayContext(tokenFilter3, true);
                this._currToken = jsonTokenNextToken;
                return jsonTokenNextToken;
            }
            if (tokenFilter3 == null || (tokenFilterCheckValue2 = this._headContext.checkValue(tokenFilter3)) == null) {
                this.delegate.skipChildren();
            } else {
                if (tokenFilterCheckValue2 != tokenFilter4) {
                    tokenFilterCheckValue2 = tokenFilterCheckValue2.filterStartArray();
                }
                this._itemFilter = tokenFilterCheckValue2;
                if (tokenFilterCheckValue2 == tokenFilter4) {
                    this._headContext = this._headContext.createChildArrayContext(tokenFilterCheckValue2, true);
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
                if (tokenFilterCheckValue2 != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                    this._headContext = this._headContext.createChildArrayContext(tokenFilterCheckValue2, true);
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
                TokenFilterContext tokenFilterContextCreateChildArrayContext = this._headContext.createChildArrayContext(tokenFilterCheckValue2, false);
                this._headContext = tokenFilterContextCreateChildArrayContext;
                if (this._inclusion == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH && (jsonToken_nextTokenWithBuffering2 = _nextTokenWithBuffering(tokenFilterContextCreateChildArrayContext)) != null) {
                    this._currToken = jsonToken_nextTokenWithBuffering2;
                    return jsonToken_nextTokenWithBuffering2;
                }
            }
        } else if (iId != 4) {
            if (iId != 5) {
                TokenFilter tokenFilter5 = this._itemFilter;
                TokenFilter tokenFilter6 = TokenFilter.INCLUDE_ALL;
                if (tokenFilter5 == tokenFilter6) {
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
                if (tokenFilter5 != null && (((tokenFilterCheckValue3 = this._headContext.checkValue(tokenFilter5)) == tokenFilter6 || (tokenFilterCheckValue3 != null && tokenFilterCheckValue3.includeValue(this.delegate))) && _verifyAllowedMatches())) {
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
            } else {
                String strCurrentName = this.delegate.currentName();
                TokenFilter fieldName = this._headContext.setFieldName(strCurrentName);
                TokenFilter tokenFilter7 = TokenFilter.INCLUDE_ALL;
                if (fieldName == tokenFilter7) {
                    this._itemFilter = fieldName;
                    this._currToken = jsonTokenNextToken;
                    return jsonTokenNextToken;
                }
                if (fieldName == null || (tokenFilterIncludeProperty = fieldName.includeProperty(strCurrentName)) == null) {
                    this.delegate.nextToken();
                    this.delegate.skipChildren();
                } else {
                    this._itemFilter = tokenFilterIncludeProperty;
                    if (tokenFilterIncludeProperty == tokenFilter7) {
                        if (!_verifyAllowedMatches()) {
                            this.delegate.nextToken();
                            this.delegate.skipChildren();
                        } else if (this._inclusion == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH) {
                            this._currToken = jsonTokenNextToken;
                            return jsonTokenNextToken;
                        }
                    }
                    if (this._inclusion != TokenFilter.Inclusion.ONLY_INCLUDE_ALL && (jsonToken_nextTokenWithBuffering3 = _nextTokenWithBuffering(this._headContext)) != null) {
                        this._currToken = jsonToken_nextTokenWithBuffering3;
                        return jsonToken_nextTokenWithBuffering3;
                    }
                }
            }
        }
        return _nextToken2();
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) {
        return this.delegate.readBinaryValue(base64Variant, outputStream);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser skipChildren() throws JsonParseException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
            int i = 1;
            while (true) {
                JsonToken jsonTokenNextToken = nextToken();
                if (jsonTokenNextToken == null) {
                    break;
                }
                if (!jsonTokenNextToken.isStructStart()) {
                    if (jsonTokenNextToken.isStructEnd() && i - 1 == 0) {
                        break;
                    }
                } else {
                    i++;
                }
            }
        }
        return this;
    }
}
