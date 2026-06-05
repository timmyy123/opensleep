package com.urbandroid.smartlight.ikea.dirigera;

import android.content.Context;
import android.util.Log;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.internal.ServerProtocol;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.controller.Controller;
import com.urbandroid.smartlight.common.mapper.MappersKt;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Blinder;
import com.urbandroid.smartlight.common.model.BlinderState;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.common.model.State;
import io.github.zeroone3010.yahueapi.SecureJsonFactory$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import oauth.signpost.OAuth;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010 \u001a\u00020\u001fH\u0002J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0096@¢\u0006\u0002\u0010(J$\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010,\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u0004\u0018\u00010\u001a2\u0006\u0010/\u001a\u00020'H\u0096@¢\u0006\u0002\u00100J,\u00101\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010,\u001a\u00020\u001a2\u0006\u00102\u001a\u000203H\u0096@¢\u0006\u0002\u00104J\u0018\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000208H\u0096@¢\u0006\u0002\u00109J$\u0010:\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002080&2\u0006\u0010,\u001a\u000206H\u0096@¢\u0006\u0002\u0010<J\u000e\u0010=\u001a\u00020*H\u0096@¢\u0006\u0002\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001a`\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006>"}, d2 = {"Lcom/urbandroid/smartlight/ikea/dirigera/DirigeraController;", "Lcom/urbandroid/smartlight/common/controller/Controller;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "gateway", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Dirigera;", "<init>", "(Landroid/content/Context;Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Dirigera;)V", "getContext", "()Landroid/content/Context;", "getGateway", "()Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Dirigera;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "tag", "", "getTag", "()Ljava/lang/String;", "job", "Lkotlinx/coroutines/CompletableJob;", "stateMap", "Ljava/util/HashMap;", "Lcom/urbandroid/smartlight/common/model/State;", "Lkotlin/collections/HashMap;", "getStateMap", "()Ljava/util/HashMap;", "client", "Lokhttp3/OkHttpClient;", "createInsecureOkHttpClient", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getLights", "", "Lcom/urbandroid/smartlight/common/model/Light;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setState", "", "lights", ServerProtocol.DIALOG_PARAM_STATE, "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getState", "light", "(Lcom/urbandroid/smartlight/common/model/Light;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "blink", "repeat", "", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/State;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBlinderState", "Lcom/urbandroid/smartlight/common/model/BlinderState;", "blinder", "Lcom/urbandroid/smartlight/common/model/Blinder;", "(Lcom/urbandroid/smartlight/common/model/Blinder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBlinderState", "blinders", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/BlinderState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DirigeraController implements Controller, FeatureLogger, CoroutineScope {
    private final OkHttpClient client;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final AuthenticatedGateway.Dirigera gateway;
    private final Gson gson;
    private final CompletableJob job;
    private final HashMap<String, State> stateMap;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.dirigera.DirigeraController$blink$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.dirigera.DirigeraController", f = "DirigeraController.kt", l = {143, 145, 148, 150, 152, 154, 156}, m = "blink")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DirigeraController.this.blink((List<Light>) null, (State) null, 0, this);
        }
    }

    public DirigeraController(Context context, AuthenticatedGateway.Dirigera dirigera) {
        context.getClass();
        dirigera.getClass();
        this.context = context;
        this.gateway = dirigera;
        this.gson = new Gson();
        this.tag = Common_smartlightKt.TAG;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.stateMap = new HashMap<>();
        this.client = createInsecureOkHttpClient();
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default).plus(new DirigeraController$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
    }

    private final OkHttpClient createInsecureOkHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        X509TrustManager x509TrustManager = new X509TrustManager() { // from class: com.urbandroid.smartlight.ikea.dirigera.DirigeraController$createInsecureOkHttpClient$trustAllCerts$1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
                chain.getClass();
                authType.getClass();
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
                chain.getClass();
                authType.getClass();
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        SSLContext sSLContext = SSLContext.getInstance("SSL");
        sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        socketFactory.getClass();
        return builder.sslSocketFactory(socketFactory, x509TrustManager).hostnameVerifier(new SecureJsonFactory$$ExternalSyntheticLambda0(2)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createInsecureOkHttpClient$lambda$0(String str, SSLSession sSLSession) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0137, code lost:
    
        if (r2.setState(r1, r0, r4) != r5) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0106 A[PHI: r0 r1 r2 r6
      0x0106: PHI (r0v11 com.urbandroid.smartlight.common.model.State) = (r0v8 com.urbandroid.smartlight.common.model.State), (r0v13 com.urbandroid.smartlight.common.model.State) binds: [B:31:0x0103, B:15:0x005b] A[DONT_GENERATE, DONT_INLINE]
      0x0106: PHI (r1v11 com.urbandroid.smartlight.common.model.State) = (r1v8 com.urbandroid.smartlight.common.model.State), (r1v15 com.urbandroid.smartlight.common.model.State) binds: [B:31:0x0103, B:15:0x005b] A[DONT_GENERATE, DONT_INLINE]
      0x0106: PHI (r2v13 java.util.List<com.urbandroid.smartlight.common.model.Light>) = 
      (r2v10 java.util.List<com.urbandroid.smartlight.common.model.Light>)
      (r2v16 java.util.List<com.urbandroid.smartlight.common.model.Light>)
     binds: [B:31:0x0103, B:15:0x005b] A[DONT_GENERATE, DONT_INLINE]
      0x0106: PHI (r6v5 com.urbandroid.smartlight.ikea.dirigera.DirigeraController) = 
      (r6v2 com.urbandroid.smartlight.ikea.dirigera.DirigeraController)
      (r6v7 com.urbandroid.smartlight.ikea.dirigera.DirigeraController)
     binds: [B:31:0x0103, B:15:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012a A[PHI: r0 r1 r2
      0x012a: PHI (r0v17 com.urbandroid.smartlight.common.model.State) = (r0v14 com.urbandroid.smartlight.common.model.State), (r0v20 com.urbandroid.smartlight.common.model.State) binds: [B:38:0x0127, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x012a: PHI (r1v19 java.util.List<com.urbandroid.smartlight.common.model.Light>) = 
      (r1v16 java.util.List<com.urbandroid.smartlight.common.model.Light>)
      (r1v21 java.util.List<com.urbandroid.smartlight.common.model.Light>)
     binds: [B:38:0x0127, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x012a: PHI (r2v20 com.urbandroid.smartlight.ikea.dirigera.DirigeraController) = 
      (r2v17 com.urbandroid.smartlight.ikea.dirigera.DirigeraController)
      (r2v22 com.urbandroid.smartlight.ikea.dirigera.DirigeraController)
     binds: [B:38:0x0127, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // com.urbandroid.smartlight.common.controller.Controller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object blink(List<Light> list, State state, int i, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        State state2;
        DirigeraController dirigeraController;
        State stateCopy$default;
        DirigeraController dirigeraController2;
        List<Light> list2;
        State state3;
        List<Light> list3;
        DirigeraController dirigeraController3;
        DirigeraController dirigeraController4 = this;
        List<Light> list4 = list;
        State state4 = state;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = dirigeraController4.new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                anonymousClass1.L$0 = dirigeraController4;
                anonymousClass1.L$1 = list4;
                anonymousClass1.L$2 = state4;
                anonymousClass1.label = 1;
                if (dirigeraController4.setState(list4, state4, anonymousClass1) != coroutine_suspended) {
                    anonymousClass1.L$0 = dirigeraController4;
                    anonymousClass1.L$1 = list4;
                    anonymousClass1.L$2 = state4;
                    anonymousClass1.label = 2;
                    if (DelayKt.delay(1000L, anonymousClass1) != coroutine_suspended) {
                        state2 = state4;
                        dirigeraController = dirigeraController4;
                        stateCopy$default = State.copy$default(state2, null, 0, State.Switch.OFF, false, 11, null);
                        anonymousClass1.L$0 = dirigeraController;
                        anonymousClass1.L$1 = list4;
                        anonymousClass1.L$2 = state2;
                        anonymousClass1.L$3 = stateCopy$default;
                        anonymousClass1.label = 3;
                        if (dirigeraController.setState(list4, stateCopy$default, anonymousClass1) != coroutine_suspended) {
                            dirigeraController2 = dirigeraController;
                            list2 = list4;
                            state3 = state2;
                            anonymousClass1.L$0 = dirigeraController2;
                            anonymousClass1.L$1 = list2;
                            anonymousClass1.L$2 = state3;
                            anonymousClass1.L$3 = stateCopy$default;
                            anonymousClass1.label = 4;
                            if (DelayKt.delay(1000L, anonymousClass1) != coroutine_suspended) {
                                anonymousClass1.L$0 = dirigeraController2;
                                anonymousClass1.L$1 = list2;
                                anonymousClass1.L$2 = stateCopy$default;
                                anonymousClass1.L$3 = null;
                                anonymousClass1.label = 5;
                                if (dirigeraController2.setState(list2, state3, anonymousClass1) != coroutine_suspended) {
                                    list3 = list2;
                                    dirigeraController3 = dirigeraController2;
                                    anonymousClass1.L$0 = dirigeraController3;
                                    anonymousClass1.L$1 = list3;
                                    anonymousClass1.L$2 = stateCopy$default;
                                    anonymousClass1.label = 6;
                                    if (DelayKt.delay(1000L, anonymousClass1) != coroutine_suspended) {
                                        anonymousClass1.L$0 = null;
                                        anonymousClass1.L$1 = null;
                                        anonymousClass1.L$2 = null;
                                        anonymousClass1.label = 7;
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
                return coroutine_suspended;
            case 1:
                State state5 = (State) anonymousClass1.L$2;
                list4 = (List) anonymousClass1.L$1;
                DirigeraController dirigeraController5 = (DirigeraController) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                state4 = state5;
                dirigeraController4 = dirigeraController5;
                anonymousClass1.L$0 = dirigeraController4;
                anonymousClass1.L$1 = list4;
                anonymousClass1.L$2 = state4;
                anonymousClass1.label = 2;
                if (DelayKt.delay(1000L, anonymousClass1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 2:
                State state6 = (State) anonymousClass1.L$2;
                list4 = (List) anonymousClass1.L$1;
                dirigeraController = (DirigeraController) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                state2 = state6;
                stateCopy$default = State.copy$default(state2, null, 0, State.Switch.OFF, false, 11, null);
                anonymousClass1.L$0 = dirigeraController;
                anonymousClass1.L$1 = list4;
                anonymousClass1.L$2 = state2;
                anonymousClass1.L$3 = stateCopy$default;
                anonymousClass1.label = 3;
                if (dirigeraController.setState(list4, stateCopy$default, anonymousClass1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 3:
                stateCopy$default = (State) anonymousClass1.L$3;
                state3 = (State) anonymousClass1.L$2;
                list2 = (List) anonymousClass1.L$1;
                dirigeraController2 = (DirigeraController) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                anonymousClass1.L$0 = dirigeraController2;
                anonymousClass1.L$1 = list2;
                anonymousClass1.L$2 = state3;
                anonymousClass1.L$3 = stateCopy$default;
                anonymousClass1.label = 4;
                if (DelayKt.delay(1000L, anonymousClass1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 4:
                stateCopy$default = (State) anonymousClass1.L$3;
                state3 = (State) anonymousClass1.L$2;
                list2 = (List) anonymousClass1.L$1;
                dirigeraController2 = (DirigeraController) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                anonymousClass1.L$0 = dirigeraController2;
                anonymousClass1.L$1 = list2;
                anonymousClass1.L$2 = stateCopy$default;
                anonymousClass1.L$3 = null;
                anonymousClass1.label = 5;
                if (dirigeraController2.setState(list2, state3, anonymousClass1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 5:
                stateCopy$default = (State) anonymousClass1.L$2;
                list3 = (List) anonymousClass1.L$1;
                dirigeraController3 = (DirigeraController) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                anonymousClass1.L$0 = dirigeraController3;
                anonymousClass1.L$1 = list3;
                anonymousClass1.L$2 = stateCopy$default;
                anonymousClass1.label = 6;
                if (DelayKt.delay(1000L, anonymousClass1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 6:
                stateCopy$default = (State) anonymousClass1.L$2;
                list3 = (List) anonymousClass1.L$1;
                dirigeraController3 = (DirigeraController) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.L$2 = null;
                anonymousClass1.label = 7;
                break;
            case 7:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object close(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object getBlinderState(Blinder blinder, Continuation<? super BlinderState> continuation) {
        return null;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final Gson getGson() {
        return this.gson;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object getLights(Continuation<? super List<Light>> continuation) {
        String strString;
        Request.Builder builderUrl = new Request.Builder().url("https://" + getGateway().getIp() + ":8443/v1/devices");
        StringBuilder sb = new StringBuilder("Bearer ");
        sb.append(getGateway().getToken());
        Response responseExecute = this.client.newCall(builderUrl.addHeader(OAuth.HTTP_AUTHORIZATION_HEADER, sb.toString()).get().build()).execute();
        try {
            if (!responseExecute.isSuccessful()) {
                System.out.println((Object) ("Server error: " + responseExecute.getCode()));
                List listEmptyList = CollectionsKt.emptyList();
                CloseableKt.closeFinally(responseExecute, null);
                return listEmptyList;
            }
            ResponseBody responseBodyBody = responseExecute.getBody();
            if (responseBodyBody == null || (strString = responseBodyBody.string()) == null) {
                CloseableKt.closeFinally(responseExecute, null);
                return CollectionsKt.emptyList();
            }
            Object objFromJson = this.gson.fromJson(strString, new TypeToken<List<? extends DirigeraDevice>>() { // from class: com.urbandroid.smartlight.ikea.dirigera.DirigeraController$getLights$2$1$deviceListType$1
            }.getType());
            objFromJson.getClass();
            ArrayList<DirigeraDevice> arrayList = new ArrayList();
            for (Object obj : (List) objFromJson) {
                if (Intrinsics.areEqual(((DirigeraDevice) obj).getType(), "light")) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (DirigeraDevice dirigeraDevice : arrayList) {
                arrayList2.add(new Light(dirigeraDevice.getId(), dirigeraDevice.getAttributes().getName(), null, 4, null));
            }
            CloseableKt.closeFinally(responseExecute, null);
            return arrayList2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(responseExecute, th);
                throw th2;
            }
        }
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object getState(Light light, Continuation<? super State> continuation) {
        return this.stateMap.get(light.getId());
    }

    public final HashMap<String, State> getStateMap() {
        return this.stateMap;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setBlinderState(Blinder blinder, BlinderState blinderState, Continuation<? super Unit> continuation) {
        return Controller.DefaultImpls.setBlinderState(this, blinder, blinderState, continuation);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setState(List<Light> list, State state, Continuation<? super Unit> continuation) {
        for (Light light : list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("isOn", Boxing.boxBoolean(state.getSwitch() == State.Switch.ON));
            linkedHashMap.put("colorHue", MappersKt.toHueState(state).getHue());
            linkedHashMap.put("colorTemperature", MappersKt.toHueState(state).getCt());
            linkedHashMap.put("colorSaturation", MappersKt.toHueState(state).getSaturation());
            String json = this.gson.toJson(CollectionsKt.listOf(MapsKt.mapOf(TuplesKt.to("attributes", linkedHashMap))));
            RequestBody.Companion companion = RequestBody.INSTANCE;
            json.getClass();
            try {
                Response responseExecute = this.client.newCall(new Request.Builder().url("https://" + getGateway().getIp() + ":8443/v1/devices/" + light.getId()).addHeader(OAuth.HTTP_AUTHORIZATION_HEADER, "Bearer " + getGateway().getToken()).patch(companion.create(json, MediaType.INSTANCE.get("application/json"))).build()).execute();
                try {
                    if (responseExecute.isSuccessful()) {
                        System.out.println((Object) ("Success: Light " + light.getId() + " state updated."));
                    } else {
                        System.out.println((Object) ("Failed: " + responseExecute.getCode() + ' ' + responseExecute.getMessage()));
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(responseExecute, null);
                } finally {
                }
            } catch (IOException e) {
                Log.e(Common_smartlightKt.TAG, "Set state error ", e);
            }
            this.stateMap.put(light.getId(), state);
        }
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public AuthenticatedGateway.Dirigera getGateway() {
        return this.gateway;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setBlinderState(List<Blinder> list, BlinderState blinderState, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object blink(Light light, State state, int i, Continuation<? super Unit> continuation) {
        return Controller.DefaultImpls.blink(this, light, state, i, continuation);
    }

    @Override // com.urbandroid.smartlight.common.controller.Controller
    public Object setState(Light light, State state, Continuation<? super Unit> continuation) {
        return Controller.DefaultImpls.setState(this, light, state, continuation);
    }
}
