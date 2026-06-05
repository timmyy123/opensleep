package io.ktor.client.plugins;

import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR*\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\f0\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/HttpPlainTextConfig;", "", "<init>", "()V", "", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charsets", "Ljava/util/Set;", "getCharsets$ktor_client_core", "()Ljava/util/Set;", "", "", "charsetQuality", "Ljava/util/Map;", "getCharsetQuality$ktor_client_core", "()Ljava/util/Map;", "sendCharset", "Ljava/nio/charset/Charset;", "getSendCharset", "()Ljava/nio/charset/Charset;", "setSendCharset", "(Ljava/nio/charset/Charset;)V", "responseCharsetFallback", "getResponseCharsetFallback", "setResponseCharsetFallback", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpPlainTextConfig {
    private Charset sendCharset;
    private final Set<Charset> charsets = new LinkedHashSet();
    private final Map<Charset, Float> charsetQuality = new LinkedHashMap();
    private Charset responseCharsetFallback = Charsets.UTF_8;

    public final Map<Charset, Float> getCharsetQuality$ktor_client_core() {
        return this.charsetQuality;
    }

    public final Set<Charset> getCharsets$ktor_client_core() {
        return this.charsets;
    }

    public final Charset getResponseCharsetFallback() {
        return this.responseCharsetFallback;
    }

    public final Charset getSendCharset() {
        return this.sendCharset;
    }
}
