package com.urbandroid.smartlight.ikea.tradfri;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.ServerProtocol;
import com.google.gson.Gson;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.controller.SafeResumeContinuation;
import com.urbandroid.smartlight.common.model.Color;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.common.model.State;
import com.urbandroid.smartlight.common.model.StateKt;
import com.urbandroid.smartlight.ikea.tradfri.Tradfri;
import com.urbandroid.smartlight.ikea.tradfri.coapmodel.AuthenticationResult;
import com.urbandroid.smartlight.ikea.tradfri.coapmodel.BlinderUpdater;
import com.urbandroid.smartlight.ikea.tradfri.coapmodel.Device;
import com.urbandroid.smartlight.ikea.tradfri.coapmodel.DeviceUpdater;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.elements.util.NamedThreadFactory;
import org.eclipse.californium.scandium.DTLSConnector;
import org.eclipse.californium.scandium.config.DtlsConnectorConfig;
import org.eclipse.californium.scandium.dtls.pskstore.StaticPskStore;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 ,2\u00020\u0001:\u0004)*+,B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0006\b\u0000\u0010\u001d\u0018\u0001*\u00020\u001eH\u0084\b¢\u0006\u0002\u0010\u001fJJ\u0010 \u001a\u0004\u0018\u0001H\u001d\"\u0006\b\u0000\u0010\u001d\u0018\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010'\u001a\u00020\u0017H\u0084H¢\u0006\u0002\u0010(R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0013X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0082\u0001\u0002-.¨\u0006/"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Client;", "", "<init>", "()V", "gateway", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "getGateway", "()Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "endpoint", "Lorg/eclipse/californium/core/network/CoapEndpoint;", "getEndpoint", "()Lorg/eclipse/californium/core/network/CoapEndpoint;", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "stateExecutor", "getStateExecutor", "sendLock", "Lkotlinx/coroutines/sync/Mutex;", "getSendLock", "()Lkotlinx/coroutines/sync/Mutex;", "lastSendTimestamp", "", "getLastSendTimestamp", "()J", "setLastSendTimestamp", "(J)V", "parse", "T", "Lorg/eclipse/californium/core/CoapResponse;", "(Lorg/eclipse/californium/core/CoapResponse;)Ljava/lang/Object;", "send", "method", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Method;", "path", "", "payload", "action", "timeoutInMs", "(Lcom/urbandroid/smartlight/ikea/tradfri/Client$Method;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Method", "Authenticated", "Plain", "Companion", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated;", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Plain;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Client {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Gson gson = new Gson();
    private final ScheduledExecutorService executor;
    private long lastSendTimestamp;
    private final Mutex sendLock;
    private final ScheduledExecutorService stateExecutor;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Client$Companion;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Gson getGson() {
            return Client.gson;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Client$Method;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "GET_SYNC", "PUT", "POST", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Method {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Method[] $VALUES;
        public static final Method GET = new Method("GET", 0);
        public static final Method GET_SYNC = new Method("GET_SYNC", 1);
        public static final Method PUT = new Method("PUT", 2);
        public static final Method POST = new Method("POST", 3);

        private static final /* synthetic */ Method[] $values() {
            return new Method[]{GET, GET_SYNC, PUT, POST};
        }

        static {
            Method[] methodArr$values = $values();
            $VALUES = methodArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(methodArr$values);
        }

        private Method(String str, int i) {
        }

        public static EnumEntries<Method> getEntries() {
            return $ENTRIES;
        }

        public static Method valueOf(String str) {
            return (Method) Enum.valueOf(Method.class, str);
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Client$Plain;", "Lcom/urbandroid/smartlight/ikea/tradfri/Client;", "gateway", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "securityCode", "", "<init>", "(Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;Ljava/lang/String;)V", "getGateway", "()Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "endpoint", "Lorg/eclipse/californium/core/network/CoapEndpoint;", "getEndpoint", "()Lorg/eclipse/californium/core/network/CoapEndpoint;", "endpoint$delegate", "Lkotlin/Lazy;", "authenticate", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Access;", "identity", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Plain extends Client {

        /* JADX INFO: renamed from: endpoint$delegate, reason: from kotlin metadata */
        private final Lazy endpoint;
        private final Tradfri.Gateway gateway;
        private final String securityCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Plain(Tradfri.Gateway gateway, String str) {
            super(null);
            gateway.getClass();
            str.getClass();
            this.gateway = gateway;
            this.securityCode = str;
            this.endpoint = LazyKt.lazy(new Url$$ExternalSyntheticLambda0(this, 19));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CoapEndpoint endpoint_delegate$lambda$3(Plain plain) {
            DtlsConnectorConfig.Builder builder = new DtlsConnectorConfig.Builder();
            byte[] bytes = plain.securityCode.getBytes(Charsets.UTF_8);
            bytes.getClass();
            builder.setPskStore(new StaticPskStore("Client_identity", bytes));
            builder.setRetransmissionTimeout(TradfriKt.getRETRANSMISSION_TIMEOUT_IN_MILLIS());
            CoapEndpoint.Builder builder2 = new CoapEndpoint.Builder();
            builder2.setConnector(new DTLSConnector(builder.build()));
            builder2.setNetworkConfig(NetworkConfig.createStandardWithoutFile());
            CoapEndpoint coapEndpointBuild = builder2.build();
            coapEndpointBuild.setExecutors(plain.getExecutor(), plain.getExecutor());
            return coapEndpointBuild;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object authenticate(String str, Continuation<? super Tradfri.Access> continuation) {
            Client$Plain$authenticate$1 client$Plain$authenticate$1;
            Plain plain = this;
            String str2 = str;
            if (continuation instanceof Client$Plain$authenticate$1) {
                client$Plain$authenticate$1 = (Client$Plain$authenticate$1) continuation;
                int i = client$Plain$authenticate$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    client$Plain$authenticate$1.label = i - Integer.MIN_VALUE;
                } else {
                    client$Plain$authenticate$1 = new Client$Plain$authenticate$1(plain, continuation);
                }
            }
            Client$Plain$authenticate$1 client$Plain$authenticate$12 = client$Plain$authenticate$1;
            Object objWithContext = client$Plain$authenticate$12.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = client$Plain$authenticate$12.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                Method method = Method.POST;
                String strM = FileInsert$$ExternalSyntheticOutline0.m("{ \"9090\": \"", str2, "\"}");
                long secondsInMillis = Utils.getSecondsInMillis(5);
                try {
                    CoroutineDispatcher io2 = Dispatchers.getIO();
                    Client$Plain$authenticate$$inlined$send$default$1 client$Plain$authenticate$$inlined$send$default$1 = new Client$Plain$authenticate$$inlined$send$default$1(plain, method, "/15011/9063", strM, "authenticate", secondsInMillis, null);
                    client$Plain$authenticate$12.L$0 = plain;
                    client$Plain$authenticate$12.L$1 = str2;
                    client$Plain$authenticate$12.label = 1;
                    objWithContext = BuildersKt.withContext(io2, client$Plain$authenticate$$inlined$send$default$1, client$Plain$authenticate$12);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e) {
                    e = e;
                    Logger.logSevere("general send failure", e);
                    objWithContext = null;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                String str3 = (String) client$Plain$authenticate$12.L$1;
                Plain plain2 = (Plain) client$Plain$authenticate$12.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    str2 = str3;
                    plain = plain2;
                } catch (Exception e2) {
                    e = e2;
                    str2 = str3;
                    plain = plain2;
                    Logger.logSevere("general send failure", e);
                    objWithContext = null;
                }
            }
            AuthenticationResult authenticationResult = (AuthenticationResult) objWithContext;
            if (authenticationResult == null) {
                return null;
            }
            return new Tradfri.Access(plain.getGateway().getName(), plain.securityCode, new Tradfri.Access.Credential(str2, authenticationResult.getPreSharedKey()), 0L, 8, null).successfullyUsed();
        }

        @Override // com.urbandroid.smartlight.ikea.tradfri.Client
        public CoapEndpoint getEndpoint() {
            Object value = this.endpoint.getValue();
            value.getClass();
            return (CoapEndpoint) value;
        }

        @Override // com.urbandroid.smartlight.ikea.tradfri.Client
        public Tradfri.Gateway getGateway() {
            return this.gateway;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.Client$send$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 176)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Client$send$2", f = "Client.kt", l = {476, 431}, m = "invokeSuspend")
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ String $action;
        final /* synthetic */ Method $method;
        final /* synthetic */ String $path;
        final /* synthetic */ String $payload;
        final /* synthetic */ long $timeoutInMs;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Method method, String str, String str2, String str3, long j, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$method = method;
            this.$path = str;
            this.$payload = str2;
            this.$action = str3;
            this.$timeoutInMs = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.needClassReification();
            return Client.this.new AnonymousClass2(this.$method, this.$path, this.$payload, this.$action, this.$timeoutInMs, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex sendLock;
            final Client client;
            Method method;
            String str;
            String str2;
            long j;
            String str3;
            Mutex mutex;
            final String str4;
            CoapClient coapClient;
            Method method2;
            Object orThrow;
            Object objFromJson;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    sendLock = Client.this.getSendLock();
                    client = Client.this;
                    method = this.$method;
                    str = this.$path;
                    String str5 = this.$payload;
                    str2 = this.$action;
                    j = this.$timeoutInMs;
                    this.L$0 = sendLock;
                    this.L$1 = client;
                    this.L$2 = method;
                    this.L$3 = str;
                    this.L$4 = str5;
                    this.L$5 = str2;
                    this.J$0 = j;
                    this.label = 1;
                    if (sendLock.lock(null, this) != coroutine_suspended) {
                        str3 = str5;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    long j2 = this.J$0;
                    String str6 = (String) this.L$5;
                    String str7 = (String) this.L$4;
                    str = (String) this.L$3;
                    method = (Method) this.L$2;
                    client = (Client) this.L$1;
                    Mutex mutex2 = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str2 = str6;
                    sendLock = mutex2;
                    j = j2;
                    str3 = str7;
                } else {
                    if (i != 2) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mutex = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        orThrow = obj;
                        mutex.unlock(null);
                        return orThrow;
                    } catch (Throwable th) {
                        th = th;
                    }
                }
                client.setLastSendTimestamp(System.currentTimeMillis());
                str4 = method + ' ' + client.getGateway().getUri() + str + ' ';
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                sb.append(str3 == null ? "" : str3);
                sb.append("... ");
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                Logger.logDebug(sb.toString(), null);
                coapClient = new CoapClient(client.getGateway().getUri() + str);
                method2 = Method.PUT;
                if (method == method2) {
                    coapClient.useNONs();
                } else {
                    coapClient.useCONs();
                }
                coapClient.setEndpoint(client.getEndpoint());
                coapClient.setTimeout(Boxing.boxLong(j));
            } catch (Throwable th2) {
                th = th2;
                mutex = sendLock;
            }
            if (method == method2) {
                coapClient.put(str3, 50);
                sendLock.unlock(null);
                return null;
            }
            String str8 = str3;
            if (method == Method.GET_SYNC) {
                CoapResponse coapResponse = coapClient.get();
                if (coapResponse != null) {
                    String responseText = coapResponse.getResponseText();
                    try {
                        Gson gson = Client.INSTANCE.getGson();
                        Intrinsics.reifiedOperationMarker(4, "T");
                        objFromJson = gson.fromJson(responseText, (Class<Object>) Object.class);
                        Logger.logDebug("response: " + responseText, null);
                    } catch (Exception e) {
                        Logger.logSevere("fail to parse json: " + coapResponse.getResponseText(), e);
                        objFromJson = null;
                    }
                } else {
                    objFromJson = null;
                }
                sendLock.unlock(null);
                return objFromJson;
            }
            Method method3 = Method.GET;
            Method method4 = Method.POST;
            if (!SetsKt.setOf((Object[]) new Method[]{method3, method4}).contains(method)) {
                sendLock.unlock(null);
                return null;
            }
            this.L$0 = sendLock;
            this.L$1 = client;
            this.L$2 = method;
            this.L$3 = str8;
            this.L$4 = str4;
            this.L$5 = coapClient;
            this.L$6 = this;
            this.label = 2;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
            final SafeResumeContinuation safeResumeContinuation = new SafeResumeContinuation(safeContinuation);
            Intrinsics.needClassReification();
            CoapHandler coapHandler = new CoapHandler() { // from class: com.urbandroid.smartlight.ikea.tradfri.Client$send$2$1$1$handler$1
                @Override // org.eclipse.californium.core.CoapHandler
                public void onError() {
                    Logger.logSevere(str4 + " ... onError failed", null);
                    safeResumeContinuation.resumeWith(Result.m2357constructorimpl(null));
                }

                @Override // org.eclipse.californium.core.CoapHandler
                public void onLoad(CoapResponse response) {
                    response.getClass();
                    String str9 = str4 + " ... response: code: " + response.getCode() + " payload: " + response.getResponseText();
                    Object obj2 = null;
                    if (!response.isSuccess()) {
                        Logger.logSevere(str9, null);
                        safeResumeContinuation.resumeWith(Result.m2357constructorimpl(null));
                        return;
                    }
                    Logger.logDebug(str9, null);
                    Continuation continuation = safeResumeContinuation;
                    String responseText2 = response.getResponseText();
                    try {
                        Gson gson2 = Client.INSTANCE.getGson();
                        Intrinsics.reifiedOperationMarker(4, "T?");
                        Object objFromJson2 = gson2.fromJson(responseText2, (Class<Object>) Object.class);
                        Logger.logDebug("response: " + responseText2, null);
                        obj2 = objFromJson2;
                    } catch (Exception e2) {
                        Logger.logSevere("fail to parse json: " + response.getResponseText(), e2);
                    }
                    continuation.resumeWith(Result.m2357constructorimpl(obj2));
                }
            };
            if (method == method3) {
                try {
                    coapClient.get(coapHandler);
                } catch (Exception e2) {
                    Logger.logSevere(null, e2);
                    safeResumeContinuation.resumeWith(Result.m2357constructorimpl(null));
                }
            }
            if (method == method4) {
                coapClient.post(coapHandler, str8, 50);
            }
            orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (orThrow != coroutine_suspended) {
                mutex = sendLock;
                mutex.unlock(null);
                return orThrow;
            }
            return coroutine_suspended;
            th = th2;
            mutex = sendLock;
            mutex.unlock(null);
            throw th;
        }
    }

    private Client() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("coap"));
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.getClass();
        this.executor = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor2 = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory(ServerProtocol.DIALOG_PARAM_STATE));
        scheduledExecutorServiceNewSingleThreadScheduledExecutor2.getClass();
        this.stateExecutor = scheduledExecutorServiceNewSingleThreadScheduledExecutor2;
        this.sendLock = MutexKt.Mutex$default(false, 1, null);
        this.lastSendTimestamp = -1L;
    }

    public static /* synthetic */ Object send$default(Client client, Method method, String str, String str2, String str3, long j, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: send");
            return null;
        }
        String str4 = (i & 4) != 0 ? null : str2;
        String str5 = (i & 8) != 0 ? null : str3;
        long secondsInMillis = (i & 16) != 0 ? Utils.getSecondsInMillis(5) : j;
        try {
            CoroutineDispatcher io2 = Dispatchers.getIO();
            Intrinsics.needClassReification();
            AnonymousClass2 anonymousClass2 = client.new AnonymousClass2(method, str, str4, str5, secondsInMillis, null);
            InlineMarker.mark(0);
            Object objWithContext = BuildersKt.withContext(io2, anonymousClass2, continuation);
            InlineMarker.mark(1);
            return objWithContext;
        } catch (Exception e) {
            Logger.logSevere("general send failure", e);
            return null;
        }
    }

    public abstract CoapEndpoint getEndpoint();

    public final ScheduledExecutorService getExecutor() {
        return this.executor;
    }

    public abstract Tradfri.Gateway getGateway();

    public final long getLastSendTimestamp() {
        return this.lastSendTimestamp;
    }

    public final Mutex getSendLock() {
        return this.sendLock;
    }

    public final ScheduledExecutorService getStateExecutor() {
        return this.stateExecutor;
    }

    public final /* synthetic */ <T> T parse(CoapResponse coapResponse) {
        coapResponse.getClass();
        String responseText = coapResponse.getResponseText();
        try {
            Gson gson2 = INSTANCE.getGson();
            Intrinsics.reifiedOperationMarker(4, "T");
            T t = (T) gson2.fromJson(responseText, (Class) Object.class);
            Logger.logDebug("response: " + responseText, null);
            return t;
        } catch (Exception e) {
            Logger.logSevere("fail to parse json: " + coapResponse.getResponseText(), e);
            return null;
        }
    }

    public final /* synthetic */ <T> Object send(Method method, String str, String str2, String str3, long j, Continuation<? super T> continuation) {
        try {
            CoroutineDispatcher io2 = Dispatchers.getIO();
            Intrinsics.needClassReification();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(method, str, str2, str3, j, null);
            InlineMarker.mark(0);
            Object objWithContext = BuildersKt.withContext(io2, anonymousClass2, continuation);
            InlineMarker.mark(1);
            return objWithContext;
        } catch (Exception e) {
            Logger.logSevere("general send failure", e);
            return null;
        }
    }

    public final void setLastSendTimestamp(long j) {
        this.lastSendTimestamp = j;
    }

    @Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0003^_`B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0086@¢\u0006\u0002\u0010+J^\u0010,\u001a\b\u0012\u0004\u0012\u00020'0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020%0$2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u00105\u001a\u000206H\u0086@¢\u0006\u0004\b7\u00108J\u0016\u00109\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010$H\u0086@¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010$H\u0086@¢\u0006\u0002\u0010:J\u001e\u0010@\u001a\b\u0012\u0004\u0012\u00020<0$*\b\u0012\u0004\u0012\u00020\u00170$H\u0082@¢\u0006\u0002\u0010AJ\"\u0010?\u001a\b\u0012\u0004\u0012\u00020<0$2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00170$H\u0086@¢\u0006\u0002\u0010AJ\u0016\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010>J\u0016\u0010E\u001a\u00020'2\u0006\u0010D\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010>J\u0019\u0010F\u001a\n G*\u0004\u0018\u00010\u000e0\u000e*\u00020 H\u0002¢\u0006\u0002\u0010HJ\u0019\u0010F\u001a\n G*\u0004\u0018\u00010\u000e0\u000e*\u00020IH\u0002¢\u0006\u0002\u0010JJ\u001c\u0010K\u001a\u00020L*\u00020 2\u0006\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020\u0017H\u0002J\u001c\u0010O\u001a\u00020L*\u00020L2\u0006\u0010P\u001a\u00020L2\u0006\u0010M\u001a\u00020 H\u0002J\f\u0010Q\u001a\u00020L*\u00020 H\u0002J\f\u0010R\u001a\u000206*\u00020 H\u0002J\u0014\u0010S\u001a\u00020 *\u00020 2\u0006\u0010T\u001a\u00020 H\u0002J\u0006\u0010U\u001a\u00020'J\t\u0010V\u001a\u00020\u0004HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\u001d\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010Y\u001a\u0002062\b\u0010Z\u001a\u0004\u0018\u00010[HÖ\u0003J\t\u0010\\\u001a\u00020\u0017HÖ\u0001J\t\u0010]\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\b\u0012\u00060\u0018R\u00020\u00000\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020 0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0004\u0012\u00020 0#0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated;", "Lcom/urbandroid/smartlight/ikea/tradfri/Client;", "Lcom/urbandroid/common/FeatureLogger;", "gateway", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "credential", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Access$Credential;", "<init>", "(Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Access$Credential;)V", "getGateway", "()Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Gateway;", "getCredential", "()Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$Access$Credential;", "tag", "", "getTag", "()Ljava/lang/String;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "stateScope", "Lkotlinx/coroutines/CoroutineScope;", "deviceTransitionMap", "", "", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated$DeviceTransition;", "endpoint", "Lorg/eclipse/californium/core/network/CoapEndpoint;", "getEndpoint", "()Lorg/eclipse/californium/core/network/CoapEndpoint;", "endpoint$delegate", "Lkotlin/Lazy;", "lastStateMap", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$State;", "applyStateChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Pair;", "", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated$LightId;", "setBlinder", "", "blinderId", "position", "", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setState", "Lkotlin/Result;", "lights", "color", "Lcom/urbandroid/smartlight/common/model/Color;", "brightness", "switch", "Lcom/urbandroid/smartlight/common/model/State$Switch;", "transitionInCentiSeconds", "emulated", "", "setState-bMdYcbs", "(Ljava/util/List;Lcom/urbandroid/smartlight/common/model/Color;Ljava/lang/Integer;Lcom/urbandroid/smartlight/common/model/State$Switch;Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceIds", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDevice", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device;", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDevices", "toDevices", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ids", "turnDeviceOn", "deviceId", "turnDeviceOff", "toUpdateJson", "kotlin.jvm.PlatformType", "(Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$State;)Ljava/lang/String;", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$BlinderState;", "(Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$BlinderState;)Ljava/lang/String;", "calculateStepTo", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated$Step;", "targetState", "totalSteps", "applyStep", "step", "toStep", "isFilled", "merge", ServerProtocol.DIALOG_PARAM_STATE, "close", "component1", "component2", "copy", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "DeviceTransition", "LightId", "Step", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Authenticated extends Client implements FeatureLogger {
        private final Channel<Pair<List<LightId>, Device.State>> applyStateChannel;
        private final Tradfri.Access.Credential credential;
        private final Map<Integer, DeviceTransition> deviceTransitionMap;

        /* JADX INFO: renamed from: endpoint$delegate, reason: from kotlin metadata */
        private final Lazy endpoint;
        private final CoroutineExceptionHandler exceptionHandler;
        private final Tradfri.Gateway gateway;
        private final Map<Integer, Device.State> lastStateMap;
        private final CoroutineScope stateScope;
        private final String tag;

        /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated$1", f = "Client.kt", l = {78, 480}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;

            public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return Authenticated.this.new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Can't wrap try/catch for region: R(9:21|(2:27|33)(3:28|(1:30)(1:31)|32)|34|51|35|36|53|37|(7:40|41|47|(0)|50|19|(2:15|(3:18|19|(0)(0)))(0))) */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x0117, code lost:
            
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x0118, code lost:
            
                r6 = r4;
                r9 = r8;
                r8 = r10;
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x011c, code lost:
            
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x011d, code lost:
            
                r10 = r6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x011f, code lost:
            
                com.urbandroid.common.logging.Logger.logSevere("general send failure", r0);
             */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[PHI: r4
              0x0039: PHI (r4v1 int) = (r4v0 int), (r4v2 int) binds: [B:14:0x0036, B:20:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x013b  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0110 -> B:41:0x0113). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object objReceive;
                Iterator it;
                Authenticated authenticated;
                Device.State state;
                int i;
                Device.State stateCopy$default;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = this.label;
                int i3 = 1;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Channel channel = Authenticated.this.applyStateChannel;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = i3;
                    objReceive = channel.receive(this);
                    if (objReceive != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    Pair pair = (Pair) obj;
                    List list = (List) pair.component1();
                    Device.State state2 = (Device.State) pair.component2();
                    Authenticated authenticated2 = Authenticated.this;
                    it = list.iterator();
                    authenticated = authenticated2;
                    state = state2;
                    if (it.hasNext()) {
                    }
                    return coroutine_suspended;
                }
                if (i2 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                int i4 = this.I$0;
                it = (Iterator) this.L$2;
                Authenticated authenticated3 = (Authenticated) this.L$1;
                Device.State state3 = (Device.State) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    Logger.logSevere("general send failure", e);
                }
                int i5 = i4;
                authenticated = authenticated3;
                state = state3;
                Map map = authenticated.lastStateMap;
                Integer numBoxInt = Boxing.boxInt(i5);
                Map map2 = authenticated.lastStateMap;
                Integer numBoxInt2 = Boxing.boxInt(i5);
                Object obj2 = map2.get(numBoxInt2);
                if (obj2 == null) {
                    map2.put(numBoxInt2, state);
                    obj2 = state;
                }
                map.put(numBoxInt, authenticated.merge((Device.State) obj2, state));
                i3 = 1;
                if (it.hasNext()) {
                    LightId lightId = (LightId) it.next();
                    int id = lightId.getId();
                    Light.Type type = lightId.getType();
                    Method method = Method.PUT;
                    String strM = FileInsert$$ExternalSyntheticOutline0.m(id, "/15001/");
                    if (type != Light.Type.CT || state.getColorX() == null || state.getColorY() == null) {
                        i = id;
                        stateCopy$default = state;
                    } else {
                        int iIntValue = state.getColorX().intValue();
                        int iIntValue2 = state.getColorY().intValue();
                        Integer brightness = state.getBrightness();
                        Color.D65 d65MapToCt = new Color.D65(iIntValue, iIntValue2, Boxing.boxInt(brightness != null ? brightness.intValue() : 0)).mapToCt();
                        i = id;
                        stateCopy$default = Device.State.copy$default(state, null, null, Boxing.boxInt(d65MapToCt.getX()), Boxing.boxInt(d65MapToCt.getY()), null, null, 51, null);
                    }
                    String updateJson = authenticated.toUpdateJson(stateCopy$default);
                    long secondsInMillis = Utils.getSecondsInMillis(5);
                    CoroutineDispatcher io2 = Dispatchers.getIO();
                    Authenticated authenticated4 = authenticated;
                    Client$Authenticated$1$invokeSuspend$lambda$1$$inlined$send$default$1 client$Authenticated$1$invokeSuspend$lambda$1$$inlined$send$default$1 = new Client$Authenticated$1$invokeSuspend$lambda$1$$inlined$send$default$1(authenticated4, method, strM, updateJson, null, secondsInMillis, null);
                    this.L$0 = state;
                    this.L$1 = authenticated4;
                    this.L$2 = it;
                    this.I$0 = i;
                    this.label = 2;
                    if (BuildersKt.withContext(io2, client$Authenticated$1$invokeSuspend$lambda$1$$inlined$send$default$1, this) != coroutine_suspended) {
                        i4 = i;
                        state3 = state;
                        authenticated3 = authenticated4;
                        int i52 = i4;
                        authenticated = authenticated3;
                        state = state3;
                        Map map3 = authenticated.lastStateMap;
                        Integer numBoxInt3 = Boxing.boxInt(i52);
                        Map map22 = authenticated.lastStateMap;
                        Integer numBoxInt22 = Boxing.boxInt(i52);
                        Object obj22 = map22.get(numBoxInt22);
                        if (obj22 == null) {
                        }
                        map3.put(numBoxInt3, authenticated.merge((Device.State) obj22, state));
                        i3 = 1;
                        if (it.hasNext()) {
                            Channel channel2 = Authenticated.this.applyStateChannel;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = i3;
                            objReceive = channel2.receive(this);
                            if (objReceive != coroutine_suspended) {
                                Pair pair2 = (Pair) objReceive;
                                List list2 = (List) pair2.component1();
                                Device.State state4 = (Device.State) pair2.component2();
                                Authenticated authenticated5 = Authenticated.this;
                                it = list2.iterator();
                                authenticated = authenticated5;
                                state = state4;
                                if (it.hasNext()) {
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0003H\u0007J\u0006\u0010\u0016\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated$DeviceTransition;", "", "deviceId", "", "type", "Lcom/urbandroid/smartlight/common/model/Light$Type;", "<init>", "(Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated;ILcom/urbandroid/smartlight/common/model/Light$Type;)V", "getDeviceId", "()I", "getType", "()Lcom/urbandroid/smartlight/common/model/Light$Type;", "job", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "", "fromState", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$State;", "toState", "transitionInCentiSeconds", "stop", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public final class DeviceTransition {
            private final int deviceId;
            private final CompletableJob job;
            private final CoroutineScope scope;
            final /* synthetic */ Authenticated this$0;
            private final Light.Type type;

            public DeviceTransition(Authenticated authenticated, int i, Light.Type type) {
                type.getClass();
                this.this$0 = authenticated;
                this.deviceId = i;
                this.type = type;
                CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
                this.job = completableJobSupervisorJob$default;
                this.scope = CoroutineScopeKt.CoroutineScope(completableJobSupervisorJob$default.plus(Dispatchers.getIO()));
            }

            public final int getDeviceId() {
                return this.deviceId;
            }

            public final Light.Type getType() {
                return this.type;
            }

            public final void start(Device.State fromState, Device.State toState, int transitionInCentiSeconds) {
                fromState.getClass();
                toState.getClass();
                stop();
                BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new Client$Authenticated$DeviceTransition$start$1(transitionInCentiSeconds, this.this$0, fromState, toState, this, null), 3, null);
            }

            public final void stop() {
                JobKt__JobKt.cancelChildren$default(this.job, null, 1, null);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated$LightId;", "", "id", "", "type", "Lcom/urbandroid/smartlight/common/model/Light$Type;", "<init>", "(ILcom/urbandroid/smartlight/common/model/Light$Type;)V", "getId", "()I", "getType", "()Lcom/urbandroid/smartlight/common/model/Light$Type;", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class LightId {
            private final int id;
            private final Light.Type type;

            public LightId(int i, Light.Type type) {
                type.getClass();
                this.id = i;
                this.type = type;
            }

            public static /* synthetic */ LightId copy$default(LightId lightId, int i, Light.Type type, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = lightId.id;
                }
                if ((i2 & 2) != 0) {
                    type = lightId.type;
                }
                return lightId.copy(i, type);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getId() {
                return this.id;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Light.Type getType() {
                return this.type;
            }

            public final LightId copy(int id, Light.Type type) {
                type.getClass();
                return new LightId(id, type);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LightId)) {
                    return false;
                }
                LightId lightId = (LightId) other;
                return this.id == lightId.id && this.type == lightId.type;
            }

            public final int getId() {
                return this.id;
            }

            public final Light.Type getType() {
                return this.type;
            }

            public int hashCode() {
                return this.type.hashCode() + (Integer.hashCode(this.id) * 31);
            }

            public String toString() {
                return "LightId(id=" + this.id + ", type=" + this.type + ')';
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0013J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated$Step;", "", "colorX", "", "colorY", "brightness", "<init>", "(FFF)V", "getColorX", "()F", "getColorY", "getBrightness", "limits", "Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated$Step$Limits;", "getLimits", "()Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated$Step$Limits;", "isChangeSufficient", "", "lastState", "Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/Device$State;", "toDiffDeviceState", "last", "toDeviceState", "hasColorChanged", "other", "hasBrightnessChanged", "component1", "component2", "component3", "copy", "equals", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "Limits", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Step {
            private final float brightness;
            private final float colorX;
            private final float colorY;
            private final Limits limits;

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/Client$Authenticated$Step$Limits;", "", "colorX", "", "colorY", "brightness", "<init>", "(III)V", "getColorX", "()I", "getColorY", "getBrightness", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Limits {
                private final int brightness;
                private final int colorX;
                private final int colorY;

                public Limits(int i, int i2, int i3) {
                    this.colorX = i;
                    this.colorY = i2;
                    this.brightness = i3;
                }

                public final int getBrightness() {
                    return this.brightness;
                }

                public final int getColorX() {
                    return this.colorX;
                }

                public final int getColorY() {
                    return this.colorY;
                }
            }

            public Step(float f, float f2, float f3) {
                this.colorX = f;
                this.colorY = f2;
                this.brightness = f3;
                this.limits = new Limits(f < 1.0f ? 1 : 300, f2 < 1.0f ? 1 : 300, f3 >= 1.0f ? 10 : 1);
            }

            public static /* synthetic */ Step copy$default(Step step, float f, float f2, float f3, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = step.colorX;
                }
                if ((i & 2) != 0) {
                    f2 = step.colorY;
                }
                if ((i & 4) != 0) {
                    f3 = step.brightness;
                }
                return step.copy(f, f2, f3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final float getColorX() {
                return this.colorX;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final float getColorY() {
                return this.colorY;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final float getBrightness() {
                return this.brightness;
            }

            public final Step copy(float colorX, float colorY, float brightness) {
                return new Step(colorX, colorY, brightness);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Step)) {
                    return false;
                }
                Step step = (Step) other;
                return Float.compare(this.colorX, step.colorX) == 0 && Float.compare(this.colorY, step.colorY) == 0 && Float.compare(this.brightness, step.brightness) == 0;
            }

            public final float getBrightness() {
                return this.brightness;
            }

            public final float getColorX() {
                return this.colorX;
            }

            public final float getColorY() {
                return this.colorY;
            }

            public final Limits getLimits() {
                return this.limits;
            }

            public final boolean hasBrightnessChanged(Device.State other) {
                other.getClass();
                if (other.getBrightness() == null) {
                    return false;
                }
                Integer brightness = other.getBrightness();
                return brightness == null || brightness.intValue() != ((int) this.brightness);
            }

            public final boolean hasColorChanged(Device.State other) {
                other.getClass();
                if (other.getColorX() != null) {
                    Integer colorX = other.getColorX();
                    int i = (int) this.colorX;
                    if (colorX == null || colorX.intValue() != i) {
                        return true;
                    }
                }
                if (other.getColorY() == null) {
                    return false;
                }
                Integer colorY = other.getColorY();
                return colorY == null || colorY.intValue() != ((int) this.colorY);
            }

            public int hashCode() {
                return Float.hashCode(this.brightness) + Fragment$$ExternalSyntheticOutline1.m(this.colorY, Float.hashCode(this.colorX) * 31, 31);
            }

            public final boolean isChangeSufficient(Device.State lastState) {
                lastState.getClass();
                if (lastState.getColorX() != null && Math.abs(((int) this.colorX) - lastState.getColorX().intValue()) >= this.limits.getColorX()) {
                    return true;
                }
                if (lastState.getColorY() == null || Math.abs(((int) this.colorY) - lastState.getColorY().intValue()) < this.limits.getColorY()) {
                    return lastState.getBrightness() != null && Math.abs(((int) this.brightness) - lastState.getBrightness().intValue()) >= this.limits.getBrightness();
                }
                return true;
            }

            public final Device.State toDeviceState() {
                return new Device.State(null, null, Integer.valueOf((int) this.colorX), Integer.valueOf((int) this.colorY), Integer.valueOf((int) this.brightness), null, 35, null);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Device.State toDiffDeviceState(Device.State last) {
                Integer numValueOf;
                Integer numValueOf2;
                Integer numValueOf3;
                last.getClass();
                if (last.getColorX() != null) {
                    Integer colorX = last.getColorX();
                    numValueOf = (colorX != null && colorX.intValue() == ((int) this.colorX)) ? null : Integer.valueOf((int) this.colorX);
                }
                if (last.getColorY() != null) {
                    Integer colorY = last.getColorY();
                    numValueOf2 = (colorY != null && colorY.intValue() == ((int) this.colorY)) ? null : Integer.valueOf((int) this.colorY);
                }
                if (last.getBrightness() != null) {
                    Integer brightness = last.getBrightness();
                    numValueOf3 = (brightness == null || brightness.intValue() != ((int) this.brightness)) ? Integer.valueOf((int) this.brightness) : null;
                }
                return new Device.State(null, null, numValueOf, numValueOf2, numValueOf3, null, 35, null);
            }

            public String toString() {
                return "Step(colorX=" + this.colorX + ", colorY=" + this.colorY + ", brightness=" + this.brightness + ')';
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Authenticated(Tradfri.Gateway gateway, Tradfri.Access.Credential credential) {
            super(null);
            gateway.getClass();
            credential.getClass();
            this.gateway = gateway;
            this.credential = credential;
            this.tag = "ikea-tradfri:Authenticated";
            Client$Authenticated$special$$inlined$CoroutineExceptionHandler$1 client$Authenticated$special$$inlined$CoroutineExceptionHandler$1 = new Client$Authenticated$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this);
            this.exceptionHandler = client$Authenticated$special$$inlined$CoroutineExceptionHandler$1;
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from((ExecutorService) getStateExecutor()).plus(client$Authenticated$special$$inlined$CoroutineExceptionHandler$1));
            this.stateScope = CoroutineScope;
            this.deviceTransitionMap = new LinkedHashMap();
            this.endpoint = LazyKt.lazy(new Url$$ExternalSyntheticLambda0(this, 18));
            this.lastStateMap = new LinkedHashMap();
            this.applyStateChannel = ChannelKt.Channel$default(10, null, null, 6, null);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Step applyStep(Step step, Step step2, Device.State state) {
            return new Step(applyStep$normalize(step2.getColorX(), step.getColorX() + step2.getColorX(), state.getColorX()), applyStep$normalize(step2.getColorY(), step.getColorY() + step2.getColorY(), state.getColorY()), applyStep$normalize(step2.getBrightness(), step.getBrightness() + step2.getBrightness(), state.getBrightness()));
        }

        private static final float applyStep$normalize(float f, float f2, Integer num) {
            if (num != null) {
                if (f < 0.0f) {
                    return Math.max(f2, num.intValue());
                }
                if (f > 0.0f) {
                    return Math.min(f2, num.intValue());
                }
            }
            return f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Step calculateStepTo(Device.State state, Device.State state2, int i) {
            float fIntValue;
            float fIntValue2;
            float fIntValue3 = 0.0f;
            if (state2.getColorX() == null) {
                fIntValue = 0.0f;
            } else {
                fIntValue = (state2.getColorX().intValue() - (state.getColorX() != null ? r3.intValue() : 0)) / i;
            }
            if (state2.getColorY() == null) {
                fIntValue2 = 0.0f;
            } else {
                fIntValue2 = (state2.getColorY().intValue() - (state.getColorY() != null ? r4.intValue() : 0)) / i;
            }
            if (state2.getBrightness() != null && !Intrinsics.areEqual(state2.getBrightness(), state.getBrightness())) {
                fIntValue3 = (state2.getBrightness().intValue() - (state.getBrightness() != null ? r7.intValue() : 0)) / i;
            }
            return new Step(fIntValue, fIntValue2, fIntValue3);
        }

        public static /* synthetic */ Authenticated copy$default(Authenticated authenticated, Tradfri.Gateway gateway, Tradfri.Access.Credential credential, int i, Object obj) {
            if ((i & 1) != 0) {
                gateway = authenticated.gateway;
            }
            if ((i & 2) != 0) {
                credential = authenticated.credential;
            }
            return authenticated.copy(gateway, credential);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CoapEndpoint endpoint_delegate$lambda$4(Authenticated authenticated) {
            DtlsConnectorConfig.Builder builder = new DtlsConnectorConfig.Builder();
            String identity = authenticated.credential.getIdentity();
            byte[] bytes = authenticated.credential.getToken().getBytes(Charsets.UTF_8);
            bytes.getClass();
            builder.setPskStore(new StaticPskStore(identity, bytes));
            builder.setRetransmissionTimeout(TradfriKt.getRETRANSMISSION_TIMEOUT_IN_MILLIS());
            CoapEndpoint.Builder builder2 = new CoapEndpoint.Builder();
            builder2.setConnector(new DTLSConnector(builder.build()));
            builder2.setNetworkConfig(NetworkConfig.createStandardWithoutFile());
            CoapEndpoint coapEndpointBuild = builder2.build();
            coapEndpointBuild.setExecutors(authenticated.getExecutor(), authenticated.getExecutor());
            return coapEndpointBuild;
        }

        private final boolean isFilled(Device.State state) {
            return (state.getColorX() == null || state.getColorY() == null || state.getBrightness() == null) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Device.State merge(Device.State state, Device.State state2) {
            Integer colorX = state2.getColorX();
            if (colorX == null) {
                colorX = state.getColorX();
            }
            Integer num = colorX;
            Integer colorY = state2.getColorY();
            if (colorY == null) {
                colorY = state.getColorY();
            }
            Integer num2 = colorY;
            Integer brightness = state2.getBrightness();
            if (brightness == null) {
                brightness = state.getBrightness();
            }
            return Device.State.copy$default(state, null, null, num, num2, brightness, null, 35, null);
        }

        /* JADX INFO: renamed from: setState-bMdYcbs$default, reason: not valid java name */
        public static /* synthetic */ Object m2167setStatebMdYcbs$default(Authenticated authenticated, List list, Color color, Integer num, State.Switch r5, Integer num2, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 2) != 0) {
                color = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            if ((i & 8) != 0) {
                r5 = null;
            }
            if ((i & 16) != 0) {
                num2 = null;
            }
            if ((i & 32) != 0) {
                z = true;
            }
            return authenticated.m2168setStatebMdYcbs(list, color, num, r5, num2, z, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.urbandroid.common.FeatureLogger] */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final Object setState_bMdYcbs$send(Authenticated authenticated, List<LightId> list, Device.State state, Continuation<? super Unit> continuation) {
            Client$Authenticated$setState$send$1 client$Authenticated$setState$send$1;
            if (continuation instanceof Client$Authenticated$setState$send$1) {
                client$Authenticated$setState$send$1 = (Client$Authenticated$setState$send$1) continuation;
                int i = client$Authenticated$setState$send$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    client$Authenticated$setState$send$1.label = i - Integer.MIN_VALUE;
                } else {
                    client$Authenticated$setState$send$1 = new Client$Authenticated$setState$send$1(continuation);
                }
            }
            Object obj = client$Authenticated$setState$send$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = client$Authenticated$setState$send$1.label;
            try {
            } catch (Exception e) {
                Logger.logWarning(Logger.defaultTag, authenticated.getTag() + ": send failure", e);
            }
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (!((Authenticated) authenticated).applyStateChannel.isClosedForSend()) {
                    Channel<Pair<List<LightId>, Device.State>> channel = ((Authenticated) authenticated).applyStateChannel;
                    Pair<List<LightId>, Device.State> pair = TuplesKt.to(list, state);
                    client$Authenticated$setState$send$1.L$0 = authenticated;
                    client$Authenticated$setState$send$1.label = 1;
                    Object objSend = channel.send(pair, client$Authenticated$setState$send$1);
                    authenticated = objSend;
                    if (objSend == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Authenticated authenticated2 = (Authenticated) client$Authenticated$setState$send$1.L$0;
            ResultKt.throwOnFailure(obj);
            authenticated = authenticated2;
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0070 -> B:12:0x0037). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object toDevices(List<Integer> list, Continuation<? super List<Device>> continuation) {
            Client$Authenticated$toDevices$1 client$Authenticated$toDevices$1;
            Collection arrayList;
            Authenticated authenticated;
            Iterator it;
            if (continuation instanceof Client$Authenticated$toDevices$1) {
                client$Authenticated$toDevices$1 = (Client$Authenticated$toDevices$1) continuation;
                int i = client$Authenticated$toDevices$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    client$Authenticated$toDevices$1.label = i - Integer.MIN_VALUE;
                } else {
                    client$Authenticated$toDevices$1 = new Client$Authenticated$toDevices$1(this, continuation);
                }
            }
            Object obj = client$Authenticated$toDevices$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = client$Authenticated$toDevices$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                arrayList = new ArrayList();
                Iterator it2 = list.iterator();
                authenticated = this;
                it = it2;
                if (it.hasNext()) {
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                it = (Iterator) client$Authenticated$toDevices$1.L$2;
                Collection collection = (Collection) client$Authenticated$toDevices$1.L$1;
                Authenticated authenticated2 = (Authenticated) client$Authenticated$toDevices$1.L$0;
                ResultKt.throwOnFailure(obj);
                Client$Authenticated$toDevices$1 client$Authenticated$toDevices$12 = client$Authenticated$toDevices$1;
                Collection collection2 = collection;
                authenticated = authenticated2;
                Client$Authenticated$toDevices$1 client$Authenticated$toDevices$13 = client$Authenticated$toDevices$12;
                Device device = (Device) obj;
                if (device != null) {
                    collection2.add(device);
                }
                arrayList = collection2;
                client$Authenticated$toDevices$1 = client$Authenticated$toDevices$13;
                if (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    client$Authenticated$toDevices$1.L$0 = authenticated;
                    client$Authenticated$toDevices$1.L$1 = arrayList;
                    client$Authenticated$toDevices$1.L$2 = it;
                    client$Authenticated$toDevices$1.label = 1;
                    Object device2 = authenticated.getDevice(iIntValue, client$Authenticated$toDevices$1);
                    if (device2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    client$Authenticated$toDevices$12 = client$Authenticated$toDevices$1;
                    collection2 = arrayList;
                    obj = device2;
                    Client$Authenticated$toDevices$1 client$Authenticated$toDevices$132 = client$Authenticated$toDevices$12;
                    Device device3 = (Device) obj;
                    if (device3 != null) {
                    }
                    arrayList = collection2;
                    client$Authenticated$toDevices$1 = client$Authenticated$toDevices$132;
                    if (it.hasNext()) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj2 : (List) arrayList) {
                            if (!StringsKt.contains$default(((Device) obj2).getType().getName(), "remote control")) {
                                arrayList2.add(obj2);
                            }
                        }
                        return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated$toDevices$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(((Device) t).getName(), ((Device) t2).getName());
                            }
                        });
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Step toStep(Device.State state) {
            Integer colorX = state.getColorX();
            float fIntValue = colorX != null ? colorX.intValue() : 0;
            Integer colorY = state.getColorY();
            return new Step(fIntValue, colorY != null ? colorY.intValue() : 0, state.getBrightness() != null ? r4.intValue() : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String toUpdateJson(Device.State state) {
            return Client.INSTANCE.getGson().toJson(new DeviceUpdater(CollectionsKt.listOf(state)));
        }

        public final void close() {
            Logger.logInfo(Logger.defaultTag, getTag() + ": close", null);
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new Client$Authenticated$close$1(this, null), 3, null);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Tradfri.Gateway getGateway() {
            return this.gateway;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Tradfri.Access.Credential getCredential() {
            return this.credential;
        }

        public final Authenticated copy(Tradfri.Gateway gateway, Tradfri.Access.Credential credential) {
            gateway.getClass();
            credential.getClass();
            return new Authenticated(gateway, credential);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Authenticated)) {
                return false;
            }
            Authenticated authenticated = (Authenticated) other;
            return Intrinsics.areEqual(this.gateway, authenticated.gateway) && Intrinsics.areEqual(this.credential, authenticated.credential);
        }

        public final Tradfri.Access.Credential getCredential() {
            return this.credential;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getDevice(int i, Continuation<? super Device> continuation) {
            Client$Authenticated$getDevice$1 client$Authenticated$getDevice$1;
            if (continuation instanceof Client$Authenticated$getDevice$1) {
                client$Authenticated$getDevice$1 = (Client$Authenticated$getDevice$1) continuation;
                int i2 = client$Authenticated$getDevice$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    client$Authenticated$getDevice$1.label = i2 - Integer.MIN_VALUE;
                } else {
                    client$Authenticated$getDevice$1 = new Client$Authenticated$getDevice$1(this, continuation);
                }
            }
            Object obj = client$Authenticated$getDevice$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = client$Authenticated$getDevice$1.label;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Method method = Method.GET;
                String strM = FileInsert$$ExternalSyntheticOutline0.m(i, "/15001/");
                String strM2 = FileInsert$$ExternalSyntheticOutline0.m(i, "getDevice ");
                long secondsInMillis = Utils.getSecondsInMillis(5);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                Client$Authenticated$getDevice$$inlined$send$default$1 client$Authenticated$getDevice$$inlined$send$default$1 = new Client$Authenticated$getDevice$$inlined$send$default$1(this, method, strM, null, strM2, secondsInMillis, null);
                client$Authenticated$getDevice$1.label = 1;
                Object objWithContext = BuildersKt.withContext(io2, client$Authenticated$getDevice$$inlined$send$default$1, client$Authenticated$getDevice$1);
                return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
            } catch (Exception e) {
                Logger.logSevere("general send failure", e);
                return null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getDeviceIds(Continuation<? super List<Integer>> continuation) {
            Client$Authenticated$getDeviceIds$1 client$Authenticated$getDeviceIds$1;
            if (continuation instanceof Client$Authenticated$getDeviceIds$1) {
                client$Authenticated$getDeviceIds$1 = (Client$Authenticated$getDeviceIds$1) continuation;
                int i = client$Authenticated$getDeviceIds$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    client$Authenticated$getDeviceIds$1.label = i - Integer.MIN_VALUE;
                } else {
                    client$Authenticated$getDeviceIds$1 = new Client$Authenticated$getDeviceIds$1(this, continuation);
                }
            }
            Object obj = client$Authenticated$getDeviceIds$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = client$Authenticated$getDeviceIds$1.label;
            try {
                if (i2 != 0) {
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Method method = Method.GET_SYNC;
                long secondsInMillis = Utils.getSecondsInMillis(5);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                Client$Authenticated$getDeviceIds$$inlined$send$default$1 client$Authenticated$getDeviceIds$$inlined$send$default$1 = new Client$Authenticated$getDeviceIds$$inlined$send$default$1(this, method, TradfriKt.NODE_DEVICE, null, "getDeviceIds", secondsInMillis, null);
                client$Authenticated$getDeviceIds$1.label = 1;
                Object objWithContext = BuildersKt.withContext(io2, client$Authenticated$getDeviceIds$$inlined$send$default$1, client$Authenticated$getDeviceIds$1);
                return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
            } catch (Exception e) {
                Logger.logSevere("general send failure", e);
                return null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        
            if (r7 == r1) goto L23;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getDevices(Continuation<? super List<Device>> continuation) {
            Client$Authenticated$getDevices$1 client$Authenticated$getDevices$1;
            if (continuation instanceof Client$Authenticated$getDevices$1) {
                client$Authenticated$getDevices$1 = (Client$Authenticated$getDevices$1) continuation;
                int i = client$Authenticated$getDevices$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    client$Authenticated$getDevices$1.label = i - Integer.MIN_VALUE;
                } else {
                    client$Authenticated$getDevices$1 = new Client$Authenticated$getDevices$1(this, continuation);
                }
            }
            Object deviceIds = client$Authenticated$getDevices$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = client$Authenticated$getDevices$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(deviceIds);
                client$Authenticated$getDevices$1.L$0 = this;
                client$Authenticated$getDevices$1.label = 1;
                deviceIds = getDeviceIds(client$Authenticated$getDevices$1);
                if (deviceIds != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    ResultKt.throwOnFailure(deviceIds);
                    return (List) deviceIds;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            this = (Authenticated) client$Authenticated$getDevices$1.L$0;
            ResultKt.throwOnFailure(deviceIds);
            List<Integer> list = (List) deviceIds;
            if (list == null) {
                return null;
            }
            client$Authenticated$getDevices$1.L$0 = null;
            client$Authenticated$getDevices$1.label = 2;
            deviceIds = this.toDevices(list, client$Authenticated$getDevices$1);
        }

        @Override // com.urbandroid.smartlight.ikea.tradfri.Client
        public CoapEndpoint getEndpoint() {
            Object value = this.endpoint.getValue();
            value.getClass();
            return (CoapEndpoint) value;
        }

        @Override // com.urbandroid.smartlight.ikea.tradfri.Client
        public Tradfri.Gateway getGateway() {
            return this.gateway;
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return this.tag;
        }

        public int hashCode() {
            return this.credential.hashCode() + (this.gateway.hashCode() * 31);
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object setBlinder(int i, float f, Continuation<? super Unit> continuation) {
            Client$Authenticated$setBlinder$1 client$Authenticated$setBlinder$1;
            if (continuation instanceof Client$Authenticated$setBlinder$1) {
                client$Authenticated$setBlinder$1 = (Client$Authenticated$setBlinder$1) continuation;
                int i2 = client$Authenticated$setBlinder$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    client$Authenticated$setBlinder$1.label = i2 - Integer.MIN_VALUE;
                } else {
                    client$Authenticated$setBlinder$1 = new Client$Authenticated$setBlinder$1(this, continuation);
                }
            }
            Client$Authenticated$setBlinder$1 client$Authenticated$setBlinder$12 = client$Authenticated$setBlinder$1;
            Object obj = client$Authenticated$setBlinder$12.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = client$Authenticated$setBlinder$12.label;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Method method = Method.PUT;
                    String strM = FileInsert$$ExternalSyntheticOutline0.m(i, "/15001/");
                    String updateJson = toUpdateJson(new Device.BlinderState(Boxing.boxFloat(f)));
                    long secondsInMillis = Utils.getSecondsInMillis(5);
                    CoroutineDispatcher io2 = Dispatchers.getIO();
                    Client$Authenticated$setBlinder$$inlined$send$default$1 client$Authenticated$setBlinder$$inlined$send$default$1 = new Client$Authenticated$setBlinder$$inlined$send$default$1(this, method, strM, updateJson, null, secondsInMillis, null);
                    client$Authenticated$setBlinder$12.label = 1;
                    if (BuildersKt.withContext(io2, client$Authenticated$setBlinder$$inlined$send$default$1, client$Authenticated$setBlinder$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                Logger.logSevere("general send failure", e);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:125:0x039b, code lost:
        
            if (setState_bMdYcbs$send(r0, r1, r2, r14) == r15) goto L133;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x03b7, code lost:
        
            if (setState_bMdYcbs$send(r0, r1, r4, r14) == r15) goto L133;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0223, code lost:
        
            if (setState_bMdYcbs$send(r0, r1, r2, r14) == r15) goto L133;
         */
        /* JADX WARN: Path cross not found for [B:106:0x02d3, B:114:0x02ee], limit reached: 137 */
        /* JADX WARN: Path cross not found for [B:33:0x00b2, B:36:0x00c3], limit reached: 137 */
        /* JADX WARN: Path cross not found for [B:38:0x00c6, B:41:0x00d7], limit reached: 137 */
        /* JADX WARN: Path cross not found for [B:41:0x00d7, B:38:0x00c6], limit reached: 137 */
        /* JADX WARN: Path cross not found for [B:67:0x01c9, B:68:0x01cc], limit reached: 137 */
        /* JADX WARN: Path cross not found for [B:81:0x0232, B:89:0x0248], limit reached: 137 */
        /* JADX WARN: Path cross not found for [B:89:0x0248, B:81:0x0232], limit reached: 137 */
        /* JADX WARN: Removed duplicated region for block: B:117:0x02f6  */
        /* JADX WARN: Removed duplicated region for block: B:129:0x03a7  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0159  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x01b9 A[LOOP:2: B:62:0x01b3->B:64:0x01b9, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x01cc  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01d6  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0232  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x027f A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0292  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x02c8 -> B:104:0x02cf). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x02f3 -> B:116:0x02f4). Please report as a decompilation issue!!! */
        /* JADX INFO: renamed from: setState-bMdYcbs, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object m2168setStatebMdYcbs(List<LightId> list, Color color, Integer num, State.Switch r33, Integer num2, boolean z, Continuation<? super Result<Unit>> continuation) {
            Client$Authenticated$setState$1 client$Authenticated$setState$1;
            Color.D65 d65AsD65;
            String str;
            Device.State state;
            Integer num3;
            Iterator it;
            Integer on;
            boolean z2;
            Iterator<LightId> it2;
            Device.State state2;
            Light.Type type;
            Device.State state3;
            List<Device.State> states;
            Authenticated authenticated = this;
            List<LightId> list2 = list;
            if (continuation instanceof Client$Authenticated$setState$1) {
                client$Authenticated$setState$1 = (Client$Authenticated$setState$1) continuation;
                int i = client$Authenticated$setState$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    client$Authenticated$setState$1.label = i - Integer.MIN_VALUE;
                } else {
                    client$Authenticated$setState$1 = new Client$Authenticated$setState$1(authenticated, continuation);
                }
            }
            Client$Authenticated$setState$1 client$Authenticated$setState$12 = client$Authenticated$setState$1;
            Object obj = client$Authenticated$setState$12.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = client$Authenticated$setState$12.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (color == null || (d65AsD65 = color.asD65()) == null) {
                    d65AsD65 = null;
                } else if (Intrinsics.areEqual(StateKt.toBooleanOrNull(r33), Boxing.boxBoolean(true))) {
                    d65AsD65 = d65AsD65.toD65WithMinZ();
                }
                Integer intOrNull = StateKt.toIntOrNull(r33);
                if (d65AsD65 != null) {
                    Integer numBoxInt = Boxing.boxInt(d65AsD65.getX());
                    Integer num4 = numBoxInt.intValue() != -1 ? numBoxInt : null;
                    if (d65AsD65 != null) {
                        Integer numBoxInt2 = Boxing.boxInt(d65AsD65.getY());
                        Integer num5 = numBoxInt2.intValue() != -1 ? numBoxInt2 : null;
                        str = ": ";
                        num3 = num2;
                        state = new Device.State(intOrNull, null, num4, num5, num == null ? d65AsD65 != null ? d65AsD65.getZ() : null : num, num3, 2, null);
                        StringBuilder sb = new StringBuilder("setState ");
                        sb.append(num3);
                        sb.append(' ');
                        sb.append(state.getBrightness());
                        sb.append(' ');
                        sb.append(color);
                        sb.append(' ');
                        sb.append(r33 != null ? r33.name() : null);
                        Logger.logInfo(Logger.defaultTag, authenticated.getTag() + str + ((Object) sb.toString()), null);
                        Map<Integer, DeviceTransition> map = authenticated.deviceTransitionMap;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Map.Entry<Integer, DeviceTransition> entry : map.entrySet()) {
                            int iIntValue = entry.getKey().intValue();
                            List<LightId> list3 = list2;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                            Iterator<T> it3 = list3.iterator();
                            while (it3.hasNext()) {
                                arrayList.add(Boxing.boxInt(((LightId) it3.next()).getId()));
                            }
                            if (arrayList.contains(Boxing.boxInt(iIntValue))) {
                                linkedHashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                        it = linkedHashMap.values().iterator();
                        while (it.hasNext()) {
                            ((DeviceTransition) it.next()).stop();
                        }
                        on = state.getOn();
                        if (on != null && on.intValue() == 0) {
                            if (r33 == State.Switch.ON_OFF) {
                                Device.State stateCopy$default = Device.State.copy$default(state, Boxing.boxInt(1), null, null, null, Boxing.boxInt(0), Boxing.boxInt(0), 14, null);
                                client$Authenticated$setState$12.L$0 = authenticated;
                                client$Authenticated$setState$12.L$1 = list2;
                                client$Authenticated$setState$12.L$2 = state;
                                client$Authenticated$setState$12.label = 1;
                                if (setState_bMdYcbs$send(authenticated, list2, stateCopy$default, client$Authenticated$setState$12) != coroutine_suspended) {
                                }
                            }
                            Device.State stateCopy$default2 = Device.State.copy$default(state, null, null, null, null, null, Boxing.boxInt(0), 31, null);
                            client$Authenticated$setState$12.L$0 = null;
                            client$Authenticated$setState$12.L$1 = null;
                            client$Authenticated$setState$12.L$2 = null;
                            client$Authenticated$setState$12.label = 2;
                        } else {
                            z2 = (z && (state.getColorX() == null || state.getColorY() == null || state.getBrightness() == null)) ? false : true;
                            Logger.logInfo(Logger.defaultTag, authenticated.getTag() + str + ((Object) ("forceEmulated: " + z2 + " emulated: " + z)), null);
                            if (z2 || num3 == null || num3.intValue() == 0) {
                                client$Authenticated$setState$12.label = 5;
                            } else {
                                it2 = list2.iterator();
                                state2 = state;
                                if (it2.hasNext()) {
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                    str = ": ";
                    num3 = num2;
                    state = new Device.State(intOrNull, null, num4, num5, num == null ? d65AsD65 != null ? d65AsD65.getZ() : null : num, num3, 2, null);
                    StringBuilder sb2 = new StringBuilder("setState ");
                    sb2.append(num3);
                    sb2.append(' ');
                    sb2.append(state.getBrightness());
                    sb2.append(' ');
                    sb2.append(color);
                    sb2.append(' ');
                    sb2.append(r33 != null ? r33.name() : null);
                    Logger.logInfo(Logger.defaultTag, authenticated.getTag() + str + ((Object) sb2.toString()), null);
                    Map<Integer, DeviceTransition> map2 = authenticated.deviceTransitionMap;
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    while (r2.hasNext()) {
                    }
                    it = linkedHashMap2.values().iterator();
                    while (it.hasNext()) {
                    }
                    on = state.getOn();
                    if (on != null) {
                        if (r33 == State.Switch.ON_OFF) {
                        }
                        Device.State stateCopy$default22 = Device.State.copy$default(state, null, null, null, null, null, Boxing.boxInt(0), 31, null);
                        client$Authenticated$setState$12.L$0 = null;
                        client$Authenticated$setState$12.L$1 = null;
                        client$Authenticated$setState$12.L$2 = null;
                        client$Authenticated$setState$12.label = 2;
                    }
                    if (z) {
                    }
                    Logger.logInfo(Logger.defaultTag, authenticated.getTag() + str + ((Object) ("forceEmulated: " + z2 + " emulated: " + z)), null);
                    if (z2) {
                    }
                    client$Authenticated$setState$12.label = 5;
                }
                if (d65AsD65 != null) {
                }
                str = ": ";
                num3 = num2;
                state = new Device.State(intOrNull, null, num4, num5, num == null ? d65AsD65 != null ? d65AsD65.getZ() : null : num, num3, 2, null);
                StringBuilder sb22 = new StringBuilder("setState ");
                sb22.append(num3);
                sb22.append(' ');
                sb22.append(state.getBrightness());
                sb22.append(' ');
                sb22.append(color);
                sb22.append(' ');
                sb22.append(r33 != null ? r33.name() : null);
                Logger.logInfo(Logger.defaultTag, authenticated.getTag() + str + ((Object) sb22.toString()), null);
                Map<Integer, DeviceTransition> map22 = authenticated.deviceTransitionMap;
                LinkedHashMap linkedHashMap22 = new LinkedHashMap();
                while (r2.hasNext()) {
                }
                it = linkedHashMap22.values().iterator();
                while (it.hasNext()) {
                }
                on = state.getOn();
                if (on != null) {
                }
                if (z) {
                }
                Logger.logInfo(Logger.defaultTag, authenticated.getTag() + str + ((Object) ("forceEmulated: " + z2 + " emulated: " + z)), null);
                if (z2) {
                }
                client$Authenticated$setState$12.label = 5;
            } else if (i2 == 1) {
                Device.State state4 = (Device.State) client$Authenticated$setState$12.L$2;
                list2 = (List) client$Authenticated$setState$12.L$1;
                Authenticated authenticated2 = (Authenticated) client$Authenticated$setState$12.L$0;
                ResultKt.throwOnFailure(obj);
                state = state4;
                authenticated = authenticated2;
                Device.State stateCopy$default222 = Device.State.copy$default(state, null, null, null, null, null, Boxing.boxInt(0), 31, null);
                client$Authenticated$setState$12.L$0 = null;
                client$Authenticated$setState$12.L$1 = null;
                client$Authenticated$setState$12.L$2 = null;
                client$Authenticated$setState$12.label = 2;
            } else {
                if (i2 == 2) {
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m2357constructorimpl(Unit.INSTANCE);
                }
                if (i2 != 3) {
                    if (i2 == 4) {
                        ResultKt.throwOnFailure(obj);
                        Result.Companion companion2 = Result.INSTANCE;
                        return Result.m2357constructorimpl(Unit.INSTANCE);
                    }
                    if (i2 != 5) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m2357constructorimpl(Unit.INSTANCE);
                }
                int i3 = client$Authenticated$setState$12.I$0;
                Light.Type type2 = (Light.Type) client$Authenticated$setState$12.L$5;
                it2 = (Iterator) client$Authenticated$setState$12.L$4;
                state2 = (Device.State) client$Authenticated$setState$12.L$3;
                Integer num6 = (Integer) client$Authenticated$setState$12.L$2;
                List<LightId> list4 = (List) client$Authenticated$setState$12.L$1;
                Authenticated authenticated3 = (Authenticated) client$Authenticated$setState$12.L$0;
                ResultKt.throwOnFailure(obj);
                List<LightId> list5 = list4;
                str = ": ";
                Device device = (Device) obj;
                if (device != null || (states = device.getStates()) == null || (state3 = (Device.State) CollectionsKt.firstOrNull((List) states)) == null || !authenticated3.isFilled(state3)) {
                    type = type2;
                    num3 = num6;
                    list2 = list5;
                    state3 = null;
                } else {
                    type = type2;
                    num3 = num6;
                    list2 = list5;
                }
                int id = i3;
                authenticated = authenticated3;
                if (state3 == null && authenticated.isFilled(state3)) {
                    Logger.logInfo(Logger.defaultTag, authenticated.getTag() + str + ((Object) ("emulated - last state: " + state3)), null);
                    Map<Integer, DeviceTransition> map3 = authenticated.deviceTransitionMap;
                    Integer numBoxInt3 = Boxing.boxInt(id);
                    DeviceTransition deviceTransition = map3.get(numBoxInt3);
                    if (deviceTransition == null) {
                        deviceTransition = new DeviceTransition(authenticated, id, type);
                        map3.put(numBoxInt3, deviceTransition);
                    }
                    deviceTransition.start(state3, state2, num3.intValue());
                    if (it2.hasNext()) {
                        Result.Companion companion4 = Result.INSTANCE;
                        return Result.m2357constructorimpl(Unit.INSTANCE);
                    }
                    LightId next = it2.next();
                    id = next.getId();
                    type = next.getType();
                    state3 = authenticated.lastStateMap.get(Boxing.boxInt(id));
                    if (state3 == null) {
                        client$Authenticated$setState$12.L$0 = authenticated;
                        client$Authenticated$setState$12.L$1 = list2;
                        client$Authenticated$setState$12.L$2 = num3;
                        client$Authenticated$setState$12.L$3 = state2;
                        client$Authenticated$setState$12.L$4 = it2;
                        client$Authenticated$setState$12.L$5 = type;
                        client$Authenticated$setState$12.I$0 = id;
                        client$Authenticated$setState$12.label = 3;
                        Object device2 = authenticated.getDevice(id, client$Authenticated$setState$12);
                        if (device2 != coroutine_suspended) {
                            list5 = list2;
                            type2 = type;
                            obj = device2;
                            authenticated3 = authenticated;
                            i3 = id;
                            num6 = num3;
                            Device device3 = (Device) obj;
                            if (device3 != null) {
                            }
                            type = type2;
                            num3 = num6;
                            list2 = list5;
                            state3 = null;
                            int id2 = i3;
                            authenticated = authenticated3;
                            if (state3 == null) {
                            }
                            Logger.logInfo(Logger.defaultTag, authenticated.getTag() + str + ((Object) ("emulated - last state not found or filled yet: " + authenticated)), null);
                            Device.State stateCopy$default3 = Device.State.copy$default(state2, null, null, null, null, null, Boxing.boxInt(0), 31, null);
                            client$Authenticated$setState$12.L$0 = null;
                            client$Authenticated$setState$12.L$1 = null;
                            client$Authenticated$setState$12.L$2 = null;
                            client$Authenticated$setState$12.L$3 = null;
                            client$Authenticated$setState$12.L$4 = null;
                            client$Authenticated$setState$12.L$5 = null;
                            client$Authenticated$setState$12.label = 4;
                        }
                        return coroutine_suspended;
                    }
                    if (state3 == null) {
                    }
                    Logger.logInfo(Logger.defaultTag, authenticated.getTag() + str + ((Object) ("emulated - last state not found or filled yet: " + authenticated)), null);
                    Device.State stateCopy$default32 = Device.State.copy$default(state2, null, null, null, null, null, Boxing.boxInt(0), 31, null);
                    client$Authenticated$setState$12.L$0 = null;
                    client$Authenticated$setState$12.L$1 = null;
                    client$Authenticated$setState$12.L$2 = null;
                    client$Authenticated$setState$12.L$3 = null;
                    client$Authenticated$setState$12.L$4 = null;
                    client$Authenticated$setState$12.L$5 = null;
                    client$Authenticated$setState$12.label = 4;
                } else {
                    Logger.logInfo(Logger.defaultTag, authenticated.getTag() + str + ((Object) ("emulated - last state not found or filled yet: " + authenticated)), null);
                    Device.State stateCopy$default322 = Device.State.copy$default(state2, null, null, null, null, null, Boxing.boxInt(0), 31, null);
                    client$Authenticated$setState$12.L$0 = null;
                    client$Authenticated$setState$12.L$1 = null;
                    client$Authenticated$setState$12.L$2 = null;
                    client$Authenticated$setState$12.L$3 = null;
                    client$Authenticated$setState$12.L$4 = null;
                    client$Authenticated$setState$12.L$5 = null;
                    client$Authenticated$setState$12.label = 4;
                }
            }
        }

        public String toString() {
            return "Authenticated(gateway=" + this.gateway + ", credential=" + this.credential + ')';
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object turnDeviceOff(int i, Continuation<? super Unit> continuation) {
            Client$Authenticated$turnDeviceOff$1 client$Authenticated$turnDeviceOff$1;
            if (continuation instanceof Client$Authenticated$turnDeviceOff$1) {
                client$Authenticated$turnDeviceOff$1 = (Client$Authenticated$turnDeviceOff$1) continuation;
                int i2 = client$Authenticated$turnDeviceOff$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    client$Authenticated$turnDeviceOff$1.label = i2 - Integer.MIN_VALUE;
                } else {
                    client$Authenticated$turnDeviceOff$1 = new Client$Authenticated$turnDeviceOff$1(this, continuation);
                }
            }
            Client$Authenticated$turnDeviceOff$1 client$Authenticated$turnDeviceOff$12 = client$Authenticated$turnDeviceOff$1;
            Object obj = client$Authenticated$turnDeviceOff$12.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = client$Authenticated$turnDeviceOff$12.label;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Method method = Method.PUT;
                    String strM = FileInsert$$ExternalSyntheticOutline0.m(i, "/15001/");
                    String updateJson = toUpdateJson(new Device.State(Boxing.boxInt(0), null, null, null, null, null, 62, null));
                    String strM2 = FileInsert$$ExternalSyntheticOutline0.m(i, "turnDeviceOff ");
                    long secondsInMillis = Utils.getSecondsInMillis(5);
                    CoroutineDispatcher io2 = Dispatchers.getIO();
                    Client$Authenticated$turnDeviceOff$$inlined$send$default$1 client$Authenticated$turnDeviceOff$$inlined$send$default$1 = new Client$Authenticated$turnDeviceOff$$inlined$send$default$1(this, method, strM, updateJson, strM2, secondsInMillis, null);
                    client$Authenticated$turnDeviceOff$12.label = 1;
                    if (BuildersKt.withContext(io2, client$Authenticated$turnDeviceOff$$inlined$send$default$1, client$Authenticated$turnDeviceOff$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                Logger.logSevere("general send failure", e);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object turnDeviceOn(int i, Continuation<? super Unit> continuation) {
            Client$Authenticated$turnDeviceOn$1 client$Authenticated$turnDeviceOn$1;
            if (continuation instanceof Client$Authenticated$turnDeviceOn$1) {
                client$Authenticated$turnDeviceOn$1 = (Client$Authenticated$turnDeviceOn$1) continuation;
                int i2 = client$Authenticated$turnDeviceOn$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    client$Authenticated$turnDeviceOn$1.label = i2 - Integer.MIN_VALUE;
                } else {
                    client$Authenticated$turnDeviceOn$1 = new Client$Authenticated$turnDeviceOn$1(this, continuation);
                }
            }
            Client$Authenticated$turnDeviceOn$1 client$Authenticated$turnDeviceOn$12 = client$Authenticated$turnDeviceOn$1;
            Object obj = client$Authenticated$turnDeviceOn$12.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = client$Authenticated$turnDeviceOn$12.label;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Method method = Method.PUT;
                    String strM = FileInsert$$ExternalSyntheticOutline0.m(i, "/15001/");
                    String updateJson = toUpdateJson(new Device.State(Boxing.boxInt(1), null, null, null, null, null, 62, null));
                    String strM2 = FileInsert$$ExternalSyntheticOutline0.m(i, "turnDeviceOn ");
                    long secondsInMillis = Utils.getSecondsInMillis(5);
                    CoroutineDispatcher io2 = Dispatchers.getIO();
                    Client$Authenticated$turnDeviceOn$$inlined$send$default$1 client$Authenticated$turnDeviceOn$$inlined$send$default$1 = new Client$Authenticated$turnDeviceOn$$inlined$send$default$1(this, method, strM, updateJson, strM2, secondsInMillis, null);
                    client$Authenticated$turnDeviceOn$12.label = 1;
                    if (BuildersKt.withContext(io2, client$Authenticated$turnDeviceOn$$inlined$send$default$1, client$Authenticated$turnDeviceOn$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                Logger.logSevere("general send failure", e);
            }
            return Unit.INSTANCE;
        }

        private final String toUpdateJson(Device.BlinderState blinderState) {
            return Client.INSTANCE.getGson().toJson(new BlinderUpdater(CollectionsKt.listOf(blinderState)));
        }

        public final Object getDevices(List<Integer> list, Continuation<? super List<Device>> continuation) {
            return toDevices(list, continuation);
        }
    }

    public /* synthetic */ Client(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
