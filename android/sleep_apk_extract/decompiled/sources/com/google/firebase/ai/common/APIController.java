package com.google.firebase.ai.common;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.util.Log;
import androidx.work.Data$$ExternalSyntheticLambda0;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ai.common.util.UtilKt;
import com.google.firebase.ai.type.CountTokensResponse;
import com.google.firebase.ai.type.FirebaseAIException;
import com.google.firebase.ai.type.GenerateContentResponse;
import com.google.firebase.ai.type.GenerativeBackend;
import com.google.firebase.ai.type.GenerativeBackendEnum;
import com.google.firebase.ai.type.ImagenGenerationResponse;
import com.google.firebase.ai.type.RequestOptions;
import com.google.firebase.ai.type.Response;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientKt;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt;
import io.ktor.client.plugins.websocket.BuildersKt;
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession;
import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.json.Json;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u0000 \\2\u00020\u0001:\u0001\\Ba\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014BI\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0015J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001cH\u0086@¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u001f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J\u0018\u0010$\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\"H\u0086@¢\u0006\u0004\b$\u0010%J \u0010'\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020&H\u0086@¢\u0006\u0004\b'\u0010(J\u0018\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00180\u001f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b-\u0010.J\u0018\u00101\u001a\u0002002\u0006\u0010\u0017\u001a\u00020/H\u0086@¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0002H\u0002¢\u0006\u0004\b3\u00104J\u0013\u00107\u001a\u000206*\u000205H\u0002¢\u0006\u0004\b7\u00108J\u001b\u0010:\u001a\u000206*\u0002052\u0006\u0010\u0017\u001a\u000209H\u0002¢\u0006\u0004\b:\u0010;J\u0014\u0010<\u001a\u000206*\u000205H\u0082@¢\u0006\u0004\b<\u0010=JD\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f\"\n\b\u0000\u0010?\u0018\u0001*\u00020>*\u00020@2\u0006\u0010A\u001a\u00020\u00022\u0014\b\u0006\u0010C\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002060BH\u0082\b¢\u0006\u0004\bD\u0010EJ\u0011\u0010F\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\bF\u0010GJ\u0011\u0010I\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0004\bI\u0010JR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010KR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010LR\u001a\u0010\t\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010K\u001a\u0004\bM\u0010GR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010NR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010OR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010KR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010PR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010QR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010KR#\u0010V\u001a\n R*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010GR\u001d\u0010Y\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010T\u001a\u0004\bX\u0010GR\u0014\u0010Z\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006]"}, d2 = {"Lcom/google/firebase/ai/common/APIController;", "", "", SDKConstants.PARAM_KEY, DeviceRequestsHelper.DEVICE_INFO_MODEL, "Lcom/google/firebase/ai/type/RequestOptions;", "requestOptions", "Lio/ktor/client/engine/HttpClientEngine;", "httpEngine", "apiClient", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "", "appVersion", "googleAppId", "Lcom/google/firebase/ai/common/HeaderProvider;", "headerProvider", "Lcom/google/firebase/ai/type/GenerativeBackend;", "backend", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/ai/type/RequestOptions;Lio/ktor/client/engine/HttpClientEngine;Ljava/lang/String;Lcom/google/firebase/FirebaseApp;ILjava/lang/String;Lcom/google/firebase/ai/common/HeaderProvider;Lcom/google/firebase/ai/type/GenerativeBackend;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/ai/type/RequestOptions;Ljava/lang/String;Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/ai/common/HeaderProvider;Lcom/google/firebase/ai/type/GenerativeBackend;)V", "Lcom/google/firebase/ai/common/GenerateContentRequest;", "request", "Lcom/google/firebase/ai/type/GenerateContentResponse$Internal;", "generateContent", "(Lcom/google/firebase/ai/common/GenerateContentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "templateId", "Lcom/google/firebase/ai/common/TemplateGenerateContentRequest;", "templateGenerateContent", "(Ljava/lang/String;Lcom/google/firebase/ai/common/TemplateGenerateContentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "templateGenerateContentStream", "(Ljava/lang/String;Lcom/google/firebase/ai/common/TemplateGenerateContentRequest;)Lkotlinx/coroutines/flow/Flow;", "Lcom/google/firebase/ai/common/GenerateImageRequest;", "Lcom/google/firebase/ai/type/ImagenGenerationResponse$Internal;", "generateImage", "(Lcom/google/firebase/ai/common/GenerateImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/firebase/ai/common/TemplateGenerateImageRequest;", "templateGenerateImage", "(Ljava/lang/String;Lcom/google/firebase/ai/common/TemplateGenerateImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "location", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "getWebSocketSession", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateContentStream", "(Lcom/google/firebase/ai/common/GenerateContentRequest;)Lkotlinx/coroutines/flow/Flow;", "Lcom/google/firebase/ai/common/CountTokensRequest;", "Lcom/google/firebase/ai/type/CountTokensResponse$Internal;", "countTokens", "(Lcom/google/firebase/ai/common/CountTokensRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBidiEndpoint", "(Ljava/lang/String;)Ljava/lang/String;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "applyCommonHeaders", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "Lcom/google/firebase/ai/common/Request;", "applyCommonConfiguration", "(Lio/ktor/client/request/HttpRequestBuilder;Lcom/google/firebase/ai/common/Request;)V", "applyHeaderProvider", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/firebase/ai/type/Response;", "R", "Lio/ktor/client/HttpClient;", "url", "Lkotlin/Function1;", "config", "postStream", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "getSigningCertFingerprint", "()Ljava/lang/String;", "Landroid/content/pm/Signature;", "getCurrentSignature", "()Landroid/content/pm/Signature;", "Ljava/lang/String;", "Lcom/google/firebase/ai/type/RequestOptions;", "getApiClient$com_google_firebase_ai_logic_firebase_ai", "Lcom/google/firebase/FirebaseApp;", "I", "Lcom/google/firebase/ai/common/HeaderProvider;", "Lcom/google/firebase/ai/type/GenerativeBackend;", "kotlin.jvm.PlatformType", "appPackageName$delegate", "Lkotlin/Lazy;", "getAppPackageName", "appPackageName", "appSigningCertFingerprint$delegate", "getAppSigningCertFingerprint", "appSigningCertFingerprint", "client", "Lio/ktor/client/HttpClient;", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class APIController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "APIController";
    private final String apiClient;

    /* JADX INFO: renamed from: appPackageName$delegate, reason: from kotlin metadata */
    private final Lazy appPackageName;

    /* JADX INFO: renamed from: appSigningCertFingerprint$delegate, reason: from kotlin metadata */
    private final Lazy appSigningCertFingerprint;
    private final int appVersion;
    private final GenerativeBackend backend;
    private final HttpClient client;
    private final FirebaseApp firebaseApp;
    private final String googleAppId;
    private final HeaderProvider headerProvider;
    private final String key;
    private final String model;
    private final RequestOptions requestOptions;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/google/firebase/ai/common/APIController$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "getVersionNumber", "", "app", "Lcom/google/firebase/FirebaseApp;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getVersionNumber(FirebaseApp app) {
            try {
                Context applicationContext = app.getApplicationContext();
                applicationContext.getClass();
                return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionCode;
            } catch (Exception e) {
                Log.d(APIController.TAG, "Error while getting app version: " + e.getMessage());
                return 0;
            }
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GenerativeBackendEnum.values().length];
            try {
                iArr[GenerativeBackendEnum.VERTEX_AI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GenerativeBackendEnum.GOOGLE_AI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$applyHeaderProvider$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIController", f = "APIController.kt", l = {299}, m = "applyHeaderProvider")
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return APIController.this.applyHeaderProvider(null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$applyHeaderProvider$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIController$applyHeaderProvider$2", f = "APIController.kt", l = {300}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HttpRequestBuilder $this_applyHeaderProvider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpRequestBuilder httpRequestBuilder, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_applyHeaderProvider = httpRequestBuilder;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return APIController.this.new AnonymousClass2(this.$this_applyHeaderProvider, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HeaderProvider headerProvider = APIController.this.headerProvider;
                this.label = 1;
                obj = headerProvider.generateHeaders(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                UtilsKt.header(this.$this_applyHeaderProvider, (String) entry.getKey(), (String) entry.getValue());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$countTokens$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIController", f = "APIController.kt", l = {266, 520, 268, 522}, m = "countTokens")
    public static final class C20481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C20481(Continuation<? super C20481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return APIController.this.countTokens(null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$generateContent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIController", f = "APIController.kt", l = {165, 520, 167, 522}, m = "generateContent")
    public static final class C20491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C20491(Continuation<? super C20491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return APIController.this.generateContent(null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$generateContentStream$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/google/firebase/ai/type/GenerateContentResponse$Internal;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIController$generateContentStream$3", f = "APIController.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super GenerateContentResponse.Internal>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super GenerateContentResponse.Internal> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = th;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw FirebaseAIException.INSTANCE.from$com_google_firebase_ai_logic_firebase_ai((Throwable) this.L$0);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$generateImage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIController", f = "APIController.kt", l = {211, 520, 213, 522}, m = "generateImage")
    public static final class C20501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C20501(Continuation<? super C20501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return APIController.this.generateImage(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$postStream$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "R", "Lcom/google/firebase/ai/type/Response;", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIController$postStream$2", f = "APIController.kt", l = {}, m = "invokeSuspend")
    public static final class C20522<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<HttpRequestBuilder, Unit> $config;
        final /* synthetic */ HttpClient $this_postStream;
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ APIController this$0;

        /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$postStream$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.google.firebase.ai.common.APIController$postStream$2$1", f = "APIController.kt", l = {343, 346}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProducerScope<R> $$this$channelFlow;
            final /* synthetic */ Function1<HttpRequestBuilder, Unit> $config;
            final /* synthetic */ HttpClient $this_postStream;
            final /* synthetic */ String $url;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            final /* synthetic */ APIController this$0;

            /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$postStream$2$1$2, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.google.firebase.ai.common.APIController$postStream$2$1$2", f = "APIController.kt", l = {347, 349, 352}, m = "invokeSuspend")
            public static final class C00132 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
                final /* synthetic */ ProducerScope<R> $$this$channelFlow;
                /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C00132(ProducerScope<? super R> producerScope, Continuation<? super C00132> continuation) {
                    super(2, continuation);
                    this.$$this$channelFlow = producerScope;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00132 c00132 = new C00132(this.$$this$channelFlow, continuation);
                    c00132.L$0 = obj;
                    return c00132;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
                    return ((C00132) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
                
                    if (r7.collect(r1, r6) != r0) goto L21;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) throws Throwable {
                    HttpResponse httpResponse;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        httpResponse = (HttpResponse) this.L$0;
                        this.L$0 = httpResponse;
                        this.label = 1;
                        if (APIControllerKt.validateResponse(httpResponse, this) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i == 1) {
                        httpResponse = (HttpResponse) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            if (i == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        Json json = APIControllerKt.getJSON();
                        Intrinsics.needClassReification();
                        Flow flowChannelFlow = FlowKt.channelFlow(new APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1((ByteReadChannel) obj, json, null));
                        final ProducerScope<R> producerScope = this.$$this$channelFlow;
                        FlowCollector flowCollector = new FlowCollector() { // from class: com.google.firebase.ai.common.APIController.postStream.2.1.2.1
                            /* JADX WARN: Incorrect types in method signature: (TR;Lkotlin/coroutines/Continuation<-Lkotlin/Unit;>;)Ljava/lang/Object; */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(Response response, Continuation continuation) {
                                Object objSend = producerScope.send(response, continuation);
                                return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                            }
                        };
                        this.label = 3;
                    }
                    this.L$0 = null;
                    this.label = 2;
                    obj = HttpResponseKt.bodyAsChannel(httpResponse, this);
                    if (obj != coroutine_suspended) {
                        Json json2 = APIControllerKt.getJSON();
                        Intrinsics.needClassReification();
                        Flow flowChannelFlow2 = FlowKt.channelFlow(new APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1((ByteReadChannel) obj, json2, null));
                        final ProducerScope<? super R> producerScope2 = this.$$this$channelFlow;
                        FlowCollector flowCollector2 = new FlowCollector() { // from class: com.google.firebase.ai.common.APIController.postStream.2.1.2.1
                            /* JADX WARN: Incorrect types in method signature: (TR;Lkotlin/coroutines/Continuation<-Lkotlin/Unit;>;)Ljava/lang/Object; */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(Response response, Continuation continuation) {
                                Object objSend = producerScope2.send(response, continuation);
                                return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                            }
                        };
                        this.label = 3;
                    }
                    return coroutine_suspended;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(HttpClient httpClient, String str, APIController aPIController, Function1<? super HttpRequestBuilder, Unit> function1, ProducerScope<? super R> producerScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$this_postStream = httpClient;
                this.$url = str;
                this.this$0 = aPIController;
                this.$config = function1;
                this.$$this$channelFlow = producerScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$this_postStream, this.$url, this.this$0, this.$config, this.$$this$channelFlow, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x007c, code lost:
            
                if (r9.execute(r1, r8) == r0) goto L16;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                HttpClient httpClient;
                Function1<HttpRequestBuilder, Unit> function1;
                HttpRequestBuilder httpRequestBuilder;
                HttpRequestBuilder httpRequestBuilder2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    httpClient = this.$this_postStream;
                    String str = this.$url;
                    APIController aPIController = this.this$0;
                    function1 = this.$config;
                    HttpRequestBuilder httpRequestBuilder3 = new HttpRequestBuilder();
                    HttpRequestKt.url(httpRequestBuilder3, str);
                    this.L$0 = function1;
                    this.L$1 = httpClient;
                    this.L$2 = httpRequestBuilder3;
                    this.L$3 = httpRequestBuilder3;
                    this.label = 1;
                    if (aPIController.applyHeaderProvider(httpRequestBuilder3, this) != coroutine_suspended) {
                        httpRequestBuilder = httpRequestBuilder3;
                        httpRequestBuilder2 = httpRequestBuilder;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                httpRequestBuilder = (HttpRequestBuilder) this.L$3;
                httpRequestBuilder2 = (HttpRequestBuilder) this.L$2;
                httpClient = (HttpClient) this.L$1;
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure(obj);
                function1.invoke(httpRequestBuilder);
                httpRequestBuilder2.setMethod(HttpMethod.INSTANCE.getPost());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder2, httpClient);
                Intrinsics.needClassReification();
                C00132 c00132 = new C00132(this.$$this$channelFlow, null);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
            }

            public final Object invokeSuspend$$forInline(Object obj) {
                HttpClient httpClient = this.$this_postStream;
                String str = this.$url;
                APIController aPIController = this.this$0;
                Function1<HttpRequestBuilder, Unit> function1 = this.$config;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, str);
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                aPIController.applyHeaderProvider(httpRequestBuilder, null);
                InlineMarker.mark(1);
                function1.invoke(httpRequestBuilder);
                Unit unit = Unit.INSTANCE;
                httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                Intrinsics.needClassReification();
                C00132 c00132 = new C00132(this.$$this$channelFlow, null);
                InlineMarker.mark(0);
                httpStatement.execute(c00132, this);
                InlineMarker.mark(1);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C20522(HttpClient httpClient, String str, APIController aPIController, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super C20522> continuation) {
            super(2, continuation);
            this.$this_postStream = httpClient;
            this.$url = str;
            this.this$0 = aPIController;
            this.$config = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.needClassReification();
            C20522 c20522 = new C20522(this.$this_postStream, this.$url, this.this$0, this.$config, continuation);
            c20522.L$0 = obj;
            return c20522;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
            return ((C20522) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            CoroutineName coroutineName = new CoroutineName("postStream");
            Intrinsics.needClassReification();
            BuildersKt__Builders_commonKt.launch$default(producerScope, coroutineName, null, new AnonymousClass1(this.$this_postStream, this.$url, this.this$0, this.$config, producerScope, null), 2, null);
            return Unit.INSTANCE;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            ProducerScope producerScope = (ProducerScope) this.L$0;
            CoroutineName coroutineName = new CoroutineName("postStream");
            Intrinsics.needClassReification();
            BuildersKt__Builders_commonKt.launch$default(producerScope, coroutineName, null, new AnonymousClass1(this.$this_postStream, this.$url, this.this$0, this.$config, producerScope, null), 2, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$templateGenerateContent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIController", f = "APIController.kt", l = {184, 520, 186, 522}, m = "templateGenerateContent")
    public static final class C20531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C20531(Continuation<? super C20531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return APIController.this.templateGenerateContent(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$templateGenerateContentStream$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/google/firebase/ai/type/GenerateContentResponse$Internal;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIController$templateGenerateContentStream$3", f = "APIController.kt", l = {}, m = "invokeSuspend")
    public static final class C20543 extends SuspendLambda implements Function3<FlowCollector<? super GenerateContentResponse.Internal>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C20543(Continuation<? super C20543> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super GenerateContentResponse.Internal> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            C20543 c20543 = new C20543(continuation);
            c20543.L$0 = th;
            return c20543.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw FirebaseAIException.INSTANCE.from$com_google_firebase_ai_logic_firebase_ai((Throwable) this.L$0);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$templateGenerateImage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIController", f = "APIController.kt", l = {229, 520, 231, 522}, m = "templateGenerateImage")
    public static final class C20551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C20551(Continuation<? super C20551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return APIController.this.templateGenerateImage(null, null, this);
        }
    }

    public APIController(String str, String str2, RequestOptions requestOptions, HttpClientEngine httpClientEngine, String str3, FirebaseApp firebaseApp, int i, String str4, HeaderProvider headerProvider, GenerativeBackend generativeBackend) {
        str.getClass();
        str2.getClass();
        requestOptions.getClass();
        httpClientEngine.getClass();
        str3.getClass();
        firebaseApp.getClass();
        str4.getClass();
        this.key = str;
        this.requestOptions = requestOptions;
        this.apiClient = str3;
        this.firebaseApp = firebaseApp;
        this.appVersion = i;
        this.googleAppId = str4;
        this.headerProvider = headerProvider;
        this.backend = generativeBackend;
        this.model = UtilKt.fullModelName(str2);
        final int i2 = 0;
        this.appPackageName = LazyKt.lazy(new Function0(this) { // from class: com.google.firebase.ai.common.APIController$$ExternalSyntheticLambda3
            public final /* synthetic */ APIController f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i3 = i2;
                APIController aPIController = this.f$0;
                switch (i3) {
                    case 0:
                        return APIController.appPackageName_delegate$lambda$0(aPIController);
                    default:
                        return aPIController.getSigningCertFingerprint();
                }
            }
        });
        final int i3 = 1;
        this.appSigningCertFingerprint = LazyKt.lazy(new Function0(this) { // from class: com.google.firebase.ai.common.APIController$$ExternalSyntheticLambda3
            public final /* synthetic */ APIController f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i32 = i3;
                APIController aPIController = this.f$0;
                switch (i32) {
                    case 0:
                        return APIController.appPackageName_delegate$lambda$0(aPIController);
                    default:
                        return aPIController.getSigningCertFingerprint();
                }
            }
        });
        this.client = HttpClientKt.HttpClient(httpClientEngine, new APIController$$ExternalSyntheticLambda0(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String appPackageName_delegate$lambda$0(APIController aPIController) {
        return aPIController.firebaseApp.getApplicationContext().getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyCommonConfiguration(HttpRequestBuilder httpRequestBuilder, Request request) {
        KType kTypeTypeOf = null;
        if (request instanceof GenerateContentRequest) {
            if (request instanceof OutgoingContent) {
                httpRequestBuilder.setBody(request);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(request);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GenerateContentRequest.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(GenerateContentRequest.class);
                } catch (Throwable unused) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
            }
        } else if (request instanceof CountTokensRequest) {
            if (request instanceof OutgoingContent) {
                httpRequestBuilder.setBody(request);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(request);
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(CountTokensRequest.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(CountTokensRequest.class);
                } catch (Throwable unused2) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kTypeTypeOf));
            }
        } else if (request instanceof GenerateImageRequest) {
            if (request instanceof OutgoingContent) {
                httpRequestBuilder.setBody(request);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(request);
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(GenerateImageRequest.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(GenerateImageRequest.class);
                } catch (Throwable unused3) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass3, kTypeTypeOf));
            }
        } else if (request instanceof TemplateGenerateContentRequest) {
            if (request instanceof OutgoingContent) {
                httpRequestBuilder.setBody(request);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(request);
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(TemplateGenerateContentRequest.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(TemplateGenerateContentRequest.class);
                } catch (Throwable unused4) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass4, kTypeTypeOf));
            }
        } else if (request instanceof TemplateGenerateImageRequest) {
            if (request instanceof OutgoingContent) {
                httpRequestBuilder.setBody(request);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(request);
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(TemplateGenerateImageRequest.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(TemplateGenerateImageRequest.class);
                } catch (Throwable unused5) {
                }
                httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass5, kTypeTypeOf));
            }
        }
        applyCommonHeaders(httpRequestBuilder);
    }

    private final void applyCommonHeaders(HttpRequestBuilder httpRequestBuilder) {
        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
        UtilsKt.header(httpRequestBuilder, "x-goog-api-key", this.key);
        UtilsKt.header(httpRequestBuilder, "x-goog-api-client", this.apiClient);
        UtilsKt.header(httpRequestBuilder, "X-Android-Package", getAppPackageName());
        String appSigningCertFingerprint = getAppSigningCertFingerprint();
        if (appSigningCertFingerprint == null) {
            appSigningCertFingerprint = "";
        }
        UtilsKt.header(httpRequestBuilder, "X-Android-Cert", appSigningCertFingerprint);
        if (this.firebaseApp.isDataCollectionDefaultEnabled()) {
            UtilsKt.header(httpRequestBuilder, "X-Firebase-AppId", this.googleAppId);
            UtilsKt.header(httpRequestBuilder, "X-Firebase-AppVersion", Integer.valueOf(this.appVersion));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object applyHeaderProvider(HttpRequestBuilder httpRequestBuilder, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
        } catch (TimeoutCancellationException unused) {
            Boxing.boxInt(Log.w(TAG, "HeaderProvided timed out without generating headers, ignoring"));
        }
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            HeaderProvider headerProvider = this.headerProvider;
            if (headerProvider != null) {
                long jMo395getTimeoutUwyO8pc = headerProvider.mo395getTimeoutUwyO8pc();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(httpRequestBuilder, null);
                anonymousClass1.label = 1;
                if (TimeoutKt.m2571withTimeoutKLykuaI(jMo395getTimeoutUwyO8pc, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit client$lambda$4(APIController aPIController, HttpClientConfig httpClientConfig) {
        httpClientConfig.getClass();
        httpClientConfig.install(HttpTimeoutKt.getHttpTimeout(), new APIController$$ExternalSyntheticLambda0(aPIController, 1));
        HttpClientConfig.install$default(httpClientConfig, WebSockets.INSTANCE, null, 2, null);
        httpClientConfig.install(ContentNegotiationKt.getContentNegotiation(), new Data$$ExternalSyntheticLambda0(16));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit client$lambda$4$lambda$2(APIController aPIController, HttpTimeoutConfig httpTimeoutConfig) {
        httpTimeoutConfig.getClass();
        httpTimeoutConfig.setRequestTimeoutMillis(Long.valueOf(Duration.m2536getInWholeMillisecondsimpl(aPIController.requestOptions.getTimeout())));
        httpTimeoutConfig.setSocketTimeoutMillis(Long.valueOf(Math.max(Duration.m2536getInWholeMillisecondsimpl(DurationKt.toDuration(180, DurationUnit.SECONDS)), Duration.m2536getInWholeMillisecondsimpl(aPIController.requestOptions.getTimeout()))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit client$lambda$4$lambda$3(ContentNegotiationConfig contentNegotiationConfig) {
        contentNegotiationConfig.getClass();
        JsonSupportKt.json$default(contentNegotiationConfig, APIControllerKt.getJSON(), null, 2, null);
        return Unit.INSTANCE;
    }

    private final String getAppPackageName() {
        return (String) this.appPackageName.getValue();
    }

    private final String getAppSigningCertFingerprint() {
        return (String) this.appSigningCertFingerprint.getValue();
    }

    private final String getBidiEndpoint(String location) {
        GenerativeBackend generativeBackend = this.backend;
        GenerativeBackendEnum backend = generativeBackend != null ? generativeBackend.getBackend() : null;
        int i = backend == null ? -1 : WhenMappings.$EnumSwitchMapping$0[backend.ordinal()];
        if (i == -1 || i == 1) {
            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("wss://firebasevertexai.googleapis.com/ws/google.firebase.vertexai.v1beta.LlmBidiService/BidiGenerateContent/locations/", location, "?key=");
            sbM5m.append(this.key);
            return sbM5m.toString();
        }
        if (i != 2) {
            Home$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        return "wss://firebasevertexai.googleapis.com/ws/google.firebase.vertexai.v1beta.GenerativeService/BidiGenerateContent?key=" + this.key;
    }

    private final Signature getCurrentSignature() {
        Signature[] signatureArr;
        SigningInfo signingInfo;
        String packageName = this.firebaseApp.getApplicationContext().getPackageName();
        int i = Build.VERSION.SDK_INT;
        FirebaseApp firebaseApp = this.firebaseApp;
        if (i < 28) {
            try {
                PackageInfo packageInfo = firebaseApp.getApplicationContext().getPackageManager().getPackageInfo(packageName, 64);
                if (packageInfo == null || (signatureArr = packageInfo.signatures) == null) {
                    return null;
                }
                if (signatureArr.length > 1) {
                    Log.d(TAG, "Multiple certificates found. On Android < P, certificate order is non-deterministic; an rotated/old cert may be used.");
                }
                return (Signature) ArraysKt.firstOrNull(signatureArr);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d(TAG, "PackageManager couldn't find the package \"" + packageName + JsonFactory.DEFAULT_QUOTE_CHAR);
                return null;
            }
        }
        try {
            PackageInfo packageInfo2 = firebaseApp.getApplicationContext().getPackageManager().getPackageInfo(packageName, 134217728);
            if (packageInfo2 == null || (signingInfo = packageInfo2.signingInfo) == null) {
                return null;
            }
            if (!signingInfo.hasMultipleSigners()) {
                Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                signingCertificateHistory.getClass();
                return (Signature) ArraysKt.lastOrNull(signingCertificateHistory);
            }
            Log.d(TAG, "App has been signed with multiple certificates. Defaulting to the first one");
            Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
            apkContentsSigners.getClass();
            return (Signature) ArraysKt.first(apkContentsSigners);
        } catch (PackageManager.NameNotFoundException unused2) {
            Log.d(TAG, "PackageManager couldn't find the package \"" + packageName + JsonFactory.DEFAULT_QUOTE_CHAR);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSigningCertFingerprint() {
        Signature currentSignature = getCurrentSignature();
        if (currentSignature == null) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-1").digest(currentSignature.toByteArray());
            bArrDigest.getClass();
            return HexExtensionsKt.toHexString(bArrDigest, HexFormat.INSTANCE.getUpperCase());
        } catch (NoSuchAlgorithmException e) {
            Log.w(TAG, "No support for SHA-1 algorithm found.", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getWebSocketSession$lambda$15(APIController aPIController, HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        aPIController.applyCommonHeaders(httpRequestBuilder);
        return Unit.INSTANCE;
    }

    private final /* synthetic */ <R extends Response> Flow<R> postStream(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1) {
        Intrinsics.needClassReification();
        return FlowKt.channelFlow(new C20522(httpClient, str, this, function1, null));
    }

    public static /* synthetic */ Flow postStream$default(APIController aPIController, HttpClient httpClient, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: com.google.firebase.ai.common.APIController.postStream.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    httpRequestBuilder.getClass();
                }
            };
        }
        Intrinsics.needClassReification();
        return FlowKt.channelFlow(new C20522(httpClient, str, aPIController, function1, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e7, code lost:
    
        if (r13 != r2) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object countTokens(CountTokensRequest countTokensRequest, Continuation<? super CountTokensResponse.Internal> continuation) {
        C20481 c20481;
        HttpClient httpClient;
        HttpRequestBuilder httpRequestBuilder;
        Object obj;
        KType kTypeTypeOf;
        if (continuation instanceof C20481) {
            c20481 = (C20481) continuation;
            int i = c20481.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20481.label = i - Integer.MIN_VALUE;
            } else {
                c20481 = new C20481(continuation);
            }
        }
        Object objExecute = c20481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20481.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient2 = this.client;
                String str = this.requestOptions.getEndpoint() + '/' + this.requestOptions.getApiVersion() + '/' + this.model + ":countTokens";
                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder2, str);
                applyCommonConfiguration(httpRequestBuilder2, countTokensRequest);
                c20481.L$0 = httpClient2;
                c20481.L$1 = httpRequestBuilder2;
                c20481.label = 1;
                if (applyHeaderProvider(httpRequestBuilder2, c20481) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpClient = httpClient2;
                httpRequestBuilder = httpRequestBuilder2;
            } else if (i2 == 1) {
                httpRequestBuilder = (HttpRequestBuilder) c20481.L$1;
                httpClient = (HttpClient) c20481.L$0;
                ResultKt.throwOnFailure(objExecute);
            } else if (i2 == 2) {
                ResultKt.throwOnFailure(objExecute);
                c20481.L$0 = objExecute;
                c20481.label = 3;
                if (APIControllerKt.validateResponse((HttpResponse) objExecute, c20481) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objExecute;
                HttpClientCall call = ((HttpResponse) obj).getCall();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CountTokensResponse.Internal.class);
                kTypeTypeOf = Reflection.typeOf(CountTokensResponse.Internal.class);
                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kTypeTypeOf);
                c20481.L$0 = null;
                c20481.label = 4;
                objExecute = call.bodyNullable(typeInfo, c20481);
            } else {
                if (i2 != 3) {
                    if (i2 != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecute);
                    if (objExecute != null) {
                        return (CountTokensResponse.Internal) objExecute;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.google.firebase.ai.type.CountTokensResponse.Internal");
                }
                obj = c20481.L$0;
                ResultKt.throwOnFailure(objExecute);
                HttpClientCall call2 = ((HttpResponse) obj).getCall();
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(CountTokensResponse.Internal.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(CountTokensResponse.Internal.class);
                } catch (Throwable unused) {
                    kTypeTypeOf = null;
                }
                TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kTypeTypeOf);
                c20481.L$0 = null;
                c20481.label = 4;
                objExecute = call2.bodyNullable(typeInfo2, c20481);
            }
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
            c20481.L$0 = null;
            c20481.L$1 = null;
            c20481.label = 2;
            objExecute = httpStatement.execute(c20481);
            if (objExecute != coroutine_suspended) {
                c20481.L$0 = objExecute;
                c20481.label = 3;
                if (APIControllerKt.validateResponse((HttpResponse) objExecute, c20481) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            throw FirebaseAIException.INSTANCE.from$com_google_firebase_ai_logic_firebase_ai(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e7, code lost:
    
        if (r13 != r2) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object generateContent(GenerateContentRequest generateContentRequest, Continuation<? super GenerateContentResponse.Internal> continuation) {
        C20491 c20491;
        HttpClient httpClient;
        HttpRequestBuilder httpRequestBuilder;
        Object obj;
        KType kTypeTypeOf;
        if (continuation instanceof C20491) {
            c20491 = (C20491) continuation;
            int i = c20491.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20491.label = i - Integer.MIN_VALUE;
            } else {
                c20491 = new C20491(continuation);
            }
        }
        Object objExecute = c20491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20491.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient2 = this.client;
                String str = this.requestOptions.getEndpoint() + '/' + this.requestOptions.getApiVersion() + '/' + this.model + ":generateContent";
                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder2, str);
                applyCommonConfiguration(httpRequestBuilder2, generateContentRequest);
                c20491.L$0 = httpClient2;
                c20491.L$1 = httpRequestBuilder2;
                c20491.label = 1;
                if (applyHeaderProvider(httpRequestBuilder2, c20491) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpClient = httpClient2;
                httpRequestBuilder = httpRequestBuilder2;
            } else if (i2 == 1) {
                httpRequestBuilder = (HttpRequestBuilder) c20491.L$1;
                httpClient = (HttpClient) c20491.L$0;
                ResultKt.throwOnFailure(objExecute);
            } else if (i2 == 2) {
                ResultKt.throwOnFailure(objExecute);
                c20491.L$0 = objExecute;
                c20491.label = 3;
                if (APIControllerKt.validateResponse((HttpResponse) objExecute, c20491) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objExecute;
                HttpClientCall call = ((HttpResponse) obj).getCall();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GenerateContentResponse.Internal.class);
                kTypeTypeOf = Reflection.typeOf(GenerateContentResponse.Internal.class);
                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kTypeTypeOf);
                c20491.L$0 = null;
                c20491.label = 4;
                objExecute = call.bodyNullable(typeInfo, c20491);
            } else {
                if (i2 != 3) {
                    if (i2 != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecute);
                    if (objExecute != null) {
                        return APIControllerKt.validate((GenerateContentResponse.Internal) objExecute);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.google.firebase.ai.type.GenerateContentResponse.Internal");
                }
                obj = c20491.L$0;
                ResultKt.throwOnFailure(objExecute);
                HttpClientCall call2 = ((HttpResponse) obj).getCall();
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(GenerateContentResponse.Internal.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(GenerateContentResponse.Internal.class);
                } catch (Throwable unused) {
                    kTypeTypeOf = null;
                }
                TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kTypeTypeOf);
                c20491.L$0 = null;
                c20491.label = 4;
                objExecute = call2.bodyNullable(typeInfo2, c20491);
            }
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
            c20491.L$0 = null;
            c20491.L$1 = null;
            c20491.label = 2;
            objExecute = httpStatement.execute(c20491);
            if (objExecute != coroutine_suspended) {
                c20491.L$0 = objExecute;
                c20491.label = 3;
                if (APIControllerKt.validateResponse((HttpResponse) objExecute, c20491) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            throw FirebaseAIException.INSTANCE.from$com_google_firebase_ai_logic_firebase_ai(th);
        }
    }

    public final Flow<GenerateContentResponse.Internal> generateContentStream(GenerateContentRequest request) {
        request.getClass();
        HttpClient httpClient = this.client;
        StringBuilder sb = new StringBuilder();
        sb.append(this.requestOptions.getEndpoint());
        sb.append('/');
        sb.append(this.requestOptions.getApiVersion());
        sb.append('/');
        final Flow flowChannelFlow = FlowKt.channelFlow(new APIController$generateContentStream$$inlined$postStream$1(httpClient, FileInsert$$ExternalSyntheticOutline0.m(sb, this.model, ":streamGenerateContent?alt=sse"), this, null, this, request));
        return FlowKt.m2600catch(new Flow<GenerateContentResponse.Internal>() { // from class: com.google.firebase.ai.common.APIController$generateContentStream$$inlined$map$1

            /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$generateContentStream$$inlined$map$1$2, reason: invalid class name */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$generateContentStream$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "com.google.firebase.ai.common.APIController$generateContentStream$$inlined$map$1$2", f = "APIController.kt", l = {50}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        GenerateContentResponse.Internal internalValidate = APIControllerKt.validate((GenerateContentResponse.Internal) obj);
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(internalValidate, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super GenerateContentResponse.Internal> flowCollector, Continuation continuation) {
                Object objCollect = flowChannelFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AnonymousClass3(null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e7, code lost:
    
        if (r13 != r2) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object generateImage(GenerateImageRequest generateImageRequest, Continuation<? super ImagenGenerationResponse.Internal> continuation) {
        C20501 c20501;
        HttpClient httpClient;
        HttpRequestBuilder httpRequestBuilder;
        Object obj;
        KType kTypeTypeOf;
        if (continuation instanceof C20501) {
            c20501 = (C20501) continuation;
            int i = c20501.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20501.label = i - Integer.MIN_VALUE;
            } else {
                c20501 = new C20501(continuation);
            }
        }
        Object objExecute = c20501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20501.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient2 = this.client;
                String str = this.requestOptions.getEndpoint() + '/' + this.requestOptions.getApiVersion() + '/' + this.model + ":predict";
                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder2, str);
                applyCommonConfiguration(httpRequestBuilder2, generateImageRequest);
                c20501.L$0 = httpClient2;
                c20501.L$1 = httpRequestBuilder2;
                c20501.label = 1;
                if (applyHeaderProvider(httpRequestBuilder2, c20501) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpClient = httpClient2;
                httpRequestBuilder = httpRequestBuilder2;
            } else if (i2 == 1) {
                httpRequestBuilder = (HttpRequestBuilder) c20501.L$1;
                httpClient = (HttpClient) c20501.L$0;
                ResultKt.throwOnFailure(objExecute);
            } else if (i2 == 2) {
                ResultKt.throwOnFailure(objExecute);
                c20501.L$0 = objExecute;
                c20501.label = 3;
                if (APIControllerKt.validateResponse((HttpResponse) objExecute, c20501) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objExecute;
                HttpClientCall call = ((HttpResponse) obj).getCall();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ImagenGenerationResponse.Internal.class);
                kTypeTypeOf = Reflection.typeOf(ImagenGenerationResponse.Internal.class);
                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kTypeTypeOf);
                c20501.L$0 = null;
                c20501.label = 4;
                objExecute = call.bodyNullable(typeInfo, c20501);
            } else {
                if (i2 != 3) {
                    if (i2 != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecute);
                    if (objExecute != null) {
                        return (ImagenGenerationResponse.Internal) objExecute;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.google.firebase.ai.type.ImagenGenerationResponse.Internal");
                }
                obj = c20501.L$0;
                ResultKt.throwOnFailure(objExecute);
                HttpClientCall call2 = ((HttpResponse) obj).getCall();
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ImagenGenerationResponse.Internal.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(ImagenGenerationResponse.Internal.class);
                } catch (Throwable unused) {
                    kTypeTypeOf = null;
                }
                TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kTypeTypeOf);
                c20501.L$0 = null;
                c20501.label = 4;
                objExecute = call2.bodyNullable(typeInfo2, c20501);
            }
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
            c20501.L$0 = null;
            c20501.L$1 = null;
            c20501.label = 2;
            objExecute = httpStatement.execute(c20501);
            if (objExecute != coroutine_suspended) {
                c20501.L$0 = objExecute;
                c20501.label = 3;
                if (APIControllerKt.validateResponse((HttpResponse) objExecute, c20501) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            throw FirebaseAIException.INSTANCE.from$com_google_firebase_ai_logic_firebase_ai(th);
        }
    }

    /* JADX INFO: renamed from: getApiClient$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getApiClient() {
        return this.apiClient;
    }

    public final Object getWebSocketSession(String str, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return BuildersKt.webSocketSession(this.client, getBidiEndpoint(str), new APIController$$ExternalSyntheticLambda0(this, 0), continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e5, code lost:
    
        if (r14 != r2) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object templateGenerateContent(String str, TemplateGenerateContentRequest templateGenerateContentRequest, Continuation<? super GenerateContentResponse.Internal> continuation) {
        C20531 c20531;
        HttpClient httpClient;
        HttpRequestBuilder httpRequestBuilder;
        Object obj;
        KType kTypeTypeOf;
        if (continuation instanceof C20531) {
            c20531 = (C20531) continuation;
            int i = c20531.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20531.label = i - Integer.MIN_VALUE;
            } else {
                c20531 = new C20531(continuation);
            }
        }
        Object objExecute = c20531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20531.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient2 = this.client;
                String str2 = this.requestOptions.getEndpoint() + '/' + this.requestOptions.getApiVersion() + '/' + str + ":templateGenerateContent";
                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder2, str2);
                applyCommonConfiguration(httpRequestBuilder2, templateGenerateContentRequest);
                c20531.L$0 = httpClient2;
                c20531.L$1 = httpRequestBuilder2;
                c20531.label = 1;
                if (applyHeaderProvider(httpRequestBuilder2, c20531) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpClient = httpClient2;
                httpRequestBuilder = httpRequestBuilder2;
            } else if (i2 == 1) {
                httpRequestBuilder = (HttpRequestBuilder) c20531.L$1;
                httpClient = (HttpClient) c20531.L$0;
                ResultKt.throwOnFailure(objExecute);
            } else if (i2 == 2) {
                ResultKt.throwOnFailure(objExecute);
                c20531.L$0 = objExecute;
                c20531.label = 3;
                if (APIControllerKt.validateResponse((HttpResponse) objExecute, c20531) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objExecute;
                HttpClientCall call = ((HttpResponse) obj).getCall();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GenerateContentResponse.Internal.class);
                kTypeTypeOf = Reflection.typeOf(GenerateContentResponse.Internal.class);
                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kTypeTypeOf);
                c20531.L$0 = null;
                c20531.label = 4;
                objExecute = call.bodyNullable(typeInfo, c20531);
            } else {
                if (i2 != 3) {
                    if (i2 != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecute);
                    if (objExecute != null) {
                        return APIControllerKt.validate((GenerateContentResponse.Internal) objExecute);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.google.firebase.ai.type.GenerateContentResponse.Internal");
                }
                obj = c20531.L$0;
                ResultKt.throwOnFailure(objExecute);
                HttpClientCall call2 = ((HttpResponse) obj).getCall();
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(GenerateContentResponse.Internal.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(GenerateContentResponse.Internal.class);
                } catch (Throwable unused) {
                    kTypeTypeOf = null;
                }
                TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kTypeTypeOf);
                c20531.L$0 = null;
                c20531.label = 4;
                objExecute = call2.bodyNullable(typeInfo2, c20531);
            }
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
            c20531.L$0 = null;
            c20531.L$1 = null;
            c20531.label = 2;
            objExecute = httpStatement.execute(c20531);
            if (objExecute != coroutine_suspended) {
                c20531.L$0 = objExecute;
                c20531.label = 3;
                if (APIControllerKt.validateResponse((HttpResponse) objExecute, c20531) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            throw FirebaseAIException.INSTANCE.from$com_google_firebase_ai_logic_firebase_ai(th);
        }
    }

    public final Flow<GenerateContentResponse.Internal> templateGenerateContentStream(String templateId, TemplateGenerateContentRequest request) {
        templateId.getClass();
        request.getClass();
        final Flow flowChannelFlow = FlowKt.channelFlow(new APIController$templateGenerateContentStream$$inlined$postStream$1(this.client, this.requestOptions.getEndpoint() + '/' + this.requestOptions.getApiVersion() + '/' + templateId + ":templateStreamGenerateContent?alt=sse", this, null, this, request));
        return FlowKt.m2600catch(new Flow<GenerateContentResponse.Internal>() { // from class: com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$map$1

            /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$map$1$2, reason: invalid class name */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "com.google.firebase.ai.common.APIController$templateGenerateContentStream$$inlined$map$1$2", f = "APIController.kt", l = {50}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        GenerateContentResponse.Internal internalValidate = APIControllerKt.validate((GenerateContentResponse.Internal) obj);
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(internalValidate, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super GenerateContentResponse.Internal> flowCollector, Continuation continuation) {
                Object objCollect = flowChannelFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new C20543(null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e5, code lost:
    
        if (r14 != r2) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object templateGenerateImage(String str, TemplateGenerateImageRequest templateGenerateImageRequest, Continuation<? super ImagenGenerationResponse.Internal> continuation) {
        C20551 c20551;
        HttpClient httpClient;
        HttpRequestBuilder httpRequestBuilder;
        Object obj;
        KType kTypeTypeOf;
        if (continuation instanceof C20551) {
            c20551 = (C20551) continuation;
            int i = c20551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c20551.label = i - Integer.MIN_VALUE;
            } else {
                c20551 = new C20551(continuation);
            }
        }
        Object objExecute = c20551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c20551.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient2 = this.client;
                String str2 = this.requestOptions.getEndpoint() + '/' + this.requestOptions.getApiVersion() + '/' + str + ":templatePredict";
                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder2, str2);
                applyCommonConfiguration(httpRequestBuilder2, templateGenerateImageRequest);
                c20551.L$0 = httpClient2;
                c20551.L$1 = httpRequestBuilder2;
                c20551.label = 1;
                if (applyHeaderProvider(httpRequestBuilder2, c20551) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpClient = httpClient2;
                httpRequestBuilder = httpRequestBuilder2;
            } else if (i2 == 1) {
                httpRequestBuilder = (HttpRequestBuilder) c20551.L$1;
                httpClient = (HttpClient) c20551.L$0;
                ResultKt.throwOnFailure(objExecute);
            } else if (i2 == 2) {
                ResultKt.throwOnFailure(objExecute);
                c20551.L$0 = objExecute;
                c20551.label = 3;
                if (APIControllerKt.validateResponse((HttpResponse) objExecute, c20551) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objExecute;
                HttpClientCall call = ((HttpResponse) obj).getCall();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ImagenGenerationResponse.Internal.class);
                kTypeTypeOf = Reflection.typeOf(ImagenGenerationResponse.Internal.class);
                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kTypeTypeOf);
                c20551.L$0 = null;
                c20551.label = 4;
                objExecute = call.bodyNullable(typeInfo, c20551);
            } else {
                if (i2 != 3) {
                    if (i2 != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecute);
                    if (objExecute != null) {
                        return (ImagenGenerationResponse.Internal) objExecute;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.google.firebase.ai.type.ImagenGenerationResponse.Internal");
                }
                obj = c20551.L$0;
                ResultKt.throwOnFailure(objExecute);
                HttpClientCall call2 = ((HttpResponse) obj).getCall();
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ImagenGenerationResponse.Internal.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(ImagenGenerationResponse.Internal.class);
                } catch (Throwable unused) {
                    kTypeTypeOf = null;
                }
                TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kTypeTypeOf);
                c20551.L$0 = null;
                c20551.label = 4;
                objExecute = call2.bodyNullable(typeInfo2, c20551);
            }
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
            c20551.L$0 = null;
            c20551.L$1 = null;
            c20551.label = 2;
            objExecute = httpStatement.execute(c20551);
            if (objExecute != coroutine_suspended) {
                c20551.L$0 = objExecute;
                c20551.label = 3;
                if (APIControllerKt.validateResponse((HttpResponse) objExecute, c20551) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            throw FirebaseAIException.INSTANCE.from$com_google_firebase_ai_logic_firebase_ai(th);
        }
    }

    public /* synthetic */ APIController(String str, String str2, RequestOptions requestOptions, HttpClientEngine httpClientEngine, String str3, FirebaseApp firebaseApp, int i, String str4, HeaderProvider headerProvider, GenerativeBackend generativeBackend, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, requestOptions, httpClientEngine, str3, firebaseApp, (i2 & 64) != 0 ? 0 : i, str4, headerProvider, (i2 & 512) != 0 ? null : generativeBackend);
    }

    public /* synthetic */ APIController(String str, String str2, RequestOptions requestOptions, String str3, FirebaseApp firebaseApp, HeaderProvider headerProvider, GenerativeBackend generativeBackend, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, requestOptions, str3, firebaseApp, (i & 32) != 0 ? null : headerProvider, (i & 64) != 0 ? null : generativeBackend);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public APIController(String str, String str2, RequestOptions requestOptions, String str3, FirebaseApp firebaseApp, HeaderProvider headerProvider, GenerativeBackend generativeBackend) {
        str.getClass();
        str2.getClass();
        requestOptions.getClass();
        str3.getClass();
        firebaseApp.getClass();
        HttpClientEngine httpClientEngineCreate$default = HttpClientEngineFactory.DefaultImpls.create$default(OkHttp.INSTANCE, null, 1, null);
        int versionNumber = INSTANCE.getVersionNumber(firebaseApp);
        String applicationId = firebaseApp.getOptions().getApplicationId();
        applicationId.getClass();
        this(str, str2, requestOptions, httpClientEngineCreate$default, str3, firebaseApp, versionNumber, applicationId, headerProvider, generativeBackend);
    }
}
