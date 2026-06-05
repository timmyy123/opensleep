package io.ktor.client.plugins.contentnegotiation;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.TransformResponseBodyContext;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.Url;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/api/TransformResponseBodyContext;", "response", "Lio/ktor/client/statement/HttpResponse;", SDKConstants.PARAM_A2U_BODY, "Lio/ktor/utils/io/ByteReadChannel;", "info", "Lio/ktor/util/reflect/TypeInfo;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt$ContentNegotiation$2$2", f = "ContentNegotiation.kt", l = {249}, m = "invokeSuspend")
public final class ContentNegotiationKt$ContentNegotiation$2$2 extends SuspendLambda implements Function5<TransformResponseBodyContext, HttpResponse, ByteReadChannel, TypeInfo, Continuation<? super Object>, Object> {
    final /* synthetic */ Set<KClass<?>> $ignoredTypes;
    final /* synthetic */ List<ContentNegotiationConfig.ConverterRegistration> $registrations;
    final /* synthetic */ ClientPluginBuilder<ContentNegotiationConfig> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContentNegotiationKt$ContentNegotiation$2$2(Set<? extends KClass<?>> set, List<ContentNegotiationConfig.ConverterRegistration> list, ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder, Continuation<? super ContentNegotiationKt$ContentNegotiation$2$2> continuation) {
        super(5, continuation);
        this.$ignoredTypes = set;
        this.$registrations = list;
        this.$this_createClientPlugin = clientPluginBuilder;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(TransformResponseBodyContext transformResponseBodyContext, HttpResponse httpResponse, ByteReadChannel byteReadChannel, TypeInfo typeInfo, Continuation<Object> continuation) {
        ContentNegotiationKt$ContentNegotiation$2$2 contentNegotiationKt$ContentNegotiation$2$2 = new ContentNegotiationKt$ContentNegotiation$2$2(this.$ignoredTypes, this.$registrations, this.$this_createClientPlugin, continuation);
        contentNegotiationKt$ContentNegotiation$2$2.L$0 = httpResponse;
        contentNegotiationKt$ContentNegotiation$2$2.L$1 = byteReadChannel;
        contentNegotiationKt$ContentNegotiation$2$2.L$2 = typeInfo;
        return contentNegotiationKt$ContentNegotiation$2$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        HttpResponse httpResponse = (HttpResponse) this.L$0;
        ByteReadChannel byteReadChannel = (ByteReadChannel) this.L$1;
        TypeInfo typeInfo = (TypeInfo) this.L$2;
        ContentType contentType = HttpMessagePropertiesKt.contentType(httpResponse);
        if (contentType == null) {
            return null;
        }
        Charset charsetSuitableCharset$default = ContentConverterKt.suitableCharset$default(HttpResponseKt.getRequest(httpResponse).getHeaders(), null, 1, null);
        Set<KClass<?>> set = this.$ignoredTypes;
        List<ContentNegotiationConfig.ConverterRegistration> list = this.$registrations;
        ClientPluginBuilder<ContentNegotiationConfig> clientPluginBuilder = this.$this_createClientPlugin;
        Url url = HttpResponseKt.getRequest(httpResponse).getUrl();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 1;
        Object objContentNegotiation$lambda$13$convertResponse = ContentNegotiationKt.ContentNegotiation$lambda$13$convertResponse(set, list, clientPluginBuilder, url, typeInfo, byteReadChannel, contentType, charsetSuitableCharset$default, this);
        return objContentNegotiation$lambda$13$convertResponse == coroutine_suspended ? coroutine_suspended : objContentNegotiation$lambda$13$convertResponse;
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(TransformResponseBodyContext transformResponseBodyContext, HttpResponse httpResponse, ByteReadChannel byteReadChannel, TypeInfo typeInfo, Continuation<? super Object> continuation) {
        return invoke2(transformResponseBodyContext, httpResponse, byteReadChannel, typeInfo, (Continuation<Object>) continuation);
    }
}
