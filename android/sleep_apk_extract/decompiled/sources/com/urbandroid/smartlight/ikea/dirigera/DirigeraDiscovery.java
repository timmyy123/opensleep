package com.urbandroid.smartlight.ikea.dirigera;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.util.Log;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.discovery.Discovery;
import com.urbandroid.smartlight.common.discovery.DiscoveryCallback;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Gateway;
import com.urbandroid.smartlight.ikea.tradfri.TradfriKt;
import io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoveryService;
import j$.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002#&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J\u001e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0016J\b\u0010(\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\fH\u0002J\u000e\u0010+\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020,J\u0006\u0010-\u001a\u00020\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006."}, d2 = {"Lcom/urbandroid/smartlight/ikea/dirigera/DirigeraDiscovery;", "Lcom/urbandroid/smartlight/common/discovery/Discovery;", "Lcom/urbandroid/smartlight/common/model/Gateway$Dirigera;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "tag", "", "kotlin.jvm.PlatformType", "getTag", "()Ljava/lang/String;", "Ljava/lang/String;", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "discover", "", "listener", "Lcom/urbandroid/smartlight/common/discovery/Discovery$Listener;", "authenticate", "gateway", "Lcom/urbandroid/smartlight/common/discovery/Discovery$AuthListener;", "nsdManager", "Landroid/net/nsd/NsdManager;", "SERVICE_TYPE", "DIRIGERA_SERVICE_TYPE", "discoveryListener", "com/urbandroid/smartlight/ikea/dirigera/DirigeraDiscovery$discoveryListener$1", "Lcom/urbandroid/smartlight/ikea/dirigera/DirigeraDiscovery$discoveryListener$1;", "resolveListener", "com/urbandroid/smartlight/ikea/dirigera/DirigeraDiscovery$resolveListener$1", "Lcom/urbandroid/smartlight/ikea/dirigera/DirigeraDiscovery$resolveListener$1;", "generateCodeVerifier", "generateCodeChallenge", "codeVerifier", "startDiscovery", "Lcom/urbandroid/smartlight/common/discovery/DiscoveryCallback;", "stopDiscovery", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DirigeraDiscovery implements Discovery<Gateway.Dirigera>, FeatureLogger, CoroutineScope {
    private final String DIRIGERA_SERVICE_TYPE;
    private final String SERVICE_TYPE;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final DirigeraDiscovery$discoveryListener$1 discoveryListener;
    private final CompletableJob job;
    private final NsdManager nsdManager;
    private final DirigeraDiscovery$resolveListener$1 resolveListener;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$discover$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$discover$1", f = "DirigeraDiscovery.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Discovery.Listener<Gateway.Dirigera> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Discovery.Listener<Gateway.Dirigera> listener, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$listener = listener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DirigeraDiscovery.this.new AnonymousClass1(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            Log.i(Common_smartlightKt.TAG, "Dirigera discover");
            DirigeraDiscovery dirigeraDiscovery = DirigeraDiscovery.this;
            final Discovery.Listener<Gateway.Dirigera> listener = this.$listener;
            dirigeraDiscovery.startDiscovery(new DiscoveryCallback() { // from class: com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery.discover.1.1
                @Override // com.urbandroid.smartlight.common.discovery.DiscoveryCallback
                public void failed(String msg) {
                    msg.getClass();
                    Log.i(Common_smartlightKt.TAG, "Dirigera found failed " + msg);
                    listener.failed(msg);
                }

                @Override // com.urbandroid.smartlight.common.discovery.DiscoveryCallback
                public void finished() {
                    listener.onStop();
                }

                @Override // com.urbandroid.smartlight.common.discovery.DiscoveryCallback
                public Object found(Gateway gateway, Continuation<? super Unit> continuation) {
                    Log.i(Common_smartlightKt.TAG, "Dirigera found " + gateway);
                    Discovery.Listener<Gateway.Dirigera> listener2 = listener;
                    gateway.getClass();
                    listener2.found((Gateway.Dirigera) gateway);
                    return Unit.INSTANCE;
                }

                @Override // com.urbandroid.smartlight.common.discovery.DiscoveryCallback
                public void started() {
                    listener.onStart();
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$discoveryListener$1] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$resolveListener$1] */
    public DirigeraDiscovery(Context context) {
        context.getClass();
        this.context = context;
        this.tag = HueBridgeDiscoveryService.TAG;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default).plus(new DirigeraDiscovery$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
        Object systemService = context.getSystemService("servicediscovery");
        systemService.getClass();
        this.nsdManager = (NsdManager) systemService;
        this.SERVICE_TYPE = "_ihsp._tcp";
        this.DIRIGERA_SERVICE_TYPE = "DIRIGERA";
        this.discoveryListener = new NsdManager.DiscoveryListener() { // from class: com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$discoveryListener$1
            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onDiscoveryStarted(String regType) {
                regType.getClass();
                Log.d("Dirigera", "Discovery started");
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onDiscoveryStopped(String regType) {
                regType.getClass();
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onServiceFound(NsdServiceInfo service) {
                service.getClass();
                Log.d("Dirigera", "Service found: " + service.getServiceName() + ' ' + service.getServiceType() + ' ' + service.getHostname() + ' ' + service.getPort() + ' ' + service.getHost().getHostAddress());
                if (Intrinsics.areEqual(this.this$0.DIRIGERA_SERVICE_TYPE, service.getServiceType())) {
                    Log.d("Dirigera", "DIRIGERA found");
                    this.this$0.nsdManager.resolveService(service, this.this$0.resolveListener);
                }
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onServiceLost(NsdServiceInfo service) {
                service.getClass();
                Log.d("Dirigera", "Service lost");
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onStartDiscoveryFailed(String serviceType, int errorCode) {
                serviceType.getClass();
                this.this$0.nsdManager.stopServiceDiscovery(this);
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onStopDiscoveryFailed(String serviceType, int errorCode) {
                serviceType.getClass();
                this.this$0.nsdManager.stopServiceDiscovery(this);
            }
        };
        this.resolveListener = new NsdManager.ResolveListener() { // from class: com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$resolveListener$1
            @Override // android.net.nsd.NsdManager.ResolveListener
            public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
                serviceInfo.getClass();
                Log.e("Dirigera", "Resolve failed: " + errorCode);
            }

            @Override // android.net.nsd.NsdManager.ResolveListener
            public void onServiceResolved(NsdServiceInfo serviceInfo) throws NoSuchAlgorithmException {
                serviceInfo.getClass();
                String hostname = serviceInfo.getHostname();
                Log.d("Dirigera", "Service resolved: " + serviceInfo.getServiceName() + ' ' + serviceInfo.getServiceType() + ' ' + serviceInfo.getHostname() + ' ' + serviceInfo.getPort() + ' ' + serviceInfo.getHost().getHostAddress());
                if (hostname != null) {
                    DirigeraSharedPreferences.getInstance(this.this$0.getContext()).setIp(hostname);
                    this.this$0.stopDiscovery();
                    DirigeraDiscovery dirigeraDiscovery = this.this$0;
                    String strGenerateCodeChallenge = dirigeraDiscovery.generateCodeChallenge(dirigeraDiscovery.generateCodeVerifier());
                    DirigeraDiscovery dirigeraDiscovery2 = this.this$0;
                    String hostname2 = serviceInfo.getHostname();
                    if (hostname2 == null) {
                        hostname2 = serviceInfo.getServiceName();
                    }
                    hostname2.getClass();
                    dirigeraDiscovery2.authenticate(new Gateway.Dirigera(hostname2, hostname, TradfriKt.DIRIGERA_PORT, strGenerateCodeChallenge), new Discovery.AuthListener<Gateway.Dirigera>() { // from class: com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$resolveListener$1$onServiceResolved$1
                        @Override // com.urbandroid.smartlight.common.discovery.Discovery.AuthListener
                        public void authRequired(Gateway.Dirigera gateway) {
                            gateway.getClass();
                            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                        }

                        @Override // com.urbandroid.smartlight.common.discovery.Discovery.AuthListener
                        public void failed(Gateway.Dirigera gateway) {
                            gateway.getClass();
                            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                        }

                        @Override // com.urbandroid.smartlight.common.discovery.Discovery.AuthListener
                        public void success(AuthenticatedGateway gateway) {
                            gateway.getClass();
                            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
                        }
                    });
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateCodeChallenge(String codeVerifier) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("sha256");
        Charset charset = StandardCharsets.US_ASCII;
        charset.getClass();
        byte[] bytes = codeVerifier.getBytes(charset);
        bytes.getClass();
        return Fragment$$ExternalSyntheticOutline1.m(1, 0, Base64.getUrlEncoder().encodeToString(messageDigest.digest(bytes)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateCodeVerifier() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-._~".charAt(threadLocalRandomCurrent.nextInt(0, 66)));
        }
        return sb.toString();
    }

    public void authenticate(Gateway.Dirigera gateway, Discovery.AuthListener<Gateway.Dirigera> listener) {
        gateway.getClass();
        listener.getClass();
        listener.authRequired(gateway);
        if (gateway.getCodeVerifier() == null) {
            gateway.setCodeVerifier(generateCodeChallenge(generateCodeVerifier()));
        }
        String codeVerifier = gateway.getCodeVerifier();
        if (codeVerifier != null) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new DirigeraDiscovery$authenticate$1$1(this, gateway, codeVerifier, listener, null), 3, null);
        }
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public void close() {
        Discovery.DefaultImpls.close(this);
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public void discover(Discovery.Listener<Gateway.Dirigera> listener) {
        listener.getClass();
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(listener, null), 3, null);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void startDiscovery(final DiscoveryCallback listener) {
        listener.getClass();
        this.nsdManager.discoverServices(this.SERVICE_TYPE, 1, new NsdManager.DiscoveryListener() { // from class: com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery.startDiscovery.1
            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onDiscoveryStarted(String regType) {
                regType.getClass();
                Log.d("Dirigera", "Discovery started");
                listener.started();
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onDiscoveryStopped(String regType) {
                regType.getClass();
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onServiceFound(NsdServiceInfo service) {
                service.getClass();
                Log.d("Dirigera", "Service found: " + service.getServiceName());
                NsdManager nsdManager = this.nsdManager;
                final DirigeraDiscovery dirigeraDiscovery = this;
                final DiscoveryCallback discoveryCallback = listener;
                nsdManager.resolveService(service, new NsdManager.ResolveListener() { // from class: com.urbandroid.smartlight.ikea.dirigera.DirigeraDiscovery$startDiscovery$1$onServiceFound$1
                    @Override // android.net.nsd.NsdManager.ResolveListener
                    public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
                        serviceInfo.getClass();
                        Log.e("Dirigera", "Resolve failed: " + errorCode);
                    }

                    @Override // android.net.nsd.NsdManager.ResolveListener
                    public void onServiceResolved(NsdServiceInfo serviceInfo) throws NoSuchAlgorithmException {
                        serviceInfo.getClass();
                        String hostAddress = serviceInfo.getHost().getHostAddress();
                        Log.d("Dirigera", "Resolved IP: " + hostAddress);
                        if (hostAddress != null) {
                            DirigeraSharedPreferences.getInstance(dirigeraDiscovery.getContext()).setIp(hostAddress);
                            dirigeraDiscovery.stopDiscovery();
                            DirigeraDiscovery dirigeraDiscovery2 = dirigeraDiscovery;
                            BuildersKt__Builders_commonKt.launch$default(dirigeraDiscovery, null, null, new DirigeraDiscovery$startDiscovery$1$onServiceFound$1$onServiceResolved$1(discoveryCallback, serviceInfo, hostAddress, dirigeraDiscovery2.generateCodeChallenge(dirigeraDiscovery2.generateCodeVerifier()), null), 3, null);
                            discoveryCallback.finished();
                        }
                    }
                });
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onServiceLost(NsdServiceInfo service) {
                service.getClass();
                Log.d("Dirigera", "Service lost");
                listener.failed("Service lost");
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onStartDiscoveryFailed(String serviceType, int errorCode) {
                serviceType.getClass();
                this.nsdManager.stopServiceDiscovery(this);
                listener.failed("Failed start " + serviceType + " code " + errorCode);
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onStopDiscoveryFailed(String serviceType, int errorCode) {
                serviceType.getClass();
                this.nsdManager.stopServiceDiscovery(this);
                listener.failed("Failed stop " + serviceType + " code " + errorCode);
            }
        });
    }

    public final void stopDiscovery() {
        try {
            this.nsdManager.stopServiceDiscovery(this.discoveryListener);
        } catch (Exception unused) {
        }
    }

    @Override // com.urbandroid.smartlight.common.discovery.Discovery
    public /* bridge */ /* synthetic */ void authenticate(Gateway gateway, Discovery.AuthListener authListener) {
        authenticate((Gateway.Dirigera) gateway, (Discovery.AuthListener<Gateway.Dirigera>) authListener);
    }
}
