package com.google.api.client.json;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JsonFactory {
    private ByteArrayOutputStream toByteStream(Object obj, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JsonGenerator jsonGeneratorCreateJsonGenerator = createJsonGenerator(byteArrayOutputStream, StandardCharsets.UTF_8);
        if (z) {
            jsonGeneratorCreateJsonGenerator.enablePrettyPrint();
        }
        jsonGeneratorCreateJsonGenerator.serialize(obj);
        jsonGeneratorCreateJsonGenerator.flush();
        return byteArrayOutputStream;
    }

    private String toString(Object obj, boolean z) {
        return toByteStream(obj, z).toString(OAuth.ENCODING);
    }

    public abstract JsonGenerator createJsonGenerator(OutputStream outputStream, Charset charset);

    public abstract JsonParser createJsonParser(InputStream inputStream);

    public abstract JsonParser createJsonParser(InputStream inputStream, Charset charset);

    public abstract JsonParser createJsonParser(Reader reader);

    public abstract JsonParser createJsonParser(String str);

    public final <T> T fromInputStream(InputStream inputStream, Class<T> cls) {
        return (T) createJsonParser(inputStream).parseAndClose(cls);
    }

    public final <T> T fromReader(Reader reader, Class<T> cls) {
        return (T) createJsonParser(reader).parseAndClose(cls);
    }

    public final String toPrettyString(Object obj) {
        return toString(obj, true);
    }

    public final String toString(Object obj) {
        return toString(obj, false);
    }
}
