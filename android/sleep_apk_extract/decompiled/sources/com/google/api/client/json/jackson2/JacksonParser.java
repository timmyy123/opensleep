package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes4.dex */
final class JacksonParser extends JsonParser {
    private final JacksonFactory factory;
    private final com.fasterxml.jackson.core.JsonParser parser;

    public JacksonParser(JacksonFactory jacksonFactory, com.fasterxml.jackson.core.JsonParser jsonParser) {
        this.factory = jacksonFactory;
        this.parser = jsonParser;
    }

    @Override // com.google.api.client.json.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.parser.close();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger getBigIntegerValue() {
        return this.parser.getBigIntegerValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public byte getByteValue() {
        return this.parser.getByteValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public String getCurrentName() {
        return this.parser.getCurrentName();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken getCurrentToken() {
        return JacksonFactory.convert(this.parser.getCurrentToken());
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal getDecimalValue() {
        return this.parser.getDecimalValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public double getDoubleValue() {
        return this.parser.getDoubleValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public float getFloatValue() {
        return this.parser.getFloatValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public int getIntValue() {
        return this.parser.getIntValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public long getLongValue() {
        return this.parser.getLongValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public short getShortValue() {
        return this.parser.getShortValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public String getText() {
        return this.parser.getText();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken nextToken() {
        return JacksonFactory.convert(this.parser.nextToken());
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser skipChildren() {
        this.parser.skipChildren();
        return this;
    }

    @Override // com.google.api.client.json.JsonParser
    public JacksonFactory getFactory() {
        return this.factory;
    }
}
