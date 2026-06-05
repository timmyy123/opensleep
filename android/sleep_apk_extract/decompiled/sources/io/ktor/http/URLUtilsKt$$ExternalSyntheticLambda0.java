package io.ktor.http;

import com.urbandroid.sleep.service.matter.MatterManager;
import com.urbandroid.sleep.smartwatch.MultiSmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.fitbit.FitbitHttpServerService;
import com.urbandroid.sleep.smartwatch.fitbit.FitbitMessage;
import com.urbandroid.sleep.smartwatch.pebble.RePebbleListenerService;
import com.urbandroid.sleep.smartwatch.zepp.ZeppHttpServerService;
import com.urbandroid.sleep.smartwatch.zepp.ZeppMessage;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import io.ktor.client.engine.okhttp.OkHttpEngine;
import io.ktor.client.plugins.BodyProgressKt;
import io.ktor.client.plugins.DoubleReceivePluginKt;
import io.ktor.client.plugins.HttpCallValidatorKt;
import io.ktor.client.plugins.HttpPlainTextKt;
import io.ktor.client.plugins.HttpRedirectKt;
import io.ktor.client.plugins.HttpRequestLifecycleKt;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import io.ktor.util.CaseInsensitiveMap;
import io.ktor.util.CaseInsensitiveString;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.json.JsonBuilder;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class URLUtilsKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ URLUtilsKt$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return URLUtilsKt.appendUrlFullPath$lambda$6((Pair) obj);
            case 1:
                return MatterManager.handleCommissioningResult$lambda$0((String) obj);
            case 2:
                return MultiSmartWatch.getPlatform$lambda$0((SmartWatch) obj);
            case 3:
                return Boolean.valueOf(FitbitHttpServerService.handleFromWatch$lambda$0((FitbitMessage) obj));
            case 4:
                return FitbitHttpServerService.AnonymousClass1.serve$lambda$1((FitbitMessage) obj);
            case 5:
                return RePebbleListenerService.onMessageReceived_PjNdOfI$lambda$1((String) obj);
            case 6:
                return RePebbleListenerService.onMessageReceived_PjNdOfI$lambda$3((String) obj);
            case 7:
                return Boolean.valueOf(ZeppHttpServerService.handleFromWatch$lambda$0((ZeppMessage) obj));
            case 8:
                return ZeppHttpServerService.AnonymousClass1.serve$lambda$1((ZeppMessage) obj);
            case 9:
                return HttpClient.lambda$2$lambda$1((HttpClient) obj);
            case 10:
                return HttpClientConfig.install$lambda$2(obj);
            case 11:
                return HttpClientConfig.engineConfig$lambda$0((HttpClientEngineConfig) obj);
            case 12:
                return HttpClientEngineFactory.DefaultImpls.create$lambda$0((HttpClientEngineConfig) obj);
            case 13:
                return OkHttpConfig.config$lambda$0((OkHttpClient.Builder) obj);
            case 14:
                return OkHttpEngine.clientCache$lambda$0((OkHttpClient) obj);
            case 15:
                return BodyProgressKt.BodyProgress$lambda$0((ClientPluginBuilder) obj);
            case 16:
                return DoubleReceivePluginKt.SaveBodyPlugin$lambda$0((ClientPluginBuilder) obj);
            case 17:
                return HttpCallValidatorKt.HttpCallValidator$lambda$2((ClientPluginBuilder) obj);
            case 18:
                return HttpPlainTextKt.HttpPlainText$lambda$6((ClientPluginBuilder) obj);
            case 19:
                return HttpRedirectKt.HttpRedirect$lambda$2((ClientPluginBuilder) obj);
            case 20:
                return HttpRequestLifecycleKt.HttpRequestLifecycle$lambda$0((ClientPluginBuilder) obj);
            case 21:
                return HttpTimeoutKt.HttpTimeout$lambda$1((ClientPluginBuilder) obj);
            case 22:
                return ContentNegotiationKt.ContentNegotiation$lambda$13((ClientPluginBuilder) obj);
            case 23:
                return ContentNegotiationKt.ContentNegotiation$lambda$13$convertRequest$lambda$8((ContentNegotiationConfig.ConverterRegistration) obj);
            case 24:
                return Configuration.DefaultImpls.register$lambda$0((ContentConverter) obj);
            case 25:
                return JsonSupportKt.DefaultJson$lambda$0((JsonBuilder) obj);
            case 26:
                return CaseInsensitiveMap._get_entries_$lambda$3((Map.Entry) obj);
            case 27:
                return CaseInsensitiveMap._get_entries_$lambda$4((Map.Entry) obj);
            case 28:
                return CaseInsensitiveMap._get_keys_$lambda$1((CaseInsensitiveString) obj);
            default:
                return CaseInsensitiveMap._get_keys_$lambda$2((String) obj);
        }
    }
}
