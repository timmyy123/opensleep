package com.google.api.client.http.json;

import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Preconditions;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class JsonHttpContent extends AbstractHttpContent {

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private final Object f46data;
    private final JsonFactory jsonFactory;
    private String wrapperKey;

    public JsonHttpContent(JsonFactory jsonFactory, Object obj) {
        super("application/json; charset=UTF-8");
        this.jsonFactory = (JsonFactory) Preconditions.checkNotNull(jsonFactory);
        this.f46data = Preconditions.checkNotNull(obj);
    }

    public JsonHttpContent setWrapperKey(String str) {
        this.wrapperKey = str;
        return this;
    }

    @Override // com.google.api.client.util.StreamingContent
    public void writeTo(OutputStream outputStream) {
        JsonGenerator jsonGeneratorCreateJsonGenerator = this.jsonFactory.createJsonGenerator(outputStream, getCharset());
        if (this.wrapperKey != null) {
            jsonGeneratorCreateJsonGenerator.writeStartObject();
            jsonGeneratorCreateJsonGenerator.writeFieldName(this.wrapperKey);
        }
        jsonGeneratorCreateJsonGenerator.serialize(this.f46data);
        if (this.wrapperKey != null) {
            jsonGeneratorCreateJsonGenerator.writeEndObject();
        }
        jsonGeneratorCreateJsonGenerator.flush();
    }
}
