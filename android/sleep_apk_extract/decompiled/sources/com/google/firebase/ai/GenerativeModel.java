package com.google.firebase.ai;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.net.ConnectivityManager;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ai.common.APIController;
import com.google.firebase.ai.common.APIControllerKt;
import com.google.firebase.ai.common.AppCheckHeaderProvider;
import com.google.firebase.ai.generativemodel.CloudGenerativeModelProvider;
import com.google.firebase.ai.generativemodel.FallbackGenerativeModelProvider;
import com.google.firebase.ai.generativemodel.GenerativeModelProvider;
import com.google.firebase.ai.generativemodel.MissingOnDeviceGenerativeModelProvider;
import com.google.firebase.ai.ondevice.interop.FirebaseAIOnDeviceGenerativeModelFactory;
import com.google.firebase.ai.type.AutoFunctionDeclaration;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.ContentKt;
import com.google.firebase.ai.type.FirebaseAutoFunctionException;
import com.google.firebase.ai.type.FunctionCallPart;
import com.google.firebase.ai.type.FunctionResponsePart;
import com.google.firebase.ai.type.GenerateContentResponse;
import com.google.firebase.ai.type.GenerationConfig;
import com.google.firebase.ai.type.GenerativeBackend;
import com.google.firebase.ai.type.InvalidStateException;
import com.google.firebase.ai.type.JsonSchema;
import com.google.firebase.ai.type.RequestOptions;
import com.google.firebase.ai.type.SafetySetting;
import com.google.firebase.ai.type.Tool;
import com.google.firebase.ai.type.ToolConfig;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ,2\u00020\u0001:\u0002-,B)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u000e\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00132\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0016H\u0080@¢\u0006\u0004\b\u001d\u0010\u001eJH\u0010\u001f\u001a\u00020\u001c\"\b\b\u0000\u0010 *\u00020\u0001\"\b\b\u0001\u0010!*\u00020\u00012\u0006\u0010\"\u001a\u00020\u00162\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#2\u0006\u0010%\u001a\u00020\u0010H\u0080@¢\u0006\u0004\b\u001d\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010+¨\u0006."}, d2 = {"Lcom/google/firebase/ai/GenerativeModel;", "", "Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;", "actualModel", "Lcom/google/firebase/ai/type/RequestOptions;", "requestOptions", "", "Lcom/google/firebase/ai/type/Tool;", "tools", "<init>", "(Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;Lcom/google/firebase/ai/type/RequestOptions;Ljava/util/List;)V", "Lcom/google/firebase/ai/type/Content;", "prompt", "Lcom/google/firebase/ai/type/GenerateContentResponse;", "generateContent", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "history", "Lcom/google/firebase/ai/Chat;", "startChat", "(Ljava/util/List;)Lcom/google/firebase/ai/Chat;", "Lcom/google/firebase/ai/type/FunctionCallPart;", "call", "", "hasFunction$com_google_firebase_ai_logic_firebase_ai", "(Lcom/google/firebase/ai/type/FunctionCallPart;)Z", "hasFunction", "Lcom/google/firebase/ai/type/FunctionResponsePart;", "executeFunction$com_google_firebase_ai_logic_firebase_ai", "(Lcom/google/firebase/ai/type/FunctionCallPart;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", IntrospectionHelper.AppFunctionServiceClass.ExecuteFunctionMethod.METHOD_NAME, "I", "O", "functionCall", "Lcom/google/firebase/ai/type/AutoFunctionDeclaration;", "functionDeclaration", "parameter", "(Lcom/google/firebase/ai/type/FunctionCallPart;Lcom/google/firebase/ai/type/AutoFunctionDeclaration;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;", "Lcom/google/firebase/ai/type/RequestOptions;", "getRequestOptions$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/RequestOptions;", "Ljava/util/List;", "Companion", "Builder", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GenerativeModel {
    private static final String TAG = "GenerativeModel";
    private final GenerativeModelProvider actualModel;
    private final RequestOptions requestOptions;
    private final List<Tool> tools;

    @Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010/\u001a\b\u0012\u0004\u0012\u00020.0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010G\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010\u001b\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR(\u0010M\u001a\u00020L8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bM\u0010N\u0012\u0004\bS\u0010T\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010d\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010i¨\u0006j"}, d2 = {"Lcom/google/firebase/ai/GenerativeModel$Builder;", "", "", "modelName", "apiKey", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "", "useLimitedUseAppCheckTokens", "Lcom/google/firebase/ai/type/GenerativeBackend;", "generativeBackend", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/FirebaseApp;ZLcom/google/firebase/ai/type/GenerativeBackend;)V", "isHybrid", "Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;", "buildCloudModelProvider$com_google_firebase_ai_logic_firebase_ai", "(Z)Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;", "buildCloudModelProvider", "buildOnDeviceModelProvider$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/generativemodel/GenerativeModelProvider;", "buildOnDeviceModelProvider", "getModelProvider$com_google_firebase_ai_logic_firebase_ai", "getModelProvider", "Lcom/google/firebase/ai/GenerativeModel;", "build$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/GenerativeModel;", InAppPurchaseConstants.METHOD_BUILD, "Ljava/lang/String;", "Lcom/google/firebase/FirebaseApp;", "Z", "Lcom/google/firebase/ai/type/GenerativeBackend;", "Lcom/google/firebase/ai/type/GenerationConfig;", "generationConfig", "Lcom/google/firebase/ai/type/GenerationConfig;", "getGenerationConfig", "()Lcom/google/firebase/ai/type/GenerationConfig;", "setGenerationConfig", "(Lcom/google/firebase/ai/type/GenerationConfig;)V", "", "Lcom/google/firebase/ai/type/SafetySetting;", "safetySettings", "Ljava/util/List;", "getSafetySettings", "()Ljava/util/List;", "setSafetySettings", "(Ljava/util/List;)V", "Lcom/google/firebase/ai/type/Tool;", "tools", "getTools", "setTools", "Lcom/google/firebase/ai/type/ToolConfig;", "toolConfig", "Lcom/google/firebase/ai/type/ToolConfig;", "getToolConfig", "()Lcom/google/firebase/ai/type/ToolConfig;", "setToolConfig", "(Lcom/google/firebase/ai/type/ToolConfig;)V", "Lcom/google/firebase/ai/type/Content;", "systemInstruction", "Lcom/google/firebase/ai/type/Content;", "getSystemInstruction", "()Lcom/google/firebase/ai/type/Content;", "setSystemInstruction", "(Lcom/google/firebase/ai/type/Content;)V", "Lcom/google/firebase/ai/type/RequestOptions;", "requestOptions", "Lcom/google/firebase/ai/type/RequestOptions;", "getRequestOptions", "()Lcom/google/firebase/ai/type/RequestOptions;", "setRequestOptions", "(Lcom/google/firebase/ai/type/RequestOptions;)V", "apiClient", "getApiClient", "()Ljava/lang/String;", "setApiClient", "(Ljava/lang/String;)V", "Lcom/google/firebase/ai/OnDeviceConfig;", "onDeviceConfig", "Lcom/google/firebase/ai/OnDeviceConfig;", "getOnDeviceConfig", "()Lcom/google/firebase/ai/OnDeviceConfig;", "setOnDeviceConfig", "(Lcom/google/firebase/ai/OnDeviceConfig;)V", "getOnDeviceConfig$annotations", "()V", "Lcom/google/firebase/appcheck/interop/InteropAppCheckTokenProvider;", "appCheckTokenProvider", "Lcom/google/firebase/appcheck/interop/InteropAppCheckTokenProvider;", "getAppCheckTokenProvider", "()Lcom/google/firebase/appcheck/interop/InteropAppCheckTokenProvider;", "setAppCheckTokenProvider", "(Lcom/google/firebase/appcheck/interop/InteropAppCheckTokenProvider;)V", "Lcom/google/firebase/auth/internal/InternalAuthProvider;", "internalAuthProvider", "Lcom/google/firebase/auth/internal/InternalAuthProvider;", "getInternalAuthProvider", "()Lcom/google/firebase/auth/internal/InternalAuthProvider;", "setInternalAuthProvider", "(Lcom/google/firebase/auth/internal/InternalAuthProvider;)V", "Lcom/google/firebase/ai/ondevice/interop/FirebaseAIOnDeviceGenerativeModelFactory;", "onDeviceFactoryProvider", "Lcom/google/firebase/ai/ondevice/interop/FirebaseAIOnDeviceGenerativeModelFactory;", "getOnDeviceFactoryProvider", "()Lcom/google/firebase/ai/ondevice/interop/FirebaseAIOnDeviceGenerativeModelFactory;", "setOnDeviceFactoryProvider", "(Lcom/google/firebase/ai/ondevice/interop/FirebaseAIOnDeviceGenerativeModelFactory;)V", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private String apiClient;
        private final String apiKey;
        private final FirebaseApp firebaseApp;
        private GenerationConfig generationConfig;
        private final GenerativeBackend generativeBackend;
        private final String modelName;
        private OnDeviceConfig onDeviceConfig;
        private RequestOptions requestOptions;
        private List<SafetySetting> safetySettings;
        private Content systemInstruction;
        private ToolConfig toolConfig;
        private List<Tool> tools;
        private final boolean useLimitedUseAppCheckTokens;

        public Builder(String str, String str2, FirebaseApp firebaseApp, boolean z, GenerativeBackend generativeBackend) {
            str.getClass();
            str2.getClass();
            firebaseApp.getClass();
            generativeBackend.getClass();
            this.modelName = str;
            this.apiKey = str2;
            this.firebaseApp = firebaseApp;
            this.useLimitedUseAppCheckTokens = z;
            this.generativeBackend = generativeBackend;
            this.tools = new ArrayList();
            this.requestOptions = new RequestOptions(0L, 0, 3, (DefaultConstructorMarker) null);
            this.apiClient = "gl-kotlin/" + KotlinVersion.CURRENT + "-ai fire/17.10.1";
            this.onDeviceConfig = OnDeviceConfig.IN_CLOUD;
        }

        public static /* synthetic */ GenerativeModelProvider buildCloudModelProvider$com_google_firebase_ai_logic_firebase_ai$default(Builder builder, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return builder.buildCloudModelProvider$com_google_firebase_ai_logic_firebase_ai(z);
        }

        public final GenerativeModel build$com_google_firebase_ai_logic_firebase_ai() {
            return new GenerativeModel(getModelProvider$com_google_firebase_ai_logic_firebase_ai(), this.requestOptions, this.tools);
        }

        public final GenerativeModelProvider buildCloudModelProvider$com_google_firebase_ai_logic_firebase_ai(boolean isHybrid) {
            String str = this.modelName;
            GenerationConfig generationConfig = this.generationConfig;
            List<SafetySetting> list = this.safetySettings;
            List<Tool> list2 = this.tools;
            ToolConfig toolConfig = this.toolConfig;
            Content content = this.systemInstruction;
            GenerativeBackend generativeBackend = this.generativeBackend;
            String str2 = this.apiKey;
            String str3 = this.modelName;
            RequestOptions requestOptions = this.requestOptions;
            String strM$1 = this.apiClient;
            if (isHybrid) {
                strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(strM$1, " hybrid");
            }
            FirebaseApp firebaseApp = this.firebaseApp;
            String str4 = GenerativeModel.TAG;
            str4.getClass();
            return new CloudGenerativeModelProvider(str, generationConfig, list, list2, toolConfig, content, generativeBackend, new APIController(str2, str3, requestOptions, strM$1, firebaseApp, new AppCheckHeaderProvider(str4, this.useLimitedUseAppCheckTokens, null, null), null, 64, null));
        }

        public final GenerativeModelProvider buildOnDeviceModelProvider$com_google_firebase_ai_logic_firebase_ai() {
            return new MissingOnDeviceGenerativeModelProvider();
        }

        public final GenerativeModelProvider getModelProvider$com_google_firebase_ai_logic_firebase_ai() {
            InferenceMode mode = this.onDeviceConfig.getMode();
            if (Intrinsics.areEqual(mode, InferenceMode.ONLY_IN_CLOUD)) {
                return buildCloudModelProvider$com_google_firebase_ai_logic_firebase_ai$default(this, false, 1, null);
            }
            if (Intrinsics.areEqual(mode, InferenceMode.ONLY_ON_DEVICE)) {
                return buildOnDeviceModelProvider$com_google_firebase_ai_logic_firebase_ai();
            }
            if (Intrinsics.areEqual(mode, InferenceMode.PREFER_ON_DEVICE)) {
                return new FallbackGenerativeModelProvider(buildOnDeviceModelProvider$com_google_firebase_ai_logic_firebase_ai(), buildCloudModelProvider$com_google_firebase_ai_logic_firebase_ai(true), null, true, 4, null);
            }
            if (!Intrinsics.areEqual(mode, InferenceMode.PREFER_IN_CLOUD)) {
                throw new InvalidStateException("Invalid inference mode", null, 2, null);
            }
            GenerativeModelProvider generativeModelProviderBuildCloudModelProvider$com_google_firebase_ai_logic_firebase_ai = buildCloudModelProvider$com_google_firebase_ai_logic_firebase_ai(true);
            GenerativeModelProvider generativeModelProviderBuildOnDeviceModelProvider$com_google_firebase_ai_logic_firebase_ai = buildOnDeviceModelProvider$com_google_firebase_ai_logic_firebase_ai();
            Object systemService = this.firebaseApp.getApplicationContext().getSystemService("connectivity");
            systemService.getClass();
            return new FallbackGenerativeModelProvider(generativeModelProviderBuildCloudModelProvider$com_google_firebase_ai_logic_firebase_ai, generativeModelProviderBuildOnDeviceModelProvider$com_google_firebase_ai_logic_firebase_ai, new GenerativeModel$Builder$getModelProvider$1(new NetworkStatusChecker((ConnectivityManager) systemService)), false);
        }

        public final void setAppCheckTokenProvider(InteropAppCheckTokenProvider interopAppCheckTokenProvider) {
        }

        public final void setGenerationConfig(GenerationConfig generationConfig) {
            this.generationConfig = generationConfig;
        }

        public final void setInternalAuthProvider(InternalAuthProvider internalAuthProvider) {
        }

        public final void setOnDeviceConfig(OnDeviceConfig onDeviceConfig) {
            onDeviceConfig.getClass();
            this.onDeviceConfig = onDeviceConfig;
        }

        public final void setOnDeviceFactoryProvider(FirebaseAIOnDeviceGenerativeModelFactory firebaseAIOnDeviceGenerativeModelFactory) {
        }

        public final void setRequestOptions(RequestOptions requestOptions) {
            requestOptions.getClass();
            this.requestOptions = requestOptions;
        }

        public final void setSafetySettings(List<SafetySetting> list) {
            this.safetySettings = list;
        }

        public final void setSystemInstruction(Content content) {
            this.systemInstruction = content;
        }

        public final void setToolConfig(ToolConfig toolConfig) {
            this.toolConfig = toolConfig;
        }

        public final void setTools(List<Tool> list) {
            list.getClass();
            this.tools = list;
        }
    }

    public GenerativeModel(GenerativeModelProvider generativeModelProvider, RequestOptions requestOptions, List<Tool> list) {
        generativeModelProvider.getClass();
        requestOptions.getClass();
        list.getClass();
        this.actualModel = generativeModelProvider;
        this.requestOptions = requestOptions;
        this.tools = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit generateContent$lambda$0(String str, Content.Builder builder) {
        builder.getClass();
        builder.addText(str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <I, O> Object executeFunction$com_google_firebase_ai_logic_firebase_ai(FunctionCallPart functionCallPart, AutoFunctionDeclaration<I, O> autoFunctionDeclaration, String str, Continuation<? super FunctionResponsePart> continuation) {
        GenerativeModel$executeFunction$2 generativeModel$executeFunction$2;
        if (continuation instanceof GenerativeModel$executeFunction$2) {
            generativeModel$executeFunction$2 = (GenerativeModel$executeFunction$2) continuation;
            int i = generativeModel$executeFunction$2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                generativeModel$executeFunction$2.label = i - Integer.MIN_VALUE;
            } else {
                generativeModel$executeFunction$2 = new GenerativeModel$executeFunction$2(this, continuation);
            }
        }
        Object objInvoke = generativeModel$executeFunction$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = generativeModel$executeFunction$2.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                Object objDecodeFromString = APIControllerKt.getJSON().decodeFromString(autoFunctionDeclaration.getInputSchema().getSerializer(), str);
                Function2<I, Continuation<? super O>, Object> functionReference = autoFunctionDeclaration.getFunctionReference();
                if (functionReference == null) {
                    throw new RuntimeException("Function reference for " + autoFunctionDeclaration.getName() + " is missing");
                }
                generativeModel$executeFunction$2.L$0 = functionCallPart;
                generativeModel$executeFunction$2.L$1 = autoFunctionDeclaration;
                generativeModel$executeFunction$2.label = 1;
                objInvoke = functionReference.invoke(objDecodeFromString, generativeModel$executeFunction$2);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                autoFunctionDeclaration = (AutoFunctionDeclaration) generativeModel$executeFunction$2.L$1;
                functionCallPart = (FunctionCallPart) generativeModel$executeFunction$2.L$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            JsonSchema<O> outputSchema = autoFunctionDeclaration.getOutputSchema();
            KSerializer<O> serializer = outputSchema != null ? outputSchema.getSerializer() : null;
            if (serializer != null) {
                return FunctionResponsePart.Companion.from$default(FunctionResponsePart.INSTANCE, JsonElementKt.getJsonObject(APIControllerKt.getJSON().encodeToJsonElement(serializer, objInvoke)), null, 2, null).normalizeAgainstCall$com_google_firebase_ai_logic_firebase_ai(functionCallPart);
            }
            objInvoke.getClass();
            return ((FunctionResponsePart) objInvoke).normalizeAgainstCall$com_google_firebase_ai_logic_firebase_ai(functionCallPart);
        } catch (FirebaseAutoFunctionException e) {
            return FunctionResponsePart.Companion.from$default(FunctionResponsePart.INSTANCE, new JsonObject(MapsKt.mapOf(TuplesKt.to("error", JsonElementKt.JsonPrimitive(e.getMessage())))), null, 2, null).normalizeAgainstCall$com_google_firebase_ai_logic_firebase_ai(functionCallPart);
        }
    }

    public final Object generateContent(String str, Continuation<? super GenerateContentResponse> continuation) {
        return generateContent(CollectionsKt.listOf(ContentKt.content$default(null, new Chat$$ExternalSyntheticLambda0(str, 21), 1, null)), continuation);
    }

    /* JADX INFO: renamed from: getRequestOptions$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final RequestOptions getRequestOptions() {
        return this.requestOptions;
    }

    public final boolean hasFunction$com_google_firebase_ai_logic_firebase_ai(FunctionCallPart call) {
        Object next;
        call.getClass();
        List<Tool> list = this.tools;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<AutoFunctionDeclaration<?, ?>> autoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai = ((Tool) it.next()).getAutoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai();
            if (autoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai == null) {
                autoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai = CollectionsKt.emptyList();
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, autoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai);
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            AutoFunctionDeclaration autoFunctionDeclaration = (AutoFunctionDeclaration) next;
            if (Intrinsics.areEqual(autoFunctionDeclaration.getName(), call.getName()) && autoFunctionDeclaration.getFunctionReference() != null) {
                break;
            }
        }
        return next != null;
    }

    public final Chat startChat(List<Content> history) {
        history.getClass();
        return new Chat(this, CollectionsKt.toMutableList((Collection) history));
    }

    public final Object generateContent(List<Content> list, Continuation<? super GenerateContentResponse> continuation) {
        return this.actualModel.generateContent(list, continuation);
    }

    public final Object executeFunction$com_google_firebase_ai_logic_firebase_ai(FunctionCallPart functionCallPart, Continuation<? super FunctionResponsePart> continuation) {
        Object obj = null;
        if (!this.tools.isEmpty()) {
            List<Tool> list = this.tools;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                List<AutoFunctionDeclaration<?, ?>> autoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai = ((Tool) it.next()).getAutoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai();
                if (autoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai == null) {
                    autoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai = CollectionsKt.emptyList();
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, autoFunctionDeclarations$com_google_firebase_ai_logic_firebase_ai);
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (Intrinsics.areEqual(((AutoFunctionDeclaration) next).getName(), functionCallPart.getName())) {
                    obj = next;
                    break;
                }
            }
            AutoFunctionDeclaration autoFunctionDeclaration = (AutoFunctionDeclaration) obj;
            if (autoFunctionDeclaration != null) {
                return executeFunction$com_google_firebase_ai_logic_firebase_ai(functionCallPart, autoFunctionDeclaration, new JsonObject(functionCallPart.getArgs()).toString(), continuation);
            }
            throw new RuntimeException("No registered function named " + functionCallPart.getName());
        }
        Types$$ExternalSyntheticBUOutline0.m$2("No registered tools");
        return null;
    }
}
