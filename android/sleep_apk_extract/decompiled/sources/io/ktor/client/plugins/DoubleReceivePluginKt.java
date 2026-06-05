package io.ktor.client.plugins;

import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006\"#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\"\u0015\u0010\u0012\u001a\u00020\u0011*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "", "skipSavingBody", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "Lio/ktor/util/AttributeKey;", "SKIP_SAVE_BODY", "Lio/ktor/util/AttributeKey;", "RESPONSE_BODY_SAVED", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/SaveBodyPluginConfig;", "SaveBodyPlugin", "Lio/ktor/client/plugins/api/ClientPlugin;", "getSaveBodyPlugin", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getSaveBodyPlugin$annotations", "()V", "Lio/ktor/client/statement/HttpResponse;", "", "isSaved", "(Lio/ktor/client/statement/HttpResponse;)Z", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class DoubleReceivePluginKt {
    private static final AttributeKey<Unit> RESPONSE_BODY_SAVED;
    private static final AttributeKey<Unit> SKIP_SAVE_BODY;
    private static final ClientPlugin<SaveBodyPluginConfig> SaveBodyPlugin;

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Unit.class);
        KType kTypeTypeOf2 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(Unit.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        SKIP_SAVE_BODY = new AttributeKey<>("SkipSaveBody", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Unit.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(Unit.class);
        } catch (Throwable unused2) {
        }
        RESPONSE_BODY_SAVED = new AttributeKey<>("ResponseBodySaved", new TypeInfo(orCreateKotlinClass2, kTypeTypeOf2));
        SaveBodyPlugin = CreatePluginUtilsKt.createClientPlugin("DoubleReceivePlugin", DoubleReceivePluginKt$SaveBodyPlugin$1.INSTANCE, new URLUtilsKt$$ExternalSyntheticLambda0(16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveBodyPlugin$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        clientPluginBuilder.getClient().getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getBefore(), new DoubleReceivePluginKt$SaveBodyPlugin$2$1(((SaveBodyPluginConfig) clientPluginBuilder.getPluginConfig()).getDisabled(), null));
        return Unit.INSTANCE;
    }

    public static final ClientPlugin<SaveBodyPluginConfig> getSaveBodyPlugin() {
        return SaveBodyPlugin;
    }

    public static final boolean isSaved(HttpResponse httpResponse) {
        httpResponse.getClass();
        return httpResponse.getCall().getAttributes().contains(RESPONSE_BODY_SAVED);
    }

    public static final void skipSavingBody(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        httpRequestBuilder.getAttributes().put(SKIP_SAVE_BODY, Unit.INSTANCE);
    }
}
