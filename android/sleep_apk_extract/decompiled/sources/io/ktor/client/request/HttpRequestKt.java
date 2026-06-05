package io.ktor.client.request;

import io.ktor.http.URLParserKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u0007*\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\t\"&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "", "urlString", "", "url", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;)V", "Lio/ktor/client/request/HttpRequestData;", "", "isUpgradeRequest", "(Lio/ktor/client/request/HttpRequestData;)Z", "isSseRequest", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/request/ResponseAdapter;", "ResponseAdapterAttributeKey", "Lio/ktor/util/AttributeKey;", "getResponseAdapterAttributeKey", "()Lio/ktor/util/AttributeKey;", "getResponseAdapterAttributeKey$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class HttpRequestKt {
    private static final AttributeKey<ResponseAdapter> ResponseAdapterAttributeKey;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ResponseAdapter.class);
        try {
            kTypeTypeOf = Reflection.typeOf(ResponseAdapter.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        ResponseAdapterAttributeKey = new AttributeKey<>("ResponseAdapterAttributeKey", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
    }

    public static final boolean isSseRequest(HttpRequestData httpRequestData) {
        httpRequestData.getClass();
        httpRequestData.getBody();
        return false;
    }

    public static final boolean isUpgradeRequest(HttpRequestData httpRequestData) {
        httpRequestData.getClass();
        return httpRequestData.getBody() instanceof ClientUpgradeContent;
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, String str) {
        httpRequestBuilder.getClass();
        str.getClass();
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), str);
    }
}
