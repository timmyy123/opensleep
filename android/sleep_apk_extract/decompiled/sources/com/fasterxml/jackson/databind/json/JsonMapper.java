package com.fasterxml.jackson.databind.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;

/* JADX INFO: loaded from: classes5.dex */
public class JsonMapper extends ObjectMapper {
    private static final long serialVersionUID = 1;

    public static class Builder extends MapperBuilder<JsonMapper, Builder> {
        public Builder(JsonMapper jsonMapper) {
            super(jsonMapper);
        }
    }

    public JsonMapper() {
        this(new JsonFactory());
    }

    public static Builder builder(JsonFactory jsonFactory) {
        return new Builder(new JsonMapper(jsonFactory));
    }

    @Override // com.fasterxml.jackson.databind.ObjectMapper
    public JsonFactory getFactory() {
        return this._jsonFactory;
    }

    public JsonMapper(JsonFactory jsonFactory) {
        super(jsonFactory);
    }
}
