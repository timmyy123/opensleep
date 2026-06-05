package com.urbandroid.smartlight.ikea.tradfri;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.WifiManager;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.ikea.tradfri.Tradfri;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0016\u001a\u00020\u0017*\b\u0018\u00010\u0011R\u00020\u0012H\u0002J\u0012\u0010\u0018\u001a\u00020\u0017*\b\u0018\u00010\u0011R\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u0006\u0010$\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0015R\u0012\u0010%\u001a\u00020&X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/DiscoveryListener;", "Landroid/net/nsd/NsdManager$DiscoveryListener;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "callback", "Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$DiscoveryCallback;", IntrospectionHelper.AppFunctionEntryPointAnnotation.PROPERTY_SERVICE_NAME, "", "ip", "<init>", "(Landroid/content/Context;Lcom/urbandroid/smartlight/ikea/tradfri/Tradfri$DiscoveryCallback;Ljava/lang/String;Ljava/lang/String;)V", "tag", "getTag", "()Ljava/lang/String;", "multicastLock", "Landroid/net/wifi/WifiManager$MulticastLock;", "Landroid/net/wifi/WifiManager;", "isFinished", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "releaseAndLog", "", "acquireAndLog", "onStartDiscoveryFailed", "serviceType", "errorCode", "", "onStopDiscoveryFailed", "onDiscoveryStarted", "onDiscoveryStopped", "onServiceFound", "serviceInfo", "Landroid/net/nsd/NsdServiceInfo;", "onServiceLost", "close", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DiscoveryListener implements NsdManager.DiscoveryListener, FeatureLogger, CoroutineScope {
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final Tradfri.DiscoveryCallback callback;
    private final Context context;
    private final String ip;
    private final AtomicBoolean isFinished;
    private final WifiManager.MulticastLock multicastLock;
    private final String serviceName;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.DiscoveryListener$onDiscoveryStarted$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.DiscoveryListener$onDiscoveryStarted$1", f = "discovery.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DiscoveryListener.this.new AnonymousClass1(continuation);
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
            DiscoveryListener.this.callback.started();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.DiscoveryListener$onDiscoveryStopped$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.DiscoveryListener$onDiscoveryStopped$1", f = "discovery.kt", l = {}, m = "invokeSuspend")
    public static final class C22361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C22361(Continuation<? super C22361> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DiscoveryListener.this.new C22361(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            DiscoveryListener.this.callback.finished();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.smartlight.ikea.tradfri.DiscoveryListener$onServiceFound$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.DiscoveryListener$onServiceFound$1", f = "discovery.kt", l = {108, 111}, m = "invokeSuspend")
    public static final class C22371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NsdServiceInfo $serviceInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22371(NsdServiceInfo nsdServiceInfo, Continuation<? super C22371> continuation) {
            super(2, continuation);
            this.$serviceInfo = nsdServiceInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DiscoveryListener.this.new C22371(this.$serviceInfo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x00cc, code lost:
        
            if (r13.found(r5, r12) == r0) goto L26;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            Tradfri.Gateway gateway = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DiscoveryListener discoveryListener = DiscoveryListener.this;
                String str = "gateway found: " + this.$serviceInfo.getServiceName() + " launch";
                Logger.logInfo(Logger.defaultTag, discoveryListener.getTag() + ": " + ((Object) str), null);
                Context context = DiscoveryListener.this.context;
                String serviceName = this.$serviceInfo.getServiceName();
                serviceName.getClass();
                this.label = 1;
                obj = DiscoveryKt.resolveGatewayOrNull(context, serviceName, this);
                if (obj != coroutine_suspended) {
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
            ResultKt.throwOnFailure(obj);
            Tradfri.Gateway gateway2 = (Tradfri.Gateway) obj;
            String str2 = Logger.defaultTag;
            Logger.logInfo(str2, DiscoveryListener.this.getTag() + ": " + ((Object) ("gateway service " + gateway2)), null);
            if (gateway2 == null) {
                String str3 = DiscoveryListener.this.ip;
                if (str3 != null) {
                    String str4 = DiscoveryListener.this.serviceName;
                    if (str4 == null) {
                        str4 = "";
                    }
                    gateway = new Tradfri.Gateway(str4, str3, 0, 4, null);
                }
            } else {
                gateway = gateway2;
            }
            Tradfri.DiscoveryCallback discoveryCallback = DiscoveryListener.this.callback;
            if (gateway != null) {
                this.label = 2;
            } else {
                discoveryCallback.failed("resolved gateway null - ip = " + DiscoveryListener.this.ip);
            }
            return Unit.INSTANCE;
        }
    }

    public DiscoveryListener(Context context, Tradfri.DiscoveryCallback discoveryCallback, String str, String str2) {
        context.getClass();
        discoveryCallback.getClass();
        this.$$delegate_0 = CoroutineScopeKt.MainScope();
        this.context = context;
        this.callback = discoveryCallback;
        this.serviceName = str;
        this.ip = str2;
        this.tag = DiscoveryKt.TAG_DISCOVERY;
        this.isFinished = new AtomicBoolean(false);
        boolean z = ContextCompat.checkSelfPermission(context, "android.permission.CHANGE_WIFI_MULTICAST_STATE") == 0;
        WifiManager.MulticastLock multicastLockCreateMulticastLock = null;
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + ((Object) ("hasMutlicastPermission: " + z)), null);
        if (z) {
            Object systemService = context.getApplicationContext().getSystemService("wifi");
            systemService.getClass();
            multicastLockCreateMulticastLock = ((WifiManager) systemService).createMulticastLock("multicastLock");
            multicastLockCreateMulticastLock.setReferenceCounted(true);
        } else {
            Logger.logWarning(Logger.defaultTag, getTag() + ": CHANGE_WIFI_MULTICAST_STATE not granted", null);
        }
        this.multicastLock = multicastLockCreateMulticastLock;
    }

    private final void acquireAndLog(WifiManager.MulticastLock multicastLock) {
        if (multicastLock == null || multicastLock.isHeld()) {
            return;
        }
        try {
            multicastLock.acquire();
            Logger.logInfo(Logger.defaultTag, getTag() + ": multicastLock acquired", null);
        } catch (Exception e) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": multicastLock acquire failure", e);
        }
    }

    private final void releaseAndLog(WifiManager.MulticastLock multicastLock) {
        if (multicastLock == null || !multicastLock.isHeld()) {
            return;
        }
        try {
            multicastLock.release();
            Logger.logInfo(Logger.defaultTag, getTag() + ": multicastLock released", null);
        } catch (Exception e) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": fail to release multicastLock", e);
        }
    }

    public final void close() {
        releaseAndLog(this.multicastLock);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: isFinished, reason: from getter */
    public final AtomicBoolean getIsFinished() {
        return this.isFinished;
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onDiscoveryStarted(String serviceType) {
        serviceType.getClass();
        Logger.logInfo(Logger.defaultTag, getTag() + ": started", null);
        acquireAndLog(this.multicastLock);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onDiscoveryStopped(String serviceType) {
        serviceType.getClass();
        releaseAndLog(this.multicastLock);
        Logger.logInfo(Logger.defaultTag, getTag() + ": stopped", null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C22361(null), 3, null);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onServiceFound(NsdServiceInfo serviceInfo) {
        serviceInfo.getClass();
        String str = "gateway found: " + serviceInfo.getServiceName();
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + ((Object) str), null);
        if (this.serviceName == null || Intrinsics.areEqual(serviceInfo.getServiceName(), this.serviceName)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new C22371(serviceInfo, null), 3, null);
            if (this.serviceName != null) {
                this.isFinished.set(true);
                return;
            }
            return;
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": gateway service name wrong", null);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onServiceLost(NsdServiceInfo serviceInfo) {
        serviceInfo.getClass();
        String str = Logger.defaultTag;
        Logger.logWarning(str, getTag() + ": " + ((Object) ("service lost " + serviceInfo)), null);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onStartDiscoveryFailed(String serviceType, int errorCode) {
        serviceType.getClass();
        releaseAndLog(this.multicastLock);
        String strM = FileInsert$$ExternalSyntheticOutline0.m(errorCode, "failed: ");
        Logger.logWarning(Logger.defaultTag, getTag() + ": " + ((Object) strM), null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new DiscoveryListener$onStartDiscoveryFailed$1$1(this, strM, null), 3, null);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onStopDiscoveryFailed(String serviceType, int errorCode) {
        serviceType.getClass();
        releaseAndLog(this.multicastLock);
        Logger.logInfo(Logger.defaultTag, getTag() + ": stop failed", null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new DiscoveryListener$onStopDiscoveryFailed$1$1(this, "stop failed", null), 3, null);
    }

    public /* synthetic */ DiscoveryListener(Context context, Tradfri.DiscoveryCallback discoveryCallback, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, discoveryCallback, (i & 4) != 0 ? null : str, str2);
    }
}
