package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.utils.EmptyContent;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.http.Url;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0018\u0010\u0002\u001a\u00060\u0000j\u0002`\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"$\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "", "Lkotlin/reflect/KClass;", "DefaultCommonIgnoredTypes", "Ljava/util/Set;", "getDefaultCommonIgnoredTypes", "()Ljava/util/Set;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/contentnegotiation/ContentNegotiationConfig;", "ContentNegotiation", "Lio/ktor/client/plugins/api/ClientPlugin;", "getContentNegotiation", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getContentNegotiation$annotations", "()V", "ktor-client-content-negotiation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ContentNegotiationKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.contentnegotiation.ContentNegotiation");
    private static final Set<KClass<?>> DefaultCommonIgnoredTypes = SetsKt.setOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(byte[].class), Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(HttpStatusCode.class), Reflection.getOrCreateKotlinClass(ByteReadChannel.class), Reflection.getOrCreateKotlinClass(OutgoingContent.class)});
    private static final ClientPlugin<ContentNegotiationConfig> ContentNegotiation = CreatePluginUtilsKt.createClientPlugin("ContentNegotiation", ContentNegotiationKt$ContentNegotiation$1.INSTANCE, new URLUtilsKt$$ExternalSyntheticLambda0(22));

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentNegotiation$lambda$13(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        List<ContentNegotiationConfig.ConverterRegistration> registrations$ktor_client_content_negotiation = ((ContentNegotiationConfig) clientPluginBuilder.getPluginConfig()).getRegistrations$ktor_client_content_negotiation();
        Set<KClass<?>> ignoredTypes$ktor_client_content_negotiation = ((ContentNegotiationConfig) clientPluginBuilder.getPluginConfig()).getIgnoredTypes$ktor_client_content_negotiation();
        clientPluginBuilder.transformRequestBody(new ContentNegotiationKt$ContentNegotiation$2$1(registrations$ktor_client_content_negotiation, ignoredTypes$ktor_client_content_negotiation, clientPluginBuilder, null));
        clientPluginBuilder.transformResponseBody(new ContentNegotiationKt$ContentNegotiation$2$2(ignoredTypes$ktor_client_content_negotiation, registrations$ktor_client_content_negotiation, clientPluginBuilder, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0233 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0234  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x01fb -> B:72:0x01fe). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object ContentNegotiation$lambda$13$convertRequest(List<ContentNegotiationConfig.ConverterRegistration> list, Set<? extends KClass<?>> set, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, HttpRequestBuilder httpRequestBuilder, Object obj, Continuation<? super OutgoingContent> continuation) throws ContentConverterException {
        ContentNegotiationKt$ContentNegotiation$2$convertRequest$1 contentNegotiationKt$ContentNegotiation$2$convertRequest$1;
        HttpRequestBuilder httpRequestBuilder2;
        Iterator it;
        ContentType contentType;
        List list2;
        Object obj2 = obj;
        if (continuation instanceof ContentNegotiationKt$ContentNegotiation$2$convertRequest$1) {
            contentNegotiationKt$ContentNegotiation$2$convertRequest$1 = (ContentNegotiationKt$ContentNegotiation$2$convertRequest$1) continuation;
            int i = contentNegotiationKt$ContentNegotiation$2$convertRequest$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                contentNegotiationKt$ContentNegotiation$2$convertRequest$1.label = i - Integer.MIN_VALUE;
            } else {
                contentNegotiationKt$ContentNegotiation$2$convertRequest$1 = new ContentNegotiationKt$ContentNegotiation$2$convertRequest$1(continuation);
            }
        }
        Object objSerialize = contentNegotiationKt$ContentNegotiation$2$convertRequest$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = contentNegotiationKt$ContentNegotiation$2$convertRequest$1.label;
        OutgoingContent outgoingContent = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSerialize);
            List<ContentNegotiationConfig.ConverterRegistration> list3 = list;
            for (ContentNegotiationConfig.ConverterRegistration converterRegistration : list3) {
                LOGGER.trace("Adding Accept=" + converterRegistration.getContentTypeToSend().getContentType() + " header for " + httpRequestBuilder.getUrl());
                if (!httpRequestBuilder.getHeaders().contains(HttpHeaders.INSTANCE.getAccept(), converterRegistration.getContentTypeToSend().toString())) {
                    UtilsKt.accept(httpRequestBuilder, converterRegistration.getContentTypeToSend());
                }
            }
            httpRequestBuilder2 = httpRequestBuilder;
            if (!(obj2 instanceof OutgoingContent)) {
                if (set == null || !set.isEmpty()) {
                    Iterator<T> it2 = set.iterator();
                    while (it2.hasNext()) {
                        if (((KClass) it2.next()).isInstance(obj2)) {
                        }
                    }
                }
                ContentType contentType2 = HttpMessagePropertiesKt.contentType(httpRequestBuilder2);
                if (contentType2 == null) {
                    LOGGER.trace("Request doesn't have Content-Type header. Skipping ContentNegotiation for " + httpRequestBuilder2.getUrl() + '.');
                    return null;
                }
                if (obj2 instanceof Unit) {
                    LOGGER.trace("Sending empty body for " + httpRequestBuilder2.getUrl());
                    httpRequestBuilder2.getHeaders().remove(HttpHeaders.INSTANCE.getContentType());
                    return EmptyContent.INSTANCE;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : list3) {
                    if (((ContentNegotiationConfig.ConverterRegistration) obj3).getContentTypeMatcher().contains(contentType2)) {
                        arrayList.add(obj3);
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                if (arrayList == null) {
                    LOGGER.trace("None of the registered converters match request Content-Type=" + contentType2 + ". Skipping ContentNegotiation for " + httpRequestBuilder2.getUrl() + '.');
                    return null;
                }
                if (httpRequestBuilder2.getBodyType() == null) {
                    LOGGER.trace("Request has unknown body type. Skipping ContentNegotiation for " + httpRequestBuilder2.getUrl() + '.');
                    return null;
                }
                httpRequestBuilder2.getHeaders().remove(HttpHeaders.INSTANCE.getContentType());
                it = arrayList.iterator();
                contentType = contentType2;
                list2 = arrayList;
                if (!it.hasNext()) {
                }
            }
            LOGGER.trace("Body type " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + " is in ignored types. Skipping ContentNegotiation for " + httpRequestBuilder2.getUrl() + '.');
            return null;
        }
        if (i2 != 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ContentNegotiationConfig.ConverterRegistration converterRegistration2 = (ContentNegotiationConfig.ConverterRegistration) contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$5;
        it = (Iterator) contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$4;
        list2 = (List) contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$3;
        ContentType contentType3 = (ContentType) contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$2;
        Object obj4 = contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$1;
        HttpRequestBuilder httpRequestBuilder3 = (HttpRequestBuilder) contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$0;
        ResultKt.throwOnFailure(objSerialize);
        ContentNegotiationKt$ContentNegotiation$2$convertRequest$1 contentNegotiationKt$ContentNegotiation$2$convertRequest$12 = contentNegotiationKt$ContentNegotiation$2$convertRequest$1;
        ContentType contentType4 = contentType3;
        httpRequestBuilder2 = httpRequestBuilder3;
        OutgoingContent outgoingContent2 = (OutgoingContent) objSerialize;
        if (outgoingContent2 != null) {
            LOGGER.trace("Converted request body using " + converterRegistration2.getConverter() + " for " + httpRequestBuilder2.getUrl());
        }
        if (outgoingContent2 == null) {
            outgoingContent = outgoingContent2;
            obj2 = obj4;
            contentType = contentType4;
            if (outgoingContent == null) {
                return outgoingContent;
            }
            StringBuilder sb = new StringBuilder("Can't convert ");
            sb.append(obj2);
            sb.append(" with contentType ");
            sb.append(contentType);
            String strJoinToString$default = CollectionsKt.joinToString$default(list2, null, null, null, new URLUtilsKt$$ExternalSyntheticLambda0(23), 31);
            sb.append(" using converters ");
            sb.append(strJoinToString$default);
            throw new ContentConverterException(sb.toString());
        }
        contentType = contentType4;
        obj2 = obj4;
        contentNegotiationKt$ContentNegotiation$2$convertRequest$1 = contentNegotiationKt$ContentNegotiation$2$convertRequest$12;
        if (!it.hasNext()) {
            ContentNegotiationConfig.ConverterRegistration converterRegistration3 = (ContentNegotiationConfig.ConverterRegistration) it.next();
            ContentConverter converter = converterRegistration3.getConverter();
            Charset charset = ContentTypesKt.charset(contentType);
            if (charset == null) {
                charset = Charsets.UTF_8;
            }
            TypeInfo bodyType = httpRequestBuilder2.getBodyType();
            bodyType.getClass();
            Object obj5 = !Intrinsics.areEqual(obj2, NullBody.INSTANCE) ? obj2 : null;
            contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$0 = httpRequestBuilder2;
            contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$1 = obj2;
            contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$2 = contentType;
            contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$3 = list2;
            contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$4 = it;
            contentNegotiationKt$ContentNegotiation$2$convertRequest$1.L$5 = converterRegistration3;
            contentNegotiationKt$ContentNegotiation$2$convertRequest$1.label = 1;
            ContentType contentType5 = contentType;
            ContentNegotiationKt$ContentNegotiation$2$convertRequest$1 contentNegotiationKt$ContentNegotiation$2$convertRequest$13 = contentNegotiationKt$ContentNegotiation$2$convertRequest$1;
            objSerialize = converter.serialize(contentType5, charset, bodyType, obj5, contentNegotiationKt$ContentNegotiation$2$convertRequest$13);
            contentType4 = contentType5;
            contentNegotiationKt$ContentNegotiation$2$convertRequest$12 = contentNegotiationKt$ContentNegotiation$2$convertRequest$13;
            if (objSerialize == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj4 = obj2;
            converterRegistration2 = converterRegistration3;
            OutgoingContent outgoingContent22 = (OutgoingContent) objSerialize;
            if (outgoingContent22 != null) {
            }
            if (outgoingContent22 == null) {
            }
        } else if (outgoingContent == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence ContentNegotiation$lambda$13$convertRequest$lambda$8(ContentNegotiationConfig.ConverterRegistration converterRegistration) {
        converterRegistration.getClass();
        return converterRegistration.getConverter().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object ContentNegotiation$lambda$13$convertResponse(Set<? extends KClass<?>> set, List<ContentNegotiationConfig.ConverterRegistration> list, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, Url url, TypeInfo typeInfo, Object obj, ContentType contentType, Charset charset, Continuation<Object> continuation) {
        ContentNegotiationKt$ContentNegotiation$2$convertResponse$1 contentNegotiationKt$ContentNegotiation$2$convertResponse$1;
        if (continuation instanceof ContentNegotiationKt$ContentNegotiation$2$convertResponse$1) {
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1 = (ContentNegotiationKt$ContentNegotiation$2$convertResponse$1) continuation;
            int i = contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label = i - Integer.MIN_VALUE;
            } else {
                contentNegotiationKt$ContentNegotiation$2$convertResponse$1 = new ContentNegotiationKt$ContentNegotiation$2$convertResponse$1(continuation);
            }
        }
        Object objDeserialize = contentNegotiationKt$ContentNegotiation$2$convertResponse$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objDeserialize);
            if (!(obj instanceof ByteReadChannel)) {
                LOGGER.trace("Response body is already transformed. Skipping ContentNegotiation for " + url + '.');
                return null;
            }
            if (set.contains(typeInfo.getType())) {
                LOGGER.trace("Response body type " + typeInfo.getType() + " is in ignored types. Skipping ContentNegotiation for " + url + '.');
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (((ContentNegotiationConfig.ConverterRegistration) obj2).getContentTypeMatcher().contains(contentType)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ContentNegotiationConfig.ConverterRegistration) it.next()).getConverter());
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            if (arrayList2 == null) {
                LOGGER.trace("None of the registered converters match response with Content-Type=" + contentType + ". Skipping ContentNegotiation for " + url + '.');
                return null;
            }
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$0 = url;
            contentNegotiationKt$ContentNegotiation$2$convertResponse$1.label = 1;
            objDeserialize = ContentConverterKt.deserialize(arrayList2, (ByteReadChannel) obj, typeInfo, charset, contentNegotiationKt$ContentNegotiation$2$convertResponse$1);
            if (objDeserialize == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            url = (Url) contentNegotiationKt$ContentNegotiation$2$convertResponse$1.L$0;
            ResultKt.throwOnFailure(objDeserialize);
        }
        if (!(objDeserialize instanceof ByteReadChannel)) {
            LOGGER.trace("Response body was converted to " + Reflection.getOrCreateKotlinClass(objDeserialize.getClass()) + " for " + url + '.');
        }
        return objDeserialize;
    }

    public static final ClientPlugin<ContentNegotiationConfig> getContentNegotiation() {
        return ContentNegotiation;
    }

    public static final Set<KClass<?>> getDefaultCommonIgnoredTypes() {
        return DefaultCommonIgnoredTypes;
    }
}
