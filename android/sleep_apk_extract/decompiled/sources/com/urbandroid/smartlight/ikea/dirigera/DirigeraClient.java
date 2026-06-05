package com.urbandroid.smartlight.ikea.dirigera;

import android.content.Context;
import android.util.Log;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.facebook.internal.ServerProtocol;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.ikea.tradfri.TradfriKt;
import io.github.zeroone3010.yahueapi.SecureJsonFactory$$ExternalSyntheticLambda0;
import java.io.Closeable;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.DelayKt;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/smartlight/ikea/dirigera/DirigeraClient;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "hubIp", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "code", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "token", "getToken", "setToken", "client", "Lokhttp3/OkHttpClient;", "createInsecureOkHttpClient", "startAuth", "codeVerifier", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pollToken", "parseTokenFromJson", "json", "parseCodeFromJson", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DirigeraClient {
    private final OkHttpClient client;
    private String code;
    private final Context context;
    private final String hubIp;
    private String token;

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.dirigera.DirigeraClient$startAuth$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.dirigera.DirigeraClient", f = "DirigeraClient.kt", l = {79}, m = "startAuth")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DirigeraClient.this.startAuth(null, this);
        }
    }

    public DirigeraClient(Context context, String str) {
        context.getClass();
        str.getClass();
        this.context = context;
        this.hubIp = str;
        this.client = createInsecureOkHttpClient();
    }

    private final OkHttpClient createInsecureOkHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        X509TrustManager x509TrustManager = new X509TrustManager() { // from class: com.urbandroid.smartlight.ikea.dirigera.DirigeraClient$createInsecureOkHttpClient$trustAllCerts$1
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
        return builder.sslSocketFactory(socketFactory, x509TrustManager).hostnameVerifier(new SecureJsonFactory$$ExternalSyntheticLambda0(1)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createInsecureOkHttpClient$lambda$0(String str, SSLSession sSLSession) {
        return true;
    }

    public final String getCode() {
        return this.code;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getToken() {
        return this.token;
    }

    public final String parseCodeFromJson(String json) {
        if (json == null) {
            return null;
        }
        return StringsKt__StringsKt.substringBefore$default(StringsKt__StringsKt.substringAfter$default(json, "\"code\":\"", (String) null, 2, (Object) null), "\"", (String) null, 2, (Object) null);
    }

    public final String parseTokenFromJson(String json) {
        if (json == null) {
            return null;
        }
        return StringsKt__StringsKt.substringBefore$default(StringsKt__StringsKt.substringAfter$default(json, "\"access_token\":\"", (String) null, 2, (Object) null), "\"", (String) null, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String pollToken(String code, String codeVerifier) {
        code.getClass();
        codeVerifier.getClass();
        Response responseExecute = this.client.newCall(new Request.Builder().url("https://" + this.hubIp + ":8443/v1/auth/token").post(new FormBody.Builder(null, 1, 0 == true ? 1 : 0).add("code", code).add("name", "MyAndroidDevice").add("grant_type", "authorization_code").add("code_verifier", codeVerifier).build()).build()).execute();
        if (responseExecute.isSuccessful()) {
            ResponseBody responseBodyBody = responseExecute.getBody();
            try {
                this.token = parseTokenFromJson(responseBodyBody != null ? responseBodyBody.string() : null);
            } catch (Exception unused) {
                return null;
            }
        }
        return this.token;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.lang.Object, okhttp3.Response] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v22, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startAuth(String str, Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        Ref$ObjectRef ref$ObjectRef;
        ?? Execute;
        ?? r1;
        String strString;
        String codeFromJson;
        DirigeraClient dirigeraClient;
        Iterator<Integer> it;
        String str2;
        Ref$ObjectRef ref$ObjectRef2;
        String str3;
        ?? r5;
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
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ref$ObjectRef = new Ref$ObjectRef();
            HttpUrl httpUrlBuild = new HttpUrl.Builder().scheme(TournamentShareDialogURIBuilder.scheme).host(this.hubIp).port(TradfriKt.DIRIGERA_PORT).addPathSegments("v1/auth/authorize").addQueryParameter("audience", this.context.getPackageName()).addQueryParameter("client_id", this.context.getPackageName()).addQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "code").addQueryParameter(ServerProtocol.DIALOG_PARAM_CODE_CHALLENGE, str).addQueryParameter(ServerProtocol.DIALOG_PARAM_CODE_CHALLENGE_METHOD, "S256").build();
            Log.i(Common_smartlightKt.TAG, "Dirigera auth url: " + httpUrlBuild);
            Execute = this.client.newCall(new Request.Builder().url(httpUrlBuild).addHeader("accept", "application/json").get().build()).execute();
            try {
                Log.i(Common_smartlightKt.TAG, "Dirigera auth response: " + Execute);
                if (!Execute.isSuccessful()) {
                    r1 = Execute;
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(r1, null);
                    return ref$ObjectRef.element;
                }
                ResponseBody responseBodyBody = Execute.getBody();
                strString = responseBodyBody != null ? responseBodyBody.string() : null;
                Log.i(Common_smartlightKt.TAG, "Dirigera body received: " + strString);
                codeFromJson = parseCodeFromJson(strString);
                r5 = Execute;
                if (codeFromJson != null) {
                    Log.i(Common_smartlightKt.TAG, "Dirigera Auth Code received: ".concat(codeFromJson));
                    this.code = codeFromJson;
                    dirigeraClient = this;
                    it = new IntRange(0, 30).iterator();
                    str2 = strString;
                    ref$ObjectRef2 = ref$ObjectRef;
                    str3 = str;
                    Execute = Execute;
                }
                r1 = r5;
                System.out.println((Object) ("Auth Initiated. PRESS BUTTON ON HUB NOW. Response: " + strString));
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(r1, null);
                return ref$ObjectRef.element;
            } catch (Throwable th) {
                th = th;
                r1 = Execute;
                throw th;
            }
        }
        if (i2 != 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        it = (Iterator) anonymousClass1.L$6;
        String str4 = (String) anonymousClass1.L$5;
        str2 = (String) anonymousClass1.L$4;
        r1 = (Closeable) anonymousClass1.L$3;
        ref$ObjectRef2 = (Ref$ObjectRef) anonymousClass1.L$2;
        String str5 = (String) anonymousClass1.L$1;
        DirigeraClient dirigeraClient2 = (DirigeraClient) anonymousClass1.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            str3 = str5;
            Execute = r1;
            codeFromJson = str4;
            dirigeraClient = dirigeraClient2;
        } catch (Throwable th2) {
            th = th2;
            try {
                throw th;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(r1, th);
                throw th3;
            }
        }
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            ref$ObjectRef2.element = dirigeraClient.pollToken(codeFromJson, str3);
            anonymousClass1.L$0 = dirigeraClient;
            anonymousClass1.L$1 = str3;
            anonymousClass1.L$2 = ref$ObjectRef2;
            anonymousClass1.L$3 = Execute;
            anonymousClass1.L$4 = str2;
            anonymousClass1.L$5 = codeFromJson;
            anonymousClass1.L$6 = it;
            anonymousClass1.label = 1;
            if (DelayKt.delay(2000L, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ref$ObjectRef = ref$ObjectRef2;
        strString = str2;
        r5 = Execute;
        r1 = r5;
        System.out.println((Object) ("Auth Initiated. PRESS BUTTON ON HUB NOW. Response: " + strString));
        Unit unit22 = Unit.INSTANCE;
        CloseableKt.closeFinally(r1, null);
        return ref$ObjectRef.element;
    }
}
