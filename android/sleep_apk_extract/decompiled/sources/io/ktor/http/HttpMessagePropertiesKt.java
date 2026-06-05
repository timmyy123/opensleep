package io.ktor.http;

import java.nio.charset.Charset;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0006\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0007¢\u0006\u0004\b\u0004\u0010\b\u001a\u0019\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n*\u00020\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/http/HttpMessageBuilder;", "Lio/ktor/http/ContentType;", "type", "", "contentType", "(Lio/ktor/http/HttpMessageBuilder;Lio/ktor/http/ContentType;)V", "(Lio/ktor/http/HttpMessageBuilder;)Lio/ktor/http/ContentType;", "Lio/ktor/http/HttpMessage;", "(Lio/ktor/http/HttpMessage;)Lio/ktor/http/ContentType;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", "(Lio/ktor/http/HttpMessage;)Ljava/nio/charset/Charset;", "", "contentLength", "(Lio/ktor/http/HttpMessage;)Ljava/lang/Long;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class HttpMessagePropertiesKt {
    public static final Charset charset(HttpMessage httpMessage) {
        httpMessage.getClass();
        ContentType contentType = contentType(httpMessage);
        if (contentType != null) {
            return ContentTypesKt.charset(contentType);
        }
        return null;
    }

    public static final Long contentLength(HttpMessage httpMessage) {
        httpMessage.getClass();
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final ContentType contentType(HttpMessageBuilder httpMessageBuilder) {
        httpMessageBuilder.getClass();
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        if (str != null) {
            return ContentType.INSTANCE.parse(str);
        }
        return null;
    }

    public static final void contentType(HttpMessageBuilder httpMessageBuilder, ContentType contentType) {
        httpMessageBuilder.getClass();
        contentType.getClass();
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getContentType(), contentType.toString());
    }

    public static final ContentType contentType(HttpMessage httpMessage) {
        httpMessage.getClass();
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        if (str != null) {
            return ContentType.INSTANCE.parse(str);
        }
        return null;
    }
}
