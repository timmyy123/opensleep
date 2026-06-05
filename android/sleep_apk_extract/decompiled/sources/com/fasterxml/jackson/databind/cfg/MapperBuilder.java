package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MapperBuilder<M extends ObjectMapper, B extends MapperBuilder<M, B>> {
    protected final M _mapper;

    public MapperBuilder(M m) {
        this._mapper = m;
    }

    public final B _this() {
        return this;
    }

    public M build() {
        return this._mapper;
    }

    public B configure(DeserializationFeature deserializationFeature, boolean z) {
        this._mapper.configure(deserializationFeature, z);
        return (B) _this();
    }

    public B enable(MapperFeature... mapperFeatureArr) {
        this._mapper.enable(mapperFeatureArr);
        return (B) _this();
    }
}
