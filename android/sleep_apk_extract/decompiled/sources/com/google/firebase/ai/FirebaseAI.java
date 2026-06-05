package com.google.firebase.ai;

import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ai.GenerativeModel;
import com.google.firebase.ai.ondevice.interop.FirebaseAIOnDeviceGenerativeModelFactory;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.GenerationConfig;
import com.google.firebase.ai.type.GenerativeBackend;
import com.google.firebase.ai.type.GenerativeBackendEnum;
import com.google.firebase.ai.type.RequestOptions;
import com.google.firebase.ai.type.SafetySetting;
import com.google.firebase.ai.type.Tool;
import com.google.firebase.ai.type.ToolConfig;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Provider;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001-BU\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012Ji\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00172\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b#\u0010$Jq\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00172\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010!\u001a\u00020 2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b#\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010(R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010)R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010*R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010+R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010+R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010+R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010,¨\u0006."}, d2 = {"Lcom/google/firebase/ai/FirebaseAI;", "", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "Lcom/google/firebase/ai/type/GenerativeBackend;", "backend", "Lkotlin/coroutines/CoroutineContext;", "blockingDispatcher", "Lcom/google/firebase/inject/Provider;", "Lcom/google/firebase/appcheck/interop/InteropAppCheckTokenProvider;", "appCheckProvider", "Lcom/google/firebase/auth/internal/InternalAuthProvider;", "internalAuthProvider", "Lcom/google/firebase/ai/ondevice/interop/FirebaseAIOnDeviceGenerativeModelFactory;", "onDeviceFactoryProvider", "", "useLimitedUseAppCheckTokens", "<init>", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/ai/type/GenerativeBackend;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/inject/Provider;Lcom/google/firebase/inject/Provider;Lcom/google/firebase/inject/Provider;Z)V", "", "modelName", "Lcom/google/firebase/ai/type/GenerationConfig;", "generationConfig", "", "Lcom/google/firebase/ai/type/SafetySetting;", "safetySettings", "Lcom/google/firebase/ai/type/Tool;", "tools", "Lcom/google/firebase/ai/type/ToolConfig;", "toolConfig", "Lcom/google/firebase/ai/type/Content;", "systemInstruction", "Lcom/google/firebase/ai/type/RequestOptions;", "requestOptions", "Lcom/google/firebase/ai/GenerativeModel;", "generativeModel", "(Ljava/lang/String;Lcom/google/firebase/ai/type/GenerationConfig;Ljava/util/List;Ljava/util/List;Lcom/google/firebase/ai/type/ToolConfig;Lcom/google/firebase/ai/type/Content;Lcom/google/firebase/ai/type/RequestOptions;)Lcom/google/firebase/ai/GenerativeModel;", "Lcom/google/firebase/ai/OnDeviceConfig;", "onDeviceConfig", "(Ljava/lang/String;Lcom/google/firebase/ai/type/GenerationConfig;Ljava/util/List;Ljava/util/List;Lcom/google/firebase/ai/type/ToolConfig;Lcom/google/firebase/ai/type/Content;Lcom/google/firebase/ai/type/RequestOptions;Lcom/google/firebase/ai/OnDeviceConfig;)Lcom/google/firebase/ai/GenerativeModel;", "Lcom/google/firebase/FirebaseApp;", "Lcom/google/firebase/ai/type/GenerativeBackend;", "Lkotlin/coroutines/CoroutineContext;", "Lcom/google/firebase/inject/Provider;", "Z", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FirebaseAI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "FirebaseAI";
    private final Provider<InteropAppCheckTokenProvider> appCheckProvider;
    private final GenerativeBackend backend;
    private final CoroutineContext blockingDispatcher;
    private final FirebaseApp firebaseApp;
    private final Provider<InternalAuthProvider> internalAuthProvider;
    private final Provider<FirebaseAIOnDeviceGenerativeModelFactory> onDeviceFactoryProvider;
    private final boolean useLimitedUseAppCheckTokens;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\t\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/google/firebase/ai/FirebaseAI$Companion;", "", "<init>", "()V", "Lcom/google/firebase/FirebaseApp;", "app", "Lcom/google/firebase/ai/type/GenerativeBackend;", "backend", "Lcom/google/firebase/ai/FirebaseAI;", "getInstance", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/ai/type/GenerativeBackend;)Lcom/google/firebase/ai/FirebaseAI;", "", "useLimitedUseAppCheckTokens", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/ai/type/GenerativeBackend;Z)Lcom/google/firebase/ai/FirebaseAI;", "", "GEMINI_MODEL_NAME_PREFIX", "Ljava/lang/String;", "IMAGEN_MODEL_NAME_PREFIX", "kotlin.jvm.PlatformType", "TAG", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FirebaseAI getInstance(FirebaseApp app, GenerativeBackend backend, boolean useLimitedUseAppCheckTokens) {
            app.getClass();
            backend.getClass();
            return ((FirebaseAIMultiResourceComponent) app.get(FirebaseAIMultiResourceComponent.class)).get(new InstanceKey(backend, useLimitedUseAppCheckTokens));
        }

        private Companion() {
        }

        public final FirebaseAI getInstance(FirebaseApp app, GenerativeBackend backend) {
            app.getClass();
            backend.getClass();
            return getInstance(app, backend, false);
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

    public FirebaseAI(FirebaseApp firebaseApp, GenerativeBackend generativeBackend, @Blocking CoroutineContext coroutineContext, Provider<InteropAppCheckTokenProvider> provider, Provider<InternalAuthProvider> provider2, Provider<FirebaseAIOnDeviceGenerativeModelFactory> provider3, boolean z) {
        firebaseApp.getClass();
        generativeBackend.getClass();
        coroutineContext.getClass();
        provider.getClass();
        provider2.getClass();
        provider3.getClass();
        this.firebaseApp = firebaseApp;
        this.backend = generativeBackend;
        this.blockingDispatcher = coroutineContext;
        this.appCheckProvider = provider;
        this.internalAuthProvider = provider2;
        this.onDeviceFactoryProvider = provider3;
        this.useLimitedUseAppCheckTokens = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GenerativeModel generativeModel$default(FirebaseAI firebaseAI, String str, GenerationConfig generationConfig, List list, List list2, ToolConfig toolConfig, Content content, RequestOptions requestOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            generationConfig = null;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            list2 = null;
        }
        if ((i & 16) != 0) {
            toolConfig = null;
        }
        if ((i & 32) != 0) {
            content = null;
        }
        if ((i & 64) != 0) {
            requestOptions = new RequestOptions(0L, 0, 3, (DefaultConstructorMarker) null);
        }
        return firebaseAI.generativeModel(str, generationConfig, list, list2, toolConfig, content, requestOptions);
    }

    public final GenerativeModel generativeModel(String modelName, GenerationConfig generationConfig, List<SafetySetting> safetySettings, List<Tool> tools, ToolConfig toolConfig, Content systemInstruction, RequestOptions requestOptions, OnDeviceConfig onDeviceConfig) {
        String str;
        modelName.getClass();
        requestOptions.getClass();
        onDeviceConfig.getClass();
        int i = WhenMappings.$EnumSwitchMapping$0[this.backend.getBackend().ordinal()];
        if (i == 1) {
            str = "projects/" + this.firebaseApp.getOptions().getProjectId() + "/locations/" + this.backend.getLocation() + "/publishers/google/models/" + modelName;
        } else {
            if (i != 2) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            str = "projects/" + this.firebaseApp.getOptions().getProjectId() + "/models/" + modelName;
        }
        String str2 = str;
        if (!StringsKt.startsWith$default(modelName, "gemini-")) {
            Log.w(TAG, StringsKt.trimIndent("Unsupported Gemini model \"" + modelName + "\"; see\n      https://firebase.google.com/docs/vertex-ai/models for a list supported Gemini model names.\n      "));
        }
        String apiKey = this.firebaseApp.getOptions().getApiKey();
        apiKey.getClass();
        GenerativeModel.Builder builder = new GenerativeModel.Builder(str2, apiKey, this.firebaseApp, this.useLimitedUseAppCheckTokens, this.backend);
        builder.setGenerationConfig(generationConfig);
        builder.setSafetySettings(safetySettings);
        builder.setTools(tools == null ? CollectionsKt.emptyList() : tools);
        builder.setToolConfig(toolConfig);
        builder.setSystemInstruction(systemInstruction);
        builder.setRequestOptions(requestOptions);
        builder.setOnDeviceConfig(onDeviceConfig);
        if (this.onDeviceFactoryProvider.get() != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        builder.setOnDeviceFactoryProvider(null);
        if (this.internalAuthProvider.get() != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        builder.setInternalAuthProvider(null);
        if (this.appCheckProvider.get() == null) {
            builder.setAppCheckTokenProvider(null);
            return builder.build$com_google_firebase_ai_logic_firebase_ai();
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public final GenerativeModel generativeModel(String modelName, GenerationConfig generationConfig, List<SafetySetting> safetySettings, List<Tool> tools, ToolConfig toolConfig, Content systemInstruction, RequestOptions requestOptions) {
        modelName.getClass();
        requestOptions.getClass();
        return generativeModel(modelName, generationConfig, safetySettings, tools, toolConfig, systemInstruction, requestOptions, OnDeviceConfig.IN_CLOUD);
    }
}
